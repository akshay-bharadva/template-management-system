// possible icons : question , error, warning, success

function showSwal(title, text, icon = "success", footer = "") {
    Swal.fire({
        icon,
        title,
        text,
        footer,
    });
}

function showConfirmSwal(title,text,confirmButtonText,callBackfunction,icon="warning",showCancelButton=true) {
    Swal.fire({
        title,
        text,
        icon,
        showCancelButton,
        confirmButtonText,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33'
    }).then((result) => {
        if (result.isConfirmed) {
            callBackfunction();
        }
    })
}