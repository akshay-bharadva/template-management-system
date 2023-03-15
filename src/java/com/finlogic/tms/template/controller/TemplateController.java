
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.template.controller;

import com.finlogic.tms.template.bean.TemplateFormBean;
import com.finlogic.tms.template.service.TemplateService;
import com.finlogic.util.CommonMember;
import com.finlogic.util.CommonUtil;
import com.finlogic.util.SessionBean;
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
    
    @RequestMapping(params = "cmdAction=loadAddTemplate", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadAddTemplate(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("Template/addTemplate");

        try {
            
            SessionBean sessionBean = CommonUtil.getSessionBean(request);
            modelAndView.addObject("USERTYPE", sessionBean.getUsertype());
            
            List templateType = templateService.getTemplateTye();
            modelAndView.addObject("templateType", templateType);

        } catch (Exception ex) {

            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=loadEditTemplate", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadEditTemplate(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("Template/editTemplate");
        try {

            String action = request.getParameter("action");
            List templateType = templateService.getTemplateTye();
            modelAndView.addObject("templateType", templateType);
//            CommonMember.appendLogFile("@TemplateController :: loadEditTemplate :: action " + action);
            modelAndView.addObject("action", action);

        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=loadDeleteTemplate", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadDeleteTemplate(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("Template/editTemplate");
        try {

            String action = request.getParameter("action");
            List templateType = templateService.getTemplateTye();
            modelAndView.addObject("templateType", templateType);
            modelAndView.addObject("action", action);
//            CommonMember.appendLogFile("@TemplateController :: loadDeleteTemplate :: action " + action);

        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=loadViewTemplate", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadViewTemplate(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("Template/editTemplate");
        try {

            List templateType = templateService.getTemplateTye();
            modelAndView.addObject("templateType", templateType);
            String action = request.getParameter("action");
            modelAndView.addObject("action", action);
//            CommonMember.appendLogFile("@TemplateController :: loadViewTemplate :: action " + action);

        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params="cmdAction=insertTemplate" , method = {RequestMethod.GET , RequestMethod.POST})
    public ModelAndView insertTemplate(HttpServletRequest request , HttpServletResponse response , TemplateFormBean templateFormBean)
    {
        ModelAndView modelAndView = new ModelAndView("Template/templateStatus");
        try {
            setUserCode(request, templateFormBean);
            int result = templateService.insertTemplateDetail(templateFormBean);
            modelAndView.addObject("Action", "insertTemplate");
            modelAndView.addObject("result", result);
//            CommonMember.appendLogFile("@TemplateController :: InsertTemplate :: result :: " + result);
            
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
            setUserCode(request, templateFormBean);
            templateFormBean.setCmbFilterType(filterType);
            List templateList = templateService.getAllTemplateDetail(templateFormBean);
            if(!templateList.isEmpty())
            {
                modelAndView.addObject("status", "1");
                modelAndView.addObject("templateList", templateList);
            }
            else
            {
                modelAndView.addObject("status", "0");
            }
            modelAndView.addObject("Action", "viewTemplate");
            modelAndView.addObject("crudAction", crudAction);
//            CommonMember.appendLogFile("@TemplateController :: getAllTemplateDetail :: TemplateList :: " + templateList + " :: filterType :: " + filterType + " :: usercode :: " + templateFormBean.getUsercode());
            
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
            
            setUserCode(request, templateFormBean);
            int result = templateService.updateTemplateDetail(templateFormBean);
            modelAndView.addObject("Action", "editTemplate");
            modelAndView.addObject("result", result);
//            CommonMember.appendLogFile("@TemplateController :: updateTemplateDetail :: result :: " + result);
            
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
            
            setUserCode(request, templateFormBean);
            int result = templateService.deleteTemplateDetail(templateFormBean);
            modelAndView.addObject("Action", "deleteTemplate");
            modelAndView.addObject("result", result);
//            CommonMember.appendLogFile("@TemplateController :: deleteTemplateDetail :: result :: " + result);
            
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
            String templateId = request.getParameter("templateId");
            String crudAction = request.getParameter("crudAction");
            
            SessionBean sessionBean = CommonUtil.getSessionBean(request);
            String usercode = sessionBean.getUsercode();
            modelAndView.addObject("USERTYPE", sessionBean.getUsertype());
            
            List templateTypeList = templateService.getTemplateTye();
            List templateList = templateService.getUpdateData(templateId,usercode);
            
            modelAndView.addObject("templateType", templateTypeList);
            modelAndView.addObject("task", crudAction);
            
            
            if (templateList.size() > 0) {
                Map m = (Map) templateList.get(0);
                modelAndView.addObject("TemplateId", m.get("TEMPLATE_ID"));
                modelAndView.addObject("Type", m.get("TEMPLATE_TYPE_ID"));
                modelAndView.addObject("CategoryId", m.get("CATEGORY_ID"));
                modelAndView.addObject("CategoryName", m.get("CATEGORY_NAME"));
                modelAndView.addObject("Subject", m.get("TITLE"));
                modelAndView.addObject("Body", m.get("BODY"));
                modelAndView.addObject("IsActive", m.get("ISACTIVE"));
                modelAndView.addObject("defaultTemplate", m.get("ISDEFAULT"));
            }  
//            CommonMember.appendLogFile("@TemplateController :: getupdateTemplateData :: TemplateList :: " + templateList + " :: templateId :: " + templateId + " :: usercode :: " + usercode);
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=loadCategory", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getCategoryList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("Template/templateStatus");

        try {
            String templateType = request.getParameter("templateType");
            SessionBean sessionBean = CommonUtil.getSessionBean(request);
            List categoryList = templateService.getCategory(templateType , sessionBean.getUsercode());
            if(!categoryList.isEmpty())
            {
                modelAndView.addObject("categoryList", categoryList);
                modelAndView.addObject("status", "1");
            }
            else
            {
                modelAndView.addObject("status", "0");
            }
            modelAndView.addObject("Action", "category");
            
            
        } catch (Exception ex) {

            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    public void setUserCode(HttpServletRequest request,TemplateFormBean templateFormBean)
    {
            SessionBean sessionBean = CommonUtil.getSessionBean(request);
            String userCode = sessionBean.getUsercode();
            templateFormBean.setUsercode(userCode);
//            CommonMember.appendLogFile("@Contoller :: setUserCode :: usercode :: " + userCode);
    }
    
    @RequestMapping(params = "cmdAction=loadButton", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadButton(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("Template/templateStatus");

        try {
            modelAndView.addObject("Action", "defaultTemplate");
        } catch (Exception ex) {

            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=loadDefaultTemplate", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadDefaultTemplate(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("Template/editTemplate");
        try {

            String action = request.getParameter("action");
            List templateType = templateService.getTemplateTye();
            modelAndView.addObject("templateType", templateType);
            modelAndView.addObject("action", action);
//            CommonMember.appendLogFile("@TemplateController :: loadDeleteTemplate :: action " + action);

        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=showDefaultTemplate", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView showDefaultTemplate(HttpServletRequest request, HttpServletResponse response,TemplateFormBean templateFormBean) {
        ModelAndView modelAndView = new ModelAndView("Template/templateStatus");
        try {

            String crudAction = request.getParameter("action");
            String filterType = request.getParameter("filterValue");
            String isDefault = request.getParameter("isDefault");
            
            templateFormBean.setCmbFilterType(filterType);
            templateFormBean.setIsdefaultTemplate(isDefault);
            
            List templateList = templateService.getDefaultTemplateDetail(templateFormBean);
            if(!templateList.isEmpty())
            {
                modelAndView.addObject("status", "1");
                modelAndView.addObject("templateList", templateList);
            }
            else
            {
                modelAndView.addObject("status", "0");
            }
            modelAndView.addObject("Action", "viewTemplate");
            modelAndView.addObject("crudAction", crudAction);
//            CommonMember.appendLogFile("@TemplateController :: getAllTemplateDetail :: TemplateList :: " + templateList + " :: filterType :: " + filterType + " :: usercode :: " + templateFormBean.getUsercode());


        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }

}
