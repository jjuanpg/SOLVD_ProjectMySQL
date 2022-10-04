package com.solvd.mybatis;

import com.solvd.enums.CrudMenu;
import com.solvd.enums.Tables;
import com.solvd.exception.MismatchInputException;
import com.solvd.mybatis.connection.ConnectionBuilder;
import com.solvd.mybatis.mappers.*;
import com.solvd.pojos.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MyBatis {
    private static final Logger logger = LogManager.getLogger(MyBatis.class);

    public static void main(String[] args) throws MismatchInputException {
        Scanner sc = new Scanner(System.in);
        int option;
        CrudMenu[] menu = CrudMenu.values();

        try(SqlSession session = new ConnectionBuilder().buildConnection()) {
            do {
                Tables[] tables = Tables.values();
                Arrays.stream(tables).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                logger.info("0) Exit.");
                option = sc.nextInt();

                switch (option){

                    //CUSTOMERS TABLE
                    case 1 -> {
                        do {
                            Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                            logger.info("0) Exit.");
                            option = sc.nextInt();

                            switch (option){
                                case 1 -> {
                                    // code to insert
                                    Customers customer = new Customers();
                                    customer = customer.create();

                                    session.getMapper(ICustomerMapper.class).insertCustomer(customer);
                                    logger.info("Record inserted successfully");
                                }
                                case 2 -> {
                                    // code to update
                                    Customers customer = new Customers();
                                    customer = customer.create();
                                    logger.info("Enter the customer ID");
                                    customer.setId(sc.nextInt());

                                    session.getMapper(ICustomerMapper.class).updateCustomer(customer);
                                    logger.info("Record updated successfully");
                                }
                                case 3 -> {
                                    // code to delete
                                    logger.info("Enter the customer ID");
                                    session.getMapper(ICustomerMapper.class).deleteCustomer(sc.nextInt());
                                    logger.info("Record deleted successfully");
                                }
                                case 4 -> {
                                    // code to get all
                                    List<Customers> customers = session.getMapper(ICustomerMapper.class).getAllCustomers();
                                    customers.forEach(logger::info);
                                }
                                case 5 -> {
                                    // code to get by id
                                    logger.info("Enter the customer ID");
                                    logger.info(session.getMapper(ICustomerMapper.class).getCustomerById(sc.nextInt()));
                                }
                            }
                        }while (option != 0);
                        option += 99; //this is to prevent the program from closing prematurely
                    }

                    //EMPLOYEES TABLE
                    case 2 -> {
                        do {
                            Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                            logger.info("0) Exit.");
                            option = sc.nextInt();

                            switch (option){
                                case 1 -> {
                                    // code to insert
                                    Employees employee = new Employees();
                                    employee = employee.create();

                                    session.getMapper(IEmployeeMapper.class).insertEmployee(employee);
                                    logger.info("Record inserted successfully");
                                }
                                case 2 -> {
                                    // code to update
                                    Employees employee = new Employees();
                                    employee = employee.create();
                                    logger.info("Enter the employee ID");
                                    employee.setId(sc.nextInt());

                                    session.getMapper(IEmployeeMapper.class).updateEmployee(employee);
                                    logger.info("Record updated successfully");
                                }
                                case 3 -> {
                                    // code to delete
                                    logger.info("Enter the employee ID");
                                    session.getMapper(IEmployeeMapper.class).deleteEmployee(sc.nextInt());
                                    logger.info("Record deleted successfully");
                                }
                                case 4 -> {
                                    // code to get all
                                    List<Employees> employees = session.getMapper(IEmployeeMapper.class).getAllEmployees();
                                    employees.forEach(logger::info);
                                }
                                case 5 -> {
                                    // code to get by id
                                    logger.info("Enter the employee ID");
                                    logger.info(session.getMapper(IEmployeeMapper.class).getEmployeeById(sc.nextInt()));
                                }
                            }
                        }while (option != 0);
                        option += 99; //this is to prevent the program from closing prematurely
                    }

                    //MANAGERS TABLE
                    case 3 -> {
                        do {
                            Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                            logger.info("0) Exit.");
                            option = sc.nextInt();

                            switch (option){
                                case 1 -> {
                                    // code to insert
                                    Managers manager = new Managers();
                                    manager = manager.create();

                                    session.getMapper(IManagerMapper.class).insertManager(manager);
                                    logger.info("Record inserted successfully");
                                }
                                case 2 -> {
                                    // code to update
                                    Managers manager = new Managers();
                                    manager = manager.create();
                                    logger.info("Enter the manager ID");
                                    manager.setId(sc.nextInt());

                                    session.getMapper(IManagerMapper.class).updateManager(manager);
                                    logger.info("Record updated successfully");
                                }
                                case 3 -> {
                                    // code to delete
                                    logger.info("Enter the manager ID");
                                    session.getMapper(IManagerMapper.class).deleteManager(sc.nextInt());
                                    logger.info("Record deleted successfully");
                                }
                                case 4 -> {
                                    // code to get all
                                    List<Managers> manager = session.getMapper(IManagerMapper.class).getAllManagers();
                                    manager.forEach(logger::info);
                                }
                                case 5 -> {
                                    // code to get by id
                                    logger.info("Enter the manager ID");
                                    logger.info(session.getMapper(IManagerMapper.class).getManagerById(sc.nextInt()));
                                }
                            }
                        }while (option != 0);
                        option += 99; //this is to prevent the program from closing prematurely
                    }

                    //DEPARTMENTS TABLE
                    case 4 -> {
                        do {
                            Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                            logger.info("0) Exit.");
                            option = sc.nextInt();

                            switch (option){
                                case 1 -> {
                                    // code to insert
                                    Departments department = new Departments();
                                    department = department.create();

                                    session.getMapper(IDepartmentMapper.class).insertDepartment(department);
                                    logger.info("Record inserted successfully");
                                }
                                case 2 -> {
                                    // code to update
                                    Departments department = new Departments();
                                    department = department.create();
                                    logger.info("Enter the department ID");
                                    department.setId(sc.nextInt());

                                    session.getMapper(IDepartmentMapper.class).updateDepartment(department);
                                    logger.info("Record updated successfully");
                                }
                                case 3 -> {
                                    // code to delete
                                    logger.info("Enter the department ID");
                                    session.getMapper(IDepartmentMapper.class).deleteDepartment(sc.nextInt());
                                    logger.info("Record deleted successfully");
                                }
                                case 4 -> {
                                    // code to get all
                                    List<Departments> departments = session.getMapper(IDepartmentMapper.class).getAllDepartments();
                                    departments.forEach(logger::info);
                                }
                                case 5 -> {
                                    // code to get by id
                                    logger.info("Enter the department ID");
                                    logger.info(session.getMapper(IDepartmentMapper.class).getDepartmentById(sc.nextInt()));
                                }
                            }
                        }while (option != 0);
                        option += 99; //this is to prevent the program from closing prematurely
                    }

                    //SUPPLIERS TABLE
                    case 5 -> {
                        do {
                            Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                            logger.info("0) Exit.");
                            option = sc.nextInt();

                            switch (option){
                                case 1 -> {
                                    // code to insert
                                    Suppliers supplier = new Suppliers();
                                    supplier = supplier.create();

                                    session.getMapper(ISupplierMapper.class).insertSupplier(supplier);
                                    logger.info("Record inserted successfully");
                                }
                                case 2 -> {
                                    // code to update
                                    Suppliers supplier = new Suppliers();
                                    supplier = supplier.create();
                                    logger.info("Enter the supplier ID");
                                    supplier.setId(sc.nextInt());

                                    session.getMapper(ISupplierMapper.class).updateSupplier(supplier);
                                    logger.info("Record updated successfully");
                                }
                                case 3 -> {
                                    // code to delete
                                    logger.info("Enter the supplier ID");
                                    session.getMapper(ISupplierMapper.class).deleteSupplier(sc.nextInt());
                                    logger.info("Record deleted successfully");
                                }
                                case 4 -> {
                                    // code to get all
                                    List<Suppliers> supplier = session.getMapper(ISupplierMapper.class).getAllSuppliers();
                                    supplier.forEach(logger::info);
                                }
                                case 5 -> {
                                    // code to get by id
                                    logger.info("Enter the supplier ID");
                                    logger.info(session.getMapper(ISupplierMapper.class).getSupplierById(sc.nextInt()));
                                }
                            }
                        }while (option != 0);
                        option += 99; //this is to prevent the program from closing prematurely
                    }

                    //PRODUCTS TABLE
                    case 6 -> {
                        do {
                            Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                            logger.info("0) Exit.");
                            option = sc.nextInt();

                            switch (option){
                                case 1 -> {
                                    // code to insert
                                    Products product = new Products();
                                    product = product.create();

                                    session.getMapper(IProductMapper.class).insertProduct(product);
                                    logger.info("Record inserted successfully");
                                }
                                case 2 -> {
                                    // code to update
                                    Products product = new Products();
                                    product = product.create();
                                    logger.info("Enter the product ID");
                                    product.setId(sc.nextInt());

                                    session.getMapper(IProductMapper.class).updateProduct(product);
                                    logger.info("Record updated successfully");
                                }
                                case 3 -> {
                                    // code to delete
                                    logger.info("Enter the product ID");
                                    session.getMapper(IProductMapper.class).deleteProduct(sc.nextInt());
                                    logger.info("Record deleted successfully");
                                }
                                case 4 -> {
                                    // code to get all
                                    List<Products> products = session.getMapper(IProductMapper.class).getAllProducts();
                                    products.forEach(logger::info);
                                }
                                case 5 -> {
                                    // code to get by id
                                    logger.info("Enter the products ID");
                                    logger.info(session.getMapper(IProductMapper.class).getProductById(sc.nextInt()));
                                }
                            }
                        }while (option != 0);
                        option += 99; //this is to prevent the program from closing prematurely
                    }

                    //PURCHASES TABLE
                    case 7 -> {
                        do {
                            Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                            logger.info("0) Exit.");
                            option = sc.nextInt();

                            switch (option){
                                case 1 -> {
                                    // code to insert
                                    Purchases purchase = new Purchases();
                                    purchase = purchase.create();

                                    session.getMapper(IPurchaseMapper.class).insertPurchase(purchase);
                                    logger.info("Record inserted successfully");
                                }
                                case 2 -> {
                                    // code to update
                                    Purchases purchase = new Purchases();
                                    purchase = purchase.create();
                                    logger.info("Enter the purchase ID");
                                    purchase.setId(sc.nextInt());

                                    session.getMapper(IPurchaseMapper.class).updatePurchase(purchase);
                                    logger.info("Record updated successfully");
                                }
                                case 3 -> {
                                    // code to delete
                                    logger.info("Enter the purchase ID");
                                    session.getMapper(IPurchaseMapper.class).deletePurchase(sc.nextInt());
                                    logger.info("Record deleted successfully");
                                }
                                case 4 -> {
                                    // code to get all
                                    List<Purchases> purchases = session.getMapper(IPurchaseMapper.class).getAllPurchases();
                                    purchases.forEach(logger::info);
                                }
                                case 5 -> {
                                    // code to get by id
                                    logger.info("Enter the purchase ID");
                                    logger.info(session.getMapper(IPurchaseMapper.class).getPurchaseById(sc.nextInt()));
                                }
                            }
                        }while (option != 0);
                        option += 99; //this is to prevent the program from closing prematurely
                    }

                    //PROMOS TABLE
                    case 8 -> {
                        do {
                            Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                            logger.info("0) Exit.");
                            option = sc.nextInt();

                            switch (option){
                                case 1 -> {
                                    // code to insert
                                    Promos promo = new Promos();
                                    promo = promo.create();

                                    session.getMapper(IPromoMapper.class).insertPromo(promo);
                                    logger.info("Record inserted successfully");
                                }
                                case 2 -> {
                                    // code to update
                                    Promos promo = new Promos();
                                    promo = promo.create();
                                    logger.info("Enter the promo ID");
                                    promo.setId(sc.nextInt());

                                    session.getMapper(IPromoMapper.class).updatePromo(promo);
                                    logger.info("Record updated successfully");
                                }
                                case 3 -> {
                                    // code to delete
                                    logger.info("Enter the promo ID");
                                    session.getMapper(IPromoMapper.class).deletePromo(sc.nextInt());
                                    logger.info("Record deleted successfully");
                                }
                                case 4 -> {
                                    // code to get all
                                    List<Promos> promos = session.getMapper(IPromoMapper.class).getAllPromos();
                                    promos.forEach(logger::info);
                                }
                                case 5 -> {
                                    // code to get by id
                                    logger.info("Enter the promo ID");
                                    logger.info(session.getMapper(IPromoMapper.class).getPromoById(sc.nextInt()));
                                }
                            }
                        }while (option != 0);
                        option += 99; //this is to prevent the program from closing prematurely
                    }

                    //ORDERS TABLE
                    case 9 -> {
                        do {
                            Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                            logger.info("0) Exit.");
                            option = sc.nextInt();

                            switch (option){
                                case 1 -> {
                                    // code to insert
                                    Orders order = new Orders();
                                    order = order.create();

                                    session.getMapper(IOrderMapper.class).insertOrder(order);
                                    logger.info("Record inserted successfully");
                                }
                                case 2 -> {
                                    // code to update
                                    Orders order = new Orders();
                                    order = order.create();
                                    logger.info("Enter the order ID");
                                    order.setId(sc.nextInt());

                                    session.getMapper(IOrderMapper.class).updateOrder(order);
                                    logger.info("Record updated successfully");
                                }
                                case 3 -> {
                                    // code to delete
                                    logger.info("Enter the order ID");
                                    session.getMapper(IOrderMapper.class).deleteOrder(sc.nextInt());
                                    logger.info("Record deleted successfully");
                                }
                                case 4 -> {
                                    // code to get all
                                    List<Orders> orders = session.getMapper(IOrderMapper.class).getAllOrders();
                                    orders.forEach(logger::info);
                                }
                                case 5 -> {
                                    // code to get by id
                                    logger.info("Enter the order ID");
                                    logger.info(session.getMapper(IOrderMapper.class).getOrderById(sc.nextInt()));
                                }
                            }
                        }while (option != 0);
                        option += 99; //this is to prevent the program from closing prematurely
                    }

                    //BRANCHES TABLE
                    case 10 -> {
                        do {
                            Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                            logger.info("0) Exit.");
                            option = sc.nextInt();

                            switch (option){
                                case 1 -> {
                                    // code to insert
                                    Branches branch = new Branches();
                                    branch = branch.create();

                                    session.getMapper(IBranchMapper.class).insertBranch(branch);
                                    logger.info("Record inserted successfully");
                                }
                                case 2 -> {
                                    // code to update
                                    Branches branch = new Branches();
                                    branch = branch.create();
                                    logger.info("Enter the branch ID");
                                    branch.setId(sc.nextInt());

                                    session.getMapper(IBranchMapper.class).updateBranch(branch);
                                    logger.info("Record updated successfully");
                                }
                                case 3 -> {
                                    // code to delete
                                    logger.info("Enter the branch ID");
                                    session.getMapper(IBranchMapper.class).deleteBranch(sc.nextInt());
                                    logger.info("Record deleted successfully");
                                }
                                case 4 -> {
                                    // code to get all
                                    List<Branches> branches = session.getMapper(IBranchMapper.class).getAllBranches();
                                    branches.forEach(System.out::println);
                                }
                                case 5 -> {
                                    // code to get by id
                                    logger.info("Enter the branch ID");
                                    logger.info(session.getMapper(IBranchMapper.class).getBranchById(sc.nextInt()));
                                }
                            }
                        }while (option != 0);
                        option += 99; //this is to prevent the program from closing prematurely
                    }

                    //DELIVERYS TABLE
                    case 11 -> {
                        do {
                            Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                            logger.info("0) Exit.");
                            option = sc.nextInt();

                            switch (option){
                                case 1 -> {
                                    // code to insert
                                    Deliverys delivery = new Deliverys();
                                    delivery = delivery.create();

                                    session.getMapper(IDeliveryMapper.class).insertDelivery(delivery);
                                    logger.info("Record inserted successfully");
                                }
                                case 2 -> {
                                    // code to update
                                    Deliverys delivery = new Deliverys();
                                    delivery = delivery.create();
                                    logger.info("Enter the delivery ID");
                                    delivery.setId(sc.nextInt());

                                    session.getMapper(IDeliveryMapper.class).updateDelivery(delivery);
                                    logger.info("Record updated successfully");
                                }
                                case 3 -> {
                                    // code to delete
                                    logger.info("Enter the delivery ID");
                                    session.getMapper(IDeliveryMapper.class).deleteDelivery(sc.nextInt());
                                    logger.info("Record deleted successfully");
                                }
                                case 4 -> {
                                    // code to get all
                                    List<Deliverys> deliverys = session.getMapper(IDeliveryMapper.class).getAllDeliverys();
                                    deliverys.forEach(logger::info);
                                }
                                case 5 -> {
                                    // code to get by id
                                    logger.info("Enter the delivery ID");
                                    logger.info(session.getMapper(IDeliveryMapper.class).getDeliveryById(sc.nextInt()));
                                }
                            }
                        }while (option != 0);
                        option += 99; //this is to prevent the program from closing prematurely
                    }

                    //LICENSES TABLE
                    case 12 -> {
                        do {
                            Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                            logger.info("0) Exit.");
                            option = sc.nextInt();

                            switch (option){
                                case 1 -> {
                                    // code to insert
                                    Licenses license = new Licenses();
                                    license = license.create();

                                    session.getMapper(ILicenseMapper.class).insertLicense(license);
                                    logger.info("Record inserted successfully");
                                }
                                case 2 -> {
                                    // code to update
                                    Licenses license = new Licenses();
                                    license = license.create();
                                    logger.info("Enter the license ID");
                                    license.setId(sc.nextInt());

                                    session.getMapper(ILicenseMapper.class).updateLicense(license);
                                    logger.info("Record updated successfully");
                                }
                                case 3 -> {
                                    // code to delete
                                    logger.info("Enter the license ID");
                                    session.getMapper(ILicenseMapper.class).deleteLicense(sc.nextInt());
                                    logger.info("Record deleted successfully");
                                }
                                case 4 -> {
                                    // code to get all
                                    List<Licenses> licenses = session.getMapper(ILicenseMapper.class).getAllLicenses();
                                    licenses.forEach(logger::info);
                                }
                                case 5 -> {
                                    // code to get by id
                                    logger.info("Enter the license ID");
                                    logger.info(session.getMapper(ILicenseMapper.class).getLicenseById(sc.nextInt()));
                                }
                            }
                        }while (option != 0);
                        option += 99; //this is to prevent the program from closing prematurely
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
}