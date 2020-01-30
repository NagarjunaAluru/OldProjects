
$(document).ready(function(){
	
	$('.autosize').keyup(function() {
		var len = this.value.length;
		if (len >= 500) {
		this.value = this.value.substring(0, 500);
		}
	});

	$('.autosize1').keyup(function() {
		var len = this.value.length;
		if (len >= 1000) {
		this.value = this.value.substring(0, 1000);
		}
	});
	
	var drawdownValueDt = $("#drawdownValueDt").val();
	if(drawdownValueDt == ""){
		var valueDt = $("#valueDateID").val();
		if(valueDt!="" ){
			$("#drawdownValueDt").val(valueDt);
		}
	}
	

	
	var legTypeId = $('#legTypeId').val();
	if(legTypeId == "1" || legTypeId == "4" || legTypeId == "5"){
		$('.conditional-lender').text("Lender");
		$('.conditional-borrower').text("Borrower");
	}else if(legTypeId == "2"){
		$('.conditional-lender').text("Provider");
		$('.conditional-borrower').text("Recipient");
	}else if(legTypeId == "6"){
		$('.conditional-lender').text("Purchaser");
		$('.conditional-borrower').text("Issuer");
	}
	var grossAmt = $("#grossSettlementAmt").val();
	if(grossAmt!=undefined && grossAmt!=""){
		$('.grosssSet').text(commaSeperateAmt(grossAmt));
	}else {
		$('.grosssSet').text("-");
	}
	
	$('.payorId').text("-");
	$('.payorSetUpPending').text("-");
	
	var transactionEventTypeId = $('#transactionEventTypeId').val();
	if(transactionEventTypeId!=undefined && transactionEventTypeId!=3){
		showPayorDetails();
	}
	
	lenderOnclick();
	borrowerOnClick();
	newLenderOnclick();
	newBorrowerOnClick();
	payorOnClick();
	
	$('#lenderTreasuryDetails').hide();
	$('#borrowerTreasuryDetails').hide();
	$('#newLenderTreasuryDetails').hide();
	$('#newBorrowerTreasuryDetails').hide();
	$('#payorTreasuryDetails').hide();
	
	
	var newLenderTreasuryCode = $("#newLenderTreasuryCode").val();
	
	if(newLenderTreasuryCode!=undefined && newLenderTreasuryCode!=""){
		$('.newLenderTreasuryCode').text(newLenderTreasuryCode.toUpperCase());
		$('#newLenderTreasuryDetails').show();
		$('#clearNewLenderTreasury').show();
	}
	
	var newBorrowerTreasuryCode = $("#newBorrowerTreasuryCode").val();
	
	if(newBorrowerTreasuryCode!=undefined && newBorrowerTreasuryCode!=""){
		$('.newBorrowerTreasuryCode').text(newBorrowerTreasuryCode.toUpperCase());
		$('#newBorrowerTreasuryDetails').show();
		$('#clearNewBorrowerTreasury').show();
	}
	
	 var actionType = document.forms[0].elements("rateInformation.interestTypeId");
	 if(actionType!=null && actionType!=undefined){
		  if(actionType[0].checked){
			    $('.fixed-container').show();
			    $('.float-container').hide();
		  }else if(actionType[1].checked){
			    $('.fixed-container').hide();
			    $('.float-container').show();
		  }else{
			  $('.fixed-container').hide();
			  $('.float-container').hide();
		  }
	 }
	 
	 if(transactionEventTypeId==undefined){
			showPayorDetails();
		}
	
	$("#lenderEntitySetupFlag").click( function(e){
		lenderOnclick();
	});
	$("#borrowerEntitySetupFlag").click( function(e){
		borrowerOnClick();
	});
	$("#newLenderEntitySetupFlag").click( function(e){
		newLenderOnclick();
	});
	$("#newBorrowerEntitySetupFlag").click( function(e){
		newBorrowerOnClick();
	});
	$("#payorEntitySetupFlag").click( function(e){
		payorOnClick();
	});
	
	
	var facilityType = $('input:radio[id=facilityType]:checked').val(); 
	if(facilityType!=undefined && facilityType == "1"){
		$('.facilityIncreaseDecrease').text("Amendment : Facility Increase Details");
		$('#facilityDecreaseDetails').show();
		$('.incDec').text("Increase");
		$('.incDec').show();
	}else if(facilityType!=undefined && facilityType == "2"){
		$('.facilityIncreaseDecrease').text("Amendment : Facility Decrease Details");
		$('#facilityDecreaseDetails').show();
		$('.incDec').text("Decrease");
		$('.incDec').show();
	}
	
	function facDecrease(){
		$('.facilityIncreaseDecrease').text("Amendment : Facility Decrease Details");
		$('#facilityDecreaseDetails').show();
		$('.incDec').text('Decrease');
		$('.incDec').show();
	}
	
	var derivativesFlag = $('input[id=derivativesFlag]:checked').val();
	if(derivativesFlag!=undefined){
		if(derivativesFlag =="true"){
			$('#derivatives-table').show();
		}else{
			$('#derivatives-table').hide();
		}
	}
	
	var fixedOrFloat = $('input[id=fixedOrFloatRadioId]:checked').val(); 
	if(fixedOrFloat!=undefined){
		if(fixedOrFloat == "1"){
			$('#float-container').hide();
			$('#fixed-container').show();
		}else if(fixedOrFloat == "2"){
			$('#fixed-container').hide();
			$('#float-container').show();
		}
	}else {
		$('#float-container').hide();
		$('#fixed-container').hide();
	}
	
	var isNonStandardLegalAgreement = $('input:radio[id=isNonStandardLegalAgreement]:checked').val(); 
	if(isNonStandardLegalAgreement!=undefined){
		if(isNonStandardLegalAgreement == "true"){
			$('#exceptionDiv').show();
		}else if(isNonStandardLegalAgreement == "false"){
			$('#exceptionDiv').hide();
		}
	}
	
	var newLenderOrBorrower = $('input:radio[id=newLenderOrBorrower]:checked').val();
	if(newLenderOrBorrower!=undefined && newLenderOrBorrower == "true"){
		$("#newLenderDetails").show();
		$("#newBorrowerDetails").hide();
	}else if(newLenderOrBorrower!=undefined && newLenderOrBorrower == "false") {
		$("#newLenderDetails").hide();
		$("#newBorrowerDetails").show();
	}
	
	var lenderGoldId = $("#LEGoldId").val();
	if(lenderGoldId!=undefined && lenderGoldId!=""){
		$('#lenderGoldIdDetails').show();
		$('#lenderCapitalDiv').show();
		$('#lenderOrProvider').val("");
		$('#orgLenderClear').show();
	}
	var borrowerGoldId = $("#borLEGoldId").val();
	if(borrowerGoldId!=undefined && borrowerGoldId!=""){
		$('#borrowerGoldIdDetails').show();
		$('#borrowerCapitalDiv').show();
		$('#borrowerOrRecipient').val("");
		$('#orgBorrowerClear').show();
	}
	var newLenderGoldId = $("#newLEGoldId").val();
	if(newLenderGoldId!=undefined && newLenderGoldId!=""){
		$('#newLenderGoldIdDetails').show();
		$('#newLenderCapitalDiv').show();
		$('#newLenderOrProvider').val("");
		$('#newLenderClear').show();
	}
	var newBorrowerGoldId = $("#newBorLEGoldId").val();
	if(newBorrowerGoldId!=undefined && newBorrowerGoldId!=""){
		$('#newBorrowerGoldIdDetails').show();
		$('#newBorrowerCapitalDiv').show();
		$('#newBorrowerOrRecipient').val("");
		$('#newBorrowerClear').show();
	}
	var payor = $("#payorLEGoldId").val();
	if(payor!=undefined && payor!=""){
		$('#payorGoldIdDetails').show();
		$('#payorCapitalDiv').show();
		$('#payor').val("");
		$('#payorClear').show();
	}
	
	var lenderTreasuryCode = $("#lenderTreasuryCode").val();
	if(lenderTreasuryCode!=undefined && lenderTreasuryCode!=""){
		$('.lenderTreasuryCode').text(lenderTreasuryCode.toUpperCase());
		$('#lenderTreasuryDetails').show();
		$('#orgLenderTreasuryClear').show();
		$('#clearLenderTreasury').show();
	}
	var borrowerTreasuryCode = $("#borrowerTreasuryCode").val();
	if(borrowerTreasuryCode!=undefined && borrowerTreasuryCode!=""){
		$('.borrowerTreasuryCode').text(borrowerTreasuryCode.toUpperCase());
		$('#borrowerTreasuryDetails').show();
		$('#orgBorrowerTreasuryClear').show();
		$('#clearBorrowerTreasury').show();
	}
	var newLenderTreasuryCode = $("#newLenderTreasuryCode").val();
	if(newLenderTreasuryCode!=undefined && newLenderTreasuryCode!=""){
		$('.newLenderTreasuryCode').text(newLenderTreasuryCode.toUpperCase());
		$('#newLenderTreasuryDetails').show();
		$('#clearNewLenderTreasury').show();
	}
	var newBorrowerTreasuryCode = $("#newBorrowerTreasuryCode").val();
	if(newBorrowerTreasuryCode!=undefined && newBorrowerTreasuryCode!=""){
		$('.newBorrowerTreasuryCode').text(newBorrowerTreasuryCode.toUpperCase());
		$('#newBorrowerTreasuryDetails').show();
		$('#clearNewBorrowerTreasury').show();
	}
	var payorTreasuryCode = $("#payorTreasuryCode1").val();
	if(payorTreasuryCode!=undefined && payorTreasuryCode!=""){
		$('.payorTreasuryCode').text(payorTreasuryCode.toUpperCase());
		$('#payorTreasuryDetails').show();
		$('#payorTreasuryClear').show();
		$('#clearPayorTreasury').show();
	}
	
	var originalCCY = $("#originalCCY").val();
	var originalCCYAmount =  $("#originalCCYAmount").val();
	if((originalCCY!=undefined && originalCCY!="") && (originalCCYAmount!=undefined && originalCCYAmount!="")){
		$('#usdEquiDiv').show();
	}
	
	var dayOneCCY = $("#dayOneCCY").val();
	var dayOneCCYAmount =  $("#dayOneCCYAmount").val();
	if((dayOneCCY!=undefined && dayOneCCY!="") && (dayOneCCYAmount!=undefined && dayOneCCYAmount!="")){
		$('#transactionUsdEquiDiv').show();
	}
	
	var currencyAmt =  $("#currencyAmt").val();
	if((originalCCY!=undefined && originalCCY!="") && (currencyAmt!=undefined && currencyAmt!="")){
		$('#usdEquiDiv').show();
	}
	
	var amendedFacilityAmt =  $("#amendedFacilityAmt").val();
	if((originalCCY!=undefined && originalCCY!="") && (amendedFacilityAmt!=undefined && amendedFacilityAmt!="")){
		$('#usdEquiAmendDiv').show();
	}
	
	var facilityIncDecAmt =  $("#facilityIncDecAmt").val();
	if((originalCCY!=undefined && originalCCY!="") && (facilityIncDecAmt!=undefined && facilityIncDecAmt!="")){
		$('#usdEquiFacDiv').show();
	}
	
	function lenderOnclick(){
		if($('input[id=lenderEntitySetupFlag]:checked').val()=="Y"){
			$("#lenderOrProvider").val("");
			$('#lenderGoldIdDetails').hide();
			$("#lenderOrProvider").attr("disabled", "disabled");
			$('#lenderTreasuryDetails').hide();
			$("#lenderTreasuryCode").val("");
			$("#lenderTreasuryCode").attr("disabled", "disabled");
			$('#searchByLenderGoldId').attr("disabled", "disabled");
			$('#searchByLenderTreasury').attr("disabled", "disabled");
			$('#lenderSearchId').attr("disabled", "disabled");
			$('#lenderLegalEntityGoldId').val("");
			$("#regulatedEntityFlag1").removeAttr("disabled");
			$("#regulatedEntityFlag2").removeAttr("disabled");
			$("#princplEntityFlag1").removeAttr("disabled");
			$("#princplEntityFlag2").removeAttr("disabled");
			
			$("#LenderSetUpFlagTDiv").show();
			$("#LenderSetUpFlagFDiv").hide();
			
			$(".condition-lenderReg").show();
			$(".condition-lenderPrn").show();
			var isDrawdown = $("#isDrawdown").val();
			if(isDrawdown!=undefined && isDrawdown=="drawdown"){
				$('.payorId').text("-");
				$('.payorSetUpPending').text("Yes");
			}
			$("#LEGoldId").val("");
		}else{
			$("#lenderOrProvider").removeAttr("disabled");
			$("#lenderTreasuryCode").removeAttr("disabled");
			$("#searchByLenderGoldId").removeAttr("disabled");
			$('#searchByLenderTreasury').removeAttr("disabled");
			$('#lenderSearchId').removeAttr("disabled");
			
			$("#LenderSetUpFlagTDiv").hide();
			$("#LenderSetUpFlagFDiv").show();
			
			$("#regulatedEntityFlag1").attr("disabled", "disabled");
			$("#regulatedEntityFlag2").attr("disabled", "disabled");
			$("#princplEntityFlag1").attr("disabled", "disabled");
			$("#princplEntityFlag2").attr("disabled", "disabled");
			
			$(".condition-lenderReg").hide();
			$(".condition-lenderPrn").hide();
			$("#lenderRegDiv").removeClass("req-error");
			$("#lenderPriDiv").removeClass("req-error");
		}
	}
	
	function newLenderOnclick(){
		if($('input[id=newLenderEntitySetupFlag]:checked').val()=="Y"){
			$("#newLenderOrProvider").val("");
			$('#newLenderGoldIdDetails').hide();
			$("#newLenderLEGoldId").attr("disabled", "disabled");
			$('#newLenderTreasuryDetails').hide();
			$("#newLenderTreasuryCode").val("");
			$("#newLenderTreasuryCode").attr("disabled", "disabled");
			$("#clearNewLenderTCode").hide();
			$('#searchByNewLenderGoldId').attr("disabled", "disabled");
			$('#searchByNewLenderTreasury').attr("disabled", "disabled");
			$('#newLenderSearchId').attr("disabled", "disabled");
			$('#newLenderLegalEntityGoldId').val("");
			$("#newRegulatedEntityFlag1").removeAttr("disabled");
			$("#newRegulatedEntityFlag2").removeAttr("disabled");
			$("#newPrincplEntityFlag1").removeAttr("disabled");
			$("#newPrincplEntityFlag2").removeAttr("disabled");
			
			$("#newLenderSetUpFlagTDiv").show();
			$("#newLenderSetUpFlagFDiv").hide();
			
			$(".condition-newLenderReg").show();
			$(".condition-newLenderPrn").show();
			$("#newLEGoldId").val("");
		}else{
			$("#newLenderLEGoldId").removeAttr("disabled");
			$("#newLenderTreasuryCode").removeAttr("disabled");
			$("#searchByNewLenderGoldId").removeAttr("disabled");
			$('#searchByNewLenderTreasury').removeAttr("disabled");
			$('#newLenderSearchId').removeAttr("disabled");
			
			$("#newLenderSetUpFlagTDiv").hide();
			$("#newLenderSetUpFlagFDiv").show();
			
			$("#newRegulatedEntityFlag1").attr("disabled", "disabled");
			$("#newRegulatedEntityFlag2").attr("disabled", "disabled");
			$("#newPrincplEntityFlag1").attr("disabled", "disabled");
			$("#newPrincplEntityFlag2").attr("disabled", "disabled");
			
			$(".condition-newLenderReg").hide();
			$(".condition-newLenderPrn").hide();
			$("#newLenderRegDiv").removeClass("req-error");
			$("#newLenderPriDiv").removeClass("req-error");
		}
	}
	
	function payorOnClick(){
		if($('input[id=payorEntitySetupFlag]:checked').val()=="Y"){
			$("#payor").val("");
			$('#payorGoldIdDetails').hide();
			$("#payor").attr("disabled", "disabled");
			$('#payorTreasuryDetails').hide();
			$("#payorTreasuryCode").val("");
			$("#payorTreasuryCode").attr("disabled", "disabled");
			$('#payorGoldId').attr("disabled", "disabled");
			$('#searchByPayorTreasury').attr("disabled", "disabled");
			$('#payorSearchId').attr("disabled", "disabled");
			$('#payorLegalEntityGoldId').val("");
			$("#payorRegulatedEntityFlag1").removeAttr("disabled");
			$("#payorRegulatedEntityFlag2").removeAttr("disabled");
			$("#payorPrincplEntityFlag1").removeAttr("disabled");
			$("#payorPrincplEntityFlag2").removeAttr("disabled");
			
			$("#payorSetUpFlagTDiv").show();
			$("#payorSetUpFlagFDiv").hide();
			
			$(".condition-payorReg").show();
			$(".condition-payorPrn").show();
			$("#payorLEGoldId").val("");
		}else{
			$("#payor").removeAttr("disabled");
			$("#payorTreasuryCode").removeAttr("disabled");
			$("#payorGoldId").removeAttr("disabled");
			$('#searchByPayorTreasury').removeAttr("disabled");
			$('#payorSearchId').removeAttr("disabled");
			
			$("#payorSetUpFlagTDiv").hide();
			$("#payorSetUpFlagFDiv").show();
			
			$("#payorRegulatedEntityFlag1").attr("disabled", "disabled");
			$("#payorRegulatedEntityFlag2").attr("disabled", "disabled");
			$("#payorPrincplEntityFlag1").attr("disabled", "disabled");
			$("#payorPrincplEntityFlag2").attr("disabled", "disabled");
			
			$(".condition-payorReg").hide();
			$(".condition-payorPrn").hide();
			$("#payorRegDiv").removeClass("req-error");
			$("#payorPriDiv").removeClass("req-error");
		}
	}
	
	
	$("#searchByLenderTreasury").click( function(e){
		e.preventDefault();
		
		var lenderTreasuryCode = $("#lenderTreasuryCode").val();
		if(lenderTreasuryCode == ""){
			$("#lenderTreasuryfailed").show();
			$("#lenderTreasuryfailedBar").show();
			$('#lenderTreasuryDetails').hide();
			$("#lenderTreasuryInvalid").hide();
			return false;
		}else {
			$("#lenderTreasuryfailed").hide();
			$("#lenderTreasuryfailedBar").hide();
			$('.lenderTreasuryCode').text(lenderTreasuryCode.toUpperCase());
			$('#lenderTreasuryDetails').show();
			$('#clearLenderTreasury').show();
		}
	});
	
	$("#searchByBorrowerTreasury").click( function(e){
		e.preventDefault();
		
		var borrowerTreasuryCode = $("#borrowerTreasuryCode").val();
		if(borrowerTreasuryCode == ""){
			$("#borrowerTreasuryfailed").show();
			$("#borrowerTreasuryfailedBar").show();
			$('#borrowerTreasuryDetails').hide();
			$("#borrowerTreasuryInvalid").hide();
			return false;
		}else {
			$("#borrowerTreasuryfailed").hide();
			$("#borrowerTreasuryfailedBar").hide();
			$('.borrowerTreasuryCode').text(borrowerTreasuryCode.toUpperCase());
			$('#borrowerTreasuryDetails').show();
			$('#clearBorrowerTreasury').show();
		}
	});
	
	$("#searchByNewLenderTreasury").click( function(e){
		e.preventDefault();
		
		var newLenderTreasuryCode = $("#newLenderTreasuryCode").val();
		if(newLenderTreasuryCode == ""){
			$("#newLenderTreasuryfailed").show();
			$("#newLenderTreasuryfailedBar").show();
			$('#newLenderTreasuryDetails').hide();
			$("#newLenderTreasuryInvalid").hide();
			return false;
		}else {
			$("#newLenderTreasuryfailed").hide();
			$("#newLenderTreasuryfailedBar").hide();
			$('.newLenderTreasuryCode').text(newLenderTreasuryCode.toUpperCase());
			$('#newLenderTreasuryDetails').show();
			$('#clearNewLenderTreasury').show();
		
		}
	});
	
	$("#searchByNewBorrowerTreasury").click( function(e){
		e.preventDefault();
		
		var newBorrowerTreasuryCode = $("#newBorrowerTreasuryCode").val();
		if(newBorrowerTreasuryCode == ""){
			$("#newBorrowerTreasuryfailed").show();
			$("#newBorrowerTreasuryfailedBar").show();
			$('#newBorrowerTreasuryDetails').hide();
			$("#newBorrowerTreasuryInvalid").hide();
			return false;
		}else {
			$("#newBorrowerTreasuryfailed").hide();
			$("#newBorrowerTreasuryfailedBar").hide();
			$('.newBorrowerTreasuryCode').text(newBorrowerTreasuryCode.toUpperCase());
			$('#newBorrowerTreasuryDetails').show();
			$('#clearNewBorrowerTreasury').show();
		}
	});
	
	$("#searchByPayorTreasury").click( function(e){
		e.preventDefault();
		
		var payorTreasuryCode = $("#payorTreasuryCode").val();
		if(payorTreasuryCode == ""){
			$("#payorTreasuryfailed").show();
			$("#payorTreasuryfailedBar").show();
			$('#payorTreasuryDetails').hide();
			$("#payorTreasuryInvalid").hide();
			return false;
		}else {
			$("#payorTreasuryfailed").hide();
			$("#payorTreasuryfailedBar").hide();
			$('.payorTreasuryCode').text(payorTreasuryCode.toUpperCase());
			$('#payorTreasuryDetails').show();
			$('#clearPayorTreasury').show();
		}
	});
	
		
	function borrowerOnClick(){
		if($('input[id=borrowerEntitySetupFlag]:checked').val()=="Y"){
			$("#borrowerOrRecipient").val("");
			$('#borrowerGoldIdDetails').hide();
			$("#borrowerOrRecipient").attr("disabled", "disabled");
			
			$("#borrowerTreasuryCode").val("");
			$("#borrowerTreasuryCode").attr("disabled", "disabled");
			$('#searchByBorrowerGoldId').attr("disabled", "disabled");
			$('#searchByBorrowerTreasury').attr("disabled", "disabled");
			$('#borrowerSearchId').attr("disabled", "disabled");
			$('#borrowerLegalEntityGoldId').val("");
			$("#borRegulatedEntityFlag1").removeAttr("disabled");
			$("#borRegulatedEntityFlag2").removeAttr("disabled");
			$("#borPrincplEntityFlag1").removeAttr("disabled");
			$("#borPrincplEntityFlag2").removeAttr("disabled");
			
			$("#BorrowerSetUpFlagTDiv").show();
			$("#BorrowerSetUpFlagFDiv").hide();
			
			$(".condition-borrowerReg").show();
			$(".condition-borrowerPrn").show();

			$("#borrowerTreasuryDetails").hide();
			$("#clearBorrowerTCode").hide();
			
			var isDrawdown = $("#isDrawdown").val();
			if(isDrawdown==undefined){
				$('.payorId').text("-");
				$('.payorSetUpPending').text("Yes");
			}
			$("#borLEGoldId").val("");
		}else{
			$("#borrowerOrRecipient").removeAttr("disabled");
			$("#borrowerTreasuryCode").removeAttr("disabled");
			$("#searchByBorrowerGoldId").removeAttr("disabled");
			$('#searchByBorrowerTreasury').removeAttr("disabled");
			$('#borrowerSearchId').removeAttr("disabled");
			
			$("#BorrowerSetUpFlagTDiv").hide();
			$("#BorrowerSetUpFlagFDiv").show();

			$("#borRegulatedEntityFlag1").attr("disabled", "disabled");
			$("#borRegulatedEntityFlag2").attr("disabled", "disabled");
			$("#borPrincplEntityFlag1").attr("disabled", "disabled");
			$("#borPrincplEntityFlag2").attr("disabled", "disabled");
			
			$(".condition-borrowerReg").hide();
			$(".condition-borrowerPrn").hide();
			$("#borrowerRegDiv").removeClass("req-error");
			$("#borrowerPriDiv").removeClass("req-error");
		}
	}
	
	function newBorrowerOnClick(){
		if($('input[id=newBorrowerEntitySetupFlag]:checked').val()=="Y"){
			$("#newBorrowerOrRecipient").val("");
			$('#newBorrowerGoldIdDetails').hide();
			$("#newBorrowerLEGoldId").attr("disabled", "disabled");
			$('#newBorrowerTreasuryDetails').hide();
			$("#newBorrowerTreasuryCode").val("");
			$("#clearNewBorrowerTCode").hide();
			$("#newBorrowerTreasuryCode").attr("disabled", "disabled");
			$('#searchByNewBorrowerGoldId').attr("disabled", "disabled");
			$('#searchByNewBorrowerTreasury').attr("disabled", "disabled");
			$('#newBorrowerSearchId').attr("disabled", "disabled");
			$('#newBorrowerLegalEntityGoldId').val("");
			$("#newBorRegulatedEntityFlag1").removeAttr("disabled");
			$("#newBorRegulatedEntityFlag2").removeAttr("disabled");
			$("#newBorPrincplEntityFlag1").removeAttr("disabled");
			$("#newBorPrincplEntityFlag2").removeAttr("disabled");
			
			$("#newBorrowerSetUpFlagTDiv").show();
			$("#newBorrowerSetUpFlagFDiv").hide();
			
			$(".condition-newBorrowerReg").show();
			$(".condition-newBorrowerPrn").show();
			$("#newBorLEGoldId").val("");
		}else{
			$("#newBorrowerLEGoldId").removeAttr("disabled");
			$("#newBorrowerTreasuryCode").removeAttr("disabled");
			$("#searchByNewBorrowerGoldId").removeAttr("disabled");
			$('#searchByNewBorrowerTreasury').removeAttr("disabled");
			$('#newBorrowerSearchId').removeAttr("disabled");
			
			$("#newBorrowerSetUpFlagTDiv").hide();
			$("#newBorrowerSetUpFlagFDiv").show();


			$("#newBorRegulatedEntityFlag1").attr("disabled", "disabled");
			$("#newBorRegulatedEntityFlag2").attr("disabled", "disabled");
			$("#newBorPrincplEntityFlag1").attr("disabled", "disabled");
			$("#newBorPrincplEntityFlag2").attr("disabled", "disabled");
			
			$(".condition-newBorrowerReg").hide();
			$(".condition-newBorrowerPrn").hide();
			$("#newBorrowerRegDiv").removeClass("req-error");
			$("#newBorrowerPriDiv").removeClass("req-error");
		}
	}
	
	$("#lenderOrProvider").change( function(e){
		var isDrawdown = $("#isDrawdown").val();
		if(isDrawdown!=undefined && isDrawdown=="drawdown"){
			showPayorDetails();
		}
	});
	
	$("#borrowerOrRecipient").change( function(e){
		var isDrawdown = $("#isDrawdown").val();
		if(isDrawdown==undefined){
			showPayorDetails();
		}
	});

	$("#accruedInterestAmt").change( function(e){
		var accruedInterestAmt = $("#accruedInterestAmt").val();
		if(isNumber(accruedInterestAmt) && !(parseFloat(accruedInterestAmt) < 0)) {
			 var value = commaSeperateAmt(accruedInterestAmt);
			 $("#accruedInterestAmt").val( value );
			 $("#accruedInterestBar").hide();
			GrossSettleAmountCalculate();
		}
		
	});
	
	$("#fees").change( function(e){
		var fees = $("#fees").val();
		if(isNumber(fees) && !(parseFloat(fees) < 0)) {
			 var value = commaSeperateAmt(fees);
			 $("#fees").val( value );
			$("#feesBar").hide();
			GrossSettleAmountCalculate();
		}
	});
	$("#pandLAmt").change( function(e){
		var pandLAmt = $("#pandLAmt").val();
		
		if(pandLAmt!=""){
			var isvalid = /^-?(\d{1,14})(\.\d{1,2})?$/.test(pandLAmt);
			if(isvalid) {
				$("#pandLAmtBar").hide();
				GrossSettleAmountCalculate();
			}else{
				$("#pandLAmtBar").show();
			}
		}
	});
	
	$("#brokerageCostAmt").change( function(e){
		var brokerageCostAmt = $("#brokerageCostAmt").val();
		if(isNumber(brokerageCostAmt) && !(parseFloat(brokerageCostAmt) < 0)) {
			$("#brokerageCostAmtBar").hide();
			GrossSettleAmountCalculate();
		}else{
			$("#brokerageCostAmtBar").show();
		}
	});
	
	$("#currencyAmt").focusout( function(e){
		calcAmendedAmt();
		$("#amendedFacilityAmt").focusout();
	});
	
	$("#facilityIncDecAmt").focusout( function(e){
		calcAmendedAmt();
		$("#amendedFacilityAmt").focusout();
	});
	
	$("#originalCCYAmount").change( function(e){
		
		var originalCCYAmount = $( "#originalCCYAmount" ).val();
		if(originalCCYAmount!=undefined){
			originalCCYAmount = originalCCYAmount.replace(/,/g,"");
			
			if(isNumber(originalCCYAmount) && !(parseFloat(originalCCYAmount) < 0)) {
				$("#originalCCYAmountValidateBar").hide();
				GrossSettleAmountCalculate();
			}else{
				$("#originalCCYAmountValidateBar").show();
			}
		}
	});
	
	$("#amendedFacilityAmt").focusout( function(e){
		var originalCCY = $("#originalCCY").val();
		var originalCCYAmount =  $("#amendedFacilityAmt").val();
		
		var val = originalCCYAmount;
		val = val.replace(/,/g,"");
		originalCCYAmount = val;
		
		if(originalCCYAmount == ""){
			$("#originalCCYValidateBar").hide();
		}else if(!(isNumber(originalCCYAmount)) || parseFloat(originalCCYAmount) <= 0) {
			$("#amendedFacilityAmtBar").show();
			$("#originalCCYValidateBar").hide();
		 }else{
			 value = commaSeperateAmt(originalCCYAmount);
			$("#amendedFacilityAmt").val( value );
			
			$("#originalCCYValidateBar").hide();
			$("#amendedFacilityAmtBar").hide();
			var actionId = $('#actionId').val();
				
				url = contextURL +"/RCALegRequest.do?command=getUSDEquiDetails";
				
				$.post( url, {originalCCYAmount: originalCCYAmount,originalCCY:originalCCY,amendedFacilityAmt:"amendedUsd",actionId:actionId},
						function(data){
					var content = $(data).find('#usdEquiAmendDiv');
					$("#usdEquiAmendDiv").empty().append( content.html() );
					$('#usdEquiAmendDiv').show();
				});
			}
	});
	
	$("#baseFixedRateID").change( function(e){
		var baseFixedRateID = $("#baseFixedRateID").val();
		if(isNumber(baseFixedRateID) && !(parseFloat(baseFixedRateID) < 0)) {
			$("#baseFixedRatefailedBar").hide();
		}else{
			$("#baseFixedRatefailedBar").show();
		}
	});
});

