package com.zeus.controller;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.zeus.domain.Board;
import com.zeus.service.BoardService;
import lombok.extern.java.Log;


@Log
@Controller
@RequestMapping("/board")
@MapperScan(basePackages = "com.zeus.mapper")
public class BoardController {
	@Autowired
	private BoardService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerForm(Board board, Model model) throws Exception {
		log.info("registerForm");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Board board, Model model) throws Exception {
		service.register(board);
		model.addAttribute("msg", "등록이 완료되었습니다.");
		return "board/success";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		log.info("list");
		model.addAttribute("list", service.list());
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
		model.addAttribute(service.read(boardNo));
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
		service.remove(boardNo);
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		return "board/success";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyForm(int boardNo, Model model) throws Exception {
		model.addAttribute(service.read(boardNo));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(Board board, Model model) throws Exception {
		service.modify(board);
		model.addAttribute("msg", "수정이 완료되었습니다.");
		return "board/success";
	}
}






//package com.zeus.controller;
//
//import org.mybatis.spring.annotation.MapperScan; import
//org.springframework.beans.factory.annotation.Autowired; import
//org.springframework.stereotype.Controller; import
//org.springframework.ui.Model; import
//org.springframework.web.bind.annotation.RequestMapping; import
//org.springframework.web.bind.annotation.RequestMethod; import
//org.springframework.web.bind.annotation.RequestParam;
// 
//import com.zeus.domain.Board; import com.zeus.service.BoardService;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//
//@Controller
//
//@RequestMapping("/board")
//
//@MapperScan(basePackages = "com.zeus.mapper") public class BoardController {
//@Autowired // 서비스를 이용해 DB접근. private BoardService service;
//
//// 게시판 입력 폼 요청. (/WEB-INF/views/board/register.jsp)
// 
//@RequestMapping(value = "/register", method = RequestMethod.GET) public void
//registerForm(Board board, Model model) throws Exception {
//log.info("registerForm"); }
// 
//// 게시판 입력 내용 저장(등록) 후, 성공메세지를 반환(/WEB-INF/views/board/success.jdp)
//
//@RequestMapping(value = "/register", method = RequestMethod.POST) public
//String register(Board board, Model model) throws Exception {
//service.register(board);
//
//model.addAttribute("msg", "등록이 완료되었습니다.");
//
//return "board/success"; }
//
//// 게시판 전체 리스트를 요청. -> 젠체 리스트 가져온후, -> (/WEB-INF/views/board/list.jsp)화면에 전달.
//@RequestMapping(value = "/list", method = RequestMethod.GET) public void
//list(Model model) throws Exception { log.info("list");
//
//model.addAttribute("list", service.list()); }
// 
//// 게시글 상세내용 요청 -> 게시글 한 개를 가져와, -> (/WEB-INF/views/board/read.jsp)화면에 전달(모델로.
//Model은 request에 들어가 있음.).
//
//@RequestMapping(value = "/read", method = RequestMethod.GET) public void
//read(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
//model.addAttribute(service.read(boardNo)); }
// 
//// 게시글 삭제 요청 -> 삭제 진행 후, -> (/WEB-INF/views/board/success.jsp)화면에 전달(모델로.
//Model은 request에 들어가 있음.).
//
//@RequestMapping(value = "/remove", method = RequestMethod.POST) public String
//remove(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
//service.remove(boardNo);
//
//model.addAttribute("msg", "삭제가 완료되었습니다.");
//
// return "board/success"; }
//
//// 게시글 수정을 위한 '화면'요청 -> 해당 게시글을 가져온 후, ->
//(/WEB-INF/views/board/modify.jsp)화면에 전달.
//
//@RequestMapping(value = "/modify", method = RequestMethod.GET) public void
//modifyForm(int boardNo, Model model) throws Exception {
//model.addAttribute(service.read(boardNo)); }
//
//// 수정된 게시글 내용을 DB에 저장 요청 -> 수정 완료. -> 결과 화면에 성공메세지 출력.
//(/WEB-INF/views/board/success.jsp)
//
//@RequestMapping(value = "/modify", method = RequestMethod.POST) public String
//modify(Board board, Model model) throws Exception { service.modify(board);
//
//model.addAttribute("msg", "수정이 완료되었습니다.");
//
//return "board/success"; } }
