/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sotux.strutsmvc.model.dao.impl;

import org.sotux.strutsmvc.model.dao.AccountDao;
import org.sotux.strutsmvc.model.entity.Account;

public class AccountDaoImpl implements AccountDao {

    @Override
    public Account createAccount(Account account) {
        return new Account ();
    }
    
}
