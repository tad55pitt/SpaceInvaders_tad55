<%-- 
    Document   : Injector
    Created on : Mar 3, 2016, 6:54:26 PM
    Author     : Troy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        if(request.getParameter("txt.userName")!=null){
            String userName = request.getParameter("txtUserName");
            String sql = "SELECT * from users WHERE email = " + userName + ";";
            out.print(sql);
        }
        
    
    %>
    
    
    <body>
        <form name="frmTest" action="Injector.jsp">
            <label for="titleName" >User Name  </label>&nbsp;<input type="text" id=txtUserName" value=""></input>
            <br/>
            <label for="titleName" >Password  </label>&nbsp;<input type="text" id=txtPassword" value=""></input>
            </br>
            <input type ="submit" id="btnSubmit" value="Login"></input>
            
            
        </form>
    </body>
</html>
