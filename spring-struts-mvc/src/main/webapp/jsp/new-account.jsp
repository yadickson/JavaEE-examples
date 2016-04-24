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
        <h1><s:text name="new.account.title"/></h1>

        <s:set name="usernametext"><s:text name="new.account.username"/></s:set>
        <s:set name="balancetext"><s:text name="new.account.balance"/></s:set>
        <s:set name="buttontext"><s:text name="new.account.button"/></s:set>

        <s:form action="newAccountAction" method="POST">
            <s:textfield name="username" label="%{usernametext}" />
            <s:textfield name="balance" label="%{balancetext}" />
            <s:submit value="%{buttontext}" />
        </s:form>

        <s:if test="hasActionErrors()">
            <div>
                <s:actionerror/>
            </div>
        </s:if>

    </body>
</html>