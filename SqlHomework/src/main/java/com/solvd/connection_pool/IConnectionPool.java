package com.solvd.connection_pool;
import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectionPool {

    //Implemented in multithread class and tested in com.solvd.test.java.SimpleTest
    Connection getConnection() throws SQLException;
    boolean releaseConnection(Connection connection);
    String getUrl();
    String getUser();
    String getPassword();
}
