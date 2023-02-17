/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.template.service.impl;

import com.finlogic.tms.template.bean.TemplateEntityBean;
import com.finlogic.tms.template.bean.TemplateFormBean;
import com.finlogic.tms.template.datamanager.TemplateDataManager;
import com.finlogic.tms.template.service.TemplateService;
import java.util.List;
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

    @Override
    public int insertTemplateDetail(TemplateFormBean templateFormBean) throws Exception{
        TemplateEntityBean templateEntityBean = convertFormBeanToEntityBean(templateFormBean);
        return templateDatamanager.insertTemplateDetail(templateEntityBean);
    }

    @Override
    public int updateTemplateDetail(TemplateFormBean templateFormBean) throws Exception {
        TemplateEntityBean templateEntityBean = convertFormBeanToEntityBean(templateFormBean);
        return templateDatamanager.updateTemplateDetail(templateEntityBean);
    }
    
    @Override
    public int deleteTemplateDetail(TemplateFormBean templateFormBean) throws Exception
    {
        TemplateEntityBean templateEntityBean = convertFormBeanToEntityBean(templateFormBean);
        return templateDatamanager.deleteTemplateDetail(templateEntityBean);
    }
    
    @Override
    public List getAllTemplateDetail(TemplateFormBean templateFormBean) throws Exception {
        TemplateEntityBean templateEntityBean = convertFormBeanToEntityBean(templateFormBean);
        return templateDatamanager.getAllTemplateDetail(templateEntityBean);
    }
    
    @Override
    public List getUpdateData(String templateType, String category) throws Exception {
        return templateDatamanager.getUpdateData(templateType, category);
    }
    
    @Override
    public TemplateEntityBean convertFormBeanToEntityBean(TemplateFormBean templateFormBean) {
        TemplateEntityBean templateEntityBean = new TemplateEntityBean();
        
        templateEntityBean.setHdnTemplateCategory(templateFormBean.getHdnTemplateCategory());
        templateEntityBean.setHdnTemplateType(templateFormBean.getHdnTemplateType());
        templateEntityBean.setTemplateType(templateFormBean.getCmbTemplateType());
        templateEntityBean.setCategory(templateFormBean.getTxtCategory());
        templateEntityBean.setTitle(templateFormBean.getTxtSubject());
        templateEntityBean.setBody(templateFormBean.getTxtBody());
        templateEntityBean.setIsActive(templateFormBean.getChkActive());
        
        //-------------------------For Filter-----------------------------------
        templateEntityBean.setFilterType(templateFormBean.getCmbFilterType());
        return templateEntityBean;
    }




}
