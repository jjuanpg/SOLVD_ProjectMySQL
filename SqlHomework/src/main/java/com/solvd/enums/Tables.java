package com.solvd.enums;

public enum Tables {
    CUSTOMERS("Customers table."),
    EMPLOYEES("Employees table."),
    MANAGERS("Managers table."),
    DEPARTMENTS("Departments table."),
    SUPPLIERS("Suppliers table."),
    PRODUCTS("Products table."),
    PURCHASES("Purchases table."),
    PROMOS("Promos table."),
    ORDERS("Orders table."),
    BRANCHES("Branches table.");

    private final String description;
    Tables(String s){
        this.description = s;
    }

    @Override
    public String toString(){
        return description;
    }
}
