/**
 * To delete the exception from leg
 * @param id
 */
function removeException(id){
	var fundingRequestForm = document.getElementById('ICFPLegRequestForm');
	var legNumber = fundingRequestForm.legNumber;
	var rowNumber = id.rowIndex/3;
	var exceptionNumber = document.getElementById('exceptionIndex').value;
	fundingRequestForm.action =  contextURL+"/frontoffice/RCALegRequest.do?command=deleteException&legNumber=" + legNumber + "&exceptionNumber=" + exceptionNumber;
	fundingRequestForm.submit();
	
}
/**
 * 
 */
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
	$('.product-type-all .add').click(function(e){
		if(!$(this).hasClass('review')){
			e.preventDefault()
			
			$('<tr class="added"></tr>').appendTo('.product-type-all table tbody')
			$('.added').load(contextURL+'/lib/add-equity-details-all.jsp').removeAttr('class');
			zebraStripes();
			autoTextarea();
		}
	})
	$('.product-type-debtfields .add').click(function(e){
		if(!$(this).hasClass('review')){
			e.preventDefault()
			
			$('<tr class="added"></tr>').appendTo('.product-type-debtfields table tbody')
			$('.added').load(contextURL+'/lib/add-equity-details-other.jsp').removeAttr('class');
			zebraStripes();
			autoTextarea();
		}
	})
	
	$('#commenstDiv').hide();
	
	$('.form-of-equity').change(function(){
		if($(this).val() == '1'||$(this).val() == '2'||$(this).val() == '3'){
			$('.product-type-debtfields, .product-type-comments').hide()
			$('.product-type-all').show()
			$(".equity-validation").find(".request-equity").each(function(){
				$(this).parents('tr').remove()
			});
			$('.product-type-all .add').click();
		}else if($(this).val() == '5'){
			$('.product-type-all, .product-type-comments').show()
			$(".equity-validation").find(".request-equity").each(function(){
				$(this).parents('tr').remove()
			});
			$('.product-type-all .add').click();
		}else if($(this).val() == '4'){
			$('.product-type-all, .product-type-comments').hide()
			$(".equity-validation").find(".request-equity").each(function(){
				$(this).parents('tr').remove()
			});
			$(".equityDebt-validation").find(".requestDebt-equity").each(function(){
				$(this).parents('tr').remove()
			});
			
			$('.product-type-debtfields').show()
			$('.product-type-debtfields .add').click();
		}else{
			$('.product-type-debtfields, .product-type-debtfields,.product-type-all').hide()
		}
		
		
		
		killNested()
		$('#derivatives-table').hide()
	})
	
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
	
	var productType = $("#productType").val();
	
	if(productType == "4"){
		var otherDescLen = $("#otherDesc").val();
		var othlength = otherDescLen.length;
		othlength = 1000-othlength;
		$(".otherDescChar").text(othlength);
	}
	
	noOfLegs =  $('#noOfLegsId').val() ;
	if(noOfLegs!=undefined && noOfLegs < 2){
		$("#optionsCheckbox").attr('disabled','disabled');
	}
	$("#infusionDiv").hide();
	$("#formOfEquityDiv").hide();
	$('#lenderTreasuryDetails').hide();
	$('#borrowerTreasuryDetails').hide();
	$('.product-type-debtfields, .product-type-debtfields,.product-type-all').hide();
	$('.product-type-all, .product-type-comments').hide();
	$("#formOfRCALegDiv").hide();
	$('#validateFlag').hide();
	
	$('.conditional-lender').text("Lender");
	$('.conditional-borrower').text("Borrower");
	
	var originalCCY = $("#originalCCY").val();
	var originalCCYAmount =  $("#originalCCYAmount").val();
	
	if(originalCCY!="" && originalCCYAmount!=""){
		$('#usdEquiDiv').show();
	}
	showGuarantorInfo();
	
	if(productType=="4"){
		$("#interestTypeStar").hide();
	}
	var equityFormId = $("#equityFormId").val();
	if(productType!=""){
		productTypeOnChange(productType, equityFormId);
	}
	
	var equityFormId = $('#equityFormId').val();
	$(".otherEquityChar").text(1000);
	if(productType == "2" && equityFormId == '5'){
		var eqFormdesc = $("#equityDescriptionID").val();
		var eqFormdesclength = eqFormdesc.length;
		eqFormdesclength = 1000-eqFormdesclength;
		$(".otherEquityChar").text(eqFormdesclength);
	}
	
	var lenderGoldId = $("#LEGoldId").val();
	if(lenderGoldId!=""){
		$('#lenderGoldIdDetails').show();
		$('#lenderCapitalDiv').show();
		$('#lenderOrProvider').val("");
	}
	
	var borrowerGoldId = $("#borLEGoldId").val();
	if(borrowerGoldId!=""){
		$('#borrowerGoldIdDetails').show();
		$('#borrowerCapitalDiv').show();
		$('#borrowerOrRecipient').val("");
	}
	
	
	var lenderTreasuryCode = $("#lenderTreasuryCode").val();
	if(lenderTreasuryCode!=""){
		$('#lenderTreasuryDetails').show();
		$('#clearLenderTreasuryFO').show();
	}
	
	var borrowerTreasuryCode = $("#borrowerTreasuryGoldId").val();
	if(borrowerTreasuryCode!=""){
		$('#borrowerTreasuryDetails').show();
		$('#clearBorrowerTreasuryFO').show();
	}
	
	var derivativesFlag = $('input[id=derivativesFlag]:checked').val();
	if(derivativesFlag == "true"){
		$('#derivatives-table').show();
	}else {
		$('#derivatives-table').hide();
	}
	
	
	var guaranteeFeeApplicableFlagId = $('input[id=guaranteeFeeApplicableFlagId]:checked').val();
	if(guaranteeFeeApplicableFlagId == "true"){
		$('#guaranteeFeeRateDivID').show();
		$('#guarantorGoldIdDetails').show();
	}else {
		$('#guaranteeFeeRateDivID').hide();
		$('#guarantorGoldIdDetails').hide();
	}
	
	
	
	var isNonStandardLegalAgreement = $('input[id=isNonStandardLegalAgreement]:checked').val();
	if(isNonStandardLegalAgreement == "true"){
		$('#exceptionDiv').show();
	}else {
		$('#exceptionDiv').hide();
	}
	
	if(productType=="1"){
		var isImmediateDrawDown = $('input[id=isImmediateDrawDown]:checked').val();
		if(isImmediateDrawDown == "true"){
			$('#immdtDrdownAmtDiv').show();
		}else {
			$('#immdtDrdownAmtDiv').hide();
		}
		var commitmentFeeApplicableFlag = $('input[id=commitmentFeeApplicableFlagId]:checked').val();
		if(commitmentFeeApplicableFlag == "true"){
			$('#commitmentFeeRateDivID').show();
		}else {
			$('#commitmentFeeRateDivID').hide();
		}
		
	}else{
		$('#immediateDrawDownID').hide();   
		$('#immdtDrdownAmtDiv').hide();
		$('#commitmentFeeDiv').hide();
		$('#commitmentFeeRateDivID').hide();
	}
	
	
	if(productType=="1" || productType=='5'){
		 var isOtherfees = $('input[id=isOtherfees]:checked').val();
		 if(isOtherfees == "true"){
				$('#otherfeesAmtDiv').show();
			}else {
				$('#otherfeesAmtDiv').hide();
			}
		
	}else{
		$('#OtherFeeDiv').hide();   
		
	}
	
	
	
	
	var amount = $("#originalCCYAmount").val();
	if(amount!="" && amount!=null){
		commaSeperate(amount);
	}
	  var actionType = document.forms[0].elements["rateInformation.interestTypeId"];
		  if(actionType!=undefined && actionType[0].checked){
			    $('.fixed-container').show();
			    $('.float-container').hide();
		  }else if(actionType!=undefined && actionType[1].checked){
			    $('.fixed-container').hide();
			    $('.float-container').show();
		  }else{
			  $('.fixed-container').hide();
			  $('.float-container').hide();
	  }

	  var fixedSpreadID = $("#fixedSpreadID").val();
		if(fixedSpreadID!=undefined && fixedSpreadID!="" && fixedSpreadID!=null){
			if(fixedSpreadID==0){
				$('#fixedSpreadID').val("");
			}
		}
		
		var floatSpreadID = $("#floatSpreadID").val();
		if(floatSpreadID!=undefined && floatSpreadID!="" && floatSpreadID!=null){
			if(floatSpreadID==0){
				$('#floatSpreadID').val("");
			}
		}
	  
	  
	lenderOnclick();
	borrowerOnClick();
		
	$("#lenderEntitySetupFlag").click( function(e){
		lenderOnclick();
	});
		
	$("#borrowerEntitySetupFlag").click( function(e){
		borrowerOnClick();
	});
	
	$('.immediate-Drawdown-condition input:radio').change(function(){
		var isImmediateDrawDown = $('input[id=isImmediateDrawDown]:checked').val();
		if(isImmediateDrawDown == "true"){
			var immediateDrawdownValueDt = $("#immediateDrawdownValueDateID").val();
			if(immediateDrawdownValueDt == null || immediateDrawdownValueDt == ""){
				var valueDt = $("#valueDateID").val();
				if(valueDt!=null && valueDt!="" ){
					$("#immediateDrawdownValueDateID").val(valueDt);
				}
			}
			
		}
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
			$('#searchByLenderTreasuryFO').attr("disabled", "disabled");
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
			$("#LEGoldId").val("");
			$("#clearLenderTreasury").hide();
		}else{
			$("#lenderOrProvider").removeAttr("disabled");
			$("#lenderTreasuryCode").removeAttr("disabled");
			$("#searchByLenderGoldId").removeAttr("disabled");
			$('#searchByLenderTreasuryFO').removeAttr("disabled");
			$('#lenderSearchId').removeAttr("disabled");
			
			$("#LenderSetUpFlagTDiv").hide();
			$("#LenderSetUpFlagFDiv").show();
			$(".condition-lenderReg").hide();
			$(".condition-lenderPrn").hide();
			$("#regulatedEntityFlag1").attr("disabled", "disabled");
			$("#regulatedEntityFlag2").attr("disabled", "disabled");
			$("#princplEntityFlag1").attr("disabled", "disabled");
			$("#princplEntityFlag2").attr("disabled", "disabled");
			
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
			$('#searchByBorrowerTreasuryFO').attr("disabled", "disabled");
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
			$("#borLEGoldId").val("");
			$("#borrowerTreasuryDetails").hide();
			$("#clearBorrowerTCode").hide();
		}else{
			$("#borrowerOrRecipient").removeAttr("disabled");
			$("#borrowerTreasuryCode").removeAttr("disabled");
			$("#searchByBorrowerGoldId").removeAttr("disabled");
			$('#searchByBorrowerTreasuryFO').removeAttr("disabled");
			$('#borrowerSearchId').removeAttr("disabled");
			
			$("#BorrowerSetUpFlagTDiv").hide();
			$("#BorrowerSetUpFlagFDiv").show();
			$(".condition-borrowerReg").hide();
			$(".condition-borrowerPrn").hide();
			
			$("#borRegulatedEntityFlag1").attr("disabled", "disabled");
			$("#borRegulatedEntityFlag2").attr("disabled", "disabled");
			$("#borPrincplEntityFlag1").attr("disabled", "disabled");
			$("#borPrincplEntityFlag2").attr("disabled", "disabled");
		}
	}
	
	
	$("#searchByLenderGoldId").click( function(e){
		e.preventDefault();
		
		var lenderGoldId = $("#lenderOrProvider").val();
		var borrowerGoldId = $("#borrowerOrRecipient").val();
		var borrowerCdrId = $("#borrowerLegalEntityGoldId").val();
		
		$("#lenderGoldIdDetails").val("");
		if(lenderGoldId == ""){
			$("#lenderInfoInvalid").hide();
			$("#lenderInfofailed").show();
			$("#lenderInfofailedBar").show();
			$("#lenderInfoInvalid").hide();
			$("#lenderDiffFailed").hide();
			return false;
		}else if(borrowerGoldId == lenderGoldId || lenderGoldId== borrowerCdrId){
			$("#lenderDiffFailed").show();
			$("#lenderInfoInvalid").hide();
			$("#lenderInfofailed").hide();
			$("#lenderInfofailedBar").show();
			$("#lenderInfoInvalid").hide();
		}else {
			var clearResults = $(this).siblings('.clear-conditional-results:hidden');
			clearResults.show();
			$("#lenderInfofailed").hide();
			$("#lenderInfofailedBar").hide();
			
			url = contextURL +"/frontoffice/RCALegRequest.do?command=getGoldIdDetails";
			$.post( url, {lenderOrProvider: lenderGoldId,goldIdFlag:"lenderDetails", searchFor: $(this).siblings().filter(".cpa-search-id").val() },
					function(data){
					var content = $(data).find('#lenderGoldIdDetails');
					
					var content1 = $(data).find('#lenderCapitalDiv');
					$("#lenderCapitalDiv").empty().append( content1.html() );
					
					var content2 = $(data).find('#lenBusSegDiv');
					$("#lenBusSegDiv").empty().append( content2.html() );
					
					$("#lenderGoldIdDetails").empty().append( content.html() );
					var a = $(data).find("#lenderLegalEntityGoldId");
								
					var content3 = $(data).find('#lenderPEorMEDiv');
					$("#lenderPEorMEDiv").empty().append( content3.html() );
					
					if( a.val() == "" ){
						$("#lenderInfoInvalid").show();
						$("#lenderInfofailedBar").show();
						$('#lenderGoldIdDetails').hide();
						$("#lenderDiffFailed").hide();
						$("#lenderPEorMEDiv").hide();
						clearResults.hide();
					}else {
						$("#lenderInfofailed").hide();
						$("#lenderInfoInvalid").hide();
						$("#lenderInfofailedBar").hide();
						$('#lenderGoldIdDetails').show();
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
	

	$("#searchByBorrowerGoldId").click( function(e){
		e.preventDefault();
		
		var borrowerGoldId = $("#borrowerOrRecipient").val();
		var lenderGoldId = $("#lenderOrProvider").val();
		var lenderCdrId = $("#lenderLegalEntityGoldId").val();

		$("#borrowerGoldIdDetails").val("");
		
		if( borrowerGoldId == ""){
			$("#borrowerInfofailed").hide();
			$("#borrowerInfofailed").show();
			$("#borrowerInfofailedBar").show();
			$("#borrowerInfoInvalid").hide();
			$("#borrowerGoldIdInvalid").hide();
			return false;
		}else if(borrowerGoldId == lenderGoldId || borrowerGoldId == lenderCdrId){
			$("#borrowerGoldIdInvalid").show();
			$("#borrowerInfofailed").hide();
			$("#borrowerInfofailed").hide();
			$("#borrowerInfofailedBar").show();
			$("#borrowerInfoInvalid").hide();
		}else {
			var clearResults = $(this).siblings('.clear-conditional-results:hidden');
			clearResults.show();
			$("#borrowerInfofailed").hide();
			$("#borrowerInfofailedBar").hide();
		
			url = contextURL +"/frontoffice/RCALegRequest.do?command=getGoldIdDetails";
			
			$.post( url, {borrowerOrRecipient: borrowerGoldId,goldIdFlag:"borrowerDetails",  searchFor: $(this).siblings().filter(".cpa-search-id").val() },
					function(data){
					var content = $(data).find('#borrowerGoldIdDetails');
					
					var content1 = $(data).find('#borrowerCapitalDiv');
					$("#borrowerCapitalDiv").empty().append( content1.html() );
					var content2 = $(data).find('#borBusSegDiv');
					$("#borBusSegDiv").empty().append( content2.html() );
					
					$("#borrowerGoldIdDetails").empty().append( content.html() );
					
					var c = $(data).find("#borrowerLegalEntityGoldId");
					var content3 = $(data).find('#borrowerPEorMEDiv');
					$("#borrowerPEorMEDiv").empty().append( content3.html() );
									
					if( c.val() == "" ){
						$("#borrowerInfoInvalid").show();
						$('#borrowerGoldIdDetails').hide();
						$("#borrowerInfofailedBar").show();
						$("#borrowerGoldIdInvalid").hide();
						$("#borrowerPEorMEDiv").hide();
						clearResults.hide();
					}else {
						$("#borrowerInfofailed").hide();
						$("#borrowerInfoInvalid").hide();
						$("#borrowerInfofailedBar").hide();
						$("#borrowerGoldIdInvalid").hide();
						$('#borrowerGoldIdDetails').show();
						$("#BorrowerSetUpFlagFDiv").show();
						$("#borBusSegFDiv").show();
						$("#borrowerPEorMEDiv").show();
						$("#borRegulatedEntityFlag1").attr("disabled", "disabled");
						$("#borRegulatedEntityFlag2").attr("disabled", "disabled");
						$("#borPrincplEntityFlag1").attr("disabled", "disabled");
						$("#borPrincplEntityFlag2").attr("disabled", "disabled");
					}
			});
		}
	});
	
	$("#searchByLegalEntityCDRCode").click( function(e){
		e.preventDefault();
		
		var guarantorGoldId = $("#guarantorInfo").val();
		$("#guarantorGoldIdDetails").val("");
		if(guarantorGoldId == ""){
			$("#guarantorInfofailed").show();
			$("#guarantorInfofailedBar").show();
			
			return false;
		}else{
			$("#guarantorInfofailed").hide();
			$("#guarantorInfofailedBar").hide();
						
			url = contextURL +"/frontoffice/RCALegRequest.do?command=getCDRCodeDetails&isFrontOffice=Yes";
			$.post( url, {guarantorInfo: guarantorGoldId,goldIdFlag:"guarantorDetails", searchFor:"CDR" },
					function(data){
					var content = $(data).find('#guarantorGoldIdDetails');
					$("#guarantorGoldIdDetails").empty().append( content.html() );
					$('#guarantorGoldIdDetails').show();
					
			});	
		}
	});
		
	$("#guarantorInfo").keypress( function(e){
		if (e.which == 13){
			e.preventDefault();
			$("#searchByLegalEntityCDRCode").click();
		}
	});
	
	$("#lenderOrProvider").keypress( function(e){
		if (e.which == 13){
			e.preventDefault();
			$("#searchByLenderGoldId").click();
		}
	});
		
	$("#borrowerOrRecipient").keypress( function(e){
		if (e.which == 13){
			e.preventDefault();
			$("#searchByBorrowerGoldId").click();
		}
	});
	
	$("#saveLegAndReturn").click( function(e){
		e.preventDefault();
		
		url = contextURL +"/frontoffice/fourBlocker.do?command=saveAndAddAnotherLeg";
		
		$.post( url, {},
				function(data){
				var content = $(data).find('#addLegDiv');
				
				$("#addLegDiv").empty().append( content.html() );
				
				window.history.back();
				$("#addLegDiv").show();
		}
	 );
	});

	
	$("#searchByLenderTreasuryFO").click( function(e){
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
			
			url = contextURL +"/frontoffice/RCALegRequest.do?command=getTCodeDetails";
			
			$.post( url, {lenderTreasuryCode: lenderTreasuryCode,goldIdFlag:"lenderTCode"},
					function(data){
					var content = $(data).find('#lenderTreasuryDetails');

					$("#lenderTreasuryDetails").empty().append( content.html() );
					
					var e = $(data).find("#lenderTreasuryGoldId");
					if( e.val() == "" ){
						$("#lenderTreasuryInvalid").show();
						$("#lenderTreasuryfailedBar").show();
						$('#lenderTreasuryDetails').hide();
					}else {
						$("#lenderTreasuryfailedBar").hide();
						$("#lenderTreasuryInvalid").hide();
						$('#lenderTreasuryDetails').show();
						$('#clearLenderTreasuryFO').show();						
					}
			});
		}
	});
	
	
	$("#searchByBorrowerTreasuryFO").click( function(e){
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
			
			url = contextURL +"/frontoffice/RCALegRequest.do?command=getTCodeDetails";
			
			$.post( url, {borrowerTreasuryCode: borrowerTreasuryCode,goldIdFlag:"borrowerTCode"},
					function(data){
					var content = $(data).find('#borrowerTreasuryDetails');
					
					$("#borrowerTreasuryDetails").empty().append( content.html() );
					
					var f = $(data).find("#borrowerTreasuryGoldId");
					if( f.val() == "" ){
						$("#borrowerTreasuryInvalid").show();
						$("#borrowerTreasuryfailedBar").show();
						$('#borrowerTreasuryDetails').hide();
					}else {
						$("#borrowerTreasuryfailedBar").hide();
						$("#borrowerTreasuryInvalid").hide();
						$('#borrowerTreasuryDetails').show();
						$('#clearBorrowerTreasuryFO').show();
					}
			});
		}
	});
	
	$("#lenderTreasuryCode").keypress( function(e){
		if (e.which == 13){
			e.preventDefault();
			$("#searchByLenderTreasuryFO").click();
		}
	});
	
	$("#borrowerTreasuryCode").keypress( function(e){
		if (e.which == 13){
			e.preventDefault();
			$("#searchByBorrowerTreasuryFO").click();
		}
	});
	
	$("#productType").change( function(e){
		e.preventDefault();
		
		var productType = $("#productType").val();
		productTypeOnChange(productType);
	});
	
	$("#equityFormId").change( function(e){
		e.preventDefault();
		
		var equityFormId = $('#equityFormId').val();
		equityFormIdOnChange(equityFormId);
		$("#equityDescriptionID").val("");
	});
	
	$("#immediateDrawDownAmt").keypress( function(e){
		if (e.which == 13){
			e.preventDefault();
			
			$("#immediateDrawDownAmt").focusout();
		}
	});
		
	$("#immediateDrawDownAmt").change( function(e){
		var drawDownAmt = $("#immediateDrawDownAmt").val();
		if(isNumber(drawDownAmt) && !(parseFloat(drawDownAmt) < 0)) {
			 var value = commaSeperateAmt(drawDownAmt);
			 $("#immediateDrawDownAmt").val( value );
			$("#immdtDrdownAmtfailedBar").hide();
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
	
	$("#issuePriceID").change( function(e){
		var issuePriceID = $("#issuePriceID").val();
		if(issuePriceID!=""){
			if(isNumber(issuePriceID) && !(parseFloat(issuePriceID) < 0)) {
				$("#issuePricefailedBar").hide();
			}else{
				$("#issuePricefailedBar").show();
			}
		}else{
			$("#issuePricefailedBar").hide();
		}
	});
	
	$("#agentDealerCommissionID").change( function(e){
		var agentDealerCommissionID = $("#agentDealerCommissionID").val();
		if(agentDealerCommissionID!=""){
			if(isNumber(agentDealerCommissionID) && !(parseFloat(agentDealerCommissionID) < 0)) {
				$("#agentDealerCommissionfailedBar").hide();
			}else{
				$("#agentDealerCommissionfailedBar").show();
			}
		}else{
			$("#agentDealerCommissionfailedBar").hide();
		}
	});
	$("#netProceedsID").change( function(e){
		var netProceedsID = $("#netProceedsID").val();
		if(isNumber(netProceedsID) && !(parseFloat(netProceedsID) < 0)) {
			$("#netProceedsIfailedBar").hide();
		}else{
			$("#netProceedsIfailedBar").show();
		}
	});

});
/**
 * Base on product type, it handles the divs disable and unable
 * @param productType
 * @param equityFormId
 */
function productTypeOnChange(productType,equityFormId){
	$("#derDiv").show();
	
	if(productType=='1' || productType=='2' || productType=='5' || productType=='6'){
		if(productType == "1"){
			
			$('.conditional-lender').text("Lender");
			$('.conditional-borrower').text("Borrower");
			$('.conditional-type-variable').text("RCA");
			$("#formOfEquityDiv").hide();
			$("#termDiv").show();
			$("#formOfRCALegDiv").show();
			$('#guarantorGoldIdDetails').show();
			$("#infusionDiv").hide();
			$("#doubleLeverageDiv").hide();
			$('.product-type-debtfields, .product-type-debtfields,.product-type-all').hide();
			$('.product-type-all, .product-type-comments').hide();
			$("#eBoardEligibleDiv").hide();
			$("#derDivEquity").show();
			$("#immdtDrdownAmtDiv").hide();
			
			var otherFeeFlag = document.forms[0].elements["otherFeeFlag"];
			  if(otherFeeFlag[0].checked)
			  {
				  $("#otherfeesAmtDiv").show;
			   }else{
				   $("#otherfeesAmtDiv").hide(); 
			  }
				
			
		}else if(productType == "2"){
			$('.conditional-lender').text("Provider");
			$('.conditional-borrower').text("Recipient");
			$('.conditional-type-variable').text("EQUITY");
			$("#formOfEquityDiv").show();
			if(equityFormId!=undefined && equityFormId!=""){
				$(".product-type-all").show();
			}
			$("#termDiv").hide();
			$("#termInMonths").val("");
			$("#formOfRCALegDiv").hide();
			$("#infusionDiv").show();
			$("#doubleLeverageDiv").show();
			$("#derDivEquity").hide();
			$("#eBoardEligibleDiv").show();
			if(equityFormId!=""){
				equityFormIdOnChange(equityFormId);
			}
		}else if(productType == "5"){
			$('.conditional-lender').text("Lender");
			$('.conditional-borrower').text("Borrower");
			$('.conditional-type-variable').text("TERM LOAN");
			$("#formOfEquityDiv").hide();
			$("#termDiv").show();
			$("#formOfRCALegDiv").show();
			$("#infusionDiv").hide();
			$("#doubleLeverageDiv").hide();
			$('.product-type-debtfields, .product-type-debtfields,.product-type-all').hide();
			$('.product-type-all, .product-type-comments').hide();
			$("#eBoardEligibleDiv").hide();
			$("#derDivEquity").show();
		}else if(productType == "6"){
			$('.conditional-lender').text("Purchaser");
			$('.conditional-borrower').text("Issuer");
			$('.conditional-type-variable').text("BOND");
			$("#formOfEquityDiv").hide();
			$("#termDiv").show();
			$("#formOfRCALegDiv").show();
			$("#infusionDiv").hide();
			$("#doubleLeverageDiv").hide();
			$('.product-type-debtfields, .product-type-debtfields,.product-type-all').hide();
			$('.product-type-all, .product-type-comments').hide();
			$("#eBoardEligibleDiv").hide();
			$("#derDivEquity").show();
		}
		$("#subordinateDiv").show();
		$('#termMandatoryDiv').show();
		$('#excepMandatoryDiv').show();
		$('#derMandatoryDiv').show();
		$("#othersDescriptionComments").hide();
	}else if(productType == "4"){
		$('.conditional-lender').text("Lender");
		$('.conditional-borrower').text("Borrower");
		$("#subordinateDiv").hide();
		$("#existDiv").hide();
		$("#formOfEquityDiv").hide();
		$("#termDiv").show();
		$("#formOfRCALegDiv").show();
		$("#infusionDiv").hide();
		$("#doubleLeverageDiv").hide();
		$('.product-type-debtfields, .product-type-debtfields,.product-type-all').hide();
		$('.product-type-all, .product-type-comments').hide();
		$("#eBoardEligibleDiv").hide();
		$('#derDivEquity').show();
		$('#termMandatoryDiv').hide();
		$('#excepMandatoryDiv').hide();
		$('#derMandatoryDiv').hide();
		$("#legalAgreementDiv").removeClass("req-error");
		$("#termValidateBar").hide();
		$("#othersDescriptionComments").show();
	}
	var originalCCY = $("#originalCCY").val();
	var originalCCYAmount =  $("#originalCCYAmount").val();
	
	if(originalCCY!="" && originalCCYAmount!=""){
		$('#usdEquiDiv').show();
	}
}
/**
 * Deletes the derivative
 * @param id
 */
function deleteDerivative(id){
	removeDisableFlag();
	var val = $( "#otherFeeAmt" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#otherFeeAmt" ).val(val);
	}
	var derivativeNumber = $(id).parent().next().next().html();
    document.getElementById('derivativeNumber').value = derivativeNumber;
	
	var fundingRequestForm = document.getElementById('ICFPLegRequestForm');
	fundingRequestForm.action =  contextURL+"/frontoffice/RCALegRequest/derivativeRequest.do?command=deleteDerivative&derivativeNumber="+derivativeNumber;
	fundingRequestForm.submit();
}

/**
 * Modified the existing derivate
 * @param id
 */
function modifyDerivative(id){
	removeDisableFlag();
	var val = $( "#otherFeeAmt" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#otherFeeAmt" ).val(val);
	}
	var derivativeNumber = $(id).parent().next().html();
	document.getElementById('derivativeNumber').value = derivativeNumber;
	var fundingRequestForm = document.getElementById('ICFPLegRequestForm');
	fundingRequestForm.action =  contextURL+"/frontoffice/RCALegRequest/derivativeRequest.do?command=openDerivative&modifyDerivative=true&derivativeNumber="+derivativeNumber;
	fundingRequestForm.submit();
	
}
/**
 * To add a new derivative
 * @param cmd
 */
function addDerivatives(cmd){
	removeAmountShortcuts();
	removeDisableFlag();
	var val = $( "#otherFeeAmt" ).val();
	if(val!=undefined){
		val = val.replace(/,/g,"");
		$( "#otherFeeAmt" ).val(val);
	}
	
	removeAmountShortcuts();

	var RCALegRequestForm = document.getElementById('ICFPLegRequestForm');
	var action = RCALegRequestForm.action;
	action = action+cmd; 
	RCALegRequestForm.action = action;
	RCALegRequestForm.submit();
}

function removeDisableFlag()
{
	
	    $("#borRegulatedEntityFlag1").removeAttr("disabled");
		$("#borRegulatedEntityFlag2").removeAttr("disabled");
		$("#borPrincplEntityFlag1").removeAttr("disabled");
		$("#borPrincplEntityFlag2").removeAttr("disabled");
		
		$("#regulatedEntityFlag1").removeAttr("disabled");
		$("#regulatedEntityFlag2").removeAttr("disabled");
		$("#princplEntityFlag1").removeAttr("disabled");
		$("#princplEntityFlag2").removeAttr("disabled");
}




/**
 * To make the amout as comma seperated
 * @param usdEquiDiv
 */
function commaSeperateUsd(usdEquiDiv){
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
	$("#usdEquiDiv").val( value );
}

function submitActionFORCALeg(obj){
	var actionType = $('input:radio[name=saveAction]:checked').val();
	if(actionType==undefined){
		$('#saveRadioDiv').addClass("req-error");
		return;
	}
	if(actionType == 'saveNextLeg'){
		validateFrontOfficeLeg('?command=saveNextLeg&isFrontOffice=Yes');
	}else if(actionType == 'saveReturnDeal'){
		validateFrontOfficeLeg('?command=saveAndReturnToDeal&isFrontOffice=Yes');
	}

}


/**
 * Validates the mandatory fields
 * @param cmd
 */
function validateFrontOfficeLeg(cmd){
	var validateflag = false;
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
	
	var lenderMgmtEntity = $("#selectedLenderMgmtEntity").val();
	if(lenderMgmtEntity == ""){
		$("#lenderMgmtfailedBar").show();
		validateflag = true;
	}else {
		$("#lenderMgmtfailedBar").hide();
	}
		
	var lendercdr = $('#lenderLegalEntityGoldId').val();
	var borrowercdr = $('#borrowerLegalEntityGoldId').val();
		
	if(borrowercdr != "" && lendercdr!="" && borrowercdr == lendercdr){
		$("#borrowerGoldIdInvalid").show();
		$("#borrowerInfofailedBar").show();
		validateflag = true;
	}else{
		$("#borrowerInfofailedBar").hide();
		$("#borrowerGoldIdInvalid").hide();
	}
	
	var borrowerGoldId = $("#borrowerLegalEntityGoldId").val();
	if(borrowerGoldId == "" && !($('input[id=borrowerEntitySetupFlag]:checked').val()=="Y")){
		$("#borrowerInfofailedBar").show();
		validateflag = true;
		$("#borrowerRegDiv").removeClass("req-error");
		$("#borrowerPriDiv").removeClass("req-error");
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
	var productType = $("#productType").val();
		
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
	
	var isNonStandardLegalAgreement = $('input[id=isNonStandardLegalAgreement]:checked').val();	
	if(productType == "1" || productType == "5" || productType == "6"){
		var subordinatedDebt = $('input[id=subordinatedDebt]:checked').val();
		if(!(subordinatedDebt == "true" || subordinatedDebt == "false")){
			$("#subordinatedDiv").addClass("radio-container req-error");
			validateflag = true;
		}else {
			$("#subordinatedDiv").removeClass("req-error");
		}
		
		var derivativesFlag = $('input[id=derivativesFlag]:checked').val();
		if(!(derivativesFlag == "true" || derivativesFlag == "false")){
			$("#derivativDiv").addClass("radio-container derivativesConditional req-error");
			validateflag = true;
		}else if(derivativesFlag == "true"){
			var derFlag = $("#derFlag").val();
			if(derFlag == "0"){
				validateflag = true;
				$("#derFlagValidate").show();
			}else{
				$("#derFlagValidate").hide();
			}
			$("#derivativDiv").removeClass("req-error");
		}else {
			$("#derivativDiv").removeClass("req-error");
			$("#derFlagValidate").hide();
		}
		if(!(isNonStandardLegalAgreement == "true" || isNonStandardLegalAgreement == "false")){
			$("#legalAgreementDiv").addClass("radio-container exceptionsConditional req-error");
			validateflag = true;
		}else {
			$("#legalAgreementDiv").removeClass("req-error");
		}
			
	}else if(productType == "2"){
		var  equityFormId = $('#equityFormId').val();
		if(equityFormId == ""){
			$("#equityFormValidate").show();
			validateflag = true;
		}else {
			$("#equityFormValidate").hide();
		}
		
		var doubleLeverageFlag = $('input[id=doubleLeverageFlag]:checked').val();
		if(!(doubleLeverageFlag == "true" || doubleLeverageFlag == "false")){
			$("#doubleLeverage").addClass("radio-container req-error");
			validateflag = true;
		}else {
			$("#doubleLeverage").removeClass("req-error");
		}
		//equityValidation
		var equityFormId = $('#equityFormId').val();
		if(equityFormId==1 || equityFormId==2 || equityFormId==3){
			if( equityValidation() ){
			}else{
				validateflag = true;
			}
		}
				
		if(equityFormId==5){
			var  equityDescriptionID = $('#equityDescriptionID').val();
			if(equityDescriptionID == ""){
				$('#equityDescBar').show();
				validateflag = true;
			}else{
				$('#equityDescBar').hide();
			}
		}
		
		var subordinatedDebt = $('input[id=subordinatedDebt]:checked').val();
		if(!(subordinatedDebt == "true" || subordinatedDebt == "false")){
			$("#subordinatedDiv").addClass("radio-container req-error");
			validateflag = true;
		}else {
			$("#subordinatedDiv").removeClass("req-error");
		}
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
	
	var originalCCY = $("#originalCCY").val();
	if(originalCCY == ""){
		$("#originalCCYValidateBar").show();
		validateflag = true;
	}else {
		$("#originalCCYValidateBar").hide();
	}
	
	if(productType != "2"){
		 var termInMonths = $("#termInMonths").val();
		 if(productType != "4"){
			if(termInMonths == ""){
				$("#termValidateBar").show();
				$("#termValidateNumber").hide();
				validateflag = true;
			}else {
				if(isNumber(termInMonths) && !(parseInt(termInMonths) <= 0)) {
					$("#termValidateNumber").hide();
				 }else{
					$("#termValidateNumber").show();
					validateflag = true;
				 }
				$("#termValidateBar").hide();
			}
		 }
		if(productType == "1" || productType == "5" || productType == "6"){
			var derivativesFlag = $('input[id=derivativesFlag]:checked').val();
			if(!(derivativesFlag == "true" || derivativesFlag == "false")){
				
				$("#derivativDiv").addClass("radio-container derivativesConditional req-error");
				validateflag = true;
			}else if(derivativesFlag == "true"){
				var derFlag = $("#derFlag").val();
				if(derFlag == "0"){
					validateflag = true;
					$("#derFlagValidate").show();
				}else{
					$("#derFlagValidate").hide();
				}
				$("#derivativDiv").removeClass("req-error");
			}else {
				$("#derivativDiv").removeClass("req-error");
				$("#derFlagValidate").hide();
			}
		}
	 }
	
	var originalCCYAmount = $("#originalCCYAmount").val();
	var val = originalCCYAmount;
	val = val.replace(/,/g,"");
	originalCCYAmount = val;
	if(originalCCYAmount == ""){
		$("#originalCCYAmountValidateBar").show();
		$("#originalCCYAmountValidateNumber").hide();
		validateflag = true;
	}else {
		if(IsNumeric(originalCCYAmount)) {
			$("#originalCCYAmountValidateNumber").hide();
		 }else{
			$("#originalCCYAmountValidateNumber").show();
			validateflag = true;
		 }
		$("#originalCCYAmountValidateBar").hide();
	}
	
	if(productType == "1"){
		/*  validate Drawdown */
		var immediateDrawdownApplicable = $('input[id=isImmediateDrawDown]:checked').val();
		if(!(immediateDrawdownApplicable == "true" || immediateDrawdownApplicable == "false")){
			$("#immediateDrawdownDiv").addClass("radio-container req-error");
			validateflag = true;
		}else {
			$("#immediateDrawdownDiv").removeClass("req-error");
		}
	
		//validate Immediate drawdown applicable :Radio button selection
		if(immediateDrawdownApplicable == "true"){
			
			var immediateDrawDownAmt = $("#immediateDrawDownAmt").val();
					
			var val = immediateDrawDownAmt;
			if(val!=undefined){
				val = val.replace(/,/g,"");
				$( "#immediateDrawDownAmt" ).val(val);
			}
			immediateDrawDownAmt = val;
			if(immediateDrawDownAmt == "" || immediateDrawDownAmt.match('^[0-9]*\.[0-9]*$')==null || parseFloat(immediateDrawDownAmt) < 0){
				$("#immdtDrdownAmtfailedBar").show();
				validateflag = true;
			}else {
				$("#immdtDrdownAmtfailedBar").hide();
			}
			
			var immediateDrawdownValueDateID = $("#immediateDrawdownValueDateID").val();
			if(immediateDrawdownValueDateID == "" ){
				$("#drdownValueDtfailedBar").show();
				validateflag = true;
			}else {
				$("#drdownValueDtfailedBar").hide();
			}
			
			var drawDownFlag = false;
			var valueDt = $("#valueDateID").val();
			
			if(immediateDrawdownValueDateID != "" && valueDt!="" ){
				var drawDownDate = new Date(immediateDrawdownValueDateID);
				var valueDate = new Date(valueDt);
				if(drawDownDate < valueDate){
					 $("#drawdownvalueDtErrorID").show();
					 validateflag = true;
					 drawDownFlag= true;
				 }
			}
			
			if(immediateDrawdownValueDateID != "" && drawDownFlag== false){
				var requestFrmtDt = $("#todayDateID").val();
				var drawDownDate = new Date(immediateDrawdownValueDateID);
				var reqDate = new Date(requestFrmtDt);
				if(drawDownDate < reqDate){
					 $("#drdownValueDtfailedBar").show();
						validateflag = true;
				 }
			}
			
		}
	}
	
	if(productType == "1" || productType == "6" || productType == "4" || productType == "5"){
		/*  validate Terms and conditions */
		//validate Interest type :Radio button selection
		var fixedOrFloat = $('input[id=fixedOrFloatRadioId]:checked').val();
		if(productType != "4"){
			if(!(fixedOrFloat == "1" || fixedOrFloat == "2")){
				$("#interestTypeDiv").addClass("radio-container req-error");
				validateflag = true;
			}else {
				$("#interestTypeDiv").removeClass("req-error");
			}
		}
		if(fixedOrFloat == "1"){
			var baseFixedRateID = $("#baseFixedRateID").val();
			if(baseFixedRateID=="" || (baseFixedRateID != "" && (baseFixedRateID.match('^[0-9]*\.[0-9]*$')==null || parseFloat(baseFixedRateID) < 0))){
				$("#baseFixedRatefailedBar").show();
				validateflag = true;
			}else {
				$("#baseFixedRatefailedBar").hide();
			}
			
			var fixedSpreadID = $("#fixedSpreadID").val();
			if(fixedSpreadID=="" || (fixedSpreadID != "" && (fixedSpreadID.match('^[-0-9]*\.[0-9]*$')==null ))){
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
		if(fixedOrFloat == "2"){
			var floatRateIndexId = $("#floatRateIndexId").val();
			if(floatRateIndexId == ""){
				$("#floatRatefailedBar").show();
				validateflag = true;
			}else {
				$("#floatRatefailedBar").hide();
			}
			var floatSpreadID = $("#floatSpreadID").val();
			if(floatSpreadID=="" || (floatSpreadID != "" && (floatSpreadID.match('^[-0-9]*\.[0-9]*$')==null))){
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
			var floatRateIndexTermId = $("#floatRateIndexTermId").val();
			if(floatRateIndexTermId == ""){
				$("#floatRateTermfailedBar").show();
				validateflag = true;
			}else {
				$("#floatRateTermfailedBar").hide();
			}
		}
	
		
		var withhldngTaxApplicableFlagId = $('input[id=withhldngTaxApplicableFlagId]:checked').val();
		if(!(withhldngTaxApplicableFlagId == "true" || withhldngTaxApplicableFlagId == "false")){
			$("#withhldngTaxApplicableDiv").addClass("radio-container exceptionsConditional req-error");
			validateflag = true;
		}else {
			$("#withhldngTaxApplicableDiv").removeClass("req-error");
		}
		
		//validate otherFee applicable :Radio button selection
		
		if(productType=="1" || productType=='5'){
		var otherFeeFlag = $('input[id=isOtherfees]:checked').val();
		if(otherFeeFlag == "true"){
			
			var otherFeeCCY = $("#otherFeeCCY").val();
			if(otherFeeCCY == ""){
				$("#otherFeeCCYValidateBar").show();
				validateflag = true;
			}else {
				$("#otherFeeCCYValidateBar").hide();
			}
			var otherFeeAmt = $("#otherFeeAmt").val();
			var val = otherFeeAmt;
			val = val.replace(/,/g,"");
			otherFeeAmt = val;
			if(otherFeeAmt == ""){
				$("#otherFeeAmtValidateBar").show();
				$("#otherFeeAmtValidateNumber").hide();
				validateflag = true;
			}else {
				if(IsNumeric(otherFeeAmt)) {
					$("#otherFeeAmtValidateNumber").hide();
				 }else{
					$("#otherFeeAmtValidateNumber").show();
					validateflag = true;
				 }
				$("#otherFeeAmtValidateBar").hide();
			}
			
		}
	}
		
		/*  validate Fees and Withholding end */
		
		
		
		if(!validateGuarantorFlag()){
			validateflag = true;
		}
		
		/*  validate Other Considerations start */
		var crossBorderFlagId = $('input[id=crossBorderFlagId]:checked').val();
		if(!(crossBorderFlagId == "true" || crossBorderFlagId == "false")){
			$("#crossBorderDiv").addClass("radio-container exceptionsConditional req-error");
			validateflag = true;
		}else {
			$("#crossBorderDiv").removeClass("req-error");
		}
		
	}
	
	if(productType == "4"){
		var  otherDesc = $('#otherDesc').val();
		if(otherDesc == ""){
			$('#otherDesBar').show();
			validateflag = true;
		}else{
			$('#otherDesBar').hide();
		}
	}
	
	if(productType == "2"){
		var isNonStandardLegalAgreement = $('input[id=isNonStandardLegalAgreement]:checked').val();
		var isCrossBorderFlag = $('input[id=crossBorderFlagId]:checked').val();
		
		if(!(isNonStandardLegalAgreement == "true" || isNonStandardLegalAgreement == "false")){
			$("#legalAgreementDiv").addClass("radio-container exceptionsConditional req-error");
			validateflag = true;
		}else {
			$("#legalAgreementDiv").removeClass("req-error");
		}
		if(!(isCrossBorderFlag == "true" || isCrossBorderFlag == "false")){
			$("#crossBorderDiv").addClass("radio-container req-error");
			validateflag = true;
		}else {
			$("#crossBorderDiv").removeClass("req-error");
		}
	}
	
	var isVisible = false;
	$('.invalid').each(function(){
		if($('.invalid').is(":visible")){
			isVisible = $('.invalid').is(":visible");
		}
	});
	
	
	
	$('.me-lookup').each( function(){
		var e = $(this).siblings(".error");
		if( $(e).is(":visible") ){
			validateflag = true;
		}
	})
	
	if(validateflag == false  && !isVisible){
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
		removeAmountShortcuts();
		removeUsdShortcuts();
		//removing commas for other fee
		var val = $( "#otherFeeAmt" ).val();
		if(val!=undefined){
			val = val.replace(/,/g,"");
			$( "#otherFeeAmt" ).val(val);
		}
		
		document.getElementById("lenderOrProvider").value = $('#lenderOrProvider').val().toUpperCase();
		document.getElementById("borrowerOrRecipient").value = $('#borrowerOrRecipient').val().toUpperCase();
		
		var productType = $("#productType").val();
		if(productType == "2"){
			var equityFormId = $('#equityFormId').val();
			if(equityFormId==1 || equityFormId==2 || equityFormId==3 || equityFormId==5){
				$('.product-type-debtfields').remove();
			}
			if(equityFormId==4){
				$('.product-type-all').remove();
			}
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
		

		removeDisableFlag();

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
	  var validateGFlag = true;
	    var guaranteeFeeApplicableFlagId = $('input[id=guaranteeFeeApplicableFlagId]:checked').val();
	    
	    var guarantorCDRCode = $("#guarantorInfo").val();
		if(guarantorCDRCode == "" && guaranteeFeeApplicableFlagId == "true"){
			$("#guarantorInfofailedBar").show();
			validateGFlag= false;
		}else {
			$("#guarantorInfofailedBar").hide();
			
		}
		
		var guarantorMgmtEntity = $("#selectedGuarantorMgmtEntity").val();
		if(guarantorMgmtEntity == "" && guaranteeFeeApplicableFlagId == "true"){
			$("#guarantorMgmtfailedBar").show();
			validateGFlag = false;
		}else {
			$("#guarantorMgmtfailedBar").hide();
		}
		
		return validateGFlag;
	    
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
