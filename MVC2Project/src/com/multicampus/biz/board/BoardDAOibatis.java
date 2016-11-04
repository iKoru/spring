package com.multicampus.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

// 2. DAO(Data Access Object) Ŭ����
@Repository("boardDAOibatis")
public class BoardDAOibatis {
	@Autowired
	private SqlMapClientTemplate ibatis;

	// CRUD ���� �޼ҵ� 
	// �� ���
	public void insertBoard(BoardVO vo){
		System.out.println("===> ibatis ������� insertBoard() ��� ó��");
		ibatis.insert("insertBoard", vo);
	}

	// �� ����
	public void updateBoard(BoardVO vo){
		System.out.println("===> ibatis ������� updateBoard() ��� ó��");
		ibatis.update("updateBoard", vo);
	}

	// �� ����
	public void deleteBoard(BoardVO vo){
		System.out.println("===> ibatis ������� deleteBoard() ��� ó��");
		ibatis.delete("deleteBoard", vo);
	}

	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo){
		System.out.println("===> ibatis ������� getBoard() ��� ó��");
		return (BoardVO)(ibatis.queryForObject("getBoard", vo));
	}

	// �� ��� �˻�
	@SuppressWarnings("unchecked")
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("===> ibatis ������� getBoardList() ��� ó��");
		return (List<BoardVO>)(ibatis.queryForList("getBoardList", vo));
	}
}






