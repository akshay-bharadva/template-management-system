/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.login.controller;

import com.finlogic.tms.login.bean.LoginFormBean;
import com.finlogic.tms.login.service.LoginService;
import com.finlogic.util.CommonMember;
import com.finlogic.util.CommonUtil;
import com.finlogic.util.SessionBean;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    
//    @Autowired
//    SessionBean sessionInfo;
    
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
    
    @RequestMapping(params = "cmdAction=verifyUser", method = {RequestMethod.POST})
    public ModelAndView verifyUser(HttpServletRequest request, HttpServletResponse response, LoginFormBean loginFormBean) {
        ModelAndView modelAndView = new ModelAndView("Login/status");
        try {
            int status = loginService.verifyUser(loginFormBean);
            modelAndView.addObject("status", status);
            modelAndView.addObject("Action", "verifyUser");

            CommonMember.appendLogFile("@service :: verifyUser:- " + status);

            String Usercode = "", Type = "";
            if (status > 0) {
                List UserList = loginService.getUserCode(loginFormBean);
                if (!UserList.isEmpty()) {
                    Map map = (Map) UserList.get(0);
                    if (map.get("USERCODE") != null && map.get("TYPE") != null) {
                        Usercode = map.get("USERCODE").toString();
                        Type = map.get("TYPE").toString();
                    }

                    CommonMember.appendLogFile("USERCODE :- " + Usercode + " TYPE:- " + Type);

                    loginFormBean.setUserCode(Usercode);
                    loginFormBean.setUserType(Type);
                }

                HttpSession session = request.getSession(true);

                SessionBean sessionInfo = CommonUtil.getSessionBean(request);
                sessionInfo.setUsercode(loginFormBean.getUserCode());
                sessionInfo.setUsername(loginFormBean.getUserName());
                sessionInfo.setUsertype(loginFormBean.getUserType());

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
    
    @RequestMapping(params = "cmdAction=logoutUser" , method = {RequestMethod.GET })
    public ModelAndView Logout(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("logout");
        SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("sessionBean");
        request.getSession().invalidate();
        sessionBean = null;
        return modelAndView;
    }
}
