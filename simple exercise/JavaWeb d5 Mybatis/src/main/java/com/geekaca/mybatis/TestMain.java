package com.geekaca.mybatis;

import com.geekaca.mybatis.mapper.BrandMapper;
import com.geekaca.mybatis.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        //修改
        int id = 1;
        String companyName = "苹果科技";
        String bdName = "苹果";
        int ordered = 1;
        String description = "苹果新机上市";
        int status = 1;
        Brand brand1 = new Brand(id,companyName,bdName,ordered,description,status);
        update(brand1);
        //删除
        deleteById(7);
        //添加
        add(new Brand(null, "惠普", "惠普科技", 1, "性价比还行", 1));
        //查询
        List<Brand> brands = loadAll();
        brands.forEach(brd -> {
            System.out.println(brd);
        });
    }


    public static void update(Brand brand){
        SqlSession sqlSession = openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.update(brand);
        sqlSession.commit();
    }



    public static void deleteById(int id){
        SqlSession sqlSession = openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
    }

    public static int add(Brand brand) {
        SqlSession sqlSession = openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int add = mapper.addBrand(brand);
        sqlSession.commit();
        return add;
    }

    public static List<Brand> loadAll() {
        SqlSession sqlSession = openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        return mapper.selectAll();
    }

    private static SqlSession openSession() {
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql ，类似于JDBC  Statement
        //true 打开事务的自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }
}