function calcAmendedAmt(){
	var amount=0;
	var curAmt=0;
	
	var currencyAmt =  $("#currencyAmt").val();
	if(currencyAmt!="" && currencyAmt!=undefined){
		var val = currencyAmt;
		val = val.replace(/,/g,"");
		currencyAmt = val;
		curAmt = parseFloat(currencyAmt);
	}
	
	var facilityIncDecAmt =  $("#facilityIncDecAmt").val();
	var facAmt = 0;
	
	if(facilityIncDecAmt!="" && facilityIncDecAmt!=undefined){
		var val = facilityIncDecAmt;
		val = val.replace(/,/g,"");
		facilityIncDecAmt = val;
		facAmt = parseFloat(facilityIncDecAmt);
	}
	
	if(!(currencyAmt=="" && facilityIncDecAmt=="")){
		var facilityType = $('input[id=facilityType]:checked').val();
		$('#currencyFacilityAmteBar').hide();
		if(facilityType!=undefined){
			if(facilityType == '1'){
				amount = curAmt+facAmt;
				val = commaSeperateAmt(amount+"");
				$("#amendedFacilityAmt").val(val);
				$("#AmendedDiv").show();
				$('#currencyFacilityAmteBar').hide();
			}
			
			if(currencyAmt!="" && facilityIncDecAmt!=""){
				if(facilityType == '2'){
					amount = curAmt-facAmt;
					if(amount>=0){
						$('#currencyFacilityAmteBar').hide();
						val = commaSeperateAmt(amount+"");
						$("#amendedFacilityAmt").val(val);
						$("#AmendedDiv").show();
					}else {
						$('#currencyFacilityAmteBar').show();
						$("#amendedFacilityAmt").val("");
						$("#AmendedDiv").show();
						$("#amendedUSDEquivalentAmt").val("");
						$("#usdEquiAmendDiv").hide();
					}
				}
			}else if(currencyAmt=="" && facilityIncDecAmt==""){
				$("#amendedFacilityAmt").val("");
				$("#amendedUSDEquivalentAmt").val("");
				$("#usdEquiAmendDiv").hide();
				$("#AmendedDiv").show();
				$('#currencyFacilityAmteBar').hide();
			}
		}
	}
}

