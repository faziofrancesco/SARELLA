

/*function signOut() {
    let auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        console.log('User signed out.');
    });
    $.ajax({
        type: "GET",
        url: "/logout",
        data: {

        },
        success: function () {
            window.location.replace("/homepage");

        },
        error: function () {
            alert("Logout non eseguito");
        }
    });
}*/

function loginUser(event) {
    $.ajax({
        type: "POST",
        url: "normalLogin",
        data: {
            username2: $("#Login-username").val(),
            password2: $("#Login-password").val(),
        },
        success: function () {
            window.location.replace("homepage");

        },
        error: function () {
            alert("Login non valido");
        }
    });
}
function UpdateCliente() {

    let form = $("#updateClienteForm")[0];
    let formData = new FormData(form);

    $.ajax({
        type: "POST",
        url: "/updateUser",
        data: formData,
        contentType: false,
        processData: false,
        success: function () {
            $("#myProfile").modal("hide");
            $(".modal-backdrop").remove();
        },
        error: function () {
            alert("update non eseguito");
        }
    });
}

function googleSignIn(googleUser) {

            $.ajax({
                type: "POST",
                url: "/googleLogin",
                data: {
                    email: googleUser.getBasicProfile().getEmail(),
                    nome: googleUser.getBasicProfile().getName(0)
                },
                success: function () {
                    window.location.replace("homepage");
                },
                error: function () {
                    alert("Something has gone wrong with google login");
                }
            });

}