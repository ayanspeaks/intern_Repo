<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- scriplet tag -->

	<%
	String user = request.getParameter("user");
	String pass = request.getParameter("pwd");
	
	if(user.equals("admin") && pass.equals("a123")){
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		
		rd.forward(request, response);
	} else{
		out.println("<h3><font color='red'>invalid credentials</font></h3><br><br>");
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				
		rd.include(request, response);
	}

	%>

</body>
</html>