package com.solvd.services;

import com.solvd.connection_pool.DataSource;
import com.solvd.dao.IDepartmentsDao;
import com.solvd.exception.DAOException;
import com.solvd.pojos.Departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentsMySQL extends Departments implements IDepartmentsDao {

    final String INSERT_FORMAT = "INSERT INTO departments(d_name) VALUES (?)";
    final String UPDATE_FORMAT = "UPDATE departments SET d_name = ? WHERE d_id = ?";
    final String DELETE_FORMAT = "DELETE FROM departments WHERE d_id = ?";
    final String GET_ALL = "SELECT * FROM departments";
    final String GET_ONE = "SELECT * FROM departments WHERE d_id = ?";
    private final Connection con;
    {
        try {
            con = DataSource.getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
    public void delete(Departments departments) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(DELETE_FORMAT);
            statement.setInt(1, departments.getId());

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
            throw new DAOException("ERROR GETTING DEPARTMENT BY ID");
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
            throw new DAOException("ERROR GETTING DEPARTMENT BY ID");
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
        return dept;
    }
}