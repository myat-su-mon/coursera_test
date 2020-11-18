<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Login Record</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<main id="main">
		<section class="breadcrumbs">
			<div class="container">
				<div class="d-flex justify-content-between align-items-center">
					<h2>Login List</h2>
				</div>
			</div>
		</section>

		<section class="about" data-aos="fade-up">
			<div class="container">

				<div class="row">

					<c:choose>
						<c:when test="${false}">
							<p>No Students have been registered yet!</p>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${true}">
									<table class="table table-striped table-responsive-md">
										<thead>
											<tr>
												<th>No</th>
												<th>Login ID</th>
												<th>User ID</th>
												<th>Entrance Date</th>
												<th>Entrance Time</th>
												<th>Exit Date</th>
												<th>Exit Time</th>
											</tr>
										</thead>

										<c:forEach var="i" items="${loginlist}" varStatus="status">
											<tr>
												<td>${status.index + 1}</td>
												<td>${i.loginid}</td>
												<td>${i.uid}</td>
												<td>${i.entdate}</td>
												<td>${i.enttime}</td>
												<td>${i.extdate}</td>
												<td>${i.exttime}</td>
											</tr>
										</c:forEach>
									</table>

								</c:when>
								<c:otherwise>
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