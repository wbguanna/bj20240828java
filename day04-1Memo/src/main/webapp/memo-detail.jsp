<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Memo Detail</title>
</head><body>
    <h1>Memo Detail</h1>
    <p><strong>Title:</strong> ${memo.title}</p>
    <p><strong>Content:</strong> ${memo.content}</p>
    <form action="${pageContext.request.contextPath}/memos" method="put">
        <input type="hidden" name="id" value="${memo.id}" />
    </form>
</body></html>