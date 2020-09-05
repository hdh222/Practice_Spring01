<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Spring 연습</h1>
	
	<c:choose>
		<c:when test="${empty id }">	
			<a href="users/login_form.do">로그인</a>
			<a href="users/signup_form.do">회원가입</a>
		</c:when>
		<c:otherwise>
			<a href="users/private/info.do"><strong>${id }</strong></a> 로그인 중
			<a href="logout.do">로그아웃</a>
		</c:otherwise>
	</c:choose>
	
	
</body>
</html>