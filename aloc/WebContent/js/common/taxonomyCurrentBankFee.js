$(document).ready(function(){
	
	$("#buttonSub").click(function(){
		allInDivDisable();
	});
	$("#buttonSub2").click(function(){
		localDivDisable();
	});

	allInDivShowHide();
	localDivShowHide();
	
	autoTextarea();
	taxonomyDecCounter("winningBankComments", 400);
	taxonomyDecCounter("reasonforChange", 400);
	
	$('.autosize').off('keyup').on('keyup', function() {
		if(this.value!=undefined){
			var cnt = $(this).val().length;
			var remainingchar30 = 400 - cnt;
			if (cnt >= 400) {
				this.value = this.value.substring(0,400);
			}
			$(this).parents('div.row').find('.counter').text(remainingchar30);
		}
	});
	
	/**
	 * This is used to close Success message
	 */
	$('body').off('click', '.successclose').on('click', '.successclose', function(e){
		$(e.target).closest("#siteMsg").hide();
		$(".delegateSuccess").text("");
	});
	
	$('body').off("change",'.updateReportAmount').on("change",'.updateReportAmount',function(e){
    	e.stopPropagation();
    	var targetId = "usdShow";
    	var currCodeid = $(e.target).parents('tr').find("input[name='updateReportingData.currencyCode']").attr('id');
		var imageId = "updateReportUSDProcess";
		var currCode=$("#"+currCodeid).val();
		var originalCCYAmount= $(e.target).val();
		var targetControl = "updateUSDVal";
		if(currCode!="" && originalCCYAmount!=""){
			if(currCode!=undefined && originalCCYAmount!=undefined){
				if(currCode!="USD"){
					var data = {currCode: currCode,originalCCYAmount: originalCCYAmount};
					usdConversion(data,targetId,targetControl,imageId);
				}else{
					$("#"+targetId).find('span').text(originalCCYAmount);
					$('#'+targetControl).val(originalCCYAmount);
					updatedBidValuepercent(originalCCYAmount);
				}
					
			}
			
		}
	
	});
	
	$('body').off("click",'#deliveryType_true').on("click",'#deliveryType_true',function(e){
		e.stopPropagation();
		   $('#pDelivery').slideUp('fast');
		   $('#pDelivery1').slideUp('fast');
		   clearDeliveryDetails();
		   if((instrumentTypeId!=undefined) && (instrumentTypeId =="1" || instrumentTypeId =="2")){
			   removeMandatory('#address1,#city,#zipPostalcode,#deliveryAddresscountry');
		   }
		   else if((instrumentTypeId!=undefined) && (instrumentTypeId =="3")){
			   removeMandatory('#sbAddress1,#sbCity,#zipPostalcode,#deliveryAddresscountry');
		   }
	});
	
	$('body').off("click","#leftPaidDateFlag_true").on("click","#leftPaidDateFlag_true",function(e){
		e.stopPropagation();
		$(".leftLastPaidDate").removeClass('hide');
	});
	
	$('body').off("click","#leftPaidDateFlag_false").on("click","#leftPaidDateFlag_false",function(e){
		e.stopPropagation();
		$(".leftLastPaidDate").addClass('hide');
	});
	
	$('body').off("click","#rightPaidDateFlag_true").on("click","#rightPaidDateFlag_true",function(e){
		e.stopPropagation();
		$(".rightLastPaidDate").removeClass('hide');
	});
	
	$('body').off("click","#rightPaidDateFlag_false").on("click","#rightPaidDateFlag_false",function(e){
		e.stopPropagation();
		$(".rightLastPaidDate").addClass('hide');
	});
	
	var currCode = $("input[name='updateReportingData.currencyCode']").val();
	var  originalAmount = $('input.updateReportAmount').val();
	var taxonomyViewType = $('#taxonomyViewType').val();
	if(currCode!=undefined && currCode!="" && originalAmount!=undefined && originalAmount!=""
		&& taxonomyViewType != undefined && taxonomyViewType == 'UPDATEDATA'){
		var targetId = "usdShow";
		var targetControl = "updateUSDVal";
		var imageId = "updateReportUSDProcess";
		if(currCode!="USD"){
			var data = {currCode: currCode,originalCCYAmount: originalAmount};
			usdConversion(data,targetId,targetControl,imageId);
		}else{
			$("#usdShow").find('span').text(originalAmount);
			$('#updateUSDVal').val(originalAmount);
			updatedBidValuepercent(originalAmount);
		}
	}
	
	getUpdateReportAutocompleterName();
	getUpdateReportUSDConversion();
	
	if($('#leftPaidDateFlag_true').is(':checked')) { 
		$(".leftLastPaidDate").removeClass('hide');
	}else if($('#leftPaidDateFlag_false').is(':checked')) { 
		$(".leftLastPaidDate").addClass('hide');
	}
	if($('#rightPaidDateFlag_true').is(':checked')) { 
		$(".rightLastPaidDate").removeClass('hide');
	}else if($('#rightPaidDateFlag_false').is(':checked')) { 
		$(".rightLastPaidDate").addClass('hide');
	}
});


