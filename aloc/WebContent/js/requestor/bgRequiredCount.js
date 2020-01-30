$(document).ready(function() {		
	
	transactionParties();
	
	onloadProjectCount();
	$('body').off('change keyup paste click', ':input.requiredProjectDesc').on('change keyup paste click', ':input.requiredProjectDesc', function() {
		  $("#pendingReqProjectDesc").text($(":input[value!=''].requiredProjectDesc").length);
	});
	
	instrumentDet();
	
	onloadInstRiskCount();
	$('body').off('change keyup paste click', ':radio.requiredFieldInstRisk').on('change keyup paste click', ':radio.requiredFieldInstRisk', function() {
		  $("#pendingReqInstRisk").text($(':input:checked.requiredFieldInstRisk').length);
		  
	});
	
	onloadInstReportCount();
	$('body').off('change keyup paste click', ':input.requiredFieldInstRep').on('change keyup paste click', ':input.requiredFieldInstRep', function() {
		  $("#pendingReqInstRep").text($(":input[value!=''].requiredFieldInstRep").length);
	});
	 
	deliveryInstruc();
	
		onloadTriPartyCount();
		$('body').off('change keyup paste click', ':input.tpRequiredField').on('change keyup paste click', ':input.tpRequiredField', function() {
			$("#pendingRequiredTriParty").text($(":input[value!=''].tpRequiredField").length);
		});
	
		onloadTpAppCount();
		$('body').off('change keyup paste click', ':input.tpaRequiredField').on('change keyup paste click', ':input.tpaRequiredField', function() {
			$("#pendingRequiredTpapp").text($(":input[value!=''].tpaRequiredField").length);
		});
	
		onloadTpCustCount();
		$('body').off('change keyup paste click', ':input.tpcRequiredField').on('change keyup paste click', ':input.tpcRequiredField', function() {
			$("#pendingRequiredTpcust").text($(":input[value!=''].tpcRequiredField").length);
		});
	
	sblc();
	
	
});

function onloadProjectCount(){
	$("#totalReqProjectDesc").text($(":input.requiredProjectDesc").length);
	$("#pendingReqProjectDesc").text($(":input[value!=''].requiredProjectDesc").length);
}

function onloadInstRiskCount(){
	$("#totalReqInstRisk").text($(':input:radio.requiredFieldInstRisk').length/2);
	$("#pendingReqInstRisk").text($(':input:checked.requiredFieldInstRisk').length);
}

function onloadInstReportCount(){
	$("#totalReqInstRep").text($(":input.requiredFieldInstRep").length);
	$("#pendingReqInstRep").text($(":input[value!=''].requiredFieldInstRep").length);
}

function onloadTriPartyCount(){
	$("#totalRequiredTriParty").text($(":input.tpRequiredField").length);
	$("#pendingRequiredTriParty").text($(":input[value!=''].tpRequiredField").length);
}

function onloadTpAppCount(){
	$("#totalRequiredTpapp").text($(":input.tpaRequiredField").length);
	$("#pendingRequiredTpapp").text($(":input[value!=''].tpaRequiredField").length);
}

function onloadTpCustCount(){
	$("#totalRequiredTpcust").text($(":input.tpcRequiredField").length);
	$("#pendingRequiredTpcust").text($(":input[value!=''].tpcRequiredField").length);
}

function transactionParties(){
	var selectedSiteId=$('#siteTypeNameId').val();
	if(selectedSiteId !=undefined && selectedSiteId !=""){
	$("#totalRequired").text($(":input.requiredField").length+radioChk(':radio.requiredRadio'));
	$("#pendingRequired").text($(":input[value!=''].requiredField").length
			+$(":input:checked.requiredRadio").length);
	
	$('#transactionParites').off('change keyup paste click', ':input.requiredField,:radio.requiredRadio').on('change keyup paste click', ':input.requiredField,:radio.requiredRadio', function() {
		$("#pendingRequired").text($(":input[value!=''].requiredField").length
		+ $(':input:checked.requiredRadio').length);
	});
	
	}else{
		$("#totalRequired").text($(":input.requiredField").length);
		$("#pendingRequired").text($(":input[value!=''].requiredField").length);
		
		$('#transactionParites').off('change keyup paste click', ':input.requiredField').on('change keyup paste click', ':input.requiredField', function() {
			$("#pendingRequired").text($(":input[value!=''].requiredField").length);
		});
	}
	
}
function finBussiness(){
	$('.countTriparty').addClass("requiredRadio");
	$('.countPrivate').addClass("requiredRadio");
	$('#csoID').addClass("requiredField");
	$('#csoDateId').addClass("requiredField");
	//$('#certifyFlagID').addClass("requiredField");  //This is for checkbox
	transactionParties();
}
function nonFinBussiness(){
	$('.countTriparty').removeClass("requiredRadio");
	$('.countPrivate').removeClass("requiredRadio");
	$('#csoID').removeClass("requiredField");
	$('#csoDateId').removeClass("requiredField");
	$('#triPartyAddressSelectionId').removeClass("requiredField");
	//$('#certifyFlagID').removeClass("requiredField");  //This is for checkbox
	$("#totalRequired").text($(":input.requiredField", document.transactionParites).length);
	$("#pendingRequired").text($(":input[value!=''].requiredField", document.transactionParites).length);
}
function triPartyTrue(){
	$('#triPartyAddressSelectionId').addClass("requiredField");
	$("#totalRequired").text($(":input.requiredField", document.transactionParites).length+radioChk(':radio.requiredRadio'));
	$("#pendingRequired").text($(":input[value!=''].requiredField", document.transactionParites).length
			+$(":input:checked.requiredRadio", document.transactionParites).length);
}
function triPartyFalse(){
	$('#triPartyAddressSelectionId').removeClass("requiredField");
	$("#totalRequired").text($(":input.requiredField", document.transactionParites).length+radioChk(':radio.requiredRadio'));
	$("#pendingRequired").text($(":input[value!=''].requiredField", document.transactionParites).length
			+$(":input:checked.requiredRadio", document.transactionParites).length);
}
function instrumentPurposeCount(){
	$('#instumrntDeatilsOther').removeClass("requiredField");
	transactionParties();
}
function instrumentPurposeOtherCount(){
	$('#instumrntDeatilsOther').addClass("requiredField");
	transactionParties();
}
// instrument details start
function instrumentDet(){
	$("#totalReqInstDet").text($(":input.requiredFieldInstDet").length+radioChk(':radio.requiredRadioInstDet'));
	$("#pendingReqInstDet").text($(":input[value!=''].requiredFieldInstDet").length+$(":input:checked.requiredRadioInstDet").length);
	
	$('body').off('change keyup paste click', ':input.requiredFieldInstDet,:radio.requiredRadioInstDet').on('change keyup paste click', ':input.requiredFieldInstDet,:radio.requiredRadioInstDet', function() {
		  $("#pendingReqInstDet").text($(":input[value!=''].requiredFieldInstDet").length+$(':input:checked.requiredRadioInstDet').length);
	});
}
function autoExtendFlagTrue(){
	$('#initialExpiryDt').addClass("requiredFieldInstDet");
	$('.noticePeriodCls').addClass("requiredRadioInstDet");
	instrumentDet();
}
function autoExtendFlagFalse(){
	$('#initialExpiryDt').removeClass("requiredFieldInstDet");
	$('.noticePeriodCls').removeClass("requiredRadioInstDet");
	
	$('#nonRenewalPeriod').removeClass("requiredFieldInstDet"); //chk
	instrumentDet();
}
function autoExtendFlagTrueOther(){
	$('#nonRenewalPeriod').addClass("requiredFieldInstDet");
	instrumentDet();
}

