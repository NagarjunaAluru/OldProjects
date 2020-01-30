$(function(){
	
	$("#applyAssessment .btn-success").click(function(){
		if( $(this).parent().prev().find(".radio-container input:checked").length == 0 ){
			$(this).parent().parent().find(".radio-container").addClass('req-error');			
		}else{			
			$("#applyAssessment").modal("hide");			
		}
	});
	
	$("#applyAssessment input").change(function(){
		$(this).parent().parent().removeClass('req-error');
	});
	
});

function closeAapplyAssessmentModal() {
	$("#applyAssessment").modal('hide');
}