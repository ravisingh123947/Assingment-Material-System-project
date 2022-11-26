
<%@page
	import="com.logitone.webapp.myproject.student.entity.FacultyMaterial"%>
<%
String studentName = (String) session.getAttribute("STUDENTNAME");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/afterSignedIn.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.btn {
	background-color: DodgerBlue;
	border: none;
	color: white;
	padding: 12px 30px;
	cursor: pointer;
	font-size: 20px;
}

.btn:hover {
	background-color: RoyalBlue;
}
a {
   text-decoration:none;
   color:white;
}
</style>
<title>student page</title>
</head>
<body>
	<header>
		<div class="brand">
			Student Page(<%=studentName%>)
		</div>

		<nav>
			<ul>
				<li><a href="./viewQuestion">View Question</a></li>
				<li><a href="./ViewMaterial">View Material</a></li>
				<li><a href="./studentpage?link=studentLogOut">Log Out</a></li>
			</ul>
		</nav>
	</header>

	<%
	FacultyMaterial[] facultyMaterialList = (FacultyMaterial[]) request.getAttribute("MATERIALLIST");
	%>

	<table class="table table-success table-striped">
		<tr>
			<th>Faculty_id</th>
			<th>Material_name</th>
			<th>description</th>
			<th>Download</th>
		</tr>
		<%
		for (FacultyMaterial material : facultyMaterialList) {
		%>
		<tr>

			<td><%=material.getFaculty_id()%></td>
			<td><%=material.getMaterial_name()%></td>
			<td><%=material.getDescription()%></td>
			<td><button class="btn">
					<i class="fa fa-download"></i> <a
						href="./images/<%=material.getMaterial_name()%>" download>Downlaod</a>
				</button></td>


		</tr>
		<%
		}
		%>


	</table>





</body>
</html>