function autoExtendFlagTrueElse(){
	$('#nonRenewalPeriod').removeClass("requiredFieldInstDet");
	instrumentDet();
}

function autoIncDecTrueCount(){
	$('.countAuto').addClass("requiredRadioInstDet");
	$('#autoIncDt1').addClass("requiredFieldInstDet");
	$('#autoIncAmt1').addClass("requiredFieldInstDet");
	instrumentDet();
}
function autoIncDecFalseCount(){
	$('.countAuto').removeClass("requiredRadioInstDet");
	$('#autoIncDt1').removeClass("requiredFieldInstDet");
	$('#autoIncAmt1').removeClass("requiredFieldInstDet");
	instrumentDet();
}
function maxPossibleHideCount(){
	$('#maxPossibleExpo').removeClass("requiredFieldInstDet");
	instrumentDet();
}
function maxPossibleShowCount(){
	$('#maxPossibleExpo').addClass("requiredFieldInstDet");
	instrumentDet();
}
//instrument details end


function curePeriodFlagTrue(){
	
	$('#noOfDays').addClass("requiredFieldInstRisk");
}
function curePeriodFlagFalse(){
	$('#noOfDays').removeClass("requiredFieldInstRisk");
}

function deliveryInstruc(){
	$("#totalReqDelivery").text($(":input.requiredFieldDelivery").length+radioChk(':radio.requiredRadioDelivery'));
	$("#pendingReqDelivery").text($(':input:checked.requiredRadioDelivery').length+
			$(":input[value!=''].requiredFieldDelivery").length); 
	
	$('body').off('change keyup paste click', ':radio.requiredRadioDelivery,:input.requiredFieldDelivery').on('change keyup paste click', ':radio.requiredRadioDelivery,:input.requiredFieldDelivery', function() {
	  $("#pendingReqDelivery").text($(':input:checked.requiredRadioDelivery').length+
			  $(":input[value!=''].requiredFieldDelivery").length);
	});
}
function deliveryTypeTrueChk()
{
	$('#address1').removeClass("requiredFieldDelivery");
	$('#city').removeClass("requiredFieldDelivery");
	$('#stateProvinceCode_widget').removeClass("requiredFieldDelivery");
	$('#zipPostalcode').removeClass("requiredFieldDelivery");
	$('#countryCode_widget').removeClass("requiredFieldDelivery");
	deliveryInstruc();
}

function deliveryTypeFalseChk()
{
	$('#address1').addClass("requiredFieldDelivery");
	$('#city').addClass("requiredFieldDelivery");
	$('#stateProvinceCode_widget').addClass("requiredFieldDelivery");
	$('#zipPostalcode').addClass("requiredFieldDelivery");
	$('#countryCode_widget').addClass("requiredFieldDelivery");
	deliveryInstruc();
}
//sblc starts
function sblc(){
	$("#totalReqSblc").text(radioChk(':radio.reqRadioSblc'));
	$("#pendingReqSblc").text($(':input:checked.reqRadioSblc').length);
	
	$('body').off('change keyup paste click', ':radio.reqRadioSblc').on('change keyup paste click', ':radio.reqRadioSblc', function() {
		  $("#pendingReqSblc").text($(':input:checked.reqRadioSblc').length);
	});
}
// sblc ends
function radioChk(classname){
	var temp='';
	var count=0;
	 $(classname).each(function(){
		 var name = $(this).attr('name');
		 if(temp!=name){ ++count; }
		 temp=name;
	 });
	 return count;
}
