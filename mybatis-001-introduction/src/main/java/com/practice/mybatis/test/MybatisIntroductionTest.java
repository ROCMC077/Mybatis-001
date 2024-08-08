package com.practice.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.InputStream;

public class MybatisIntroductionTest{
    public static void main(String[] args) throws Exception{

        //獲取SqlSessionBuilder對象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //獲取SqlSessionFactory對象
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");//Resources.getResourceAsStream()默認從類的根目錄下查找資源
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        //獲取SqlSession對象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //執行SQL語句
        int count = sqlSession.insert("insertCar"); //返回值是影響資料庫當中的數據條數
        System.out.println("插入幾條數據"+count);

        sqlSession.commit();

    }
}
