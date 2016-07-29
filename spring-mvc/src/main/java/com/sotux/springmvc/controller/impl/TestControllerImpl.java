/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotux.springmvc.controller.impl;

import com.sotux.springmvc.controller.TestController;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author debian
 */
@Controller
public class TestControllerImpl implements TestController {

    @Override
    @RequestMapping(value = {"/Test"}, method = {RequestMethod.GET})
    public void test(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.getWriter().println("Hello World");
    }

}
