<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
							<h5 class="card-title text-center">Site Status</h5>
							<form:form class="form-signin" action="updatestatus"
								method="post">
								<div class="form-label-group">
									<center>
										<label><input type="radio" name="status" value="ON">
											&nbsp; ON</label>
									</center>
									<hr>
									<center>
										<label><input type="radio" name="status" value="OFF">
											&nbsp; OFF</label>
									</center>
								</div>
								<hr>
								<button class="btn btn-block text-uppercase" type="submit">Submit</button>
								<hr class="my-4">
								<p>${message}</p>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<%@include file="footer.jsp"%>
</body>

</html>