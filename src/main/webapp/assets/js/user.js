function registerUser() {

    let form = $('#regForm')[0];
    let formData = new FormData(form);

    $.ajax({
        type: "POST",
        url: "registrationUser",
        async: false,
        data: formData,
        success: function () {
            $("#registrationModal").modal("hide");
            $(".modal-backdrop").remove();
            $("#loginModal").modal("show");

        },
        error: function () {
            alert("ERRORE NELLA REGISTRAZIONE");
        }
    });
}