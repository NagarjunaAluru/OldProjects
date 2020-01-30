$(document).ready(function() {
	
	showHideTPApplicantAddress();
	showHideTPTriPartyAddress();
	showHideTPCustomerAddress();
	
	loadTrypartyFlag();
	loadSiteSpecificfields();
	loadSiteTypeDynamic();
	getDefaultPole();
	$('body').off('change', '#triparty_true').on('change', '#triparty_true', function(e) {
		e.stopPropagation(); 
	    $("#TriPartyApplicant").show();
	    $("#tpApplicantDetailsDiv").hide();
	    makeMandatory('#triPartyAddressName,#triPartyAddress1,#triPartyAddressCity,#triPartyAddressZip,#triPartyAddressCountry');
	    removeMandatory('#applicantAddressName,#applicantAddress1,#applicantAddressCity,#applicantAddressZip,#applicantAddressCountry');
	    $("#ApplicantShow").find('.form-row').find('p').text('');
        $("#ApplicantShow").hide();
        $('#ApplicantShowManually').hide();
        $('#ApplicantShowManually').find('input[type=text]').val('');
		$('#ApplicantShowManually').find('input[type=hidden]').val('');
	});
	
	$('body').off('change', '#triparty_false').on('change', '#triparty_false', function(e) {		
		e.stopPropagation();
		removeMandatory('#triPartyAddressName,#triPartyAddress1,#triPartyAddressCity,#triPartyAddressZip,#triPartyAddressCountry');
		makeMandatory('#applicantAddressName,#applicantAddress1,#applicantAddressCity,#applicantAddressZip,#applicantAddressCountry');
		$("#tpApplicantDetailsDiv").show();
        $("#TriPartyApplicant").hide();
        $("#TriPartyShow").find('.form-row').find('p').text('');
        $("#TriPartyShow").hide();
        $('#TriPartyShowManually').find('input[type=text]').val('');
		$('#TriPartyShowManually').find('input[type=hidden]').val('');        
	});
	
	
	
	$('body').off('change', '#selectedSiteId').on('change', '#selectedSiteId', function(e) {
		e.stopPropagation();
		var siteId = $(e.target).val();
		newsiteId = siteId.replace(/,/g,"");
		$('#reqsiteID').val(newsiteId);
		if(newsiteId != "" && ($('#instrumentTypeId').val()=='1' || $('#instrumentTypeId').val()=='2')){
			var checkBUCandADN="Yes";
			getSiteType(newsiteId,checkBUCandADN);
		}
		else{
			$("#triPartyRequest, #private, #csoNoDiv, #csoApprovalDtDiv, #certifyDiv").hide();
		}
	});
	
	showHideEconomicExpiry();
	$('body').off('blur', '#expiryDt').on('blur', '#expiryDt', function(e) {
		$('#expiryDt').change();
	});
	
	$('body').off('change', '#expiryDt').on('change', '#expiryDt', function(e) {
		e.stopPropagation();
		showHideEconomicExpiry();
	});
	
	$('body').off('change', '#csoID, #tpApplicantLEGoldID').on('change', '#csoID, #tpApplicantLEGoldID', function(e) {
		e.stopPropagation();
		var url = contextURL+"/int/CSOLEValidationLookup.action";
		var csoValue = $('#csoID').val();
		var leGoldIdValue = $('#tpApplicantLEGoldID').val();
		var formData = {
			csoValue : csoValue,
			leGoldIdValue : leGoldIdValue
		};
		if(csoValue != undefined && csoValue != '' && leGoldIdValue != undefined && leGoldIdValue != ''){
			$('#csoleGoldLoading').show();
			callCSOValidation(url, formData);
		}
	});
	showHideCSOValidation();
	showHideNoOfDays();
	showHideComplyCtrRqmt();
	$('body').off('click', '#curePeriodFlag_true').on('click', '#curePeriodFlag_true', function(e) {
		e.stopPropagation();
		showHideNoOfDays();
		makeMandatory('#noOfDays');
	});
	$('body').off('click', '#curePeriodFlag_false').on('click', '#curePeriodFlag_false', function(e) {
		e.stopPropagation();
		showHideNoOfDays();
		removeMandatory('#noOfDays');
	});
	
	$('body').off('click', '#contrReqFlag_true').on('click', '#contrReqFlag_true', function(e) {
		e.stopPropagation();
		showHideComplyCtrRqmt();
	});
	$('body').off('click', '#contrReqFlag_false').on('click', '#contrReqFlag_false', function(e) {
		e.stopPropagation();
		showHideComplyCtrRqmt();
	});
	$('body').off('click', '.noticePeriodCls').on('click', '.noticePeriodCls', function(e) {		
		e.stopPropagation();
		$('#nonRenewalPeriod').val("");
	});
	
	$('body').off('change', '#bidContractAmt').on('change', '#bidContractAmt', function(e) {
		e.stopPropagation();
		bidUsdEquivalent();
		
	});
	
	
	bidUsdEquivalent();
	amountTowords();
	instrumentPurposeClick();
	$('body').off('change', '#instrumentPurposeId').on('change', '#instrumentPurposeId', function(e) {
		e.stopPropagation();
		instrumentPurposeClick();
		var insPurposeName=$('#instrumentPurposeId :selected').text();
		$('#instrumentPurpose').val(insPurposeName);
		var isResubmitPage = $('#isResubmitPage').val();
		if(isResubmitPage != undefined && isResubmitPage == "true"){
			dynamicFormatValueChange();
		}
	});
	
	$.subscribe('dynamicFormatValueChange', function(event,data) {
		dynamicFormatValueChange();
	});
	
	hideInsPurposeOther();
	onclickSBLC();
    	$('body').on('click', '#creditReqConfimFlag_true, #creditReqConfimFlag_false, #creditReqAdviseFlag_true, #creditReqAdviseFlag_false', function(e) {
    		e.stopPropagation();
			onclickSBLC();
		});
	
		
	onclickAutoExtendFlag();
	$('body').on('click', '#autoExtendFlag_true, #autoExtendFlag_false', function(e) {
			e.stopPropagation();
			onclickAutoExtendFlag();
		});
	$('body').off('click', '#noticePeriodFlag_other').on('click', '#noticePeriodFlag_other', function(e) {
		e.stopPropagation();
			$('#otherTimeFrameDiv').show();
			makeMandatory('#nonRenewalPeriod');
			});
	$('body').off('click', '#noticePeriodFlag_30').on('click', '#noticePeriodFlag_30', function(e) {
		e.stopPropagation();
			$('#otherTimeFrameDiv').hide();
			removeMandatory('#nonRenewalPeriod');
			});
	$('body').off('click', '#noticePeriodFlag_60').on('click', '#noticePeriodFlag_60', function(e) {
		e.stopPropagation();
			$('#otherTimeFrameDiv').hide();
			removeMandatory('#nonRenewalPeriod');
			});
	$('body').off('click', '#noticePeriodFlag_90').on('click', '#noticePeriodFlag_90', function(e) {
		e.stopPropagation();
			$('#otherTimeFrameDiv').hide();
			removeMandatory('#nonRenewalPeriod');
			});
	hideotherTimeFrameDiv();
		
		$.subscribe('showReimbursement', function(event,data) {
			readyForSystemChecks();
			 $('.reimbursementDiv').removeClass("hide");
			 getReiembursmentTypes();
			 $('#postAwardCounter').text('400');
			 $('#postAwardComments').show();
		});
		var bgTreasuryAnalystError = $('#bgTreasuryAnalystErrorShowDiv').val();
		if(bgTreasuryAnalystError!=undefined && bgTreasuryAnalystError == 'true'){				
			$('#closurePageLevelErrorDivId').show();
			 $('.reimbursementDiv').removeClass("hide");
			 $('#readySystemCheckSection').hide();
			 $("#submitDiv").removeClass('hide');
			 var actionId= $('#actionTypeId').val();
				if(actionId=='4'){
					 $("#tr-nav-sendBack").parent('li').hide();
					 $("#tr-nav-approve").parent('li').show();
					$('#tr-nav-approve').addClass('tabactive');
				     $('#li7').addClass('liactive');
					 $('#tab2').show();
					 getReiembursmentTypes();
					 getDelegationApprovers();			
				}
				if(actionId=='3'){
					 $("#tr-nav-approve").parent('li').hide();
					 $("#tr-nav-sendBack").parent('li').show();
				     $("#tr-nav-sendBack").addClass('tabactive');
				     $('#li8').addClass('liactive');
					 $('#tab3').show();
					 getReiembursmentTypes();
				}
			 
		}
		$("table#autoIncDecTable tr:odd").addClass("odd");
		$('body').off('click', '.auto-addincdec').on('click', '.auto-addincdec', function(e) {
			e.stopPropagation();
			var newIncrementIndex = parseInt($('#newIncrementIndex').val());
			var showIndex = parseInt($('#showIndex').val());
			$("table#autoIncDecTable").children('tbody').children("tr:last").after('<tr class="additionalAutoIncDec newAdditionalAutoIncDec"></tr>');
			var url = contextURL+'/int/addAutoIncrease.action' + '?newIncrementIndex=' + newIncrementIndex ;
			$('.newAdditionalAutoIncDec').load(url).removeClass('newAdditionalAutoIncDec');				
			$('#newIncrementIndex').val(newIncrementIndex + 1);
			$('#showIndex').val(showIndex + 1);	
			if($('#showIndex').val() >= 10 && $('#showIndex').val() !=""){
				$('#autoaddLinkDiv').hide();
			}
			$("table#autoIncDecTable tr:odd").addClass("odd");
		});
		
		/*
		* Deletes  Auto Inc/Dec
		*/
		$('body').off('click', '.delete-autoIncDec').on('click', '.delete-autoIncDec', function(e) {
			e.stopPropagation();
			var showIndex = parseInt($('#showIndex').val());
			var incDecRow = $(e.target).parent().parent();
			$('#showIndex').val(showIndex - 1);
			if($('#showIndex').val() < 10 && $('#showIndex').val() !=""){
				$('#autoaddLinkDiv').show();
			}
			$(incDecRow).find('.autoIncDecOpcode').val('DELETE');
			$(incDecRow).addClass('deleted');
			$(incDecRow).hide();
			
		});
		
		$('body').off('click', '#autoIncDecFlag_true').on('click', '#autoIncDecFlag_true', function(e) {
			e.stopPropagation();
			autoIncDecShowDiv();
			
		});
		$('body').off('click', '#autoIncDecFlag_false').on('click', '#autoIncDecFlag_false', function(e) {
			e.stopPropagation();
			autoIncDechideDiv();
		});
		
		loadAutoIncDecCheck();
	
		 poleNameClick();
		 $('body').off('change', '#poleId').on('change', '#poleId', function(e) {
			 e.stopPropagation();
				poleNameClick();
				var poleName=$('#poleId :selected').text();
				$('#poleName').val(poleName);
				var poleId=$('#poleId').val();
				if($('#siteRequiredFlag').val() == 'true' && poleId!=undefined && poleId!="") 
				{
					makeMandatory('#customValueMandatory');
				}else{
					removeMandatory('#customValueMandatory');
				}
				
			});
		
			//Treasury analyst transfer fees section
		 	setDefaultWebcash();
			onclickTransferFeesFlag();
			onclickBankSelectionFlag();
			
			$('#transferFeesFlag_true').on('click', function(e) {
				e.stopPropagation();
				onclickTransferFeesFlag();
			});
			$('#transferFeesFlag_false').on('click', function(e) {
				e.stopPropagation();
				onclickTransferFeesFlag();
			});
			$('#issuingBankSelectionFlag_Y').on('click', function(e) {
				e.stopPropagation();
				onclickBankSelectionFlag();
			});
			$('#issuingBankSelectionFlag_N').on('click', function(e) {
				e.stopPropagation();
				onclickBankSelectionFlag();
			});		
			subscribeshowSBLCRadioBtns();
			showSBLCOnload();
});



