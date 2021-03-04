package com.spring.biz.user;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {
	public static void main(String[] args) {
		System.out.println("구동전");
		GenericXmlApplicationContext container
			= new GenericXmlApplicationContext("applicationContext_after-returning.xml");
		System.out.println("=== 컨체이너 구동 후 ===");
		UserService userService = (UserService) container.getBean("userService");
		
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test");
		
		UserVO user = userService.getUser(vo);
		System.out.println(user);
		
		container.close();
	}
}
