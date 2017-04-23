<%--
  Created by IntelliJ IDEA.
  User: kmiro
  Date: 22.04.2017
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login-controller</title>
</head>
<body>
    <div>
        Login:<%= request.getParameter("login")%>
    </div>
    <div>
        Password:<%= request.getParameter("password")%>
    </div>
    <div>
        Message:<%= request.getParameter("message")%>
    </div>
</body>
</html>
