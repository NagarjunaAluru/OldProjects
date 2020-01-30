/**
 * @author ramakrishna.satti
 */

$(document).ready(function(){
	$("#createAmendmentRiderDiv").undelegate('.crAmendment', 'click').delegate('.crAmendment', 'click', function() {
		$('#valAmdRidErrordiv').hide();
		var reqId= $('#reqId').val();
		var formData = {amendRiderOption:"alocRecNo",amendRiderValue:reqId};
		var url = contextURL + "/int/validateAmendmentRider.action";
		$.ajax({
			type: "POST",
            url: url,
            dataType: 'json',
            data: formData,
            success: function(response) {
            	var alocRecNo = response.result[0].AlocRecordNo;
            	var instrTypeId = response.result[0].InstrumentTypeId;
            	var instrType = response.result[0].InstrumentType;
            	createAmendmentRider(alocRecNo,instrTypeId,instrType);
            },
	        error: function (xhr, textStatus, errorThrown ) {
				$('.valAmdRidError').empty().text(xhr.responseText);
				$('#valAmdRidErrordiv').show();
			}
		});
	});
	$('#treasuryAuditlogTable tr:odd').addClass('odd');
	$('#taxonomyAmendment tr:odd').addClass('odd');
	$('#taxonomyFeeHistory tr:odd').addClass('odd');
	$('#tableeLinks tr:odd').addClass('odd');
	$('#taxonomyBundleTrans tr:odd').addClass('odd');
	$('#transactionTable tr:odd').addClass('odd');
	
	jQuery('#bgTaxonomyForm').preventDoubleSubmit();
	jQuery('#cuuBankForm').preventDoubleSubmit();
	jQuery('#dlocRequestForm').preventDoubleSubmit();
	jQuery('#suretyRequestForm').preventDoubleSubmit();
	
});

function createAmendmentRider(alocRecNo,instrTypeId,instrType) {
	if(instrTypeId == '1' || instrTypeId == '2'){
		document.forms[0].action = contextURL + "/int/requestor/openAmendmentRequest.action?requestId="+alocRecNo+"&instrumentId=5&oldInstrumentType="+instrType;
		document.forms[0].submit();
	}else if(instrTypeId == '3'){
		document.forms[0].action = contextURL + "/int/requestor/openRiderRequest.action?requestId="+alocRecNo+"&instrumentId=6&oldInstrumentType="+instrType;
		document.forms[0].submit();
	}
}

function showAuditProcess(){
	$('#showFullAuditProcess').show();
}

function showActionProcess(){
	$('#showFullActionProcess').show();
}
