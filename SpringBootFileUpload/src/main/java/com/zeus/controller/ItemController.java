package com.zeus.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zeus.domain.Item;
import com.zeus.service.ItemService;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/item")
@MapperScan(basePackages = "com.zeus.mapper")
public class ItemController
{
	@Autowired
	private ItemService itemService;
	
	@Value("${upload.path}")
	private String uploadPath;

	// 이미지 게시판 리스트 요청. (/WEB-INF/views/item/list.jsp)
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception
	{
		List <Item> itemList = this.itemService.list();
		
		model.addAttribute("itemList", itemList);
	}

	// 이미지 게시판 등록 화면 요청.(GET이니까.) (/WEB-INF/views/item/register.jsp)
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm(Model model)
	{
		model.addAttribute(new Item());
		
		return "item/register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Item item, Model model) throws Exception
	{
	    MultipartFile file = item.getPicture();
	    
	    if (file != null && file.getSize() > 0)
	    {
	        String createdFileName = itemService.uploadFile(file.getOriginalFilename(), file.getBytes(), null);
	        item.setPictureUrl(createdFileName);
	    }
	    
	    this.itemService.regist(item);
	    
	    model.addAttribute("msg", "등록이 완료되었습니다.");
	    
	    return "item/success";
	}

	// 이미지 게시판에 등록된 내용을 수정. (/WEB-INF/views/item/modify.jsp)
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyForm(Integer itemId, Model model) throws Exception
	{
		Item item = this.itemService.read(itemId);
		
		model.addAttribute(item);
		
		return "item/modify";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(Item item, Model model) throws Exception
	{
	    // 이미지는 ItemService의 modify 메소드에서 처리됩니다.
	    this.itemService.modify(item);

	    // 수정 후 item 객체를 model에 추가하여 뷰에서 새로운 이미지 URL을 사용하도록 함.
	    model.addAttribute("item", item);

	    model.addAttribute("msg", "수정이 완료되었습니다.");

	    return "item/success";
	}

	// 이미지 게시판 제거 화면 요청. (DB & 파일) (/WEB-INF/views/item/remove.jsp)
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String removeForm(Integer itemId, Model model) throws Exception
	{
		Item item = this.itemService.read(itemId);
		
		model.addAttribute(item);
		
		return "item/remove";
	}

	// 이미지 게시판 제거 내용을 DB에 저장 요청. (DB & 파일) (/WEB-INF/views/item/success.jsp)
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(Item item, Model model) throws Exception
	{
		this.itemService.remove(item.getItemId());
		
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		
		return "item/success";
	}

	// 브라우저에서 <img src="/item/display/2" /> 2번 이미지 게시판에서 호출하여 redponseBody를 통해 화면에 출력.
	@ResponseBody
	@RequestMapping("/display")
	public ResponseEntity <byte[]> displayFile(Integer itemId) throws Exception
	{
		InputStream in = null;
		
		ResponseEntity<byte[]> entity = null;
		
		String fileName = itemService.getPicture(itemId);
		
		log.info("FILE NAME: " + fileName);
		
		try
		{
			// 4cd18230-d5e8-42e8-ae2e-a4104a6b5e29_T멤버십으로 30% 할인.jpg => "jpg"
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
			
			// "jpg" -> MidiaType.IMAGE_JPG
			MediaType mType = getMediaType(formatName);
			
			// 웹 브라우저에 반환할 헤더 생성.
			HttpHeaders headers = new HttpHeaders();
			
			// C://upload//4cd18230-d5e8-42e8-ae2e-a4104a6b5e29_T멤버십으로 30% 할인.jpg -> inputStream in으로 읽음.
			in = new FileInputStream(uploadPath + File.separator + fileName);
			
			if (mType != null)
			{
				// MidiaType.IMAGE_JPG 헤더에 추가.
				headers.setContentType(mType);
			}
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			
		} catch (Exception e)
		{
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally
		{
			in.close();
		}
		
		return entity;
	}

	// 확장자에 따라서 미디어타입을 브라우저에 설정해주는 함수.
	private MediaType getMediaType(String formatName)
	{
		if (formatName != null)
		{
			if (formatName.equals("JPG"))
			{
				return MediaType.IMAGE_JPEG;
			}
			
			if (formatName.equals("GIF"))
			{
				return MediaType.IMAGE_GIF;
			}
			
			if (formatName.equals("PNG"))
			{
				return MediaType.IMAGE_PNG;
			}
		}
		
		return null;
	}
}