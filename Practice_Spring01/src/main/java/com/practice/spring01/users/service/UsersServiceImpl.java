package com.practice.spring01.users.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

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

	@Override
	public Map<String, Object> checkId(String inputId) {
		// TODO Auto-generated method stub
		
		boolean isExist = usersDao.checkId(inputId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("isExist", isExist);
		
		return map;
	}

	@Override
	public void loginProcess(UsersDto dto, ModelAndView mView, HttpSession session) {
		// TODO Auto-generated method stub
		boolean isValid = usersDao.isValid(dto);
		
		if(isValid) {
			session.setAttribute("id", dto.getId());
			mView.addObject("isSuccess", true);
		}else {
			mView.addObject("isSuccess", false);
		}
	}
	

}
