<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Shopping Cart - Agriturismo Sarella</title>
    <%@include file="include.jsp" %>
    <meta name="description" content="I cinghiali lo amano, i sanpietresi lo temono.">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="assets/fonts/simple-line-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="assets/css/Newsletter-Subscription-Form.css">
    <link rel="stylesheet" href="assets/css/smoothproducts.css">
    <script type="text/javascript" src="assets/js/cart.js"></script>
</head>

<body>
<%@ include file="header.jsp" %>

<div style="width:100%; height:15%"></div>

    <main class="page shopping-cart-page">
        <section class="clean-block clean-cart dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Shopping Cart</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna, dignissim nec auctor in, mattis vitae leo.</p>
                </div>
                <div class="content">
                    <div class="row no-gutters">
                        <div class="col-md-12 col-lg-8">
                            <div class="items">
                            <c:forEach items="${ordrooms}" var="ordrooms">
                                <div class="product">
                                    <div class="row justify-content-center align-items-center">
                                        <div class="col-md-3">
                                            <div class="product-image">
                                                <img class="img-fluid d-block mx-auto image" src="images/${ordrooms.getImagePath()}">
                                            </div>
                                        </div>
                                        <div class="col-md-5 product-info">
                                            <a class="product-name" href="#">Camera no. ${ordrooms.getIdCamera()}</a>
                                            <div class="product-specs">
                                                <p>${ordrooms.getDescrizione()}</p>
                                            </div>
                                        </div>
                                        <div class="col-6 col-md-2 quantity">
                                            <label class="d-none d-md-block" for="eliminaPren">Elimina?</label>
                                            <a id="eliminaPren" onclick="delp(${ordrooms.getIdCamera()})"></a>
                                        </div>
                                        <div class="col-6 col-md-2 price"><span>$ ${ordrooms.getPrice()}</span></div>
                                    </div>
                                </div>
                            </c:forEach>
                            </div>
                        <div class="col-md-12 col-lg-4">
                            <div class="summary">
                                <h3>Summary</h3>
                                <h4><span class="text">Subtotal</span><span class="price">$ ${totPrice}</span></h4>
                                <h4><span class="text">Total</span><span class="price">$ ${totPrice}</span></h4>
                                <button class="btn btn-primary btn-block btn-lg" type="button">Paga con PayPal</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>

<%@ include file="footer.jsp" %>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    <script src="assets/js/smoothproducts.min.js"></script>
    <script src="assets/js/theme.js"></script>
</body>

</html>