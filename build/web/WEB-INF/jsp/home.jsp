<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>TMS</title>
    <link
    
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="http://test.njindiainvest.com/finlibrary/resource/ajax.js"></script>
    <link rel="stylesheet" href="css/style.css" />
    <script src="js/Template/template.js"></script>
  </head>
  <body>
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
                    <li><a class="dropdown-item" onclick="loadTemplate()">Template Master</a></li>
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
  <main>
      <div id="load"></div>
  </main>
    <footer class="fixed-bottom text-muted bg-light shadow-sm p-3">
      <div class="container">Created by the NJCT Team · &copy;2022</div>
    </footer>
  </body>
</html>
