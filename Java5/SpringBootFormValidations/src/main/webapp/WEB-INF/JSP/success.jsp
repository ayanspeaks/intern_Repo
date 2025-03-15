<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>user data format submitted with validations</h1>

	FirstName : ${user.firstName}
	<br>
	<br> LastName : ${user.lastName}
	<br>
	<br> Gender : ${user.gender}
	<br>
	<br> Food:
	<ul>
		<c:forEach var="food" items="${user.food}">
			<li>${food}</li>
		</c:forEach>
	</ul>

	Leaving from : ${user.cityFrom}
	<br>
	<br> Going To : ${user.cityTo}
	<br>
	<br> Journey Date : ${user.jDate}
	<br>
	<br> Seat No:
	<ul>
		<c:forEach var="seats" items="${user.seat}">
			<li>${seats}</li>
		</c:forEach>
	</ul><br><br>
	
	<a href = "userform">click here to register</a>
</body>
</html>