/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.placeholder.service.impl;

import com.finlogic.tms.placeholder.datamanager.PlaceholderDataManager;
import com.finlogic.tms.placeholder.service.PlaceholderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author njuser
 */
@Service(value = "PlaceholderService")
public class PlaceholderServiceImpl implements PlaceholderService{
    
    @Autowired
    PlaceholderDataManager placeHolderDataManager;
    
    @Override
    public List templateTypeList(String usercode) throws Exception
    {
        return placeHolderDataManager.templateTypeList(usercode);
    }
    
    @Override
    public List templateReport(String templateType , String category , String usercode) throws Exception
    {
        return placeHolderDataManager.templateReport(templateType, category, usercode);
    }
    
    @Override
    public List categoryList(String templateType , String usercode) throws Exception
    {
        return placeHolderDataManager.categoryList(templateType, usercode);
    }
    
    @Override
    public List specificTemplateData(String templateId,String usercode) throws Exception
    {
        return placeHolderDataManager.specificTemplateData(templateId, usercode);
    }
}
