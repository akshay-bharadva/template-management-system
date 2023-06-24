<%-- 
    Document   : template.jsp
    Created on : 27-Jan-2022, 2:17:29 PM
    Author     : njuser
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<main class="container my-4 mb-5">
    <div <c:if test="${USERTYPE eq 'USER'}">style="display: none"</c:if>>
        <div class="row">
                <div class="col">
                    <label>Templates </label><br>
                    <h3>${TemplateCount}</h3>
            </div>
            <div class="col">
                <label>Default Templates </label>
                <h3>${DefaultCount}</h3>
            </div>
        </div>
    </div>
    <div id="breadcrumb">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">Admin</li>
                <li class="breadcrumb-item">Master</li>
                <li class="breadcrumb-item active">Template</li>
            </ol>
        </nav>
    </div>
    <div id="main-content">
        <div class="card">
            <div class="card-header">Template</div>
            <div class="card-body">
                <ul class="nav justify-content-end fs-6">
                    <li class="nav-item">
                        <a class="nav-link active" onclick="loadAddTemplate()">Add</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" onclick="loadEditTemplate('Edit')">Edit</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" onclick="loadDeleteTemplate('Delete')">Delete</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" onclick="loadViewTemplate('View')">View</a>
                    </li>
                </ul>
            </div>
            <div id="loadTemplate"></div> 

        </div>

    </div>        
</main> 
