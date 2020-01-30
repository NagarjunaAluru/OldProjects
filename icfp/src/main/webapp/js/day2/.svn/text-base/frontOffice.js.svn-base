


 
 
$(document).ready(function(){
	//adding for defect 1284
	if($('input[id=fixedOrFloatRadioId]:checked').val()){
		$('input[id=fixedOrFloatRadioId]').attr("disabled", "disabled");
	}		
	if($("#baseFixedRateID").val()!=""){
		$("#baseFixedRateID").attr("disabled", "disabled");
	}
	if($("#floatRateIndexId").val()!=""){
		$("#floatRateIndexId").attr("disabled", "disabled");
	}
	if($("#floatRateIndexTermId").val()!=""){		
		$("#floatRateIndexTermId").attr("disabled", "disabled");
	}		
	//end defect 1284
	
	$('#lenderEditDetails').hide();
	$('#lenderEdit').live("click",function(){
		$('#lenderEditDetails').show();
		var lenderTCodeValue = $('#lenderTreasuryCodeId').val();
		if(lenderTCodeValue != ''){
			$('#lenderTreasuryDetails').show();
		}
	});
	
	$('#borrowerEditDetails').hide();
	$('#borrowerEdit').live("click",function(){
		$('#borrowerEditDetails').show();
		var tcodeVal = $('#borrowerTreasuryCodeId').val();
		if(tcodeVal != ''){
			$('#borrowerTreasuryDetails').show();
		}
	});
	
var newFOLenderOrBorrower = $('input:radio[id=newFOLenderOrBorrower]:checked').val();
	if(newFOLenderOrBorrower!=undefined && newFOLenderOrBorrower == "true"){
		$("#newFOLenderDetails").show();
		$("#newFOBorrowerDetails").hide();
	}else if(newFOLenderOrBorrower!=undefined && newFOLenderOrBorrower == "false") {
		
		$("#newFOLenderDetails").hide();
		$("#newFOBorrowerDetails").show();
	}
	
	$('#newLenderEditDetails').hide();
	$('#newLenderEdit').live("click",function(){
		$('#newLenderEditDetails').show();
		
	});
	
	$('#newBorrowerEditDetails').hide();
	$('#newBorrowerEdit').live("click",function(){
		$('#newBorrowerEditDetails').show();
		
	});
	
	$("#saveNewLenderDetails").click(function(){
				
		$('#newLenderEditDetails').hide();
		var newLentityName="NEW_LENDER";
		
		var newLenderGoldId = $("#newLEGoldId").val();
		var newLenderCdrId = $("#newLenderLegalEntityGoldId").val();
		var newLeName=$("#newLeName").val();
		var newLcountry=$("#newLecountry").val();
		var newLcap=$("#newLenderCapOrIndustrial").val();
		var newLbusiness=$("#newLenderbusinessSegment").val();
		var newLtcode=$("#newLenderTreasuryCode").val();
		var newLfun=$("#selectedNewFunCompany option:selected").val();
		var newLme=$("#selectedNewLenderMgmtEntity").val();
		
		var newLenderRegulated = $('input[name=legSummary.newLenderEntity.regulatedEntityFlag]:checked').val();
		var newLenderPrincipal = $('input[name=legSummary.newLenderEntity.princplEntityFlag]:checked').val();
				     
			var url= contextURL+"/frontoffice/RCALegRequest.do?command=setLenderBorrowerDetails";
			$.post(url,{cdrCode:newLenderCdrId,goldId:newLenderGoldId,leName:newLeName,country:newLcountry,capitalIndustrial:newLcap,businessSegment: newLbusiness,
				tcode:newLtcode,funCompany:newLfun,mgmtEntity:newLme,regulatedEntity:newLenderRegulated,princplEntity:newLenderPrincipal,entity:newLentityName},function(data){
					var content = $(data).find('#NewLenderReadOnlyDetails');
					
					$("#NewLenderReadOnlyDetails").empty().append( content.html() );
										
					$('#NewLenderReadOnlyDetails').show();
								
			});
	
		
	});
	
	$("#saveNewBorrowerDetails").click(function(){
			
		$('#newBorrowerEditDetails').hide();
		var newBentityName="NEW_BORROWER";
		var newBoGoldId = $("#newBorLEGoldId").val();
		var newBoCdrId = $("#newBorrowerLegalEntityGoldId").val();
		var newBoLeName=$("#newBoLeName").val();
		var newBocountry=$("#newBocountry").val();
		var newBcap=$("#newBorrowerCapOrIndustrial").val();
		var newBobusiness=$("#newBorrowerbusinessSegment").val();
		var newBtcode=$("#newBorrowerTreasuryCode").val();
		var newBfun=$("#newSelectedBorFunCompany option:selected").val();
		var newBme=$("#selectedNewBorrowerMgmtEntity").val();
		
		var newBoRegulated = $('input[name=legSummary.newBorrowerEntity.regulatedEntityFlag]:checked').val();
		var newBoPrincipal = $('input[name=legSummary.newBorrowerEntity.princplEntityFlag]:checked').val();
				     
			var url= contextURL+"/frontoffice/RCALegRequest.do?command=setLenderBorrowerDetails";
			$.post(url,{cdrCode:newBoCdrId,goldId:newBoGoldId,leName:newBoLeName,country:newBocountry,capitalIndustrial:newBcap,businessSegment: newBobusiness,
				tcode:newBtcode,funCompany:newBfun,mgmtEntity:newBme,regulatedEntity:newBoRegulated,princplEntity:newBoPrincipal,entity:newBentityName},function(data){
					var content = $(data).find('#NewBorrowerReadOnlyDetails');
					
					$("#NewBorrowerReadOnlyDetails").empty().append( content.html() );
										
					$('#NewBorrowerReadOnlyDetails').show();
								
			});
				
	});
	
	
	
	
	$("#saveOriginalLenderDetails").click(function(){
				  
		$('#lenderEditDetails').hide();
		var lentityName="ORIGINAL_LENDER";
		var lenderGoldId = $("#LEGoldId").val();
		var lenderCdrId = $("#lenderLegalEntityGoldId").val();
		var leName=$("#leName").val();
		var country=$("#country").val();
		var cap=$("#lenderCapOrIndustrial").val();
		var business=$("#lenderbusinessSegment").val();
		var tcode=$("#lenderTreasuryCode").val();
		var fun=$("#selectedFunCompany option:selected").val();
		var me=$("#selectedLenderMgmtEntity").val();
		
		var lenderRegulated = $('input[name=legSummary.lenderEntity.regulatedEntityFlag]:checked').val();
		var lenderPrincipal = $('input[name=legSummary.lenderEntity.princplEntityFlag]:checked').val();
				     
			var url= contextURL+"/frontoffice/RCALegRequest.do?command=setLenderBorrowerDetails";
			
			$.post(url,{cdrCode:lenderCdrId,goldId:lenderGoldId,leName:leName,country:country,capitalIndustrial:cap,businessSegment: business,
				tcode:tcode,funCompany:fun,mgmtEntity:me,regulatedEntity:lenderRegulated,princplEntity:lenderPrincipal,entity:lentityName},function(data){
					var content = $(data).find('#0riginalLenderEditDetails');
					
					$("#0riginalLenderEditDetails").empty().append( content.html() );
										
					$('#0riginalLenderEditDetails').show();
					
				
					
			});
		
	});
	
	
	$("#saveOriginalBorrowerDetails").click(function(){
		$('#borrowerEditDetails').hide();
		var bentityName="ORIGINAL_BORROWER";
		var borrowerGoldId = $("#borLEGoldId").val();
		var borrowerCdrId = $("#borrowerLegalEntityGoldId").val();
		var boleName=$("#boleName").val();
		var borcountry=$("#borcountry").val();
		var bcap=$("#borrowerCapOrIndustrial").val();
		var business=$("#borrowerbusinessSegment").val();
		var btcode=$("#borrowerTreasuryCode").val();
		var bfun=$("#selectedBorFunCompany option:selected").val();
		var bme=$("#selectedBorrowerMgmtEntity").val();
		var borrowerRegulated = $('input[name=legSummary.borrowerEntity.regulatedEntityFlag]:checked').val();
		var borrowerPrincipal = $('input[name=legSummary.borrowerEntity.princplEntityFlag]:checked').val(); 
			var url= contextURL+"/frontoffice/RCALegRequest.do?command=setLenderBorrowerDetails";
			$.post(url,{cdrCode:borrowerCdrId,goldId:borrowerGoldId,leName:boleName,country:borcountry,capitalIndustrial:bcap,businessSegment: business,
				tcode:btcode,funCompany:bfun,mgmtEntity:bme,regulatedEntity:borrowerRegulated,princplEntity:borrowerPrincipal,entity:bentityName},function(data){
					var content = $(data).find('#0riginalBorrowerEditDetails');
					
					$("#0riginalBorrowerEditDetails").empty().append( content.html() );
										
					$('#0riginalBorrowerEditDetails').show();
					
				
					
			});
		
	});
	

	  
	  
	  
	
	
	
});



