<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="util.StringUtils"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin Panel</title>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="../stylesheets/userManagement.css">
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
                    <form action="<%= request.getContextPath() + StringUtils.SERVLET_URL_LOGOUT%> method="post">
                	<button class="logOutButton" type="submit">Log Out</button>
            	</form>
            </div>
        </header>
        <section id="content">
            <main>
                <div class="order-table">
                    <div class="head">
                        <h3>Users</h3>
                    </div>
                    <table>
                        <thead>
                            <tr>
                                <th>User</th>
                                <th>Order Total</th>
                                <th>Date Order</th>
                                <th>Status</th>
    
                            </tr>
                        </thead>
                        <tbody>
                            
                           
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