package com.solvd.pojos;

import com.solvd.exception.DAOException;
import com.solvd.services.DaoManagerMySQL;
import com.solvd.services.PurchasesMySQL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.Scanner;

public class Purchases {

    private static final Logger logger = LogManager.getLogger(Purchases.class);
    static Scanner sc = new Scanner(System.in);
    private int id;
    private Date date;
    private int total_spent;
    private int customer_id;
    private int dept_id;
    private String items;
    private Customers customer;

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

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
                ", dept_id=" + dept_id +
                ", items='" + items + '\'' +
                '}';
    }

    public Purchases create(){
        Purchases purchases = new Purchases();
        logger.info("Enter the purchase date");
        purchases.setDate(java.sql.Date.valueOf(sc.next())); //Dates must be like this 2022-09-21
        logger.info("Enter the total spent");
        purchases.setTotal_spent(sc.nextInt());
        logger.info("Enter the customer ID");
        purchases.setCustomer_id(sc.nextInt());
        logger.info("Enter the department ID");
        purchases.setDept_id(sc.nextInt());
        logger.info("Enter the item");
        purchases.setItems(sc.next());

        return purchases;
    }

    public Purchases getFullDetails(int id, DaoManagerMySQL man) throws DAOException, SQLException {
        Purchases purchases = ((PurchasesMySQL) man.getPurchases()).getByID(id);

        String GET = "SELECT * FROM customers WHERE c_id = ?";
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","root");
        ResultSet rs;
        PreparedStatement statement;
        Customers customer = new Customers();

        statement = con.prepareStatement(GET);
        statement.setInt(1, purchases.getCustomer_id());
        rs = statement.executeQuery();

        rs.next();
        customer.setId(rs.getInt("c_id"));
        customer.setFirst_name(rs.getString("first_name"));
        customer.setLast_name(rs.getString("last_name"));
        customer.setDob(rs.getDate("bod"));
        customer.setPhone(rs.getString("phone"));
        customer.setEmail(rs.getString("email"));
        customer.setAddress(rs.getString("address"));
        purchases.setCustomers(customer);

        con.close();
        return purchases;
    }

    public Customers getCustomers() {
        return customer;
    }

    public void setCustomers(Customers customer) {
        this.customer = customer;
    }
}
