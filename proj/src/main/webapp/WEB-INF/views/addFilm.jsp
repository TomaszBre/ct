<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new film</title>
</head>
<body>
	<table>
		<tr>
			<th><h1>Add new film</h1></th>
		</tr>
		<tr>
			<td>
				<form:form method="POST" modelAttribute="addFilm"><br>
					<form:input path="title" placeholder="Title " autofocus="true" required="true"/><br>
					<form:input path="director" placeholder="Director" required="true"/><br>
					<form:input path="actor1" placeholder="Actor" required="true"/><br>
					<form:input path="actor2" placeholder="Second actor" required="true"/><br>
					<form:textarea path="description" placeholder="Description(max 250chars)" rows="4" cols="50" maxlength="250" required="true"/><br>
					<input type="submit" value="Add"/>
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