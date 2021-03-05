package com.spring.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;

//@Service : @Component 상속 확장된 어노테이션
//		비지니스 로직 처리(업무 처리) 서비스 영역에 사용
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired	// 타입이 일치하는 객체 (인스턴스) 주입
	private BoardDAO boardDAO;

	public BoardServiceImpl() {
		System.out.println(">> BoardServiceImpl() 객체생성");
	}
	
	@Override
	public void insertBoard(BoardVO vo) {
		System.out.println(">>BoardServiceImpl.insertBoard()시작~");
		// 의도적으로 예외 발생 시키기
//		if(vo.getSeq() == 0) {
//			throw new IllegalArgumentException("0번 글은 입력할 수 없습니다.");
//		}
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {
		return boardDAO.getBoardList();
	}
}
