package com.practice.spring01.file.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.spring01.file.dto.FileDto;

@Repository
public class FileDaoImpl implements FileDao{

	@Autowired
	private SqlSession session;

	@Override
	public List<FileDto> getList(FileDto dto) {
		// TODO Auto-generated method stub
		return session.selectList("file.getList", dto);
	}

	@Override
	public int getCount(FileDto dto) {
		// TODO Auto-generated method stub
		return session.selectOne("file.getCount", dto);
	}
	
	
}