function lenderFOD() {
	
	$("#newFOLenderDetails").show();
	$("#newFOBorrowerDetails").hide();

}

function borrowerFOD() {
	
	$("#newFOLenderDetails").hide();
	$("#newFOBorrowerDetails").show();

}
function fosaveAndReturnDeal(obj){
	
	var isVisible = false;
	var cmd ="";
	$('.invalid').each(function(){
		if($('.invalid').is(":visible")){
			isVisible = $('.invalid').is(":visible");
		}
	});
	
	var fixedOrFloat = $('input[id=fixedOrFloatRadioId]:checked').val();
	if(fixedOrFloat!=undefined && fixedOrFloat == "2"){
		var floatSpreadID = $('#floatSpreadID').val();
		if(floatSpreadID!=undefined && floatSpreadID!=""){
			$('#fixedSpreadID').val(floatSpreadID);
		}
	}
	
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

		
					
		var RCALegRequestForm = obj.form;
		var action = RCALegRequestForm.action;
		//var cmd="?command=saveAndReturnToDeal&isFrontOffice=Yes";
		action=action+cmd;
		
		RCALegRequestForm.action = action;
		RCALegRequestForm.submit();
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}
}

function fosave(obj){
	
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
		
		var transactionEventTypeId =$("#transactionEventTypeId").val();
		if(transactionEventTypeId!=undefined && transactionEventTypeId == 5){
			$("#facilityType").removeAttr("disabled");
		}
		
		var RCALegRequestForm = obj.form;
		var action = RCALegRequestForm.action;
		var cmd="?command=saveAsDraft&isFrontOffice=Yes";
		action=action+cmd;
		RCALegRequestForm.action = action;
		RCALegRequestForm.submit();
	}else {
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}
	
}


