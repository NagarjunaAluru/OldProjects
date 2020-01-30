$(document).ready(function(){
	if($('#derivativeAmount1Id').val()!="" && $('#derivativeAmount1Id').val()!=null){
		var value = commaSeperateAmount($('#derivativeAmount1Id').val());
		$("#derivativeAmount1Id").val( value );
	}
	
	if($('#derivativeAmount2Id').val()!="" && $('#derivativeAmount2Id').val()!=null){
		var value = commaSeperateAmount($('#derivativeAmount2Id').val());
		$("#derivativeAmount2Id").val( value );
	}
	showRateInfo();
	
	var lenderGoldID = $("#lenderLegalEntityGoldId").val();
	
	if(lenderGoldID!=null && lenderGoldID!="")
	{
		 $("#lenderGoldIdDetails").show();
	}
	
	var brGoldID = $("#borrowerLegalEntityGoldId").val();
	
	if(brGoldID!=null && brGoldID!="")
	{
		 $("#borrowerGoldIdDetails").show();
	}
	
	var lenderOrProvider = $('#lenderLegalEntityGoldId').val();
	if(lenderOrProvider!=undefined && lenderOrProvider==""){
		 $('#part1Clear').hide();
	}
	var borrowerOrRecipient =  $('#borrowerLegalEntityGoldId').val();
	if(borrowerOrRecipient!=undefined && borrowerOrRecipient==""){
		 $('#part2Clear').hide();
	}
	if($('.derivative-select').val() == '3'|| $('.derivative-select').val() == '4'|| $('.derivative-select').val() == '5'  ){
		$('.contractClass').show();
	}
		
	if(($("#hedgeDesigationId").val() != '3'&& $("#hedgeDesigationId").val() != '1' && $("#hedgeDesigationId").val() != '2' && $("#hedgeDesigationId").val() != '5')){
		$('.hedgeProgram').hide();
	}
	
	if(($('.hedgeDesignation-select').val() == '3'|| $('.hedgeDesignation-select').val() == '1'|| $('.hedgeDesignation-select').val() == '2' || $('.hedgeDesignation-select').val() == '5') 
			&& ($("#derivativeTypeId").val() == '1' || $("#derivativeTypeId").val() == '2')){
		$('.hedgeProgram').show().highlight();
	}
	else{
		$('.hedgeProgram').hide();
	}
	var meName1 = $('#meName1').val();
	if(meName1 != undefined && meName1 != ""){
		$('#showDivMEDetailsID').show();
	}
	var meName2 = $('#meName2').val();
	if(meName2 != undefined && meName2 != ""){
		$('#showDivMEDetailsID2').show();
	}	
	
});

function clearCounterPart1(){
	 $('#lenderGoldIdDetails').hide();
	 $('#lenderOrProvider').val("");
	 $("#lenderEntitySetupFlag").removeAttr("checked");
	 $('#cPart1LEName').val("");
	 $('#lenderLegalEntityGoldId').val("");
	 $('#LEGoldId').val("");
	 $('#lenderLeTypeId').val("");
	 $('#part1Clear').hide();
}

function clearCounterPart2(){
	 $('#borrowerGoldIdDetails').hide();
	 $('#borrowerOrRecipient').val("");
	 $("#borrowerEntitySetupFlag").removeAttr("checked");
	 $('#borLEName').val("");
	 $('#borrowerLegalEntityGoldId').val("");
	 $('#borLEGoldId').val("");
	 $('#borLeTypeId').val("");
	 $('#part2Clear').hide();
}


