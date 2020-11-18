<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Student Timetable</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<section class="about" data-aos="fade-up">
		<div class="container">

			<div class="row">

				<c:choose>
					<c:when test="${false}">
						<p>No Users have been registered yet!</p>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${true}">
								<h3>Time Table of Student</h3>

								<table class="table table-responsive-md">
									<thead>
										<tr>
											<th>Day</th>
											<th>Period</th>
											<th>Start Time</th>
											<th>End Time</th>
											<th>Subject</th>
											<th>Section</th>
											<th>Teacher</th>
										</tr>
									</thead>

									<tr>
										<td rowspan="${mon+1}">Monday</td>
										<c:forEach var="i" items="${timetables}" varStatus="status">
											<c:if test="${i.viewDay=='2'}">
											<tr>
												<td>${i.viewPeriod}</td>
												<td>${i.viewStartTime}</td>
												<td>${i.viewEndTime}</td>
												<td>${i.viewSubCode}</td>
												<td>${i.viewSection}</td>
												<td>${i.viewTeacher}</td>
												<tr>
											</c:if>
										</c:forEach>
									</tr>

									<tr>
										<td rowspan="${tue+1}">Tuesday</td>
										<c:forEach var="i" items="${timetables}" varStatus="status">
											<c:if test="${i.viewDay=='3'}">
												<tr>
													<td>${i.viewPeriod}</td>
													<td>${i.viewStartTime}</td>
													<td>${i.viewEndTime}</td>
													<td>${i.viewSubCode}</td>
													<td>${i.viewSection}</td>
													<td>${i.viewTeacher}</td>
												</tr>
											</c:if>
										</c:forEach>
									</tr>

									<tr>
										<td rowspan="${wed+1}">Wednesday</td>
										<c:forEach var="i" items="${timetables}" varStatus="status">
											<c:if test="${i.viewDay=='4'}">
											<tr>
												<td>${i.viewPeriod}</td>
												<td>${i.viewStartTime}</td>
												<td>${i.viewEndTime}</td>
												<td>${i.viewSubCode}</td>
												<td>${i.viewSection}</td>
												<td>${i.viewTeacher}</td>
												</tr>
											</c:if>
										</c:forEach>
									</tr>

									<tr>
										<td rowspan="${thur+1}">Thursday</td>
										<c:forEach var="i" items="${timetables}" varStatus="status">
											<c:if test="${i.viewDay=='5'}">
											<tr>
												<td>${i.viewPeriod}</td>
												<td>${i.viewStartTime}</td>
												<td>${i.viewEndTime}</td>
												<td>${i.viewSubCode}</td>
												<td>${i.viewSection}</td>
												<td>${i.viewTeacher}</td>
												</tr>
											</c:if>
										</c:forEach>
									</tr>

									<tr>
										<td rowspan="${fri+1}">Friday</td>
										<c:forEach var="i" items="${timetables}" varStatus="status">
											<c:if test="${i.viewDay=='6'}">
											<tr>
												<td>${i.viewPeriod}</td>
												<td>${i.viewStartTime}</td>
												<td>${i.viewEndTime}</td>
												<td>${i.viewSubCode}</td>
												<td>${i.viewSection}</td>
												<td>${i.viewTeacher}</td>
												</tr>
											</c:if>
										</c:forEach>
									</tr>

								</table>

							</c:when>
							<c:otherwise>
					No Timetable Found!
				</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>

			</div>

		</div>
	</section>
	<%@include file="footer.jsp"%>
</body>
</html>