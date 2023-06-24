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

function downloadFileFormat(templateId)
{   
    window.open("placeholder.fin?cmdAction=downloadFileFormat&templateId="+templateId,"");
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

function uploadFile(templateId)
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
    frmdata.append("templateId",templateId);
    $.ajax({
        url: "placeholder.fin?cmdAction=uploadExcelFileWithData",
        type: 'POST',
        data: frmdata,
        mimeType: "multipart/form-data",
        contentType: false,
        cache: false,
        processData: false,
        success: function (data) {
            if(data == 0)
            {
                document.forms[0].reset();
                downloadErrorFile();
                
            }
            else
            {
                showSwalTimer("File Uploaded Successfully",TIME,"success");
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            showSwalTimer("Some Problem Arise",TIME,"error");
        }
    });
}

function downloadErrorFile()
{
    window.open("placeholder.fin?cmdAction=downloadFileError","");
    
}

function loadImportedData()
{
    
    getSynchronousData("placeholder.fin?cmdAction=loadImportedData","","load");
    
}

function getUploadData(uploadId)
{
    getSynchronousData("placeholder.fin?cmdAction=getDataForSpecificUploadId","uploadId="+uploadId,"load");
    var data = $('#placeholder-json-data').val();
    generateTableFromJSON(JSON.parse(data));
}

function generateTableFromJSON(data){
    
    console.log(data)
    
    var firstData = data.length > 0 ? data[0] : {};

    var columns = {};

    data.forEach((record) => {
      const btnEl = document.createElement("button");
      btnEl.classList.add("btn", "btn-primary");
      record.ACTION = btnEl;
      btnEl.innerHTML = "Generate";
      btnEl.addEventListener('click',() => generateDocumnet(record._id));
    });

    Object.keys(firstData).forEach((col) => {
      if (col !== "_id") {
        columns[col] = col;
      }
    });
    
    var table = $('#jsonTable').tableSortable({
        data: data,
        columns: columns,
        searchField: '#searchFieldInUploadedData',
        rowsPerPage: 5,
        pagination: true,
        tableWillMount: function() {
            console.log('table will mount')
        },
        tableDidMount: function() {
            console.log('table did mount')
        },
        tableWillUpdate: function() {console.log('table will update')},
        tableDidUpdate: function() {console.log('table did update')},
        tableWillUnmount: function() {console.log('table will unmount')},
        tableDidUnmount: function() {console.log('table did unmount')},
        onPaginationChange: function(nextPage, setPage) {
            setPage(nextPage);
        }
    });

    $('#changeRowsOfTable').on('change', function() {
        table.updateRowsPerPage(parseInt($(this).val(), 10));
    })

    $('.gs-table-container').addClass("table-responsive p-4")

}
function generateDocumnet(id) {
    var uploadID = $('#placeholder-upload-id').val();
    getSynchronousData("placeholder.fin?cmdAction=generatePDF","recordID="+id +"&uploadID="+uploadID,"generatePDFStatus");
    
    if($("#pdfStatus").val() === "1")
    {
        showSwalTimer("PDF Generated Successfully",TIME,"success");
    }
    else
    {
        showSwalTimer("some problem arise",TIME,"error");
    }
}

function loadGeneratedPDFData()
{
    getSynchronousData("placeholder.fin?cmdAction=loadGeneratedPDFData","","load");
}

function downloadPDF(fileName)
{
    window.open("placeholder.fin?cmdAction=downloadPDF&fileName="+fileName,"");
}