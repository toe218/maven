<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">		<!-- action에 적지 않아도 자동이동됨 -->
		<!-- <p>
			1.당신의 역할은?<br/>
			<label><input type="radio" name="response[0]" value="서버">서버개발자</label>
			<label><input type="radio" name="response[0}" value="프론트">프론트개발자</label>
			<label><input type="radio" name="response[0]" value="풀스택">풀스택 개발자</label>
		</p>
		
		<p>
			2.가장많이 사용하는 개발도구는?<br/>
			<label><input type="radio" name="response[1]" value="Eclipse">Eclipse</label>
			<label><input type="radio" name="response[1]" value="Intellij">Intellij</label>
			<label><input type="radio" name="response[1]" value="Sublime">Sublime</label>
		
		</p>
		
		<p>
			3.하고싶은말 <br/>
			<label><input type="text" name="response[2]"> </label>
			
		
		</p> -->
		<c:forEach var ="q" items="${questions}" varStatus="status">
			${status.index + 1}.${q.title} <br/>
			<c:if test="${ q.choice}">
				<c:forEach var ="option" items="${q.options }">
					<input type="radio" name="responses[${status.index }]"  value="${option}"/>
						${option }
					<br/>
				</c:forEach>
				
				
			
			</c:if>
			<c:if test="${!q.choice }">
				<input type="text" name="responses[${status.index }]"/>
			
			
			</c:if>
			<br/> 
			
		</c:forEach>
		
		
		
		
		
		
		<p>
		<label>응답자 위치<br/>
		<input type="text" name="res.location"></label>
		</p>
		
		<p>
		<label>응답자 나이:<br/>
		<input type="text" name="res.age"></label>
		</p>
		<input type="submit" value="전송">
	</form>
</body>
</html>