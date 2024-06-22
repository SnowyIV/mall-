package com.geekaca.spring.dao;

import com.geekaca.spring.domain.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface BrandMapper {

    @Select("select * from tb_brand")
   public List<Brand> selectAll();

    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    public int add(Brand brand);

    @Select("select * from tb_brand where id = #{id}")
    public  Brand selectById(int id);


    @Update("update tb_brand set brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status = #{status} where id = #{id}")
    public int update(Brand brand);

    @Delete("delete from tb_brand where id = #{id}")
    public int deleteById(int id);

    @Select("select * from tb_brand limit #{pageNum},#{pageSize}")
   public List<Brand> findPage(Integer pageNum, Integer pageSize);

    @Select("select * from tb_brand where description like CONCAT ('%', #{description}, '%') ")
    List<Brand> selectPage(@Param("description") String description);
}