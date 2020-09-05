package com.practice.spring01.users.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.practice.spring01.users.dto.UsersDto;
import com.practice.spring01.users.service.UsersService;

@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@RequestMapping(value = "/users/signup_form")
	public String signup_form() {
		
		return "users/signup_form";
	}
	
	@RequestMapping(value = "/users/signup")
	public ModelAndView signup(ModelAndView mView, UsersDto dto) {
		
		usersService.addUser(dto);
		mView.setViewName("users/signup");
		return mView;
	}
	
	@RequestMapping(value = "/users/login_form")
	public String login_form() {
		
		return "users/login_form";
	}
	
	@RequestMapping(value = "users/checkid", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> checkid(@RequestParam String inputId){
		return usersService.checkId(inputId);
	}
}
