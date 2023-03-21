/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.historymaster.controller;

import com.finlogic.tms.historymaster.service.HistoryMasterService;
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
@RequestMapping(value = "historymaster.fin")
public class HistoryMasterController {

    @Autowired
    HistoryMasterService historyMasterService;

    @RequestMapping(params = "cmdAction=loadHistoryMaster", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView loadHistoryMaster(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("HistoryMaster/History");
        try {
            modelAndView.addObject("HistoryList", historyMasterService.getUserHistory());
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
}
