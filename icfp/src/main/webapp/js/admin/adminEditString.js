	/**
	 * Method to validate the admin rows data
	 * @returns {Boolean}
	 */
	function adminValidation () {
		var isvalid =true;
		$(".admin-validation").find(".request-admin").each(function(){
			if($(this).val()!=''){
				$(this).parent().find(".req-error").remove();
			}else{
				$(this).parent().append("<span class='req-error'>error</span>");
				isvalid = false;
			}
		} );
		return isvalid;
	}

	$(document).ready(function() {
		$('#genericErrorComment').hide();
		var validateflag = false;
		
		$('#submitAction').click(function(e){
			if(adminValidation() ){
				validateflag = false;
			}else{
				validateflag = true;
			}
			if(!validateflag){
			$('#genericErrorComment').hide();
			document.forms[0].action = contextURL + '/admin/admin.do?command=saveReferenceData';
			document.forms[0].submit();
			}else{
				$('#genericErrorComment').show();
			}
		});
	});