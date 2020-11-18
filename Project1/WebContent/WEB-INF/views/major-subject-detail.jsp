<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Major Subject Detail</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<main id="main">

		<section class="about" data-aos="fade-up">
			<div class="container">
				<table class="table table-striped table-responsive-md">
					<tr>
						<th>Subject Code</th>
						<td>${majorsub.subcode}</td>
					</tr>
					<tr>
						<th>Subject Name</th>
						<td>${majorsub.subname}</td>
					</tr>
					<tr>
						<th>Subject Category</th>
						<td>${categories}</td>
					</tr>
					<tr>
						<th>Semester</th>
						<td>${majorsub.semester}</td>
					</tr>
					<tr>
						<th>Credit</th>
						<td>${majorsub.credit}</td>
					</tr>
					<tr>
						<th>Pre-Requisite</th>
						<td>${majorsub.prereq}</td>
					</tr>
					<tr>
						<th>Department Offered</th>
						<td>${majorsub.department.des}</td>
					</tr>
					<tr>
						<th>Semester Limit</th>
						<td>${majorsub.semesterlimit}</td>
					</tr>
					<tr>
						<th>Purpose</th>
						<td>${majorsub.purpose}</td>
					</tr>
					<tr>
						<th>Description</th>
						<td>${majorsub.descrip}</td>
					</tr>
					<tr>
						<th>Subject Outlines</th>
						<td>${majorsub.outline}</td>
					</tr>
					<tr>
						<th>Reference Books</th>
						<td>${majorsub.refbook}</td>
					</tr>
					<tr>
						<th>Status</th>
						<c:if test="${majorsub.status==0}"><td>Valid</td>
						</c:if>
						<c:if test="${majorsub.status==1}"><td>Invalid</td>
						</c:if>
					</tr>
				</table>
			</div>
		</section>
	</main>
	<%@include file="footer.jsp"%>
</body>
</html>