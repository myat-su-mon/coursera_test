<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>User List</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<main id="main">

		<section class="breadcrumbs">
			<div class="container">
				<div class="d-flex justify-content-between align-items-center">
					<h2>Search By User ID</h2>
					<form class="form-inline" method="post" action="searchuser">
						<input type="text" class="form-control" name="uid" /> &nbsp;
						&nbsp;
						<button type="submit"
							class="btn btn-outline-info animate__animated animate__fadeInUp">
							<i class="fa fa-search" aria-hidden="true">&nbsp;Search</i>
						</button>
						&nbsp; &nbsp;
						<button type="reset"
							class="btn btn-outline-info animate__animated animate__fadeInUp">
							<i class="fa fa-times" aria-hidden="true">&nbsp;Cancel</i>
						</button>
					</form>
				</div>
			</div>
		</section>

		<section class="facts section-bg">
			<div class="container">

				<div class="row counters">

					<div class="col-lg-3 col-6">
						<span data-toggle="counter-up">${userlist.size()}</span>
						<p>Users</p>
					</div>

					<div class="col-lg-3 col-6 text-center">
						<span data-toggle="counter-up">10</span>
						<p>Departments</p>
					</div>

				</div>

			</div>
		</section>
		<section class="about" data-aos="fade-up">
			<div class="container">

				<div class="row">

					<c:choose>
						<c:when test="${userlist==null}">
							<p>No Users have been registered yet!</p>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${userlist.size()>0}">
									<h3>User List</h3>
									<h5></h5>

									<table class="table table-striped table-responsive-md">
										<thead>
											<tr>
												<th>No</th>
												<th>User ID</th>
												<th>User's Name</th>
												<th>Rank</th>
												<th>Department</th>
												<th>Status</th>
												<th colspan="3">Operation</th>
											</tr>
										</thead>

										<c:forEach var="i" items="${userlist}" varStatus="status">
											<tr>
												<td>${status.index + 1}</td>
												<td>${i.uid}</td>
												<td>${i.uname}</td>
												<td>${i.ranks.des}</td>
												<td>${i.department.des}</td>
												<c:choose>
													<c:when test="${i.status==0}">
														<td>Valid</td>
													</c:when>
													<c:otherwise>
														<td>Invalid</td>
													</c:otherwise>
												</c:choose>
												<td><a href="passreset?uid=${i.uid}">Password
														Reset</a></td>
											</tr>
										</c:forEach>
									</table>

								</c:when>
								<c:otherwise>
					No Student found!
				</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>

				</div>

			</div>
		</section>
	</main>
	<%@include file="footer.jsp"%>
</body>
</html>