package com.solvd.mybatis.mappers;

import com.solvd.pojos.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrderMapper {

    @Insert("INSERT INTO orders(o_date, product, quantity, department, supplier_id, o_status) VALUES (#{order_date}, #{product}, #{quantity}, #{department_id}, #{supplier_id}, #{order_status})")
    @Options(useGeneratedKeys = true, keyProperty = "o_id")
    void insertOrder(Orders order);

    @Update("UPDATE orders SET o_date = #{order_date}, product = #{product}, quantity = #{quantity}, department = #{department_id}, supplier_id = #{supplier_id}, o_status = #{order_status WHERE o_id = #{id}")
    void updateOrder(Orders order);

    @Delete("DELETE FROM orders WHERE o_id = #{id}")
    void deleteOrder(int id);

    @Select("SELECT * FROM orders WHERE o_id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "o_id"),
            @Result(property = "order_date", column = "o_date"),
            @Result(property = "department_id", column = "department"),
            @Result(property = "order_status", column = "o_status")
    })
    Orders getOrderById(int id);

    @Select("SELECT * FROM orders")
    @Results(value = {
            @Result(property = "id", column = "o_id"),
            @Result(property = "order_date", column = "o_date"),
            @Result(property = "department_id", column = "department"),
            @Result(property = "order_status", column = "o_status")
    })
    List<Orders> getAllOrders();
}