function showHideEconomicExpiry() {
	var expiryDate=$('#expiryDt').val();
	
	if(expiryDate != undefined && expiryDate != ''){
		var date = expiryDate.match(/^(\d{1,2}) (\w{3}) (\d{4})[ ]?$/);
		var year = '';
		if(date!= undefined && date != '' && date.length >= 3){
			year = date[3];
		}
		if(year != '' && year >='2050'){
			$('#econoExpiryDtDiv').show();
			makeMandatory('#econoExpiryDt');
		}else{
			$('#econoExpiryDtDiv').hide();
			removeMandatory('#econoExpiryDt');
			$('#econoExpiryDt').val('');
		}
	}else{
		$('#econoExpiryDtDiv').hide();
		removeMandatory('#econoExpiryDt');
		$('#econoExpiryDt').val('');
	}
}


function onclickSBLC(){
	
	 if($('#creditReqConfimFlag_true').is(':checked')) { 
		   $('.sblcReqYesDiv').removeClass("hide");
		   makeMandatory('#selectedConfirmedCountry_widget');
		   removeMandatory('.sblcReq,#selectedAdviseCountry_widget');
		   $('.sblcReqNoDiv').addClass("hide");
		   $('.sblcReqAdviseDiv').addClass("hide");
		   $('input[name="requestDetails.SBLC.creditReqAdviseFlag"]').removeAttr('checked');
		   $('#selectedAdviseCountry_widget').siblings('input').val("");
		}
	 if($('#creditReqConfimFlag_false').is(':checked')) {
		   $('.sblcReqYesDiv').addClass("hide");
		   $('#selectedConfirmedCountry_widget').siblings('input').val("");
		   $('.sblcReqNoDiv').removeClass("hide");
		   makeMandatory('.sblcReq');
		   removeMandatory('#selectedConfirmedCountry_widget');
		}
	 if($('#creditReqAdviseFlag_true').is(':checked')) {
		   $('.sblcReqAdviseDiv').removeClass("hide");
		   makeMandatory('#selectedAdviseCountry_widget');
		}
	 if($('#creditReqAdviseFlag_false').is(':checked')) {
		   $('.sblcReqAdviseDiv').addClass("hide");
		   removeMandatory('#selectedAdviseCountry_widget');
		   $('#selectedAdviseCountry_widget').siblings('input').val("");
		}
}

