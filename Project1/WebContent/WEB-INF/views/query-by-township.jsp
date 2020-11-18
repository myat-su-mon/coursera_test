<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Query By Township</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<main id="main">
		<section class="breadcrumbs">
			<div class="container">
				<div class="d-flex justify-content-between align-items-center">
					<h2>Search By Township</h2>
					<form class="form-inline" method="post" action="township">
						Township : &nbsp; <select class="form-control" name="township">
							<option value="none"></option>
							<c:forEach var="t" items="${townships}">
							<option value="${t.id}">${t.des}</option>
							</c:forEach>
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
						<span data-toggle="counter-up">${townships.size()}</span>
						<p>Townships</p>
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
										<th>Township</th>
										<th>Contact</th>
										<th>Status</th>
										<th colspan="2">Operation</th>
									</tr>
								</thead>

								<c:forEach var="i" items="${stdlist}" varStatus="status">
									<tr>
										<td>${status.index + 1}</td>
										<td>${i.viewSId}</td>
										<td>${i.viewNameMyan}</td>
										<td>${i.viewSpecializedMajor}</td>
										<td>${i.viewTownshipDes}</td>
										<td>${i.viewPhone}<br>${i.viewEmail}</td>
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