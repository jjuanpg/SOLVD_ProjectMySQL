package com.solvd.pojos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Branches {

    private static final Logger logger = LogManager.getLogger(Branches.class);
    static Scanner sc = new Scanner(System.in); //Scanner for numbers
    static Scanner sc1 = new Scanner(System.in); //Scanner for strings
    private int id;
    private String name;
    private String address;
    private int manager_id;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    @Override
    public String toString() {
        return "Branches{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", manager_id=" + manager_id +
                '}';
    }

    public Branches create(){
        Branches branch = new Branches();
        logger.info("Enter the branch name");
        String name="";
        name+=sc1.nextLine();
        branch.setName(name);
        logger.info("Enter the branch address");
        String address="";
        address+=sc1.nextLine();
        branch.setAddress(address);
        logger.info("Enter the manager ID of the branch");
        branch.setManager_id(sc.nextInt());

        return branch;
    }
}