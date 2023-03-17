/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.profile.controller;

import com.finlogic.tms.profile.bean.ProfileFormBean;
import com.finlogic.tms.profile.service.ProfileService;
import com.finlogic.util.CommonMember;
import com.finlogic.util.CommonUtil;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
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
@RequestMapping(value = "profile.fin")
public class ProfileController {

    @Autowired
    ProfileService profileService; 
    
    @RequestMapping( params = "cmdAction=loadProfile" ,  method = RequestMethod.POST)
    public ModelAndView loadProfile(HttpServletRequest request , HttpServletResponse response)  
    {
        ModelAndView modelAndView = new ModelAndView("Profile/userProfile");
        String usercode = CommonUtil.getUserCode(request);
        try {
            List profile = profileService.getProfile(usercode);
            if(!profile.isEmpty())
            {
                HashMap map = (HashMap)profile.get(0);
                modelAndView.addObject("fname", map.get("FIRSTNAME"));
                modelAndView.addObject("lname", map.get("LASTNAME"));
                modelAndView.addObject("dob", map.get("DOB"));
                modelAndView.addObject("mobNo", map.get("PHONE_NO"));
                modelAndView.addObject("gender", map.get("GENDER"));
            }
            modelAndView.addObject("Action","loadProfile");
            
            
        } catch (SQLException |ClassNotFoundException ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping( params = "cmdAction=updateProfile" ,  method = RequestMethod.POST)
    public ModelAndView updateProfile(HttpServletRequest request , HttpServletResponse response , ProfileFormBean profileFormBean)
    {
        ModelAndView modelAndView = new ModelAndView("Profile/userProfile");
        String usercode = CommonUtil.getUserCode(request);
        try {
            
            int updateStatus = profileService.updateProfile(profileFormBean, usercode);
            modelAndView.addObject("updateStatus", updateStatus);
            modelAndView.addObject("Action", "updateProfile");
        } catch (ClassNotFoundException | SQLException ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
}
