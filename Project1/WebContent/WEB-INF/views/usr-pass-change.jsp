<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>Password Change</title>
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
							<h5 class="card-title text-center">Password Change</h5>
							<form class="form-signin" action="passchange" method="post">

								<div class="form-label-group">
									<input type="text" id="uid" class="form-control"
										placeholder="User ID" required name="uid" disabled="disabled"
										value="${user.viewUid}" /> <label for="uid">User ID</label>
								</div>

								<div class="form-label-group">
									<input type="text" id="uname" class="form-control"
										placeholder="User Name" disabled="disabled"
										value="${user.viewUname}" /> <label for="uname">User
										Name</label>
								</div>

								<div class="form-label-group">
									<input type="password" id="curpassword" class="form-control"
										placeholder="Current Password" required name="curpass" /> <label
										for="curpassword">Current Password</label>
								</div>

								<div class="form-label-group">
									<input type="password" id="newpassword" class="form-control"
										placeholder="New Password" required name="newpass" /> <label
										for="newpassword">New Password</label>
								</div>

								<div class="form-label-group">
									<input type="password" id="confirmpassword"
										class="form-control" placeholder="Confirm Password" required
										name="confirmpass" /> <label for="confirmpassword">Confirm
										Password</label>
								</div>

								<button class="btn btn-block text-uppercase" type="submit">Password
									Change</button>
								<hr class="my-4">
								<p>${message}</p>
							</form>
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