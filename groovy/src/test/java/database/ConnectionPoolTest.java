package database;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by kmiro on 24.03.2018.
 */
public class ConnectionPoolTest {
    ConnectionPool pool = new ConnectionPool(4);

    @Test
    public void opensConnection() {
        //Prepare test

        //Method under test
        Connection connection = pool.open();

        //Verify
        assertNotNull(connection);
        assertEquals(3, pool.free.size());
        assertEquals(1, pool.open.size());
    }

    @Test(expected = IllegalStateException.class)
    public void openThrowsException() {
        pool.open();
        pool.open();
        pool.open();
        pool.open();
        assertEquals(0, pool.free.size());
        assertEquals(4, pool.open.size());
        pool.open();
    }

    @Test
    public void closesConnection() {


    }

    @Test(expected = IllegalStateException.class)
    public void closeThrowsException() {


    }

}
