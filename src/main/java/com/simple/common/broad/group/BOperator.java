package com.simple.common.broad.group;

import com.simple.common.broad.Operator;
import com.simple.common.constant.FigureConstant;

public class BOperator implements Operator {
    @Override
    public int operate(int a, int b) {
        return (a - FigureConstant.FIVE) * b;
    }
}
