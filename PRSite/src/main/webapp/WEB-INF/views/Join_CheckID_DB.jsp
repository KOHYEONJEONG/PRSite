<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		String input_id = request.getParameter("id"); 
		String db_id = null;
	 %>
	 
	 <% 
		Connection conn = null; //Connection 객체 생성
   		PreparedStatement pstmt = null;//sql문 수행 준비문

		try{//DB연결
			String jdbcUrl = "jdbc:mysql://localhost:3306/jsptest";
			String dbId="lololoi2";
			String dbPass="!xxleen3357";
			Class.forName("com.mysql.jdbc.Driver"); //1.JDBC드라이버 Load
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);//2.Connection 객체 생성
   	
			//sql 작성
			String sql = "select * from member where id = ?";
			//?->setXxx() 메소드를 사용해서 실제 값으로 대치
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, input_id);
			//쿼리 수행 - 결과 레코드 저장
			ResultSet rs = pstmt.executeQuery();
      		//레코드셋 처리
			while(rs.next()){
				db_id=rs.getString("id");
			}
      		
			if(db_id==null){
				out.println("사용 가능한 id 입니다.");  
				
      		}else{
      			out.println("이미 사용중인 id 입니다."); 
      			
			}  
			
		}catch(Exception e){
			e.printStackTrace();
			out.println("select 실패");
		}finally{
			if(pstmt != null){
				try{
					pstmt.close();
				}catch(SQLException sqle){

				}
			}
			if(conn != null){
				try {
					conn.close();
				}catch(SQLException sqle){
						
				}
			} 
		}
	%>
	
	<input type=buton onclick="self.close()" value="닫기">
</body>
</html>