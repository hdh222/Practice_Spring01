<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
<style>
	/* 프로필 업로드 폼을 화면에서 숨긴다. */
	#profileForm{
		display:none;
	}
	/* 이미지를 작은 원형으로 만든다. */
	#profileImage{
		width: 50px;
		height: 50px;
		border: 1px solid #cecece;
		border-radius: 50%;
		cursor: pointer;
	}
</style>
</head>
<body>
	<div class="container">
	<h1>회원정보 수정 폼</h1>
	<a href="javascript:" id="profileLink">
		<c:choose>
			<c:when test="${empty dto.profile }">
				<svg id="profileImage"  width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-person-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
							<path fill-rule="evenodd" d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
				</svg>
			</c:when>
			<c:otherwise>
				<img id="profileImage" 
					src="${pageContext.request.contextPath }${dto.profile }"/>
			</c:otherwise>
		</c:choose>
	</a>	
		<form action="update.do" method = "post">
			<input type="hidden" name="profile" id="profile" value="${dto.profile }" />
			<div class="form-group">
				<label for="id">아이디</label>
				<input type="text" class="form-control" id="id" value="${dto.id }" disabled />
			</div>
			
			<div class="form-group">
				<label for="email">이메일</label>
				<input type="text" class="form-control" id="email" name="email" value="${dto.email }"/>
			</div>
			
			<button class="btn btn-primary" type="submit">수정하기</button>
			<button class="btn btn-danger" type="reset">취소하기</button>
		</form>
		
		<form action="profile_upload.do" method="post" enctype="multipart/form-data" id="profileForm">
		<input type="file" name="image" accept=".jpg, .jpeg, .png, .JPG, .JPEG" id="image"/>
	</form>
	
	<form action="pwd_update.do" method="post" id="myForm">
		<div class="form-group">
			<label for="pwd">기존 비밀번호</label>
			<input class="form-control" type="password" name="pwd" id="pwd"/>
		</div>
		<div class="form-group">
			<label for="newPwd">새 비밀번호</label>
			<input class="form-control" type="password" name="newPwd" id="newPwd"/>
		</div>
		<div class="form-group">
			<label for="newPwd2">새 비밀번호 확인</label>
			<input class="form-control" type="password" name="newPwd2" id="newPwd2"/>
		</div>
		<button class="btn btn-outline-primary" type="submit">수정하기</button>
	</form>
	</div>
	<script src="${pageContext.request.contextPath }/resources/js/jquery-3.5.1.js"></script>
	<script src="${pageContext.request.contextPath }/resources/js/jquery.form.min.js"></script>
	
	<script>
		$("#profileLink").on("click", function(){
			$("#image").click();
		});


		$("#image").on("change", function(){

			$("#profileForm").submit();
		});
		
		$("#profileForm").ajaxForm(function(data){
			
			$("#profileImage").remove();
			
			$("<img/>")
			.attr("id", "profileImage")
			.attr("src", "${pageContext.request.contextPath }"+data.imageSrc)
			.appendTo("#profileLink");
			
			$("#profile").val(data.imageSrc);// input type="hidden" 의 value값
		});
		
		$("#myForm").on("submit", function(){
			
			var pwd1=$("#newPwd").val();
			var pwd2=$("#newPwd2").val();
			
			if(pwd1 != pwd2){
				alert("새로운 비밀번호가 일치 하지 않아요");
				$("#newPwd").val("").focus();
				$("#newPwd2").val("");
				
				return false;
			}
		});
	</script>
</body>
</html>