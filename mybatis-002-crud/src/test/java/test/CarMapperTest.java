package test;

import com.practice.mybatis.pojo.Car;
import com.practice.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarMapperTest {

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Object> cars = sqlSession.selectList("selectAll");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // mybatis 底層執行select語句後一定會返回一個結果集對象, ResultSet
        // JDBC 中叫 ResultSet, 接下來就是 mybatis 應該從 ResultSet 中取出數據, 封裝對象
        Object car = sqlSession.selectOne("selectById", 1);
        System.out.println(car.toString());
        sqlSession.close();
    }

    @Test
    public void testUpdateById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car = new Car(1,"1000","BMW_update",200.0,"2024-08-10","油車Update");
        int count = sqlSession.update("updateById", car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteById(){
    SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.delete("deleteById", 19);
        System.out.println(count);
        sqlSession.commit();
    sqlSession.close();


    }


    @Test
    public void testInsertCarByPOJO(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 封裝數據
        Car car = new Car(null,"1005","奧迪",200.0,"2024-08-10","油車");
        //  執行SQL
        int count = sqlSession.insert("insertCar", car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testInsertCarByUtil(){
        SqlSession sqlSession = SqlSessionUtil.openSession();

        Map<String,Object> object = new HashMap<>();
        object.put("carNum","1004");
        object.put("brand","特斯拉");
        object.put("guidePrice",3000);
        object.put("produceTime","2024-08-10");
        object.put("carType","電車");


        //執行sql
        //insert方法的參數(2種)
        //insert(sqlId)
        //insert(sqlId,對象)
        int count = sqlSession.insert("insertCar",object);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();

    }

}
