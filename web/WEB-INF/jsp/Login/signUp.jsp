<%-- 
    Document   : signIn
    Created on : 03-Feb-2022, 12:04:21 PM
    Author     : njuser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Register</title>
        <meta charset="utf-8" />
        <%@include file="../cdn/cdn.jsp" %>
        <link rel="stylesheet" href="css/custom/login.css" />
    </head>
    <body>
        <%--<c:if test="${Action eq 'signup'}">--%>
            <div id="status"> 
            </div>
            <div id="load">
            <section class="ftco-section">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-md-7 col-lg-5">
                            <div class="login-wrap p-4 p-md-5">
                                <div
                                    class="icon d-flex align-items-center justify-content-center"
                                    >
                                    <i class="fa-solid fa-user text-white"></i>
                                </div>
                                <h3 class="text-center mb-4">Register</h3>
                                <form id="RegisterForm" name="Register" method="POST" class="login-form">
                                    <div class="form-group">
                                        <input
                                            type="text"
                                            class="form-control rounded-left"
                                            placeholder="Email"
                                            name="Email"
                                            onblur="EmailExist();"
                                            id="Email"
                                            />
                                        <div id="EmailError" style="color:red;"></div>
                                    </div>
                                    <div class="form-group">
                                        <input
                                            type="text"
                                            class="form-control rounded-left"
                                            placeholder="Username"
                                            name="UserName"
                                            onblur="UserNameExist();"
                                            id="UserName"
                                            />
                                        <div id="UserNameError" style="color:red;"></div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <input
                                            type="password"
                                            class="form-control rounded-left"
                                            placeholder="Password"
                                            name="Password"
                                            id="Password"
                                            onblur="validatePassword()"
                                            />
                                        <div id="PasswordError" style="color:red;"></div>
                                    </div>
                                    <div class="form-group">
                                        <button
                                            id="registerBtn"
                                            type="button"
                                            class="form-control btn btn-primary rounded submit px-3"
                                            onclick="validateSignUp()"
                                            >
                                            Register
                                        </button>
                                    </div>
                                    <div class="form-group d-md-flex">
                                        <div class="w-100">
                                            Already a User? <a href="javascript:void(0)" onclick="loadSignIn()">Sign in here!</a>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            </div>
        <%--</c:if>--%>

    </body>
</html>
