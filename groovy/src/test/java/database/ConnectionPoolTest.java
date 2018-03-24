package database;

import org.junit.Test;

/**
 * Created by kmiro on 24.03.2018.
 */
public class ConnectionPoolTest {
    ConnectionPool pool = new ConnectionPool(4);

    @Test
    public void opensConnection() {


    }

    @Test(expected = IllegalStateException.class)
    public void openThrowsException() {


    }

    @Test
    public void closesConnection() {


    }

    @Test(expected = IllegalStateException.class)
    public void closeThrowsException() {


    }

}
