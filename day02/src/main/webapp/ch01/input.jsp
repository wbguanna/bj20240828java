<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>서명/이메일 입력 폼</h1>
	<%
	if(session.getAttribute("email") == null) {
	%>
	<form action="result.do" method="post">
		<label for="name">Name:</label><input type="text" name="name" id="name" value="Hong" />
		<label for="email">Email:</label><input type="email" name="email" id="email" value="Hong@example.com" />
		<input type="submit" value="send" />
	</form>
	<%
	} else {
	%>
	<p>이미 세션에 이메일이 들어 있습니다</p>
	<p>이미 로그인이 되어있습니다</p>
	<a href="result.do">세션 비우기(doGet에서 처리)</a>
	<%} %>
</body>
</html>