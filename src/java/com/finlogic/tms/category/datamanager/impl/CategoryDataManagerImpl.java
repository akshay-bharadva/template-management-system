/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.category.datamanager.impl;

import com.finlogic.tms.category.bean.CategoryFormBean;
import com.finlogic.tms.category.datamanager.CategoryDataManager;
import com.finlogic.util.CommonMember;
import com.finlogic.util.persistence.SQLTranUtility;
import com.finlogic.util.persistence.SQLUtility;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
//new BeanPropertySqlParameterSource(categoryFormBean)
/**
 *
 * @author njuser
 */
@Repository(value = "CategoryDataManager")
public class CategoryDataManagerImpl implements CategoryDataManager {

    private final String CONNECTION_ALIAS = "njindiainvest_offline";

    private final SQLUtility sqlUtility = new SQLUtility();
    private final SQLTranUtility sqlTranUtility = new SQLTranUtility();

    @Override
    public List getTemplateType() throws Exception {
        StringBuilder query = new StringBuilder();
        //Map map = new HashMap();

        query.append("SELECT TEMPLATE_TYPE_ID,TEMPLATE_TYPE_NAME FROM TMS_TEMPLATE_TYPE; ");

        return sqlUtility.getList(CONNECTION_ALIAS, query.toString());
    }

    @Override
    public int insertCategoryDetail(CategoryFormBean categoryFormBean) throws Exception {
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        CommonMember.appendLogFile("Master 3 " + categoryFormBean.getCategory());
        query.append("INSERT INTO TMS_CATEGORY_TYPE (CATEGORY_NAME,TEMPLATE_TYPE_ID,ISACTIVE,ENTRY_DATE,USERCODE) VALUES");
        query.append(" (:CATEGORY_NAME,:TEMPLATE_TYPE_ID,:ISACTIVE,CURRENT_TIMESTAMP,:USERCODE) ");
        
        map.put("CATEGORY_NAME",categoryFormBean.getCategory());
        map.put("TEMPLATE_TYPE_ID", categoryFormBean.getCmbTemplateType());
        map.put("ISACTIVE",categoryFormBean.getChkActive());
        map.put("USERCODE", categoryFormBean.getUserCode());

        return sqlUtility.persist(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }
    
    @Override
    public List getAllCategoryDetail(CategoryFormBean categoryFormBean) throws Exception 
    {
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append("SELECT C.CATEGORY_ID,C.CATEGORY_NAME,T.TEMPLATE_TYPE_NAME,C.ENTRY_DATE FROM TMS_CATEGORY_TYPE C JOIN ");
        query.append("TMS_TEMPLATE_TYPE T ON C.TEMPLATE_TYPE_ID = T.TEMPLATE_TYPE_ID");
        if(categoryFormBean.getCmbFilterType() != null && !categoryFormBean.getCmbFilterType().equals("0"))
        {
            query.append(" WHERE T.TEMPLATE_TYPE_ID = :FILTER_TYPE");
            map.put("FILTER_TYPE",categoryFormBean.getCmbFilterType());
        }
        query.append(" ORDER BY T.TEMPLATE_TYPE_NAME, C.CATEGORY_NAME");
        CommonMember.appendLogFile("@Repository :: getAllCategoryDetail :: query :: " + query.toString());
        CommonMember.appendLogFile("@Repository :: getAllCategoryDetail :: map :: " + map);
        return sqlUtility.getList(CONNECTION_ALIAS, query.toString(),new MapSqlParameterSource(map));
    }
    
    @Override
    public List getCategoryData(String categoryId) throws Exception {
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append("SELECT C.TEMPLATE_TYPE_ID,C.CATEGORY_NAME,T.TEMPLATE_TYPE_NAME,C.ISACTIVE FROM TMS_CATEGORY_TYPE C JOIN TMS_TEMPLATE_TYPE T ON T.TEMPLATE_TYPE_ID = C.TEMPLATE_TYPE_ID WHERE C.CATEGORY_ID = :CATEGORY_ID");
    
        map.put("CATEGORY_ID", categoryId);
        CommonMember.appendLogFile("@Repository :: getCategoryData :: query :: " + query.toString());
        CommonMember.appendLogFile("@Repository :: getCategoryData :: map :: " + map);
        return sqlUtility.getList(CONNECTION_ALIAS, query.toString(),new MapSqlParameterSource(map));
    }
    
    @Override
    public int editCategoryDetail(CategoryFormBean categoryFormBean) throws Exception
    {
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append("UPDATE TMS_CATEGORY_TYPE SET TEMPLATE_TYPE_ID = :TEMPLATE_TYPE_ID,CATEGORY_NAME = :CATEGORY_NAME,ISACTIVE = :ISACTIVE,ENTRY_DATE = CURRENT_TIMESTAMP WHERE CATEGORY_ID = :CATEGORY_ID;");
        
        map.put("TEMPLATE_TYPE_ID", categoryFormBean.getCmbTemplateType());
        map.put("CATEGORY_NAME", categoryFormBean.getCategory());
        map.put("ISACTIVE", categoryFormBean.getChkActive());
        map.put("CATEGORY_ID", categoryFormBean.getCategoryID());
        CommonMember.appendLogFile("@Repository :: editCategoryDetail :: query :: " + query.toString());
        CommonMember.appendLogFile("@Repository :: editCategoryDetail :: map :: " + map);
        return sqlUtility.persist(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }
    
    @Override
    public int deleteCategoryDetail(String categoryId) throws Exception
    {
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append("DELETE FROM TMS_CATEGORY_TYPE WHERE CATEGORY_ID = :CATEGORY_ID");
        
        map.put("CATEGORY_ID", categoryId);
        
        CommonMember.appendLogFile("@Repository :: deleteCategoryDetail :: query :: " + query.toString());
        CommonMember.appendLogFile("@Repository :: deleteCategoryDetail :: map :: " + map);
        return sqlUtility.persist(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }
}
