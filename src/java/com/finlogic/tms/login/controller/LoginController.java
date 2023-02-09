/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.login.controller;

import com.finlogic.tms.login.bean.LoginFormBean;
import com.finlogic.tms.login.service.LoginService;
import com.finlogic.util.CommonMember;
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
@RequestMapping(value = "login.fin")
public class LoginController {
    
    @Autowired
    LoginService loginService;
    
    @RequestMapping(params = "cmdAction=loadSignUp" , method = {RequestMethod.GET ,RequestMethod.POST})
    public ModelAndView loadSignUp(HttpServletRequest request,HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView("Login/signUp");
//        modelAndView.addObject("Action", "signup");
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=loadSignIn" , method = {RequestMethod.GET ,RequestMethod.POST})
    public ModelAndView loadSignIn(HttpServletRequest request,HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView("Login/signIn");
        modelAndView.addObject("Action", "signin");
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=loadRecoverPassword" , method = {RequestMethod.GET ,RequestMethod.POST})
    public ModelAndView loadRecoverPassword(HttpServletRequest request,HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView("Login/recoverPassword");
        modelAndView.addObject("Action", "recoverpassword");
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=login", method = {RequestMethod.POST})
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, LoginFormBean loginFormBean) {
        ModelAndView modelAndView = new ModelAndView("Login/status");
        try {
            int status = loginService.insertUserLoginDetail(loginFormBean);
            CommonMember.appendLogFile("@service :: InsertUser:- " + status);
            modelAndView.addObject("status", status);
            modelAndView.addObject("Action", "insertedUser");
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=loadHome" , method = {RequestMethod.POST})
    public ModelAndView verifyUser(HttpServletRequest request, HttpServletResponse response, LoginFormBean loginFormBean) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            int result = loginService.verifyUser(loginFormBean);
            if (result > 0) {
                modelAndView.setViewName("home");
            } else {
                modelAndView.addObject("Action", "signin");
                modelAndView.setViewName("Login/signUp");
            }
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=emailExist" , method = {RequestMethod.POST})
    public ModelAndView allReadyExistEmail(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("Login/status");
        try {
            String email = request.getParameter("email");
            int status = loginService.checkEmailExist(email);
            CommonMember.appendLogFile("@Controller :: status of Duplication Of Email :: " + status);
            modelAndView.addObject("Action", "checkEmail");
            modelAndView.addObject("status", status);
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params = "cmdAction=userNameExist" , method = {RequestMethod.POST})
    public ModelAndView allReadyExistUserName(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("Login/status");
        try {
            String userName = request.getParameter("userName");
            int status = loginService.checkUserNameExist(userName);
            CommonMember.appendLogFile("@Controller :: status of Duplication Of userName :: " + status);
            modelAndView.addObject("Action", "checkUserName");
            modelAndView.addObject("status", status);
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
}
