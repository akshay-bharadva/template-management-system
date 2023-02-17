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
 
    private String hdnTemplateType;
    private String hdnTemplateCategory;
    private String templateType;
    private String category;
    private String title;
    private String body;
    private String isActive;
    
     //-----------for Filter-----------
    private String FilterType;

    public String getFilterType() {
        return FilterType;
    }

    public void setFilterType(String FilterType) {
        this.FilterType = FilterType;
    }

    public String getHdnTemplateType() {
        return hdnTemplateType;
    }

    public void setHdnTemplateType(String hdnTemplateType) {
        this.hdnTemplateType = hdnTemplateType;
    }

    public String getHdnTemplateCategory() {
        return hdnTemplateCategory;
    }

    public void setHdnTemplateCategory(String hdnTemplateCategory) {
        this.hdnTemplateCategory = hdnTemplateCategory;
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
}
