package com.practice.spring01.file.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.spring01.file.dao.FileDao;

@Service
public class FileServiceImpl implements FileService{
	
	@Autowired
	private FileDao fileDao;
	
	
}
