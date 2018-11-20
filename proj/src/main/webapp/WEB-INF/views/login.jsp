<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<table class="login">
		<tr>
			<th><h1>Login</h1></th>
		</tr>
		<tr>
			<td>
				<form:form method="POST" modelAttribute="userLogin">
					<form:input path="login" placeholder="Login" autofocus="true" required="true"/><br>
					<form:password path="password" placeholder="Password" required="true"/><br>
					<input type="submit" value="login">
				</form:form>
			</td>
		</tr>
		<tr>
			<td>
				<p class="error">
					<c:out value="${error}"/>
				</p>
			</td>
		</tr>
	</table>

</body>
</html>