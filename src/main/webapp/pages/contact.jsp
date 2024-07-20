<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Contact Form</title>
<link rel="stylesheet" href="../stylesheets/contact.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
</head>
<body>
	<header>
		<h1 class="logo">Idealism</h1>
		<div class="nav middle">
			<ul>
				<li><a href="home.jsp">Home</a></li>
				<li><a href="aboutus.jsp">About Us</a></li>
				<li><a href="contact.jsp">Contact</a></li>
			</ul>
		</div>
		<div class="nav right">
			<ul>
				<li><a href="cart.jsp"> <img src="../images/cart.png"></a></li>
				<li><a href="search.html"> <img src="../images/search.png"></a></li>
				<li><a href="register.jsp"><img src="../images/user.png"></a></li>
			</ul>
		</div>
	</header>

	<div class="container">
		<h1>
			get in <span>TOUCH</span>
		</h1>
		<div class="c-form">
			<h2>contact</h2>
			<p>We would love to hear from you!</p>
			<p>Please fill out the form</p>
			<form>
				<input type="text" placeholder="NAME" required /> <input
					type="email" placeholder="EMAIL" required /> <input type="text"
					placeholder="ADDRESS" required /> <input type="text"
					placeholder="SUBJECT" required />
				<textarea placeholder="MESSAGE" required></textarea>
				<button type="submit">SEND</button>
			</form>
		</div>
		<div class="footer">
			<div class="letter">
				<p>NEWSLETTER</p>
				<input type="email" placeholder="EMAIL" required />
				<button type="submit">SUBMIT</button>
			</div>
			<div class="social">
				<p>FOLLOW</p>
				<div class="icons">
					<a href="#"><i class="fab fa-facebook"></i></a> <a href="#"><i
						class="fab fa-pinterest"></i></a> <a href="#"><i
						class="fab fa-twitter"></i></a> <a href="#"><i
						class="fab fa-instagram"></i></a> <a href="#"><i
						class="fab fa-bloglovin"></i></a>
				</div>
			</div>
			<footer>
				<p>&copy; 2024 Idealism. All rights reserved.</p>
			</footer>
		</div>
	</div>
</body>
</html>