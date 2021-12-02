<%@ page language="java" contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8" %>
<! DOCTYPE html>
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
  
  <!-- pet section -->


  <section class="book_section layout_padding">
    <div class="container">
      <div class="heading_container heading_center">
        <h2>
          Ranking
        </h2>
      </div>
    </div>
  </section>
  
  <!-- fashion category section -->
	<table align="center" width="600">	
		<tr>
			<td>순위</td>
			<td>인플루언서</td>
			<td>카테고리</td>
		</tr>
		<tr>
			<td>1</td>
			<td>뫄뫄</td>
			<td>패션</td>
		</tr>
		<tr>
			<td>2</td>
			<td>솨솨</td>
			<td>패션</td>
		</tr>
		<tr>
			<td>3</td>
			<td>디디</td>
			<td>반려동물</td>
		</tr>
		<tr>
			<td>4</td>
			<td>티티</td>
			<td>반려동물</td>
		</tr>
		<tr>
			<td>5</td>
			<td>승우아빠</td>
			<td>요리</td>
		</tr>
		<tr>
			<td>6</td>
			<td>김박사</td>
			<td>일상</td>
		</tr>
		<tr>
			<td>7</td>
			<td>수리</td>
			<td>반려동물</td>
		</tr>
		<tr>
			<td>8</td>
			<td>쿠킹트리</td>
			<td>요리</td>
		</tr>
		<tr>
			<td>9</td>
			<td>뫄뫄</td>
			<td>패션</td>
		</tr>
		<tr>
			<td>10</td>
			<td>뫄뫄</td>
			<td>패션</td>
		</tr>
	</table>
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