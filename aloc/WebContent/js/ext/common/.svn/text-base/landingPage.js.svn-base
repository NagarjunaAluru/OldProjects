/**
 * @author arijit.biswas
 */

$(document).ready(function(){
	var closeTransOption='';
	
	$('.closeTransaction').off("click").on("click", function(){
		closeTransOption = $(this).val();
	});
	
	$("#closeTransactionDiv").undelegate('.btn-secondary', 'click').delegate('.btn-secondary', 'click', function() {
		$('.closeTransError').empty().hide();
		var value = $.trim($(this).siblings('input.span160').val());
		var formData = {closeTransOption:closeTransOption,closeTransValue:value};
		var url = contextURL + "/ext/validateCloseTransaction.action";
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

