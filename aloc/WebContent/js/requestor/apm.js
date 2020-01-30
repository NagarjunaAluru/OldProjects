$(document).ready(function() {
	
	if (window.PIE) {
        $('.btn,.errorHead,.errorContent,.errorbox,#siteMsg').each(function() {
            PIE.attach(this);
        });
    }
	
	$("table#bucadnUpdates tbody tr:odd").addClass("odd");
	
	 $("#includeFxRate").hide();
		
		$('.dateyearOnly').each(function() {
			// This checking is requrired to avoid multiple registrations; zdate-plugin checking of 'data' is not working.
			if(!$(this).attr('zdateRegistered')) {
				$(this).zdate({
					format:'Y',
					onSelect: function(format, elements) {
						 $("#includeFxRate").hide();
						$("#showpaymentperiodDet").empty().append("<option value='-1'>Select...</option>");
						$(".FXRate-error").empty().addClass("hide").removeClass("show");
						var  FXfromyear= $('#fxrateFromyear').val();
						var FXtoyear = $('#fxrateToyear').val();
						if((FXfromyear != undefined && FXfromyear !='') && (FXtoyear != undefined && FXtoyear !='')){
							if(parseInt(FXtoyear)>= parseInt(FXfromyear)){
								 $("#periodProcessImgOne").show();
								  $.ajax({
									  type: "POST",
							            url: contextURL+'/int/apm/openFXRateHistory.action',
							            dataType: 'json',
							            data: {FXfromyear : FXfromyear, FXtoyear: FXtoyear},
							            processdata: true,
							            success: function(data) {
							            	$("#showpaymentperiodDet").empty().append("<option value='-1'>Select...</option>");
							              	for (var i = 0; i < data.result.length; i++) {
							              		$("#showpaymentperiodDet").append("<option value='" + data.result[i].id + "'>" + data.result[i].name + "</option>");
							                 }
							              	 $("#periodProcessImgOne").hide();	
							            },
							            error: function (xhr, textStatus, errorThrown ) {
							            	 $("#periodProcessImgOne").hide();
											var errorMsg = $.trim($(xhr.responseText).find('.errorReason').text());	
											$('.apmErrorDiv').show();
											$('.curApmError').text(errorMsg).show();
									    }
							        });
							}else{$(".FXRate-error").text("To date should be greater than or equal to from date").removeClass("hide").addClass("show");
							}
						}
					}
				});
				$(this).attr('zdateRegistered', 'true');
				
			}
		});

	  $('#showpaymentperiodDet').off('change').on('change', function() {
		  
		 var feePeriodId = $('#showpaymentperiodDet').val();
		 var period=$('#showpaymentperiodDet :selected').text();
		  if(feePeriodId==-1){
			  $("#includeFxRate").hide();		 
		  }
		  else{
			$('#periodProcessImg').show();
			$.ajax({
				type: "POST",
			      url: contextURL+'/int/apm/getFxRates.action',
			      dataType: 'html',
			      data: { feePeriodId : feePeriodId},
			      processdata: true,
			      success: function(data) {
						$('#includeFxRate').empty().append(data);
						$('#includeFxRate').show();
						
						$('.FXperiod').text(period);
						$(".FXperiod").show();
						 
						$('#periodProcessImg').hide();
			      		},
			      		 error: function (xhr, textStatus, errorThrown ) {		
			      			 $("#periodProcessImg").hide();
								var errorMsg = $.trim($(xhr.responseText).find('.errorReason').text());				
								$('.apmErrorDiv').show();
								$('.curApmError').text(errorMsg).show();
						    }
			  		});
		  }
	  });
	  
$('.downloadToCSV').attr('disabled', true);
$('.creditsAndCarryOvers').hide();
$('.creditsAndCarryOvers').attr('disabled', true);

	var showCSVButton = $('#showCalculateFeeTable').val();
	if(showCSVButton != undefined && showCSVButton =="true"){
		$('.downloadToCSV').attr('disabled', false);
	}
	
	var creditsCarryOverHidden = $('#creditsCarryOverHidden').val();
	if(creditsCarryOverHidden!=undefined && creditsCarryOverHidden=="true"){
		$('.creditsAndCarryOvers').show();
		$('.creditsAndCarryOvers').attr('disabled', false);
		$('.creditsAndCarryOvers').attr('disabled', true);
	}
	  
$.subscribe('CalculateFees', function(event,data) {
	$("#feetable").show("fast");
	$('.downloadToCSV').attr('disabled', false);
	$('.invoice').attr('disabled', true);
	$('.webCash').attr('disabled', true);
	$('.paymentPeriod').attr('disabled', true);
	
	var creditsCarryOverHidden = $('#creditsCarryOverHidden').val();
	if(creditsCarryOverHidden!=undefined && creditsCarryOverHidden=="true"){
		$('.creditsAndCarryOvers').show();
		$('.creditsAndCarryOvers').attr('disabled', false);
		$('.creditsAndCarryOvers').attr('disabled', true);
	}
});

$('.downloadToCSV').click(function() { 
	var creditsCarryOverHidden = $('#creditsCarryOverHidden').val();
	if(creditsCarryOverHidden!=undefined && creditsCarryOverHidden=="true"){
		$('.creditsAndCarryOvers').attr('disabled', false);
	}
	$('.invoice').attr('disabled', false);
	$('.webCash').attr('disabled', false);
	$('.paymentPeriod').attr('disabled', false);
});

$('.creditsAndCarryOvers').click(function() { 
	var creditsCarryOverHidden = $('#creditsCarryOverHidden').val();
	if(creditsCarryOverHidden!=undefined && creditsCarryOverHidden=="true"){
		$('.invoice').attr('disabled', false);
	}
});

$.subscribe('sendInvoice', function(event,data) {
	$('.webCash').attr('disabled', false);
});

$.subscribe('webCash', function(event,data) {
	$('.paymentPeriod').attr('disabled', false);
});

var tabCount = $("#tabCount").val();
if(tabCount != undefined && tabCount != null && tabCount != ""){
  tabCount = parseInt(tabCount);
  if(tabCount >=2){$('.downloadToCSV').attr('disabled', false);}
}


// APM FX Rate History and Currency

$(".addcurrency").click(function(){
	$("#addCurrency").slideDown("fast");
	$("#saveCurrency").slideDown("fast");
});
$(".cancelcurrency").click(function(){
	$("#addCurrency").slideUp("fast");
	$("#saveCurrency").slideUp("fast");
});
$(".savecurrency").click(function(){
	$("#addCurrency").slideUp("fast");
	$("#saveCurrency").slideUp("fast");
});


$("#edittr1").click(function(){
	$("#tr1Show").slideDown("fast");
	$("#tr1Save").slideDown("fast");
	$("#tr1").slideUp("fast");
});
$("#savetr1").click(function(){
	$("#tr1Show").slideUp("fast");
	$("#tr1Save").slideUp("fast");
	$("#tr1").slideDown("fast");
});
$("#canceltr1").click(function(){
	$("#tr1Show").slideUp("fast");
	$("#tr1Save").slideUp("fast");
	$("#tr1").slideDown("fast");
});

$("#edittr2").click(function(){
	$("#tr2Show").slideDown("fast");
	$("#tr2Save").slideDown("fast");
	$("#tr2").slideUp("fast");
});
$("#savetr2").click(function(){
	$("#tr2Show").slideUp("fast");
	$("#tr2Save").slideUp("fast");
	$("#tr2").slideDown("fast");
});
$("#canceltr2").click(function(){
	$("#tr2Show").slideUp("fast");
	$("#tr2Save").slideUp("fast");
	$("#tr2").slideDown("fast");
});

$("#edittr3").click(function(){
	$("#tr3Show").slideDown("fast");
	$("#tr3Save").slideDown("fast");
	$("#tr3").slideUp("fast");
});
$("#savetr3").click(function(){
	$("#tr3Show").slideUp("fast");
	$("#tr3Save").slideUp("fast");
	$("#tr3").slideDown("fast");
});
$("#canceltr3").click(function(){
	$("#tr3Show").slideUp("fast");
	$("#tr3Save").slideUp("fast");
	$("#tr3").slideDown("fast");
});


$('#pay').bind('change', function(event) {
	var i= $('#pay').val();
	
	if(i=="payment")
	 {
		 $('#payment').slideDown("fast");
	 }
	else if(i=="select")
	 {
		$('#payment').slideUp("fast"); // hide the first one
	
	  }
});

$('#defViewType').off('change').on('change', function() {
	
	var defViewType = $('#defViewType').val();
	
	url = contextURL+'/int/admin/searchFeeHistory.action';
	$("#getSummary").load(url,{defViewType:defViewType}, function(){
		   $("#getSummary").show();
		   
		   showFeeHistoryFields(defViewType);
	   });
});

$('.feeHistCheckAll').click(function () {
	if($(this).attr('checked')){
		 $('.feeHistPaymentId').each(function() {
	           $(this).attr('checked',true);
		 });
	}else{
		$('.feeHistPaymentId').each(function() {
	           $(this).attr('checked',false);
		 });
	}
});

$('.feeHistPaymentId').click(function () {
	if(!$(this).attr('checked')){
		$('.feeHistCheckAll').attr('checked',false);
	}
});

$('.exportToExcel').off('click').on('click',function(e){
    e.preventDefault();
    var paymentsIds = '';
    var alocRecNos = '';
    var counter = 0;
    var url = $(this).attr('href');
    $('.feeHistPaymentId').each(function() {
        if($(this).attr('checked')){
        	counter++;
        	var paymentId = $(this).val();
        	var alocRecNo = $(this).attr('id');
        	paymentsIds += paymentId + ":";
        	alocRecNos += alocRecNo + ":";
        }
	});
    if( counter > 0 ){
    	alocRecNos = alocRecNos.replace(/\:$/,"");
    	paymentsIds=paymentsIds.replace(/\:$/,"");
    	document.forms[0].action = url + "?paymentsIds="+paymentsIds+"&alocRecNos="+alocRecNos;
    	document.forms[0].submit();
    }
});

/**
* select or unselect all BUC,ADN for Update
*/
$('#checkallBucAdnUpdate').off('click').on('click',function(e){
	  var checked_status = this.checked;
	  $(this).closest('table').find('input:checkbox').each(function(){
	    this.checked = checked_status;
	  });
});

/**
* unselect all check if any of check is clicked
*/
$('.checkBucAdnUpdate').off('click').on('click',function(e){
	$('#checkallBucAdnUpdate').attr('checked',false);
});

/**
* validate given BUC,ADN values for Update
*/
$('#updatedBUCId ,#updatedADNId').off("change").on("change",function(e){
	var url = contextURL+"/int/BUCADNLookup.action";
	var bucValue = $('#updatedBUCId').val();
	var adnValue = $('#updatedADNId').val();
	var formData = {
		bucValue : bucValue,
		adnValue : adnValue
	};
	if((bucValue != undefined && bucValue != '' ) && (adnValue != undefined && adnValue != '')){
		$('#bucadnLoading').show();
		$.ajax({
			type: "POST",
		    url: url,
		    dataType: 'json',
		    data: formData,
		    processdata: true,
		    success: function(data) {
		    	if(data.result[0].IBSMessageId != ''){
		    		$('#matched').show();
		    		$('#unMatched').hide();
		    		$(".bucadnupdate-error").empty().addClass("hide").removeClass("show");
		    	}else{
		    		$('#unMatched').show();
		    		$('#matched').hide();
		    		$(".bucadnupdate-error").text(data.result[0].IBSMessage).removeClass("hide").addClass("show");
		    	}
				$('#bucadnLoading').hide();
				$('#bucUpdateValidate').hide();
				$('#adnUpdateValidate').hide();
				$('#bucadnUpdateValidate').hide();
		    }
		});
	}
	e.stopPropagation();
	});
	
	$("#feeTableId tr:odd").addClass("odd");
	$("#feeTableId tr:not(.odd)").hide();
	$("#feeTableId tr:first-child").show();
	
	/**
	* Fee Payment Run Calculate Fee Table expanding rows
	*/
	$("#feeTableId").delegate('tr.odd td:first-child', 'click', function() {
		if(!$(this).parent().next("tr").hasClass('shown')){			
			var bankMDMId = $.trim($(this).parent().children('td:nth-child(1)').text());
			var processImg = $(this).parent().children('td:nth-child(1)').find(".expandProcess");
			var bankName = $.trim($(this).parent().children('td:nth-child(2)').text());
			var url = contextURL +"/int/apm/expandFeeTableDetails.action";
			var nextTr = $(this).parent().next("tr");
			var arrow = $(this).parent().find("#arrow");
			processImg.show();
			$.ajax({
				type: "POST",
				url: url,
				dataType: 'html',
				data: {bankName : bankName, bankMDMId : bankMDMId},
				success: function(response){
					$(nextTr).find('td').html(response);
					$(nextTr).show();
					$(nextTr).addClass("shown");
					$(arrow).removeClass("down");
					$(arrow).addClass("up");
					processImg.hide();
				},
				error: function (xhr, textStatus, errorThrown ) {
					processImg.hide();
					var errorMsg = $.trim($(xhr.responseText).find('.errorReason').text());
					$(nextTr).find('td').html('<div class="errorbox"><div class="errorHead"><p class="erroricon">Error</p></div>'+
							'<div class="errorContent"><p><span class="apmBankDetError"></span></p></div></div>');
					$('.apmBankDetError').text(errorMsg).show();
			    }
			});
		}
		else {
			$(this).parent().next("tr").hide();
			$(this).parent().next("tr").removeClass("shown");
			$(this).parent().find("#arrow").removeClass("up");
			$(this).parent().find("#arrow").addClass("down");			
		}
	});
	
	$("a#basicFHSearch").each(function(){
		
		if(!$(this).attr('addBasicSearch')) {
			$(this).click(function(e) {
				e.preventDefault();
				var defViewType = $('#defViewType :selected').val();
				var url = $(this).attr('href');
				$('#searchIndicator').show();
				$.ajax({
					type: "POST",
					url: url,
					dataType: 'html',
					data: $("#basicSearchFormID").serialize(),// serializes the form's elements.
					success: function(data){
						$('#getSummary').empty().html(data);
						showFeeHistoryFields(defViewType);
						$('#searchIndicator').hide();
					},
					error: function (xhr, textStatus, errorThrown ) {
						$('#searchIndicator').hide();
				    }
				});
			});
			$(this).attr('addBasicSearch', true);
		}
	});
	
	$('a.advanceSearch').off('click').on('click',function(e){	
		if($(this).siblings('div#arrow').hasClass('down')){
			$(this).siblings('div#arrow').removeClass('down').addClass('up');
			$(this).parents('.form-row').siblings("div.filterMsg").slideDown();
			$(this).parents('.form-row').siblings("div.filterMsg").find('.section_flip').addClass('section_active');
			$(this).parents('.form-row').siblings("div.filterMsg").find('.section_panel').slideDown();
		}else if($(this).siblings('div#arrow').hasClass('up')){
			$(this).siblings('div#arrow').removeClass('up').addClass('down');
			$(this).parents('.form-row').siblings("div.filterMsg").slideUp();
			$(this).parents('.form-row').siblings("div.filterMsg").find('.section_flip').removeClass('section_active');
			$(this).parents('.form-row').siblings("div.filterMsg").find('.section_panel').slideUp();
		}
	});
	
		
	$("a.advanceFHSearchBtn").each(function() {
		if(!$(this).attr('addAdvanceSearch')) {
			$(this).click(function(e) {
			e.preventDefault();
			var defViewType = $('#defViewType :selected').val();
			var url = $(this).attr('href');
			var parentDiv = $(this).parent().parent();
			$('#advSearchIndicator').show();
			$.ajax({
				   type: "POST",
		           url: url,
		           dataType: 'html',
		           processdata: true,
		           data: $("#advanceSearchFormID").serialize(), // serializes the form's elements.
		           success: function(data)
		           {
		        	   $('#getSummary').empty().html(data);
		        	   	showFeeHistoryFields(defViewType);
						$(parentDiv).slideUp();
						$('#advSearchIndicator').hide();
		           },
		           error: function (xhr, textStatus, errorThrown ) {
						$('#advSearchIndicator').hide();
				    }
		         });
		});
		$(this).attr('addAdvanceSearch', true);
		}
	});	
	$('.collapse').click(function(){
		$(this).parent().find('.section_flip').removeClass('section_active');
		$(this).parent().find('.section_panel').slideUp();
	});
	$("a#addCountryI").off('click').on('click',function(e) {
		var newIssuanceCountry = parseInt($('#newIssuanceCountry').val());
		$("div#countryI").children("div.form-row").last().after('<div class="form-row newIssuanceCountry"></div>');
		var url = contextURL+'/int/dashboard/addApmIssuanceCountry.action?newIssuanceCountry='+(newIssuanceCountry+1);
		$('div.newIssuanceCountry').load(url).removeClass('newIssuanceCountry');
		$('#newIssuanceCountry').val(newIssuanceCountry + 1);
		return false;
	});	
	
	$("a#addPaymentC").off('click').on('click',function(e) {
		var newPaymentCurrency = parseInt($('#newPaymentCurrency').val());
		$("div#paymentC").children("div.form-row").last().after('<div class="form-row newPaymentCurrency"></div>');
		var url = contextURL+'/int/dashboard/addApmPaymentCurrency.action?newPaymentCurrency='+(newPaymentCurrency+1);
		$('div.newPaymentCurrency').load(url).removeClass('newPaymentCurrency');
		$('#newPaymentCurrency').val(newPaymentCurrency + 1);
		return false;
	});

	$.subscribe('getAutocompleterName', function(event,data) {
		var ui = event.originalEvent.ui;
		var codeTextField = $("#"+data.id).parents('div.form-row').children("input:first").attr("id");
		var text;
		if(ui.item != undefined && ui.item != null){
			text = ui.item.value;
		}else{
			text = '';
			$('#'+codeTextField).val($.trim(text));
		}
		event.stopPropagation();
	});
	$('table.table tr:odd').addClass('odd');
});

