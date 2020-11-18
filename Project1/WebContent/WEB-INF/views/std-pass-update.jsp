<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>Student Password Update</title>
<meta content="" name="descriptison">
<meta content="" name="keywords">
</head>

<body>
	<%@include file="header.jsp"%>

	<main id="main">
		<div class="container">
			<div class="row">
				<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
					<div class="card card-signin my-5">
						<div class="card-body">
							<c:choose>
								<c:when test="${stdList==null}">

								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${stdList.size()>0}">

											<c:forEach var="i" items="${stdList}" varStatus="status">
												<h5>${msg}</h5>
												<h5 class="card-title text-center">Password Change for
													Student</h5>
												<form class="form-signin" action="stdpasschg" method="post">
													<div class="form-label-group">
														<input type="text" id="uid" class="form-control"
															placeholder="User ID" required name="uid"
															value="${i.frmSUid}" /> <label for="uid">Student
															ID</label>
													</div>

													<div class="form-label-group">
														<input type="text" id="name" class="form-control"
															placeholder="Student Name" required name="uname"
															value="${i.frmStudentNamee}" /> <label for="name">Student
															Name</label>
													</div>

													<div class="form-label-group">
														<input type="password" id="currentpassword"
															class="form-control" placeholder="Current Password"
															name="cpass" /> <label for="currentpassword">Current
															Password</label>
													</div>

													<div class="form-label-group">
														<input type="password" id="newpassword"
															class="form-control" placeholder="newpassword" required
															name="npas" /> <label for="newpassword">New
															Password</label>
													</div>

													<div class="form-label-group">
														<input type="password" id="confirmpassword"
															class="form-control" placeholder="confirmpassword"
															required name="npass" /> <label for="confirmpassword">Confirm
															Password</label>
													</div>

													<button class="btn btn-block text-uppercase" type="submit">Password
														Update[Student]</button>
												</form>
												<h3>${m}</h3>
											</c:forEach>
										</c:when>
										<c:otherwise>
					No Student found!
				</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>

						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<!-- End #main -->
	<%@include file="footer.jsp"%>
</body>

</html>