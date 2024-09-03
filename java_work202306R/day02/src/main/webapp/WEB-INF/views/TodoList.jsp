<%@page import="org.comstudy.myweb.model.TodoVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>할 일 목록</h1>
<!-- 목록 테이블 들어 갑니다. -->
<table width="100%" border="1">
            <tr>
                <th>ID</th>
                <th>TITLE</th>
                <th>상태</th>
                <th>수정</th>
                <th>삭제</th>
            </tr>
    <%
    	/* ArrayList<TodoVo> todoList = new ArrayList<TodoVo>();
    	todoList.add(new TodoVo(101, "새 할일", false));
    	todoList.add(new TodoVo(102, "새 할일2", true));
    	todoList.add(new TodoVo(103, "새 할일3", false)); */
    	ArrayList<TodoVo> todoList = (ArrayList<TodoVo>)request.getAttribute("todoList");
        for(int i=0; i<todoList.size(); i++) {
        	TodoVo todo = todoList.get(i);
    %>
            <tr>
                <td><%= i %></td>
                <td><a href="detail?no=<%= todo.getNo() %>"><%= todo.getTitle() %></a></td>
                <td><%= todo.isDone() %></td>
                <td><a href="modify?no=<%= todo.getNo() %>">수정</a></td>
                <td><a href="delete?no=<%= todo.getNo() %>">삭제</a></td>
            </tr>
    <%
        }
    %>
        </table>

<a href="input">할일 입력</a>
</body>
</html>