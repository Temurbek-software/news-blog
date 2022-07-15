<%--
  Created by IntelliJ IDEA.
  User: Temurbek
  Date: 6/19/2022
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Search Panel</title>
    <jsp:include page="../header/header2.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../header/header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-lg-8">
            <div class="row">
                <c:if test="${searchedProduct==null}">
                    <div class="alert alert-danger" role="alert">
                        This is a danger alert—check it out!
                    </div>
                </c:if>
                <c:if test="${searchedProduct!=null}">
                    <c:forEach var="producc" items="${searchedProduct}">
                        <a href="singleData?id=<c:out value='${producc.id}' />"
                           style="color: black ; text-decoration: none">
                            <div class="card mb-3">
                                <div class="row no-gutters">
                                    <div class="col-md-4">
                                        <img src="data:image/png;base64,${producc.photofile}" width="500" height="250"
                                             class="card-img" alt="...">
                                    </div>
                                    <div class="col-md-8">
                                        <div class="card-body">
                                            <h5 class="card-title"><c:out value="${producc.titles}"/></h5>
                                            <p class="card-text"><c:out value="${producc.description}"/></p>
                                            <p class="card-text"><small class="text-muted"><c:out
                                                    value="${producc.created_at}"/></small>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </a>

                    </c:forEach>
                </c:if>
            </div>
        </div>
        <jsp:include page="../extra/categorySearch.jsp"></jsp:include>

    </div>
</div>
<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
</html>
