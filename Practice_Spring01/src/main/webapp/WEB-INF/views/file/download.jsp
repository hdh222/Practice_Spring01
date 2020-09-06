<%@page import="com.practice.spring01.file.dto.FileDto"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	FileDto dto=(FileDto)request.getAttribute("dto");	
	String orgFileName=dto.getOrgFileName(); //원본 파일명
	String saveFileName=dto.getSaveFileName(); //저장된 파일명
	
	String path=application.getRealPath("/upload")
			+File.separator+saveFileName;
	
	FileInputStream fis=new FileInputStream(path);
	
	String encodedName=null;
	if(request.getHeader("User-Agent").contains("Firefox")){
		//벤더사가 파이어 폭스인경우 
		encodedName=new String
			(orgFileName.getBytes("utf-8"),"ISO-8859-1");
	}else{ //그외 다른 벤더사 
		encodedName=URLEncoder.encode(orgFileName, "utf-8");
		encodedName=encodedName.replaceAll("\\+"," ");
	}
	
	response.setHeader("Content-Disposition","attachment;filename="+encodedName);
	response.setHeader("Content-Transfer-Encoding", "binary");
	
	response.setContentLengthLong(dto.getFileSize());
	
	BufferedOutputStream bos=
	new BufferedOutputStream(response.getOutputStream());
	byte[] buffer=new byte[1024*1000];
	int readedByte=0;
	while(true){
		readedByte = fis.read(buffer);
		if(readedByte == -1)break; 
		bos.write(buffer, 0, readedByte);
		bos.flush(); 
	}

	bos.close();
	fis.close();    	
%> 