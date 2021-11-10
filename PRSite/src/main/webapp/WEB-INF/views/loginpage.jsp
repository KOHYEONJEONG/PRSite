<%@ page language="java" contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8" %>
<! DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Login Page</title>
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
		<table border="2" style="border-collapse:collapse;" bordercolor="#481968" height="500" width="500">
			<tr>
				<td align="center">
					<h2>LOGIN</h2>
					아이디 
					<input type="text" name="id" size=10 placeholder="ID"></br></br>
					비밀번호 
					<input type="text" name="pwd" size=10 placeholder="password"></br></br>
					<input type="button" value="로그인">&nbsp;&nbsp;<a href="join">회원가입</a>
					
				</td>			
			</tr>
		</table>
		</td>
	</tr>
</table>

</body>
</html>