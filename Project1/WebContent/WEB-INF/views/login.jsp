<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
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
							<h5 class="card-title text-center">Login</h5>
							<form class="form-signin" action="login" method="post">
								<div class="form-label-group">
									<input type="text" id="uid" class="form-control"
										placeholder="Email address" required autofocus name="uid"> <label
										for="uid">User ID</label>
								</div>

								<div class="form-label-group">
									<input type="password" id="password" class="form-control"
										placeholder="Password" required name="password"> <label
										for="password">Password</label>
								</div>

								<div class="custom-control custom-checkbox mb-3">
									<input type="checkbox" class="custom-control-input"
										id="customCheck1"> <label class="custom-control-label"
										for="customCheck1">Remember password</label>
								</div>
								<button class="btn btn-block text-uppercase" type="submit">Login</button>
								<hr class="my-4">
								<p>
									Forget Password? <i><a href="">Click Here</a></i>
								</p>
								<hr class="my-4">
								<p>${message}</p>
								<p> ${sessionScope.loginUser.uid}  ${sessionScope.loginUser.status}</p>
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