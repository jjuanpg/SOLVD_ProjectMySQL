package com.solvd.pojos;

import java.sql.Date;

public class Purchases {

    private int id;
    private Date date;
    private int total_spent;
    private int customer_id;

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
                '}';
    }
}
