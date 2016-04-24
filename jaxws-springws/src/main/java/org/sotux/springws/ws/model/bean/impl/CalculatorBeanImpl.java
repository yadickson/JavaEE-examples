package org.sotux.springws.ws.model.bean.impl;

import org.sotux.springws.ws.model.bean.CalculatorBean;

public class CalculatorBeanImpl implements CalculatorBean {

    @Override
    public Double add(Double a, Double b) {
        return a + b;
    }

    @Override
    public Double sub(Double a, Double b) {
        return a - b;
    }

}
