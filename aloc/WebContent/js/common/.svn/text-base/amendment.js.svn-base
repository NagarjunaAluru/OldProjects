//Amendment 
$(document).ready(function() {
	
	checkRevisedExpDate();
	setRevisedInsAmt();
	onLoadAmountInWords();
	$('body').off('change', '#amountIncDec').on('change', '#amountIncDec', function(e) {
		e.stopPropagation(); 
		hideSubmitBtns();
		var revisedAmt = 0;
		var currentAmt = $('#currentInstrumentAmt').val().replace(/,/g,"");
		var incDec = $('input[type="radio"].amtIncDecRadio:checked').val();
		var amountofIncDec=$(this).val();
		if(amountofIncDec != undefined && amountofIncDec !=""){
			amountofIncDec= amountofIncDec.replace(/,/g,"");
		}else{
			amountofIncDec=0;
		}
		if(incDec == 'INCREASE'){
			revisedAmt = parseFloat(currentAmt) + parseFloat(amountofIncDec);
		}else if(incDec == 'DECREASE'){
			revisedAmt = parseFloat(currentAmt) - parseFloat(amountofIncDec);
		}else{
			return false;
		}
		$('#revisedInstrumentAmt').siblings('p').text(revisedAmt);
		$('#revisedInstrumentAmt').val(revisedAmt);
		amountTowordsConersion(revisedAmt,$('#revisedInsAmountinWords'));
		calculateRevisedUSDAmount();
	});
	
	$('body').off('change', '#autoAmountIncDec').on('change', '#autoAmountIncDec', function(e) {
		e.stopPropagation();
		var autoRevisedAmt = 0;
		var originalAmt = $('#originalInstrumentAmt').val().replace(/,/g,"");
		var autoIncDec = $('#instrumentOperationId').val();
		var autoAmountofIncDec=$(this).val();
		if(autoAmountofIncDec != undefined && autoAmountofIncDec !=""){
			autoAmountofIncDec= autoAmountofIncDec.replace(/,/g,"");
		}
		if(autoIncDec == 'INCREASE'){
			autoRevisedAmt = parseFloat(originalAmt) + parseFloat(autoAmountofIncDec);
		}else if(autoIncDec == 'DECREASE'){
			autoRevisedAmt = parseFloat(originalAmt) - parseFloat(autoAmountofIncDec);
		}else{
			return false;
		}
		$('#revisedInstrumentAmt').siblings('p').text(autoRevisedAmt);
		$('#revisedInstrumentAmt').val(autoRevisedAmt);
		
	});
	
	
	$('body').off('change', '#newInstCurrId').on('change', '#newInstCurrId', function(e) {
		e.stopPropagation();
		hideSubmitBtns();
		var currencyName=$("#newInstCurrId option:selected").text();
		if(currencyName!=undefined && currencyName!=""){
			$('#newInstCurr').val(currencyName.substring(0,currencyName.indexOf("_")));
		}else{
			$('#newInstCurr').val("");
		}
		calculateRevisedUSDAmount();
		
	});
	
	$('body').off('click', '.amtIncDecRadio').on('click', '.amtIncDecRadio', function(e) {
		e.stopPropagation();
		if($('#amountIncDec').val() != undefined && $('#amountIncDec').val() != ''){
			$('#amountIncDec').change();
		}
	});
	
	$('body').off('click', '#instrumentOperationId_INCREASE').on('click', '#instrumentOperationId_INCREASE', function(e) {
		e.stopPropagation();
		$('.IncOrDec').text("Increase");
		$('.instrAmtNotification').hide();
	});
	
	$('body').off('click', '#instrumentOperationId_DECREASE').on('click', '#instrumentOperationId_DECREASE', function(e) {
		e.stopPropagation();
		$('.IncOrDec').text("Decrease");
		$('.instrAmtNotification').show();
	});
	
	onLoadInstrumentOperation();
	
	
	// Create Amendment SaveAsDraft button
	if(!$('#nav-saveasDraftAmend').attr('handlerSaveDraft')) {
		$("#nav-saveasDraftAmend").click(function(){
			$(this).addClass('tabactive');
			$("#nav-submitAmendment").removeClass('tabactive');
			$('#actionTypeId').val("1");
			$('form#submitAmendmentFormID').submit();
			
		});
		$('#nav-saveasDraftAmend').attr('handlerSaveDraft', true);
	}
	$('form#submitAmendmentFormID').submit(function() {
		return true;
	});
	
	if(!$('#nav-auto-submit').attr('handlerSubmitAutoAmend')) {
		$("#nav-auto-submit").click(function(){
			$(this).addClass('tabactive');
			$("#nav-auto-amddeleteAmendment").removeClass('tabactive');
			$('#actionTypeId').val("2");
			$('form#submitAutoAmendmentFormID').submit();
			
		});
		$('#nav-auto-submit').attr('handlerSubmitAutoAmend', true);
	}
	$('form#submitAutoAmendmentFormID').submit(function() {
		return true;
	});
	
	$("#nav-submitAmendment").click(function(){
		   $(this).addClass('tabactive');
		   $(".approversErrorDiv").hide();
		   $('#li24').addClass('liactive');
		   $('#li25').removeClass('liactive');
		   $("#nav-saveasDraftAmend").removeClass('tabactive');
		   var approverAmount = $('#revisedUSDEquiAmt').val();
		   if(approverAmount !="" && approverAmount != undefined){
			   approverAmount= approverAmount.replace(/,/g,"");
			   $('#submitProcess').show();
			   getDelegationApproversOnSubmit(approverAmount);
		   }else{
			   amdApproversWithoutAmt();
		   }
	});	
	
	$("#nav-ta-amdreturnToBusiness").click(function(){
		   $(this).addClass('tabactive');
		   $('#li2').addClass('liactive');
		   $('#li1').removeClass('liactive');
		   $('#li3').removeClass('liactive');
		   $('#li4').removeClass('liactive');
		   $("#nav-ta-amdapprove").removeClass('tabactive');
		   $("#nav-ta-amdsave").removeClass('tabactive');
		   $("#nav-ta-amddeleteAmendment").removeClass('tabactive');
		   
	});	
	
	if(!$('#nav-ta-amdsave').attr('handlerAmdsaveDraft')) {
		$("#nav-ta-amdsave").click(function(){
			   $(this).addClass('tabactive');
			   $('#li3').addClass('liactive');
			   $('#li1').removeClass('liactive');
			   $('#li2').removeClass('liactive');
			   $('#li4').removeClass('liactive');
			   $("#nav-ta-amdapprove").removeClass('tabactive');
			   $("#nav-ta-amdreturnToBusiness").removeClass('tabactive');
			   $("#nav-ta-amddeleteAmendment").removeClass('tabactive');
			   $('#actionTypeId').val("1");
				$('form#trAnalystSubmitForm').submit();
			   
		});
		$('#nav-ta-amdsave').attr('handlerAmdsaveDraft', true);
	}
	$('form#trAnalystSubmitForm').submit(function() {
		return true;
	});
	
	$("#nav-ta-amddeleteAmendment").click(function(){
		   $(this).addClass('tabactive');
		   $('#li4').addClass('liactive');
		   $('#li1').removeClass('liactive');
		   $('#li2').removeClass('liactive');
		   $('#li3').removeClass('liactive');
		   $("#nav-ta-amdapprove").removeClass('tabactive');
		   $("#nav-ta-amdreturnToBusiness").removeClass('tabactive');
		   $("#nav-ta-amdsave").removeClass('tabactive');
		   $("#deleteReasonId").val("");
		   $('#fourHundredCounter').text('400');
		   $('.deleteReasonError').hide();
		   $('.deleteReasonError').parent('div').removeClass('errorBlock');
		   $('#deleteAmendment').modal({show: 'true'});
	});
	
	$("#nav-auto-amddeleteAmendment").click(function(){
		$('nav ul li.navLi').removeClass('liactive');
		$('nav ul li.navLi').find('.tabactive').removeClass('tabactive');
		$("#deleteReasonId").val("");
		$('#fourHundredCounter').text('400');
		$('.deleteReasonError').hide();
		$('.deleteReasonError').parent('div').removeClass('errorBlock');
		$('#deleteAutoAmendment').modal({show: 'true'});
	});
	
	$("#deleteAmendmentId").off("click").on("click",function(e){
		e.stopImmediatePropagation();
		$('.deleteReasonError').hide();
		var errorFlag = 0;
		if($('#deleteReasonId').val() == undefined || $('#deleteReasonId').val() == ''){
			$('.deleteReasonError').show();
			$('.deleteReasonError').parent('div').addClass('errorBlock');
			errorFlag = 1;
		}
		if(errorFlag == 1){
			return false;
		}else {
			$('#actionTypeId').val("37");
			$('form#trAnalystSubmitForm').submit();
		}
	});
	
	$("#deleteAutoAmendmentId").off("click").on("click",function(e){
		e.stopImmediatePropagation();
		$('#actionTypeId').val("37");
		$('form#submitAutoAmendmentFormID').submit();
	});
	
	if(!$('#nav-ta-amdapprove').attr('handleramdApproveDraft')) {
		$("#nav-ta-amdapprove").click(function(){
			   $(".approversErrorDiv").hide();
			   $(this).addClass('tabactive');
			   $('#li1').addClass('liactive');
			   $('#li2').removeClass('liactive');
			   $('#li3').removeClass('liactive');
			   $('#li4').removeClass('liactive');
			   $("#nav-ta-amdreturnToBusiness").removeClass('tabactive');
			   $("#nav-ta-amdsave").removeClass('tabactive');
			   $("#nav-ta-amddeleteAmendment").removeClass('tabactive');
			   var approverAmount = $('#revisedUSDEquiAmt').val();
			   var amdWorkflowAmt = $('#amdWorkflowAmt').val();
			   if((approverAmount !="" && approverAmount != undefined) && (amdWorkflowAmt !="" && amdWorkflowAmt != undefined)){
				   approverAmount= parseFloat(approverAmount.replace(/,/g,""));
				   amdWorkflowAmt= parseFloat(amdWorkflowAmt.replace(/,/g,""));
				   if(approverAmount > amdWorkflowAmt){
					   $('#infoTransmissionDiv').hide();
					   $('#amdtreasuryDelegationDiv').show();
					   $('#submitProcess').show();
					   getDelegationApproversOnSubmit(approverAmount);
					   
				   }else{
					   $('#infoTransmissionDiv').show();
					   $('#amdtreasuryDelegationDiv').hide();
					   
				   }
			   }			   
		});	
		$('#nav-ta-amdapprove').attr('handleramdApproveDraft', true);
	
	}
	
	var amendTrAnalystErorShow = $('#amendTrAnalystErorShowId').val();
	if(amendTrAnalystErorShow!=undefined && amendTrAnalystErorShow == 'true'){
		$('#amendTrAnalystErorShowDivId').show();
		var actionId= $('#actionTypeId').val();
		if(actionId=='4'){
			$('#nav-ta-amdapprove').addClass('tabactive');
			 $('#li1').addClass('liactive');
			 $('#li2').removeClass('liactive');
			 $('#li3').removeClass('liactive');
			 $('#li4').removeClass('liactive');
		     $("#nav-ta-amdreturnToBusiness").removeClass('tabactive');
		     $("#nav-ta-amdsave").removeClass('tabactive');
		     $("#nav-ta-amddeleteAmendment").removeClass('tabactive');
			 var approverAmount = $('#revisedUSDEquiAmt').val();
			   var amdWorkflowAmt = $('#amdWorkflowAmt').val();
			   if((approverAmount !="" && approverAmount != undefined) && (amdWorkflowAmt !="" && amdWorkflowAmt != undefined)){
				   approverAmount= parseFloat(approverAmount.replace(/,/g,""));
				   amdWorkflowAmt= parseFloat(amdWorkflowAmt.replace(/,/g,""));
				   if(approverAmount > amdWorkflowAmt){
					   $('#infoTransmissionDiv').hide();
					   $('#amdtreasuryDelegationDiv').show();
					  getDelegationApprovers();					   
				   }else{
					   $('#infoTransmissionDiv').show();
					   $('#amdtreasuryDelegationDiv').hide();					   
				   }
				   
			   }
			   $('#tab1').show();
			   
		}
		if(actionId=='3'){			
			 $('#li2').addClass('liactive');
			   $('#li1').removeClass('liactive');
			   $('#li3').removeClass('liactive');
			   $('#li4').removeClass('liactive');
			   $("#nav-ta-amdreturnToBusiness").addClass('tabactive');
			   $("#nav-ta-amdapprove").removeClass('tabactive');
			   $("#nav-ta-amdsave").removeClass('tabactive');
			   $("#nav-ta-amddeleteAmendment").removeClass('tabactive');
			   $('#tab2').show();	
		}
	}
	
	
	
	if(!$('#tra-nav-save').attr('handlerPostAwardSave')) {
		$("#tra-nav-save").click(function(){
			$(this).addClass('tabactive');
			$('#li22').removeClass('liactive');
			$("#tra-nav-award").removeClass('tabactive');
			$('#actionTypeId').val("1");
			$('form#postawardSubmitForm').submit();
		});
		$('#tra-nav-save').attr('handlerPostAwardSave', true);

		}
		$('form#postawardSubmitForm').submit(function() {
			return true;
		});
		
		if(!$('#tra-nav-award').attr('handlerPostAwardSubmit')) {
		$("#tra-nav-award").click(function(){
		    $(this).addClass('tabactive');
			   $('#li22').addClass('liactive');
			   $("#tra-nav-save").removeClass('tabactive');
		});
		$('#tra-nav-award').attr('handlerPostAwardSubmit', true);
		}
				
});

