/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.tmptype.datamanager;

import com.finlogic.tms.tmptype.bean.TmptypeFormBean;
import java.util.List;

/**
 *
 * @author njuser
 */
public interface TemplateTypeDataManager {
    
    public List GetTypeNameList() throws Exception;
    
    public List GetTypeList() throws Exception;
    
    public int insertTmpType(TmptypeFormBean tmptypeFormBean) throws Exception;
    
    public List getAllTmpType(TmptypeFormBean tmptypeFormBean) throws Exception;
    
    public List gettmptypeData(String TmptypeID) throws Exception;
    
    public int editTmpType(TmptypeFormBean tmptypeFormBean) throws Exception;
    
    public int deleteTmpType(String TmptypeId) throws Exception;


}
