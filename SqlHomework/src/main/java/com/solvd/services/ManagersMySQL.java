package com.solvd.services;

import com.solvd.dao.DAO;
import com.solvd.exception.DAOException;
import com.solvd.pojos.Managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagersMySQL extends Managers implements DAO<Managers, Integer> {

    final String INSERT_FORMAT = "INSERT INTO mangers(first_name, last_name, bod, phone, email, address, salary, dept_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE_FORMAT = "UPDATE managers SET first_name = ?, last_name = ?, bod = ?, phone = ?, email = ?, address = ?, salary = ?, dept_id = ? WHERE m_id = ?";
    final String DELETE_FORMAT = "DELETE FROM managers WHERE m_id = ?";
    final String GET_ALL = "SELECT * FROM managers";
    final String GET_ONE = "SELECT * FROM managers WHERE m_id = ?";
    private final Connection con;

    public ManagersMySQL(Connection con) {
        this.con = con;
    }

    @Override
    public void insert(Managers managers) throws DAOException {
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(INSERT_FORMAT);
            statement.setString(1, managers.getFirst_name());
            statement.setString(2, managers.getLast_name());
            statement.setDate(3, managers.getDob());
            statement.setString(4, managers.getPhone());
            statement.setString(5, managers.getEmail());
            statement.setString(6, managers.getAddress());
            statement.setInt(7, managers.getSalary());
            statement.setInt(8, managers.getDept_id());

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
    public void update(Managers managers) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(UPDATE_FORMAT);
            statement.setString(1, managers.getFirst_name());
            statement.setString(2, managers.getLast_name());
            statement.setDate(3, managers.getDob());
            statement.setString(4, managers.getPhone());
            statement.setString(5, managers.getEmail());
            statement.setString(6, managers.getAddress());
            statement.setInt(7, managers.getSalary());
            statement.setInt(8, managers.getDept_id());
            statement.setInt(9, managers.getId());

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
    public void delete(Managers managers) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(DELETE_FORMAT);
            statement.setInt(1, managers.getId());

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

    private Managers getManagers(ResultSet rs) throws SQLException {
        Managers managers = new Managers();
        managers.setId(rs.getInt("m_id"));
        managers.setFirst_name(rs.getString("first_name"));
        managers.setLast_name(rs.getString("last_name"));
        managers.setDob(rs.getDate("bod"));
        managers.setPhone(rs.getString("phone"));
        managers.setEmail(rs.getString("email"));
        managers.setAddress(rs.getString("address"));
        managers.setSalary(rs.getInt("salary"));
        managers.setDept_id(rs.getInt("dept_id"));

        return managers;
    }

    @Override
    public List<Managers> getAll() throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Managers> managers = new ArrayList<>();
        try {
            statement = con.prepareStatement(GET_ALL);
            rs = statement.executeQuery();

            while(rs.next()){
                managers.add(getManagers(rs));
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
        return managers;
    }

    @Override
    public Managers getByID(Integer id) throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        Managers managers;
        try {
            statement = con.prepareStatement(GET_ONE);
            statement.setInt(1, id);
            rs = statement.executeQuery();

            if (rs.next()){
                managers = getManagers(rs);
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
        return managers;
    }
}