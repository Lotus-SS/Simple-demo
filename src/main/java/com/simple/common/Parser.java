package com.simple.common;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final Map<String, Operator> OPERATORS = new HashMap<>();

    static {
        OPERATORS.put("a", new AOperator());
        OPERATORS.put("b", new BOperator());
        OPERATORS.put("c", new COperator());
    }

    public static List<Object> parse(String input) throws IllegalArgumentException {
        List<Object> result = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\d+|[abc])");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String token = matcher.group();
            if (Character.isDigit(token.charAt(0))) {
                result.add(Integer.parseInt(token));
            } else {
                if (OPERATORS.containsKey(token)) {
                    result.add(OPERATORS.get(token));
                } else {
                    throw new IllegalArgumentException("Invalid character: " + token);
                }
            }
        }
        return result;
    }

    public static int calculate(List<Object> expression) throws IllegalArgumentException {
        Stack<Integer> operandStack = new Stack<>();
        Stack<Operator> operatorStack = new Stack<>();

        for (Object obj : expression) {
            if (obj instanceof Operator) {
                Operator operator = (Operator) obj;
                while (!operatorStack.isEmpty() && hasHigherPrecedence(operatorStack.peek(), operator)) {
                    processOperation(operandStack, operatorStack);
                }
                operatorStack.push(operator);
            } else if (obj instanceof Integer) {
                operandStack.push((Integer) obj);
            } else {
                throw new IllegalArgumentException("Invalid character: " + obj);
            }
        }

        while (!operatorStack.isEmpty()) {
            processOperation(operandStack, operatorStack);
        }

        if (operandStack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }
        return operandStack.pop();
    }

    private static boolean hasHigherPrecedence(Operator op1, Operator op2) {
        if (op1 instanceof AOperator && op2 instanceof BOperator) {
            return true;
        } else if (op1 instanceof BOperator && op2 instanceof COperator) {
            return true;
        } else {
            return false;
        }
    }

    private static void processOperation(Stack<Integer> operandStack, Stack<Operator> operatorStack) throws IllegalArgumentException {
        if (operandStack.size() < 2) {
            throw new IllegalArgumentException("Insufficient operands");
        }
        int a = operandStack.pop();
        int b = operandStack.pop();
        Operator operator = operatorStack.pop();
        operandStack.push(operator.operate(a, b));
    }
}
