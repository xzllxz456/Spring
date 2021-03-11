package com.spring.biz.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;


@Controller
public class UpdateBoardController {

	@RequestMapping("updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	/*
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>> 게시글 수정처리");
		//1. 전달받은 파라미터 값 추출(확인)
		//request.setCharacterEncoding("UTF-8");
		String seq = request.getParameter("seq");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		//2. 업무처리 - DB 연동작업(게시글 수정)
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.updateBoard(vo);
		
		//3. 화면 네비게이션(목록 페이지로) : 데이터 다시 읽어오기
		//response.sendRedirect("getBoardList.do");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList.do");
		return mav;
	}
*/
}
