<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="cdn/cdn.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
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
                <ul class="navbar-nav">
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
                            <li><a class="dropdown-item">User Master</a></li>
                            <li><a class="dropdown-item">History Master</a></li>
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
                            <li><a class="dropdown-item">View Imported Data</a></li>
                            <li><a class="dropdown-item">View Generated Pdf</a></li>
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
                                <a class="dropdown-item">Upload Placeholder's Data</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>