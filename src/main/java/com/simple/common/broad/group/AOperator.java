package com.simple.common.broad.group;

import com.simple.common.broad.Operator;
import com.simple.common.constant.FigureConstant;

public class AOperator implements Operator {
    @Override
    public int operate(int a, int b) {
        return a * FigureConstant.TWO + b;
    }
}
