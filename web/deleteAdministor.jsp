<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/30
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete administor</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/normalStyleSheet.css"/>
</head>
<body>
    <div>
        <%@include file="menuBar.jsp"%>
    </div>
    <div>
        <p style="font-size: 40px;color: red">${deleteMessage}</p>
        <form action="deleteAdministorForm" class="form-group" method="post">

            <table class="table table-bordered table-hover">
                <tr>
                    <td>账号</td>
                    <td>用户名</td>
                    <td>账号级别</td>
                </tr>
                <c:forEach var="administor" items="${allAdministors}">
                    <tr>
                        <td>${administor.administorAccount}</td>
                        <td>${administor.username}</td>
                        <td>${administor.administorlevel}</td>
                        <td><button class="btn btn-danger"
                                name="deleteAccount" type="submit"
                                value="${administor.administorAccount}"
                                onclick="return deleteConfirm()">删除</button></td>
                    </tr>
                </c:forEach>
            </table>

        </form>
    </div>
    <script>
        function deleteConfirm() {
            var m="确定删除账号吗？";
            if (confirm(m)==true){
                return true;
            }else {
                return false;
            }
        }

    </script>
</body>
</html>
