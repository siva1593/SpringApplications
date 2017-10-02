
jQuery(document).ready(function($) {
 
	 function displayTime() {
        $.ajax({
            url : 'time',
            success : function(data) {
                $('#result').html(data);
            }
        });
    }
	
	 var intervalId = 0;
	    intervalId = setInterval(displayTime, 1000);

});
