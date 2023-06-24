<%-- 
    Document   : UserProfile
    Created on : 01-Apr-2022, 4:11:51 PM
    Author     : njuser
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:choose>
    <c:when test="${Action eq 'loadProfile'}">
        <div class="container my-4">
            <div class="card mb-3">
                <div class="card-header">
                    User Profile
                </div>
                <div class="card-body">
                    <div class="row g-3 mb-4">
                    <div class="col-8 mx-auto">    
                            
                        <form id="userProfileForm" name="userProfileForm" method="POST" class="row g-3">    
                            <div class="col-12">
                                <div class="row">
                                    <div class="col-md-3">
                                        <label for="txtFname" class="form-label">
                                            First Name</label>
                                    </div>
                                    <div class="col-md-9">
                                        <input
                                            type="text"
                                            class="form-control"
                                            placeholder="Enter First Name..."
                                            id="txtFname"
                                            name="txtFname"
                                            value="${fname}"
                                            />
                                    </div>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="row">
                                    <div class="col-md-3">
                                        <label for="txtLname" class="form-label">
                                            Last Name</label>
                                    </div>
                                    <div class="col-md-9">
                                        <input
                                            type="text"
                                            class="form-control"
                                            placeholder="Enter Last Name..."
                                            id="txtLname"
                                            name="txtLname"
                                            value="${lname}"
                                            />
                                    </div>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="row">
                                    <div class="col-md-3">
                                        <label for="dob" class="form-label">
                                            Date Of Birth</label>
                                    </div>
                                    <div class="col-md-9">
                                        <input
                                            type="text"
                                            class="form-control"
                                            placeholder="DD-MM-YYYY"
                                            id="dob"
                                            name="dob"
                                            value="${dob}"
                                            
                                            />
                                    </div>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="row">
                                    <div class="col-md-3">
                                        <label for="mobNo" class="form-label">
                                            Mobile Number</label>
                                    </div>
                                    <div class="col-md-9">
                                        <input
                                            type="text"
                                            class="form-control"
                                            placeholder="Enter Mobile Number ..."
                                            id="mobNo"
                                            name="mobNo"
                                            value="${mobNo}"
                                            />
                                    </div>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="row">
                                    <div class="col-md-3">
                                        <label for="active" class="form-label">Gender</label>
                                    </div>
                                    <div class="col-md-9">
                                        <c:choose>
                                            <c:when test="${gender eq 'MALE'}">
                                                <div class="form-check form-check-inline">
                                                    <input
                                                        class="form-check-input"
                                                        type="radio"
                                                        name="gender"
                                                        id="yes"
                                                        value="MALE"
                                                        checked
                                                        />
                                                    <label class="form-check-label" for="yes">Male</label>

                                                </div>
                                                <div class="form-check form-check-inline">
                                                    <input
                                                        class="form-check-input"
                                                        type="radio"
                                                        name="gender"
                                                        id="no"
                                                        value="FEMALE"
                                                        />
                                                    <label class="form-check-label" for="no">Female</label>
                                                </div>
                                            </c:when>
                                            <c:when test="${gender eq 'FEMALE'}">
                                                <div class="form-check form-check-inline">
                                                    <input
                                                        class="form-check-input"
                                                        type="radio"
                                                        name="gender"
                                                        id="MALE"
                                                        value="MALE"

                                                        />
                                                    <label class="form-check-label" for="yes">Male</label>

                                                </div>
                                                <div class="form-check form-check-inline">
                                                    <input
                                                        class="form-check-input"
                                                        type="radio"
                                                        name="gender"
                                                        id="FEMALE"
                                                        value="FEMALE"
                                                        checked
                                                        />
                                                    <label class="form-check-label" for="no">Female</label>
                                                </div>
                                            </c:when>
                                            <c:otherwise>

                                                <div class="form-check form-check-inline">
                                                    <input
                                                        class="form-check-input"
                                                        type="radio"
                                                        name="gender"
                                                        id="MALE"
                                                        value="MALE"
                                                        checked
                                                        />
                                                    <label class="form-check-label" for="yes">Male</label>

                                                </div>
                                                <div class="form-check form-check-inline">
                                                    <input
                                                        class="form-check-input"
                                                        type="radio"
                                                        name="gender"
                                                        id="FEMALE"
                                                        value="FEMALE"
                                                        />
                                                    <label class="form-check-label" for="no">Female</label>
                                                </div>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>  
                                </div> 
                            </div>
                            <div class="text-center">
                                <button type="button" class="btn btn-primary" onclick="submitProfile()">Edit User Profile</button>
                                <button type="reset" class="btn btn-primary" onclick="" >Reset</button>
                            </div>
                        </form>
                    
                    </div> 
                    </div> 
                    <div id="profileStatus">
                        
                    </div>
                </div>
            </div> 
        </div>
    </c:when>
    <c:when test="${Action eq 'updateProfile'}">
        <input type="hidden" id="updateProfileStatus" name="updateProfileStatus" value="${updateStatus}"> 
    </c:when>
</c:choose>
