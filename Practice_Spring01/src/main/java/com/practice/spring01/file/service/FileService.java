package com.practice.spring01.file.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.practice.spring01.file.dto.FileDto;

public interface FileService {
	public void getList(HttpServletRequest req);
	public void saveFile(FileDto dto, ModelAndView mView, HttpServletRequest request);
	public void getFileData(int num, ModelAndView mView);
}