function showPayorDetails(){
	var isDrawdown = $("#isDrawdown").val();
	var borrowerOrRecipient = "";
	if(isDrawdown!=undefined && isDrawdown=="drawdown"){
		borrowerOrRecipient = $("#lenderOrProvider").val();
	}else{
		borrowerOrRecipient = $("#borrowerOrRecipient").val();
	}
	
	$("#payorGoldId").val(borrowerOrRecipient);
	$('.payorId').text(borrowerOrRecipient);
	$('.payorId').show();
	$("#payorEntitySetupFlag").val($('input[id=borrowerEntitySetupFlag]:checked').val());
	if($('input[id=borrowerEntitySetupFlag]:checked').val()=="Y"){
		$('.payorSetUpPending').text("Yes");
	}else{
		$('.payorSetUpPending').text("No");
		if(borrowerOrRecipient=="" && isDrawdown!="drawdown"){
			var borrowerLegalEntityGoldId = $("#borrowerLegalEntityGoldId").val();
			$("#payorGoldId").val(borrowerLegalEntityGoldId);
			$('.payorId').text(borrowerLegalEntityGoldId);
			$('.payorId').show();
		}else if(borrowerOrRecipient=="" && isDrawdown=="drawdown"){
			var lenderOrProviderGoldId = $("#lenderLegalEntityGoldId").val();
			$("#payorGoldId").val(lenderOrProviderGoldId);
			$('.payorId').text(lenderOrProviderGoldId);
			$('.payorId').show();
		}
	}
	$('.payorSetUpPending').show();
}

function GrossSettleAmountCalculate(){
	var originalCCYAmount = $( "#originalCCYAmount" ).val();
	var amount=0;
	if(originalCCYAmount!="" && originalCCYAmount!=undefined){
		originalCCYAmount = originalCCYAmount.replace(/,/g,"");
		amount = parseFloat(originalCCYAmount);
	}
	
	var accruedInterestAmt = $("#accruedInterestAmt").val();
	var intAmount=0;
	if(accruedInterestAmt!="" && accruedInterestAmt!=undefined){
		accruedInterestAmt = accruedInterestAmt.replace(/,/g,"");
		intAmount = parseFloat(accruedInterestAmt);
	}
	var fees = $("#fees").val();
	var feesAmount=0;
	if(fees!="" && fees!=undefined){
		fees = fees.replace(/,/g,"");
		feesAmount = parseFloat(fees);
	}
	var pandLAmt = $("#pandLAmt").val();
	var pandLAmount=0;
	if(pandLAmt!="" && pandLAmt!=undefined){
		pandLAmount = parseFloat(pandLAmt);
	}
	
	var brokerageCostAmtStr = $("#brokerageCostAmt").val();
	var brokerageCostAmt=0;
	if(brokerageCostAmtStr!="" && brokerageCostAmtStr!=undefined){
		brokerageCostAmt = parseFloat(brokerageCostAmtStr);
	}
	
	var tot = amount+intAmount+feesAmount+pandLAmount+brokerageCostAmt;
	$("#grossSettlementAmt").val(tot);
	$('.grosssSet').text(commaSeperateAmt(tot+""));
	
}

function lenderD(){
	$("#newLenderDetails").show();
	$("#newBorrowerDetails").hide();
}

function borrowerD(){
	$("#newLenderDetails").hide();
	$("#newBorrowerDetails").show();
}

/**
 * Clear the fieds for the Lender or Issuer or Provider for the Gold Id
 */
function clearLenderDetails(){
	$('#lenderOrProvider').val("");
	$("#lenderOrProviderSetupPending").removeAttr("checked");
	$("#lenderInfofailed").val("");
	$("#lenderInfofailed").hide();
	$("#lenderInfofailedBar").hide();
	$("#lenderInfoInvalid").hide();
	
	$("#LenderSetUpFlagTDiv").show();
	$("#LenderSetUpFlagFDiv").hide();
	$("#lenBusSegTDiv").show();
	$("#lenBusSegFDiv").hide();
	
	$("#regulatedEntityFlag1").removeAttr("checked");
	$("#regulatedEntityFlag2").removeAttr("checked");
	$("#princplEntityFlag1").removeAttr("checked");
	$("#princplEntityFlag2").removeAttr("checked");
	$("#regulatedEntityFlag1").attr("disabled", "disabled");
	$("#regulatedEntityFlag2").attr("disabled", "disabled");
	$("#princplEntityFlag1").attr("disabled", "disabled");
	$("#princplEntityFlag2").attr("disabled", "disabled");
}

/**
 * Clear the fields for Purchaser or Borrower Or Recipient for the Gold Id
 */
function clearBorrowerDetails(){
	$('#borrowerOrRecipient').val("");
	$("#borrowerOrRecipientSetupPending").removeAttr("checked");
	$("#borrowerInfofailed").val("");
	$("#borrowerInfofailed").hide();
	$("#borrowerInfofailedBar").hide();
	$("#borrowerInfoInvalid").hide();
	
	$("#BorrowerSetUpFlagTDiv").show();
	$("#BorrowerSetUpFlagFDiv").hide();
	$("#borBusSegTDiv").show();
	$("#borBusSegFDiv").hide();
	
	$("#borRegulatedEntityFlag1").attr("checked", false);
	$("#borRegulatedEntityFlag2").attr("checked", false);
	$("#borPrincplEntityFlag1").attr("checked", false);
	$("#borPrincplEntityFlag2").attr("checked", false);
	
	$("#borRegulatedEntityFlag1").removeAttr("checked");
	$("#borRegulatedEntityFlag2").removeAttr("checked");
	$("#borPrincplEntityFlag1").removeAttr("checked");
	$("#borPrincplEntityFlag2").removeAttr("checked");
	$("#borRegulatedEntityFlag1").attr("disabled", "disabled");
	$("#borRegulatedEntityFlag2").attr("disabled", "disabled");
	$("#borPrincplEntityFlag1").attr("disabled", "disabled");
	$("#borPrincplEntityFlag2").attr("disabled", "disabled");
}