/**
 * auto expanding text area
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
 * Decrease the Counter Value
 * @param id
 * @param fullLength
 */
function taxonomyDecCounter(id,fullLength){
	var txtAreaVal = $('#'+id).val(); 
	if(txtAreaVal!=undefined && txtAreaVal!=""){
		var txtAreaValLen = txtAreaVal.length;
		txtAreaValLen = fullLength-txtAreaValLen;
		$('#'+id).siblings('.counter').text(txtAreaValLen);
	}
}

/**
 * Disable AllIn Commissions Div values 
 */
function allInDivDisable(){
	$('#allinCommValue').removeAttr("readonly");
	$('#amendmentTransactionFee1').removeAttr("readonly");
	$("#buttonSub").hide();
}

/**
 * Disable Local Commissions Div values 
 */
function localDivDisable(){
	$('#localPricing').removeAttr("readonly");
	$('#localCommValue').removeAttr("readonly");
	$('#amendmentTransactionFee2').removeAttr("readonly");
	$("#buttonSub2").hide();
}

/**
 * Show/hide All-In Pricing Values & Change the label Dynamically
 */
function allInDivShowHide(){
	var allInPricing = $('#allinPricing').val();
	if(allInPricing!=undefined && allInPricing!=""){
		allInDivDisable();
	}
}

/**
 * Show/hide Local Pricing Values & Change the label Dynamically
 */
function localDivShowHide(){
	var localPricing = $('#localPricing').val();
	if(localPricing!=undefined && localPricing!=""){
		localDivDisable();
	}
}

/**
 * Used to set AutoCompleter Details in UpdateReportingData Tab
 */
function getUpdateReportAutocompleterName(){
	$.subscribe('getUpdateReportAutocompleterName', function(event,data) {
		var ui = event.originalEvent.ui;
		var codeTextField = $("#"+data.id).parents('tr').find("input[name='updateReportingData.currencyCode']").attr('id');
		var textField = $("#"+data.id).parents('tr').find(".updateReportAutoCompleterName").attr("id");
		var text;
		if(ui.item != undefined && ui.item != null){
			var name = ui.item.value;
			text = name.substring(0,name.indexOf("_"));
		}else{
			text = '';
			$('#'+codeTextField).val($.trim(text));
		}
		$('#'+textField).val($.trim(text));
		event.stopPropagation();
	});

}

/**
 * Used to get USD Conversion Value in UpdateReportingData Tab
 */
function getUpdateReportUSDConversion(){
$.subscribe('getUpdateReportUSDConversion', function(event,data) {
	var targetId = "usdShow";
	var currCodeid = $("#"+data.id).parents('tr').find("input[name='updateReportingData.currencyCode']").attr('id');
	var imageId = "updateReportUSDProcess";
	var currCode=$("#"+currCodeid).val();
	var originalCCYAmountid=$('input.updateReportAmount').attr('id');
	var originalCCYAmount= $("#"+originalCCYAmountid).val();
	var targetControl = "updateUSDVal";
	if(currCode!=undefined && currCode!="" && originalCCYAmount!=undefined && originalCCYAmount!=""){
		if(currCode!="USD"){
			var data = {currCode: currCode,originalCCYAmount: originalCCYAmount};
			usdConversion(data,targetId,targetControl,imageId);
		}else{
			$("#"+targetId).find('span').text(originalCCYAmount);
			$('#'+targetControl).val(originalCCYAmount);
			updatedBidValuepercent(originalCCYAmount);
		}
	}
	event.stopPropagation();
});

function updatedBidValuepercent(usdAmount){
	var bidPercent="";
	if(usdAmount!="" && usdAmount!=undefined){
		var USDInstrumentAmount = usdAmount.replace(/,/g,"");
		var USDBidAmount = $('#updatedBidUSDEquivalentAmount').val();
		USDBidAmount= USDBidAmount.replace(/,/g,"");
		if(USDBidAmount!="" && USDInstrumentAmount!=""){
			if(USDBidAmount!=undefined && USDInstrumentAmount!=undefined){
				if(USDBidAmount!="0"){
					bidPercent=(USDInstrumentAmount/USDBidAmount)*100;
				}
				if(bidPercent!="" && bidPercent!=undefined){
					$('#updatedPercentValueOfBid').val(bidPercent.toFixed(2));
					
				}
			}
		}
	}else{
		$('#updatedPercentValueOfBid').val("");
	}
}
}
