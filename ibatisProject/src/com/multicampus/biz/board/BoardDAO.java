package com.multicampus.biz.board;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ibatis.sqlmap.client.SqlMapClient;

public class BoardDAO {
	@Autowired
	private SqlMapClient ibatis;
	
	public SqlMapClient getIbatis() {
		return ibatis;
	}

	public void setIbatis(SqlMapClient ibatis) {
		this.ibatis = ibatis;
	}

	public void insertBoard(BoardVO vo) throws SQLException{		
		ibatis.insert("insertBoard", vo);
	}	
	
	public void updateBoard(BoardVO vo) throws SQLException{		
		ibatis.update("updateBoard", vo);
	}	
	
	public void deleteBoard(BoardVO vo) throws SQLException{		
		ibatis.delete("deleteBoard", vo);
	}	
	
	public BoardVO getBoard(BoardVO vo) throws SQLException{		
		return (BoardVO)ibatis.queryForObject("getBoard", vo);
	}	
	
	@SuppressWarnings("unchecked")
	public List<BoardVO> getBoardList(BoardVO vo) throws SQLException{		
		return (List<BoardVO>)(ibatis.queryForList("getBoardList", vo));
	}
}
















