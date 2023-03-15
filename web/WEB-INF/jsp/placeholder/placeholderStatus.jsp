<%-- 
    Document   : placeholderStatus
    Created on : 15-Mar-2022, 6:03:31 PM
    Author     : njuser
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:choose>
    <c:when test="${Action eq 'viewTemplateReport'}">
        <c:if test="${status eq '1'}">
            <div id="filterTemplate">
                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Template Type</th>
                                <th scope="col">Template Category</th>
                                <th scope="col">Subject</th>
                                <th scope="col">Entry Date</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${templateList}" var="i">
                                <tr>
                                    <td>${i.TEMPLATE_TYPE_NAME}</td>
                                    <td>${i.CATEGORY_NAME}</td>
                                    <td>${i.TITLE}</td>
                                    <td>${i.ENTRY_DATE}</td>
                                    <td>
                                        <button type="button" class="btn btn-sm btn-primary w-100" onclick="loadDetailTemplateWithUploadBtn('${i.TEMPLATE_ID}')">
                                            Generate <i class="fa-solid fa-arrow-right"></i>
                                        </button>
                                    </td>
                                </tr>  
                            </c:forEach>
                        </tbody>  
                    </table>

                </div>
            </div>
        </c:if>
        <c:if test="${status eq '0'}">
            <div class="card">
                <div class="card-body">
                    <blockquote class="blockquote mb-0">
                        <p align="center">NO RECORD FOUND</p>
                    </blockquote>
                </div>
            </div>
        </c:if>
    </c:when>
    <c:when test="${Action eq 'categoryList'}">
        <c:if test="${status eq '1'}">
            <option selected value= "0" > All Categories</option>
            <c:forEach items="${categoryTypeList}" var="i">
                <option value="${i.CATEGORY_ID}">${i.CATEGORY_NAME}</option>
            </c:forEach>
        </c:if>
        <c:if test="${status eq '0'}">
            <option disabled>NO RECORD FOUND</option>
        </c:if>
    </c:when>

    <c:when test="${Action eq 'templateDataList'}">
        <c:if test="${status eq '1'}">
            <c:forEach items="${templateData}" var="i">
                <div class="container my-4">
                    <div class="card mb-3">
                        <div class="card-header">Template File Format & Upload Data</div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="card">
                                        <div class="card-body">
<!--                                            <h5 class="card-title">TEMPLATE TYPE :- ${i.TEMPLATE_TYPE_NAME}</h5>
                                            <h5 class="card-title">TEMPLATE CATEGORY :- ${i.CATEGORY_NAME}</h5>-->
                                            <h6 class="card-title"><span class="text-muted">Preview of </span><b>${i.TITLE}</b></h6>
                                            <p class="card-text">
                                                ${i.BODY}
                                            </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="d-flex">
                                        <button class="btn btn-primary w-50 m-2" onclick="downloadFileFormat('${fileName}')">Download File Format</button>
                                        <button class="btn btn-primary w-50 m-2" onclick="loadUploadFile()">Upload Data</button>
                                        
                                    </div>
                                    <div class="card-body" id="loadFileUpload" style="display: none;">
                                        <form method="POST" action="" id="excelfileform" name="excelfileform" enctype="multipart/form-data">
                                            <div class="input-group">
                                                <input type="file" class="form-control" name="fileupload" id="fileUpload" aria-describedby="inputGroupFileAddon04" onchange="validateFile()" aria-label="Upload">
                                            </div>
                                            <br>
                                            <div class="input-group">
                                                <button class="btn btn-outline-secondary" type="button" id="inputGroupFileAddon04" onclick="uploadFile()">Upload File</button>
                                            </div>
                                        </form>  
                                    </div>
                                        
                                </div>
                            </div>
                        </div>
                    </div>  
                </div>                        
            </c:forEach>
        </c:if>

    </c:when>


</c:choose>

