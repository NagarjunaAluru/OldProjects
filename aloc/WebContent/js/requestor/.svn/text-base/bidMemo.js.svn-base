$(document).ready(function() {
	
	amountTowords();
	
	if (window.PIE) {
        $('.main,.btn,.nav-tabs > li > a').each(function() {
            PIE.attach(this);
        });
    }
	
	var requestForProposalTrue =$('input[id=requestForProposal_true]:checked').val(); 
	if(requestForProposalTrue!=undefined && requestForProposalTrue == 'true'){
		 $("#pricingDetailsDiv").removeClass("hide");
		 $("#pricingDetails").click();
	}
	
	var requestForProposalFalse =$('input[id=requestForProposal_false]:checked').val(); 
	if(requestForProposalFalse!=undefined && requestForProposalFalse == 'false'){
		$("#pricingDetailsDiv").addClass("hide");
	}
	
	var validationSuccess = $('#errorShow').val();
	var instId = $('#instrumentTypeId').val();
	var selectBankFlag = $('#selectBankFlag').val();
	if(validationSuccess!=undefined && validationSuccess == 'true'){
		$('#pageLevelErrorDivId').show();

		if(selectBankFlag == "Y"){
			if(instId == 1 || instId == 2){
				showHidePricingDet();
			}
			$('#BidMemoRowDiv').hide();
			$('#bidMemoDetailsPanel').hide();
			$('#bankSelection').show();
			$('#bankSelectionPanel').show();
		}else{
			$('#bidMemoDetails').click();
		}
		
		var actionType = $('#actionType').val();
		if(actionType == 3) {
			$("#reasonForSendBackId").show();
		}
	}else{
		if(selectBankFlag == "Y"){
			if(instId == 1 || instId == 2){
				showHidePricingDet();
			}else if(instId == 3 || instId == 4){
				$('#bankSelection').show();
				$('#bankSelection').click();
			}
			$('#BidMemoRowDiv').hide();
			$('#bidMemoDetailsPanel').hide();
			$('#bankSelection').show();
			$('#bankSelectionPanel').show();
		}else{
			$('#bidMemoDetails').click();
		}
	}
	
	$('#governingRules').change(function() {
		showHideOtherGovernRules();
	});
	
	showHideOtherGovernRules();
	setAllInPricingValueLabel();
	setLocalPricingValueLabel();
	
	//Bid memo All In Pricing detail div
	$('#allinPricing').off('change').on('change', function() {
		setAllInPricingValueLabel();
	});
	
	//Bid memo Local Pricing details div
	$('#localPricing').off('change').on('change', function() {
		setLocalPricingValueLabel();
	});
	
	$('#requestForProposal_true').bind("click",function(){
		$("#pricingDetailsDiv").removeClass("hide");
		$("#pricingDetails").click();
	});
	
	$('#requestForProposal_false').bind("click",function(){
		$("#pricingDetailsDiv").addClass("hide");
		
		$('#allinPricing').find('option:eq(0)').attr('selected', true);
		$('#localPricing').find('option:eq(0)').attr('selected', true);
		$('#allinCommValue').val("");
		$('#allinTransFee').val("");
		$('#localCommValue').val("");
		$('#localTransFee').val("");
		$('#VATTaxes').val("");
		$('#stampTax').val("");
		$('#incAdminFee').val("");
		$('#otherOneTime').val("");
	});
	
	
	//For Audit & Transaction Log
	
	$("a.lookupAction").off("click").on("click",function(e) {
		e.preventDefault();
		e.stopImmediatePropagation();
		var url = $(this).attr('href');
		$('#searchIndicator').show();
		$.ajax({
			type: "POST",
			url: url,
			dataType: 'html',
			data: $("#searchActionForm").serialize(),// serializes the form's elements.
			success: function(response){
				$('#fullHistoryDiv').empty().html(response);
				$('#searchIndicator').hide();
			},
				complete : function(jqXHR, status){
					if(status == "success"){
						$('#mainPage').hide();
						$('#fullHistoryDiv').show();
						$(window).scrollTop(0);
					}else{
						$(indicator).hide();
					}
				}
		});
	});
	
	  $('a.fullScreen').off('click').on('click',function(e){
		  e.preventDefault();
	      e.stopImmediatePropagation();
	      var url = $(this).attr('href');
	  	$.ajax({
			type: "POST",
			url: url,
			dataType: 'html',
			data:{},
			success: function(data){
				$('#fullHistoryDiv').empty().html(data);
			},
  				complete : function(jqXHR, status){
  					if(status == "success"){
  						$('#mainPage').hide();
  						$('#fullHistoryDiv').show();
  						$(window).scrollTop(0);
  					}
  				}
		});
	  });
	  
	  $('a.closeFullScreen').off('click').on('click',function(e){
		  $('#mainPage').show();
		  $('#fullHistoryDiv').hide();
	  });
	  
	  onloadReadOnlySection();	
	  jQuery('#treasuryBidSubmitForm').preventDoubleSubmit();
	  jQuery('#suretyBidMemoForm').preventDoubleSubmit();
	  jQuery('#dLocSubmitForm').preventDoubleSubmit();
});

/**
 * Show/Hide Other Governing Rules
 */
function showHideOtherGovernRules(){
	var governingRulesId = $('#governingRules').val();
	if(governingRulesId!=undefined){
		if(governingRulesId == '6'){
			$('#other').show();
		}else{
			$('#other').hide();
		}
	}
}

/**
 * Save bank Selection for Treasury Bid Memo
 * @param actionType
 */
