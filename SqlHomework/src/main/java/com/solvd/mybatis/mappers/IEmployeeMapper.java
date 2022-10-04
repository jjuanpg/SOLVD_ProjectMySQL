package com.solvd.mybatis.mappers;

import com.solvd.pojos.Employees;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IEmployeeMapper {

    @Insert("INSERT INTO employees(first_name, last_name, bod, phone, email, address, salary, dept_id) VALUES (#{first_name}, #{last_name}, #{dob}, #{phone}, #{email}, #{address}, #{salary}, #{dept_id})")
    @Options(useGeneratedKeys = true, keyProperty = "e_id")
    void insertEmployee(Employees employee);

    @Update("UPDATE employees SET first_name = #{first_name}, last_name = #{last_name}, bod = #{dob}, phone = #{phone}, email = #{email}, address = #{address}, salary = #{salary}, dept_id = #{dept_id} WHERE e_id = #{id}")
    void updateEmployee(Employees employee);

    @Delete("DELETE FROM employees WHERE e_id = #{id}")
    void deleteEmployee(int id);

    @Select("SELECT * FROM employees WHERE e_id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "e_id"),
            @Result(property="dob", column = "bod")  //typo in "bod" it should be dob too
    })
    Employees getEmployeeById(int id);

    @Select("SELECT * FROM employees")
    @Results(value = {
            @Result(property = "id", column = "e_id"),
            @Result(property="dob", column = "bod")  //typo in "bod" it should be dob too
    })
    List<Employees> getAllEmployees();
}