function calculateRevisedUSDAmount(){
	var revisedAmt = $('#revisedInstrumentAmt').val();
	var newCurrId = $('#newInstCurrId').val();
	$(".usdEquivalentErrorDiv").hide();
	if(newCurrId!="" && revisedAmt!=""){
		if(newCurrId!=undefined && revisedAmt!=undefined){
			if(newCurrId!="USD"){
				$('#RevisedUsdProcess').show();
				var amdinstrumentdata = {currCode: newCurrId,originalCCYAmount: revisedAmt};
				var url = contextURL +"/int/USDEquivalentRefData.action";
				$.ajax({
					type: "POST",
					url: url,
					dataType: 'json',
					data: amdinstrumentdata,
					success: function(data){
						$('#revisedUSDEquiAmt').siblings('p').text(data.data);
						$('#revisedUSDEquiAmt').val(data.data);
						$('#RevisedUsdProcess').hide();						
					},
					error: function (xhr, textStatus, errorThrown ) {
						var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
						$(".usdEquivalentErrorDiv").show();
						$(".usdEquivalentErrorDiv").find('div.errorContent').html(errorReason);
						$('#revisedUSDEquiAmt').siblings('p').text("");
						$('#revisedUSDEquiAmt').val("");
						$('#RevisedUsdProcess').hide();		
				    }
				});
			}else{
				$('#revisedUSDEquiAmt').siblings('p').text(revisedAmt);
				$('#revisedUSDEquiAmt').val(revisedAmt);
			}
		}
	}
}

