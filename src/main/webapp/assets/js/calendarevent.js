

// Global variables, the values come from the Developer Console
// Put your OWN clientID and apiKey
var clientId = '602416974316-iv76p5524v5q0rht3eg8h87kflrf03od.apps.googleusercontent.com';
var apiKey = 'AIzaSyABCx7yk1fNMlkVDp9vf2r_7uLT_BEeFCA';
var scopes = 'https://www.googleapis.com/auth/calendar';


/* Function invoked when the client javascript library is loaded */
function handleClientLoad() {
    console.log("Inside handleClientLoad ...");
    gapi.client.setApiKey(apiKey);
    window.setTimeout(checkAuth,100);
}

/* API function to check whether the app is authorized. */
function checkAuth() {
    console.log("Inside checkAuth ...");
    gapi.auth.authorize({client_id: clientId, scope: scopes, immediate: true},
        handleAuthResult);
}

/* Invoked by different functions to handle the result of authentication checks.*/
function handleAuthResult(authResult) {
    console.log("Inside handleAuthResult ...");
    var authorizeButton = document.getElementById('authorize-button');
    var addButton = document.getElementById('addToCalendar');
    if (authResult && !authResult.error) {
        authorizeButton.style.visibility = 'hidden';
        addButton.style.visibility = 'visible';
        //load the calendar client library
        gapi.client.load('calendar', 'v3', function(){
            console.log("Calendar library loaded.");
        });
    } else {
        authorizeButton.style.visibility = '';
        authorizeButton.onclick = handleAuthClick;
    }
}

/* Event handler that deals with clicking on the Authorize button.*/
function handleAuthClick(event) {
    gapi.auth.authorize({client_id: clientId, scope: scopes, immediate: false},
        handleAuthResult);
    return false;
}
// Make an API call to create an event.  Give feedback to user.
function createEvent(eventData) {
// First create resource that will be send to server.
    var resource = {
        "summary": eventData.eventTitle,
        "start": {
            "dateTime": new Date(eventData.date + " " + eventData.startTime).toISOString()
        },
        "end": {
            "dateTime": new Date(eventData.date + " " + eventData.endTime).toISOString()
        }
    };
    // create the request
    var request = gapi.client.calendar.events.insert({
        'calendarId': 'primary',
        'resource': resource
    });

    // execute the request and do something with response
    request.execute(function(resp) {
        console.log(resp);
        alert("Your event was added to the calendar.");
    });
}