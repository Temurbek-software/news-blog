<%--
  Created by IntelliJ IDEA.
  User: Temurbek
  Date: 6/19/2022
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-lg-4">
    <!-- Search widget-->
    <form action="searchNews" method="post">
        <div class="card mb-4">
            <div class="card-header">Search</div>
            <div class="card-body">
                <div class="input-group">
                    <div class="input-group-text p-0">
                        <select name="category_id" class="form-select  shadow-none bg-light border-0">
                            <option selected>Categories</option>
                            <c:forEach var="categ" items="${categoryList}">
                                <option value="<c:out value='${categ.id}' />"><c:out value="${categ.name}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                    <input class="form-control"
                           type="text" name="searchedProduct" placeholder="Enter search term..."
                           aria-label="Enter search term..." aria-describedby="button-search"/>
                    <button type="submit" class="btn btn-success">Go!</button>
                </div>
            </div>
        </div>
    </form>

    <!-- Categories widget-->
    <div class="card mb-4">
        <div class="card-header">Categories</div>
        <div class="card-body">
            <div class="row">
                <c:forEach var="categ" items="${categoryList}">
                    <div class="col-sm-6">
                        <ul class="list-unstyled mb-0">
                            <li>
                                <a style="color:black;text-decoration: none"
                                   href="categoryNews?id=<c:out value='${categ.id}' />">
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
        <div class="card-header">Recent post</div>
        <div class="card-body">
            <ul>
                <c:forEach var="recentPost" items="${lastPosts}">
                    <a href="singleData?id=<c:out value='${recentPost.id}' />">
                        <li><c:out value="${recentPost.titles}"/></li>
                    </a>
                </c:forEach>
            </ul>

        </div>
    </div>

</div>
