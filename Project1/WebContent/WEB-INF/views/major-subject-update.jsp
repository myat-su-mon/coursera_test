<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Major Subject Update</title>
<style type="text/css">
#spacing {
	margin-top: 10px;
	margin-bottom: 10px;
}

#btn-update {
	display: none;
  color: #fff;
  background: #18d26e;
  text-align: center;
  padding: 15px;
  font-weight: 600;
}
</style>
</head>
<body>
	<%@include file="header.jsp"%>
	<main id="main">
		<section class="about" data-aos="fade-up">
			<div class="container">
				<form:form action="majorsubupdate" method="post"
					modelAttribute="majorsub">
					<h4 align="center">Update Major Subject</h4>
					<div class="row">
						<div class="col-lg-6">
							<table>
								<tr>
									<td>Sub Code</td>
									<td><form:input type="text" class="form-control"
											id="spacing" path="subcode"/></td>
								</tr>
								<tr>
									<td>Sub Name</td>
									<td><form:input type="text" class="form-control"
											id="spacing" path="subname" /></td>
								</tr>
								<tr>
									<td>Semester</td>
									<td><form:select class="form-control" id="spacing"
											path="semester">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">Both</option>
										</form:select></td>
								</tr>
								<tr>
									<td>Credit</td>
									<td><form:select class="form-control" id="spacing"
											path="credit">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
										</form:select></td>
								</tr>
								<tr>
									<td>Department</td>
									<td><form:select class="form-control" id="spacing"
											path="department">
											<option value="1" label="Admin" />
											<option value="2" label="Language [Myanmar]" />
											<option value="3" label="Language [English]" />
											<option value="4" label="Natural Science [Physics]" />
											<option value="5" label="Faculty of Computing" />
											<option value="6"
												label="Faculty of Computer Science" />
											<option value="7"
												label="Faculty of Information Science" />
											<option value="8"
												label="Faculty of Computer System and Technology" />
											<option value="9"
												label="Faculty of IT Support and Maintenance" />
											<option value="10" label="Student Affairs" />
										</form:select></td>
								</tr>
								<tr>
									<td>For CS (BIS)</td>
									<td><form:select class="form-control" id="spacing"
											path="bis">
											<option value="0">Major - Core</option>
											<option value="1">Major - Elective</option>
											<option value="2">None</option>
										</form:select></td>
								</tr>
								<tr>
									<td>For CS (CSF)</td>
									<td><form:select class="form-control" id="spacing"
											path="csf">
											<option value="0">Major - Core</option>
											<option value="1">Major - Elective</option>
											<option value="2">None</option>
										</form:select></td>
								</tr>
								<tr>
									<td>For CS (KE)</td>
									<td><form:select class="form-control" id="spacing"
											path="ke">
											<option value="0">Major - Core</option>
											<option value="1">Major - Elective</option>
											<option value="2">None</option>
										</form:select></td>
								</tr>
								<tr>
									<td>For CS (SE)</td>
									<td><form:select class="form-control" id="spacing"
											path="se">
											<option value="0">Major - Core</option>
											<option value="1">Major - Elective</option>
											<option value="2">None</option>
										</form:select></td>
								</tr>
								<tr>
									<td>For CT (Networking)</td>
									<td><form:select class="form-control" id="spacing"
											path="nt">
											<option value="0">Major - Core</option>
											<option value="1">Major - Elective</option>
											<option value="2">None</option>
										</form:select></td>
								</tr>
								<tr>
									<td>For CT (Embedded)</td>
									<td><form:select class="form-control" id="spacing"
											path="emb">
											<option value="0">Major - Core</option>
											<option value="1">Major - Elective</option>
											<option value="2">None</option>
										</form:select></td>
								</tr>
								<tr>
									<td>Status</td>
									<td><form:select class="form-control" id="spacing"
											path="status">
											<option value="0">Valid</option>
											<option value="1">Invalid</option>
										</form:select></td>
								</tr>
								<tr>
									<td>Semester Limit</td>
									<td><form:select class="form-control" id="spacing"
											path="semesterlimit">
											<option value="0">0</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
											<option value="11">11</option>
											<option value="12">12</option>
											<option value="13">13</option>
											<option value="14">14</option>
											<option value="15">15</option>
											<option value="16">16</option>
											<option value="17">17</option>
											<option value="18">18</option>
											<option value="19">19</option>
										</form:select></td>
								</tr>
							</table>
						</div>

						<div class="col-lg-6">
							<table>
								<tr>
									<td>Purpose</td>
									<td colspan="2"><form:textarea class="form-control"
											id="spacing" path="purpose"></form:textarea></td>
								</tr>
								<tr>
									<td>Description</td>
									<td colspan="2"><form:textarea class="form-control"
											id="spacing" path="descrip"></form:textarea>
								</tr>
								<tr>
									<td>Outline</td>
									<td colspan="2"><form:textarea class="form-control"
											id="spacing" path="outline"></form:textarea>
								</tr>
								<tr>
									<td>Reference Books</td>
									<td colspan="2"><form:textarea class="form-control"
											id="spacing" path="refbook"></form:textarea>
								</tr>
							</table>
						</div>
					</div>

					<hr>

					<h5 align="center">Pre-requisites [Semester-Credit]</h5>

					<div class="row">

						<div class="col-lg-6">
							<div class="row">

								<div class="col-md-6">
									<h6 align="center">Core- Foundation [18]</h6>
									<table class="table table-striped table-responsive-md">
										<c:forEach var="f" items="${foundation}">
											<tr id="spacing">
												<td>
													<%-- <input type="checkbox" class="form-check-input"
												name="chkcore">${f.viewSubCode} [${f.viewSemester}
												- ${f.viewCredit}] --%> <form:checkbox path="prereq"
														value="${f.subcode}" /> ${f.subcode}
													[${f.semester} - ${f.credit}]
												</td>
											</tr>
										</c:forEach>
									</table>
								</div>

								<div class="col-md-6">
									<h6 align="center">Core- Skill and Knowledge [18]</h6>
									<table class="table table-striped table-responsive-md">
										<c:forEach var="k" items="${knowledge}">
											<tr>
												<td>
													<%-- <input type="checkbox" class="form-check-input"
												name="chkcore">${k.viewSubCode} [${k.viewSemester}
												- ${k.viewCredit}] --%> <form:checkbox path="prereq"
														value="${k.subcode}" /> ${k.subcode}
													[${k.semester} - ${k.credit}]
												</td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>
						</div>


						<div class="col-lg-6">
							<div class="row">

								<div class="col-md-6">
									<h6 align="center">Core- National and International
										Perspectives [6]</h6>
									<table class="table table-striped table-responsive-md">
										<c:forEach var="p" items="${perspectives}">
											<tr>
												<td><form:checkbox path="prereq"
														value="${p.subcode}" /> ${p.subcode}
													[${p.semester} - ${p.credit}]</td>
											</tr>
										</c:forEach>
									</table>
								</div>

								<div class="col-md-6">
									<h6 align="center">Core- Supporting Skills [10]</h6>
									<table class="table table-striped table-responsive-md">
										<c:forEach var="s" items="${supporting}">
											<tr>
												<td><form:checkbox path="prereq"
														value="${s.subcode}" /> ${s.subcode}
													[${s.semester} - ${s.credit}]</td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>
						</div>
					</div>

					<hr>

					<h5 align="center">Pre-requisites Major Subjects
						[Semester-Credit]</h5>

					<div class="row">

						<div class="col-lg-6">
							<div class="row">
								<div class="col-md-6">
									<table class="table table-striped table-responsive-md">
										<c:forEach var="i" items="${majorsubjects}" varStatus="status">
											<c:if test="${(status.index>=0) and (status.index<15)}">
												<tr>
													<td><form:checkbox path="prereq"
															value="${i.subcode}" /> ${i.subcode}
														[${i.semester} - ${i.credit}]</td>
												</tr>
											</c:if>
										</c:forEach>
									</table>
								</div>

								<div class="col-md-6">
									<table class="table table-striped table-responsive-md">
										<c:forEach var="i" items="${majorsubjects}" varStatus="status">
											<c:if test="${(status.index>=15) and (status.index<30)}">
												<tr>
													<td><form:checkbox path="prereq"
															value="${i.subcode}" /> ${i.subcode}
														[${i.semester} - ${i.credit}]</td>
												</tr>
											</c:if>
										</c:forEach>
									</table>
								</div>
							</div>
						</div>


						<div class="col-lg-6">
							<div class="row">

								<div class="col-md-6">
									<table class="table table-striped table-responsive-md">
										<c:forEach var="i" items="${majorsubjects}" varStatus="status">
											<c:if test="${(status.index>=30) and (status.index<45)}">
												<tr>
													<td><form:checkbox path="prereq"
															value="${i.subcode}" /> ${i.subcode}
														[${i.semester} - ${i.credit}]</td>
												</tr>
											</c:if>
										</c:forEach>
									</table>
								</div>

								<div class="col-md-6">
									<table class="table table-striped table-responsive-md">
										<c:forEach var="i" items="${majorsubjects}" varStatus="status">
											<c:if test="${(status.index>=45) and (status.index<60)}">
												<tr>
													<td><form:checkbox path="prereq"
															value="${i.subcode}" /> ${i.subcode}
														[${i.semester} - ${i.credit}]</td>
												</tr>
											</c:if>
										</c:forEach>
									</table>
								</div>
							</div>
						</div>
					</div>
					<hr>
					<h5>${message}</h5>

					<div class="text-center">
						<button class="btn-update" type="submit">Update Major Subject</button>
					</div>
				</form:form>
			</div>
		</section>
	</main>
	<%@include file="footer.jsp"%>
</body>
</html>