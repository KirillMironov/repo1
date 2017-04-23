<%--
  Created by IntelliJ IDEA.
  User: kmiro
  Date: 22.04.2017
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <script src="js/core.js"></script>
    <script src="js/sha256.js"></script>
    <script>
        function sha256(s) {
            return CryptoJS.SHA256(s)
        }
        function processForm() {
            var password = document.getElementById('passwordInput').value;
            var hash = sha256(password);
            document.getElementById('passwordInput').value = hash;
            return true;
        }
    </script>
</head>
<body>
<div style="horiz-align: center">
    <form action="login-controller" onsubmit="processForm(); return true;" method="post">
        <table border="1">
            <tr>
                <td><label for="loginInput">Login:</label></td>
                <td><input id="loginInput" name="login" type="text" style="size: 100px"/></td>
            </tr>
            <tr>
                <td><label for="passwordInput">Password:</label></td>
                <td><input id="passwordInput" name="password" type="password" style="size: 100px"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
