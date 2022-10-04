package com.solvd.mybatis.mappers;

import com.solvd.pojos.Products;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IProductMapper {

    @Insert("INSERT INTO products(p_name, quantity, price, create_by, supplier_id) VALUES (#{name}, #{quantity}, #{price}, #{creator_id}, #{supplier_id})")
    @Options(useGeneratedKeys = true, keyProperty = "prod_id")
    void insertProduct(Products product);

    @Update("UPDATE products SET p_name = #{name}, quantity = #{quantity}, price = #{price}, create_by = #{creator_id}, supplier_id = #{supplier_id} WHERE prod_id = #{id}")
    void updateProduct(Products product);

    @Delete("DELETE FROM products WHERE prod_id = #{id}")
    void deleteProduct(int id);

    @Select("SELECT * FROM products WHERE prod_id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "prod_id"),
            @Result(property = "name", column = "p_name"),
            @Result(property = "creator_id", column = "create_by")
    })
    Products getProductById(int id);

    @Select("SELECT * FROM products")
    @Results(value = {
            @Result(property = "id", column = "prod_id"),
            @Result(property = "name", column = "p_name"),
            @Result(property = "creator_id", column = "create_by")
    })
    List<Products> getAllProducts();
}
