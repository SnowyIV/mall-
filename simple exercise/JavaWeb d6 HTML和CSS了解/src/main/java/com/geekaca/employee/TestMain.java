package com.geekaca.employee;

import com.geekaca.employee.mapper.EmployeeMapper;
import com.geekaca.employee.pojo.Dept;
import com.geekaca.employee.pojo.EmployeeMsg;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {

testSelectFind();
//插入旅游部
//        add(new Dept(50, "旅游部", "大连"));
//
////查询
//        List<Dept> depts = loadAll1();
//        depts.forEach(dept -> {
//            System.out.println(dept);
//        });
//
////插入员工
//        add(new EmployeeMsg(1015, "白龙马", 4, 1008, "2002-01-23", 18000, null, 50));
//
////查询
//        List<EmployeeMsg> emp = loadAll();
//        emp.forEach(emps1 -> {
//            System.out.println(emps1);
//        });
//
////职位为经理的员工薪资-1000
//        update(4);
//        //查询职位是经理的员工
//        List<EmployeeMsg> empMG = selectjobid(4);
//        empMG.forEach(emps2 -> {
//            System.out.println(emps2);
//        });
//
//    }

//
//    //插入部门
//    public static int add(Dept dept1) {
//        SqlSession sqlSession = openSession();
//        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        int add = mapper.addDept(dept1);
//        sqlSession.commit();
//        return add;
//    }
//
//    //查询部门
//    public static List<Dept> loadAll1() {
//        SqlSession sqlSession = openSession();
//        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        return mapper.selectAll1();
//    }
//
//    //插入员工
//    public static int add(EmployeeMsg emps) {
//        SqlSession sqlSession = openSession();
//        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        int add1 = mapper.addEmployeeMsg(emps);
//        sqlSession.commit();
//        return add1;
//    }
//
//    //查询员工
//    public static List<EmployeeMsg> loadAll() {
//        SqlSession sqlSession = openSession();
//        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        return mapper.selectAll();
//    }
//
//    //更新薪资-1000
//    public static void update(int jobid) {
//        SqlSession sqlSession = openSession();
//        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        mapper.update(jobid);
//        sqlSession.commit();
//    }
//
//    //查询职位是经理的员工
//    public static List<EmployeeMsg> selectjobid(int jobid) {
//        SqlSession sqlSession = openSession();
//        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        mapper.selectJobId(jobid);
//        sqlSession.commit();
//        return mapper.selectJobId(jobid);
//
    }

    private static void testSelectFind(){
        SqlSession sqlSession = openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        EmployeeMsg emp = new EmployeeMsg(null,"白",null,null,null,0,null,null);
        mapper.selectFind(emp);
        List<EmployeeMsg> employeeMsgList = mapper.selectFind(emp);
        employeeMsgList.forEach(employeeMsg -> {
            System.out.println(employeeMsg);
        });
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
