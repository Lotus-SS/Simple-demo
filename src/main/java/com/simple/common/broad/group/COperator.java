package com.simple.common.broad.group;

import com.simple.common.broad.Operator;

public class COperator implements Operator {
    @Override
    public int operate(int a, int b) {
        return a * a - b;
    }
}
