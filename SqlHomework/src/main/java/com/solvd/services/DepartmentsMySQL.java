package com.solvd.services;

import com.solvd.dao.DAO;
import com.solvd.exception.DAOException;
import com.solvd.pojos.Departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentsMySQL extends Departments implements DAO<Departments, Integer> {

    final String INSERT_FORMAT = "INSERT INTO departments(d_name) VALUES (?)";
    final String UPDATE_FORMAT = "UPDATE departments SET d_name = ? WHERE d_id = ?";
    final String DELETE_FORMAT = "DELETE FROM departments WHERE d_id = ?";
    final String GET_ALL = "SELECT * FROM departments";
    final String GET_ONE = "SELECT * FROM departments WHERE d_id = ?";
    private final Connection con;

    public DepartmentsMySQL(Connection con) {
        this.con = con;
    }

    @Override
    public void insert(Departments departments) throws DAOException {
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(INSERT_FORMAT);
            statement.setString(1, departments.getName());

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
    public void update(Departments departments) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(UPDATE_FORMAT);
            statement.setString(1, departments.getName());
            statement.setInt(2, departments.getId());

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
    public void delete(Departments departments) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(DELETE_FORMAT);
            statement.setInt(1, departments.getId());

            if (statement.executeUpdate() == 0){
                throw new DAOException("CHANGES MAY NOT HAVE BEEN SAVED");
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new DAOException("ERROR IN THE SQL DELETE");
        }finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new DAOException("ERROR IN THE SQL DELETE");
                }
            }
        }
    }

    private Departments getDepartment(ResultSet rs) throws SQLException {
        Departments dept = new Departments();
        dept.setId(rs.getInt("d_id"));
        dept.setName(rs.getString("d_name"));

        return dept;
    }

    @Override
    public List<Departments> getAll() throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Departments> dept = new ArrayList<>();
        try {
            statement = con.prepareStatement(GET_ALL);
            rs = statement.executeQuery();

            while(rs.next()){
                dept.add(getDepartment(rs));
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new DAOException("ERROR GETTING DEPARTMENT BY ID");
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
        return dept;
    }

    @Override
    public Departments getByID(Integer id) throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        Departments dept;
        try {
            statement = con.prepareStatement(GET_ONE);
            statement.setInt(1, id);
            rs = statement.executeQuery();

            if (rs.next()){
                dept = getDepartment(rs);
            }else{
                throw new DAOException("ERROR: DEPARTMENT DOES NOT EXIST");
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new DAOException("ERROR GETTING DEPARTMENT BY ID");
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
        return dept;
    }
}