/**
 * @author arijit.biswas
 */

$(document).ready(function(){
	var amendRiderOption='';
	var closeTransOption='';
	$('.createAmendmentRider').off("click").on("click", function(){
		amendRiderOption = $(this).val();
	});
	$("#createAmendmentRiderDiv").undelegate('.btn-secondary', 'click').delegate('.btn-secondary', 'click', function() {
		$('.valAmdRidError').empty().hide();
		var value = $.trim($(this).siblings('input.span160').val());
		var formData = {amendRiderOption:amendRiderOption,amendRiderValue:value};
		var url = contextURL + "/int/validateAmendmentRider.action";
		var parentDiv = $(this).parent('div');
		$(parentDiv).removeClass('errorinLanding');
		if(amendRiderOption != '' && value != ''){
			var errorMsg = "The ";
			if(amendRiderOption == 'issuerReferenceNumber'){
				errorMsg = errorMsg + "Issuer reference number";
			}else if(amendRiderOption == 'alocRecNo'){
				errorMsg = errorMsg + "ALOC record number";
			}
			errorMsg = errorMsg + " entered is not valid";
			$.ajax({
				type: "POST",
	            url: url,
	            dataType: 'json',
	            data: formData,
	            success: function(response) {
	            	if(response != null){
		            	var alocRecNo = response.result[0].AlocRecordNo;
		            	var instrTypeId = response.result[0].InstrumentTypeId;
		            	var instrType = response.result[0].InstrumentType;
		            	createAmendmentRider(alocRecNo,instrTypeId,instrType);
	            	}else if (response == null){
	            		$(parentDiv).addClass('errorinLanding');
						$('.valAmdRidError').text(errorMsg).show();
	            	}
	            },
		        error: function (xhr, textStatus, errorThrown ) {
					$(parentDiv).addClass('errorinLanding');
					$('.valAmdRidError').text(xhr.responseText).show();
				}
			});
		}else{
			$(parentDiv).addClass('errorinLanding');
			var errorMsg = "Enter a ";
			if(amendRiderOption == 'issuerReferenceNumber'){
				errorMsg = errorMsg + "Issuer reference number";
			}else if(amendRiderOption == 'alocRecNo'){
				errorMsg = errorMsg + "ALOC record number";
			}else{
				errorMsg = "Enter an Option";
			}
			$('.valAmdRidError').text(errorMsg).show();
		}
	});
	
	$('.closeTransaction').off("click").on("click", function(){
		closeTransOption = $(this).val();
	});
	
	$("#closeTransactionDiv").undelegate('.btn-secondary', 'click').delegate('.btn-secondary', 'click', function() {
		$('.closeTransError').empty().hide();
		var value = $.trim($(this).siblings('input.span160').val());
		var formData = {closeTransOption:closeTransOption,closeTransValue:value};
		var url = contextURL + "/int/validateCloseTransaction.action";
		var parentDiv = $(this).parent('div');
		if($(parentDiv).hasClass('errorinLandingCT')){
			$(parentDiv).removeClass('errorinLandingCT').addClass('boxContent');
		}
		if(closeTransOption != '' && value != ''){
			$.ajax({
				type: "POST",
	            url: url,
	            dataType: 'json',
	            data: formData,
	            success: function(response) {
	            	if(response != null){
	            		$('#requestId').val(response.result.AlocRecordNo);
	            		$('#wfid').val(response.result.wfid);
	            		$('#queueName').val(response.result.queueName);
	            		$('#procedureName').val(response.result.procedureName);
	            		$('#stageName').val(response.result.WFStage);
	            		$('#instrumentId').val(response.result.InstrumentTypeId);
	            		$('form#openCloseTransactionForm').submit();
	            	}else if (response == null){
	            		$(parentDiv).addClass('errorinLandingCT').removeClass('boxContent');
	            		var errorMsg = "The ";
						if(closeTransOption == 'issuerReferenceNumber'){
							errorMsg = errorMsg + "Issuer reference number";
						}else if(closeTransOption == 'alocRecNo'){
							errorMsg = errorMsg + "ALOC record number";
						}else if(closeTransOption == 'bankReferenceNumber'){
							errorMsg = errorMsg + "Bank reference number";
						}else if(closeTransOption == 'bondReferenceNumber'){
							errorMsg = errorMsg + "Bond reference number";
						}
						errorMsg = errorMsg + " entered is not valid";
	            		$('.closeTransError').text(errorMsg).show();
	            	}
	            },
		        error: function (xhr, textStatus, errorThrown ) {
					$(parentDiv).addClass('errorinLandingCT').removeClass('boxContent');
					var errorMsg = "The ";
					if(closeTransOption == 'issuerReferenceNumber'){
						errorMsg = errorMsg + "Issuer reference number";
					}else if(closeTransOption == 'alocRecNo'){
						errorMsg = errorMsg + "ALOC record number";
					}else if(closeTransOption == 'bankReferenceNumber'){
						errorMsg = errorMsg + "Bank reference number";
					}else if(closeTransOption == 'bondReferenceNumber'){
						errorMsg = errorMsg + "Bond reference number";
					}
					errorMsg = errorMsg + " entered is not valid";
					$('.closeTransError').text(errorMsg).show();
				}
			});
		}else{
			$(parentDiv).addClass('errorinLandingCT').removeClass('boxContent');
			var errorMsg = "Enter a ";
			if(closeTransOption == 'issuerReferenceNumber'){
				errorMsg = errorMsg + "Issuer reference number";
			}else if(closeTransOption == 'alocRecNo'){
				errorMsg = errorMsg + "ALOC record number";
			}else if(closeTransOption == 'bankReferenceNumber'){
				errorMsg = errorMsg + "Bank reference number";
			}else if(closeTransOption == 'bondReferenceNumber'){
				errorMsg = errorMsg + "Bond reference number";
			}else{
				errorMsg = "Enter an Option";
			}
			$('.closeTransError').text(errorMsg).show();
		}
	});
	$(".infoclose").click(function(){
	    $("#infoMsg").hide("fast");
	});	
	$('form#openCloseTransactionForm').submit(function() {
		return true;
	});
	
});

function createAmendmentRider(alocRecNo,instrTypeId,instrType) {
	if(instrTypeId == '1' || instrTypeId == '2'){
		 document.getElementById("openAmendmentRequestForm").action = contextURL + "/int/requestor/openAmendmentRequest.action";
		 $('#requestId1').val(alocRecNo);
		 $('#instrumentId1').val('5');
	     document.getElementById("openAmendmentRequestForm").submit();
	}else if(instrTypeId == '3'){
		document.getElementById("openRiderRequestForm").action = contextURL + "/int/requestor/openRiderRequest.action";
		$('#requestId2').val(alocRecNo);
		$('#instrumentId2').val('6');
		document.getElementById("openRiderRequestForm").submit();
	}
}

