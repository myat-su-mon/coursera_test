<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Query By Core Subject</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<main id="main">
		<section class="breadcrumbs">
			<div class="container">
				<div class="d-flex justify-content-between align-items-center">
					<h2>Search By Core Subject</h2>
					<form class="form-inline" method="post" action="coresub">
						Core Subject: &nbsp; <select class="form-control" name="core">
							<option value=""></option>
							<option value="CM-101">CM-101</option>
							<option value="CM-102">CM-102</option>
							<option value="CM-201">CM-201</option>
							<option value="Eng-101">Eng-101</option>
							<option value="Eng-102">Eng-102</option>
							<option value="Eng-201">Eng-201</option>
							<option value="Eng-202">Eng-202</option>
							<option value="Eng-401">Eng-401</option>
							<option value="IS-302">IS-302</option>
							<option value="IS-401">IS-401</option>
							<option value="ITSM-101">ITSM-101</option>
							<option value="ITSM-501">ITSM-501</option>
							<option value="ITSM-502">ITSM-502</option>
							<option value="Myan-101">Myan-101</option>
							<option value="Myan-102">Myan-102</option>
							<option value="Phys-101">Phys-101</option>
							<option value="Phys-102">Phys-102</option>
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
						<span data-toggle="counter-up">17</span>
						<p>Core Subject</p>
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
										<th>Core Subject</th>
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
										<td>${i.viewCoreSubject}</td>
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