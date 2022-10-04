package com.solvd.mybatis;

import com.solvd.enums.CrudMenu;
import com.solvd.enums.Tables;
import com.solvd.exception.MismatchInputException;
import com.solvd.mybatis.connection.ConnectionBuilder;
import com.solvd.mybatis.mappers.IBranchMapper;
import com.solvd.mybatis.mappers.ICustomerMapper;
import com.solvd.pojos.Branches;
import com.solvd.pojos.Customers;
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

                                }
                                case 2 -> {
                                    // code to update

                                }
                                case 3 -> {
                                    // code to delete

                                }
                                case 4 -> {
                                    // code to get all
                                    List<Customers> customers = session.getMapper(ICustomerMapper.class).getAllCustomers();
                                    customers.forEach(logger::info);
                                }
                                case 5 -> {
                                    // code to get by id

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

                                }
                                case 2 -> {
                                    // code to update

                                }
                                case 3 -> {
                                    // code to delete

                                }
                                case 4 -> {
                                    // code to get all

                                }
                                case 5 -> {
                                    // code to get by id

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

                                }
                                case 2 -> {
                                    // code to update

                                }
                                case 3 -> {
                                    // code to delete

                                }
                                case 4 -> {
                                    // code to get all

                                }
                                case 5 -> {
                                    // code to get by id

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

                                }
                                case 2 -> {
                                    // code to update

                                }
                                case 3 -> {
                                    // code to delete

                                }
                                case 4 -> {
                                    // code to get all

                                }
                                case 5 -> {
                                    // code to get by id

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

                                }
                                case 2 -> {
                                    // code to update

                                }
                                case 3 -> {
                                    // code to delete

                                }
                                case 4 -> {
                                    // code to get all

                                }
                                case 5 -> {
                                    // code to get by id

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

                                }
                                case 2 -> {
                                    // code to update

                                }
                                case 3 -> {
                                    // code to delete

                                }
                                case 4 -> {
                                    // code to get all

                                }
                                case 5 -> {
                                    // code to get by id

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

                                }
                                case 2 -> {
                                    // code to update

                                }
                                case 3 -> {
                                    // code to delete

                                }
                                case 4 -> {
                                    // code to get all

                                }
                                case 5 -> {
                                    // code to get by id

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

                                }
                                case 2 -> {
                                    // code to update

                                }
                                case 3 -> {
                                    // code to delete

                                }
                                case 4 -> {
                                    // code to get all

                                }
                                case 5 -> {
                                    // code to get by id

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

                                }
                                case 2 -> {
                                    // code to update

                                }
                                case 3 -> {
                                    // code to delete

                                }
                                case 4 -> {
                                    // code to get all

                                }
                                case 5 -> {
                                    // code to get by id

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

                                }
                                case 2 -> {
                                    // code to update

                                }
                                case 3 -> {
                                    // code to delete

                                }
                                case 4 -> {
                                    // code to get all

                                }
                                case 5 -> {
                                    // code to get by id

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

                                }
                                case 2 -> {
                                    // code to update

                                }
                                case 3 -> {
                                    // code to delete

                                }
                                case 4 -> {
                                    // code to get all

                                }
                                case 5 -> {
                                    // code to get by id

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