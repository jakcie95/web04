<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(session.getAttribute("id") != null){%>	
	<%=session.getAttribute("id") %>님 로그인 상태입니다.<br>
	<button type="submit" value="메인">
	<a href="main.jsp">main이동</a>
	</button>
<% }else{ %>
<input type="text" name="id" placeholder="아이디"><br>
<input type="text" name="pwd" placeholder="비밀번호"><br>
<button type="submit" value="로그인">로그인</button>
<% } %>
</body>
</html>