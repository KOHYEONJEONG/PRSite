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

  <title> ModifyView </title>

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

	<script type="text/javascript">
		function check_write(){
			if (document.modify_v.title.value =="") {
		 		alert("제목을 입력하세요.");
		  		document.modify_view.title.focus();
		  		return false;
			}
			
			else if (document.modify_v.content.value =="") {
		 		alert("내용을 입력하세요.");
		  		document.modify_view.content.focus();
		  		return false;
			}
			else {return true;}
		}
		
	</script>
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
	  textarea {
	    resize: none;
	  }
	
	</style>
</head>

<body class="sub_page">

  <div class="hero_area">
    <div class="bg-box">
      <img src="/project/resources/images/Main.PNG" alt="">
    </div>
    <!-- header section starts -->
       <jsp:include page="<%=Menu %>" flush="false" />
    <!-- end header section -->
  </div>
  
    <!-- pet section -->


  <section class="book_section layout_padding">
    <div class="container">
      <div class="heading_container heading_center">
        <h2>
          Modify View
        </h2>
      </div>
    </div>
  </section>
  
  <!-- modify_view section -->
  	<div align="center" style="border:1px solid lightgray; margin:10px 470px 10px 470px; padding:10px" >
  		<form method=post action="./modify" name="modify_v"  onSubmit="return check_write()">	
			<input type="hidden" value="${LoginID}" name="id">
			
			<table cellpadding="5px">
			
				<tr>
					<td>
						NO.
					</td>
					<td>
						<input type="text" name="b_no" value="${content_view.bno}" readonly>
					</td>
				</tr>
							
				<tr width="20">
				
					<td>
						TITLE
					</td>
					<td>
						<div id="title">
							<input type="text" name="title" size="99" value="${content_view.title}">
						</div>
					</td>
				</tr>
				<tr>
					<td>
						CONTENT
					</td>
					<td>
						<div id="contents">
						<textarea rows="22" cols="100" name="content">${content_view.content}</textarea>
						</div>
					</td>
				</tr>
				<tr align="right">
					<td colspan="2">
						<div style="margin:10px 5px 0px 0px" align="right">
							<button type="submit">수정하기</button>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br><br><br><br>
  <!-- end modify_view section -->
  
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