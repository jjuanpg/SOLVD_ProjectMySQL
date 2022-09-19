package com.solvd.services;
import com.solvd.dao.DAO;
import com.solvd.pojos.Orders;
import java.util.List;

public class OrdersMySQL extends Orders implements DAO<Orders, Integer> {
    @Override
    public void insert(Orders orders) {

    }

    @Override
    public void update(Orders orders) {

    }

    @Override
    public void delete(Orders orders) {

    }

    @Override
    public List<Orders> getAll() {
        return null;
    }

    @Override
    public Orders getByID(Integer id) {
        return null;
    }
}
