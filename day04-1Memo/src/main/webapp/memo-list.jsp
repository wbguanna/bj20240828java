<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Memo List</title>
</head>
<body>
    <h1>Memo List</h1>
    <ul>
        <c:forEach items="${memos}" var="memo">
        	<!-- ID 값이 없다면? -->
        	<!-- 서블릿에서 확인해 주자 -->
            <li><a href="${pageContext.request.contextPath}/memos/${memo.id}">${memo.title}</a></li>
        </c:forEach>
    </ul>
    <h2>Add New Memo</h2>
    <!-- HTML 폼에서는 METHOD가 POST 또는 GET으로만 보낼 수 있다. -->
    <form action="${pageContext.request.contextPath}/memos" method="post">
        Title: <input type="text" name="title" required><br>
        Content: <textarea name="content" required></textarea><br>
        <input type="submit" value="Add">
    </form>
</body>
</html>

