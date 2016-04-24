package org.sotux.springws.ws.model.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.sotux.springws.ws.model.bean.CalculatorBean;

@WebService(serviceName = "CalculatorService", portName = "CalculatorServicePort")
public class CalculatorService {

    CalculatorBean calculatorBean;

    @WebMethod(operationName = "add")
    public Double add(@WebParam(name = "a") Double a, @WebParam(name = "b") Double b) {
        return calculatorBean.add(a, b);
    }

    @WebMethod(operationName = "sub")
    public Double sub(@WebParam(name = "a") Double a, @WebParam(name = "b") Double b) {
        return calculatorBean.sub(a, b);
    }

    @WebMethod(exclude = true)
    public void setCalculatorBean(CalculatorBean calculatorBean) {
        this.calculatorBean = calculatorBean;
    }
}
