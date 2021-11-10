<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>Main Page</title>
</head>
<body>
<table style="border-collapse:collapse;" align="center">	
	<tr>
		<td>
			<jsp:include page="include/menu.jsp" flush="false" />
		</td>
	</tr>
	<tr align="right">
		<td>
				<table algin="center">
					<tr>
						<td>
							<input type="text" name="search" size=25 placeholder="검색할 단어를 입력하세요.">
						</td>
						<td>										
							<img src="resources/img/search_icon.jpg" width="25" height="25">
						</td>
					</tr>
				</table>
				</br>
		</td>
	</tr>
	<tr >
		<td> <!-- 인플루언서 소개 부분 테이블 -->
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
		</td>
	</tr>
	<tr>
		<td> <!-- 랭킹 부분 테이블 -->
			</br>
			<table border="1" bordercolor="#481968" style="border-collapse:collapse;" height="400" width="1000">
				<tr>
					<h3>신규 인플루언서</h3>
				</tr>
				<tr>
					<td>
						i'm a savage</br>
						
					</td>
				</tr>
			</table>
			</br>
		</td>
	</tr>
</table>

</body>
</html>
