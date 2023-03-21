/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.category.controller;

import com.finlogic.tms.category.bean.CategoryFormBean;
import com.finlogic.tms.category.service.CategoryService;
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
@RequestMapping(value = "category.fin")
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;
    
    @RequestMapping(params = "cmdAction=loadCategory", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadCategory(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("Category/category");
        SessionBean sessionBean = CommonUtil.getSessionBean(request);
        try {
            modelAndView.addObject("USERTYPE", sessionBean.getUsertype());
            modelAndView.addObject("CategoryCount", categoryService.CategoryCount());
            modelAndView.addObject("DefaultCount", categoryService.DefaultCount());
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }

        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=loadAddCategory", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadAddCategory(HttpServletRequest request, HttpServletResponse response,CategoryFormBean categoryFormBean) {
        ModelAndView modelAndView = new ModelAndView("Category/addCategory");
        try {
            setUserCode(request, categoryFormBean);
            CommonMember.appendLogFile("@loadAddCategory :: usercode :: " +categoryFormBean.getUserCode());
            modelAndView.addObject("categorylist", categoryService.getCategoryNameList(categoryFormBean));
            modelAndView.addObject("tmptypelist", categoryService.getTemplateType());
            modelAndView.addObject("USERTYPE", getUserType(request));
            
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=insertCategory", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView insertCategory(HttpServletRequest request,HttpServletResponse response,CategoryFormBean categoryFormBean) {
        ModelAndView modelAndView = new ModelAndView("Category/categoryajax");
        try {
            setUserCode(request,categoryFormBean);
            int result = categoryService.insertCategoryDetail(categoryFormBean);
            modelAndView.addObject("Action", "insertCategory");
            modelAndView.addObject("Status", result);
            
        } catch (Exception e) {
            CommonMember.errorHandler(e);
        }
        
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=loadEditCategory", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadEditCategory(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("Category/editCategory");
        try {
            String action = request.getParameter("Action");
            modelAndView.addObject("tmptypelist", categoryService.getTemplateType());
            modelAndView.addObject("action", action);
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    @RequestMapping(params = "cmdAction=loadDeleteCategory", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadDeleteCategory(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("Category/editCategory");
        try {
            String action = request.getParameter("Action");
            modelAndView.addObject("tmptypelist", categoryService.getTemplateType());
            modelAndView.addObject("action", action);
            
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    @RequestMapping(params = "cmdAction=loadViewCategory", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadViewCategory(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("Category/editCategory");
        try {
            String action = request.getParameter("Action");
            modelAndView.addObject("tmptypelist", categoryService.getTemplateType());
            modelAndView.addObject("action", action);
            
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }

    @RequestMapping(params="cmdAction=showCategory" , method = {RequestMethod.GET , RequestMethod.POST})
    public ModelAndView getAllCategoryDetail(HttpServletRequest request , HttpServletResponse response , CategoryFormBean categoryFormBean)
    {
        ModelAndView modelAndView = new ModelAndView("Category/categoryajax");
        try {
            String crudAction = request.getParameter("action");
            String filterType = request.getParameter("filterValue");
            categoryFormBean.setCmbFilterType(filterType);
            setUserCode(request,categoryFormBean);
            List CategoryList = categoryService.getAllCategoryDetail(categoryFormBean);
            if(!CategoryList.isEmpty())
            {
                modelAndView.addObject("CategoryList", CategoryList);
                modelAndView.addObject("status", "1");
            }
            else
            {
                modelAndView.addObject("status", "0");                
            }
            modelAndView.addObject("Action", "viewCategory");
            modelAndView.addObject("crudAction", crudAction);
            CommonMember.appendLogFile("@CategoryController :: getAllCategoryDetail :: CategoryList :: " + CategoryList + " :: filterType :: " + filterType);
            
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=getCategoryData", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getCategoryData(HttpServletRequest request,HttpServletResponse response,CategoryFormBean categoryFormBean)
    {
        ModelAndView modelAndView = new ModelAndView("Category/addCategory");
        try {
            String categoryId = request.getParameter("CategoryID");
            String crudAction = request.getParameter("crudAction");
            setUserCode(request,categoryFormBean);
            List categoryList = categoryService.getCategoryData(categoryFormBean);
            modelAndView.addObject("task", crudAction);
            modelAndView.addObject("categoryID", categoryId);
            modelAndView.addObject("categorylist", categoryService.getAllCategoryDetail(categoryFormBean));
           if (categoryList.size() > 0) {
                Map m = (Map) categoryList.get(0);
                modelAndView.addObject("hdnTemplateType", m.get("TEMPLATE_TYPE_NAME"));
                modelAndView.addObject("hdnTemplateCategory", m.get("CATEGORY_NAME"));
                modelAndView.addObject("TMPID", m.get("TEMPLATE_TYPE_ID"));
                modelAndView.addObject("tmptypelist", categoryService.getTemplateType());
                modelAndView.addObject("Category", m.get("CATEGORY_NAME"));
                modelAndView.addObject("IsActive", m.get("ISACTIVE"));
                modelAndView.addObject("defaultTemplate",m.get("ISDEFAULT"));
                modelAndView.addObject("USERTYPE", getUserType(request));
            }
            
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
        
    }
    
    @RequestMapping(params = "cmdAction=editCategory", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView editCategory(HttpServletRequest request,
            HttpServletResponse response,
            CategoryFormBean categoryFormBean) {
        ModelAndView modelAndView = new ModelAndView("Category/categoryajax");
        try {
            setUserCode(request,categoryFormBean);
            int result = categoryService.editCategoryDetail(categoryFormBean);
            modelAndView.addObject("Action", "editCategory");
            modelAndView.addObject("Status", result);            
        } catch (Exception e) {
            CommonMember.errorHandler(e);
        }
        
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=deleteCategory", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView deleteCategory(HttpServletRequest request,
            HttpServletResponse response,
            CategoryFormBean categoryFormBean) 
    {
        ModelAndView modelAndView = new ModelAndView("Category/categoryajax");
        try {
            setUserCode(request,categoryFormBean);
            CommonMember.appendLogFile("@CategoryController :: deleteCategory :: CategoryID :: " + categoryFormBean.getCategoryID());
            int result = categoryService.deleteCategoryDetail(categoryFormBean);
            modelAndView.addObject("Action", "deleteCategory");
            modelAndView.addObject("Status", result);
            CommonMember.appendLogFile("@CategoryController :: deleteCategory :: result :: " + result);
            
        } catch (Exception e) {
            CommonMember.errorHandler(e);
        }
        
        return modelAndView;
    }
    
    public void setUserCode(HttpServletRequest request,CategoryFormBean categoryFormBean)
    {
            SessionBean sessionBean = CommonUtil.getSessionBean(request);
            String userCode = sessionBean.getUsercode();
            categoryFormBean.setUserCode(userCode);
    }
    
    public String getUserType(HttpServletRequest request)
    {
        SessionBean sessionBean = CommonUtil.getSessionBean(request);
        return sessionBean.getUsertype();
    }
    
}
