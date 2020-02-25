<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Header - Agriturismo Sarella</title>
    <%@include file="include.jsp" %>
    <script type="text/javascript" src="assets/js/login.js"></script>
    <script type="text/javascript" src="assets/js/user.js"></script>
    <link rel="stylesheet" type="text/css" href="assets/css/calendar.css">
    <link rel="stylesheet" type="text/css" href="assets/css/calendar.css">
    <script type="text/javascript" src="assets/js/rooms.js"></script>
    <script type="text/javascript" src="assets/js/calendar.js"></script>
    <script type="text/javascript" src="assets/js/retrievecredentials.js"></script>
    <meta name="description" content="I cinghiali lo amano, i sanpietresi lo temono.">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    <script src="assets/js/smoothproducts.min.js"></script>
    <script src="assets/js/theme.js"></script>
    <link rel="stylesheet" href="assets/css/Newsletter-Subscription-Form.css">
    <link rel="stylesheet" href="assets/css/smoothproducts.css">
    <script src="assets/js/header.js"></script>
</head>

<body>
<nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar" style="padding-bottom: 0px;">
    <div class="container">
        <p class="align-self-center navbar-brand logo" id="header-title"
           style="padding-left: 5px;padding-right: 5px;margin-right: 0;margin-bottom: 12px;">Agriturismo Sarella</p>
        <button data-toggle="collapse" class="navbar-toggler align-self-center" data-target="#navcol-1"
                style="min-height: 50px;height: 50px;margin-bottom: 12px;margin-right: 0px;"><span class="sr-only">Toggle navigation</span><span
                class="navbar-toggler-icon align-self-center"></span></button>
        <div
                class="collapse navbar-collapse" id="navcol-1">
            <div class="table-responsive table-borderless d-flex flex-row justify-content-start align-items-center">
                <table class="table table-bordered table-sm">
                    <tbody>
                    <tr>
                        <td class="text-center nav-item" role="presentation"><a
                                class="text-center d-inline-block small-padding index-a" href="index.jsp"
                                style="color: rgb(134,138,143);" title="Home">Home</a></td>
                        <td class="text-center nav-item" role="presentation"><a
                                class="text-center d-inline-block small-padding index-a"
                                data-toggle="modal" data-target="#roomsModal" style="color: rgb(134,138,143);" title="Rooms">Rooms</a>
                        </td>
                        <td class="text-center nav-item" role="presentation"><a
                                class="text-center d-inline-block small-padding index-a" href="#"
                                style="color: rgb(134,138,143);" title="About us">About us</a></td>
                        <td class="text-center nav-item" role="presentation">
                                <% if((request.getSession().getAttribute("logged") == null || !(boolean)request.getSession().getAttribute("logged"))) {%>
                            <a class="text-center border rounded d-inline-block small-padding btn btn-info"
                               title="Sign In" role="button" data-toggle="modal" data-target="#loginModal">Sign In</a>
                                <%} else {%>
                                    <div class="dropdown show" style="position:absolute; z-index:100">
                                        <a id="usernameDropdown" data-toggle="dropdown" aria-expanded="false" aria-haspopup="true" href="#"
                                           class="dropdown-toggle text-center border rounded d-inline-block small-padding btn btn-info">${username}</a>
                                        <div role="menu" class="dropdown-menu">
                                            <a role="presentation" class="dropdown-item" href="service-page.jsp">Vai al profilo</a>
                                            <a role="presentation" class="dropdown-item" href="#">Carrello</a>
                                            <a role="presentation" class="dropdown-item" data-toggle="modal" data-target="#myModal">Eventi</a>
                                        </div>
                                    </div>
                                <% }%>
                    </tr>
                    <tr>
                        <td class="text-center nav-item" role="presentation"><a
                                class="text-center d-inline-block small-padding index-a" href="#"
                                style="color: rgb(134,138,143);" title="Blog">Blog</a></td>
                        <td class="text-center nav-item" role="presentation"><a
                                class="text-center d-inline-block small-padding index-a"
                                href="#" style="color: rgb(134,138,143);"
                                title="Products">Products</a></td>
                        <td class="text-center nav-item" role="presentation"><a
                                class="text-center d-inline-block small-padding index-a" href="#"
                                style="color: rgb(134,138,143);" title="Contacts">Contacts</a></td>
                        <td class="text-center nav-item" role="presentation">
                                <% if((request.getSession().getAttribute("logged") == null || !(boolean)request.getSession().getAttribute("logged"))) {%>
                            <a class="text-center border rounded d-inline-block small-padding btn btn-info"
                               title="Sign Up" role="button" data-toggle="modal" data-target="#registrationModal">Sign Up</a>
                                <%} else {%>
                                <% if((request.getSession().getAttribute("userGoogle") == null || !(boolean)request.getSession().getAttribute("userGoogle"))) {%>
                            <a id="signOutButton" class="text-center border rounded d-inline-block small-padding btn btn-info"
                               title="Sign Out" role="button" href="logout">Sign Out</a>
                                <%} else {%>
                                    <a id="signOutButton" href="logout" onclick="signOut()">Sign out with Google</a>
                                    <script>
                                        function signOut() {
                                            let auth2 = gapi.auth2.getAuthInstance();
                                            auth2.signOut().then(function () {
                                                console.log('User signed out.');

                                            });
                                        }
                                    </script>

                                <%}
                                }%>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</nav>

