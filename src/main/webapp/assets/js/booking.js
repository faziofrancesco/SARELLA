function booking(googleUser) {

    $.ajax({
        type: "POST",
        url: "addbookingtocart",
        success: function () {
            window.location.replace("homepage");
        },
        error: function () {
            alert("Something has gone wrong bookingrooms");
        }
    });

}