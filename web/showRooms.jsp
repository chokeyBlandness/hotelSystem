<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/16
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
    <title>rooms</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>
<body>
    <div>
        <table class="table table-bordered table-hover">
            <tr>
                <td>房间号</td>
                <td>楼层</td>
                <td>属性</td>
                <td>朝向</td>
                <td>房间状态</td>
                <td>离开时间</td>
                <td>单价</td>
            </tr>
            <c:forEach var="rooms" items="${roomList}">
                <tr>
                    <td>${rooms.roomId}</td>
                    <td>${rooms.roomFloor}</td>
                    <td>${rooms.roomProporty}</td>
                    <td>${rooms.roomDirection}</td>
                    <td>${rooms.roomStatus}</td>
                    <td>${rooms.leaveRoomTimeString()}</td>
                    <td>${rooms.price}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
