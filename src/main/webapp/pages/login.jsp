
<%
String contextPath = request.getContextPath();
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<style>

/* General Styles */
body {
	background-color: #f2f2f0;
	font-family: system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI",
		Roboto, Oxygen, Ubuntu, Cantarell, "Open Sans", "Helvetica Neue",
		sans-serif;
	font-size: 16px; /* Adjusted base font size */
	margin: 0;
	padding: 0;
}

.Main_container {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	width: 400px;
	padding: 30px;
	background-color: #dddddd;
	box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);
	border-radius: 15px;
}

/* Heading Styles */
.heading_form_container h1 {
	text-align: center;
	margin-bottom: 20px;
	font-size: 20px; /* Larger heading size */
}

/* Close Button Styles */
.closeButton {
	position: absolute;
	top: 10px;
	right: 10px;
	width: 20px;
	height: 20px;
	border: none;
	background-color: #eee;
	color: #333;
	text-align: center;
	line-height: 20px;
	border-radius: 50%;
	cursor: pointer;
	font-size: 14px;
}

.closeButton:hover {
	background-color: #c6bebe;
}

.form_container {
	display: flex; /* Enable flexbox layout */
	flex-direction: column; /* Stack elements vertically */
	margin-bottom: 15px;
}

.form_container label {
	display: flex; /* Make label part of the flexbox */
	align-items: center; /* Align label content vertically */
	justify-content: space-between;
	/* Distribute space between label and input */
	margin-bottom: 5px; /* Spacing between label and input */
	font-size: 14px; /* Adjust font size if needed */
}

.form_container input[type="email"], .form_container input[type="password"]
	{
	width: 100%;
	padding: 10px;
	border: 1px solid #aaa; /* Lighter border */
	border-radius: 5px;
	outline: none;
}

.form_container input[type="email"]:focus, .form_container input[type="password"]:focus
	{
	border-color: #555;
}

/* Login Button Styles */
.loginButton {
	display: block;
	width: 100%; /* Full width for the container */
	padding: 10px 0px; /* Adjusted padding */
	font-size: 14px; /* Adjusted button font size */
	font-weight: bold;
	border: none;
	border-radius: 25px;
	background-color: #f2f2f0;
	color: #101010;
	cursor: pointer;
}

.loginButton:hover {
	background-color: #c9cd86;
}

/* Footer Styles */
.form_container p {
	font-size: 12px; /* Adjusted font size for smaller text */
	margin-top: 10px; /* Added spacing */
}

/* Removed unused styles */
.Main_container.heading_form_container, .Main_container.form_container p:hover
	{
	/* Removed unused selectors */
	
}
}
</style>
</head>
<body>
	<form action="<%=contextPath%>/Login" method="post">
		<div class="Main_container">
            <a href="home.jsp" class="closeButton"> &times; </a>

			<div class="heading_form_container">
				<h1>Login</h1>
			</div>

			<div class="form_container">
				<label for="email">Email</label><br> <input type="email"
					id="email" placeholder="Enter your e-mail" name="email">
			</div>

			<div class="form_container">
				<label for="password">Password</label><br> 
				<input type="password" id="password" name="password" placeholder="Enter your password here">
			</div>

			<button type="submit" class="loginButton">Login</button>

			<div class="form_container">
				<a href="/idealism/pages/register.jsp" class="registerButton">Don't have an account?</a>
			</div>
		</div>
	</form>

</body>
</html>