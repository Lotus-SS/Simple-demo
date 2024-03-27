package com.simple;


import com.simple.common.utils.CustomArithmeticUtil;

import java.util.*;

public class CustomArithmetic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            int  expression = CustomArithmeticUtil.isNumStr(input); // 解析输入字符串
            System.out.println(expression); // 输出结果
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 输出错误信息
        }
    }
}
