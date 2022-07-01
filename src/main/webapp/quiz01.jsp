<%@page import="member.MemberDTOQ"%>
<%@page import="java.util.ArrayList"%>
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
<table border="1">
	<tr>
		<th>학번</th><th>이름</th><th>국어</th><th>영어</th><th>수학</th>
	</tr>
	<%
	MemberDAOQ daoq = new MemberDAOQ();
	ArrayList<MemberDTOQ> list = daoq.getStudent();
	for(MemberDTOQ dtoq : list){%>
	<tr>
		<td><a href="infoquiz01.jsp?id=<%= dtoq.getId() %>">
		<%= dtoq.getId() %>
		</td>
		<td><%=dtoq.getName() %></td>
		<td><%=dtoq.getKor() %></td>
		<td><%=dtoq.getEng() %></td>
		<td><%=dtoq.getMath() %></td>
	</tr>
	<% } %>
</table>

</body>
</html>