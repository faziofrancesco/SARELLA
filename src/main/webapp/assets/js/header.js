function usernameButton() {
    let button = $('#usernameDropdown');
    let source = $('#signOutButton');
    if(button.length && source.length) {
        button.width(source.width());
        button.height(source.height());
    }
}

$(document).ready(function(){
    usernameButton();
});

$('.modal').on('shown.bs.modal', function(){
    $('.modal').not(this).modal('hide');
});