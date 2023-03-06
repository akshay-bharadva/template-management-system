/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author njuser
 */
public class SessionFilter implements Filter {

    @Autowired
    SessionBean sessionInfo;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
        httpResponse.setHeader("Pragma", "no-cache");    //HTTP 1.0
        httpResponse.setDateHeader("Expires", 0); // Proxies.

        try {

            String url = httpRequest.getRequestURI().substring(httpRequest.getRequestURI().lastIndexOf("/") + 1);

            CommonMember.appendLogFile("This log is from Filter");
            CommonMember.appendLogFile(url);

            if (url.equals("index.fin") || url.equals("login.fin")) {
                chain.doFilter(request, response);
                return;
            }
            
            HttpSession session = httpRequest.getSession(false);

            if (session != null && session.getAttribute("sessionInfo") != null) {
                sessionInfo = (SessionBean)session.getAttribute("sessionInfo");
                CommonMember.appendLogFile("USERCODE :- " + sessionInfo.getUsercode() +" | USERNAME :- " + sessionInfo.getUsername() + " | USERTYPE :- " + sessionInfo.getUsertype());
            }

            if (session == null || sessionInfo == null || sessionInfo.getUsername() == null) {
                httpResponse.setContentType("text/html;charset=UTF-8");
                StringBuilder builder = new StringBuilder();
                builder.append("<html><head><title>Access Denied</title></head>");
                builder.append("<body>");
                builder.append("<br/>");
                builder.append("<h3 style='text-align:center;'>");
                builder.append("SESSION EXPIRED");
                builder.append("<br/><br/></h3>");
                builder.append("<script>setTimeout(function(){ window.location='login.fin?cmdAction=loadSignIn'}, 3000);</script>");
                builder.append("<h4 style='text-align:center;'>Click here to &nbsp;<a href='login.fin?cmdAction=loadSignIn'>Re-Login</a></h4>");
                builder.append("</body></html>");
                httpResponse.getWriter().write(builder.toString());
            } else {
                chain.doFilter(httpRequest, httpResponse);

            }
        } catch (IOException | ServletException ex) {

            response.setContentType("text/html;charset=UTF-8");
            CommonMember.errorHandler(ex);
        }
    }

    @Override
    public void destroy() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
