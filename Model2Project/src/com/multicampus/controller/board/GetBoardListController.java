package com.multicampus.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardVO;
import com.multicampus.controller.Controller;

public class GetBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. ����� �Է����� ����(�˻��� ���߿� ����)
		HttpSession session = request.getSession();
		if(session.getAttribute("boardList") == null){
			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			session.setAttribute("boardList", boardList);
		}		
		
		// 3. �˻������ ���ǿ� �����ϰ� jspȭ�� ������ �����Ѵ�.
		return "getBoardList.jsp";

	}

}
