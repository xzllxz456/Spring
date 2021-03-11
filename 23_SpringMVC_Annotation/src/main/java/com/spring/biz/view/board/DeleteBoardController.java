package com.spring.biz.view.board;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class DeleteBoardController {
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	/*
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>> 게시글 삭제처리");
		//1. 전달받은 파라미터 값 추출(확인)
		//request.setCharacterEncoding("UTF-8");
		String seq = request.getParameter("seq");
		
		//2. 업무처리 - DB 연동작업(게시글 삭제)
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(vo);
		
		//3. 화면 네비게이션(목록 페이지로) : 데이터 다시 읽어오기
		//response.sendRedirect("getBoardList.do");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList.do");
		return mav;
	}
*/
}
