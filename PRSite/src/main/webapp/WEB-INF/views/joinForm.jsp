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


<script type="text/javascript" src="<c:url value="/static/js/jquery-3.4.1.min.js"/>"></script>
<script type="text/javascript">
function check_form(){
	if (document.joinform.id.value =="") {
 		alert("아이디를 입력하세요.");
  		document.joinform.id.focus();
  		return false;
	}

	else if (document.joinform.pwd.value =="") {
 		alert("비밀번호를 입력하세요.");
  		document.joinform.pwd.focus();
  		return false;
	}
	
	else if (document.joinform.nickname.value =="") {
 		alert("닉네임을 입력하세요.");
  		document.joinform.nickname.focus();
  		return false;
	}
	else {return true;}
}


function check_id(){ //아이디 중복 체크 **추가 수정 필요**
	var x = eval(document.joinform);
	
	if(!x.id.value){
		str = x.id.value;
		alert("ID를 입력하세요.");
		return false;
	}else{
		//ref = "Join_CheckID_DB.jsp?id="+ x.id.value;
		//window.open(ref,"checkID",'top=200px, left=500px,width=300,height=200,status=no');
	}
}

function display(){
	document.getElementById("influencerInfo").style.display = "block";
}

function display2(){
	document.getElementById("influencerInfo").style.display = "none";
}

</script>

</head>

<body class="sub_page">

  <div class="hero_area">
    <div class="bg-box">
      <img src="/project/resources/images/hero-bg.jpg" alt="">
    </div>
    <!-- header section strats -->
    	<jsp:include page="include/HeaderSection.jsp" flush="false" />
    <!-- end header section -->
  </div>
    
    <!--  join form section -->
    <section class="book_section layout_padding">
    <div class="container">
      <div class="heading_container">
		<h2 align="left">&nbsp;Join Us</h2>	</br>
	  </div>		
	  <div class="row">
        <div class="col-md-6">
          <div class="form_container">			
				<form method=post action="MemberJoin" name="joinform" onSubmit="return check_form()">
				<fieldset><legend>기본정보</legend>
					아이디   (영문 대소문자/숫자, 6~15자) <input type="text" class="form-control" name="id" size=15 placeholder="영숫자 최대 15글자" pattern="^[0-9a-zA-Z]{6,15}$">
					비밀번호 (영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 8자~15자)<input type="password" name="pwd" class="form-control" size=20 pattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()_-+=[]{}~?:;`|/]).{8,15}$">  
					닉네임  <input type="text" name="nickname" class="form-control" size=10 pattern="^.{1,10}">
					일반 회원 <input type="radio" name="influyn" value="n" onclick="display2()" checked>&nbsp; 인플루언서 <input type="radio" name="influyn" value="y" onclick="display()"></br>
				</fieldset>
				<br>
				</br>
				<div id="influencerInfo" style="display:none">
					<fieldset > <legend> 추가 인플루언서 정보 </legend>
						카테고리  <select name="category" class="form-control nice-select wide">
								<option value="fashion_beauty"> 패션 </option>
								<option value="food"> 요리 </option>
								<option value=daily> 일상 </option>
								<option value="pet"> 반려동물 </option>
						    </select><br>
						소개 </br><textarea rows="3" cols="50" name="info" class="form-control" placeholder="소개를 짧게 적어주세요~"> </textarea><br>
						인스타그램 주소  <input type="text" class="form-control" name="instagram" size=30><br>
						유튜브 주소  <input type="text" class="form-control" name="youtube" size=30><br>
						인스타그램 구독자 수  <input type="text" class="form-control" name="instsubs" size=30><br>
						유튜브 구독자 수  <input type="text" class="form-control" name="ytsubs" size=30><br>
							
					</fieldset>	
				</div>
					<br>

					<div class="btn_box">
						<input type="submit" value="가입하기" class="btn">
						<input type="reset" value="초기화" class="btn" >
					</div>
				</form>
			</div>
		  </div>
		</div>
		</div>
	</section>

</body>
</html>