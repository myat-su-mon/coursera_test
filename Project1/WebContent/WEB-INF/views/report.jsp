<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>Contact Us</title>
<meta content="" name="descriptison">
<meta content="" name="keywords">
<body>
	<%@include file="header.jsp"%>

	<main id="main">

		<c:choose>
			<c:when test="${sessionScope.sesRank!='Student'}">
				<c:choose>
					<c:when test="${report=='view'}">
						<section class="breadcrumbs">
							<div class="container">
								<div class="d-flex justify-content-between align-items-center">
									<h3>Report List</h3>
									<form class="form-inline" action="searchreport" method="post">
										<label><input type="radio" name="stat" value="1">&nbsp;
											Unread &nbsp;</label> <label><input type="radio" name="stat"
											value="0">&nbsp; Read &nbsp;</label> &nbsp;
										<button type="submit"
											class="btn btn-outline-info animate__animated animate__fadeInUp">
											<i class="fa fa-search" aria-hidden="true">&nbsp;Search</i>
										</button>
										&nbsp; &nbsp;
									</form>
								</div>
							</div>
						</section>

						<section class="about" data-aos="fade-up">
							<div class="container">

								<div class="row">
									<c:choose>
										<c:when test="${rList==null}">
														No Unread Report to Read Currently!
												</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${repstat=='1'}">
													<table class="table table-striped table-responsive-md">
														<thead>
															<tr>
																<th>No</th>
																<th>Email</th>
																<th>Report</th>
																<th>Status</th>
																<th>Operation</th>
															</tr>
														</thead>

														<c:forEach var="i" items="${rList}" varStatus="status">
															<tr>
																<td>${status.index + 1}</td>
																<td>${i.email}</td>
																<td>${i.report}</td>
																<c:choose>
																	<c:when test="${i.status==1}">
																		<td>Unread</td>
																	</c:when>
																	<c:otherwise>
																		<td>Read</td>
																	</c:otherwise>
																</c:choose>
																<c:choose>
																	<c:when test="${i.status==1}">
																		<td><a
																			href="reportstat?email=${i.email}&&stat=${i.status}&&rep=${i.report}">Email</a></td>
																	</c:when>
																	<c:otherwise>
																		<td><a
																			href="reportstat?email=${i.email}&&stat=${i.status}&&rep=${i.report}">ReEmail</a></td>
																	</c:otherwise>
																</c:choose>
															</tr>
														</c:forEach>
													</table>
												</c:when>
												<c:otherwise>
													<c:choose>
														<c:when test="${repstat=='0'}">
															<table class="table table-striped table-responsive-md">
																<thead>
																	<tr>
																		<th>No</th>
																		<th>Email</th>
																		<th>Report</th>
																		<th>Status</th>
																		<th>Subject</th>
																		<th>Reply</th>
																	</tr>
																</thead>

																<c:forEach var="i" items="${rList}" varStatus="status">
																	<tr>
																		<td>${status.index + 1}</td>
																		<td>${i.email}</td>
																		<td>${i.report}</td>
																		<c:choose>
																			<c:when test="${i.status==1}">
																				<td>Unread</td>
																			</c:when>
																			<c:otherwise>
																				<td>Read</td>
																			</c:otherwise>
																		</c:choose>
																		<td>${i.subject}</td>
																		<td>${i.reply}</td>
																	</tr>
																</c:forEach>
															</table>
														</c:when>
													</c:choose>
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</section>

					</c:when>
				</c:choose>
			</c:when>
		</c:choose>

	</main>
	<!-- End #main -->

	<%@include file="footer.jsp"%>
</body>
</html>