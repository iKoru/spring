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
		// 1. 사용자 입력정보 추출(검색은 나중에 구현)
		HttpSession session = request.getSession();
		if(session.getAttribute("boardList") == null){
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			session.setAttribute("boardList", boardList);
		}		
		
		// 3. 검색결과를 세션에 저장하고 jsp화면 정보를 리턴한다.
		return "getBoardList.jsp";

	}

}
