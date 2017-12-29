<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/24
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>find empty rooms by time</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/normalStyleSheet.css"/>
</head>
<body>
    <div>
        <%@ include file="menuBar.jsp"%>
    </div>
    <div class="normalFormat">
        <form action="findUsefulRoomsByTimeForm" method="post">
            <input type="date" name="limitTime" required/>
            <input class="btn btn-default" type="submit" value="search"/>
            <input class="btn btn-default" type="reset" value="reset"/>
        </form>
    </div>
    <div>
        <%@include file="showRooms.jsp"%>
    </div>
</body>
</html>
