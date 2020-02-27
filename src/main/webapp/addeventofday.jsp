<%--
  Created by IntelliJ IDEA.
  User: gomgo
  Date: 25/02/2020
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Google Calendar Event</title>
    <link rel="stylesheet" href="">
    <script src="assets/js/calendarevent.js"></script>
    <script src="https://apis.google.com/js/client.js?onload=handleClientLoad"></script>


</head>

<body>
<h1>Event for Google Calendar</h1>
<div id="content">
    <p>Fill these fields to enter a new event in your Google Calendar.</p>
    <p><label>Select a date: <input type="date" id="date"></label></p>
    <p><label>Start time <input type="time" id="start"></label>
        <label>End time: <input type="time" id="end"></label>
    </p>
    <p><label>Event description: <input type="text" id="event" size=60></label></p>
    <p><button id="authorize-button" style="visibility: hidden">Login & Authorize</button></p>
    <p><button id="addToCalendar" style="visibility: hidden">Add to Google Calendar</button></p>
</div>
<!--Add a button for the user to click to initiate auth sequence -->
<script src="assets/js/calendarevent.js"></script>
<script src="https://apis.google.com/js/client.js?onload=handleClientLoad"></script>
</body>
</html>