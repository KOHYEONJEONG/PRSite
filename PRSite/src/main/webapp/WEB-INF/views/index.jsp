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
  
 <style>
 	#sbutton{ 	
 		background : white;
 		border : none;
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
<script type="text/javascript">
function check() {
	if(document.searchbar.search.value==""){
		alert("검색어를 입력하세요.");
		document.searchbar.search.focus();
		return false;
	}
	else {return true;}
}
</script>

</head>

<body>

  <div class="hero_area">
    <div class="bg-box">
      <img src="/project/resources/images/Main.PNG" alt="">
    </div>
    
    
    <!-- header section starts -->
    
    	<jsp:include page="<%= Menu %>" flush="false" />

  	
    <!-- end header section -->
        
    
    <!-- slider section -->
    <section class="slider_section ">
      <div id="customCarousel1" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <div class="container ">
              <div class="row">
                <div class="col-md-7 col-lg-6 ">
                  <div class="detail-box">
                    <h1>
                      Hot Influencer 1
                    </h1>
                    <p>
                      김메주와 고양이들 알아? </br>
                      4마리의 다양한 고양이를 볼 수 있는 '김메주와 고양이들' 채널과 그 집사의 일상 브이로그를 담은 '김메주' 채널까지!!
                      일상과 반려동물 영상 둘 다 즐기고 싶다면 당장 보자!
                    </p>
                    <div class="btn-box">
                      <a href="profile" class="btn1">
                        자세히 보기
                      </a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="carousel-item ">
            <div class="container ">
              <div class="row">
                <div class="col-md-7 col-lg-6 ">
                  <div class="detail-box">
                    <h1>
                      Hot Influencer 2
                    </h1>
                    <p>
                      여기가 주먹맛집...? </br>
                      홈카페 영상으로 유명한 yedy101 다양한 디저트 레시피와 음료 레시피를 볼 수 있어요.
                      귀여운 고양이는 덤                     
                    </p>
                    <div class="btn-box">
                      <a href="" class="btn1">
                        자세히 보기
                      </a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <div class="container ">
              <div class="row">
                <div class="col-md-7 col-lg-6 ">
                  <div class="detail-box">
                    <h1>
                      Hot Influencer 3
                    </h1>
                    <p>
                      쭈친 모여라!!!!</br>
                      호주 사는 해쭈의 천방지축 어리둥절 빙글빙글 돌아가는 브이로그!
                      귀여운 고양이 새삼이와 KO패밀리의 즐거운 일상이 궁금하다면 보러가자
                    </p>
                    <div class="btn-box">
                      <a href="" class="btn1">
                        자세히 보기
                      </a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="container">
          <ol class="carousel-indicators">
            <li data-target="#customCarousel1" data-slide-to="0" class="active"></li>
            <li data-target="#customCarousel1" data-slide-to="1"></li>
            <li data-target="#customCarousel1" data-slide-to="2"></li>
          </ol>
        </div>
      </div>

    </section>
    <!-- end slider section -->
  </div>
	
	</br>
	</br>
	<!-- 검색창 -->
	<div class="form_container" align="center">
	<form method=get action="./InfluencerSearch" name="searchbar"  onSubmit="return check()">

		<input type="text" name="search" class="form_container" placeholder="아이디나 키워드를 입력하세요." size="50" id="search"/>
		<button type="submit" id="sbutton"><img src="/project/resources/img/search_icon.jpg" width="30" height="30"></button>
	</form>
	</div>
	<div>
	</div>
	</br></br></br>
	
  <!-- offer section -->
<div class="container">
      <div class="heading_container heading_center">
        <h2>
          Hot Influencer
        </h2>
      </div>
    </div>
  <section class="offer_section layout_padding-bottom">
    <div class="offer_container">
      <div class="container ">
        <div class="row">
        <c:forEach items="${rcmmlist}" var="rcmmlist">
          <div class="col-md-6  ">
            <div class="box ">
              <div class="img-box">
                <img src="/project/resources/img/profimg.png" alt="">
              </div>
              <div class="detail-box">
                <h8>
                   ${rcmmlist.id}
                </h8>
                <h3>
                  <span> ${rcmmlist.info}</span> 
                </h3>
                <a href="https://youtu.be/RScBfvjyU_Y">
                  구독하기 
                    <g>
                      <g>
                        <path d="M345.6,338.862c-29.184,0-53.248,23.552-53.248,53.248c0,29.184,23.552,53.248,53.248,53.248
                     c29.184,0,53.248-23.552,53.248-53.248C398.336,362.926,374.784,338.862,345.6,338.862z" />
                      </g>
                    </g>
                    <g>
                      <g>
                        <path d="M439.296,84.91c-1.024,0-2.56-0.512-4.096-0.512H112.64l-5.12-34.304C104.448,27.566,84.992,10.67,61.952,10.67H20.48
                     C9.216,10.67,0,19.886,0,31.15c0,11.264,9.216,20.48,20.48,20.48h41.472c2.56,0,4.608,2.048,5.12,4.608l31.744,216.064
                     c4.096,27.136,27.648,47.616,55.296,47.616h212.992c26.624,0,49.664-18.944,55.296-45.056l33.28-166.4
                     C457.728,97.71,450.56,86.958,439.296,84.91z" />
                      </g>
                    </g>
                    <g>
                      <g>
                        <path d="M215.04,389.55c-1.024-28.16-24.576-50.688-52.736-50.688c-29.696,1.536-52.224,26.112-51.2,55.296
                     c1.024,28.16,24.064,50.688,52.224,50.688h1.024C193.536,443.31,216.576,418.734,215.04,389.55z" />
                      </g>
                    </g>
                    <g>
                    </g>
                    <g>
                    </g>
                    <g>
                    </g>
                    <g>
                    </g>
                    <g>
                    </g>
                    <g>
                    </g>
                    <g>
                    </g>
                    <g>
                    </g>
                    <g>
                    </g>
                    <g>
                    </g>
                    <g>
                    </g>
                    <g>
                    </g>
                    <g>
                    </g>
                    <g>
                    </g>
                    <g>
                    </g>
                  </svg>
                </a>
              </div>
            </div>
          </div>
          
          </c:forEach>
        </div>
      </div>
    </div>
  </section>

  <!-- end offer section -->

  <!-- client section -->

  <section class="client_section layout_padding-bottom">
    <div class="container">
      <div class="heading_container heading_center psudo_white_primary mb_45">
        <h1>
          Today Influencer
        </h1>
      </div>
      <div class="carousel-wrap row ">
        <div class="owl-carousel client_owl-carousel">
        
        <c:forEach items="${newalllist}" var="newalllist">
          <div class="item">
            <div class="box">
              <div class="detail-box">
                <p>
                  ${newalllist.get("info")}
                </p>
                <h6>
                 ${newalllist.get("name")}
                </h6>
                <p>
                  
                </p>
              </div>
              <div class="img-box">
                <img src="https://yt3.ggpht.com/ytc/AKedOLSn6fUg07YNkDHwhn8ioE_7E6fM63TFwNFMDp0d=s900-c-k-c0x00ffffff-no-rj" alt="" class="box-img">
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