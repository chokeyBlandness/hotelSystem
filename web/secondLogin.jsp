<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/18
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>second login</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/normalStyleSheet.css"/>
</head>
<body>
    <div class="normalFormat">
        <p style="color: red">${secondLoginMessage}</p>
        <form action="secondLoginForm" method="post" name="secondLoginForm">
            <p>second password:</p>
            <input type="password" required
                   ng-class="{'error':secondLoginForm.secondPassword.$invalid &&
                   secondLoginForm.secondPassword.$touched}"
                   name="secondPassword"/>
            <label ng-if="secondLoginForm.secondPassword.$invalid &&
                   secondLoginForm.secondPassword.$touched">不能为空</label><br/>
            <input class="btn btn-default" type="submit" value="submit"/>
        </form>
    </div>
</body>
</html>
