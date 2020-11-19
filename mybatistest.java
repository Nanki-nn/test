package com.itheima.test;

import com.itheima.dao.TestUserDao;
import com.itheima.domain.TestUser;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class mybatistest {
    public static void main(String[] args)throws Exception {
//1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//2.创建 SqlSessionFactory 的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//3.使用构建者创建工厂对象 SqlSessionFactory
        SqlSessionFactory factory = builder.build(in);
//4.使用 SqlSessionFactory 生产 SqlSession 对象
        SqlSession session = factory.openSession();
//5.使用 SqlSession 创建 dao 接口的代理对象
        TestUserDao userDao = session.getMapper(TestUserDao.class);
//6.使用代理对象执行查询所有方法
        List<TestUser> users = userDao.findAll();
        for(TestUser user : users) {
            System.out.println(user);
        }
//7.释放资源
        session.close();
        in.close();
    }

    public static void t(String[] args) throws IOException {
        InputStream in=Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(in);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        TestUserDao userDao = sqlSession.getMapper(TestUserDao.class);
    }
}
