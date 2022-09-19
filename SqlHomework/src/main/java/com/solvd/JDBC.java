package com.solvd;
import com.solvd.enums.Tables;
import com.solvd.exception.DAOException;
import com.solvd.pojos.Branches;
import com.solvd.pojos.Customers;
import com.solvd.services.BranchesMySQL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

@SuppressWarnings("FieldCanBeLocal")
public class JDBC {

    private static Logger logger = LogManager.getLogger(JDBC.class);
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static void main(String[] args) throws SQLException, DAOException {
        Date date = new Date();
        logger = LogManager.getRootLogger();
        logger.debug("---------------" + formatter.format(date) + "---------------");
        int option;

        Scanner sc = new Scanner(System.in);
        do{
            Tables[] tables = Tables.values();
            Arrays.stream(tables).map(v -> (v.ordinal()+1)+") "+ v).forEach(logger::info);
            logger.info("0) Exit.");
            option = sc.nextInt();
            if (option == 1){
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","root");
                Statement statement = connection.createStatement();
                boolean res = statement.execute("SELECT * FROM customers");
                logger.info("CONNECTION RESULT: "+res);
                List<Customers> customers = new ArrayList<>();
                if(res){
                    ResultSet resultSet = statement.getResultSet();
                    while(resultSet.next()) {
                        Customers client = new Customers();
                        client.setId(resultSet.getInt("c_id"));
                        client.setFirst_name(resultSet.getString("first_name"));
                        client.setLast_name(resultSet.getString("last_name"));
                        client.setDob(resultSet.getDate("bod"));
                        client.setPhone(resultSet.getString("phone"));
                        client.setEmail(resultSet.getString("email"));
                        client.setAddress(resultSet.getString("address"));
                        customers.add(client);
                    }
                    connection.close();
                    customers.forEach(logger::info);
                }
            }

            if (option == 2){
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","root");
                Statement statement = connection.createStatement();
                boolean res = statement.execute("INSERT INTO customers (first_name, last_name, bod, phone, email, address) VALUES ('Luis', 'Comunica', '2022-05-14', '3704358426', 'luis@gmail.com', 'Sica 200')");
                logger.info("CONNECTION RESULT: "+res);
                connection.close();
            }

            if (option == 3){
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket","root","root");
                BranchesMySQL branches = new BranchesMySQL(connection);
                List<Branches> branchList = branches.getAll();
                branchList.forEach(logger::info);
            }

        }while (option != 0);
    }
}