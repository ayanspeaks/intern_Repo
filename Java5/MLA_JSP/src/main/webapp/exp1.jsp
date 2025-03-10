<%@ page import = "java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tags</title>
</head>
<body>
	<!-- declaration tag  -->

	<%!int x = 10;
	int y = 20;

	public int add() {
		return x + y;

	}%>

	<!-- expression tag -->
	EXPRESSION TAG : <%=add()%>

	<!-- scriplet tag -->
	<br><br>
	<%
	out.println("SCRIPLET TAG : " + add());
	out.println("<br><br> Surrent System Date : "+new Date());
	%>
</body>
</html>