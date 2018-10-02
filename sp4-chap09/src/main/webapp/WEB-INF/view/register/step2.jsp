<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2><spring:message code="member.info"></spring:message> 입력</h2>
	<!-- <form action="step3" method="post"> -->
	<form:form action="step3" commandName="registerRequest">
		<p>
		<label><spring:message code="email"/>:<br>
		<!-- <input type="text" name="email" id="email"></label> -->
		<form:input path="email"/></label>
		<form:errors path="email"/>
		</p>
		<p>
		<label><spring:message code="name"/>:<br>
		<!-- <input type="text" name="name" id="name"></label> -->
		<form:input path="name"/></label>
		<form:errors path="name"/>
		</p>
		<p>
		<label><spring:message code="password"/>:<br>
		<!-- <input type="password" name="password" id="password"></label> -->
		<form:password path="password"/></label>
		<form:errors path="password"/>
		
		</p>
		<p>
		<label><spring:message code="password.confirm"/>:<br>
		<!-- <input type="password" name="password" id="confirmPassword"></label> -->
		<form:password path="confirmPassword"/>
		<form:errors path="confirmPassword"/>
		</p>
		<input type="submit" value="가입완료">
	</form:form>	
<!-- </form> -->

</body>
</html>