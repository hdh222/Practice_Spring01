package com.practice.spring01.users.service;

import java.util.Map;

import com.practice.spring01.users.dto.UsersDto;

public interface UsersService {
	public void addUser(UsersDto dto);
	public Map<String, Object> checkId(String inputId);
}
