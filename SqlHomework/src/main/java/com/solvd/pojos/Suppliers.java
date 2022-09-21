package com.solvd.pojos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Suppliers {

    private static final Logger logger = LogManager.getLogger(Suppliers.class);
    static Scanner sc = new Scanner(System.in);
    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Suppliers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Suppliers create(){
        Suppliers supplier = new Suppliers();
        logger.info("Enter the supplier name");
        supplier.setName(sc.next());
        logger.info("Enter the supplier address");
        Scanner scan1 = new Scanner(System.in);
        String address="";
        address+=scan1.nextLine();
        supplier.setAddress(address);
        logger.info("Enter the supplier phone");
        supplier.setPhone(sc.next());
        logger.info("Enter the supplier email address");
        supplier.setEmail(sc.next());

        return supplier;
    }
}
