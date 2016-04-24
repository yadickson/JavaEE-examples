<%-- 
    Document   : main-menu
    Created on : Apr 24, 2016, 10:58:33 AM
    Author     : soto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="main.title" /></title>
    </head>
    <body>
        <h1><s:text name="main.menu.options"/></h1>

        <ol>
            <s:iterator value="menuOptions">
                <li>
                    <a href="<s:property value='action'/>" ><s:text name="%{key}"/></a>
                </li>
            </s:iterator>
        </ol>

    </body>
</html>