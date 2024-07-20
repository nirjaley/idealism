<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Product"%>

<%
    List<Product> searchResults = (List<Product>) request.getAttribute("search_results");
    String searchError = (String) request.getAttribute("search_error");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Idealism - Search Results</title>
</head>
<body>
    <h1>Search Results</h1>

    <c:if test="${not empty searchError}">
        <p style="color: red;">An error occurred: ${searchError}</p>
    </c:if>
    
    <c:if test="${not empty searchResults}">
        <ul>
            <c:forEach items="${searchResults}" var="product">
                <li><a href="home.jsp"> ${product.product_name} (Rs ${product.unit_price})</a></li>
            </c:forEach>
        </ul>
    </c:if>

    <c:if test="${empty searchResults}">
        <p>No results found for your search.</p>
    </c:if>
</body>
</html>
