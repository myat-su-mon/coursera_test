<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Exam Timetable</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<section class="about" data-aos="fade-up">
		<div class="container">
			<table class="table table-responsive-md">
				<thead>
					<tr>
						<th>Date</th>
						<th>Time</th>
						<th>Subject Code</th>
						<th>Subject Name</th>
						<th>Exam Type</th>
					</tr>
				</thead>

				<c:forEach var="i" items="${timetables}" varStatus="status">
					<tr>
						<td>${i.viewDate}</td>
						<td>${i.viewStartTime} - ${i.viewEndTime}</td>
						<td>${i.viewSubCode}</td>
						<td>${i.viewSubName}</td>
						<td>${i.viewExamType}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</section>
	<%@include file="footer.jsp"%>
</body>
</html>