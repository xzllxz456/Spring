package com.spring.biz.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService; // 의존주입 <--BoardServiceImpl
	
	public BoardController() {
		System.out.println("---->BoardController() 객체생성");
		System.out.println("boardService" + boardService); // NULL
	}
	//메소드에 선언된 @ModelAttribute : 리턴된 데이터를 VIEW 에 전달
	//@ModelAttribute 선언된 메소드는 @RequestMapping 메소드보다 먼저 실행
	//뷰에 전달될 떄 설정된 명칭(예 : conditionMap)으로 전달
	@ModelAttribute("conditionMap")
	public Map<String , String> searchConditionMap() {
		System.out.println("----> @ModelAttribute - searchConditionMap() ");
		//key : 제목, value : TITLE 
		//key : 내용, value : CONTENT 
		Map<String, String> conditionMap = new HashMap<>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
		
	}
	//리턴타입 MedelAndView -> String
	//전달하는데이터 타입 ModelAndView -> Medel
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		BoardVO board = boardService.getBoard(vo);
		model.addAttribute("board", board);
		return "getBoard.jsp";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo,Model model) {
		System.out.println(">>> 게시글 전체 목록 보여주기 - getBoardList()");
		
		// 검색 조건 값이 없을 때 기본값 설정
		if(vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		if(vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		List<BoardVO> boardList = boardService.getBoardList(vo);
		model.addAttribute("boardList", boardList); //뷰에서 사용할 데이터 저장
		return "getBoardList.jsp";
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		System.out.println(">>> 게시글 입력처리 - insertBoard()");
		System.out.println("vo : " + vo);
		/*
		 	파일 업로드 관련 처리
		 	MultipartFile 인터페이스 주요 메소드 
		 	String getOriginalFilename() : 업로드할 파일명 찾기
		 	transferTo(File) : 업로드할 파일을 업로드 처리
		 	boolean isEmpty() : 업로드할 파일의 존재 여부 (없으면 true)
		*/
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {	// 파일이 있으면
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("c:/Mystudy/temp/" + fileName));
		
		}
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/updateBoard.do")
	// 인수(파라미터)에 설정한@ModelAttribute("board") : 속성명 board 가 있으면 사용
	// 없으면 새로 만들어서 적용
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("ㅣ>>> 글수정 - updateBoard()");
		System.out.println("> board : " + vo);
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	//Ajax 요청을 받고 JSON 배열 데이터 리턴
	@RequestMapping("/ajaxGetBoardList.do")
	@ResponseBody
	public List<BoardVO> ajaxGetBoardList(BoardVO vo) {
		List<BoardVO> boardList = boardService.getBoardList(vo);
		System.out.println("boardList : " + boardList);
		return boardList;
	}
}
