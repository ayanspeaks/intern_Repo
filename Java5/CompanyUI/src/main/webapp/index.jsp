<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Company Home Page</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
}

.navbar {
	background-color: #D3D3D3;
	padding: 10px;
	color: white;
	text-align: center;
}

.navbar a {
	color: black;
	padding: 14px 20px;
	text-decoration: none;
}

.navbar a:hover {
	background-color: #ddd;
	color: blue;
}

.container {
	text-align: center;
	margin: 20px;
}

.image-slider {
	width: 80%;
	margin: auto;
	border: 2px solid #ccc;
	padding: 10px;
}

.products {
	display: flex;
	justify-content: space-around;
	margin-top: 20px;
}

.product {
	width: 30%;
	padding: 20px;
	border: 1px solid #ddd;
}

.form-container {
	text-align: left;
	margin-top: 30px;
}
</style>
</head>
<body>
	<div
		style="background-color: #87CEFA; padding: 10px; display: flex; align-items: center;">
		<img src="images/logo.png" alt="Company Logo"
			style="height: 80px; width: 100px; border-radius: 50%; object-fit: cover; margin-right: 0px;">
		<span style="color: black; font-size: 30px; font-weight: bold;">ABC
			InfoTech</span>
	</div>
	<!-- Navigation Bar -->
	<div class="navbar">
		<a href="#">Home</a> <a href="#">Services</a> <a href="#">Products</a>
		<a href="login.jsp">Login / Signup</a>
	</div>

	<!-- Image Slider -->
	<div class="container">
		<div class="image-slider">
			<p
				style="font-size: 24px; font-weight: bold; color: #ffffff; background: linear-gradient(45deg, #ff6b6b, #6b6bff); padding: 10px 20px; border-radius: 8px; text-align: center; width: max-content; margin: auto; box-shadow: 2px 4px 10px rgba(0, 0, 0, 0.2);">
				Know Your Department With A Quick Click</p>

		</div>
	</div>

	<!-- Products Section -->
	<div class="products">
		<div class="product">
			<img src="images/customer.jfif" alt="customer" class="logo"
				width="250px">
		</div>
		<div class="product">
			<img src="images/diversity.jfif" alt="diversity" class="logo"
				width="250px" height="135px">
		</div>
		<div class="product">
			<img src="images/customer.jfif" alt="customer" class="logo"
				width="250px">
		</div>
	</div>

	<!-- Form Section -->
	<div class="container form-container">
		<h3>User Form</h3>
		<form action="RegisterServlet" method="post">
			Name: <input type="text" name="name" required> <br> <br>
			Email: <input type="email" name="email" required> <br> <br>
			Gender: <input type="radio" name="gender" value="Male"> Male
			<input type="radio" name="gender" value="Female"> Female <br>
			<br> Services: <select name="services">
				<option>Web Development</option>
				<option>App Development</option>
				<option>SEO</option>
			</select> <br> <br> <input type="checkbox" name="subscribe"
				value="yes"> Subscribe to newsletter <br> <br>
				Password: <input type="password" name="password" required><br><br>
			<button type="submit">Submit</button>
		</form>
	</div>

</body>
</html>