/**
 * Clear the fieds for the Lender or Issuer or Provider for the Gold Id
 */
function clearNewLenderDetails(){
	$('#newLenderOrProvider').val("");
	$("#newLenderOrProviderSetupPending").removeAttr("checked");
	$("#newLenderInfofailed").val("");
	$("#newLenderInfofailed").hide();
	$("#newLenderInfofailedBar").hide();
	$("#newLenderInfoInvalid").hide();
	
	$("#newLenderSetUpFlagTDiv").show();
	$("#newLenderSetUpFlagFDiv").hide();
	$("#newLenBusSegTDiv").show();
	$("#newLenBusSegFDiv").hide();
	
	$("#newRegulatedEntityFlag1").attr("checked", false);
	$("#newRegulatedEntityFlag2").attr("checked", false);
	$("#newPrincplEntityFlag1").attr("checked", false);
	$("#newPrincplEntityFlag2").attr("checked", false);
}

/**
 * Clear the fields for Purchaser or Borrower Or Recipient for the Gold Id
 */
function clearNewBorrowerDetails(){
	$('#newBorrowerOrRecipient').val("");
	$("#newBorrowerOrRecipientSetupPending").removeAttr("checked");
	$("#newBorrowerInfofailed").val("");
	$("#newBorrowerInfofailed").hide();
	$("#newBorrowerInfofailedBar").hide();
	$("#newBorrowerInfoInvalid").hide();
	
	$("#newBorrowerSetUpFlagTDiv").show();
	$("#newBorrowerSetUpFlagFDiv").hide();
	$("#newBorBusSegTDiv").show();
	$("#newBorBusSegFDiv").hide();
	
	$("#newBorRegulatedEntityFlag1").attr("checked", false);
	$("#newBorRegulatedEntityFlag2").attr("checked", false);
	$("#newBorPrincplEntityFlag1").attr("checked", false);
	$("#newBorPrincplEntityFlag2").attr("checked", false);
}

/**
 * Clear the fields for the Payor
 */
function clearPayorDetails(){
	$('#payor').val("");
	$("#payorSetupPending").removeAttr("checked");
	$("#payorInfofailed").val("");
	$("#payorInfofailed").hide();
	$("#payorInfofailedBar").hide();
	$("#payorInfoInvalid").hide();
	
	$("#payorSetUpFlagTDiv").show();
	$("#payorSetUpFlagFDiv").hide();
	$("#payorBusSegTDiv").show();
	$("#payorBusSegFDiv").hide();
	
	$("#payorRegulatedEntityFlag1").attr("checked", false);
	$("#payorRegulatedEntityFlag2").attr("checked", false);
	$("#payorPrincplEntityFlag1").attr("checked", false);
	$("#payorPrincplEntityFlag2").attr("checked", false);
}


/**
 * Clear the fields for the Lender or Issuer or Provider for the TreasuryDetails
 */
function clearTreasuryDetails(){
	$('#lenderTreasuryDetails').hide();
	$("#lenderTreasuryfailed").hide();
	$("#lenderTreasuryfailedBar").hide();
	$("#lenderTreasuryInvalid").hide();
}

/**
 * lear the fields for Purchaser or Borrower Or Recipient for the BorrowerDetails
 */
function clearBorrowerTreasuryDetails(){
	$('#borrowerTreasuryDetails').hide();
	$("#borrowerTreasuryfailed").hide();
	$("#borrowerTreasuryfailedBar").hide();
	$("#borrowerTreasuryInvalid").hide();
}


/**
 * Clear the fields for the Lender or Issuer or Provider for the TreasuryDetails
 */
function clearNewTreasuryDetails(){
	$('#newLenderTreasuryDetails').hide();
	$("#newLenderTreasuryfailed").hide();
	$("#newLenderTreasuryfailedBar").hide();
	$("#newLenderTreasuryInvalid").hide();
}


/**
 * Clear the fields for Purchaser or Borrower Or Recipient for the BorrowerDetails
 */
function clearNewBorrowerTreasuryDetails(){
	$('#newBorrowerTreasuryDetails').hide();
	$("#newBorrowerTreasuryfailed").hide();
	$("#newBorrowerTreasuryfailedBar").hide();
	$("#newBorrowerTreasuryInvalid").hide();
}

/**
 * Clear the fields for Payor
 */
function clearPayorTreasuryDetails(){
	$('#payorTreasuryDetails').hide();
	$("#payorTreasuryfailed").hide();
	$("#payorTreasuryfailedBar").hide();
	$("#payorTreasuryInvalid").hide();
}

/**
 * Method to add the comma seperate for the mount & the USD Equivalent
 * @param originalCCYAmount
 */
function commaSeperate(originalCCYAmount){
	value= originalCCYAmount;
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
	$("#originalCCYAmount").val( value );
}

/**
 * This method with commonly to all amounts
 * @param amount
 */
function commaSeperateAmount(amount){
	value= amount;
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
/**
 * Method to format the money
 * @param val
 * @param c
 * @param d
 * @param t
 * @returns
 */
function formatMoney(val, c, d, t){
	var i = val, c = isNaN(c = Math.abs(c)) ? 2 : c, d = d == undefined ? "," : d, t = t == undefined ? "." : t,  j = (j = i.length) > 3 ? j % 3 : 0;
   return  (j ? i.substr(0, j) + t : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + t);
};


/**
 * Method to add the derivatives
 * @param cmd
 */
function addDerivatives(cmd){
	
	setGoldIdValues();
	removeAmountcommas();
	var RCALegRequestForm = document.getElementById('ICFPLegRequestForm');
	var action = RCALegRequestForm.action;
	action = action+cmd; 
	RCALegRequestForm.action = action;
	RCALegRequestForm.submit();
}

/**
 * Method to remove the Exceptions
 * @param id
 */
function removeException(id){
	var fundingRequestForm = document.getElementById('ICFPLegRequestForm');
	var legNumber = fundingRequestForm.legNumber;
	var exceptionNumber = document.getElementById('exceptionIndex').value;
	fundingRequestForm.action =  contextURL+"/RCALegRequest.do?command=deleteException&legNumber=" + legNumber + "&exceptionNumber=" + exceptionNumber;
	fundingRequestForm.submit();
	
}


/**
 * Method to delete the derivatives
 * @param id
 */
function deleteDerivative(id){
	$('#dealDeriv'+id+'').remove();
	
	var derivativeNumber = id;
	document.getElementById('derivativeNumber').value = derivativeNumber;
    $("#derDeleteConfirm").modal('hide');
    var actionId = $('#actionId').val();
	var fundingRequestForm = document.getElementById('ICFPLegRequestForm');
	fundingRequestForm.action =  contextURL+"/derivativeRequest.do?command=deleteDerivative&derivativeNumber="+derivativeNumber+"&actionId="+actionId;
	fundingRequestForm.submit();
}

/**
 * Method to modify the derivatives
 * @param id
 */
function modifyDerivative(id){
	
	setGoldIdValues();
	removeAmountcommas();
	var derivativeNumber = $(id).parent().next().html();
	document.getElementById('derivativeNumber').value = derivativeNumber;
	var fundingRequestForm = document.getElementById('ICFPLegRequestForm');
	var actionId = $('#actionId').val();
	fundingRequestForm.action =  contextURL+"/derivativeRequest.do?command=openDerivative&modifyDerivative=true&derivativeNumber="+derivativeNumber+"&actionId="+actionId;
    fundingRequestForm.submit();
	
}


/**
 * Method to add the Exception Row
 */
function addExceptionRow() {
	
	if($(this).prev('table').hasClass('exceptions-nested')){
		$('<tr class="added"></tr>').appendTo('.exceptions tbody')
		$('<tr class="attachment1"></tr>').appendTo('.exceptions tbody')
		$('<tr class="attachment2"  onclick="displayResult(this)"></tr>').appendTo('.exceptions tbody')
	}else{
		$('<tr class="added"></tr>').appendTo('.exceptions tbody')
	}
	
	if($(this).hasClass('non-required')){
		$('.added').load('lib/add-exception-non-required.html').removeAttr('class');

	}else if($(this).prev('table').hasClass('exceptions-nested')){
		$('.added').load('lib/add-exception-nested1.html');
		var l = $(this).prev('table tbody').find('tr').length;
		$('.added input:radio').attr("name", "exceptionDetails[" + (Math.floor(l/3)) + "].exceptionTimelineId");
		$('.added').removeAttr('class');
		$('.attachment1').load('lib/add-exception-nested2.html').addClass('attachment-nested').removeClass('attachment1')
		$('.attachment2').load('lib/add-exception-nested3.html').addClass('attachment-nested2').removeClass('attachment2')

	}else{
		$('.added').load('lib/add-exception.html').removeAttr('class');
	}
		
	zebraStripes();
	autoTextarea();
	
	$('.autosize').bind('keyup', textareaCounter);
}


/**
 * Method to add the zebra stripes for Exceptions
 */
function zebraStripes(){
if ($.browser.msie) {
	$("tbody tr:even").addClass("even");//dumb ie 
	 $('thead .header').live('click',function(){
		$(".even").removeClass("even")
		$("tbody tr:even").addClass("even")
	}) 	
}
}

/**
 * Method to add the autoTextarea for Exceptions
 */
function autoTextarea(){
$('textarea.autosize').autoResize({
	onResize : function() {
		$(this).css({opacity:0.8});// On resize:
	},
	animateCallback : function() {
		$(this).css({opacity:1});// After resize:
	},
	animateDuration : 300, 
	minHeight: 30,		
	extraSpace : 40 // More extra space:
});
}

/**
 * Method to increase text area counter
 */
function textareaCounter() {

if($(this).data('max')>=0){
	var maxchar = $(this).data('max')
}else{
	var maxchar = 500
}
var cnt = $(this).val().length;
var remainingchar = maxchar - cnt;
var counter = $(this).prev()
var help = $(this).siblings('.help-block')
var left = $(this).outerWidth() -32
counter.html(remainingchar);
if(remainingchar > 0){
	counter.css('color', '#7FC47E');
	help.css('color', '#999999');
}else{
	counter.css('color', '#AE2C2C');
	help.css('color', '#AE2C2C');
}
if($(this).hasClass('small')){ //if its a small autosize in the table
	if(cnt > 25){
		counter.css('top','-2px')
	}else if(cnt < 25) {
		counter.css('top','29px')
	}
}else{
	if(cnt > 50){
		counter.css('top','-4px')
	}else if(cnt < 50) {
		counter.css('top','29px')
	}
}
}
$('.autosize').bind('keyup', textareaCounter);



/**
 * Method to add the exception details
 * @param rowNumber
 */
function addExceptionDetails(rowNumber) {
	var cmd="?command=addExceptionDetails";
	isChanged = false;
	var RCALegRequestForm = document.getElementById('ICFPLegRequestForm');
	
	var action = RCALegRequestForm.action;
	var legNumber = RCALegRequestForm.legNumber.value;
	action = action+cmd+"&legNumber="+legNumber+"&sid="+Math.random(); 
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
		req.onreadystatechange = reportStatusExceptionAdd;
		try {
			req.open("GET", action, false);
		} catch (e) {
			uploading = false;
		}
		req.send();
	} else if (window.ActiveXObject) {
		req = new ActiveXObject("Microsoft.XMLHTTP");
	
		if (req) {
			req.onreadystatechange = reportStatusExceptionAdd;
			req.open("GET", action, false);
			req.send();
		} else {
			uploading = false;
		}
	}
}

/**
 * Method to report Status Exception Add
 */
function reportStatusExceptionAdd() {
if (req.readyState == 4) {
	if (req.status == 200) { 
		var RCALegRequestForm = document.getElementById('ICFPLegRequestForm');
		var exceptionIndexElementList = RCALegRequestForm.elements["exceptionIndex"];
		
		exceptionCount = exceptionIndexElementList.length;
		
		var str = req.responseText;
		if(exceptionCount == undefined || exceptionCount==0) {
			RCALegRequestForm.exceptionIndex1.value = str;
		} else{
			exceptionIndexElementList[exceptionCount - 1].value = str;
		}
	}
}
}

/**Method to delete the exception details
 * 
 * @param rowNumber
 */
