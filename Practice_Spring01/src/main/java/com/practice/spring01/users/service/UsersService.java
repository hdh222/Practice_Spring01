package com.practice.spring01.users.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.practice.spring01.users.dto.UsersDto;

public interface UsersService {
	public void addUser(UsersDto dto);
	public Map<String, Object> checkId(String inputId);
	public void loginProcess(UsersDto dto, ModelAndView mView, HttpSession session);
	public void getData(HttpSession session, ModelAndView mView);
	public void deleteUser(HttpSession session);
	public Map<String, Object> saveProfileImage(HttpServletRequest request, MultipartFile mFile);
	public void updateUserInfo(HttpSession session, UsersDto dto);
	public void updateUserPwd(HttpSession session, UsersDto dto, ModelAndView mView);
}
