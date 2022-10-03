package com.solvd.connection_pool;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {
    public static final int MAX_POOL_SIZE = 5;
    private static BasicDataSource dataSource;

    public static BasicDataSource getDataSource(){
        if (dataSource == null){
            dataSource = new BasicDataSource();
            dataSource.setUsername("root");
            dataSource.setPassword("root");
            dataSource.setUrl("jdbc:mysql://localhost:3306/supermarket");

            dataSource.setMinIdle(1);
            dataSource.setMaxIdle(MAX_POOL_SIZE);
            dataSource.setMaxTotal(MAX_POOL_SIZE);
            dataSource.setMaxOpenPreparedStatements(200);
            dataSource.setMaxWaitMillis(-1);
        }
        return dataSource;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