function deleteExceptionDetails(rowNumber) {
	var cmd="?command=deleteExceptionDetails";
	isChanged = false;
	var RCALegRequestForm = document.getElementById('ICFPLegRequestForm');
	var action = RCALegRequestForm.action;
	var legNumber = RCALegRequestForm.legNumber.value;
	var exceptionNumber = rowNumber;
	action = action+cmd+"&legNumber="+legNumber+"&exceptionNumber="+rowNumber+"&sid="+Math.random(); 
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
		req.onreadystatechange = reportStatusException;
		try {
			req.open("GET", action, false);
		} catch (e) {
			uploading = false;
		}
		req.send();
	} else if (window.ActiveXObject) {
		req = new ActiveXObject("Microsoft.XMLHTTP");
	
		if (req) {
			req.onreadystatechange = reportStatusException;
			req.open("GET", action, false);
			req.send();
		} else {
			uploading = false;
		}
	}
}

function reportStatusException() {
	if (req.readyState == 4) {
		if (req.status == 200) { 
			var str = req.responseText;
			
			if(document.getElementById("exceptionIndex").length ==undefined) {
				 $("#exceptionIndex").val(str);
			} else {
				 $("#exceptionIndex")[str - 1].val(str);
			} 
			}
		
	}
}

/**Method to delete the exception details
 * 
 * @param rowNumber
 */
function deleteAmendmentDetails(rowNumber) {
	var cmd="?command=deleteAmendment";
	isChanged = false;
	var RCALegRequestForm = document.getElementById('ICFPLegRequestForm');
	var action = RCALegRequestForm.action;
	var legNumber = RCALegRequestForm.legNumber.value;
	var exceptionNumber = rowNumber;
	action = action+cmd+"&legNumber="+legNumber+"&amendmentNumber="+rowNumber+"&sid="+Math.random(); 
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
		req.onreadystatechange = reportStatusAmendment;
		try {
			req.open("GET", action, false);
		} catch (e) {
			uploading = false;
		}
		req.send();
	} else if (window.ActiveXObject) {
		req = new ActiveXObject("Microsoft.XMLHTTP");
	
		if (req) {
			req.onreadystatechange = reportStatusAmendment;
			req.open("GET", action, false);
			req.send();
		} else {
			uploading = false;
		}
	}
}

function reportStatusAmendment() {
	if (req.readyState == 4) {
		if (req.status == 200) { 
			var str = req.responseText;
			if(document.getElementById("amendmentexceptionIndex")!=null){
				if(document.getElementById("amendmentexceptionIndex").length ==undefined) {
					 $("#amendmentexceptionIndex").val(str);
				} else {
					 $("#amendmentexceptionIndex")[str - 1].val(str);
				} 
				}	
			}
		
	}
}

function getFOIndexTermDetails()
{
	 
		url = '';
	   floatingRate = $('#floatRateIndexId').val();
	   legNum =  $('#legNumberID').val();
	   actionIDData = $('#actionId').val();
		   if(actionIDData!=null && actionIDData==2){
			   url = contextURL+"/frontoffice/RCALegRequest.do?command=getIndexTermData"; 
		   }else if(actionIDData!=null && actionIDData==1){
			   url = contextURL+"/RCALegRequest.do?command=getIndexTermData"; 
		   }
	 
	   if(url!="")
	      {
	        
	    	  $.post( url, {floatingRateIndex:floatingRate,actionID:actionIDData,legNumber:legNum},
	                    function(data){
	    		        var content = $(data).find("#indexTermDivID");
	                    $("#indexTermDivID").empty().append( content.html() );
	            });
	    	}
}

function facIncrease(){
	$('.facilityIncreaseDecrease').text("Amendment : Facility Increase Details");
	$('#facilityDecreaseDetails').show();
	$('.incDec').text("Increase");
	$('.incDec').show();
	calcAmendedAmt();
	$("#amendedFacilityAmt").focusout();
}

function facDecrease(){
	$('.facilityIncreaseDecrease').text("Amendment : Facility Decrease Details");
	$('#facilityDecreaseDetails').show();
	$('.incDec').text('Decrease');
	$('.incDec').show();
	calcAmendedAmt();
	$("#amendedFacilityAmt").focusout();
}

function fixedClick(){
	$('#baseFixedRateID').val("");
	$('#fixedSpreadID').val("");
	$('#fixedSpread').hide();
	$('#fixedSpreadfailedBar').hide();
}

function floatClick(){
	$('#floatRateIndexId').val("");
	$('#floatSpreadID').val("");
	$('#floatRateIndexTermId').val("");
	$('#floatSpread').hide();
	$('#floatSpreadfailedBar').hide();
}

/**
 * Validations for all the products based the click of Save and return to deal
 * @param cmd
 */
function validateAssignment(cmd){
	
	$("#updateMessageID").hide();
	
	var validateflag = false;
	
	validateflag = isEntitesSameInAssignment(validateflag);
	validateflag  = originalLenderBorrowerValidations(validateflag);
	validateflag = originalTransactionValidations(validateflag);
	validateflag  = newLenderBorrowerValidations(validateflag);
	validateflag = originalCCYValidate(validateflag);
	validateflag = accuredAndFeesValidate(validateflag);
	
	var pandLAmt = $("#pandLAmt").val();
	var val = pandLAmt;
	val = val.replace(/,/g,"");
	pandLAmt = val;
	if(pandLAmt == ""){
		$("#pandLAmtBar").show();
		validateflag = true;
	}else {
		$("#pandLAmtBar").hide();
	}
	
	var isOrigLegalAgreementAttachedFlag = $('input[id=isOrigLegalAgreementAttachedFlag]:checked').val();
	if(!(isOrigLegalAgreementAttachedFlag == "true" || isOrigLegalAgreementAttachedFlag == "false")){
		$("#originalAgmtDiv").addClass("radio-container req-error");
		validateflag = true;
	}else {
		$("#originalAgmtDiv").removeClass("req-error");
	}
	
	validateflag = validateDerivative(validateflag);
	validateflag = payorValidations(validateflag);
	validateflag = otherConsiderations(validateflag);
	validateflag = checkME(validateflag);

	function changeValue(obj, status){
		$(obj).parents("tr").find("input:hidden").val(status);
	}
	


	if(validateflag == false){
		saveAndReturnDeal(cmd);
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}
}

function checkME(validateflag){
	$('.me-lookup').each( function(){
		var e = $(this).siblings(".error");
		if( $(e).is(":visible") ){
			validateflag = true;
		}
	});
	return validateflag;
}
function validateCorrection(cmd, productType){

	var validateflag = false;
	if(productType == 2){
		validateflag = equityOriginalTransactionValidations(validateflag);
	}else{
		validateflag = originalTransactionUsdValidations(validateflag);
	}
	
	validateflag = originalLenderBorrowerValidations(validateflag);
	validateflag = isLenderBorrowerSame(validateflag);
	validateflag = validateGoldId(validateflag);
	
	var problemStatement = $("#problemStatement").val();
	if(problemStatement == ""){
		$("#problemStatementBar").show();
		validateflag = true;
	}else {
		$("#problemStatementBar").hide();
	}
	
	var correctionNeededComments = $("#correctionNeededComments").val();
	if(correctionNeededComments == ""){
		$("#correctionNeededCommentsBar").show();
		validateflag = true;
	}else {
		$("#correctionNeededCommentsBar").hide();
	}
	
	var actionNeededByDt = $("#actionNeededByDt").val();
	if(actionNeededByDt == ""){
		$("#actionNeededByDtBar").show();
		validateflag = true;
	}else {
		$("#actionNeededByDtBar").hide();
	}
	
	validateflag = checkME(validateflag);
	
	

	if(validateflag == false){
		saveAndReturnDeal(cmd);
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}
}

function validatePrepayment(cmd){
	var validateflag = false;
	
	validateflag = originalTransactionValidations(validateflag);
	validateflag = originalLenderBorrowerValidations(validateflag);
	validateflag = isLenderBorrowerSame(validateflag);
	validateflag = originalCCYValidate(validateflag);
	validateflag = accuredAndFeesValidate(validateflag);
	
	validateflag = validateGoldId(validateflag);
	
	var prepaymentNoticeAttachedFlag = $('input[id=prepaymentNoticeAttachedFlag]:checked').val();
	if(!(prepaymentNoticeAttachedFlag == "true" || prepaymentNoticeAttachedFlag == "false")){
		$("#preArrachedDiv").addClass("radio-container req-error");
		validateflag = true;
	}else {
		$("#preArrachedDiv").removeClass("req-error");
	}
	
	validateflag = validateDerivative(validateflag);
	validateflag = checkME(validateflag);;
	
	

	if(validateflag == false){
		saveAndReturnDeal(cmd);
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}
}

function validateDebtEquity(cmd, productType){

	var validateflag = false;

	validateflag = originalLenderBorrowerValidations(validateflag);
	validateflag = isLenderBorrowerSame(validateflag);
	
	var debtEquityOtherComments = $("#debtEquityOtherComments").val();
	if(debtEquityOtherComments == ""){
		$("#commentsBar").show();
		validateflag = true;
	}else {
		$("#commentsBar").hide();
	}
	if(productType != 2){
		validateflag = validateDerivative(validateflag);
		validateflag = termsAndConditions(validateflag);
	}
	validateflag = otherConsiderations(validateflag);
		
	var originalCCY = $("#originalCCY").val();
	var originalCCYAmount = $("#originalCCYAmount").val();
	var val = originalCCYAmount;
	val = val.replace(/,/g,"");
	originalCCYAmount = val;
	
	var USDEquivalent = $("#USDEquivalent").val();
	var val = USDEquivalent;
	val = val.replace(/,/g,"");
	USDEquivalent = val;
	
	if(originalCCY != undefined && originalCCYAmount != undefined){
		if(originalCCY != "" && originalCCYAmount != "" && (USDEquivalent == "" || parseFloat(USDEquivalent) <= 0)){
			$("#usdValidateBar").show();
			validateflag = true;
		}else{
			$("#usdValidateBar").hide();
		}
	}

	validateflag = checkME(validateflag);
	
	


	if(validateflag == false){
		saveAndReturnDeal(cmd);
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}

}


function validateTermination(cmd){

	var validateflag = false;
	validateflag = originalTransactionValidations(validateflag);
	validateflag = originalLenderBorrowerValidations(validateflag);
	validateflag = isLenderBorrowerSame(validateflag);
	
	validateflag = originalCCYValidate(validateflag);
	
	var accruedInterestAmt = $("#accruedInterestAmt").val();
	var val = accruedInterestAmt;
	val = val.replace(/,/g,"");
	accruedInterestAmt = val;
	if(accruedInterestAmt == ""  || accruedInterestAmt.match('^[0-9]*\.[0-9]*$')==null){
		$("#accruedInterestBar").show();
		validateflag = true;
	}else {
		$("#accruedInterestBar").hide();
	}
	
	var eventNoticeAttachedFlag = $('input[id=eventNoticeAttachedFlag]:checked').val();
	if(!(eventNoticeAttachedFlag == "true" || eventNoticeAttachedFlag == "false")){
		$("#terminationDiv").addClass("radio-container req-error");
		validateflag = true;
	}else {
		$("#terminationDiv").removeClass("req-error");
	}
	
	var brokerageCostAmt = $("#brokerageCostAmt").val();
	var val = brokerageCostAmt;
	val = val.replace(/,/g,"");
	brokerageCostAmt = val;
	if(brokerageCostAmt == ""  || brokerageCostAmt.match('^[0-9]*\.[0-9]*$')==null){
		$("#brokerageCostAmtBar").show();
		validateflag = true;
	}else {
		$("#brokerageCostAmtBar").hide();
	}

	validateflag = termsAndConditions(validateflag);
	validateflag = validateDerivative(validateflag);
	validateflag = otherConsiderations(validateflag);
	validateflag = checkME(validateflag);
	
	function changeValue(obj, status){
		$(obj).parents("tr").find("input:hidden").val(status);
	}
	

	if(validateflag == false){
		saveAndReturnDeal(cmd);
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}
} 


function validateAgreementExtension(cmd){

	var validateflag = false;
	validateflag = originalTransactionValidations(validateflag);
	
	var maturityDt = $("#maturityDt").val();
	if(maturityDt == ""){
		$("#maturityDtBar").show();
		validateflag = true;
	}else{
		if(isDate(maturityDt)){
			$("#maturityDtBar").hide();
		}else{
			$("#maturityDtBar").show();
			validateflag = true;
		}
		
	}
	
	validateflag  = originalLenderBorrowerValidations(validateflag);
	validateflag = isLenderBorrowerSame(validateflag);
	
	var amendmentMaturityDt = $("#amendmentMaturityDt").val();
	if(amendmentMaturityDt == ""){
		$("#amendmentMaturityDtBar").show();
		validateflag = true;
	}else {
		if(isDate(amendmentMaturityDt)){
			$("#amendmentMaturityDtBar").hide();
		}else{
			$("#amendmentMaturityDtBar").show();
			validateflag = true;
		}
	}
	
	validateflag = originalCCYValidate(validateflag);
	validateflag = termsAndConditions( validateflag);
	
	var isOrigLegalAgreementAttachedFlag = $('input[id=isOrigLegalAgreementAttachedFlag]:checked').val();
	if(!(isOrigLegalAgreementAttachedFlag == "true" || isOrigLegalAgreementAttachedFlag == "false")){
		$("#originalAgmtDiv").addClass("radio-container req-error");
		validateflag = true;
	}else {
		$("#originalAgmtDiv").removeClass("req-error");
	}
	
	validateflag = validateDerivative(validateflag);
	validateflag = otherConsiderations(validateflag);
	function changeValue(obj, status){
		$(obj).parents("tr").find("input:hidden").val(status);
	}
	
	validateflag = checkME(validateflag);
	
	

	if(validateflag == false){
		saveAndReturnDeal(cmd);
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}
}

