package com.solvd.dao;
import com.solvd.pojos.*;

public interface IDaoManager {

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
    Deliverys getDeliverys();
    Licenses getLicenses();
}
