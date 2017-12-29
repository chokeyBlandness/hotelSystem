<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/24
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>indent list</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>
<body>
    <div class="">
        <%@ include file="menuBar.jsp"%>
    </div>
    <div class="center-block">
        <table class="table table-bordered table-hover">
            <tr>
                <td>订单号</td>
                <td>房间类型</td>
                <td>入住时间</td>
                <td>离开时间</td>
                <td>订单状态</td>
                <td>入住人1</td>
                <td>入住人2</td>
                <td>入住人3</td>
            </tr>
            <c:forEach var="indent" items="${indentList}">
                <tr>
                    <td>${indent.indentNumber}</td>
                    <td>${indent.roomProporty}</td>
                    <td>${indent.checkInTimeString()}</td>
                    <td>${indent.checkOutTimeString()}</td>
                    <td>${indent.indentStatus}</td>
                    <td>${indent.person_1}</td>
                    <td>${indent.person_2}</td>
                    <td>${indent.person_3}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
