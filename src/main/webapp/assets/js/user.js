function registerUser(event) {
    $.ajax({
        type: "POST",
        url: "/registrationUser",
        async: false,
        data: {
            name: $("#reg-name").val(),
            surname: $("#reg-surname").val(),
            datanascita: $("#reg-date").val(),
            email: $("#reg-email").val(),
            username: $("#reg-username").val(),
            password: $("#reg-password").val(),
        },
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