package com.spring.biz.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;
//@Controller : DispatcherServlet 에서 인식할 수 있는 컨트롤러로 객체 생성
@Controller 
public class LoginController{
	/*  @RequestMapping
	 * @RequestMapping : 요청과 처리(Controller) 연결(HandlerMapping 역할 대체)
	 * command 객체 사용 : (UserVO) 파라미터로 전달되는 값을 Command 객체가 설정 
	 * 스프링 프레임워크에서 객체 생성하고 파라미터 값을 설정해서 전달해줌
	 * 1. UserVO 타입의 객체 생성
	 * 2. UserVO 타입의 객체에 전달받은 파라미터 값을 설정(이름이 일치하는경우)
	 * 3. USERVO 타입의 객체를 메소드의 파라미터(인수) 값으로 전달
	 */
	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println(">>>>로그인 처리 - login()");
		System.out.println(">> 전달받은 vo : " + vo);
		System.out.println(">> 전달받은 uerDAO : " + userDAO);
		
		UserVO user = userDAO.getUser(vo);
		if(user != null) {
			return "getBoardList.do" ;
		} else {
			
		}
		return "login.jsp";
	}
/*
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>> 로그인 처리");
		//1. 사용자 입력 데이터 확인(추출)

		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		//3. 화면 네비게이션(화면이동)
		//로그인 성공 : 게시글 보여주기 - getBoardList.jsp
		//로그인 실패 : 로그인화면으로 이동 - login.jsp 
		ModelAndView mav = new ModelAndView();
		if (user != null) { //사용자 정보가 있는 경우
			System.out.println("> 로그인 성공!!!");
			//response.sendRedirect("getBoardList.do");
			//returnStr = "getBoardList.do";
			mav.setViewName("getBoardList.do");
		} else {
			System.out.println("> 로그인 실패!!!");
			//response.sendRedirect("login.jsp");
			//returnStr = "login";
			mav.setViewName("login.jsp");	// 뷰리졸버 사용 안하는 경우
		}
		
		return mav;
	}
*/
}
