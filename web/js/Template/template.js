/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function loadTemplate()
{
    getSynchronousData("template.fin?cmdAction=loadTemplate", '', 'load');
}
function loadAddTemplate()
{
    getSynchronousData("template.fin?cmdAction=loadButton", '', 'loadTemplate');
}
function loadAddTemplateFromScratch()
{
    getSynchronousData("template.fin?cmdAction=loadAddTemplate", '', 'loadTemplate');
    $("#categoryblock").hide();
    loadEditor('txtBody');
}
function loadAddTemplateFromDefault(action)
{
    $("#report").hide();
    getSynchronousData("template.fin?cmdAction=loadDefaultTemplate", 'action=' + action, 'loadTemplate');
    showReport("0");
}
function loadEditTemplate(action)
{
    $("#report").hide();
    getSynchronousData("template.fin?cmdAction=loadEditTemplate", 'action=' + action, 'loadTemplate');
    showReport("0");
}
function loadDeleteTemplate(action)
{
    $("#report").hide();
    getSynchronousData("template.fin?cmdAction=loadDeleteTemplate", 'action=' + action, 'loadTemplate');
    showReport("0");
}
function loadViewTemplate(action)
{
    $("#report").hide();
    getSynchronousData("template.fin?cmdAction=loadViewTemplate", 'action=' + action, 'loadTemplate');
    showReport("0");
}
function showReport(value)
{
    var action = $("#action").val();
    if(action === 'Default')
    {
        var isDefault = '1';
        getSynchronousData("template.fin?cmdAction=showDefaultTemplate", "action=" + action + "&filterValue=" + value + "&isDefault=" + isDefault, 'report');   
    }
    else
    {
        getSynchronousData("template.fin?cmdAction=showTemplate", "action=" + action + "&filterValue=" + value, 'report');
    }
    
    $("#report").show();
}

function showTemplateData(templateId, crudAction)
{
    getSynchronousData("template.fin?cmdAction=getupdateTemplateData", "templateId=" + templateId  + "&crudAction=" + crudAction, 'loadTemplate');
    loadEditor('txtBody');
}

function editTemplate()
{
    var templateForm = document.templateForm;
    var result = validateTemplate();
    if (result)
    {
        var param = getTemplateData(templateForm);
        getSynchronousData("template.fin?cmdAction=updateTemplate", param, 'insertTemplateFlag');
        var editTemplateFlag = $("#editTemplateStatus").val();
        if (editTemplateFlag > 0)
        {

            showSwalTimer("Template updated Successfully",TIME,"success");
        } else
        {
            showSwalTimer("some problem arise",TIME,"error");

        }
        loadEditTemplate('Edit');
    }
}

function deleteTemplate()
{
    var templateForm = document.templateForm;
    var param = getTemplateData(templateForm);

    showConfirmSwal(
            "Are you sure you want to Delete Template?",
            "Once Deleted can't be reverted.",
            "Delete Tempalte",
            () => {
                getSynchronousData("template.fin?cmdAction=deleteTemplate", param, 'insertTemplateFlag');
                var deleteTemplateFlag = $("#deleteTemplateStatus").val();
                if (deleteTemplateFlag > 0)
                {
                    showSwalTimer("Template deleted Successfully",TIME,"success");

                } else
                {
                    showSwalTimer("some problem arise",TIME,"error");

                }
                loadDeleteTemplate('Delete');
            }         
    );
    loadEditor('txtBody');   
}

function loadTemplateTypeList(value)
{
    getSynchronousData("template.fin?cmdAction=loadCategory","templateType="+value,"categorysel");
    $("#categoryblock").show();
}

function addTemplate()
{

    var templateForm = document.templateForm;
    var result = validateTemplate();
    if (result)
    {
        var param = getTemplateData(templateForm);
        console.log(param);
        getSynchronousData("template.fin?cmdAction=insertTemplate", param, 'insertTemplateFlag');
        var insertTemplateFlag = $("#insertTemplateStatus").val();
        if (insertTemplateFlag > 0)
        {

            showSwalTimer("Template Added Successfully",TIME,"success");
        } else
        {

            showSwalTimer("some problem arise",TIME,"error");
        }
        loadAddTemplate();
    }
}
function validateTemplate()
{
    var REG_ALPHA_NUM_SPACE = /^[a-zA-Z0-9\b ]+$/;
    var MSG_ALPHA_NUM_SPACE = "Please enter valid value (alpha-numeric) for";

    var templateType = $("#cmbTemplateType").val();
    if (templateType === null || templateType === "0")
    {
        showSwal("Please make selection for Template Type.","","error","","cmbTemplateType");
        return false;
    }
        var selCategory = $("#categorysel").val();
        if (selCategory === null || selCategory === "0")
        {
            showSwal("Please make selection for Category.","","error","","categorysel");
            return false;
        } 
        var txtSubject = $("#txtSubject").val().trim();
        if (txtSubject === "")
        {
            showSwal("Please enter value for Subject.","","error","","txtSubject");
            
            return false;
        }

    var body = CKEDITOR.getData();
    if (body.trim() === "")
    {
        showSwal("Please enter value for Template Body","","error","","body");
        return false;
    }

    return true;
}

function formReset()
{
    $("#cmbTemplateType").val("0");
    $("#categorysel").val("0");
//    $("#categoryblock").hide();
    $("#txtSubject").val("");
    CKEDITOR.setData("");
    $('input:checkbox').removeAttr('checked');

}

/***
 * CK EDITOR FUNCTIONS
 */
window.CKEDITOR = null;

function loadEditor(id) {
    ClassicEditor.create(document.querySelector("#" + id))
            .then((editor) => {
                CKEDITOR = editor;
            })
            .catch((error) => {
                showSwalTimer("Cannot Load Editor!",TIME,"error");
            });
}

function destroyEditor(id) {
    CKEDITOR.destroy().catch((error) => {
        showSwalTimer("Some Error Occured, Please Try Again Later!", TIME , "error");
    });
}

function getTemplateData(formObj) {
    destroyEditor('body');
    return getFormData(formObj)
}




