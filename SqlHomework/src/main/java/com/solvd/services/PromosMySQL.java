package com.solvd.services;

import com.solvd.dao.DAO;
import com.solvd.exception.DAOException;
import com.solvd.pojos.Promos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PromosMySQL extends Promos implements DAO<Promos, Integer> {

    final String INSERT_FORMAT = "INSERT INTO promos(discount, valid_till, consumptions, product_id) VALUES (?, ?, ?, ?)";
    final String UPDATE_FORMAT = "UPDATE promos SET discount = ?, valid_till = ?, consumptions = ?, product_id = ? WHERE p_id = ?";
    final String DELETE_FORMAT = "DELETE FROM promos WHERE p_id = ?";
    final String GET_ALL = "SELECT * FROM promos";
    final String GET_ONE = "SELECT * FROM promos WHERE p_id = ?";
    private final Connection con;

    public PromosMySQL(Connection con) {
        this.con = con;
    }

    @Override
    public void insert(Promos promos) throws DAOException {
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(INSERT_FORMAT);
            statement.setInt(1, promos.getDiscount());
            statement.setDate(2, promos.getValid_till());
            statement.setInt(3, promos.getConsumptions());
            statement.setInt(4, promos.getProduct_id());

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
    public void update(Promos promos) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(UPDATE_FORMAT);
            statement.setInt(1, promos.getDiscount());
            statement.setDate(2, promos.getValid_till());
            statement.setInt(3, promos.getConsumptions());
            statement.setInt(4, promos.getProduct_id());
            statement.setInt(5, promos.getId());

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
    public void delete(Promos promos) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(DELETE_FORMAT);
            statement.setInt(1, promos.getId());

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

    private Promos getPromo (ResultSet rs) throws SQLException {
        Promos promo = new Promos();
        promo.setId(rs.getInt("p_id"));
        promo.setDiscount(rs.getInt("discount"));
        promo.setValid_till(rs.getDate("valid_till"));
        promo.setConsumptions(rs.getInt("consumptions"));
        promo.setProduct_id(rs.getInt("product_id"));

        return promo;
    }

    @Override
    public List<Promos> getAll() throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Promos> promos = new ArrayList<>();
        try {
            statement = con.prepareStatement(GET_ALL);
            rs = statement.executeQuery();

            while(rs.next()){
                promos.add(getPromo(rs));
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
        return promos;
    }

    @Override
    public Promos getByID(Integer id) throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        Promos promos;
        try {
            statement = con.prepareStatement(GET_ONE);
            statement.setInt(1, id);
            rs = statement.executeQuery();

            if (rs.next()){
                promos = getPromo(rs);
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
        return promos;
    }
}
