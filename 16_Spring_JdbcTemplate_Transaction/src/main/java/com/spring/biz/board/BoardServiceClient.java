package com.spring.biz.board;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. 스프링 컨테이너 구동
		GenericXmlApplicationContext container
			= new GenericXmlApplicationContext("applicationContext.xml");
		
		System.out.println("=== 컨체이너 구동 후 ===");
		// 2. 스프링 컨테이너 사용
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		// 데이터 입력
		BoardVO vo = new BoardVO();
		vo.setSeq(100);
		vo.setTitle("tx테스트-Spring");
		vo.setWriter("tx테스터-S");
		vo.setContent("tx테스트중-Spring");
		
		boardService.insertBoard(vo);
		
		vo.setSeq(2);
		// 데이터 수정
		vo.setTitle("dddd");
		boardService.updateBoard(vo);
		
		// 데이터 삭제
		//boardService.deleteBoard(vo);
		
		//한개 가져오기
		vo.setSeq(3);
		boardService.getBoard(vo);
		// 전체 데이터 조회
		List<BoardVO> list = boardService.getBoardList();
		for (BoardVO board : list) {
			System.out.println(board);
		}
		
		
		// 3. 스프링 컨테이너 종료
		container.close();
	}
}
