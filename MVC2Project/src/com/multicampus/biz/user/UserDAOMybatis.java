package com.multicampus.biz.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// 2. DAO(Data Access Object) Ŭ����
@Repository("userDAOMybatis")
public class UserDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;

	// CRUD ���� �޼ҵ�
	// ȸ�� �� ��ȸ
	public UserVO getUser(UserVO vo) {
		System.out.println("===> mybatis ������� getUser() ��� ó��");
		return (UserVO) mybatis.selectOne("userDAO.getUser", vo);
	}
}
