/**
 * This method is used to set the values to the jsp during onload.
 */
$(document).ready(function(){

	var lenderGoldId = $("#lenderOrProvider").val();
	if(lenderGoldId!=""){
		$('#participantDetailsDiv').show();
	}
	var cashPoolNameId = $("#cashPoolNameId").text();
	if(cashPoolNameId!=""){
		$('#poolLeaderIdDetails').show();
	}
	
	$("#poolLeaderEntityId").click(function(){
		$("#poolLeaderEntityErrorId").hide();	
		var actionId = $("#actionId").val();
		
		var regionCode = $("#regionId option:selected").val();
		var countryCode = $("#countryId option:selected").val();
		var currencyCode = $("#currencyId option:selected").val();
		var regionText = $("#regionId option:selected").text();
		var countryText = $("#countryId option:selected").text();
		var currencyText = $("#currencyId option:selected").text();
		var poolTreasuryCode = $("#poolTreasuryCodeID").val();
		
		var url= contextURL+"/CPALegRequest.do?command=getPoolLeaderEntites";
		$.post(url, {region:regionCode,country:countryCode,currency:currencyCode,regionLabel:regionText,countryLabel:countryText,currencyLabel:currencyText,tCode:poolTreasuryCode,actionId:actionId},function(data){
			var content = $(data).find('#cashPoolID');
			$("#cashPoolID").empty().append( content.html() );
			gotoPage(1);
		});

	});
	
	$("#regulatedEntityFlag1").attr("disabled", "disabled");
	$("#regulatedEntityFlag2").attr("disabled", "disabled");
	$("#princplEntityFlag1").attr("disabled", "disabled");
	$("#princplEntityFlag2").attr("disabled", "disabled");
	
	$("#saveSelectionId").click(function(e){
		e.preventDefault();
		$("#poolLeaderEntityErrorId").hide();
		
		var actionId = $("#actionId").val();
		var cpName = $("input[name='cashPoolOptions']:checked").val();
		if(cpName == undefined){
			$('#cashpoolSelect').show();
			$('#poolLeaderIdDetails').hide();
			$('#leader-search-results').show();
		}else {
			$('#cashpoolSelect').hide();
			var clearResults = $(this).siblings('.clear-conditional-results:hidden');
			clearResults.show();
	        
			var url= contextURL+"/CPALegRequest.do?command=getPoolLeaderDetailas";
			$.post(url, {accountId:cpName,actionId:actionId},function(data){
					var content = $(data).find('#poolLeaderIdDetails');
					$("#poolLeaderIdDetails").empty().append( content.html() );
					
					
					$('#poolLeaderIdDetails').show();
					$('#leader-search-results').hide();
					$("#regionId").val("0");
					$("#countryId").val("0");
					$("#currencyId").val("0");
			});
		}
	});
	
	var isNonStandardLegalAgreement = $('input[id=isNonStandardLegalAgreement]:checked').val();
	if(isNonStandardLegalAgreement == "true"){
		$('#exceptionDiv').show();
	}else {
		$('#exceptionDiv').hide();
	}
	
	var lenderTreasuryCode = $("#showTreasuryCode").val();
	
	if(lenderTreasuryCode){
		$('#lenderTreasuryDetails,#clearCPALenderTreasuryFO').show();
	}else{
		$('#lenderTreasuryDetails,#clearCPALenderTreasuryFO').hide();
	}
	var praticipantCodesExists = $("#praticipantCodesExists").val();
	if(praticipantCodesExists!="false")
	{
	   $('#lenderTreasuryDetails').show();
	}else{
		$('#lenderTreasuryDetails').hide();
	}
	
	$("#searchByParticipant").click( function(e){
		e.preventDefault();
		
		var lenderGoldId = $("#lenderOrProvider").val();
		
		var searchID = $("#searchID").val();
		
		$("#participantDetailsDiv").val("");
		if(lenderGoldId == ""){
			$("#lenderInfofailed").show();
			$("#lenderInfoInvalid").hide();
			$("#lenderInfofailedBar").show();
			$("#lenderDiffFailed").hide();
			return false;
		}else {
			$('#clearParIdDiv').show();
			var clearResults = $(this).siblings('.clear-conditional-results:hidden');
			clearResults.show();
			$("#lenderInfofailed").hide();
			$("#lenderInfofailedBar").hide();
			
			url = contextURL +"/CPALegRequest.do?command=getGoldIdDetails";
			$.post( url, {lenderOrProvider: lenderGoldId,goldIdFlag:"lenderDetails",participantCode:searchID},
					function(data){
					var content = $(data).find('#participantDetailsDiv');
					
					$("#participantDetailsDiv").empty().append( content.html() );
					var a = $(data).find("#lenderLegalEntityGoldId");
					
					var content2 = $(data).find('#lenBusSegDiv');
					$("#lenBusSegDiv").empty().append( content2.html() );
					
					var content1 = $(data).find('#lenderCapitalDiv');
					$("#lenderCapitalDiv").empty().append( content1.html() );
					
					var content3 = $(data).find('#lenderPEorMEDiv');
					$("#lenderPEorMEDiv").empty().append( content3.html() );
										
					if( a.val() == "" ){
						$("#lenderInfoInvalid").show();
						$("#lenderInfofailedBar").show();
						$('#participantDetailsDiv').hide();
						$("#lenderDiffFailed").hide();
						$("#lenderPEorMEDiv").hide();
						clearResults.hide();
					}else {
						$("#lenderInfofailed").hide();
						$("#lenderInfoInvalid").hide();
						$("#lenderInfofailedBar").hide();
						$('#participantDetailsDiv').show();
						$("#lenderDiffFailed").hide();
						$("#LenderSetUpFlagFDiv").show();
						$("#lenBusSegFDiv").show();
						$("#lenderPEorMEDiv").show();
						$("#regulatedEntityFlag1").attr("disabled", "disabled");
						$("#regulatedEntityFlag2").attr("disabled", "disabled");
						$("#princplEntityFlag1").attr("disabled", "disabled");
						$("#princplEntityFlag2").attr("disabled", "disabled");
					}
			});
		}
	});
	
	participantClick();
	
	$("#lenderEntitySetupFlag").click( function(e){
		participantClick();
	});
	
	function participantClick(){
		if($('input[id=lenderEntitySetupFlag]:checked').val()=="Y"){
			$("#lenderOrProvider").val("");
			$('#participantDetailsDiv').hide();
			$("#lenderOrProvider").attr("disabled", "disabled");
			$("#searchID").attr("disabled", "disabled");
			$('#lenderTreasuryDetails').hide();
			$("#lenderTreasuryCode").val("");
			$("#lenderTreasuryCode").attr("disabled", "disabled");
			$('#searchByLenderTreasuryFO').attr("disabled", "disabled");
			$('#searchByParticipant').attr("disabled", "disabled");
			$('#clearParIdDiv').hide();
			$("#clearLenderTreasury").hide();
			$('#lenderLegalEntityGoldId').val("");
			$("#regulatedEntityFlag1").removeAttr("disabled");
			$("#regulatedEntityFlag2").removeAttr("disabled");
			$("#princplEntityFlag1").removeAttr("disabled");
			$("#princplEntityFlag2").removeAttr("disabled");
			
			$("#LenderSetUpFlagTDiv").show();
			$("#LenderSetUpFlagFDiv").hide();
			$("#lenBusSegTDiv").show();
			$("#lenBusSegFDiv").hide();
			$("#LEGoldId").val("");
			
			$(".condition-lenderReg").show();
			$(".condition-lenderPrn").show();
		}else
			{
			$("#lenderOrProvider").removeAttr("disabled");
			$("#lenderTreasuryCode").removeAttr("disabled");
			$("#searchByLenderGoldId").removeAttr("disabled");
			$('#searchByLenderTreasuryFO').removeAttr("disabled");
			$('#searchByParticipant').removeAttr("disabled");
			$("#searchID").removeAttr("disabled");
			$("#LenderSetUpFlagTDiv").hide();
			$("#LenderSetUpFlagFDiv").show();
			$("#lenBusSegTDiv").hide();
			$("#lenBusSegFDiv").show();
			
			$(".condition-lenderReg").hide();
			$(".condition-lenderPrn").hide();

			var lenderGoldId = $("#lenderLegalEntityGoldId").val();
			if(lenderGoldId!=""){
				$("#regulatedEntityFlag1").attr("disabled", "disabled");
				$("#regulatedEntityFlag2").attr("disabled", "disabled");
				$("#princplEntityFlag1").attr("disabled", "disabled");
				$("#princplEntityFlag2").attr("disabled", "disabled");
			}
		}
	}
	
	
	$("#lenderOrProvider").keypress( function(e){
		if (e.which == 13){
			e.preventDefault();
			$("#searchByParticipant").click();
		}
	});
	
	$("#searchByLenderTreasuryFO").click( function(e){
		e.preventDefault();
		
		var lenderTreasuryCode = $("#lenderTreasuryCode").val();
		var lenderOrProvider = $("#lenderOrProvider").val();
		var mename = $("#selectedLenderMgmtEntity").val(); 
		if(lenderTreasuryCode == ""){
			$("#lenderTreasuryfailed").show();
			$("#lenderTreasuryfailedBar").show();
			$('#lenderTreasuryDetails').hide();
			$("#lenderTreasuryInvalid").hide();
			return false;
		}else {
			$("#lenderTreasuryfailed").hide();
			$("#lenderTreasuryfailedBar").hide();

			//check for duplicate
			var  tcodes = $("#lenderTreasuryDetails").find("input[name='participantTCodeEntities']");
			var isDuplicate = false;
			$(tcodes).each( function(){
				if(lenderTreasuryCode === $(this).val() ){
					isDuplicate = true;
					return true;
				}					
			});

			if(isDuplicate){
				$("#lenderTreasuryfailedBar").show();
				$("#lenderTreasuryDuplicate").show();
				return
			}else{
				$("#lenderTreasuryfailed").hide();
				$("#lenderTreasuryfailedBar").hide();
				$("#lenderTreasuryDuplicate").hide();
			}
			
			url = contextURL +"/CPALegRequest.do?command=getTCodeDetails";
			$("#lenderTreasuryCode").addClass("loading");
			$.post( url, {lenderTreasuryCode: lenderTreasuryCode,goldIdFlag:"lenderTCode",LEGoldId:lenderOrProvider,MEName:mename},
					function(data){
					var content = $(data).find('#lenderTreasuryDetails');
					
					$("#lenderTreasuryDetails").empty().append( content.html() );
					$("#lenderTreasuryDetails").show();
					$("#clearCPALenderTreasuryFO").show();
					
			})
			.complete(function(){
				$("#lenderTreasuryCode").removeClass("loading");
			});		
		}
	});
	
	
	$("#lenderTreasuryCode").keypress( function(e){
		if (e.which == 13){
			e.preventDefault();
			$("#searchByLenderTreasuryFO").click();
		}
	});
	
	
});

