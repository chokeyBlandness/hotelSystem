<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/19
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add new starff</title>
    <script src="js/angular.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/normalStyleSheet.css">
</head>
<body>
<div>
    <%@include file="menuBar.jsp"%>
</div>
    <div class="normalFormat" ng-app="">
        <form action="addNewStaffForm" method="post" name="addNewStaffForm">
            <p>staff id:</p>
            <input type="text" name="staffId" ng-model="staffId"
                   pattern="\d{6}" required placeholder="6位数字"
                   ng-class="{'error':addNewStaffForm.staffId.$invalid &&
                   addNewStaffForm.staffId.$touched}"/>
            <label ng-if="addNewStaffForm.staffId.$invalid &&
                   addNewStaffForm.staffId.$touched">请输入6位数字</label><br/>
            <p>staff password:</p>
            <input type="text" name="staffPassword" required
                   ng-model="staffPassword" placeholder="不能为空"
                   ng-class="{'error':addNewStaffForm.staffPassword.$invalid &&
                   addNewStaffForm.staffPassword.$touched}"/>
            <label ng-if="addNewStaffForm.staffPassword.$invalid &&
                   addNewStaffForm.staffPassword.$touched">请输入密码</label><br/>
            <p>staff name:</p>
            <input type="text" name="staffName" required
                   ng-model="staffName" placeholder="不能为空"
                   ng-class="{'error':addNewStaffForm.staffName.$invalid &&
                   addNewStaffForm.staffName.$touched}"/>
            <label ng-if="addNewStaffForm.staffName.$invalid &&
                   addNewStaffForm.staffName.$touched">请输入名字</label><br/>
            <p>staff identification:</p>
            <input type="text" name="staffIdentification" required pattern="\d{18}"
                   ng-model="staffIdentification" placeholder="18位身份证号"
                   ng-class="{'error':addNewStaffForm.staffIdentification.$invalid &&
                   addNewStaffForm.staffIdentification.$touched}"/>
            <label ng-if="addNewStaffForm.staffIdentification.$invalid &&
                   addNewStaffForm.staffIdentification.$touched">请输入18位身份证号</label><br/>
            <input class="btn btn-default" type="submit" value="submit" ng-disabled="addNewStaffForm.$invalid"/>
            <input class="btn btn-default" type="reset" value="reset"/>
        </form>
    </div>
</body>
</html>
