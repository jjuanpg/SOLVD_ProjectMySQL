package com.solvd.services;
import com.solvd.dao.DAO;
import com.solvd.exception.DAOException;
import com.solvd.pojos.Branches;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BranchesMySQL extends Branches implements DAO<Branches, Integer> {

    final String INSERT_FORMAT = "INSERT INTO branches(b_name, b_address, manager_id) VALUES (?, ?, ?)";
    final String UPDATE_FORMAT = "UPDATE branches SET b_name = ?, b_address = ?, manager_id = ? WHERE b_id = ?";
    final String DELETE_FORMAT = "DELETE FROM branches WHERE b_id = ?";
    final String GET_ALL = "SELECT * FROM branches";
    final String GET_ONE = "SELECT * FROM branches WHERE b_id = ?";
    private final Connection con;
    public BranchesMySQL(Connection con){
        this.con = con;
    }

    @Override
    public void insert(Branches branches) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(INSERT_FORMAT);
            statement.setString(1, branches.getName());
            statement.setString(2, branches.getAddress());
            statement.setInt(3, branches.getManager_id());

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
    public void update(Branches branches) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(UPDATE_FORMAT);
            statement.setString(1, branches.getName());
            statement.setString(2, branches.getAddress());
            statement.setInt(3, branches.getManager_id());
            statement.setInt(4, branches.getId());

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
    public void delete(Branches branches) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(DELETE_FORMAT);
            statement.setInt(1, branches.getId());

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

    private Branches getBranch(ResultSet rs) throws SQLException {
        Branches branch = new Branches();
        branch.setId(rs.getInt("b_id"));
        branch.setName(rs.getString("b_name"));
        branch.setAddress(rs.getString("b_address"));
        branch.setManager_id(rs.getInt("manager_id"));

        return branch;
    }

    @Override
    public List<Branches> getAll() throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Branches> branch = new ArrayList<>();
        try {
            statement = con.prepareStatement(GET_ALL);
            rs = statement.executeQuery();

            while(rs.next()){
                branch.add(getBranch(rs));
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new DAOException("ERROR GETTING BRANCH BY ID");
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
        return branch;
    }

    @Override
    public Branches getByID(Integer id) throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        Branches branch;
        try {
            statement = con.prepareStatement(GET_ONE);
            statement.setInt(1, id);
            rs = statement.executeQuery();

            if (rs.next()){
                branch = getBranch(rs);
            }else{
                throw new DAOException("ERROR: BRANCH DOES NOT EXIST");
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new DAOException("ERROR GETTING BRANCH BY ID");
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
        return branch;
    }
}