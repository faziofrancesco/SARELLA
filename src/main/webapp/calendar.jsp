<%--
  Created by IntelliJ IDEA.
  User: gomgo
  Date: 23/02/2020
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Flexible Calendar</title>
    <meta name="description" content="Flexible Calendar with jQuery and CSS3" />
    <meta name="keywords" content="responsive, calendar, jquery, plugin, full page, flexible, javascript, css3, media queries" />
    <meta name="author" content="Codrops" />
<body>
<div class="container">
    <!-- Codrops top bar -->
    <!--/ Codrops top bar -->
    <div class="custom-calendar-wrap custom-calendar-full">

    </div>
    <div id="calendar" class="fc-calendar-container"></div>
</div>
<!-- /container -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/calendar.js"></script>
<link rel="stylesheet" type="text/css" href="assets/css/calendar.css">

<script type="text/javascript">
    $(function() {

        var cal = $( '#calendar' ).calendario( {
                onDayClick : function( $el, $contentEl, dateProperties ) {

                    for( var key in dateProperties ) {
                        console.log( key + ' = ' + dateProperties[ key ] );
                    }

                },
                caldata : codropsEvents
            } ),
            $month = $( '#custom-month' ).html( cal.getMonthName() ),
            $year = $( '#custom-year' ).html( cal.getYear() );

        $( '#custom-next' ).on( 'click', function() {
            cal.gotoNextMonth( updateMonthYear );
        } );
        $( '#custom-prev' ).on( 'click', function() {
            cal.gotoPreviousMonth( updateMonthYear );
        } );
        $( '#custom-current' ).on( 'click', function() {
            cal.gotoNow( updateMonthYear );
        } );

        function updateMonthYear() {
            $month.html( cal.getMonthName() );
            $year.html( cal.getYear() );
        }

        // you can also add more data later on. As an example:
        /*
        someElement.on( 'click', function() {

            cal.setData( {
                '03-01-2013' : '<a href="#">testing</a>',
                '03-10-2013' : '<a href="#">testing</a>',
                '03-12-2013' : '<a href="#">testing</a>'
            } );
            // goes to a specific month/year
            cal.goto( 3, 2013, updateMonthYear );

        } );
        */

    });
</script>
</body>
</html>
