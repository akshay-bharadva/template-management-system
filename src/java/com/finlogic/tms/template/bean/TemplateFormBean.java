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
    
    private String hdnTemplateType;
    private String hdnTemplateCategory;
    private String cmbTemplateType;
    private String txtCategory;
    private String txtSubject;
    private String txtBody;
    private String chkActive;
    
    //---------For Filter -------------
    private String cmbFilterType;

    public String getCmbFilterType() {
        return cmbFilterType;
    }

    public void setCmbFilterType(String cmbFilterType) {
        this.cmbFilterType = cmbFilterType;
    }

    public String getCmbTemplateType() {
        return cmbTemplateType;
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

    public void setCmbTemplateType(String cmbTemplateType) {
        this.cmbTemplateType = cmbTemplateType;
    }

    public String getTxtCategory() {
        return txtCategory;
    }

    public void setTxtCategory(String txtCategory) {
        this.txtCategory = txtCategory;
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
}
