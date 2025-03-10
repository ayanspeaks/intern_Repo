<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h2>Login Form</h2>
    <form action="LoginServlet" method="post">
        Email: <input type="email" name="email" required> <br><br>
        Password: <input type="password" name="password" required> <br><br>
        <button type="submit">Login</button>
    </form>
</body>
</html>