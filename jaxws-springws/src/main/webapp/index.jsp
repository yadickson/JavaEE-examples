<%-- 
    Document   : index
    Created on : Apr 23, 2016, 1:44:26 PM
    Author     : soto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The web services portal</title>
    </head>
    <body>
        <h1>Web services</h1>
        <div><a href="${pageContext.request.contextPath}/CalculatorService?wsdl">CalculatorService</a></div>
        <div><a href="${pageContext.request.contextPath}/MiniBankService?wsdl">MiniBankService</a></div>
        <div><a href="${pageContext.request.contextPath}/GreetingService?wsdl">GreetingService</a></div>
    </body>
</html>
