<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>

<h1>컴스터디 코딩 스쿨</h1>
<ul>
	<li><a href="phone/list.do">전화번호 목록</a></li>
	<li><a href="phone/input.do">전화번호 등록</a></li>
	<li><a href="phone/search.do">전화번호 조회</a></li>
</ul>

<%
out.println( request.getRealPath("./") );
%>

</body>
</html>