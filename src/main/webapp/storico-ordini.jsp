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
                <div class="card">
                    <div class="card-header" role="tab">
                        <h5 class="mb-0"><a data-toggle="collapse" aria-expanded="false" aria-controls="accordion-1 .item-1" href="#accordion-1 .item-1">Ordine #3</a></h5>
                    </div>
                    <div class="collapse item-1" role="tabpanel" data-parent="#accordion-1">
                        <div class="card-body">
                            <p class="card-text">Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header" role="tab">
                        <h5 class="mb-0"><a data-toggle="collapse" aria-expanded="false" aria-controls="accordion-1 .item-2" href="#accordion-1 .item-2">Ordine #2</a></h5>
                    </div>
                    <div class="collapse item-2" role="tabpanel" data-parent="#accordion-1">
                        <div class="card-body">
                            <p class="card-text">Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header" role="tab">
                        <h5 class="mb-0"><a data-toggle="collapse" aria-expanded="true" aria-controls="accordion-1 .item-3" href="#accordion-1 .item-3">Ordine #1</a></h5>
                    </div>
                    <div class="collapse show item-3 flex-column" role="tabpanel" data-parent="#accordion-1">
                        <div class="card-body">
                            <p>Info #1</p>
                            <p>Info #2</p>
                            <p>Camere:</p>
                            <div class="products">
                                <div class="d-flex flex-column justify-content-between clean-product-item">
                                    <div class="about"><a href="#">${numero camera}</a>
                                        <div class="price">
                                            <h3>${prezzo}</h3>
                                        </div>
                                    </div>
                                </div>
                                <div class="clean-product-item">
                                    <div class="about"><a href="#">${numero camera}</a>
                                        <div class="price">
                                            <h3>${prezzo}</h3>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
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