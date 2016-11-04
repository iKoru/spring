package com.multicampus.biz.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// 2. DAO(Data Access Object) 클래스
@Repository("userDAOMybatis")
public class UserDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;

	// CRUD 관련 메소드
	// 회원 상세 조회
	public UserVO getUser(UserVO vo) {
		System.out.println("===> mybatis 기반으로 getUser() 기능 처리");
		return (UserVO) mybatis.selectOne("userDAO.getUser", vo);
	}
}
