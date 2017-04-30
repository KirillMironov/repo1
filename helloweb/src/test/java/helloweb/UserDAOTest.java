package helloweb;

import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertNotNull;

/**
 * Created by kmiro on 30.04.2017.
 */
public class UserDAOTest {
    UserDAO userDAO = new UserDAO();
    @Test
    public void findByLogin() {
        Locale.setDefault(Locale.ENGLISH);
        User user = userDAO.findByLogin("bart");
        assertNotNull(user);
        user = userDAO.findByLogin("lisa");
        assertNotNull(user);
    }
}