function validateAmendIncreaseDecrease(cmd){
	var validateflag = false;
	
	validateflag = originalTransactionValidations(validateflag);
	validateflag  = originalLenderBorrowerValidations(validateflag);
	validateflag = isLenderBorrowerSame(validateflag);
	
	var facilityType = $('input[id=facilityType]:checked').val();
	if(!(facilityType == "1" || facilityType == "2")){
		$("#facilityDiv").addClass("radio-container req-error");
		validateflag = true;
	}else {
		
		if(facilityType == "2"){
			validateflag = validateGoldId(validateflag);
		}
		
		$("#facilityDiv").removeClass("req-error");
		
		var originalCCY = $("#originalCCY").val();
		if(originalCCY == ""){
			$("#originalCCYValidateBar").show();
			validateflag = true;
		}else {
			$("#originalCCYValidateBar").hide();
		}
		
		var originalCCYAmount = $("#currencyAmt").val();
		var val = originalCCYAmount;
		val = val.replace(/,/g,"");
		originalCCYAmount = val;
		
		if(originalCCYAmount == ""  || originalCCYAmount.match('^[0-9]*\.[0-9]*$')==null || parseFloat(originalCCYAmount) <= 0){
			$("#currencyFacilityAmteBar").show();
			validateflag = true;
		}else{
			$("#currencyFacilityAmteBar").hide();
		}
		
		var USDEquivalent = $("#currencyUSDEquivalentAmt").val();
		var val = USDEquivalent;
		val = val.replace(/,/g,"");
		USDEquivalent = val;
		if(originalCCY != "" && originalCCYAmount != "" && (USDEquivalent == "" || parseFloat(USDEquivalent) <= 0)){
			$("#usdValidateBar").show();
			validateflag = true;
		}else{
			$("#usdValidateBar").hide();
		}
		
		var amendedFacilityAmt = $("#amendedFacilityAmt").val();
		var val = amendedFacilityAmt;
		val = val.replace(/,/g,"");
		amendedFacilityAmt = val;
		
		if(amendedFacilityAmt == "" || amendedFacilityAmt.match('^[0-9]*\.[0-9]*$')==null || parseFloat(amendedFacilityAmt) <= 0){
			$("#amendedFacilityAmtBar").show();
			validateflag = true;
		}else{
			$("#amendedFacilityAmtBar").hide();
		}
		
		var facIncDecUSDAmt = $("#facilityIncDecUSDEquivalentAmt").val();
		var val = facIncDecUSDAmt;
		if(val!=undefined){
			val = val.replace(/,/g,"");
			facIncDecUSDAmt = val;
			if(originalCCY != "" && amendedFacilityAmt != "" && (facIncDecUSDAmt == "" || parseFloat(facIncDecUSDAmt) <= 0)){
				$("#usdFacValidateBar").show();
				validateflag = true;
			}else{
				$("#usdFacValidateBar").hide();
			}
		}
		var facilityIncDecAmt = $("#facilityIncDecAmt").val();
		var val = facilityIncDecAmt;
		val = val.replace(/,/g,"");
		facilityIncDecAmt = val;
		
		if(facilityIncDecAmt == "" || facilityIncDecAmt.match('^[0-9]*\.[0-9]*$')==null || parseFloat(facilityIncDecAmt) <= 0){
			$("#facilityIncDecAmtBar").show();
			validateflag = true;
		}else{
			$("#facilityIncDecAmtBar").hide();
		}
		var amendedUSDEquivalentAmt = $("#amendedUSDEquivalentAmt").val();
		var val = amendedUSDEquivalentAmt;
		val = val.replace(/,/g,"");
		amendedUSDEquivalentAmt = val;
		if(originalCCY != "" && facilityIncDecAmt != "" && (amendedUSDEquivalentAmt == "" || parseFloat(amendedUSDEquivalentAmt) <= 0)){
			$("#usdAmendValidateBar").show();
			validateflag = true;
		}else{
			$("#usdAmendValidateBar").hide();
		}
		
		
		var isOrigLegalAgreementAttachedFlag = $('input[id=isOrigLegalAgreementAttachedFlag]:checked').val();
		if(!(isOrigLegalAgreementAttachedFlag == "true" || isOrigLegalAgreementAttachedFlag == "false")){
			$("#originalAgmtDiv").addClass("radio-container req-error");
			validateflag = true;
		}else {
			$("#originalAgmtDiv").removeClass("req-error");
		}
		
		validateflag = validateDerivative(validateflag);
	}
	
	validateflag  = termsAndConditions(validateflag);
	validateflag = otherConsiderations(validateflag);
	validateflag = checkME(validateflag);

	function changeValue(obj, status){
		$(obj).parents("tr").find("input:hidden").val(status);
	}
	
	if(validateflag == false){
		saveAndReturnDeal(cmd);
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}
}

function validateDrawDown(cmd){

	var validateflag = false;
	
	validateflag = originalTransactionValidations(validateflag);
	validateflag  = originalLenderBorrowerValidations(validateflag);
	validateflag = isLenderBorrowerSame(validateflag);
	validateflag = validateGoldId(validateflag);
	 $("#drawdownvalueDtErrorID").hide();
	 $("#drawdownvalueDtTodayID").hide();
	 
	var drawdownNoticeAttachedFlag = $('input[id=drawdownNoticeAttachedFlag]:checked').val();
	if(!(drawdownNoticeAttachedFlag == "true" || drawdownNoticeAttachedFlag == "false")){
		$("#drawDownNoticeDiv").addClass("radio-container req-error");
		validateflag = true;
	}else {
		$("#drawDownNoticeDiv").removeClass("req-error");
	}
	
	var drawdownValueDt = $("#drawdownValueDt").val();
	if(drawdownValueDt == ""){
		$("#drawdownValueDtBar").show();
		validateflag = true;
	}else {
		
		if(isDate(drawdownValueDt)){
		
			$("#drawdownValueDtBar").hide();
		}else{
			
			$("#drawdownValueDtBar").show();
			validateflag = true;
		}
		
	}
	
	var drawDownFlag = false;
	var valueDt = $("#valueDateID").val();
	if(drawdownValueDt != "" && valueDt!="" ){
		var drawDownDate = new Date(drawdownValueDt);
		var valueDate = new Date(valueDt);
		if(drawDownDate < valueDate){
			 $("#drawdownvalueDtErrorID").show();
			 validateflag = true;
			 drawDownFlag = true;
		 }
	}
	
	
	if(drawdownValueDt != "" && drawDownFlag== false){
		var requestFrmtDt = $("#todayDateID").val();
		var drawDownDate = new Date(drawdownValueDt);
		var reqDate = new Date(requestFrmtDt);
		if(drawDownDate < reqDate){
			 $("#drawdownvalueDtTodayID").show();
			 validateflag = true;
		 }
	}
	

	validateflag = validateDerivative(validateflag);

	validateflag = originalCCYValidate(validateflag);
	validateflag = checkME(validateflag);
	

	if(validateflag == false){
		saveAndReturnDeal(cmd);
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}
}


function validateGenAmendment(cmd){
	var validateflag = false;
	
	validateflag = originalTransactionUsdValidations(validateflag);
	validateflag  = originalLenderBorrowerValidations(validateflag);
	validateflag = isLenderBorrowerSame(validateflag);
	validateflag  = termsAndConditions(validateflag);
	validateflag = otherConsiderations(validateflag);
	
	var isOrigLegalAgreementAttachedFlag = $('input[id=isOrigLegalAgreementAttachedFlag]:checked').val();
	if(!(isOrigLegalAgreementAttachedFlag == "true" || isOrigLegalAgreementAttachedFlag == "false")){
		$("#originalAgmtDiv").addClass("radio-container req-error");
		validateflag = true;
	}else {
		$("#originalAgmtDiv").removeClass("req-error");
	}
	
	validateflag = validateDerivative(validateflag);
	
	if( !(amendmentValidation()) ){
		validateflag = true;
	}
	
	function changeValue(obj, status){
		$(obj).parents("tr").find("input:hidden").val(status);
	}

	validateflag = checkME(validateflag);
	
	
	if(validateflag == false){
		saveAndReturnDeal(cmd);
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}
}

/**
 * This method is used to check the given value contains expected characters.
 * @param val
 * @returns {Boolean}
 */
function isNumber(val) {
	var numericExpression = /^\d*(\.\d{2})?$/;
	if(val && val.match(numericExpression)) {
		return true;
	} else {
		return false;
	}
}

/**
 * This method is used to check whether inputer parameter is number or string.
 * @param val
 * @returns {Boolean}
 */
function IsNumeric(val) {
	if (isNaN(val)) {
	      return false;
	 }
	 return true;
}

function saveLeg(cmd){
	hideValidationBarsSave();
	saveAndReturnDeal(cmd);
}


function termsAndConditions(validateflag){
	var fixedOrFloat = $('input[id=fixedOrFloatRadioId]:checked').val();
	
	if(fixedOrFloat == "1"){
		var baseFixedRateID = $("#baseFixedRateID").val();
		if(baseFixedRateID != "" && (baseFixedRateID.match('^[0-9]*\.[0-9]*$')==null || parseFloat(baseFixedRateID) < 0)){
			$("#baseFixedRatefailedBar").show();
			validateflag = true;
		}else {
			$("#baseFixedRatefailedBar").hide();
		}
	}
	return validateflag;
}

function otherConsiderations(validateflag){
	var isNonStandardLegalAgreement = $('input[id=isNonStandardLegalAgreement]:checked').val();
	var isCrossBorderFlag = $('input[id=crossBorderFlag]:checked').val();
	var subordinatedDebt = $('input[id=subordinatedDebt]:checked').val();
	
	if(!(subordinatedDebt == "true" || subordinatedDebt == "false")){
		$("#subordinatedDiv").addClass("radio-container req-error");
		validateflag = true;
	}else {
		$("#subordinatedDiv").removeClass("req-error");
	}
	
	if(!(isNonStandardLegalAgreement == "true" || isNonStandardLegalAgreement == "false")){
		$("#legalAgreementDiv").addClass("radio-container exceptionsConditional req-error");
		validateflag = true;
	}else {
		$("#legalAgreementDiv").removeClass("req-error");
		if(isNonStandardLegalAgreement == "true"){
			if( exceptionValidation() ){
			}else{
				validateflag = true;
			}
		}
	}
	
	if(!(isCrossBorderFlag == "true" || isCrossBorderFlag == "false")){
		$("#crossborderDiv").addClass("radio-container req-error");
		validateflag = true;
	}else {
		$("#crossborderDiv").removeClass("req-error");
	}
	return validateflag;
}

function payorValidations(validateflag){
	var payorGoldId = $("#payorGoldId").val();
	if(payorGoldId == "" && !($('input[id=payorEntitySetupFlag]:checked').val()=="Y")){
		$("#payorInfofailedBar").show();
		validateflag = true;
		
	}else {
		$("#payorInfofailedBar").hide();
		
		if($('input:radio[id=payorRegulatedEntityFlag1]:checked').val()==undefined && $('input:radio[id=payorRegulatedEntityFlag2]:checked').val()==undefined){
			$("#payorRegDiv").addClass("radio-container regulatedEntityFlag req-error");
			validateflag = true;
		}else{
			$("#payorRegDiv").removeClass("req-error");
		}
		
		if($('input:radio[id=payorPrincplEntityFlag1]:checked').val()==undefined && $('input:radio[id=payorPrincplEntityFlag2]:checked').val()==undefined){
			$("#payorPriDiv").addClass("radio-container princplEntityFlag req-error");
			validateflag = true;
		}else{
			$("#payorPriDiv").removeClass("req-error");
		}
	}
	
	var payorMgmtEntity = $("#selectedPayorMgmtEntity").val();
	if(payorMgmtEntity == ""){
		$("#payorMgmtfailedBar").show();
		validateflag = true;
	}else {
		$("#payorMgmtfailedBar").hide();
	}
	return validateflag;
}


