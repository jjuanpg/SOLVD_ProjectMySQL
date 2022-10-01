package com.solvd.services;

import com.solvd.dao.ILicensesDao;
import com.solvd.exception.DAOException;
import com.solvd.pojos.Licenses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LicensesMySQL extends Licenses implements ILicensesDao {

    final String INSERT_FORMAT = "INSERT INTO licenses(license_type, delivery_id) VALUES (?, ?)";
    final String UPDATE_FORMAT = "UPDATE licenses SET license_type = ?, delivery_id = ? WHERE l_id = ?";
    final String DELETE_FORMAT = "DELETE FROM licenses WHERE l_id = ?";
    final String GET_ALL = "SELECT * FROM licenses";
    final String GET_ONE = "SELECT * FROM licenses WHERE l_id = ?";
    private final Connection con;

    public LicensesMySQL(Connection con) {
        this.con = con;
    }


    @Override
    public void insert(Licenses licenses) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(INSERT_FORMAT);
            statement.setString(1, licenses.getLicenseType());
            statement.setInt(2, licenses.getDelivery_id());

            if (statement.executeUpdate() == 0){
                throw new DAOException("CHANGES MAY NOT HAVE BEEN SAVED");
            }
        } catch (SQLException e) {
            throw new DAOException("ERROR IN THE SQL INSERT");
        } finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new DAOException("ERROR IN THE SQL INSERT");
                }
            }
        }
    }

    @Override
    public void update(Licenses licenses) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(UPDATE_FORMAT);
            statement.setString(1, licenses.getLicenseType());
            statement.setInt(2, licenses.getDelivery_id());
            statement.setInt(3, licenses.getId());

            if (statement.executeUpdate() == 0){
                throw new DAOException("CHANGES MAY NOT HAVE BEEN SAVED");
            }
        }catch (SQLException e){
            throw new DAOException("ERROR IN THE SQL UPDATE");
        }finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new DAOException("ERROR IN THE SQL UPDATE");
                }
            }
        }
    }

    @Override
    public void delete(Licenses licenses) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(DELETE_FORMAT);
            statement.setInt(1, licenses.getId());

            if (statement.executeUpdate() == 0){
                throw new DAOException("CHANGES MAY NOT HAVE BEEN SAVED");
            }
        } catch (SQLException e){
            throw new DAOException("ERROR IN THE SQL DELETE");
        }finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new DAOException("ERROR IN THE SQL DELETE");
                }
            }
        }
    }

    private Licenses getLicense(ResultSet rs) throws SQLException {
        Licenses license = new Licenses();
        license.setId(rs.getInt("l_id"));
        license.setLicenseType(rs.getString("license_type"));
        license.setDelivery_id(rs.getInt("delivery_id"));

        return license;
    }

    @Override
    public List<Licenses> getAll() throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Licenses> licenses = new ArrayList<>();
        try {
            statement = con.prepareStatement(GET_ALL);
            rs = statement.executeQuery();

            while(rs.next()){
                licenses.add(getLicense(rs));
            }
        } catch (SQLException e){
            throw new DAOException("ERROR GETTING LICENSE BY ID");
        } finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException("ERROR: THE RESULT SET CANNOT BE CLOSED");
                }
            }
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new DAOException("ERROR IN THE SQL SELECT");
                }
            }
        }
        return licenses;
    }

    @Override
    public Licenses getByID(Integer id) throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        Licenses license;
        try {
            statement = con.prepareStatement(GET_ONE);
            statement.setInt(1, id);
            rs = statement.executeQuery();

            if (rs.next()){
                license = getLicense(rs);
            }else{
                throw new DAOException("ERROR: LICENSE DOES NOT EXIST");
            }
        } catch (SQLException e){
            throw new DAOException("ERROR GETTING LICENSE BY ID");
        } finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException("ERROR: THE RESULT SET CANNOT BE CLOSED");
                }
            }
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new DAOException("ERROR IN THE SQL SELECT");
                }
            }
        }
        return license;
    }
}