<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page import="controller.database.DatabaseController"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.OrderModel" %>
<%@page import="util.StringUtils"%>
<sql:setDataSource var="dbConnection" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/idealism"
    user="root" password=""/>
<sql:query var="orders" dataSource="${dbConnection}">
    SELECT * FROM `orders`
</sql:query>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Panel</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="../stylesheets/adminDashboard.css">
    <script href="/js/admin.js"></script>
</head>

<body>
    <header>
        <h1 class="logo">Idealism</h1>
        <div class="nav middle">
            <ul> 
                <li><a href="./userManagement.jsp">User Management</a></li>
                <li><a href="./adminDashboard.jsp">DashBoard</a></li>
                <li><a href="./productManagement.jsp">Product Management</a></li>
            </ul>
        </div>
        <div class="nav right">
        <form action="<%= request.getContextPath() + StringUtils.SERVLET_URL_LOGOUT%>" method="post">
                <button class="logOutButton" type="submit">Log Out</button>
            </form>
               <!--  <a href="#"> Logout</a> -->
        </div>
	</header>

    <section id="content">
        <main>
            <section class="top">
                <div class="head-title">
                    <div class="left">
                        <h1>DashBoard</h1>
                    </div>
      
                </div>
            </section>
            <ul class="box-info">
				<li>
					<i class='bx bx-package' ></i>
					<span class="text">
						<h3>1020</h3>
						<p>Stock</p>
					</span>
				</li>
				<li>
					<i class='bx bx-cart' ></i>
					<span class="text">
						<h3>2834</h3>
						<p>Orders</p>
					</span>
				</li>
				<li>
					<i class='bx bxs-dollar-circle' ></i>
					<span class="text">
						<h3>$2543</h3>
						<p>Total Sales</p>
					</span>
				</li>
			</ul>

				<div class="order-table">
					<div class="head">
						<h3>Recent Orders</h3>
					</div>
					<table>
						<thead>
							<tr>
								<th>Order ID</th>
                                <th>Product ID</th>
								<th>Product Name</th>
								<th>Quantity</th>
								<th>Unit Price</th>
								<th>Total Price</th>
								<th>Status</th>

							</tr>
						</thead>
						<tbody>
						<c:forEach var="order" items="${orders.rows}">
                            <tr>
                                <td><c:out value="${order.order_Id}"/></td>
                                <td><c:out value="${order.product_id}"/></td>
                                <td><c:out value="${order.product_name}"/></td>
                                <td><c:out value="${order.quantity}"/></td>
                                <td><c:out value="${order.unit_price}"/></td>
                                <td><c:out value="${order.total_price}"/></td>
                                <td><span class="status completed">Completed</span></td>
                            </tr>
                        </c:forEach>
				<%-- 		<%
    				ArrayList<OrderModel> orders = (ArrayList<OrderModel>) request.getAttribute("orders");
						%>
							<tr>
							<% for (OrderModel order : orders) { %>
						    <tr>
						        <td><%= order.getOrder_Id() %></td>
						        <td><%= order.getProduct_id() %></td>
						        <td><%= order.getProduct_name() %></td>
						        <td><%= order.getQuantity() %></td>
						        <td><%= order.getUnit_price() %></td>
						        <td><%= order.getTotal_price() %></td>
						    </tr>
						    <% } %> --%>
							<%-- <c:forEach var="order" items="${order}">
					        <tr>
					            <td><c:out value="${order.order_ID}"/></td> <!-- Adjust column names as per your database schema -->
					            <td><c:out value="${order.product_id}"/></td>
					            <td><c:out value="${order.product_name}"/></td>
					            <td><c:out value="${order.quantity}"/></td>
					            <td><c:out value="${order.unit_price}"/></td>
					            <td><c:out value="${order.total_price}"/></td>
								<td>
								<td><span class="status completed">Completed</span></td></tr>
								</c:forEach> --%>

						
							
						</tbody>
					</table>
				</div>
        </main>
    </section>

    <footer>
        <p>&copy; 2024 Idealism. All rights reserved.</p>
    </footer>
</body>
</html>