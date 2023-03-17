<%-- 
    Document   : logout
    Created on : 31-Mar-2022, 3:30:49 PM
    Author     : njuser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache");    //HTTP 1.0
    response.setDateHeader("Expires", 0);
    HttpSession Usersession = request.getSession(true);
    //String sUrl = Usersession.getAttribute("aclurl").toString();
    Usersession.invalidate();    
    //System.out.println("Log Out is Called");
    response.sendRedirect("login.fin?cmdAction=loadSignIn");    
%>
