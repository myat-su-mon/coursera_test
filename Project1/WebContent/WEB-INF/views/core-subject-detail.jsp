<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Core Subject Detail</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<main id="main">

		<section class="about" data-aos="fade-up">
			<div class="container">
			<h5>${message}</h5>
				<table class="table table-striped table-responsive-md">
					<tr>
						<th>Subject Code</th>
						<td>${coresub.subcode}</td>
					</tr>
					<tr>
						<th>Subject Name</th>
						<td>${coresub.subname}</td>
					</tr>
					<tr>
						<th>Subject Category</th>
						<td>${coresub.subcategory.des}</td>
					</tr>
					<tr>
						<th>Semester</th>
						<td>${coresub.semester}</td>
					</tr>
					<tr>
						<th>Credit</th>
						<td>${coresub.credit}</td>
					</tr>
					<tr>
						<th>Pre-Requisite</th>
						<td>${coresub.prereq}</td>
					</tr>
					<tr>
						<th>Department Offered</th>
						<td>${coresub.department.des}</td>
					</tr>
					<tr>
						<th>Semester Limit</th>
						<td>${coresub.semesterlimit}</td>
					</tr>
					<tr>
						<th>Purpose</th>
						<td>${coresub.purpose}</td>
					</tr>
					<tr>
						<th>Description</th>
						<td>${coresub.descrip}</td>
					</tr>
					<tr>
						<th>Subject Outlines</th>
						<td>${coresub.outline}</td>
					</tr>
					<tr>
						<th>Reference Books</th>
						<td>${coresub.refbook}</td>
					</tr>
					<tr>
						<th>Status</th>
						<c:if test="${coresub.status==0}"><td>Valid</td>
						</c:if>
						<c:if test="${coresub.status==1}"><td>Invalid</td>
						</c:if>
					</tr>
				</table>
			</div>
		</section>
	</main>
	<%@include file="footer.jsp"%>
</body>
</html>