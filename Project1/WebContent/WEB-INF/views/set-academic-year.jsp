<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>Academic Year</title>
<meta content="" name="descriptison">
<meta content="" name="keywords">
</head>

<body>
	<%@include file="header.jsp"%>
	<main id="main">
		<div class="container">
			<div class="row">
				<div class=" col-md-7 col-lg-5 mx-auto">
					<div class="card card-signin my-5">
						<div class="card-body">
							<h5 class="card-title text-center">Academic Year/Semester</h5>
							<form:form class="form-signin" action="setacademic" method="post"
								modelAttribute="curyear">
								<form:hidden path="id" value="${curyear.id}" />
								<div class="form-label-group">
									<form:select class="custom-select" path="curYr">
										<form:option value="2019" label="2019-2020" />
										<form:option value="2020" label="2020-2021" />
										<form:option value="2021" label="2021-2022" />
										<form:option value="2022" label="2022-2023" />
										<form:option value="2023" label="2023-2024" />
										<form:option value="2024" label="2024-2025" />
										<form:option value="2025" label="2025-2026" />
										<form:option value="2026" label="2026-2027" />
										<form:option value="2027" label="2027-2028" />
										<form:option value="2028" label="2028-2029" />
										<form:option value="2029" label="2029-2030" />

									</form:select>
								</div>

								<div class="form-label-group">
									<form:select class="custom-select" path="curSem">
										<form:option value="1" label="1" />
										<form:option value="2" label="2" />
									</form:select>
								</div>

								<button class="btn btn-block text-uppercase" type="submit">Set
									Academic</button>
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