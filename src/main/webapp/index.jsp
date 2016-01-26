<%-- 
    Document   : index
    Created on : 26-Jan-2016, 5:27:22 PM
    Author     : c0664573
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jbosswildfly.jbosswildfly" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%=jbosswildfly.getTable()%>
    </body>
</html>
