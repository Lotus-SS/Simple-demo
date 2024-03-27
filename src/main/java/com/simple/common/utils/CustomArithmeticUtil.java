package com.simple.common.utils;

import com.simple.common.broad.Operator;
import com.simple.common.constant.FigureConstant;
import com.simple.common.broad.group.AOperator;
import com.simple.common.broad.group.BOperator;
import com.simple.common.broad.group.COperator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomArithmeticUtil {

    private static final Map<String, Integer> precedence = new HashMap<>();
    private static final Map<String, Operator> operatorMap = new HashMap<>();

    static {
        precedence.put("a", FigureConstant.TWO);
        precedence.put("b", FigureConstant.ONE);
        precedence.put("c", FigureConstant.THREE);

        operatorMap.put("a", new AOperator());
        operatorMap.put("b", new BOperator());
        operatorMap.put("c", new COperator());
    }

    public static List<String> infixToPostfix(String[] tokens) {
        List<String> postfix = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (isNumeric(token)) {
                postfix.add(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.add(stack.pop());
                }
                stack.pop(); // Discard the opening parenthesis
            } else {
                while (!stack.isEmpty() && precedence.getOrDefault(stack.peek(), 0) >= precedence.get(token)) {
                    postfix.add(stack.pop());
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }

        return postfix;
    }

    public static int evaluatePostfix(List<String> postfix) {
        Stack<Integer> stack = new Stack<>();

        for (String token : postfix) {
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = operatorMap.get(token).operate(operand1, operand2);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }
    public static int isNumStr(String str) throws IllegalArgumentException {
        // Remove spaces from the input string
        str = str.replaceAll(" ", "");

        String[] tokens = str.split("");
        for (String token : tokens) {
            if (!isNumeric(token) && !operatorMap.containsKey(token)) {
                Pattern pattern = Pattern.compile("(\\d+|[abc]+)");
                Matcher matcher = pattern.matcher(token);
                if (!matcher.matches()) {
                    throw new IllegalArgumentException("Invalid operator: " + token);
                }
            }
        }
        List<String> postfix = CustomArithmeticUtil.infixToPostfix(tokens);
        int result = CustomArithmeticUtil.evaluatePostfix(postfix);
        return result;
    }
}
