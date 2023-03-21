/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function loadUserMaster()
{
    getSynchronousData("usermaster.fin?cmdAction=loadUserMaster", '', 'load');
}
function loadAddUser()
{
    getSynchronousData("usermaster.fin?cmdAction=loadAddUser", '', 'loadUser');
}
function loadEditUser(action)
{
    $("#userreport").hide();
    getSynchronousData("usermaster.fin?cmdAction=loadEditUser", 'Action=' + action, 'loadUser');
    showUserReport("0");
}

function loadViewUser(action)
{
    $("#userreport").hide();
    getSynchronousData("usermaster.fin?cmdAction=loadViewUser", 'Action=' + action, 'loadUser');
    showUserReport("0");
}

function addUserdetail()
{
    var userform = document.getElementById("userForm");
    var result = validate_email(userform, "Email", "Email", true)
            && validateUserData(userform);
    if (result)
    {
        var params = getFormData(userform);
        getSynchronousData("usermaster.fin?cmdAction=addUserDetails", params, 'updateUserFlag');

        var Addstatus = $("#adduserstatus").val();
        if (Addstatus > 0)
        {
            showSwalTimer("User Added Successfully", TIME, "success");
        } else
        {
            showSwalTimer("Some Problem Arise \n Try Again", TIME, "error");
        }
        loadAddUser();
    }

}

function showUserReport(value)
{
    var Action = $("#action").val();
    getSynchronousData("usermaster.fin?cmdAction=showUsers", "&action=" + Action + "&filterValue=" + value, 'userreport');
    $("#userreport").show();
}
function editUserByAdmin(usercode, crudAction)
{
    getSynchronousData("usermaster.fin?cmdAction=EditUserDetail", "Usercode=" + usercode + "&crudAction=" + crudAction, 'loadUser');
}

function updateUser()
{
    var userform = document.getElementById("userForm");

    var result = password_validate(userform, 'Password', 'Password', true);
    if (result)
    {
        var params = getFormData(userform);
        getSynchronousData("usermaster.fin?cmdAction=updateUserDetail", params, 'updateUserFlag');
        var status = $("#updateuserstatus").val();

        if (status > 0)
        {
            showSwalTimer("User Updated Successfully", TIME, "success");
        } else
        {
            showSwalTimer("Some Problem Arise \n Try Again", TIME, "error");
        }
        loadUserMaster();
        loadEditUser('Edit');
    }

}
