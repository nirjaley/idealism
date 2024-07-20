<%@page import="model.*"%>
<%@page import="controller.database.DatabaseController"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="util.StringUtils"%>
<%
    // Get the session and request objects
    HttpSession userSession = request.getSession();
    String currentUser = (String) userSession.getAttribute("UserEmail");
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Idealism</title>
    <link rel="stylesheet" href="../stylesheets/style.css"> 
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
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
                <li>
                <form action="<%
                    // Conditionally set the action URL based on user session
                    if (currentUser != null) {
                        out.print(contextPath + StringUtils.SERVLET_URL_LOGOUT);
                    } else {
                        out.print(contextPath + StringUtils.PAGE_URL_LOGIN);
                    }
                %>" method="post">
                    <input type="submit" class="formSubmitButton" value="<%
                        // Conditionally set the button label based on user session
                        if (currentUser != null) {
                            out.print(StringUtils.LOGOUT);
                        } else {
                            out.print(StringUtils.LOGIN);
                        }
                    %>"/>
                </form></li>
                <li><a href="userProfile.jsp"><img src="../images/user.png"></a></li>
            </ul>
        </div>
    </header>

    <main>
        <section class="intro">
            <h2>Welcome to Idealism</h2>
            <p>Idealism, more like minimalism.</p>
            <a href="#featured-products" class="btn">Explore Products</a>
        </section>

            <div id="slider">
                <figure>
                    <img src="../images/ad4.png">
                    <img src="../images/ad2.jpg">
                    <img src="../images/ad3.png">
                    <img src="../images/ad1.webp">
                    <img src="../images/ad4.png">
                </figure>
            </div>

        <section id="featured-products" class="featured-products">
            <h2>Featured Products</h2>
            <div class="product">
                <img src="../images/edifier headphone.png" alt="Product 1">
                <h3>Edifier Headphones</h3>
                <p>Rs 2499</p>
                <a href="/idealism/add-to-cart?product_id=1" class="get-now-btn">Add to Cart</a>

            </div>
            <div class="product">
                <img src="../images/earbuds.png" alt="Product 2">
                <h3>Jogger's Earbuds</h3>
                <p>Rs 2999</p>
                <a href="/idealism/add-to-cart?product_id=2" class="get-now-btn">Add to Cart</a>
            </div>
            <div class="product">
                <img src="../images/minibluethooth.jpg" alt="Product 3">
                <h3>Portable Bluetooth Speaker</h3>
                <p>Rs 2899</p>
                <a href="/idealism/add-to-cart?product_id=3" class="get-now-btn">Add to Cart</a>
            </div>
            <div class="product">
                <img src="../images/ibanez amp.jpg" alt="Product 4">
                <h3>Ibanez Guitar Amplifier</h3>
                <p>Rs 7999</p>
                <a href="/idealism/add-to-cart?product_id=4" class="get-now-btn">Add to Cart</a>
            </div>
        </section>

        <section class="headphones">
            <h2>Headphones</h2>
            <div class="product">
                <img src="../images/cosmicheadphones.jpg" alt="Product 5">
                <h3>Cosmic Gaming Headphones</h3>
                <p>Rs 3599</p>
                <a href="/idealism/add-to-cart?product_id=5" class="get-now-btn">Add to Cart</a>
            </div>
            <div class="product">
                <img src="../images/razer headphones.webp" alt="Product 6">
                <h3>Razer Blackshark Headphones</h3>
                <p>Rs 9999</p>
                <a href="/idealism/add-to-cart?product_id=6" class="get-now-btn">Add to Cart</a>
            </div>
            <div class="product">
                <img src="../images/earfolding.webp" alt="Product 7">
                <h3>Ear Folding Bluethooth Headphones</h3>
                <p>Rs 5999</p>
                <a href="/idealism/add-to-cart?product_id=7" class="get-now-btn">Add to Cart</a>
            </div>
            <div class="product">
                <img src="../images/stereoheadphones.webp" alt="Product 8">
                <h3>Stereo Wireless Headphones</h3>
                <p>Rs 3999</p>
                <a href="/idealism/add-to-cart?product_id=8" class="get-now-btn">Add to Cart</a>
                </div>
        </section>

        <section class="earbuds">
            <h2>Earbuds</h2>
            <div class="product">
                <img src="../images/cobra.webp" alt="Product 9">
                <h3>Cobra Noise Reduction Earbuds</h3>
                <p>Rs 4999</p>
                <a href="/idealism/add-to-cart?product_id=9" class="get-now-btn">Add to Cart</a>
            </div>
            <div class="product">
                <img src="../images/tronsmart.jpg" alt="Product 10">
                <h3>Tronsmart Battle Gaming Earbuds</h3>
                <p>Rs 2499</p>
                <a href="/idealism/add-to-cart?product_id=10" class="get-now-btn">Add to Cart</a>
            </div>
            <div class="product">
                <img src="../images/Retro Earbuds.jpg" alt="Product 11">
                <h3>Noise earbuds</h3>
                <p>Rs 3999</p>
                <a href="/idealism/add-to-cart?product_id=11" class="get-now-btn">Add to Cart</a>
            </div>
            <div class="product">
                <img src="../images/boAtearbuds.jpg" alt="Product 12">
                <h3>Beats Studio Buds</h3>
                <p>Rs 3999</p>
                <a href="/idealism/add-to-cart?product_id=12" class="get-now-btn">Add to Cart</a>
                </div>
        </section>
    </main>

    <footer>
        <p>&copy; 2024 Idealism. All rights reserved.</p>
    </footer>
</body>
