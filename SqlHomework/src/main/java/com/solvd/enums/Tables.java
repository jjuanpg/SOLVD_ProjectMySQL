package com.solvd.enums;

public enum Tables {
    CUSTOMERS("Customers."),
    EMPLOYEES("Employees."),
    MANAGERS("Managers."),
    DEPARTMENTS("Departments."),
    SUPPLIERS("Suppliers."),
    PRODUCTS("Products."),
    PURCHASES("Purchases."),
    PROMOS("Promos."),
    ORDERS("Orders."),
    BRANCHES("Branches.");

    private final String description;
    Tables(String s){
        this.description = s;
    }

    @Override
    public String toString(){
        return description;
    }
}
