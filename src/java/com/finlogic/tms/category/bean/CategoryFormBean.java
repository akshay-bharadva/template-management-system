/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.category.bean;

/**
 *
 * @author njuser
 */
public class CategoryFormBean {

    public String cmbTemplateType;
    public String category;
    public String chkActive;
    public String userCode;
    public String categoryID;
    public String isdefaultTemplate;
    
    //---------For Filter -------------
    private String cmbFilterType;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getCmbTemplateType() {
        return cmbTemplateType;
    }

    public void setCmbTemplateType(String cmbTemplateType) {
        this.cmbTemplateType = cmbTemplateType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getChkActive() {
        return chkActive;
    }

    public void setChkActive(String chkActive) {
        this.chkActive = chkActive;
    }

    public String getCmbFilterType() {
        return cmbFilterType;
    }

    public void setCmbFilterType(String cmbFilterType) {
        this.cmbFilterType = cmbFilterType;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getIsdefaultTemplate() {
        return isdefaultTemplate;
    }

    public void setIsdefaultTemplate(String isdefaultTemplate) {
        this.isdefaultTemplate = isdefaultTemplate;
    }
    
    @Override
    public String toString() {
        return "CategoryFormBean{" + "cmbTemplateType=" + cmbTemplateType + ", category=" + category + ", chkActive=" + chkActive + ", categoryID=" + categoryID + ", cmbFilterType=" + cmbFilterType + '}';
    }
    
    
        

}
