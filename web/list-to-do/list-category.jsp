<%--
  Created by IntelliJ IDEA.
  User: Temurbek
  Date: 6/14/2022
  Time: 12:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="../header/header2.jsp"></jsp:include>
<body>
<%--<jsp:include page="header/header.jsp"></jsp:include>--%>
<jsp:include page="../header/header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <!-- Blog entries-->
        <div class="col-lg-8">
            <!-- Featured blog post-->
            <!-- Nested row for non-featured blog posts-->
            <div class="row">
                <c:forEach var="news" items="${productCategory}">
                    <div class="col-lg-6">
                        <!-- Blog post-->
                         <div class="card mb-4">
                            <a href="#!">
                                <img class="card-img-top"
                                     src="data:image/png;base64,${news.photofile}" width="500" height="250"
                                     alt="..."/>
                            </a>
                            <div class="card-body">
                                <div class="small text-muted"><c:out value="${news.created_at}"/></div>
                                <h2 class="card-title h4"><c:out value="${news.titles}"/></h2>
                                <p class="card-text"><c:out value="${news.description}"/></p>
                                <a class="btn btn-primary" href="#!">Read more →</a>
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
        <jsp:include page="../extra/categorySearch.jsp"></jsp:include>
    </div>
</div>
<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
</html>
