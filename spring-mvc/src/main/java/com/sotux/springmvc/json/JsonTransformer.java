/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotux.springmvc.json;

import com.sotux.springmvc.exception.BusinessException;

/**
 *
 * @author debian
 */
public interface JsonTransformer {

    String toJson(Object data) throws BusinessException;

    <T> T fromJSON(String json, Class<T> clazz) throws BusinessException;
}
