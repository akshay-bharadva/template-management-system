/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.template.datamanager;

import com.finlogic.tms.template.bean.TemplateEntityBean;
import java.util.List;

/**
 *
 * @author njuser
 */
public interface TemplateDataManager {
    
    public int insertTemplateDetail(TemplateEntityBean templateEntityBean) throws Exception;
    public int updateTemplateDetail(TemplateEntityBean templateEntityBean) throws Exception;
    public int deleteTemplateDetail(TemplateEntityBean templateEntityBean) throws Exception;
    public List getAllTemplateDetail(TemplateEntityBean templateEntityBean)throws Exception;
    public List getUpdateData(String templateId, String usercode)throws Exception;
    public List getTemplateTye() throws Exception;
    public List getCategory(String templateType) throws Exception;
    public List getDefaultTemplateDetail(TemplateEntityBean templateEntityBean)throws Exception;
}