function showRateInfo()
{
	 if($('input[id=fixedOrFloatRadio1Id]:checked').val()=="Y"){
		  $("#fixedRateDivID1").show();
		  $("#floatRateDivID1").hide();
		  $("#floatFixedRateId1").val("");
	   }else if($('input[id=fixedOrFloatRadio1Id]:checked').val()=="N"){
	      $("#fixedRateDivID1").hide();
		  $("#floatRateDivID1").show();
		  $("#fixedFixedRateId1").val("");
	  }else{
		  $("#fixedRateDivID1").hide();
		  $("#floatRateDivID1").hide();
		  $("#floatFixedRateId1").val("");
		  $("#fixedFixedRateId1").val("");
	  }
		
	  if($('input[id=fixedOrFloatRadio2Id]:checked').val()=="Y")
	  {
		  $("#fixedRateDivID2").show();
		  $("#floatRateDivID2").hide();
		  $("#floatFixedRateId2").val("");
	   }else  if($('input[id=fixedOrFloatRadio2Id]:checked').val()=="N"){
	      $("#fixedRateDivID2").hide();
		  $("#floatRateDivID2").show();
		  $("#fixedFixedRateId2").val("");
	  }else{
		  $("#fixedRateDivID2").hide();
		  $("#floatRateDivID2").hide();
		  $("#fixedFixedRateId2").val("");
		  $("#floatFixedRateId2").val("");
	  }
}

