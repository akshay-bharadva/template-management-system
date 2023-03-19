/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.util;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    
    public static String currentDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        return dateFormat.format(date); 
    }
    
    public static String storageFilePath()
    {
        return "/opt/application_storage/storage_box/tms/excelsheets/generatedFile/";
    }
    
    public static String uploadedFilePath()
    {
        return "/opt/application_storage/storage_box/tms/excelsheets/uploadedFile/";
    }
     
    public static String errorFilePath()
    {
        return "/opt/application_storage/storage_box/tms/excelsheets/error/";
    }
    
    public static String pdfFilePath()
    {
        return "/opt/application_storage/storage_box/tms/excelsheets/pdf/";
    }

    public static String getUserCode(HttpServletRequest request) {
        SessionBean sessionBean = CommonUtil.getSessionBean(request);
        return sessionBean.getUsercode();
    }
    
    
}
