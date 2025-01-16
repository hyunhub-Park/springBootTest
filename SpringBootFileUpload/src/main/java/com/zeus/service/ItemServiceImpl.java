package com.zeus.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.zeus.domain.Item;
import com.zeus.mapper.ItemMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService
{

	@Autowired
	private ItemMapper mapper;
	
	/* 업로드 파일 경로. */
	@Value("${upload.path}")
	private String uploadPath;
	
	@Override
	public void regist(Item item) throws Exception
	{
		mapper.create(item);
	}
	
	@Override
	public Item read(Integer itemId) throws Exception
	{
		return mapper.read(itemId);
	}
	
	@Override
	public void modify(Item item) throws Exception
	{
	    // 기존 이미지 URL을 가져옴.
	    String existingPictureUrl = mapper.getPicture(item.getItemId());

	    MultipartFile file = item.getPicture();

	    // 게시글 수정 시, 이미지 파일을 새로 첨부할 경우.
	    if (file != null && file.getSize() > 0)
	    {
	        // 기존 이미지가 있을 시 삭제.
	        if (existingPictureUrl != null && !existingPictureUrl.isEmpty())
	        {
	            deleteFile(existingPictureUrl);
	        }

	        // 새 이미지 파일을 저장 및 URL 설정.
	        String createdFileName = uploadFile(file.getOriginalFilename(), file.getBytes(), existingPictureUrl);
	        item.setPictureUrl(createdFileName);
	    } else
	    {
	        // 이미지 파일을 새로 첨부하지 않을 경우, 기존 이미지 URL을 그대로 유지.
	        item.setPictureUrl(existingPictureUrl);
	    }

	    // 수정된 내용 DB에 반영
	    mapper.update(item);
	}

	@Override
	public void remove(Integer itemId) throws Exception
	{
		/* 게시글에 연결된 이미지 삭제. */
		String pictureUrl = mapper.getPicture(itemId);

	    if (pictureUrl != null && !pictureUrl.isEmpty())
	    {
	        // 연결된 이미지 파일 삭제
	        deleteFile(pictureUrl);
	    }

	    // 해당 상품 삭제
	    mapper.delete(itemId);
	}

	@Override
	public List <Item> list() throws Exception
	{
		return mapper.list();
	}

	@Override
	public String getPicture(Integer itemId) throws Exception
	{
		return mapper.getPicture(itemId);
	}
	
	/* 해당하는 경로의 파일을 삭제. */
	private void deleteFile(String fileName)
	{
//		if (fileName != null && !fileName.isEmpty())
//		{
//	        File file = new File(uploadPath, fileName);
//	        
//	        if (file.exists())
//	        {
//	            file.delete(); // 이미지 파일 삭제
//	        }
//	    }
		
		 if (fileName != null && !fileName.isEmpty())
		    {
		        // uploadPath는 외부 설정파일로부터 주입되며, 실제 경로는 파일명과 합쳐져야 합니다.
		        File file = new File(uploadPath, fileName);
		        
		        if (file.exists())
		        {
		            boolean deleted = file.delete(); // 이미지 파일 삭제
		            if (deleted) {
		                log.info("Successfully deleted file: " + fileName);
		            } else {
		                log.warn("Failed to delete file: " + fileName);
		            }
		        }
		    }
	}
	
	@Override
	public String uploadFile(String originalName, byte[] fileData, String existingFileName) throws Exception
	{
	    // 기존 파일 존재 시 삭제.
	    if (existingFileName != null && !existingFileName.isEmpty())
	    {
	        deleteFile(existingFileName);
	    }
	    
	    // 새로운 파일 생성.
	    UUID uid = UUID.randomUUID();
	    String createdFileName = uid.toString() + "_" + originalName;
	    
	    File target = new File(uploadPath, createdFileName);
	    
	    FileCopyUtils.copy(fileData, target);
	    
	    return createdFileName;
	}
}