function newFOLenderBorrowerValidations(validateflag){
	
	
	//var newLenderOrBorrower = $('input[id=newFOLenderOrBorrower]:checked').val();
	var newFOLenderOrBorrower = $('input:radio[id=newFOLenderOrBorrower]:checked').val();
	if(!(newFOLenderOrBorrower == "true" || newFOLenderOrBorrower == "false")){
		$("#newLenBorDiv").addClass("radio-container req-error");
		validateflag = true;
	}else {
		$("#newLenBorDiv").removeClass("req-error");
	
		var newFOLenderOrBorrower = $('input:radio[id=newFOLenderOrBorrower]:checked').val();
		if(newFOLenderOrBorrower == "true"){
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
		}else if(newFOLenderOrBorrower == "false"){		
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




function saveAsDraft(obj){
	hideValidationBarsSave();
	
	fosave(obj);
}

function foTermsAndConditions(validateflag){
	var fixedOrFloat = $('input[id=fixedOrFloatRadioId]:checked').val();
	
	if(fixedOrFloat == "1"){
		var baseFixedRateID = $("#baseFixedRateID").val();
		if(baseFixedRateID != "" && (baseFixedRateID.match('^[0-9]*\.[0-9]*$')==null || parseFloat(baseFixedRateID) < 0)){
			$("#baseFixedRatefailedBar").show();
			validateflag = true;
		}else {
			$("#baseFixedRatefailedBar").hide();
		}
		
		
		var fixedSpreadID = $("#fixedSpreadID").val();
		if(fixedSpreadID != "" && fixedSpreadID!=undefined){
			
		if((fixedSpreadID.match('^[-0-9]*\.[0-9]*$')==null )){
			$("#fixedSpreadfailedBar").show();
			validateflag = true;
		}else {
			$("#fixedSpreadfailedBar").hide();
			fixedMinSpreadVal = $("#fixedMinSpreadID").val();
			fixedMaxSpreadVal = $("#fixedMaxSpreadID").val();
			if(fixedMinSpreadVal!=undefined && fixedMaxSpreadVal!=undefined ){
				if(fixedMinSpreadVal!="" && fixedMaxSpreadVal!=""){
				//fixedAverage = (parseFloat(fixedMinSpreadVal) + parseFloat(fixedMaxSpreadVal))/2; 
				if((parseFloat(fixedSpreadID) >= parseFloat(fixedMinSpreadVal))){	
					if((parseFloat(fixedSpreadID) <= parseFloat(fixedMaxSpreadVal))){
						$("#fixedSpreadfailedBar").hide();
						$("#fixedSpreadIDFailed").hide();
					}else{
						$("#fixedSpreadfailedBar").show();
						$("#fixedSpreadIDFailed").show();
						validateflag = true;
					}
				}else{
					$("#fixedSpreadfailedBar").show();
					$("#fixedSpreadIDFailed").show();
					validateflag = true;
				}
			}
			}
		}
		}
	}
	
	if(fixedOrFloat == "2"){
		
		var floatSpreadID = $("#floatSpreadID").val();
		
		if(floatSpreadID != "" && floatSpreadID!=undefined){
		
		if((floatSpreadID.match('^[-0-9]*\.[0-9]*$')==null)){
			$("#floatSpreadfailedBar").show();
			validateflag = true;
		}else {
			$("#floatSpreadfailedBar").hide();
			floatMinSpreadVal = $("#floatMinSpreadID").val();
			floatMaxSpreadVal = $("#floatMaxSpreadID").val();
			if(floatMinSpreadVal!=undefined && floatMaxSpreadVal!=undefined ){
				if(floatMinSpreadVal!="" && floatMaxSpreadVal!=""){ 
				//floatAverage = (parseFloat(floatMinSpreadVal) + parseFloat(floatMaxSpreadVal))/2;
				if((parseFloat(floatSpreadID) >= parseFloat(floatMinSpreadVal))){	
					if((parseFloat(floatSpreadID) <= parseFloat(floatMaxSpreadVal))){
						$("#floatSpreadfailedBar").hide();
						$("#floatSpreadIDFailed").hide();
					}else{
						$("#floatSpreadfailedBar").show();
						$("#floatSpreadIDFailed").show();
						validateflag = true;
					}
				}else{
					$("#floatSpreadfailedBar").show();
					$("#floatSpreadIDFailed").show();
					validateflag = true;
				}
			}
			}
		}
		}
	}
	
	
	return validateflag;
}






/**
 * Validates the mandatory fields
 * @param cmd
 */
function validateFOAssignment(obj){
var validateflag = false;
	
	validateflag = isEntitesSameInAssignmentFO(validateflag);
	validateflag = originalTransactionValidations(validateflag);
	validateflag  = originalLenderBorrowerValidations(validateflag);
	validateflag  = newFOLenderBorrowerValidations(validateflag);
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
	validateflag = foTermsAndConditions( validateflag);
	validateflag = otherConsiderations(validateflag);
	validateflag = qualitativeFactorValidations(validateflag);
	validateflag = checkME(validateflag);
 	

	function changeValue(obj, status){
		$(obj).parents("tr").find("input:hidden").val(status);
	}
	
	var isVisible = false;
	$('.invalid').each(function(){
		if($('.invalid').is(":visible")){
			isVisible = $('.invalid').is(":visible");
		}
	});
	
	
	
	if(validateflag == false && !isVisible){
		
		var fixedOrFloat = $('input[id=fixedOrFloatRadioId]:checked').val();
		if(fixedOrFloat!=undefined && fixedOrFloat == "2"){
			var floatSpreadID = $('#floatSpreadID').val();
			if(floatSpreadID!=undefined && floatSpreadID!=""){
				$('#fixedSpreadID').val(floatSpreadID);
			}
		}
		
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
		
		var cmd ="";
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
		var RCALegRequestForm = obj.form;
		
		var action = RCALegRequestForm.action;
		//var cmd="?command=saveAndReturnToDeal&isFrontOffice=Yes";
		action=action+cmd;
		RCALegRequestForm.action = action;
		RCALegRequestForm.submit();
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}
}

function validateFODebtEquity(obj){

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
	
	var legTypeId = $('#legTypeId').val();
	if(legTypeId != 2){
		validateflag = validateDerivative(validateflag);
		validateflag = foTermsAndConditions(validateflag);
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
	
	validateflag = qualitativeFactorValidations(validateflag);
	
	validateflag = checkME(validateflag);
 	
	if(validateflag == false){
		
		fosaveAndReturnDeal(obj);
			
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}

}


function validateFOTermination(obj){

	var validateflag = false;
	validateflag = originalTransactionValidations(validateflag);
	validateflag = originalLenderBorrowerValidations(validateflag);
	validateflag = isLenderBorrowerSame(validateflag);
		
	validateflag = originalCCYValidate(validateflag);
	validateflag = checkME(validateflag);
 	

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

	validateflag = foTermsAndConditions(validateflag);
	validateflag = validateDerivative(validateflag);
	validateflag = otherConsiderations(validateflag);
	
	validateflag = qualitativeFactorValidations(validateflag);
	
	function changeValue(obj, status){
		$(obj).parents("tr").find("input:hidden").val(status);
	}
	
	
	if(validateflag == false){
		
		fosaveAndReturnDeal(obj);
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}
} 

function validateFOAgreementExtension(obj){

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
	validateflag = foTermsAndConditions( validateflag);
	validateflag = checkME(validateflag);
 	
	
	var isOrigLegalAgreementAttachedFlag = $('input[id=isOrigLegalAgreementAttachedFlag]:checked').val();
	if(!(isOrigLegalAgreementAttachedFlag == "true" || isOrigLegalAgreementAttachedFlag == "false")){
		$("#originalAgmtDiv").addClass("radio-container req-error");
		validateflag = true;
	}else {
		$("#originalAgmtDiv").removeClass("req-error");
	}
	
	validateflag = validateDerivative(validateflag);
	validateflag = otherConsiderations(validateflag);
	validateflag = qualitativeFactorValidations(validateflag);
	function changeValue(obj, status){
		$(obj).parents("tr").find("input:hidden").val(status);
	}
	
	if(validateflag == false){
		fosaveAndReturnDeal(obj);
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}
}

function validateFOAmendIncreaseDecrease(obj){

	var validateflag = false;
	
	var facilityType = $('input[id=facilityType]:checked').val();
	if(!(facilityType == "1" || facilityType == "2")){
		$("#facilityDiv").addClass("radio-container req-error");
		validateflag = true;
	}else {
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
		
		if(originalCCYAmount == ""  || originalCCYAmount.match('^[0-9]*\.[0-9]*$')==null){
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
		val = val.replace(/,/g,"");
		facIncDecUSDAmt = val;
		if(originalCCY != "" && amendedFacilityAmt != "" && (facIncDecUSDAmt == "" || parseFloat(facIncDecUSDAmt) <= 0)){
			$("#usdFacValidateBar").show();
			validateflag = true;
		}else{
			$("#usdFacValidateBar").hide();
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
	
	validateflag = originalTransactionValidations(validateflag);
	validateflag  = originalLenderBorrowerValidations(validateflag);
	validateflag = isLenderBorrowerSame(validateflag);
	validateflag  = foTermsAndConditions(validateflag);
	validateflag = otherConsiderations(validateflag);
	validateflag = qualitativeFactorValidations(validateflag);
	validateflag = checkME(validateflag);
 	
	function changeValue(obj, status){
		$(obj).parents("tr").find("input:hidden").val(status);
	}
	
	if(validateflag == false){
		$("#facilityType").removeAttr("disabled");
		fosaveAndReturnDeal(obj);
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}
}

function validateFOGenAmendment(obj){

	var validateflag = false;
	
	validateflag = originalTransactionUsdValidations(validateflag);
	
	validateflag  = originalLenderBorrowerValidations(validateflag);
	validateflag = isLenderBorrowerSame(validateflag);
	validateflag  = foTermsAndConditions(validateflag);
	validateflag = otherConsiderations(validateflag);
	validateflag = checkME(validateflag);
	
	
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
	validateflag = qualitativeFactorValidations(validateflag);
	function changeValue(obj, status){
		$(obj).parents("tr").find("input:hidden").val(status);
	}
		
	if(validateflag == false){
		fosaveAndReturnDeal(obj);
	}else{
		$(window).scrollTop(100);
		$('#validateFlag').show();
	}
}


function isEntitesSameInAssignmentFO(validateflag){
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



