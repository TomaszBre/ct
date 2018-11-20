<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All films in database</title>
</head>
<body>
	<h1>All films in database:</h1>
	<c:forEach items="${films}" var="film">
		--------------------------------------------------- <br>
		ID: <c:out value="${film.id}"/><br>
		TITLE: <c:out value="${film.title}"/><br>
		DIRECTOR: <c:out value="${film.director}"/><br>
		ACTOR: <c:out value="${film.actor1}"/><br>
		SECOND ACTOR: <c:out value="${film.actor2}"/><br>
		DESCRIPTION: <c:out value="${film.description}"/><br>
		---------------------------------------------------	<br>
	</c:forEach>
	
	<a href="/proj/home">Go to home page</a>

</body>
</html>