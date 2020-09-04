<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<form action="signup.do" method="post">
			<div class="form-group">
				<label for="id">아이디</label>
				<input type="text" name="id" id="id" class= "form-control"/>
			</div>
			
			<div class="form-group">
				<label for="pwd">비밀번호</label>
				<input type="text" name="pwd" id="pwd" class= "form-control"/>
			</div>
			
			<div class="form-group">
				<label for="email">이메일</label>
				<input type="text" name="email" id="email" class= "form-control"/>
			</div>
			
			<button type="submit" class="btn btn-primary">가입</button>
			<button type="reset" class="btn btn-danger">취소</button>
		</form>
	</div>
</body>
</html>