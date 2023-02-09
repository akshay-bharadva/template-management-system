<%-- 
    Document   : recoverPassword
    Created on : 16-Feb-2022, 3:06:11 PM
    Author     : njuser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recover Password</title>
        <%@include file="../cdn/cdn.jsp"%>
    </head>
    <body>
        <c:if test="${Action eq 'recoverpassword'}">
            <section class="ftco-section">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-md-7 col-lg-5">
                            <div class="login-wrap p-4 p-md-5">
                                <div
                                    class="icon d-flex align-items-center justify-content-center"
                                    >
                                    <span class="fa fa-key" aria-hidden="true"></span>
                                </div>
                                <h3 class="text-center mb-4">Forgot Password</h3>
                                <form action="#" class="login-form">
                                    <div class="form-group">
                                        <input
                                            type="email"
                                            class="form-control rounded-left"
                                            placeholder="Enter Email"
                                            required
                                            />
                                    </div>
                                    <div class="form-group">
                                        <button
                                            type="submit"
                                            class="form-control btn btn-primary rounded submit px-3"
                                            >
                                            Submit
                                        </button>
                                    </div>
                                    <div class="form-group d-md-flex">
                                        <div class="w-100">
                                            <a href="javascript:void(0)" onclick="loadSignIn()">Sign in Here!</a>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </c:if>
    </body>
</html>
