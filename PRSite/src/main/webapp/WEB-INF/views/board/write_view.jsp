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

	<script type="text/javascript">
		function check_write(){
			if (document.write_view.title.value =="") {
		 		alert("제목을 입력하세요.");
		  		document.write_view.title.focus();
		  		return false;
			}
			
			else if (document.write_view.content.value =="") {
		 		alert("내용을 입력하세요.");
		  		document.write_view.content.focus();
		  		return false;
			}
			else {return true;}
		}
		
	</script>
	
	<style type="text/css">
	
	table textarea {
		resize: none;
	}
	</style>

</head>

<body class="sub_page">

<!-- 상단바 -->
    <div class="hero_area">
    <div class="bg-box">
      <img src="/project/resources/images/Main.PNG" alt="">
    </div>
      <!-- START header section -->
    	<jsp:include page="../include/HeaderSection.jsp" flush="false" />
    <!-- end header section -->
  </div>
<!-- end -->
  
    <!-- pet section -->


  <section class="book_section layout_padding">
    <div class="container">
      <div class="heading_container heading_center">
        <h2>
          Community
        </h2>
      </div>
    </div>
  </section>
  
  <!-- write_view section -->
			<fieldset>
  	<div align="center" style="border:1px solid lightgray; margin:10px 470px 10px 470px; padding:10px" >
        <form action="./write" name="write_view"  onSubmit="return check_write()">   
         <table cellpadding="5px">
            <tr width="20">
               <td>
                  <div id="title">
                     <input type="text" placeholder="제목을 입력하세요" name="title" size="99">
                  </div>
               </td>
            </tr>
            <tr>
               <td>
                  <div id="contents">
                  <textarea rows="22" cols="100" placeholder="글을 작성하세요." name="content"></textarea>
                  </div>
               </td>
            </tr>
            <tr align="right">
               <td colspan="2">
                  <div style="margin:10px 5px 0px 0px" align="center">
                     <button type="submit">등록</button>
                  </div>
               </td>
            </tr>
         </table>
      </form>
   </div>
   <br><br><br><br>
			</fieldset>
	<br><br><br><br>
  <!-- end write_view section -->
  
  <!-- footer section -->
  	<jsp:include page="../include/FooterSection.jsp" flush="false" />
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