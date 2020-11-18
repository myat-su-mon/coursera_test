<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Report Reply</title>
<style type="text/css">
#spacing {
	margin-bottom: 15px;
}
</style>
</head>
<body>
	<%@include file="header.jsp"%>

	<main id="main">
		<div class="container">
			<c:choose>
				<c:when test="${report=='reply'}">
				</c:when>
			</c:choose>
			<div class="row">
				<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
					<div class="card card-signin my-5">
						<div class="card-body">
							<h5 class="card-title text-center">Report Reply</h5>
							<form class="form-signin" action="replyreport" method="post">
								<input type="hidden" name="em" value="${email}"> <input
									type="hidden" name="st" value="${status}"><input
									type="hidden" name="re" value="${rep}"> <input
									type="text" id="spacing" class="form-control" name="email"
									value="${email}" disabled="disabled">

								<!-- <input type="text" class="form-control"
										value="" disabled="disabled"> -->

								<div class="form-label-group">
									<textarea id="spacing" class="form-control" name="report"
										disabled="disabled"> ${rep}</textarea>
								</div>

								<input type="text" id="spacing" class="form-control"
									name="sub" placeholder="Subject">

								<div class="form-label-group">
									<textarea class="form-control" name="reply" placeholder="Reply"></textarea>
								</div>
								
								<div class="form-label-group" align="center"><p>${msg}</p></div>

								<button class="btn btn-block text-uppercase" type="submit">Reply</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<%@include file="footer.jsp"%>
</body>
</html>