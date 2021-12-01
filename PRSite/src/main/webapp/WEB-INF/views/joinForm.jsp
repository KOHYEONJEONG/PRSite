<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

  <title> Join </title>

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
      <img src="/project/resources/images/hero-bg.jpg" alt="">
    </div>
    <!-- header section strats -->
    	<jsp:include page="include/HeaderSection.jsp" flush="false" /> <!-- 상단바 header -->
    <!-- end header section -->
  </div>
    
    <!--  join form section -->
    <section class="book_section layout_padding">
    <div class="container">
      <div class="heading_container">
		<h2 align="left">&nbsp;Join Us</h2>	
		
		<br/>
		
	  </div>		
	  <div class="row">
        <div class="col-md-6">
          <div class="form_container">			
				<form"C:/Users/kogus/OneDrive/바탕 화면/StudentBuild" method=post action="MemberJoin">
				<fieldset><legend>기본정보</legend>
					아이디   (영문 대소문자/숫자, 6~15자) <input type="text" class="form-control" name="id" size=15>
					비밀번호 (영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 15자~20자)<input type="password" name="pwd" class="form-control" size=20>  
					닉네임  <input type="text" name="nickname" class="form-control" size=10>
					일반 회원 <input type="radio" name="influyn" value="n" checked>&nbsp; 인플루언서 <input type="radio" name="influyn" value="y"> </br>
				</fieldset>
				<br/>
				<fieldset><legend> 추가 인플루언서 정보 </legend>
					카테고리  <select name="category" class="form-control nice-select wide">
							<option value=> 패션 </option>
							<option value=> 요리 </option>
							<option value=> 스포츠 </option>
							<option value=> 일상 </option>
							<option value=> 게임 </option>
					    </select><br>
					소개 </br><textarea rows="3" cols="50" name="info" class="form-control" placeholder="소개를 짧게 적어주세요~"> </textarea><br>
					인스타그램 주소  <input type="text" class="form-control" name="instagram" size=30><br>
					유튜브 주소  <input type="text" class="form-control" name="youtube" size=30><br>
					인스타그램 구독자 수  <input type="text" class="form-control" name="instsubs" size=30><br>
					유튜브 구독자 수  <input type="text" class="form-control" name="ytsubs" size=30><br>
						
				</fieldset>	
				
					<br>

					<div class="btn_box">
						<button type="submit">가입하기	</button>
						<button type="reset">초기화</button>
					</div>
				</form>
			</div>
		  </div>
		</div>
		</div>
	</section>

</body>
</html>