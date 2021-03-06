package com.multicampus.biz.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// 2. DAO(Data Access Object) 클래스
@Repository("boardDAOMybatis")
public class BoardDAOMybatis {
	@Autowired
	private SqlSessionTemplate myBatis;

	// CRUD 관련 메소드 
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis 기반으로 insertBoard() 기능 처리");
		myBatis.insert("boardDAO.insertBoard", vo);
	}

	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis 기반으로 updateBoard() 기능 처리");
		myBatis.update("boardDAO.updateBoard", vo);
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Mybatis 기반으로 deleteBoard() 기능 처리");
		myBatis.delete("boardDAO.deleteBoard", vo);
	}

	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis 기반으로 getBoard() 기능 처리");
		return (BoardVO) (myBatis.selectOne("boardDAO.getBoard", vo));
	}

	// 글 목록 검색
	@SuppressWarnings("unchecked")
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Mybatis 기반으로 getBoardList() 기능 처리");
		return (List<BoardVO>) myBatis.selectList("boardDAO.getBoardList", vo);
	}
}






