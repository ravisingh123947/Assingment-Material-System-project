
<%@page
	import="com.logitone.webapp.myproject.student.entity.FacultyQuestion"%>
<%
String studentName = (String) session.getAttribute("STUDENTNAME");

String status = (String) request.getAttribute("ANSWERUPLOADED");
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
<style>
.answer {
	width: 40%;
}

.text {
	width: 100%;
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
	FacultyQuestion[] facultyQuestionList = (FacultyQuestion[]) request.getAttribute("QUESTIONLIST");
	%>

	<table class="table table-success table-striped">
		<tr>
			<th>Question_id</th>
			<th>Question</th>
			<th class="answer">Write Answer Here</th>
			<th>Upload Answer</th>
		</tr>
		<%
		for (FacultyQuestion fac : facultyQuestionList) {
		%>
		<tr>
			<form action="./UploadAnswer">
				<td><input name="question_id"
					value="<%=fac.getQuestion_id()%>"></td>
				<td><%=fac.getFaculty_question()%></td>
				<td><textarea class="text" name="answer"></textarea></td>
				<td><button class="btn btn-primary" type="submit">Upload</button></td>
			</form>
		</tr>
		<%
		}
		%>


	</table>

	<%
	if (status == "success") {
	%>
	<div class="alert alert-success" role="alert">Uploaded
		successfully!!</div>
	<%
	} else if (status == "failure") {
	%>
	<div class="alert alert-danger" role="alert">Sorry!! for
		inconvenience</div>
	<%
	}
	%>


	<!-- <script src="./js/custom.js">
        </script
              <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
      </script> -->
</body>
</html>