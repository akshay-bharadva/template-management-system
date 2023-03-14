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
        
        query.append("INSERT INTO TMS_TEMPLATE(TEMPLATE_TYPE,CATEGORY,TITLE,BODY,ISACTIVE,ENTRY_DATE,USERCODE,ISDEFAULT)");     
        query.append(" VALUES(:TEMPLATE_TYPE,:CATEGORY,:TITLE,:BODY,:ISACTIVE,CURRENT_TIMESTAMP,:USERCODE,:ISDEFAULT)");
       
        map.put("TEMPLATE_TYPE",templateEntityBean.getTemplateType());
        map.put("CATEGORY", templateEntityBean.getCategory());
        map.put("TITLE",templateEntityBean.getTitle());
        map.put("BODY",templateEntityBean.getBody());
        map.put("ISACTIVE",templateEntityBean.getIsActive());
        map.put("USERCODE",templateEntityBean.getUsercode());
        if(templateEntityBean.getIsdefaultTemplate() != null && !templateEntityBean.getIsdefaultTemplate().equals(""))
        {
            map.put("ISDEFAULT",templateEntityBean.getIsdefaultTemplate());
        }
        else
        {
            map.put("ISDEFAULT", "0");
        }
        CommonMember.appendLogFile("@Repository :: insertTemplateDetail :: query :: " + query.toString());
        CommonMember.appendLogFile("@Repository :: insertTemplateDetail :: map :: " + map);
        return sqlUtility.persist(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }
    
    @Override
    public int updateTemplateDetail(TemplateEntityBean templateEntityBean) throws Exception {

        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append("UPDATE TMS_TEMPLATE SET TEMPLATE_TYPE=:TEMPLATE_TYPE,CATEGORY=:CATEGORY,TITLE=:TITLE,BODY=:BODY  ");
        query.append(" , ISACTIVE=:ISACTIVE, ENTRY_DATE=CURRENT_TIMESTAMP ");// TAILOER RECORD
        query.append(" WHERE TEMPLATE_ID = :TEMPLATE_ID AND USERCODE=:USERCODE ");
        
        map.put("TEMPLATE_TYPE",templateEntityBean.getTemplateType());
        map.put("CATEGORY", templateEntityBean.getCategory());
        map.put("TITLE",templateEntityBean.getTitle());
        map.put("BODY",templateEntityBean.getBody());
        map.put("ISACTIVE",templateEntityBean.getIsActive());
        map.put("USERCODE",templateEntityBean.getUsercode());
        map.put("TEMPLATE_ID", templateEntityBean.getHdnTemplateId());
        
//        CommonMember.appendLogFile("@Repository :: updateTemplateDetail :: query :: " + query.toString());
//        CommonMember.appendLogFile("@Repository :: updateTemplateDetail :: map :: " + map);
        return sqlUtility.persist(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }

    @Override
    public int deleteTemplateDetail(TemplateEntityBean templateEntityBean) throws Exception {
                
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        sqlTranUtility.openConn(CONNECTION_ALIAS);
        int result;
        try {
            query.append("DELETE FROM TMS_TEMPLATE WHERE TEMPLATE_ID = :TEMPLATE_ID AND USERCODE=:USERCODE");
              
            map.put("TEMPLATE_ID", templateEntityBean.getHdnTemplateId());
            map.put("USERCODE",templateEntityBean.getUsercode());

            result = sqlTranUtility.persist(query.toString(), new MapSqlParameterSource(map));
//            CommonMember.appendLogFile("@Repository :: deleteTemplateDetail :: query :: " + query.toString());
//            CommonMember.appendLogFile("@Repository :: deleteTemplateDetail :: map :: " + map);
//            CommonMember.appendLogFile("@Repository :: deleteTemplateDetail :: result :: " + result);
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
        
        query.append("SELECT T.TEMPLATE_ID , TT.TEMPLATE_TYPE_ID AS TEMPLATE_TYPE_ID , TT.TEMPLATE_TYPE_NAME AS TEMPLATE_TYPE , CT.CATEGORY_ID AS CATEGORY_ID, CT.CATEGORY_NAME AS CATEGORY ,T.TITLE,T.BODY, DATE_FORMAT(T.ENTRY_DATE,'%d-%m-%Y')ENTRY_DATE, UL.USERNAME FROM TMS_TEMPLATE T ");
        query.append(" INNER JOIN TMS_TEMPLATE_TYPE TT ON TT.TEMPLATE_TYPE_ID = T.TEMPLATE_TYPE");
        query.append(" INNER JOIN TMS_CATEGORY_TYPE CT ON CT.CATEGORY_ID = T.CATEGORY");
        query.append(" INNER JOIN TMS_USER_LOGIN UL ON UL.USERCODE = T.USERCODE");
        query.append(" WHERE T.USERCODE = :USERCODE ");
        
        if(templateEntityBean.getFilterType() != null && !templateEntityBean.getFilterType().equals("0"))
        {
            query.append(" AND T.TEMPLATE_TYPE = :FILTER_TYPE");
            map.put("FILTER_TYPE",templateEntityBean.getFilterType());
        }
        map.put("USERCODE", templateEntityBean.getUsercode());
//        map.put("ISDEFAULT", "0");
        query.append(" ORDER BY T.TEMPLATE_TYPE, T.CATEGORY");
        
//        CommonMember.appendLogFile("@Repository :: getAllTemplateDetail :: query :: " + query.toString());
//        CommonMember.appendLogFile("@Repository :: getAllTemplateDetail :: map :: " + map);
        return sqlUtility.getList(CONNECTION_ALIAS, query.toString(),new MapSqlParameterSource(map));
    }
    
    @Override
    public List getUpdateData(String templateId, String usercode) throws Exception {
        
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append("SELECT T.TEMPLATE_ID AS TEMPLATE_ID , TT.TEMPLATE_TYPE_ID AS TEMPLATE_TYPE_ID , CT.CATEGORY_ID AS CATEGORY_ID, CT.CATEGORY_NAME AS CATEGORY_NAME ,T.TITLE,T.BODY, T.ISDEFAULT AS ISDEFAULT FROM TMS_TEMPLATE T ");
        query.append(" INNER JOIN TMS_TEMPLATE_TYPE TT ON TT.TEMPLATE_TYPE_ID = T.TEMPLATE_TYPE ");
        query.append(" INNER JOIN TMS_CATEGORY_TYPE CT ON CT.CATEGORY_ID = T.CATEGORY ");
//        query.append(" INNER JOIN TMS_USER_LOGIN UL ON UL.USERCODE = T.USERCODE ");
        query.append(" WHERE T.TEMPLATE_ID = :TEMPLATE_ID");//T.USERCODE = :USERCODE
 
        map.put("TEMPLATE_ID", templateId);
        map.put("USERCODE",usercode);
//        CommonMember.appendLogFile("@Repository :: getUpdateData :: query :: " + query.toString());
//        CommonMember.appendLogFile("@Repository :: getUpdateData :: map :: " + map);
        return sqlUtility.getList(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }

    @Override
    public List getTemplateTye() throws Exception {
        
        StringBuilder query = new StringBuilder();
        
        query.append("SELECT TEMPLATE_TYPE_ID,TEMPLATE_TYPE_NAME FROM TMS_TEMPLATE_TYPE");

//        CommonMember.appendLogFile("@Repository :: getTemplateTye :: query :: " + query.toString());
        return sqlUtility.getList(CONNECTION_ALIAS, query.toString());
    }
    
    @Override
    public List getCategory(String templateType) throws Exception {

        StringBuilder query = new StringBuilder();
        Map map = new HashMap();

        query.append("SELECT CATEGORY_ID,CATEGORY_NAME FROM TMS_CATEGORY_TYPE ");
        query.append(" WHERE TEMPLATE_TYPE_ID = :TEMPLATE_TYPE_ID");

        map.put("TEMPLATE_TYPE_ID", templateType);

//        CommonMember.appendLogFile("@Repository :: getCategory :: query :: " + query.toString());
//        CommonMember.appendLogFile("@Repository :: getCategory :: map :: " + map);
        return sqlUtility.getList(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));

    }
    
    @Override
    public List getDefaultTemplateDetail(TemplateEntityBean templateEntityBean) throws Exception {
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append("SELECT T.TEMPLATE_ID , TT.TEMPLATE_TYPE_ID AS TEMPLATE_TYPE_ID , TT.TEMPLATE_TYPE_NAME AS TEMPLATE_TYPE , CT.CATEGORY_ID AS CATEGORY_ID, CT.CATEGORY_NAME AS CATEGORY ,T.TITLE,T.BODY, DATE_FORMAT(T.ENTRY_DATE,'%d-%m-%Y')ENTRY_DATE, UL.USERNAME FROM TMS_TEMPLATE T ");
        query.append(" INNER JOIN TMS_TEMPLATE_TYPE TT ON TT.TEMPLATE_TYPE_ID = T.TEMPLATE_TYPE");
        query.append(" INNER JOIN TMS_CATEGORY_TYPE CT ON CT.CATEGORY_ID = T.CATEGORY");
        query.append(" INNER JOIN TMS_USER_LOGIN UL ON UL.USERCODE = T.USERCODE");
        query.append(" WHERE ISDEFAULT = :ISDEFAULT");
        
        if(templateEntityBean.getFilterType() != null && !templateEntityBean.getFilterType().equals("0"))
        {
            query.append(" AND T.TEMPLATE_TYPE = :FILTER_TYPE");
            map.put("FILTER_TYPE",templateEntityBean.getFilterType());
        }
        map.put("USERCODE", templateEntityBean.getUsercode());
        map.put("ISDEFAULT", templateEntityBean.getIsdefaultTemplate());
        query.append(" ORDER BY T.ENTRY_DATE");
        
//        CommonMember.appendLogFile("@Repository :: getAllTemplateDetail :: query :: " + query.toString());
//        CommonMember.appendLogFile("@Repository :: getAllTemplateDetail :: map :: " + map);
        return sqlUtility.getList(CONNECTION_ALIAS, query.toString(),new MapSqlParameterSource(map));
    }
    
    
}
