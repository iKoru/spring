package com.multicampus.biz.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// 2. DAO(Data Access Object) Ŭ����
@Repository("boardDAOMybatis")
public class BoardDAOMybatis {
	@Autowired
	private SqlSessionTemplate myBatis;

	// CRUD ���� �޼ҵ� 
	// �� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis ������� insertBoard() ��� ó��");
		myBatis.insert("boardDAO.insertBoard", vo);
	}

	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis ������� updateBoard() ��� ó��");
		myBatis.update("boardDAO.updateBoard", vo);
	}

	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Mybatis ������� deleteBoard() ��� ó��");
		myBatis.delete("boardDAO.deleteBoard", vo);
	}

	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis ������� getBoard() ��� ó��");
		return (BoardVO) (myBatis.selectOne("boardDAO.getBoard", vo));
	}

	// �� ��� �˻�
	@SuppressWarnings("unchecked")
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Mybatis ������� getBoardList() ��� ó��");
		return (List<BoardVO>) myBatis.selectList("boardDAO.getBoardList", vo);
	}
}






