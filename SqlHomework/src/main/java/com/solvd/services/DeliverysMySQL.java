package com.solvd.services;

import com.solvd.dao.DAO;
import com.solvd.exception.DAOException;
import com.solvd.pojos.Deliverys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliverysMySQL extends Deliverys implements DAO<Deliverys, Integer> {

    final String INSERT_FORMAT = "INSERT INTO deliverys(d_name, vehicle, purchase_id, license_id) VALUES (?, ?, ?, ?)";
    final String UPDATE_FORMAT = "UPDATE deliverys SET d_name = ?, vehicle = ?, purchase_id = ?, license_id = ? WHERE d_id = ?";
    final String DELETE_FORMAT = "DELETE FROM deliverys WHERE d_id = ?";
    final String GET_ALL = "SELECT * FROM deliverys";
    final String GET_ONE = "SELECT * FROM deliverys WHERE d_id = ?";

    private final Connection con;

    public DeliverysMySQL(Connection con) {
        this.con = con;
    }

    @Override
    public void insert(Deliverys deliverys) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(INSERT_FORMAT);
            statement.setString(1, deliverys.getName());
            statement.setString(2, deliverys.getVehicle());
            statement.setInt(3, deliverys.getPurchaseID());
            statement.setInt(4, deliverys.getLicenseID());

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
    public void update(Deliverys deliverys) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(UPDATE_FORMAT);
            statement.setString(1, deliverys.getName());
            statement.setString(2, deliverys.getVehicle());
            statement.setInt(3, deliverys.getPurchaseID());
            statement.setInt(4, deliverys.getLicenseID());
            statement.setInt(5, deliverys.getId());

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
    public void delete(Deliverys deliverys) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(DELETE_FORMAT);
            statement.setInt(1, deliverys.getId());

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

    private Deliverys getDelivery(ResultSet rs) throws SQLException {
        Deliverys delivery = new Deliverys();
        delivery.setId(rs.getInt("d_id"));
        delivery.setName(rs.getString("d_name"));
        delivery.setVehicle(rs.getString("vehicle"));
        delivery.setPurchaseID(rs.getInt("purchase_id"));
        delivery.setLicenseID(rs.getInt("license_id"));

        return delivery;
    }

    @Override
    public List<Deliverys> getAll() throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Deliverys> deliverys = new ArrayList<>();
        try {
            statement = con.prepareStatement(GET_ALL);
            rs = statement.executeQuery();

            while(rs.next()){
                deliverys.add(getDelivery(rs));
            }
        } catch (SQLException e){
            throw new DAOException("ERROR GETTING DELIVERY BY ID");
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
        return deliverys;
    }

    @Override
    public Deliverys getByID(Integer id) throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        Deliverys delivery;
        try {
            statement = con.prepareStatement(GET_ONE);
            statement.setInt(1, id);
            rs = statement.executeQuery();

            if (rs.next()){
                delivery = getDelivery(rs);
            }else{
                throw new DAOException("ERROR: DELIVERY DOES NOT EXIST");
            }
        } catch (SQLException e){
            throw new DAOException("ERROR GETTING DELIVERY BY ID");
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
                    e.printStackTrace();
                    throw new DAOException("ERROR IN THE SQL SELECT");
                }
            }
        }
        return delivery;
    }
}