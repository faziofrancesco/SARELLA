function onLoad() {
    gapi.load('auth2', function () {
        gapi.auth2.init();
    });
}

function signOut() {
    let auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        console.log('User signed out.');
    });
}

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
            token: googleUser.getAuthResponse().id_token
        },
        success: function () {
            $.ajax({
                type: "POST",
                url: "/login",
                data: {
                    email: googleUser.getBasicProfile().getEmail(),
                    nome: googleUser.getBasicProfile().getName()
                },
                success: function () {
                    window.location.replace("index.jsp");
                },
                error: function () {
                    alert("Something has gone wrong with google login");
                }
            });
        },
        error: function () {
            alert("NOPE");
            //TODO: da gestire se l'email è già presente nel database
        }
    });
}