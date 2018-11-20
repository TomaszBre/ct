<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All users</title>
</head>
<body>
	<h1>All users:</h1>
	<c:forEach items="${users}" var="user">
		--------------------------------------------------- <br>
		ID: <c:out value="${user.id}"/><br>
		FIRST NAME: <c:out value="${user.firstName}"/><br>
		LASET NAME: <c:out value="${user.lastName}"/><br>
		LOGIN: <c:out value="${user.login}"/><br>
		DATE OD REGISTRATION: <c:out value="${user.dateOfRegistration}"/><br>
		ACTIVE: <c:out value="${user.activeUser}"/><br>
		---------------------------------------------------	<br>
	</c:forEach>
	
	<a href="/proj/home">Go to home page</a>

</body>
</html>