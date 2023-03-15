/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.placeholder.controller;

import com.finlogic.tms.placeholder.service.PlaceholderService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.finlogic.util.CommonUtil;
import com.finlogic.util.CommonMember;
import com.finlogic.util.DownloadFileUtil;
import com.finlogic.util.ExcelUtil;
import com.finlogic.util.RegxUtil;
import com.finlogic.util.SessionBean;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author njuser
 */
@Controller
@RequestMapping(value = "placeholder.fin")
public class PlaceholderController {

    @Autowired
    PlaceholderService placeholderService;
    
    @Autowired
    RegxUtil regxUtil;
    
    @Autowired
    ExcelUtil excelUtil; 
    
    @Autowired 
    DownloadFileUtil downloadFileUtil;

    @RequestMapping(params="cmdAction=loadPlaceholder" , method = {RequestMethod.GET ,RequestMethod.POST})
    public ModelAndView loadPlaceholder(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("placeholder/placeholder");
        try {
            String usercode = getUserCode(request);
            List templateTypeList = placeholderService.templateTypeList(usercode);
            if(!templateTypeList.isEmpty())
            {
                modelAndView.addObject("templateTypeList", templateTypeList);
                modelAndView.addObject("status", "1");
            }
            else
            {
                modelAndView.addObject("status", "0");
            }
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params="cmdAction=showTemplateReport" , method = {RequestMethod.GET , RequestMethod.POST})
    public ModelAndView getAllTemplateDetail(HttpServletRequest request , HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView("placeholder/placeholderStatus");
        try {
            String templateType = request.getParameter("templateTypeValue");
            String category = request.getParameter("categoryValue");
            String usercode = getUserCode(request);
            
            List templateReport = placeholderService.templateReport(templateType, category, usercode);
            if(!templateReport.isEmpty())
            {
                modelAndView.addObject("status", "1");
                modelAndView.addObject("templateList", templateReport);
            }
            else
            {
                modelAndView.addObject("status", "0");
            }
            modelAndView.addObject("Action", "viewTemplateReport");
//            CommonMember.appendLogFile("@TemplateController :: getAllTemplateDetail :: TemplateList :: " + templateList + " :: filterType :: " + filterType + " :: usercode :: " + templateFormBean.getUsercode());
            
            
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }

    @RequestMapping(params="cmdAction=loadPlaceholderCategory" , method = {RequestMethod.GET ,RequestMethod.POST})
    public ModelAndView loadPlaceholderCategory(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("placeholder/placeholderStatus");
        try {
            String usercode = getUserCode(request);
            String templateType = request.getParameter("templateTypeValue");
            List categoryTypeList = placeholderService.categoryList(templateType, usercode);
            if(!categoryTypeList.isEmpty())
            {
                modelAndView.addObject("categoryTypeList", categoryTypeList);
                modelAndView.addObject("status", "1");
            }
            else
            {
                modelAndView.addObject("status", "0");
            }
            modelAndView.addObject("Action", "categoryList");
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params="cmdAction=generateFileWithPlaceholderAsHeader" , method = {RequestMethod.GET ,RequestMethod.POST})
    public ModelAndView generateFileWithPlaceholderAsHeader(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("placeholder/placeholderStatus");
        try {
            String usercode = getUserCode(request);
            String templateId = request.getParameter("templateId");
            
            List templateData = placeholderService.specificTemplateData(templateId, usercode);
            
            //Trace PlaceHolder
            HashMap map = (HashMap)templateData.get(0);
            List<String> listOfPlaceholder = regxUtil.getPlaceholderList(map.get("BODY").toString());
            
//            CommonMember.appendLogFile("List of Placeholder : " + listOfPlaceholder);
            
            //Generate Excel Of PlaceHolder
            String fileName = excelUtil.generateExcelFromList(map.get("TITLE").toString(), listOfPlaceholder);


            if(!templateData.isEmpty())
            {
                modelAndView.addObject("fileName", fileName);
                modelAndView.addObject("templateData", templateData);
                modelAndView.addObject("status", "1");
            }
            else
            {
                modelAndView.addObject("status", "0");
            }
            modelAndView.addObject("Action", "templateDataList");
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params="cmdAction=downloadFileFormat" , method = {RequestMethod.GET ,RequestMethod.POST})
    public void downloadFileFormat(HttpServletRequest request , HttpServletResponse response)
    {
        String fileName = request.getParameter("fileName");
        try {
            downloadFileUtil.downloadFile(response, fileName, CommonUtil.storageFilePath());
//            CommonMember.appendLogFile("Download file Successfully ");
        } catch (IOException ex) {
            CommonMember.errorHandler(ex);
        }
    }
    
    @RequestMapping(params="cmdAction=uploadExcelFileWithData" , method = {RequestMethod.POST})
    public void uploadExcelFileWithData(HttpServletRequest request , HttpServletResponse response ,@RequestParam("file") CommonsMultipartFile file)
    {
        String fileName = file.getOriginalFilename();
        try {
            
            file.transferTo(new File(CommonUtil.uploadedFilePath()+ fileName));
            
        } catch (IOException ex) {
            CommonMember.errorHandler(ex);
        }
    }
    
    public String getUserCode(HttpServletRequest request) {
        SessionBean sessionBean = CommonUtil.getSessionBean(request);
        return sessionBean.getUsercode();
    }
    
}