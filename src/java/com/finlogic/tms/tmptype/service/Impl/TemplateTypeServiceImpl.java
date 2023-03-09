/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.tmptype.service.Impl;

import com.finlogic.tms.tmptype.bean.TmptypeFormBean;
import com.finlogic.tms.tmptype.datamanager.TemplateTypeDataManager;
import com.finlogic.tms.tmptype.service.TemplateTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author njuser
 */
@Service
public class TemplateTypeServiceImpl implements TemplateTypeService{
    
    @Autowired
    TemplateTypeDataManager templateTypeDataManager;
    
    @Override
    public List GetTypeNameList() throws Exception
    {
        return templateTypeDataManager.GetTypeNameList();
    }
    
    @Override
    public List GetTypeList() throws Exception
    {
        return templateTypeDataManager.GetTypeList();
    }
    
    @Override
    public List gettmptypeData(String TmptypeID) throws Exception
    {
        return templateTypeDataManager.gettmptypeData(TmptypeID);
    }
    
    @Override
    public int insertTmpType(TmptypeFormBean tmptypeFormBean) throws Exception
    {
        return templateTypeDataManager.insertTmpType(tmptypeFormBean);
    }
    
    @Override
    public List getAllTmpType(TmptypeFormBean tmptypeFormBean) throws Exception
    {
        return templateTypeDataManager.getAllTmpType(tmptypeFormBean);
    }
       
    @Override
    public int editTmpType(TmptypeFormBean tmptypeFormBean) throws Exception
    {
        return templateTypeDataManager.editTmpType(tmptypeFormBean);
    }

    @Override
    public int deleteTmpType(String TmptypeId) throws Exception 
    {
        return templateTypeDataManager.deleteTmpType(TmptypeId);
    }
}