/**
 * Show the Fee History Fileds based on the Default View type
 * @param defViewType
 */
function showFeeHistoryFields(defViewType){
	if(defViewType == "full"){
		$('.defaultViewType').text("Full Summary");
	    $('.defaultViewDesc').text("Displays full transaction and fee details.");
	    $('.USDPaymentAmount').removeClass('hide');
	    $('.USFeeTotal').removeClass('hide');
	    $('.foreignFeeTotal').removeClass('hide');
	    $('.periodFeeCredits').removeClass('hide');
	    $('.periodAmendmentFees').removeClass('hide');
	    $('.otherFees').removeClass('hide');
	    $('.oneTimeFees').removeClass('hide');
	    $('.modelID').removeClass('hide');
	    $('.GEApplicant').removeClass('hide');
	    $('.triPartyApplicant').removeClass('hide');
	    $('.beneficiaryName').removeClass('hide');
	    $('.appPrnName').addClass('hide');
		$('.benOblName').addClass('hide');
	}else if(defViewType == "domestic"){
		   $('.defaultViewType').text("Top Level and Domestic Summary");
		   $('.defaultViewDesc').text("Displays high level transaction details and expands domestic fee details.");
		   $('.USDPaymentAmount').removeClass('hide');
		   $('.USFeeTotal').removeClass('hide');
		   $('.foreignFeeTotal').addClass('hide');
		   $('.GEApplicant').removeClass('hide');
		   $('.triPartyApplicant').removeClass('hide');
		   $('.beneficiaryName').removeClass('hide');
		   $('.appPrnName').addClass('hide');
		   $('.benOblName').addClass('hide');
	}else if(defViewType == "foreign"){
		   $('.defaultViewType').text("Top Level and Foreign Summary");
		   $('.defaultViewDesc').text("Displays high level transaction details and expands foreign fee details.");
		   $('.USDPaymentAmount').removeClass('hide');
		   $('.USFeeTotal').addClass('hide');
		   $('.foreignFeeTotal').removeClass('hide');
		   $('.GEApplicant').removeClass('hide');
		   $('.triPartyApplicant').removeClass('hide');
		   $('.beneficiaryName').removeClass('hide');
		   $('.appPrnName').addClass('hide');
		   $('.benOblName').addClass('hide');
	}else if(defViewType == "topLevel"){
		   $('.defaultViewType').text("Top Level Summary");
		   $('.defaultViewDesc').text("Displays high level transaction details.");
		   $('.USDPaymentAmount').addClass('hide');
		   $('.USFeeTotal').addClass('hide');
		   $('.foreignFeeTotal').addClass('hide');
		   $('.GEApplicant').addClass('hide');
		   $('.triPartyApplicant').addClass('hide');
		   $('.beneficiaryName').addClass('hide');
		   $('.appPrnName').removeClass('hide');
		   $('.benOblName').removeClass('hide');
		   
	}
	if(defViewType == "domestic" || defViewType == "foreign" || defViewType == "topLevel"){
		   $('.periodFeeCredits').addClass('hide');
		   $('.periodAmendmentFees').addClass('hide');
	    $('.otherFees').addClass('hide');
	    $('.oneTimeFees').addClass('hide');
	    $('.modelID').addClass('hide');
	}
}