/**
 * This method is used to show the red strip for every component during validation.
 * @param id
 * @param msg
 */
function addErrorMessage(id, msg){
	$(id).find("span.errmsg").remove();
	var a = document.createElement("span");
	$(a).addClass('errmsg');
	$(a).css({'color':'#bf2f24', 'font-family':'Arial', 'font-weight':'bold', 'font-size':'11px', 'margin-left':'10px'});
	$(a).text( msg );
	$(id).prepend(a);
}

/**
 * This method is used to removed the red strip for every component
 * @param id
 */
function removeErrorMessage(id){
	$(id).find("span.errmsg").remove();
}

/**
 * This method is used to redirect 
 */
function redirectFundingRequest(cmd){
	removeAmountShortcuts();
	var RCALegRequestForm = document.getElementById('cpaLegRequestForm');
	var action = RCALegRequestForm.action;
	action = action+cmd+"&productType=CPA";
	RCALegRequestForm.action = action;
	RCALegRequestForm.submit();
}

/**
 * This method is used to clear the treasury details.
 */
function clearTreasuryDetails(){
	$('#lenderTreasuryDetails').hide();
	$("#lenderTreasuryfailed").hide();
	$("#lenderTreasuryfailedBar").hide();
	$("#lenderTreasuryInvalid").hide();
}

