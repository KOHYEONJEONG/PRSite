<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<! DOCTYPE html>
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

<title>Influencer Recommend Site</title>

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

<style>
a:link {
	color: black;
}

a:visited {
	color: black;
}
</style>
 <%
	boolean isLogin = false;
 	String Menu = "include/HeaderSection.jsp";
 	String LoginID = (String) session.getAttribute("LoginID");
 	System.out.println("LoginID==" + (String) session.getAttribute("LoginID"));
 	
 	if( LoginID!=null){
 		System.out.println("LoginID==" + (String) session.getAttribute("LoginID"));
		isLogin=true;
	}
 	else
 	{
 		isLogin=false;
 	}
 		
 	if(isLogin){
			System.out.println("isLogin==true");
		Menu = "include/HeaderSection2.jsp";
	}
	else{
		Menu = "include/HeaderSection.jsp";
	}
	
 %>
 
 <style type="text/css">
 	table th{
		font-weight:bolder;
		font-size: 20px;
	}
 </style>
</head>

<body class="sub_page">

	<div class="hero_area">
		<div class="bg-box">
			<img src="/project/resources/images/Main.PNG" alt="">
		</div>
		<!-- header section strats -->
		<jsp:include page="../include/HeaderSection.jsp" flush="false" />
		<!-- end header section -->
	</div>

	<!-- pet section -->


	<section class="book_section layout_padding">
		<div class="container">
			<div class="heading_container heading_center">
				<h2>Community</h2>
			</div>
		</div>
	</section>

	<!-- community section -->

	<div align="center"
		style="margin: 10px 430px 10px 430px; padding: 10px">
		<hr>
		<table width="900" cellpadding="10px">

			<tr align="center" >
				<th>번호</th>
				<th>이름</th>
				<th>제목</th>
				<th>날짜</th>
			</tr>

			<c:forEach items="${list}" var="dto">
				<tr align="center">
					<td>${dto.bno}</td>
					<td>${dto.title}</td>
					<!-- CommunityContentService에 게시글 번호와 작성자ID 보냄 -->
					<td><a href="content_view?b_no=${dto.bno}&id=${dto.id}">${dto.content}</a></td>
					<td>${dto.writedate}</td>
				</tr>
			</c:forEach>

			<!-- 데이터가 한개도 없는 경우 -->
			<c:if test="${ empty list }">
				<tr>
					<td align="center" colspan="9" width="100%" height="50">
						현재 등록된 게시글이 없습니다.
					</td>
				</tr>
			</c:if>

		</table>
		<hr>
		<!-- 페이징 처리(5개씩 한페이지) -->
		<div align="center">${pageMenu}</div>
		<hr>
		<!-- 글쓰기 버튼(페이지이동)-->
		<div align="right">
			<a href="./write_view"> 
				<img alt="글쓰기" src="/project/resources/button/write_b.gif">
			</a>
		</div>
	</div>

	<br>
	<br>
	<br>
	<br>
	<!-- end community section -->

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