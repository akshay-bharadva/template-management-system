/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function loadTemplateType()
{
    getSynchronousData("tmptype.fin?cmdAction=loadtmptype",'','load');
}
function loadAddTmpType()
{
    getSynchronousData("tmptype.fin?cmdAction=loadaddTmptype",'','loadtmptype');
}
function loadEditTmpType(action)
{
    $("#Tmptypereport").hide();
    getSynchronousData("tmptype.fin?cmdAction=loadeditTmptype",'Action='+ action,'loadtmptype');
    showTmpTypeReport("0");
}
function loadDeleteTmpType(action)
{
    $("#Tmptypereport").hide();
    getSynchronousData("tmptype.fin?cmdAction=loaddeleteTmptype",'Action='+ action,'loadtmptype');
    showTmpTypeReport("0");
}
function loadViewTmpType(action)
{
    $("#Tmptypereport").hide();
    getSynchronousData("tmptype.fin?cmdAction=loadviewTmptype",'Action='+ action,'loadtmptype');
    showTmpTypeReport("0");
}
function addTmptype()
{
    var tmptypefrm = document.Tmptypeform;
    var params = getFormData(tmptypefrm);
    
    var result = Tmptypevalidate();
    if(result)
    {
        getSynchronousData("tmptype.fin?cmdAction=insertTmptype",params,'insertTmptypeFlag');
        var insertTmptypeFlag = $("#insertTmptypeStatus").val();
        if(insertTmptypeFlag > 0)
        {
            showSwalTimer("Template Type Added Successfully",TIME,"success");
        }
        else
        {
            showSwalTimer("Some Problem Arise \n Try Again",TIME,"error");       
        }
        
        loadAddTmpType();
    }
    
}

function Tmptypevalidate()
{
    var REG_ALPHA_NUM_SPACE =  /^[a-zA-Z\s]*$/;
    var MSG_ALPHA_NUM_SPACE = "Please enter valid value for";
    
    var tmptype = $("#tmptypetxt").val().toUpperCase();
    var List = $("#typelist").val();
    
    if(tmptype === null || tmptype === "")
    {
        showSwal("Please Enter the value for Template Type","","error","",'tmptypetxt');
//        $("#tmptypetxt").focus();
        return false;
    }
    else
    {
        if(!tmptype.match(REG_ALPHA_NUM_SPACE))
        {
            showSwal(MSG_ALPHA_NUM_SPACE + " Template Type.","","error","",'tmptypetxt');
//            $("#tmptypetxt").focus();
            return false;
        }
        else if(List.includes(tmptype) === true)
        {
            showSwal("This Template Type is Already Avaliable","","error","",'tmptypetxt');
//            $("#tmptypetxt").focus();
            return false;
        }
    } 
    return true;
}

function showTmpTypeData(TmptypeId, crudAction)
{
    getSynchronousData("tmptype.fin?cmdAction=getTmpTypeData", "TmptypeID=" + TmptypeId + "&crudAction=" + crudAction, 'loadtmptype');
    
}

function showTmpTypeReport(value)
{
    var Action = $("#action").val();
//    alert(value);
    getSynchronousData("tmptype.fin?cmdAction=showTmptype", "&action=" + Action + "&filterValue=" + value, 'Tmptypereport');
    $("#Tmptypereport").show();
}

function editTmptype()
{
    var editTmpTypefrm = document.Tmptypeform;
    var result = Tmptypevalidate();
//    alert("hii");
    if (result)
    {
        var params = getFormData(editTmpTypefrm);
//        alert(params);
        getSynchronousData("tmptype.fin?cmdAction=editTmptype", params, 'insertTmptypeFlag');
        var editTmptypeFlag = $("#editTmptypeStatus").val();
        
        //alert(editTmptypeFlag);
        if (editTmptypeFlag > 0)
        {
            showSwalTimer("Template Type Updated Successfully",TIME,"success");
        } else
        {
            showSwalTimer("Some Problem Arise \n Try Again",TIME,"error");
        }
        loadEditTmpType('Edit');
    }
}

function deleteTmpType()
{
    var deleteTmpTypefrm = document.Tmptypeform;
    var params = getFormData(deleteTmpTypefrm);
    showConfirmSwal(
            "Are you sure you want to Delete Type?",
            "Once Deleted can't be reverted.",
            "Delete Template Type",
            () => {
        getSynchronousData("tmptype.fin?cmdAction=deleteTmptype", params, 'insertTmptypeFlag');
        var deleteTmptypeFlag = $("#deleteTmptypeStatus").val();
        if (deleteTmptypeFlag > 0)
        {
            showSwalTimer("Template Type deleted Successfully",TIME,"success");
        } else
        {
            showSwalTimer("Some Problem Arise \n Try Again",TIME,"error");
        }
        loadDeleteTmpType('Delete');
    }
    );
}