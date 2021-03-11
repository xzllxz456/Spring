package com.spring.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;

@Repository("boardDAOMybatis")
public class BoardDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public BoardDAOMybatis() {
		System.out.println(">>>객체 BoardDAOMybatis() 생성함");
	}
	
	// 글 입력
	public void insertBoard(BoardVO vo) {
		System.out.println("===> mybatis로 insertBoard() 실행");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}
	
	//게시글 1개 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===>mybatis로 getBoard() 실행");
		return mybatis.selectOne("BoardDAO.getBoard", vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> mybatise로 deleteBoad() 실행");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> mybatis로 updateBoard() 실행");
		mybatis.update("BoardDAO.updateBoard", vo);
	}
	

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> mybatis로 getBoardList() 실행-vo");
		
		//검색조건 값이 없을 때 기본값 설정
		if (vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		if (vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}
	
}
