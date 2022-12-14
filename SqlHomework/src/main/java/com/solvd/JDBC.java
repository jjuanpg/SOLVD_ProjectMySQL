package com.solvd;

import com.solvd.enums.CrudMenu;
import com.solvd.enums.Tables;
import com.solvd.exception.DAOException;
import com.solvd.exception.MismatchInputException;
import com.solvd.pojos.*;
import com.solvd.services.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("FieldCanBeLocal")
public class JDBC {

    private static Logger logger = LogManager.getLogger(JDBC.class);
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static void main(String[] args) throws SQLException, DAOException, MismatchInputException {
        Date date = new Date();
        logger = LogManager.getRootLogger();
        logger.debug("---------------" + formatter.format(date) + "---------------");
        int option;

        CrudMenu[] menu = CrudMenu.values();
        Scanner sc = new Scanner(System.in);
        do{
            Tables[] tables = Tables.values();
            Arrays.stream(tables).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
            logger.info("0) Exit.");
            option = sc.nextInt();
            switch (option){
                //CUSTOMERS TABLE
                case 1 ->{
                    do {
                        DaoManagerMySQL man = new DaoManagerMySQL();
                        Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                        logger.info("0) Exit.");
                        option = sc.nextInt();

                        if (option == 1){
                            // code to insert
                            Customers customer = new Customers();
                            customer = customer.create();

                            ((CustomerMySQL) man.getCustomers()).insert(customer);
                            logger.info("Customer inserted!");
                        }
                        if (option == 2){
                            // code to update
                            Customers customer = new Customers();
                            customer = customer.create();
                            logger.info("Insert the customer ID");
                            customer.setId(sc.nextInt());

                            ((CustomerMySQL) man.getCustomers()).update(customer);
                            logger.info("Customer updated!");
                        }
                        if (option == 3){
                            // code to delete
                            Customers customer = new Customers();
                            logger.info("Enter the customer ID");
                            customer.setId(sc.nextInt());

                            ((CustomerMySQL) man.getCustomers()).delete(customer);
                            logger.info("Customer deleted!");
                        }
                        if (option == 4){
                            // code to get all
                            List<Customers> customers = ((CustomerMySQL) man.getCustomers()).getAll();
                            customers.forEach(logger::info);
                        }
                        if (option == 5){
                            // code to get by id
                            logger.info("Enter the customer ID");
                            Customers customer = ((CustomerMySQL) man.getCustomers()).getByID(sc.nextInt());
                            logger.info(customer);
                        }

                    }while (option != 0);
                    option += 99; //this is to prevent the program from closing prematurely
                }
                //EMPLOYEES TABLE
                case 2 ->{
                    do {
                        DaoManagerMySQL man = new DaoManagerMySQL();
                        Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                        logger.info("0) Exit.");
                        option = sc.nextInt();

                        if (option == 1){
                            // code to insert
                            Employees employee = new Employees();
                            employee = employee.create();

                            ((EmployeesMySQL) man.getEmployees()).insert(employee);
                            logger.info("Employee inserted!");
                        }
                        if (option == 2){
                            // code to update
                            Employees employee = new Employees();
                            employee = employee.create();
                            logger.info("Insert the employee ID");
                            employee.setId(sc.nextInt());

                            ((EmployeesMySQL) man.getEmployees()).update(employee);
                            logger.info("Employee updated!");
                        }
                        if (option == 3){
                            // code to delete
                            Employees employee = new Employees();
                            logger.info("Enter the employee ID");
                            employee.setId(sc.nextInt());

                            ((EmployeesMySQL) man.getEmployees()).delete(employee);
                            logger.info("Employee deleted!");
                        }
                        if (option == 4){
                            // code to get all
                            List<Employees> employees = ((EmployeesMySQL) man.getEmployees()).getAll();
                            employees.forEach(logger::info);
                        }
                        if (option == 5){
                            // code to get by id
                            logger.info("Enter the employee ID");
                            Employees employee = ((EmployeesMySQL) man.getEmployees()).getByID(sc.nextInt());
                            logger.info(employee);
                        }

                    }while (option != 0);
                    option += 99;
                }
                //MANAGERS TABLE
                case 3 ->{
                    do {
                        DaoManagerMySQL man = new DaoManagerMySQL();
                        Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                        logger.info("0) Exit.");
                        option = sc.nextInt();

                        if (option == 1){
                            // code to insert
                            Managers manager = new Managers();
                            manager = manager.create();

                            ((ManagersMySQL) man.getManagers()).insert(manager);
                            logger.info("Manager inserted!");
                        }
                        if (option == 2){
                            // code to update
                            Managers manager = new Managers();
                            manager = manager.create();
                            logger.info("Insert the manager ID");
                            manager.setId(sc.nextInt());

                            ((ManagersMySQL) man.getManagers()).update(manager);
                            logger.info("Manager updated!");
                        }
                        if (option == 3){
                            // code to delete
                            Managers manager = new Managers();
                            logger.info("Enter the manager ID");
                            manager.setId(sc.nextInt());

                            ((ManagersMySQL) man.getManagers()).delete(manager);
                            logger.info("Manager deleted!");
                        }
                        if (option == 4){
                            // code to get all
                            List<Managers> managers = ((ManagersMySQL) man.getManagers()).getAll();
                            managers.forEach(logger::info);
                        }
                        if (option == 5){
                            // code to get by id
                            logger.info("Enter the employee ID");
                            Managers manager = ((ManagersMySQL) man.getManagers()).getByID(sc.nextInt());
                            logger.info(manager);
                        }

                    }while (option != 0);
                    option += 99;
                }
                //DEPARTMENTS TABLE
                case 4 ->{
                    do {
                        DaoManagerMySQL man = new DaoManagerMySQL();
                        Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                        logger.info("0) Exit.");
                        option = sc.nextInt();

                        if (option == 1){
                            // code to insert
                            Departments department = new Departments();
                            department = department.create();
                            ((DepartmentsMySQL) man.getDepartments()).insert(department);
                            logger.info("Department inserted!");
                        }
                        if (option == 2){
                            // code to update
                            Departments department = new Departments();
                            department = department.create();
                            logger.info("Insert the department ID");
                            department.setId(sc.nextInt());

                            ((DepartmentsMySQL) man.getDepartments()).update(department);
                            logger.info("Manager updated!");
                        }
                        if (option == 3){
                            // code to delete
                            Departments department = new Departments();
                            logger.info("Enter the department ID");
                            department.setId(sc.nextInt());

                            ((DepartmentsMySQL) man.getDepartments()).delete(department);
                            logger.info("Department deleted!");
                        }
                        if (option == 4){
                            // code to get all
                            List<Departments> department = ((DepartmentsMySQL) man.getDepartments()).getAll();
                            department.forEach(logger::info);
                        }
                        if (option == 5){
                            // code to get by id
                            logger.info("Enter the department ID");
                            Departments department = ((DepartmentsMySQL) man.getDepartments()).getByID(sc.nextInt());
                            logger.info(department);
                        }

                    }while (option != 0);
                    option += 99;
                }
                //SUPPLIERS TABLE
                case 5 ->{
                    do {
                        DaoManagerMySQL man = new DaoManagerMySQL();
                        Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                        logger.info("0) Exit.");
                        option = sc.nextInt();

                        if (option == 1){
                            // code to insert
                            Suppliers supplier = new Suppliers();
                            supplier = supplier.create();

                            ((SuppliersMySQL) man.getSuppliers()).insert(supplier);
                            logger.info("Supplier inserted!");
                        }
                        if (option == 2){
                            // code to update
                            Suppliers supplier = new Suppliers();
                            supplier = supplier.create();
                            logger.info("Insert the supplier ID");
                            supplier.setId(sc.nextInt());

                            ((SuppliersMySQL) man.getSuppliers()).update(supplier);
                            logger.info("supplier updated!");
                        }
                        if (option == 3){
                            // code to delete
                            Suppliers supplier = new Suppliers();
                            logger.info("Enter the supplier ID");
                            supplier.setId(sc.nextInt());

                            ((SuppliersMySQL) man.getSuppliers()).delete(supplier);
                            logger.info("Supplier deleted!");
                        }
                        if (option == 4){
                            // code to get all
                            List<Suppliers> suppliers = ((SuppliersMySQL) man.getSuppliers()).getAll();
                            suppliers.forEach(logger::info);
                        }
                        if (option == 5){
                            // code to get by id
                            logger.info("Enter the supplier ID");
                            Suppliers supplier = ((SuppliersMySQL) man.getSuppliers()).getByID(sc.nextInt());
                            logger.info(supplier);
                        }

                    }while (option != 0);
                    option += 99;
                }
                //PRODUCTS TABLE
                case 6 ->{
                    do {
                        DaoManagerMySQL man = new DaoManagerMySQL();
                        Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                        logger.info("0) Exit.");
                        option = sc.nextInt();

                        if (option == 1){
                            // code to insert
                            Products product = new Products();
                            product = product.create();

                            ((ProductsMySQL) man.getProducts()).insert(product);
                            logger.info("Product inserted!");
                        }
                        if (option == 2){
                            // code to update
                            Products product = new Products();
                            product = product.create();
                            logger.info("Insert the product ID");
                            product.setId(sc.nextInt());

                            ((ProductsMySQL) man.getProducts()).update(product);
                            logger.info("Product updated!");
                        }
                        if (option == 3){
                            // code to delete
                            Products product = new Products();
                            logger.info("Enter the product ID");
                            product.setId(sc.nextInt());

                            ((ProductsMySQL) man.getProducts()).delete(product);
                            logger.info("Product deleted!");
                        }
                        if (option == 4){
                            // code to get all
                            List<Products> products = ((ProductsMySQL) man.getProducts()).getAll();
                            products.forEach(logger::info);
                        }
                        if (option == 5){
                            // code to get by id
                            logger.info("Enter the product ID");
                            Products product = ((ProductsMySQL) man.getProducts()).getByID(sc.nextInt());
                            logger.info(product);
                        }

                    }while (option != 0);
                    option += 99;
                }
                //PURCHASES TABLE
                case 7 ->{
                    do {
                        DaoManagerMySQL man = new DaoManagerMySQL();
                        Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                        logger.info("0) Exit.");
                        option = sc.nextInt();

                        if (option == 1){
                            // code to insert
                            Purchases purchases = new Purchases();
                            purchases = purchases.create();

                            ((PurchasesMySQL) man.getPurchases()).insert(purchases);
                            logger.info("Purchases inserted!");
                        }
                        if (option == 2){
                            // code to update
                            Purchases purchases = new Purchases();
                            purchases = purchases.create();
                            logger.info("Insert the purchase ID");
                            purchases.setId(sc.nextInt());

                            ((PurchasesMySQL) man.getPurchases()).update(purchases);
                            logger.info("Purchase updated!");
                        }
                        if (option == 3){
                            // code to delete
                            Purchases purchases = new Purchases();
                            logger.info("Enter the purchase ID");
                            purchases.setId(sc.nextInt());

                            ((PurchasesMySQL) man.getPurchases()).delete(purchases);
                            logger.info("Purchase deleted!");
                        }
                        if (option == 4){
                            // code to get all
                            List<Purchases> purchases = ((PurchasesMySQL) man.getPurchases()).getAll();
                            purchases.forEach(logger::info);
                        }
                        if (option == 5){
                            // code to get by id
                            logger.info("Enter the purchase ID");
                            Purchases purchases = ((PurchasesMySQL) man.getPurchases()).getByID(sc.nextInt());
                            logger.info(purchases);
                        }
                        if(option == 6){
                            // code to get by id with customers
                            Purchases purchases = new Purchases();
                            logger.info("Enter the purchase ID");
                            purchases = purchases.getFullDetails(sc.nextInt(), man);
                            logger.info("\n"+purchases+"\n"+purchases.getCustomers());
                        }

                    }while (option != 0);
                    option += 99;
                }
                //PROMOS TABLE
                case 8 ->{
                    do {
                        DaoManagerMySQL man = new DaoManagerMySQL();
                        Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                        logger.info("0) Exit.");
                        option = sc.nextInt();

                        if (option == 1){
                            // code to insert
                            Promos promo = new Promos();
                            promo = promo.create();

                            ((PromosMySQL) man.getPromos()).insert(promo);
                            logger.info("Promo inserted!");
                        }
                        if (option == 2){
                            // code to update
                            Promos promo = new Promos();
                            promo = promo.create();
                            logger.info("Insert the promo ID");
                            promo.setId(sc.nextInt());

                            ((PromosMySQL) man.getPromos()).update(promo);
                            logger.info("Promo updated!");
                        }
                        if (option == 3){
                            // code to delete
                            Promos promo = new Promos();
                            logger.info("Enter the promo ID");
                            promo.setId(sc.nextInt());

                            ((PromosMySQL) man.getPromos()).delete(promo);
                            logger.info("Promo deleted!");
                        }
                        if (option == 4){
                            // code to get all
                            List<Promos> promo = ((PromosMySQL) man.getPromos()).getAll();
                            promo.forEach(logger::info);
                        }
                        if (option == 5){
                            // code to get by id
                            logger.info("Enter the employee ID");
                            Promos promo = ((PromosMySQL) man.getPromos()).getByID(sc.nextInt());
                            logger.info(promo);
                        }

                    }while (option != 0);
                    option += 99;
                }
                //ORDERS TABLE
                case 9 ->{
                    do {
                        DaoManagerMySQL man = new DaoManagerMySQL();
                        Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                        logger.info("0) Exit.");
                        option = sc.nextInt();

                        if (option == 1){
                            // code to insert
                            Orders order = new Orders();
                            order = order.create();

                            ((OrdersMySQL) man.getOrders()).insert(order);
                            logger.info("Order inserted!");
                        }
                        if (option == 2){
                            // code to update
                            Orders order = new Orders();
                            order = order.create();
                            logger.info("Insert the order ID");
                            order.setId(sc.nextInt());

                            ((OrdersMySQL) man.getOrders()).update(order);
                            logger.info("Order updated!");
                        }
                        if (option == 3){
                            // code to delete
                            Orders order = new Orders();
                            logger.info("Enter the order ID");
                            order.setId(sc.nextInt());

                            ((OrdersMySQL) man.getOrders()).delete(order);
                            logger.info("Order deleted!");
                        }
                        if (option == 4){
                            // code to get all
                            List<Orders> order = ((OrdersMySQL) man.getOrders()).getAll();
                            order.forEach(logger::info);
                        }
                        if (option == 5){
                            // code to get by id
                            logger.info("Enter the order ID");
                            Orders order = ((OrdersMySQL) man.getOrders()).getByID(sc.nextInt());
                            logger.info(order);
                        }

                    }while (option != 0);
                    option += 99;
                }
                //BRANCHES TABLE
                case 10 ->{
                    do {
                        DaoManagerMySQL man = new DaoManagerMySQL();
                        Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                        logger.info("0) Exit.");
                        option = sc.nextInt();

                        switch(option){
                            case 1 ->{
                                // code to insert
                                Branches branch = new Branches();
                                branch = branch.create();

                                ((BranchesMySQL) man.getBranches()).insert(branch);
                                logger.info("Branch inserted!");
                            }
                            case 2 ->{
                                // code to update
                                Branches branch = new Branches();
                                branch = branch.create();
                                logger.info("Insert the branch ID");
                                branch.setId(sc.nextInt());

                                ((BranchesMySQL) man.getBranches()).update(branch);
                                logger.info("Branch updated!");
                            }
                            case 3 ->{
                                // code to delete
                                Branches branch = new Branches();
                                logger.info("Enter the branch ID");
                                branch.setId(sc.nextInt());

                                ((BranchesMySQL) man.getBranches()).delete(branch);
                                logger.info("Branch deleted!");
                            }
                            case 4 ->{
                                // code to get all
                                List<Branches> branches = ((BranchesMySQL) man.getBranches()).getAll();
                                branches.forEach(logger::info);
                            }
                            case 5 ->{
                                // code to get by id
                                logger.info("Enter the branch ID");
                                Branches branch = ((BranchesMySQL) man.getBranches()).getByID(sc.nextInt());
                                logger.info(branch);
                            }
                        }
                    }while (option != 0);
                    option += 99;
                }
                //DELIVERYS TABLE
                case 11 -> {
                    do {
                        DaoManagerMySQL man = new DaoManagerMySQL();
                        Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                        logger.info("0) Exit.");
                        option = sc.nextInt();

                        switch(option){
                            case 1 ->{
                                // code to insert
                                Deliverys delivery = new Deliverys();
                                delivery = delivery.create();

                                ((DeliverysMySQL) man.getDeliverys()).insert(delivery);
                                logger.info("Delivery inserted!");
                            }
                            case 2 ->{
                                // code to update
                                Deliverys delivery = new Deliverys();
                                delivery = delivery.create();
                                logger.info("Insert the delivery ID");
                                delivery.setId(sc.nextInt());

                                ((DeliverysMySQL) man.getDeliverys()).update(delivery);
                                logger.info("Delivery updated!");
                            }
                            case 3 ->{
                                // code to delete
                                Deliverys delivery = new Deliverys();
                                logger.info("Enter the delivery ID");
                                delivery.setId(sc.nextInt());

                                ((DeliverysMySQL) man.getDeliverys()).delete(delivery);
                                logger.info("Delivery deleted!");
                            }
                            case 4 ->{
                                // code to get all
                                List<Deliverys> delivery = ((DeliverysMySQL) man.getDeliverys()).getAll();
                                delivery.forEach(logger::info);
                            }
                            case 5 ->{
                                // code to get by id
                                logger.info("Enter the delivery ID");
                                Deliverys delivery = ((DeliverysMySQL) man.getDeliverys()).getByID(sc.nextInt());
                                logger.info(delivery);
                            }
                        }
                    }while (option != 0);
                    option += 99;
                }
                //LICENSES TABLE
                case 12 -> {
                    do {
                        DaoManagerMySQL man = new DaoManagerMySQL();
                        Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                        logger.info("0) Exit.");
                        option = sc.nextInt();

                        switch(option){
                            case 1 ->{
                                // code to insert
                                Licenses license = new Licenses();
                                license = license.create();

                                ((LicensesMySQL) man.getLicenses()).insert(license);
                                logger.info("License inserted!");
                            }
                            case 2 ->{
                                // code to update
                                Licenses license = new Licenses();
                                license = license.create();
                                logger.info("Insert the license ID");
                                license.setId(sc.nextInt());

                                ((LicensesMySQL) man.getLicenses()).update(license);
                                logger.info("License updated!");
                            }
                            case 3 ->{
                                // code to delete
                                Licenses license = new Licenses();
                                logger.info("Enter the license ID");
                                license.setId(sc.nextInt());

                                ((LicensesMySQL) man.getLicenses()).delete(license);
                                logger.info("License deleted!");
                            }
                            case 4 ->{
                                // code to get all
                                List<Licenses> license = ((LicensesMySQL) man.getLicenses()).getAll();
                                license.forEach(logger::info);
                            }
                            case 5 ->{
                                // code to get by id
                                logger.info("Enter the license ID");
                                Licenses license = ((LicensesMySQL) man.getLicenses()).getByID(sc.nextInt());
                                logger.info(license);
                            }
                        }
                    }while (option !=0);
                    option += 99;
                }
                default -> {
                    if(option != 0){
                        throw new MismatchInputException("ERROR: WRONG INPUT");
                    }
                }
            }
        }while (option != 0);
    }
}