/**
 * This method is used to validate the fields as per the business functionality
 * @param cmd
 */
function validate(cmd){
	var validateflag = false;
	//particepent Gold id
	var lenderGoldId = $("#lenderLegalEntityGoldId").val();
	if(lenderGoldId == "" && !($('input[id=lenderEntitySetupFlag]:checked').val()=="Y")){
		$("#lenderInfofailedBar").show();
		validateflag = true;
		$("#lenderRegDiv").removeClass("req-error");
		$("#lenderPriDiv").removeClass("req-error");
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
	//Management entity
	var lenderMgmtEntity = $("#selectedLenderMgmtEntity").val();
	if(lenderMgmtEntity == ""){
		$("#lenderMgmtfailedBar").show();
		validateflag = true;
	}else {
		$("#lenderMgmtfailedBar").hide();
	}
	//NonStandardLegalAgreement
	var isNonStandardLegalAgreement = $('input[id=isNonStandardLegalAgreement]:checked').val();
	if(!(isNonStandardLegalAgreement == "true" || isNonStandardLegalAgreement == "false")){
		$("#legalAgreementDiv").addClass("radio-container exceptionsConditional req-error");
		validateflag = true;
	}else {
		$("#legalAgreementDiv").removeClass("req-error");
	}
	
	var termInMonths = $("#termInMonths").val();
	if(termInMonths == ""){
		$("#termValidateBar").show();
		$("#termValidateNumber").hide();
		validateflag = true;
	}else {
		if(isDecimalNumber(termInMonths) && !(parseFloat(termInMonths) <= 0)) {
			$("#termValidateNumber").hide();
		 }else{
			$("#termValidateNumber").show();
			validateflag = true;
		 }
		$("#termValidateBar").hide();
	}
	
	//cross board
	var isCrossBorderFlag = $('input[id=crossBorderFlagId]:checked').val();
	if(!(isCrossBorderFlag == "true" || isCrossBorderFlag == "false")){
		$("#crossBoarderDiv").addClass("radio-container exceptionsConditional req-error");
		validateflag = true;
	}else {
		$("#crossBoarderDiv").removeClass("req-error");
	}	
	
	validateflag = validateRegionData(validateflag);
	
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
	if(isNonStandardLegalAgreement == "true"){
		var exceptionComments = $("#exceptionComments").val();
		if( exceptionValidation() ){
		}else{
			validateflag = true;
		}
		if(exceptionComments == ""){
			$("#exceptionCommentsBar").show();
			validateflag = true;
		}else {
			$("#exceptionCommentsBar").hide();
		}
	}

	$('.me-lookup').each( function(){
		var e = $(this).siblings(".error");
		if( $(e).is(":visible") ){
			validateflag = true;
		}
	})


	if(validateflag == false){
		
		var regionText = $("#regionId option:selected").text();
		var countryText = $("#countryId option:selected").text();
		var currencyText =$("#currencyId option:selected").text();
		
		document.forms[0].elements("cpaSummary.region").value = document.forms[0].elements("region").value;
		document.forms[0].elements("cpaSummary.country").value = document.forms[0].elements("country").value;
		document.forms[0].elements("cpaSummary.currencyCd").value = document.forms[0].elements("currencyCd").value;
		if(!($('input[id=lenderEntitySetupFlag]:checked').val()=="Y")){
			$("#lenderEntitySetupFlag").val("N");
		}else{
			$("#lenderEntitySetupFlag").val("Y");
		}
		removeAmountShortcuts();
		$("#lenderOrProvider").removeAttr("disabled");
		var lenderEntitySetupFlag = $('input[id=lenderEntitySetupFlag]:checked').val();
		if(lenderEntitySetupFlag==null || lenderEntitySetupFlag == "" || lenderEntitySetupFlag == undefined)
		{
			$('input[id=lenderEntitySetupFlag]').attr('checked', true);
			$("#lenderEntitySetupFlag").val("N");
		}
		
		var CPALegRequestForm = document.getElementById('cpaLegRequestForm');
		var action = CPALegRequestForm.action;
		action = action+cmd; 
		CPALegRequestForm.action = action;
		CPALegRequestForm.submit();
		
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}

}

/**
 * This method is used to submit the form when save as draft button is pressed.
 * @param cmd
 */
function saveAsDraft(cmd){
	
	document.forms[0].elements("cpaSummary.region").value = document.forms[0].elements("region").value;
	document.forms[0].elements("cpaSummary.country").value = document.forms[0].elements("country").value;
	document.forms[0].elements("cpaSummary.currencyCd").value = document.forms[0].elements("currencyCd").value;
	
	if(!($('input[id=lenderEntitySetupFlag]:checked').val()=="Y")){
		document.getElementById("lenderEntitySetupFlag").value="N";
	}else{
		document.getElementById("lenderEntitySetupFlag").value="Y";
	}

	removeAmountShortcuts();
	
	$("#lenderOrProvider").removeAttr("disabled");
	
	var lenderEntitySetupFlag = $('input[id=lenderEntitySetupFlag]:checked').val();
	
	if(lenderEntitySetupFlag==null || lenderEntitySetupFlag == "" || lenderEntitySetupFlag == undefined)
	{
		$('input[id=lenderEntitySetupFlag]').attr('checked', true);
		$("#lenderEntitySetupFlag").val("N");
	}
	
	var CPALegRequestForm = document.getElementById('cpaLegRequestForm');
	var action = CPALegRequestForm.action;
	action = action+cmd; 
	CPALegRequestForm.action = action;
	CPALegRequestForm.submit();
}

/**
 * This method is used to show error strip for pool lender entity
 * @param validateflag
 * @returns
 */
 function validateRegionData(validateflag)
 {
	 
	 var poolLeGoldId = $("#poolLeGoldId").val();
	 if(poolLeGoldId==""){
		
		var regionIDValue = $("#regionID").val();
		if(regionIDValue==null || regionIDValue == ""){
			$("#poolLeaderEntityErrorId").show();
			validateflag = true;
		}else{
			$("#poolLeaderEntityErrorId").hide();
		}
			
		var countryIDValue = $("#countryID").val();
		if(countryIDValue==null || countryIDValue == ""){
			$("#poolLeaderEntityErrorId").show();
			validateflag = true;
		}else{
			$("#poolLeaderEntityErrorId").hide();
		}
				
		var currencyCdIDValue = $("#currencyCdID").val();
		if(currencyCdIDValue==null || currencyCdIDValue == ""){
			$("#poolLeaderEntityErrorId").show();
			validateflag = true;
		}else{
			$("#poolLeaderEntityErrorId").hide();
		}
 	}
	return validateflag;
 }
/**
 * This method is used to submit the form when we want to removed exceptions.
 * @param id
 */
function removeException(id){
	var fundingRequestForm = document.getElementById('cpaLegRequestForm');
	var legNumber = fundingRequestForm.legNumber;
	var rowNumber = id.rowIndex/3;
	var exceptionNumber = document.getElementById('exceptionIndex').value;
	
	fundingRequestForm.action =  contextURL+"/CPALegRequest.do?command=deleteException&legNumber=" + legNumber + "&exceptionNumber=" + exceptionNumber;
	fundingRequestForm.submit();
	
}

/**
 * This method is used to add exception details when add exception button is pressed.
 * @param rowNumber
 */
function addExceptionDetails(rowNumber) {
	
	var cmd="?command=addExceptionDetails";
	isChanged = false;
	var RCALegRequestForm = document.getElementById('cpaLegRequestForm');
	
	
	var action = RCALegRequestForm.action;
	var legNumber = RCALegRequestForm.legNumber.value;
	action = action+cmd+"&legNumber="+legNumber+"&sid="+Math.random(); 
   
    if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
		req.onreadystatechange = reportStatusExceptionAdd;
		try {
			req.open("GET", action, false);
		} catch (e) {
			alert(e);
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
 * This method is used to show the report status
 */
function reportStatusExceptionAdd() {
	if (req.readyState == 4) {
		if (req.status == 200) { 
			var RCALegRequestForm = document.getElementById('cpaLegRequestForm');
			var exceptionIndexElementList = RCALegRequestForm.elements["exceptionIndex"];
			if(exceptionIndexElementList == undefined){
				exceptionIndexElementList = RCALegRequestForm.elements["exceptionIndex1"];
			}
			
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

/**
 * This method is used to deleted the exception from the exception table.
 * @param x
 */
function deleteExceptionDetails(x) {
	
	var cmd="?command=deleteExceptionDetails";
	isChanged = false;
	var RCALegRequestForm = document.getElementById('cpaLegRequestForm');
	var action = RCALegRequestForm.action;
	var legNumber = RCALegRequestForm.legNumber.value;
	// exceptionNumber = RCALegRequestForm.exceptionIndex.value;
	var exceptionNumber = x;
	//alert("exceptionIndex :::"+ exceptionNumber + "Leg Number::::"+ legNumber);
	action = action+cmd+"&legNumber="+legNumber+"&exceptionNumber="+exceptionNumber+"&sid="+Math.random(); 
    if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
		req.onreadystatechange = reportStatusException;
		try {
			req.open("GET", action, false);
		} catch (e) {
			alert(e);
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

/**
 * Need to be implemented later.
 */
function reportStatusException() {
	if (req.readyState == 4) {
		if (req.status == 200) {/* 
			var str = req.responseText;
			
			if(document.getElementById("exceptionIndex").length ==undefined) {
				 $("#exceptionIndex").val(str);
			} else {
				 $("#exceptionIndex")[str - 1].val(str);
			} 
			*/}
		
	}
}

/**
 * Clear the fields for the Participant for the Gold Id
 */
function clearLEDetails(){
	$('#lenderOrProvider').val("");
	$("#lenderEntitySetupFlag").removeAttr("checked");
	$("#lenderInfofailed").val("");
	$("#lenderInfofailed").hide();
	$("#lenderInfofailedBar").hide();
	$("#lenderInfoInvalid").hide();
	
	$("#participantDetailsDiv").hide();
	
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
 * This method is used to resize the text areas.
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
 * This method is used to change the counter value in text areas.
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

/**
 * This method is used to check the given value contains expected characters.
 * @param val
 * @returns {Boolean}
 */
function isDecimalNumber(val) {
	var numericExpression = /^[0-9.]+$/;

	if(val.match(numericExpression)) {

	return true;

	} else {

	return false;

	}
}

/**
 * This method is used for count left in text areas.
 * @param field
 * @param count
 * @param max
 */
function CountLeft(field, count, max) {
	if (field.value!=null && field.value.length > max)
		field.value = field.value.substring(0, max);
	else
		count.value = max - field.value.length;
}

/**
 * This method is used to handle count in text areas.
 * @param field
 * @param countfield
 * @param maxlimit
 */
function textCounter(field, countfield, maxlimit) {
	if (field.value.length > maxlimit) // if too long...trim it!
	field.value = field.value.substring(0, maxlimit);
	else 
	countfield.value = maxlimit - field.value.length;
}
/**
 * This method is used to hide the validate flag.
 */
function closeMessage(){
	$('#validateFlag').hide();
}

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
	 * This method is used to get search results based on given vault id
	 */
   function getVaultDetails()
   {
	   $("#vaultRequestPoolID").empty();
	   
	   var vaultID = $("#vaultTextID").val();
		var url= contextURL+"/CPALegRequest.do?command=getVaultDetails";
		$.post(url, {vaultIDDetails:vaultID},function(data){
			var content = $(data).find('#vaultRequestPoolID');
			$("#vaultRequestPoolID").empty().append( content.html() );
			eval($("#vaultRequestPoolID").innerHTML);
		});
	}
   
   /**
	 * This method is used to get participant details and cash pool details for the selected 
	 * value of the vault details.
	 */
   
   function getVaultPoolDetails(){
		
		var checkedData = $('#vaultRequestScreenID tbody :checked');
		
		var vaultDetailsID = $("#vaultDetailsID").val();
		
		if(vaultDetailsID!="" && vaultDetailsID=="false"){
			return;
		}
		
		$("#vaultDetailsID").val("false");
		
		var poolLeaderLEGoldID = checkedData.val();
		var paticipantLEGoldID = checkedData.parent().next().next().next().text();
		
		if(poolLeaderLEGoldID!=null && poolLeaderLEGoldID!=""){
			getPoolLenderDetails(poolLeaderLEGoldID);
		}else{
			$("#poolLeaderIdDetails").hide();
		}
		
		if(paticipantLEGoldID!=null && paticipantLEGoldID!=""){
		   getParticipantDetails(paticipantLEGoldID,'LEGOLDID');
		}else{
			$("#participantDetailsDiv").empty();
			$("#lenBusSegDiv").empty();
			$("#lenderCapitalDiv").empty();
			$("#lenderPEorMEDiv").empty();
		}
	}
   
  
   
   function getPoolLenderDetails(leGoldID){
	  
		var url= contextURL+"/CPALegRequest.do?command=getVaultCashPoolDetails";
		$.post(url, {leGoldIDDetails:leGoldID},function(data){
				var content = $(data).find('#poolLeaderIdDetails');
				$("#poolLeaderIdDetails").empty().append( content.html() );
				$('#poolLeaderIdDetails').show();
				$("#regionId").val("0");
				$("#countryId").val("0");
				$("#currencyId").val("0");
		});
	}

	 function getParticipantDetails(lenderGoldId,searchID){
			
			$("#lenderInfofailed").hide();
			$("#lenderInfofailedBar").hide();
			
			
			url = contextURL +"/CPALegRequest.do?command=getGoldIdDetails";
			$.post( url, {lenderOrProvider: lenderGoldId,goldIdFlag:"lenderDetails",participantCode:searchID},
					function(data){
					var content = $(data).find('#participantDetailsDiv');
					
					$("#participantDetailsDiv").empty().append( content.html() );
					var a = $(data).find("#lenderLegalEntityGoldId");
					
					var content2 = $(data).find('#lenBusSegDiv');
					$("#lenBusSegDiv").empty().append( content2.html() );
					
					var content1 = $(data).find('#lenderCapitalDiv');
					$("#lenderCapitalDiv").empty().append( content1.html() );
					
					var content3 = $(data).find('#lenderPEorMEDiv');
					$("#lenderPEorMEDiv").empty().append( content3.html() );
										
					if( a.val() == "" ){
						$("#lenderInfoInvalid").show();
						$("#lenderInfofailedBar").show();
						$('#participantDetailsDiv').hide();
						$("#lenderDiffFailed").hide();
						$("#lenderPEorMEDiv").hide();
						clearResults.hide();
					}else {
						$("#lenderInfofailed").hide();
						$("#lenderInfoInvalid").hide();
						$("#lenderInfofailedBar").hide();
						$('#participantDetailsDiv').show();
						$("#lenderDiffFailed").hide();
						$("#LenderSetUpFlagFDiv").show();
						$("#lenBusSegFDiv").show();
						$("#lenderPEorMEDiv").show();
						$("#regulatedEntityFlag1").attr("disabled", "disabled");
						$("#regulatedEntityFlag2").attr("disabled", "disabled");
						$("#princplEntityFlag1").attr("disabled", "disabled");
						$("#princplEntityFlag2").attr("disabled", "disabled");
					}
			});
		}
	
	 function changeFlag()
	 {
		 $("#vaultDetailsID").val("true");
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

	   function showGuarantorInfo()
	   {
	 	    var guaranteeFeeApplicableFlagId = $('input[id=guaranteeFeeApplicableFlagId]:checked').val();
	 	
	 		if(guaranteeFeeApplicableFlagId == "true"){
	 	
	 			$('#guaranteedivid').show();
	 		}else{
	 		
	 			$('#guarantorInfo').val("");
	 			$('#guaranteedivid').hide();
	 		}
	   }
	   
	   function validateGuarantorFlag()
	   {
	 	    var guaranteeFeeApplicableFlagId = $('input[id=guaranteeFeeApplicableFlagId]:checked').val();
	 	    
	 	    var guarantorCDRCode = $("#guarantorInfo").val();
	 		if(guarantorCDRCode == "" && guaranteeFeeApplicableFlagId == "true"){
	 			$("#guarantorInfofailedBar").show();
	 			return false;
	 		}else {
	 			$("#guarantorInfofailedBar").hide();
	 			return true;
	 		}
	 	    
	   }
		 function saveSelectionClick(e)
		 {
				$("#poolLeaderEntityErrorId").hide();		
				var cpName = $("input[name='cashPoolOptions']:checked").val();
			    var actionId = $('#actionId').val();
				if(cpName == undefined){
					$('#cashpoolSelect').show();
					$('#poolLeaderIdDetails').hide();
					$('#leader-search-results').show();
				}else {
					$('#cashpoolSelect').hide();
			 		$("#cashPoolID").hide();
					var url= contextURL+"/CPALegRequest.do?command=getPoolLeaderDetailas";
					$.post(url, {accountId:cpName,actionId:actionId},function(data){
							var content = $(data).find('#poolLeaderIdDetails');
							$("#poolLeaderIdDetails").empty().append( content.html() );
							$('#poolLeaderIdDetails').show();
							$('#leader-search-results').hide();
							$("#regionId").val("0");
							$("#countryId").val("0");
							$("#currencyId").val("0");
					});
				}
		 }

