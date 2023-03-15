/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function loadPlaceholder()
{
    getSynchronousData("placeholder.fin?cmdAction=loadPlaceholder","","load");
    showTemplateReport();
}

function showTemplateReport()
{
    var templateCategoryValue = $("#cmbTemplateCategory").val();    
    var templateTypeValue = $("#cmbTemplateType").val();
    getSynchronousData("placeholder.fin?cmdAction=showTemplateReport","categoryValue="+templateCategoryValue + "&templateTypeValue="+templateTypeValue,"report");
    getSynchronousData("placeholder.fin?cmdAction=loadPlaceholderCategory","templateTypeValue="+templateTypeValue,"cmbTemplateCategory"); 
}

function loadDetailTemplateWithUploadBtn(templateId)
{
    getSynchronousData("placeholder.fin?cmdAction=generateFileWithPlaceholderAsHeader","templateId="+templateId,"load");
    $("#loadFileUpload").hide();
}

function downloadFileFormat(fileName)
{   
    window.open("placeholder.fin?cmdAction=downloadFileFormat&fileName="+fileName,"");
}

function loadUploadFile()
{
    $("#loadFileUpload").show();
}

function validateFile()
{
    var form = document.forms[0];
    var fileName = $("#fileUpload").val();
    var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
   
    if(ext !== "xlsx")
    {
        showSwal("please choose valid file","File must be Excel(xlsx)","error","","fileUpload");
        form.reset();
        return false;
    }
}

function uploadFile()
{
    var fileName = $("#fileUpload").val();
    if(fileName.trim() === "")
    {
        showSwal("Please Select File","","error","","fileUpload");
        return false;
    }

    var frmdata = new FormData();
    var file = fileUpload.files[0];
    frmdata.append("file",file);
    
    $.ajax({
        url: "placeholder.fin?cmdAction=uploadExcelFileWithData",
        type: 'POST',
        data: frmdata,
        mimeType: "multipart/form-data",
        contentType: false,
        cache: false,
        processData: false,
        success: function (data) {
            showSwalTimer("File Uploaded Successfully",TIME,"success");
        },
        error: function (jqXHR, textStatus, errorThrown) {
            showSwalTimer("Some Problem Arise",TIME,"error");
        }
    });
}

