package com.spring.biz.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.spring.biz.user.UserService;
import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;


@Controller
//@EnableWebMvc	// 4.3 버전에서는 추가해야 @GetMapping, @PostMapping 정상동작 
public class UserController {
	
	// UserService 타입 주입받아서 사용 형태로 변경
	
	@Autowired
	private UserService userService;
	
	
	public UserController() {
		System.out.println("---->UserController() 생성  " + userService);
	}
	
	//@RequestMapping("/login.do")
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	//@PostMapping(value = "/login.do")
	
	public String login(UserVO vo) {
		System.out.println(">>>>로그인 처리 - login()");
		UserVO user = userService.getUser(vo);
		if(user != null) {
			return "getBoardList.do" ;
		} else {
			return "login.jsp";
		}
	}

	/*  @@ModelAttribute : 모델(Model)속성값으로 저장(속성명 별도 지정)
	 	별도 지정 명칭 부여 안하면 <데이터 타입>의 첫글자 소문자로 작성된 명칭 사용
	 	@ModelAttribute UserVO vo ---> 속성명 userVO 형태
	 	@ModelAttribute("user")UserVO ---> 속성명 user 사용
	 	Command 객체가 기본 request 스코프에 저장 사용됨
	*/
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
//	@GetMapping(value = "/login.do")
//	public String loginView(UserVO vo) {	// 뷰에서 사용할 userVO명칭으로 데이터 저장
	
	public String loginView(@ModelAttribute("user") UserVO vo) {	//Model 속성명 뷰에서 사용할 user명칭으로 데이터 저장 사용
		System.out.println(">>>>로그인 페이지로 이동 처리 - loginView()");
		vo.setId("test");
		vo.setPassword("test");
		return "login.jsp";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println(">>> 로그아웃 처리");
		//1.세션 초기화(세션 객체 종료)
		session.invalidate();

		return "login.jsp";
	}
}
