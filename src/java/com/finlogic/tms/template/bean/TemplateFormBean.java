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
public class TemplateFormBean {
    
    private String hdnTemplateId;
    private String cmbTemplateType;
    private String categorysel;
    private String txtSubject;
    private String txtBody;
    private String chkActive;
    private String isdefaultTemplate;
    private String usercode;
    
    //---------For Filter -------------
    private String cmbFilterType;

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getCmbFilterType() {
        return cmbFilterType;
    }

    public void setCmbFilterType(String cmbFilterType) {
        this.cmbFilterType = cmbFilterType;
    }

    public String getCmbTemplateType() {
        return cmbTemplateType;
    }

    public String getHdnTemplateId() {
        return hdnTemplateId;
    }

    public void setHdnTemplateId(String hdnTemplateId) {
        this.hdnTemplateId = hdnTemplateId;
    }

    public void setCmbTemplateType(String cmbTemplateType) {
        this.cmbTemplateType = cmbTemplateType;
    }

    public String getCategorysel() {
        return categorysel;
    }

    public void setCategorysel(String categorysel) {
        this.categorysel = categorysel;
    }

    public String getTxtSubject() {
        return txtSubject;
    }

    public void setTxtSubject(String txtSubject) {
        this.txtSubject = txtSubject;
    }

    public String getTxtBody() {
        return txtBody;
    }

    public void setTxtBody(String txtBody) {
        this.txtBody = txtBody;
    }

    public String getChkActive() {
        return chkActive;
    }

    public void setChkActive(String chkActive) {
        this.chkActive = chkActive;
    }

    public String getIsdefaultTemplate() {
        return isdefaultTemplate;
    }

    public void setIsdefaultTemplate(String isdefaultTemplate) {
        this.isdefaultTemplate = isdefaultTemplate;
    }
}
