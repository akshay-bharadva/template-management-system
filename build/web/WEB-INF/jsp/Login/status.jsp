<%-- 
    Document   : status
    Created on : 17-Feb-2022, 12:07:20 PM
    Author     : njuser
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:choose>
    <c:when test="${Action eq 'insertedUser'}">
        <input type="hidden" name="RegisterStatus" id="RegisterStatus" value="${status}">
    </c:when>
    <c:when test="${Action eq 'checkEmail'}">
        <input type="hidden" name="CheckEmailStatus" id="CheckEmailStatus" value="${status}">
        <c:if test="${status eq 1}">
            <span>Email is already Exist</span>
        </c:if>
    </c:when>
    <c:when test="${Action eq 'checkUserName'}">
        <input type="hidden" name="CheckUserNameStatus" id="CheckUserNameStatus" value="${status}">
        <c:if test="${status eq 1}">
            <span>UserName is already Exist</span>
        </c:if>
    </c:when>
</c:choose>
