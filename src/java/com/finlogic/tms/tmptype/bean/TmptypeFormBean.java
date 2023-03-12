/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.tmptype.bean;

/**
 *
 * @author njuser
 */
public class TmptypeFormBean {
    
    public String tmptypeID;
    public String templateType;
    public String chkActive;
    public String userCode = "34add156-90aa-11ec-aced-005056b76057";
//    public String task;
    
    //---------For Filter -------------
    private String cmbFilterType;
    
    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getChkActive() {
        return chkActive;
    }

    public void setChkActive(String chkActive) {
        this.chkActive = chkActive;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getCmbFilterType() {
        return cmbFilterType;
    }

    public void setCmbFilterType(String cmbFilterType) {
        this.cmbFilterType = cmbFilterType;
    }

    public String getTmptypeID() {
        return tmptypeID;
    }

    public void setTmptypeID(String tmptypeID) {
        this.tmptypeID = tmptypeID;
    }
    
    
    @Override
    public String toString() {
        return "TmptypeFormBean{" + "templateType=" + templateType + ", chkActive=" + chkActive + '}';
    }

    

    
    
    
    
}
