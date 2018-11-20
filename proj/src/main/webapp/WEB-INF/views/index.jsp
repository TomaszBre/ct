<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to the Film Service</title>
</head>
<body>
	<table>
		<tr>
			<th>
				<h1>Film Service welcomes you</h1>
			</th>
		</tr>
		<tr>
			<td>
				<button onclick="login()">LOGIN</button>
				<script>
				function login() {
				    var usr = "/proj/login";
				    window.location.href=usr;
				}
				</script>

			</td>
		</tr>	
	</table>

</body>
</html>

