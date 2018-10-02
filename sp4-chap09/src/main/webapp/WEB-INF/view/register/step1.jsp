<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  <!-- label.properties를 사용하기 위함 -->  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.register"/></title>
</head>
<body>
	<h2><spring:message code="term"/></h2>	<!-- label.properties에서 해당 code에 대응되는 문자열을 가져옴 -->
	<p><spring:message code="term.cont"></spring:message></p>
	<form action="step2" method="post">
		<input type="checkbox" name="agree" value="true"><spring:message code="term.agree"/>
		<input type="submit" value="<spring:message code='next.btn'/>">
	
	
	</form>
</body>
</html>