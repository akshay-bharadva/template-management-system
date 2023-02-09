/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

const TIME = 5000; 
function loadSignUp()
{

    window.open("login.fin?cmdAction=loadSignUp", "_self");
}
function validateSignUp()
{
    var signUpForm = document.getElementById("RegisterForm");

    var result = validateUserData() && validate_email(signUpForm, "Email", "Email", true);
    if (result)
    {
        var param = getFormData(signUpForm);
        getSynchronousData("login.fin?cmdAction=login", param, 'status');

        var status = $("#RegisterStatus").val();
        if (status > 0)
        {
            showNotyfCallback("Registerd Successfully", "success", false, "", setTimeout(() => window.location = "login.fin?cmdAction=loadSignIn", TIME));
        } else
        {
            showNotyf("Some Problem Arise", "error");
        }
    }

}
function loadSignIn()
{
    window.open("login.fin?cmdAction=loadSignIn", "_self");
}

function loadRecoverPassword()
{
    window.open("login.fin?cmdAction=loadRecoverPassword", "_self");
}
function validateSignIn()
{
    var signInForm = document.getElementById("SignInForm");

    var result = validateUserData();
    if (result)
    {
        var param = getFormData(signInForm);
//      getAsynchronousData("login.fin?cmdAction=loadHome",param,'load');
        window.open("login.fin?cmdAction=loadHome", "_self");
        
    }
    

}

/**
 * 
 * showNotyfCallback("Hello",
 *                   "success",
 *                   false,
 *                   "",
 *                   setTimeout(() => window.location="www.google.com", 5000))
 */

function validateUserData()
{
    var signUpForm = document.getElementById("RegisterForm");
    var result = validate_loginid(signUpForm, 'UserName', 'User Name', true) 
                 && validate_password(signUpForm, 'Password', 'Password', true);
    return result;
}

function EmailExist()
{
    var email = $("#Email").val();
    alert(email);
    getAsynchronousData("login.fin?cmdAction=emailExist","email="+email,'EmailError');
    var EmailStatus = $("#CheckEmailStatus").val();
    if(EmailStatus > 1)
    {
        $("#Email").focus();
        return false;
    }
    return true;
}

function UserNameExist()
{
    var userName = $("#UserName").val();
    alert(userName);
    getAsynchronousData("login.fin?cmdAction=userNameExist","userName="+userName,'UserNameError');
    var UserNameStatus = $("#CheckUserNameStatus").val();
    if(UserNameStatus > 1)
    {
        $("#UserName").focus();
    }
}