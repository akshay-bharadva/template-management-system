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
                <c:when test="${task eq 'Edit'}">Edit</c:when>
                <c:when test="${task eq 'Delete'}">Delete</c:when>
                <c:when test="${task eq 'View'}">View</c:when>
                <c:otherwise>Insert</c:otherwise>
            </c:choose>
            Template
        </div>
        <div class="card-body">
            <form id="templateForm" name="templateForm" method="POST" class="row g-3">
                <input type="hidden" value="${TemplateId}" name="hdnTemplateId" id="hdnTemplateId">
                <input type="hidden" value="${task}" name="task" id="task">
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
                                <select class="form-select" id="cmbTemplateType" name="cmbTemplateType" onchange="loadTemplateType(this.value)" <c:if test="${task eq 'Delete' || task eq 'View' || task eq 'Edit'}">disabled</c:if>>
                                            <option selected value="0" disabled>
                                                Select Template Type
                                            </option>
                                            <c:forEach items="${templateType}" var="i">
                                                <option value="${i.TEMPLATE_TYPE_ID}" <c:if test="${Type eq i.TEMPLATE_TYPE_ID}"> selected </c:if>>${i.TEMPLATE_TYPE_NAME}</option>
                                            </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-12" id="categoryblock">
                        <div class="row">
                            <div class="col-md-3">
                                <label for="category" class="form-label">Category</label>
                            </div>
                            <div class="col-md-9">
                                <select class="form-select" id="categorysel" name="categorysel" <c:if test="${task eq 'Delete' || task eq 'View' || task eq 'Edit'}">disabled</c:if>>
                                    <option value="0" disabled>Select Category</option>
                                    <option value="${CategoryId}" selected>${CategoryName}</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-12">
                        <div class="row">
                            <div class="col-md-3">
                                <label for="subject" class="form-label"
                                       >Template Subject</label
                                >
                            </div>
                            <div class="col-md-9">
                                <input
                                    type="text"
                                    class="form-control"
                                    placeholder="Enter Subject..."
                                    id="txtSubject"
                                    name="txtSubject"
                                    value="${Subject}"
                                    <c:if test="${task eq 'Delete' || task eq 'View'}">readonly</c:if>
                                    />
                            </div>
                        </div>
                    </div>
                    <div class="col-12">
                        <div class="row">
                            <div class="col-md-3">
                                <label for="body" class="form-label">Template Body</label>
                            </div>
                            <div class="col-md-9">
                                <textarea
                                    class="form-control"
                                    placeholder="Enter Template Body..."
                                    name="txtBody"
                                    id="txtBody"
                                    style="min-height: 350px"
                                    <c:if test="${task eq 'Delete' || task eq 'View'}">readonly</c:if>
                                    >${Body}</textarea>
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
                                    <c:when test="${Default eq '0'}">
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
                <div id="insertTemplateFlag"></div>
                <!-- Row End -->

                <div class="text-center">
                    <c:choose>
                        <c:when test="${task eq 'Edit'}">
                            <button type="button" class="btn btn-primary" onclick="editTemplate()">Edit Template</button>
                        </c:when>
                        <c:when test="${task eq 'Delete'}">
                            <button type="button" class="btn btn-primary" onclick="deleteTemplate()">Delete Template</button>
                        </c:when>
                        <c:when test="${task eq 'View'}">
                            
                        </c:when>
                        <c:when test="${task eq 'Default'}">
                            <button type="button" class="btn btn-primary" onclick="addTemplate()">Save Template</button>
                        </c:when>   
                        <c:otherwise>
                            <button type="button" class="btn btn-primary" onclick="addTemplate()">Save Template</button>
                            <button type="reset" class="btn btn-primary" onclick="formReset()" >Reset</button>
                        </c:otherwise>
                    </c:choose>
                    
                </div>
            </form>
        </div>
    </div>
</div>
