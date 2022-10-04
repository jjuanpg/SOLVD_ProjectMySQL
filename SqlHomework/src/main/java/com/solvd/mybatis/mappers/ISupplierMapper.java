package com.solvd.mybatis.mappers;

import com.solvd.pojos.Suppliers;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ISupplierMapper {

    @Insert("INSERT INTO suppliers(s_name, s_address, s_phone, s_email) VALUES (#{name}, #{address}, #{phone}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "s_id")
    void insertSupplier(Suppliers supplier);

    @Update("UPDATE suppliers SET s_name = #{name}, s_address = #{address}, s_phone = #{phone}, s_email = #{email} WHERE p_id = #{id}")
    void updateSupplier(Suppliers supplier);

    @Delete("DELETE FROM suppliers WHERE s_id = #{id}")
    void deleteSupplier(int id);

    @Select("SELECT * FROM suppliers WHERE s_id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "s_id"),
            @Result(property = "name", column = "s_name"),
            @Result(property = "address", column = "s_address"),
            @Result(property = "phone", column = "s_phone"),
            @Result(property = "email", column = "s_email")
    })
    Suppliers getSupplierById(int id);

    @Select("SELECT * FROM suppliers")
    @Results(value = {
            @Result(property = "id", column = "s_id"),
            @Result(property = "name", column = "s_name"),
            @Result(property = "address", column = "s_address"),
            @Result(property = "phone", column = "s_phone"),
            @Result(property = "email", column = "s_email")
    })
    List<Suppliers> getAllSuppliers();
}
