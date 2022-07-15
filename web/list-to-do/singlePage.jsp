<%@ page import="service.product.ProductServiceImpl" %>
<%@ page import="entity.Product" %>
<%@ page import="payload.CookieService" %>
<%@ page import="entity.Users" %><%--
  Created by IntelliJ IDEA.
  User: Temurbek
  Date: 6/19/2022
  Time: 12:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>This is one news</title>
    <jsp:include page="../header/header2.jsp"></jsp:include>
    <style>
        .be-comment-block {
            margin-bottom: 50px !important;
            border: 1px solid #edeff2;
            border-radius: 2px;
            padding: 50px 70px;
            border:1px solid #ffffff;
        }

        .comments-title {
            font-size: 16px;
            color: #262626;
            margin-bottom: 15px;
            font-family: 'Conv_helveticaneuecyr-bold';
        }

        .be-img-comment {
            width: 60px;
            height: 60px;
            float: left;
            margin-bottom: 15px;
        }

        .be-ava-comment {
            width: 60px;
            height: 60px;
            border-radius: 50%;
        }

        .be-comment-content {
            margin-left: 80px;
        }

        .be-comment-content span {
            display: inline-block;
            width: 49%;
            margin-bottom: 15px;
        }

        .be-comment-name {
            font-size: 13px;
            font-family: 'Conv_helveticaneuecyr-bold';
        }

        .be-comment-content a {
            color: #383b43;
        }

        .be-comment-content span {
            display: inline-block;
            width: 49%;
            margin-bottom: 15px;
        }

        .be-comment-time {
            text-align: right;
        }

        .be-comment-time {
            font-size: 11px;
            color: #b4b7c1;
        }

        .be-comment-text {
            font-size: 13px;
            line-height: 18px;
            color: #7a8192;
            display: block;
            background: #f6f6f7;
            border: 1px solid #edeff2;
            padding: 15px 20px 20px 20px;
        }

        /*.form-group.fl_icon .icon {*/
        /*    position: absolute;*/
        /*    top: 1px;*/
        /*    left: 16px;*/
        /*    width: 48px;*/
        /*    height: 48px;*/
        /*    background: #f6f6f7;*/
        /*    color: #b5b8c2;*/
        /*    text-align: center;*/
        /*    line-height: 50px;*/
        /*    -webkit-border-top-left-radius: 2px;*/
        /*    -webkit-border-bottom-left-radius: 2px;*/
        /*    -moz-border-radius-topleft: 2px;*/
        /*    -moz-border-radius-bottomleft: 2px;*/
        /*    border-top-left-radius: 2px;*/
        /*    border-bottom-left-radius: 2px;*/
        /*}*/

        .form-group .form-input {
            font-size: 13px;
            line-height: 50px;
            font-weight: 400;
            color: #b4b7c1;
            width: 100%;
            height: 50px;
            padding-left: 20px;
            padding-right: 20px;
            border: 1px solid #edeff2;
            border-radius: 3px;
        }

        .form-group.fl_icon .form-input {
            padding-left: 70px;
        }

        .form-group textarea.form-input {
            height: 150px;
        }
        button.like{
            width: 30px;
            height: 30px;
            margin: 0 auto;
            line-heigth: 50px;
            border-radius: 50%;
            color: rgba(0,150,136 ,1);
            background-color:rgba(38,166,154 ,0.3);
            border-color: rgba(0,150,136 ,1);
            border-width: 1px;
            font-size: 15px;
        }

        button.dislike{
            width: 30px;
            height: 30px;
            margin: 0 auto;
            line-heigth: 50px;
            border-radius: 50%;
            color: rgba(255,82,82 ,1);
            background-color: rgba(255,138,128 ,0.3);
            border-color: rgba(255,82,82 ,1);
            border-width: 1px;
            font-size: 15px;
        }

    </style>
    <%
        CookieService service = new CookieService();
        Users user = service.getCurrentUser(request);
        boolean isAc=user.isActive();
    %>
