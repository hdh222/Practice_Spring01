package com.practice.spring01.users.controller;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String login_form(HttpServletRequest req) {
		
		String url = req.getParameter("url");
		if(url == null) {
			url = req.getContextPath() + "/home.do";
		}
		System.out.println(url);
		req.setAttribute("url", url);
		
		return "users/login_form";
	}
	
	@RequestMapping(value = "/users/checkid", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> checkid(@RequestParam String inputId){
		return usersService.checkId(inputId);
	}
	
	@RequestMapping(value = "/users/login")
	public ModelAndView login(UsersDto dto, ModelAndView mView, HttpServletRequest req) {
		
		String url = req.getParameter("url");
		System.out.println(url);
		String encodedUrl = URLEncoder.encode(url);
		mView.addObject("url",url);
		mView.addObject("encodedUrl", encodedUrl);
		
		usersService.loginProcess(dto, mView, req.getSession());
		mView.setViewName("users/login");
		return mView;
	}
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/home.do";
	}
	@RequestMapping(value = "/users/private/info")
	public ModelAndView getData(HttpSession session, ModelAndView mView) {
		
		usersService.getData(session, mView);
		mView.setViewName("users/private/info");
		return mView;
	}
}
