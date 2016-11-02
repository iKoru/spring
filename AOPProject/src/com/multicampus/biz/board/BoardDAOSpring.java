package com.multicampus.biz.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// 2. DAO(Data Access Object) Ŭ����
@Repository("boardDAOSpring")
public class BoardDAOSpring {
	@Autowired
	private JdbcTemplate spring;

	// SQL ��ɾ��
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values(?,?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET    = "select * from board where seq=?";
	private final String BOARD_LIST   = "select * from board order by seq desc";
	
	// CRUD ���� �޼ҵ� 
	// �� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring ������� insertBoard() ��� ó��");
		spring.update(BOARD_INSERT, vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring ������� updateBoard() ��� ó��");
		Object[] args = {vo.getTitle(), vo.getContent(), vo.getSeq()};
		spring.update(BOARD_UPDATE, args);
	}

	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring ������� deleteBoard() ��� ó��");
		spring.update(BOARD_DELETE, vo.getSeq());
	}

	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring ������� getBoard() ��� ó��");
		Object[] args = {vo.getSeq()};
		return spring.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}

	// �� ��� �˻�
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring ������� getBoardList() ��� ó��");
		return spring.query(BOARD_LIST, new BoardRowMapper());
	}
}

class BoardRowMapper implements RowMapper<BoardVO> {

	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("SEQ"));
		board.setTitle(rs.getString("TITLE"));
		board.setWriter(rs.getString("WRITER"));
		board.setContent(rs.getString("CONTENT"));
		board.setRegDate(rs.getDate("REGDATE"));
		board.setCnt(rs.getInt("CNT"));
		return board;
	}
	
}





