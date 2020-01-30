	 ////////////////////// Day2 specific 
	
/**
 * This method is used to submit the form when save as draft button is pressed.
 * @param cmd
 */
function saveAsDraftD2CPA(obj) { 
	removeDisabled();
	document.forms[0].elements("cpaSummary.region").value = document.forms[0].elements("region").value;
	document.forms[0].elements("cpaSummary.country").value = document.forms[0].elements("country").value;
	document.forms[0].elements("cpaSummary.currencyCd").value = document.forms[0].elements("currencyCd").value;
	
	if(!($('input[id=lenderEntitySetupFlag]:checked').val()=="Y")){
		document.getElementById("lenderEntitySetupFlag").value="N";
	}else{
		document.getElementById("lenderEntitySetupFlag").value="Y";
	}

	removeAmountShortcuts();
	
	var lenderEntitySetupFlag = $('input[id=lenderEntitySetupFlag]:checked').val();
	if(lenderEntitySetupFlag==null || lenderEntitySetupFlag == "" || lenderEntitySetupFlag == undefined)
	{
		$('input[id=lenderEntitySetupFlag]').attr('checked', true);
		$("#lenderEntitySetupFlag").val("N");
	}
	
	//document.getElementById("lenderOrProvider").value = $('#lenderOrProvider').val().toUpperCase();
	var CPALegRequestForm = document.getElementById('cpaLegRequestForm');
	var action = CPALegRequestForm.action;
	var cmd = '?command=saveAsDraft&productType=CPA';
	action = action+cmd; 
	CPALegRequestForm.action = action;
	CPALegRequestForm.submit();
}


	 /**
	  * This method is used to validate the fields as per the business functionality
	  * @param cmd
	  */
	 
	  function validateLegCashPool(cmd,transactionEventTypeId,actionId){
	    
	 	var validateflag = false;
	 	
	 	removeDisabled();

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
	 	
	 	
	 	if(transactionEventTypeId == 10){
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
	 	} else if(transactionEventTypeId == 1 || transactionEventTypeId == 2) {
	 		if(transactionEventTypeId == 1){
	 			//Current Cash Pool Agreement Attached
				var currentCashPoolAgreementAttached = $('input[id=isCurrentCashPoolAgreementAttachedId]:checked').val();
				if(!(currentCashPoolAgreementAttached == "Y" || currentCashPoolAgreementAttached == "N")){
					$("#currentCashPoolAgreementAttachedDiv").addClass("radio-container req-error");
					validateflag = true;
				}else {
					$("#currentCashPoolAgreementAttachedDiv").removeClass("req-error");
				}
				
				//Termination Notice Attached
				var terminationNoticeAttached = $('input[id=terminationNoticeAttachedId]:checked').val();
				if(!(terminationNoticeAttached == "Y" || terminationNoticeAttached == "N")){
					$("#terminationNoticeAttachedDiv").addClass("radio-container req-error");
					validateflag = true;
				}else {
					$("#terminationNoticeAttachedDiv").removeClass("req-error");
				}
				
				//termination Date - not required
				/*var terminationDate = $("#terminationDateId").val();
				if(terminationDate == ""){
					$("#terminationDatefailedBar").show();
					validateflag = true;
				}else {
					$("#terminationDatefailedBar").hide();
				}*/
	 		}
	 		
			
			//NonStandardLegalAgreement
		 	var isNonStandardLegalAgreement = $('input[id=isNonStandardLegalAgreement]:checked').val();
		 	if(!(isNonStandardLegalAgreement == "true" || isNonStandardLegalAgreement == "false")){
		 		$("#legalAgreementDiv").addClass("radio-container exceptionsConditional req-error");
		 		validateflag = true;
		 	}else {
		 		$("#legalAgreementDiv").removeClass("req-error");
		 	}

		 	//CrossBorder
			var isCrossBorderFlag = $('input[id=crossBorderFlagId]:checked').val();
			if(!(isCrossBorderFlag == "true" || isCrossBorderFlag == "false")){
				$("#crossBoarderDiv").addClass("radio-container exceptionsConditional req-error");
				validateflag = true;
			}else {
				$("#crossBoarderDiv").removeClass("req-error");
			}	
			
			//termInMonths
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
			
			//settlementDetailsId
			var settlementDetails = $("#settlementOtherDetailsId").val(); 
			if(settlementDetails == ""){
				$("#settlementDetailsErrorBar").show();  
				validateflag = true;
			}else {
				$("#settlementDetailsErrorBar").hide();
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
		 	
	 	} 
	 	
	 	//validations for 5 qualitative factors
	 	
	 	if(actionId == 2){
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
	 	}
	 	
	 	validateflag = validateRegionData(validateflag);
	
		
		validateflag = checkME(validateflag);
	 	
	 	if(validateflag == false){
	 		
	 		var regionText = $("#regionId option:selected").text();
	 		var countryText = $("#countryId option:selected").text();
	 		var currencyText =$("#currencyId option:selected").text();
	 		
	 		document.forms[0].elements("cpaSummary.region").value = document.forms[0].elements("region").value;
	 		document.forms[0].elements("cpaSummary.country").value = document.forms[0].elements("country").value;
	 		document.forms[0].elements("cpaSummary.currencyCd").value = document.forms[0].elements("currencyCd").value;
	 		
	 		if(!($('input[id=lenderEntitySetupFlag]:checked').val()=="Y")){
	 			document.getElementById("lenderEntitySetupFlag").value="N";
	 		}else{
	 			document.getElementById("lenderEntitySetupFlag").value="Y";
	 		}
	 	
	 		removeAmountShortcuts();
	 		
	 		$('#lenderOrProvider').val($('#LEGoldId').val());
	 		
	 		var lenderEntitySetupFlag = $('input[id=lenderEntitySetupFlag]:checked').val();
	 		if(lenderEntitySetupFlag==null || lenderEntitySetupFlag == "" || lenderEntitySetupFlag == undefined)
	 		{
	 			$('input[id=lenderEntitySetupFlag]').attr('checked', true);
	 			$("#lenderEntitySetupFlag").val("N");
	 		}
	 		
	 		document.getElementById("lenderOrProvider").value = $('#lenderOrProvider').val().toUpperCase();
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
	  
	  
	  function removeDisabled()
		{
			$("#regulatedEntityFlag1").removeAttr("disabled");
			$("#regulatedEntityFlag2").removeAttr("disabled");
			$("#princplEntityFlag1").removeAttr("disabled");
			$("#princplEntityFlag2").removeAttr("disabled");
			$("#lenderOrProvider").removeAttr("disabled");
			$("#lenderTreasuryCode").removeAttr("disabled");
			$("#searchByLenderGoldId").removeAttr("disabled");
			$('#searchByLenderTreasury').removeAttr("disabled");
			$('#searchByParticipant').removeAttr("disabled");
			$("#searchID").removeAttr("disabled");
		}
	