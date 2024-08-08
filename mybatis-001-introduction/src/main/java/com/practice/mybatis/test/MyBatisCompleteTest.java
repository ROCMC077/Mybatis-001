package com.practice.mybatis.test;

import com.mysql.cj.xdevapi.SessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
* 正規方式, 完整版的MyBatis
* */
public class MyBatisCompleteTest {

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            //開啟會話(底層開啟事務)
            sqlSession = sessionFactory.openSession();
            //執行SQL，處理相關業務
            sqlSession.insert("insertCar");
            //執行到這，都沒異常，提交事務 終止事務
            sqlSession.commit();
        } catch (Exception e) {
            //最好回滾事務
            if(sqlSession!=null){
                sqlSession.rollback();
            }
            e.printStackTrace();
        }finally {

            if(sqlSession!=null){
                sqlSession.close();
            }

        }

    }

}
