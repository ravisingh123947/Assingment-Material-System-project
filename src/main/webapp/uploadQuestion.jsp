
<%
String name = (String) session.getAttribute("FACULTYNAME");
String status = (String) request.getAttribute("QUESTIONUPLOADED");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/afterSignedIn.css" />
<link rel="stylesheet" href="./css/uploadQuestion.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<title>upload question</title>
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
	<div class="maincontainer">
		<div class="cont">
			<h1 id="title" style="color:white">Write your Question Here</h1>

			<form action="./UploadQuestion">
				<textarea name="question"></textarea>
				<input type="submit">
			</form>
		</div>
	</div>

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

</body>
</html>