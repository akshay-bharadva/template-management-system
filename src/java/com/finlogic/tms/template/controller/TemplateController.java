
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.template.controller;

import com.finlogic.tms.template.bean.TemplateFormBean;
import com.finlogic.tms.template.service.TemplateService;
import com.finlogic.util.CommonMember;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author njuser
 */
@Controller
@RequestMapping(value="template.fin")
public class TemplateController {
    
    @Autowired
    TemplateService templateService;
    
    @RequestMapping(params="cmdAction=loadTemplate" , method = {RequestMethod.GET ,RequestMethod.POST})
    public ModelAndView loadTemplate(HttpServletRequest request , HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView("Template/template");
        return modelAndView;
    }
    
    @RequestMapping(params="cmdAction=loadAddTemplate" , method = {RequestMethod.GET , RequestMethod.POST})
    public ModelAndView loadAddTemplate(HttpServletRequest request , HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView("Template/addTemplate");
        return modelAndView;
    }
    
    @RequestMapping(params="cmdAction=loadEditTemplate" , method = {RequestMethod.GET , RequestMethod.POST})
    public ModelAndView loadEditTemplate(HttpServletRequest request , HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView("Template/editTemplate");
        String action = request.getParameter("action");
        CommonMember.appendLogFile("@TemplateController :: loadEditTemplate :: action " + action);
        modelAndView.addObject("action", action);
        return modelAndView;
    }
    
    @RequestMapping(params="cmdAction=loadDeleteTemplate" , method = {RequestMethod.GET , RequestMethod.POST})
    public ModelAndView loadDeleteTemplate(HttpServletRequest request , HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView("Template/editTemplate");
        String action = request.getParameter("action");
        modelAndView.addObject("action", action);
        CommonMember.appendLogFile("@TemplateController :: loadDeleteTemplate :: action " + action);
        return modelAndView;
    }
    
    @RequestMapping(params="cmdAction=loadViewTemplate" , method = {RequestMethod.GET , RequestMethod.POST})
    public ModelAndView loadViewTemplate(HttpServletRequest request , HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView("Template/editTemplate");
        String action = request.getParameter("action");
        modelAndView.addObject("action", action);
        CommonMember.appendLogFile("@TemplateController :: loadViewTemplate :: action " + action);
        return modelAndView;
    }
    
    @RequestMapping(params="cmdAction=insertTemplate" , method = {RequestMethod.GET , RequestMethod.POST})
    public ModelAndView insertTemplate(HttpServletRequest request , HttpServletResponse response , TemplateFormBean templateFormBean)
    {
        ModelAndView modelAndView = new ModelAndView("Template/templateStatus");
        try {
            int result = templateService.insertTemplateDetail(templateFormBean);
            modelAndView.addObject("Action", "insertTemplate");
            modelAndView.addObject("result", result);
            CommonMember.appendLogFile("@TemplateController :: InsertTemplate :: result :: " + result);
            
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params="cmdAction=showTemplate" , method = {RequestMethod.GET , RequestMethod.POST})
    public ModelAndView getAllTemplateDetail(HttpServletRequest request , HttpServletResponse response , TemplateFormBean templateFormBean)
    {
        ModelAndView modelAndView = new ModelAndView("Template/templateStatus");
        try {
            String crudAction = request.getParameter("action");
            String filterType = request.getParameter("filterValue");
            templateFormBean.setCmbFilterType(filterType);
            List templateList = templateService.getAllTemplateDetail(templateFormBean);
            modelAndView.addObject("Action", "viewTemplate");
            modelAndView.addObject("templateList", templateList);
            modelAndView.addObject("crudAction", crudAction);
            CommonMember.appendLogFile("@TemplateController :: getAllTemplateDetail :: TemplateList :: " + templateList + " :: filterType :: " + filterType);
            
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params="cmdAction=updateTemplate" , method = {RequestMethod.GET , RequestMethod.POST})
    public ModelAndView updateTemplateDetail(HttpServletRequest request , HttpServletResponse response , TemplateFormBean templateFormBean)
    {
        ModelAndView modelAndView = new ModelAndView("Template/templateStatus");
        try {
            int result = templateService.updateTemplateDetail(templateFormBean);
            modelAndView.addObject("Action", "editTemplate");
            modelAndView.addObject("result", result);
            CommonMember.appendLogFile("@TemplateController :: updateTemplateDetail :: result :: " + result);
            
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params="cmdAction=deleteTemplate" , method = {RequestMethod.GET , RequestMethod.POST})
    public ModelAndView deleteTemplateDetail(HttpServletRequest request , HttpServletResponse response , TemplateFormBean templateFormBean)
    {
        ModelAndView modelAndView = new ModelAndView("Template/templateStatus");
        try {
            int result = templateService.deleteTemplateDetail(templateFormBean);
            modelAndView.addObject("Action", "deleteTemplate");
            modelAndView.addObject("result", result);
            CommonMember.appendLogFile("@TemplateController :: deleteTemplateDetail :: result :: " + result);
            
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params="cmdAction=getupdateTemplateData" , method = {RequestMethod.GET , RequestMethod.POST})
    public ModelAndView getupdateTemplateData(HttpServletRequest request , HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView("Template/addTemplate");
        try {
            String templateType = request.getParameter("templateType");
            String category = request.getParameter("category");
            String crudAction = request.getParameter("crudAction");
            List templateList = templateService.getUpdateData(templateType, category);
            modelAndView.addObject("task", crudAction);
           if (templateList.size() > 0) {
                Map m = (Map) templateList.get(0);
                modelAndView.addObject("hdnTemplateType", m.get("TEMPLATE_TYPE"));
                modelAndView.addObject("hdnTemplateCategory", m.get("CATEGORY"));
                modelAndView.addObject("Type", m.get("TEMPLATE_TYPE"));
                modelAndView.addObject("Category", m.get("CATEGORY"));
                modelAndView.addObject("Subject", m.get("TITLE"));
                modelAndView.addObject("Body", m.get("BODY"));
                modelAndView.addObject("Default", m.get("ISACTIVE"));
            }  
            CommonMember.appendLogFile("@TemplateController :: getAllTemplateDetail :: TemplateList :: " + templateList);
            
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }

}
