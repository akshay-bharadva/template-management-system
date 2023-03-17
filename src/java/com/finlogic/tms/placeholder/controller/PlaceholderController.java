/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.placeholder.controller;

import com.finlogic.tms.placeholder.service.PlaceholderService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.finlogic.util.CommonUtil;
import com.finlogic.util.CommonMember;
import com.finlogic.util.DownloadFileUtil;
import com.finlogic.util.ExcelUtil;
import com.finlogic.util.JSONUtility;
import com.finlogic.util.RegxUtil;
import com.finlogic.util.PDFUtility;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author njuser
 */
@Controller
@RequestMapping(value = "placeholder.fin")
public class PlaceholderController {

    @Autowired
    PlaceholderService placeholderService;
    
    @Autowired
    RegxUtil regxUtil;
    
    @Autowired
    ExcelUtil excelUtil; 
    
    @Autowired 
    DownloadFileUtil downloadFileUtil;

    @RequestMapping(params="cmdAction=loadPlaceholder" , method = {RequestMethod.GET ,RequestMethod.POST})
    public ModelAndView loadPlaceholder(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("placeholder/placeholder");
        try {
            String usercode = CommonUtil.getUserCode(request);
            List templateTypeList = placeholderService.templateTypeList(usercode);
            if(!templateTypeList.isEmpty())
            {
                modelAndView.addObject("templateTypeList", templateTypeList);
                modelAndView.addObject("status", "1");
            }
            else
            {
                modelAndView.addObject("status", "0");
            }
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params="cmdAction=showTemplateReport" , method = {RequestMethod.GET , RequestMethod.POST})
    public ModelAndView getAllTemplateDetail(HttpServletRequest request , HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView("placeholder/placeholderStatus");
        try {
            String templateType = request.getParameter("templateTypeValue");
            String category = request.getParameter("categoryValue");
            String usercode = CommonUtil.getUserCode(request);
            
            List templateReport = placeholderService.templateReport(templateType, category, usercode);
            if(!templateReport.isEmpty())
            {
                modelAndView.addObject("status", "1");
                modelAndView.addObject("templateList", templateReport);
            }
            else
            {
                modelAndView.addObject("status", "0");
            }
            modelAndView.addObject("Action", "viewTemplateReport");
//            CommonMember.appendLogFile("@TemplateController :: getAllTemplateDetail :: TemplateList :: " + templateList + " :: filterType :: " + filterType + " :: usercode :: " + templateFormBean.getUsercode());
            
            
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }

    @RequestMapping(params="cmdAction=loadPlaceholderCategory" , method = {RequestMethod.GET ,RequestMethod.POST})
    public ModelAndView loadPlaceholderCategory(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("placeholder/placeholderStatus");
        try {
            String usercode = CommonUtil.getUserCode(request);
            String templateType = request.getParameter("templateTypeValue");
            List categoryTypeList = placeholderService.categoryList(templateType, usercode);
            if(!categoryTypeList.isEmpty())
            {
                modelAndView.addObject("categoryTypeList", categoryTypeList);
                modelAndView.addObject("status", "1");
            }
            else
            {
                modelAndView.addObject("status", "0");
            }
            modelAndView.addObject("Action", "categoryList");
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params="cmdAction=generateFileWithPlaceholderAsHeader" , method = {RequestMethod.GET ,RequestMethod.POST})
    public ModelAndView generateFileWithPlaceholderAsHeader(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("placeholder/placeholderStatus");
        try {
            String usercode = CommonUtil.getUserCode(request);
            String templateId = request.getParameter("templateId");
            
            List templateData = placeholderService.specificTemplateData(templateId, usercode);
            
            //Trace PlaceHolder
            HashMap map = (HashMap)templateData.get(0);
            List<String> listOfPlaceholder = regxUtil.getPlaceholderList(map.get("BODY").toString());
            
//            CommonMember.appendLogFile("List of Placeholder : " + listOfPlaceholder + " count :- " + listOfPlaceholder.size()); 
            
            //Generate Excel Of PlaceHolder
            String fileName = excelUtil.generateExcelFromList(map.get("TITLE").toString(), listOfPlaceholder);
            
            int insertStatus = placeholderService.insertGeneratedExcelFileData(usercode, fileName, map.get("BODY").toString(), listOfPlaceholder.size() , listOfPlaceholder.toString() , templateId);
            if(!templateData.isEmpty() && insertStatus > 0)
            {
                modelAndView.addObject("fileName", fileName);
                modelAndView.addObject("templateData", templateData);
                modelAndView.addObject("status", "1");
            }
            else
            {
                modelAndView.addObject("status", "0");
            }
            modelAndView.addObject("Action", "templateDataList");
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params="cmdAction=downloadFileFormat" , method = {RequestMethod.GET ,RequestMethod.POST})
    public void downloadFileFormat(HttpServletRequest request , HttpServletResponse response)
    {
        String templateId = request.getParameter("templateId");
        String usercode = CommonUtil.getUserCode(request);
        try {
            List generationList = placeholderService.getGenerationIdFileName(templateId);
            HashMap map = (HashMap)generationList.get(0);
            String fileName = map.get("FILE_NAME").toString();
            String generationId = map.get("GENERATION_ID").toString();
            downloadFileUtil.downloadFile(response, fileName , CommonUtil.storageFilePath());
            int insertStatus = placeholderService.insertDownloadedExcelFileData(usercode , fileName , generationId);

//            CommonMember.appendLogFile("Download file Successfully ");
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
    }
    
    @RequestMapping(params="cmdAction=uploadExcelFileWithData" , method = {RequestMethod.POST})
    public ModelAndView uploadExcelFileWithData(HttpServletRequest request , HttpServletResponse response ,@RequestParam("file") CommonsMultipartFile file)
    {
        ModelAndView modelAndView = new ModelAndView("placeholder/placeholderStatus");
        String fileName = file.getOriginalFilename();
        try {
             
            String templateId = request.getParameter("templateId");
            String filePath = CommonUtil.uploadedFilePath()+ fileName;
            String usercode = CommonUtil.getUserCode(request);
            
            
            List data = placeholderService.getGenerationIdFileName(templateId);
            HashMap map = (HashMap)data.get(0);
            file.transferTo(new File(filePath));
            
            int noOfPlaceholder = Integer.parseInt(map.get("NO_OF_PLACEHOLDER").toString());
            String generationId = map.get("GENERATION_ID").toString();
//            CommonMember.appendLogFile("column:- " + Integer.parseInt(map.get("NO_OF_PLACEHOLDER").toString()));
            String errorStatus = excelUtil.validateExcel(filePath , noOfPlaceholder);
            
            if(errorStatus.equals("0"))
            {
                File f = new File(filePath);
                f.delete();
//                CommonMember.appendLogFile("file deleted successfully");
            }
            else
            {
                List dataList = excelUtil.readExcel(filePath , noOfPlaceholder);
//                CommonMember.appendLogFile("data" + dataList.toString());
                JSONUtility json = new JSONUtility();
                int uploadStatus = placeholderService.insertUploadedExcelFileData(usercode, fileName, json.getJSONString(dataList), generationId);

//                int uploadStatus = placeholderService.insertUploadedExcelFileData(usercode, fileName, dataList.toString(), generationId);
//                CommonMember.appendLogFile("uploadStatus :- " + uploadStatus);
                
            }
            modelAndView.addObject("Action", "uploadFileStatus");
            modelAndView.addObject("status",errorStatus );                        
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params="cmdAction=downloadFileError" , method = {RequestMethod.GET ,RequestMethod.POST})
    public void downloadFileError(HttpServletRequest request , HttpServletResponse response)
    {
        
        try {
            String fileName = "error.xlsx";
            downloadFileUtil.downloadFile(response, fileName , CommonUtil.errorFilePath());
            
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
    }
    
    @RequestMapping(params="cmdAction=loadImportedData" , method = {RequestMethod.GET ,RequestMethod.POST})
    public ModelAndView loadImportedData(HttpServletRequest request , HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView("placeholder/placeholderStatus");
        try {
            String usercode = CommonUtil.getUserCode(request);
            List imporetdDataList = placeholderService.getImportedData(usercode);
            CommonMember.appendLogFile("List :- " + imporetdDataList);
            if(!imporetdDataList.isEmpty())
            {
                modelAndView.addObject("status", "1");
                modelAndView.addObject("imporetdDataList", imporetdDataList);
            }
            else
            {
                modelAndView.addObject("status", "0");
            }
            modelAndView.addObject("Action", "importedData");
            
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params="cmdAction=getDataForSpecificUploadId" , method = {RequestMethod.GET ,RequestMethod.POST})
    public ModelAndView getDataForSpecificUploadId(HttpServletRequest request , HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView("placeholder/placeholderStatus");
        try {
            String uploadId = request.getParameter("uploadId");
            String usercode = CommonUtil.getUserCode(request);
            List DataforSpecificUploadId = placeholderService.getDataForSpecificUploadId(usercode,uploadId);
            CommonMember.appendLogFile("List :- " + DataforSpecificUploadId);
            if(!DataforSpecificUploadId.isEmpty())
            {
                modelAndView.addObject("status", "1");
                modelAndView.addObject("DataforSpecificUploadId", DataforSpecificUploadId);
            }
            else
            {
                modelAndView.addObject("status", "0");
            }
            modelAndView.addObject("Action", "DataforSpecificUploadId");
            
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params="cmdAction=generatePDF" , method = {RequestMethod.POST})
    public ModelAndView generatePDF(HttpServletRequest request , HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView("placeholder/placeholderStatus");
        try{    
            int pdfStatus = placeholderService.pdfGenerationImpl(request);
            if(pdfStatus == 1)
            {
                modelAndView.addObject("status", "1");
            }
            else
            {
                modelAndView.addObject("status", "0");
            }
            modelAndView.addObject("Action", "GeneratePDFStatus");
            
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params="cmdAction=loadGeneratedPDFData" , method = {RequestMethod.POST})
    public ModelAndView loadGeneratedPDFData(HttpServletRequest request , HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView("placeholder/placeholderStatus");
        try{    
            String usercode = CommonUtil.getUserCode(request);
            List pdfDataList = placeholderService.getPdfGenerationFileData(usercode);
            if(!pdfDataList.isEmpty())
            {
                modelAndView.addObject("status", "1");
                modelAndView.addObject("pdfDataList", pdfDataList);
            }
            else
            {
                modelAndView.addObject("status", "0");
            }
            modelAndView.addObject("Action", "PDFData");
            
        } catch (Exception ex) {
            CommonMember.errorHandler(ex);
        }
        return modelAndView;
    }
    
    @RequestMapping(params="cmdAction=downloadPDF" , method = {RequestMethod.GET ,RequestMethod.POST})
    public void downloadPDF(HttpServletRequest request , HttpServletResponse response)
    {
        
        try {
            String fileName = request.getParameter("fileName");
            downloadFileUtil.downloadFile(response, fileName , CommonUtil.pdfFilePath());
            
        } catch (IOException ex) {
            CommonMember.errorHandler(ex);
        }
    }
}