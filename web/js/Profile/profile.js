/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function loadProfileForm()
{
//    alert("hello");
    getSynchronousData("profile.fin?cmdAction=loadProfile", "", "load");
//    loadDatePicker("dob");
}

function submitProfile()
{
    var regExMob = /^[1-9]{1}[0-9]{9}$/;
    var regExComm = /^[A-za-z]{1,30}$/;
    
    var mobNo = $("#mobNo").val();
    var Fname = $("#txtFname").val();
    var Lname = $("#txtLname").val();
    if(Fname.trim()!=="")
    {
       if(!regExComm.test(Fname.trim()))
       {    
           valid_length_alert("First Name" , 30 , "txtFname");
           return false;
       }
    }
    
    if(Lname.trim()!=="")
    {
       if(!regExComm.test(Lname.trim()))
       {    
           valid_length_alert("Last Name" , 30 , "txtLname");
           return false;
       }
    }
    
    if(!validateDate_txt('dob','Date Of Birth',true))
    {
        $("#dob").focus();
        return false;
    }
    
    if(mobNo.trim() !== "")
    {
        if(!regExMob.test(mobNo.trim()))
        {
            valid_common_alert("Mobile Number","mobNo");
            return false;
        }
    }
    
    var formName = document.forms[0];
    var param = getFormData(formName);
    getSynchronousData("profile.fin?cmdAction=updateProfile",param, "profileStatus");
    
    if($("#updateProfileStatus").val() > 0)
    {
        showSwalTimer("Profile Updated Successfully",TIME,"success");
    }
    else
    {
        showSwalTimer("Some Problem Arise",TIME,"error");
    }
}
