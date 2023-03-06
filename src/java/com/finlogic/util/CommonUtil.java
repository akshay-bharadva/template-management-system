/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.util;

import javax.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 *
 * @author njuser
 */
public class CommonUtil {

    public static SessionBean getSessionBean(HttpServletRequest request) {
        ApplicationContext context = RequestContextUtils.getWebApplicationContext(request);
        return context.getBean(SessionBean.class);
    }

}
