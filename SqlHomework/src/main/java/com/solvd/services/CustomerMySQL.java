package com.solvd.services;

import com.solvd.dao.DAO;
import com.solvd.exception.DAOException;
import com.solvd.pojos.Customers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerMySQL extends Customers implements DAO<Customers, Integer> {

    final String INSERT_FORMAT = "INSERT INTO customers(first_name, last_name, bod, phone, email, address) VALUES (?, ?, ?, ?, ?, ?)";
    final String UPDATE_FORMAT = "UPDATE customers SET first_name = ?, last_name = ?, bod = ?, phone = ?, email = ?, address = ? WHERE c_id = ?";
    final String DELETE_FORMAT = "DELETE FROM customers WHERE c_id = ?";
    final String GET_ALL = "SELECT * FROM customers";
    final String GET_ONE = "SELECT * FROM customers WHERE c_id = ?";
    private final Connection con;

    public CustomerMySQL(Connection con) {
        this.con = con;
    }

    @Override
    public void insert(Customers customers) throws DAOException {
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(INSERT_FORMAT);
            statement.setString(1, customers.getFirst_name());
            statement.setString(2, customers.getLast_name());
            statement.setDate(3, customers.getDob());
            statement.setString(4, customers.getPhone());
            statement.setString(5, customers.getEmail());
            statement.setString(6, customers.getAddress());

            if (statement.executeUpdate() == 0){
                throw new DAOException("CHANGES MAY NOT HAVE BEEN SAVED");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("ERROR IN THE SQL INSERT");
        } finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new DAOException("ERROR IN THE SQL INSERT");
                }
            }
        }
    }

    @Override
    public void update(Customers customers) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(UPDATE_FORMAT);
            statement.setString(1, customers.getFirst_name());
            statement.setString(2, customers.getLast_name());
            statement.setDate(3, customers.getDob());
            statement.setString(4, customers.getPhone());
            statement.setString(5, customers.getEmail());
            statement.setString(6, customers.getAddress());
            statement.setInt(7, customers.getId());

            if (statement.executeUpdate() == 0){
                throw new DAOException("CHANGES MAY NOT HAVE BEEN SAVED");
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new DAOException("ERROR IN THE SQL UPDATE");
        }finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new DAOException("ERROR IN THE SQL UPDATE");
                }
            }
        }
    }

    @Override
    public void delete(Customers customers) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(DELETE_FORMAT);
            statement.setInt(1, customers.getId());

            if (statement.executeUpdate() == 0){
                throw new DAOException("CHANGES MAY NOT HAVE BEEN SAVED");
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new DAOException("ERROR IN THE SQL DELETE");
        }finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new DAOException("ERROR IN THE SQL DELETE");
                }
            }
        }
    }

    private Customers getCustomer(ResultSet rs) throws SQLException {
        Customers client = new Customers();
        client.setId(rs.getInt("c_id"));
        client.setFirst_name(rs.getString("first_name"));
        client.setLast_name(rs.getString("last_name"));
        client.setDob(rs.getDate("bod"));
        client.setPhone(rs.getString("phone"));
        client.setEmail(rs.getString("email"));
        client.setAddress(rs.getString("address"));

        return client;
    }


    @Override
    public List<Customers> getAll() throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Customers> client = new ArrayList<>();
        try {
            statement = con.prepareStatement(GET_ALL);
            rs = statement.executeQuery();

            while(rs.next()){
                client.add(getCustomer(rs));
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new DAOException("ERROR GETTING CUSTOMER BY ID");
        } finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new DAOException("ERROR: THE RESULT SET CANNOT BE CLOSED");
                }
            }
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new DAOException("ERROR IN THE SQL SELECT");
                }
            }
        }
        return client;
    }

    @Override
    public Customers getByID(Integer id) throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        Customers client;
        try {
            statement = con.prepareStatement(GET_ONE);
            statement.setInt(1, id);
            rs = statement.executeQuery();

            if (rs.next()){
                client = getCustomer(rs);
            }else{
                throw new DAOException("ERROR: CLIENT DOES NOT EXIST");
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new DAOException("ERROR GETTING CLIENT BY ID");
        } finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new DAOException("ERROR: THE RESULT SET CANNOT BE CLOSED");
                }
            }
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new DAOException("ERROR IN THE SQL SELECT");
                }
            }
        }
        return client;
    }
}