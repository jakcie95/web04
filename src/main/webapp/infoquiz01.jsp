<%@page import="member.MemberDTOQ"%>
<%@page import="member.MemberDAOQ"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MemberDAOQ dao = new MemberDAOQ();
	MemberDTOQ d =dao.getStudent(request.getParameter("id"));
%>
<h1>인적 사항</h1>
<p>
학번 : <%= d.getId() %>
</p>
이름 : <%= d.getName() %><br>
<p>
국,영,수 : <%= d.getKor()+","+d.getEng()+","+d.getMath() %>
</p>
</body>
</html>