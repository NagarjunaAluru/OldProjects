
$(document).ready(function() {
	$('#valueDt').zdate({
		direction: true,
		readonly_element: true,
		format: 'm/d/Y',
		offset:  [20, 25],
		first_day_of_week: '0'
	});
	$('#sbCommentsError1').hide();
	$('#sbCommentsError2').hide();
	$('#dCommentsError2').hide();
	$('#dCommentsError4').hide();
	$('#dCommentsError5').hide();
	$('#dCommentsError6').hide();
	$('#dCommentsError7').hide();
	$('#errorDate').hide();
	$('#errorDate1').hide();
	$('#actionError').hide();
	$('#valueDateValidationID').hide();
		
	$('#submit').click(function(e){
		var source = $('input[name=sourcePage]').val();
		$('#sendBackComments').val("");
		$('#sbCommentsError1').hide();
		$('#sbCommentsError2').hide();
        
		$('#sendBack').click(function(e){
    		var comments = $('#sendBackComments').val();
    		
    		if(comments != ''){
    			 $('#selectedCommentsID').val(comments);
    			$('#sendBack').attr('data-dismiss','modal');
    			$('#sbCommentsError1').hide();
    			$('#sbCommentsError2').hide();
    			document.forms[0].action = contextURL + '/pipelineReview/pipelineReviewDeal.do?command=sendBack'+ "&source=" + source;
    			document.forms[0].submit();
    		}else{
    			$('#sbCommentsError1').show();
    			$('#sbCommentsError2').show();
    			$('#sendBack').removeAttr('data-dismiss');
    		}
    		
    	});
		
		
		var action = $('input:radio[name=optionsRadios]:checked').val();
		
		if(action == undefined){
			
			$('#actionError').show();
			$('#pipelineReviewDealFBId').find('.radio-container').addClass('conditional-radio-tri req-error');
			$('#actionButton').attr('style','margin-top: 100px;');
		}
	
		else if(action == 'acceptRequest'){
			 $("#inputsCompletedModalID").modal('show');
		}
		else if(action=='sendBack'){
				
				$('#actionError').hide();
				$('#pipelineReviewDealFBId').find('.radio-container').removeClass('conditional-radio-tri req-error');
				$('#actionButton').removeAttr('style');			
		}
		else if(action = 'reviewNextDeal'){
			 $("#inputsCompletedModalID1").modal('show');
		}else{
			$('#actionError').hide();
			$('#dCommentsError2').hide();
			$('#errorDate').hide();
			$('#errorDate1').hide();	
			$('#dCommentsError4').hide();
			$('#dCommentsError5').hide();
			$('#dCommentsError6').hide();
			$('#dCommentsError7').hide();
			$('#pipelineReviewDealFBId').find('.radio-container').removeClass('conditional-radio-tri req-error');
			$('#actionButton').removeAttr('style');
		}
	});
	
});

function validatePipeLineReviewDeal(comments,valueDt,treasuryTaxID,cashManagementID,middleOfficeID,frontOfficeID){
	var isValidFlag = true;
	var dateRe = re = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
	 $('#serverValueDateValidationID').hide();
	if(valueDt != ''){
		if(!date_check(valueDt)){
			$('#errorDate').show();
			$('#errorDate1').show();
			$('#valueDt').focus();
			isValidFlag = false;
		}else if(!valueDt.match(dateRe)){
			$('#errorDate').show();
			$('#errorDate1').show();
			$('#valueDt').focus();
			isValidFlag = false;
		}else{
			$('#errorDate').hide();
			$('#errorDate1').hide();
		}
	}else{
		$('#errorDate').show();
		$('#errorDate1').show();
		$('#valueDt').focus();
		isValidFlag = false;
	}
	
	if(treasuryTaxID != '0'){
		$('#dCommentsError4').hide();
		$('#dCommentsError4').hide();
		
	}else{
		$('#dCommentsError4').show();
		$('#dCommentsError4').show();
		$('#treasuryTaxID').focus();
		isValidFlag = false;
	}
	 if(cashManagementID != '0'){
		$('#dCommentsError5').hide();
		$('#dCommentsError5').hide();
	}else{
		$('#dCommentsError5').show();
		$('#dCommentsError5').show();
		$('#cashManagementID').focus();
		isValidFlag = false;
	}
	if(middleOfficeID != '0'){
		$('#dCommentsError6').hide();
		$('#dCommentsError6').hide();
	}else{
		$('#dCommentsError6').show();
		$('#dCommentsError6').show();
		$('#middleOfficeID').focus();
		isValidFlag = false;
	}
	if(frontOfficeID != '0'){
		$('#dCommentsError7').hide();
		$('#dCommentsError7').hide();
	}else{
		$('#dCommentsError7').show();
		$('#dCommentsError7').show();
		$('#frontOfficeID').focus();
		isValidFlag = false;
	}
	return isValidFlag;	
}

