$(document).ready(function(){
				
				 covertDataToCurrencyFormat();
				 
				 var guaranteeFeeApplicableFlag = document.forms[0].elements("guaranteeFeeApplicableFlag");
		
				  if(guaranteeFeeApplicableFlag[0].checked)
				  {
				      $("#guaranteeFeeRateDivID").show();
				   }else{
					  $("#guaranteeFeeRateDivID").hide(); 
				  }
				  
				  var guaranteeFeeApplicableFlag = document.forms[0].elements("commitmentFeeApplicableFlag");
					
				  if(guaranteeFeeApplicableFlag[0].checked)
				  {
				      $("#commitmentFeeRateDivID").show();
				   }else{
					  $("#commitmentFeeRateDivID").hide(); 
				  }
		
				  $('#mDriversAlert').hide();
				 
				  var actionType = document.forms[0].elements("rateInformation.interestTypeId");
					
				  if(actionType[0].checked){
					    $('.fixed-container').show();
					    $('.float-container').hide();
					    $('#maxSpreadDivID').show();
					    
				  }else if(actionType[1].checked){
					    $('.fixed-container').hide();
					    $('.float-container').show();
					    $('#maxSpreadDivID').show();
				  }else{
					    $('.fixed-container').hide();
					    $('.float-container').hide();
					    $('#maxSpreadDivID').hide();
				  }
				  
				  var modelType = document.forms[0].elements("tpLegRequest.modelTypeId").value;
				  
				  if(modelType == "1" ){
					 $('#Other').show();
				  }else {
					  $('#Other').hide();
				  }
				  
				 
				  				  
				  showAssessmentComment();
				  
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
					  $('#commentsReq6').hide();
					});
				  $("#smradioH6").click(function() {
					  $('#commentsReq6').show();
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
					}else if ($('#me-conditional-select').val() == ''){
						$('.mDrivers').hide();
						$('#mDriversAlert').hide();
					}else{
						$('.mDrivers').hide();
						$('#scoresO').hide();
						$('#scoresOO').hide();
						$('#scores1').hide();
						$('#scores2').hide();
						$('#scores3').hide();
						$('#scores4').hide();
						$('#scores5').hide();
						$('#mDriversAlert').show();
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
						  $('#floatMaxSpreadBPSID').val("");
						  $('#floatMinSpreadBPSID').val("");
						  $('#maxSpreadDivID').show();
					  });
					
					  $('#commitmentFeeApplicableNoID').click(function(e){
						  $('#commitmentFeeRateID').val("");
					  });
					  
					  $('#guaranteeFeeApplicableNoID').click(function(e){
						  $('#guaranteeFeeRateID').val("");
					  });
     });