package com.practice.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class CarMapperTest {

    @Test
    public void testInsertCar(){
        // 編寫mybatis程序

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
