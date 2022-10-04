package com.solvd.mybatis.mappers;

import com.solvd.pojos.Deliverys;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IDeliveryMapper {

    @Insert("INSERT INTO deliverys(d_name, vehicle, purchase_id, license_id) VALUES (#{name}, #{vehicle}, #{purchaseID}, #{licenseID})")
    @Options(useGeneratedKeys = true, keyProperty = "d_id")
    void insertDelivery(Deliverys delivery);

    @Update("UPDATE deliverys SET d_name = #{name}, vehicle = #{vehicle}, purchase_id = #{purchaseID}, license_id = #{licenseID} WHERE d_id = #{id}")
    void updateDelivery(Deliverys delivery);

    @Delete("DELETE FROM deliverys WHERE d_id = #{id}")
    void deleteDelivery(int id);

    @Select("SELECT * FROM deliverys WHERE d_id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "d_id"),
            @Result(property = "name", column = "d_name"),
            @Result(property = "purchaseID", column = "purchase_id"),
            @Result(property = "licenseID", column = "license_id")
    })
    Deliverys getDeliveryById(int id);

    @Select("SELECT * FROM deliverys")
    @Results(value = {
            @Result(property = "id", column = "d_id"),
            @Result(property = "name", column = "d_name"),
            @Result(property = "purchaseID", column = "purchase_id"),
            @Result(property = "licenseID", column = "license_id")
    })
    List<Deliverys> getAllDeliverys();
}
