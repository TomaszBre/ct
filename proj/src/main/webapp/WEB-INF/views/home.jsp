<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home page</title>
</head>
<body>
	<table class="homeTable">
		<tr>
			<td>
				<a href="/proj/showUsers/">Show all users</a><br><br>
				<p class="nearButton">Show user with ID:</p><br>
				<input type="text" id="userId" value="1">
				<button onclick="showUser()">Go</button>

				<script>
				function showUser() {
				    var usrID = document.getElementById("userId").value;
				    var usr = "/proj/showUsers/";
				    window.location.href=usr.concat(usrID);
				}
				</script>
			</td>
			<td>
				<a href="/proj/addFilm/">Add new film</a><br><br>
				<a href="/proj/showFilms/">Show all films</a><br><br>
				<a href="/proj/top/">Show top 10 films</a><br><br>
				<p class="nearButton">Evaluate film with ID:</p>
				<input type="text" id="filmId" value="1">
				<button onclick="showFilm()">Go</button>

				<script>
				function showFilm() {
				    var filmId = document.getElementById("filmId").value;
				    var film = "/proj/showFilms/";
				    window.location.href=film.concat(filmId);
				}
				</script>
			</td>
			
		</tr>
	</table>


</body>
</html>