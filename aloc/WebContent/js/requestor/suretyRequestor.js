
$(document).ready(function() {
	
//Surety Bond related script start
bondamountTowords();		 
showHidePrincipalAddress();
showHideObligeeAddress();
amountInWords();
suretyUSDShow();
showSubBondOnload(); //bond details
showMailingStateOnload();//mailing address

var selectedSiteId =$('#selectedSite').val();
$('#selectedSiteId').val(selectedSiteId);

$('body').off('change', '#selectedSiteId').on('change', '#selectedSiteId', function(e) {
	var siteId = $(this).val();
	var newsiteId = siteId.replace(/,/g,"");
	$('#reqsiteID').val(newsiteId);
	e.stopPropagation();
});
$('body').off('change','#bondAmt').on('change','#bondAmt',function(e){
	e.stopPropagation();
	amountInWords();
});

$('body').off('change','#geDivisionID').on('change','#geDivisionID',function(e){
	e.stopPropagation();
	var geDivisionName=$('#geDivisionID :selected').text();
	$('#geDivisionName').val(geDivisionName);	
});


$('body').off('change','#selectBond').on('change','#selectBond',function(e) {
	e.stopPropagation();
	var selectBond =  $("#selectBond").val();
    showBondSubType(selectBond);
    showBondInformation(selectBond);
});

$('body').off('change','#selectSubBond').on('change','#selectSubBond',function(e){
	e.stopPropagation();
	var bondSubType=$('#selectSubBond :selected').text();
	$('#bondSubType').val(bondSubType);
});
$('body').off('change','#contractAmt').on('change','#contractAmt',function(e){
	e.stopPropagation();
	suretyUSDShow();
});

$('body').off('change','#bondAmount').on('change','#bondAmount',function(e){
	e.stopPropagation();
	suretyUSDShow();
});

$('body').off('change','#mailingState').on('change','#mailingState',function(e){
 $('select.comboMailingState option[value="-1"]').attr("selected",true);
});

$.subscribe('showSBTreasuryAnalystBtns', function(event,data) {		
	readyForSystemChecks();	
	$('#postAwardCounter').text('400');
	$('#postAwardComments').show();
});

contactPersonMakeMandatory();

subscribeNameAndShowState();

$('body').off('change','#principleInfoFlag').on('change','#principleInfoFlag',function(e){
	e.stopPropagation();
if($(e.target).is(":checked")) {
	$('#companyName').val($('#principalAddressName').val());
	$('#mailingAddress1').val($('#principalAddress1').val());
	$('#mailingAddress2').val($('#principalAddress2').val());
	$('#mailingCity').val($('#principalAddressCity').val());
	$('#mailingState').val($('#principalAddressState').val());
	$('select.comboMailingState option[value="-1"]').attr("selected",true);
	$('#mailingzipPostalCode').val($('#principalAddressZip').val());
	$('#mailingcountryCd').val($('#principalCountryCd').val());
	$('#mailingCountry').val($('#principalAddressCountry').val());
	$('#mailingCountry').siblings("input.ui-widget").val($("#principalAddressCountry").val());
	$('#mailingCountry').closest('div.form-row').find('div.errorBlock').find("input.ui-widget").val($("#principalAddressCountry").val());
}
$.publish('/fieldCounter/fieldsModified', '#companyName');
});

subscribePrincipalState();
//Surety Bond related script end					
});

//Surety Bond realted functions start

function showBondSubType(val) {
	var selectSubBondIdDet =  $("#selectSubBondIdDet").val();
	var bondType=$('#selectBond :selected').text();
	$('#bondType').val(bondType);	
	$(".bondTypeErrorShow").hide();
	if ((val == "2") || (val == "3") || (val == "4")) 
		{	
		var a=1;
		 $('#bondprocess').show();
		    $.ajax({
		    	type: "POST",
	            url: contextURL +'/int/requestor/getBondSubTypes.action',
	            dataType: 'json',
	            data: { bondType : val},
	            processdata: true,
	            success: function(data) {
	            	$("#bondSubtype").slideDown("fast");
	            	$("#selectSubBond").empty().append("<option value=''>Select...</option>");
	            	for (var i = 0; i < data.result.length; i++) {
	            		if(selectSubBondIdDet!=undefined && selectSubBondIdDet!="" &&  selectSubBondIdDet== data.result[i].id)
	            			{
	            				$("#selectSubBond").append("<option value='" + data.result[i].id +"' selected>" + data.result[i].name + "</option>");
	            			}
	            		else{
	            				$("#selectSubBond").append("<option value='" + data.result[i].id + "'>" + data.result[i].name + "</option>");
	            				if(a++ == '1') {
	            					}
	            		}
	                }
	            	 $('#bondprocess').hide();
	            	 
	            	 makeMandatory('#selectSubBond');
	            },
	            error: function (xhr, textStatus, errorThrown ) {
	            	$('#bondprocess').hide();
					var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
					$(".bondTypeErrorShow").show();
					$(".bondTypeErrorShow").find('div.errorContent').html(errorReason);
					
			    }
	        });
		    		   
		}else {
			$("#bondSubtype").slideUp("fast");
			$("#selectSubBond").val("");
			$("#bondSubType").val("");	
			removeMandatory('#selectSubBond');		
	}
}


