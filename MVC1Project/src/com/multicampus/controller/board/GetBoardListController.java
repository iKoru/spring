package com.multicampus.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardVO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. ����� �Է����� ����(�˻��� ���߿� ����)
		
		
		// 2. DB ���� ó��
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		// 3. �˻� ����� ���ǿ� �����ϰ� JSP ȭ�� ������ �����Ѵ�.
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("getBoardList.jsp");
		return mv;
	}

}




