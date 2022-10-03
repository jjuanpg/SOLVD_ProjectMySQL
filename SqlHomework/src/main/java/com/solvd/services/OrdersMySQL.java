package com.solvd.services;

import com.solvd.connection_pool.DataSource;
import com.solvd.dao.IOrdersDao;
import com.solvd.exception.DAOException;
import com.solvd.pojos.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersMySQL extends Orders implements IOrdersDao {

    final String INSERT_FORMAT = "INSERT INTO orders(o_date, product, quantity, department, supplier_id, o_status) VALUES (?, ?, ?, ?, ?, ?)";
    final String UPDATE_FORMAT = "UPDATE orders SET o_date = ?, product = ?, quantity = ?, department = ?, supplier_id = ?, o_status = ? WHERE o_id = ?";
    final String DELETE_FORMAT = "DELETE FROM orders WHERE o_id = ?";
    final String GET_ALL = "SELECT * FROM orders";
    final String GET_ONE = "SELECT * FROM orders WHERE o_id = ?";
    private final Connection con;
    {
        try {
            con = DataSource.getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Orders orders) throws DAOException {
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(INSERT_FORMAT);
            statement.setDate(1, orders.getOrder_date());
            statement.setString(2, orders.getProduct());
            statement.setInt(3, orders.getQuantity());
            statement.setInt(4, orders.getDepartment_id());
            statement.setInt(5, orders.getSupplier_id());
            statement.setBoolean(6, orders.isOrder_status());

            if (statement.executeUpdate() == 0){
                throw new DAOException("CHANGES MAY NOT HAVE BEEN SAVED");
            }
        } catch (SQLException e) {
            throw new DAOException("ERROR IN THE SQL INSERT");
        } finally {
            try {
                if (statement != null){
                    statement.close();
                }
                if (con != null){
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("ERROR IN THE SQL INSERT");
            }
        }
    }

    @Override
    public void update(Orders orders) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(UPDATE_FORMAT);
            statement.setDate(1, orders.getOrder_date());
            statement.setString(2, orders.getProduct());
            statement.setInt(3, orders.getQuantity());
            statement.setInt(4, orders.getDepartment_id());
            statement.setInt(5, orders.getSupplier_id());
            statement.setBoolean(6, orders.isOrder_status());
            statement.setInt(7, orders.getId());

            if (statement.executeUpdate() == 0){
                throw new DAOException("CHANGES MAY NOT HAVE BEEN SAVED");
            }
        }catch (SQLException e){
            throw new DAOException("ERROR IN THE SQL UPDATE");
        }finally {
            try {
                if (statement != null){
                    statement.close();
                }
                if (con != null){
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("ERROR IN THE SQL UPDATE");
            }
        }
    }

    @Override
    public void delete(Orders orders) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(DELETE_FORMAT);
            statement.setInt(1, orders.getId());

            if (statement.executeUpdate() == 0){
                throw new DAOException("CHANGES MAY NOT HAVE BEEN SAVED");
            }
        } catch (SQLException e){
            throw new DAOException("ERROR IN THE SQL DELETE");
        }finally {
            try {
                if (statement != null){
                    statement.close();
                }
                if (con != null){
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("ERROR IN THE SQL DELETE");
            }
        }
    }

    private Orders getOrders(ResultSet rs) throws SQLException {
        Orders order = new Orders();
        order.setId(rs.getInt("o_id"));
        order.setOrder_date(rs.getDate("o_date"));
        order.setProduct(rs.getString("product"));
        order.setQuantity(rs.getInt("quantity"));
        order.setDepartment_id(rs.getInt("department"));
        order.setSupplier_id(rs.getInt("supplier_id"));
        order.setOrder_status(rs.getBoolean("o_status"));

        return order;
    }

    @Override
    public List<Orders> getAll() throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Orders> orders = new ArrayList<>();
        try {
            statement = con.prepareStatement(GET_ALL);
            rs = statement.executeQuery();

            while(rs.next()){
                orders.add(getOrders(rs));
            }
        } catch (SQLException e){
            throw new DAOException("ERROR GETTING CUSTOMER BY ID");
        } finally {
            try {
                if (statement != null){
                    statement.close();
                }
                if (rs != null){
                    rs.close();
                }
                if (con != null){
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("ERROR IN THE SQL SELECT");
            }
        }
        return orders;
    }

    @Override
    public Orders getByID(Integer id) throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        Orders orders;
        try {
            statement = con.prepareStatement(GET_ONE);
            statement.setInt(1, id);
            rs = statement.executeQuery();

            if (rs.next()){
                orders = getOrders(rs);
            }else{
                throw new DAOException("ERROR: CLIENT DOES NOT EXIST");
            }
        } catch (SQLException e){
            throw new DAOException("ERROR GETTING CLIENT BY ID");
        } finally {
            try {
                if (statement != null){
                    statement.close();
                }
                if (rs != null){
                    rs.close();
                }
                if (con != null){
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("ERROR IN THE SQL SELECT");
            }
        }
        return orders;
    }
}
