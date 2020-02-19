
function onSignIn(googleUser) {
	   
    var profile = googleUser.getBasicProfile();
    var name =  profile.getGivenName();
    var surname  = profile.getFamilyName();
    var email = profile.getEmail();
    
    
    
    $.post("googleLogin",{ 	email : email, name : name, surname : surname }, function(result){
    				    	    if(result == 1){
    				    	    	window.location.href = "header.jsp";
    				    	    }
  				    	  });
}


