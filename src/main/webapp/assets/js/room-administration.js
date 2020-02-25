function addc(formName) {

    let form = $(formName)[0];
    let formData = new FormData(form);

    $.ajax({
        type: "POST",
        url: "addrooms_servlet",
        data: formData,
        contentType: false,
        processData: false,
        success: function () {
            alert("Camera Inserita correttamente");
            window.location.replace("rooms-handler?target=admin");
        },
        error: function () {
            alert("la camera non è stata inserita correttamente");
        }
    });
}

function updc(formName) {

    let form = $(formName)[0];
    let formData = new FormData(form);

    $.ajax({
        type: "POST",
        url: "updaterooms_servlet",
        data: formData,
        contentType: false,
        processData: false,
        success: function () {
            alert("Camera aggiornata correttamente");
            window.location.replace("rooms-handler?target=admin");
        },
        error: function () {
            alert("Camera non aggiornata correttamente");
        }
    });
}

function delc(formName) {

    let form = $(formName)[0];
    let formData = new FormData(form);

    $.ajax({
        type: "POST",
        url: "deleterooms_servlet",
        data: formData,
        contentType: false,
        processData:false,
        success: function () {
            alert("Camera eliminata correttamente");
            window.location.replace("rooms-handler?target=admin");
        },
        error: function () {
            alert("Camera non eliminata correttamente");
        }
    });
}