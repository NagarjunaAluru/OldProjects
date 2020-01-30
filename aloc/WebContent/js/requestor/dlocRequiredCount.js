$(document).ready(function() {
	
	onloadBcpCount();
	onloadIssuingBankCount();
	onloadApplicantCount();
	onloadBenfiCount();
	onloadPaymentSchCount();
	
	$('body').off('change keyup paste click', ':input.requiredBcpField').on('change keyup paste click', ':input.requiredBcpField', function() {
	  $("#pendingRequired").text($(":input[value!=''].requiredBcpField").length);
	});
	
	$('body').off('change keyup paste click', ':input.requiredField1').on('change keyup paste click', ':input.requiredField1', function() {
	  $("#pendingRequired1").text($(":input[value!=''].requiredField1").length + $(":input[value!=''].reqBankLookup").length);
	});
	
	$('body').off('change keyup paste click', ':input.requiredField2').on('change keyup paste click', ':input.requiredField2', function() {
	  $("#pendingRequired2").text($(":input[value!=''].requiredField2").length);
	});
	
	$('body').off('change keyup paste click', ':input.requiredField3').on('change keyup paste click', ':input.requiredField3', function() {
	  $("#pendingRequired3").text($(":input[value!=''].requiredField3").length);
	});
	
	instrumentTrasactionSection();
	
	$('body').off('change keyup paste click', '.requiredField5').on('change keyup paste click', '.requiredField5', function() {
	$("#pendingRequired5").text($(":input[value!=''].requiredField5").length);
	});
		
});

function onloadBcpCount(){
	$("#totalRequired").text($(":input.requiredBcpField").length);
	$("#pendingRequired").text($(":input[value!=''].requiredBcpField").length);
}
function onloadIssuingBankCount(){
	$("#totalRequired1").text($(":input.requiredField1").length + $(":input.bankLookUp").length);
	$("#pendingRequired1").text($(":input[value!=''].requiredField1").length + $(":input[value!=''].reqBankLookup").length);
}
function onloadApplicantCount(){
	$("#totalRequired2").text($(":input.requiredField2").length);
	$("#pendingRequired2").text($(":input[value!=''].requiredField2").length);
	
}
function onloadBenfiCount(){
	$("#totalRequired3").text($(":input.requiredField3").length);
	$("#pendingRequired3").text($(":input[value!=''].requiredField3").length);
	
}
function onloadPaymentSchCount(){
	$("#totalRequired5").text($(":input.requiredField5").length);
	$("#pendingRequired5").text($(":input[value!=''].requiredField5").length);
	
}

function instrumentTrasactionSection()
{
	$("#totalRequired4").text($(":input.requiredField4").length+radioChk(':radio.requiredRadio4'));
	$("#pendingRequired4").text($(":input[value!=''].requiredField4").length
			+$(":input:checked.requiredRadio4").length);

	$('#instTransFrom').off('change keyup paste click', ':input.requiredField4').on('change keyup paste click', ':input.requiredField4', function(e) {
	  $("#pendingRequired4").text($(":input[value!=''].requiredField4").length
			 +$(":input:checked.requiredRadio4").length);
	});	
}
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

function otherInst(){
	$('#othPaymentDesc').addClass("requiredField4");
	instrumentTrasactionSection();
}

function notOtherInst(){
	$('#othPaymentDesc').removeClass("requiredField4");
	instrumentTrasactionSection();
}

function usaOriginGoods(){
	$('.countUsa').addClass("requiredRadio4");
	instrumentTrasactionSection();
}

function notUsaOriginGoods(){
	$('.countUsa').removeClass("requiredRadio4");
	instrumentTrasactionSection();
}