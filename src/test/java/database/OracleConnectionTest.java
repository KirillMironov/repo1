package database;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by kmiro on 18.03.2017.
 */
public class OracleConnectionTest {
    @Test
    public void test() throws Exception {
        //Class.forName("oracle.jdbc.driver.OracleDriver");
        DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.101:1521:xe","hr","hr");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from JOBS");
        while (rs.next()) {
            System.out.println(String.format("%-12s %-32s %8d %8d", rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
        }

    }
}
