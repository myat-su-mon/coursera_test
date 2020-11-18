<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Favicons -->
<link
	href="${pageContext.request.contextPath}/resources/img/favicon.png"
	rel="icon">
<link
	href="${pageContext.request.contextPath}/resources/img/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Roboto:300,300i,400,400i,500,500i,700,700i&display=swap"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link
	href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/vendor/animate.css/animate.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/vendor/icofont/icofont.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/vendor/venobox/venobox.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/vendor/owl.carousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/vendor/aos/aos.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet">

<!-- Login Template CSS File -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/login/all.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/login/boostrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/login/login.style.css">
<!-- Login Template JS File -->
<script
	src="${pageContext.request.contextPath}/resources/login/boostrap.bundle.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/login/jquery.slim.min.js"></script>

<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">

</head>
<body>

	<header id="header" class="fixed-top">
		<div class="container d-flex h-100"">
			<div class="justify-content-center align-self-center">
				<marquee>
					<font color="#fff">News/Announcements:
						&#4101;&#4140;&#4121;&#4145;&#4152;&#4117;&#4157;&#4146;
						&#4129;&#4097;&#4155;&#4141;&#4116;&#4154;&#4101;&#4140;&#4123;&#4100;&#4154;&#4152;&#4121;&#4155;&#4140;&#4152;
						&#4096;&#4156;&#4106;&#4151;&#4154;&#4123;&#4158;&#4143;&#4116;&#4141;&#4143;&#4100;&#4154;&#4117;&#4139;&#4117;&#4156;&#4142;
						-
						&#4096;&#4155;&#4145;&#4140;&#4100;&#4154;&#4152;&#4126;&#4140;&#4152;/&#4126;&#4144;
						&#4112;&#4101;&#4154;&#4134;&#4152;&#4097;&#4155;&#4100;&#4154;&#4152;&#4101;&#4142;&#4129;&#4124;&#4141;&#4143;&#4096;&#4154;
						&#4101;&#4140;&#4121;&#4145;&#4152;&#4117;&#4157;&#4146;
						&#4129;&#4097;&#4155;&#4141;&#4116;&#4154;&#4101;&#4140;&#4123;&#4100;&#4154;&#4152;&#4121;&#4155;&#4140;&#4152;&#4096;&#4141;&#4143;
						UCSY-SIS &#4112;&#4157;&#4100;&#4154;
						&#4096;&#4156;&#4106;&#4151;&#4154;&#4123;&#4158;&#4143;&#4116;&#4141;&#4143;&#4100;&#4154;&#4117;&#4139;&#4117;&#4156;&#4142;&#4171;</font>
				</marquee>
				<div class="logo float-left">
					<h1 class="text-light">
						<a href="index"><span>UCSY SIS</span></a>
					</h1>
				</div>

				<c:choose>
					<c:when test="${true}">
						<nav class="nav-menu float-right d-none d-lg-block">
							<ul>
								<li class="drop-down"><a href="">Admin Tasks</a>
									<ul>
										<li><a href="newuser">New User</a></li>
										<li><a href="userlist">User List</a></li>
										<li><a href="loginlist">Login List</a></li>
										<hr>
										<li><a href="setacademic">Set Academic Plan</a></li>
										<li><a href="sitestatus">Site Status</a></li>
									</ul></li>
								<li class="drop-down"><a href="">Student Affairs</a>
									<ul>
										<li><a href="regdate">List by Registration</a></li>
										<li><a href="scholar">List by Scholar</a></li>
										<hr>
										<li><a href="hostel">List by Hostel</a></li>
										<li><a href="blood">List by Blood Type</a></li>
										<li><a href="township">List by Township</a></li>
										<li><a href="stateregion">List by State/Region</a></li>
										<hr>
										<li><a href="specialized">List by Specialized Major</a></li>
										<li><a href="coresub">List by Core Subject</a></li>
										<li><a href="majorsub">List by Major Subject</a></li>
									</ul></li>
								<li class="drop-down"><a href="">Academic</a>
									<ul>
										<li><a href="courselist">Course List</a></li>
										<li><a href="newcoresub">New Core Subject</a></li>
										<li><a href="newmajorsub">New Major Subject</a></li>
									</ul></li>
								<li class="drop-down"><a href="">Timetable</a>
									<ul>
										<li><a href="teacherlist">Teacher Timetable</a></li>
										<li><a href="stdtimetable">Student Timetable</a></li>
										<li><a href="examtimetable">Exam Timetable</a></li>
									</ul></li>
								<li class="drop-down"><a href="">Setting</a>
									<ul>
										<li><a href="passchange?uid=${loginuser.viewUid}">Change
												Password</a></li>
										<li><a href="contact">Contact Us</a></li>
										<li><a href="team">Our Team</a></li>
									</ul></li>

								<li><a href="">${loginuser.viewName}[${loginuser.viewRank}]</a></li>
								<li><a href="logout?uid=${loginuser.viewLoginId}">Log
										out</a></li>
							</ul>
						</nav>
					</c:when>
					<c:when test="${loginuser.viewRank=='Teacher'}">
						<nav class="nav-menu float-right d-none d-lg-block">
							<ul>
								<li class="drop-down"><a href="">Academic</a>
									<ul>
										<li><a href="courselist">Course List</a></li>
										<li><a href="coresubupdate?subcode=Eng-101">Update Core Subject</a></li>
										<li><a href="majorsubupdate?subcode=CS-301">Update Major Subject</a></li>
									</ul></li>
								<li class="drop-down"><a href="">Timetable</a>
									<ul>
										<li><a href="teacherlist">Teacher Timetable</a></li>
										<li><a href="stdtimetable">Student Timetable</a></li>
										<li><a href="examtimetable">Exam Timetable</a></li>
									</ul></li>
								<li class="drop-down"><a href="">Setting</a>
									<ul>
										<li><a href="passchange?uid=${loginuser.viewUid}">Change
												Password</a></li>
										<li><a href="contact">Contact Us</a></li>
										<li><a href="team">Our Team</a></li>
									</ul></li>
								<li><a href="">${loginuser.viewName}[${loginuser.viewRank}]</a></li>
								<li><a href="logout?${loginuser.viewLoginId}">Log out</a></li>
							</ul>
						</nav>
					</c:when>
					<c:when test="${loginuser.viewRank=='Student'}">
						<nav class="nav-menu float-right d-none d-lg-block">
							<ul>
								<li class="drop-down"><a href="">Academic</a>
									<ul>
										<li><a href="courselist">Course List</a></li>
									</ul></li>
								<li class="drop-down"><a href="">Timetable</a>
									<ul>
										<li><a href="stdtimetable">View Timetable</a></li>
										<li><a href="examtimetable">View Exam Timetable</a></li>
									</ul></li>
								<li class="drop-down"><a href="">Setting</a>
									<ul>
										<li><a href="passchange?uid=${loginuser.viewUid}">Change
												Password</a></li>
										<li><a href="contact">Contact Us</a></li>
										<li><a href="team">Our Team</a></li>
									</ul></li>
								<li><a href="">${loginuser.viewName}[${loginuser.viewRank}]</a></li>
								<li><a href="logout?${loginuser.viewLoginId}">Log out</a></li>
							</ul>
						</nav>
					</c:when>
					<c:otherwise>
						<nav class="nav-menu float-right d-none d-lg-block">
							<ul>
								<li><a href="">Guest User</a></li>
								<li><a href="contact">Contact Us</a></li>
								<li><a href="login">Log In</a></li>
							</ul>
						</nav>
					</c:otherwise>
				</c:choose>

			</div>
		</div>

		<a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

		<!-- Vendor JS Files -->
		<script
			src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/resources/vendor/jquery.easing/jquery.easing.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/resources/vendor/php-email-form/validate.js"></script>
		<script
			src="${pageContext.request.contextPath}/resources/vendor/venobox/venobox.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/resources/vendor/waypoints/jquery.waypoints.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/resources/vendor/counterup/counterup.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/resources/vendor/owl.carousel/owl.carousel.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/resources/vendor/isotope-layout/isotope.pkgd.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/resources/vendor/aos/aos.js"></script>

		<!-- Template Main JS File -->
		<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
	</header>

	<!-- ======= Hero Section ======= -->
	<section id="hero"
		class="d-flex justify-cntent-center align-items-center">
		<div id="heroCarousel" class="container carousel carousel-fade"
			data-ride="carousel">

			<!-- Slide 1 -->
			<div class="carousel-item active">
				<div class="carousel-container">
					<h2 class="animate__animated animate__fadeInDown">
						Welcome to <span>UCSY SIS</span>
					</h2>

					<a href="team"
						class="btn-get-started animate__animated animate__fadeInUp">Our
						Team </a>
				</div>
			</div>

		</div>
	</section>

	<!-- End Hero -->
</body>
</html>