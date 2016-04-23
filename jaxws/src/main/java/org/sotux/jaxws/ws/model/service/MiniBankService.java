package org.sotux.jaxws.ws.model.service;

import java.util.Random;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.sotux.jaxws.ws.model.entity.Account;

@WebService(serviceName = "MiniBankService", portName = "MiniBankServicePort")
public class MiniBankService {

    @WebMethod(operationName = "createAccount")
    public Account createAccount(@WebParam(name = "account") Account account) {
        Account a = new Account();
        a.setId((long)((new Random()).nextInt(100)));
        a.setName(account.getName());
        a.setBalance(account.getBalance());
        return a;
    }

}
