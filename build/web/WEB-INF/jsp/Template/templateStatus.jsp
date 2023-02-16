<%-- 
    Document   : templateStatus
    Created on : 21-Feb-2022, 1:42:15 PM
    Author     : njuser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${Action eq 'insertTemplate'}">
        <input type="hidden" name="insertTemplateStatus" id="insertTemplateStatus" value="${result}">
    </c:when>
    <c:when test="${Action eq 'editTemplate'}">
        <input type="hidden" name="editTemplateStatus" id="editTemplateStatus" value="${result}">
    </c:when>
    <c:when test="${Action eq 'deleteTemplate'}">
        <input type="hidden" name="deleteTemplateStatus" id="deleteTemplateStatus" value="${result}">
    </c:when>
    <c:when test="${Action eq 'viewTemplate'}">
        <div id="filterTemplate">
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Template Type</th>
                            <th scope="col">Template Category</th>
                            <th scope="col">Subject</th>
                            <th scope="col">Entry Date</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${templateList}" var="i" varStatus="sr">
                            <tr>
                                <th scope="row">${sr.index}</th>
                                <td>${i.TEMPLATE_TYPE}</td>
                                <td>${i.CATEGORY}</td>
                                <td>${i.TITLE}</td>
                                <td>${i.ENTRY_DATE}</td>
                                <td>
                                    <c:if test="${crudAction eq 'View'}">
                                        <button type="button" class="btn btn-sm btn-primary w-100" onclick="showTemplateData('${i.TEMPLATE_TYPE}', '${i.CATEGORY}', '${crudAction}')">
                                            View <i class="fa-solid fa-arrow-right"></i>
                                        </button>
                                    </c:if>
                                    <c:if test="${crudAction eq 'Edit'}">
                                        <button type="button" class="btn btn-sm btn-warning w-100" onclick="showTemplateData('${i.TEMPLATE_TYPE}', '${i.CATEGORY}', '${crudAction}')">
                                            Edit <i class="fa-solid fa-pen-to-square"></i>
                                        </button>
                                    </c:if>
                                    <c:if test="${crudAction eq 'Delete'}">
                                        <button type="button" class="btn btn-sm btn-danger w-100" onclick="showTemplateData('${i.TEMPLATE_TYPE}', '${i.CATEGORY}', '${crudAction}')">
                                            Delete <i class="far fa-trash-alt"></i>
                                        </button>
                                    </c:if>
                                </td>
                            </tr>  
                        </c:forEach>
                    </tbody>  
                </table>

            </div>
        </div>
    </c:when>
</c:choose>
