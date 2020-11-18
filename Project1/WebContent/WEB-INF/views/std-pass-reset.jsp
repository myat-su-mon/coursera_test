<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>Student Password Reset</title>
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
							<h5 class="card-title text-center">Password Reset for
								Student</h5>
								<c:forEach var="i" items="${stdList}" varStatus="status">
							<form class="form-signin" action="stdpassr" method="post">
								<div class="form-label-group">
									<input type="text" id="uid" class="form-control"
										placeholder="Student ID" name="uid" value="${i.frmSUid}" required /> 
										<label for="uid">Student ID</label>
								</div>

								<div class="form-label-group">
									<input type="text" id="name" class="form-control"
										placeholder="Student Name" required name="uname" value="${i.frmStudentNamee}" /> 
										<label for="name">Student Name</label>
								</div>

								<div class="form-label-group">
									<input type="email" id="email" class="form-control"
										placeholder="Email" required name="email" value="${i.frmStudentEmail}"/>
										 <label for="email">Student Email</label>
								</div>

								<div class="form-label-group">
									<input type="text" id="passgen" class="form-control"
										placeholder="Password Generate" required name="key" value="${i.frmKey}"/> 
										<label for="passgen">Password Generate</label>
								</div>
								<button class="btn btn-block text-uppercase" type="submit">Password
									Reset[Student]</button>
								<hr class="my-4">
								<p>${m}</p>
							</form>
							</c:forEach>
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