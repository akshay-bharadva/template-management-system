<%-- 
    Document   : signIn
    Created on : 16-Feb-2022, 2:52:46 PM
    Author     : njuser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign In</title>
        <%@include file="../cdn/cdn.jsp"%>
        <link rel="stylesheet" href="css/custom/login.css" />
    </head>
    <body>
            <div id="load"></div>
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
                                <h3 class="text-center mb-4">Sign In</h3>
                                <form id="SignInForm" name="SignIn" method="POST" class="login-form">
                                    <div class="form-group">
                                        <input
                                            type="text"
                                            class="form-control rounded-left"
                                            placeholder="Username"
                                            name="UserName"
                                            id="UserName"
                                            />
                                    </div>
                                    <div class="form-group d-flex">
                                        <input
                                            type="password"
                                            class="form-control rounded-left"
                                            placeholder="Password"
                                            name="Password"
                                            id="Password"
                                            />
                                    </div>
                                    <div class="form-group">
                                        <button
                                            type="button"
                                            class="form-control btn btn-primary rounded submit px-3"
                                            onclick="validateSignIn()"
                                            >
                                            Login
                                        </button>
                                    </div>
                                    <div class="form-group d-md-flex">
                                        <div class="w-100">
                                            <a href="javascript:void(0)" onclick="loadRecoverPassword()">Forgot Password?</a>
                                        </div>
                                        <div class="w-100 text-md-right">
                                            <a href="javascript:void(0)" onclick="loadSignUp()">Create One!</a>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
    </body>
</html>