function onclickAutoExtendFlag(){
	if($('#autoExtendFlag_true').is(':checked')) {
		$('.noticePeriodDiv').removeClass("hide");
		$('.initialExpiryDtDiv').removeClass("hide");
		makeMandatory('#initialExpiryDt,.noticePeriodDiv');
	}
	if($('#autoExtendFlag_false').is(':checked')) {
		$('.noticePeriodDiv').addClass("hide");
		$('.initialExpiryDtDiv').addClass("hide");
		$('#otherTimeFrameDiv').hide();
		$('#nonRenewalPeriod').val("");
		$('input[name="requestDetails.instrumentDetails.autoExtendClause.nonRenewalPeriod"]').removeAttr('checked');
		$('#initialExpiryDt').val("");
		removeMandatory('#initialExpiryDt,.noticePeriodCls');
	}
}

function showHideTPApplicantAddress() {
	if($('#tpApplicantAddressSelectionId').val() != undefined && $('#tpApplicantAddressSelectionId').val() == 'New'){
		$('#ApplicantShowManually').show();
	}
}

function showHideTPTriPartyAddress() {
	if($('#triparty_true').is(':checked') == true && ($('#triPartyAddressSelectionId').val() != undefined && $('#triPartyAddressSelectionId').val() == 'New')){
		$('#TriPartyShowManually').show();
	}
}

