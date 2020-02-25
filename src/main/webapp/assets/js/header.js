function usernameButton() {
    let button = $('#usernameDropdown');
    let source = $('#signOutButton');
    if(button.length && source.length) {
        button.width(source.width());
        button.height(source.height());
    }
}

window.loadGAPI = function() {
    //you can safely call gapi here
};
(function(d, s, id) {
    var js,
        p = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) {
        return;
    }
    js = d.createElement(s);
    js.id = id;
    js.src =
        'https://apis.google.com/js/platform.js?onload=gapiLoaded';
    p.parentNode.insertBefore(js, p);
})(document, 'script', 'google-api-js');

$(document).ready(function(){
    usernameButton();
});