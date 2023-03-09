/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
            showNotyf("Template Type Added Successfully", "success");
        }
        else
        {
            showNotyf("Some Problem Arise", "error");       
        }
        
        loadAddTmpType();
    }
    
}

function Tmptypevalidate()
{
    var REG_ALPHA_NUM_SPACE = /^[A-Za-z]+$/;
    var MSG_ALPHA_NUM_SPACE = "Please enter valid value for";
    
    var tmptype = $("#tmptypetxt").val().toUpperCase();
    var List = $("#typelist").val();
    if(List.includes(tmptype) === true)
    {
        alert("This Template Type is Already Avaliable");
        $("#tmptypetxt").focus();
        return false;
    }
    if(tmptype === null || tmptype === "")
    {
        alert("Please Enter the value for Template Type");
        $("#tmptypetxt").focus();
        return false;
    }
    else if(!tmptype.match(REG_ALPHA_NUM_SPACE))
    {
        alert(MSG_ALPHA_NUM_SPACE + "Template Type.");
        $("#tmptypetxt").focus();
        return false;
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
            showNotyf("TmpType updated Successfully", "success");
        } else
        {
            showNotyf("some problem arise", "error");
        }
        loadEditTmpType('Edit');
    }
}

function deleteTmpType()
{
    var TmpTypeId = $("#tmptypeID").val();
    showConfirmSwal(
            "Are you sure you want to Delete Type?",
            "Once Deleted can't be reverted.",
            "Delete Template Type",
            () => {
        getSynchronousData("tmptype.fin?cmdAction=deleteTmptype", 'TmptypeID=' + TmpTypeId, 'insertTmptypeFlag');
        var deleteTmptypeFlag = $("#deleteTmptypeStatus").val();
        if (deleteTmptypeFlag > 0)
        {
            showNotyf("Template Type deleted Successfully", "success");
        } else
        {
            showNotyf("some problem arise", "error");
        }
        loadDeleteTmpType('Delete');
    }
    );
}