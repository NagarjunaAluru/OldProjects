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
	
 	$("#qualitativeFactor1").click(function(){
		  $("#commentsQualFacID").show();
	});
	$("#qualitativeFactor2").click(function(){
		  $("#commentsQualFacID").show();
	});
	$("#qualitativeFactor3").click(function(){
		  $("#commentsQualFacID").hide();
	});
	
	$("#applyAssessment input").change(function(){
		$(this).parent().parent().removeClass('req-error');
	}); 
	
	var high = $('input[id=qualitativeFactor1]:checked').val();
 	var medium = $('input[id=qualitativeFactor2]:checked').val();
 	var low = $('input[id=qualitativeFactor3]:checked').val();
 	
 	if(high!=undefined && high=="1")
	{
	 $("#commentsQualFacID").show();
	}
 	else if(medium!=undefined && medium=="2")
	{
	  $("#commentsQualFacID").show();
	}
 	else if(low!=undefined && low=="3")
	{
	 $("#commentsQualFacID").hide();
	}
 	
});