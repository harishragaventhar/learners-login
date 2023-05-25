<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<style>
.error {
	color: red;
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">LA</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<%
						String id = (String) session.getAttribute("id");
						if (id == null) {
					%>
					<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a>
					</li>
					<%
						}
						if (id != null) {
					%>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="subjects.jsp">Subjects</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="teachers.jsp">Teachers</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="students.jsp">Students</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="classes">Classes</a></li>
					<li class="nav-item"><a class="nav-link" href="viewSubjects">View
							Subjects</a></li>
					<li class="nav-item"><a class="nav-link" href="viewTeachers">View
							Teachers</a></li>
					<li class="nav-item"><a class="nav-link" href="viewStudents">View
							Students</a></li>
					<li class="nav-item"><a class="nav-link" href="viewClasses">View
							Classes</a></li>
					<li class="nav-item"><a class="nav-link" href="logout.jsp">Logout</a>
					</li>
					<%
						}
					%>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<h2 align="center">Please add a new student by entering its name</h2>
	</div>
	<div class="container">
		<%
			String error = (String) request.getAttribute("error");
			String name = (String) request.getAttribute("name");
			if (name == null)
				name = "";
			if (error != null) {
		%>
		<div class="error"><%=error%></div>
		<%
			}
		%>
		<form action="students" method="post">

			<div class="row">
				<div class="col-lg-6 col-lg-offset-3">
					<div class="form-group">
						<label for="name">Student Name:*</label> <input type="text"
							class="form-control" id="studentName" placeholder="Enter Name"
							name="name" value=<%=name%>>
					</div>
					<div align="center">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>
				</div>
			</div>
		</form>
	</div>

</body>
</html>