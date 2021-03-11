package com.spring.biz.view.board;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController{
	
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardDAO boardDAO, ModelAndView mav) {
		System.out.println(">>> 게시글 전체 목록 보여주기 - getBoardList()");
		List<BoardVO> boardList = boardDAO.getBoardList();
		mav.addObject("boardList", boardList); //뷰에서 사용할 데이터 저장
		mav.setViewName("getBoardList.jsp");	// 뷰리졸버 사용 안함
		return mav;
	}

/*	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>> 게시글 전체 목록 보여주기");
		//1. 게시글 목록 조회(SELECT)
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList();
		
		//2. 검색결과를 세션에 저장
		//request.getSession().setAttribute("boardList", boardList);
		
		//3. ModelAndView 형식으로 데이터 저장 및 뷰 이름 저장
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList); //뷰에서 사용할 데이터 저장
		mav.setViewName("getBoardList.jsp");	// 뷰리졸버 사용 안함
		
		return mav;
	}*/

}







