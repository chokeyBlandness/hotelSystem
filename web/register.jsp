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
    <title>register</title>
    <script src="js/angular.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/normalStyleSheet.css">
</head>
<body>
<div>
    <a href="index.jsp">首页</a>
    <a href="login.jsp">登录</a>
</div>
<div class="normalFormat" ng-app="">
    <form action="registerAdministorForm" method="post" name="registerAdministorForm">
        <p>account</p>
        <input type="text" name="account" pattern=".{7,10}"
               required placeholder="7-10位字符"
               ng-minlength="6" ng-model="account"
               ng-class="{'error':registerAdministorForm.account.$invalid &&
                           registerAdministorForm.account.$touched}"/>
        <label ng-if="registerAdministorForm.account.$invalid &&
                           registerAdministorForm.account.$touched">7-10位字符</label>
        <p>password:</p>
        <input type="password" name="password" required
               pattern=".{8,}" ng-model="password" placeholder="至少8位密码"
               ng-class="{'error':registerAdministorForm.password.$invalid &&
                           registerAdministorForm.password.$touched}"/>
        <label ng-if="registerAdministorForm.password.$invalid &&
                           registerAdministorForm.password.$touched">至少8位密码</label><br/>
        <p>confirmed password:</p>
        <input type="password" name="confirmedPassword"
               required ng-model="confirmedPassword"
               pattern="{{password}}"
               ng-class="{'error':registerAdministorForm.confirmedPassword.$invalid &&
                           registerAdministorForm.confirmedPassword.$touched}"/>
        <label ng-if="registerAdministorForm.confirmedPassword.$invalid &&
                           registerAdministorForm.confirmedPassword.$touched">与密码不符</label><br/>
        <p>username:</p>
        <input type="text" name="username" ng-model="username"
               required ng-class="{'error':registerAdministorForm.username.$invalid &&
                           registerAdministorForm.username.$touched}"/>
        <label ng-if="registerAdministorForm.username.$invalid &&
                           registerAdministorForm.username.$touched">不能为空</label><br/>
        <p>identification:</p>
        <input type="text" name="identification" required
               placeholder="18位身份证号"
               ng-model="identification" pattern="\d{18}"
               ng-class="{'error':registerAdministorForm.identification.$invalid &&
                           registerAdministorForm.identification.$touched}"/>
        <label ng-if="registerAdministorForm.identification.$invalid &&
                           registerAdministorForm.identification.$touched">请用18位的身份证号实名注册</label><br/>
        <input class="btn btn-default" type="submit" value="提交" ng-disabled="registerAdministorForm.$invalid"/>
        <input class="btn btn-default" type="reset" value="重置"/>
    </form>
</div>
</body>
</html>
