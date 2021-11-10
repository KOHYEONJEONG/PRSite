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
		<td>
			<table border="0" bordercolor="#481968" height="100" width="800">
				<h3 align="center">category</h3>
				<a href="write.htm">
					<input type="button" value="글쓰기" text-align="center" id="write">
				</a>
				<hr>
				<tr align="center">
					<td>1</td>
					<td>content1</td>
					<td><a href="profile">김패피</a></td>
				</tr>	
				<hr>
				<tr align="center">
					<td>2</td>
					<td>content2</td>
					<td>헬로월드</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>