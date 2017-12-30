<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/17
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script src="js/angular.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/normalStyleSheet.css">
    <style>
        a{
            font-size: 32px;
        }
    </style>
</head>
<body>
    <div>
        <a href="index.jsp">首页</a>
        <a href="register.jsp">注册</a>
    </div>
    <div class="form-group normalFormat" ng-app="">
        ${requestScope.loginMessage}
        <form action="loginForm" method="post" name="loginForm">
            <p>account:</p>
            <input type="text" name="account" required
                   ng-model="account" placeholder="请输入您的账号"
                   ng-class="{'error':loginForm.account.$invalid &&
                   loginForm.account.$touched}"/>
            <label ng-if="loginForm.account.$invalid &&
                   loginForm.account.$touched">不能为空</label><br/>
            <p>password:</p>
            <input type="password" name="password" required
                   ng-model="password" placeholder="请输入您的密码"
                   ng-class="{'error':loginForm.password.$invalid &&
                   loginForm.password.$touched}"/>
            <label ng-if="loginForm.password.$invalid &&
                   loginForm.password.$touched">不能为空</label><br/>
            <input class="btn btn-default" type="submit" value="提交" ng-disabled="loginForm.$invalid"/>
            <input class="btn btn-default" type="reset" value="重置"/>
        </form>
    </div>
</body>
</html>
