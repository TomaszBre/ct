<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Evaluate film</title>
</head>
<body>
	<h1>Evaluate film:</h1>
	<p class="p_user">
		ID: <c:out value="${film.id}"/><br>
		TITLE: <c:out value="${film.title}"/><br>
		DIRECTOR: <c:out value="${film.director}"/><br>
		ACTOR: <c:out value="${film.actor1}"/><br>
		SECOND ACTOR: <c:out value="${film.actor2}"/><br>
		DESCRIPTION: <c:out value="${film.description}"/><br>
		EVALUATE: 
				<select id="marks">
					<option value="0">0 - not evaluated</option>
					<option value="1">1 - bad</option>
					<option value="2">2 - not bad</option>
					<option value="3">3 - good</option>
					<option value="4">4 - amazing</option>
				</select>
				<button onclick="showUser()">Go</button>

				<script>
				function showUser() {
				    var filmId = <c:out value="${film.id}"/>;
			
				    if (filmId > 0) {
				    	var path1 = "/proj/evaluate?filmId=";
				    	var path2 = "&mark=";
				    	var mark = document.getElementById("marks").value;
				    	window.location.href=path1.concat(filmId).concat(path2).concat(mark);
				    }
				}
				</script>
				
				<p class="success"><c:out value="${comment}"/></p>
	</p>
	
	<a href="/proj/home">Go to home page</a>

</body>
</html>