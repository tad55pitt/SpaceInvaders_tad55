<%-- 
    Document   : index
    Created on : Feb 18, 2016, 7:01:28 PM
    Author     : Troy
--%>

<%@page import="edu.pitt.is1017.spaceinvaders.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AlienInvasion - Login</title>
    </head>
    <%
        String email = "";
        String password = "";
        User user;
        if (request.getParameter("btnSubmit") != null) {
            if (request.getParameter("txtEmail") != null) {
                if (request.getParameter("txtEmail") != "") {
                    email = request.getParameter("txtEmail");
                }
            }
            if (request.getParameter("txtPassword") != null) {
                if (request.getParameter("txtPassword") != "") {
                    password = request.getParameter("txtPassword");
                }
            }

            if (!email.equals("") && !password.equals("")) {
                user = new User(email, password);
                response.sendRedirect("game.jsp");
                
            } else {
                out.println("<script>alert('You must enter both Email and Password');</script>");
            }   
        }
        if (request.getParameter("btnRegister") != null) {
            response.sendRedirect("Registration.jsp");
        }
    %>
    <body>
        <form id="frmLogin" action="index.jsp" method="post" >
            <label for="txtEmail">Email:</label>&nbsp;<input type="text" id="txtEmail" name="txtEmail" value=""></input>
            <br/>
            <br/>
            <label for="txtPassword">Password:</label>&nbsp;&nbsp;<input type="password" id="txtPassword" name="txtPassword" value=""></input>
            </br>
            </br>
            <input type ="submit" id="btnSubmit" name="btnSubmit" value="Login"></input>
            <input type ="submit" id="btnRegister" name="btnRegister" value="Register"></input>
        </form>
    </body>
</html>