function showHidePrincipalAddress() {
	if($('#principlaAddressSelectionId').val() != undefined && $('#principlaAddressSelectionId').val() == 'New'){
		$('#PrincipalShowManually').show();
		if($("#principalCountryCd").val()=="US"){
			   $("#principalStateDivId").show();
		   }
	}
}

function showHideObligeeAddress() {
	if($('#obligeeAddressSelectionId').val() != undefined && $('#obligeeAddressSelectionId').val() == 'New'){
		$('#ObligeeShowManually').show();
	}
}

function amountInWords()
{
	var ccyCode = $('#currencies1').val();
	var amount = $('#bondAmt').val();
	if(ccyCode!="" && ccyCode!=undefined && amount!="" && amount!=undefined){
		var toword = toWords(amount);
			$('#amountinWords').html(ccyCode + " - " +toword);
	}
}

function bondamountTowords(){
	var bondcur= $('.row').children('.subdiv').children('.suretybondCurrency').children(".bondCurrency").html();
	var bondamount= $('.row').children('.suretyAmountDiv').children('.bondamountDiv').children(".bondAmount").html();
	if(bondamount!=undefined && bondamount!="" ){
		var bondAmtToword = toWords(bondamount);
		$('#amountinWords').html(bondcur + " - " +bondAmtToword);
	}
}

function showBondInformation(bondTypeId)
{
	var url = contextURL +'/int/requestor/bondInfoController.action' + '?bondTypeId=' + bondTypeId;	
	$.ajax({
		type:'POST',
		url: url,
		dataType: 'html',
		data: {},
		success: function(data) {
			$('#bondInfoDiv1').empty().html(data);
		}
	});		
};

function showMailingStateOnload(){
	var countrycode=$("#mailingCountryOfIncId").val();
	if(countrycode!=undefined && countrycode!=""){
	if(countrycode == "US"){
			   $("#mailingStateDivId").show();
			   makeMandatory('#mailingstateOfIncCd_widget');			 
		   }else{
			   $("#mailingStateDivId").hide();
			   removeMandatory('#mailingstateOfIncCd_widget');
		   } 
	}
}

function showSubBondOnload(){
	var selectBond =  $("#selectBond").val();
	if(selectBond!=undefined && selectBond!=""){
		showBondSubType(selectBond);
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
			   makeMandatory('#principalStateOfIncCd_widget');//need to check
		   }else{
			   $("#principalStateDivId").hide();			  		
			 $("#principalStateDivId input").val('');
			 removeMandatory('#principalStateOfIncCd_widget');
		   } 
	if($('#' + data.id).hasClass('mandatory')) {
		fieldsModified('#' + data.id);
		}
	event.stopPropagation();
	});
}

function subscribeNameAndShowState(){
	$.subscribe('getNameAndShowState', function(event,data) {
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
		if($("#mailingCountryOfIncId").val()=="US"){
	  		   $("#mailingStateDivId").show();
	  		  makeMandatory('#mailingstateOfIncCd_widget');
	  	   }else{
	  		   $("#mailingStateDivId").hide();			  		
	  		   $("#mailingStateDivId input").val('');
	  		   $("#mailingStateDivId hidden").val('');
	  		 removeMandatory('#mailingstateOfIncCd_widget');
	  	   } 
		if($('#' + data.id).hasClass('mandatory')) {
			fieldsModified('#' + data.id);
			}
		event.stopPropagation();				
	});
}

function suretyUSDShow(){
	var ccyCode = $('#currencies').val();
	var CurrencyCode = $('#currencies1').val();
	if(ccyCode!="" && ccyCode!=undefined){
		if(ccyCode=="USD"){
			$('#usdEquivalentDiv').hide();
		}else{
			$('#usdEquivalentDiv').show();
		}
	}
	if(CurrencyCode!="" && CurrencyCode!=undefined){
		if(CurrencyCode=="USD"){
			$('#estUsdEquivalentDiv').hide();
		}else{
			$('#estUsdEquivalentDiv').show();
		}
	}
}

function contactPersonMakeMandatory(){
	var BondReqNameSelection = $('#BondReqNameSelectionID').val();
	if(BondReqNameSelection!=undefined && BondReqNameSelection!=""){
		makeMandatory('#bondReqPhoneNumber,#bondReqName,#emailAddr');
	}else{
		removeMandatory('#bondReqPhoneNumber,#bondReqName,#emailAddr');
	}
}
//Surety Bond realted functions end
