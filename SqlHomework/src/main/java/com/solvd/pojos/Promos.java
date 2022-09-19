package com.solvd.pojos;

import java.sql.Date;

public class Promos {

    private int id;
    private int discount;
    private Date valid_till;
    private int consumptions;
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

    public int getConsumptions() {
        return consumptions;
    }

    public void setConsumptions(int consumptions) {
        this.consumptions = consumptions;
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
                ", consumptions=" + consumptions +
                ", product_id=" + product_id +
                '}';
    }
}
