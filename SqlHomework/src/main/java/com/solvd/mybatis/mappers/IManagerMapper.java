package com.solvd.mybatis.mappers;

import com.solvd.pojos.Managers;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IManagerMapper {

    @Insert("INSERT INTO managers(first_name, last_name, bod, phone, email, address, salary, dept_id) VALUES (#{first_name}, #{last_name}, #{dob}, #{phone}, #{email}, #{address}, #{salary}, #{dept_id})")
    @Options(useGeneratedKeys = true, keyProperty = "m_id")
    void insertManager(Managers manager);

    @Update("UPDATE managers SET first_name = #{first_name}, last_name = #{last_name}, bod = #{dob}, phone = #{phone}, email = #{email}, address = #{address}, salary = #{salary}, dept_id = #{dept_id} WHERE m_id = #{id}")
    void updateManager(Managers manager);

    @Delete("DELETE FROM managers WHERE m_id = #{id}")
    void deleteManager(int id);

    @Select("SELECT * FROM managers WHERE m_id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "m_id"),
            @Result(property="dob", column = "bod")  //typo in "bod" it should be dob too
    })
    Managers getManagerById(int id);

    @Select("SELECT * FROM managers")
    @Results(value = {
            @Result(property = "id", column = "m_id"),
            @Result(property="dob", column = "bod")
    })
    List<Managers> getAllManagers();
}
