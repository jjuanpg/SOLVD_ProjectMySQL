package com.solvd.mybatis.mappers;

import com.solvd.pojos.Purchases;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IPurchaseMapper {

    @Insert("INSERT INTO purchases(p_date, total_spent, costumer_id, dept_id, items) VALUES (#{date}, #{total_spent}, #{customer_id}, #{dept_id}, #{items})")
    @Options(useGeneratedKeys = true, keyProperty = "p_id")
    void insertPurchase(Purchases purchase);

    @Update("UPDATE purchases SET p_date = #{date}, total_spent = #{total_spent}, costumer_id = #{customer_id}, dept_id = #{dept_id}, items = #{items} WHERE p_id = #{id}")
    void updatePurchase(Purchases purchase);

    @Delete("DELETE FROM purchases WHERE p_id = #{id}")
    void deletePurchase(int id);

    @Select("SELECT * FROM purchases WHERE p_id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "p_id"),
            @Result(property = "date", column = "p_date")
    })
    Purchases getPurchaseById(int id);

    @Select("SELECT * FROM purchases")
    @Results(value = {
            @Result(property = "id", column = "p_id"),
            @Result(property = "date", column = "p_date")
    })
    List<Purchases> getAllPurchases();
}
