/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.tmptype.controller;

import com.finlogic.tms.tmptype.bean.TmptypeFormBean;
import com.finlogic.tms.tmptype.service.TemplateTypeService;
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
@RequestMapping(value = "tmptype.fin")
public class TemplatetypeController {
    
    @Autowired
    TemplateTypeService templateTypeService;
    
    @RequestMapping(params = "cmdAction=loadtmptype", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadtmptype(HttpServletRequest request,HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView("TemplateType/TmpType");
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=loadaddTmptype", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadaddTmptype(HttpServletRequest request,HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView("TemplateType/addTmpType");
        try {
            modelAndView.addObject("TypeList", templateTypeService.GetTypeNameList());
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=loadeditTmptype", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadeditTmptype(HttpServletRequest request,HttpServletResponse response,TmptypeFormBean tmptypeFormBean)
    {
        ModelAndView modelAndView = new ModelAndView("TemplateType/editTmpType");
        try {
            String action = request.getParameter("Action");
            modelAndView.addObject("tmptypeList", templateTypeService.GetTypeList());
            modelAndView.addObject("action", action);
            
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=loaddeleteTmptype", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loaddeleteTmptype(HttpServletRequest request,HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView("TemplateType/editTmpType");
        try {
            String action = request.getParameter("Action");
            modelAndView.addObject("tmptypeList", templateTypeService.GetTypeList());
            modelAndView.addObject("action", action);
            
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=loadviewTmptype", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadviewTmptype(HttpServletRequest request,HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView("TemplateType/editTmpType");
        try {
            String action = request.getParameter("Action");
            modelAndView.addObject("tmptypeList", templateTypeService.GetTypeList());
            modelAndView.addObject("action", action);
            
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=insertTmptype", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView insertTmptype(HttpServletRequest request,
            HttpServletResponse response,
            TmptypeFormBean tmptypeFormBean)
    {
        ModelAndView modelAndView = new ModelAndView("TemplateType/TmpTypeajax");
        try {
            setUserCode(request,tmptypeFormBean);
            int result = templateTypeService.insertTmpType(tmptypeFormBean);
            modelAndView.addObject("Action","insertTmptype");
            modelAndView.addObject("Status", result);
            CommonMember.appendLogFile("@TemplatetypeController :: insertTmptype :: insertStatus :: " + result);
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
 
    @RequestMapping(params = "cmdAction=showTmptype",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView getAllTmptype(HttpServletRequest request,HttpServletResponse response,TmptypeFormBean tmptypeFormBean)
    {
        ModelAndView modelAndView = new ModelAndView("TemplateType/TmpTypeajax");
        try {
            String crudAction = request.getParameter("action");
            String filterType = request.getParameter("filterValue");
            tmptypeFormBean.setCmbFilterType(filterType);
            setUserCode(request,tmptypeFormBean);
            List TmptypeList = templateTypeService.getAllTmpType(tmptypeFormBean);
            
            if(!TmptypeList.isEmpty())
            {
                modelAndView.addObject("TmptypeList", TmptypeList);
                modelAndView.addObject("status", "1");
            }
            else
            {
                modelAndView.addObject("status", "0");
            }
            
            modelAndView.addObject("Action", "viewTmptype");
            modelAndView.addObject("crudAction", crudAction);
            CommonMember.appendLogFile("@TemplatetypeController :: showTmptype :: crudAction : "+crudAction);
            CommonMember.appendLogFile("@TemplatetypeController :: showTmptype :: filtertype : "+filterType);
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=getTmpTypeData",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView getTmpTypeData(HttpServletRequest request,HttpServletResponse response,TmptypeFormBean tmptypeFormBean)
    {
        ModelAndView modelAndView = new ModelAndView("TemplateType/addTmpType");
        try{
            String TmptypeID = request.getParameter("TmptypeID");
            String crudAction = request.getParameter("crudAction");
            setUserCode(request,tmptypeFormBean);
            List TmptypeList = templateTypeService.gettmptypeData(tmptypeFormBean);
            modelAndView.addObject("task", crudAction);
            modelAndView.addObject("tmptypeId", TmptypeID);
            modelAndView.addObject("TypeList", templateTypeService.GetTypeNameList());
           if (TmptypeList.size() > 0) {
                Map m = (Map) TmptypeList.get(0);
                modelAndView.addObject("TemplateType", m.get("TEMPLATE_TYPE_NAME"));
                modelAndView.addObject("IsActive", m.get("ISACTIVE"));
            }  
            CommonMember.appendLogFile("@TemplatetypeController :: getTmpTypeData :: TmptypeList :: " + TmptypeList);
            
        }
        catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=editTmptype",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView editTmptype(HttpServletRequest request,HttpServletResponse response,TmptypeFormBean tmptypeFormBean)
    {
        ModelAndView modelAndView = new ModelAndView("TemplateType/TmpTypeajax");
        try {
            setUserCode(request,tmptypeFormBean);
            int result = templateTypeService.editTmpType(tmptypeFormBean);
            modelAndView.addObject("Action", "editTmptype");
            modelAndView.addObject("Status", result);
            CommonMember.appendLogFile("@TemplatetypeController :: editTmptype :: result :: " + result);

        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=deleteTmptype",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView deleteTmptype(HttpServletRequest request,HttpServletResponse response,TmptypeFormBean tmptypeFormBean)
    {
        ModelAndView modelAndView = new ModelAndView("TemplateType/TmpTypeajax");
        try{
//            String TmptypeId = request.getParameter("TmptypeID");
            setUserCode(request,tmptypeFormBean);
            int result = templateTypeService.deleteTmpType(tmptypeFormBean);
            modelAndView.addObject("Action", "deleteTmptype");
            modelAndView.addObject("Status", result);
            CommonMember.appendLogFile("@TemplatetypeController :: deleteTmptype :: result :: " + result);
            
        }catch(Exception ex){
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    public void setUserCode(HttpServletRequest request,TmptypeFormBean tmptypeFormBean)
    {
            SessionBean sessionBean = CommonUtil.getSessionBean(request);
            String userCode = sessionBean.getUsercode();
            tmptypeFormBean.setUserCode(userCode);
    }
}
