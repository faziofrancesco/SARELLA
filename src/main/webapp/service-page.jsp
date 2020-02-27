<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Services - Agriturismo Sarella</title>
    <meta name="description" content="I cinghiali lo amano, i sanpietresi lo temono.">
    <%@ include file="include.jsp" %>
    <script src="assets/js/login.js"></script>

</head>

<body>
<%@ include file="header.jsp" %>

<div style="width:100%; height:15%"></div>

    <main class="page service-page">
        <div style="width: 100%;height: 15%;"></div>
        <section class="clean-block clean-services dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Benvenuto, ${username}!</h2>
                    <p></p>
                </div>
                <div class="row">
                    <div class="col-md-6 col-lg-4">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Modifica profilo</h4>
                                <p class="card-text"></p>
                            </div>
                            <div><button class="btn btn-outline-primary btn-sm" type="button" data-toggle="modal" data-target="#myProfile">Modifica Profilo</button></div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-4">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Storico Ordini</h4>
                                <p class="card-text"></p>
                            </div>
                            <div>
                                <button class="btn btn-outline-primary btn-sm" role="button"><a>Vai allo storico ordini</a></button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-4">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Eventi</h4>
                                <p class="card-text"></p>
                            </div>
                            <div><button class="btn btn-outline-primary btn-sm" type="button" data-toggle="modal" data-target="#myModal">Visualizza i tuoi eventi</button></div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-4">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Carrello</h4>
                                <p class="card-text"></p>
                            </div>
                            <div><button class="btn btn-outline-primary btn-sm" type="button" onclick="loadCart()">Vai al carrello</button></div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-4">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Recensioni</h4>
                                <p class="card-text"></p>
                            </div>
                            <div><button class="btn btn-outline-primary btn-sm" type="button">Le tue recensioni</button></div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-4">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Logout</h4>
                                <p class="card-text"></p>
                            </div>
                            <div><button class="btn btn-outline-primary btn-sm" role="button"><a href="logout">Esegui il logout</a></button></div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>

<div class="modal fade" role="dialog" tabindex="-1" id="myProfile">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Modifica Profilo</h4>
                <button type="button" class="close" data-dismiss="modal">&#10006;</button>
            </div>
            <form id="updateClienteForm" class="modal-body" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="updateClienteNam">Nome</label>
                    <input class="form-control item" type="text" id="updateClienteNam" name="updateClienteName" placeholder="Nome">
                </div>
                <div class="form-group">
                    <label for="updateClienteSurname">Cognome</label>
                    <input class="form-control item" type="text" id="updateClienteSurname" name="updateClienteSurname" placeholder="Cognome">
                </div>
                <div class="form-group">
                    <label for="updateClienteDate">Data</label>
                    <input class="form-control item" type="date" id="updateClienteDate" name="updateClienteDate" placeholder="Date">
                </div>
                <div class="form-group">
                    <label for="updateClienteEmail">Email</label>
                    <input class="form-control item" type="text" id="updateClienteEmail" name="updateClienteEmail" placeholder="Email">
                </div>
                <div class="form-group">
                    <label for="updateClienteUsername">Username</label>
                    <input class="form-control item" type="text" id="updateClienteUsername" name="updateClienteUsername" placeholder="Username">
                </div>
                <div class="form-group">
                    <label for="updateClientePassword">Password</label>
                    <input class="form-control item" type="text" id="updateClientePassword" name="updateClientePassword" placeholder="Password">
                </div>
            </form>
            <div class="modal-footer">
                <button class="btn btn-primary" type="button" id="btnUpdate" onclick="UpdateCliente()">Update</button>
            </div>

        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    <script src="assets/js/smoothproducts.min.js"></script>
    <script src="assets/js/theme.js"></script>

</body>

</html>