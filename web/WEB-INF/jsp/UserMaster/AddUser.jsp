<%-- 
    Document   : editUserMaster
    Created on : 28-Mar-2022, 10:22:45 AM
    Author     : njuser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container my-4">
    <div class="card mb-3">
        <div class="card-header">
            <c:choose>
                <c:when test="${task eq 'Edit'}">Edit</c:when>
                <c:when test="${task eq 'View'}">View</c:when>
                <c:otherwise>Add</c:otherwise>
            </c:choose>
            User
        </div>
        <div class="card-body">
            <form id="userForm" name="userForm" method="POST" class="row g-3">
                <div class="row g-3 mb-3">

                    <div class="col-12">
                        <div class="row">
                            <div class="col-md-3">
                                <label for="Email" class="form-label">Email</label>
                            </div>
                            <div class="col-md-9">
                                <input type="hidden" id="usercode" name="usercode" value="${usercode}">
                                <input class="form-control" type="text" id="Email" 
                                       value="${email}" name="Email" placeholder="Email" onblur="EmailExist();"
                                       <c:if test="${task eq 'Edit' || task eq 'Delete' || task eq 'View'}">disabled</c:if>>
                                       <div id="EmailError" style="color:red;"></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-12" id="categoryblock">
                            <div class="row">
                                <div class="col-md-3">
                                    <label for="UserName" class="form-label">User Name</label>
                                </div>
                                <div class="col-md-9">
                                    <input class="form-control" type="text" id="UserName"
                                           value="${username}" name="UserName" placeholder="Username" onblur="UserNameExist();"
                                    <c:if test="${task eq 'Edit' || task eq 'Delete' || task eq 'View'}">disabled</c:if>>
                                    <div id="UserNameError" style="color:red;"></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-12" <c:if test="${task eq 'Edit' || task eq 'Delete' || task eq 'View'}">style="display: none"</c:if>>
                            <div class="row">
                                <div class="col-md-3">
                                    <label for="Password" class="form-label">Password</label>
                                </div>
                                <div class="col-md-9">
                                    <input class="form-control" type="password" id="Password" maxlength="20"
                                           value="${password}" name="Password" placeholder="Password" onblur="validatePassword()">
                                <div id="PasswordError" style="color:red;"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-12">
                        <div class="row">
                            <div class="col-md-3">
                                <label for="chkActive" class="form-label">Is Active</label>
                            </div>
                            <div class="col-md-9">
                                <c:choose>
                                    <c:when test="${isactive eq 'N'}">
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" id="yes" name="chkActive" value="Y"  <c:if test="${task eq 'Delete' || task eq 'View'}">disabled</c:if>>
                                                <label class="form-check-label" for="yes">Yes</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" id="no" name="chkActive" value="N" checked  <c:if test="${task eq 'Delete' || task eq 'View'}">disabled</c:if>>
                                                <label class="form-check-label" for="no">No</label>
                                            </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" id="yes" name="chkActive" value="Y" checked <c:if test="${task eq 'Delete' || task eq 'View'}">disabled</c:if> >
                                                <label class="form-check-label" for="yes">Yes</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" id="no" name="chkActive" value="N"  <c:if test="${task eq 'Delete' || task eq 'View'}">disabled</c:if>>
                                                <label class="form-check-label" for="no">No</label>
                                            </div>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                    <div class="col-12">
                        <div class="row">
                            <div class="col-md-3">
                                <label for="active" class="form-label">User Type</label>
                            </div>
                            <div class="col-md-9">
                                <c:choose>
                                    <c:when test="${usertype eq '1'}">
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" id="admin" name="usertype" value="1" checked <c:if test="${task eq 'Delete' || task eq 'View'}">disabled</c:if>>
                                                <label class="form-check-label" for="admin">Admin</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" id="user" name="usertype" value="2"  <c:if test="${task eq 'Delete' || task eq 'View'}">disabled</c:if>>
                                                <label class="form-check-label" for="user">User</label>
                                            </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" id="admin" name="usertype" value="1"  <c:if test="${task eq 'Delete' || task eq 'View'}">disabled</c:if>>
                                                <label class="form-check-label" for="admin">Admin</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" id="user" name="usertype" value="2" checked <c:if test="${task eq 'Delete' || task eq 'View'}">disabled</c:if>>
                                                <label class="form-check-label" for="user">User</label>
                                            </div>
                                    </c:otherwise>
                                </c:choose>

                            </div>
                        </div>
                    </div>

                    <div id="updateUserFlag"></div>
                    <!-- Row End -->

                    <div class="text-center">
                        <c:choose>
                            <c:when test="${task eq 'Edit'}">
                                <button type="button" class="btn btn-primary" onclick="updateUser()">Update User</button>
                            </c:when>
                            <c:when test="${task eq 'View'}">
                                
                            </c:when>
                            <c:otherwise>
                                <button id="registerBtn" type="button" class="btn btn-primary" onclick="addUserdetail()" >Add User</button>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </form>
        </div>
    </div>
