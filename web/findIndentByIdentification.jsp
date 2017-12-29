<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/25
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>find indent by identification</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/normalStyleSheet.css"/>
</head>
<body>
    <div class="normalFormat">
        <form action="findIndentByIdentificationForm" method="post">
            <p>入住人身份证号：</p>
            <input type="text" pattern="\d{18}" name="personId"
                   placeholder="18位身份证号" required/>
            <input class="btn btn-default" type="submit" value="查询"/>
        </form>
    </div>
</body>
</html>
