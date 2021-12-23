<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	response.setStatus(HttpServletResponse.SC_OK);
	// 에러가 발생하면 여기로 와서 처리하는 페이지 (즉,정상적이게 수행되는 페이지다 <-- 라고 일러줌.)
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404 에러 발생</title>
<style>
body {
	background: repeating-linear-gradient(100deg, #191A43, #2b1d5a);
}

#wrapper {
	position: absolute;
	top: 50%;
	left: 50%;
	width: 400;
	height: 200;
	margin-left: -200px;
	margin-top: -150px;
	text-align: center;
}

hr {
	position: absolute;
	width: 90%;
	border: 0.2px solid #E8F49E;
	margin-left: 5%;
}

h1 {
	margin-bottom: 0px;
	letter-spacing: 25px;
	color: #E8F49E;
	font-size: 45px;
	font-weight: lighter;
	font-family: "Palatino Linotype", "Book Antiqua", Palatino, serif;
}

h3 {
	color: #B6A8BC;
	font-weight: lighter;
}
</style>
</head>
<body>

	<!-- web.xml에서 url 설정해줌. -->
	<!-- homeController.java -->

	<hr style="top: 3%;">
	<div id="wrapper">
		<h1>[404에러]</h1>
		<br/>
		<h3>
			경로없음<br>
			해당페이지는 빠른 시일내에 올바르게 복구하겠습니다.<br>
			문의는 관리자에게 해주세요.
			전화번호 : 010-3102-2339.</h3>
	</div>
	<hr style="top: 93%;">
	<hr style="top: 95%;">


	<Script>
		function move(){
			location.href = "<%=request.getContextPath()%>/index";
		}
		setTimeout(move, 2000);
	</Script>

</body>
</html>