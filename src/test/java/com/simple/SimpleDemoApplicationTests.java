package com.simple;

import com.simple.common.Parser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Scanner;

import static com.simple.common.Parser.calculate;

@SpringBootTest
class SimpleDemoApplicationTests {

    @Test
    void contextLoads() {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
        String input = "3a1";
        try {
            List<Object> expression = Parser.parse(input);
            int result = calculate(expression);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
