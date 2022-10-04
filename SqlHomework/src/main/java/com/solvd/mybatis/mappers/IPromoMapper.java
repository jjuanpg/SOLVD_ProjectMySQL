package com.solvd.mybatis.mappers;

import com.solvd.pojos.Promos;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IPromoMapper {

    @Insert("INSERT INTO promos(discount, valid_till, product_id) VALUES (#{discount}, #{valid_till}, #{product_id})")
    @Options(useGeneratedKeys = true, keyProperty = "p_id")
    void insertPromo(Promos promo);

    @Update("UPDATE promos SET discount = #{discount}, valid_till = #{valid_till}, product_id = #{product_id WHERE p_id = #{id}")
    void updatePromo(Promos promo);

    @Delete("DELETE FROM promos WHERE p_id = #{id}")
    void deletePromo(int id);

    @Select("SELECT * FROM promos WHERE p_id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "p_id")
    })
    Promos getPromoById(int id);

    @Select("SELECT * FROM promos")
    @Results(value = {
            @Result(property = "id", column = "p_id")
    })
    List<Promos> getAllPromos();
}
