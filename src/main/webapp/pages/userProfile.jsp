<%@page import="util.StringUtils"%>
<%@page import="model.UserModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <style>
        * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    background-color: #f2f2f0;
    font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
}

.mainUserProfileContainer {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    width: 450px;
    padding: 20px;
    background-color: #dddddd;
    box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);
    border-radius: 15px;
}

.mainUserProfileContainer .closeButton {
    position: absolute;
    top: 20px;
    right: 25px;
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

.profileInfo {
    padding: 10px 5px;
}

.profileInfo .field {
    margin-bottom: 20px;
}

.profileInfo label {
    display: block;
    font-size: 18px;
    margin-bottom: 5px;
}

.profileInfo input[type="text"],
.profileInfo input[type="tel"],
.profileInfo input[type="email"],
.profileInfo input[type="password"] {
    width: 390px; 
    padding: 10px;
    border: 2px solid #aaa;
    border-radius: 5px;
    outline: none;
}

.profileInfo input[type="text"]:focus,
.profileInfo input[type="tel"]:focus,
.profileInfo input[type="email"]:focus,
.profileInfo input[type="password"]:focus {
    border-color: #555;
}

.profileInfo p {
    font-size: 14px;
    margin-top: 5px;
}

.saveChangesButton {
    display: block;
    width: 400px;
    padding: 10px;
    font-size: 18px;
    font-weight: bold;
    border: none;
    border-radius: 20px;
    background-color: #5ac65d;
    color: #fff;
    cursor: pointer;
    margin-top: 20px;
}

.saveChangesButton:hover {
    background-color: rgb(65, 228, 138);
}

.logOutButton {
    display: block;
    width: 400px;
    padding: 10px;
    font-size: 18px;
    font-weight: bold;
    border: none;
    border-radius: 20px;
    background-color: #575757;
    color: #fff;
    cursor: pointer;
    margin-top: 20px;
}

.logOutButton:hover {
    background-color: rgb(204, 100, 36);
}

.logInButton {
	display: block;
    width: 400px;
    padding: 10px;
    font-size: 18px;
    font-weight: bold;
    border: none;
    border-radius: 20px;
    background-color: #575757;
    color: #fff;
    cursor: pointer;
    margin-top: 20px;
}
.logInButton:hover {
	background-color: #333;
}

    </style>
</head>
<body>
    <div class="mainUserProfileContainer">
   	   <form action="<%= request.getContextPath() + StringUtils.PAGE_URL_HOME %>" method="post">
                <button class="closeButton" type="submit">&times;</button>
       </form>
       <h1>User Profile</h1>
       <c:choose>
        <c:when test="${not empty sessionScope.UserEmail || sessionScope.UserEmail == ''}">
        	<div class="profileInfo">
            	<div class="field">
                	<label for="firstname">First Name:</label>
                	<input type="text" value="${userProfile.firstName}" readonly>
            	</div>
           	 <div class="field">
               	 <label for="lastname">Last Name:</label>
               	 <input type="text" value="${userProfile.lastName}" readonly>
           	 </div>
           	 <div class="field">
               	 <label for="address">Address:</label>
              	 <input type="text" id="address" value="${userProfile.address}" >
               	 <p>Tap above to change your Address</p>
            	</div>
           	 <div class="field">
               	 <label for="phone">Phone Number:</label>
               	 <input type="tel" id="phone" value="${userProfile.phoneNumber}" pattern="[0-9]{10}">
               	 <p>Tap above to change your Phone Number</p>
            </div>
            <div class="field">
               	 <label for="email">Email:</label>
                <input type="email" value="${userProfile.email}" readonly>
            </div>
            <div class="field">
                <label for="password">Password:</label>
                <input type="password" id="password" value="${userProfile.password}">
                <p>Tap above to change your Password</p>
            </div>
            <form action="<%= request.getContextPath() + StringUtils.SERVLET_URL_USER_PROFILE_USER %>" method="post">
                <button class="saveChangesButton" type="submit">Save Changes</button>
            </form>
           <form action="<%= request.getContextPath() + StringUtils.SERVLET_URL_LOGOUT %>" method="post">
                <button class="logOutButton" type="submit">Log Out</button>
            </form>
        </div>
	</c:when>
	<c:otherwise> 
        	<p>No user logged in</p>
        	<form action="<%= request.getContextPath() + StringUtils.SERVLET_URL_LOGIN %>" method="post">
        		<button class="logInButton" type="submit">Log In</button>
    		</form>
	</c:otherwise>
	</c:choose>
    </div>
</body>
</html>





