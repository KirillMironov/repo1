package helloweb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by kmiro on 23.04.2017.
 */
public class LoginController extends HttpServlet {
    UserDAO userDAO = new UserDAO();
    Hasher hasher = new Hasher();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Locale.setDefault(Locale.ENGLISH);
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = userDAO.findByLogin(login);
        String message;
        String hash = "?";

        if (user == null) {
            message = "User not found.";
        } else {
            hash = hasher.sha256(user.salt, password);
            if (hash.equals(user.hash)) {
                message = "Password is correct.";
            } else {
                message = "Password is not correct.";
            }
        }

        resp.sendRedirect("show-login.jsp?message=" + message + "&login=" + login + "&hash=" + hash);
    }
}
