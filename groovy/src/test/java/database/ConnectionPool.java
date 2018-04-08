package database;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by kmiro on 24.03.2018.
 */
public class ConnectionPool {
    protected Queue<Connection> free = new LinkedList<>();
    protected List<Connection> open = new LinkedList<>();

    public ConnectionPool(int count) {
        for (int i = 0; i < count; i++) {
            free.offer(new Connection());
        }
    }

    public Connection open() {
        Connection connection = free.poll();
        if (connection == null) {
            throw new IllegalStateException();
        }
        open.add(connection);
        return connection;
    }

    public void close(Connection connection) {
        if (open.remove(connection)) {
            free.offer(connection);
        } else {
            throw new IllegalStateException();
        }
    }

}