function originalLenderBorrowerValidations(validateflag){
	var lenderGoldId = $("#lenderLegalEntityGoldId").val();
	if(lenderGoldId == "" && !($('input[id=lenderEntitySetupFlag]:checked').val()=="Y")){
		$("#lenderInfofailedBar").show();
		validateflag = true;
	}else {
		$("#lenderInfofailedBar").hide();
		if($('input:radio[id=regulatedEntityFlag1]:checked').val()==undefined && $('input:radio[id=regulatedEntityFlag2]:checked').val()==undefined){
			$("#lenderRegDiv").addClass("radio-container regulatedEntityFlag req-error");
			validateflag = true;
		}else{
			$("#lenderRegDiv").removeClass("req-error");
		}
		
		if($('input:radio[id=princplEntityFlag1]:checked').val()==undefined && $('input:radio[id=princplEntityFlag2]:checked').val()==undefined){
			$("#lenderPriDiv").addClass("radio-container princplEntityFlag req-error");
			validateflag = true;
		}else{
			$("#lenderPriDiv").removeClass("req-error");
		}
	}
	
	var lenderMgmtEntity = $("#selectedLenderMgmtEntity").val();
	if(lenderMgmtEntity == ""){
		$("#lenderMgmtfailedBar").show();
		validateflag = true;
	}else {
		$("#lenderMgmtfailedBar").hide();
	}
		
	var borrowerGoldId = $("#borrowerLegalEntityGoldId").val();
	if(borrowerGoldId == "" && !($('input[id=borrowerEntitySetupFlag]:checked').val()=="Y")){
		$("#borrowerInfofailedBar").show();
		validateflag = true;
	}else if(borrowerGoldId != "" && lenderGoldId!="" && borrowerGoldId == lenderGoldId){
		$("#borrowerGoldIdInvalid").show();
		$("#borrowerInfofailed").hide();
		$("#borrowerInfofailed").hide();
		$("#borrowerInfofailedBar").show();
		$("#borrowerInfoInvalid").hide();
	}else{
		$("#borrowerInfofailedBar").hide();
		if($('input:radio[id=borRegulatedEntityFlag1]:checked').val()==undefined && $('input:radio[id=borRegulatedEntityFlag2]:checked').val()==undefined){
			$("#borrowerRegDiv").addClass("radio-container regulatedEntityFlag req-error");
			validateflag = true;
		}else{
			$("#borrowerRegDiv").removeClass("req-error");
		}
		
		if($('input:radio[id=borPrincplEntityFlag1]:checked').val()==undefined && $('input:radio[id=borPrincplEntityFlag2]:checked').val()==undefined){
			$("#borrowerPriDiv").addClass("radio-container princplEntityFlag req-error");
			validateflag = true;
		}else{
			$("#borrowerPriDiv").removeClass("req-error");
		}
	}
	
	var borrowerMgmtEntity = $("#selectedBorrowerMgmtEntity").val();
	if(borrowerMgmtEntity == ""){
		$("#borrowerMgmtfailedBar").show();
		validateflag = true;
	}else {
		$("#borrowerMgmtfailedBar").hide();
	}
	return validateflag;
}

function newLenderBorrowerValidations(validateflag){
	
	
	var newLenderOrBorrower = $('input[id=newLenderOrBorrower]:checked').val();
	if(!(newLenderOrBorrower == "true" || newLenderOrBorrower == "false")){
		$("#newLenBorDiv").addClass("radio-container req-error");
		validateflag = true;
	}else {
		$("#newLenBorDiv").removeClass("req-error");
	
		var newLenderOrBorrower = $('input[id=newLenderOrBorrower]:checked').val();
		if(newLenderOrBorrower == "true"){
			var newLenderGoldId = $("#newLenderLegalEntityGoldId").val();
			if(newLenderGoldId == "" && !($('input[id=newLenderEntitySetupFlag]:checked').val()=="Y")){
				$("#newLenderInfofailedBar").show();
				validateflag = true;
			}else {
				$("#newLenderInfofailedBar").hide();
				
				if($('input:radio[id=newRegulatedEntityFlag1]:checked').val()==undefined && $('input:radio[id=newRegulatedEntityFlag2]:checked').val()==undefined){
					$("#newLenderRegDiv").addClass("radio-container regulatedEntityFlag req-error");
					validateflag = true;
				}else{
					$("#newLenderRegDiv").removeClass("req-error");
				}
				
				if($('input:radio[id=newPrincplEntityFlag1]:checked').val()==undefined && $('input:radio[id=newPrincplEntityFlag2]:checked').val()==undefined){
					$("#newLenderPriDiv").addClass("radio-container princplEntityFlag req-error");
					validateflag = true;
				}else{
					$("#newLenderPriDiv").removeClass("req-error");
				}
			}
		
			var newLenderMgmtEntity = $("#selectedNewLenderMgmtEntity").val();
			if(newLenderMgmtEntity == ""){
				$("#newLenderMgmtfailedBar").show();
				validateflag = true;
			}else {
				$("#newLenderMgmtfailedBar").hide();
			}
		}else if(newLenderOrBorrower == "false"){		
			var newBorrowerGoldId = $("#newBorrowerLegalEntityGoldId").val();
			if(newBorrowerGoldId == "" && !($('input[id=newBorrowerEntitySetupFlag]:checked').val()=="Y")){
				$("#newBorrowerInfofailedBar").show();
				validateflag = true;
				
			}else{
				$("#newBorrowerInfofailedBar").hide();
				
				if($('input:radio[id=newBorRegulatedEntityFlag1]:checked').val()==undefined && $('input:radio[id=newBorRegulatedEntityFlag2]:checked').val()==undefined){
					$("#newBorrowerRegDiv").addClass("radio-container regulatedEntityFlag req-error");
					validateflag = true;
				}else{
					$("#newBorrowerRegDiv").removeClass("req-error");
				}
				
				if($('input:radio[id=newBorPrincplEntityFlag1]:checked').val()==undefined && $('input:radio[id=newBorPrincplEntityFlag2]:checked').val()==undefined){
					$("#newBorrowerPriDiv").addClass("radio-container princplEntityFlag req-error");
					validateflag = true;
				}else{
					$("#newBorrowerPriDiv").removeClass("req-error");
				}
			}
			
			var newBorrowerMgmtEntity = $("#selectedNewBorrowerMgmtEntity").val();
			if(newBorrowerMgmtEntity == ""){
				$("#newBorrowerMgmtfailedBar").show();
				validateflag = true;
			}else {
				$("#newBorrowerMgmtfailedBar").hide();
			}
		}
	}
	return validateflag;
}

function originalTransactionValidations(validateflag){
	var transactionId = $("#transactionId").val();

	if(transactionId == ""){
		$("#transactionIdBar").show();
		validateflag = true;
	}else $("#transactionIdBar").hide();
	
	var termInMonths = $("#termInMonths").val();
	if(termInMonths == "" || !(isNumber(termInMonths)) || parseInt(termInMonths) <= 0){
		$("#terminMonthsBar").show();
		validateflag = true;
	}else $("#terminMonthsBar").hide();
	
	var originalLegalAgreementsFlag = $('input[id=originalLegalAgreementsFlag]:checked').val();
	if(!(originalLegalAgreementsFlag == "1" || originalLegalAgreementsFlag == "0")){
		$("#originalLegalAgreementDiv").addClass("radio-container req-error");
		validateflag = true;
	}else {
		$("#originalLegalAgreementDiv").removeClass("req-error");
	}
	
	var isHedgedFlag = $('input[id=isHedgedFlag]:checked').val();
	if(!(isHedgedFlag == "1" || isHedgedFlag == "0")){
		$("#transHedgedDiv").addClass("radio-container req-error");
		validateflag = true;
	}else {
		$("#transHedgedDiv").removeClass("req-error");
	}
	
	var dayOneCCYAmount = $("#dayOneCCYAmount").val();
	var val = dayOneCCYAmount;
	val = val.replace(/,/g,"");
	dayOneCCYAmount = val;
	if(dayOneCCYAmount == "" || dayOneCCYAmount.match('^[0-9]*\.[0-9]*$')==null  || parseFloat(dayOneCCYAmount) < 0){
		$("#dayOneAmtBar").show();
		validateflag = true;
	}else $("#dayOneAmtBar").hide();
	
	var dayOneCCY = $("#dayOneCCY").val();
	if(dayOneCCY == ""){
		$("#dayOneCCYBar").show();
		validateflag = true;
	}else $("#dayOneCCYBar").hide();
	
	
	var dayOneUSDEquivalent = $("#dayOneUSDEquivalent").val();
	var val = dayOneUSDEquivalent;
	if(val!=undefined){
	val = val.replace(/,/g,"");
	dayOneUSDEquivalent = val;
	if(dayOneCCY != "" && dayOneCCYAmount != "" && (dayOneUSDEquivalent == "" || parseFloat(dayOneUSDEquivalent) <= 0)){
		$("#dayOneUsdBar").show();
		validateflag = true;
	}else{
		$("#dayOneUsdBar").hide();
	}
	}
	
	return validateflag;
}


function equityOriginalTransactionValidations(validateflag){
	var originalLegalAgreementsFlag = $('input[id=originalLegalAgreementsFlag]:checked').val();
	if(!(originalLegalAgreementsFlag == "1" || originalLegalAgreementsFlag == "0")){
		$("#originalLegalAgreementDiv").addClass("radio-container req-error");
		validateflag = true;
	}else {
		$("#originalLegalAgreementDiv").removeClass("req-error");
	}
	
	validateflag = originalCCYValidate(validateflag);
	return validateflag;
}


function saveAndReturnDeal(cmd){
	var fixedOrFloat = $('input[id=fixedOrFloatRadioId]:checked').val();
	if(fixedOrFloat!=undefined && fixedOrFloat == "2"){
		var floatSpreadID = $('#floatSpreadID').val();
		if(floatSpreadID!=undefined && floatSpreadID!=""){
			$('#fixedSpreadID').val(floatSpreadID);
		}
	}

	var isVisible = false;
	$('.invalid').each(function(){
		if($('.invalid').is(":visible")){
			isVisible = $('.invalid').is(":visible");
		}
	});
	
	if(!isVisible){
		if(!($('input[id=lenderEntitySetupFlag]:checked').val()=="Y")){
			document.getElementById("lenderEntitySetupFlag").value="N";
		}else{
			document.getElementById("lenderEntitySetupFlag").value="Y";
		}
	
		if(!($('input[id=borrowerEntitySetupFlag]:checked').val()=="Y")){
			document.getElementById("borrowerEntitySetupFlag").value="N";
		}else{
			document.getElementById("borrowerEntitySetupFlag").value="Y";
		}
		removeAmountcommas();
		setGoldIdValues();
		
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
		
		var newLenderEntitySetupFlag = $('input[id=newLenderEntitySetupFlag]:checked').val();
		if(newLenderEntitySetupFlag==null || newLenderEntitySetupFlag == "" || newLenderEntitySetupFlag == undefined)
		{
			$('input[id=newLenderEntitySetupFlag]').attr('checked', true);
			$("#newLenderEntitySetupFlag").val("N");
		}
		
		var newBorrowerEntitySetupFlag = $('input[id=newBorrowerEntitySetupFlag]:checked').val();
		if(newBorrowerEntitySetupFlag==null || newBorrowerEntitySetupFlag == "" || newBorrowerEntitySetupFlag == undefined)
		{
			$('input[id=newBorrowerEntitySetupFlag]').attr('checked', true);
			$("#newBorrowerEntitySetupFlag").val("N");
		}
		
		var payorEntitySetupFlag = $('input[id=payorEntitySetupFlag]:checked').val();
		if(payorEntitySetupFlag==null || payorEntitySetupFlag == "" || payorEntitySetupFlag == undefined)
		{
			$('input[id=payorEntitySetupFlag]').attr('checked', true);
			$("#payorEntitySetupFlag").val("N");
		}
		
		var RCALegRequestForm = document.getElementById('ICFPLegRequestForm');
		var action = RCALegRequestForm.action;
		action = action+cmd; 
		RCALegRequestForm.action = action;
		RCALegRequestForm.submit();
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}
}



function hideValidationBarsSave(){
	$("#lenderInfofailedBar").hide();
	$("#lenderMgmtfailedBar").hide();
	$("#lenderCap").removeClass("req-error");
	$("#borrowerInfofailedBar").hide();
	$("#borrowerMgmtfailedBar").hide();
	$("#borrowerCap").removeClass("req-error");
	$("#productTypefailedBar").hide();
	$("#legalAgreementDiv").removeClass("req-error");
	$("#subordinatedDiv").removeClass("req-error");
	$("#existingDiv").removeClass("req-error");
	$("#derivativDiv").removeClass("req-error");
	$("#exceptionCommentsBar").hide();
	$("#termValidateBar").hide();
	$("#originalCCYValidateBar").hide();
	$("#originalCCYAmountValidateBar").hide();
}

/**
 * Method to redirect to home page
 * @param cmd
 */
