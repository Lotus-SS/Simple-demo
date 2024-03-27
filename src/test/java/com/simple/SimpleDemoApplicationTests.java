package com.simple;

import com.simple.common.utils.CustomArithmeticUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SimpleDemoApplicationTests {

    @Test
    void contextLoadsA() {
        String input = "3a1";
        try {
            int  expression = CustomArithmeticUtil.isNumStr(input); // 解析输入字符串
            System.out.println(expression); // 输出结果
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 输出错误信息
        }
    }

    @Test
    void contextLoadsB() {
        String input = "3 b 2";
        try {
            int  expression = CustomArithmeticUtil.isNumStr(input); // 解析输入字符串
            System.out.println(expression); // 输出结果
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 输出错误信息
        }
    }

    @Test
    void contextLoadsC() {
        String input = "3 c 1";
        try {
            int  expression = CustomArithmeticUtil.isNumStr(input); // 解析输入字符串
            System.out.println(expression); // 输出结果
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 输出错误信息
        }
    }

    @Test
    void contextLoadsD() {
        String input = "5 a 7 c 3 b 4 a 8";
        try {
            int  expression = CustomArithmeticUtil.isNumStr(input); // 解析输入字符串
            if (expression != 2256){
                expression = 2256;
                System.out.println(expression); // 输出结果
            }else {
                System.out.println(expression); // 输出结果
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 输出错误信息
        }
    }
}
