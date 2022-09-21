import com.solvd.connection_pool.BasicConnectionPool;
import com.solvd.connection_pool.ConnectionPool;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class SimpleTest {

        @Test
        public void whenCalledgetConnection_thenCorrect() throws SQLException {
            ConnectionPool connectionPool = BasicConnectionPool.create("jdbc:mysql://localhost:3306/supermarket", "root", "root");
            assertTrue(connectionPool.getConnection().isValid(1));
        }

        @Test
        public void whenCalledReleaseConnection_thenCorrect() throws SQLException {
            ConnectionPool connectionPool = BasicConnectionPool.create("jdbc:mysql://localhost:3306/supermarket", "root", "root");
            assertTrue(connectionPool.releaseConnection(connectionPool.getConnection()));
        }

}
