<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <link rel="shortcut icon" href="/project/resources/images/favicon.png" type="">

  <title> Influencer Recommend Site </title>

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="/project/resources/css/bootstrap.css" />

  <!--owl slider stylesheet -->
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
  <!-- nice select  -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ==" crossorigin="anonymous" />
  <!-- font awesome style -->
  <link href="/project/resources/css/font-awesome.min.css" rel="stylesheet" />

  <!-- Custom styles for this template -->
  <link href="/project/resources/css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="/project/resources/css/responsive.css" rel="stylesheet" />
  
 

</head>

<body class="sub_page">

  <div class="hero_area">
    <div class="bg-box">
      <img src="/project/resources/images/Main.PNG" alt="">
    </div>
    <!-- header section strats -->
    	<jsp:include page="include/HeaderSection.jsp" flush="false" />
    <!-- end header section -->
  </div>
  
  	<!-- profile section -->
		<table align="center" width="1000">
			<tr>
				<td>
					
				</td>
			</tr>
			<tr>
				<td align="center">
				<table border="0" style="border-collapse:collapse;" bordercolor="#481968" height="600" width="1100">
					<tr>
						<td align="center">
							<img src="resources/img/rozy.jpg" width="300" height="300">
						</td>
									
					<c:forEach items="${dto}" var="dto">	
						
						<td>
							${dto.id}<br>
							${dto.cat }<br>
							${dto.info}<br>
							YoutubeSNS : ${dto.youtube}
							<a href="">인스타그램</a>, <a href="">트위터</a>, <a href="">유튜브</a>
						</td>
						
						</c:forEach>
					</tr>
				</table>
				<hr>
				<table border="1" bordercolor="#481968" style="border-collapse:collapse;">
						<tr>
							<h3>추천 인플루언서</h3>
						</tr>
						<tr>
							<td>
												
							</td>
						</tr>
				</table>
			</tr>
		</table>
	<!-- end profile section -->
  <!-- end fashion category section -->
  
  <!-- footer section -->
  	<jsp:include page="include/FooterSection.jsp" flush="false" />
  <!-- footer section -->
  
    <!-- jQery -->
  <script src="/project/resources/js/jquery-3.4.1.min.js"></script>
  <!-- popper js -->
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous">
  </script>
  <!-- bootstrap js -->
  <script src="/project/resources/js/bootstrap.js"></script>
  <!-- owl slider -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js">
  </script>
  <!-- isotope js -->
  <script src="https://unpkg.com/isotope-layout@3.0.4/dist/isotope.pkgd.min.js"></script>
  <!-- nice select -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/js/jquery.nice-select.min.js"></script>
  <!-- custom js -->
  <script src="/project/resources/js/custom.js"></script>
  <!-- Google Map -->
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCh39n5U-4IoWpsVGUHWdqB6puEkhRLdmI&callback=myMap">
  </script>
  <!-- End Google Map -->

</body>

</html>