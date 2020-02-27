function delp(room) {

    $.ajax({
        type: "POST",
        url: "eliminaPrenotazione",
        data: {
            roomId:room
        },
        success: function () {

            loadCart();

        },
        error: function () {
            alert("Errore nell'eliminazione, siete invitati a riprovare");

        }
    });
}

function loadCart() {

    $.ajax({
        type: "POST",
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

function eliminaButton() {
    let button = $('#btndeletep');
    if(button.length) {
        button.css('width', '100%');
        button.css('height', '100%');
    }
}

$(document).ready(function(){
    eliminaButton();
});