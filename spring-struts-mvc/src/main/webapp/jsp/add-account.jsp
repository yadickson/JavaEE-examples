<%-- 
    Document   : add-account
    Created on : Apr 24, 2016, 10:58:18 AM
    Author     : soto
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
    <head></head>
    <body>
        <h1><s:text name="add.account.title"/></h1>

        <s:set name="usernametext"><s:text name='add.account.username'/></s:set>
        <s:set name="balancetext"><s:text name='add.account.balance'/></s:set>
        <s:set name="buttontext"><s:text name='add.account.button'/></s:set>

        <s:form action="addAccountAction" >
            <s:textfield name="username" id="name" label="%{usernametext}" />
            <s:textfield name="balance" id="balance" label="%{balancetext}" />
            <s:submit value="%{buttontext}"/>
        </s:form>

    </body>
</html>