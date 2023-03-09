<%-- 
    Document   : template.jsp
    Created on : 27-Jan-2022, 2:17:29 PM
    Author     : njuser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Template Type</title>
    </head>
    <body>
        <%@include file="../header.jsp" %>
        <main class="container my-4 mb-5">
            <div id="breadcrumb">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">Admin</li>
                        <li class="breadcrumb-item">Master</li>
                        <li class="breadcrumb-item active">Template Type</li>
                    </ol>
                </nav>
            </div>
            <div id="main-content">
                <div class="card">
                    <div class="card-header">Template Type</div>
                    <div class="card-body">
                        <ul class="nav justify-content-end fs-6">
                            <li class="nav-item">
                                <a class="nav-link active" onclick="loadAddTmpType()">Add</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" onclick="loadEditTmpType('Edit')">Edit</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" onclick="loadDeleteTmpType('Delete')">Delete</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" onclick="loadViewTmpType('View')">View</a>
                            </li>
                        </ul>
                    </div>
                    <div id="loadtmptype"></div> 
                    
                </div>
                
            </div>        
        </main> 
        <%@include file="../footer.jsp" %>
    </body>
</html>