/**
 * To Check the null Verification for the Fields
 * @param startdate
 * @param enddate
 * @param reValuedate
 * @param cutOfdate
 * @param usdamount
 * @param dayCount
 * @returns {String}
 */
function nullCheck(startdate,enddate,reValuedate,cutOfdate,usdamount,dayCount){
    var value="false";
    if((startdate != undefined && startdate !='') && (enddate != undefined && enddate !='') && (reValuedate != undefined && reValuedate !='') &&
    		(cutOfdate != undefined && cutOfdate !='') && (usdamount != undefined && usdamount !='') && (dayCount != undefined && dayCount !='')){
            if((customParse(startdate)<customParse(reValuedate)) && (customParse(enddate)>customParse(reValuedate))){
                    value="true";
               }
            }
    return value;
}

/**
 * To Parse the Custm Parser
 */
function customParse(str) {
    var months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
    n = months.length;
    re = /(\d{2})-([a-z]{3})-(\d{4})/i;
    var matches;    while (n--) { months[months[n]] = n; }
     matches = str.match(re);
return new Date(matches[3], months[matches[2]], matches[1]);
}

/**
 * To Add the Print Content
 * @param id
 */
function printContent(id) {
    str = document.getElementById(id).innerHTML;
    newwin = window.open('', 'printwin',
            'left=100,top=100,width=940,height=400');
    newwin.document.write('<HTML>\n<HEAD>\n');
    newwin.document.write('<TITLE>Print Page</TITLE>\n');
    newwin.document
            .write('<link rel="stylesheet" href="/aloc/css/bootstrap/bootstrap.css"/>');
    newwin.document.write('<script>\n');
    newwin.document.write('function chkstate(){\n');
    newwin.document.write('if(document.readyState=="complete"){\n');
    newwin.document.write('window.close()\n');
    newwin.document.write('}\n');
    newwin.document.write('else{\n');
    newwin.document.write('setTimeout("chkstate()",2000)\n');
    newwin.document.write('}\n');
    newwin.document.write('}\n');
    newwin.document.write('function print_win(){\n');
    newwin.document.write('window.print();\n');
    newwin.document.write('chkstate();\n');
    newwin.document.write('}\n');
    newwin.document.write('<\/script>\n');
    newwin.document.write('</HEAD>\n');
    newwin.document.write('<BODY onload="print_win()">\n');
    newwin.document.write(str);
    newwin.document.write('</BODY>\n');
    newwin.document.write('</HTML>\n');
    newwin.document.close();
}
