package com.solvd.mybatis.mappers;

import com.solvd.pojos.Branches;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IBranchMapper {

    @Insert("INSERT INTO branches (b_name, b_address, manager_id) VALUES(#{name}, #{address}, #{managerId})")
    @Options(useGeneratedKeys = true, keyProperty = "b_id")
    void insertBranch(Branches branch);

    @Update("UPDATE branches SET b_name = #{name}, b_address = #{address}, manager_id = #{managerId} WHERE b_id = #{id}")
    void updateBranch(Branches branch);

    @Delete("DELETE FROM branches WHERE b_id = #{id}")
    void deleteBranch(int id);

    @Select("SELECT * FROM branches WHERE b_id=#{id}")
    @Results(value = {
            @Result(property = "id", column = "b_id"),
            @Result(property = "name", column = "b_name"),
            @Result(property = "address", column = "b_address")
    })
    Branches getBranchById(int id);

    @Select("SELECT * FROM branches")
    @Results(value = {
            @Result(property = "id", column = "b_id"),
            @Result(property="name", column = "b_name"),
            @Result(property = "address", column = "b_address")
    })
    List<Branches> getAllBranches();
}
