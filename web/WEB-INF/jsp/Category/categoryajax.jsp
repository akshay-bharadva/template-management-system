<%-- 
    Document   : categoryajax
    Created on : 24-Feb-2022, 11:07:30 AM
    Author     : njuser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<c:choose>
    <c:when test="${Action eq 'insertCategory'}">
        <input type="hidden" name="insertCategoryStatus" id="insertCategoryStatus" value="${Status}">
    </c:when>
    <c:when test="${Action eq 'editCategory'}">
        <input type="hidden" name="editCategoryStatus" id="editCategoryStatus" value="${Status}">
    </c:when>
    <c:when test="${Action eq 'deleteCategory'}">
        <input type="hidden" name="deleteCategoryStatus" id="deleteCategoryStatus" value="${Status}">
    </c:when>
    <c:when test="${Action eq 'viewCategory'}">
        <div id="filterTemplate">
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Template Type</th>
                            <th scope="col">Category Name</th>
                            <th scope="col">Entry Date</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${CategoryList}" var="list" varStatus="sr">
                            <tr>
                                <th scope="row">${sr.index}</th>
                                
                                <td>${list.TEMPLATE_TYPE_NAME}</td>
                                <td>${list.CATEGORY_NAME}</td>
                                <td>${list.ENTRY_DATE}</td>
                                <td>
                                    <c:if test="${crudAction eq 'View'}">
                                        <button type="button" class="btn btn-sm btn-primary w-100" onclick="showCategoryData(${list.CATEGORY_ID}, '${crudAction}')">
                                            View <i class="fa-solid fa-arrow-right"></i>
                                        </button>
                                    </c:if>
                                    <c:if test="${crudAction eq 'Edit'}">
                                        <button type="button" class="btn btn-sm btn-warning w-100" onclick="showCategoryData(${list.CATEGORY_ID}, '${crudAction}')">
                                            Edit <i class="fa-solid fa-pen-to-square"></i>
                                        </button>
                                    </c:if>
                                    <c:if test="${crudAction eq 'Delete'}">
                                        <button type="button" class="btn btn-sm btn-danger w-100" onclick="showCategoryData(${list.CATEGORY_ID}, '${crudAction}')">
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
