package com.practice.spring01.file.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.practice.spring01.file.dto.FileDto;
import com.practice.spring01.file.service.FileService;

@Controller
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	@RequestMapping(value = "/file/list")
	public ModelAndView list(HttpServletRequest request, ModelAndView mView) {
		
		fileService.getList(request);
		mView.setViewName("file/list");
		return mView;
	}
	
	@RequestMapping(value = "/file/private/upload_form")
	public ModelAndView upload_form(ModelAndView mView) {
		
		mView.setViewName("file/private/upload_form");
		return mView;
	}
	
	@RequestMapping(value = "/file/private/upload", method = RequestMethod.POST)
	public ModelAndView upload(FileDto dto, ModelAndView mView, 
			HttpServletRequest request) {
		fileService.saveFile(dto, mView, request);
		mView.setViewName("file/private/upload");
		return mView;
	}
	@RequestMapping(value = "/file/download")
	public ModelAndView download(@RequestParam int num, ModelAndView mView) {
		
		
		fileService.getFileData(num, mView);
		mView.setViewName("file/download");
		return mView;
	}
}
