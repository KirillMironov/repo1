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

        Connection connection1 = pool.open();
        Connection connection2 = pool.open();
        Connection connection3 = pool.open();

        //Method under test
        pool.close(connection1);

        //Verify
        assertEquals(2, pool.free.size());
        assertEquals(2, pool.open.size());

    }

    @Test(expected = IllegalStateException.class)
    public void closeThrowsException() {
        Connection connection = new Connection();
        pool.close(connection);
    }

}
