<%-- 
    Document   : addTemplate
    Created on : 19-Feb-2022, 4:58:19 PM
    Author     : njuser
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="container my-4">
    <div class="card mb-3">
        <div class="card-header">
            <c:choose>
                <c:when test="${task eq 'Edit'}">
                    Edit
                </c:when>
                <c:when test="${task eq 'Delete'}">
                    Delete
                </c:when>
                <c:when test="${task eq 'View'}">
                    View
                </c:when>
                <c:otherwise>
                    Insert
                </c:otherwise>
            </c:choose>
            Category
        </div>
        <div class="card-body">
            <input type="hidden" value="${categorylist}" name="categoryList" id="categoryList">
            <form id="Categoryform" name="Categoryform" method="POST" class="row g-3">
                <input type="hidden" value="${task}" name="task" id="task">
                <input type="hidden" value="${categoryID}" name="categoryID" id="categoryID">
                
                <div class="row g-3 mb-3">
                    <!-- Row Start-->
                    <div class="col-12">
                        <div class="row">
                            <div class="col-md-3">
                                <label for="templateType" class="form-label"
                                       >Template Type</label
                                >
                            </div>
                            <div class="col-md-9">
                                <select class="form-select" id="cmbTemplateType" name="cmbTemplateType" onchange="onloadtype(this.value)" <c:if test="${task eq 'Delete' || task eq 'View'}">disabled</c:if>>
                                    <option selected value="0" disabled>
                                        Select Template
                                    </option>
                                    <c:forEach items="${tmptypelist}" var="list">
                                        <option value="${list.TEMPLATE_TYPE_ID}"<c:if test="${TMPID eq list.TEMPLATE_TYPE_ID}">selected</c:if>>${list.TEMPLATE_TYPE_NAME}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-12">
                        <div class="row">
                            <div class="col-md-3">
                                <label for="category" class="form-label">Add Category</label>
                            </div>
                            <div class="col-md-9" id="categorytxt">
                                <input type="text" name="category" class="form-control" value="${Category}" <c:if test="${task eq 'Delete' || task eq 'View'}">disabled</c:if> id="txtCategory" placeholder="Enter Category...">
                            </div>
                        </div>
                    </div>
                    <div class="col-12">
                        <div class="row">
                            <div class="col-md-3">
                                <label for="active" class="form-label">Is Active?</label>
                            </div>
                            <div class="col-md-9">
                                <c:choose>
                                    <c:when test="${IsActive eq '0'}">
                                        <div class="form-check form-check-inline">
                                            <input
                                                class="form-check-input"
                                                type="radio"
                                                name="chkActive"
                                                id="yes"
                                                value="1"
                                                <c:if test="${task eq 'Delete' || task eq 'View'}">disabled</c:if>
                                                />
                                            <label class="form-check-label" for="yes">Yes</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input
                                                class="form-check-input"
                                                type="radio"
                                                name="chkActive"
                                                id="no"
                                                value="0"
                                                checked
                                                <c:if test="${task eq 'Delete' || task eq 'View'}">disabled</c:if>
                                                />
                                            <label class="form-check-label" for="no">No</label>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="form-check form-check-inline">
                                            <input
                                                class="form-check-input"
                                                type="radio"
                                                name="chkActive"
                                                id="yes"
                                                value="1"
                                                checked
                                                <c:if test="${task eq 'Delete' || task eq 'View'}">disabled</c:if>
                                                />
                                            <label class="form-check-label" for="yes">Yes</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input
                                                class="form-check-input"
                                                type="radio"
                                                name="chkActive"
                                                id="no"
                                                value="0"
                                                <c:if test="${task eq 'Delete' || task eq 'View'}">disabled</c:if>
                                                />
                                            <label class="form-check-label" for="no">No</label>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>        
                    <c:if test="${USERTYPE eq 'ADMIN'}">
                        <div class="col-12">
                            <div class="row">
                                <div class="col-md-3">
                                    <label for="active" class="form-label" <c:if test="${task eq 'Delete' || task eq 'View'}">disabled</c:if>>Is Default?</label>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-check form-check-inline">
                                        <input type="checkbox" name="isdefaultTemplate" id="isdefaultTemplate" value="1" <c:if test="${defaultTemplate eq '1'}">checked</c:if> <c:if test="${task eq 'Delete' || task eq 'View'}">disabled</c:if>>
                                    </div>
                                </div>
                            </div>          
                        </div>
                    </c:if>         
                </div>
                <div id="insertCategoryFlag"></div>
                <!-- Row End -->

                <div class="text-center">
                    <c:choose>
                        <c:when test="${task eq 'Edit'}">
                            <button type="button" class="btn btn-primary" onclick="editCategory()">Edit Category</button>
                        </c:when>
                        <c:when test="${task eq 'Delete'}">
                            <button type="button" class="btn btn-primary" onclick="deleteCategory()">Delete Category</button>
                        </c:when>
                        <c:when test="${task eq 'View'}">
                            
                        </c:when>
                        <c:otherwise>
                            <button type="button" class="btn btn-primary" onclick="addCategory()">Save Category</button>
                        </c:otherwise>
                    </c:choose>
                            <button type="reset" class="btn btn-primary"<c:if test="${task eq 'Delete' || task eq 'View'}">style="display: none"</c:if>>Reset</button>
                </div>
            </form>
        </div>
    </div>
</div>
