<%-- 
    Document   : editTemplate
    Created on : 21-Feb-2022, 11:22:37 AM
    Author     : njuser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container my-4">
    <div class="card mb-3">
        <div class="card-header">
            <c:if test="${action eq 'Edit'}">
                Edit
            </c:if>
            <c:if test="${action eq 'Delete'}">
                Delete
            </c:if>
            <c:if test="${action eq 'View'}">
                View
            </c:if>
            Category
        </div>
        <%-- Edit  --%>
        <div class="card-body">
            <div class="row mb-4">
                <div class="col-7"></div>
                <div class="col-5">
                    <select class="form-select" id="cmbFilterType" name="cmbFilterType" onchange="showCategoryReport(this.value)">
                        <option selected="" value="0">All Templates</option>
                        <c:forEach items="${tmptypelist}" var="list">
                            <option value="${list.TEMPLATE_TYPE_ID}">${list.TEMPLATE_TYPE_NAME}</option>
                        </c:forEach> 
                    </select>
                </div>
            </div> 
            <div id="filerCategory">
                <div id="categoryreport"></div>
            </div>
        </div>
    </div> 
    <input type="hidden" id="action" name="action" value="${action}">
</div>
