<%-- 
    Document   : userMaster
    Created on : 25-Mar-2022, 12:56:51 PM
    Author     : njuser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<main class="container my-4 mb-5">
    <div class="row">
        <div class="col-md-6">
            <div class="card mb-3 p-3" style="background: #778beb">
                <label>Registered Users </label>
                <h3>${usercount}</h3>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card mb-3 p-3" style="background: #ea8685">
                <label>Admin </label>
                <h3>${admincount}</h3>
            </div>
        </div>
    </div>
    <div id="breadcrumb">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">Admin</li>
                <li class="breadcrumb-item">Master</li>
                <li class="breadcrumb-item active">User Master</li>
            </ol>
        </nav>
    </div>
    <div id="main-content">
        <div class="card">
            <div class="card-header">User</div>
            <div class="card-body">
                <ul class="nav justify-content-end fs-6">
                    <li class="nav-item">
                        <a class="nav-link active" onclick="loadAddUser()">Add</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" onclick="loadEditUser('Edit')">Edit</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" onclick="loadViewUser('View')">View</a>
                    </li>
                </ul>
            </div>
            <div id="loadUser"></div> 
        </div>
    </div>
</main>

