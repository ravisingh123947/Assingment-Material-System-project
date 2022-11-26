<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" href="./css/signUp.css" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />

<link rel="stylesheet" href="./css/signUp.css" />
<title>Faculty sign up page</title>
</head>

<body>

	<header>
		<div class="brand">Assignment & Materials</div>

		<nav>
			<ul>
				<li><a href="./index.jsp">Home</a></li>
				<li><a href="./adminLogin.jsp">Admin</a></li>
				<li><a href="./facultyLogin.jsp">Faculty</a></li>
				<li><a href="./studentLogin.jsp">Students</a></li>
			</ul>
		</nav>
	</header>

	<div class="center">
		<h1 style="color:white">faculty Sign Up</h1>
		<form action="./facultysignup">
			<div class="txt_field">
				<input type="number" name="id" required> <span></span> <label>Faculty
					Id</label>
			</div>
			<div class="txt_field">
				<input type="text" name="name" required> <span></span> <label>Name</label>
			</div>
			<div class="txt_field">
				<input type="text" name="email" required> <span></span> <label>Email</label>
			</div>
			<div class="txt_field">
				<input type="text" name="username" required> <span></span> <label>Username</label>
			</div>
			<div class="txt_field">
				<input type="password" name="password" required> <span></span>
				<label>Password</label>
			</div>
			<%
			String username = (String) request.getAttribute("username");
			if (username != null) {
				//if (loginStatus.equals("invalid")) {
			%>
			<div style="color: green;" class="form-text alert alert-success"
				role="alert">
				Registered successfully with username
				<%=username%>
				<a href="./facultyLogin.jsp">click to Login</a>
			</div>
			<%
			//}
			}
			%>
			<input type="submit" value="Sign Up">

		</form>



	</div>

</body>
</html>
