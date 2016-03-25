<%-- 
    Document   : Registration
    Created on : Mar 3, 2016, 6:40:34 PM
    Author     : Troy
--%>

<%@page import="edu.pitt.is1017.spaceinvaders.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AlienInvasion - Registration</title>
    </head>
    <%
        String firstName = "";
        String lastName = "";
        String email = "";
        String password = "";
        String confirmPass = "";
        User user;

        if (request.getParameter("btnRegister") != null) {
            if (request.getParameter("txtFirstName") != null) {
                if (request.getParameter("txtFirstName") != "") {
                    firstName = request.getParameter("txtFirstName");
                }
            }
            if (request.getParameter("txtLastName") != null) {
                if (request.getParameter("txtLastName") != "") {
                    lastName = request.getParameter("txtLastName");
                }
            }
            if (request.getParameter("txtEmail") != null) {
                if (request.getParameter("txtEmail") != "") {
                    email = request.getParameter("txtEmail");
                }
            }
            if (request.getParameter("txtPass") != null) {
                if (request.getParameter("txtPass") != "") {
                    password = request.getParameter("txtPass");
                }
            }
            if (request.getParameter("txtConfirmPass") != null) {
                if (request.getParameter("txtConfirmPass") != "") {
                    confirmPass = request.getParameter("txtConfirmPass");
                }
            }
            if (!firstName.equals("") && !lastName.equals("") && !email.equals("") && !password.equals("") && !confirmPass.equals("")) {
                user = new User(firstName, lastName, email, password);
                user.saveUserInfo();
                response.sendRedirect("index.jsp");
            }
            else{
                out.println("<script>alert('You must enter all required information');</script>");       
            }
        }

        if (request.getParameter("btnCancel") != null) {
            response.sendRedirect("index.jsp");
        }
    %>
    <body>
        <form id="frmRegistration" action="Registration.jsp" method="post">
            <label for="txtFirstName" >First Name: </label>&nbsp;<input type="text" id=txtFirstName" name="txtFirstName" value=""></input>
            <br/>
            <br/>
            <label for="txtLastName" >Last Name: </label>&nbsp;<input type="text" id=txtLastName" name="txtLastName" value=""></input>
            <br/>
            <br/>
            <label for="txtEmail" >Email: </label>&nbsp;<input type="text" id=txtEmail" name=txtEmail" value=""></input>
            <br/>
            <br/>
            <label for="txtPass" >Password: </label>&nbsp;<input type="password" id="txtPass" name="txtPass" value=""></input>
            <br/>
            <br/>
            <label for="txtConfirmPass" >Confirm Password: </label>&nbsp;<input type="password" id=txtConfirmPass" name=txtConfirmPass" value=""></input>
            <br/>

            <input type ="submit" id="btnRegister" name="btnRegister" value="Register"></input>
            <input type ="submit" id="btnCancel" name="btnCancel" value="Cancel"></input>

        </form>
    </body>
</html>
