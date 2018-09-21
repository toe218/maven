<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원정보 입력</h2>
	<!-- <form action="step3" method="post"> -->
	<form:form action="step3" commandName="registerRequest">
		<p>
		<label>이메일:<br>
		<!-- <input type="text" name="email" id="email"></label> -->
		<form:input path="email"/></label>
		</p>
		<p>
		<label>이름:<br>
		<!-- <input type="text" name="name" id="name"></label> -->
		<form:input path="name"/></label>
		</p>
		<p>
		<label>비밀번호:<br>
		<!-- <input type="password" name="password" id="password"></label> -->
		<form:password path="password"/></label>
		
		</p>
		<p>
		<label>비밀번호확인:<br>
		<input type="password" name="password" id="confirmPassword"></label>
		</p>
		<input type="submit" value="가입완료">
	</form:form>	
<!-- </form> -->

</body>
</html>