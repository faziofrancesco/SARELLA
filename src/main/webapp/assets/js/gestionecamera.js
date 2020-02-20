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
            window.location.replace("/gestionecamere");
        },
        error : function () {
            alert("la camera  non è stata inserita corretamente");
        }
    });
}
function updatec(event){
    $.ajax({
        type: "POST",
        url: "/updaterooms_servlet",

        data: {
            Id1 : $("#updateRoomModalIdRoom").val(),
            Tipo1 : $("#updateRoomModalType").val(),
            Descrizione1 : $("#updateRoomModalDescription").val(),
            numMaxPersone1 : $("#updateRoomModalNumP").val(),
            Img1 : $("#updateRoomModalImg").val(),
            Prezzo1 : $("#updateRoomModalPrice").val()
        },
        success:function(){
            alert("camera aggiornata corretamente");
            window.location.replace("/gestionecamere");


        },
        error : function () {
            alert("la camera  non è stata aggiornata corretamente o id camera non corretto");


        }
    });
}
function deletec(event){
    $.ajax({
        type: "POST",
        url: "/deleterooms_servlet",

        data: {
            Id : $("#deleteRoomModalIdRoom").val()
        },
        success:function(){
            alert("Camera eliminata corretamente");
            window.location.replace("/gestionecamere");

        },
        error : function () {
            alert("l'id non corrisponde oppure la camera è stata prenotata");

        }
    });

}