function showHideTPCustomerAddress() {
	if($('#tpCustomerAddressSelectionId').val() != undefined && $('#tpCustomerAddressSelectionId').val() == 'New'){
		$('#CustomerBeneficiaryShowManually').show();
	}
}


function bidValuepercent(usdAmount){
	var bidPercent="";
	if(usdAmount!="" && usdAmount!=undefined){
		var USDInstrumentAmount = usdAmount.replace(/,/g,"");
		var USDBidAmount = $('#bidUSDEquivalentAmount').val();
		USDBidAmount= USDBidAmount.replace(/,/g,"");
		if(USDBidAmount!="" && USDInstrumentAmount!=""){
			if(USDBidAmount!=undefined && USDInstrumentAmount!=undefined){
				if(USDBidAmount!="0"){
					bidPercent=(USDInstrumentAmount/USDBidAmount)*100;
				}
				if(bidPercent!="" && bidPercent!=undefined){
					$('#percent').text(bidPercent.toFixed(2));
					$('#percentValueOfBid').val(bidPercent.toFixed(2));
					
				}
			}
		}
	}else{
		$('#percent').text("");
		$('#percentValueOfBid').val("");
		$('#amountinWords').html("");
	}
}


function bidUsdEquivalent(){
	var bidCCYCode = $('#bidCurrId').val();
	if(bidCCYCode!="" && bidCCYCode!=undefined){
		if(bidCCYCode=="USD"){
			$('#usdEquivalentDiv').hide();
			
		}else{
			$('#usdEquivalentDiv').show();
		}
	}
	
}

