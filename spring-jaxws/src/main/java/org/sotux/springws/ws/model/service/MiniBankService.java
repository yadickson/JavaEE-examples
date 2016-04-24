package org.sotux.springws.ws.model.service;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.sotux.springws.ws.model.dao.AccountDao;
import org.sotux.springws.ws.model.entity.Account;

@WebService(serviceName = "MiniBankService", portName = "MiniBankServicePort")
public class MiniBankService {

    AccountDao accountDao;

    @WebMethod(operationName = "greeting")
    public Account createAccount(@WebParam(name = "account") Account account) {
        return accountDao.createAccount(account);
    }

    @WebMethod(exclude = true)
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

}
