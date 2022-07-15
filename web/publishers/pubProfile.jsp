<%--
  Created by IntelliJ IDEA.
  User: Temurbek
  Date: 7/11/2022
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="payload.CookieService" %>
<%@ page import="entity.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    CookieService service = new CookieService();
    Users user = service.getCurrentUser(request);
%>
<html>
<head>
    <title>Publisher profile</title>
    <jsp:include page="../header/header2.jsp"></jsp:include>
    <style>
        #success_tic .page-body {
            max-width: 300px;
            background-color: #FFFFFF;
            margin: 10% auto;
        }

        #success_tic .page-body .head {
            text-align: center;
        }

        /* #success_tic .tic{
          font-size:186px;
        } */
        #success_tic .close {
            opacity: 1;
            position: absolute;
            right: 0px;
            font-size: 30px;
            padding: 3px 15px;
            margin-bottom: 10px;
        }

        #success_tic .checkmark-circle {
            width: 150px;
            height: 150px;
            position: relative;
            display: inline-block;
            vertical-align: top;
        }

        .checkmark-circle .background {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            background: #1ab394;
            position: absolute;
        }

        .checkmark-circle .background2 {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            background: #fc4e03;
            position: absolute;
        }

        #success_tic .checkmark-circle .checkmark {
            border-radius: 5px;
        }

        #success_tic .checkmark-circle .checkmark.draw:after {
            -webkit-animation-delay: 300ms;
            -moz-animation-delay: 300ms;
            animation-delay: 300ms;
            -webkit-animation-duration: 1s;
            -moz-animation-duration: 1s;
            animation-duration: 1s;
            -webkit-animation-timing-function: ease;
            -moz-animation-timing-function: ease;
            animation-timing-function: ease;
            -webkit-animation-name: checkmark;
            -moz-animation-name: checkmark;
            animation-name: checkmark;
            -webkit-transform: scaleX(-1) rotate(135deg);
            -moz-transform: scaleX(-1) rotate(135deg);
            -ms-transform: scaleX(-1) rotate(135deg);
            -o-transform: scaleX(-1) rotate(135deg);
            transform: scaleX(-1) rotate(135deg);
            -webkit-animation-fill-mode: forwards;
            -moz-animation-fill-mode: forwards;
            animation-fill-mode: forwards;
        }

        #success_tic .checkmark-circle .checkmark:after {
            opacity: 1;
            height: 75px;
            width: 37.5px;
            -webkit-transform-origin: left top;
            -moz-transform-origin: left top;
            -ms-transform-origin: left top;
            -o-transform-origin: left top;
            transform-origin: left top;
            border-right: 15px solid #fff;
            border-top: 15px solid #fff;
            border-radius: 2.5px !important;
            content: '';
            left: 35px;
            top: 80px;
            position: absolute;
        }

        @-webkit-keyframes checkmark {
            0% {
                height: 0;
                width: 0;
                opacity: 1;
            }
            20% {
                height: 0;
                width: 37.5px;
                opacity: 1;
            }
            40% {
                height: 75px;
                width: 37.5px;
                opacity: 1;
            }
            100% {
                height: 75px;
                width: 37.5px;
                opacity: 1;
            }
        }

        @-moz-keyframes checkmark {
            0% {
                height: 0;
                width: 0;
                opacity: 1;
            }
            20% {
                height: 0;
                width: 37.5px;
                opacity: 1;
            }
            40% {
                height: 75px;
                width: 37.5px;
                opacity: 1;
            }
            100% {
                height: 75px;
                width: 37.5px;
                opacity: 1;
            }
        }

        @keyframes checkmark {
            0% {
                height: 0;
                width: 0;
                opacity: 1;
            }
            20% {
                height: 0;
                width: 37.5px;
                opacity: 1;
            }
            40% {
                height: 75px;
                width: 37.5px;
                opacity: 1;
            }
            100% {
                height: 75px;
                width: 37.5px;
                opacity: 1;
            }
        }

    </style>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="<%=request.getContextPath()%>/">Bosh menu</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="aboutUs">About</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
                <li class="nav-item">
                    <a class="nav-link" data-bs-toggle="modal" href="#exampleModal">
                        Subscribtion
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" data-toggle="modal" href="#ModalForm">
                        <img width="20"
                             src="https://icon-library.com/images/profile-photo-icon/profile-photo-icon-10.jpg" alt=""></a>
                </li>
                <c:if test="${userSession!=null}">
                    <li class="nav-item" style="display: flex; align-items:center ;">
                        <div class="dropdown p-0">
                            <a class="nav-link dropdown-toggle p-0" href="#"
                               role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false"
                               href="#">
                                <%=user.getUsername()%>
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                <li><a class="dropdown-item" href="userSetting">Settings</a></li>
                                <li><a class="dropdown-item" href="#">Massage</a></li>
                                <li><a class="dropdown-item" href="logout">Logout</a></li>
                            </ul>
                        </div>


                    </li>
                </c:if>

            </ul>
        </div>
    </div>
</nav>
<c:if test="${falseUser==false}">
    <div class="alert alert-warning alert-dismissible fade show" role="alert">
        <strong>Wrong user Brug!</strong> You should sign up right here.
        <a href="/register/registration.jsp">Signup</a>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">
        </button>
    </div>
