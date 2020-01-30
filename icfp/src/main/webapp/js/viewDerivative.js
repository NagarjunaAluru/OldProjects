$(document).ready(function(){
	
	if($('#derivativeTypeId').val() == '3'|| $('#derivativeTypeId').val() == '4'|| $('#derivativeTypeId').val() == '5'  ){
		$('.contractClass').show();
	}
		
	if(($("#hedgeDesigationId").val() != '3'&& $("#hedgeDesigationId").val() != '1' && $("#hedgeDesigationId").val() != '2' && $("#hedgeDesigationId").val() != '5')){
		$('.hedgeProgram').hide();
	}
	
	if(($('#hedgeDesigationId').val() == '3'|| $('#hedgeDesigationId').val() == '1'|| $('#hedgeDesigationId').val() == '2' || $('#hedgeDesigationId').val() == '5') 
			&& ($("#derivativeTypeId").val() == '1' || $("#derivativeTypeId").val() == '2')){
		$('.hedgeProgram').show().highlight();
	}else{
		$('.hedgeProgram').hide();
	}
	
});