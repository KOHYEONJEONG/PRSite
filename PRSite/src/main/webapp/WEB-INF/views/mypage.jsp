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

  <title> My Profile </title>

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
  
  <style type="text/css">
  	 table {
	    width: 100%;
	    border-top: 1px solid #DCDCDC;
	    border-collapse: collapse;
	  }
	  td {
	    border-bottom: 1px solid #DCDCDC;   
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
 
 <script type="text/javascript" src="<c:url value="/static/js/jquery-3.4.1.min.js"/>"></script>

</head>

<body class="sub_page">

  <div class="hero_area">
    <div class="bg-box">
      <img src="/project/resources/images/Main.PNG" alt="">
    </div>
    <!-- header section starts -->
    	<jsp:include page="<%= Menu %>" flush="false" />
    <!-- end header section -->
  </div>

	<!-- my page section -->

  <section class="book_section layout_padding">
    <div class="container">
      <div class="heading_container">
        <h2>
          My Profile
        </h2>
      </div>
      </br>
      <div class="row">
        <div class="col-md-6">
        <div class="form_container">
        
        <form action="ModiInfo" name="Info">
          	<table cellpadding="30px">
          		<tr>
          			<td width="300" height="70" bgcolor="whitesmoke">
          				 아이디
          			</td>
          			<td width="500">
          				 ${userProfile.id}
          			</td>          			
          		</tr>
          		<tr>
          			<td width="300" height="70" bgcolor="whitesmoke">
          				 비밀번호
          			</td>
          			<td width="500">
          				 ${userProfile.pwd}
          			</td>          			
          		</tr>
          		<tr>
          			<td width="300" height="70" bgcolor="whitesmoke">
          				 이름
          			</td>
          			<td width="500">
          				 ${userProfile.name}
          			</td>          			
          		</tr>
          		<tr>
          			<td width="300" height="70" bgcolor="whitesmoke">
          				 구독한 인플루언서
          			</td>
          			<td width="500">
          			
          			</td>          			
          		</tr>
          	</table>
          	
          	<br/>
          		<br/>
          	<hr/>
          		<br/>
          			<br/>
          	<div class="heading_container">
		        <h2>
		         influencer Profile
		        </h2>
		     </div>		
          				
          	<div>
          	<table cellpadding="30px">
          		<tr>
          			<td width="300" height="70" bgcolor="whitesmoke">
          				 카테고리
          			</td>
          			<td width="500">
          				  ${influencerProfile.cat}
          			</td>          			
          		</tr>
          		<tr>
          			<td width="300" height="70" bgcolor="whitesmoke">
          				 자기소개
          			</td>
          			<td width="500">
          				<c:if test="${empty influencerProfile.info}">
							자기소개 작성해주세요 ^^
          				</c:if> 
          				<c:if test="${not empty influencerProfile.info}">
							${influencerProfile.info}
          				</c:if> 
          			</td>          			
          		</tr>
          		<tr>
          			<td width="300" height="70" bgcolor="whitesmoke">
          				 인스타그램 주소
          			</td>
          			<td width="500">
          					<a href="${influencerProfile.instagram}">${influencerProfile.instagram}</a>
          			</td>          			
          		</tr>
          		<tr>
          			<td width="300" height="70" bgcolor="whitesmoke">
          				 유튜브 주소
          			</td>
          			<td width="500">
          					<a href="${influencerProfile.youtube}">${influencerProfile.youtube}</a>
          			</td>          			
          		</tr>
          		<tr>
          			<td width="300" height="70" bgcolor="whitesmoke">
          				 사이트 내 구독자
          			</td>
          			<td width="500">
          				${influencerProfile.subscnt} 명
          			</td>          			
          		</tr>
          		<tr>
          			<td width="300" height="70" bgcolor="whitesmoke">
          				 인스타그램 팔로워
          			</td>
          			<td width="500">
          				 ${influencerProfile.instsubs} 명
          			</td>          			
          		</tr>
          		<tr>
          			<td width="300" height="70" bgcolor="whitesmoke">
          				 유튜브 구독자
          			</td>
          			<td width="500">
          				${influencerProfile.ytbsubs} 명
          			</td>          			
          		</tr>
          		
          	</table>
          	</div>
            </br> 
            	
			<div class="btn_box">

					<button type="submit" onClick="updateForm">
						수정하기
					</button>
			
			</div>
		  </form>
		  	
					
        <div class="col-md-6">
          
        </div>
        </div>
      </div>
    </div>
    </div>
  </section>

	
	
	<!-- end my page section -->

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