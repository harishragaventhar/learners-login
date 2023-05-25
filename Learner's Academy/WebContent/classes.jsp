<%@page import="entities.Subject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
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

				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<h2 align="center">Please add a new class by entering its details</h2>
	</div>
	<div class="container">
		<%
			String error = (String) request.getAttribute("error");
			String name = (String) request.getAttribute("name");
			String day = (String) request.getAttribute("day");
			String time = (String) request.getAttribute("time");
			String subjectName = (String) request.getAttribute("subject");
			String teacherName = (String) request.getAttribute("teacher");

			if (name == null)
				name = "";
			if (day == null)
				day = "";
			if (time == null)
				time = "";

			if (error != null) {
		%>
		<div class="error"><%=error%></div>
		<%
			}
		%>
		<form action="classes" method="post">

			<div class="row">
				<div class="col-lg-6 col-lg-offset-3">
					<div class="form-group">
						<label for="name">Name:*</label> <input type="text"
							class="form-control" id="className" placeholder="Enter name"
							name="name" value=<%=name%>>
					</div>
					<br>

					<div class="form-group">
						<label for="name">Day:*</label> <input type="text"
							class="form-control" id="classDay" placeholder="Enter day"
							name="day" value=<%=day%>>
					</div>
					<br>

					<div class="form-group">
						<label for="name">Time:*</label> <input type="text"
							class="form-control" id="classTime" placeholder="Enter time"
							name="time" value=<%=time%>>
					</div>
					<br>

					<div class="drop-down">
						<label for="name">Subject:</label><br> <select name="subject"
							class="drop-down" id="subject" name="subjectName">
							<c:forEach items="${requestScope.subjects}" var="subject">
								<option>${subject.name}</option>
								<font></font>
							</c:forEach>
						</select>
					</div>
					<br>

					<div class="drop-down">
						<label for="name">Teacher:</label><br> <select name="teacher"
							class="drop-down" id="teacher" name="teacherName">
							<c:forEach items="${requestScope.teachers}" var="teacher">
								<option>${teacher.name}</option>
								<font></font>
							</c:forEach>
						</select>
					</div>
					<br>

					<div class="drop-down">
						<label for="name">Student:</label><br> <select name="student"
							class="drop-down" id="student" name="studentName">
							<c:forEach items="${requestScope.students}" var="student">
								<option>${student.name}</option>
								<font></font>
							</c:forEach>
						</select>
					</div>
					<br>

					<div align="center">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>
				</div>
			</div>
		</form>
	</div>


	<!--  <div class="container">
	<table class="table">
		<tr>
			<th>Id</th>
			<th>Name</th>
		</tr>
		<c:forEach var="subject" items="${requestScope.subjects}">
			<tr>
				<td>${ subject.id}</td>
				<td>${ subject.name}</td>
			</tr>
		</c:forEach>
	</table>
	</div> -->



	}

</body>
</html>