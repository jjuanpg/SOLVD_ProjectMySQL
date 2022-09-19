package com.solvd.services;
import com.solvd.dao.DAO;
import com.solvd.exception.DAOException;
import com.solvd.pojos.Employees;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesMySQL extends Employees implements DAO<Employees, Integer> {

    final String INSERT_FORMAT = "INSERT INTO employees(first_name, last_name, bod, phone, email, address, salary, dept_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    final String UPDATE_FORMAT = "UPDATE employees SET first_name = ?, last_name = ?, bod = ?, phone = ?, email = ?, address = ?, salary = ?, dept_id = ? WHERE e_id = ?";
    final String DELETE_FORMAT = "DELETE FROM employees WHERE e_id = ?";
    final String GET_ALL = "SELECT * FROM employees";
    final String GET_ONE = "SELECT * FROM employees WHERE e_id = ?";
    private final Connection con;

    public EmployeesMySQL(Connection con) {
        this.con = con;
    }

    @Override
    public void insert(Employees employees) throws DAOException {
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(INSERT_FORMAT);
            statement.setString(1, employees.getFirst_name());
            statement.setString(2, employees.getLast_name());
            statement.setDate(3, employees.getDob());
            statement.setString(4, employees.getPhone());
            statement.setString(5, employees.getEmail());
            statement.setString(6, employees.getAddress());
            statement.setInt(7, employees.getSalary());
            statement.setInt(8, employees.getDept_id());

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
    public void update(Employees employees) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(UPDATE_FORMAT);
            statement.setString(1, employees.getFirst_name());
            statement.setString(2, employees.getLast_name());
            statement.setDate(3, employees.getDob());
            statement.setString(4, employees.getPhone());
            statement.setString(5, employees.getEmail());
            statement.setString(6, employees.getAddress());
            statement.setInt(7, employees.getSalary());
            statement.setInt(8, employees.getDept_id());
            statement.setInt(9, employees.getId());

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
    public void delete(Employees employees) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(DELETE_FORMAT);
            statement.setInt(1, employees.getId());

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


    private Employees getEmployee(ResultSet rs) throws SQLException {
        Employees employee = new Employees();
        employee.setId(rs.getInt("e_id"));
        employee.setFirst_name(rs.getString("first_name"));
        employee.setLast_name(rs.getString("last_name"));
        employee.setDob(rs.getDate("bod"));
        employee.setPhone(rs.getString("phone"));
        employee.setEmail(rs.getString("email"));
        employee.setAddress(rs.getString("address"));
        employee.setSalary(rs.getInt("salary"));
        employee.setDept_id(rs.getInt("dept_id"));

        return employee;
    }

    @Override
    public List<Employees> getAll() throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Employees> employees = new ArrayList<>();
        try {
            statement = con.prepareStatement(GET_ALL);
            rs = statement.executeQuery();

            while(rs.next()){
                employees.add(getEmployee(rs));
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
        return employees;
    }

    @Override
    public Employees getByID(Integer id) throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        Employees employees;
        try {
            statement = con.prepareStatement(GET_ONE);
            statement.setInt(1, id);
            rs = statement.executeQuery();

            if (rs.next()){
                employees = getEmployee(rs);
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
        return employees;
    }
}
