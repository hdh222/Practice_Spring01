package com.practice.spring01.users.dao;

import java.util.Map;

import com.practice.spring01.users.dto.UsersDto;

public interface UsersDao {
	public void insert(UsersDto dto);
	public boolean checkId(String inputId);
	public UsersDto getData(String id);
	public void delete(String id);
	public void update(UsersDto dto);
	public void updatePwd(UsersDto dto);
}
