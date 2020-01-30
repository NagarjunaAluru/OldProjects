


$(document).ready(function() {
	
	decCounter("dlocBidadditionalComments",400);
	decCounter("bgBidReplyNotesId",250);
	decCounter("bidReplyComments", 400);
	
	$('#suretyFeeNameId').bind('change', function(event) {
		var suretyName=$('#suretyFeeNameId :selected').text();
		$('#suretyFeeName').val(suretyName);
	});
	
	//Treasury bid reply section
	onclickBidOption();
    
	$('#bidOption_Bid').click(function() {
		onclickBidOption();
		   
		});
	$('#bidOption_Optout').click(function() {
		onclickBidOption();
		   
		});
	
	//dloc bid instrument purpose
	$('#selectFeeStructure').bind('change',function(){
	    if($('#selectFeeStructure').val() == ''){
	    	 $('.confirmFeesDiv').addClass("hide");
	    } else {
	    	$('.confirmFeesDiv').removeClass("hide");
	}
	});
	
	setAllInPricingValueLabel();
	setLocalPricingValueLabel();
	
	//Bid reply All In Pricing detail div
	$('#allinPricing').off('change').on('change', function() {
		setAllInPricingValueLabel();
	});
	
	//Bid reply Local Pricing details div
	$('#localPricing').off('change').on('change', function() {
		setLocalPricingValueLabel();
	});
	
	$("#priceDetailsFlag_Accept").click(function(){
        $("#rejection").hide("fast");
     });
	$("#priceDetailsFlag_Reject").click(function(){
        $("#rejection").show("fast");
     });
	
	var reasonforRejection = $('[name="requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.acceptPricingDetailsFlag"]:radio:checked').val();
	if(reasonforRejection != undefined && reasonforRejection == "Reject"){
 	 $("#rejection").show("fast");
	}
	var errorShow = $('#errorShowId').val();
	if(errorShow!=undefined && errorShow == 'true'){
		$('#bidReplyPageLevelErrorDivId').show();
	}
	
	jQuery('#bgBankReplyForm').preventDoubleSubmit();
	jQuery('#bgSuretyReplyForm').preventDoubleSubmit();
	jQuery('#dLocBidReplyForm').preventDoubleSubmit();
});


/**
 * Show/Hide Toggles when we Click on Bid/OptOut radio buttons in Bid Reply
 */		
function onclickBidOption(){
	if($('#bidOption_Bid').is(':checked')) {
		$('.bidDiv').removeClass("hide");
		$('.bidOptDiv').addClass("hide");
		$('.optOutButton').addClass("hide");
		$('#actionTypeId').val("9");
		var bundleCount = $('#bidBundleCount').val();
		if(bundleCount != undefined && bundleCount != '' && bundleCount > 0){
			$('.saveGotoNextButton').removeClass("hide");
			$('.submitBidReplyButton').addClass("hide");
		}else{
			$('.submitBidReplyButton').removeClass("hide");
			$('.saveGotoNextButton').addClass("hide");
		}
		$('.bidOptingOutNotification').hide();
		$('.bidReplyWithBundleNotification').show();
		$('#optingOutCommentsReason').val('');
		$('#fourHundredCounter').text('400');
		$('#twofiftyCounter').text('250');
	}
	else if($('#bidOption_Optout').is(':checked')) {
		$('.bidDiv').addClass("hide");
		$('.saveGotoNextButton').addClass("hide");
		$('.submitBidReplyButton').addClass("hide");
		$('.bidOptDiv').removeClass("hide");
		$('.optOutButton').removeClass("hide");
		$('#actionTypeId').val("10");    
		$('.bidOptingOutNotification').show();
		$('.bidReplyWithBundleNotification').hide();
		$('#conformationFeesSection').children().find('input').val('');
		$("#selectFeeStructure").val('');
		$('#dlocBidadditionalComments').val('');
		$('#indicativePricingSection').children().find('input').val('');
		$('#bankDetails').hide();
		$('#sbBidReplyDetailsSection').children().find('input').val('');
		$('#bgBidReplyDetailsSection').children().find('input').val('');
		$('#usExpirationDate').val('');
		$('#pricingDetailsSection').children().find('input').val('');
		$('#bgBidReplyNotesId').val('');
		$('#allinPricing').val('');
		$('#localPricing').val('');
		$('#bidMemoComments').val('');
		$('#rejection').hide();
		$('.allInCommissionsValueDiv').addClass("hide");
		$('.localCommissionDiv').addClass("hide");
		$('#issuanceTypeFlagId_Direct').attr('checked',false);
		$('#issuanceTypeFlagId_Indirect').attr('checked',false);
		$('#priceDetailsFlag_Accept').attr('checked',false);
		$('#priceDetailsFlag_Reject').attr('checked',false);
		$('#suretyFeeNameId').val('');
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


