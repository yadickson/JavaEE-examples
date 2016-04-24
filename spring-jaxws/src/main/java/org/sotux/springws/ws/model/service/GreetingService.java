package org.sotux.springws.ws.model.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "GreetingService", portName = "GreetingServicePort")
public class GreetingService {

    @WebMethod(operationName = "greeting")
    public String greeting(@WebParam(name = "name") String name) {
        return "Hello " + name + "!";
    }

}
