package com.solvd.pojos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.Scanner;

public class Customers {

    private static final Logger logger = LogManager.getLogger(Customers.class);
    static Scanner sc = new Scanner(System.in);
    private int id;
    private String first_name;
    private String last_name;
    private Date dob;
    private String phone;
    private String email;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customers[" +
                "id=" + id +
                ", first_name= " + first_name +
                ", last_name= " + last_name +
                ", dob=" + dob +
                ", phone= " + phone +
                ", email= " + email +
                ", address= " + address +
                ']';
    }

    public Customers create(){
        Customers customer = new Customers();
        logger.info("Insert the customer first name");
        Scanner scan = new Scanner(System.in);
        String name="";
        name+=scan.nextLine();
        customer.setFirst_name(name);
        logger.info("Insert the customer last name");
        customer.setLast_name(sc.next());
        logger.info("Insert the customer date of birth");
        customer.setDob(java.sql.Date.valueOf(sc.next())); //Dates must be like this 2022-09-21
        logger.info("Insert the customer phone number");
        customer.setPhone(sc.next());
        logger.info("Insert the customer email address");
        customer.setEmail(sc.next());
        logger.info("Insert the customer address");
        Scanner scan1 = new Scanner(System.in);
        String address="";
        address+=scan1.nextLine();
        customer.setAddress(address);

        return customer;
    }
}
