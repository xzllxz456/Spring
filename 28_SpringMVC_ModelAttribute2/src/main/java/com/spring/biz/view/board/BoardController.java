package com.spring.biz.view.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
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
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		BoardVO board = boardDAO.getBoard(vo);
		model.addAttribute("board", board);
		return "getBoard.jsp";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardDAO boardDAO, BoardVO vo,Model model) {
		System.out.println(">>> 게시글 전체 목록 보여주기 - getBoardList()");
		
		// 검색 조건 값이 없을 때 기본값 설정
		if(vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		if(vo.getSearchKeyword() == null) {
			vo.setSearchCondition("");
		}
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		model.addAttribute("boardList", boardList); //뷰에서 사용할 데이터 저장
		return "getBoardList.jsp";
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 게시글 입력처리 - insertBoard()");
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
}
