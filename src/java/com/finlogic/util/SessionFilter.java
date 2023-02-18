/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author njuser
 */
public class SessionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(true);
        String path = httpRequest.getRequestURI().substring(httpRequest.getRequestURI().lastIndexOf("/") + 1);

        CommonMember.appendLogFile("This log is from Filter");
        CommonMember.appendLogFile(path);

        try {

//            if(session.getAttribute("USERCODE") == null){
//                
//            }else{
//                
//            }
            CommonMember.appendLogFile(session.getAttribute("USERCODE") + "");
            CommonMember.appendLogFile(session.getId() + "");

            if (path.equals("login.fin")) {
                chain.doFilter(request, response);
            } else {
                
                if (session.getAttribute("USERCODE") == null) {
                    httpResponse.sendRedirect("login.fin?cmdAction=loadSignIn");
                    return;
                }

                CommonMember.appendLogFile(session.getAttribute("USERCODE") + "");
                CommonMember.appendLogFile(session.getId() + "");

//                Date date = new Date();
//
//                ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(httpRequest.getServletContext());
//                SessionBean sb = (SessionBean) context.getBean("sessionBean");
//
//                String fromTime = sb.getFromtime();
//                String toTime = sb.getTotime();
//
//                DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
//                Date ftime = (Date) formatter.parse(fromTime);
//                Date ttime = (Date) formatter.parse(toTime);
//
//                date = (Date) formatter.parse(formatter.format(date));
//                int cnt = 1;
//                if (ftime.getTime() <= date.getTime() && ttime.getTime() >= date.getTime()) {
//                    cnt = 1;
//                }
//                if (cnt == 1) {
//                    chain.doFilter(request, response);
//                } else {
//                    httpResponse.sendRedirect("timeOver.jsp");
//                }

                chain.doFilter(request, response);

            }

        } catch (Exception ex) {

        }
    }

    @Override
    public void destroy() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
