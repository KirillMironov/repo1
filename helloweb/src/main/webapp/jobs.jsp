<%@ page import="java.util.Locale" %>
<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: kmiro
  Date: 16.04.2017
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jobs</title>

</head>
<body>

<%
    Locale.setDefault(Locale.ENGLISH);
    try {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
    } catch (SQLException e) {
        e.printStackTrace();
    }

    Connection conn = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    try {

        conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.101:1521:xe", "hr", "hr");
        st = conn.prepareStatement("select * from JOBS where JOB_TITLE like ? ");
        st.setString(1, "S%");
        rs = st.executeQuery();
%>
<table border=3>
    <tr>
        <th>JOB ID</th>
        <th>JOB NAME</th>
        <th>Минимальная зарплата</th>
        <th>Максимальная зарплата</th>
    </tr>
    <%
        while (rs.next()) {
    %>
    <tr>
        <td><%=rs.getString("JOB_ID")%></td>
        <td><%=rs.getString(2)%></td>
        <td><%=rs.getInt(3)%></td>
        <td><%=rs.getInt(4)%></td>
    </tr>
    <%
        }
    %>
</table>
<%
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
%>

</body>
</html>
