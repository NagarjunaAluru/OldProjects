$(document).ready(function() {
	
	//DLOC related script start
	showHideBank();
	showHideIssuingBankAddress();
	showHideBeneficaryAddress();
	showHideApplicantAddress();
	
	bcpSiteSelect();
	getAutocompleterNameAndUS();
	instTrasactionOriginGoods();
	lcPaymentTermsSelect();
	decCounter("othPaymentDesc", 50);
	
	$.subscribe('showSubmitButtons', function(event,data) {
		var requiresEditsValue= $('.requiresEdits').text();
		$("#readySystemCheckSection").hide();	
		$("#submitDiv").removeClass('hide');
		if(requiresEditsValue != undefined && requiresEditsValue!=''){
			$("#li-send-back").show();
			$("#li-bid").hide();
			$("#tra-nav-sendBack").parent('li').show();
			$("#tra-nav-award").parent('li').hide();
		}else{
			$("#li-bid").show();
			$("#li-send-back").hide();
			$("#tra-nav-sendBack").parent('li').hide();
			$("#tra-nav-award").parent('li').show();
		}
		$('#postAwardCounter').text('400');
		$('#postAwardComments').show();
	});
	
	$('body').off('change', '#selectedSiteId').on('change', '#selectedSiteId', function(e) {
		var siteId = $(e.target).val();
		var newsiteId = siteId.replace(/,/g,"");
		$('#reqsiteID').val(newsiteId);
		e.stopPropagation();
	});

	 $('body').off('change', '#lcPaymentTermsID').on('change', '#lcPaymentTermsID', function(e) {
		 e.stopPropagation();
		var LCPaymentTerm=$('#lcPaymentTermsID :selected').text();
		$('#LCPaymentTerm').val(LCPaymentTerm);
		
	});
	 $('body').off('change', '#bankChargesId').on('change', '#bankChargesId', function(e) {
		 e.stopPropagation();
		var bankChargesType=$('#bankChargesId :selected').text();
		$('#bankChargesType').val(bankChargesType);
		
	});
	 
	dlocUSDShow();
	$('body').off('change', '#docLCAmt').on('change', '#docLCAmt', function(e) {
		e.stopPropagation();
		dlocUSDShow();
	});
	
	$('body').off('change', '.estimatedMonths').on('change', '.estimatedMonths', function(e) {
		e.stopPropagation();
		if($(e.target).val() != undefined && $(e.target).val() != ''){
			var issueDate = new Date($('#paymentScheduleIssueDate').val());
			var monthsToAdd = parseInt($(e.target).val());
			issueDate.setMonth(issueDate.getMonth()+monthsToAdd);
			var estPayDate = issueDate.toDateString().split(' ')[2] + ' '+issueDate.toDateString().split(' ')[1] + ' '+issueDate.toDateString().split(' ')[3];
			$(e.target).closest('td').next().find('.date').val(estPayDate);
		}
	});
	 
	/*
	* Adds Payment schedule
	*/
	 $('body').off('click', '.add-paymentSchedule').on('click', '.add-paymentSchedule', function(e) {
		 e.stopPropagation();
		 
		var showIndex = parseInt($('#showIndex').val());
		var newAdditionalPaymentsIndex = parseInt($('#newAdditionalPaymentsIndex').val());
		$("table#paymentSchedule").children('tbody').children("tr:last").after('<tr class="additionalPaymentsRow newAdditionalPayments"></tr>');
		var url = contextURL+'/int/addPayment.action' + '?newAdditionalPaymentsIndex=' + newAdditionalPaymentsIndex ;
		$('.newAdditionalPayments').load(url).removeClass('newAdditionalPayments');				
		$('#newAdditionalPaymentsIndex').val(newAdditionalPaymentsIndex + 1);
		$('#showIndex').val(showIndex + 1);	
		if($('#showIndex').val() >= 10 && $('#showIndex').val() !=""){
			$('#addPayment').hide();
		}
		
	});

	/*
	* Deletes Payment Schedule
	*/
	 $('body').off('click', '.delete-paymentSchedules').on('click', '.delete-paymentSchedules', function(e) {
		 e.stopPropagation();
		
			var showIndex = parseInt($('#showIndex').val());
			$('#showIndex').val(showIndex - 1);
			if($('#showIndex').val() < 10 && $('#showIndex').val() !=""){
				$('#addPayment').show();
			}
			var paymentRow = $(e.currentTarget).parent().parent();
			$(paymentRow).find('.paymentOpcode').val('DELETE');
			$(paymentRow).addClass('deleted');
			$(paymentRow).hide();
		
	});

	if(!$('#dloc-draft').attr('handlerDraft')) {
		 $("#dloc-draft").off('click').on('click', function(e){
			hideSubmitSectionDropdown();
			$('#actionTypeId').val("1");
			$('form#dlocReviewAndSubmitForm').submit();
		});
		$('#dloc-draft').attr('handlerDraft', true);
		}
		
		$("#dloc-prepare").off('click').on('click', function(e){
			e.stopPropagation();
			var leftPosVal = $(this).position().left;
			var dropDownDiv = $(this).attr('data-dropdown');
			if(!$(this).hasClass('dropdown-open')){
				$(this).addClass('secondary').addClass('dropdown-open');
				$(dropDownDiv).show();
				$(dropDownDiv).css({'left': leftPosVal+5});
			}else{
				$(this).removeClass("secondary").removeClass('dropdown-open');
				$(dropDownDiv).hide();
			}
		});
		
		if(!$('#dloc-submit').attr('handlerSubmit')) {
			$("#dloc-submit").off('click').on('click', function(e){
				hideSubmitSectionDropdown();
				$('#actionTypeId').val("2");
				$('form#dlocReviewAndSubmitForm').submit(); 
			});
			$('#dloc-submit').attr('handlerSubmit', true);
		}
		
		$('form#dlocReviewAndSubmitForm').submit(function() {
			return true;
		});
		
		if(!$('#ready-for-bid').attr('handlerRegistered')) {
			$('#ready-for-bid').on('click', function() {						
				$(this).addClass('tabactive');
				$('#actionTypeId').val("4");
				$('form#tranalystSubmitForm').submit();
			});
			$('#ready-for-bid').attr('handlerRegistered', true);
		}
		
		if(!$('#dloc-send-back').attr('handlerRegistered')) {
			$('#dloc-send-back').on('click', function() {						
				$(this).addClass('tabactive');
				$('#actionTypeId').val("3");
				$('form#tranalystSubmitForm').submit();
			});
			$('#dloc-send-back').attr('handlerRegistered', true);
		}
		
	//DLOC related script end		

});
//DLOC realted functions start
function dlocUSDShow(){
	var ccyCode = $('#currenciesCd').val();
	if(ccyCode!="" && ccyCode!=undefined){
		if(ccyCode=="USD"){
			$('#usdEquivalentDiv').hide();
		}else{
			$('#usdEquivalentDiv').show();
		}
	}
}