<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&#10006;</button>
                <h4 class="modal-title">Eventi Agriturismo</h4>
            </div>
            <div class="modal-body">
                <iframe id="videoContainer" width="750" height="400" src="calendar.jsp" frameborder="100" allowfullscreen></iframe>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" role="dialog" tabindex="-1" id="loginModal">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Login</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">×</span></button>
            </div>
            <div class="modal-body">
                <% if((request.getSession().getAttribute("userGoogle") == null || !(boolean)request.getSession().getAttribute("userGoogle"))){%>
                    <div class="g-signin2" data-onsuccess="onSignIn"></div>
                    <script>
                        function onSignIn(googleUser) {
                            googleSignIn(googleUser);
                        }
                    </script>
                <%}%>

                <form>
                    <div class="form-group">
                        <label for="Login-username">Username</label>
                        <input class="form-control item" type="text" id="Login-username" placeholder="Your username">
                    </div>
                    <div class="form-group">
                        <label for="Login-password">Password</label>
                        <input class="form-control item" type="password" id="Login-password" placeholder="Your password">
                    </div>
                    <div class="form-group">
                        <div class="form-check"><input class="form-check-input" type="checkbox" id="checkbox"><label
                                class="form-check-label" for="checkbox">Remember me</label></div>
                    </div>
                    <div class="form-group">
                        <label for="createAccount" style="padding: 0px;padding-left: 0px;padding-right: 0px;">Don't have an account yet?&nbsp;</label>
                        <a id="createAccount" href="#" data-toggle="modal" data-target="#registrationModal">Create an account</a>
                    </div>
                    <div class="form-group d-xl-flex flex-shrink-1 align-items-xl-center"
                         style="margin-bottom: 0px;height: 32px;"><a class="text-left d-xl-flex align-items-xl-center"
                                                                     style="height: 32px;width: 466px;"
                                                                     data-toggle="modal" data-target="#retrievalModal"
                                                                     href="#"><br>Don't remember username or
                        password?<br><br></a></div>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" type="button" id="btnLogin" onclick="loginUser(event)">Accedi</button>
            </div>

            </div>
    </div>
</div>
<div class="modal fade" role="dialog" tabindex="-1" id="retrievalModal">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Recupera credenziali</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">&#10006;</button>
            </div>
            <div class="modal-body">
                <div>
                    <ul class="nav nav-tabs">
                        <li class="nav-item"><a class="nav-link active" role="tab" data-toggle="tab" href="#tab-1">Username</a>
                        </li>
                        <li class="nav-item"><a class="nav-link" role="tab" data-toggle="tab" href="#tab-2">Password</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active" role="tabpanel" id="tab-1">
                            <form>
                                <div class="form-group"><label for="retrieve-username">E-mail</label><input
                                        class="form-control item" type="email" id="retrieve-username" placeholder="Your e-mail">
                                    <button class="btn btn-primary" type="button" style="margin-top: 5%;" id="retrieve-usernamebt" onclick="retrieveusername(event)">Invia
                                        informazioni
                                    </button>
                                </div>
                            </form>
                        </div>
                        <div class="tab-pane" role="tabpanel" id="tab-2">
                            <form>
                                <div class="form-group"><label for="emailemail">Username</label><input
                                        class="form-control item" type="email" id="emailemail" placeholder="Your email">
                                </div>
                                <div class="form-group"><label for="userpass">username</label><input
                                        class="form-control" type="text" id="userpass" placeholder="Your username">
                                    <button class="btn btn-primary" type="button" style="margin-top: 5%;"  id="retrieve-passwordbt" onclick="retrievepassword(event)">Invia
                                        informazioni
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade justify-content-center align-items-center" role="dialog" tabindex="-1" id="registrationModal">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">RegistrationForm</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">&#10006;</button>
            </div>
            <div class="modal-body">
                <form id="regForm" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="reg-name">Nome</label>
                        <input class="form-control item" type="text" id="reg-name" name="reg-name" placeholder="Your name">
                    </div>
                    <div class="form-group">
                        <label for="reg-surname">Cognome</label>
                        <input class="form-control item" type="text" id="reg-surname" name="reg-surname" placeholder="Your surname">
                    </div>
                    <div class="form-group">
                        <label for="reg-date">Data di nascita</label>
                        <input class="form-control item" id="reg-date" name="reg-date" type="date" required=""></div>
                    <div class="form-group">
                        <label for="reg-username">Username</label>
                        <input class="form-control item" type="text" id="reg-username" name="reg-username" placeholder="Your Username" required="">
                    </div>
                    <div class="form-group">
                        <label for="reg-password">Password</label>
                        <input class="form-control item" type="password" name="reg-password" id="reg-password" placeholder="Your password" required="">
                    </div>
                    <div class="form-group">
                        <label for="reg-email">Email</label>
                        <input class="form-control item" type="email" id="reg-email" name="reg-email" placeholder="Your e-mail" required=""></div>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" type="button" id="btnregistration" onclick="registerUser('#regForm')">
                    Procedi alla registrazione
                </button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" role="dialog" tabindex="-1" id="roomsModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Scegli il periodo di permanenza</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">&#10006;</button></div>
            <div class="modal-body">
                <form id="roomForm" method="get" action="rooms-handler">
                <div id="andata" class="form-group">
                    <label for="arrivalDate" title="Data di partenza"> Data Check-In</label>
                    <input type="date" id="arrivalDate" name="arrivalDate" required="" class="form-control item">
                </div>
                <div id="ritorno" class="form-group">
                    <label for="departureDate" title="Data di ritorno"> Data Check-Out </label>
                    <input type="date" id="departureDate" name="departureDate" required="" class="form-control item">
                </div>
                    <input type="hidden" id="target" name="target" value="show">
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" type="button" onclick="showRooms('#roomForm')">Cerca una camera</button>
            </div>
        </div>
    </div>
</div>

<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/smoothproducts.min.js"></script>
<script src="assets/js/theme.js"></script>
<script src="assets/js/header.js"></script>
</body>

</html>