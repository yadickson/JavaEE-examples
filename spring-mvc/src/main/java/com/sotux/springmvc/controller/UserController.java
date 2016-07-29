/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotux.springmvc.controller;

import com.sotux.springmvc.exception.BusinessException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author debian
 */
public interface UserController {

    public void list(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, BusinessException;

    public void read(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Integer idUser) throws IOException, BusinessException;
    
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String jsonInput) throws IOException, BusinessException;

    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String jsonInput, Integer idUser) throws IOException, BusinessException;

    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Integer idUser) throws IOException, BusinessException;
}
