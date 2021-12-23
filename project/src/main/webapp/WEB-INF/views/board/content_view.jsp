<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
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
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <link rel="shortcut icon" href="/project/../resources/images/favicon.png" type="">

  <title> Content View </title>

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="/project/../resources/css/bootstrap.css" />

  <!--owl slider stylesheet -->
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
  <!-- nice select  -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ==" crossorigin="anonymous" />
  <!-- font awesome style -->
  <link href="/project/../resources/css/font-awesome.min.css" rel="stylesheet" />

  <!-- Custom styles for this template -->
  <link href="/project/../resources/css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="/project/../resources/css/responsive.css" rel="stylesheet" />
<%
	boolean isLogin = false;
 	String Menu = "../include/HeaderSection.jsp";
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
		Menu = "../include/HeaderSection2.jsp";
	}
	else{
		Menu = "../include/HeaderSection.jsp";
	}
	
 %>
  <style>
     a:link { color:black; }
     a:visited { color:black; }
  </style>

</head>

<body class="sub_page">

  <div class="hero_area">
    <div class="bg-box">
      <img src="/project/../resources/images/Main.PNG" alt="">
    </div>
    <!-- header section starts -->
       <jsp:include page="../include/HeaderSection.jsp" flush="false" />
    <!-- end header section -->
  </div>
  
    <!-- pet section -->


  <section class="book_section layout_padding">
    <div class="container">
      <div class="heading_container heading_center">
        <h2>
          Content View
        </h2>
      </div>
    </div>
  </section>
  
  <!-- write_view section -->
   <div align="center" style="margin:10px 470px 10px 470px; padding:10px" >
           <form method=post id="frm">   
            <input type="hidden" name="b_no" value="${content_view.bno}">

            <table cellpadding="15px" border="0" width="900">
            
               <tr>
                  <td colspan="3">
                     <div align="right">
                        	${Writer.name} | ${content_view.writedate}
                        
                     </div>
                     
                  </td>
               </tr>
               
               <tr style="border-bottom:1px solid #DCDCDC; border-top:1px solid #DCDCDC">
                 <td width="30">
                  TITLE
                 </td>
                 <td>
                  :
                 </td>
                  <td>
                     <div>${content_view.title}</div>
                  </td>
               </tr>
               
               <tr>
                  <td>
                  	CONTENT
                  </td>
                  
                  <td>
                     :
                  </td>
                  
                  <td colspan="2"><p>
                     ${content_view.content}
                  </p>
                  </td>
               </tr>
               
               <tr>
               <td colspan="3" align="center">
               
               <!-- 글쓴이와 로그인한 사람이 같은 경우만 보여지게 -->
               	  <c:if test="${Writer.id eq LoginID}">
	                  <a href="./modify_view?b_no=${content_view.bno}" >
	                     <img alt="글수정" src="/project/../resources/button/mod_b.gif">
	                  </a>
                  </c:if>
                  
                  
                  <a href="community" >
                     <img alt="글목록" src="/project/../resources/button/list_b.gif">
                  </a>
                  
                  
                  <!-- 글쓴이와 로그인한 사람이 같은  경우만 보여지게 -->
               	  <c:if test="${Writer.id eq LoginID}">
	                  <a href="./delete?b_no=${content_view.bno}" >
	                     <img alt="글삭제" src="/project/../resources/button/del_b.gif">
	                  </a>
                  </c:if>
               </td>
               </tr>
            </table>
         </form>
   </div>
   <br><br><br><br>
 <!-- end write_view section -->
  
  <!-- footer section -->
     <jsp:include page="../include/FooterSection.jsp" flush="false" />
  <!-- footer section -->
  
    <!-- jQery -->
  <script src="/project/../resources/js/jquery-3.4.1.min.js"></script>
  <!-- popper js -->
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous">
  </script>
  <!-- bootstrap js -->
  <script src="/project/../resources/js/bootstrap.js"></script>
  <!-- owl slider -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js">
  </script>
  <!-- isotope js -->
  <script src="https://unpkg.com/isotope-layout@3.0.4/dist/isotope.pkgd.min.js"></script>
  <!-- nice select -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/js/jquery.nice-select.min.js"></script>
  <!-- custom js -->
  <script src="/project/../resources/js/custom.js"></script>
  <!-- Google Map -->
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCh39n5U-4IoWpsVGUHWdqB6puEkhRLdmI&callback=myMap">
  </script>
  <!-- End Google Map -->

</body>

</html>