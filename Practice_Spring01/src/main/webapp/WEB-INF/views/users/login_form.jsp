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
		<h1>로그인 폼</h1>
		<form action="login.do" method="post">
		<input type="hidden" name="url" value="${url }" />
			<div class="form-group">
				<div class="row">
					<label for="id">아이디</label>
					<input class="form-control" type="text" name="id" id="id" placeholder="아이디 입력"/>
				</div>
			</div>
			
			<div class="form-group">
				<div class="row">
					<label for="pwd">비밀번호</label>
					<input class="form-control" type="password" name="pwd" id="pwd" placeholder="비밀번호 입력"/>
				</div>
			</div>
			<button class="btn btn-primary">로그인</button>
		</form>
	</div>
</body>
</html>