package com.solvd.connection_pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Multithread implements Runnable, IConnectionPool {

    public boolean isRes() {
        return res;
    }

    public void setRes(boolean res) {
        this.res = res;
    }

    private boolean res;
    private boolean closing;


    @Override
    public void run() {
        Connection connection;
        String[] sql=new String[] {"SELECT * FROM customers", "SELECT * FROM branches",
                                    "SELECT * FROM managers", "SELECT * FROM employees",
                                    "SELECT * FROM orders", "SELECT * FROM promos",
                                    "SELECT * FROM suppliers"};
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            boolean res;
            for(String state : sql){
                res = statement.execute(state);
                if(res){
                    setRes(true);
                    setClosing(releaseConnection(connection));
                }else{
                    setRes(false);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getDataSource().getConnection();
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if (connection.isClosed()){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public String getUrl() {
        return dataSource.getDataSource().getUrl();
    }

    @Override
    public String getUser() {
        return dataSource.getDataSource().getUsername();
    }

    @Override
    public String getPassword() {
        return dataSource.getDataSource().getPassword();
    }

    public boolean isClosing() {
        return closing;
    }

    public void setClosing(boolean closing) {
        this.closing = closing;
    }
}
