<%@ page language="java" contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8" %>
<! DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Menu </title>

<style type="text/css">
	ul{background: #E9DAFF; padding: 6px;}
	  
	li{display: inline; padding: 10px 20px;}
	li a{padding: 5px 10px; color: #481968; text-decoration: none;}
	li a:hover{background: ghostwhite;}
	li.dropdown{display: inline-block;}
	.dropdown-content{display: none; position: absolute; background: #E9DAFF;
		     box-shadow: 0px 8px 16px 0px rgba(0,0,0,0,2); }
	.dropdown-content a{display: block; padding: 12px 16px; text-decoration: none;
		       text-align: left; color: #481968; }
	.dropdown-content a:hover{background: ghostwhite;}
	.dropdown:hover .dropdown-content{display:block;}
</style>

</head>
<body>
<h1 align=center>
	PRSite
</h1></br>
<p style="text-align:right;"><a href="loginpage">로그인 | 회원가입</a>&nbsp;</p>
<ul>
	<li class="dropdown">
		<a href="category">카테고리1</a>
		<div class="dropdown-content">
			<a href="">요리</a>
			<a href="">스포츠</a>
			<a href="">패션</a>
		</div>
	</li>
     
	<li class="dropdown">
		<a href="">카테고리2</a>
		<div class="dropdown-content">
			<a href="">#1</a>
			<a href="">#2</a>
			<a href="">#3</a>
		</div>
	</li>
     
	<li class="dropdown">
		<a href="">카테고리3</a>
		<div class="dropdown-content">
	    	<a href="">#1</a>
			<a href="">#2</a>
			<a href="">#3</a>
		</div>
	</li>
     
   	<li class="dropdown">
		<a href="">카테고리4</a>
		<div class="dropdown-content">
	    	<a href="">#1</a>
			<a href="">#2</a>
			<a href="">#3</a>
		</div>
	</li>
     
    <li class="dropdown">
		<a href="">랭킹</a>
    </li>
     
    <li class="dropdown">
		<a href="community">커뮤니티</a>
    </li>
     
    <li class="dropdown">
		<a href="">공지사항</a>
	</li>
	
     
</ul>
</body>
</html>