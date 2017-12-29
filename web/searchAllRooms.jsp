<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/25
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>search all rooms</title>
</head>
<body>
<div>
    <%@ include file="menuBar.jsp"%>
</div>
<div>
    <form action="searchAllRoomsForm" method="post">
        search by:
        <select name="searchCategory" ng-model="searchCategory">
            <option value="floor">floor</option>
            <option value="proporty">proporty</option>
            <option value="direction">direction</option>
        </select>
        <select name="floor" ng-if="searchCategory=='floor'">
            <option value="1" selected>1</option>
            <option value="2">2</option>
            <option value="3">3</option>
        </select>
        <select name="proporty" ng-if="searchCategory=='proporty'">
            <option value="single" selected>single</option>
            <option value="double">double</option>
            <option value="triple">triple</option>
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
<%@include file="showRooms.jsp"%>
</body>
</html>
