<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>UCSY SIS - Index</title>
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
							<h5 class="card-title text-center">New User</h5>
							<form:form class="form-signin" action="adduser" method="post" modelAttribute="newuser">

								<div class="form-label-group">
									<form:input type="text" id="uid" class="form-control"
										placeholder="User ID" path="uid" /> <label for="uid">User
										ID</label>
								</div>

								<div class="form-label-group">
									<form:input type="text" id="name" class="form-control"
										placeholder="User Name"  path="uname" /> <label for="name">User
										Name</label>
								</div>
								<div class="form-label-group">
									<form:select class="custom-select form-control rounded-pill"
										id="select-height" path="ranks.id">
										<form:option value="1" label="Admin" />
										<form:option value="2" label="Teacher" />
										<form:option value="3" label="Department Head" />
										<form:option value="4" label="Staff" />
										<form:option value="5" label="Student" />
										<form:option value="6" label="Registrator" />
										<form:option value="7" label="Mentor" />
										<form:option value="8" label="Rector" />
									</form:select>
								</div>

								<div class="form-label-group">
									<form:select class="custom-select form-control rounded-pill"
										id="select-height" path="department.id">
										<form:option value="1" label="Admin" />
										<form:option value="2" label="Language [Myanmar]" />
										<form:option value="3" label="Language [English]" />
										<form:option value="4" label="Natural Science [Physics]" />
										<form:option value="5" label="Faculty of Computing" />
										<form:option value="6"
											label="Faculty of Computer Science" />
										<form:option value="7"
											label="Faculty of Information Science" />
										<form:option value="8"
											label="Faculty of Computer System and Technology" />
										<form:option value="9"
											label="Faculty of IT Support and Maintenance" />
										<form:option value="10" label="Student Affairs" />
									</form:select>
								</div>

								<div class="form-label-group">
									<form:input type="text" id="webpage" class="form-control"
										placeholder="Web Page" path="webpage" /> <label for="webpage">Web
										Page</label>
								</div>

								<button class="btn btn-block text-uppercase" type="submit">New
									User</button>
								<hr class="my-4">
								<p>${success}</p>
							</form:form>
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