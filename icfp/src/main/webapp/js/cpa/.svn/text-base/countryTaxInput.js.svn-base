$(document).ready(function() {
	$('#saveLeg1').click(function() {
		document.forms[0].action = contextURL + '/countryTax/countryTaxLeg.do?command=saveLeg&Save=True';
		document.forms[0].submit();
	});
	var lastLegVar = '<%=lastLeg%>';
	   if(lastLegVar=='yes')
		   {
		   $('#reviewNextLegID').hide();
		   }else {
			   $('#reviewNextLegID').show();
		   }

});
function saveCountryTax(){
	
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
			document.forms[0].action = contextURL + '/countryTax/countryTaxLeg.do?command=saveNextLeg';
			document.forms[0].submit();
		}else if(actionType == 'saveReturnDeal'){
			document.forms[0].action = contextURL + '/countryTax/countryTaxLeg.do?command=saveLeg';
			document.forms[0].submit();
		}
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}
}