$(function(){
 	$("#applyAssessment .btn-success").click(function(){
		if( $(this).parent().prev().find(".radio-container input:checked").length == 0 ){
			$(this).parent().parent().find(".radio-container").addClass('req-error');			
		}else{			
			$("#applyAssessment").modal("hide");			
		}
		var option = $('input[name=qApplyAssessment]:radio:checked').val();
		$('#radioValueId').val(option);
	});
	
	$("#applyAssessment input").change(function(){
		$(this).parent().parent().removeClass('req-error');
	}); 
});