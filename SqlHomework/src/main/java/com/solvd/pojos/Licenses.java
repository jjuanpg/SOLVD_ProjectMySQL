package com.solvd.pojos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Licenses {

    private static final Logger logger = LogManager.getLogger(Licenses.class);
    static Scanner sc = new Scanner(System.in); //Scanner for numbers
    static Scanner sc1 = new Scanner(System.in); //Scanner for strings
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
        return "Licenses{" +
                "id=" + id +
                ", licenseType='" + licenseType + '\'' +
                ", delivery_id=" + delivery_id +
                '}';
    }

    public Licenses create(){
        Licenses license = new Licenses();
        logger.info("Enter the license ID");
        license.setId(sc.nextInt());
        logger.info("Enter the license type"); //i.e. Car, Bike.
        license.setLicenseType(sc1.nextLine());
        logger.info("Enter the delivery ID");
        license.setDelivery_id(sc.nextInt());

        return license;
    }
}
