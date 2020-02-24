function retrieveusername(event) {

    $.ajax({
        type: "POST",
        url: "/LostUsername",
        data: {
            email: $("#retrieve-username").val()

        },
        success: function () {
            window.location.replace("homepage");
        },
        error: function () {
            alert("Something has gone wrong with retrieve username");
        }
    });

}
function retrievepassword(event) {

    $.ajax({
        type: "POST",
        url: "/LostPassword",
        data: {
            email: $("#emailemail").val(),
            username: $("#retrievepassword").val()

        },
        success: function () {
            window.location.replace("homepage");
        },
        error: function () {
            alert("Something has gone wrong with retrieve password");
        }
    });

}