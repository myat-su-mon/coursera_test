<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Query By Major Subject</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<main id="main">
		<section class="breadcrumbs">
			<div class="container">
				<div class="d-flex justify-content-between align-items-center">
					<h2>Search By Major Subject</h2>
					<form class="form-inline" method="post" action="majorsub">
						Major Subject: &nbsp; <select class="form-control" name="major">
							<option value="CS-101">CS-101</option>
							<option value="CS-201">CS-201</option>
							<option value="CS-202">CS-202</option>
							<option value="CS-301">CS-301</option>
							<option value="CS-302">CS-302</option>
							<option value="CS-401">CS-401</option>
							<option value="CS-411">CS-411</option>
							<option value="CS-501">CS-501</option>
							<option value="CS-511">CS-511</option>
							<option value="CS-601">CS-601</option>
							<option value="CS-801">CS-801</option>
							<option value="CM-103">CM-103</option>
							<option value="CM-104">CM-104</option>
							<option value="CM-301">CM-301</option>
							<option value="CM-401">CM-401</option>
							<option value="CM-402">CM-402</option>
							<option value="CM-403">CM-403</option>
							<option value="CM-501">CM-501</option>
							<option value="CM-502">CM-502</option>
							<option value="CM-503">CM-503</option>
							<option value="CM-504">CM-504</option>
							<option value="CM-505">CM-505</option>
							<option value="CM-601">CM-601</option>
							<option value="CST-101">CST-101</option>
							<option value="CST-102">CST-102</option>
							<option value="CST-201">CST-201</option>
							<option value="CST-202">CST-202</option>
							<option value="CST-301">CST-301</option>
							<option value="CST-401">CST-401</option>
							<option value="CST-402">CST-402</option>
							<option value="CST-403">CST-403</option>
							<option value="CST-501">CST-501</option>
							<option value="CST-501E">CST-501E</option>
							<option value="CST-502E">CST-502E</option>
							<option value="CST-503">CST-503</option>
							<option value="CST-503E">CST-503E</option>
							<option value="CST-504">CST-504</option>
							<option value="CST-504E">CST-504E</option>
							<option value="CST-601">CST-601</option>
							<option value="Ele-1">Ele-1</option>
							<option value="Ele-4">Ele-4</option>
							<option value="IS-101">IS-101</option>
							<option value="IS-102">IS-102</option>
							<option value="IS-103">IS-103</option>
							<option value="IS-105">IS-105</option>
							<option value="IS-111">IS-111</option>
							<option value="IS-201">IS-201</option>
							<option value="IS-202">IS-202</option>
							<option value="IS-204">IS-204</option>
							<option value="IS-311">IS-311</option>
							<option value="IS-402">IS-402</option>
							<option value="IS-403">IS-403</option>
							<option value="IS-404">IS-404</option>
							<option value="IS-411">IS-411</option>
							<option value="IS-412">IS-412</option>
							<option value="IS-413">IS-413</option>
							<option value="IS-421">IS-421</option>
							<option value="IS-422">IS-422</option>
							<option value="ITSM-102">ITSM-102</option>
							<option value="ITSM-103">ITSM-103</option>
							<option value="ITSM-201">ITSM-201</option>
							<option value="ITSM-301">ITSM-301</option>
							<option value="ITSM-302">ITSM-302</option>
							<option value="ITSM-303">ITSM-303</option>
							<option value="ITSM-401">ITSM-401</option>
						</select> &nbsp; &nbsp;
						<button type="submit"
							class="btn btn-outline-info animate__animated animate__fadeInUp">
							<i class="fa fa-search" aria-hidden="true">&nbsp;Search</i>
						</button>
						&nbsp; &nbsp;
					</form>
				</div>
			</div>
		</section>

		<section class="facts section-bg">
			<div class="container">

				<div class="row counters">

					<div class="col-lg-3 col-6">
						<span data-toggle="counter-up">${stdlist.size()}</span>
						<p>Students</p>
					</div>

					<div class="col-lg-3 col-6 text-center">
						<span data-toggle="counter-up">65</span>
						<p>Major Subject</p>
					</div>

				</div>

			</div>
		</section>

		<section class="about" data-aos="fade-up">
			<div class="container">

				<div class="row">

					<c:choose>
						<c:when test="${stdlist.size()>0}">
							<h3>Student Lists By ${queryby}</h3>

							<table class="table table-striped table-responsive-md">
								<thead>
									<tr>
										<th>No</th>
										<th>Student ID</th>
										<th>Student Name</th>
										<th>Specialized Major</th>
										<th>Major Subject</th>
										<th>Section</th>
										<th>Contact</th>
										<th colspan="2">Operation</th>
									</tr>
								</thead>

								<c:forEach var="i" items="${stdlist}" varStatus="status">
									<tr>
										<td>${status.index + 1}</td>
										<td>${i.viewSId}</td>
										<td>${i.viewNameMyan}</td>
										<td>${i.viewSpecializedMajor}</td>
										<td>${i.viewMajorSubject}</td>
										<td>Section ${i.viewSection}</td>
										<td>Phone- ${i.viewPhone}<br />${i.viewEmail}</td>
										<c:choose>
											<c:when test="${i.viewStatus==0}">
												<td>Valid</td>
												<td><a href="#">Invalidate</a></td>
											</c:when>
											<c:otherwise>
												<td>Invalid</td>
												<td><a href="#">Validate</a></td>
											</c:otherwise>
										</c:choose>
										<td><a href="">Password Reset</a></td>
									</tr>
								</c:forEach>
							</table>

						</c:when>
						<c:otherwise>
					No Student found!
				</c:otherwise>
					</c:choose>

				</div>

			</div>
		</section>
	</main>
	<%@include file="footer.jsp"%>
</body>
</html>