package com.solvd.mybatis.mappers;

import com.solvd.pojos.Customers;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ICustomerMapper {

    @Insert("INSERT INTO customers (first_name, last_name, bod, phone, email, address) VALUES(#{first_name}, #{last_name}, #{dob}, #{phone}, #{email}, #{address})")
    @Options(useGeneratedKeys = true, keyProperty = "c_id")
    void insertCustomer(Customers customer);

    @Update("UPDATE customers SET first_name = #{first_name}, last_name = #{last_name}, bod = #{dob}, phone = #{phone}, email = #{email}, address = #{address} WHERE c_id = #{id}")
    void updateCustomer(Customers customer);

    @Delete("DELETE FROM customers WHERE c_id = #{id}")
    void deleteCustomer(int id);

    @Select("SELECT * FROM customers WHERE c_id=#{id}")
    @Results(value = {
            @Result(property = "id", column = "c_id"),
            @Result(property="dob", column = "bod")  //typo in "bod" it should be dob too
    })
    Customers getCustomerById(int id);

    @Select("SELECT * FROM customers")
    @Results(value = {
            @Result(property = "id", column = "c_id"),
            @Result(property="dob", column = "bod")
    })
    List<Customers> getAllCustomers();
}
