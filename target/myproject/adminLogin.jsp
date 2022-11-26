<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" href="./css/login.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />

<title>Assignment & Material project</title>
</head>

<body>
	<%

	%>
	<header>
		<div class="brand">Assignment & Materials</div>

		<nav>
			<ul>
				<li><a href="./adminpage?link=home">Home</a></li>
				<li><a href="./adminpage?link=adminLogin">Admin</a></li>
				<li><a href="./adminpage?link=facultyLogin">Faculty</a></li>
				<li><a href="./adminpage?link=studentLogin">Students</a></li>
			</ul>
		</nav>
	</header>

	<div class="center">
		<h1 style="color:white">Admin Login</h1>
		<form action="./adminlogin">
			<div class="txt_field">
				<input type="text" name="username" required> <span></span> <label>Username</label>
			</div>
			<div class="txt_field">
				<input type="password" name="password" required> <span></span>
				<label>Password</label>
			</div>

			<input type="submit" value="Login">

			<div class="txt_field"></div>

		</form>
	</div>

</body>
</html>
