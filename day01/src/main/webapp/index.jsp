<%@page import="org.comstudy.myweb.model.TodoVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
// jsp 선언문 : 멤버 필드, 멤버메서드 등
// service 함수 외부에 들어가는 내용
// 함수 내부라면
	private String name = "홍길동";
	public String sayHello() {
		return toString();
	}
// 이런식으로 멤버들을 선언 할 수 있다..
%>


<%
// service 함수 내부에 들어가는 내용
// 스크립틀릿: 이렇게 주석달린부분 처럼 java 소스코드 작성,사용 가능
// JSP 파일을 Tomcat 에서 실행 하면 Servlet JAVA 소스코드로 변경되고
// 변경된 소스코드를 컴파일 돼서 .class 파일로 만들어 진다.
// TOMCAT이 .class 파일을 브라우저에 실행 하도록 만들어 줌(HTML로 바뀜)

// src 영역에 선언된 JAVA 객체 바로 사용가능. (사용 할 클래스 import 필수)
TodoVo todo = new TodoVo(100, "집안 정리하기", false);
// jsp에는 out, request, response, session, application 등의 내장 객체가 미리 준비되어 있다..
%>
	<h1>Hello World</h1>
	<ul>
	<li><a href="App">to App</a></li>
	<li><a href="todo/list">Todolist</a></li>
	
	</ul>
	<h3><%=todo %></h3>
	
	<table>
	</table>
	
</body>
</html>