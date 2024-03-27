package com.simple;

import com.simple.common.Parser;

import java.util.List;
import java.util.Scanner;

import static com.simple.common.Parser.calculate;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            List<Object> expression = Parser.parse(input);
            int result = calculate(expression);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
