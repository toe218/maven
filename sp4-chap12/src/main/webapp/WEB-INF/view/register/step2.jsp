<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" 
			uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title><spring:message code="member.register" /></title>
</head>
<body>
	<h2><spring:message code="member.info" /></h2>
	<%-- <form action="step3" method="post" > --%>
	<form:form action="step3" commandName="registerRequest">
	<p>
		<label><spring:message code="email" />:<br>
		<%-- <input type="text" name="email" id="email" value="${registerRequest.email}"> --%>
		<form:input path="email"/>
		<form:errors path="email"/>
		</label>
	</p>
	<p>
		<label><spring:message code="name" />:<br>
		<%-- <input type="text" name="name" id="name" value="${registerRequest.name}"> --%>
		<form:input path="name" />
		<form:errors path="name" />
		</label>
	</p>
	<p>
		<label><spring:message code="password" />:<br>
		<!-- <input type="password" name="password" id="password"> -->
		<form:password path="password"/>
		<form:errors path="password"/>
		</label>
	</p>
	<p>
		<label><spring:message code="password.confirm" />:<br>
		<!-- <input type="password" name="confirmPassword" id="confirmPassword"> -->
		<form:password path="confirmPassword" />
		<form:errors path="confirmPassword"/>
		</label>
	</p>
	<input type="submit" 
			value="<spring:message code="register.btn" />">
	</form:form>
	
	<%--
	<form:form action="step3" commandName="registerRequest">
	<p>
		<label>이메일:<br>
		<form:input path="email" />
		</label>
	</p>
	<p>
		<label>이름:<br>
		<form:input path="name" />
		</label>
	</p>
	<p>
		<label>비밀번호:<br>
		<form:password path="password" />
		</label>
	</p>
	<p>
		<label>비밀번호 확인:<br>
		<form:password path="confirmPassword" />
		</label>
	</p>
	<input type="submit" value="가입 완료">
	</form:form>
	--%>
</body>
</html>