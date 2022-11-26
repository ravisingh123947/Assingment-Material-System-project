
<%@page
	import="com.logitone.webapp.myproject.faculty.entity.ViewAnswerOfStudent"%>
<%
String name = (String) session.getAttribute("FACULTYNAME");
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
<title>view answer</title>
</head>
<body onload="makeItCapital()">
	<header>
		<div class="brand">
			Faculty Page(<span id="name"><%=name%></span>)
		</div>

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

	<%
	ViewAnswerOfStudent[] viewAnswerOfStudent = (ViewAnswerOfStudent[]) request.getAttribute("ANSWER");
	%>

	<table class="table table-success table-striped">
		<tr>
			<th>Student Name</th>
			<th>Faculty Question</th>
			<th>Answer</th>
		</tr>
		<%
		for (ViewAnswerOfStudent answer : viewAnswerOfStudent) {
		%>
		<tr>
			<td><%=answer.getStudent_name()%></td>
			<td><%=answer.getFaculty_question()%></td>
			<td><%=answer.getAnswer()%></td>
		</tr>
		<%
		}
		%>


	</table>
	<script src="./js/custom.js"></script>

</body>
</html>