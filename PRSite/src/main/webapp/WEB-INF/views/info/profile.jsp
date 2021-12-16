<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>

<head>
<!-- Basic -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<!-- Mobile Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<!-- Site Metas -->
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="author" content="" />
<link rel="shortcut icon" href="/project/resources/images/favicon.png"
	type="">

<title>Profile(인플루언서)</title>

<!-- bootstrap core css -->
<link rel="stylesheet" type="text/css"
	href="/project/resources/css/bootstrap.css" />

<!--owl slider stylesheet -->
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
<!-- nice select  -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css"
	integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ=="
	crossorigin="anonymous" />
<!-- font awesome style -->
<link href="/project/resources/css/font-awesome.min.css"
	rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="/project/resources/css/style.css" rel="stylesheet" />
<!-- responsive style -->
<link href="/project/resources/css/responsive.css" rel="stylesheet" />
<%-- 
<%
   //현재 로그인한 사람에 id에 구독한 인플루언서 넣어주려고(SubScribe테이블)
   boolean isLogin = false;
   String Menu = "include/HeaderSection.jsp";
   String LoginID = (String) session.getAttribute("LoginID");
   if (LoginID != null) {
      isLogin = true;
   } else {
      isLogin = false;
   }

   //상단바 로그인 하고 안하고 차이
   if (isLogin) {
      Menu = "include/HeaderSection2.jsp";
   } else {
      Menu = "include/HeaderSection.jsp";
   }
%>
 --%>
<style type="text/css">
table td {
	text-align: center;
}

#tds {
	font-weight: bolder;
}
</style>
</head>

<body class="sub_page">

	<div class="hero_area">
		<div class="bg-box">
			<img src="/project/resources/images/Main.PNG" alt="">
		</div>
		<!-- header section starts -->
			<jsp:include page="../include/HeaderSection.jsp" flush="false" />
		<!-- end header section -->
	</div>



	<!-- profile section -->
	<section class="book_section layout_padding">
		<div class="container">
			<div class="heading_container heading_center">
				<h2>Profile</h2>
			</div>
		</div>
		<br>
		<br>
		<center>
			<div class="col-md-6">
				<div class="form_container">
					<table align="center" width="700">
						<tr>
							<td align="center">
								<table border="0" style="border-collapse: collapse;"
									bordercolor="#481968" width="700">
									<tr>
										<td align="center">
										
										<c:if test="${empty photo}">
										<!-- 이미지 등록을 안했을 경우 -->
											<img src="resources/img/rozy.jpg" width="300" height="300">&nbsp;
										</c:if>
										
										<c:if test="${not empty photo}">
										<!-- 이미지 등록을 한경우 -->
											<img src="${photo}" width="300" height="300">&nbsp;
										</c:if>
										</td>
										<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
										<td>
											<table width="500" height="200">
												<tr></tr>
												<tr>
													<td align="center" id="tds">PRSite_ID</td>
													<td>:</td>
													<td>${dto.id}</td>
												</tr>

												<tr>
													<td align="center" id="tds">카테고리</td>
													<td>:</td>
													<td>${dto.cat}</td>
												</tr>

												<tr>
													<td align="center" id="tds">소&nbsp;&nbsp;&nbsp;&nbsp;개</td>
													<td>:</td>
													<td>${dto.info}</td>
												</tr>

												<tr>
													<td align="center" id="tds">Instagram</td>
													<td>:</td>
													<td><c:if test="${dto.instagram eq 'https://'}">
															<a href="#">${dto.instagram}</a>
														</c:if> <c:if test="${dto.instagram ne 'https://'}">
															<a href="${dto.instagram}">${dto.instagram}</a>
														</c:if></td>
												</tr>

												<tr>
													<td align="center" id="tds">Youtube</td>
													<td>:</td>
													<td><c:if test="${dto.youtube eq 'https://'}">
															<a href="#">${dto.youtube}</a>
														</c:if> <c:if test="${dto.youtube ne 'https://'}">
															<a href="${dto.youtube}">${dto.youtube}</a>
														</c:if></td>
												</tr>

											</table>
										</td>
									</tr>
									<tr>
										<td colspan="3">
											<!-- MemberController에서 SubInsert메소드 인플루언서id도 받아와서 구독중인지 아닌지 확인한다. -->
											<%
         							String Iid = request.getParameter("Iid");
      							%> <c:set var="isSub" value="${isSub}" /> <c:choose>
												<c:when test="${isSub eq 'true'}">
													<button onclick='location.href="./SubInsert?Iid=<%=Iid%>"'>구독하기</button>
												</c:when>
												<c:when test="${isSub eq 'false'}">
													<button onclick='location.href="./SubCancel?Iid=<%=Iid%>"'>구독취소</button>
												</c:when>
											</c:choose>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						</center>
					</table>
				</div>
			</div>
	</section>


	<!-- end profile section -->
	<!-- end fashion category section -->

	<hr>

	<!-- client section -->

	<section class="client_section layout_padding-bottom">
		<div class="container">
			<div
				class="heading_container heading_center psudo_white_primary mb_45">
				<h1>Related Influencer</h1>
			</div>
			<div class="carousel-wrap row ">
				<div class="owl-carousel client_owl-carousel">

					<c:forEach items="${relcatlist}" var="relcatlist">
						<div class="item">
							<div class="box">
								<div class="detail-box">
									<a href='./profilepage?Iid=${relcatlist.get("id")}'	style="color: green">${relcatlist.get("id")}</a>
									<p>${relcatlist.get("info")}</p>
									<h6>${relcatlist.get("name")}</h6>
									<p></p>
								</div>
								<div class="img-box">
									<img
										src="https://yt3.ggpht.com/ytc/AKedOLSn6fUg07YNkDHwhn8ioE_7E6fM63TFwNFMDp0d=s900-c-k-c0x00ffffff-no-rj"
										alt="" class="box-img">
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</section>

	<!-- end client section -->



	<!-- footer section -->
	<jsp:include page="../include/FooterSection.jsp" flush="false" />
	<!-- footer section -->

	<!-- jQery -->
	<script src="/project/resources/js/jquery-3.4.1.min.js"></script>
	<!-- popper js -->
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous">
      
   </script>
	<!-- bootstrap js -->
	<script src="/project/resources/js/bootstrap.js"></script>
	<!-- owl slider -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js">
      
   </script>
	<!-- isotope js -->
	<script
		src="https://unpkg.com/isotope-layout@3.0.4/dist/isotope.pkgd.min.js"></script>
	<!-- nice select -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/js/jquery.nice-select.min.js"></script>
	<!-- custom js -->
	<script src="/project/resources/js/custom.js"></script>
	<!-- Google Map -->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCh39n5U-4IoWpsVGUHWdqB6puEkhRLdmI&callback=myMap">
      
   </script>
	<!-- End Google Map -->

</body>

</html>