//only numbers
function onlyNumbers(inputVal){
    var numericReg = /^\d*[0-9](|.\d*[0-9]|,\d*[0-9])?$/;
    if(!numericReg.test(inputVal)) {
		messageSpan.hide();
		errorBarSpan.hide();
		return true;
    } 
	messageSpan.show();
	errorBarSpan.show();
	return false;
}
function checkDecimalRange(inputVal,messageSpan,errorBarSpan,max){
	var characterReg = /^-?(?:\d*|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/;
	var input = inputVal.val();
	if(input == '' || input==null || input==undefined){
		messageSpan.show();
		errorBarSpan.show();
		return false;
	}else {
		if(!characterReg.test(input)) {
			messageSpan.show();
			errorBarSpan.show();
			return false;
	    } 
		if(input >= max){
			messageSpan.show();
			errorBarSpan.show();
			return false;		
		}
	}	
	messageSpan.hide();
	errorBarSpan.hide();
	return true;

}
//should be numeric and not null
function validateAmount(id,messageSpan,errorBarSpan){
	var amount = id.val();
	if(amount == '' || amount==null || amount==undefined){
		messageSpan.show();
		errorBarSpan.show();
		return false;
	}else {
		messageSpan.hide();
		errorBarSpan.hide();
		return true;
	}
}
//validation for Radio buttons
function radioMandatory(id,messageSpan,errorDiv){
	var radioValue =  id.val();
	if(!(radioValue == "Y" || radioValue == "N")){
		messageSpan.show();
		errorDiv.addClass("radio-container req-error");
		return false;
	}else {
		messageSpan.hide();
		errorDiv.removeClass("radio-container req-error");
		return true;
	}
}
//valueRequired
function valueRequired(id,messageSpan,errorBarSpan,borrowerOrRecipient){
	var required = id.val();
	if(required){
	  if(required == borrowerOrRecipient.val()){
		messageSpan.show();
		errorBarSpan.show();
		return false;
	 }else {
		messageSpan.hide();
		errorBarSpan.hide();
		return true;
	}
   }
    return true;	
}
//select a combovalue
function selectCombo(id,errorBarSpan,messageSpan){
	var option = id.val();
	if(option=='0' || option == '' || option==null || option==undefined ){
		errorBarSpan.show();
		return false;
	}else {
		errorBarSpan.hide();
		return true;
	}
}

function validateDerivative(){
	var flag = "true";
	if(!radioMandatory($('input[id=internalOrExternalId]:checked'),$('#internalOrExternalIdErrorSpan'),$('#internalOrExternalIdErrorDiv'))){
		flag = "false";
	}
	if(!selectCombo($("#derivativeTypeId"),$("#derivativeTypeIdErrorSpan"))){
		flag = "false";
	}
	if(!selectCombo($("#currency1Id"),$("#currency1IdErrorSpan"))){
		flag = "false";
	}
	if(!selectCombo($("#currency2Id"),$("#currency2IdErrorSpan"))){
		flag = "false";
	}
	if(!valueRequired($('#lenderLegalEntityGoldId'),$('#secondCounterErrorMess'),$('#borrowerInfofailedBar'),$('#borrowerLegalEntityGoldId'))){
		flag = "false";
	}
	var termInMonths = $("#termInMonths").val();
	
	if(isNumber(termInMonths) || termInMonths == null || termInMonths == "")
		{
		$("#termValidateNumber").hide();
		}
	else{
		$("#termValidateNumber").show();
		flag = "false";
	}
	return flag;
}

function saveDerivative(){
	var flag = validateDerivative();
	var amount1data = $('#derivativeAmount1Id').val();
	if(amount1data==null || amount1data=="" || amount1data==undefined){
		$('#counterParty1AmtID').hide();
	}
	
	var amount2data = $('#derivativeAmount2Id').val();
	if(amount2data==null || amount2data=="" || amount2data==undefined){
		$('#counterParty2AmtID').hide();
	}
	
	var isVisible = false;
	$('.invalid').each(function(){
		if($('.invalid').is(":visible")){
			isVisible = $('.invalid').is(":visible");
		}
	});
	
	if(flag == "true" && !isVisible){
		removeAmount1Shortcuts();
		removeAmount2Shortcuts();
		
		var lenderEntitySetupFlag = $('input[id=lenderEntitySetupFlag]:checked').val();
		if(lenderEntitySetupFlag==null || lenderEntitySetupFlag == "" || lenderEntitySetupFlag == undefined)
		{
			$('input[id=lenderEntitySetupFlag]').attr('checked', true);
			$("#lenderEntitySetupFlag").val("N");
		}
		
		var borrowerEntitySetupFlag = $('input[id=borrowerEntitySetupFlag]:checked').val();
		if(borrowerEntitySetupFlag==null || borrowerEntitySetupFlag == "" || borrowerEntitySetupFlag == undefined)
		{
			$('input[id=borrowerEntitySetupFlag]').attr('checked', true);
			$("#borrowerEntitySetupFlag").val("N");
		}
		
		var fundingRequestForm = document.getElementById('fundingRequestForm');
		var action = fundingRequestForm.action;
		
		action = action+'?command=saveDerivative'; 
		
		fundingRequestForm.action = action;
		fundingRequestForm.submit();
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}

}
function saveAndReturnDerivative(){
	removeAmount1Shortcuts();
	removeAmount2Shortcuts();
	
	var flag = validateDerivative();
	
	var isVisible = false;
	$('.invalid').each(function(){
		if($('.invalid').is(":visible")){
			isVisible = $('.invalid').is(":visible");
		}
	});
	
	if(flag == "true" && !isVisible){
		
		var lenderEntitySetupFlag = $('input[id=lenderEntitySetupFlag]:checked').val();
		if(lenderEntitySetupFlag==null || lenderEntitySetupFlag == "" || lenderEntitySetupFlag == undefined)
		{
			$('input[id=lenderEntitySetupFlag]').attr('checked', true);
			$("#lenderEntitySetupFlag").val("N");
		}
		
		var borrowerEntitySetupFlag = $('input[id=borrowerEntitySetupFlag]:checked').val();
		if(borrowerEntitySetupFlag==null || borrowerEntitySetupFlag == "" || borrowerEntitySetupFlag == undefined)
		{
			$('input[id=borrowerEntitySetupFlag]').attr('checked', true);
			$("#borrowerEntitySetupFlag").val("N");
		}
		
		var fundingRequestForm = document.getElementById('fundingRequestForm');
		var action = fundingRequestForm.action;
		action = action+'?command=saveAndNewDerivative'; 
		fundingRequestForm.action = action;
		fundingRequestForm.submit();
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}

}


function redirectToLeg(cmd){
	removeAmount1Shortcuts();
	removeAmount2Shortcuts();
	
	var fundingRequestForm = document.getElementById('fundingRequestForm');
	var action = fundingRequestForm.action;
	action = action+cmd; 
	fundingRequestForm.action = action;
	fundingRequestForm.submit();
}

function commaAmount1(){
	 var value = commaSeperateAmount($('#derivativeAmount1Id').val());
	 $("#derivativeAmount1Id").val( value );
}

function commaAmount2(){
	 var value =  commaSeperateAmount($('#derivativeAmount2Id').val());
	 $("#derivativeAmount2Id").val( value );
}


function commaSeperateAmount(derivativeAmountId){
	value= derivativeAmountId;
	value = value.replace(/,/g,"").toUpperCase();
	value = $.trim(value);
	
	if( value.match(/K/i) )
		value = value.replace(/K/i,"000");
	else if( value.match(/M/i))
		value = value.replace(/M/i,"000000");
	else if( value.match(/B/i) )
		value = value.replace(/B/i,"000000000");
	
	if( !isNaN(value) && Number(value) > 0 ){
		is_valid = true;
	}
	var arr = value.split('.');
	var res = formatMoney(arr[0], 2, ".", ",");
	if( res != 0){
		var s = res.split('.');			
		value = "" + s[0] + (arr.length > 1 ? '.' + arr[1] : '');			
	}
	return value;
}



function formatMoney(val, c, d, t){
	var i = val, c = isNaN(c = Math.abs(c)) ? 2 : c, d = d == undefined ? "," : d, t = t == undefined ? "." : t,  j = (j = i.length) > 3 ? j % 3 : 0;
   return  (j ? i.substr(0, j) + t : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + t);
};

function removeAmount1Shortcuts(){
	var val = $( "#derivativeAmount1Id" ).val();
	val = val.replace(/,/g,"");
	$( "#derivativeAmount1Id" ).val(val);
}

function removeAmount2Shortcuts(){
	var val = $( "#derivativeAmount2Id" ).val();
	val = val.replace(/,/g,"");
	$( "#derivativeAmount2Id" ).val(val);
}
function isNumber(val) {
	var numericExpression = /^[0-9]+$/;

	if(val.match(numericExpression)) {

	return true;

	} else {

	return false;

	}
}

function getIndexTermDetails(counterPartyDetails)
{
	
   var floatingRate = '';
   if(counterPartyDetails!=null && counterPartyDetails=='counterParty1')
	{
	   floatingRate =  $('#floatFixedRateId1').val();   
	}else if (counterPartyDetails!=null && counterPartyDetails=='counterParty2')
	{
		floatingRate =  $('#floatFixedRateId2').val();  
	}
  
    var fundingRequestForm = document.getElementById('fundingRequestForm');
	var action = fundingRequestForm.action;
	action = action+'?command=getIndexTermData'; 
    
   var url = action ;
   
   if(url!="")
      {
    	  $.post( url, {floatingRateIndex:floatingRate,counterParty:counterPartyDetails},
                    function(data){
    		  if(counterPartyDetails!=null && counterPartyDetails=='counterParty1')
    			{
    			    var content = $(data).find('#indexTermDivID1');
		        	$("#indexTermDivID1").empty().append( content.html() );
    			}else if (counterPartyDetails!=null && counterPartyDetails=='counterParty2')
    			{
    				var content = $(data).find('#indexTermDivID2');
		        	$("#indexTermDivID2").empty().append( content.html() );
    			}
    		        	
            });
    	}
   }

function getCounterPartyDetails(counterPartyDetails)
{
	var goldOrCdrVal = '';
	var goldTextBoxValue = '';
	var counterPartyNbr='';
	if(counterPartyDetails!=null && counterPartyDetails=='counterParty1')
	{
		goldOrCdrVal = $('#lenderSearchId').val();
		goldTextBoxValue = $('#lenderOrProvider').val();
	    counterPartyNbr = '1';
	    $("#lenderOrProvider").addClass("loading");
	    
	}else if (counterPartyDetails!=null && counterPartyDetails=='counterParty2')
	{
		goldOrCdrVal = $('#borrowerSearchId').val();
		goldTextBoxValue = $('#borrowerOrRecipient').val();
		counterPartyNbr = '2';
		$("#borrowerOrRecipient").addClass("loading");
	}else{
		return;
	}
	
	
	var url = contextURL+"/derivativeRequest.do?command=getCountPartyLenderDetails";

	   if(url!="")
	      {
	    	  $.post( url, {goldORCdrDetails:goldOrCdrVal,goldValueData:goldTextBoxValue,counterPartyNumber:counterPartyNbr},
	                    function(data){
	    		  if(counterPartyDetails!=null && counterPartyDetails=='counterParty1')
	    			  {
	    		        	var content = $(data).find('#lenderGoldIdDetails');
	    		        	$("#lenderGoldIdDetails").empty().append( content.html() );
	    		        	$("#lenderGoldIdDetails").show();
	    		        	$("#lenderOrProvider").removeClass("loading");
	    		        	$('#part1Clear').show();
	    			  }else if (counterPartyDetails!=null && counterPartyDetails=='counterParty2')
    				  {
	    				    var content = $(data).find('#borrowerGoldIdDetails');
	    		        	$("#borrowerGoldIdDetails").empty().append( content.html() );
	    		        	$("#borrowerGoldIdDetails").show();
	    		        	$("#borrowerOrRecipient").removeClass("loading");
	    		        	$('#part2Clear').show();
    				  }
	            });
	    	}
}

 function getManagementEntity(counterPartyDetails)
 {
	 
		var meTextBoxValue = '';
		var counterPartyNbr='';
		var leGoldId = '';
		if(counterPartyDetails!=null && counterPartyDetails=='counterParty1')
		{
			meTextBoxValue = $('#selectedLenderMgmtEntity').val();
			leGoldId = $('#LEGoldId').val();
			counterPartyNbr = '1';
		    
		}else if (counterPartyDetails!=null && counterPartyDetails=='counterParty2')
		{
			meTextBoxValue = $('#selectedBorrowerMgmtEntity').val();
			leGoldId = $('#borLEGoldId').val();
			counterPartyNbr = '2';
		}else{
			return;
		}
		
		var fundingRequestForm = document.getElementById('fundingRequestForm');
		var action = fundingRequestForm.action;
		
		var url = action+'?command=getManagementEntityDetails';
		
		if(url!="")
		      {
		    	  $.post( url, {managementEntityData:meTextBoxValue,counterPartyNumber:counterPartyNbr,leGoldIdVal:leGoldId},
		          function(data){
		    		  if(counterPartyDetails!=null && counterPartyDetails=='counterParty1')
		    			  {
		    			        var content = $(data).find('#showDivMEDetailsID');
		    		        	$("#showDivMEDetailsID").empty().append( content.html() );
		    		        	$("#showDivMEDetailsID").show();
		    			  }else if (counterPartyDetails!=null && counterPartyDetails=='counterParty2')
	    				  {
		    				    var content = $(data).find('#showDivMEDetailsID2');
		    		        	$("#showDivMEDetailsID2").empty().append( content.html() );
		    		        	$("#showDivMEDetailsID2").show();
	    				  }
		            });
		    	}
 }
 
   function getFirstIndexTermDetails(productType)
   {
	   var url = '';
	   var floatingRate = $('#floatFixedRateId1').val();
	   if(productType!=null && productType=='RCA')
		   {
		     url = contextURL+"/transferPricing/transferPricingLeg.do?command=getIndexTermData"; 
		   }
	      if(url!=""){
	    	  $.post( url, {floatingRateIndex:floatingRate},
	          function(data){
	                    var content = $(data).find('#indexTermDivID');
	                    $("#indexTermDivID").empty().append( content.html() );
	            });
	      }
     }
 
 function getSecondIndexTermDetails(productType)
 {
	   var url = '';
	   var floatingRate = $('#floatingRateIndexID').val();
	   
	   if(productType!=null && productType=='RCA')
		   {
		     url = contextURL+"/transferPricing/transferPricingLeg.do?command=getIndexTermData"; 
		   }
	  
	      if(url!="")
	      {
	    	  $.post( url, {floatingRateIndex:floatingRate},
	                    function(data){
	    		  
	                    var content = $(data).find('#indexTermDivID');
	                    $("#indexTermDivID").empty().append( content.html() );
	            });
	    	}
     }

