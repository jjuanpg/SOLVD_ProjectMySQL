package com.solvd.mybatis.mappers;

import com.solvd.mybatis.entities.Customer;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ICustomerMapper {

    void insertBranch();
    void updateBranch();
    void deleteBranch();

    @Select("SELECT * FROM customers WHERE c_id=#{id}")
    @Results(value = {
            @Result(property = "id", column = "c_id"),
            @Result(property="dob", column = "bod"),
    })
    Customer getCustomerById(int id);

    @Select("SELECT * FROM customers")
    @Results(value = {
            @Result(property = "id", column = "c_id"),
            @Result(property="dob", column = "bod"),
    })
    List<Customer> getAllCustomers();
}
