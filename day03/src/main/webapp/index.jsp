<%@page import="java.util.Scanner"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String servletDataFile = application.getInitParameter("ServletDataFile");
	InputStream is = this.getClass().getResourceAsStream(servletDataFile);
	Scanner fileScanner = new Scanner(is);
	while(fileScanner.hasNext()) {
		fileScanner.nextLine();
	}
%>
<%=servletDataFile %>
</body>
</html>