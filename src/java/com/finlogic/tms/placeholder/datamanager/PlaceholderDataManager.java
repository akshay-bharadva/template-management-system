/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.placeholder.datamanager;

import java.util.List;

/**
 *
 * @author njuser
 */
public interface PlaceholderDataManager {
 
    public List templateTypeList(String usercode) throws Exception;

    public List templateReport(String templateType , String category , String usercode) throws Exception;
    
    public List categoryList(String templateType , String usercode) throws Exception;
    
    public List specificTemplateData(String templateId,String usercode) throws Exception;
}
