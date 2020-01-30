

$(document).ready(function(){
	showAssessmentComment();
	 onLoadSolvencyCalc();
	covertDataToCurrencyFormat();
	$('#mDriversAlert').hide();

	var actionType = document.forms[0].elements("rateInformation.interestTypeId");
	
	  if(actionType!=null && actionType[0].checked){
		    $('.fixed-container').show();
		    $('.float-container').hide();
		    $('#maxSpreadDivID').show();
		    
	  }else if(actionType!=null && actionType[1].checked){
		    $('.fixed-container').hide();
		    $('.float-container').show();
		    $('#maxSpreadDivID').show();
	  }else{
		    $('.fixed-container').hide();
		    $('.float-container').hide();
		    $('#maxSpreadDivID').hide();
	  }
		  
	  
	  $('#fixedRateID').click(function(e){
		  $('#floatingRateIndexID').val("");
		  $('#floatingRateIndexTermID').val("");
		  $('#floatMaxSpreadBPSID').val("");
		  $('#floatMinSpreadBPSID').val("");
		  $('#maxSpreadDivID').show();
	  });
	  
	  $('#floatRateID').click(function(e){
		  $('#baseFixedRateID').val("");
		  $('#floatMaxSpreadBPSID').val("");
		  $('#floatMinSpreadBPSID').val("");
		  $('#maxSpreadDivID').show();
	  });
	  
	  
	var modelType = $('#me-conditional-select').val();
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
			$('#scoresO').show();
			$('#scoresOO').hide();
			$('#scores1').show();
			$('#scores2').hide();
			$('#scores3').show();
			$('#scores4').show();
			$('#scores5').show();
			$('#mDriversAlert').show();
			$('#mDriversAttach').show();
		}
		else if($('#me-conditional-select').val() == '2' ){
			$('.mDrivers').hide();
			$('#scoresO').hide();
			$('#scoresOO').hide();
			$('#scores1').show();
			$('#scores2').hide();
			$('#scores3').show();
			$('#scores4').show();
			$('#scores5').show();		
			$('#mDriversAlert').show();
			$('#mDriversAttach').show();
		}
		else if($('#me-conditional-select').val() == '3' ){
			$('.mDrivers').hide();
			$('#scoresO').hide();
			$('#scoresOO').hide();
			$('#scores1').show();
			$('#scores2').hide();
			$('#scores3').show();
			$('#scores4').show();
			$('#scores5').show();
			$('#mDriversAlert').show();
			$('#mDriversAttach').show();
		}else if ($('#me-conditional-select').val() == ''){
			// This block is executed when nothing is selected in drop down
			$('.mDrivers').hide();
			$('#mDriversAlert').hide();
		}else {
		  // This will be executed when other is selected in drop down
			$('.mDrivers').hide();
			$('#scoresO').hide();
			$('#scoresOO').hide();
			$('#scores1').hide();
			$('#scores2').hide();
			$('#scores3').hide();
			$('#scores4').hide();
			$('#scores5').hide();
			$('#mDriversAlert').show();
			$('#mDriversAttach').show();
		}

		$('#saveLeg').click(function(e){
		  removeAmountShortcuts();
		 document.forms[0].action = contextURL + '/transferPricing/transferPricingOtherLeg.do?command=saveAndReturnToDeal';
		 document.forms[0].submit();
	  });

		$('.autosize').keyup(function() {
			var len = this.value.length;
			if (len >= 500) {
			this.value = this.value.substring(0, 500);
			}
		});

		$('.autosize1').keyup(function() {
			var len = this.value.length;
			if (len >= 1000) {
			this.value = this.value.substring(0, 1000);
			}
		});
});

function closeConfirmModal() {
	$("#confirm").modal('hide');
}