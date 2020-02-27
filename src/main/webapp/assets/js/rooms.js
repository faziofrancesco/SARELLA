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