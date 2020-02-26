function delp(room) {

    $.ajax({
        type: "POST",
        url: "eliminaPrenotazione",
        data: {
            roomId: room
        },
        success: function () {
            window.location.replace("show_cart");

        },
        error: function () {
            alert("Errore nell'eliminazione, siete invitati a riprovare");

        }
    });
}

function loadCart() {

    $.ajax({
        type: "GET",
        url: "/show_cart",
        success:function () {
            window.location.replace("shopping-cart.jsp");

        },
        error: function(jqXHR, textStatus, errorThrown) {
            if(jqXHR.status === 412) {
                alert("Il carrello è vuoto");
                window.location.replace("/homepage");
            } else {
                alert("Errore nell'eliminazione, siete invitati a riprovare");
            }
        }
    });
}