function validateMOPipeLineReviewDeal(comments,valueDt,middleOfficeID){
	var isValidFlag = true;
	var dateRe = re = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
	 $('#serverValueDateValidationID').hide();
	if(valueDt != ''){
		if(!date_check(valueDt)){
			$('#errorDate').show();
			$('#errorDate1').show();
			$('#valueDt').focus();
			isValidFlag = false;
		}else if(!valueDt.match(dateRe)){
			$('#errorDate').show();
			$('#errorDate1').show();
			$('#valueDt').focus();
			isValidFlag = false;
		}else{
			$('#errorDate').hide();
			$('#errorDate1').hide();
		}
	}else{
		$('#errorDate').show();
		$('#errorDate1').show();
		$('#valueDt').focus();
		isValidFlag = false;
	}
		
	if(middleOfficeID != '0'){
		$('#dCommentsError6').hide();
	}else{
		$('#dCommentsError6').show();
		$('#middleOfficeID').focus();
		isValidFlag = false;
	}
	return isValidFlag;	
}
function date_check(valueDt) {
	 var d = new Date();
	 var today = (d.getMonth()+1) + "/" + d.getDate()+ "/" + d.getFullYear();
	 if(new Date(valueDt) < new Date(today)){
		 $('#valueDateValidationID').show();
		 return false;
	 }
	 $('#valueDateValidationID').hide();
	 return true;
		 
}
function submitFormAtViewLeg(legNumber, productType) {
	var sourcePage = $('input[name=sourcePage]').val();
	var form = document.forms[0];
	var oldPath = form.action;
	var path = oldPath;
	path = path + "?command=viewInputScreens&source=pipelineReview/pipelineReviewDeal&id=" + legNumber + "&pType=" + productType + "&sourcePage=" + sourcePage;
	form.action = path;
	form.submit();
}

function inputsCompleted()
{
	var source = $('input[name=sourcePage]').val();
	var comments = $('#dealCommentsId').val();
	var valueDt = $('#valueDt').val();
	var eventFlag = $('#eventFlag').val();
	var treasuryTaxID = $('#treasuryTaxID').val();
	var cashManagementID = $('#cashManagementID').val();
	var middleOfficeID = $('#middleOfficeID').val();
	var frontOfficeID = $('#frontOfficeID').val();
	
	$('#actionError').hide();
	$('#pipelineReviewDealFBId').find('.radio-container').removeClass('conditional-radio-tri req-error');
	$('#actionButton').removeAttr('style');
	if(eventFlag!=null && eventFlag=='Y'){
		if(validateMOPipeLineReviewDeal(comments,valueDt,middleOfficeID)){
			document.forms[0].action = contextURL + '/pipelineReview/pipelineReviewDeal.do?command=acceptRequest' + "&source=" + source;
			document.forms[0].submit();
		}else{
			$(window).scrollTop(100);
			$('#validateFlag').show();
		}
	}else if(validatePipeLineReviewDeal(comments,valueDt,treasuryTaxID,cashManagementID,middleOfficeID,frontOfficeID)){
		
			document.forms[0].action = contextURL + '/pipelineReview/pipelineReviewDeal.do?command=acceptRequest' + "&source=" + source;
			document.forms[0].submit();
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
		$("#inputsCompletedModalID").modal('hide');
	}
}

function inputsCompleted1()
{
	var source = $('input[name=sourcePage]').val();
	var comments = $('#dealCommentsId').val();
	var valueDt = $('#valueDt').val();
	var eventFlag = $('#eventFlag').val();
	var treasuryTaxID = $('#treasuryTaxID').val();
	var cashManagementID = $('#cashManagementID').val();
	var middleOfficeID = $('#middleOfficeID').val();
	var frontOfficeID = $('#frontOfficeID').val();
	 
	$('#actionError').hide();
	$('#pipelineReviewDealFBId').find('.radio-container').removeClass('conditional-radio-tri req-error');
	$('#actionButton').removeAttr('style');
	if(eventFlag!=null && eventFlag=='Y'){
		if(validateMOPipeLineReviewDeal(comments,valueDt,middleOfficeID)){
			
			document.forms[0].action = contextURL + '/pipelineReview/pipelineReviewDeal.do?command=reviewNextDeal'+ "&source=" + source;
			document.forms[0].submit();
		}else{
			$(window).scrollTop(100);
			$('#validateFlag').show();
		}
	}else if(validatePipeLineReviewDeal(comments,valueDt,treasuryTaxID,cashManagementID,middleOfficeID,frontOfficeID)){
	document.forms[0].action = contextURL + '/pipelineReview/pipelineReviewDeal.do?command=reviewNextDeal'+ "&source=" + source;
	document.forms[0].submit();
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
		$("#inputsCompletedModalID1").modal('hide');
	}
}
