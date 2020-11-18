<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Major Subject List</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<main id="main">

		<section class="about" data-aos="fade-up">
			<div class="container">
				<div class="row">

						<table class="table table-striped table-responsive-md">
							<thead align="center">
								<tr>
									<th colspan="8">${majorname} - Major Courses</th>
								</tr>
								<tr>
									<th colspan="8">Major - Core [70 Credits]</th>
								</tr>
							</thead>
							<thead>
								<tr>
									<th>Sub Code</th>
									<th>Subject Name</th>
									<th>Semester</th>
									<th>Credit</th>
									<th>Pre-requisite</th>
									<th>Department</th>
									<th>Status</th>
									<th>Detail</th>
									<th colspan="2">Operation</th>
								</tr>
							</thead>
							<c:forEach var="i" items="${majorcore}" varStatus="status">
							<tr>
									<td>${i.subcode}</td>
									<td>${i.subname}</td>
									<td>${i.semester}</td>
									<td>${i.credit}</td>
									<td>${i.prereq}</td>
									<td>${i.department.des}</td>
									<td>Valid</td>
									<td><a href="majorsubdetail?subcode=${i.subcode}">Detail</a></td>
									<td><a href="majorsubupdate?subcode=${i.subcode}">Update</a></td>
									<td><a href="majorsubdelete?subcode=${i.subcode}">Delete</a></td>
								</tr>
							</c:forEach>
						</table>
						
						<table class="table table-striped table-responsive-md">
							<thead align="center">
								<tr>
									<th colspan="8">Major - Electives [12 Credits]</th>
								</tr>
							</thead>
							<thead>
								<tr>
									<th>Sub Code</th>
									<th>Subject Name</th>
									<th>Semester</th>
									<th>Credit</th>
									<th>Pre-requisite</th>
									<th>Department</th>
									<th>Status</th>
									<th>Detail</th>
									<th colspan="2">Operation</th>
								</tr>
							</thead>
							<c:forEach var="i" items="${majorelective}" varStatus="status">
							<tr>
									<td>${i.subcode}</td>
									<td>${i.subname}</td>
									<td>${i.semester}</td>
									<td>${i.credit}</td>
									<td>${i.prereq}</td>
									<td>${i.department.des}</td>
									<td>Valid</td>
									<td><a href="majorsubdetail?subcode=${i.subcode}">Detail</a></td>
									<td><a href="majorsubupdate?subcode=${i.subcode}">Update</a></td>
									<td><a href="majorsubdelete?subcode=${i.subcode}">Delete</a></td>
								</tr>
							</c:forEach>
						</table>

				</div>
			</div>
		</section>
	</main>
	<%@include file="footer.jsp"%>

</body>
</html>