/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validate_email(frm,field_name,captionName,isCompulsory)
{
    var fieldvalue = frm.elements[field_name].value;
    alpharegexpr=/^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/;

    if(isCompulsory === true) {

        if(fieldvalue.trim()=== "") {
            value_common_alert(captionName);
            return false;
        }

    }

    if(fieldvalue.trim() !== "") {
        if(alpharegexpr.test(fieldvalue) !== true ) {
            valid_common_alert(captionName);
            frm.elements[field_name].focus();
            return false;
        }
        if(fieldvalue.length > 80 ) {
            valid_email_alert(captionName,80);
            frm.elements[field_name].focus();
            return false;
        }

    }
    return true;

}

function validate_loginid(frm,field_name,captionName,isCompulsory)
{

    var fieldvalue = frm.elements[field_name].value;
    alpharegexpr=/^([a-zA-Z0-9]+)$/;

    if(isCompulsory === true) {

        if(fieldvalue.trim() === "") {
            value_common_alert(captionName);
            frm.elements[field_name].focus();
            return false;
        }

    }

    if(fieldvalue.trim() !== "") {
        if(alpharegexpr.test(fieldvalue) !== true ) {
            valid_common_alert_alphanumeric(captionName);
            frm.elements[field_name].focus();
            return false;
        }

    }
    return true;


}

function password_validate(frm,field_name,captionName,isCompulsory)
{
    var fieldvalue = frm.elements[field_name].value;
    if(fieldvalue.trim() === "")
    {
//        alert("Enter valid value for \'"+captionName+"\'.");
          value_common_alert(captionName);
        return false;
    }
    return true;
}

function valid_common_alert(caption) {
    caption = caption.replace("\"","'");
    showSwal("Please enter valid value for \'"+caption+"\'.","","error","");
}

function value_common_alert(caption) {
    caption = caption.replace("\"","'");
    showSwal("Please enter value for \'"+caption+"\'.","","error","");
}

function valid_email_alert(caption,maxLength) {
    caption = caption.replace("\"","'");
    showSwal("\'"+caption+"\' should not be greater than "+maxLength+" characters.","","error","");
}

function valid_common_alert_alphanumeric(caption){
    caption = caption.replace("\"","'");
    showSwal("Please enter valid value (alphanumeric) for \'"+caption+"\'.","","error","");
}
