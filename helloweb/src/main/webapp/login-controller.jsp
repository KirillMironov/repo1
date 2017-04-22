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
    <script src="js/core.js"></script>
    <script src="js/sha256.js"></script>
    <script>
        function sha256(s) {
            return CryptoJS.SHA256(s)
        }
    </script>
</head>
<body>
    <div>
        Login:<%= request.getParameter("login")%>
    </div>
    <div>
        Password:<%= request.getParameter("password")%>
    </div>
    <div>
        <form name="test">
            <input type="button" value="test" onclick="alert(sha256('123'))">
        </form>
        Hash:sha256('<%= request.getParameter("password")%>')
    </div>
</body>
</html>
