/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.placeholder.service.impl;

import com.finlogic.tms.placeholder.datamanager.PlaceholderDataManager;
import com.finlogic.tms.placeholder.service.PlaceholderService;
import com.finlogic.util.CommonUtil;
import com.finlogic.util.JSONUtility;
import com.finlogic.util.PDFUtility;
import com.finlogic.util.RegxUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;
import org.springframework.stereotype.Service;


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
    
    @Override
    public int insertGeneratedExcelFileData(String usercode, String fileName, String body , int noOfPlaceholder , String placeholderList , String templateId) throws Exception
    {
        return placeHolderDataManager.insertGeneratedExcelFileData(usercode, fileName, body, noOfPlaceholder, placeholderList, templateId);
    }
    
    @Override
    public List getGenerationIdFileName(String templateId) throws Exception
    {
        return placeHolderDataManager.getGenerationIdFileName(templateId);
    }
    
    @Override
    public int insertDownloadedExcelFileData(String usercode, String fileName, String generationId) throws Exception
    {
        return placeHolderDataManager.insertDownloadedExcelFileData(usercode, fileName, generationId);
    }
    
    @Override
    public int insertUploadedExcelFileData(String usercode, String fileName , String data , String generationId) throws Exception
    {
        return placeHolderDataManager.insertUploadedExcelFileData(usercode, fileName , data , generationId);
    }
    
    @Override
    public List getImportedData(String usercode) throws Exception
    {
        return placeHolderDataManager.getImportedData(usercode);
    }
    
    @Override
    public List getDataForSpecificUploadId(String usercode , String uploadId) throws Exception
    {
        return placeHolderDataManager.getDataForSpecificUploadId(usercode, uploadId);
    }
    
    @Override
    public int pdfGenerationImpl(HttpServletRequest request) throws Exception
    {
            JSONUtility json = new JSONUtility();
            RegxUtil regx = new RegxUtil();
            PDFUtility pdf = new PDFUtility();
            
            int status = 0;
        
            String uploadId = request.getParameter("uploadID");
            String recordId = request.getParameter("recordID");
            String usercode = CommonUtil.getUserCode(request);
            
            List DataforSpecificUploadId = placeHolderDataManager.getDataForSpecificUploadId(usercode,uploadId);
            HashMap map = (HashMap) DataforSpecificUploadId.get(0);
            
            String templateBody = (String) map.get("BODY");
            String fileData = map.get("EXCELFILE_DATA").toString();
            String pdfName = map.get("TITLE").toString();
            
            JSONArray array = (JSONArray) new JSONParser().parse(fileData);
//            CommonMember.appendLogFile("DATA : " + array);
            JSONObject o = json.findByAutoGeneratedID(array, recordId);
            String refNo = (String) o.get("_id");
            Map<String, String> userMapData = json.toMap(o);
            userMapData = json.getPlaceholderData(userMapData);

            String output = regx.regx((HashMap<String, String>) userMapData, templateBody);
//            CommonMember.appendLogFile("OUTPUT: " + output);
//            CommonMember.appendLogFile("RefNo: " + refNo);
            String fileName = pdf.generatePDF(refNo, output , pdfName);
            if(fileName != null && !fileName.equals(""))
            {
               status = placeHolderDataManager.insertPdfGenerationFileData(usercode, fileName, fileData);
            }
            return status;
    }
    
    @Override
    public List getPdfGenerationFileData(String usercode) throws Exception
    {
       return placeHolderDataManager.getPdfGenerationFileData(usercode);
    }
}
