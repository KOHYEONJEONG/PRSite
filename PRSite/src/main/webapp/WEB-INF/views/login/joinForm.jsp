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

<!--<script type="text/javascript" src="<c:url value="/static/js/jquery-3.4.1.min.js"/>"></script>-->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<style type="text/css">
	.id_ok{color:blue; display:none;}
	.id_already{color:#fb6a6a; display:none;}
</style>

<script type="text/javascript">
function check_form(){
	
	var form =document.joinform;
	
	if (!form.id.value) {
 		alert("아이디를 입력하세요.");
  		document.joinform.id.focus();
  		return false;
	} 

	if (!form.pwd.value) {
 		alert("비밀번호를 입력하세요.");
  		document.joinform.pwd.focus();
  		return false;
	}
	
	if (!form.nickname.value) {
 		alert("닉네임을 입력하세요.");
  		document.joinform.nickname.focus();
  		return false;
	}
	
	// 라디오버튼 유효성 검사(id)
	if(document.getElementById("inf").checked == true){

		if (!form.instsubs.value) {
	 		alert("인스타그램 팔로워 수를 입력해주세요.");
	  		document.joinform.instsubs.focus();
	  		return false;
		}
		
		else if (!form.ytsubs.value) {
	 		alert("유튜브 구독자 수를 입력해주세요.");
	  		document.joinform.ytsubs.focus();
	  		return false;
		}
	}
	
	document.joinform.submit();
}



// 취소 버튼 클릭시 첫화면으로 이동
function goFirstForm() {
    location.href="MainForm.do";
}  


function display(){
	document.getElementById("influencerInfo").style.display = "block";
}

function display2(){
	document.getElementById("influencerInfo").style.display = "none";
}


//AJAX:비동기 자바스크립트 AND XML
function checkId() {
	var form =document.joinform;
	var id = $('#id').val(); //id값이 "id"인 입력란의 값을 저장
	$.ajax({
		url :'/idCheck', //Controller에서 인식할 주소
		type:'post',
		data: {id:id}, //데이터 전송
		contentType:'application/x-www-form-urlencoded; charset=UTF-8',//중요
		success:function(cnt){ //컨트롤러에서 넘어온 cnt값을 받는다 
            if(cnt != 1){ //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디 
                $('.id_ok').css("display","inline-block"); 
                $('.id_already').css("display", "none");
            } else { // cnt가 1일 경우 -> 이미 존재하는 아이디
                $('.id_already').css("display","inline-block");
                $('.id_ok').css("display", "none");
                form.id.value ="";
            }
        },
        error:function(){
            alert("에러입니다");
        }
	});
};
//Controller → Service → Repository(DAO) → Mapper (DB)
//DB에서 비교한 후 결과값을 다시 뷰로 리턴받아 사용할 수 있다.

</script>


</head>

<body class="sub_page">

  <div class="hero_area">
    <div class="bg-box">
      <img src="/project/resources/images/hero-bg.jpg" alt="">
    </div>
    <!-- header section strats -->
    	<jsp:include page="../include/HeaderSection.jsp" flush="false" />
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
				
				
				<form method="post" action="join" name="joinform" enctype="multipart/form-data" accept-charset="UTF-8">
				<fieldset>
					<legend>기본정보</legend>
									
					아이디   (영문 대소문자/숫자, 5~15자) 
					<!--on input은 HTML5에서 새로 등장한 기능 : 사용자의 입력을 받으면 실행되는 이벤트 -->
					<input type="text" style="white-space: nowrap" class="form-control" name="id" id="id" size=15 pattern="^[0-9a-zA-Z]{5,15}$" required oninput="checkId()">
					<div class="id_ok" style="white-space: nowrap">사용 가능한 아이디입니다.</div>
					<strong class="id_already" style="white-space: nowrap">누군가 이 아이디를 사용하고 있어요.</strong>
					<br><br>
					
					비밀번호 (영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 5자~15자)<input type="password" name="pwd" class="form-control" size=20 pattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()_-+=[]{}~?:;`|/]).{5,15}$">
					  
					닉네임  <input type="text" name="nickname" class="form-control" size=10 pattern="^.{1,10}">
					일반 회원 <input type="radio" name="influyn" value="n" onclick="display2()" checked>&nbsp; 인플루언서 <input type="radio"  id="inf" name="influyn" value="y" onclick="display()"></br>
				</fieldset>
				<br><br>
				
				
				<div id="influencerInfo" style="display:none">
					<fieldset > <legend> 추가 인플루언서 정보 </legend>
						카테고리  <select name="category" class="form-control nice-select wide">
								<option value="fashion_beauty"> 패션 </option>
								<option value="food"> 요리 </option>
								<option value=daily> 일상 </option>
								<option value="pet"> 반려동물 </option>
						    </select><br>
						소개 </br><textarea rows="3" cols="50" name="info" class="form-control" placeholder="소개를 짧게 적어주세요~"> </textarea><br>
						인스타그램 주소  <input type="text" class="form-control" name="instagram" size=30 placeholder="인스타그램 링크를 입력해주세요."><br>
						유튜브 주소  <input type="text" class="form-control" name="youtube" size=30 placeholder="유튜브 링크를 입력해주세요."><br>
						인스타그램 구독자 수  <input type="text" class="form-control" name="instsubs" size=30 value="0"><br>
						유튜브 구독자 수  <input type="text" class="form-control" name="ytsubs" size=30 value="0" ><br>
						이미지 등록<br> <input name="photo" type="file"> <br><br> 
							
					</fieldset>	
				</div>
					<br>

					<div class="btn_box">
						<input type="button" value="가입하기" onclick="check_form()">
						<input type="button" value="메인화면" onclick="goFirstForm()">
					</div>
				</form>
				
				
			</div>
		  </div>
		</div>
		</div>
	</section>

</body>
</html>