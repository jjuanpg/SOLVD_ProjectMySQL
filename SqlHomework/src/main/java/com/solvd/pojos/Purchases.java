package com.solvd.pojos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.Scanner;

public class Purchases {

    private static final Logger logger = LogManager.getLogger(Purchases.class);
    static Scanner sc = new Scanner(System.in);
    private int id;
    private Date date;
    private int total_spent;
    private int customer_id;
    private int dept_id;
    private String items;

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotal_spent() {
        return total_spent;
    }

    public void setTotal_spent(int total_spent) {
        this.total_spent = total_spent;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "Purchases{" +
                "id=" + id +
                ", date=" + date +
                ", total_spent=" + total_spent +
                ", customer_id=" + customer_id +
                ", dept_id=" + dept_id +
                ", items='" + items + '\'' +
                '}';
    }

    public Purchases create(){
        Purchases purchases = new Purchases();
        logger.info("Enter the purchase date");
        purchases.setDate(java.sql.Date.valueOf(sc.next())); //Dates must be like this 2022-09-21
        logger.info("Enter the total spent");
        purchases.setTotal_spent(sc.nextInt());
        logger.info("Enter the customer ID");
        purchases.setCustomer_id(sc.nextInt());
        logger.info("Enter the department ID");
        purchases.setDept_id(sc.nextInt());
        logger.info("Enter the item");
        purchases.setItems(sc.next());

        return purchases;
    }
}
