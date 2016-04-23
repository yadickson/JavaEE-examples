package org.sotux.jaxws.ws.model.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "CalculatorService", portName = "CalculatorServicePort")
public class CalculatorService {

    @WebMethod(operationName = "add")
    public Double add(@WebParam(name = "a")Double a, @WebParam(name = "b")Double b) {
        return a + b;
    }

    @WebMethod(operationName = "sub")
    public Double sub(@WebParam(name = "a")Double a, @WebParam(name = "b")Double b) {
        return a - b;
    }
}
