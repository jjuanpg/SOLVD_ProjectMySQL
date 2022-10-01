package com.solvd.dao;
import com.solvd.exception.DAOException;
import java.util.List;

public interface IDao<T, K>{

    void insert(T t) throws DAOException;
    void update(T t) throws DAOException;
    void delete(T t) throws DAOException;
    List<T> getAll() throws DAOException;
    T getByID(K id) throws DAOException;
}
