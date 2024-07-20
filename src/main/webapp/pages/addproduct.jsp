<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controller.database.DatabaseController"%>
<%@ page import="java.sql.*" %>
<%@ page import="controller.servlets.AddProductServlet"%>
<%@page import="util.StringUtils"%>
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
       <% 
       int id = 1;
       try{
    	   Connection con = DatabaseController.getConnection();
    	   Statement st = con.createStatement();
    	   ResultSet rs = st.executeQuery("select max(product_id) from product");
    	   
    	   while(rs.next()){
    		   /* out.print(rs); */
    		   id = rs.getInt(1);
    		   id = id +1;
    	   }
       }
       catch(Exception e){}
       %> 
        
        <div class="container">
        
            <form action="${pageContext.request.contextPath}/AddProductServlet" method="post" enctype="multipart/form-data">
            	<label for="productID"> Product ID: <%out.println(id);%> </label>
            	<input type="hidden" name="productID" value=<%out.println(id); %>><br><br>
            	
                <label for="productName">Product Name</label>
                <input type="text" name="productName" required maxlength="30"></br>
    
<!--                 <label for="productDescription">Product Description</label>
                <textarea name="productDescription", required, rows="5" cols="60"></textarea> <br> -->
                
                <label for="unitPrice">Unit Price</label>
                <input type="text" name="unitPrice" required maxlength="10"></br>

                <Label for="category">Category</Label><br>
                <select name="category" required>
                    <option value="Speakers">Speakers</option>
                    <option value="Headphones">Headphones</option>
                    <option value="Earbuds">Earbuds</option>
                    <option value="Amplifiers">Amplifiers</option>
                </select>
                <br>
                
                <label for="productName">Stock</label>
                <input type="text" name="stock" required maxlength="30"></br>
                
                <br>
                <label for="image"> Product Image</label>
                <input type="file" name="image" accept="image/*">
                
                <input type="submit" value="Add">
                
            </form>
          
        </div>
		<footer>
            <p>&copy; 2024 Idealism. All rights reserved.</p>
        </footer>
    </body>
</html>