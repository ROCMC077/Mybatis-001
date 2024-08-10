package com.practice.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * Mybatis 工具類
 * */
public class SqlSessionUtil {

    //工具類的構造方法一般都是私有化
    //工具類中所有方法都是靜態, 直接用類名即可調用, 不需要new對象
    //為了防止New對象, 構造方法私有化
    private SqlSessionUtil(){

    }
    private static SqlSessionFactory sqlSessionFactory;

    //類加載時執行
    //SqlSessionUtil工具類在進行第一次加載時,解析mybatis-config文件, 創造SqlSessionFactory對象
    static {
        try {
             sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
    * 獲取會話對象
    * */
    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();

    }




//    private static SqlSession openSession(){
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        //SqlSessionFactory對象: 一個SqlSessionFactory對應一個mybatis-config裡的environment, 通常是一個數據庫
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        return sqlSession;
//    }


}
