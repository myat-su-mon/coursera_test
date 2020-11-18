<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>Course List</title>
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
							<h5 class="card-title text-center">Course List</h5>

							<label><a href="coresublist">&nbsp; &nbsp; &nbsp; Core Courses</a></label>

							<c:forEach var="i" items="${specmajors}" varStatus="status">
								<div class="form-label-group">
									<label><a href="majorsublist?specialized=${i.des}">${i.des}</a></label> <br>
								</div>
							</c:forEach>

							<hr class="my-4">
							<label><a href="#">&nbsp; &nbsp; &nbsp;Courses By
									Faculty/Department</a></label>

						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<%@include file="footer.jsp"%>
</body>
</html>