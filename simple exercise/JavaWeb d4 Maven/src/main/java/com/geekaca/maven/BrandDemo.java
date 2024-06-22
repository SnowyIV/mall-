package com.geekaca.maven;

import com.geekaca.maven.pojo.Brand;
import com.geekaca.maven.utils.SqlUtil;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class BrandDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(BrandDemo.class);

    /**
     * 增加品牌
     *
     * @param brand 品牌对象
     */
    public int addBrand(Brand brand) {
        LOGGER.info("addBrand===" + brand.toString());
        /**
         * 1, 获取连接
         * 2，构造sql语句
         * 3，发送查询
         * todo: 对品牌名字和公司名字 要判断非空
         */
        String sql = "insert into tb_brand(brand_name, company_name, ordered, description, status) " +
                " values(?, ?, ?, ?, ?)";
        try (Connection conn = SqlUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, brand.getBrandName());
            pstmt.setString(2, brand.getCompanyName());
            pstmt.setInt(3, brand.getOrdered());
            pstmt.setString(4, brand.getDescription());
            pstmt.setInt(5, brand.getStatus());
            int updated = pstmt.executeUpdate();
            return updated;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}

