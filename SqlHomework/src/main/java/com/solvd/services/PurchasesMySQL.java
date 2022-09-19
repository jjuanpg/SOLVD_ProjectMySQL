package com.solvd.services;
import com.solvd.dao.DAO;
import com.solvd.pojos.Purchases;
import java.util.List;

public class PurchasesMySQL extends Purchases implements DAO<Purchases, Integer> {
    @Override
    public void insert(Purchases purchases) {

    }

    @Override
    public void update(Purchases purchases) {

    }

    @Override
    public void delete(Purchases purchases) {

    }

    @Override
    public List<Purchases> getAll() {
        return null;
    }

    @Override
    public Purchases getByID(Integer id) {
        return null;
    }
}