function amountTowords(){
	var ccyCode1 = $('#currencies').val();
	var insAmount= $('#instrumentAmt').val();
	if(insAmount!=undefined && insAmount!="" ){
		var insAmtToword = toWords(insAmount);
		$('#amountinWords').html(ccyCode1 + " - " +insAmtToword);
	}
}

function instrumentPurposeClick(){
	var instrumentPurposeId = $('#instrumentPurposeId').val();
	if(instrumentPurposeId!=undefined && instrumentPurposeId != ''){
		if(instrumentPurposeId=="16"){
			$('#instumrntDeatilsOtherDiv').show();
			makeMandatory('#instumrntDeatilsOther');
			removeMandatory('#maxPossibleExpo');
			$('#maxPossibleExpoDiv').hide();
			$('#maxPossibleExpo').val("");
			
		}else if(instrumentPurposeId=="12" || instrumentPurposeId=="14"){
			$('#maxPossibleExpoDiv').show();
			makeMandatory('#maxPossibleExpo');
			$('#instumrntDeatilsOtherDiv').hide();
			removeMandatory('#instumrntDeatilsOther');
			$('#instumrntDeatilsOther').val("");
			
		}else{
			$('#instumrntDeatilsOtherDiv').hide();
			removeMandatory('#instumrntDeatilsOther,#maxPossibleExpo');
			$('#maxPossibleExpoDiv').hide();
			$('#instumrntDeatilsOther').val("");
			$('#maxPossibleExpo').val("");
		}
	}  
}

/**
 * This function is used to change the Format content
 */
function dynamicFormatValueChange(){
	var instrumentPurposeId = $('#instrumentPurposeId').val();
	if(instrumentPurposeId!=undefined && instrumentPurposeId != ''){
		var url = contextURL +'/int/requestor/getOnchangeFormatValue.action' + '?instrumentPurposeId=' + instrumentPurposeId;	
		$.ajax({
			type:'POST',
			url: url,
			dataType: 'html',
			data: {},
			success: function(data) {
				$('#replaceFormat').empty().html(data);
			}
		});	
	}
}

function showHideCSOValidation() {
	var csoValue = $('#csoID').val();
	var leGoldIdValue = $('#tpApplicantLEGoldID').val();
	if(csoValue != undefined && csoValue != '' && leGoldIdValue != undefined && leGoldIdValue != ''){
		var url = contextURL+"/int/CSOLEValidationLookup.action";
		var formData = {
			csoValue : csoValue,
			leGoldIdValue : leGoldIdValue
		};
		callCSOValidation(url,formData);
	}else{
		$('#csoMatched').hide();
		$('#csoUnMatched').hide();
	}
	
}

function callCSOValidation(url,formData) {
	$.ajax({
		type: "POST",
        url: url,
        dataType: 'json',
        data: formData,
        processdata: true,
        success: function(data) {
        	if(data.result[0].isCSOLEValid){
        		$('#csoMatched').show();
        		$('#csoUnMatched').hide();
        		$('#validCSOId').val(true);
        	}else{
        		$('#csoMatched').hide();
        		$('#csoUnMatched').show();
        		$('#validCSOId').val(false);
        	}
        	$('span.csoLEClass').text(data.result[0].resultMessage);
        	$('#csoleGoldLoading').hide();
        }
	});
}
function poleNameClick(){
	var i= $('#poleId').val();
	if(i=="")
	 {
		 $('#instRptAttrDevId').slideUp();
	 }
	else if(i!="")
	 {
		$('#instRptAttrDevId').slideDown();
	 }
	var poleId=$('#poleId').val();
	if($('#siteRequiredFlag').val() == 'true' && poleId!=undefined && poleId!="") 
	{
		makeMandatory('#customValueMandatory');
	}else{
		removeMandatory('#customValueMandatory');
	}
}

