package com.solvd.services;

import com.solvd.dao.IProductsDao;
import com.solvd.exception.DAOException;
import com.solvd.pojos.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsMySQL extends Products implements IProductsDao {

    final String INSERT_FORMAT = "INSERT INTO products(p_name, quantity, price, create_by, supplier_id) VALUES (?, ?, ?, ?, ?)";
    final String UPDATE_FORMAT = "UPDATE products SET p_name = ?, quantity = ?, price = ?, create_by = ?, supplier_id = ? WHERE prod_id = ?";
    final String DELETE_FORMAT = "DELETE FROM products WHERE prod_id = ?";
    final String GET_ALL = "SELECT * FROM products";
    final String GET_ONE = "SELECT * FROM products WHERE prod_id = ?";
    private final Connection con;

    public ProductsMySQL(Connection con) {
        this.con = con;
    }

    @Override
    public void insert(Products products) throws DAOException {
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(INSERT_FORMAT);
            statement.setString(1, products.getName());
            statement.setInt(2, products.getQuantity());
            statement.setInt(3, products.getPrice());
            statement.setInt(4, products.getCreator_id());
            statement.setInt(5, products.getSupplier_id());

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
    public void update(Products products) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(UPDATE_FORMAT);
            statement.setString(1, products.getName());
            statement.setInt(2, products.getQuantity());
            statement.setInt(3, products.getPrice());
            statement.setInt(4, products.getCreator_id());
            statement.setInt(5, products.getSupplier_id());
            statement.setInt(6, products.getId());

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
    public void delete(Products products) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(DELETE_FORMAT);
            statement.setInt(1, products.getId());

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

    private Products getProduct (ResultSet rs) throws SQLException {
        Products product = new Products();
        product.setId(rs.getInt("prod_id"));
        product.setName(rs.getString("p_name"));
        product.setQuantity(rs.getInt("quantity"));
        product.setPrice(rs.getInt("price"));
        product.setCreator_id(rs.getInt("create_by"));
        product.setSupplier_id(rs.getInt("supplier_id"));

        return product;
    }

    @Override
    public List<Products> getAll() throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Products> products = new ArrayList<>();
        try {
            statement = con.prepareStatement(GET_ALL);
            rs = statement.executeQuery();

            while(rs.next()){
                products.add(getProduct(rs));
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
        return products;
    }

    @Override
    public Products getByID(Integer id) throws DAOException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        Products products;
        try {
            statement = con.prepareStatement(GET_ONE);
            statement.setInt(1, id);
            rs = statement.executeQuery();

            if (rs.next()){
                products = getProduct(rs);
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
        return products;
    }
}