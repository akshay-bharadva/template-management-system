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
            Template Type
        </div>
        <div class="card-body">
            <input type="hidden" value="${TypeList}" name="typelist" id="typelist">
            
            <form id="Tmptypeform" name="Tmptypeform" method="POST" class="row g-3">
                <input type="hidden" value="${tmptypeId}" name="tmptypeID" id="tmptypeID">
                <input type="hidden" value="${task}" name="task" id="task">

                <div class="row g-3 mb-3">
                    <!-- Row Start-->
                    <div class="col-12">
                        <div class="row">
                            <div class="col-md-3">
                                <label for="templateType" class="form-label">Template Type</label>
                            </div>
                            <div class="col-md-9">
                                <input type="text" name="templateType" value="${TemplateType}" class="form-control"  <c:if test="${task eq 'Delete' || task eq 'View'}">disabled</c:if> id="tmptypetxt" placeholder="Enter Template Type...">
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
                </div>
                <div id="insertTmptypeFlag"></div>
                <!-- Row End -->

                <div class="text-center">
                    <c:choose>
                        <c:when test="${task eq 'Edit'}">
                            <button type="button" class="btn btn-primary" onclick="editTmptype()">Update Type</button>
                        </c:when>
                        <c:when test="${task eq 'Delete'}">
                            <button type="button" class="btn btn-primary" onclick="deleteTmpType()">Delete Type</button>
                        </c:when>
                        <c:when test="${task eq 'View'}">

                        </c:when>
                        <c:otherwise>
                            <button type="button" class="btn btn-primary" onclick="addTmptype()">Save Type</button>
                        </c:otherwise>
                    </c:choose>
                    <button type="reset" class="btn btn-primary">Reset</button>
                </div>
            </form>
        </div>
    </div>
</div>
