<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/30
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete administor</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/normalStyleSheet.css"/>
</head>
<body>
    <div>
        <%@include file="menuBar.jsp"%>
    </div>
    <div>
        <p style="color: red">${deleteMessage}</p>
        <form action="deleteAdministorForm" class="form-group normalFormat" method="post">
            <p>delete administor</p>
            <input type="text" required name="deleteAccount" placeholder="请输入你要删除的账号"/><br/>
            <input type="submit" class="btn btn-danger" onclick="deleteConfirm()" value="删除"/>
        </form>
    </div>

    <script>
        function deleteConfirm() {
            var m="确定删除账号吗？";
            if (confirm(m)==true){
                return true;
            }else {
                return false;
            }
        }
    </script>
</body>
</html>
