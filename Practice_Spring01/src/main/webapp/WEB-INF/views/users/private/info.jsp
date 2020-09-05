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
		<h1>개인정보 페이지</h1>
		<table>
			<tr>
				<th>아이디</th>
				<td>${dto.id }</td>
			</tr>
			<tr>
				<th>프로필 이미지</th>
				<td><img src="${pageContext.request.contextPath }${dto.profile}" alt="" /></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${dto.email }</td>
			</tr>
			<tr>
				<th>가입일</th>
				<td>${dto.regdate }</td>
			</tr>
		</table>
		<a href="update_form">개인정보수정</a>
		<a href="javascript:deleteConfirm()">탈퇴</a>
	</div>
	
	<script>
		function deleteConfirm(){
			var isDelete = confirm("${id} 회원님 탈퇴 하시겠습니까?");
			if(isDelete){
				location.href="delete.do";
			}
		}
	</script>
</body>
</html>