package org.apache.jsp.WEB_002dINF.jsp.Login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signUp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/jsp/Login/../cdn/cdn.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <title>Register</title>\n");
      out.write("    <meta charset=\"utf-8\" />\n");
      out.write("    <link rel=\"icon\" type=\"image/svg+xml\" href=\"Asset/favicon/favicon.svg\" />\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" href=\"Asset/favicon/favicon.png\" />\n");
      out.write("    <meta\n");
      out.write("      name=\"viewport\"\n");
      out.write("      content=\"width=device-width, initial-scale=1, shrink-to-fit=no\"\n");
      out.write("    />\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/custom/style.css\" />\n");
      out.write("    <script src=\"//cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\n");
      out.write("\n");
      out.write("    <!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css\"> -->\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.css\"/>\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\"/>\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap\" rel=\"stylesheet\"/>\n");
      out.write("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\"/>\n");
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
      out.write("<script src=\"http://test.njindiainvest.com/finlibrary/resource/validate.js\"></script>");
      out.write("\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div id=\"load\">\n");
      out.write("        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("  </div>        \n");
      out.write("\n");
      out.write("    <script src=\"js/jquery.min.js\"></script>\n");
      out.write("    <script src=\"js/popper.js\"></script>\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"js/main.js\"></script>\n");
      out.write("    <script src=\"swal/swal.util.js\"></script>\n");
      out.write("    <script src=\"js/Login/login.js\"></script>\n");
      out.write("    <!-- <script src=\"https://cdnjs.cloudflare.com/ajax/libs/toastify-js/1.11.2/toastify.js\" integrity=\"sha512-aieEASdA6UHnmrjaXnn7GTrPl2HmlTC924jZ1e5z0pD5vx0hGsoOYPtnnG1KjFqcvq5MGZBBL1dmgIe1TfLzNw==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\"></script> -->\n");
      out.write("  </body>\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Action eq 'signup'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            <input type=\"hidden\" name=\"RegisterStatus\" id=\"RegisterStatus\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${status}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\n");
        out.write("            <section class=\"ftco-section\">\n");
        out.write("                <div class=\"container\">\n");
        out.write("                    <div class=\"row justify-content-center\">\n");
        out.write("                        <div class=\"col-md-7 col-lg-5\">\n");
        out.write("                            <div class=\"login-wrap p-4 p-md-5\">\n");
        out.write("                                <div\n");
        out.write("                                    class=\"icon d-flex align-items-center justify-content-center\"\n");
        out.write("                                    >\n");
        out.write("                                    <span class=\"fa fa-user-o\"></span>\n");
        out.write("                                </div>\n");
        out.write("                                <h3 class=\"text-center mb-4\">Register</h3>\n");
        out.write("                                <form id=\"RegisterForm\" name=\"Register\" method=\"POST\" class=\"login-form\">\n");
        out.write("                                    <div class=\"form-group\">\n");
        out.write("                                        <input\n");
        out.write("                                            type=\"text\"\n");
        out.write("                                            class=\"form-control rounded-left\"\n");
        out.write("                                            placeholder=\"Email\"\n");
        out.write("                                            name=\"Email\"\n");
        out.write("                                            \n");
        out.write("                                            />\n");
        out.write("                                    </div>\n");
        out.write("                                    <div class=\"form-group\">\n");
        out.write("                                        <input\n");
        out.write("                                            type=\"text\"\n");
        out.write("                                            class=\"form-control rounded-left\"\n");
        out.write("                                            placeholder=\"Username\"\n");
        out.write("                                            name=\"UserName\"\n");
        out.write("                                            \n");
        out.write("                                            />\n");
        out.write("                                    </div>\n");
        out.write("                                    <div class=\"form-group d-flex\">\n");
        out.write("                                        <input\n");
        out.write("                                            type=\"password\"\n");
        out.write("                                            class=\"form-control rounded-left\"\n");
        out.write("                                            placeholder=\"Password\"\n");
        out.write("                                            name=\"Password\"\n");
        out.write("                                            \n");
        out.write("                                            />\n");
        out.write("                                    </div>\n");
        out.write("                                    <div class=\"form-group\">\n");
        out.write("                                        <button\n");
        out.write("                                            type=\"submit\"\n");
        out.write("                                            class=\"form-control btn btn-primary rounded submit px-3\"\n");
        out.write("                                            onclick=\"return validateSignUp()\"\n");
        out.write("                                            >\n");
        out.write("                                            Register\n");
        out.write("                                        </button>\n");
        out.write("                                    </div>\n");
        out.write("                                    <div class=\"form-group d-md-flex\">\n");
        out.write("                                        <div class=\"w-100\">\n");
        out.write("                                            Already a User? <a href=\"javascript:void(0)\" onclick=\"loadSignIn()\">Sign in here!</a>\n");
        out.write("                                        </div>\n");
        out.write("                                    </div>\n");
        out.write("                                </form>\n");
        out.write("                            </div>\n");
        out.write("                        </div>\n");
        out.write("                    </div>\n");
        out.write("                </div>\n");
        out.write("            </section>\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Action eq 'signin'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            <section class=\"ftco-section\">\n");
        out.write("                <div class=\"container\">\n");
        out.write("                    <div class=\"row justify-content-center\">\n");
        out.write("                        <div class=\"col-md-7 col-lg-5\">\n");
        out.write("                            <div class=\"login-wrap p-4 p-md-5\">\n");
        out.write("                                <div\n");
        out.write("                                    class=\"icon d-flex align-items-center justify-content-center\"\n");
        out.write("                                    >\n");
        out.write("                                    <span class=\"fa fa-user-o\"></span>\n");
        out.write("                                </div>\n");
        out.write("                                <h3 class=\"text-center mb-4\">Sign In</h3>\n");
        out.write("                                <form action=\"\" id=\"SignInForm\" name=\"SignIn\" method=\"POST\" class=\"login-form\">\n");
        out.write("                                    <div class=\"form-group\">\n");
        out.write("                                        <input\n");
        out.write("                                            type=\"text\"\n");
        out.write("                                            class=\"form-control rounded-left\"\n");
        out.write("                                            placeholder=\"Username\"\n");
        out.write("                                            name=\"UserName\"\n");
        out.write("                                            />\n");
        out.write("                                    </div>\n");
        out.write("                                    <div class=\"form-group d-flex\">\n");
        out.write("                                        <input\n");
        out.write("                                            type=\"password\"\n");
        out.write("                                            class=\"form-control rounded-left\"\n");
        out.write("                                            placeholder=\"Password\"\n");
        out.write("                                            name=\"Password\"\n");
        out.write("                                            />\n");
        out.write("                                    </div>\n");
        out.write("                                    <div class=\"form-group\">\n");
        out.write("                                        <button\n");
        out.write("                                            type=\"submit\"\n");
        out.write("                                            class=\"form-control btn btn-primary rounded submit px-3\"\n");
        out.write("                                            onclick=\"return validateSignIn()\"\n");
        out.write("                                            >\n");
        out.write("                                            Login\n");
        out.write("                                        </button>\n");
        out.write("                                    </div>\n");
        out.write("                                    <div class=\"form-group d-md-flex\">\n");
        out.write("                                        <div class=\"w-100\">\n");
        out.write("                                            <a href=\"javascript:void(0)\" onclick=\"loadRecoverPassword()\">Forgot Password?</a>\n");
        out.write("                                        </div>\n");
        out.write("                                        <div class=\"w-100 text-md-right\">\n");
        out.write("                                            <a href=\"javascript:void(0)\" onclick=\"loadSignUp()\">Create One!</a>\n");
        out.write("                                        </div>\n");
        out.write("                                    </div>\n");
        out.write("                                </form>\n");
        out.write("                            </div>\n");
        out.write("                        </div>\n");
        out.write("                    </div>\n");
        out.write("                </div>\n");
        out.write("            </section>\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Action eq 'recoverpassword'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            <section class=\"ftco-section\">\n");
        out.write("                <div class=\"container\">\n");
        out.write("                    <div class=\"row justify-content-center\">\n");
        out.write("                        <div class=\"col-md-7 col-lg-5\">\n");
        out.write("                            <div class=\"login-wrap p-4 p-md-5\">\n");
        out.write("                                <div\n");
        out.write("                                    class=\"icon d-flex align-items-center justify-content-center\"\n");
        out.write("                                    >\n");
        out.write("                                    <span class=\"fa fa-key\" aria-hidden=\"true\"></span>\n");
        out.write("                                </div>\n");
        out.write("                                <h3 class=\"text-center mb-4\">Forgot Password</h3>\n");
        out.write("                                <form action=\"#\" class=\"login-form\">\n");
        out.write("                                    <div class=\"form-group\">\n");
        out.write("                                        <input\n");
        out.write("                                            type=\"email\"\n");
        out.write("                                            class=\"form-control rounded-left\"\n");
        out.write("                                            placeholder=\"Enter Email\"\n");
        out.write("                                            required\n");
        out.write("                                            />\n");
        out.write("                                    </div>\n");
        out.write("                                    <div class=\"form-group\">\n");
        out.write("                                        <button\n");
        out.write("                                            type=\"submit\"\n");
        out.write("                                            class=\"form-control btn btn-primary rounded submit px-3\"\n");
        out.write("                                            >\n");
        out.write("                                            Submit\n");
        out.write("                                        </button>\n");
        out.write("                                    </div>\n");
        out.write("                                    <div class=\"form-group d-md-flex\">\n");
        out.write("                                        <div class=\"w-100\">\n");
        out.write("                                            <a href=\"javascript:void(0)\" onclick=\"loadSignIn()\">Sign in Here!</a>\n");
        out.write("                                        </div>\n");
        out.write("                                    </div>\n");
        out.write("                                </form>\n");
        out.write("                            </div>\n");
        out.write("                        </div>\n");
        out.write("                    </div>\n");
        out.write("                </div>\n");
        out.write("            </section>\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }
}
