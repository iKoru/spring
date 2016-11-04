package com.multicampus.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.multicampus.biz.user.UserDAO;
import com.multicampus.biz.user.UserVO;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(UserVO vo) {
		vo.setId("test");
		vo.setPassword("test");
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO) {
		if(userDAO.getUser(vo) != null) return "getBoardList.do";
		else return "login.jsp";
	}

}