</c:if>
<%--Login modal--%>
<div class="modal fade" id="ModalForm" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <%
                Cookie[] cookies = request.getCookies();
                String userName = "", password = "", rememberVal = "";
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("cocUser")) {
                            userName = cookie.getValue();
                        }
                        if (cookie.getName().equals("cocPas")) {
                            password = cookie.getValue();
                        }
                        if (cookie.getName().equals("cocRem")) {
                            rememberVal = cookie.getValue();
                        }
                    }
                }
            %>
            <!-- Login Form -->
            <form action="login" method="post">
                <div class="modal-header">
                    <h5 class="modal-title">Sign in</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label>Username<span class="text-danger">*</span></label>
                        <input type="text" name="logusername" value="<%=userName%>"
                               class="form-control"
                               autocomplete="off"
                               placeholder="Enter Username">
                    </div>

                    <div class="mb-3">
                        <label>Password<span class="text-danger">*</span></label>
                        <input type="password" name="logpassword" value="<%=password%>"
                               class="form-control"
                               autocomplete="off"
                               placeholder="Enter Password">
                    </div>
                    <div class="mb-3">
                        <input class="form-check-input" name="remember" type="checkbox" value="1"
                            <%= "1".equals(rememberVal.trim()) ? "checked=\"checked\"" : "" %>
                               required>
                        <label class="form-check-label">Remember Me</label>

                        <a href="#" class="float-end">Forgot Password</a>
                    </div>
                    <div class="modal-footer pt-4">
                        <button type="submit" class="btn btn-success mx-auto w-100">Login</button>
                    </div>
                </div>

                <p class="text-center">Not yet account, <a href="showRegister">Signup</a></p>
            </form>
        </div>
    </div>
</div>
<!-- subscription modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog  modal-dialog-centered">
        <div class="modal-content">
            <form action="sendEmail" method="post">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Subscribe now</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label class="form-label">Enter your email</label>
                        <input name="emailing" type="email" class="form-control"
                               aria-describedby="emailHelp">
                        <div id="emailHelp" class="form-text">
                            We are happy to work with you
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">Subscribe</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%--success modal--%>
<div id="success_tic" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <button type="button" class="btn-close" aria-hidden="true" data-bs-dismiss="modal"
                    aria-label="Close"></button>
            <div class="page-body">
                <div class="head">
                    <h4>Thank you your subscription</h4>
                </div>

                <h1 style="text-align:center;">
                    <div class="checkmark-circle">
                        <div class="background"></div>
                        <div class="checkmark draw"></div>
                    </div>
                </h1>

            </div>
        </div>
    </div>

</div>

<section style="background-color: #eee;">
    <div class="container py-5">
        <div class="row">
            <div class="col">
                <nav aria-label="breadcrumb" class="bg-light rounded-3 p-3 mb-4">
                    <ol class="breadcrumb mb-0">
                        <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/">Home</a></li>
                        <li class="breadcrumb-item active" aria-current="page">publisher profile</li>
                    </ol>
                </nav>
            </div>
        </div>


        <div class="row">
            <div class="col-lg-4">
                <div class="card mb-4">
                    <div class="card-body text-center">
                        <img src="https://thumbs.dreamstime.com/b/publishing-company-logo-5950113.jpg"
                             alt="avatar"
                             class="rounded-circle img-fluid" style="width: 150px;">
                        <h5 class="my-3"><c:out value="${publisherAtribute.nameOfCompany}"/></h5>
                        <p class="text-muted mb-1"><c:out value="${publisherAtribute.email}"/></p>
                        <p class="text-muted mb-4"><c:out value="${publisherAtribute.address}"/></p>

                    </div>
                </div>

            </div>
            <div class="col-lg-8">
                <div class="card mb-4">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Comany name</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0"><c:out value="${publisherAtribute.nameOfCompany}"/></p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Email</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0"><c:out value="${publisherAtribute.email}"/></p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Phone</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0"><c:out value="${publisherAtribute.phoneNumber}"/></p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Mobile</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0"><c:out value="${publisherAtribute.phoneNumber}"/></p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Address</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0"><c:out value="${publisherAtribute.address}"/></p>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div class="row">
                <div class="col-md-12">
                    <div class="card text-center">
                        <div class="card-header">
                            Description
                        </div>
                        <div class="card-body">
                            <h5 class="card-title"><c:out value="${publisherAtribute.nameOfCompany}"/></h5>
                            <p class="card-text"><c:out value="${publisherAtribute.description}"/></p>
<%--                            <a href="#" class="btn btn-primary">Go somewhere</a>--%>
                        </div>
<%--                        <div class="card-footer text-muted">--%>
<%--                            2 days ago--%>
<%--                        </div>--%>
                    </div>
                </div>
        </div>
    </div>
</section>


<jsp:include page="../footer/footer.jsp"></jsp:include>
<script type="text/javascript">
    var b =<c:out value='${natija}'/>;
    if (b = true) {
        window.onload = function () {
            OpenBootstrapPopup();
        };

        function OpenBootstrapPopup() {
            $("#success_tic").modal('show');
        }
    }
</script>
<script type="text/javascript">
    var b =<c:out value='${hasError}'/>;
    if (b = true) {
        window.onload = function () {
            OpenBootstrapPopup();
        };

        function OpenBootstrapPopup() {
            $("#success_tic").modal('show');
        }
    }
</script>
</body>
</html>
