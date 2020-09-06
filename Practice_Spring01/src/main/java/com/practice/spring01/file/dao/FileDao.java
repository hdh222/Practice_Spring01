package com.practice.spring01.file.dao;

import java.util.List;

import com.practice.spring01.file.dto.FileDto;

public interface FileDao {
	public List<FileDto> getList(FileDto dto);
	public int getCount(FileDto dto);
	public void insert(FileDto dto);
}
