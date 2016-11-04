package com.multicampus.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

// 2. DAO(Data Access Object) Ŭ����
@Repository("userDAOIbatis")
public class UserDAOIbatis {
	@Autowired
	private SqlMapClientTemplate ibatis;

	// CRUD ���� �޼ҵ�
	// ȸ�� �� ��ȸ
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Ibatis ������� getUser() ��� ó��");
		return (UserVO) ibatis.queryForObject("getUser", vo);
	}
}
