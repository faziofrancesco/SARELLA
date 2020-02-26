<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Footer - Agriturismo Sarella</title>
    <%@include file="include.jsp" %>
</head>

<body>
<footer class="page-footer dark" style="padding-top: 1%;">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-3 d-flex flex-column align-content-center align-items-lg-center justify-content-xl-start align-items-xl-center col-sm-4">
                <h5>Get started</h5>
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <% if((request.getSession().getAttribute("logged") == null || !(boolean)request.getSession().getAttribute("logged"))) {%>
                    <li><a role="button" data-target="modal" data-toggle="#loginModal">Sign In</a></li>
                    <%} else {%>
                    <li><a href="service-page.jsp">Vai al profilo</a></li>
                    <%}%>
                    <% if((request.getSession().getAttribute("logged") == null || !(boolean)request.getSession().getAttribute("logged"))) {%>
                    <li><a role="button" data-target="modal" data-toggle="#registrationModal">Sign Up</a></li>
                    <%} else {%>
                    <li><a href="logout">Logout</a></li>
                    <%}%>
                </ul>
            </div>
            <div class="col-sm-3 d-flex d-xl-flex flex-column align-items-lg-center justify-content-xl-start align-items-xl-center col-sm-4">
                <h5>About us</h5>
                <ul>
                    <li><a href="#">Company Information</a></li>
                    <li><a href="#">Contact us</a></li>
                    <li><a href="#">Reviews</a></li>
                </ul>
            </div>
            <div class="col-sm-3 d-none flex-column align-items-lg-center justify-content-xl-start align-items-xl-center col-sm-4">
                <h5>Legal</h5>
                <ul>
                    <li><a href="#">Terms of Service</a></li>
                    <li><a href="#">Terms of Use</a></li>
                    <li><a href="#">Privacy Policy</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="footer-copyright">
        <p>© 2018 Copyright Text</p>
    </div>
</footer>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
<script src="assets/js/smoothproducts.min.js"></script>
<script src="assets/js/theme.js"></script>
</body>

</html>