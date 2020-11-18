<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Contact - Moderna Bootstrap Template</title>
<meta content="" name="descriptison">
<meta content="" name="keywords">
<body>
	<%@include file="header.jsp"%>

	<main id="main">

		<!-- ======= Contact Section ======= -->
		<section class="breadcrumbs">
			<div class="container">

				<div class="d-flex justify-content-between align-items-center">
					<h2>Contact</h2>
					<ol>
						<li><a href="index.html">Home</a></li>
						<li>Contact</li>
					</ol>
				</div>

			</div>
		</section>
		<!-- End Contact Section -->

		<!-- ======= Contact Section ======= -->
		<section class="contact" data-aos="fade-up"
			data-aos-easing="ease-in-out" data-aos-duration="500">
			<div class="container">

				<div class="row">

					<div class="col-lg-6">

						<div class="row">
							<div class="col-md-12">
								<div class="info-box">
									<i class="bx bx-map"></i>
									<h3>Our Address</h3>
									<p>
										No.(4) Main Road, Shwe Pyi Thar Township,<br> Yangon,
										Myanmar.
									</p>
								</div>
							</div>
							<div class="col-md-6">
								<div class="info-box">
									<i class="bx bx-envelope"></i>
									<h3>Email Us</h3>
									<p>
										ucsy.admin@ucsy.edu.mm<br>contact@ucsy.edu.mm
									</p>
								</div>
							</div>
							<div class="col-md-6">
								<div class="info-box">
									<i class="bx bx-phone-call"></i>
									<h3>Call Us</h3>
									<p>
										(+95) 9443440472<br>Monday - Friday, <br> 09:00 AM -
										02:30 PM
									</p>
								</div>
							</div>
						</div>

					</div>

					<c:choose>
						<c:when test="${sent=='no'}">
							<div class="col-lg-6">
								<form action="" method="post" role="form"
									class="php-email-form">
									<div class="form-row">
										<div class="col-md-6 form-group">
											<input type="text" name="name" class="form-control" id="name"
												placeholder="Your Name" data-rule="minlen:4"
												data-msg="Please enter at least 4 chars" />
											<div class="validate"></div>
										</div>
										<div class="col-md-6 form-group">
											<input type="email" class="form-control" name="email"
												id="email" placeholder="Your Email" data-rule="email"
												data-msg="Please enter a valid email" />
											<div class="validate"></div>
										</div>
									</div>
									<div class="form-group">
										<input type="text" class="form-control" name="subject"
											id="subject" placeholder="Subject" data-rule="minlen:4"
											data-msg="Please enter at least 8 chars of subject" />
										<div class="validate"></div>
									</div>
									<div class="form-group">
										<textarea class="form-control" name="message" rows="5"
											data-rule="required" data-msg="Please write something for us"
											placeholder="Message"></textarea>
										<div class="validate"></div>
									</div>

									<div class="text-center">
										<button type="submit">Send Message</button>
									</div>
								</form>
							</div>
						</c:when>
						<c:otherwise>
							<div class="col-lg-6">
								<form class="php-email-form" action="">
									<div class="form-group">
										<p class="form-control">Your Message has been sent. Thank
											You!</p>
									</div>
									<div class="text-center">
										<a href="index"><button type="submit">Go To Home</button></a>
									</div>
								</form>
							</div>
						</c:otherwise>
					</c:choose>

				</div>

			</div>
		</section>
		<!-- End Contact Section -->

		<!-- ======= Map Section ======= -->
		<section class="map mt-2">
			<div class="container-fluid p-0">
				<iframe
					src="https://www.google.com/maps/embed?pb=!1m16!1m12!1m3!1d3815.4222101213995!2d96.08987326420396!3d17.00294801825547!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!2m1!1sucsy!5e0!3m2!1sen!2smm!4v1596732583783!5m2!1sen!2smm"
					width="600" height="450" frameborder="0" style="border: 0;"
					allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
			</div>
		</section>
		<!-- End Map Section -->

	</main>
	
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script>
	$.ajax({
		type: 'POST',
		url: 'sendmessage',
		// dataType: "JSON", // data type expected from server
		success: function (data) {
			console.log(data);
		},
		error: function(error) {
			console.log('Error: ' + error);
		}
	});
	</script>

	<!-- <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script>
		// $("#form2").css("display", "none"); // so it's initially invisible
		$("#gotothank")
				.submit(
						function(e) {
							e.preventDefault();
							var str = $("#gotothank").serialize();

							$.ajax({
								type : "post",
								data : str,
								crossDomain : true,
								url : $("#gotothank").attr("action"),
								async : false,
								dataType : "jsonp",

							});
							$("#gotothank")
									.replaceWith(
											'<form id="thankyou" class="php-email-form" action=""><div class="form-group"><p class="form-control">Your Message has been sent. Thank You!</p></div><div class="text-center"><a href="index"><button type="submit">Go To Home</button></a></div></form>');
						});
	</script> -->
	<!-- <script>
        $("#form2").css("display", "none"); // so it's initially invisible
        var str = $("#gotothank").serialize();

		$.ajax({
			type:"post",
			data:str,
			url : $("#gotothank").attr("action"),
			async: false,
			dataType: "json",
			success: function(){
			alert("success");
			$("#form1").css("display", "none");
        $("#form2").css("display", "block");
			}
		});
    </script> -->

	<%@include file="footer.jsp"%>
</body>
</html>