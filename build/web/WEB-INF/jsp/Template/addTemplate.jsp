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
        <div class="card-header">Insert Template</div>
        <div class="card-body">
            <form id="templateForm" name="templateForm" method="POST" class="row g-3">
                <input type="hidden" value="${hdnTemplateType}" name="hdnTemplateType" id="hdnTemplateType">
                <input type="hidden" value="${hdnTemplateCategory}" name="hdnTemplateCategory" id="hdnTemplateCategory">
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
                                    <c:choose>
                                        <c:when test="${Type eq 'SMS'}">
                                            <option value="Letter">Letter</option>
                                            <option value="Email" >Email</option>
                                            <option selected value="SMS">Message</option>
                                        </c:when>
                                        <c:when test="${Type eq 'LETTER'}">
                                            <option selected value="Letter">Letter</option>
                                            <option value="Email" >Email</option>
                                            <option value="SMS">Message</option>
                                        </c:when>
                                        <c:when test="${Type eq 'EMAIL'}">
                                            <option  value="Letter">Letter</option>
                                            <option selected value="Email" >Email</option>
                                            <option value="SMS">Message</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option selected value="0" disabled>
                                                Select Category
                                            </option>
                                            <option value="Letter">Letter</option>
                                            <option value="Email" >Email</option>
                                            <option value="SMS">Message</option>
                                        </c:otherwise>                                           
                                    </c:choose>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-12">
                        <div class="row">
                            <div class="col-md-3">
                                <label for="category" class="form-label">Category</label>
                            </div>
                            <div class="col-md-9" id="cmbCategory" <c:if test="${Type ne 'LETTER'}">style="display:none;"</c:if>>
                                <select class="form-select" id="categorysel" name="categorysel" <c:if test="${task eq 'Delete' || task eq 'View' || task eq 'Edit'}">disabled</c:if>>
                                <c:choose>
                                <c:when test="${Category eq 'FULLCLOSURE'}">
                                    <option value="WELCOMELETTER">Welcome Letter</option>
                                    <option value="PARTIALCLOSURE">Partial Closure Letter</option>
                                    <option value="FULLCLOSURE" selected>Full Closure Letter</option>
                                    <option value="NOTES">Notes to accounts For Bulk Printing</option>
                                    <option value="COVERLETTER">Covering letter for Bulk Printing</option>
                                    <option value="CACERTIFICATE">CA Certificate for Bulk Printing</option>
                                </c:when>
                                <c:when test="${Category eq 'PARTIALCLOSURE'}">
                                    <option value="WELCOMELETTER">Welcome Letter</option>
                                    <option value="PARTIALCLOSURE" selected>Partial Closure Letter</option>
                                    <option value="FULLCLOSURE">Full Closure Letter</option>
                                    <option value="NOTES">Notes to accounts For Bulk Printing</option>
                                    <option value="COVERLETTER">Covering letter for Bulk Printing</option>
                                    <option value="CACERTIFICATE">CA Certificate for Bulk Printing</option>
                                </c:when>
                                <c:when test="${Category eq 'NOTES'}">
                                    <option value="WELCOMELETTER">Welcome Letter</option>
                                    <option value="PARTIALCLOSURE">Partial Closure Letter</option>
                                    <option value="FULLCLOSURE">Full Closure Letter</option>
                                    <option value="NOTES" selected>Notes to accounts For Bulk Printing</option>
                                    <option value="COVERLETTER">Covering letter for Bulk Printing</option>
                                    <option value="CACERTIFICATE">CA Certificate for Bulk Printing</option>
                                </c:when>
                                <c:when test="${Category eq 'COVERLETTER'}">
                                    <option value="WELCOMELETTER">Welcome Letter</option>
                                    <option value="PARTIALCLOSURE">Partial Closure Letter</option>
                                    <option value="FULLCLOSURE">Full Closure Letter</option>
                                    <option value="NOTES">Notes to accounts For Bulk Printing</option>
                                    <option value="COVERLETTER" selected>Covering letter for Bulk Printing</option>
                                    <option value="CACERTIFICATE">CA Certificate for Bulk Printing</option>
                                </c:when>
                                <c:when test="${Category eq 'CACERTIFICATE'}">
                                    <option value="WELCOMELETTER">Welcome Letter</option>
                                    <option value="PARTIALCLOSURE">Partial Closure Letter</option>
                                    <option value="FULLCLOSURE">Full Closure Letter</option>
                                    <option value="NOTES">Notes to accounts For Bulk Printing</option>
                                    <option value="COVERLETTER" selected>Covering letter for Bulk Printing</option>
                                    <option value="CACERTIFICATE" selected>CA Certificate for Bulk Printing</option>
                                </c:when>
                                <c:when test="${Category eq 'PARTIALSTRGYSWITCH'}">
                                    <option value="PARTIALSTRGYSWITCH">Partial Strategy Switch Letter</option>                                   
                                </c:when>
                                <c:when test="${Category eq 'FULLSTRGYSWITCH'}">
                                    <option value="FULLSTRGYSWITCH">Full Strategy Switch Letter</option>                                                     
                                </c:when>                                    
                                <c:when test="${Category eq 'QUARTRPTCOVER'}">
                                    <option value="QUARTRPTCOVER">Quarterly Report Cover Letter</option>                                                     
                                </c:when>                                    
                                <c:when test="${Category eq 'QUARTPRTNOTESACC'}">
                                    <option value="QUARTPRTNOTESACC">Quarterly Report Notes To Account</option>                                                     
                                </c:when>                                   
                                <c:when test="${Category eq 'FULLCLOSUNITTRANSFR'}">
                                    <option value="FULLCLOSUNITTRANSFR">Full Closure Through Unit Transfer Letter</option>                                                     
                                </c:when>    
                                <c:otherwise>
                                    <option selected value="0" disabled>
                                        Select Category
                                    </option>
                                    <option value="WELCOMELETTER">Welcome Letter</option>
                                    <option value="PARTIALCLOSURE">Partial Closure Letter</option>
                                    <option value="FULLCLOSURE">Full Closure Letter</option>
                                    <option value="FULLCLOSUNITTRANSFR">Full Closure Through Unit Transfer Letter</option>
                                    <option value="NOTES">Notes to accounts For Bulk Printing</option>
                                    <option value="COVERLETTER">Covering letter for Bulk Printing</option>
                                    <option value="CACERTIFICATE">CA Certificate for Bulk Printing</option>
                                    <option value="PARTIALSTRGYSWITCH">Partial Strategy Switch Letter</option>                                   
                                    <option value="FULLSTRGYSWITCH">Full Strategy Switch Letter</option> 
                                    <option value="QUARTRPTCOVER">Quarterly Report Cover Letter</option> 
                                    <option value="QUARTPRTNOTESACC">Quarterly Report Notes To Account</option>                                                                          
                                </c:otherwise> 
                            </c:choose>
                                </select>
                            </div>
                                <div class="col-md-9" id="categorytxt" <c:if test="${Type eq 'LETTER'}">style="display:none;"</c:if>>
                                <input
                                    type="text"
                                    class="form-control"
                                    placeholder="Enter Category..."
                                    id="txtCategory"
                                    name="txtCategory"
                                    value ="${Category}"
                                    <c:if test="${task eq 'Delete' || task eq 'View' || task eq 'Edit' }">readonly</c:if>
                                    />
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
                </div>
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
                        <c:otherwise>
                            <button type="button" class="btn btn-primary" onclick="addTemplate()">Save Template</button>
                        </c:otherwise>
                    </c:choose>
                    <button type="reset" class="btn btn-primary">Reset</button>
                </div>
            </form>
        </div>
    </div>
</div>
