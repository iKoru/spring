package com.multicampus.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardVO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. ����� �Է����� ����
		String seq = request.getParameter("seq");
		
		// 2. DB ���� ó��
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		// 3. �˻� ����� ���ǿ� �����ϰ� JSP ȭ�� ������ �����Ѵ�.
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("getBoard.jsp");
		return mv;
	}

}








