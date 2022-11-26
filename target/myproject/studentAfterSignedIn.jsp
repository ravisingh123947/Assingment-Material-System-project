<%@page import="com.logitone.webapp.myproject.student.entity.Student"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/afterSignedIn.css" />
<!-- <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    /> -->
<title>student page</title>
</head>
<body>
	<%
	Student student = (Student) request.getAttribute("STUDENT");

	session.setAttribute("STUDENTNAME", student.getName());
	session.setAttribute("STUDENTID", student.getId());
	%>
	<header>
		<div class="brand">
			Student Page (<%=student.getName()%>)
		</div>

		<nav>
			<ul>
				<li><a href="./viewQuestion">View Question</a></li>
				<li><a href="./ViewMaterial">View Material</a></li>
				<li><a href="./studentpage?link=studentLogOut">Log Out</a></li>
			</ul>
		</nav>
	</header>

	<!-- <script src="./js/custom.js">
        </script
              <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
      </script> -->
</body>
</html>