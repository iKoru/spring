package com.multicampus.biz.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceClient {
	public static void main(String[] args) {
		// 1. Spring �����̳ʸ� �����Ѵ�.
		ApplicationContext container = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring �����̳ʷκ��� �׽�Ʈ ��ü�� Lookup�Ѵ�.
		UserService userService = 
			(UserService) container.getBean("userService");
		
		// 3. Lookup�� ��ü �׽�Ʈ
		UserVO vo = new UserVO();
		vo.setId("aaa");
		vo.setPassword("aaa");
		UserVO user = userService.getUser(vo);
		
		if(user != null) {
			System.out.println(user.getName() + "�� ȯ���մϴ�.");
		} else {
			System.out.println("�α��� ����");
		}
	}
}
