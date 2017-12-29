<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/22
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>order room</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/normalStyleSheet.css"/>
    <script src="js/angular.js"></script>
</head>
<body>
    <div>
        <%@ include file="menuBar.jsp"%>
    </div>
    <div class="normalFormat" ng-app="">
        <form action="orderRoomForm" method="post">
            <p>入住时间：</p>
            <input type="date" name="checkInTime" required/><br/>
            <p>离开时间：</p>
            <input type="date"name="checkOutTime" required/><br/>
            <p>房间类型：</p>
            <select name="roomProporty" ng-model="roomProporty">
                <option value="single" selected>单人间</option>
                <option value="double">双人间</option>
                <option value="triple">三人间</option>
            </select><br/>
            <p>入住人1身份证：</p>
            <input type="text" name="person_1" required
                   placeholder="18位身份证号" pattern="\d{18}"/><br/>
            <p>入住人2身份证：</p>
            <input type="text" name="person_2" required
                   placeholder="18位身份证号" pattern="\d{18}"
                   ng-if="roomProporty=='double'||roomProporty=='triple'"/><br/>
            <p>入住人3身份证：</p>
            <input type="text" name="person_3" required
                   placeholder="18位身份证号" pattern="\d{18}"
                   ng-if="roomProporty=='triple'"/><br/>
            <input class="btn btn-default" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
        </form>
    </div>
</body>
</html>
