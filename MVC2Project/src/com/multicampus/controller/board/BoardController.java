package com.multicampus.controller.board;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.multicampus.biz.board.BoardListVO;
import com.multicampus.biz.board.BoardService;
import com.multicampus.biz.board.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	@Resource(name="xmlView")
	private View xmlView;
	@Resource(name="jsonView")
	private View jsonView;
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		// 파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String file = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/" + file));
		}
		
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo) {
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model){
		model.addAttribute("board", boardService.getBoard(vo)); // Model 정보 저장
		return "getBoard.jsp";   // View 이름 리턴
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		model.addAttribute("boardList", boardService.getBoardList(vo)); // Model 정보 저장
		return "getBoardList.jsp";   // View 이름 리턴
	}

	
	@RequestMapping("/transform.do")
	public ModelAndView transform(@RequestParam String format, BoardVO vo, BoardListVO listvo){
		List<BoardVO> boardList = boardService.getBoardList(vo);
		listvo.setBoardList(boardList);
		ModelAndView mv = new ModelAndView();
		mv.addObject(listvo);
		if("xml".equalsIgnoreCase(format)){
			mv.setView(xmlView);
		}else{
			mv.setView(jsonView);
		}
		return mv;
	}
}








