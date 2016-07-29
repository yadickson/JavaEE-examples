/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sotux.springmvc.util;

/**
 *
 * @author debian
 */
public class StackManager {

    private static String getInfo(StackTraceElement element) {
        return element.getLineNumber() + ":" + element.getClassName() + "." + element.getMethodName();
    }

    private static String getInfo(StackTraceElement element, Exception ex) {
        return getInfo(element) + " - " + ex.getMessage();
    }

    public static String getInfo() {
        return getInfo(Thread.currentThread().getStackTrace()[1]);
    }

    public static String getInfo(Exception ex) {
        return getInfo(Thread.currentThread().getStackTrace()[1], ex);
    }
}
