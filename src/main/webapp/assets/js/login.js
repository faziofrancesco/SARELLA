

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
        url: "/normalLogin",
        data: {

            username: $("#Login-username").val(),
            password: $("#Login_password").val(),
        },
        success: function () {
            window.location.replace("/homepage");

        },
        error: function () {
            alert("Login non valido");
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
                    window.location.replace("/homepage");
                },
                error: function () {
                    alert("Something has gone wrong with google login");
                }
            });

}