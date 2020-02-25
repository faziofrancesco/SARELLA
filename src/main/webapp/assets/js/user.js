function registerUser(formName) {

    let form = $(formName)[0];
    let formData = new FormData(form);

    $.ajax({
        type: "POST",
        url: "registrationUser",
        async: false,
        data: formData,
        processData: false,
        contentType: false,
        success: function () {
            $("#registrationModal").modal("hide");
            $(".modal-backdrop").remove();
            $("#loginModal").modal("show");

        },
        error: function () {
            alert("ERRORE NELLA REGISTRAZIONE");
        }
    });
}
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
    if (!event.target.matches('.dropbtn')) {
        var dropdowns = document.getElementsByClassName("dropdown-menu");
        var i;
        for (i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
};