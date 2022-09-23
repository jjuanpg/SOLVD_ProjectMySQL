package com.solvd.pojos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.Scanner;

public class Employees {

    private static final Logger logger = LogManager.getLogger(Employees.class);
    static Scanner sc = new Scanner(System.in); //Scanner for numbers
    static Scanner sc1 = new Scanner(System.in); //Scanner for strings

    private int id;
    private String first_name;
    private String last_name;
    private Date dob;
    private String phone;
    private String email;
    private String address;
    private int salary;
    private int dept_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", dob=" + dob +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", dept_id=" + dept_id +
                '}';
    }

    public Employees create(){
        Employees employee = new Employees();
        logger.info("Enter the employee first name");
        String name="";
        name+=sc1.nextLine();
        employee.setFirst_name(name);
        logger.info("Enter the employee last name");
        employee.setLast_name(sc.next());
        logger.info("Enter the employee date of birth");
        employee.setDob(java.sql.Date.valueOf(sc.next())); //Dates must be like this 2022-09-21
        logger.info("Enter the employee phone number");
        employee.setPhone(sc.next());
        logger.info("Enter the employee email address");
        employee.setEmail(sc.next());
        logger.info("Enter the employee address");
        String address="";
        address+=sc1.nextLine();
        employee.setAddress(address);
        logger.info("Enter the employee salary");
        employee.setSalary(sc.nextInt());
        logger.info("Enter the employee dept ID");
        employee.setDept_id(sc.nextInt());

        return employee;
    }
}
