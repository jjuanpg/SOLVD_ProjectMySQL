package com.solvd.mybatis.mappers;

import com.solvd.pojos.Licenses;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ILicenseMapper {

    @Insert("INSERT INTO licenses(license_type, delivery_id) VALUES (#{licenseType}, #{delivery_id})")
    void insertLicense(Licenses license);

    @Update("UPDATE licenses SET license_type = #{licenseType}, delivery_id = #{delivery_id} WHERE l_id = #{id}")
    void updateLicense(Licenses license);

    @Delete("DELETE FROM licenses WHERE l_id = #{id}")
    void deleteLicense(int id);

    @Select("SELECT * FROM licenses WHERE l_id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "l_id"),
            @Result(property = "licenseType", column = "license_type")
    })
    Licenses getLicenseById(int id);

    @Select("SELECT * FROM licenses")
    @Results(value = {
            @Result(property = "id", column = "l_id"),
            @Result(property = "licenseType", column = "license_type")
    })
    List<Licenses> getAllLicenses();
}
