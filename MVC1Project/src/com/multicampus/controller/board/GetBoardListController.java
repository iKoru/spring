package com.multicampus.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		// 3. �˻� ����� View �̸��� ModelAndView�� �����Ͽ� �����Ѵ�.
		// ModelAndView�� ����� �����ʹ� �ڵ����� request ���尴ü�� ��ϵȴ�.
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList); // Model ���� ����
		mav.setViewName("getBoardList");   // View  ���� ����
		return mav;
	}

}











