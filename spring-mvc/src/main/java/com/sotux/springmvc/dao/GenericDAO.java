/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotux.springmvc.dao;

import com.sotux.springmvc.exception.BusinessException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author debian
 * @param <T>
 * @param <ID>
 */
public interface GenericDAO<T, ID extends Serializable> {

    public T create() throws BusinessException;

    public ID save(T entity) throws BusinessException;

    public void update(ID id, T entity) throws BusinessException;

    public T get(ID id) throws BusinessException;

    public void delete(ID id) throws BusinessException;

    public List<T> findAll() throws BusinessException;

}
