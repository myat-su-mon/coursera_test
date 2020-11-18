<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <title>Project Team</title>
  <meta content="" name="descriptison">
  <meta content="" name="keywords">
</head>

<body>
<%@include file="header.jsp"%>
  <main id="main">

    <!-- ======= Our Team Section ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>Our Team</h2>
          <ol>
            <li><a href="index.html">Home</a></li>
            <li>Our Team</li>
          </ol>
        </div>

      </div>
    </section><!-- End Our Team Section -->

    <!-- ======= Team Section ======= -->
    <section class="team" data-aos="fade-up" data-aos-easing="ease-in-out" data-aos-duration="500">
      <div class="container">

        <div class="row">

          <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
            <div class="member">
              <div class="member-img">
                <img src="${pageContext.request.contextPath}/resources/img/team/zawlwin.jpg" class="img-fluid" alt="">
                <div class="social">
                  <a href="https://www.facebook.com/leo.valeska.is.emotionless"><i class="icofont-facebook"></i></a>
                  <a href="https://www.instagram.com/leo_valeska/?hl=en"><i class="icofont-instagram"></i></a>
                  <a href="https://twitter.com/StevenJ972"><i class="icofont-twitter"></i></a>
                </div>
              </div>
              <div class="member-info">
                <h4>Zaw Lwin Tun</h4>
                <span>Project Manager</span>
                <p></p>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
            <div class="member">
              <div class="member-img">
                <img src="${pageContext.request.contextPath}/resources/img/team/ingyinwai.jpg" class="img-fluid" alt="">
                <div class="social">
                  <a href="https://www.facebook.com/profile.php?id=100014991103049"><i class="icofont-facebook"></i></a>
                </div>
              </div>
              <div class="member-info">
                <h4>Ingyin Wai</h4>
                <span>UI/UX Designer</span>
                <p></p>
              </div>
            </div>
          </div>
          
          <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
            <div class="member">
              <div class="member-img">
                <img src="${pageContext.request.contextPath}/resources/img/team/shweyee.jpg" class="img-fluid" alt="">
                <div class="social">
                  <a href="https://www.facebook.com/shwe.y.win.3304673"><i class="icofont-facebook"></i></a>
                  <a href="https://www.instagram.com/shwe_yee_win_htuns/"><i class="icofont-instagram"></i></a>
                  </div>
              </div>
              <div class="member-info">
                <h4>Shwe Yee Win</h4>
                <span>Graphic Designer</span>
                <p></p>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
            <div class="member">
              <div class="member-img">
                <img src="${pageContext.request.contextPath}/resources/img/team/maykoye.jpg" class="img-fluid" alt="">
                <div class="social">
                  <a href="https://www.facebook.com/maykoye2612"><i class="icofont-facebook"></i></a>
                </div>
              </div>
              <div class="member-info">
                <h4>May Ko Ye</h4>
                <span>User Experience Researcher</span>
                <p></p>
              </div>
            </div>
          </div>
          
          <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
            <div class="member">
              <div class="member-img">
                <img src="${pageContext.request.contextPath}/resources/img/team/ayethwet.jpg" class="img-fluid" alt="">
                <div class="social">
                  <a href="https://www.facebook.com/rhythmless.poem.7"><i class="icofont-facebook"></i></a>
                  <a href="https://www.instagram.com/aye_thwaet/?hl=en"><i class="icofont-instagram"></i></a>
                  </div>
              </div>
              <div class="member-info">
                <h4>Aye Thwet Kabyar</h4>
                <span>Content Creator</span>
                <p></p>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
            <div class="member">
              <div class="member-img">
                <img src="${pageContext.request.contextPath}/resources/img/team/hninyadanar.jpg" class="img-fluid" alt="">
                <div class="social">
                  <a href="https://www.facebook.com/profile.php?id=100011478781928"><i class="icofont-facebook"></i></a>
                </div>
              </div>
              <div class="member-info">
                <h4>Hnin Yadanar Myo</h4>
                <span>Content Creator</span>
                <p></p>
              </div>
            </div>
          </div>
 
          <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
            <div class="member">
              <div class="member-img">
                <img src="${pageContext.request.contextPath}/resources/img/team/myatsumon.jpg" class="img-fluid" alt="">
                <div class="social">
                  <a href="https://www.facebook.com/sumon.jessica/"><i class="icofont-facebook"></i></a>
                  <a href="https://www.instagram.com/li_su_min/"><i class="icofont-instagram"></i></a>
                  <a href="https://www.linkedin.com/in/myat-su-mon/"><i class="icofont-linkedin"></i></a>
                </div>
              </div>
              <div class="member-info">
                <h4>Myat Su Mon</h4>
                <span>Front End Developer</span>
                <p></p>
              </div>
            </div>
          </div>
               
        </div>

      </div>
    </section><!-- End Team Section -->

  </main><!-- End #main -->
<%@include file="footer.jsp"%>
</body>
</html>