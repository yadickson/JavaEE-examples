/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sotux.springmvc.exception;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 *
 * @author debian
 */

public class BusinessException extends Exception {

    @Getter
    private final List<BusinessMessage> businessMessages = new ArrayList<BusinessMessage>();

    public BusinessException(Exception ex) {
        this.businessMessages.add (new BusinessMessage(ex.getClass().getSimpleName(), ex.getMessage()));
    }
    
    public BusinessException(List<BusinessMessage> businessMessages) {
        this.businessMessages.addAll(businessMessages);
    }

    public BusinessException(BusinessMessage businessMessage) {
        this.businessMessages.add(businessMessage);
    }
}