function addc(event){
    $.ajax({
        type: "POST",
        url: "/rooms_servlet",

        data: {
            Id1 : $("#addRoomModalNumC").val(),
            Tipo1 : $("#addRoomModalType").val(),
            Descrizione1 : $("#addRoomModalDescription").val(),
            numMaxPersone1 : $("#addRoomModalNumP").val(),
            Img1 : $("#addRoomModalImg").val(),
            Prezzo1 : $("#addRoomModalPrice").val()
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