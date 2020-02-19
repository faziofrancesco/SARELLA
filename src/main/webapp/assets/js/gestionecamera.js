function addc(event){
    $.ajax({
        type: "POST",
        url: "rooms_servlet",

        data: {
            Id1 : $("#Id1").val(),
            Tipo1 : $("#Tipo1").val(),
            Descrizione1 : $("#Descrizione1").val(),
            numMaxPersone1 : $("#numMaxPersone1").val(),
            Img1 : $("#Img1").val(),
            Prezzo1 : $("#Prezzo1").val()
        },
        success:function(){
            alert("Camera Inserita corretamente");
            window.location.replace("room-administration.jsp");

        },
        error : function () {
            alert("la camera  non è stata inserita corretamente");
            window.location.replace("room-administration.jsp");

        }
    });
}