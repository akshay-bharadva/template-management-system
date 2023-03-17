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
        
        query.append(" select T.TEMPLATE_ID , TT.TEMPLATE_TYPE_NAME , CT.CATEGORY_NAME , T.TITLE , T.BODY from TMS_TEMPLATE T ");
        query.append(" INNER JOIN TMS_TEMPLATE_TYPE TT ON TT.TEMPLATE_TYPE_ID = T.TEMPLATE_TYPE ");
        query.append(" INNER JOIN TMS_CATEGORY_TYPE CT ON CT.CATEGORY_ID = T.CATEGORY ");
        query.append(" WHERE T.TEMPLATE_ID = :TEMPLATE_ID AND T.USERCODE = :USERCODE ");
        
        
        map.put("USERCODE", usercode);
        map.put("TEMPLATE_ID", templateId);
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl ::  specificTemplateData :: query :: " + query.toString());
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl :: specificTemplateData :: map :: " + map);
        
        return sqlUtility.getList(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    
    }

    @Override
    public int insertGeneratedExcelFileData(String usercode, String fileName, String body, int noOfPlaceholder, String placeholderList, String templateId) throws Exception {
        
        StringBuilder query = new StringBuilder();
        StringBuilder updateQuery = new StringBuilder();
        Map map = new HashMap();
        
        query.append("SELECT COUNT(*) FROM TMS_EXCEL_FF_GENERATION_TXN WHERE TEMPLATE_ID = :TEMPLATE_ID ");
        
        map.put("TEMPLATE_ID", templateId);
        int count = sqlUtility.getIntValue(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
        
        query.setLength(0);
        
        query.append(" INSERT INTO TMS_EXCEL_FF_GENERATION_TXN(USERCODE , FILE_NAME , BODY , GENERATION_DATE , NO_OF_PLACEHOLDER , PLACEHOLDERS , TEMPLATE_ID) ");
        query.append(" VALUES (:USERCODE , :FILE_NAME , :BODY , CURRENT_TIMESTAMP , :NO_OF_PLACEHOLDER , :PLACEHOLDERS , :TEMPLATE_ID )");
        
        updateQuery.append("UPDATE TMS_EXCEL_FF_GENERATION_TXN SET FILE_NAME = :FILE_NAME , ");
        updateQuery.append(" BODY = :BODY , ");
        updateQuery.append(" GENERATION_DATE = CURRENT_TIMESTAMP , ");
        updateQuery.append(" NO_OF_PLACEHOLDER = :NO_OF_PLACEHOLDER ,");
        updateQuery.append(" PLACEHOLDERS = :PLACEHOLDERS ");
        updateQuery.append(" WHERE TEMPLATE_ID = :TEMPLATE_ID");
        
        
        map.put("USERCODE", usercode);
        map.put("FILE_NAME", fileName);
        map.put("BODY", body);
        map.put("NO_OF_PLACEHOLDER", noOfPlaceholder);
        map.put("PLACEHOLDERS", placeholderList);
        
        if(count > 0)
        {
//            CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl ::  insertGeneratedExcelFileData :: updateQuery :: " + updateQuery.toString());
//            CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl :: insertGeneratedExcelFileData :: map :: " + map);
            return sqlUtility.persist(CONNECTION_ALIAS, updateQuery.toString(), new MapSqlParameterSource(map));
        }
        
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl ::  insertGeneratedExcelFileData :: query :: " + query.toString());
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl :: insertGeneratedExcelFileData :: map :: " + map);
        
        return sqlUtility.persist(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }

    @Override
    public List getGenerationIdFileName(String templateId) throws Exception {
        
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append(" SELECT GENERATION_ID , FILE_NAME , NO_OF_PLACEHOLDER FROM TMS_EXCEL_FF_GENERATION_TXN WHERE TEMPLATE_ID = :TEMPLATE_ID ");
        query.append(" ORDER BY GENERATION_DATE DESC LIMIT 1");
        
        map.put("TEMPLATE_ID", templateId);
        
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl ::  getGenerationIdFileName :: query :: " + query.toString());
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl :: getGenerationIdFileName :: map :: " + map);
        
        return sqlUtility.getList(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }
    
    @Override
    public int insertDownloadedExcelFileData(String usercode, String fileName, String generationId) throws Exception {
        
        StringBuilder query = new StringBuilder();
        StringBuilder updateQuery = new StringBuilder();
        Map map = new HashMap();
        
        query.append("SELECT COUNT(*) FROM TMS_EXCEL_FF_DOWNLOAD_TXN WHERE GENERATION_ID = :GENERATION_ID ");
        
        map.put("GENERATION_ID", generationId);
        int count = sqlUtility.getIntValue(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
        
        query.setLength(0);
        
        query.append(" INSERT INTO TMS_EXCEL_FF_DOWNLOAD_TXN(USERCODE , FILE_NAME , DOWNLOAD_DATE , GENERATION_ID) ");
        query.append(" VALUES (:USERCODE , :FILE_NAME , CURRENT_TIMESTAMP , :GENERATION_ID )");
        
        updateQuery.append("UPDATE TMS_EXCEL_FF_DOWNLOAD_TXN SET FILE_NAME = :FILE_NAME , ");
        updateQuery.append(" DOWNLOAD_DATE = CURRENT_TIMESTAMP ");
        updateQuery.append(" WHERE GENERATION_ID = :GENERATION_ID");
        
        
        map.put("USERCODE", usercode);
        map.put("FILE_NAME", fileName);
        
        if(count > 0)
        {
//            CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl ::  insertDownloadedExcelFileData :: updateQuery :: " + updateQuery.toString());
//            CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl :: insertDownloadedExcelFileData :: map :: " + map);
            return sqlUtility.persist(CONNECTION_ALIAS, updateQuery.toString(), new MapSqlParameterSource(map));
        }
        
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl ::  insertDownloadedExcelFileData :: query :: " + query.toString());
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl :: insertDownloadedExcelFileData :: map :: " + map);
        
        return sqlUtility.persist(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }

    @Override
    public int insertUploadedExcelFileData(String usercode, String fileName, String data , String generationId) throws Exception {
        
        StringBuilder query = new StringBuilder();
        StringBuilder updateQuery = new StringBuilder();
        Map map = new HashMap();
        
        query.append("SELECT COUNT(*) FROM TMS_EXCELFILE_UPLOAD_TXN WHERE GENERATION_ID = :GENERATION_ID ");
        map.put("GENERATION_ID", generationId);
        
        int count = sqlUtility.getIntValue(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
        
        
        query.setLength(0);
        
        query.append(" INSERT INTO TMS_EXCELFILE_UPLOAD_TXN(USERCODE , FILE_NAME , EXCELFILE_DATA ,UPLOAD_DATE , GENERATION_ID) ");
        query.append(" VALUES (:USERCODE , :FILE_NAME , :EXCELFILE_DATA , CURRENT_TIMESTAMP , :GENERATION_ID ) ");
        
        updateQuery.append("UPDATE TMS_EXCELFILE_UPLOAD_TXN SET FILE_NAME = :FILE_NAME , ");
        updateQuery.append(" EXCELFILE_DATA = :EXCELFILE_DATA , ");
        updateQuery.append(" UPLOAD_DATE = CURRENT_TIMESTAMP ");
        updateQuery.append(" WHERE GENERATION_ID = :GENERATION_ID");
        
        map.put("USERCODE", usercode);
        map.put("FILE_NAME", fileName);
        map.put("EXCELFILE_DATA" , data);
        
        if(count > 0)
        {
//            CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl ::  insertUploadedExcelFileData :: updateQuery :: " + updateQuery.toString());
//            CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl :: insertUploadedExcelFileData :: map :: " + map);
            return sqlUtility.persist(CONNECTION_ALIAS, updateQuery.toString(), new MapSqlParameterSource(map));
        }
        
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl ::  insertUploadedExcelFileData :: query :: " + query.toString());
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl :: insertUploadedExcelFileData :: map :: " + map);
        
        return sqlUtility.persist(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));

    }
    
    @Override
    public List getImportedData(String usercode) throws Exception {
        
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append(" SELECT G.TEMPLATE_ID , TT.TEMPLATE_TYPE_NAME , CT.CATEGORY_NAME , T.TITLE , U.UPLOAD_ID FROM TMS_EXCELFILE_UPLOAD_TXN U ");
        query.append(" INNER JOIN TMS_EXCEL_FF_GENERATION_TXN G ON G.GENERATION_ID = U.GENERATION_ID ");
        query.append(" INNER JOIN TMS_TEMPLATE T ON T.TEMPLATE_ID = G.TEMPLATE_ID ");
        query.append(" INNER JOIN TMS_CATEGORY_TYPE CT ON CT.CATEGORY_ID = T.CATEGORY ");
        query.append(" INNER JOIN TMS_TEMPLATE_TYPE TT ON TT.TEMPLATE_TYPE_ID = T.TEMPLATE_TYPE");
        query.append(" WHERE G.USERCODE = :USERCODE");
        
        map.put("USERCODE", usercode);
        
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl ::  getImportedData :: query :: " + query.toString());
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl :: getImportedData :: map :: " + map);
        
        return sqlUtility.getList(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }
    
    
    @Override
    public List getDataForSpecificUploadId(String usercode , String uploadId) throws Exception {
        
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append(" SELECT G.TEMPLATE_ID , TT.TEMPLATE_TYPE_NAME , CT.CATEGORY_NAME , T.TITLE , G.BODY , U.UPLOAD_ID , U.EXCELFILE_DATA FROM TMS_EXCELFILE_UPLOAD_TXN U ");
        query.append(" INNER JOIN TMS_EXCEL_FF_GENERATION_TXN G ON G.GENERATION_ID = U.GENERATION_ID ");
        query.append(" INNER JOIN TMS_TEMPLATE T ON T.TEMPLATE_ID = G.TEMPLATE_ID ");
        query.append(" INNER JOIN TMS_CATEGORY_TYPE CT ON CT.CATEGORY_ID = T.CATEGORY ");
        query.append(" INNER JOIN TMS_TEMPLATE_TYPE TT ON TT.TEMPLATE_TYPE_ID = T.TEMPLATE_TYPE");
        query.append(" WHERE G.USERCODE = :USERCODE AND UPLOAD_ID = :UPLOAD_ID");
        
        map.put("USERCODE", usercode);
        map.put("UPLOAD_ID", uploadId);
        
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl ::  getDataForSpecificUploadId :: query :: " + query.toString());
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl :: getDataForSpecificUploadId :: map :: " + map);
        
        return sqlUtility.getList(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }
    
    @Override
    public int insertPdfGenerationFileData(String usercode , String fileName , String data) throws Exception {
        
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append(" INSERT INTO TMS_PDF_GENERATION_TXN(USERCODE , FILE_NAME , DATA , GENERATION_DATE) ");
        query.append(" VALUES (:USERCODE , :FILE_NAME , :DATA , CURRENT_TIMESTAMP)");
        
        map.put("USERCODE", usercode);
        map.put("FILE_NAME", fileName);
        map.put("DATA", data);
        
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl ::  insertPdfGenerationFileData :: query :: " + query.toString());
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl :: insertPdfGenerationFileData :: map :: " + map);
        
        return sqlUtility.persist(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }
    
    @Override
    public List getPdfGenerationFileData(String usercode) throws Exception {
        
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append(" select distinct(FILE_NAME) , DATE_FORMAT(GENERATION_DATE,\"%d-%m-%Y\") GENERATION_DATE FROM TMS_PDF_GENERATION_TXN ");
        query.append(" WHERE USERCODE = :USERCODE");
        
        map.put("USERCODE", usercode);
        
        
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl ::  getPdfGenerationFileData :: query :: " + query.toString());
//        CommonMember.appendLogFile("@Repository :: PlaceholderDataManagerImpl :: getPdfGenerationFileData :: map :: " + map);
        
        return sqlUtility.getList(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }
    
    
}
