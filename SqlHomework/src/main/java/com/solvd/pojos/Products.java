package com.solvd.pojos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Products {

    private static final Logger logger = LogManager.getLogger(Products.class);
    static Scanner sc = new Scanner(System.in); //Scanner for numbers
    static Scanner sc1 = new Scanner(System.in); //Scanner for strings

    private int id;
    private String name;
    private int quantity;
    private int price;
    private int creator_id; //must be a manager
    private int supplier_id;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(int creator_id) {
        this.creator_id = creator_id;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", creator_id=" + creator_id +
                ", supplier_id=" + supplier_id +
                '}';
    }

    public Products create(){
        Products product = new Products();
        logger.info("Enter the product name");
        String name = "";
        name += sc1.nextLine();
        product.setName(name);
        logger.info("Enter the order quantity");
        product.setQuantity(sc.nextInt());
        logger.info("Enter the product price");
        product.setPrice(sc.nextInt());
        logger.info("Enter the manager ID");
        product.setCreator_id(sc.nextInt());
        logger.info("Enter the supplier ID");
        product.setSupplier_id(sc.nextInt());

        return product;
    }
}