function onclickTransferFeesFlag(){
	if($('#transferFeesFlag_true').is(':checked')) {
		   $('.transferFeesDiv').removeClass("hide");
		}
	else if($('#transferFeesFlag_false').is(':checked')) {
		   $('.transferFeesDiv').addClass("hide");
		   $('#transferCostBPS').val("");
		   $('#bpsCurrId').val("");
		   $('#currencyBPS').val("");
		   $('.perAnnumQuarterBPS').prop('checked',false);
		   $('.perAnnumQuarterNumeric').prop('checked',false);
		   $('#perAnnumQuarterNumeric_1').val("");
		   $('#perAnnumQuarterNumeric_2').val("");
		   $('#perAnnumQuarterBPS_1').val("");
		   $('#perAnnumQuarterBPS_2').val("");
		   $('#transferCostNumeric').val("");
		   $('#numericCurrId').val("");
		   $('#currencyNumeric').val("");
		   $('#perAnnumQuarterNumeric').val("");
		   $('#transferFeesComments').val("");
		}
	
	
}

function setDefaultWebcash(){
	var suppressWebcashId= $('#suppressWebcashId').val();
	if(suppressWebcashId=='' || suppressWebcashId==null){
		$('#webcashFlag_false').prop('checked',true);
		
	}
}
function showHideNoOfDays(){
	if($('#curePeriodFlag_true').is(':checked')) {
		 $('#noOfDaysDiv').show();
		 makeMandatory('#noOfDays');
		}
	else if($('#curePeriodFlag_false').is(':checked')) {
		 $('#noOfDaysDiv').hide();
		 $('#noOfDays').val("");
		 removeMandatory('#noOfDays');
	}
	
}

function showHideComplyCtrRqmt(){
	if($('#contrReqFlag_true').is(':checked')) {
		 $('#complyCtrRqmtDiv').hide();
		 removeMandatory('#complyCtrRqmt');
		 $('#complyCtrRqmt').val("");
		}else if($('#contrReqFlag_false').is(':checked')) {
		 $('#complyCtrRqmtDiv').show();
		 makeMandatory('#complyCtrRqmt');
	}
}


function getReiembursmentTypes(){
	var url = contextURL +"/int/ReiembursmentTypesRefData.action";
	var requestId =$('#requestId').val();
	var formData = {'requestId':requestId};
	$.ajax({
		type: "POST",
		url: url,
		dataType: 'json',
		data: formData,
		processdata: true,
		success: function(data){
			$("#selectAgreemet").empty().append("<option value=''>Select...</option>");
        	for (var i = 0; i < data.result.length; i++) {
        		if(data.result[i].defaultagID== data.result[i].agTypeID)
    			{
    			 $("#selectAgreemet").append("<option value='" + data.result[i].agTypeID +"' selected>" + data.result[i].agTypeName + "</option>");
    			}else{
    			 $("#selectAgreemet").append("<option value='" + data.result[i].agTypeID + "'>" + data.result[i].agTypeName +"</option>");
    		}
        		
        		
    	        
             }
		}
	});

}

function getSiteType(siteId,checkBUCandADN){
	$('#siteTypeIndicator').show();
	var url = contextURL +"/int/SiteTypeRefData.action";
	$.ajax({
		type: "POST",
		url: url,
		dataType: 'json',
		data: {siteId : siteId},
		success: function(data){
			if(data.result!=null){
				if(data.result.siteType!=null){
					$('#siteTypeNameId').val(data.result.siteType);
				}
				if(checkBUCandADN=="Yes"){
					if(data.result.bucId!=null){
						$('#bussUnitCodeId').val(data.result.bucId);
					}
					if(data.result.adnId!=null){
						$('#accDistNoId').val(data.result.adnId);
					}
					
				}else if(checkBUCandADN=="No"){
					if($('#bussUnitCodeId').val()== undefined || $('#bussUnitCodeId').val()== ''){
						$('#bussUnitCodeId').val(data.result.bucId);
					}
					if($('#accDistNoId').val() == undefined || $('#accDistNoId').val()== ''){
						$('#accDistNoId').val(data.result.adnId);
					}
					
				}
				showHideIbsMessage();				
			}
			$('#siteTypeIndicator').hide();
			var siteTypeName=$('#siteTypeNameId').val();
			hideNonFinSection(siteTypeName);
		}
		});
	
	
}


