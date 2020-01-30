$(document).ready(function() {
	
	if (window.PIE) {
        $('.btn').each(function() {
            PIE.attach(this);
        });
    }
	
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
							            url: contextURL+'/ext/apm/openFXRateHistory.action',
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
			      url: contextURL+'/ext/apm/getFxRates.action',
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
	
	var creditsCarryOverHidden = $('#creditsCarryOverHidden').val();
	if(creditsCarryOverHidden!=undefined && creditsCarryOverHidden=="true"){
		$('.creditsAndCarryOvers').show();
		$('.creditsAndCarryOvers').attr('disabled', false);
		$('.creditsAndCarryOvers').attr('disabled', true);
	}
});

$('.downloadToCSV').click(function() { 
	var creditsCarryOverHidden = $('#creditsCarryOverHidden').val();
	if(creditsCarryOverHidden!=undefined && creditsCarryOverHidden!="true"){
		$('.invoice').attr('disabled', false);
	}else{
		$('.creditsAndCarryOvers').attr('disabled', false);
	}
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
	
	url = contextURL+'/ext/admin/searchFeeHistory.action';
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
			if($('.filterMsg').is(':hidden')){
				$('.filterMsg').show();
			}else{
				$('.filterMsg').hide();
			}
			$(this).parents('.form-row').find("div.filterMsg").find('.section_flip').addClass('section_active');
			$(this).parents('.form-row').find("div.filterMsg").find('.section_panel').slideDown();
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
		var url = contextURL+'/ext/dashboard/addApmIssuanceCountry.action?newIssuanceCountry='+(newIssuanceCountry+1);
		$('div.newIssuanceCountry').load(url).removeClass('newIssuanceCountry');
		$('#newIssuanceCountry').val(newIssuanceCountry + 1);
		return false;
	});	
	
	$("a#addPaymentC").off('click').on('click',function(e) {
		var newPaymentCurrency = parseInt($('#newPaymentCurrency').val());
		$("div#paymentC").children("div.form-row").last().after('<div class="form-row newPaymentCurrency"></div>');
		var url = contextURL+'/ext/dashboard/addApmPaymentCurrency.action?newPaymentCurrency='+(newPaymentCurrency+1);
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