</head>
<body>
<jsp:include page="../header/header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-lg-8">
            <div class="card mb-4">
                <a href="#">
                    <img class="card-img-top"
                         src="data:image/png;base64,${currentProduct.photofile}" width="600" height="350"
                         alt="..."/>
                </a>
                <div class="card-body">

                    <div  class="d-flex justify-content-between">
                        <div>
                            <div class="small text-muted"><c:out value="${currentProduct.created_at}"/>
                        </div>
                        <div class="small text-muted">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye-fill" viewBox="0 0 16 16">
                                <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z"/>
                                <path d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8zm8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"/>

                            </svg>
                            <c:out value="${currentProduct.counterOfView}"/>
                        </div>
                    </div>

                    </div>

                    <h2 class="card-title "><c:out value="${currentProduct.titles}"/>
                    </h2>
                    <p class="card-text fw-bold"><c:out value="${currentProduct.description}"/>
                    </p>
                    <br>
                    <p class="lh-lg">
                        <c:out value="${currentProduct.textData}" escapeXml="false"/>
                    </p>
                </div>
            </div>

            <div class="be-comment-block">
                <h1 class="comments-title">Comments (3)</h1>
                <div class="be-comment">
                    <div class="be-img-comment">
                        <a href="blog-detail-2.html">
                            <img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="" class="be-ava-comment">
                        </a>
                    </div>
                    <div class="be-comment-content">

				<span class="be-comment-name">
					<a href="blog-detail-2.html">Ravi Sah</a>
					</span>
                        <span class="be-comment-time">
					<i class="fa fa-clock-o"></i>
					May 27, 2015 at 3:14am
				</span>

                        <p class="be-comment-text">
                            Pellentesque gravida tristique ultrices.
                            Sed blandit varius mauris, vel volutpat urna hendrerit id.
                            Curabitur rutrum dolor gravida turpis tristique efficitur.
                        </p>
                    </div>
                </div>
                <div class="be-comment">
                    <div class="be-img-comment">
                        <a href="blog-detail-2.html">
                            <img src="https://bootdey.com/img/Content/avatar/avatar2.png" alt="" class="be-ava-comment">
                        </a>
                    </div>
                    <div class="be-comment-content">
			<span class="be-comment-name">
				<a href="blog-detail-2.html">Phoenix, the Creative Studio</a>
			</span>
                        <span class="be-comment-time">
				<i class="fa fa-clock-o"></i>
				May 27, 2015 at 3:14am
			</span>
                        <p class="be-comment-text">
                            Nunc ornare sed dolor sed mattis. In scelerisque dui a arcu mattis, at maximus eros commodo. Cras magna nunc, cursus lobortis luctus at, sollicitudin vel neque. Duis eleifend lorem non ant. Proin ut ornare lectus, vel eleifend est. Fusce hendrerit dui in turpis tristique blandit.
                        </p>
                    </div>
                </div>
                <div class="be-comment">
                    <div class="be-img-comment">
                        <a href="blog-detail-2.html">
                            <img src="https://bootdey.com/img/Content/avatar/avatar3.png" alt="" class="be-ava-comment">
                        </a>
                    </div>
                    <div class="be-comment-content">
			<span class="be-comment-name">
				<a href="blog-detail-2.html">Cüneyt ŞEN</a>
			</span>
                        <span class="be-comment-time">
				<i class="fa fa-clock-o"></i>
				May 27, 2015 at 3:14am
			</span>
                        <p class="be-comment-text">
                            Cras magna nunc, cursus lobortis luctus at, sollicitudin vel neque. Duis eleifend lorem non ant
                        </p>
                    </div>
                </div>
                <form class="form-block">
                    <div class="row">
                        <div class="col-xs-12 col-sm-6">
                            <div class="form-group fl_icon">
                                <div class="icon"><i class="fa fa-user"></i></div>
                                <input class="form-input" type="text" placeholder="Your name">
                            </div>
                        </div>
                        <div class="col-xs-12 col-sm-6 fl_icon">
                            <div class="form-group fl_icon">
                                <div class="icon"><i class="fa fa-envelope-o"></i></div>
                                <input class="form-input" type="text" placeholder="Your email">
                            </div>
                        </div>
                        <br>
                        <div class="col-xs-12">
                            <div class="form-group">
                                <textarea class="form-input" required="" placeholder="Your text"></textarea>
                            </div>
                        </div>
                        <div class="col-xs-12 col-sm-6">
                            <a class="btn btn-primary pull-right">submit</a>
                        </div>
                    </div>
                </form>
            </div>

            <!-- From -->
        </div>
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
            <div class="card mb-4">
                <div class="card-body text-center">
                    <img src="https://thumbs.dreamstime.com/b/writer-agency-publishing-company-vector-logo-design-black-feather-pen-icon-writer-agency-publishing-company-logo-231443324.jpg" alt="avatar"
                         class="rounded-circle img-fluid" style="width: 150px;">
                    <h5 class="my-3"><c:out value="${currentPublisher.nameOfCompany}"/></h5>
                    <p class="text-muted mb-1"><c:out value="${currentPublisher.email}"/></p>
                    <p class="text-muted mb-4"><c:out value="${currentPublisher.address}"/></p>

                    <div class="d-flex justify-content-center mb-2">
                        <a href="displayPublisher?id=<c:out value='${currentPublisher.id}' />" type="button"
                           class="btn btn-primary">View publisher</a>
                   <%
                   if (isAc)
                   {
                   %>
                        <a href="complain?id=<c:out value='${currentPublisher.id}' />"type="button" class="btn btn-outline-primary ms-1">Complain</a>
                   <%
                       }
                   %>

                    </div>
                </div>
            </div>
<%--            <a href="singleData?id=<c:out value='${news.id}' />"--%>
<%--               class="btn btn-primary">Read more →</a>--%>
        </div>
    </div>
</div>
<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
</html>