function hideNonFinSection(siteTypeName){
	var financialExist = false;
	$("#instrumentPurposeId option").each(function(){
		if (this.value == '15') {
			financialExist = true;
		  }
	});
	if(financialExist == true && siteTypeName != 'Financial Business'){
		$("#instrumentPurposeId option[value='15']").remove();
	}else if(financialExist != true && siteTypeName == 'Financial Business'){
		$("#instrumentPurposeId").append('<option value="15">Financial</option>');
	}
	if(siteTypeName != 'Financial Business'){
		$("#triPartyRequest, #private, #csoNoDiv, #csoApprovalDtDiv, #certifyDiv,#TriPartyApplicant").hide();
		 $('#TriPartyShowManually').find('input[type=text]').val('');
		 $('#TriPartyShowManually').find('input[type=hidden]').val(''); 
		 removeMandatory('.countTriparty,.countPrivate,#csoID,#csoDateId,#certifyFlagID');
	}else if(siteTypeName == 'Financial Business'){
		$("#triPartyRequest, #private, #csoNoDiv, #csoApprovalDtDiv, #certifyDiv").show();
		makeMandatory('.countTriparty,.countPrivate,#csoID,#csoDateId,#certifyFlagID');
	}
	
}

function onclickBankSelectionFlag(){
	if($('#issuingBankSelectionFlag_Y').is(':checked')) {
		   $('.bankShowDiv').removeClass("hide");
		}
	else if($('#issuingBankSelectionFlag_N').is(':checked')) {
		   $('.bankShowDiv').addClass("hide");
		   $('#treasurySelectedBankId').val("");
		   $('#treasurySelectedBankName').val("");
		   
		}
	
}


function loadTrypartyFlag() {
	if($('#triparty_true').is(':checked')){
		$("#TriPartyApplicant").show();
	    $("#tpApplicantDetailsDiv").hide();
	    makeMandatory('#triPartyAddressName,#triPartyAddress1,#triPartyAddressCity,#triPartyAddressZip,#triPartyAddressCountry');
	    removeMandatory('#applicantAddressName,#applicantAddress1,#applicantAddressCity,#applicantAddressZip,#applicantAddressCountry');
	    $("#ApplicantShow").find('.form-row').find('p').text('');
	    $("#ApplicantShow").hide();
	}
	if($('#triparty_false').is(':checked')){
		removeMandatory('#triPartyAddressName,#triPartyAddress1,#triPartyAddressCity,#triPartyAddressZip,#triPartyAddressCountry');
		makeMandatory('#applicantAddressName,#applicantAddress1,#applicantAddressCity,#applicantAddressZip,#applicantAddressCountry');
		$("#tpApplicantDetailsDiv").show();
	    $("#TriPartyApplicant").hide();
	    $("#TriPartyShow").find('.form-row').find('p').text('');
	    $("#TriPartyShow").hide();
	}
}

function loadSiteSpecificfields(){
	var selectedSiteId =$('#selectedSite').val();
	$('#selectedSiteId').val(selectedSiteId);
	var siteTypeName = $('#siteTypeNameId').val();
	if(siteTypeName != "" && siteTypeName!=undefined) {
		hideNonFinSection(siteTypeName);
		
	}
}

function loadSiteTypeDynamic(){
	var reqsiteID = $('#reqsiteID').val();
	var siteTypeName = $('#siteTypeNameId').val();
	if((reqsiteID != "" && reqsiteID!=undefined) && (siteTypeName == undefined || siteTypeName == "")) {
		reqsiteID = reqsiteID.replace(/,/g,"");
		if($('#instrumentTypeId').val()=='1' || $('#instrumentTypeId').val()=='2'){
			var checkBUCandADN="No";
			getSiteType(reqsiteID,checkBUCandADN);
		}
	}
}
function hideInsPurposeOther(){
	var selectInstrumentPurpose =  $("#selectInstrumentPurpose").val();

	if(selectInstrumentPurpose == "16" && selectInstrumentPurpose!=""){
		$("#Other").removeClass('hide');
	}
}