function hideSubmitSectionDropdown(){
	$('.bottombtn').each(function(){
		$(this).removeClass("secondary").removeClass('dropdown-open');
		var dropDownDiv = $(this).attr('data-dropdown');
		$(dropDownDiv).hide();
	});
}

function showHideBank() {
	if($('#bankSelectionId').val() != undefined && $('#bankSelectionId').val() == 'New'){
		$('#BankDetailsShowManually').show();
	}
}

function showHideApplicantAddress() {
	if($('#applicantSelectionId').val() != undefined && $('#applicantSelectionId').val() == 'New'){
		$('#ApplicantShowManually').show();
	}
}

function showHideIssuingBankAddress() {
	if($('#issuingBankSelectionId').val() != undefined && $('#issuingBankSelectionId').val() == 'New'){
		$('#BankDetailsShowManually').show();
	}
}

function showHideBeneficaryAddress() {
	if($('#beneficiaryAddressSelectionID').val() != undefined && $('#beneficiaryAddressSelectionID').val() == 'New'){
		$('#BeneficiaryShowManually').show();
	}
}


function checkOther(){
	if($("#lcPaymentTermsID").val() == 3){
		$("#other").show();
		makeMandatory('#othPaymentDesc');
	}else{
		removeMandatory('#othPaymentDesc');
		$("#other").hide();
	}
}

function instTrasactionOriginGoods(){
	if($("#originOfGoodsCd").val()=="US" || $("#originOfGoodsCd1").val()=="US" || $("#originOfGoodsCd2").val()=="US"){
		   $("#usPercentID").show();
	  }else{
		   $("#usPercentID").hide();
	  }
}

function lcPaymentTermsSelect(){
	var lcPaymentTermsSelect  = $('#lcPaymentTermsID').val();
	 if(lcPaymentTermsSelect != undefined && lcPaymentTermsSelect !=''){
		 checkOther();
	 }
	
}
function bcpSiteSelect(){
	var selectedSiteId =$('#selectedSite').val();
	$('#selectedSiteId').val(selectedSiteId);
}

function getAutocompleterNameAndUS(){
	$.subscribe('getAutocompleterNameAndUS', function(event,data) {
		 var ui = event.originalEvent.ui;
			var codeTextField = $("#"+data.id).closest('td').children("input:first").attr("id");
			var textField = $("#"+data.id).closest('td').find(".autoCompleterName").attr("id");
			var text;
			if(ui.item != undefined && ui.item != null){
				text = ui.item.value;
			}else{
				text = '';
				$('#'+codeTextField).val($.trim(text));
			}			
			$('#'+textField).val($.trim(text));			
			
			if($("#originOfGoodsCd").val()=="US" || $("#originOfGoodsCd1").val()=="US" || $("#originOfGoodsCd2").val()=="US"){				
		  		   $("#usPercentID").show();
		  		   makeMandatory('#usPercentID');
		  	   }else{	
		  		   $("#usPercentID").hide();
		  		   removeMandatory('#usPercentID');
		  	   } 
			event.stopPropagation();
	});
	
}

//DLOC realted functions end
