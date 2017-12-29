<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/25
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>allocate room</title>
    <script src="js/angular.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>
<body ng-app="">
    <div>
        <%@include file="menuBar.jsp"%>
    </div>
    <div>
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
                <tr>
                    <td>${sessionScope.indent.indentNumber}</td>
                    <td>${sessionScope.indent.roomProporty}</td>
                    <td>${sessionScope.indent.checkInTimeString()}</td>
                    <td>${sessionScope.indent.checkOutTimeString()}</td>
                    <td>${sessionScope.indent.indentStatus}</td>
                    <td>${sessionScope.indent.person_1}</td>
                    <td>${sessionScope.indent.person_2}</td>
                    <td>${sessionScope.indent.person_3}</td>
                </tr>
        </table>
    </div>
    <div>
        <form action="searchProportyRoomsForm" method="post">
            search by:
            <select name="searchCategory" ng-model="searchCategory">
                <option value="floor">floor</option>
                <option value="direction">direction</option>
            </select>
            <select name="floor" ng-if="searchCategory=='floor'">
                <option value="1" selected>1</option>
                <option value="2">2</option>
                <option value="3">3</option>
            </select>
            <select name="direction" ng-if="searchCategory=='direction'">
                <option value="e" selected>东</option>
                <option value="n">南</option>
                <option value="w">西</option>
                <option value="n">北</option>
            </select>
            <input type="submit" value="搜索"/>
        </form>
    </div>
    <div>
        <form action="allocateRoomForm" method="post">
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
                    <td><button type="submit" name="allocateRoom"
                                value="${rooms.roomId}" class="btn btn-primary"
                                ng-if="${rooms.roomStatus=='empty'}">定房</button></td>
                </tr>
            </c:forEach>
        </table>
        </form>
    </div>
</body>
</html>
