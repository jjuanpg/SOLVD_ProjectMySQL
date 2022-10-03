package com.solvd.mybatis.entities;

public class License {

    private int id;
    private String licenseType;
    private int delivery_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public int getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(int delivery_id) {
        this.delivery_id = delivery_id;
    }

    @Override
    public String toString() {
        return "License{" +
                "id=" + id +
                ", licenseType='" + licenseType + '\'' +
                ", delivery_id=" + delivery_id +
                '}';
    }
}