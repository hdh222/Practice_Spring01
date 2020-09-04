package com.practice.spring01.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.spring01.users.dao.UsersDao;
import com.practice.spring01.users.dto.UsersDto;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersDao usersDao;

	@Override
	public void addUser(UsersDto dto) {
		// TODO Auto-generated method stub
		usersDao.insert(dto);
	}

}
