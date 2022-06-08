<%--
  Created by IntelliJ IDEA.
  User: Temurbek
  Date: 6/8/2022
  Time: 5:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%--<jsp:include page="header/head.jsp"></jsp:include>--%>
</head>
<body>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>id</th>
        <th>username</th>
        <th>fullName</th>
        <th>password</th>
        <th>phoneNumber</th>
        <th>email</th>
        <th>createdTime</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${userss}" var="users">
        <tr>
            <td><c:out value="${users.id}"/></td>
            <td><c:out value="${users.username}"/></td>
            <td><c:out value="${users.fullName}"/></td>
            <td><c:out value="${users.password}"/></td>
            <td><c:out value="${users.phoneNumber}"/></td>
            <td><c:out value="${users.email}"/></td>
            <td><c:out value="${users.createdTime}"/></td>
        </tr>
    </c:forEach>
    </tbody>

</table>
<%--<jsp:include page="header/header.jsp"></jsp:include>--%>
<%--<jsp:include page="footer/footer.jsp"></jsp:include>--%>
</body>
</html>
