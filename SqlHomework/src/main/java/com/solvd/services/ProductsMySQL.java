package com.solvd.services;
import com.solvd.dao.DAO;
import com.solvd.pojos.Products;
import java.util.List;

public class ProductsMySQL extends Products implements DAO<Products, Integer> {
    @Override
    public void insert(Products products) {

    }

    @Override
    public void update(Products products) {

    }

    @Override
    public void delete(Products products) {

    }

    @Override
    public List<Products> getAll() {
        return null;
    }

    @Override
    public Products getByID(Integer id) {
        return null;
    }
}
