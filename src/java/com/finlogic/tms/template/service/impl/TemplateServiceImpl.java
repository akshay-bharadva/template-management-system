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
    public List getUpdateData(String templateId, String usercode) throws Exception {
        return templateDatamanager.getUpdateData(templateId, usercode);
    }
    
    @Override
    public TemplateEntityBean convertFormBeanToEntityBean(TemplateFormBean templateFormBean) {
        TemplateEntityBean templateEntityBean = new TemplateEntityBean();
        
        templateEntityBean.setHdnTemplateId(templateFormBean.getHdnTemplateId());
        templateEntityBean.setTemplateType(templateFormBean.getCmbTemplateType());
        templateEntityBean.setCategory(templateFormBean.getCategorysel());
        templateEntityBean.setTitle(templateFormBean.getTxtSubject());
        templateEntityBean.setBody(templateFormBean.getTxtBody());
        templateEntityBean.setIsActive(templateFormBean.getChkActive());
        templateEntityBean.setUsercode(templateFormBean.getUsercode());
        //-------------------------For Filter-----------------------------------
        templateEntityBean.setFilterType(templateFormBean.getCmbFilterType());
        //-------------------------For default-----------------------------------
        templateEntityBean.setIsdefaultTemplate(templateFormBean.getIsdefaultTemplate());
        return templateEntityBean;
    }
    
    @Override
    public List getTemplateTye() throws Exception
    {
        return templateDatamanager.getTemplateTye();
    }
    
    @Override
    public List getCategory(String templateType) throws Exception
    {
        return templateDatamanager.getCategory(templateType);
    }
    
    @Override
    public List getDefaultTemplateDetail(TemplateFormBean templateFormBean) throws Exception {
        TemplateEntityBean templateEntityBean = convertFormBeanToEntityBean(templateFormBean);
        return templateDatamanager.getDefaultTemplateDetail(templateEntityBean);
    }

}
