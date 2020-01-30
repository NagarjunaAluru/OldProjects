function closeConfirmModal() {
	$("#confirm").modal('hide');
}
function closeCancelModal() {
	$("#cancelpopup").modal('hide');
}
function saveMiddleOffice(obj){
	
	var validateFlag = false;
	var qAssessment = $('input:radio[name=qAssessment]:checked').val();
	var actionType = $('input:radio[name=saveAction]:checked').val();
	if(qAssessment==undefined){
		validateFlag = true;
		$('#qualitativeDiv').addClass("req-error");
	}else{
		$('#qualitativeDiv').removeClass("req-error");
		if(qAssessment==1 || qAssessment==2){
			var rationale = $('#rationale').val();
			if(rationale==""){
				validateFlag = true;
				$('#rationale').parent().append("<span class='req-error'>error</span>'");
			}
		}else {
			$("span.req-error").remove();
		}
	}
	
	
	
	
	if(actionType==undefined){
		validateFlag = true;
		$('#saveRadioDiv').addClass("req-error");
	}
	
	if(validateFlag==false){
		if(actionType == 'saveNextLeg'){
			$('#saveNextLeg').show();
			$('#saveLeg').hide();
			document.forms[0].action = contextURL + '/middleOffice/middleOfficeInputLeg.do?command=saveNextLeg';
			document.forms[0].submit();
		}else if(actionType == 'saveReturnDeal'){
			$('#saveLeg').show();
			$('#saveNextLeg').hide();
			document.forms[0].action = contextURL + '/middleOffice/middleOfficeInputLeg.do?command=saveLeg';
			document.forms[0].submit();
		}
	}else{
		$(window).scrollTop(100);
		$('#validationFlag').show();
	}
}

function saveBut(obj){
	document.forms[0].action = contextURL + '/middleOffice/middleOfficeInputLeg.do?command=saveLeg&Save=True';
	document.forms[0].submit();
}
function closeMessage(){
	$('#validationFlag').hide();
}
