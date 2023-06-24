<%-- 
    Document   : History
    Created on : 30-Mar-2022, 4:01:20 PM
    Author     : njuser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<main class="container my-4 mb-5">
    <div class="card mb-3">
        <div class="card-header">
            History
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th scope="col">Sr No</th>
                            <th scope="col">User Name</th>
                            <th scope="col">Last Login</th>
                            <th scope="col">Login Hits</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${HistoryList}" var="list" varStatus="sn">
                            <tr>
                                <td>${sn.index + 1}</td>
                                <td>${list.USERNAME}</td>
                                <td>${list.LAST_LOGIN}</td>
                                <td>${list.LOGIN_HITS}</td>
                            </tr>  
                        </c:forEach>
                    </tbody>  
                </table>
            </div>
        </div>
</main>
