package com.practice.spring01.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.spring01.users.dto.UsersDto;

@Repository
public class UsersDaoImpl implements UsersDao{

	@Autowired
	private SqlSession session;

	@Override
	public void insert(UsersDto dto) {
		// TODO Auto-generated method stub
		session.insert("users.insert", dto);
	}

	@Override
	public boolean checkId(String inputId) {
		// TODO Auto-generated method stub
		
		String id = session.selectOne("users.isExist", inputId);
		
		if(id == null) {
			return false;
		}else {
			return true;
		}
	}
	
}
