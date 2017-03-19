package database;

import expedia.ExpediaTest;
import org.junit.Test;

import java.sql.*;

/**
 * Created by kmiro on 18.03.2017.
 */
public class OracleConnectionTest {
    @Test
    public void test() {
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
            while (rs.next()) {
                System.out.println(String.format("%-12s %-32s %8d %8d", rs.getString("JOB_ID"), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (Exception e) {

        } finally {
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (st!=null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
