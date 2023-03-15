/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.placeholder.datamanager.impl;

import com.finlogic.tms.placeholder.datamanager.PlaceholderDataManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.finlogic.util.CommonMember;
import com.finlogic.util.persistence.SQLUtility;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

/**
 *
 * @author njuser
 */
@Repository(value = "PlaceholderDataManager")
public class PlaceholderDataManagerImpl implements PlaceholderDataManager{
    private final String CONNECTION_ALIAS = "njindiainvest_offline";

    private final SQLUtility sqlUtility = new SQLUtility();
    
    @Override
    public List templateTypeList(String usercode) throws Exception
    {
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append(" select distinct(TT.TEMPLATE_TYPE_ID) , TT.TEMPLATE_TYPE_NAME , CT.CATEGORY_ID , CT.CATEGORY_NAME FROM TMS_TEMPLATE_TYPE TT ");
        query.append(" INNER JOIN TMS_TEMPLATE T ON TT.TEMPLATE_TYPE_ID = T.TEMPLATE_TYPE ");
        query.append(" INNER JOIN TMS_CATEGORY_TYPE CT ON CT.CATEGORY_ID = T.CATEGORY ");
        query.append(" WHERE T.USERCODE = :USERCODE ");
        
        
        map.put("USERCODE", usercode);
        
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl ::  templateTypeList :: query :: " + query.toString());
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl :: templateTypeList :: map :: " + map);
        
        return sqlUtility.getList(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }

    @Override
    public List templateReport(String templateType, String category, String usercode) throws Exception {
        
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append(" SELECT T.TEMPLATE_ID , TT.TEMPLATE_TYPE_NAME , CT.CATEGORY_NAME , T.TITLE , DATE_FORMAT(T.ENTRY_DATE,\"%d-%m-%Y\") AS ENTRY_DATE from TMS_TEMPLATE T ");
        query.append(" INNER JOIN TMS_TEMPLATE_TYPE TT ON TT.TEMPLATE_TYPE_ID = T.TEMPLATE_TYPE ");
        query.append(" INNER JOIN TMS_CATEGORY_TYPE CT ON CT.CATEGORY_ID = T.CATEGORY ");
        query.append(" WHERE T.USERCODE = :USERCODE ");
        
        
        if(templateType != null && !templateType.equals("0"))
        {
            query.append(" AND T.TEMPLATE_TYPE = :TEMPLATE_TYPE ");
            map.put("TEMPLATE_TYPE",templateType);
        }
        
        if(category != null && !category.equals("0"))
        {
            query.append(" AND T.CATEGORY = :CATEGORY ");
            map.put("CATEGORY",category);
        }
        
        
        map.put("USERCODE", usercode);
        
        
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl ::  templateReport :: query :: " + query.toString());
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl :: templateReport :: map :: " + map);
        
        return sqlUtility.getList(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }
    
    @Override
    public List categoryList(String templateType , String usercode) throws Exception
    {
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append(" select distinct(CT.CATEGORY_ID) , CT.CATEGORY_NAME FROM TMS_CATEGORY_TYPE CT  ");
        query.append(" INNER JOIN TMS_TEMPLATE T ON CT.CATEGORY_ID = T.CATEGORY ");
        query.append(" WHERE T.USERCODE = :USERCODE ");
        
        if(!templateType.equals("0"))
        {
            query.append(" AND T.TEMPLATE_TYPE = :TEMPLATE_TYPE");
        }
        map.put("USERCODE", usercode);
        map.put("TEMPLATE_TYPE", templateType);
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl ::  categoryList :: query :: " + query.toString());
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl :: categoryList :: map :: " + map);
        
        return sqlUtility.getList(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }
    
    @Override
    public List specificTemplateData(String templateId,String usercode) throws Exception
    {
        
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append(" select TT.TEMPLATE_TYPE_NAME , CT.CATEGORY_NAME , T.TITLE , T.BODY from TMS_TEMPLATE T ");
        query.append(" INNER JOIN TMS_TEMPLATE_TYPE TT ON TT.TEMPLATE_TYPE_ID = T.TEMPLATE_TYPE ");
        query.append(" INNER JOIN TMS_CATEGORY_TYPE CT ON CT.CATEGORY_ID = T.CATEGORY ");
        query.append(" WHERE T.TEMPLATE_ID = :TEMPLATE_ID AND T.USERCODE = :USERCODE ");
        
        
        map.put("USERCODE", usercode);
        map.put("TEMPLATE_ID", templateId);
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl ::  specificTemplateData :: query :: " + query.toString());
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl :: specificTemplateData :: map :: " + map);
        
        return sqlUtility.getList(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    
    }
}
