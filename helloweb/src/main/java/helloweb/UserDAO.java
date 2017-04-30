package helloweb;

import java.sql.*;

/**
 * Created by kmiro on 30.04.2017.
 */
public class UserDAO {
    public User findByLogin(String login){
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        User user = null;

        try {

            conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.101:1521:xe", "hr", "hr");
            st = conn.prepareStatement("SELECT * FROM USERS WHERE login = ?");
            st.setString(1, login);
            rs = st.executeQuery();

            if (rs.next()) {
                user = new User();
                user.id = rs.getLong("id");
                user.login = rs.getString("login");
                user.password = rs.getString("password");
                user.salt = rs.getString("salt");
                user.firstName = rs.getString("first_name");
                user.lastName = rs.getString("last_name");
                user.email = rs.getString("email");
            }

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
        return user;
    }
}
