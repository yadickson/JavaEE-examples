/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotux.springmvc.exception;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author debian
 */
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class BusinessMessage {

    @Getter
    private final String name;
    
    @Getter
    private final String message;
}