function hideotherTimeFrameDiv(){
	if($('#noticePeriodFlag_other').is(':checked')) {
		$('#otherTimeFrameDiv').show();
		makeMandatory('#nonRenewalPeriod');
		}else{
			$('#otherTimeFrameDiv').hide();
		}
	
}

function autoIncDecShowDiv(){
	$('#autoIncDecShow').show();
	$("table#autoIncDecTable tr:odd").addClass("odd");
	makeMandatory('.countAuto,#autoIncDt1,#autoIncAmt1');
	if($('#showIndex').val() >= 10 && $('#showIndex').val() !=""){
		$('#autoaddLinkDiv').hide();
	}else{
	$('#autoaddLinkDiv').show();
	}
	
}

function autoIncDechideDiv(){
	removeMandatory('.countAuto,#autoIncDt1,#autoIncAmt1');
	 $('#autoIncDecShow').hide();
	 $('#autoaddLinkDiv').hide();
}

function loadAutoIncDecCheck(){
	if($('#autoIncDecFlag_true').is(':checked')) { 				
		autoIncDecShowDiv();
		}
	 if($('#autoIncDecFlag_false').is(':checked')) {
		 autoIncDechideDiv();
		}
	
}

function getDefaultPole(){
	$.subscribe('getDefaultPole', function(event,data) {
		var countryTextField = $("#"+data.id).parents('div.form-row').children("input:first").attr("id");
		var countryCode=$("#"+countryTextField).val();
			if(countryCode!="" && countryCode!=undefined){
					var countrydata = {countryCode: countryCode};
					var url = contextURL +"/int/DefaultPoleRefData.action";
					$.ajax({
						type: "POST",
						url: url,
						dataType: 'json',
						data: countrydata,
						success: function(data){
							if(data.result!=null){
								if(data.result.poleId!=null && data.result.poleName!=null){
									$('#poleId').val(data.result.poleId);
									$('#poleName').val(data.result.poleName);
									poleNameClick();
									$.publish('/fieldCounter/fieldsModified','#poleId');
								}else{
									$('#poleId').val("");
									$('#poleName').val("");
									$('#instRptAttrDevId').find('input[type=text]').val('');
									poleNameClick();
								}
							}
						}
					});
				
			}
	});
}

function subscribeshowSBLCRadioBtns(){
	$.subscribe('showSBLCRadioBtns', function(event,data) {
		var ui = event.originalEvent.ui;
		var codeTextField = $("#"+data.id).parents('div.form-row').children("input:first").attr("id");
		var textField = $("#"+data.id).parents('div.form-row').find(".autoCompleterName").attr("id");
		var text;
		if(ui.item != undefined && ui.item != null){
			text = ui.item.value;
		}else{
			text = '';
			$('#'+codeTextField).val($.trim(text));
		}
		$('#'+textField).val($.trim(text));
		showSBLCOnload();
		if($('#' + data.id).hasClass('mandatory')) {
		fieldsModified('#' + data.id);
		}
	event.stopPropagation();
	});
}

function showSBLCOnload(){
	var countryCode = $("#issuanceCountry").val();
	if(countryCode!=undefined && countryCode!=""){
	if(countryCode=="US"||countryCode=="UM"|countryCode=="PU"){
		$("#usIssuanceFlag_true").attr('checked', 'checked');
	     $(".usIssuanceFlagRadio").attr('disabled', true);
	     $("#uniqueUSIssuanceFlag").attr('disabled', false);
	     $("#uniqueUSIssuanceFlag").val('true');
	}else{
	   $("#usIssuanceFlag_false").attr('checked', 'checked');
		$(".usIssuanceFlagRadio").attr('disabled', true);	
		 $("#uniqueUSIssuanceFlag").attr('disabled', false);
		  $("#uniqueUSIssuanceFlag").val('false');
	   } 		
			onclickSBLC();
	}else{$("#uniqueUSIssuanceFlag").val(null);}
}
