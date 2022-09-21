package com.solvd.pojos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.Scanner;

public class Promos {

    private static final Logger logger = LogManager.getLogger(Promos.class);
    static Scanner sc = new Scanner(System.in);
    private int id;
    private int discount;
    private Date valid_till;
    private int product_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Date getValid_till() {
        return valid_till;
    }

    public void setValid_till(Date valid_till) {
        this.valid_till = valid_till;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return "Promos{" +
                "id=" + id +
                ", discount=" + discount +
                ", valid_till=" + valid_till +
                ", product_id=" + product_id +
                '}';
    }

    public Promos create(){
        Promos promo = new Promos();
        logger.info("Enter the discount amount");
        promo.setDiscount(sc.nextInt());
        logger.info("Enter the expiration date");
        promo.setValid_till(java.sql.Date.valueOf(sc.next())); //Dates must be like this 2022-09-21
        logger.info("Enter the product ID");
        promo.setProduct_id(sc.nextInt());

        return promo;
    }
}
