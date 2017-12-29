<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/25
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>check out</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/normalStyleSheet.css"/>
</head>
<body>
    <%@include file="menuBar.jsp"%>

    <div class="normalFormat">
        <form action="checkOutForm" method="post">
            <p>房间号：</p>
            <input type="text" name="checkOutRoomId" required/>
            <input class="btn btn-danger" type="submit" value="退房"/>
        </form>
    </div>
</body>
</html>