function checkRevisedExpDate() {
	var revisedDate = new Date($.trim($('#expiryDt').val()));
	var amendmentCurrentExpDate = new Date($.trim($('p#amendmentCurrentExpDate').text()));

	if((revisedDate != undefined && revisedDate != '') && revisedDate < amendmentCurrentExpDate){
		$('.expDateNotification').show();
	}else{
		$('.expDateNotification').hide();
	}
}

function onLoadInstrumentOperation(){
	var operation= $('#instrumentOperationId').val();
	if(operation != undefined && operation != '' && operation=='INCREASE'){
		$('.IncOrDec').text("Increase");
	}
	if(operation != undefined && operation != '' && operation=='DECREASE'){
		$('.IncOrDec').text("Decrease");
	}
	if($('#instrumentOperationId_INCREASE').is(':checked')) {
		$('.IncOrDec').text("Increase");
		$('.instrAmtNotification').hide();
		}
	if ($('#instrumentOperationId_DECREASE').is(':checked')){
		$('.IncOrDec').text("Decrease");
		$('.instrAmtNotification').show();
	}
	
}

function setRevisedInsAmt(){
	if($('#revisedInstrumentAmt').val() != undefined && $('#revisedInstrumentAmt').val() != ''){
		$('#revisedInstrumentAmt').siblings("p").text($('#revisedInstrumentAmt').val());
	}
	if($('#revisedUSDEquiAmt').val() != undefined && $('#revisedUSDEquiAmt').val() != ''){
		$('#revisedUSDEquiAmt').siblings("p").text($('#revisedUSDEquiAmt').val());
	}
	
}

