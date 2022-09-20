package com.solvd;

import com.solvd.enums.CrudMenu;
import com.solvd.enums.Tables;
import com.solvd.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

@SuppressWarnings("FieldCanBeLocal")
public class JDBC {

    private static Logger logger = LogManager.getLogger(JDBC.class);
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static void main(String[] args) throws SQLException, DAOException {
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

            //CUSTOMERS TABLE
            if (option == 1){
                do {
                    Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                    logger.info("0) Exit.");
                    option = sc.nextInt();
                    if (option == 1){
                        // code to insert
                    }
                    if (option == 2){
                        // code to update
                    }
                    if (option == 3){
                        // code to delete
                    }
                    if (option == 4){
                        // code to get all
                    }
                    if (option == 5){
                        // code to get by id
                    }
                }while (option != 0);
                option += 99; //this is to prevent the program from closing prematurely
            }

            //EMPLOYEES TABLE
            if (option == 2){
                do {
                    Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                    logger.info("0) Exit.");
                    option = sc.nextInt();
                    if (option == 1){
                        // code to insert
                    }
                    if (option == 2){
                        // code to update
                    }
                    if (option == 3){
                        // code to delete
                    }
                    if (option == 4){
                        // code to get all
                    }
                    if (option == 5){
                        // code to get by id
                    }
                }while (option != 0);
                option += 99;
            }

            //MANAGERS TABLE
            if (option == 3){
                do {
                    Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                    logger.info("0) Exit.");
                    option = sc.nextInt();
                    if (option == 1){
                        // code to insert
                    }
                    if (option == 2){
                        // code to update
                    }
                    if (option == 3){
                        // code to delete
                    }
                    if (option == 4){
                        // code to get all
                    }
                    if (option == 5){
                        // code to get by id
                    }
                }while (option != 0);
                option += 99;
            }

            //DEPARTMENTS TABLE
            if (option == 4){
                do {
                    Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                    logger.info("0) Exit.");
                    option = sc.nextInt();
                    if (option == 1){
                        // code to insert
                    }
                    if (option == 2){
                        // code to update
                    }
                    if (option == 3){
                        // code to delete
                    }
                    if (option == 4){
                        // code to get all
                    }
                    if (option == 5){
                        // code to get by id
                    }
                }while (option != 0);
                option += 99;
            }

            //SUPPLIERS TABLE
            if (option == 5){
                do {
                    Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                    logger.info("0) Exit.");
                    option = sc.nextInt();
                    if (option == 1){
                        // code to insert
                    }
                    if (option == 2){
                        // code to update
                    }
                    if (option == 3){
                        // code to delete
                    }
                    if (option == 4){
                        // code to get all
                    }
                    if (option == 5){
                        // code to get by id
                    }
                }while (option != 0);
                option += 99;
            }

            //PRODUCTS TABLE
            if (option == 6){
                do {
                    Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                    logger.info("0) Exit.");
                    option = sc.nextInt();
                    if (option == 1){
                        // code to insert
                    }
                    if (option == 2){
                        // code to update
                    }
                    if (option == 3){
                        // code to delete
                    }
                    if (option == 4){
                        // code to get all
                    }
                    if (option == 5){
                        // code to get by id
                    }
                }while (option != 0);
                option += 99;
            }

            //PURCHASES TABLE
            if (option == 7){
                do {
                    Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                    logger.info("0) Exit.");
                    option = sc.nextInt();
                    if (option == 1){
                        // code to insert
                    }
                    if (option == 2){
                        // code to update
                    }
                    if (option == 3){
                        // code to delete
                    }
                    if (option == 4){
                        // code to get all
                    }
                    if (option == 5){
                        // code to get by id
                    }
                }while (option != 0);
                option += 99;
            }

            //PROMOS TABLE
            if (option == 8){
                do {
                    Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                    logger.info("0) Exit.");
                    option = sc.nextInt();
                    if (option == 1){
                        // code to insert
                    }
                    if (option == 2){
                        // code to update
                    }
                    if (option == 3){
                        // code to delete
                    }
                    if (option == 4){
                        // code to get all
                    }
                    if (option == 5){
                        // code to get by id
                    }
                }while (option != 0);
                option += 99;
            }

            //ORDERS TABLE
            if (option == 9){
                do {
                    Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                    logger.info("0) Exit.");
                    option = sc.nextInt();
                    if (option == 1){
                        // code to insert
                    }
                    if (option == 2){
                        // code to update
                    }
                    if (option == 3){
                        // code to delete
                    }
                    if (option == 4){
                        // code to get all
                    }
                    if (option == 5){
                        // code to get by id
                    }
                }while (option != 0);
                option += 99;
            }

            //BRANCHES TABLE
            if (option == 10){
                do {
                    Arrays.stream(menu).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
                    logger.info("0) Exit.");
                    option = sc.nextInt();
                    if (option == 1){
                        // code to insert
                    }
                    if (option == 2){
                        // code to update
                    }
                    if (option == 3){
                        // code to delete
                    }
                    if (option == 4){
                        // code to get all
                    }
                    if (option == 5){
                        // code to get by id
                    }
                }while (option != 0);
                option += 99;
            }

        }while (option != 0);
    }
}