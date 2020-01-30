	/**
	 * Clear the fields for Payor
	 */
	function clearPayorTreasuryDetails(){
		$('#payorTreasuryDetails').hide();
		$("#payorTreasuryfailed").hide();
		$("#payorTreasuryfailedBar").hide();
		$("#payorTreasuryInvalid").hide();
	}
	
$(document).ready(function() {


	var dividendAmountId = $("#dividendAmountId").val();
	var originalCCY =  $("#originalCCY").val();
	if((dividendAmountId!=undefined && dividendAmountId!="") && (originalCCY!=undefined && originalCCY!="")){
		$('#usdEquiDiv').show();
	}
	showPayorDetails();
	$('.payorId').text("-");
	$('.payorSetUpPending').text("-");
	
	var grossAmt = $("#grossSettlementAmt").val();
	if(grossAmt!=undefined && grossAmt!=""){
		$('.grosssSet').text(commaSeperateAmt(grossAmt));
	}else {
		$('.grosssSet').text("-");
	}
	
	$("#dividendAmountId").change( function(e){
		var dividendAmount = $( "#dividendAmountId" ).val();
		if(dividendAmount!=undefined && isNumber(dividendAmount) && !(parseFloat(dividendAmount) < 0)) {
			var amount=0;
			dividendAmount = dividendAmount.replace(/,/g,"");
			amount = dividendAmount;
			$("#grossSettlementAmt").val(amount);
			$('.grosssSet').text(commaSeperateAmt(amount+""));
		}
	});
	
	var isNonStandardLegalAgreement = $('input:radio[id=isNonStandardLegalAgreementId]:checked').val(); 
	if(isNonStandardLegalAgreement!=undefined){
		if(isNonStandardLegalAgreement == "true"){
			$('#exceptionDiv').show();
		}else if(isNonStandardLegalAgreement == "false"){
			$('#exceptionDiv').hide();
		}
	}
	
	$("#payorEntitySetupFlag").click( function(e){
		payorOnClick();
	});
	
	lenderOnclick();
	borrowerOnClick();
	
	var lenderGoldId = $("#LEGoldId").val();
	if(lenderGoldId!=undefined && lenderGoldId!=""){
		$('#lenderGoldIdDetails').show();
		$('#lenderCapitalDiv').show();
		$('#lenderOrProvider').val("");
		$('#orgLenderClear').show();
	}
	var borrowerGoldId = $("#borLEGoldId").val();
	if(borrowerGoldId!=undefined && borrowerGoldId!=""){
		$('.payorSetUpPending').text("No");
		$('.payorId').text(borrowerGoldId);
		$('#borrowerGoldIdDetails').show();
		$('#borrowerCapitalDiv').show();
		$('#borrowerOrRecipient').val("");
		$('#orgBorrowerClear').show();
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
			//$("#payorBusSegTDiv").show();
			//$("#payorBusSegFDiv").hide();
			
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
			//$("#payorBusSegTDiv").hide();
			//$("#payorBusSegFDiv").show();
			
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

	function formatMoney(val, c, d, t){
		var i = val, c = isNaN(c = Math.abs(c)) ? 2 : c, d = d == undefined ? "," : d, t = t == undefined ? "." : t,  j = (j = i.length) > 3 ? j % 3 : 0;
	   return  (j ? i.substr(0, j) + t : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + t);
	};


	var amount = $("#dividendAmountId").val();
	if(amount!="" && amount!=null){
		$("#dividendAmountId").val(commaSeperateAmt(amount));
	}

	
	
	
	$("#lenderEntitySetupFlag").click( function(e){
		lenderOnclick();
	});
	$("#borrowerEntitySetupFlag").click( function(e){
		borrowerOnClick();
	});	
	
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
			//$("#lenBusSegTDiv").show();
			//$("#lenBusSegFDiv").hide();
			
			$(".condition-lenderReg").show();
			$(".condition-lenderPrn").show();
			//var isDrawdown = $("#isDrawdown").val();
			//if(isDrawdown!=undefined && isDrawdown=="drawdown"){
			//	$('.payorId').text("-");
			//	$('.payorSetUpPending').text("Yes");
			//}
			$("#LEGoldId").val("");
		}else{
			$("#lenderOrProvider").removeAttr("disabled");
			$("#lenderTreasuryCode").removeAttr("disabled");
			$("#searchByLenderGoldId").removeAttr("disabled");
			$('#searchByLenderTreasury').removeAttr("disabled");
			$('#lenderSearchId').removeAttr("disabled");
			
			$("#LenderSetUpFlagTDiv").hide();
			$("#LenderSetUpFlagFDiv").show();
			//$("#lenBusSegTDiv").hide();
			//$("#lenBusSegFDiv").show();
			
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
			$("#borrowerTreasuryDetails").hide();
			$("#clearBorrowerTCode").hide();
			$(".condition-borrowerReg").show();
			$(".condition-borrowerPrn").show();
			
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
			//$("#borBusSegTDiv").hide();
			//$("#borBusSegFDiv").show();

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

$("#borrowerOrRecipient").change( function(e){
	showPayorDetails();
});

});

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

function validateLegDividends(cmd){
	var validateflag = false;
	$('#genericErrorComment').hide();	
	
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
	
	var lenderMgmtEntity = $("#selectedLenderMgmtEntity").val();
	if(lenderMgmtEntity == ""){
		$("#lenderMgmtfailedBar").show();
		validateflag = true;
	}else {
		$("#lenderMgmtfailedBar").hide();
	}

	var borrowerMgmtEntity = $("#selectedBorrowerMgmtEntity").val();
	if(borrowerMgmtEntity == ""){
		$("#borrowerMgmtfailedBar").show();
		validateflag = true;
	}else {
		$("#borrowerMgmtfailedBar").hide();
	}

	var subordinatedDebt = $('input:radio[id=subordinatedDebtId]:checked').val();
	if(!subordinatedDebt){
		$("#subordinatedDebtErrorBar").addClass("req-error");
		validateflag = true;
	}else {
		$("#subordinatedDebtErrorBar").removeClass("req-error");
	}

	var crossBorderFlag =  $('input:radio[id=crossBorderFlagId]:checked').val();

	if(!crossBorderFlag){
		$('#crossBorderFlagErrorBar').addClass("req-error");
		validateflag = true;
	}else {
		$("#crossBorderFlagErrorBar").removeClass("req-error");
	}
	
	var isNonStandardLegalAgreement =  $('input:radio[id=isNonStandardLegalAgreementId]:checked').val();
	if(!isNonStandardLegalAgreement){
		$('#isNonStandardLegalAgreementErrorBar').addClass("req-error");
		validateflag = true;
	}else {
		$("#isNonStandardLegalAgreementErrorBar").removeClass("req-error");
		if(isNonStandardLegalAgreement == "true"){
			if( exceptionValidation() ){
			}else{
				validateflag = true;
			}
		}
	}
	
	validateflag = originalCCYValidate(validateflag);

	var isVisible = false;
	$('.invalid').each(function(){
		if($('.invalid').is(":visible")){
			isVisible = $('.invalid').is(":visible");
		}
	});
	
	
	if(cmd == 'frontOffice'){
		validateflag = qualitativeFactorValidations(validateflag);
	}
	validateflag = checkME(validateflag);
 	

	if(validateflag){
		$(window).scrollTop(100);
		$('#genericErrorComment').show();
	}else{	
		if(!isVisible){
			var val = $( "#dividendAmountId" ).val();
			if(val!=undefined){
				val = val.replace(/,/g,"");
				$( "#dividendAmountId" ).val(val);
				$( "#grossSettlementAmt" ).val(val);
			}
			
			val = $( "#dayOneCCYAmount" ).val();
			if(val!=undefined && val != ""){
				val = val.replace(/,/g,"");
				$( "#dayOneCCYAmount" ).val(val);
				$("#dayOneAmtBar").hide();
			}else{
				$("#dayOneAmtBar").show();
				validateflag = true;
			}
			document.getElementById("lenderOrProvider").value = $('#lenderOrProvider').val().toUpperCase();
			document.getElementById("borrowerOrRecipient").value = $('#borrowerOrRecipient').val().toUpperCase();
			
			$('#lenderOrProvider').val($('#LEGoldId').val());
			$('#borrowerOrRecipient').val($('#borLEGoldId').val());
			
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
			
			if(cmd == 'frontOffice'){
				var actionType = $('input:radio[name=saveAction]:checked').val();
				if(actionType==undefined){
					$('#saveRadioDiv').addClass("req-error");
					return;
				}
				if(actionType == 'saveNextLeg'){
					document.forms[0].action = servletContextUrl + '/frontoffice/RCALegRequest.do?command=saveNextLeg&isFrontOffice=Yes';
				}else if(actionType == 'saveReturnDeal'){
					document.forms[0].action = servletContextUrl + '/frontoffice/RCALegRequest.do?command=saveAndReturnToDeal&isFrontOffice=Yes';
				}
				
			}else{
				document.forms[0].action = servletContextUrl + '/RCALegRequest.do?command=saveAndReturnToDeal';
			}
			document.forms[0].submit();
		}else{
			$(window).scrollTop(100);
			$('#genericErrorComment').show();
		}
	}
	
	$('textarea').keyup(function() {
		var len = this.value.length;
		if (len >= 999) {
			this.value = this.value.substring(0, 1000);
		}
	});
}

function saveLeg(){
	var val = $( "#dividendAmountId" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#dividendAmountId" ).val(val);
	}

	document.getElementById("lenderOrProvider").value = $('#lenderOrProvider').val().toUpperCase();
	document.getElementById("borrowerOrRecipient").value = $('#borrowerOrRecipient').val().toUpperCase();
	
	$('#lenderOrProvider').val($('#LEGoldId').val());
	$('#borrowerOrRecipient').val($('#borLEGoldId').val());
	
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
	
	document.forms[0].action = servletContextUrl + '/RCALegRequest.do?command=saveAsDraft';
	document.forms[0].submit();
}

function saveFOLeg(){
	var val = $( "#dividendAmountId" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#dividendAmountId" ).val(val);
	}

	document.getElementById("lenderOrProvider").value = $('#lenderOrProvider').val().toUpperCase();
	document.getElementById("borrowerOrRecipient").value = $('#borrowerOrRecipient').val().toUpperCase();
	
	$('#lenderOrProvider').val($('#LEGoldId').val());
	$('#borrowerOrRecipient').val($('#borLEGoldId').val());
	
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
	
	document.forms[0].action = servletContextUrl + '/frontoffice/RCALegRequest.do?command=saveAsDraft&isFrontOffice=Yes';
	document.forms[0].submit();
}






function cancel(){
	var val = $( "#dividendAmountId" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#dividendAmountId" ).val(val);
	}

	document.forms[0].action = servletContextUrl + '/RCALegRequest.do?command=redirectFundingRequest';
	document.forms[0].submit();
}

/**
 * Method to redirectFundingRequest
 * @param cmd
 */
function redirectFundingRequest(cmd){
	
	var val = $( "#dividendAmountId" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#dividendAmountId" ).val(val);
	}
	
	var RCALegRequestForm = document.getElementById('ICFPLegRequestForm');
	var action = RCALegRequestForm.action;
	action = action+cmd; 
	RCALegRequestForm.action = action;
	RCALegRequestForm.submit();
}

function commaSeperate(value){
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
	$("#dividendAmountId").val( value );
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

function originalCCYValidate(validateflag){
	var originalCCY = $("#originalCCY").val();
	if(originalCCY == ""){
		$("#originalCCYValidateBar").show();
		validateflag = true;
	}else {
		$("#originalCCYValidateBar").hide();
	}
	var originalCCYAmount = $("#dividendAmountId").val();
	var val = originalCCYAmount;
	if(val!= undefined){
		val = val.replace(/,/g,"");
		originalCCYAmount = val;
		if(originalCCYAmount == "" || originalCCYAmount.match('^[0-9]*\.[0-9]*$')==null || parseFloat(originalCCYAmount) < 0){
			$("#dividendAmountErrorBar").show();
			validateflag = true;
		}else{
			$("#dividendAmountErrorBar").hide();
		}
	}
	
	
	var USDEquivalent = $("#USDEquivalent").val();
	var val = USDEquivalent;
	if(val!= undefined){
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

function qualitativeFactorValidations(validateflag){
	
	//validations for 5 qualitative factors
	if(!radioMandatory($('input[id=qualitativeFactor5]:checked'),$('#qFIdErrorSpan5'),$('#qFIdErrorDiv5'))){
		validateflag = true;
	}
	if(!valueRequired($('#qualitativeFactorComment5'),$('#qualitativeFactorCommentFailedBar5'),$('input[id=qualitativeFactor5]:checked'))){
		validateflag = true;
	}
	if(!radioMandatory($('input[id=qualitativeFactor1]:checked'),$('#qFIdErrorSpan1'),$('#qFIdErrorDiv1'))){
		validateflag = true;
	}
	if(!valueRequired($('#qualitativeFactorComment1'),$('#qualitativeFactorCommentFailedBar1'),$('input[id=qualitativeFactor1]:checked'))){
		validateflag = true;
	}
	if(!radioMandatory($('input[id=qualitativeFactor2]:checked'),$('#qFIdErrorSpan2'),$('#qFIdErrorDiv2'))){
		validateflag = true;
	}
	if(!valueRequired($('#qualitativeFactorComment2'),$('#qualitativeFactorCommentFailedBar2'),$('input[id=qualitativeFactor2]:checked'))){
		validateflag = true;
	}
	if(!radioMandatory($('input[id=qualitativeFactor3]:checked'),$('#qFIdErrorSpan3'),$('#qFIdErrorDiv3'))){
		validateflag = true;
	}
	if(!valueRequired($('#qualitativeFactorComment3'),$('#qualitativeFactorCommentFailedBar3'),$('input[id=qualitativeFactor3]:checked'))){
		validateflag = true;
	}
	if(!radioMandatory($('input[id=qualitativeFactor4]:checked'),$('#qFIdErrorSpan4'),$('#qFIdErrorDiv4'))){
		validateflag = true;
	}
	if(!valueRequired($('#qualitativeFactorComment4'),$('#qualitativeFactorCommentFailedBar4'),$('input[id=qualitativeFactor4]:checked'))){
		validateflag = true;
	}
	
	return validateflag;
}

/**
 * Validation: radio button selection manatory 
 * @param id
 * @param messageSpan
 * @param errorDiv
 * @returns {Boolean}
 */
function radioMandatory(id,messageSpan,errorDiv){
	var radioValue =  id.val();
	if(!(radioValue == "0" || radioValue == "1" || radioValue == "2" || radioValue == "3" || radioValue == "Yes" || radioValue == "No" )){
		
		messageSpan.show();
		errorDiv.addClass("radio-container req-error");
		return false;
	}else {
	
		messageSpan.hide();
		errorDiv.removeClass("radio-container req-error");
		return true;
	}
}
/**
 * Mandatory field validation
 * @param id
 * @param errorBarSpan
 * @returns {Boolean}
 */
function valueRequired(id,errorBarSpan,selectedRadio){
	var required = id.val();
	var radioValue = selectedRadio.val();
	
	if(required == '' || required==null || required==undefined){
		if(radioValue == '1' || radioValue == '2') 
		{
			errorBarSpan.show();
			return false;
		}else{
			errorBarSpan.hide();
			return true;
		}
		
	}else {
		errorBarSpan.hide();
		return true;
	}
	
}
