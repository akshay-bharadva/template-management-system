<%-- 
    Document   : UserMaterAjax
    Created on : 28-Mar-2022, 12:55:39 PM
    Author     : njuser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:if test="${Action eq 'Adduser'}">
    <input type="hidden" id="adduserstatus" name="adduserstatus" value="${AddStatus}">
</c:if>
<c:if test="${Action eq 'Edituser'}">
    <input type="hidden" id="updateuserstatus" name="updateuserstatus" value="${updateStatus}">
</c:if>
<c:if test="${Action eq 'Deleteuser'}">
    <input type="hidden" id="deleteuserstatus" name="deleteuserstatus" value="${deleteStatus}">
    Hiii
</c:if>
<c:if test="${Action eq 'ViewUser'}">
    <c:if test="${status eq '1'}">
        <div id="filterUser">
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th scope="col">User Code</th>
                            <th scope="col">User Name</th>
                            <th scope="col">Email</th>
                            <th scope="col">Type</th>
                                <%--<th scope="col">Last Login</th>--%>
                            <th scope="col">Action</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${userlist}" var="list">
                            <tr>
                                <td>${list.USERCODE}</td>
                                <td>${list.USERNAME}</td>
                                <td>${list.EMAIL}</td>
                                <%--<td>${list.LAST_LOGIN}</td>--%>
                                <td>${list.TYPE}</td>
                                <c:if test="${crudAction eq 'Edit'}">
                                    <td>
                                        <button type="button" class="btn btn-sm btn-warning w-100" onclick="editUserByAdmin('${list.USERCODE}', '${crudAction}')">
                                            Edit <i class="fa-solid fa-pen-to-square"></i>
                                        </button>
                                    </td>
                                </c:if>
                                <c:if test="${crudAction eq 'Delete'}">
                                    <td>
                                        <button type="button" class="btn btn-sm btn-danger w-100" onclick="editUserByAdmin('${list.USERCODE}', '${crudAction}')">
                                            Delete <i class="far fa-trash-alt"></i>
                                        </button>
                                    </td>
                                </c:if> 
                                <c:if test="${crudAction eq 'View'}">
                                    <td>
                                        <button type="button" class="btn btn-sm btn-primary w-100" onclick="editUserByAdmin('${list.USERCODE}', '${crudAction}')">
                                            View <i class="fa-solid fa-arrow-right"></i>
                                        </button>
                                    </td>
                                </c:if>   
                            </tr>  
                        </c:forEach>
                    </tbody>  
                </table>
            </div>
        </div>
    </c:if>
</c:if>