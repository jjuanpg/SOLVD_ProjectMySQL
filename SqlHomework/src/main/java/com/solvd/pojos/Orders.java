package com.solvd.pojos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.Scanner;

public class Orders {

    private static final Logger logger = LogManager.getLogger(Orders.class);
    static Scanner sc = new Scanner(System.in); //Scanner for numbers
    static Scanner sc1 = new Scanner(System.in); //Scanner for strings

    private int id;
    private Date order_date;
    private String product;
    private int quantity;
    private int department_id;
    private int supplier_id;
    private boolean order_status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public boolean isOrder_status() {
        return order_status;
    }

    public void setOrder_status(boolean order_status) {
        this.order_status = order_status;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", order_date=" + order_date +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", department_id=" + department_id +
                ", supplier_id=" + supplier_id +
                ", order_status=" + order_status +
                '}';
    }

    public Orders create(){
        Orders order = new Orders();
        logger.info("Enter the order date");
        order.setOrder_date(java.sql.Date.valueOf(sc.next())); //Dates must be like this 2022-09-21
        logger.info("Enter the product name");
        String name= "";
        name += sc1.nextLine();
        order.setProduct(name);
        logger.info("Enter the order quantity");
        order.setQuantity(sc.nextInt());
        logger.info("Enter the department ID");
        order.setDepartment_id(sc.nextInt());
        logger.info("Enter the supplier ID");
        order.setSupplier_id(sc.nextInt());
        logger.info("Enter the order status");
        order.setOrder_status(sc.nextBoolean());

        return order;
    }
}