function amountTowordsConersion(amount,targetid){
	if(amount!=undefined && amount!="" ){
		var insAmtToword = toWords(amount);
		targetid.html(insAmtToword);
	}
}

function onLoadAmountInWords(){
	var currentInsAmount= $('#currentInstrumentAmt').val();
	if(currentInsAmount!=undefined && currentInsAmount!="" ){
		amountTowordsConersion(currentInsAmount,$('#currentInsAmountinWords'));
		
	}
	var revisedInsAmount= $('#revisedInstrumentAmt').val();
	if(revisedInsAmount!=undefined && revisedInsAmount!="" ){
		amountTowordsConersion(revisedInsAmount,$('#revisedInsAmountinWords'));
		
	}
}
function amdApproversWithoutAmt(){
	var revisedAmt = $('#currentInstrumentAmt').val();
	var newCurrId = $('#newInstCurrId').val();
	if(newCurrId!="" && revisedAmt!=""){
		if(newCurrId!=undefined && revisedAmt!=undefined){
			$('#submitProcess').show();
			if(newCurrId!="USD"){
				var amdinstrumentdata = {currCode: newCurrId,originalCCYAmount: revisedAmt};
				var url = contextURL +"/int/USDEquivalentRefData.action";
				$.ajax({
					type: "POST",
					url: url,
					dataType: 'json',
					data: amdinstrumentdata,
					success: function(data){
						$('#revisedUSDEquiAmt').val(data.data);
						$('#revisedUSDEquiAmt').siblings('p').text(data.data);
						 getDelegationApproversOnSubmit(data.data);
					},
					error: function (xhr, textStatus, errorThrown ) {
						$('#submitProcess').hide();
						var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
						$(".approversErrorDiv").show();
						$(".approversErrorDiv").find('div.errorContent').html(errorReason);	
				    }
				});
			}else{
				$('#revisedUSDEquiAmt').val(revisedAmt);
				 $('#revisedUSDEquiAmt').siblings('p').text(revisedAmt);
				 getDelegationApproversOnSubmit(revisedAmt);
			}
		}
	}
}
function hideSubmitBtns(){
	$(".approversErrorDiv").hide();
	$('li.navLi').removeClass('liactive');
	$("a.navLink").removeClass('tabactive');
	$('.tab').hide();
}