function saveBankSelection(actionType){
	$('#actionType').val(actionType);
	$('#submitBidProcess').show();
	
	var validationSuccess = $('#errorShow').val();
	if(validationSuccess!=undefined && validationSuccess == 'true'){
		$('#bankSelection').show();
		$('#bankSelectionPanel').show();
	}
}

/**
 * Set action type for Save Bid memo
 */
function saveBidMemo(){
	$('#actionType').val(1);
}

/**
 * Set action type for Save Bid memo
 */
function saveSelectBanksBidMemo(){
	$('#actionType').val(36);
	$('#saveAndSelectBanksProcess').show();
}

/**
 * Set action type for Save Bid memo
 */
function sendBackBidMemo(){
	$('#actionType').val(3);
	$('#saveAndSelectBanksProcess').show();
}

/**
 * Hide BidMemo Bank Guarantee Details
 */
function hideBidMemoBgToggles(){
	$('#bidMemoDetailsPanel').hide();
	$('#additionalInstrumentDetailsPanel').hide();
	$('#pricingDetailsPanel').hide();
	$('#bankSelection').show();
	$('#bankSelection').click();
}

/**
 * Set the Amount to words
 */
function amountTowords(){
	var ccyCode1 = $('#currencies').val();
	var insAmount= $('#instrumentAmt').val();
	if(insAmount!=undefined && insAmount!="" ){
		var insAmtToword = toWords(insAmount);
		$('#amountinWords').html(ccyCode1 + " - " +insAmtToword);
	}
}

/**
 * Set AllIn Pricing Details Label
 */
function setAllInPricingValueLabel(){
	var AllInVal = $('#allinPricing').val();
    if(AllInVal == ''){
    	 $('.allInCommissionsValueDiv').addClass("hide");
    	 $('#allinCommValue').val('');
    } else {
    	if(AllInVal == 1){
    		$('.AllinVal').text("All-in rate per Annum(P.A.) - arrears Value");
    	}else if(AllInVal == 2){
    		$('.AllinVal').text("All-in rate per Annum(P.A.) - in advance Value");
    	}else if(AllInVal == 3){
    		$('.AllinVal').text("Flat fee per Annum(P.A.) - in advance Value");
    	}else if(AllInVal == 4){
    		$('.AllinVal').text("Flat fee life in advance Value");
    	}
    	$('.allInCommissionsValueDiv').removeClass("hide");
    }
}

/**
 * Set Local Pricing Details Label
 */
function setLocalPricingValueLabel(){
	var localVal = $('#localPricing').val();
    if(localVal == ''){
    	 $('.localCommissionDiv').addClass("hide");
    	 $('#localCommValue').val('');
    } else {
    	$('.localCommissionDiv').removeClass("hide");
    }
    
    if(localVal == 1){
		$('.localVal').text("All-in rate per Annum(P.A.) - arrears Value");
	}else if(localVal == 2){
		$('.localVal').text("All-in rate per Annum(P.A.) - in advance Value");
	}else if(localVal == 3){
		$('.localVal').text("Flat fee per Annum(P.A.) - in advance Value");
	}else if(localVal == 4){
		$('.localVal').text("Flat fee life in advance Value");
	}
}

/**
 * Set Show/Hide the Pricing Details
 */
function showHidePricingDet(){
	var governingRules = $('#governingRules').val();
	var requestForProposalTrue =$('input[id=requestForProposal_true]:checked').val(); 
	var requestForProposalFalse =$('input[id=requestForProposal_false]:checked').val(); 
	
	if(governingRules!=undefined && governingRules!=""){
		if(requestForProposalTrue!=undefined && requestForProposalTrue == 'true'){
			hideBidMemoBgToggles();
		}
		if(requestForProposalFalse!=undefined && requestForProposalFalse == 'false'){
			hideBidMemoBgToggles();
		}
	}
}

/**
 * To display the Format Section text
 * rich text editor plug-in code
 */
function registerTinyMCE(elementId) {	
	tinymce.init({		
        mode: "exact",
        elements: elementId,
        theme: "advanced",       
        plugins: 'paste,ice,icesearchreplace',       
        theme_advanced_buttons1: "",
        theme_advanced_buttons2: "",
        theme_advanced_buttons3: "",
        theme_advanced_buttons4: "",
        theme_advanced_path : false,
        paste_auto_cleanup_on_paste : true, 
        extended_valid_elements: "p,span[*],delete[*],insert[*]",
        ice: {
            user: { name: 'Geoffrey Jellineck', id: 11},
            preserveOnPaste: 'p,a[href],i,em,b,span'
        },
        height: '400'
    });
}

/**
 * To display the Format Section text
 */
function registerStandardTinyMCE(elementId) {	
	tinymce.init({
        mode: 'exact',        
        elements: elementId,        
        readonly:'true',       
        theme_advanced_buttons1: "",
        theme_advanced_buttons2: "",
        theme_advanced_buttons3: "",
        theme_advanced_buttons4: "",
        theme_advanced_path : false,
        extended_valid_elements: "p,span[*]",      
        height: '400'        	
    });
}

/*
 * This function is used to set the Heading of Format selection in ReadOnly pages
 */
function onloadReadOnlySection(){
	var formatTypeId = $("#readOnlyFormatTypeId").val();
	if(formatTypeId!= undefined && formatTypeId != ""){
		if(formatTypeId == "1") {$("#formatSelectionH2").text(" - GE Standard Format");}
		else if(formatTypeId == "2"){$("#formatSelectionH2").text(" - Modified GE Standard Format");}
		else{$("#formatSelectionH2").text("");}
	}
}

function showSendBackNotes() {
	$("#reasonForSendBackId").show();
}