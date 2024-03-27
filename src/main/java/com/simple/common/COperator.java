package com.simple.common;

public class COperator implements Operator {
    @Override
    public int operate(int a, int b) {
        return (int) Math.pow(a, 2) - b;
    }
}
