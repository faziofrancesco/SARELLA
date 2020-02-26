<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Catalog - Agriturismo Sarella</title>
    <meta name="description" content="I cinghiali lo amano, i sanpietresi lo temono.">
    <%@ include file="include.jsp" %>
</head>

<body>
<%@ include file="header.jsp" %>

<div style="width:100%; height:15%"></div>

    <main class="page catalog-page">
        <div class="container-fluid" style="padding: 2%;">
            <div role="tablist" id="accordion-1">
            <c:forEach items="${ordine}" var="ordine">
                <div class="card">
                    <div class="card-header" role="tab">
                        <h5 class="mb-0">
                            <a data-toggle="collapse" aria-expanded="true" aria-controls="accordion-1 .item-${ordine.getIdOrdine()}" href="#accordion-1 .item-${ordine.getIdOrdine()}">Ordine #${ordine.getIdOrdine()}</a>
                        </h5>
                    </div>
                    <div class="collapse show item-${ordine.getIdOrdine()} flex-column" role="tabpanel" data-parent="#accordion-1">
                        <div class="card-body">
                            <p>Camere:</p>
                            <c:forEach items="${camere.get(ordine.getIdOrdine)}" var="camere">
                            <div class="products">
                                <div class="d-flex flex-column justify-content-between clean-product-item">
                                    <div class="about"><a href="#">Camera no. ${camere.getIdCamera()}</a>
                                        <div class="price">
                                            <h3>${camere.getPrezzo()}</h3>
                                        </div>
                                    </div>
                                </div>
                                <div class="clean-product-item">
                                    <div class="about">
                                        <a href="#">${camere.getIdCamera()}</a>
                                        <div class="price">
                                            <h3>${camere.getPrezzo()}</h3>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </c:forEach>
            </div>
        </div>
    </main>
<%@ include file="footer.jsp" %>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    <script src="assets/js/smoothproducts.min.js"></script>
    <script src="assets/js/theme.js"></script>
</body>

</html>