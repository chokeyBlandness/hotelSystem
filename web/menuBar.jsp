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

</head>
<body ng-app="">




<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">首页</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse navbar-right">

                <div ng-if="${sessionScope.account==null}">
                    <a class="navbar-brand" href="login.jsp">login</a>
                    <a class="navbar-brand" href="register.jsp">register</a>
                </div>

                    <div ng-if="${sessionScope.account!=null}">
                        <h1 style="color: #d58512;">welcome:${sessionScope.account}</h1><br/>

                        <div  ng-if="${sessionScope.accountLevel=='manager'}">
                            <a class="navbar-brand" href="searchAllRooms.jsp">所有房间状态</a>
                            <a class="navbar-brand" href="addNewStaff.jsp">添加工作人员</a>
                            <a class="navbar-brand" href="deleteAdministor.jsp">删除账号</a><br/>
                        </div>

                        <div ng-if="${sessionScope.accountLevel=='manager'||sessionScope.accountLevel=='staff'}">
                            <a class="navbar-brand" href="findIndentByIdentification.jsp">身份证号查询订单</a>
                            <a class="navbar-brand" href="checkOut.jsp">退房</a><br/>
                        </div>

                        <div>
                            <a class="navbar-brand" href="orderRoom.jsp">订房</a>
                            <a class="navbar-brand" href="findUsefulRoomsByTime.jsp">查找有效房</a>
                            <a class="navbar-brand" href="indentList.jsp">订单表</a>
                        </div>

                        <form action="logoutForm" method="post" class="navbar-form form-group">
                            <input class="btn btn-danger" type="submit" value="注销"/>
                        </form>
                    </div>
        </div><!--/.navbar-collapse -->
    </div>
</nav>





</body>
</html>
