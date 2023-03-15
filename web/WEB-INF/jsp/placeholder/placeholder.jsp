<%-- 
    Document   : placeholder
    Created on : 15-Mar-2022, 2:11:35 PM
    Author     : njuser
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container my-4">
    <div class="card mb-3">
        <div class="card-header">
            UPLOAD PLACEHOLDER DATA
        </div>
        <div class="card-body">
            <div class="row mb-4">
                <div class="col-6">
                    <select class="form-select" id="cmbTemplateType" name="cmbTemplateType" onchange="showTemplateReport()">
                        <option selected="" value="0">All Templates</option>
                        <c:if test="${status eq '1'}">
                            <c:forEach items="${templateTypeList}" var="i">
                                <option value="${i.TEMPLATE_TYPE_ID}">${i.TEMPLATE_TYPE_NAME}</option>
                            </c:forEach>
                        </c:if>
                        <c:if test="${status eq '0'}">
                            <option disabled>NO RECORD FOUND</option>
                        </c:if>    
                    </select>
                </div>
                <div class="col-6" id="TemplateCategoryBlock">
                    <select class="form-select" id="cmbTemplateCategory" name="cmbTemplateCategory" onchange="showTemplateReport()">
                        <option selected="" value="0">All Categories</option>
                        <c:if test="${status eq '1'}">
                            <c:forEach items="${templateTypeList}" var="i">
                                <option value="${i.CATEGORY_ID}">${i.CATEGORY_NAME}</option>
                            </c:forEach>
                        </c:if>
                        <c:if test="${status eq '0'}">
                            <option disabled>NO RECORD FOUND</option>
                        </c:if>
                    </select>
                </div>
            </div> 
            <div id="filterTemplate">
                <div id="report"></div>
            </div>
        </div>
    </div> 
</div>



