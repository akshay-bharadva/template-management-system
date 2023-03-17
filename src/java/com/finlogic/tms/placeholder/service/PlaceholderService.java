/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.placeholder.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author njuser
 */
public interface PlaceholderService{
    
    public List templateTypeList(String usercode) throws Exception;
    
    public List templateReport(String templateType , String category , String usercode) throws Exception;
    
    public List categoryList(String templateType , String usercode) throws Exception;
    
    public List specificTemplateData(String templateId,String usercode) throws Exception;
    
    public int insertGeneratedExcelFileData(String usercode, String fileName, String body , int noOfPlaceholder , String placeholderList , String templateId) throws Exception;
    
    public List getGenerationIdFileName(String templateId) throws Exception;
    
    public int insertDownloadedExcelFileData(String usercode, String fileName, String generationId) throws Exception;
    
    public int insertUploadedExcelFileData(String usercode, String fileName , String data , String generationId) throws Exception;
    
    public List getImportedData(String usercode) throws Exception;
    
    public List getDataForSpecificUploadId(String usercode , String uploadId) throws Exception;
    
    public int pdfGenerationImpl(HttpServletRequest request) throws Exception;
    
    public List getPdfGenerationFileData(String usercode) throws Exception; 
} 
