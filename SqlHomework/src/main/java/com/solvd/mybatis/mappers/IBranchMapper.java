package com.solvd.mybatis.mappers;

import com.solvd.mybatis.entities.Branch;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IBranchMapper {

    void insertBranch();
    void updateBranch();
    void deleteBranch();
    @Select("SELECT * FROM branches WHERE b_id=#{id}")
    @Results(value = {
            @Result(property = "id", column = "b_id"),
            @Result(property="name", column = "b_name"),
            @Result(property = "address", column = "b_address")
    })
    Branch getBranchById(int id);

    @Select("SELECT * FROM branches")
    @Results(value = {
            @Result(property = "id", column = "b_id"),
            @Result(property="name", column = "b_name"),
            @Result(property = "address", column = "b_address")
    })
    List<Branch> getAllBranches();
}
