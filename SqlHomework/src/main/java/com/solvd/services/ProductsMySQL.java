package com.solvd.services;

import com.solvd.connection_pool.dataSource;
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
    {
        try {
            con = dataSource.getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
    public void delete(Products products) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(DELETE_FORMAT);
            statement.setInt(1, products.getId());

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
            throw new DAOException("ERROR GETTING CUSTOMER BY ID");
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
            throw new DAOException("ERROR GETTING CLIENT BY ID");
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
        return products;
    }
}