package com.multicampus.biz.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceClient {
	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		ApplicationContext container = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로부터 테스트 객체를 Lookup한다.
		UserService userService = 
			(UserService) container.getBean("userService");
		
		// 3. Lookup한 객체 테스트
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test");
		UserVO user = userService.getUser(vo);
		
		if(user != null) {
			System.out.println(user.getName() + "님 환영합니다.");
		} else {
			System.out.println("로그인 실패");
		}
	}
}
