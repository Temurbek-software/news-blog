<%--
  Created by IntelliJ IDEA.
  User: Temurbek
  Date: 6/15/2022
  Time: 1:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="../header/header2.jsp"></jsp:include>
<!-- Font Awesome -->
<link
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
        rel="stylesheet"
/>
<!-- Google Fonts -->
<link
        href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
        rel="stylesheet"
/>
<!-- MDB -->
<link
        href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.2.0/mdb.min.css"
        rel="stylesheet"
/>
<head>
    <title>Registration page</title>
</head>
<style>
    .gradient-custom {
        background: #fafafa;
    }

    .card-registration .select-input.form-control[readonly]:not([disabled]) {
        font-size: 1rem;
        line-height: 2.15;
        padding-left: .75em;
        padding-right: .75em;
    }

    .card-registration .select-arrow {
        top: 13px;
    }

    .modal-confirm {
        color: #636363;
        width: 325px;
        font-size: 14px;
    }

    .modal-confirm .modal-content {
        padding: 20px;
        border-radius: 5px;
        border: none;
    }

    .modal-confirm .modal-header {
        border-bottom: none;
        position: relative;
    }

    .modal-confirm h4 {
        text-align: center;
        font-size: 26px;
        margin: 30px 0 -15px;
    }

    .modal-confirm .form-control, .modal-confirm .btn {
        min-height: 40px;
        border-radius: 3px;
    }

    .modal-confirm .close {
        position: absolute;
        top: -5px;
        right: -5px;
    }

    .modal-confirm .modal-footer {
        border: none;
        text-align: center;
        border-radius: 5px;
        font-size: 13px;
    }

    .modal-confirm .icon-box {
        color: #fff;
        position: absolute;
        margin: 0 auto;
        left: 0;
        right: 0;
        top: -70px;
        width: 95px;
        height: 95px;
        border-radius: 50%;
        z-index: 9;
        background: #82ce34;
        padding: 15px;
        text-align: center;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
    }

    .modal-confirm .icon-box i {
        font-size: 58px;
        position: relative;
        top: 3px;
    }

    .modal-confirm.modal-dialog {
        margin-top: 80px;
    }

    .modal-confirm .btn {
        color: #fff;
        border-radius: 4px;
        background: #82ce34;
        text-decoration: none;
        transition: all 0.4s;
        line-height: normal;
        border: none;
    }

    .modal-confirm .btn:hover, .modal-confirm .btn:focus {
        background: #6fb32b;
        outline: none;
    }

    .trigger-btn {
        display: inline-block;
        margin: 100px auto;
    }
</style>
<body>
<jsp:include page="../header/header.jsp"></jsp:include>

<section class="vh-100 gradient-custom">
    <c:if test="${msg==false}">
        <div class="alert alert-danger d-flex align-items-center" role="alert">
            <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:">
                <use xlink:href="#exclamation-triangle-fill"/>
            </svg>
            <div>
               You have an account bru
            </div>
        </div>
    </c:if>

    <div class="container py-5 h-100">
        <div class="row justify-content-center align-items-center h-100">
            <div class="col-12 col-lg-9 col-xl-7">
                <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration Form</h3>
                        <form action="registration" method="post">

                            <div class="row">
                                <div class="col-md-6 mb-4">

                                    <div class="form-outline">
                                        <input type="text" name="username" required
                                               class="form-control form-control-lg"/>
                                        <label class="form-label">Your name<span
                                                class="text-danger">*</span></label> </label>

                                    </div>

                                </div>
                                <div class="col-md-6 mb-4">

                                    <div class="form-outline">
                                        <input type="text" name="fullName" required
                                               class="form-control form-control-lg"/>
                                        <label class="form-label">Full name<span
                                                class="text-danger">*</span></label></label>
                                    </div>

                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6 mb-4 d-flex align-items-center">

                                    <div class="form-outline datepicker w-100">
                                        <input type="password" required name="password"
                                               class="form-control form-control-lg">
                                        <label class="form-label">Password<span
                                                class="text-danger">*</span></label></label>
                                    </div>

                                </div>
                                <div class="col-md-6 mb-4 pb-2">

                                    <div class="form-outline">
                                        <input type="email" required name="email" class="form-control form-control-lg"/>
                                        <label class="form-label">Email<span
                                                class="text-danger">*</span></label></label>
                                    </div>

                                </div>
                            </div>

                            <div class="row">

                                <div class="col-md-12 mb-4 pb-2">

                                    <div class="form-outline">
                                        <input type="tel" required name="phoneNumber"
                                               class="form-control form-control-lg"/>
                                        <label class="form-label">Phone Number</label>
                                    </div>

                                </div>
                            </div>
                            <div class="mt-4 pt-2">
                                <input class="btn btn-primary btn-lg" type="submit" value="Submit"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script type="text/javascript">
    var b =<c:out value='${result}'/>;
    if (b = true) {
        window.onload = function () {
            OpenBootstrapPopup();
        };

        function OpenBootstrapPopup() {
            $("#success_").modal('show');
        }
    }
    if (b = false) {
        window.onload = function () {
            OpenBootstrapPopup();
        };

        function OpenBootstrapPopup() {
            $("#wrong_tic").modal('show');
        }
    }
</script>
<%--Wrong massage--%>
<div id="wrong_tic" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <button type="button" class="btn-close" aria-hidden="true" data-bs-dismiss="modal"
                    aria-label="Close"></button>
            <div class="page-body">
                <div class="head">
                    <h4>Something wrong check please</h4>
                </div>

                <h1 style="text-align:center;">
                    <div class="checkmark-circle">
                        <div class="background2"></div>
                        <div class="checkmark draw"></div>
                    </div>
                </h1>

            </div>
        </div>
    </div>

</div>
<%--success modal--%>
<div id="success_" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <button type="button" class="btn-close" aria-hidden="true" data-bs-dismiss="modal"
                    aria-label="Close"></button>
            <div class="page-body">
                <div class="head">
                    <h4>User has been saved correctly</h4>
                </div>

            </div>
        </div>
    </div>

</div>
<script
        type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.2.0/mdb.min.js"></script>
<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
</html>
