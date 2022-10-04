package com.solvd.mybatis.mappers;

import com.solvd.pojos.Departments;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IDepartmentMapper {

    @Insert("INSERT INTO departments(d_name) VALUES (#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "d_id")
    void insertDepartment(Departments department);

    @Update("UPDATE departments SET d_name = #{name} WHERE d_id = #{id}")
    void updateDepartment(Departments department);

    @Delete("DELETE FROM departments WHERE d_id = #{id}")
    void deleteDepartment(int id);

    @Select("SELECT * FROM departments WHERE d_id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "d_id"),
            @Result(property = "name", column = "d_name")
    })
    Departments getDepartmentById(int id);

    @Select("SELECT * FROM departments")
    @Results(value = {
            @Result(property = "id", column = "d_id"),
            @Result(property = "name", column = "d_name")
    })
    List<Departments> getAllDepartments();
}
