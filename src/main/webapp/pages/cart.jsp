<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.*"%>
<%@ page import="controller.servlets.*"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%
String contextPath = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../stylesheets/cart.css">
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
		<h1>Items in Cart</h1>
		<div class="Total">
			<form action="/idealism/checkout-servlet" method="post">
				<button class="Check Out">Check Out</button>
			</form>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Price</th>
					<th scope="col">Quantity</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
				<%
				ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cart-list");
				if (cartList != null && !cartList.isEmpty()) {
					for (Cart cartItem : cartList) {
				%>
				<tr>
					<td><%=cartItem.getProduct_name()%></td>
					<td>Rs <%=cartItem.getUnit_price()%></td>
					<td><%=cartItem.getQuantity()%></td>
					<td>
						<form action="<%=request.getContextPath()%>/remove-from-cart"
							method="post" class="form-incline">
							<div class="form">
								<input type="hidden" name="id"
									value="<%=cartItem.getProduct_id()%>">
								<button type="submit" class="remove">Remove item</button>
							</div>
						</form>
					</td>
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td colspan="4" style="text-align: center;">Your cart is empty!</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>
