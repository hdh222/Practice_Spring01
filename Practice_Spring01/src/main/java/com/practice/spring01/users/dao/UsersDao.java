package com.practice.spring01.users.dao;

import java.util.Map;

import com.practice.spring01.users.dto.UsersDto;

public interface UsersDao {
	public void insert(UsersDto dto);
	public boolean checkId(String inputId);
	public boolean isValid(UsersDto dto);
}
