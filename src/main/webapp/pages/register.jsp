<%
String contextPath = request.getContextPath();
%>
<%@page import="util.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
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

        .mainRegisterContainer {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            width: 500px;
            padding: 20px;
            background-color: #dddddd;
            box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);
            border-radius: 15px;
        }

        .mainRegisterContainer .closeButton {
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

        .mainRegisterContainer .headingRegisterForm {
            text-align: center;
            margin-bottom: 20px;
        }

        .mainRegisterContainer .headingRegisterForm h1 {
            font-size: 25px;
        }

        .mainRegisterContainer .registerForm {
            margin-bottom: 15px;
        }

        .mainRegisterContainer .registerForm label {
            display: block;
            font-size: 18px;
            margin-bottom: 2px;
        }

        .mainRegisterContainer .registerForm input[type="text"],
        .mainRegisterContainer .registerForm input[type="tel"],
        .mainRegisterContainer .registerForm input[type="email"],
        .mainRegisterContainer .registerForm input[type="password"] {
            width: 100% ;
            padding: 10px;
            border: 2px solid #aaa;
            border-radius: 5px;
            outline: none;
        }

        .mainRegisterContainer .registerForm input[type="text"]:focus,
        .mainRegisterContainer .registerForm input[type="tel"]:focus,
        .mainRegisterContainer .registerForm input[type="email"]:focus,
        .mainRegisterContainer .registerForm input[type="password"]:focus {
            border-color: #555;
        }

        .Signup {
            display: block;
            width: 100%;
            padding: 10px;
            font-size: 18px;
            font-weight: bold;
            border: none;
            border-radius: 10px;
            background-color: #5ac65d;
            color: #fff;
            cursor: pointer;
        }

        .Signup:hover {
            background-color: forestgreen;
        }
    </style>
</head>
<body>
    <form action="<%=contextPath%>/Register" method="post">
        <div class="mainRegisterContainer">
            <a href="home.jsp" class="closeButton"> &times; </a>
            <div class="headingRegisterForm">
                <h1>Register</h1>
            </div>
            <div class="registerForm">
                <label for="firstname">Firstname</label>
                <input type="text" id="firstname" placeholder="Enter your firstname here" name="first_name" required>
            </div>
            <div class="registerForm">    
                <label for="lastname">Lastname</label>
                <input type="text" id="lastname" placeholder="Enter your lastname here" name="last_name" required>
            </div>
            <div class="registerForm">
                <label for="phoneNumber">Phone Number</label>
                <input type="tel" id="phoneNumber" placeholder="Enter your phone number here" name="phone_number" required>
            </div>
            <div class="registerForm">  
                <label for="address">Address</label>
                <input type="text" id="address" placeholder="Enter your address here" name="address" required>
            </div>
            <div class="registerForm">
                <label for="email">E-mail</label>
                <input type="email" id="email" placeholder="Enter your e-mail here" name="email" required>
            </div>
            <div class="registerForm">
                <label for="password">Password</label>
                <input type="password" id="password" placeholder="Create a new password" name="password" required>
            </div>
            <div class="registerForm">
                <label for="retypePassword">Re-type Password</label>
                <input type="password" id="retypePassword" placeholder="Re-type your password here" name="retypePassword" required>
            </div>
           	 	<form action="<%= request.getContextPath() + StringUtils.PAGE_URL_HOME %>" method="post">
                <button class="Signup" type="submit">Sing-Up</button>
       			</form>
        </div>
    </form>
</body>
</html>