package com.practice.spring01.file.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.practice.spring01.file.service.FileService;

@Controller
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	@RequestMapping(value = "/file/list")
	public ModelAndView list(HttpServletRequest request, ModelAndView mView) {
		
		mView.setViewName("file/list");
		return mView;
	}
}
