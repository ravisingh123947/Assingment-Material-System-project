
<%
String name = (String) session.getAttribute("GETNAME");
%>

<!DOCTYPE html>
<%@page import="com.logitone.webapp.myproject.student.entity.Student"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/afterSignedIn.css" />
<script src="https://kit.fontawesome.com/03e025c263.js"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<title>View student</title>
</head>
<body onload="makeItCapital()">
	<header>
		<div class="brand">
			Admin Page(<span id="name"><%=name%></span>)
		</div>

		<nav>
			<ul>

				<li><a href="./viewfaculty">View Faculty</a></li>
				<li><a href="./viewstudent">View Students</a></li>
				<li><a href="./adminpage?link=adminLogout">Log Out</a></li>
			</ul>
		</nav>
	</header>



	<%
	Student[] studentList = (Student[]) request.getAttribute("STUDENTLIST");
	%>

	<table class="table table-success table-striped">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>email</th>
			<th>username</th>
			<th>password</th>
		</tr>
		<%
		for (Student emp : studentList) {
		%>
		<tr>
			<td><%=emp.getId()%></td>
			<td><%=emp.getName()%></td>
			<td><%=emp.getEmail()%></td>
			<td><%=emp.getUsername()%></td>
			<td><%=emp.getPassword()%></td>
			<td>

				<button type="button" class="btn btn-danger">
					<a style="color: white; font-size: 15px"
						href="./deleteStudentRecord?id=<%=emp.getId()%>">Delete</a>
				</button>
			</td>

		</tr>
		<%
		}
		%>


	</table>
	<%
	String status = (String) request.getAttribute("status");
	%>

	<%
	if (status != null) {
	%>
	<div style="font-size: 20px;" class="alert alert-success" role="alert">
		<%=status%>
	</div>
	<%
	}
	%>

	<script src="./js/custom.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>