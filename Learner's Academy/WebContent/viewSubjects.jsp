<%@page import="entities.Subject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<%
		List<Subject> subjects = (List<Subject>) request.getAttribute("subjects");
	%>
	<div class="container">
		<%
			String subjectName = (String) request.getAttribute("subject");
		%>
		<table class="table">
			<tr>
				<th>Id</th>
				<th>Name</th>
			</tr>
			<c:forEach var="subject" items="${subjects}">
				<tr>
					<td>${ subject.id}</td>
					<td>${ subject.name}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>