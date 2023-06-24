package org.apache.jsp.WEB_002dINF.jsp.Template;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class template_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/WEB-INF/jsp/Template/../header.jsp");
    _jspx_dependants.add("/WEB-INF/jsp/Template/../cdn/cdn.jsp");
    _jspx_dependants.add("/WEB-INF/jsp/Template/../footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("        <title>Template Master</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" />\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap\" rel=\"stylesheet\"/>\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.css\"/>\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\"/>\n");
      out.write("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\"/>\n");
      out.write("<link rel=\"icon\" type=\"image/svg+xml\" href=\"Asset/favicon/favicon.svg\" />\n");
      out.write("<link rel=\"icon\" type=\"image/png\" href=\"Asset/favicon/favicon.png\" />\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"css/custom/style.css\" />\n");
      out.write("\n");
      out.write("\n");
      out.write("<script defer src=\"https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.js\"></script>\n");
      out.write("<script defer src=\"js/Util/notyf/notyf.util.js\"></script>\n");
      out.write("<script defer src=\"//cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"http://test.njindiainvest.com/finlibrary/resource/ajax.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"http://test.njindiainvest.com/finlibrary/resource/validate.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"https://cdn.ckeditor.com/ckeditor5/31.1.0/classic/ckeditor.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"js/Remote/jquery.min.js\"></script>\n");
      out.write("<script src=\"js/Remote/popper.js\"></script>\n");
      out.write("<script src=\"js/Remote/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"js/Util/swal/swal.util.js\"></script>\n");
      out.write("<script src=\"js/Login/login.js\"></script>\n");
      out.write("<script src=\"js/Template/template.js\"></script>\n");
      out.write("<script src=\"js/Template/ck-editor-inject.js\"></script>\n");
      out.write("    ");
      out.write("\n");
      out.write("<header>\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"/\">TMS</a>\n");
      out.write("            <button\n");
      out.write("                class=\"navbar-toggler\"\n");
      out.write("                type=\"button\"\n");
      out.write("                data-bs-toggle=\"collapse\"\n");
      out.write("                data-bs-target=\"#navbarNavDropdown\"\n");
      out.write("                aria-controls=\"navbarNavDropdown\"\n");
      out.write("                aria-expanded=\"false\"\n");
      out.write("                aria-label=\"Toggle navigation\"\n");
      out.write("                >\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarNavDropdown\">\n");
      out.write("                <ul class=\"navbar-nav\">\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a\n");
      out.write("                            class=\"nav-link dropdown-toggle\"\n");
      out.write("                            id=\"master\"\n");
      out.write("                            role=\"button\"\n");
      out.write("                            data-bs-toggle=\"dropdown\"\n");
      out.write("                            aria-expanded=\"false\"\n");
      out.write("                            >\n");
      out.write("                            Master\n");
      out.write("                        </a>\n");
      out.write("                        <ul class=\"dropdown-menu\" aria-labelledby=\"master\">\n");
      out.write("                            <li><a class=\"dropdown-item\" href=\"template.fin?cmdAction=loadTemplate\">Template Master</a></li>\n");
      out.write("                            <!--onclick=\"loadTemplate()\"-->\n");
      out.write("                            <li><a class=\"dropdown-item\">User Master</a></li>\n");
      out.write("                            <li><a class=\"dropdown-item\">History Master</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a\n");
      out.write("                            class=\"nav-link dropdown-toggle\"\n");
      out.write("                            id=\"view\"\n");
      out.write("                            role=\"button\"\n");
      out.write("                            data-bs-toggle=\"dropdown\"\n");
      out.write("                            aria-expanded=\"false\"\n");
      out.write("                            >View\n");
      out.write("                        </a>\n");
      out.write("                        <ul class=\"dropdown-menu\" aria-labelledby=\"view\">\n");
      out.write("                            <li><a class=\"dropdown-item\">View Imported Data</a></li>\n");
      out.write("                            <li><a class=\"dropdown-item\">View Generated Pdf</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a\n");
      out.write("                            class=\"nav-link dropdown-toggle\"\n");
      out.write("                            id=\"utility\"\n");
      out.write("                            role=\"button\"\n");
      out.write("                            data-bs-toggle=\"dropdown\"\n");
      out.write("                            aria-expanded=\"false\"\n");
      out.write("                            >Utility\n");
      out.write("                        </a>\n");
      out.write("                        <ul class=\"dropdown-menu\" aria-labelledby=\"utility\">\n");
      out.write("                            <li>\n");
      out.write("                                <a class=\"dropdown-item\">Upload Placeholder's Data</a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("</header>");
      out.write("\n");
      out.write("        <main class=\"container my-4\">\n");
      out.write("            <div id=\"breadcrumb\">\n");
      out.write("                <nav aria-label=\"breadcrumb\">\n");
      out.write("                    <ol class=\"breadcrumb\">\n");
      out.write("                        <li class=\"breadcrumb-item\">Admin</li>\n");
      out.write("                        <li class=\"breadcrumb-item\">Master</li>\n");
      out.write("                        <li class=\"breadcrumb-item active\">Template</li>\n");
      out.write("                    </ol>\n");
      out.write("                </nav>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"main-content\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                    <div class=\"card-header\">Template</div>\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <ul class=\"nav justify-content-end fs-6\">\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a class=\"nav-link active\" onclick=\"loadAddTemplate()\">Add</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a class=\"nav-link\" onclick=\"loadEditTemplate('Edit')\">Edit</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a class=\"nav-link\" onclick=\"loadDeleteTemplate('Delete')\">Delete</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a class=\"nav-link\" onclick=\"loadViewTemplate('View')\">View</a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"loadTemplate\"></div>\n");
      out.write("                    <div id=\"report\"></div>\n");
      out.write("                </div>\n");
      out.write("            </div>        \n");
      out.write("        </main> \n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<footer class=\"fixed-bottom text-muted bg-light shadow-sm p-3\">\n");
      out.write("    <div class=\"container\">Created by the NJCT Team · &copy;2022</div>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
