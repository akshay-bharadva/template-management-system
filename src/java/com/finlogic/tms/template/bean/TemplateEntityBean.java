/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.template.bean;

/**
 *
 * @author njuser
 */
public class TemplateEntityBean {
 
    private String hdnTemplateId;
    private String templateType;
    private String category;
    private String title;
    private String body;
    private String isActive;
    private String usercode; 
    private String isdefaultTemplate;
    
     //-----------for Filter-----------
    private String FilterType;

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getFilterType() {
        return FilterType;
    }

    public void setFilterType(String FilterType) {
        this.FilterType = FilterType;
    }

    public String getHdnTemplateId() {
        return hdnTemplateId;
    }

    public void setHdnTemplateId(String hdnTemplateId) {
        this.hdnTemplateId = hdnTemplateId;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getIsdefaultTemplate() {
        return isdefaultTemplate;
    }

    public void setIsdefaultTemplate(String isdefaultTemplate) {
        this.isdefaultTemplate = isdefaultTemplate;
    }
}
