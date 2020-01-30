$(document).ready(function() {
	$('textarea').keyup(function() {
		var len = this.value.length;
		if (len >= 1000) {
		this.value = this.value.substring(0, 1000);
		}
		});

	$('#saveLeg1').click(function() {
		document.forms[0].action = contextURL + '/transferPricing/equityTransferPricing.do?command=saveLeg&Save=True';
		document.forms[0].submit();
	});	
});

function saveEquityTP(obj){
	var validateFlag = false;
	var actionType = $('input:radio[name=saveAction]:checked').val();
	
	if(actionType==undefined){
		validateFlag = true;
		$('#saveRadioDiv').addClass("req-error");
	}
	
	
	
	if(validateFlag==false){
		if(actionType == 'saveNextLeg'){
			document.forms[0].action = contextURL + '/transferPricing/equityTransferPricing.do?command=saveNextLeg';
			document.forms[0].submit();
		}else if(actionType == 'saveReturnDeal'){
			document.forms[0].action = contextURL + '/transferPricing/equityTransferPricing.do?command=saveLeg';
			document.forms[0].submit();
		}
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}
}