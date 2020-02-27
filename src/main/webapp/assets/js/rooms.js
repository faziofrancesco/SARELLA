function showRooms(formName) {

    let date = new Date();
    let andata = $('#arrivalDate');
    let ritorno = $('#departureDate');
    andata.min = date;
    ritorno.min = date;

    let form = $(formName)[0];
    if(form.checkValidity()) {
        if(andata.val() <= ritorno.val()) {
            form.submit();
        } else {
            form.valid = false;
        }
    }
}

function filterNumP(id) {

    if(id === '1') {
        if($(id).is(":checked")) {
            $('.filtro-nump1').hide();

        } else {
            $('.filtro-nump1').show();
        }
    }

    if(id === '2') {
        if($(id).is(":checked")) {
            $('.filtro-nump2').hide();

        } else {
            $('.filtro-nump2').show();
        }
    }

    if(id === '3') {
        if($(id).is(":checked")) {
            $('.filtro-nump3').hide();

        } else {
            $('.filtro-nump3').show();
        }
    }
}

function filterTipo(id) {

    if(id === '1') {
        if($(id).is(":checked")) {
            $('.filtro-tip1').hide();

        } else {
            $('.filtro-tip1').show();
        }
    }

    if(id === '2') {
        if($(id).is(":checked")) {
            $('.filtro-tip2').hide();

        } else {
            $('.filtro-tip2').show();
        }
    }

    if(id === '3') {
        if($(id).is(":checked")) {
            $('.filtro-tip3').hide();

        } else {
            $('.filtro-tip3').show();
        }
    }
}