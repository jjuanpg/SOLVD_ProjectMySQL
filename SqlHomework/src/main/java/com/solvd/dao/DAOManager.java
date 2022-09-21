package com.solvd.dao;
import com.solvd.pojos.*;

public interface DAOManager {

    Branches getBranches();
    Customers getCustomers();
    Departments getDepartments();
    Employees getEmployees();
    Managers getManagers();
    Orders getOrders();
    Products getProducts();
    Promos getPromos();
    Purchases getPurchases();
    Suppliers getSuppliers();
}
