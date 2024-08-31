<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>Login page</h1>
  <form action="login.do" method="post" name="loginForm">
  	<fieldset>
  	<legend>Login</legend>
	<label for="username">User name:</label><input type="text" name="username" id="username" value="user01" /><br/>
	<label for="password">Password:</label><input type="password" name="password" id="password" value="12345" /><br/>
	<input type="submit" value="send" />
	</fieldset>
  </form>
</body>
</html>