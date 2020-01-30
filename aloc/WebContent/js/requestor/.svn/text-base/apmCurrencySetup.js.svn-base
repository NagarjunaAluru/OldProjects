$(document).ready(function() {
/*
* Add New Currency Row for Currency Setup Screen
*/
$('.addNewCurrency').each(function() {
	if(!$(this).attr('addRowRegistered')) {
	$(this).click(function() {
		var curSetupSize = 0;
		var processImg = contextURL+"/img/loading.gif";
		$('.addNewCurProcess').show();
		if($('#curSetupSize').val() != undefined && ($('#curSetupSize').val() != "" && $('#curSetupSize').val() != "0")){
			curSetupSize = parseInt($('#curSetupSize').val());
		}
		if( curSetupSize > 0 ){
			$("table#curSetupTable").children('tbody').children("tr:last").after('<tr class="shown curSetRow curRowVal"></tr><tr class="curRowVal"><td></td><td colspan="7"><a href="javascript:;" class="btn-secondary saveCurSetRow">Save</a><a href="javascript:;" class="btn-tertiary cancelCurSetRow">Cancel</a>'+'&nbsp;&nbsp;&nbsp;&nbsp;<img alt="Loading..." class="saveCurProcess" src="'+ processImg +'" style="display: none; height: 20px; width: 20px;"></td></tr>');
		}
		else if(curSetupSize == 0)
		{
			$("table#curSetupTable").children('tbody').append('<tr class="shown curSetRow curRowVal"></tr><tr class="curRowVal"><td></td><td colspan="7"><a href="javascript:;" class="btn-secondary saveCurSetRow">Save</a><a href="javascript:;" class="btn-tertiary cancelCurSetRow">Cancel</a>'+'&nbsp;&nbsp;&nbsp;&nbsp;<img alt="Loading..." class="saveCurProcess" src="'+ processImg +'" style="display: none; height: 20px; width: 20px;"></td></tr>');
		}
		
		var url = contextURL+'/int/apm/addCurrencyRow.action' + '?curIndex=' + curSetupSize;
		$('.curSetRow').load(url, function(){ 
			$(this).children("td:nth-child(2)").find("input.ui-widget").css("width","150px");
			$('.addNewCurProcess').hide();
			$(this).removeClass('curSetRow');
		});
		var curSetupIndex = curSetupSize + 1;
		$('#curSetupSize').val(curSetupIndex);
	});
	$(this).attr('addRowRegistered', true);
	}
});
	
/*
* Edit Currency Row for Currency Setup Screen
*/
$('.editCurSetup').off('click').on('click',function(e){
	e.preventDefault();
	
	var curIndex = $(this).attr('alt');
	var curVal = $(this).parents('tr').find('.apmPaymentCurrencyFlag');
	
	var processImg = contextURL+"/img/loading.gif";
	$(this).parents('tr').find('.editCurProcess').show();
	$(this).closest('tr').addClass('curSetRow');
	var url = contextURL+'/int/apm/editCurrencyRow.action' + '?curIndex=' + curIndex;
	$('.curSetRow').after('<tr class="curRowVal"><td></td><td colspan="12"><a href="javascript:;" class="btn-secondary saveCurSetRow">Save</a><a href="javascript:;" class="btn-tertiary cancelCurSetRow">Cancel</a>'+'&nbsp;&nbsp;&nbsp;&nbsp;<img alt="Loading..." class="saveCurProcess" src="'+ processImg +'" style="display: none; height: 20px; width: 20px;"></td></tr>');
	
	$('.curSetRow').load(url, function(){
		$(this).children("td:nth-child(2)").find("input.ui-widget").css("width","150px");
		var bucClass = $(this).children("td:nth-child(7)").find('input.BUC');
		var adnClass = $(this).children("td:nth-child(8)").find('input.ADN');
		
		if($(curVal).text() == 'No'){
			$(bucClass).attr('disabled', true);
			$(bucClass).val("");
			$(adnClass).attr('disabled', true);
			$(adnClass).val("");
			
		}else if($(curVal).text() == 'Yes'){
			$(bucClass).attr('disabled', false);
			$(adnClass).attr('disabled', false);
		}
		
		$(this).removeClass('curSetRow');
		$(this).parents('tr').find('.editCurProcess').hide();
	});
});

/*
* Save Row for Currency Setup Screen
*/
$('.saveCurSetRow').off('click').on('click',function(e){
	e.preventDefault();
	
	$(this).closest('tr').addClass('saveCurRow');
	
	var parentRow = $(this).parents('tr.curRowVal').prev('.curRowVal');
	
	var currencyConfigId = $(parentRow).find('.currencyConfigId').val();
	var curCode = $(parentRow).find('.currencyCode').val();
	var rateDirection = $(parentRow).find("input[type='radio'].rateDirection:checked").val();
	var tickerSymbol = $(parentRow).find('.tickerSymbol').val();
	var decimalPrecision = $(parentRow).find('.decimalPrecision').val();
	var APMPaymentCurrencyFlag = $(parentRow).find("input[type='radio'].apmPaymentCurrencyFlag:checked").val();
	var BUC = $(parentRow).find('.BUC').val();
	var ADN = $(parentRow).find('.ADN').val();
	var currName = encodeURI($(parentRow).find('.currName').val());
	var curIndex =$(parentRow).find('.curIndex').val();
	
	var bucAdnValid = $(parentRow).find('.invalidBucMsg').text();
	if(bucAdnValid==undefined || bucAdnValid == "" || bucAdnValid == null){
		if(rateDirection == undefined)	{	rateDirection = ''; 	}
		if(APMPaymentCurrencyFlag == undefined)	{	APMPaymentCurrencyFlag = '';	}
		
		var url = contextURL+'/int/apm/saveCurrencySetRow.action'; 
		var data = {
				'curIndex' : curIndex,
				'currencySetup.currencyCode' : curCode,
				'currencySetup.rateDirection' : rateDirection,
				'currencySetup.tickerSymbol' : tickerSymbol,
				'currencySetup.decimalPrecision' : decimalPrecision,
				'currencySetup.APMPaymentCurrencyFlag' : APMPaymentCurrencyFlag,
				'currencySetup.BUC' : BUC,
				'currencySetup.ADN' : ADN, 
				'currencySetup.currencyConfigId' : currencyConfigId,
				'currencySetup.currName' : currName
		};
		
		$(this).closest('tr').find('.saveCurProcess').show();
		var prevTr = $(this).parents('tr.curRowVal').prev('.curRowVal');
		$.ajax({
			type: "POST",
		    url: url,
		    dataType: 'html',
		    data: data,
		    processdata: true,
		    success: function(data) {
		    	$(prevTr).children("td:nth-child(2)").find("input.ui-widget").css("width","150px");
					$('.currencySetupCls').empty().html(data);
		    },
            error: function (xhr, textStatus, errorThrown ){
            	$(prevTr).next('tr').find('.saveCurProcess').hide();
				if(APMPaymentCurrencyFlag!=undefined && APMPaymentCurrencyFlag == 'No'){
					$(prevTr).find('.BUC').attr('disabled', true);
					$(prevTr).find('.ADN').attr('disabled', true);
				 }
				$(prevTr).empty().html(xhr.responseText);
            }
		});
	}
});

/*
* Delete Row for Currency Setup Screen
*/
$('.cancelCurSetRow').off('click').on('click',function(e){
	e.preventDefault();
	var curIndex = $(this).parents('tr.curRowVal').prev('.curRowVal').find('.curIndex').val();
	var currencyConfigId = $(this).parents('tr.curRowVal').prev('.curRowVal').find('.currencyConfigId').val();
	
	if(currencyConfigId!=undefined && currencyConfigId!=""){	
		var url = contextURL+'/int/apm/cancelCurrencyRow.action' + '?currencyConfigId='+currencyConfigId+'&curIndex=' + curIndex;
		$(this).closest('tr').find('.saveCurProcess').show();
		$(this).parents('tr.curRowVal').prev('.curRowVal').load(url, function(){ 
			$(this).next('tr').remove();
			$(this).next('tr').find('.saveCurProcess').hide();
		});
	}else{
		var url = contextURL+'/int/apm/cancelCurrencyRow.action' + '?currencyConfigId='+currencyConfigId+'&curIndex=' + curIndex;
		$(this).closest('tr').find('.saveCurProcess').show();
		$(this).parents('tr.curRowVal').prev('.curRowVal').load(url, function(){ 
			$(this).parents('tr.curRowVal').prev('.curRowVal').remove();
			$(this).next('tr').remove();
			$(this).next('tr').find('.saveCurProcess').hide();
		});
		var curSetupSize = parseInt($('#curSetupSize').val());
		var curSetupIndex = curSetupSize - 1;
		$('#curSetupSize').val(curSetupIndex);
	}
});

/**
 * Currency Setup Delete Row
 */
$(".delCurSetup").off("click").on("click", function(e){
	e.preventDefault();
	var configId=$.trim($(this).parents('tr').find('.currencyConfigId').html());
	var currencyCode=$.trim($(this).parents('tr').find('.currencyCode').html());
	var currencyName=$.trim($(this).parents('tr').find('.currName').html());
	var size = $('#curSetupSize').val();
	
	
	if(size==1){
		n = window.open('#delCurSizeOneModal', '_self');
		$('#delCurSizeOneModal').modal({show: 'true'});
	}else{
		n = window.open('#deletecurModal', '_self');
		$('#deleteCurModal').modal({show: 'true'});
	}
	
	$('#configId', n.document).val(configId);
	$('#curCode', n.document).val(currencyCode);
	$('#curName', n.document).val(currencyName);
});

/**
 * Delete Row from the Pop Up
 */
$("#deleteCurSetRow").off("click").on("click", function(e){
	var configId = $('#configId').val();
	var url = contextURL+'/int/apm/deleteCurrencyRow.action' + '?configId=' + configId;
	
	var data = {};
	$.ajax({
		type: "POST",
	    url: url,
	    dataType: 'html',
	    data: data,
	    processdata: true,
	    success: function(data) {
	    		$('#deleteCurModal').hide();
				$('.currencySetupCls').empty().html(data);
	    }
	});
});

/**
 * Get the copy Site details
 */
if(!$('.apmPaymentCurrencyFlag').attr('currencyReg')) {
	$('.apmPaymentCurrencyFlag').on('change', function() {
		 var apmPaymentCurFlag = $(this).val();
		 if(apmPaymentCurFlag!=undefined && apmPaymentCurFlag == 'Yes'){
			 $(this).parents('tr').find('.BUC').val("");
			 $(this).parents('tr').find('.BUC').attr('disabled', false);
			 $(this).parents('tr').find('.ADN').val("");
			 $(this).parents('tr').find('.ADN').attr('disabled', false);
		 }
		 if(apmPaymentCurFlag!=undefined && apmPaymentCurFlag == 'No'){
			 $(this).parents('tr').find('.BUC').val("");
			 $(this).parents('tr').find('.BUC').attr('disabled', true);
			 $(this).parents('tr').find('.ADN').val("");
			 $(this).parents('tr').find('.ADN').attr('disabled', true);
			 $(this).parents('tr').find('.invalidBucMsg').text('');
		 }
	});
	$('#apmPaymentCurrencyFlag').attr('currencyReg', true);
}

/**
* validate given BUC,ADN values for Update
*/
$('.BUC,.ADN').off("change").on("change",function(e){
		
		var url = contextURL+"/int/BUCADNLookup.action";
		var bucValue = $(this).parents('tr').find('.BUC').val();
		var adnValue = $(this).parents('tr').find('.ADN').val();
		var fieldClass = $(this).parents('tr').find('.invalidBucMsg');
		var bucValidFlagHidden = $(this).parents('tr').find('.validBucFlag');
		var process = $(this).parents('tr').find('.bucProcessImg');
		var saveBut = $(this).parents('tr').next('tr').find('.saveCurSetRow');
		$(saveBut).attr('disabled',true);
		var formData = {
			bucValue : bucValue,
			adnValue : adnValue
		};
		if((bucValue != undefined && bucValue != '' ) && (adnValue != undefined && adnValue != '')){
			$(process).show();
			$(saveBut).attr('disabled',true);
			$.ajax({
				type: "POST",
			    url: url,
			    dataType: 'json',
			    data: formData,
			    processdata: true,
			    success: function(data) {
			    	if(data.result[0].IBSMessageId == ''){
			    		$(fieldClass).text('BUC & ADN Combination Invalid').removeClass("hide").addClass("show");
			    		$(bucValidFlagHidden).val("Invalid");
			    	}else{
			    		$(fieldClass).text('');
			    		$(fieldClass).addClass('hide').removeClass('show');
			    	}
			    	$(process).hide();
			    	$(saveBut).attr('disabled',false);
			    }
			});
		}else{
			$(fieldClass).text('');
			$(saveBut).attr('disabled',false);
		}
		e.stopPropagation();
});


});
 