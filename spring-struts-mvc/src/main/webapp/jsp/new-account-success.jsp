<%-- 
    Document   : add-account
    Created on : Apr 24, 2016, 10:58:18 AM
    Author     : soto
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="main.title" /></title>
        <s:head />
    </head>
    <body>
        <h1><s:text name="welcome.new.account.title"/> <s:property value="username" /></h1>

        <s:if test="hasActionMessages()">
            <div>
                <s:actionmessage/>
            </div>
        </s:if>

    </body>
</html>