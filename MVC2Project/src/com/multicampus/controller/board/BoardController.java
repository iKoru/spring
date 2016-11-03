package com.multicampus.controller.board;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.multicampus.biz.board.BoardService;
import com.multicampus.biz.board.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		// ���� ���ε� ó��
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
		model.addAttribute("board", boardService.getBoard(vo)); // Model ���� ����
		return "getBoard.jsp";   // View �̸� ����
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		model.addAttribute("boardList", boardService.getBoardList(vo)); // Model ���� ����
		return "getBoardList.jsp";   // View �̸� ����
	}

}








