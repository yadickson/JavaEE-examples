package org.sotux.strutsmvc.web.action;

import org.apache.struts2.Action;
import org.apache.struts2.ResultNames;
import org.sotux.strutsmvc.model.dao.AccountDao;
import org.sotux.strutsmvc.model.entity.Account;

public class AddAccountAction implements Action {

    private String username;
    private Double balance;

    AccountDao accountDao;
    
    @Override
    public String execute() {

        if (username.length() > 0 && balance > 0D) {
            accountDao.createAccount( new Account() );
            return ResultNames.SUCCESS;
        } else {
            return ResultNames.ERROR;
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
