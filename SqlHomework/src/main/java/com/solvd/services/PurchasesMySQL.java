package com.solvd.services;

import com.solvd.dao.DAO;
import com.solvd.exception.DAOException;
import com.solvd.pojos.Purchases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchasesMySQL extends Purchases implements DAO<Purchases, Integer> {

    final String INSERT_FORMAT = "INSERT INTO purchases(p_date, total_spent, costumer_id, dept_id, items) VALUES (?, ?, ?, ?, ?)";
    final String UPDATE_FORMAT = "UPDATE purchases SET p_date = ?, total_spent = ?, costumer_id = ?, dept_id = ?, items = ? WHERE p_id = ?";
    final String DELETE_FORMAT = "DELETE FROM purchases WHERE p_id = ?";
    final String GET_ALL = "SELECT * FROM purchases";
    final String GET_ONE = "SELECT * FROM purchases WHERE p_id = ?";
    private final Connection con;

    public PurchasesMySQL(Connection con) {
        this.con = con;
    }

    @Override
    public void insert(Purchases purchases) throws DAOException {
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(INSERT_FORMAT);
            statement.setDate(1, purchases.getDate());
            statement.setInt(2, purchases.getTotal_spent());
            statement.setInt(3, purchases.getCustomer_id());
            statement.setInt(4, purchases.getDept_id());
            statement.setString(5, purchases.getItems());

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
    public void update(Purchases purchases) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(UPDATE_FORMAT);
            statement.setDate(1, purchases.getDate());
            statement.setInt(2, purchases.getTotal_spent());
            statement.setInt(3, purchases.getCustomer_id());
            statement.setInt(4, purchases.getDept_id());
            statement.setString(5, purchases.getItems());
            statement.setInt(6, purchases.getId());

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
    public void delete(Purchases purchases) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(DELETE_FORMAT);
            statement.setInt(1, purchases.getId());

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

    private Purchases getPurchase (ResultSet rs) throws SQLException {
        Purchases purchases = new Purchases();
        purchases.setId(rs.getInt("p_id"));
        purchases.setDate(rs.getDate("p_date"));
        purchases.setTotal_spent(rs.getInt("total_spent"));
        purchases.setCustomer_id(rs.getInt("customer_id"));
        purchases.setDept_id(rs.getInt("dept_id"));
        purchases.setItems(rs.getString("items"));

        return purchases;
    }

    @Override
    public List<Purchases> getAll() throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Purchases> purchases = new ArrayList<>();
        try {
            statement = con.prepareStatement(GET_ALL);
            rs = statement.executeQuery();

            while(rs.next()){
                purchases.add(getPurchase(rs));
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
        return purchases;
    }

    @Override
    public Purchases getByID(Integer id) throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        Purchases purchases;
        try {
            statement = con.prepareStatement(GET_ONE);
            statement.setInt(1, id);
            rs = statement.executeQuery();

            if (rs.next()){
                purchases = getPurchase(rs);
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
        return purchases;
    }
}