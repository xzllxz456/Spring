package com.spring.biz.board.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;

// spring-jdbc의 JdbcDaoSupport 상속 확장 방식으로 구현
@Repository("boardDAOSpring")
public class BoardDAOSpring extends JdbcDaoSupport {
	
	// SQL 문 
	private final String BOARD_INSERT = 
			"INSERT INTO BOARD (SEQ, TITLE, WRITER, CONTENT) "
			+ " VALUES ((SELECT NVL(MAX(SEQ),0) + 1 FROM BOARD), ?, ?, ?) ";
	
	private final String BOARD_UPDATE = 
			"UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ?";
	
	private final String BOARD_DELETE = 
			"DELETE FROM BOARD WHERE SEQ = ?";
	
	private final String BOARD_GET = 
			"SELECT * FROM BOARD WHERE SEQ = ?";
	
	private final String BOARD_LIST = 
			"SELECT * FROM BOARD ORDER BY SEQ DESC";
	
	// JdbcDaoSupport에 DataSource 객체(인스턴스) 전달
	@Autowired // 파라미터 타입과 동일한 객체 주입하면서 메소드 실행
	public void setSuperDataSource(DataSource dataSource) {
		System.out.println(">>>> BoardDAOSpring.setSuperDataSource() 실행 ");
		System.out.println(">>>> dataSource : " + dataSource);
		super.setDataSource(dataSource);
	}
	
	public BoardDAOSpring() {
		System.out.println(">>> BoardDAO() 객체 생성");
	}
	
	// 글 입력
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 insertBoard() 실행");
		
		//Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent()};
		//super.getJdbcTemplate().update(BOARD_INSERT, args);
		
		super.getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	//게시글 1개 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring  JDBC로 getBoard() 실행");
		Object[] args = {vo.getSeq()};
		return super.getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
		//return super.getJdbcTemplate().queryForObject(BOARD_GET, BoardVO.class, vo.getSeq());
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring  JDBC로 deleteBoard() 실행");
		super.getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring  JDBC로 updateBoard() 실행");
		super.getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	// 게시글 전체 조회
	public List<BoardVO> getBoardList() {
		System.out.println("===> Spring JDBC로 getBoardList() 실행");
		
		return super.getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
	}
}
