package org.sotux.strutsmvc.web.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ResultNames;

public class NewAccountAction extends ActionSupport {

    private String username;
    private Double balance;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String execute() {
        return ResultNames.SUCCESS;
    }

    @Override
    public void validate() {
        if (getUsername().length() > 0 && balance > 0D) {
            addActionMessage("You are valid user!");
        } else {
            addActionError("I don't know you, dont try to hack me!");
        }
    }
}
