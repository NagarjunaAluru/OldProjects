
$(document).ready(function(){
	
	$('#mDriversAlert').hide();
	  showAssessmentComment();
	  onLoadSolvencyCalc();
	  covertDataToCurrencyFormat();
	  
	  var modelType = document.forms[0].elements("TPLegRequest.modelTypeId").value;
	  
	  if(modelType == "1" ){
		 $('#Other').show();
	  }else {
		  $('#Other').hide();
	  }
	  
	  
	  			
	  
	  
	  $("#smradioS0").click(function() {
			 
		  $('#commentsReq0').hide();
		});
	  $("#smradioH0").click(function() {
		  $('#commentsReq0').show();
		});	
	  
	  $("#smradioS1").click(function() {
		  
		  $('#commentsReq1').hide();
		});
	  $("#smradioH1").click(function() {
		  $('#commentsReq1').show();
		});
	  
	  $("#smradioS2").click(function() {
		  
		  $('#commentsReq2').hide();
		});
	  $("#smradioH2").click(function() {
		  $('#commentsReq2').show();
		});
	  
	  $("#smradioS3").click(function() {
		 
		  $('#commentsReq3').hide();
		});
	  $("#smradioH3").click(function() {
		  $('#commentsReq3').show();
		});
	  
	  $("#smradioS4").click(function() {
		  
		  $('#commentsReq4').hide();
		});
	  $("#smradioH4").click(function() {
		  $('#commentsReq4').show();
		});
	  
	  $("#smradioS5").click(function() {
		 
		  $('#commentsReq5').hide();
		});
	  $("#smradioH5").click(function() {
		  $('#commentsReq5').show();
		});
	  
	   $("#smradioS6").click(function() {
		  $('#commentsReq6').show();
		  $('#solvencyMetrics6TdID').removeClass("solvencyYellowClass");
		  $('#solvencyMetrics6TdID').removeClass("solvencyRedClass");
		  $('#solvencyMetrics6TdID').removeClass("solvencyGreenClass"); 
		  $('#solvencyMetrics6TdID').addClass("solvencyRedClass"); 
		});
	  $("#smradioH6").click(function() {
		  $('#commentsReq6').hide();
		  $('#solvencyMetrics6TdID').removeClass("solvencyYellowClass");
		  $('#solvencyMetrics6TdID').removeClass("solvencyRedClass");
		  $('#solvencyMetrics6TdID').removeClass("solvencyGreenClass"); 
		  $('#solvencyMetrics6TdID').addClass("solvencyGreenClass"); 
		});
	  
	  $('#commentsQualFacID').hide();
	  
	  $("#qualitativeFactor1").click(function() {
		  $('#commentsQualFacID').show();
		});
	  $("#qualitativeFactor2").click(function() {
		  $('#commentsQualFacID').show();
		});
	  $("#qualitativeFactor3").click(function() {
		  $('#commentsQualFacID').hide();
		});
		   
		if($('#me-conditional-select').val() == '1' ){
			$('.mDrivers').show();
			$('#mDriversAlert').show();
			$('#mDriversAttach').show();
		}
		else if($('#me-conditional-select').val() == '2' ){
			$('.mDrivers').hide();
			$('#mDriversAlert').show();
			$('#mDriversAttach').show();
		}
		else if($('#me-conditional-select').val() == '3' ){
			$('.mDrivers').hide();
			$('#mDriversAlert').show();
			$('#mDriversAttach').show();
			
		}else if($('#me-conditional-select').val() == '' ){
			$('.mDrivers').hide();
			$('#mDriversAlert').hide();
		}
		else{
			$('.mDrivers').hide();
			$('#mDriversAlert').show();
			$('#mDriversAttach').show();
		}
		
		$('textarea').keyup(function() {
		  	  var len = this.value.length;
		  	  if (len >= 500) {
		  	  this.value = this.value.substring(0, 500);
		  	  }
		  	  });
});