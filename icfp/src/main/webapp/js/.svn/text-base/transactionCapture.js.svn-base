
$(document).ready(function() {
	$('.material-condition').hide();
	$('#sbCommentsError').hide();
	$('#orCommentsError').hide();
	$('#roCommentsError').hide();
	var continueAction = "";
	$('textarea[name=changeTypeComments]').keyup(function() {
		var len = this.value.length;
		if(len > 0){
			$('input:radio[value=sendBack]').removeAttr("disabled");
		}else{
			$('input:radio[value=sendBack]').attr("disabled", "disabled");
		}
	});
	$('input:radio[name=changeTypeId]').live('change', function() { 
		var value = $('input:radio[name=changeTypeId]:checked').val();
		if(value == 2){
			$('input:radio[value=sendBack]').attr("disabled", "disabled");
			$('input:radio[value=override]').removeAttr("disabled");
			if(checkCertify == 31){
				$('input:radio[value=certify]').removeAttr("disabled");
			}
		}else{
			$('input:radio[value=certify]').attr("disabled", "disabled");
			$('input:radio[value=override]').attr("disabled", "disabled");
			if (!$.trim($('textarea[name=changeTypeComments]').val())) {
				$('input:radio[value=sendBack]').attr("disabled", "disabled");
			}else{
				$('input:radio[value=sendBack]').removeAttr("disabled");
			}
		}
	});
	
	$('input:radio[name=changeAfterApprovalFlag]').live('change', function() { 
		var value = $('input:radio[name=changeAfterApprovalFlag]:checked').val();
		if(value == 0){
			$('input:radio[value=sendBack]').removeAttr("disabled");
			$('input:radio[value=override]').removeAttr("disabled");
			if(checkCertify == 31){
				$('input:radio[value=certify]').removeAttr("disabled");
			}
		}else{
			if($('input:radio[name=changeTypeId]:checked').val() == 2){
				$('input:radio[value=sendBack]').attr("disabled", "disabled");
				$('input:radio[value=override]').removeAttr("disabled");
				if(checkCertify == 31){
					$('input:radio[value=certify]').removeAttr("disabled");
				}
				$('.closing-checklist, .material-condition').show();
			}else{
				$('input:radio[value=certify]').attr("disabled", "disabled");
				$('input:radio[value=override]').attr("disabled", "disabled");
				if (!$.trim($('textarea[name=changeTypeComments]').val())) {
					$('input:radio[value=sendBack]').attr("disabled", "disabled");
				}else{
					$('input:radio[value=sendBack]').removeAttr("disabled");
				}
			}
		}
	});
	
	$('#submit').click(function(e){
		$('#sbCommentsError').hide();
		$('#orCommentsError').hide();
		$("#forwardPageId").val("homePage");
		var action = $('input:radio[name=submitAction]:checked').val();
		if(action == undefined){
			$('#topErrorDiv').show();
			$('#updateStatusForm').find('.btn-container').find('.radio-container').addClass('conditional-radio-tri req-error');
			$('#actionButton').attr('style','margin-top: 75px;');
		}else if(action == 'approve'){
			$('#approveRejectId').val("0");
			$('#actionID').val(action);
			$('#topErrorDiv').hide();
			$('#commentsID').val($('#dealCommentsId').val());
			$('#updateStatusForm').find('.btn-container').find('.radio-container').removeClass('conditional-radio-tri req-error');
			$('#actionButton').removeAttr('style');
			
			var changeTypeComments = $('textarea[name=changeTypeComments]').val();
			if(changeTypeComments != '')
				{
				$('#changeTypeCommentsError').hide();
				}
			else{
				$('#changeTypeCommentsError').show();
			}
			continueAction = "approve";
			$('#wantToContinuePopup').modal('show');
			
			
			
		}else if (action === 'sendBack'){
			$("#sendback").modal('show');
		}else if (action === 'moCloseOut'){
			$("#closeOut").modal('show');
		}else if (action === 'approveOverride'){
			$("#approveOverride").modal('show');
			var changeTypeComments = $('textarea[name=changeTypeComments]').val();
			if(changeTypeComments != '')
			{
			$('#changeTypeCommentsError').hide();
			}
		else{
			$('#changeTypeCommentsError').show();
		}
			
		}else{
			$('#topErrorDiv').hide();
			$('#updateStatusForm').find('.btn-container').find('.radio-container').removeClass('conditional-radio-tri req-error');
			$('#actionButton').removeAttr('style');
		}
	});
	$('#wantToContinue').click(function(e){
		if(continueAction == "approve"){
			document.forms[0].action = contextURL + '/transactionCapture/transactionCaptureARFourBlocker.do?command=submitDealRequest';
			document.forms[0].submit();
		}
	});
	$('#sendback').find('.btn-success').click(function() {
		var comments = $('#sendback').find('textarea[name="textarea2"]').val();
		if(comments != ''){
			$('#actionCommentsID').val(comments);
			$('#commentsID').val($('#dealCommentsId').val());
			$('#approveRejectId').val("2");
			$('#actionID').val("sendBack");
			$('#sendback').find('.btn-success').attr('data-dismiss','modal');
			$('#sbCommentsError').hide();
			var a= $('#sendback').find('.btn-success').text();
			if(a == 'Send back'){
				document.forms[0].action = contextURL + '/transactionCapture/transactionCaptureARFourBlocker.do?command=submitDealRequest';
			}else if(a == 'Send request back'){
				$('#materialCFlag').val("1");
				document.forms[0].action = contextURL + '/transactionCapture/transactionCaptureFOCMFourBlocker.do?command=submitDealRequest';
			}else if(a == 'Send Back'){
				document.forms[0].action = contextURL + '/transactionCapture/transactionCaptureMOFourBlocker.do?command=submitDealRequest';
			}
			document.forms[0].submit();
		}else{
			$('#sbCommentsError').show();
			$('#sendback').find('.btn-success').removeAttr('data-dismiss');
		}
	});
	$('#rejectRequest').find('.btn-success').click(function() {
		var comments = $('#rejectRequest').find('textarea[name="textarea2"]').val();
		if(comments != ''){
			$('#actionCommentsID').val(comments);
			$('#approveRejectId').val("2");
			$('#actionID').val("reject");
			$('#rejectRequest').find('.btn-success').attr('data-dismiss','modal');
			$('#roCommentsError').hide();
			document.forms[0].action = contextURL + '/transactionCapture/transactionCaptureManagerFourBlocker.do?command=submitDealRequest';
			document.forms[0].submit();
		}else{
			$('#roCommentsError').show();
			$('#rejectRequest').find('.btn-success').removeAttr('data-dismiss');
		}
	});
	$('#override').find('.btn-success').click(function() {
		var comments = $('#override').find('textarea[name="textarea2"]').val();
		if(comments != ''){
			$('#actionCommentsID').val(comments);
			$('#commentsID').val($('#dealCommentsId').val());
			$('#approveRejectId').val("0");
			$('#actionID').val("override");
			$('#OverRideFlag').val("1");
			$('#override').find('.btn-success').attr('data-dismiss','modal');
			$('#orCommentsError').hide();
			document.forms[0].action = contextURL + '/transactionCapture/transactionCaptureFOCMFourBlocker.do?command=submitDealRequest';
			document.forms[0].submit();
		}else{
			$('#orCommentsError').show();
			$('#override').find('.btn-success').removeAttr('data-dismiss');
		}
	});
		
	$('#saveActionFOCM').click(function(e){
		$('#approveRejectId').val("0");
		$('#actionID').val("save");
		$("#forwardPageId").val("success");
		$('#commentsID').val($('#dealCommentsId').val());
		$('#topErrorDiv').hide();
		document.forms[0].action = contextURL + '/transactionCapture/transactionCaptureFOCMFourBlocker.do?command=submitDealRequest&action=save';
		document.forms[0].submit();
	});
	
	$('#saveActionManager').click(function(e){
		$('#approveRejectId').val("0");
		$('#actionID').val("save");
		$("#forwardPageId").val("success");
		$('#commentsID').val($('#dealCommentsId').val());
		$('#topErrorDiv').hide();
		document.forms[0].action = contextURL + '/transactionCapture/transactionCaptureManagerFourBlocker.do?command=submitDealRequest&action=save';
		document.forms[0].submit();
	});
	
	$('#saveActionAR').click(function(e){
		var comments = $('#dealCommentsId').val();
		$('#commentsID').val(comments);
		$('#approveRejectId').val("0");
		$('#actionID').val("save");
		$("#forwardPageId").val("success");
		$('#commentsID').val($('#dealCommentsId').val());
		$('#topErrorDiv').hide();
		document.forms[0].action = contextURL + '/transactionCapture/transactionCaptureARFourBlocker.do?command=submitDealRequest&action=save';
		document.forms[0].submit();
	});
	
	$('#saveActionMO').click(function(e){
		$('#approveRejectId').val("0");
		$('#actionID').val("save");
		$("#forwardPageId").val("success");
		$('#commentsID').val($('#dealCommentsId').val());
		$('#topErrorDiv').hide();
		document.forms[0].action = contextURL + '/transactionCapture/transactionCaptureMOFourBlocker.do?command=submitDealRequest&action=save';
		document.forms[0].submit();
	});
	
	$('textarea').keyup(function() {
		var len = this.value.length;
		if (len >= 500) {
		this.value = this.value.substring(0, 500);
		}
	});
	$('#certify').find('.btn-success').click(function() {
		$("#forwardPageId").val("submitSuccess");
		$('#approveRejectId').val("0");
		$('#actionID').val("certify");
		$('#commentsID').val($('#dealCommentsId').val());
		$('#topErrorDiv').hide();
		
		var changeTypeComments = $('textarea[name=changeTypeComments]').val();
	
		if(changeTypeComments != '')
		{
		$('#changeTypeCommentsError').hide();
		}
	else{
		$('#changeTypeCommentsError').show();
	}
		document.forms[0].action = contextURL + '/transactionCapture/transactionCaptureFOCMFourBlocker.do?command=submitDealRequest';
		document.forms[0].submit();
		
		
		
	});
	
	$('#closeOut').find('.btn-success').click(function() {
		$("#forwardPageId").val("submitSuccess");
		$('#approveRejectId').val("0");
		$('#commentsID').val($('#dealCommentsId').val());
		$('#topErrorDiv').hide();
			$('#actionID').val("close");
			document.forms[0].action = contextURL + '/transactionCapture/transactionCaptureMOFourBlocker.do?command=submitDealRequest';
			document.forms[0].submit();
		
	});
	$('#approveOverride').find('.btn-success').click(function() {
		$("#forwardPageId").val("submitSuccess");
		$('#approveRejectId').val("0");
		$('#commentsID').val($('#dealCommentsId').val());
		$('#OrdApprovFlag').val("1");
		var changeTypeComments = $('textarea[name=changeTypeComments]').val();
		if(changeTypeComments != '')
		{
		$('#changeTypeCommentsError').hide();
		}
		else{
		$('#changeTypeCommentsError').show();
		}
		$('#topErrorDiv').hide();
			$('#actionID').val("approveOverride");
			document.forms[0].action = contextURL + '/transactionCapture/transactionCaptureManagerFourBlocker.do?command=submitDealRequest';
			document.forms[0].submit();
	});
});

/**
 * This method is used to validate whether the given vaultid is valid or not
 */
	function validateVaultDetails()
	{
		 var vaultID = $("#vaultTextID").val();
		 
		   var flag = true;
		   
		   if(vaultID==null || vaultID=="")
		   {
			   flag = false;
		   }
		   
		   flag = isNumber(vaultID);
		  
		   if(!flag){
			   $("#vaultTextID").val("");
		   }
	}
	
	/**
	 * This method is used to check the given value contains expected characters.
	 * @param val
	 * @returns {Boolean}
	 */
	function isNumber(val) {
		var numericExpression = /^[0-9]+$/;

		if(val.match(numericExpression)) {

		return true;

		} else {

		return false;

		}
	}
	
	
