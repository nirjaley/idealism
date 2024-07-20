<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controller.database.DatabaseController"%>
<%@ page import="java.sql.*" %>
<%@ page import="controller.servlets.AddProductServlet"%>
<%@ page import="model.ProductModel" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page import="util.StringUtils"%>

<%-- <sql:setDataSource var="dbConnection" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/idealism"
user="root" password=""/>
<sql:query var="product" dataSource="${dbConnection}">
	SELECT product_id, product_name, unit_price, category, stock, image FROM product WHERE product_id = 
</sql:query>
    scriptlet --%>
    <% ProductModel productInformation = (ProductModel)request.getAttribute("updateProductInfo"); %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add Product</title>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/stylesheets/addProduct.css">
    </head>
    <body>
    	<header>
            <h1 class="logo">Idealism</h1>
<!--             <div class="nav middle">
                <ul> 
	                <li><a href="./userManagement.jsp">User Management</a></li>
	                <li><a href="./adminDashboard.jsp">DashBoard</a></li>
	                <li><a href="./productManagement.jsp">Product Management</a></li>
                </ul>
            </div> -->
            <div class="nav right">
                    <form action="<%= request.getContextPath() + StringUtils.SERVLET_URL_LOGOUT%>" method="post" id="updateForm-${product.productID}">
                	<button class="logOutButton" type="submit">Log Out</button>
            	</form>
            </div>
        </header>
        
        <div class="container">
        
            <form action="${pageContext.request.contextPath}/ModifyProductServlet" method="post" enctype="multipart/form-data">
            	<label for="productID"> Product ID:</label>
            	<input type="text" name="productID" value="${product.productID}"><br><br>
            	
                <label for="productName">Product Name</label>
                <input type="text" name="productName" value="${product.productName}" required maxlength="30"></br>
    
<!--                 <label for="productDescription">Product Description</label>
                <textarea name="productDescription", required, rows="5" cols="60"></textarea> <br> 
                String productID = request.getParameter("productID");
		int productIDInt = Integer.parseInt(productID);
		String productName = request.getParameter("productName");
		String unitPrice = request.getParameter("unitPrice");
//		int unitPriceInt = Integer.parseInt(unitPrice);
		String category = request.getParameter("category");
		
		String stock = request.getParameter("stock");
//		int stockInt = Integer.parseInt(stock);
		
		Part imagePart = request.getPart("image");
                -->
                
                <label for="unitPrice">Unit Price</label>
                <input type="text" name="unitPrice" value="${product.unitprice}" required maxlength="10"></br>
                
              

                <Label for="category">Category</Label><br>
                <select name="category"required>
                	<option value="Speakers"
                            ${product.category == "Speakers"? 'selected' : ''}>Speakers</option>
                        <option value="Headphones"
                            ${product.category == "Headphones"? 'selected' : ''}>Headphones</option>
        
                        <option value="Earbuds"
                            ${product.category == "Earbuds"? 'selected' : ''}>Earbuds</option>
                        <option value="Amplifiers"
                            ${product.category== "Amplifiers"? 'selected' : ''}>Amplifiers</option>
                            
               
                
                    <!-- <option value="Speaker">English</option>
                    <option value="Headphones">Math</option>
                    <option value="Science">Science</option>
                    <option value="Computing">Computing</option> -->
                </select>
                <br>
                
                <label for="productName">Stock</label>
                <input type="text" name="stock" value="${product.stock}"  required maxlength="30"></br>
                
                <br>
                <%-- label for="image"> Product Image</label>
                <input type="file" name="image" <%=productInformation.getImagePath()%>> --%>
                
                <%-- <input type="hidden" name="oldImage" value="<%=productInformation.getImagePath()%>" /> --%>
                
                
                
                        <input type="hidden" name="<%=StringUtils.UPDATE_ID %>"
                            value="${product.productID}" />
                        <button class="action-button" id="update-button" type="submit"
                            onclick="update('${product.productID}')">Edit</button>
                                    
                
            </form>
          
        </div>
		<footer>
            <p>&copy; 2024 Idealism. All rights reserved.</p>
        </footer>
    </body>
        <!-- <script>function update(product_id) {
        document.getElementById("updateForm-" + product_id).submit();
    }</script> -->
</html>