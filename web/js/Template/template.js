/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function loadTemplate()
{
    getAsynchronousData("template.fin?cmdAction=loadTemplate", '', 'load');
}

function loadAddTemplate()
{
    getSynchronousData("template.fin?cmdAction=loadAddTemplate", '', 'loadTemplate');
    $("#cmbCategory").hide();
    loadEditor('txtBody');
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
    getSynchronousData("template.fin?cmdAction=showTemplate", "action=" + action + "&filterValue=" + value, 'report');
    $("#report").show();
}

function showTemplateData(templateType, category, crudAction)
{
    getSynchronousData("template.fin?cmdAction=getupdateTemplateData", "templateType=" + templateType + "&category=" + category + "&crudAction=" + crudAction, 'loadTemplate');
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
            showNotyf("Template updated Successfully", "success");
        } else
        {
            showNotyf("some problem arise", "error");
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
                    showNotyf("Template deleted Successfully", "success");
                } else
                {
                    showNotyf("some problem arise", "error");
                }
                loadDeleteTemplate('Delete');
            }         
    );
    loadEditor('txtBody');   
}

function loadTemplateType(value)
{
    if (value === 'Letter')
    {
        $("#cmbCategory").show();
        $("#categorytxt").hide();
    } else
    {
        $("#cmbCategory").hide();
        $("#categorytxt").show();
    }
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
            showNotyf("Template Added Successfully", "success");
        } else
        {
            showNotyf("some problem arise", "error");
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
        alert("Please make selection for Template Type.");
        $("#cmbTemplateType").focus();
        return false;
    }
    if (templateType === 'Letter')
    {
        var selCategory = $("#categorysel").val();
        if (selCategory === null || selCategory === "0")
        {

            alert("Please make selection for Category.");
            $("#categorysel").focus();
            return false;
        } else
        {
            $("#txtCategory").val(selCategory);
        }
    } else
    {
        var txtCategory = Trim($("#txtCategory").val());

        if (txtCategory === "")
        {
            alert("Please enter value for Category.");
            $("#txtCategory").focus();
            return false;
        }
        if (txtCategory !== "")
        {
            if (!txtCategory.match(REG_ALPHA_NUM_SPACE))
            {
                alert(MSG_ALPHA_NUM_SPACE + "Category.");
                $("#txtCategory").focus();
                return false;
            }
        }
    }
    if (templateType === 'Email' || templateType === 'Letter')
    {
        var txtSubject = Trim($("#txtSubject").val());
        if (txtSubject === "")
        {
            alert("Please enter value for Subject.");
            $("#txtSubject").focus();
            return false;
        }
    }
    var body = CKEDITOR.getData();
    if (body.trim() === "")
    {
        alert("Please enter value for Template Body");
        $("#txtBody").focus();
        return false;
    }

    return true;
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
                showNotyf("Cannot Load Editor!", "error");
            });
}

function destroyEditor(id) {
    CKEDITOR.destroy().catch((error) => {
        showNotyf("Some Error Occured, Please Try Again Later!", "error");
    });
}

function getTemplateData(formObj) {
    destroyEditor('body');
    return getFormData(formObj)
}


