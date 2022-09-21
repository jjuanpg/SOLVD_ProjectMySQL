package com.solvd.pojos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Departments {

    private static final Logger logger = LogManager.getLogger(Departments.class);
    private int id;
    private String name;

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

    @Override
    public String toString() {
        return "Departments{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    public Departments create(){
        Departments department = new Departments();
        logger.info("Insert the department name");
        Scanner scan = new Scanner(System.in);
        String name="";
        name+=scan.nextLine();
        department.setName(name);

        return department;
    }
}