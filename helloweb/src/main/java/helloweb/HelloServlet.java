package helloweb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Locale;

/**
 * Created by kmiro on 08.04.2017.
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        //writer.println("Hello,web!");
        test(writer);
        //writer.close();
    }

    public void test(PrintWriter writer) {
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

            writer.println("<html><head>\n" +
                    "        <meta charset=\"UTF-8\">\n" +
                    "        <title>Кодировка HTML-страницы</title>\n" +
                    "    </head><body>");
            writer.println("<table border=3>");
            writer.println("<tr><th>JOB ID</th><th>JOB NAME</th><th>Минимальная зарплата</th><th>Максимальная зарплата</th></tr>");

            while (rs.next()) {
                writer.println("<tr>");
                //writer.println(String.format("%-12s %-32s %8d %8d", rs.getString("JOB_ID"), rs.getString(2), rs.getInt(3), rs.getInt(4)));
                writer.println(String.format("<td>%s</td> <td>%s</td> <td>%d</td> <td>%d</td>", rs.getString("JOB_ID"), rs.getString(2), rs.getInt(3), rs.getInt(4)));
                writer.println("</tr>");
            }

            writer.println("</table>");
            writer.println("</body></html>");

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
    }
}

