/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global TIME */
function loadCategory()
{
    getSynchronousData("category.fin?cmdAction=loadCategory",'','load');
}

function loadAddCategory()
{
    getSynchronousData("category.fin?cmdAction=loadAddCategory", '', 'loadCategory');
}

function loadEditCategory(action)
{
    $("#categoryreport").hide();
    getSynchronousData("category.fin?cmdAction=loadEditCategory", 'Action=' + action, 'loadCategory');
    showCategoryReport("0");
}
function loadDeleteCategory(action)
{
    $("#categoryreport").hide();
    getSynchronousData("category.fin?cmdAction=loadDeleteCategory", 'Action=' + action, 'loadCategory');
    showCategoryReport("0");
}
function loadViewCategory(action)
{
    $("#categoryreport").hide();
    getSynchronousData("category.fin?cmdAction=loadViewCategory", 'Action=' + action, 'loadCategory');
    showCategoryReport("0");
}


function onloadtype(type)
{
    $("#cmbTemplateType").val(type);
}

function addCategory()
{
    var categoryfrm = document.Categoryform;
    var result = categoryvalidate();

    if (result)
    {
        var params = getFormData(categoryfrm);
        getSynchronousData("category.fin?cmdAction=insertCategory", params, 'insertCategoryFlag');
        var insertCategoryFlag = $("#insertCategoryStatus").val();
        if (insertCategoryFlag > 0)
        {
            showSwalTimer("Category Added Successfully", TIME, "success");
        } else
        {
            showSwalTimer("Some Problem Arise \n Try Again",TIME,"error");
        }

        loadAddCategory();
    }
}

function showCategoryReport(value)
{
    var Action = $("#action").val();
    getSynchronousData("category.fin?cmdAction=showCategory", "&action=" + Action + "&filterValue=" + value, 'categoryreport');
    $("#categoryreport").show();
}

function showCategoryData(categoryID, crudAction)
{
    getSynchronousData("category.fin?cmdAction=getCategoryData", "CategoryID=" + categoryID + "&crudAction=" + crudAction, 'loadCategory');
}

function categoryvalidate()
{
    var REG_ALPHA_NUM_SPACE = /^[a-zA-Z0-9\s\b ]+$/;
    var MSG_ALPHA_NUM_SPACE = "Please enter valid value (alpha-numeric) for";

    var category = $("#txtCategory").val();
    var templateType = $("#cmbTemplateType").val();
    var List = $("#categoryList").val();
//    alert(List);
    if (templateType === null || templateType === "0")
    {
        showSwal("Please make selection for Template Type.", "", "error", "",'cmbTemplateType');
//        $("#cmbTemplateType").focus();
        return false;
    }
    if (category === null || category === "")
    {
        showSwal("Please Enter Category.", "", "error", "",'txtCategory');
//        $("#txtCategory").focus();
        return false;
    } else
    {
        if (!category.match(REG_ALPHA_NUM_SPACE))
        {
            showSwal(MSG_ALPHA_NUM_SPACE + "Category.","", "error", "",'txtCategory');
//            $("#txtCategory").focus();
            return false;
        }
        else if(List.includes(category) === true)
        {
            showSwal("This Category is Already Avaliable","","error","",'txtCategory');
            return false;
        }
        return true;
    }
}
function editCategory()
{
    var result = categoryvalidate();
    if (result)
    {
        var editcategoryfrm = document.Categoryform;
        var params = getFormData(editcategoryfrm);
        getSynchronousData("category.fin?cmdAction=editCategory", params, 'insertCategoryFlag');
        var editCategoryFlag = $("#editCategoryStatus").val();

        if (editCategoryFlag > 0)
        {
            showSwalTimer("Category updated Successfully", TIME, "success");
        } else
        {
            showSwalTimer("Some Problem Arise \n Try Again",TIME,"error");
        }
        loadEditCategory('Edit');
    }
}

function deleteCategory()
{
    var deletecategoryfrm = document.Categoryform;
    var params = getFormData(deletecategoryfrm);
    showConfirmSwal(
            "Are you sure you want to Delete Cateegory?",
            "Once Deleted can't be reverted.",
            "Delete Category",
            () => {
        getSynchronousData("category.fin?cmdAction=deleteCategory", params, 'insertCategoryFlag');
        var deleteCategoryFlag = $("#deleteCategoryStatus").val();
        if (deleteCategoryFlag > 0)
        {
            showSwalTimer("Category deleted Successfully", TIME, "success");
        } else
        {
            showSwalTimer("Some Problem Arise \n Try Again",TIME,"error");
        }
        loadDeleteCategory('Delete');
    }
    );
}