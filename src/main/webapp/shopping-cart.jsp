<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Shopping Cart - Agriturismo Sarella</title>
    <meta name="description" content="I cinghiali lo amano, i sanpietresi lo temono.">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="assets/fonts/simple-line-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="assets/css/Newsletter-Subscription-Form.css">
    <link rel="stylesheet" href="assets/css/smoothproducts.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <script type="text/javascript" src="assets/js/cart.js"></script>
    <%@ include file="include.jsp" %>


</head>

<body>
<%@ include file="header.jsp" %>

<div style="width:100%; height:15%"></div>

    <main class="page shopping-cart-page">
        <section class="clean-block clean-cart dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Shopping Cart</h2>
                    <p></p>
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
                                        <div class="col-6 col-md-2 price"><span><p>$ ${ordrooms.getPrezzo()}</p></span></div>
                                        <button class="btn btn-primary col-6 col-md-2 quantity" style="padding-right:2%"
                                                type="button" id="btndeletep" onclick="delp(${ordrooms.getIdCamera()})">Elimina prenotazioni</button>
                                    </div>
                                </div>
                            </c:forEach>
                            </div>
                        </div>
                        <div class="col-md-12 col-lg-4">
                            <div class="summary" style="padding: 8% 8% 16% 8%">
                                <h3>Summary</h3>
                                <h4><span class="text">Subtotal</span><span class="price"><p>$ ${totPrice}</p></span></h4>
                                <h4><span class="text">Total</span><span class="price"><p>$ ${totPrice}</p></span></h4>
                                <!-- START PAYPAL PAYMENTS-->
                                <div class ="float-right" id="paypal-button"></div>
                                <script src="https://www.paypalobjects.com/api/checkout.js"></script>

                                <script>
                                paypal.Button.render({
                                        // Configure environment
                                        env: 'sandbox',
                                        client: {
                                            sandbox: 'AeVv1fuwCcg9YddrZS1IYJ93ukIOEOSJfrUc85dWzGRY7oTHhhbhbJ-lUBCuqfAxB-CcdqinWZ1MXJPJ',
                                        },
                                        // Customize button (optional)
                                        locale: 'it_IT',
                                        style: {
                                            size: 'small',
                                            color: 'gold',
                                            shape: 'pill',
                                        },

                                        // Enable Pay Now checkout flow (optional)
                                        commit: true,

                                        // Set up a payment
                                        payment: function(data, actions) {
                                            return actions.payment.create({
                                                transactions: [{
                                                    amount: {
                                                        total: '${totPrice}',
                                                        currency: 'EUR'
                                                    }
                                                }]
                                            });
                                        },
                                        // Execute the payment
                                        onAuthorize: function(data, actions) {
                                            return actions.payment.execute().then(function()
                                            {
                                                // Show a confirmation message to the buyer
                                                var alert = window.alert('Pagamento avvenuto con successo!');

                                            }).then(function(){
                                                $.post("/Paga",
                                                    function() {

                                                        window.location.replace("/homepage");
                                                    }
                                                );
                                            });
                                        }
                                    }, '#paypal-button');
                                </script>
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