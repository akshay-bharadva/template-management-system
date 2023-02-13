/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.template.service.impl;

import com.finlogic.tms.template.datamanager.TemplateDataManager;
import com.finlogic.tms.template.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author njuser
 */
@Service(value = "TemplateService")
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    TemplateDataManager templateDatamanager;
}
