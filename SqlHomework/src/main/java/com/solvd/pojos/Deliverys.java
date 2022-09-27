package com.solvd.pojos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Deliverys {

    private static final Logger logger = LogManager.getLogger(Deliverys.class);
    static Scanner sc = new Scanner(System.in); //Scanner for numbers
    static Scanner sc1 = new Scanner(System.in); //Scanner for strings
    private int id;
    private String name;
    private String vehicle;
    private int purchaseID;
    private int licenseID;

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

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public int getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(int purchaseID) {
        this.purchaseID = purchaseID;
    }

    public int getLicenseID() {
        return licenseID;
    }

    public void setLicenseID(int licenseID) {
        this.licenseID = licenseID;
    }

    @Override
    public String toString() {
        return "Deliverys{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", purchaseID=" + purchaseID +
                ", licenseID=" + licenseID +
                '}';
    }

    public Deliverys create(){
        Deliverys delivery = new Deliverys();
        logger.info("Enter the delivery ID");
        delivery.setId(sc.nextInt());
        logger.info("Enter the delivery name");
        delivery.setName(sc1.nextLine());
        logger.info("Enter the delivery vehicle");
        delivery.setVehicle(sc1.nextLine());
        logger.info("Enter the delivery purchase ID");
        delivery.setPurchaseID(sc.nextInt());
        logger.info("Enter the delivery license ID");
        delivery.setLicenseID(sc.nextInt());

        return delivery;
    }
}
