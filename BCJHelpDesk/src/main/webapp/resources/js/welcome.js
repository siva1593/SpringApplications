
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
 
	   function getUserType() {
	        $.ajax({ 
	            url : 'getUserType',
	            success : function(userType) {
	            	
	            	for(i in userType){
	            		$("#userType").append("<option value='"+userType[i]+"'>"+userType[i]+"</option>");
	            	}
	            }
	        });
	    }
	   
	getUserType();
	 
	 function getStatesName() {
	        $.ajax({ 
	            url : 'getState',
	            success : function(state) {
	            	
	            	for(i in state){
	            		
	            		$("#state").append("<option value='"+state[i]+"'>"+state[i]+"</option>");

	            	}
	            }
	        });
	    }
	   
	 getStatesName();

});