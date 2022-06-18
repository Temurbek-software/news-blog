<%@ page import="service.product.ProductServiceImpl" %>
<%@ page import="entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: Temurbek
  Date: 6/13/2022
  Time: 12:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <title>Online news blog</title>
    <jsp:include page="header/header2.jsp"></jsp:include>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<jsp:include page="header/header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <!-- Blog entries-->
        <div class="col-lg-8">
            <!-- Featured blog post-->
            <div class="card mb-4">
                <%
                    Product product = ProductServiceImpl.getOneProduct();
                %>
                <a href="#">
                    <img class="card-img-top" src="https://dummyimage.com/850x350/dee2e6/6c757d.jpg"
                         alt="..."/>
                </a>
                <div class="card-body">
                    <div class="small text-muted"><%=product.getCreatedTime()%>
                    </div>
                    <h2 class="card-title"><%=product.getTitles()%>
                    </h2>
                    <p class="card-text"><%=product.getDescription()%>
                    </p>
                    <a class="btn btn-primary" href="#!">Read more →</a>
                </div>
            </div>
            <!-- Nested row for non-featured blog posts-->
            <div class="row">
                <c:forEach var="news" items="${productList}">

                    <div class="col-lg-6">
                        <!-- Blog post-->
                        <div class="card mb-4">
                            <a href="#"><img class="card-img-top"
                                              src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                                              alt="..."/></a>
                            <div class="card-body">
                                <div style="display: flex; justify-content: space-between">
                                    <div>
                                        <div class="small text-muted"><c:out value="${news.createdTime}"/></div>
                                    </div>
                                    <div class="small text-muted">
                                        <c:out value="${news.name}"/>
                                    </div>
                                </div>
                                <h2 class="card-title h4"><c:out value="${news.titles}"/></h2>
                                <p class="card-text"><c:out value="${news.description}"/></p>
                                <a class="btn btn-primary" href="#">Read more →</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <!-- Pagination-->
            <nav aria-label="Pagination">
                <hr class="my-0"/>
                <ul class="pagination justify-content-center my-4">
                    <li class="page-item disabled"><a class="page-link" href="#" tabindex="-1" aria-disabled="true">Newer</a>
                    </li>
                    <li class="page-item active" aria-current="page"><a class="page-link" href="#!">1</a></li>
                    <li class="page-item"><a class="page-link" href="#!">2</a></li>
                    <li class="page-item"><a class="page-link" href="#!">3</a></li>
                    <li class="page-item disabled"><a class="page-link" href="#!">...</a></li>
                    <li class="page-item"><a class="page-link" href="#!">15</a></li>
                    <li class="page-item"><a class="page-link" href="#!">Older</a></li>
                </ul>
            </nav>
        </div>
        <!-- Side widgets-->
        <div class="col-lg-4">
            <!-- Search widget-->
            <div class="card mb-4">
                <div class="card-header">Search</div>
                <div class="card-body">
                    <div class="input-group">
                        <input class="form-control" type="text" placeholder="Enter search term..."
                               aria-label="Enter search term..." aria-describedby="button-search"/>
                        <button class="btn btn-primary" id="button-search" type="button">Go!</button>
                    </div>
                </div>
            </div>
            <!-- Categories widget-->
            <div class="card mb-4">
                <div class="card-header">Categories</div>
                <div class="card-body">
                    <div class="row">
                        <c:forEach var="categ" items="${categoryList}">
                            <div class="col-sm-6">
                                <ul class="list-unstyled mb-0">
                                    <li>
                                        <a href="categoryNews?id=<c:out value='${categ.id}' />">
                                            <c:out value="${categ.name}"/>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <!-- Side widget-->
            <div class="card mb-4">
                <div class="card-header">Side Widget</div>
                <div class="card-body">You can put anything you want inside of these side widgets. They are easy to use,
                    and feature the Bootstrap 5 card component!
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <div class="modal fade" id="modalRegisterForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header text-center">
                            <h4 class="modal-title w-100 font-weight-bold">Sign up</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body mx-3">
                            <div class="md-form mb-5">
                                <i class="fas fa-user prefix grey-text"></i>
                                <input type="text" id="orangeForm-name" class="form-control validate">
                                <label data-error="wrong" data-success="right" for="orangeForm-name">Your name</label>
                            </div>
                            <div class="md-form mb-5">
                                <i class="fas fa-envelope prefix grey-text"></i>
                                <input type="email" id="orangeForm-email" class="form-control validate">
                                <label data-error="wrong" data-success="right" for="orangeForm-email">Your email</label>
                            </div>

                            <div class="md-form mb-4">
                                <i class="fas fa-lock prefix grey-text"></i>
                                <input type="password" id="orangeForm-pass" class="form-control validate">
                                <label data-error="wrong" data-success="right" for="orangeForm-pass">Your password</label>
                            </div>

                        </div>
                        <div class="modal-footer d-flex justify-content-center">
                            <button class="btn btn-deep-orange">Sign up</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="text-center">
                <a href="" class="btn btn-default btn-rounded mb-4" data-toggle="modal" data-target="#modalRegisterForm">Launch
                    Modal Register Form</a>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer/footer.jsp"></jsp:include>
</body>
</html>
