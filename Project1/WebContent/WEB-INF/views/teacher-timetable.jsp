<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Teacher Timetable</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<section class="about" data-aos="fade-up">
		<div class="container">
			<div class="row">

				<c:if test="${teacher=='list'}">
					<h3>Timetable of Teachers</h3>
					<table class="table table-responsive-md">
						<thead>
							<tr>
								<th>Department Name</th>
								<th>Teachers</th>
							</tr>
						</thead>

						<tr>
							<td rowspan="${dept2.size()+1}">Language [Myanmar]</td>
							<c:forEach var="i" items="${dept2}">
								<tr>
									<td><a href="teachertimetable?uid=${i.viewUid}">${i.viewUname}&nbsp;(${i.viewUid})</a></td>
								</tr>
							</c:forEach>

							<td rowspan="${dept3.size()+1}">Language [English]</td>
							<c:forEach var="i" items="${dept3}">
								<tr>
									<td><a href="teachertimetable?uid=${i.viewUid}">${i.viewUname}&nbsp;(${i.viewUid})</a></td>
								</tr>
							</c:forEach>

							<td rowspan="${dept4.size()+1}">Natural Science [Physics]</td>
							<c:forEach var="i" items="${dept4}">
								<tr>
									<td><a href="teachertimetable?uid=${i.viewUid}">${i.viewUname}&nbsp;(${i.viewUid})</a></td>
								</tr>
							</c:forEach>

							<td rowspan="${dept5.size()+1}">Faculty of Computing</td>
							<c:forEach var="i" items="${dept5}">
								<tr>
									<td><a href="teachertimetable?uid=${i.viewUid}">${i.viewUname}&nbsp;(${i.viewUid})</a></td>
								</tr>
							</c:forEach>

							<td rowspan="${dept6.size()+1}">Faculty of Computer Science</td>
							<c:forEach var="i" items="${dept6}">
								<tr>
									<td><a href="teachertimetable?uid=${i.viewUid}">${i.viewUname}&nbsp;(${i.viewUid})</a></td>
								</tr>
							</c:forEach>

							<td rowspan="${dept7.size()+1}">Faculty of Information
								Science</td>
							<c:forEach var="i" items="${dept7}">
								<tr>
									<td><a href="teachertimetable?uid=${i.viewUid}">${i.viewUname}&nbsp;(${i.viewUid})</a></td>
								</tr>
							</c:forEach>

							<td rowspan="${dept8.size()+1}">Faculty of Computer System
								and Technology</td>
							<c:forEach var="i" items="${dept8}">
								<tr>
									<td><a href="teachertimetable?uid=${i.viewUid}">${i.viewUname}&nbsp;(${i.viewUid})</a></td>
								</tr>
							</c:forEach>

							<td rowspan="${dept9.size()+1}">Faculty of IT Support and
								Maintenance</td>
							<c:forEach var="i" items="${dept9}">
								<tr>
									<td><a href="teachertimetable?uid=${i.viewUid}">${i.viewUname}&nbsp;(${i.viewUid})</a></td>
								</tr>
							</c:forEach>
						</tr>
					</table>
				</c:if>

				<c:if test="${teacher=='timetable'}">
					<h3>Timetable of ${timetables[0].viewUname}</h3>
					<table class="table table-responsive-md">
						<thead>
							<tr>
								<th>Day</th>
								<th>Period</th>
								<th>Start Time</th>
								<th>End Time</th>
								<th>Subject</th>
								<th>Section</th>
							</tr>
						</thead>

						<c:if test="${mon>=1}">
							<tr>
								<td rowspan="${mon+1}">Monday</td>
								<c:forEach var="i" items="${timetables}" varStatus="status">
									<c:if test="${i.viewDay=='2'}">
										<tr>
											<td>${i.viewPeriod}</td>
											<td>${i.viewStartTime}</td>
											<td>${i.viewEndTime}</td>
											<td>${i.viewSubCode}</td>
											<td>Section - ${i.viewSection}</td>
										<tr>
									</c:if>
								</c:forEach>
							</tr>
						</c:if>
						<c:if test="${tue>=1}">
							<tr>
								<td rowspan="${tue+1}">Tuesday</td>
								<c:forEach var="i" items="${timetables}" varStatus="status">
									<c:if test="${i.viewDay=='3'}">
										<tr>
											<td>${i.viewPeriod}</td>
											<td>${i.viewStartTime}</td>
											<td>${i.viewEndTime}</td>
											<td>${i.viewSubCode}</td>
											<td>Section - ${i.viewSection}</td>
										</tr>
									</c:if>
								</c:forEach>
							</tr>
						</c:if>
						<c:if test="${wed>=1}">
							<tr>
								<td rowspan="${wed+1}">Wednesday</td>
								<c:forEach var="i" items="${timetables}" varStatus="status">
									<c:if test="${i.viewDay=='4'}">
										<tr>
											<td>${i.viewPeriod}</td>
											<td>${i.viewStartTime}</td>
											<td>${i.viewEndTime}</td>
											<td>${i.viewSubCode}</td>
											<td>Section - ${i.viewSection}</td>
										</tr>
									</c:if>
								</c:forEach>
							</tr>
						</c:if>
						<c:if test="${thur>=1}">
							<tr>
								<td rowspan="${thur+1}">Thursday</td>
								<c:forEach var="i" items="${timetables}" varStatus="status">
									<c:if test="${i.viewDay=='5'}">
										<tr>
											<td>${i.viewPeriod}</td>
											<td>${i.viewStartTime}</td>
											<td>${i.viewEndTime}</td>
											<td>${i.viewSubCode}</td>
											<td>Section - ${i.viewSection}</td>
										</tr>
									</c:if>
								</c:forEach>
							</tr>
						</c:if>
						<c:if test="${fri>=1}">
							<tr>
								<td rowspan="${fri+1}">Friday</td>
								<c:forEach var="i" items="${timetables}" varStatus="status">
									<c:if test="${i.viewDay=='6'}">
										<tr>
											<td>${i.viewPeriod}</td>
											<td>${i.viewStartTime}</td>
											<td>${i.viewEndTime}</td>
											<td>${i.viewSubCode}</td>
											<td>Section - ${i.viewSection}</td>
										</tr>
									</c:if>
								</c:forEach>
							</tr>
						</c:if>

					</table>
				</c:if>

			</div>
		</div>
	</section>
	<%@include file="footer.jsp"%>
</body>
</html>