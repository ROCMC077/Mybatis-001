package com.practice.junit;

import org.junit.Assert;
import org.junit.Test;

/**
 * 單元測試類
 *
 * */
public class MathServiceTest { //名子的規範: 要測試的類名+Test

    //單元測試方法寫多少個
    //一般是一個業務方法對應一個測試方式
    //測試方法的規範: public void testXxx(){}
    //測試方法的方法名以test開始, 假設要被測試的方法名:sum, 測試方法名:testSum
    //@Test註解的方法就是一個單元測試的方法
    @Test
    public void testSum(){
    //單元測試中有兩個重要概念
    // 一個是: 實際值 (被測試的業務方法 真正執行結果)
    // 一個是: 期望值 (執行這業務方法後, 期望執行結果是多少?)

        MathService mathService = new MathService();

        //實際值
        int actual = mathService.sum(1,2);
        //期望值
        int expected = 3;
        //加斷言進行測試
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testSub(){
        MathService mathService = new MathService();
        int sub = mathService.sub(10,5);
        int expected = 5;
        Assert.assertEquals(expected,sub);
    }

}
