<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Footer - Agriturismo Sarella</title>
    <%@include file="include.jsp"%>
</head>

<body>
    <footer class="page-footer dark" style="padding-top: 1%;">
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 d-flex flex-column align-content-center align-items-lg-center justify-content-xl-start align-items-xl-center col-sm-4">
                    <h5>Get started</h5>
                    <ul>
                        <li><a href="#">Home</a></li>
                        <li><a href="#">Sign In</a></li>
                        <li><a href="#">Sign Up</a></li>
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
            <div class="row">
                <div class="col" style="background-color: #ffffff;">
                    <div class="d-flex flex-column flex-shrink-1 justify-content-center align-items-center align-self-center container" style="padding: 2%;">
                        <div class="intro">
                            <h2 class="text-center">Newsletter</h2>
                            <p class="text-center">Subscribe for the latest info!</p>
                        </div>
                        <form class="d-flex justify-content-center form-inline" method="post">
                            <div class="d-flex justify-content-sm-center align-items-sm-center form-group"><input class="form-control" type="email" name="email" placeholder="Your Email" required="" style="margin-right: 5%;"></div>
                            <div class="form-group"><button class="btn btn-primary d-xl-flex align-self-center justify-content-xl-center align-items-xl-center" type="submit">Submit</button></div>
                        </form>
                    </div>
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