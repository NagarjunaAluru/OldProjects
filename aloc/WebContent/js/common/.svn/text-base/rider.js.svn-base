//Rider
$(document).ready(function() {
	
	showHidePrincipalAddress();
	showHideObligeeAddress();
	
	$('body').off('change','#amountIncDec').on('change','#amountIncDec',function(){
		hideSubmitBtns();
		var revisedBondAmt = 0;
		var revisedContractAmt = 0;
		var isContractBond = $('#contractBondID').val();
		var currCode=$('#contractCurId').val();
		var currentBondAmt = $('#currentBondAmtId').val();
		var currentContractAmt = 0;
		currentBondAmt = currentBondAmt.replace(/,/g,"");
		if(isContractBond == "true"){
			currentContractAmt = $('#originalContractAmtId').val();
			currentContractAmt = currentContractAmt.replace(/,/g,"");
		}
		
		var amount = $(this).val().replace(",","");
		if(amount == undefined || amount== ""){
			$('#amountvalidationShow').addClass('hide');
			$(this).closest('.row').next().find('p').text("");
			$('#revisedBondAmt').val("");
			$('#revisedUSDEquiContractAmtId').val("");
			$('#revisedUSDEquiContractAmtId').siblings('p').text("");
			return false;
		}
		var incDec = $('input[type="radio"].amtIncDecRadio:checked').val();
		if(incDec == 'INCREASE'){
			$('#amountvalidationShow').addClass('hide');
			revisedBondAmt = parseFloat(currentBondAmt) + parseFloat($(this).val().replace(",",""));
			if(isContractBond == "true"){
				revisedContractAmt = parseFloat(currentContractAmt) + parseFloat($(this).val().replace(",",""));
			}
		}else if(incDec == 'DECREASE'){
			$('#amountvalidationShow').addClass('hide');
			revisedBondAmt = parseFloat(currentBondAmt) - parseFloat($(this).val().replace(",",""));
			if(revisedBondAmt < 0){
				$('#amountvalidationShow').removeClass('hide');
				$(this).closest('.row').next().find('p').text("");
				$('#revisedBondAmt').val("");
				$('#revisedUSDEquiContractAmtId').val("");
				$('#revisedUSDEquiContractAmtId').siblings('p').text("");
				return false;
			}
			if(isContractBond == "true"){
				revisedContractAmt = parseFloat(currentContractAmt) - parseFloat($(this).val().replace(",",""));
			}
		}else{
			return false;
		}
		$(this).closest('.row').next().find('p').text(revisedBondAmt);
		$('#revisedBondAmt').val(revisedBondAmt);
		
		if(isContractBond == "true"){
			$('#revisedContractAmtId').siblings('p').text(revisedContractAmt );
			$('#revisedContractAmtId').val(revisedContractAmt);
		if(currCode!="" && revisedContractAmt!=""){
			if(currCode!=undefined && revisedContractAmt!=undefined){
				if(currCode != 'USD'){
					var data = {currCode: currCode,originalCCYAmount: revisedContractAmt};
					var url = contextURL +"/int/USDEquivalentRefData.action";
					$.ajax({
						type: "POST",
						url: url,
						dataType: 'json',
						data: data,
						success: function(data){
							$('#revisedUSDEquiContractAmtId').val(data.data);
							$('#revisedUSDEquiContractAmtId').siblings('p').text(data.data);
							}
						});
				}else{
						$('#revisedUSDEquiContractAmtId').val(revisedContractAmt);
					}
				}	
			}
		}
	});
	
	$('body').off('click','input.amtIncDecRadio').on('click','input.amtIncDecRadio',function(){
		if($('#amountIncDec').val() != undefined && $('#amountIncDec').val() != ''){
			$('#amountIncDec').change();
		}
	});
	
	// Create Rider SaveAsDraft button
	$("#nav-saveasDraft").click(function(){
		$(this).addClass('tabactive');
		 $('#li22').removeClass('liactive');
		$("#nav-submitRider").removeClass('tabactive');
		$('#actionTypeId').val("1");
		$('form#suretyRiderFormId').submit();
		
	});
	$('form#suretyRiderFormId').submit(function() {
		return true;
	});
	$("#nav-submitRider").click(function(){
		$(this).addClass('tabactive');
		$(".approversErrorDiv").hide();
		$('#li22').addClass('liactive');
		$('#li23').removeClass('liactive');
		getApprovers();
	});	
	
	subscribePrincipalState();//principal
	onloadPrincipalStateDivId();//principal
	
	 
	 $('body').off('change','#addressSelection').on('change','#addressSelection',function(){
		var addressSelectionVal =  $("#addressSelection").val();
         if(addressSelectionVal=='PrincipalDetails') {
				$('#sbAddress1').val($('#principalAddress1').val());
				$('#sbAddress2').val($('#principalAddress2').val());
				$('#sbCity').val($('#principalAddressCity').val());
				if($('#principalAddressState').val() != undefined && $('#principalAddressState').val() !=""){
					$('#stateProvince2').val($('#principalAddressStatecode').val());
					$('#deliveryAddressState').val($("#principalAddressState").val());
					$('#deliveryAddressState').siblings("input.ui-widget").val($("#principalAddressState").val());
					$('select.comboDeliveryState option[value="-1"]').attr("selected",true);
				}else{
					$('#stateProvince2').val("");
					$('#deliveryAddressState').val("");
					$('#deliveryAddressState').siblings("input.ui-widget").val("");
					$('select.comboDeliveryState option[value="-1"]').attr("selected",true);
				}
				if($('#principalCountryCd').val() != undefined && $('#principalCountryCd').val() !=""){
					$('#sbCountryCode').val($('#principalCountryCd').val());
					$('#deliveryAddresscountry').val($("#principalAddressCountry").val());
					$('#deliveryAddresscountry').siblings("input.ui-widget").val($("#principalAddressCountry").val());
				}else{
					$('#sbCountryCode').val("");
					$('#deliveryAddresscountry').val("");
					$('#deliveryAddresscountry').siblings("input.ui-widget").val("");
				}				
				$('#zipPostalcode').val($('#principalAddressZip').val());					
	        }
        else if(addressSelectionVal=='ObligeeDetails') {
			$('#sbAddress1').val($('#obligeeAddress1').val());
			$('#sbAddress2').val($('#obligeeAddress2').val());
			$('#sbCity').val($('#obligeeAddressCity').val());
			if($('#obligeeAddressState').val() != undefined && $('#obligeeAddressState').val() !=""){
				$('#stateProvince2').val($('#obligeeAddressStateCd').val());
				$('#deliveryAddressState').val($("#obligeeAddressState").val());
				$('#deliveryAddressState').siblings("input.ui-widget").val($("#obligeeAddressState").val());
				$('select.comboDeliveryState option[value="-1"]').attr("selected",true);
			}else{
				$('#stateProvince2').val("");
				$('#deliveryAddressState').val("");
				$('#deliveryAddressState').siblings("input.ui-widget").val("");
				$('select.comboDeliveryState option[value="-1"]').attr("selected",true);
			}
			if($('#obligeeAddressCountryCd').val() != undefined && $('#obligeeAddressCountryCd').val() !=""){
				$('#sbCountryCode').val($('#obligeeAddressCountryCd').val());
				$('#deliveryAddresscountry').val($("#obligeeAddressCountry").val());
				$('#deliveryAddresscountry').siblings("input.ui-widget").val($("#obligeeAddressCountry").val());
			}else{
				$('#sbCountryCode').val("");
				$('#deliveryAddresscountry').val("");
				$('#deliveryAddresscountry').siblings("input.ui-widget").val("");
			}				
			$('#zipPostalcode').val($('#obligeeAddressZip').val());				
        }
        else{
        	clearDeliveryDetails();	
        }
	});
	
	
	//Rider Treasury Analyst Final buttons logic
	
	if(!$('#nav-riderApprove').attr('handlerRiderApprove')) {
		$("#nav-riderApprove").click(function(){
			   $(this).addClass('tabactive');
			   $(".approversErrorDiv").hide();
			   $('#li1').addClass('liactive');
			   $('#li2').removeClass('liactive');
			   $('#li3').removeClass('liactive');
			   $('#li4').removeClass('liactive');
			   $("#nav-riderReturnToBusiness").removeClass('tabactive');
			   $("#nav-ridersave").removeClass('tabactive');
			   $("#nav-deleteRider").removeClass('tabactive');
			   riderTreasuryAnalystApprovers();
		});	
		$('#nav-riderApprove').attr('handlerRiderApprove', true);	
	}
	
	if(!$('#nav-riderReturnToBusiness').attr('handlerRiderReturnToBusiness')) {
	$("#nav-riderReturnToBusiness").click(function(){
		   $(this).addClass('tabactive');
		   $('#li2').addClass('liactive');
		   $('#li1').removeClass('liactive');
		   $('#li3').removeClass('liactive');
		   $('#li4').removeClass('liactive');
		   $("#nav-riderApprove").removeClass('tabactive');
		   $("#nav-ridersave").removeClass('tabactive');
		   $("#nav-deleteRider").removeClass('tabactive');
		   
	});	
		$('#nav-riderReturnToBusiness').attr('handlerRiderReturnToBusiness', true);	
	}
	
	if(!$('#nav-ridersave').attr('handlerRidersaveDraft')) {
		$("#nav-ridersave").click(function(){
			   $(this).addClass('tabactive');
			   $('#li3').addClass('liactive');
			   $('#li1').removeClass('liactive');
			   $('#li2').removeClass('liactive');
			   $('#li4').removeClass('liactive');
			   $("#nav-riderApprove").removeClass('tabactive');
			   $("#nav-deleteRider").removeClass('tabactive');
			   $("#nav-riderReturnToBusiness").removeClass('tabactive');
			   $('#actionTypeId').val("1");
			   $('form#trAnalystSubmitForm').submit();			   
		});
		$('#nav-ridersave').attr('handlerRidersaveDraft', true);
	}
	
	if(!$('#nav-deleteRider').attr('handlerDeleteRider')) {
	$("#nav-deleteRider").click(function(){
		   $('#li1').removeClass('liactive');
		   $('#li2').removeClass('liactive');
		   $('#li3').removeClass('liactive');
		   $("#nav-riderApprove").removeClass('tabactive');
		   $("#nav-riderReturnToBusiness").removeClass('tabactive');
		   $("#nav-ridersave").removeClass('tabactive');
		   $("#deleteReasonId").val("");
		   $('#fourHundredCounter').text('400');
		   $('.deleteReasonError').hide();
		   $('.deleteReasonError').parent('div').removeClass('errorBlock');
		   $('#deleteRider').modal({show: 'true'});
		   
	});
	$('#nav-deleteRider').attr('handlerDeleteRider', true);
	}
	$('form#trAnalystSubmitForm').submit(function() {
		return true;
	});
	$("#deleteRiderId").off("click").on("click",function(e){
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
	
});

function showHidePrincipalAddress() {
	if($('#principlaAddressSelectionId').val() != undefined && $('#principlaAddressSelectionId').val() == 'New'){
		$('#PrincipalShowManually').show();
	}
}

function showHideObligeeAddress() {
	if($('#obligeeAddressSelectionId').val() != undefined && $('#obligeeAddressSelectionId').val() == 'New'){
		$('#ObligeeShowManually').show();
	}
}

function subscribePrincipalState(){
	 $.subscribe('showPrincipalState', function(event,data) {
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
			
		if($("#principalCountryCd").val()=="US"){
	  		   $("#principalStateDivId").show();
	  	   }else{
	  		   $("#principalStateDivId").hide();			  		
	  		 $("#principalStateDivId input").val('');
	  	   } 
		event.stopPropagation();
		
	});	
}

function onloadPrincipalStateDivId(){
	 var principalCountrycode=$("#principalCountryCd").val();
	 if(principalCountrycode!=undefined && principalCountrycode!=""){
	 if(principalCountrycode == "US"){
	 	   $("#principalStateDivId").show();
	  }else{
	 	   $("#principalStateDivId").hide();
	 	  $("#principalStateDivId input").val('');
	  } 
	 }	
}

function riderTreasuryAnalystApprovers(){
	 
	 var approverAmount;
	 	var riderWorkflowAmt = $('#riderWorkflowAmt').val();
		var isContractBond = $('#contractBondID').val();
		if(isContractBond == "true"){
			approverAmount = $('#revisedUSDEquiContractAmtId').val();
		}else{
			approverAmount = $('#revisedBondAmt').val();
		}
		if((approverAmount !="" && approverAmount != undefined) && (riderWorkflowAmt !="" && riderWorkflowAmt != undefined)){
			approverAmount= parseFloat(approverAmount.replace(/,/g,""));
			riderWorkflowAmt= parseFloat(riderWorkflowAmt.replace(/,/g,""));
			$('#validationUsdAmount').val(approverAmount);
		 if(approverAmount > riderWorkflowAmt){	
			$('#riderTreasuryDelegationDiv').show();
			$('#submitProcess').show();
			getDelegationApproversOnSubmit(approverAmount);
			 }else{
				 $('#riderTreasuryDelegationDiv').hide();
			 }
		}else{
			if(isContractBond == "true"){
				  var revisedAmt = $('#originalContractAmtId').val();
					var newCurrId = $('#contractCurId').val();
					if(newCurrId!="" && revisedAmt!=""){
						if(newCurrId!=undefined && revisedAmt!=undefined){
							  revisedAmt= parseFloat(revisedAmt.replace(/,/g,""));
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
										approverAmount=data.data;	
										if((approverAmount !="" && approverAmount != undefined) && (riderWorkflowAmt !="" && riderWorkflowAmt != undefined)){
											approverAmount= parseFloat(approverAmount.replace(/,/g,""));
											riderWorkflowAmt= parseFloat(riderWorkflowAmt.replace(/,/g,""));
											$('#validationUsdAmount').val(approverAmount);
											if( approverAmount > riderWorkflowAmt){				
												$('#submitProcess').show();
												$('#riderTreasuryDelegationDiv').show();
												getDelegationApproversOnSubmit(approverAmount);
											 }else{$('#riderTreasuryDelegationDiv').hide();}
										}
									},
									error: function (xhr, textStatus, errorThrown ) {
										$('#submitProcess').hide();
										var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
										$(".approversErrorDiv").show();
										$(".approversErrorDiv").find('div.errorContent').html(errorReason);	
								    }
								});
							}else{
								approverAmount = revisedAmt;
								if((approverAmount !="" && approverAmount != undefined) && (riderWorkflowAmt !="" && riderWorkflowAmt != undefined)){
									approverAmount= parseFloat(approverAmount.replace(/,/g,""));
									riderWorkflowAmt= parseFloat(riderWorkflowAmt.replace(/,/g,""));
									$('#validationUsdAmount').val(approverAmount);
									if( approverAmount > riderWorkflowAmt){				
										$('#submitProcess').show();
										$('#riderTreasuryDelegationDiv').show();
										getDelegationApproversOnSubmit(approverAmount);
									 }else{$('#riderTreasuryDelegationDiv').hide();}
								}
							}
						}
					}
			   }
			else{
				approverAmount = $('#currentBondAmtId').val();
				if((approverAmount !="" && approverAmount != undefined) && (riderWorkflowAmt !="" && riderWorkflowAmt != undefined)){
					approverAmount= parseFloat(approverAmount.replace(/,/g,""));
					riderWorkflowAmt= parseFloat(riderWorkflowAmt.replace(/,/g,""));
					$('#validationUsdAmount').val(approverAmount);
					if( approverAmount > riderWorkflowAmt){				
						$('#submitProcess').show();
						$('#riderTreasuryDelegationDiv').show();
						getDelegationApproversOnSubmit(approverAmount);
					 }else{$('#riderTreasuryDelegationDiv').hide();}
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