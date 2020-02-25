<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Product - Agriturismo Sarella</title>
    <meta name="description" content="I cinghiali lo amano, i sanpietresi lo temono.">
    <%@ include file="include.jsp" %>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body>
<%@ include file="header.jsp" %>

<div style="width:100%; height:15%"></div>

    <main class="page product-page">
        <div class="modal fade" role="dialog" tabindex="-1">
            <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Sign In</h4><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button></div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group"><label for="email">Email</label><input class="form-control item" type="email" id="email"></div>
                            <div class="form-group"><label for="password">Password</label><input class="form-control" type="password" id="password"></div>
                            <div class="form-group">
                                <div class="form-check"><input class="form-check-input" type="checkbox" id="checkbox"><label class="form-check-label" for="checkbox">Remember me</label></div>
                            </div><button class="btn btn-primary btn-block" type="submit">Log In</button></form>
                    </div>
                    <div class="modal-footer"><button class="btn btn-light" type="button" data-dismiss="modal">Close</button><button class="btn btn-primary" type="button">Save</button></div>
                </div>
            </div>
        </div>
        <section class="clean-block clean-product dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Product Page</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna, dignissim nec auctor in, mattis vitae leo.</p>
                </div>
                <div class="block-content">
                    <div class="product-info">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="gallery">
                                    <div class="sp-wrap"><a href="assets/img/tech/image1.jpg"><img class="img-fluid d-block mx-auto" src="assets/img/tech_TOREMOVE/image1.jpg"></a><a href="assets/img/tech_TOREMOVE/image1.jpg"><img class="img-fluid d-block mx-auto" src="assets/img/tech_TOREMOVE/image1.jpg"></a><a href="assets/img/tech_TOREMOVE/image1.jpg"><img class="img-fluid d-block mx-auto" src="assets/img/tech_TOREMOVE/image1.jpg"></a></div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="info">
                                    <h3>Lorem Ipsum</h3>
                                    <div class="d-none rating"><img src="assets/img/rooms/star.svg"><img src="assets/img/rooms/star.svg"><img src="assets/img/rooms/star.svg"><img src="assets/img/rooms/star-half-empty.svg"><img src="assets/img/rooms/star-empty.svg"></div>
                                    <div class="price">
                                        <h3>$300.00</h3>
                                    </div><button class="btn btn-primary" type="button"><i class="icon-basket"></i>Add to Cart</button>
                                    <div class="summary">
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec augue nunc, pretium at augue at, convallis pellentesque ipsum. Vestibulum diam risus, sagittis at fringilla at, pulvinar vel risus. Vestibulum dignissim
                                            eu nulla eu imperdiet. Morbi mollis tellus a nunc vestibulum consequat. Quisque tristique elit et nibh dapibus sodales. Nam sollicitudin a urna sed iaculis.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="product-info">
                        <div>
                            <ul class="nav nav-tabs" id="myTab">
                                <li class="nav-item"><a class="nav-link" role="tab" data-toggle="tab" id="reviews-tab" href="#reviews">Reviews</a></li>
                            </ul>
                            <div class="tab-content" id="myTabContent">
                                <div class="tab-pane fade show" role="tabpanel" id="reviews">
                                <c:forEach items="${reviews}" var="reviews">
                                    <div class="reviews">
                                        <div class="review-item">
                                            <div class="rating">
                                                <c:choose>
                                                    <c:when test="${reviews.getVoto() >= 1}"><span class="fa fa-star"></span></c:when>
                                                    <c:otherwise><span class="fa fa-star unchecked"></span></c:otherwise>
                                                </c:choose>

                                                <c:choose>
                                                    <c:when test="${reviews.getVoto() >= 2}"><span class="fa fa-star"></span></c:when>
                                                    <c:otherwise><span class="fa fa-star unchecked"></span></c:otherwise>
                                                </c:choose>

                                                <c:choose>
                                                    <c:when test="${reviews.getVoto() >= 3}"><span class="fa fa-star"></span></c:when>
                                                    <c:otherwise><span class="fa fa-star unchecked"></span></c:otherwise>
                                                </c:choose>

                                                <c:choose>
                                                    <c:when test="${reviews.getVoto() >= 4}"><span class="fa fa-star"></span></c:when>
                                                    <c:otherwise><span class="fa fa-star unchecked"></span></c:otherwise>
                                                </c:choose>

                                                <c:choose>
                                                    <c:when test="${reviews.getVoto() >= 5}"><span class="fa fa-star"></span></c:when>
                                                    <c:otherwise><span class="fa fa-star unchecked"></span></c:otherwise>
                                                </c:choose>
                                            </div>
                                            <h4>Incredible product</h4>
                                            <span class="text-muted">
                                                <a href="#">${reviews.getIdClienteFk()}</a>
                                                    ${reviews.getDataRecensione()}
                                            </span>
                                            <p>${reviews.getDescrizione()}.</p>
                                        </div>
                                    </div>
                                </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="clean-related-items">
                        <h3>Related Products</h3>
                        <div class="items">
                            <div class="row justify-content-center">
                                <div class="col-sm-6 col-lg-4">
                                    <div class="clean-related-item">
                                        <div class="image"><a href="#"><img class="img-fluid d-block mx-auto" src="assets/img/tech_TOREMOVE/image2.jpg"></a></div>
                                        <div class="related-name"><a href="#">Lorem Ipsum dolor</a>
                                            <div class="d-none rating"><img src="assets/img/rooms/star.svg"><img src="assets/img/rooms/star.svg"><img src="assets/img/rooms/star.svg"><img src="assets/img/rooms/star-half-empty.svg"><img src="assets/img/rooms/star-empty.svg"></div>
                                            <h4>$300</h4>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-lg-4">
                                    <div class="clean-related-item">
                                        <div class="image"><a href="#"><img class="img-fluid d-block mx-auto" src="assets/img/tech_TOREMOVE/image2.jpg"></a></div>
                                        <div class="related-name"><a href="#">Lorem Ipsum dolor</a>
                                            <div class="d-none rating"><img src="assets/img/rooms/star.svg"><img src="assets/img/rooms/star.svg"><img src="assets/img/rooms/star.svg"><img class="d-none" src="assets/img/rooms/star-half-empty.svg"><img src="assets/img/rooms/star-empty.svg"></div>
                                            <h4>$300</h4>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-lg-4">
                                    <div class="clean-related-item">
                                        <div class="image"><a href="#"><img class="img-fluid d-block mx-auto" src="assets/img/tech_TOREMOVE/image2.jpg"></a></div>
                                        <div class="related-name"><a href="#">Lorem Ipsum dolor</a>
                                            <div class="d-none rating"><img src="assets/img/rooms/star.svg"><img src="assets/img/rooms/star.svg"><img src="assets/img/rooms/star.svg"><img src="assets/img/rooms/star-half-empty.svg"><img src="assets/img/rooms/star-empty.svg"></div>
                                            <h4>$300</h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>

<%@ include file="footer.jsp" %>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    <script src="assets/js/smoothproducts.min.js"></script>
    <script src="assets/js/theme.js"></script>
</body>

</html>