package com.simple.common;

public class BOperator implements Operator {
    @Override
    public int operate(int a, int b) {
        return a - 5 * b;
    }
}
