// possible icons : question , error, warning, success

function showSwal(title, text, icon = "success", footer = "") {
  Swal.fire({
    icon,
    title,
    text,
    footer,
  });
}
