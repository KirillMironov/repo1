package helloweb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kmiro on 23.04.2017.
 */
public class LoginController extends HttpServlet {
    UserDAO userDAO = new UserDAO();
    Hasher hasher = new Hasher();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("hash");
        User user = userDAO.findByLogin(login);
        String hash = hasher.sha256(user.salt,password);
        String message;
        if (hash.equals(user.hash)) {
            message = "Password is correct.";
        } else {
            message = "Password is not correct.";
        }
        resp.sendRedirect("show-login.jsp?message=" + message + "&login=" + login + "&hash=" + password);
    }
}
