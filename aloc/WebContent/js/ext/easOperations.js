$(document).ready(function() {
	
	$("#termslink").click(function(){
        $("#termsncond").toggle("fast");
	}); 
	
	if (window.PIE) {
        $('.circle,.main,.modal-header,.boxHead,.errorHead,.errorContent,.btn').each(function() {
            PIE.attach(this);
        });
    }
});

function onLoginFormSubmit() {
	var user = $('#orgId').val() + ':' + $('#userId').val();
	$('#USER').val(user);
	$('#userId').val(user);
	return true;
}