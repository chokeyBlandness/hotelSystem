<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/19
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>menu</title>
    <script src="js/angular.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <style>
        a{
            font-size: 32px;
        }
    </style>
</head>
<body ng-app="">
    <div style="background-color: #5cb85c">
    <div style="margin-top: 0px;margin-left: 0px">
        <a href="index.jsp">首页</a>
    </div>
    <div style="margin-top: 0px;text-align: right " ng-if="${sessionScope.account==null}">
        <a href="login.jsp">login</a>
        <a href="register.jsp">register</a>
    </div>
    <div style="margin-top: 0px;text-align: right " ng-if="${sessionScope.account!=null}">
        <p>welcome:${sessionScope.account}</p><br/>

        <div  ng-if="${sessionScope.accountLevel=='manager'}">
            <a href="searchAllRooms.jsp">所有房间状态</a>
            <a href="addNewStaff.jsp">添加工作人员</a><br/>
        </div>

        <div ng-if="${sessionScope.accountLevel=='manager'||sessionScope.accountLevel=='staff'}">
            <a href="findIndentByIdentification.jsp">身份证号查询订单</a>
            <a href="checkOut.jsp">退房</a><br/>
        </div>

        <div>
            <a href="orderRoom.jsp">订房</a>
            <a href="findUsefulRoomsByTime.jsp">查找有效房</a>
            <a href="indentList.jsp">订单表</a>
        </div>


        <form action="logoutForm" method="post">
            <input type="submit" value="注销"/>
        </form>
    </div>
    </div>
</body>
</html>
