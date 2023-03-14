/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.template.service;

import com.finlogic.tms.template.bean.TemplateEntityBean;
import com.finlogic.tms.template.bean.TemplateFormBean;
import java.util.List;

/**
 *
 * @author njuser
 */
public interface TemplateService {
    
    public int insertTemplateDetail(TemplateFormBean templateFormBean) throws Exception;
    public int updateTemplateDetail(TemplateFormBean templateFormBean) throws Exception;
    public int deleteTemplateDetail(TemplateFormBean templateFormBean) throws Exception;
    public List getAllTemplateDetail(TemplateFormBean templateFormBean) throws Exception;
    public List getUpdateData(String templateId , String usercode) throws Exception;
    public TemplateEntityBean convertFormBeanToEntityBean(TemplateFormBean objFrmBean);
    public List getTemplateTye() throws Exception;
    public List getCategory(String templateType) throws Exception;
    public List getDefaultTemplateDetail(TemplateFormBean templateFormBean) throws Exception;
}
