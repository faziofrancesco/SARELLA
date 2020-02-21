function addc(formName){

    let form = $(formName)[0];
    let formData = new FormData(form);

    $.ajax({
        type: "POST",
        url: "rooms_servlet",
        data: formData,
        contentType: false,
        processData: false,
        success:function(){
            alert("Camera Inserita correttamente");
            window.location.replace("/gestionecamere");
        },
        error:function(){
            alert("la camera non è stata inserita correttamente");
        }
    });
}