function redirectFundingRequest(cmd){
	removeAmountcommas();
	
	var RCALegRequestForm = document.getElementById('ICFPLegRequestForm');
	var action = RCALegRequestForm.action;
	action = action+cmd; 
	RCALegRequestForm.action = action;
	RCALegRequestForm.submit();
}

/**
 * Method to add the comma seperate for the mount & the USD Equivalent
 * @param originalCCYAmount
 */
function commaSeperateAmt(originalCCYAmount){
	value= originalCCYAmount;
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

function removeAmountcommas(){
	var val = $( "#USDEquivalent" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#USDEquivalent" ).val(val);
	}
	
	var val = $( "#originalCCYAmount" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#originalCCYAmount" ).val(val);
	}
	
	var val = $( "#dayOneCCYAmount" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#dayOneCCYAmount" ).val(val);
	}
	
	var val = $( "#dayOneUSDEquivalent" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#dayOneUSDEquivalent" ).val(val);
	}
	
	var val = $( "#currencyAmt" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#currencyAmt" ).val(val);
	}
	
	var val = $( "#amendedFacilityAmt" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#amendedFacilityAmt" ).val(val);
	}
	
	var val = $( "#currencyUSDEquivalentAmt" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#currencyUSDEquivalentAmt" ).val(val);
	}
	
	var val = $( "#amendedUSDEquivalentAmt" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#amendedUSDEquivalentAmt" ).val(val);
	}
	
	var val = $( "#grossSettlementAmt" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#grossSettlementAmt" ).val(val);
	}
	
	var val = $( "#facilityIncDecAmt" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#facilityIncDecAmt" ).val(val);
	}
	
	var val = $( "#facilityIncDecUSDEquivalentAmt" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#facilityIncDecUSDEquivalentAmt" ).val(val);
	}
	
	var val = $( "#accruedInterestAmt" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#accruedInterestAmt" ).val(val);
	}
	
	var val = $( "#fees" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#fees" ).val(val);
	}
	
	var val = $( "#pandLAmt" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#pandLAmt" ).val(val);
	}
	
	var val = $( "#brokerageCostAmt" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#brokerageCostAmt" ).val(val);
	}
}


/**
 * Method to validate the Amendment
 * @returns {Boolean}
 */
function amendmentValidation () {
	var isvalid =true;
	$(".amendment-validation").find(".request-exp").each(function(){
		if($(this).val()!=''){
			$(this).parent().find(".req-error").remove();
		}else{
			$(this).parent().append("<span class='req-error'>error</span>");
			isvalid = false;
		}
	} );
	$(".amendment-validation .radio-container").each(function(){
		if($(this).find("input[type='radio']").is(":checked") == false){
			$(this).addClass("req-error");
		}else{
			$(this).removeClass("req-error");
		}
	});
	return isvalid;
}

function originalCCYValidate(validateflag){
	var originalCCY = $("#originalCCY").val();
	if(originalCCY == ""){
		$("#originalCCYValidateBar").show();
		validateflag = true;
	}else {
		$("#originalCCYValidateBar").hide();
	}
	var originalCCYAmount = $("#originalCCYAmount").val();
	var val = originalCCYAmount;
	val = val.replace(/,/g,"");
	originalCCYAmount = val;
	
	if(originalCCYAmount == "" || originalCCYAmount.match('^[0-9]*\.[0-9]*$')==null || parseFloat(originalCCYAmount) < 0){
		$("#originalCCYAmountValidateBar").show();
		validateflag = true;
	}else{
		$("#originalCCYAmountValidateBar").hide();
	}
	
	var USDEquivalent = $("#USDEquivalent").val();
	var val = USDEquivalent;
	if(val!=undefined){
	val = val.replace(/,/g,"");
	USDEquivalent = val;
	if(originalCCY != "" && originalCCYAmount != "" && (USDEquivalent == "" || parseFloat(USDEquivalent) <= 0)){
		$("#usdValidateBar").show();
		validateflag = true;
	}else{
		$("#usdValidateBar").hide();
	}
   }
	return validateflag;
}

function accuredAndFeesValidate(validateflag){
	
	var accruedInterestAmt = $("#accruedInterestAmt").val();
	var val = accruedInterestAmt;
	val = val.replace(/,/g,"");
	accruedInterestAmt = val;
	if(accruedInterestAmt == "" || accruedInterestAmt.match('^[0-9]*\.[0-9]*$')==null || parseFloat(accruedInterestAmt) < 0){
		$("#accruedInterestBar").show();
		validateflag = true;
	}else {
		$("#accruedInterestBar").hide();
	}
	
	var fees = $("#fees").val();
	var val = fees;
	val = val.replace(/,/g,"");
	fees = val;
	if(fees == "" || fees.match('^[0-9]*\.[0-9]*$')==null || parseFloat(fees) < 0){
		$("#feesBar").show();
		validateflag = true;
	}else {
		$("#feesBar").hide();
	}
	return validateflag;
}

/**
 * Hide the validation error Message
 */
function closeMessage(){
	$('#validateFlag').hide();
}

function closeConfirmModal() {
	$("#confirm").modal('hide');
}
function closeLookUpModal() {
	$("#lookup").modal('hide');
}
function closeConfirmModal() {
	$("#confirm").modal('hide');
}
function closeDerDeleteConfirmModal() {
	$("#derDeleteConfirm").modal('hide');
}

function originalTransactionUsdValidations(validateflag){
	var transactionId = $("#transactionId").val();

	if(transactionId == ""){
		$("#transactionIdBar").show();
		validateflag = true;
	}else $("#transactionIdBar").hide();
	
	var termInMonths = $("#termInMonths").val();
	if(termInMonths == "" || !(isNumber(termInMonths)) || parseInt(termInMonths) <= 0){
		$("#terminMonthsBar").show();
		validateflag = true;
	}else $("#terminMonthsBar").hide();
	
	var originalLegalAgreementsFlag = $('input[id=originalLegalAgreementsFlag]:checked').val();
	if(!(originalLegalAgreementsFlag == "1" || originalLegalAgreementsFlag == "0")){
		$("#originalLegalAgreementDiv").addClass("radio-container req-error");
		validateflag = true;
	}else {
		$("#originalLegalAgreementDiv").removeClass("req-error");
	}
	
	var isHedgedFlag = $('input[id=isHedgedFlag]:checked').val();
	if(!(isHedgedFlag == "1" || isHedgedFlag == "0")){
		$("#transHedgedDiv").addClass("radio-container req-error");
		validateflag = true;
	}else {
		$("#transHedgedDiv").removeClass("req-error");
	}
	
	validateflag = originalCCYValidate(validateflag);
	
	return validateflag;
}


function isLenderBorrowerSame(validateflag){
	var lendercdr = $('#lenderLegalEntityGoldId').val();
	var borrowercdr = $('#borrowerLegalEntityGoldId').val();
	if(borrowercdr != "" && lendercdr!=""){
		if(borrowercdr == lendercdr){
			$("#borrowerGoldIdInvalid").show();
			$("#borrowerInfofailedBar").show();
			validateflag = true;
		}else{
			$("#borrowerInfofailedBar").hide();
			$("#borrowerGoldIdInvalid").hide();
		}
	}
	return validateflag;
}

function isEntitesSameInAssignment(validateflag){
	validateflag = isLenderBorrowerSame(validateflag);
	
	if(!validateflag){
		var lendercdr = $('#lenderLegalEntityGoldId').val();
		var newLendercdr = $('#newLenderLegalEntityGoldId').val();
		var newBorrowercdr = $('#newBorrowerLegalEntityGoldId').val();
		var newLenderOrBorrower = $('input:radio[id=newLenderOrBorrower]:checked').val();
		if(newLenderOrBorrower!=undefined && newLenderOrBorrower == "true"){
			if(lendercdr!="" && newLendercdr!="" && lendercdr == newLendercdr){
				$("#newLenderDiffFailed").show();
				$("#newLenderInfofailedBar").show();
				validateflag = true;
			}else{
				$("#newLenderDiffFailed").hide();
				$("#newLenderInfofailedBar").hide();
			}
		}else if(newLenderOrBorrower!=undefined && newLenderOrBorrower == "false") {
			if(lendercdr!="" && newBorrowercdr!="" && lendercdr == newBorrowercdr){
				$("#newBorrowerGoldIdInvalid").show();
				$("#newBorrowerInfofailedBar").show();
				validateflag = true;
			}else{
				$("#newBorrowerGoldIdInvalid").hide();
				$("#newBorrowerInfofailedBar").hide();
			}
		}
	}
	return validateflag; 
}

function validateGoldId(validateflag){
	var lenderGoldId = $("#lenderLegalEntityGoldId").val();
	if(lenderGoldId == "" && $('input[id=lenderEntitySetupFlag]:checked').val()=="Y"){
		$("#lenderInfofailedBar").show();
		$("#lenIdReq").show();
		validateflag = true;
	}else if(lenderGoldId != ""){
		$("#lenderInfofailedBar").hide();
		$("#lenIdReq").hide();
	}
	
	var borrowerGoldId = $("#borrowerLegalEntityGoldId").val();
	if(borrowerGoldId == "" && $('input[id=borrowerEntitySetupFlag]:checked').val()=="Y"){
		$("#borrowerInfofailedBar").show();
		$("#borIdReq").show();
		validateflag = true;
	}else if(borrowerGoldId != ""){
		$("#borrowerInfofailedBar").hide();
		$("#borIdReq").hide();
	}
	return validateflag; 
}

function validateDerivative(validateflag){
	
	var derivativesFlag = $('input[id=derivativesFlag]:checked').val();
	if(!(derivativesFlag == "true" || derivativesFlag == "false")){
		$("#derivativDiv").addClass("radio-container derivativesConditional req-error");
		validateflag = true;
	}else {
		$("#derivativDiv").removeClass("req-error");
	}
	
	var derivativeCount = $("#derivativeCountID").val();
	if(derivativeCount!=null && derivativeCount<=0 && derivativesFlag == "true")
	{
		validateflag = true;
		$("#derFlagValidate").show();
	}else{
		$("#derFlagValidate").hide();
	}
	
	return validateflag; 
}

function setGoldIdValues(){
	document.getElementById("lenderOrProvider").value = $('#lenderOrProvider').val().toUpperCase();
	document.getElementById("borrowerOrRecipient").value = $('#borrowerOrRecipient').val().toUpperCase();
	
	$('#lenderOrProvider').val($('#LEGoldId').val());
	$('#borrowerOrRecipient').val($('#borLEGoldId').val());
	
	var newLender = $('#newLEGoldId').val();
	if(newLender!=undefined){
		$('#newLenderLEGoldId').val(newLender);
	}
	var newBorrower = $('#newBorLEGoldId').val();
	if(newBorrower!=undefined){
		$('#newBorrowerLEGoldId').val(newBorrower);
	}
	var payor = $('#payorLEGoldId').val();
	if(payor!=undefined){
		$('#payorGoldId').val(payor);
	}
}

function isDate(txtDate)  

{ 
	
  var currVal = txtDate;  
  if(currVal == ''){ 
    return false; 
  }
 //Declare Regex    
  var rxDatePattern = /^(\d{1,2})(\/|-)(\d{1,2})(\/|-)(\d{4})$/;   

  var dtArray = currVal.match(rxDatePattern); // is format OK?  
  if (dtArray == null){
	  return false;  
  }  
     
  //Checks for mm/dd/yyyy format.  
 dtMonth = dtArray[1];  
  dtDay= dtArray[3];  
  dtYear = dtArray[5];  

  if (dtMonth < 1 || dtMonth > 12){
	  return false;  
  }else if (dtDay < 1 || dtDay> 31){
	  return false;  
  }else if ((dtMonth==4 || dtMonth==6 || dtMonth==9 || dtMonth==11) && dtDay ==31){
	  return false;  
  }else if (dtMonth == 2){
 
     var isleap = (dtYear % 4 == 0 && (dtYear % 100 != 0 || dtYear % 400 == 0));  
     if (dtDay> 29 || (dtDay ==29 && !isleap))  
          return false;  
  }  
  return true;  

} 

function validateSubmit(moEvent, cmd){
	
	var actionType = $('input:radio[name=saveAction]:checked').val();
	if(actionType==undefined){
		$('#saveRadioDiv').addClass("req-error");
		return;
	}
	
	if(actionType == 'saveNextLeg'){
		cmd="?command=saveNextLeg&isFrontOffice=Yes";
	}else if(actionType == 'saveReturnDeal'){
		cmd="?command=saveAndReturnToDeal&isFrontOffice=Yes";
	}

	switch(moEvent){
		case 7://prepayment
		validatePrepayment(cmd);
		break;
		case 8:
		validateDrawDown(cmd);	
	    break;	
		case 5:
		validateAmendIncreaseDecrease(cmd);	
		break;
	}
   }

  function saveAsDraft(obj)
  {
	  var cmd="?command=saveAsDraft&isFrontOffice=Yes";
	  saveLeg(cmd);
  }