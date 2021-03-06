<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Catalog - Agriturismo Sarella</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <%@ include file="include.jsp" %>
    <script type="text/javascript" src="assets/js/rooms.js"></script>
</head>

<body>
<%@ include file="header.jsp" %>

<div style="width:100%; height:15%"></div>

    <main class="page catalog-page">
        <section class="clean-block clean-catalog dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Le nostre camere.</h2>
                    <p>Lorem ipsum</p>
                </div>
                <div class="content">
                    <div class="row">
                        <div class="col-md-3">
                            <div class="d-none d-md-block">
                                <div class="filters">
                                    <div class="filter-item">
                                        <h3>Numero persone</h3>
                                        <c:forEach items="${nump}" var="nump">
                                            <div class="form-check filtro">
                                                <input class="form-check-input" type="checkbox" id="nump_${nump.getIdNumPersone()}">
                                                <label class="form-check-label" for="nump_${nump.getIdNumPersone()}">${nump.getNumPersone()}</label>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <div class="filter-item">
                                        <h3>Tipologia</h3>
                                        <c:forEach items="${tip}" var="tip">
                                            <div class="form-check filtro">
                                                <input class="form-check-input" type="checkbox" id="tip_${tip.getIdTipologia()}">
                                                <label class="form-check-label" for="tip_${tip.getIdTipologia()}">${tip.getTipologia()}</label>
                                            </div>
                                        </c:forEach>
                                     </div>
                                    <div class="filter-item">
                                        <h3>Prezzo</h3><input class="custom-range" type="range" min="30" max="999" step="1"></div>
                                </div>
                            </div>
                            <div class="d-md-none">
                                <a class="btn btn-link d-md-none filter-collapse" data-toggle="collapse" aria-expanded="false" aria-controls="filters" href="#filters" role="button">Filters<i class="icon-arrow-down filter-caret"></i></a>
                                <div class="collapse"
                                    id="filters">
                                    <div class="filters">
                                        <div class="filter-item">
                                            <h3>Numero persone</h3>
                                            <c:forEach items="${nump}" var="nump">
                                                <div class="form-check filtro">
                                                    <input class="form-check-input" type="checkbox" id="nump_${nump.getIdNumPersone()}">
                                                    <label class="form-check-label" for="nump_${nump.getIdNumPersone()}">${nump.getNumPersone()}</label>
                                                </div>
                                            </c:forEach>
                                        </div>
                                        <div class="filter-item">
                                            <h3>Tipologia</h3>
                                            <c:forEach items="${tip}" var="tip">
                                                <div class="form-check filtro">
                                                    <input class="form-check-input" type="checkbox" id="tip_${tip.getIdTipologia()}">
                                                    <label class="form-check-label" for="tip_${tip.getIdTipologia()}">${tip.getTipologia()}</label>
                                                </div>
                                            </c:forEach>
                                        </div>
                                        <div class="filter-item">
                                            <h3>Prezzo</h3><input class="custom-range" type="range" min="30" max="999" step="1"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-9">
                            <div class="products">
                                <c:forEach items="${prods}" var="prods">
                                    <div class="clean-product-item filtro-num" data-filterN="nump_${prods.getNumPersone()}" data-filterT="tip_${prods.getTipologia()}">
                                        <div class="image">
                                            <a class="d-lg-flex justify-content-lg-center align-items-lg-center" href="rooms-handler?target=single&id=${prods.getIdCamera()}">
                                                <img class="img-fluid d-flex d-lg-flex justify-content-lg-center align-items-lg-center" src="images/${prods.getImagePath()}">
                                            </a>
                                        </div>
                                        <div class="product-name"><a href="#">Camera n. ${prods.getIdCamera()}</a></div>
                                        <div class="about">
                                            <div class="rating">
                                                <c:choose>
                                                    <c:when test="${meanvote >= 1}"><span class="fa fa-star"></span></c:when>
                                                    <c:otherwise><span class="fa fa-star unchecked"></span></c:otherwise>
                                                </c:choose>

                                                <c:choose>
                                                    <c:when test="${meanvote >= 2}"><span class="fa fa-star"></span></c:when>
                                                    <c:otherwise><span class="fa fa-star unchecked"></span></c:otherwise>
                                                </c:choose>

                                                <c:choose>
                                                    <c:when test="${meanvote >= 3}"><span class="fa fa-star"></span></c:when>
                                                    <c:otherwise><span class="fa fa-star unchecked"></span></c:otherwise>
                                                </c:choose>

                                                <c:choose>
                                                    <c:when test="${meanvote >= 4}"><span class="fa fa-star"></span></c:when>
                                                    <c:otherwise><span class="fa fa-star unchecked"></span></c:otherwise>
                                                </c:choose>

                                                <c:choose>
                                                    <c:when test="${meanvote >= 5}"><span class="fa fa-star"></span></c:when>
                                                    <c:otherwise><span class="fa fa-star unchecked"></span></c:otherwise>
                                                </c:choose>
                                            </div>
                                            <div class="price">
                                                <h3>$ ${prods.getPrezzo()}</h3>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>

<%@ include file="footer.jsp" %>
<script type="text/javascript" src="assets/js/rooms.js"></script>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    <script src="assets/js/smoothproducts.min.js"></script>
    <script src="assets/js/theme.js"></script>
</body>

</html>