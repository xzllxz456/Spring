package com.spring.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;
import com.spring.biz.common.Log4jAdvice;
import com.spring.biz.common.LogAdvice;

//@Service : @Component 상속 확장된 어노테이션
//		비지니스 로직 처리(업무 처리) 서비스 영역에 사용
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired	// 타입이 일치하는 객체 (인스턴스) 주입
	private BoardDAO boardDAO;
	//private LogAdvice log;
	private Log4jAdvice log4j;
	
	// 모든 메소드가 joinpoint
	public BoardServiceImpl() {
		System.out.println(">> BoardServiceImpl() 객체생성");
		//log = new LogAdvice();
		log4j = new Log4jAdvice();
	}
	
	@Override
	public void insertBoard(BoardVO vo) {
		// log.printLog();
		log4j.printLoggin();
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		// log.printLog();
		log4j.printLoggin();
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		// log.printLog();
		log4j.printLoggin();
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		// log.printLog();
		log4j.printLoggin();
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {
		// log.printLog();
		log4j.printLoggin();
		return boardDAO.getBoardList();
	}
}
