/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.usermaster.controller;

import com.finlogic.tms.usermaster.bean.UserMasterFormBean;
import com.finlogic.tms.usermaster.service.UserMasterService;
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
@RequestMapping(value = "usermaster.fin")
public class UserMasterController {

    @Autowired
    UserMasterService userMasterService;

    @RequestMapping(params = "cmdAction=loadUserMaster", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadUserMaster(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("UserMaster/userMaster");
        try {
            modelAndView.addObject("usercount", userMasterService.UsersCount());
            modelAndView.addObject("admincount", userMasterService.AdminCount());
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }

    @RequestMapping(params = "cmdAction=loadAddUser", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadAddUser(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("UserMaster/AddUser");
        return modelAndView;
    }

    @RequestMapping(params = "cmdAction=addUserDetails", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView addUserDetails(HttpServletRequest request, HttpServletResponse response, UserMasterFormBean userMasterFormBean) {
        ModelAndView modelAndView = new ModelAndView("UserMaster/UserMasterAjax");
        try {
            modelAndView.addObject("Action", "Adduser");
            modelAndView.addObject("AddStatus", userMasterService.addUserDetails(userMasterFormBean));
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }

    @RequestMapping(params = "cmdAction=loadEditUser", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadEditUser(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("UserMaster/EditUser");
        try {
            modelAndView.addObject("action", request.getParameter("Action"));
            modelAndView.addObject("usertypelist", userMasterService.UserTypeList());
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }

    @RequestMapping(params = "cmdAction=loadViewUser", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadViewUser(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("UserMaster/EditUser");
        try {
            modelAndView.addObject("action", request.getParameter("Action"));
            modelAndView.addObject("usertypelist", userMasterService.UserTypeList());
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }

    @RequestMapping(params = "cmdAction=EditUserDetail", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView EditUserDetail(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("UserMaster/AddUser");
        try {
            String crudAction = request.getParameter("crudAction");
            List userDataList = userMasterService.getUserData(request.getParameter("Usercode"));
            modelAndView.addObject("task", crudAction);

            if (userDataList.size() > 0) {
                Map m = (Map) userDataList.get(0);
                modelAndView.addObject("usercode", m.get("USERCODE"));
                modelAndView.addObject("username", m.get("USERNAME"));
                modelAndView.addObject("password", m.get("PASSWORD"));
                modelAndView.addObject("email", m.get("EMAIL"));
                modelAndView.addObject("isactive", m.get("ISACTIVE"));
                modelAndView.addObject("usertype", m.get("USER_TYPE"));
            }
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }

    @RequestMapping(params = "cmdAction=updateUserDetail", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView updateUserDetail(HttpServletRequest request, HttpServletResponse response, UserMasterFormBean userMasterFormBean) {
        ModelAndView modelAndView = new ModelAndView("UserMaster/UserMasterAjax");
        try {
            modelAndView.addObject("Action", "Edituser");
            modelAndView.addObject("updateStatus", userMasterService.updateUserDetail(userMasterFormBean));
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }

    @RequestMapping(params = "cmdAction=showUsers", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getAllUsers(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("UserMaster/UserMasterAjax");
        try {
            String crudAction = request.getParameter("action");
            String filterType = request.getParameter("filterValue");

            List UserList = userMasterService.UserList(filterType);
            if (!UserList.isEmpty()) {
                modelAndView.addObject("userlist", UserList);
                modelAndView.addObject("status", "1");
            } else {
                modelAndView.addObject("status", "0");
            }

            modelAndView.addObject("Action", "ViewUser");
            modelAndView.addObject("crudAction", crudAction);

            CommonMember.appendLogFile(crudAction);
        } catch (Exception ex) {

        }
        return modelAndView;
    }
}
