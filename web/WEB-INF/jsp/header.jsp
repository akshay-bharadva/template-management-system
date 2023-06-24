<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="cdn/cdn.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="/">TMS</a>
            <button
                class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown"
                aria-expanded="false"
                aria-label="Toggle navigation"
                >
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item dropdown">
                        <a
                            class="nav-link dropdown-toggle"
                            id="master"
                            role="button"
                            data-bs-toggle="dropdown"
                            aria-expanded="false"
                            >
                            Master
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="master">

                            <c:if test="${USERTYPE eq 'ADMIN'}">
                                <li><a class="dropdown-item" href="javascript:void(0)" onclick="loadTemplateType()">Template Type</a></li>
                            </c:if>
                            <li><a class="dropdown-item" href="javascript:void(0)" onclick="loadCategory()">Category Master</a></li>
                            <li><a class="dropdown-item" onclick ="loadTemplate()" href="javascript:void(0)">Template Master</a></li> <!--"template.fin?cmdAction=loadTemplate" -->
                            <!--onclick="loadTemplate()"-->
                            <c:if test="${USERTYPE eq 'ADMIN'}">
                                <li><a class="dropdown-item" href="javascript:void(0)" onclick="loadUserMaster()">User Master</a></li>
                                <li><a class="dropdown-item" href="javascript:void(0)" onclick="loadHistoryMaster()">History Master</a></li>
                            </c:if>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a
                            class="nav-link dropdown-toggle"
                            id="view"
                            role="button"
                            data-bs-toggle="dropdown"
                            aria-expanded="false"
                            >View
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="view">
                            <li><a class="dropdown-item" onclick="loadImportedData()">View Imported Data</a></li>
                            <li><a class="dropdown-item" onclick="loadGeneratedPDFData()">View Generated Pdf</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a
                            class="nav-link dropdown-toggle"
                            id="utility"
                            role="button"
                            data-bs-toggle="dropdown"
                            aria-expanded="false"
                            >Utility
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="utility">
                            <li>
                                <a class="dropdown-item" onclick ="loadPlaceholder()" href="javascript:void(0)">Upload Placeholder's Data</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <span class="navbar-text">
              <div class="dropdown">
                <button class="btn border-0 btn-sm dropdown-toggle d-flex justify-content-between align-items-center" type="button" id="dropdownMenu2" data-bs-toggle="dropdown" aria-expanded="false">
                  <span class="badge bg-secondary rounded-circle p-2 d-block me-2" style="width:25px;height:25px"><i class="fa-solid fa-user"></i></span>
                  ${USERNAME}
                </button>
                <ul class="dropdown-menu">
                  <li><button class="dropdown-item text-sm" type="button" onclick="loadProfileForm()">Profile</button></li>
                  <li><button class="dropdown-item text-sm text-danger" type="button" onclick="logoutUser()">Logout</button></li>
                </ul>
              </div>
            </span>
            </div>
        </div>
    </nav>
</header>