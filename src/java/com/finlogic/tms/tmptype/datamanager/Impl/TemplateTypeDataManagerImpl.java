/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.tmptype.datamanager.Impl;

import com.finlogic.tms.tmptype.bean.TmptypeFormBean;
import com.finlogic.tms.tmptype.datamanager.TemplateTypeDataManager;
import com.finlogic.util.CommonMember;
import com.finlogic.util.persistence.SQLTranUtility;
import com.finlogic.util.persistence.SQLUtility;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author njuser
 */
@Repository
public class TemplateTypeDataManagerImpl implements TemplateTypeDataManager {
    
    private final String CONNECTION_ALIAS = "njindiainvest_offline";

    private final SQLUtility sqlUtility = new SQLUtility();
    private final SQLTranUtility sqlTranUtility = new SQLTranUtility();
    
    @Override
    public List GetTypeNameList() throws Exception
    {
        StringBuilder query = new StringBuilder();
        
        query.append("SELECT TEMPLATE_TYPE_NAME FROM TMS_TEMPLATE_TYPE");
        
        return sqlUtility.getList(CONNECTION_ALIAS, query.toString());
    }
    @Override
    public List GetTypeList() throws Exception
    {
        StringBuilder query = new StringBuilder();
        
        query.append("SELECT TEMPLATE_TYPE_ID,TEMPLATE_TYPE_NAME FROM TMS_TEMPLATE_TYPE");
        
        return sqlUtility.getList(CONNECTION_ALIAS, query.toString());
    }
    
    @Override
    public List gettmptypeData(TmptypeFormBean tmptypeFormBean) throws Exception
    {
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        query.append("SELECT TEMPLATE_TYPE_ID,TEMPLATE_TYPE_NAME,ISACTIVE FROM TMS_TEMPLATE_TYPE WHERE TEMPLATE_TYPE_ID = :TEMPLATE_TYPE_ID AND USERCODE = :USERCODE");
        
        map.put("TEMPLATE_TYPE_ID",tmptypeFormBean.getTmptypeID());
        map.put("USERCODE",tmptypeFormBean.getUserCode());
//        CommonMember.appendLogFile("@Repository :: gettmptypeData :: map :: "+map);

        return sqlUtility.getList(CONNECTION_ALIAS, query.toString(),new MapSqlParameterSource(map));
    }
    @Override
    public int insertTmpType(TmptypeFormBean tmptypeFormBean) throws Exception
    {
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append("INSERT INTO TMS_TEMPLATE_TYPE(TEMPLATE_TYPE_NAME,ISACTIVE,ENTRY_DATE,USERCODE) VALUES(:TEMPLATE_TYPE_NAME,:ISACTIVE,CURRENT_TIMESTAMP,:USERCODE)");

        map.put("TEMPLATE_TYPE_NAME",tmptypeFormBean.getTemplateType().toUpperCase());
        map.put("ISACTIVE",tmptypeFormBean.getChkActive());
        map.put("USERCODE",tmptypeFormBean.getUserCode());
//        CommonMember.appendLogFile("@Repository :: insertTmpType :: map :: "+map);

        return sqlUtility.persist(CONNECTION_ALIAS, query.toString(),new MapSqlParameterSource(map));
    }
    
    @Override
    public List getAllTmpType(TmptypeFormBean tmptypeFormBean) throws Exception
    {
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append("SELECT TEMPLATE_TYPE_ID,TEMPLATE_TYPE_NAME,DATE_FORMAT(ENTRY_DATE,'%d-%m-%Y')ENTRY_DATE FROM TMS_TEMPLATE_TYPE WHERE USERCODE = :USERCODE ");
        if(tmptypeFormBean.getCmbFilterType() != null && !tmptypeFormBean.getCmbFilterType().equals("0"))
        {
            query.append("AND TEMPLATE_TYPE_ID = :FILTER_TYPE");
            map.put("FILTER_TYPE",tmptypeFormBean.getCmbFilterType());
        }
        query.append(" ORDER BY TEMPLATE_TYPE_NAME");
        map.put("USERCODE", tmptypeFormBean.getUserCode());

//        CommonMember.appendLogFile("@repository :: getAllTmpType :: filtertype : "+ tmptypeFormBean.getCmbFilterType());
//        CommonMember.appendLogFile("@repository :: getAllTmpType :: map : "+ map);
        return sqlUtility.getList(CONNECTION_ALIAS, query.toString(),new MapSqlParameterSource(map));
    }
    
    @Override
    public int editTmpType(TmptypeFormBean tmptypeFormBean) throws Exception
    {
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append("UPDATE TMS_TEMPLATE_TYPE SET TEMPLATE_TYPE_NAME = :TEMPLATE_TYPE_NAME,ISACTIVE = :ISACTIVE,");
        query.append("ENTRY_DATE = CURRENT_TIMESTAMP WHERE TEMPLATE_TYPE_ID = :TEMPLATE_TYPE_ID AND USERCODE = :USERCODE; ");
        
        map.put("TEMPLATE_TYPE_NAME", tmptypeFormBean.getTemplateType().toUpperCase());
        map.put("ISACTIVE", tmptypeFormBean.getChkActive());
        map.put("USERCODE", tmptypeFormBean.getUserCode());
        map.put("TEMPLATE_TYPE_ID", tmptypeFormBean.getTmptypeID());
        
//        CommonMember.appendLogFile("@repository :: editTmpType :: map : "+ map);
        return sqlUtility.persist(CONNECTION_ALIAS, query.toString(),new MapSqlParameterSource(map));
    }
    
    @Override
    public int deleteTmpType(TmptypeFormBean tmptypeFormBean) throws Exception
    {
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append("DELETE FROM TMS_TEMPLATE_TYPE WHERE TEMPLATE_TYPE_ID = :TEMPLATE_TYPE_ID AND USERCODE = :USERCODE");
        
        map.put("TEMPLATE_TYPE_ID", tmptypeFormBean.getTmptypeID());
        map.put("USERCODE", tmptypeFormBean.getUserCode());
//        CommonMember.appendLogFile("@repository :: deleteTmpType :: map : "+ map);
        return sqlUtility.persist(CONNECTION_ALIAS, query.toString(),new MapSqlParameterSource(map));
    }


}
