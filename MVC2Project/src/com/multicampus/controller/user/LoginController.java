package com.multicampus.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.user.UserDAO;
import com.multicampus.biz.user.UserVO;

@Controller
public class LoginController{
	
	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDAO) {
		return (userDAO.getUser(vo)==null?"login.jsp":"getBoardList.do");
	}

}



