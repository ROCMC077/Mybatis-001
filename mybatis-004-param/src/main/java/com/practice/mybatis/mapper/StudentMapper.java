package com.practice.mybatis.mapper;

import com.practice.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentMapper {

    /**
     * 使用多參數使用 @Param 查詢 Student訊息
     *   mybatis 框架底層實現原理,
     *      map.put("name",name);
     *      map.put("sex",sex);
     * */
    public List<Student> selectStudentByNameAndSex2(@Param("name") String name,@Param("sex") Character sex);

    /**
     * 使用多參數查詢 Student訊息
     * 如果是多參數, mybatis 框架會自動生成一個 Map集合,
     *      map.put("args0",name);
     *      map.put("args1",sex);
     *      map.put("param1",name);
     *      map.put("param2",sex);
     * */
    public List<Student> selectStudentByNameAndSex(String name,Character sex);

    /**
     * 新增學生訊息, 通過 POJO 參數
     * */
    int insertStudentByPOJO(Student student);

    /**
     * 新增學生訊息, 通過 Map 參數
     * */
    int insertStudentByMap(Map<String,Object> map);

    /**
     * 當接口中的方法參數只有一個, 並且參數是簡單類型
     * 根據 id查詢、name查詢、birth查詢、sex查詢
     * */
    public List<Student> selectById(Integer id);
    public List<Student> selectByName(String name);
    public List<Student> selectByBirth(Date birth);
    public List<Student> selectBySex(Character sex);


}
