<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<! DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Logout </title>
	<style>
		body { 
			background : repeating-linear-gradient(100deg, #191A43,  #2b1d5a);
		}
		#wrapper { 
			position : absolute;
			top : 50%; left : 50%;
			width : 400; height: 200;
			margin-left : -200px;
			margin-top : -150px;
			text-align : center;
		}
		hr {
			position : absolute;
			width : 90%;
			border : 0.2px solid #E8F49E;
			margin-left : 5%; 
		}
		h1{
			margin-bottom : 0px;
			letter-spacing : 25px;
			color : #E8F49E;
			font-size : 45px;
			font-weight : lighter;
			font-family : "Palatino Linotype", "Book Antiqua", Palatino, serif;
		}
		h3 {
			color : #B6A8BC;
			font-weight : lighter;	
		}
		
		
	</style>	
</head>

<body>
	<%	session.invalidate();	%>
	
	<hr style="top:3%;">
	<div id="wrapper">
		<h1> [Logout]</h1><br/>
		<h3> 로그아웃 되었습니다. </h3>
	</div>
	<hr style="top:93%;">
	<hr style="top:95%;">
	
	
	<Script>
		function move(){
			location.href = "<%= request.getContextPath() %>/index";
		}
		setTimeout(move,2000);
	</Script>
	
</body>
</html>