package com.practice.mybatis.mapper;

import com.practice.mybatis.pojo.Student;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentMapper {

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
