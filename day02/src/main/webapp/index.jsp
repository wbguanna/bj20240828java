	 <%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Hello Servlet&JSP World</h1>
<% 
//PrintWriter out = response.getWriter(); 
out.println(request.getClass().getName());
out.println(request.getServletContext().getRealPath("/") );
%>
</body>
</html>