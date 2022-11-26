

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/login.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<title>Faculty login page</title>
</head>
<body>
	<header>
		<div class="brand">Assignment & Materials</div>

		<nav>
			<ul>
				<li><a href="./facultypage?link=home">Home</a></li>
				<li><a href="./facultypage?link=adminLogin">Admin</a></li>
				<li><a href="./facultypage?link=facultyLogin">Faculty</a></li>
				<li><a href="./facultypage?link=studentLogin">Students</a></li>
			</ul>
		</nav>
	</header>
	<div class="center">
		<h1 style="color:white">Faculty Login</h1>
		<form action="./facultylogin">
			<div class="txt_field">
				<input type="text" name="username" required> <span></span> <label>Username</label>
			</div>
			<div class="txt_field">
				<input type="password" name="password" required> <span></span>
				<label>Password</label>
			</div>
			<div class="pass">Forgot Password?</div>
			<input type="submit" value="Login">
			<div class="signup_link">
				New User? <a href="./facultySignUp.jsp">Signup</a>
			</div>
		</form>
		<%
		String loginStatus = (String) request.getAttribute("loginStatus");
		if (loginStatus != null) {
			if (loginStatus.equals("invalid")) {
		%>
		<div class="form-text alert alert-danger" role="alert">Invalid
			Credentials. Please Try Again.</div>
		<%
		}
		}
		%>
	</div>


	<script src="./js/custom.js">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">

		</body>
		</html>
	