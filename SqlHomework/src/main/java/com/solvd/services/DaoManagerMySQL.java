package com.solvd.services;

import com.solvd.dao.IDaoManager;
import com.solvd.pojos.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoManagerMySQL implements IDaoManager {

    private static final Logger logger = LogManager.getLogger(DaoManagerMySQL.class);
    private final Connection con;

    Branches branches = null;
    Customers customers = null;
    Departments departments = null;
    Employees employees = null;
    Managers managers = null;
    Orders orders = null;
    Products products = null;
    Promos promos = null;
    Purchases purchases = null;
    Suppliers suppliers = null;
    Deliverys delivery = null;
    Licenses licenses = null;

    public DaoManagerMySQL(String host,String username, String password, String database) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://"+host+"/"+database, username, password);
    }

    @Override
    public Branches getBranches() {
        if(branches == null){
            branches = new BranchesMySQL(con);
        }
        return branches;
    }

    @Override
    public Customers getCustomers() {
        if(customers == null){
            customers = new CustomerMySQL(con);
        }
        return customers;
    }

    @Override
    public Departments getDepartments() {
        if(departments == null){
            departments = new DepartmentsMySQL(con);
        }
        return departments;
    }

    @Override
    public Employees getEmployees() {
        if(employees == null){
            employees = new EmployeesMySQL(con);
        }
        return employees;
    }

    @Override
    public Managers getManagers() {
        if(managers == null){
            managers = new ManagersMySQL(con);
        }
        return managers;
    }

    @Override
    public Orders getOrders() {
        if(orders == null){
            orders = new OrdersMySQL(con);
        }
        return orders;
    }

    @Override
    public Products getProducts() {
        if(products == null){
            products = new ProductsMySQL(con);
        }
        return products;
    }

    @Override
    public Promos getPromos() {
        if(promos == null){
            promos = new PromosMySQL(con);
        }
        return promos;
    }

    @Override
    public Purchases getPurchases() {
        if(purchases == null){
            purchases = new PurchasesMySQL(con);
        }
        return purchases;
    }

    @Override
    public Suppliers getSuppliers() {
        if(suppliers == null){
            suppliers = new SuppliersMySQL(con);
        }
        return suppliers;
    }

    @Override
    public Deliverys getDeliverys() {
        if(delivery == null){
            delivery = new DeliverysMySQL(con);
        }
        return  delivery;
    }

    @Override
    public Licenses getLicenses() {
        if(licenses == null){
            licenses = new LicensesMySQL(con);
        }
        return licenses;
    }

    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            logger.info("ERROR CLOSING THE CONNECTION");
        }
    }
}
