<!DOCTYPE html>
<%@page import="com.logitone.webapp.myproject.faculty.entity.Faculty"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/afterSignedIn.css" />
<link rel="stylesheet" href="./css/admin.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<title>Faculty page</title>
</head>
<body onload="makeItCapital()">
	<%
	

	Faculty faculty = (Faculty) request.getAttribute("FACULTY");
	session.setAttribute("FACULTYNAME", faculty.getName());
	session.setAttribute("FACULTYID", faculty.getId());
	%>
	<header>
		<div class="brand">Faculty Page</div>

		<nav>
			<ul>

				<li><a href="./facultypage?link=uploadQuestion">Upload
						Question</a></li>
				<li><a href="./facultypage?link=uploadMaterial">Upload
						Material</a></li>
				<li><a href="./ViewAnswer">View Answer</a></li>
				<li><a href="./facultypage?link=logOut">Log Out</a></li>
			</ul>
		</nav>
	</header>
	<div id="middle">
		<h1>
			Welcome <span id="name"><%=faculty.getName()%></span>
		</h1>
	</div>

	<script src="./js/custom.js">
		
	</script
              <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
      </script> -->
</body>
</html>