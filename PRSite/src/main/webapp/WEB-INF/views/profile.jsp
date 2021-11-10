<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table align="center" width="1000">	
	<tr>
		<td>
			<jsp:include page="include/menu.jsp" flush="false" />
		</td>
	</tr>
	<tr>
		<td align="center">
		<table border="0" style="border-collapse:collapse;" bordercolor="#481968" height="600" width="1100">
			<tr>
				<td align="center">
					<img src="resources/img/rozy.jpg" width="300" height="300">
				</td>			
				<td>
					김패피 @dddd<br>
					패션<br>
					안녕하세요 김패피입니다<br>
					SNS :
					<a href="">인스타그램</a>, <a href="">트위터</a>, <a href="">유튜브</a>
				</td>
			</tr>
		</table>
		<hr>
		<table border="1" bordercolor="#481968" style="border-collapse:collapse;">
				<tr>
					<h3>추천 인플루언서</h3>
				</tr>
				<tr>
					<td>
						<jsp:include page="include/recommendSlide.jsp" flush="false" />						
					</td>
				</tr>
		</table>
	</tr>
</table>
</body>
</html>