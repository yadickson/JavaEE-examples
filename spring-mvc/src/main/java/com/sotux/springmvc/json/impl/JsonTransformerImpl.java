/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotux.springmvc.json.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sotux.springmvc.exception.BusinessException;
import com.sotux.springmvc.exception.BusinessMessage;
import com.sotux.springmvc.json.JsonTransformer;
import com.sotux.springmvc.util.StackManager;
import java.io.IOException;

/**
 *
 * @author debian
 */
public class JsonTransformerImpl implements JsonTransformer {

    @Override
    public String toJson(Object data) throws BusinessException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException ex) {
            StackManager.getInfo(ex);
            throw new BusinessException(new BusinessMessage("toJson()", "[" + data.getClass().toString() + "] error: " + ex.getMessage()));
        }
    }

    @Override
    public <T> T fromJSON(String json, Class<T> clazz) throws BusinessException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            return objectMapper.readValue(json, clazz);
        } catch (IOException ex) {
            StackManager.getInfo(ex);
            throw new BusinessException(new BusinessMessage("fromJSON()", "[" + json + "] error: " + ex.getMessage()));
        }
    }

}
