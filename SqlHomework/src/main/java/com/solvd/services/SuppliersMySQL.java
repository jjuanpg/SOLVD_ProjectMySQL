package com.solvd.services;

import com.solvd.dao.ISuppliersDao;
import com.solvd.exception.DAOException;
import com.solvd.pojos.Suppliers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuppliersMySQL extends Suppliers implements ISuppliersDao {

    final String INSERT_FORMAT = "INSERT INTO suppliers(s_name, s_address, s_phone, s_email) VALUES (?, ?, ?, ?)";
    final String UPDATE_FORMAT = "UPDATE suppliers SET s_name = ?, s_address = ?, s_phone = ?, s_email = ? WHERE p_id = ?";
    final String DELETE_FORMAT = "DELETE FROM suppliers WHERE s_id = ?";
    final String GET_ALL = "SELECT * FROM suppliers";
    final String GET_ONE = "SELECT * FROM suppliers WHERE s_id = ?";
    private final Connection con;

    public SuppliersMySQL(Connection con) {
        this.con = con;
    }

    @Override
    public void insert(Suppliers suppliers) throws DAOException {
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(INSERT_FORMAT);
            statement.setString(1, suppliers.getName());
            statement.setString(2, suppliers.getAddress());
            statement.setString(3, suppliers.getPhone());
            statement.setString(4, suppliers.getEmail());

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
    public void update(Suppliers suppliers) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(UPDATE_FORMAT);
            statement.setString(1, suppliers.getName());
            statement.setString(2, suppliers.getAddress());
            statement.setString(3, suppliers.getPhone());
            statement.setString(4, suppliers.getEmail());
            statement.setInt(5, suppliers.getId());

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
    public void delete(Suppliers suppliers) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(DELETE_FORMAT);
            statement.setInt(1, suppliers.getId());

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

    private Suppliers getSupplier(ResultSet rs) throws SQLException {
        Suppliers suppliers = new Suppliers();
        suppliers.setId(rs.getInt("s_id"));
        suppliers.setName(rs.getString("s_name"));
        suppliers.setAddress(rs.getString("s_address"));
        suppliers.setPhone(rs.getString("s_phone"));
        suppliers.setEmail(rs.getString("s_email"));

        return suppliers;
    }

    @Override
    public List<Suppliers> getAll() throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Suppliers> suppliers = new ArrayList<>();
        try {
            statement = con.prepareStatement(GET_ALL);
            rs = statement.executeQuery();

            while(rs.next()){
                suppliers.add(getSupplier(rs));
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
        return suppliers;
    }

    @Override
    public Suppliers getByID(Integer id) throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        Suppliers suppliers;
        try {
            statement = con.prepareStatement(GET_ONE);
            statement.setInt(1, id);
            rs = statement.executeQuery();

            if (rs.next()){
                suppliers = getSupplier(rs);
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
        return suppliers;
    }
}
