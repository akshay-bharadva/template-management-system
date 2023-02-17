/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.template.datamanager.impl;

import com.finlogic.tms.template.bean.TemplateEntityBean;
import com.finlogic.tms.template.datamanager.TemplateDataManager;
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
@Repository(value = "TemplateDataManager")
public class TemplateDataManagerImpl implements TemplateDataManager {

    private final String CONNECTION_ALIAS = "njindiainvest_offline";

    private final SQLUtility sqlUtility = new SQLUtility();
    private final SQLTranUtility sqlTranUtility = new SQLTranUtility();

    
    @Override
    public int insertTemplateDetail(TemplateEntityBean templateEntityBean) throws Exception {
        
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append("INSERT INTO TMS_TEMPLATE(TEMPLATE_TYPE,CATEGORY,TITLE,BODY,ISACTIVE,ENTRY_DATE,USERCODE)");     
        query.append(" VALUES(:TEMPLATE_TYPE,:CATEGORY,:TITLE,:BODY,:ISACTIVE,CURRENT_TIMESTAMP,:USERCODE)");
       
        map.put("TEMPLATE_TYPE",templateEntityBean.getTemplateType());
        map.put("CATEGORY", templateEntityBean.getCategory());
        map.put("TITLE",templateEntityBean.getTitle());
        map.put("BODY",templateEntityBean.getBody());
        map.put("ISACTIVE",templateEntityBean.getIsActive());
        map.put("USERCODE","34add156-90aa-11ec-aced-005056b76057");
        CommonMember.appendLogFile("@Repository :: insertTemplateDetail :: query :: " + query.toString());
        CommonMember.appendLogFile("@Repository :: insertTemplateDetail :: map :: " + map);
        return sqlUtility.persist(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }
    
    @Override
    public int updateTemplateDetail(TemplateEntityBean templateEntityBean) throws Exception {

        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append("UPDATE TMS_TEMPLATE SET TEMPLATE_TYPE=:TEMPLATE_TYPE,CATEGORY=:CATEGORY,TITLE=:TITLE,BODY=:BODY  ");
        query.append(" , ISACTIVE=:ISACTIVE, ENTRY_DATE=CURRENT_TIMESTAMP, USERCODE=:USERCODE");// TAILOER RECORD
        query.append(" WHERE TEMPLATE_TYPE=:TMPTYPE AND CATEGORY=:TMPCATEGORY ");
        
        map.put("TEMPLATE_TYPE",templateEntityBean.getTemplateType());
        map.put("CATEGORY", templateEntityBean.getCategory());
        map.put("TITLE",templateEntityBean.getTitle());
        map.put("BODY",templateEntityBean.getBody());
        map.put("ISACTIVE",templateEntityBean.getIsActive());
        map.put("USERCODE","34add156-90aa-11ec-aced-005056b76057");
        map.put("TMPTYPE",templateEntityBean.getHdnTemplateType());
        map.put("TMPCATEGORY",templateEntityBean.getHdnTemplateCategory());
        
        CommonMember.appendLogFile("@Repository :: updateTemplateDetail :: query :: " + query.toString());
        CommonMember.appendLogFile("@Repository :: updateTemplateDetail :: map :: " + map);
        return sqlUtility.persist(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }

    @Override
    public int deleteTemplateDetail(TemplateEntityBean templateEntityBean) throws Exception {
                
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        sqlTranUtility.openConn(CONNECTION_ALIAS);
        int result;
        try {
            query.append("DELETE FROM TMS_TEMPLATE WHERE TEMPLATE_TYPE = :TMPTYPE AND CATEGORY = :TMPCATEGORY");

            map.put("TMPTYPE", templateEntityBean.getHdnTemplateType());
            map.put("TMPCATEGORY", templateEntityBean.getHdnTemplateCategory());
            
            CommonMember.appendLogFile("@Repository :: deleteTemplateDetail :: query :: " + query.toString());
            CommonMember.appendLogFile("@Repository :: deleteTemplateDetail :: map :: " + map);
            
            result = sqlTranUtility.persist(query.toString(), new MapSqlParameterSource(map));
            CommonMember.appendLogFile("@Repository :: deleteTemplateDetail :: result :: " + result);
            sqlTranUtility.commitChanges();
        }
        catch(Exception ex)
        {
            sqlTranUtility.rollbackChanges();
            throw new Exception(ex);
        }finally
        {
            sqlTranUtility.closeConn();
        }
        return result;
    }

    @Override
    public List getAllTemplateDetail(TemplateEntityBean templateEntityBean) throws Exception {
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append("SELECT T.TEMPLATE_TYPE, T.CATEGORY, T.TITLE, UL.USERNAME, DATE_FORMAT(T.ENTRY_DATE,'%d-%m-%Y')ENTRY_DATE FROM TMS_TEMPLATE T");
        query.append(" INNER JOIN TMS_USER_LOGIN UL ON UL.USERCODE = T.USERCODE");
        
        if(templateEntityBean.getFilterType() != null && !templateEntityBean.getFilterType().equals("0"))
        {
            query.append(" WHERE T.TEMPLATE_TYPE = :FILTER_TYPE");
            map.put("FILTER_TYPE",templateEntityBean.getFilterType());
        }
        query.append(" ORDER BY T.TEMPLATE_TYPE, T.CATEGORY");
        CommonMember.appendLogFile("@Repository :: getAllTemplateDetail :: query :: " + query.toString());
        CommonMember.appendLogFile("@Repository :: getAllTemplateDetail :: map :: " + map);
        return sqlUtility.getList(CONNECTION_ALIAS, query.toString(),new MapSqlParameterSource(map));
    }
    
    @Override
    public List getUpdateData(String templateType, String category) throws Exception {
        
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append("SELECT TEMPLATE_TYPE,CATEGORY, TITLE, BODY, ISACTIVE FROM TMS_TEMPLATE");
        query.append(" WHERE TEMPLATE_TYPE = :TEMPLATE_TYPE AND CATEGORY = :CATEGORY ");
        
        map.put("TEMPLATE_TYPE", templateType);
        map.put("CATEGORY",category);
        CommonMember.appendLogFile("@Repository :: getUpdateData :: query :: " + query.toString());
        CommonMember.appendLogFile("@Repository :: getUpdateData :: map :: " + map);
        return sqlUtility.getList(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }
}
