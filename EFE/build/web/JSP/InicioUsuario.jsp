<%-- 
    Document   : InicioUsuario
    Created on : 11-jun-2021, 4:20:11
    Author     : bailarina77
--%>

<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="../img/efeicon.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" session="true">
        <title>BIENVENIDO</title>
    </head>
    <body>
        <h1>Bienvenido</h1>
        <% 
     
       String usuario=(String)session.getAttribute("Usuario");
      
        %>
        <h2>Bienvenido: <%=usuario%></h2>    
        
    </body>
</html>
