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

<title>student login</title>
</head>

<body>

	<header>
		<div class="brand">Assignment & Materials</div>

		<nav>
			<ul>
				<li><a href="./studentpage?link=home">Home</a></li>
				<li><a href="./studentpage?link=adminLogin">Admin</a></li>
				<li><a href="./studentpage?link=facultyLogin">Faculty</a></li>
				<li><a href="./studentpage?link=studentLogin">Students</a></li>
			</ul>
		</nav>
	</header>

	<div class="center">
		<h1 style="color:white">Student Login</h1>
		<form action="./studentlogin">
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
				New User? <a href="./studentSignUp.jsp">Signup</a>
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


</body>
</html>
