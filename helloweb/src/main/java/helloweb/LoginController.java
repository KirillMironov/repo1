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
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String correctPassword = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3";
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String message;
        if (correctPassword.equals(password)) {
            message = "Password is correct.";
        } else {
            message = "Password is not correct.";
        }
        resp.sendRedirect("show-login.jsp?message=" + message + "&login=" + login + "&password=" + password);
    }
}
