<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Tipologia" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>AdminPage - Agriturismo Sarella</title>
    <%@ include file="include.jsp"%>
    <script type="text/javascript" src="assets/js/gestionecamera.js"></script>

</head>

<body>
    <%@ include file="header.jsp"%>
    <main class="page service-page">
        <section class="clean-block clean-services dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Gestisci Camere</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna, dignissim nec auctor in, mattis vitae leo.</p>
                </div>
                <div class="row">
                    <div class="col-md-6 col-lg-4">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Aggiungi Camera</h4>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna, dignissim nec auctor in.</p>
                            </div>
                            <div><button class="btn btn-outline-primary btn-sm" type="button" data-toggle="modal" data-target="#addRoomModal">Aggiungi una camera</button></div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-4">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Modifica Camera</h4>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna, dignissim nec auctor in.</p>
                            </div>
                            <div><button class="btn btn-outline-primary btn-sm" type="button" data-toggle="modal" data-target="#updateRoomModal">Modifica una camera</button></div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-4">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Elimina Camera</h4>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna, dignissim nec auctor in.</p>
                            </div>
                            <div><button class="btn btn-outline-primary btn-sm" type="button" data-toggle="modal" data-target="#deleteRoomModal">Elimina una camera</button></div>
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
                    <h4 class="modal-title">Inserisci una nuova camera</h4><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button></div>
                <div class="modal-body">
                    <form>
                        <div>
                            <div class="form-row row-cols-1 row-cols-sm-1 row-cols-md-1 row-cols-lg-2 row-cols-xl-2 d-flex flex-row flex-wrap">
                                <div class="col">
                                    <div class="form-group">
                                        <label for="addRoomModalNumC">Numero camera</label>
                                        <input class="form-control item" type="text" id="addRoomModalNumC" placeholder="Il numero identificativo della camera" required=""></div>
                                    <div class="form-group">
                                        <label for="addRoomModalType">Tipologia</label>
                                        <select id="addRoomModalType" class="form-control" required="">
                                            <optgroup label="Tipologie">
                                                <c:forEach items="${tip}" var="tipolgie">
                                                    <option value="${tipolgie.getIdTipologia()}">${tipolgie.getTipologia()}</option>
                                                </c:forEach>
                                            </optgroup>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="addRoomModalNumP">Num.persone</label>
                                        <select id="addRoomModalNumP"class="form-control" required="">
                                            <optgroup label="NumeroPersone">
                                                <c:forEach var= "nump" items= "${nump}" >
                                                <option value="${nump.getIdNumPersone()}">${nump.getNumPersone()}</option>
                                                </c:forEach>
                                            </optgroup>+
                                        </select>
                                    </div>
                                <div class="form-group">
                                    <label for="addRoomModalImg">Immagine</label>
                                    <input class="form-control" id="addRoomModalImg" type="file"></div>
                            <div class="form-group">
                                <label for="addRoomModalPrice">Prezzo</label>
                                <input class="form-control" id="addRoomModalPrice" type="number" required=""></div>
                        </div>
                        <div class="col">
                            <div class="form-group">
                                <label for="addRoomModalDescription">Descrizione</label>
                                <textarea id="addRoomModalDescription" class="form-control" rows="15"></textarea></div>
                        </div>
                </div>
            </div>
            </form>
        </div>
        <div class="modal-footer"><button class="btn btn-primary" type="button" id="btnaddc" onclick="addc(event)">Aggiungi camera</button></div>
    </div>
    </div>
    </div>
    <div class="modal fade" role="dialog" tabindex="-1" id="updateRoomModal">
        <div class="modal-dialog modal-xl modal-dialog-scrollable" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Modifica la camera</h4><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button></div>
                <div class="modal-body">
                    <form>
                        <div>
                            <div class="form-row row-cols-1 row-cols-sm-1 row-cols-md-1 row-cols-lg-2 row-cols-xl-2 d-flex flex-row flex-wrap">
                                <div class="col">
                                    <div class="form-group">
                                        <label for="email">Numero camera</label>
                                        <input class="form-control item" type="email" id="email" placeholder="Il numero identificativo della camera" required=""></div>
                                    <div class="form-group">
                                        <label for="updateRoomModalType">Tipologia</label>
                                        <select id="updateRoomModalType"class="form-control" required="">
                                            <optgroup label="This is a group">
                                                <option value="12" selected="">This is item 1</option>
                                                <option value="13">This is item 2</option>
                                                <option value="14">This is item 3</option></optgroup></select></div>
                                    <div class="form-group">
                                        <label for="updateRoomModalNumP">Num. persone</label>
                                        <select id="updateRoomModalNumP" class="form-control" required="">
                                            <optgroup label="This is a group">
                                                <option value="12" selected="">This is item 1</option>
                                                <option value="13">This is item 2</option>
                                                <option value="14">This is item 3</option></optgroup></select></div>
                                <div class="form-group">
                                    <label for="updateRoomModalImg">Immagine</label>
                                    <input class="form-control" id="updateRoomModalImg" type="file"></div>
                            <div class="form-group">
                                <label for="updateRoomModalPrice">Prezzo</label>
                                <input class="form-control" id="updateRoomModalPrice" type="number" required=""></div>
                        </div>
                        <div class="col">
                            <div class="form-group">
                                <label for="updateRoomModalDescription">Descrizione</label>
                                <textarea id="updateRoomModalDescription" class="form-control" rows="15"></textarea></div>
                        </div>
                </div>
            </div>
            </form>
        </div>
        <div class="modal-footer"><button class="btn btn-primary" type="button">Modifica la camera</button></div>
    </div>
    </div>
    </div>
    <div class="modal fade" role="dialog" tabindex="-1" id="deleteRoomModal">
        <div class="modal-dialog modal-dialog-scrollable" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Rimuovi camera</h4><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button></div>
                <div class="modal-body">
                    <form>
                        <div class="form-group"><label for="email">Numero camera</label><select class="form-control"><optgroup label="This is a group"><option value="12" selected="">This is item 1</option><option value="13">This is item 2</option><option value="14">This is item 3</option></optgroup></select></div>
                    </form>
                </div>
                <div class="modal-footer"><button class="btn btn-primary" type="button">Elimina la camera</button></div>
            </div>
        </div>
    </div>

    <%@ include file="footer.jsp"%>

    <script src="../assets/js/jquery.min.js"></script>
    <script src="../assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    <script src="../assets/js/smoothproducts.min.js"></script>
    <script src="../assets/js/theme.js"></script>
</body>

</html>