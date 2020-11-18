<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>Password Reset</title>
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
							<h5 class="card-title text-center">Password Reset</h5>
							<form class="form-signin" action="passreset" method="post">
								<div class="form-label-group">
									<input type="text" id="uid" class="form-control"
										placeholder="User ID" name="uid" value="${user.viewUid}"
										required /> <label for="uid">User ID</label>
								</div>
								<div class="form-label-group">
									<input type="text" id="uname" class="form-control"
										placeholder="User Name" disabled="disabled"
										value="${user.viewUname}" /> <label for="uname">User
										Name</label>
								</div>

								<div class="form-label-group">
									<input type="text" id="rank" class="form-control"
										placeholder="Rank" disabled="disabled"
										value="${user.viewUrankDes}" /> <label for="rank">Rank</label>
								</div>

								<div class="form-label-group">
									<input type="text" id="dept" class="form-control"
										placeholder="Department" disabled="disabled"
										value="${user.viewUdept}" /> <label for="dept">Department</label>
								</div>

								<div class="form-label-group">
									<input type="text" id="status" class="form-control"
										placeholder="Status" disabled="disabled"
										value="${user.viewUstatus}" /> <label for="dept">Status</label>
								</div>

								<div class="form-label-group">
									<input type="text" id="passgen" class="form-control"
										placeholder="Generated Password" required name="pass"
										value="${user.viewUpass}" /> <label for="passgen">Generated
										Password</label>
								</div>

								<button class="btn btn-block text-uppercase" type="submit">Password
									Reset</button>
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