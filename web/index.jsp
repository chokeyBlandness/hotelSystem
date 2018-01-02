<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/11
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index</title>

  </head>
  <body>
    <div>
      <%@include file="menuBar.jsp"%>
    </div>
    <div>
      <div class="jumbotron">
        <div class="container">
          <h1>Hello, visitor!</h1>
          <img src="pic/1.jpg" style="height: 500px;width: 800px">
        </div>
      </div>

      <div class="container">
        <!-- Example row of columns -->
        <div class="row">
          <div class="col-md-4">
            <h2>单人间</h2>
            <img src="pic/single.jpg" style="height: 200px;width: 360px">
            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
          </div>
          <div class="col-md-4">
            <h2>双人间</h2>
            <img src="pic/double.jpg" style="height: 200px;width: 360px">
            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
          </div>
          <div class="col-md-4">
            <h2>三人间</h2>
            <img src="pic/triple.jpg" style="height: 200px;width: 360px">
            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
          </div>
        </div>
        <hr>
        <footer>
          <p>&copy; 2018, Inc.</p>
        </footer>

      </div>
  </body>
</html>
