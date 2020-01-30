
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

$(document).ready(function(){
	
	var productType = $("#productType").val();
	
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
	
	$('#commenstDiv').hide();
	
	$("#agentDealerCommissionID").change( function(e){
		var agentDealerCommissionID = $("#agentDealerCommissionID").val();
		if(agentDealerCommissionID!=""){
			if(isNumber(agentDealerCommissionID) && !(parseFloat(agentDealerCommissionID) < 0)) {
				$("#agentDealerCommissionfailedBar").hide();
			}else{
				$("#agentDealerCommissionfailedBar").show();
			}
		}else {
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
	
	var equityFormId = $("#equityFormId").val();
	if(productType!=""){
		productTypeOnChange(productType, equityFormId);
	}
	
	if(productType == "4"){
		var otherDescLen = $("#otherDesc").val();
		var othlength = otherDescLen.length;
		othlength = 1000-othlength;
		$(".otherDescChar").text(othlength);
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
	
	
	var lenderTreasuryCode = $("#lenderTreasuryGoldId").val();
	if(lenderTreasuryCode!=""){
		$('#lenderTreasuryDetails').show();
		$('#clearLenderTreasury').show();
	}
	
	var borrowerTreasuryCode = $("#borrowerTreasuryGoldId").val();
	if(borrowerTreasuryCode!=""){
		$('#borrowerTreasuryDetails').show();
		$('#clearBorrowerTreasury').show();
	}
	
	var derivativesFlag = $('input[id=derivativesFlag]:checked').val();
	if(derivativesFlag == "true"){
		$('#derivatives-table').show();
	}else {
		$('#derivatives-table').hide();
	}
	
	if(productType=="1"){
		var isImmediateDrawDown = $('input[id=isImmediateDrawDown]:checked').val();
		if(isImmediateDrawDown == "true"){
			$('#immdtDrdownAmtDiv').show();
			var immediateDrawdownValueDt = $("#immediateDrawdownValueDateID").val();
			if(immediateDrawdownValueDt == ""){
				var valueDt = $("#valueDateID").val();
				if(valueDt!="" ){
					$("#immediateDrawdownValueDateID").val(valueDt);
				}
			}

		}else {
			$('#immdtDrdownAmtDiv').hide();
		}
	}else{
		$('#immediateDrawDownID').hide();
		$('#immdtDrdownAmtDiv').hide();
	}
	
	var isNonStandardLegalAgreement = $('input[id=isNonStandardLegalAgreement]:checked').val();
	if(isNonStandardLegalAgreement == "true"){
		$('#exceptionDiv').show();
	}else {
		$('#exceptionDiv').hide();
	}
	
	var amount = $("#originalCCYAmount").val();
	if(amount!="" && amount!=null){
		commaSeperate(amount);
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
	
	
	var  equityDescriptionCommentsValue = $('#equityDescriptionCommentsId').val();
	if(equityDescriptionCommentsValue!=null && equityDescriptionCommentsValue!='undefined' && equityDescriptionCommentsValue!='')
		{
	    	$('#equityDescriptionID').val(equityDescriptionCommentsValue);
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
			$("#LEGoldId").val("");
		}else{
			$("#lenderOrProvider").removeAttr("disabled");
			$("#lenderTreasuryCode").removeAttr("disabled");
			$("#searchByLenderGoldId").removeAttr("disabled");
			$('#searchByLenderTreasury').removeAttr("disabled");
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
			$('#searchByBorrowerTreasury').removeAttr("disabled");
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
			
			url = contextURL +"/RCALegRequest.do?command=getGoldIdDetails";
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
		
			url = contextURL +"/RCALegRequest.do?command=getGoldIdDetails";
			
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
		
						
			url = contextURL +"/RCALegRequest.do?command=getGoldIdDetails";
			$.post( url, {guarantorInfo: guarantorGoldId,goldIdFlag:"guarantorDetails", searchFor:"CDR" },
					function(data){
					var content = $(data).find('#guarantorGoldIdDetails');
					
					$("#guarantorGoldIdDetails").empty().append( content.html() );
					$('#guarantorGoldIdDetails').show();
					
			});					
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
		
		url = contextURL +"/fundingRequest/newFundingRequest.do?command=saveAndAddAnotherLeg";
		
		$.post( url, {},
				function(data){
				var content = $(data).find('#addLegDiv');
				
				$("#addLegDiv").empty().append( content.html() );
				
				window.history.back();
				$("#addLegDiv").show();
		}
	 );
	});

	
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
			
			url = contextURL +"/RCALegRequest.do?command=getTCodeDetails";
			
			$.post( url, {lenderTreasuryCode: lenderTreasuryCode,goldIdFlag:"lenderTCode"},
					function(data){
					var content = $(data).find('#lenderTreasuryDetails');
					$("#lenderTreasuryDetails").empty().append( content.html() );
					
					var e = $(data).find("#lenderTreasuryGoldId");
					if( $(e).val() === "" ){
						$("#lenderTreasuryInvalid").show();
						$("#lenderTreasuryfailedBar").show();
						$('#lenderTreasuryDetails').hide();
					}else {
						$("#lenderTreasuryfailedBar").hide();
						$("#lenderTreasuryInvalid").hide();
						$('#lenderTreasuryDetails').show();
						$('#clearLenderTreasury').show();
					}
			});
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
			
			url = contextURL +"/RCALegRequest.do?command=getTCodeDetails";
			
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
						$('#clearBorrowerTreasury').show();
					}
			});
		}
	});
	
	$("#lenderTreasuryCode").keypress( function(e){
		if (e.which == 13){
			e.preventDefault();
			$("#searchByLenderTreasury").click();
		}
	});
	
	$("#borrowerTreasuryCode").keypress( function(e){
		if (e.which == 13){
			e.preventDefault();
			$("#searchByBorrowerTreasury").click();
		}
	});
	
	$('#shareValue').keypress( function(e){
		if (e.which == 46){
			$("#shareValue").attr('maxlength','23');
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
	
});

/**
 * Method to show the fields based on the Product Type
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
			$("#doubleLeverageDiv").hide();
			$('.product-type-debtfields, .product-type-debtfields,.product-type-all').hide();
			$('.product-type-all, .product-type-comments').hide();
			$("#eBoardEligibleDiv").hide();
			$("#derDivEquity").show();
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
			$("#formOfRCALegDiv").hide();
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
			$("#formOfRCALegDiv").hide();
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
		$('#crossMandatoryDiv').show();
		$("#othersDescriptionComments").hide();
	}else if(productType == "4"){
		$('.conditional-lender').text("Lender");
		$('.conditional-borrower').text("Borrower");
		$("#subordinateDiv").hide();
		$("#formOfEquityDiv").hide();
		$("#termDiv").show();
		$("#formOfRCALegDiv").hide();
		$("#doubleLeverageDiv").hide();
		$('.product-type-debtfields, .product-type-debtfields,.product-type-all').hide();
		$('.product-type-all, .product-type-comments').hide();
		$("#eBoardEligibleDiv").hide();
		$('#derDivEquity').show();
		$('#termMandatoryDiv').hide();
		$('#excepMandatoryDiv').hide();
		$('#derMandatoryDiv').hide();
		$('#crossMandatoryDiv').hide();
		$("#legalAgreementDiv").removeClass("req-error");
		$("#termValidateBar").hide();
		$("#derivativDiv").removeClass("req-error");
		$("#crossborderDiv").removeClass("req-error");
		$("#othersDescriptionComments").show();
	}
	var originalCCY = $("#originalCCY").val();
	var originalCCYAmount =  $("#originalCCYAmount").val();
	
	if(originalCCY!="" && originalCCYAmount!=""){
		$('#usdEquiDiv').show();
	}
}




/**
 * Validations for all the products based the click of Save and return to deal
 * @param cmd
 */
function validate(cmd){
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
		
		var derivativeCount = $("#derivativeCountID").val();
		var derivativesFlag = $('input[id=derivativesFlag]:checked').val();
		if(derivativeCount!=null && derivativeCount<=0 && derivativesFlag == "true")
		{
			validateflag = true;
			$("#derFlagValidatee").show();
		}else{
			$("#derFlagValidatee").hide();
		}
		
		var termInMonths = $("#termInMonths").val();
		if(termInMonths == ""){
			$("#termValidateBar").show();
			$("#termValidateNumber").hide();
			validateflag = true;
		}else {
			if(isNumber(termInMonths) && !(parseFloat(termInMonths) <= 0)) {
				$("#termValidateNumber").hide();
			 }else{
				$("#termValidateNumber").show();
				validateflag = true;
			 }
			$("#termValidateBar").hide();
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
	}
	
	if(productType == "4"){
		var  otherDesc = $('#otherDesc').val();
		if(otherDesc == ""){
			$('#otherDesBar').show();
			validateflag = true;
		}else{
			$('#otherDesBar').hide();
		}
		
		var derivativeCount = $("#derivativeCountID").val();
		var derivativesFlag = $('input[id=derivativesFlag]:checked').val();
		if(derivativeCount!=null && derivativeCount<=0 && derivativesFlag == "true")
		{
			validateflag = true;
			$("#derFlagValidatee").show();
		}else{
			$("#derFlagValidatee").hide();
		}
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
		 $("#drawdownvalueDtErrorID").hide();
		 $("#drawdownvalueDtTodayID").hide();
		 
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
			
			
			if(immediateDrawdownValueDateID != ""  && drawDownFlag== false){
				var requestFrmtDt = $("#todayDateID").val();
				var drawDownDate = new Date(immediateDrawdownValueDateID);
				var reqDate = new Date(requestFrmtDt);
				if(drawDownDate < reqDate){
					 $("#drawdownvalueDtTodayID").show();
						validateflag = true;
						
				 }
			}
			
			
		}
	}
	
	var isNonStandardLegalAgreement = $('input[id=isNonStandardLegalAgreement]:checked').val();
	var isCrossBorderFlag = $('input[id=crossBorderFlag]:checked').val();
	

	if(productType == "1" || productType == "5" || productType == "6" || productType == "2"){
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
		}
		if(!(isCrossBorderFlag == "true" || isCrossBorderFlag == "false")){
			$("#crossborderDiv").addClass("radio-container req-error");
			validateflag = true;
		}else {
			$("#crossborderDiv").removeClass("req-error");
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
	
	var originalCCYAmount = $("#originalCCYAmount").val();
	var val = originalCCYAmount;
	val = val.replace(/,/g,"");
	originalCCYAmount = val;
	
	if(originalCCYAmount == ""){
		$("#originalCCYAmountValidateBar").show();
		$("#originalCCYAmountValidateNumber").hide();
		validateflag = true;
	}else {
		
		if(!(isNumber(originalCCYAmount)) || parseFloat(originalCCYAmount) <= 0) {
			$("#originalCCYAmountValidateNumber").show();
			validateflag = true;
		}else{
			$("#originalCCYAmountValidateNumber").hide();
		}
		$("#originalCCYAmountValidateBar").hide();
	}
	
	var USDEquivalent = $("#USDEquivalent").val();
	if(USDEquivalent!=undefined){
		var val = USDEquivalent;
		val = val.replace(/,/g,"");
		USDEquivalent = val;
		if(originalCCY != "" && originalCCYAmount != "" && (USDEquivalent == "" || parseFloat(USDEquivalent) <= 0)){
			$("#usdValidateBar").show();
			validateflag = true;
		}else{
			$("#usdValidateBar").hide();
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
	
		
	
	
	if(validateflag == false && !isVisible){
		
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
		
		removeDisableFlag();
		
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
 * Method to delete the derivatives
 * @param id
 */
function deleteDerivative(id){
	$('#dealDeriv'+id+'').remove();
	removeDisableFlag();
	
	var derivativeNumber = id;
    document.getElementById('derivativeNumber').value = derivativeNumber;
	
	var fundingRequestForm = document.getElementById('ICFPLegRequestForm');
	fundingRequestForm.action =  contextURL+"/derivativeRequest.do?command=deleteDerivative";
	fundingRequestForm.submit();
}

/**
 * Method to modify the derivatives
 * @param id
 */
function modifyDerivative(id){
	removeDisableFlag();
	var derivativeNumber = $(id).parent().next().html();
	document.getElementById('derivativeNumber').value = derivativeNumber;
	var fundingRequestForm = document.getElementById('ICFPLegRequestForm');
	fundingRequestForm.action =  contextURL+"/derivativeRequest.do?command=openDerivative&modifyDerivative=true";
	fundingRequestForm.submit();
	
}


/**
 * Method to add the derivatives
 * @param cmd
 */
function addDerivatives(cmd){
	removeAmountShortcuts();
	removeUsdShortcuts();
	removeDisableFlag();
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

 	function addDerivative(){
		var legRequestForm = document.getElementById('ICFPLegRequestForm');
		action = legRequestForm.action;
		action = action + '?command=addDerivatives';
		legRequestForm.action = action;
		legRequestForm.submit();
	}
	function displayResult(x)
	{
	x.rowIndex/3;
	}
