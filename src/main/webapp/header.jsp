<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Header - Agriturismo Sarella</title>
    <%@include file="include.jsp"%>
</head>

<body>
    <nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar" style="padding-bottom: 0px;">
        <div class="container">
            <p class="align-self-center navbar-brand logo" id="header-title" style="padding-left: 5px;padding-right: 5px;margin-right: 0;margin-bottom: 12px;">Agriturismo Sarella</p><button data-toggle="collapse" class="navbar-toggler align-self-center" data-target="#navcol-1" style="min-height: 50.8;height: 50.8px;margin-bottom: 12px;margin-right: 0;"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon align-self-center"></span></button>
            <div
                class="collapse navbar-collapse" id="navcol-1">
                <div class="table-responsive table-borderless d-flex flex-row justify-content-start align-items-center">
                    <table class="table table-bordered table-sm">
                        <tbody>
                            <tr>
                                <td class="text-center nav-item" role="presentation"><a class="text-center d-inline-block small-padding index-a" href="index.jsp" style="color: rgb(134,138,143);" title="Home">Home</a></td>
                                <td class="text-center nav-item" role="presentation"><a class="text-center d-inline-block small-padding index-a" href="rooms/rooms-catalog-page.html" style="color: rgb(134,138,143);" title="Rooms">Rooms</a></td>
                                <td class="text-center nav-item" role="presentation"><a class="text-center d-inline-block small-padding index-a" href="infos/about-us.html" style="color: rgb(134,138,143);" title="About us">About us</a></td>
                                <td class="text-center nav-item" role="presentation">
                                    <% if(true) {%>
                                        <a class="text-center border rounded d-inline-block small-padding btn btn-info" title="Sign In" role="button" data-toggle="modal" data-target="#loginModal">Sign In</a>
                                    <%} else {%>
                                        <a class="text-center border rounded d-inline-block small-padding btn btn-info" title="${username}" role="button">${username}</a>
                                    <% }%>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-center nav-item" role="presentation"><a class="text-center d-inline-block small-padding index-a" href="blog-post-list.html" style="color: rgb(134,138,143);" title="Blog">Blog</a></td>
                                <td class="text-center nav-item" role="presentation"><a class="text-center d-inline-block small-padding index-a" href="products/products-catalog-page.html" style="color: rgb(134,138,143);" title="Products">Products</a></td>
                                <td class="text-center nav-item" role="presentation"><a class="text-center d-inline-block small-padding index-a" href="infos/contact-us.html" style="color: rgb(134,138,143);" title="Contacts">Contacts</a></td>
                                <td class="text-center nav-item" role="presentation">
                                    <% if(true) {%>
                                        <a class="text-center border rounded d-inline-block small-padding btn btn-info" title="Sign Up" role="button" data-toggle="modal" data-target="#registrationModal">Sign Up</a>
                                    <%} else {%>
                                        <a class="text-center border rounded d-inline-block small-padding btn btn-info" title="Log Out" role="button">Log Out</a>
                                    <%}%>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
        </div>
        </div>
    </nav>
    <div class="modal fade" role="dialog" tabindex="-1" id="loginModal">
        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Login</h4><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button></div>
                <div class="modal-body">
                    <form>
                        <div class="form-group"><label for="email">Username</label><input class="form-control item" type="email" id="email" placeholder="Your username"></div>
                        <div class="form-group"><label for="password">Password</label><input class="form-control" type="password" id="password" placeholder="Your password"></div>
                        <div class="form-group">
                            <div class="form-check"><input class="form-check-input" type="checkbox" id="checkbox"><label class="form-check-label" for="checkbox">Remember me</label></div>
                        </div>
                        <div class="form-group"><label for="password" style="padding: 0px;padding-left: 0px;padding-right: 0px;">Don't have an account yet?&nbsp;</label><a href="#" data-toggle="modal" data-target="#registrationModal">Create an account</a></div>
                        <div class="form-group d-xl-flex flex-shrink-1 align-items-xl-center"
                            style="margin-bottom: 0px;height: 32px;"><a class="text-left d-xl-flex align-items-xl-center" style="height: 32px;width: 466px;" href="#"><br>Don't remember username or password?<br><br></a></div>
                    </form>
                </div>
                <div class="modal-footer"><button class="btn btn-primary" type="button">Accedi</button></div>
            </div>
        </div>
    </div>
    <div class="modal fade justify-content-center align-items-center" role="dialog" tabindex="-1" id="registrationModal">
        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">RegistrationForm</h4><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button></div>
                <div class="modal-body">
                    <form>
                        <div class="form-group"><label >Nome</label><input class="form-control item" type="text" id="reg-name" placeholder="Your name"></div>
                        <div class="form-group"><label >Cognome</label><input class="form-control item" type="text" id="reg-surname" placeholder="Your surname"></div>
                        <div class="form-group"><label >Data di nascita</label><input class="form-control item" id="reg-date" type="date"></div>
                        <div class="form-group"><label for="password">Password</label><input class="form-control item" type="password" id="reg-password" placeholder="Your password"></div>
                        <div class="form-group"><label for="email">Email</label><input class="form-control item" type="email" id="reg-email" placeholder="Your e-mail"></div>
                    </form>
                </div>
                <div class="modal-footer"><button class="btn btn-primary" type="button">Procedi alla registrazione</button></div>
            </div>
        </div>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    <script src="assets/js/smoothproducts.min.js"></script>
    <script src="assets/js/theme.js"></script>
</body>

</html>