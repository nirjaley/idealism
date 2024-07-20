<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controller.database.DatabaseController"%>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page import="util.StringUtils" %>
<%@ page import="model.ProductModel" %>
<%
String contextPath = request.getContextPath();
%>

<sql:setDataSource var="dbConnection" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/idealism"
user="root" password=""/>

<sql:query var="product" dataSource="${dbConnection}">
	SELECT product_id, product_name, unit_price, category, stock, image FROM product
</sql:query>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin Panel</title>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="../stylesheets/productManagement.css">
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
            	<form action="<%= request.getContextPath() + StringUtils.SERVLET_URL_LOGOUT%> " method="post">
                	<button class="logOutButton" type="submit">Log Out</button>
            	</form>
            </div>
        </header>
        <section id="content">
            <main>
                <section class="top">
                <%
		            	String msg = request.getParameter("msg");
		                if("done".equals(msg)){%>	
		                <br><h2 style='color:crimson; text-align: center'>Product added Suceessfully!!!</h2><br>
		                <% }%>
		        		<%
		                if("wrong".equals(msg)){%>	
		                <br><h2 style='color:crimson; text-align: center'>***Product Failed to Add***</h2><br>
		                <% }%>
		                 
		                   <%
		                if("exception".equals(msg)){%>	
		                <br><h2 style='color:crimson; text-align: center'>***Product Failed to Add<br>EXCEPTION OCCOURED***</h2><br>
		                <% }
		                if("missing".equals(msg)){%>	
			                <br><h2 style='color:crimson; text-align: center'>***Product Failed to Add***<br> Fields missing!!</h2><br>
			                <% }
		                if("invalid".equals(msg)){%>	
		                <br><h2 style='color:crimson; text-align: center'>***Product Failed to Add***<br> Invalid Input!!</h2><br>
		                <% }
		                if("deleted".equals(msg)){%>	
		                <br><h2 style='color:crimson; text-align: center'>Product Deleted Successfully!!!</h2><br>
		                <% }
		                %>  <% 
		                if("deletefailed".equals(msg)){%>	
		                <br><h2 style='color:crimson; text-align: center'>***Product Delete Fail***</h2><br>
		                <% }
		                %> 
                    <div class="head-title">
                        <div class="left">
                            <h3>Add Products:</h3>
                        </div>
                        <a href="./addproduct.jsp" class="btn-add-products">
                            <i class='bx bx-plus-circle'></i>
                            <span class="text">Add Products</span>
                        </a>
                    </div>
                </section>
                <div class="order-table">
                    <div class="head">
                        <h3>Products</h3>
                    </div>
                    <table>
                        <thead>
                            <tr>
                                <th>Product ID</th>
                                <th>Product Name</th>
                                <th>Unit Price</th>
                                <th>Category</th>
                                <th>Stock</th>
                                <th>Image</th>
                                <th>Manage</th>
    
                            </tr>
                        </thead>
                        <tbody>
                        
                        	
					
					    <c:forEach var="product" items="${product.rows}">
					        <tr>
					            <td><c:out value="${product.product_id}"/></td> 
					            <td><c:out value="${product.product_name}"/></td>
					            <td><c:out value="${product.unit_price}"/></td>
					            <td><c:out value="${product.category}"/></td>
					            <td><c:out value="${product.stock}"/></td>
					            <td style="border: 1px solid #000;"><img src="../resources/images/product${product.image}" alt="Product Image" width="100"></td>
					       
					            <td>
                                        <form action="${pageContext.request.contextPath}/DeleteProductServlet" method="post">
                                            <input type="hidden" name="productIdDel" value="${product.product_id}">
                                            <button type="submit">Delete</button>
                      
                                        </form><br>
                                      <form id="updateForm-${product.product_id}"
                                        action="<%=contextPath + StringUtils.SERVLET_URL_PRODUCT_UPDATE%>">
                                        <input type="hidden" name="<%=StringUtils.UPDATE_ID %>"
                                            value="${product.product_id}" />
                                        <button class="action-button" id="update-button" type="submit"
                                            onclick="update('${product.product_id}')">Edit</button>
                                    </form>
                                        <%-- <form action="<%=request.getContextPath() %>/pages/UpdateProduct.jsp" method="post" enctype="multipart/form-data">
                                            <input type="hidden" name="productIdUpdate" value="${product.product_id}">
                                           <input type="hidden" name="productNameUpdate" value="${product.product_name}">
                                            <input type="hidden" name="unit_priceUpdate" value="${product.unit_price}">
                                            <input type="hidden" name="categoryUpdate" value="${product.category}">
                                            <input type="hidden" name="stockUpdate" value="${product.stock}">
                                            <input type="hidden" name="imageUpdate" value="${product.image}"> 
                                            <button type="submit">Update</button>
                      
                                        </form>  --%>
                                    </td>
					          

					    </c:forEach>
					    
                             
                        </tbody>
                    </table>
                </div>
                
            </main>
        </section>
        
        <footer>
            <p>&copy; 2024 Idealism. All rights reserved.</p>
        </footer>
    </body>
   <!--  <script>function update(product_id) {
        document.getElementById("updateForm-" + product_id).submit();
    }</script> -->
</html>