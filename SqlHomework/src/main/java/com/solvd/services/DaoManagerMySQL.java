package com.solvd.services;

import com.solvd.dao.IDaoManager;
import com.solvd.pojos.*;

public class DaoManagerMySQL implements IDaoManager {

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

    @Override
    public Branches getBranches() {
        if(branches == null){
            branches = new BranchesMySQL();
        }
        return branches;
    }

    @Override
    public Customers getCustomers() {
        if(customers == null){
            customers = new CustomerMySQL();
        }
        return customers;
    }

    @Override
    public Departments getDepartments() {
        if(departments == null){
            departments = new DepartmentsMySQL();
        }
        return departments;
    }

    @Override
    public Employees getEmployees() {
        if(employees == null){
            employees = new EmployeesMySQL();
        }
        return employees;
    }

    @Override
    public Managers getManagers() {
        if(managers == null){
            managers = new ManagersMySQL();
        }
        return managers;
    }

    @Override
    public Orders getOrders() {
        if(orders == null){
            orders = new OrdersMySQL();
        }
        return orders;
    }

    @Override
    public Products getProducts() {
        if(products == null){
            products = new ProductsMySQL();
        }
        return products;
    }

    @Override
    public Promos getPromos() {
        if(promos == null){
            promos = new PromosMySQL();
        }
        return promos;
    }

    @Override
    public Purchases getPurchases() {
        if(purchases == null){
            purchases = new PurchasesMySQL();
        }
        return purchases;
    }

    @Override
    public Suppliers getSuppliers() {
        if(suppliers == null){
            suppliers = new SuppliersMySQL();
        }
        return suppliers;
    }

    @Override
    public Deliverys getDeliverys() {
        if(delivery == null){
            delivery = new DeliverysMySQL();
        }
        return  delivery;
    }

    @Override
    public Licenses getLicenses() {
        if(licenses == null){
            licenses = new LicensesMySQL();
        }
        return licenses;
    }
}
