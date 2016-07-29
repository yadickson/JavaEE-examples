/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotux.springmvc.controller.impl;

import com.sotux.springmvc.controller.UserController;
import com.sotux.springmvc.exception.BusinessException;

import com.sotux.springmvc.dao.UserDAO;
import com.sotux.springmvc.entity.User;
import com.sotux.springmvc.json.JsonTransformer;
import com.sotux.springmvc.util.StackManager;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author debian
 */
@Controller
public class UserControllerImpl implements UserController {

    @Autowired
    JsonTransformer jsonTransformer;

    @Autowired
    UserDAO userDAO;

    @Override
    @RequestMapping(value = "/User", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void list(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, BusinessException {
        try {
            List<User> list = userDAO.findAll();

            String json = jsonTransformer.toJson(list);

            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            httpServletResponse.getWriter().println(json);

        } catch (BusinessException ex) {

            String jsonEx = jsonTransformer.toJson(ex.getBusinessMessages());

            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            httpServletResponse.getWriter().println(jsonEx);

        } catch (RuntimeException ex) {
            System.out.println(StackManager.getInfo(ex));
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @RequestMapping(value = "/User/{idUser}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void read(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idUser") Integer idUser) throws IOException, BusinessException {

        try {
            User user = userDAO.get(idUser);
            String json = jsonTransformer.toJson(user);

            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            httpServletResponse.getWriter().println(json);

        } catch (BusinessException ex) {

            String jsonEx = jsonTransformer.toJson(ex.getBusinessMessages());

            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            httpServletResponse.getWriter().println(jsonEx);

        } catch (RuntimeException ex) {
            System.out.println(StackManager.getInfo(ex));
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @RequestMapping(value = "/User", method = {RequestMethod.POST}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonInput) throws IOException, BusinessException {

        try {
            User user = jsonTransformer.fromJSON(jsonInput, User.class);
            Integer id = userDAO.save(user);

            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            httpServletResponse.getWriter().println(jsonTransformer.toJson(id));

        } catch (BusinessException ex) {

            String jsonEx = jsonTransformer.toJson(ex.getBusinessMessages());

            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            httpServletResponse.getWriter().println(jsonEx);

        } catch (RuntimeException ex) {
            System.out.println(StackManager.getInfo(ex));
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @RequestMapping(value = "/User/{idUser}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonInput, @PathVariable("idUser") Integer idUser) throws IOException, BusinessException {

        try {
            User user = jsonTransformer.fromJSON(jsonInput, User.class);
            userDAO.update(idUser, user);
            String userUpdated = jsonTransformer.toJson(user);

            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            httpServletResponse.getWriter().println(userUpdated);

        } catch (BusinessException ex) {

            String jsonEx = jsonTransformer.toJson(ex.getBusinessMessages());

            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            httpServletResponse.getWriter().println(jsonEx);

        } catch (RuntimeException ex) {
            System.out.println(StackManager.getInfo(ex));
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @RequestMapping(value = "/User/{idUser}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idUser") Integer idUser) throws IOException, BusinessException {

        try {
            userDAO.delete(idUser);

            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        } catch (BusinessException ex) {

            String jsonEx = jsonTransformer.toJson(ex.getBusinessMessages());

            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            httpServletResponse.getWriter().println(jsonEx);

        } catch (RuntimeException ex) {
            System.out.println(StackManager.getInfo(ex));
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}
