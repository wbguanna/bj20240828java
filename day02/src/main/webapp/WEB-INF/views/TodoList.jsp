<%@page import="org.comstudy.myweb.controller.TodoVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="todos" scope="session" class="org.comstudy.myweb.controller.TodoVO" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>할일 목록</h1>
	<ul>
	<li><a href="input">할일 추가</a></li>
	<li><a href="delete">할일 삭제</a></li>
	<li><a href="detail">할일 상세보기</a></li>
	<li><a href="modify">할일 수정</a></li>
	</ul>
	
	<ul>
	<% 
		ArrayList<TodoVo> todoList = new ArrayList<TodoVo>();
	  	todoList.add(new TodoVo(101, "귀가", false));
	  	todoList.add(new TodoVo(102, "기획서 작성", false));
	  	todoList.add(new TodoVo(103, "nodejs 정리", false));
	  	todoList.add(new TodoVo(104, "mongodb erd 작성", false));
	  	request.setAttribute("todoList", todoList);

	  	// 받아올때는 이렇게 하면 된다.
	  	// ArrayList<TodoVo> todoList = (ArrayList<TodoVo>)request.getAttribuite("todoList");
	  	for (TodoVo todo : todoList) {
	%>
		<li>
			<span><%= todo.getNo()%></span> | 
			<span><a href="detail?no=<%=todo.getNo()%>"><%= todo.getTitle()%></span> | 
			<a href="modify?no=<%=todo.getNo() %>">수정</a> | 
			<a href="delete?no=<%=todo.getNo()%>">삭제</a>
		</li>
	<%	} %>
	</ul>
</body>
</html>