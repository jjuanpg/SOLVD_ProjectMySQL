package com.solvd.services;
import com.solvd.dao.DAO;
import com.solvd.pojos.Promos;
import java.util.List;

public class PromosMySQL extends Promos implements DAO<Promos, Integer> {
    @Override
    public void insert(Promos promos) {

    }

    @Override
    public void update(Promos promos) {

    }

    @Override
    public void delete(Promos promos) {

    }

    @Override
    public List<Promos> getAll() {
        return null;
    }

    @Override
    public Promos getByID(Integer id) {
        return null;
    }
}
