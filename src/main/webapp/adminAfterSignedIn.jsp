<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/afterSignedIn.css" />
<link rel="stylesheet" href="./css/admin.css" />
<!-- <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    /> -->
<title>Admin page</title>
</head>
<body onload="makeItCapital()">
	<%
	String name = (String) request.getAttribute("NAME");
	session.setAttribute("GETNAME", name);
	%>
	<header>
		<div class="brand">Admin Page</div>

		<nav>
			<ul>

				<li><a href="./viewfaculty">View Faculty</a></li>
				<li><a href="./viewstudent">View Students</a></li>
				<li><a href="./adminpage?link=adminLogout">Log Out</a></li>
			</ul>
		</nav>
	</header>
	<div id="middle">
		<h1>
			Welcome <span id="name"><%=name%></span>
		</h1>
	</div>

	<script src="./js/custom.js"></script>

</body>
</html>