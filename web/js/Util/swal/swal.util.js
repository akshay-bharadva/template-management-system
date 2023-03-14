// possible icons : question , error, warning, success

function showSwal(title, text, icon = "success", footer = "",Id) {
    Swal.fire({
        icon,
        title,
        text,
        footer,
    }).then(function () {
        swal.close();
        $('#' + Id).focus();
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

function showSwalCallback(title, timer, callback, icon = "success")
{
    const Toast = Swal.mixin({
        toast: true,
        position: 'top-end',
        showConfirmButton: false,
        timer,
        timerProgressBar: true,
        didOpen: (toast) => {
            toast.addEventListener('mouseenter', Swal.stopTimer);
            toast.addEventListener('mouseleave', Swal.resumeTimer);
        }
    });

    Toast.fire({
        icon,
        title
    });

    callback();
}

function showSwalTimer(title, timer , icon = "success")
{
    const Toast = Swal.mixin({
        toast: true,
        position: 'top-end',
        showConfirmButton: false,
        timer,
        timerProgressBar: true,
        didOpen: (toast) => {
            toast.addEventListener('mouseenter', Swal.stopTimer);
            toast.addEventListener('mouseleave', Swal.resumeTimer);
        }
    });

    Toast.fire({
        icon,
        title
    });

}