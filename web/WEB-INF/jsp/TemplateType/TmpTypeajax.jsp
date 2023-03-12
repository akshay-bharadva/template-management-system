<%-- 
    Document   : TmpTypeajax
    Created on : 03-Mar-2022, 5:21:03 PM
    Author     : njuser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:choose>
    <c:when test="${Action eq 'insertTmptype'}">
        <input type="hidden" name="insertTmptypeStatus" id="insertTmptypeStatus" value="${Status}">
    </c:when>
    <c:when test="${Action eq 'editTmptype'}">
        <input type="hidden" name="editTmptypeStatus" id="editTmptypeStatus" value="${Status}">
    </c:when>
    <c:when test="${Action eq 'deleteTmptype'}">
        <input type="hidden" name="deleteTmptypeStatus" id="deleteTmptypeStatus" value="${Status}">
    </c:when>
    <c:when test="${Action eq 'viewTmptype'}">
        <div id="filterTemplate">
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Template Type</th>
                            <th scope="col">Entry Date</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${TmptypeList}" var="list" varStatus="sr">
                            <tr>
                                <th scope="row">${sr.index}</th>
                                <td>${list.TEMPLATE_TYPE_NAME}</td>
                                <td>${list.ENTRY_DATE}</td>
                                <td>
                                    <c:if test="${crudAction eq 'View'}">
                                        <button type="button" class="btn btn-sm btn-primary w-100" onclick="showTmpTypeData(${list.TEMPLATE_TYPE_ID}, '${crudAction}')">
                                            View <i class="fa-solid fa-arrow-right"></i>
                                        </button>
                                    </c:if>
                                    <c:if test="${crudAction eq 'Edit'}">
                                        <button type="button" class="btn btn-sm btn-warning w-100" onclick="showTmpTypeData(${list.TEMPLATE_TYPE_ID}, '${crudAction}')">
                                            Edit <i class="fa-solid fa-pen-to-square"></i>
                                        </button>
                                    </c:if>
                                    <c:if test="${crudAction eq 'Delete'}">
                                        <button type="button" class="btn btn-sm btn-danger w-100" onclick="showTmpTypeData(${list.TEMPLATE_TYPE_ID}, '${crudAction}')">
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
