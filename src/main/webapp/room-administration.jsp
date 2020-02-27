<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>AdminPage - Agriturismo Sarella</title>
    <%@ include file="include.jsp" %>
    <script type="text/javascript" src="assets/js/room-administration.js"></script>
    <script type="text/javascript" src="assets/js/calendarevent.js.js"></script>


</head>

<body>
<%@ include file="header.jsp" %>

<div style="width:100%; height:15%"></div>

<main class="page service-page">
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Gestione Admin</h2>
                <p>pannello di controllo</p>
            </div>
            <div class="row">
                <div class="col-md-6 col-lg-4">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Aggiungi Camera</h4>
                            <p class="card-text"></p>
                        </div>
                        <div>
                            <button class="btn btn-outline-primary btn-sm" type="button" data-toggle="modal"
                                    data-target="#addRoomModal">Aggiungi una camera
                            </button>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Modifica Camera</h4>
                            <p class="card-text"></p>
                        </div>
                        <div>
                            <button class="btn btn-outline-primary btn-sm" type="button" data-toggle="modal"
                                    data-target="#updateRoomModal">Modifica una camera
                            </button>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Elimina Camera</h4>
                            <p class="card-text"></p>
                        </div>
                        <div>
                            <button class="btn btn-outline-primary btn-sm" type="button" data-toggle="modal"
                                    data-target="#deleteRoomModal">Elimina una camera
                            </button>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Aggiungi evento del giorno</h4>
                            <p class="card-text"></p>
                        </div>
                        <div>
                            <button class="btn btn-outline-primary btn-sm" type="button" data-toggle="modal"
                                    data-target="#addEventofday">Aggiungi evento
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<div class="modal fade" role="dialog" tabindex="-1" id="addRoomModal">
    <div class="modal-dialog modal-xl modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Inserisci una nuova camera</h4>
                <button type="button" class="close" data-dismiss="modal">&#10006;</button>
            </div>
            <div class="modal-body">
                <form id="addRoomForm" enctype="multipart/form-data">
                    <div>
                        <div class="form-row row-cols-1 row-cols-sm-1 row-cols-md-1 row-cols-lg-2 row-cols-xl-2 d-flex flex-row flex-wrap">
                            <div class="col">
                                <div class="form-group">
                                    <label for="addRoomFormId">Numero camera</label>
                                    <input class="form-control item" name="addRoomFromId" type="text"
                                           id="addRoomFormId" placeholder="Il numero identificativo della camera"
                                           required="required"></div>
                                <div class="form-group">
                                    <label for="addRoomFormType">Tipologia</label>
                                    <select id="addRoomFormType" name="addRoomFormType" class="form-control"
                                            required="required">
                                        <optgroup label="Tipologie">
                                            <c:forEach items="${tip}" var="tipolgie">
                                                <option value="${tipolgie.getIdTipologia()}">${tipolgie.getTipologia()}</option>
                                            </c:forEach>
                                        </optgroup>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="addRoomFormNumPersone">Numero persone</label>
                                    <select id="addRoomFormNumPersone" name="addRoomFormNumPersone" class="form-control"
                                            required="required">
                                        <optgroup label="NumeroPersone">
                                            <c:forEach var="nump" items="${nump}">
                                                <option value="${nump.getIdNumPersone()}">${nump.getNumPersone()}</option>
                                            </c:forEach>
                                        </optgroup>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="addRoomFormImg">Immagine</label>
                                    <input class="form-control" name="addRoomFormImg" id="addRoomFormImg" type="file"></div>
                                <div class="form-group">
                                    <label for="addRoomFormPrice">Prezzo</label>
                                    <input class="form-control" name="addRoomFormPrice" id="addRoomFormPrice"
                                           type="number" min="0" step="0.01" required="required"></div>
                            </div>
                            <div class="col">
                                <div class="form-group">
                                    <label for="addRoomFormDesc">Descrizione</label>
                                    <textarea id="addRoomFormDesc" name="addRoomFormDesc" class="form-control"
                                              rows="15" required="required"></textarea></div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" type="button" id="btnaddc" onclick="addc('#addRoomForm')">Aggiungi
                    camera
                </button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" role="dialog" tabindex="-1" id="updateRoomModal">
    <div class="modal-dialog modal-xl modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Modifica la camera</h4>
                <button type="button" class="close" data-dismiss="modal">&#10006;</button>
            </div>
            <div class="modal-body">
                <form id="updateRoomForm" enctype="multipart/form-data">
                    <div>
                        <div class="form-row row-cols-1 row-cols-sm-1 row-cols-md-1 row-cols-lg-2 row-cols-xl-2 d-flex flex-row flex-wrap">
                            <div class="col">
                                <div class="form-group">
                                    <label for="updateRoomModalId">ID_camera</label>
                                    <select id="updateRoomModalId" name="updateRoomFormId" class="form-control"
                                            required="">
                                        <optgroup label="Id_camera">
                                            <c:forEach var="prods" items="${prods}">
                                                <option value="${prods.getIdCamera()}">${prods.getIdCamera()}</option>
                                            </c:forEach>
                                        </optgroup>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="updateRoomModalType">Tipologia</label>
                                    <select id="updateRoomModalType" name="updateRoomFormType" class="form-control">
                                        <optgroup label="Tipologia">
                                            <c:forEach items="${tip}" var="tipolgie">
                                                <option value="${tipolgie.getIdTipologia()}">${tipolgie.getTipologia()}</option>
                                            </c:forEach></optgroup>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="updateRoomModalNumP">Num. persone</label>
                                    <select id="updateRoomModalNumP" name="updateRoomFormNumP" class="form-control">
                                        <optgroup label="NumPersone">
                                            <c:forEach var="nump" items="${nump}">
                                                <option value="${nump.getIdNumPersone()}">${nump.getNumPersone()}</option>
                                            </c:forEach>
                                        </optgroup>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="updateRoomModalImg">Immagine</label>
                                    <input class="form-control" name="updateRoomFormImg"
                                           id="updateRoomModalImg" type="file"></div>
                                <div class="form-group">
                                    <label for="updateRoomModalPrice">Prezzo</label>
                                    <input class="form-control" id="updateRoomModalPrice" name="updateRoomFormPrice"
                                           type="number"></div>
                            </div>
                            <div class="col">
                                <div class="form-group">
                                    <label for="updateRoomModalDescription">Descrizione</label>
                                    <textarea id="updateRoomModalDescription" class="form-control"
                                              name="updateRoomFormDesc" rows="15"></textarea></div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" type="button" id="btnupdc" onclick="updc('#updateRoomForm')">Modifica la
                    camera
                </button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" role="dialog" tabindex="-1" id="deleteRoomModal">
    <div class="modal-dialog modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Rimuovi camera</h4>
                <button type="button" class="close" data-dismiss="modal">&#10006;</button>
            </div>
            <div class="modal-body">
                <form id="deleteRoomForm">
                    <div class="form-group">
                        <label for="deleteRoomModalId">ID_camera</label>
                        <select id="deleteRoomModalId" class="form-control" required="" name="deleteRoomModalId">
                            <optgroup label="Id_camera">
                                <c:forEach var="prods" items="${prods}">
                                    <option value="${prods.getIdCamera()}">${prods.getIdCamera()}</option>
                                </c:forEach>
                            </optgroup>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" type="button" id="btndelc" onclick="delc('#deleteRoomForm')">Elimina la
                    camera
                </button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="addEventofday" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Eventi Agriturismo</h4>
                <button type="button" class="close" data-dismiss="modal">&#10006;</button>
            </div>
            <div class="modal-body">
                <iframe id="videoContainer" width="750" height="400" src="addeventofday.jsp" frameborder="100" allowfullscreen></iframe>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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