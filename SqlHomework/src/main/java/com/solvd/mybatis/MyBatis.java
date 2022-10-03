package com.solvd.mybatis;

import com.solvd.mybatis.connection.ConnectionBuilder;
import com.solvd.mybatis.entities.Branch;
import com.solvd.mybatis.entities.Customer;
import com.solvd.mybatis.mappers.IBranchMapper;
import com.solvd.mybatis.mappers.ICustomerMapper;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class MyBatis {

    public static void main(String[] args) {
        try(SqlSession session = new ConnectionBuilder().buildConnection()) {
            List<Branch> branches = session.getMapper(IBranchMapper.class).getAllBranches();
            branches.forEach(System.out::println);

            List<Customer> customers = session.getMapper(ICustomerMapper.class).getAllCustomers();
            customers.forEach(System.out::println);
        }
    }
}
