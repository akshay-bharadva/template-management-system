/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function loadAddCategory()
{
    getSynchronousData("category.fin?cmdAction=loadAddCategory",'','loadCategory');
}

function loadEditCategory(action)
{
    $("#categoryreport").hide();
    getSynchronousData("category.fin?cmdAction=loadEditCategory",'Action='+ action,'loadCategory');
    showCategoryReport("0");
}
function loadDeleteCategory(action)
{
    $("#categoryreport").hide();
    getSynchronousData("category.fin?cmdAction=loadDeleteCategory",'Action='+ action,'loadCategory');
    showCategoryReport("0");
}
function loadViewCategory(action)
{
    $("#categoryreport").hide();
    getSynchronousData("category.fin?cmdAction=loadViewCategory",'Action='+ action,'loadCategory');
    showCategoryReport("0");
}


function onloadtype(type)
{
    $("#cmbTemplateType").val(type);
}

function addCategory()
{
    var categoryfrm = document.Categoryform;
//    var params = getFormData(categoryfrm);
    var result = categoryvalidate();
//    alert(params);
    if(result)
    {
        var params = getFormData(categoryfrm);
        alert(params);
        getSynchronousData("category.fin?cmdAction=insertCategory",params,'insertCategoryFlag');
        var insertCategoryFlag = $("#insertCategoryStatus").val();
        if(insertCategoryFlag > 0)
        {
            showNotyf("Category Added Successfully", "success");
        }
        else
        {
            showNotyf("Some Problem Arise", "error");       
        }
        
        loadAddCategory();
    }
}

function showCategoryReport(value)
{
    var Action = $("#action").val();
//    alert(value+""+Action);
    getSynchronousData("category.fin?cmdAction=showCategory", "&action=" + Action + "&filterValue=" + value, 'categoryreport');
    $("#categoryreport").show();
}

function showCategoryData(categoryID, crudAction)
{
//    alert(categoryID);
    getSynchronousData("category.fin?cmdAction=getCategoryData", "CategoryID=" + categoryID + "&crudAction=" + crudAction, 'loadCategory');
    
}

function categoryvalidate()
{
    var REG_ALPHA_NUM_SPACE = /^[a-zA-Z0-9\b ]+$/;
    var MSG_ALPHA_NUM_SPACE = "Please enter valid value (alpha-numeric) for";
    
    var category = $("#txtCategory").val();
    var templateType = $("#cmbTemplateType").val();
    if(templateType === null || templateType === "0")
    {
        alert("Please make selection for Template Type.");
        $("#cmbTemplateType").focus();
        return false;
    }
    if(category === null || category === "")
    {
        alert("Please Enter Category.");
        $("#txtCategory").focus();
        return false;
    }
    else
    {
        if (!category.match(REG_ALPHA_NUM_SPACE))
        {
            alert(MSG_ALPHA_NUM_SPACE + "Category.");
            $("#txtCategory").focus();
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
//        alert(params);
        getSynchronousData("category.fin?cmdAction=editCategory", params, 'insertCategoryFlag');
        var editCategoryFlag = $("#editCategoryStatus").val();
        
//        alert(editCategoryFlag);
        if (editCategoryFlag > 0)
        {
            showNotyf("Category updated Successfully", "success");
        } else
        {
            showNotyf("some problem arise", "error");
        }
        loadEditCategory('Edit');
    }
}

function deleteCategory()
{
    var categoryId = $("#categoryID").val();
    showConfirmSwal(
            "Are you sure you want to Delete Cateegory?",
            "Once Deleted can't be reverted.",
            "Delete Category",
            () => {
        getSynchronousData("category.fin?cmdAction=deleteCategory", 'categoryId=' + categoryId, 'insertCategoryFlag');
        var deleteCategoryFlag = $("#deleteCategoryStatus").val();
        if (deleteCategoryFlag > 0)
        {
            showNotyf("Category deleted Successfully", "success");
        } else
        {
            showNotyf("some problem arise", "error");
        }
        loadDeleteCategory('Delete');
    }
    );
}