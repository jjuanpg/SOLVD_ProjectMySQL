package com.solvd.services;
import com.solvd.dao.DAO;
import com.solvd.pojos.Suppliers;
import java.util.List;

public class SuppliersMySQL extends Suppliers implements DAO<Suppliers, Integer> {
    @Override
    public void insert(Suppliers suppliers) {

    }

    @Override
    public void update(Suppliers suppliers) {

    }

    @Override
    public void delete(Suppliers suppliers) {

    }

    @Override
    public List<Suppliers> getAll() {
        return null;
    }

    @Override
    public Suppliers getByID(Integer id) {
        return null;
    }
}
