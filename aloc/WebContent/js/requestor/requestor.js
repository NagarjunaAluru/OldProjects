/*
 * rich text editor plugin code
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
jQuery(function($){

	tabs = function(options) {
		
		var defaults = {  
			selector: '.tabs',
			selectedClass: 'selected'
		};  
		
		if(typeof options == 'string') defaults.selector = options;
		var options = $.extend(defaults, options); 
	
		return $(options.selector).each(function(){
									
			var obj = this;	
			var targets = Array();
	
			function show(i){
				$.each(targets,function(index,value){
					$(value).hide();
				})
				$(targets[i]).fadeIn('fast');
				$(obj).children().removeClass(options.selectedClass);
				selected = $(obj).children().get(i);
				$(selected).addClass(options.selectedClass);
			};
	
			$('a',this).each(function(i){	
				targets.push($(this).attr('href'));
				$(this).click(function(e){
					e.preventDefault();
					show(i);
				});
			});
			
			show();
	
		});			
	}
	// initialize the function
	// as a parameter we are sending a selector. For this particular script we must select the unordered (or ordered) list item element 
	tabs('nav ul');

});


$(document).ready(function() {
	
				//////////////////////
				// on window scroll fire it will call a function.
				/*$(window).scroll(function() {
					// after window scroll fire it will add define pixel
					// added to that element.
					set = $(document).scrollTop() + "px";
					// this is the jQuery animate function to fixed the div
					// position after scrolling.
					$('#floatDiv').animate({
						top : set
					}, {
						duration : 100,
						queue : false
					});
				});*/
				
	$(window).scroll(showDiv);
	showDiv();

	decCounter("projDesc", 400);
	decCounter("specialInst", 400);
	decCounter("complyCtrRqmt", 200);
	decCounter("projectDescription", 50);	
	decCounter("specialInstructions", 400);
	decCounter("projectDescId", 300);
	decCounter("splInstructions", 300);
	decCounter("declineReason", 400);
	decCounter("copyAndPasteId", 10000);
	decCounter("tdcomments", 400);
	decCounter("bidMemoComments", 300);
	decCounter("textFormatId", 10000);
	decCounter("amdotherChanges",300);
	decCounter("exactProjDesc",300);
	decCounter("otherInfo",300);
	
	jQuery('#transactionPartiesForm').preventDoubleSubmit();
	jQuery('#suretyBondDetailsForm').preventDoubleSubmit();
	jQuery('#businessContactPersonForm').preventDoubleSubmit();
	
	jQuery('#bondDetailsForm').preventDoubleSubmit();
	jQuery('#suretyBondForm').preventDoubleSubmit();
	jQuery('#bgSblcForm').preventDoubleSubmit();
	jQuery('#reviewAndSubmitFormID').preventDoubleSubmit();
	jQuery('#reRequestFormId').preventDoubleSubmit();
	jQuery('#dlocForm').preventDoubleSubmit();
	jQuery('#dlocReviewAndSubmitForm').preventDoubleSubmit();
	//for all Instruments
	jQuery('#approverSubmitForm').preventDoubleSubmit();
	jQuery('#trAnalystSubmitForm').preventDoubleSubmit();
	jQuery('#tranalystSubmitForm').preventDoubleSubmit();

	//for rider
	jQuery('#suretyRiderFormId').preventDoubleSubmit();
	//for Amendment
	jQuery('#submitAmendmentFormID').preventDoubleSubmit();
	jQuery('#submitAutoAmendmentFormID').preventDoubleSubmit();
	
	
	var taxonomyViewType = $('#taxonomyViewType').val();
	if(taxonomyViewType != undefined && taxonomyViewType == 'UPDATEDATA'){
	}else{
		deliveryTypeOnloadShow(); // delivery Instructions
	}
	sendbackOnloadShow(); // send back Treasury analyst for all req

	$("a.navLink").click(function(e){
		e.stopPropagation();
		var a = "div"+$(this).attr("href");
		$(a).css("filter","alpha(opacity=100)");
	});
	
	$("a.selectWinner").click(function(e){
		e.stopPropagation();
		$('#selectWinner').modal({show: 'true'}).css("margin-top","-82px;"); 
	});
	$("a.clearEntries").click(function(e){
		e.stopPropagation();
		hideSubmitSectionDropdown();
		$('#clearEntries').modal({show: 'true'}).css("margin-top","-82px;");
		
	});
	
	$('body').off('click', 'a.lookupAction').on('click', 'a.lookupAction', function(e) {
		e.preventDefault();
		e.stopImmediatePropagation();
		var url = $(e.target).attr('href');
		$('#searchIndicator').show();
		$.ajax({
			type: "POST",
			url: url,
			dataType: 'html',
			data: $("#searchActionForm").serialize(),// serializes the form's elements.
			success: function(response){
				$('#fullHistoryDiv').empty().html(response);
				$('#searchIndicator').hide();
				$('#mainPage').hide();
				$('#fullHistoryDiv').show();
				$(window).scrollTop(0);
			},
			 error: function (xhr, textStatus, errorThrown ) {
					$('#searchIndicator').hide();
					var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
					$(".searchError").find('div.errorContent').html(errorReason);
					$(".searchError").show().focus();
			    }
		});
	});
	
	$('body').off('click', 'a.fullScreen').on('click', 'a.fullScreen', function(e) {
		  e.preventDefault();
	      e.stopImmediatePropagation();
	      var url = $(e.target).attr('href');
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
	
	$('body').off('click', 'a.closeFullScreen').on('click', 'a.closeFullScreen', function(e) {
		e.stopPropagation();
		  $('#mainPage').show();
		  $('#fullHistoryDiv').hide();
		  $('#showFullAuditProcess').hide();
		  $('#showFullActionProcess').hide();
		});
	 
	loadBeforeTracking();
	loadRequireEditTracking();
	$("a#nav-approve").click(function(e){
		e.stopPropagation();
		 $(this).addClass('tabactive');
		 $('#li1').addClass('liactive');
		 $('#li2').removeClass('liactive');
		 $("#nav-reject").removeClass('tabactive');
	});
	
	$("a#nav-reject").click(function(e){
		e.stopPropagation();
		$(".approversErrorDiv").hide();
		 $(this).addClass('tabactive');
		 $('#li2').addClass('liactive');
		 $('#li1').removeClass('liactive');
		 $("#nav-approve").removeClass('tabactive');
		
	});
	
	$("#nav-reSave").click(function(e){
		e.stopPropagation();
		$(this).addClass('tabactive');
		$('#li2').removeClass('liactive');
		$("#nav-reSubmit").removeClass('tabactive');
		$('#actionTypeId').val("1");
		$('form#reRequestFormId').submit();
	});
	
	$("a#nav-reSubmit").click(function(e){
		e.stopPropagation();
		$(".approversErrorDiv").hide();
		 $(this).addClass('tabactive');
		 $('#li2').addClass('liactive');
		 $('#li1').removeClass('liactive');
		 $("#nav-reSave").removeClass('tabactive');
		 	getApprovers();
	});	
	
	$("#nav-prepare").off('click').on('click', function(e){
		e.stopPropagation();
		$(".approversErrorDiv").hide();
		hideSubmitSectionDropdown();
		var leftPosVal = $(this).position().left;
		var dropDownDiv = $(this).attr('data-dropdown');
		if(!$(this).hasClass('dropdown-open')){
			$(this).addClass('secondary').addClass('dropdown-open');
			$(dropDownDiv).show();
			$(dropDownDiv).css({'left': leftPosVal+5});
			$('.tabDelegation').empty().append("");
			$(dropDownDiv).find(".tabDelegation").load(contextURL+'/int/requestor/review/buDelegation.action?', function(){
				getApprovers();
				var selectedApproverFlag = $("#selectedApproverFlag").val();
				if(selectedApproverFlag == undefined || selectedApproverFlag == "") {
					$('#tBusinessApprovalFlag_Y').removeAttr("checked");
					$('#tBusinessApprovalFlag_N').removeAttr("checked");
				}else {
					if(selectedApproverFlag == 'Y') {
						$('#businessDelegationDiv').show();
					}
				}
		   });
		}else{
			$(this).removeClass("secondary").removeClass('dropdown-open');
			$(dropDownDiv).hide();
		}
	});
	
	$("#nav-submit").off('click').on('click', function(e){
		e.stopPropagation();
		$(".approversErrorDiv").hide();
		hideSubmitSectionDropdown();
		var leftPosVal = $(this).position().left;
		var dropDownDiv = $(this).attr('data-dropdown');
		$("#saveAsModel").attr("checked", false);
		if(!$(this).hasClass('dropdown-open')){
			$(this).addClass('secondary').addClass('dropdown-open');
			$(dropDownDiv).show();
			$(dropDownDiv).css({'left': leftPosVal+5});
			$('#modelNameId').empty().append("");
			$('#SaveAsModelShow').load(contextURL+'/int/requestor/review/modelName.action');
			$("#modelName").val("");
			$('#SaveAsModelShow').hide();
			$('.tabDelegation').empty().append("");
			$(dropDownDiv).find(".tabDelegation").load(contextURL+'/int/requestor/review/buDelegation.action?', function(){
				getApprovers();
				var selectedApproverFlag = $("#selectedApproverFlag").val();
				if(selectedApproverFlag == undefined || selectedApproverFlag == "") {
					$('#tBusinessApprovalFlag_Y').removeAttr("checked");
					$('#tBusinessApprovalFlag_N').removeAttr("checked");
				}else {
					if(selectedApproverFlag == 'Y') {
						$('#businessDelegationDiv').show();
					}
				}
		   });
		}else{
			$(this).removeClass("secondary").removeClass('dropdown-open');
			$(dropDownDiv).hide();
		}
	});
	
	$('body').off('click', '#tBusinessApprovalFlag_Y').on('click', '#tBusinessApprovalFlag_Y', function(e){
			$('#businessDelegationDiv').show();
	});
	
	$('body').off('click', '#tBusinessApprovalFlag_N').on('click', '#tBusinessApprovalFlag_N', function(e){
		$('#businessDelegationDiv').hide();
	});
	
	$("#nav-model").off('click').on('click', function(e){
		e.stopPropagation();
		hideSubmitSectionDropdown();
		var leftPosVal = $(this).position().left;
		var dropDownDiv = $(this).attr('data-dropdown');
		$("#saveAsModel").attr("checked", false);
		if(!$(this).hasClass('dropdown-open')){
			$(this).addClass('secondary').addClass('dropdown-open');
			$(dropDownDiv).show();
			$(dropDownDiv).css({'left': leftPosVal+5});
			$('#SaveAsModelShow').empty().append("");
			$(dropDownDiv).find('#modelNameId').load(contextURL+'/int/requestor/review/modelName.action');
			$('.tabDelegation').empty().append("");
			$(dropDownDiv).find('#modelName').val("");
		}else{
			$(this).removeClass("secondary").removeClass('dropdown-open');
			$(dropDownDiv).hide();
		}
		$(".approversErrorDiv").hide();
	});
	
	
	getAutocompleterName();
	getCurrencyAutocompleterName();
	getInstrumentUSDConversion();
	multipleTabsProblemHandle();
	getUSDConversion();
	getBondInfoUSDConversion();
	showHideIbsMessage(); // principal details
	$('#delegate').click(function(e){
		e.stopPropagation();
		   $('#SMA').show();
		   $('#deleg').hide();
	});
	$('#bdelegate').click(function(e){
		e.stopPropagation();
		   $('#SMA').hide();
		   $('#deleg').show();
	});
	$('#delSave').click(function(e){
		e.stopPropagation();
		   $('#SMA').hide();
		   $('#deleg').hide();
	});
	
	$('#approve').click(function(e){
		e.stopPropagation();
		   $('#rejectComment').hide();
	});
	
	$('#reject').click(function(e){
		e.stopPropagation();
		$('#rejectComment').show();
		 
	});

	$('body').off('click', 'a.lookup').on('click', 'a.lookup', function(e){
    	e.preventDefault();
    	e.stopImmediatePropagation();
    	var scrollTopValue = $(e.target).closest(".row").offset().top;
  		var url = $(e.target).attr('href');
  		var lookupError = $(e.target).siblings(".lookup-error");
  		if(lookupError == undefined || $(e.target).siblings(".lookup-error").length == 0){
  			lookupError = $(e.target).closest('div.row').find(".lookup-error");
  		}
  		$(lookupError).empty().addClass("hide").removeClass("show");
  		var dataValue = $(e.target).siblings(".lookup-filterValue").val();  		
  		var bankCountryCd  = $(e.target).siblings(".bankCountryCode").val();
  		var bankCountryName = '';
  		var nameAddressLookupValue = $(e.target).siblings(".nameAddressClass").val();
  		var bankCity  = $(e.target).siblings(".bankCityName").val();
  		var userDataLookup = $(e.target).siblings('.businessContactClass').val();
  		var bucFirstName = '';
  		var bucLastName = '';
  		if(dataValue == undefined && $(e.target).siblings(".lookup-filterValue").length == 0){
  			dataValue = $(e.target).closest('.form-row').find('.lookup-filterValue').val();
  			lookupField = $(e.target).closest('.form-row').find('.lookup-filterValue');
  			userDataLookup = $(e.target).closest('.form-row').find('.businessContactClass').val();
  			nameAddressLookupValue =  $(e.target).closest('.form-row').find('.nameAddressClass').val();
  		}
  		if(bankCountryCd == undefined && $(e.target).siblings(".bankCountryCode").length == 0){
  			bankCountryCd = $(e.target).closest('.form-row').find('.bankCountryCode').val();
  			bankCountryName = $(e.target).closest('.form-row').find('#bankCountryNameId').val();
  			bankCountryCodeField = $(e.target).closest('.form-row').find('.bankCountryCode');
  			bankCountryNameField = $(e.target).closest('.form-row').find('#bankCountryNameId');
  		}
  		
  		if(bankCountryCd == undefined && $(e.target).closest('.form-row').find('.bankCountryCode').length == 0){
  			bankCountryCd = $(e.target).closest('.form-row').find('.bankDetailCountryCode').val();
  			bankCountryName = $(e.target).closest('.form-row').find('#bankDetailCountryNameId').val();
  		}
  		
  		if(bankCity == undefined && $(e.target).siblings(".bankCityName").length == 0){
  			bankCity = $(e.target).closest('.form-row').find('.bankCityName').val();
  			bankCityField = $(e.target).closest('.form-row').find('.bankCityName');
  		}
  		if($.trim(dataValue) != '' && bankCountryCd != '' && ($.trim(bankCity) != '' || bankCity == undefined)){
  			if(userDataLookup != undefined && userDataLookup != '' && userDataLookup == 'BUC') {
  				if(dataValue.indexOf(",") == -1)	{
  					if(dataValue.length < 7 )	{
  						$(lookupError).text("Please provide SSO(at least 7 digits) / LastName , FirstName (at least 2 characters each )").removeClass("hide").addClass("show");
  			  			return false;
  					}}
  				else {
  					var dataValueArray = dataValue.split(",");
  					if(dataValueArray.length == 2)	{
  						var nameLengthCheck = false;
  						$.each(dataValueArray, function(index, name) {
  							var nameTrim = $.trim(name);
  							if(nameTrim == '' || (nameTrim != '' && nameTrim.length < 2))	{
  								nameLengthCheck = true;
  							}
  						});
  						if(nameLengthCheck == true) {
  							$(lookupError).text("Please provide SSO(at least 7 digits) / LastName , FirstName (at least 2 characters each )").removeClass("hide").addClass("show");
  							return false;
  						}else {
  							bucLastName = dataValueArray[0];
  							bucFirstName = dataValueArray[1];
  						}} else {
  						$(lookupError).text("Please provide SSO(at least 7 digits) / LastName , FirstName (at least 2 characters each )").removeClass("hide").addClass("show");
	  			  		return false;
  					}}}
  			if(nameAddressLookupValue != undefined && nameAddressLookupValue != '' && nameAddressLookupValue == 'yes'){
  				if($.trim(dataValue).length < 5){
  					$(lookupError).text("Please enter at least 5 characters for Lookup Search").removeClass("hide").addClass("show");
	  			  		return false;
  				}
  			}
  			var indicator = $(e.target).siblings(".indicator");
  			if(indicator == undefined || $(e.target).siblings(".indicator").length == 0){
  				indicator = $(e.target).closest('div.row').find(".indicator");
  			}
  			$(indicator).show();
  			$.ajax({
  				type: "POST",
  				url: url,
  				dataType: 'html',
  				data: {filterValue : $.trim(dataValue), bankCountryCd : bankCountryCd, bankCountry : bankCountryName, bankCity : $.trim(bankCity), scrollTopValue:scrollTopValue, 
  					    bucFirstName : bucFirstName, bucLastName : bucLastName},
  				success: function(response){
  					$('#lookupDiv').empty().append(response);
  					$(indicator).hide();
  				},
  				complete : function(jqXHR, status){
  					if(status == "success"){
  						$('#mainPage').hide();
  						$('#lookupDiv').show();
  						$(window).scrollTop(0);
  					}else{
  						$(indicator).hide();
  					}
  				},error: function (xhr, textStatus, errorThrown ) {
  					var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
  					$(lookupError).text(errorReason).removeClass("hide").addClass("show");
  		  			return false;
  				}
  			});
  		}else{
  			$(lookupError).text("Please enter values for Lookup Search").removeClass("hide").addClass("show");
  			return false;
  		}
  		return false;
     });
	/*- Previous Next LE Pagination -*/
	$('#pageDivID').off('click', 'a').on('click', 'a', function(event) {
    //$('#pageDivID').delegate('a','click',function(event) {
		event.stopPropagation();
		event.preventDefault();
		var url = $(this).attr('href');
		var indicator = $(this).siblings(".indicator");
		$(indicator).show();
		$.ajax({
			type: "POST",
			url: url,
			dataType: 'html',
			success: function(response){
				$(indicator).hide();
				$('#mainPage').hide();
				$('#lookupDiv').empty().append(response);
				$('#lookupDiv').show();
			}
		});
	});
    
    $('body').off("change",'#instrumentAmt').on("change",'#instrumentAmt',function(e){
    	e.stopPropagation();
		var targetId = $(e.target).closest('.row').next().next().find('p').attr('id');
		var currCodeid = $(e.target).closest('.row').prev().find('input[type=hidden]').attr('id');
		var currCode=$("#"+currCodeid).val();
		var originalCCYAmount= $(e.target).val();
		var targetControl = $(e.target).closest('.row').next().next().find('input[type=hidden]').attr('id');
		$(".instUsdEquivalentErrorDiv").hide();
		if(currCode!="" && originalCCYAmount!=""){
			if(currCode!=undefined && originalCCYAmount!=undefined){
				if(currCode!="USD"){
					$('#approximateUSDDiv').show();
					$('#instUsdProcess').show();
					var instrumentdata = {currCode: currCode,originalCCYAmount: originalCCYAmount};
					var url = contextURL +"/int/USDEquivalentRefData.action";
					$.ajax({
						type: "POST",
						url: url,
						dataType: 'json',
						data: instrumentdata,
						success: function(data){
						$("#"+targetId).find('span').text(data.data);
						$('#'+targetControl).val(data.data);
						bidValuepercent(data.data);
						$('#instUsdProcess').hide();
						},
						error: function (xhr, textStatus, errorThrown ) {
							var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
							$(".instUsdEquivalentErrorDiv").show();
							$(".instUsdEquivalentErrorDiv").find('div.errorContent').html(errorReason);
							$('#instUsdProcess').hide();
							$('#approximateUSDDiv').hide();
							$('#instUsdProcess').hide();
							$("#"+targetId).find('span').text("");
							$('#'+targetControl).val("");
							bidValuepercent("");
						}
					
						});
					
				}else{
					$('#approximateUSDDiv').hide();
					$("#"+targetId).find('span').text(originalCCYAmount);
					$('#'+targetControl).val(originalCCYAmount);
					bidValuepercent(originalCCYAmount);
				}
				amountTowords();
			}
		}
		
	});
	
    $('body').off("change",'.currencyAmt').on("change",'.currencyAmt',function(e){
    	e.stopPropagation();
		var targetId = $(e.target).closest('.row').next().find('p').attr('id');
		var currCodeid = $(e.target).closest('.row').prev().find('input[type=hidden]').attr('id');
		var imageId = $(e.target).closest('.row').next().find('img').attr('id');
		var currCode=$("#"+currCodeid).val();
		var originalCCYAmount= $(e.target).val();
		var targetControl = $(e.target).closest('.row').next().find('input[type=hidden]').attr('id');
		$(".usdEquivalentErrorDiv").hide();
		if(currCode!="" && originalCCYAmount!=""){
			if(currCode!=undefined && originalCCYAmount!=undefined){
				if(currCode!="USD"){
					var data = {currCode: currCode,originalCCYAmount: originalCCYAmount};
					usdConversion(data,targetId,targetControl,imageId);
				}else{
					$("#"+targetId).find('span').text(originalCCYAmount);
					$('#'+targetControl).val(originalCCYAmount);
					if($('#instrumentUSDAmt').val()!=undefined && $('#instrumentUSDAmt').val()!=""){
					bidValuepercent($('#instrumentUSDAmt').val());
					}
				}
					
			}
			
		}
	
	});
	
	approximateUSDShow();	
	var validationSuccess = $('#validationSuccessId').val();
	var serviceErrorMsg = $('#serviceErrorMsgId').val();
	if(validationSuccess!=undefined && validationSuccess == 'false'){
		$('#pageLevelErrorDivId').show();
	}
	var errorMsgShow = $('#errorMsgShowId').val();
	if(errorMsgShow!=undefined && errorMsgShow == 'true'){
		$('#pageLevelErrorDivId').show();
		var actionId= $('#actionTypeId').val();
		if(actionId=='4'){
			$('#nav-approve').addClass('tabactive');
			 $('#li1').addClass('liactive');
			 $('#li2').removeClass('liactive');
		     $("#nav-reject").removeClass('tabactive');
			 $('#tab1').show();
			 getDelegationApprovers();			
		}
		if(actionId=='5'){
			$('#nav-reject').addClass('tabactive');
			 $('#li2').addClass('liactive');
			 $('#li1').removeClass('liactive');
		     $("#nav-approve").removeClass('tabactive');
			 $('#tab2').show();		
		}
	}
	var amendmentvalidationId= $('#amendmentvalidationId').val();
	if(amendmentvalidationId!=undefined && amendmentvalidationId == 'false'){
		$("#nav-submitAmendment").addClass('tabactive');
		   $('#li24').addClass('liactive');
		   $('#li25').removeClass('liactive');
		   $("#nav-saveasDraftAmend").removeClass('tabactive');
			$('#tab24').show();
		   var approverAmount = $('#revisedUSDEquiAmt').val();
		   if(approverAmount !="" && approverAmount != undefined){
			   approverAmount= approverAmount.replace(/,/g,"");
			   $('#submitProcess').show();
			   getDelegationApproversOnSubmit(approverAmount);
		   }
		   if($('#arBusinessApprovalFlag_Y').is(':checked')) {
				$('#tab2DelegationID').show();
			}
	}
	
	if((validationSuccess!=undefined && validationSuccess == 'false') || (serviceErrorMsg != undefined && serviceErrorMsg != '')){
		var actionId= $('#actionTypeId').val();
		if(actionId=='1'){
			 hideSubmitSectionDropdown();
				var leftPosVal = $('#nav-prepare').position().left;
				var dropDownDiv = $('#nav-prepare').attr('data-dropdown');
				if(!$('#nav-prepare').hasClass('dropdown-open')){
					$('#nav-prepare').addClass('secondary').addClass('dropdown-open');
					$(dropDownDiv).show();
					$(dropDownDiv).css({'left': leftPosVal+5});
						getApprovers();
				}else{
					$('#nav-prepare').removeClass("secondary").removeClass('dropdown-open');
					$(dropDownDiv).hide();
				}
				
				if($('#tBusinessApprovalFlag_Y').is(':checked')) {
					$('#businessDelegationDiv').show();
				}
		}
		if(actionId=='2'){
			hideSubmitSectionDropdown();
			var leftPosVal = $("#nav-submit").position().left;
			var dropDownDiv = $("#nav-submit").attr('data-dropdown');
			if(!$("#nav-submit").hasClass('dropdown-open')){
				$("#nav-submit").addClass('secondary').addClass('dropdown-open');
				$(dropDownDiv).show();
				$(dropDownDiv).css({'left': leftPosVal+5});
				$(dropDownDiv).find('#modelNameId').empty().append("");
				if($('#saveasmodelId').val()!=undefined && $('#saveasmodelId').val()!='' && $('#saveasmodelId').val()=='SAVE'){
					$("#saveAsModel").attr("checked", "checked");
					 $('#SaveAsModelShow').show('fast');
				}else{
					$('#SaveAsModelShow').addClass('hide');
				}
					getApprovers();
			}else{
				$("#nav-submit").removeClass("secondary").removeClass('dropdown-open');
				$(dropDownDiv).hide();
			}
			
			if($('#tBusinessApprovalFlag_Y').is(':checked')) {
				$('#businessDelegationDiv').show();
			}
		}
		if(actionId=='7'){
			hideSubmitSectionDropdown();
			var leftPosVal = $("#nav-model").position().left;
			var dropDownDiv = $("#nav-model").attr('data-dropdown');
			if(!$("#nav-model").hasClass('dropdown-open')){
				$("#nav-model").addClass('secondary').addClass('dropdown-open');
				$(dropDownDiv).show();
				$(dropDownDiv).css({'left': leftPosVal+5});
				$(dropDownDiv).find('#SaveAsModelShow').empty().append("");
				$('.tabDelegation').empty().append("");
			}else{
				$("#nav-model").removeClass("secondary").removeClass('dropdown-open');
				$(dropDownDiv).hide();
			}
			
		}
		
	}
	
	var riderMsgShow = $('#riderMsgShowId').val();
	if(riderMsgShow!=undefined && riderMsgShow == 'true'){
		$('#pageLevelRiderErrorDivId').show();
		var actionId= $('#actionTypeId').val();
		if(actionId=='4'){
			$('#nav-riderApprove').addClass('tabactive');
		     $("#nav-riderReturnToBusiness").removeClass('tabactive');
		     $("#nav-ridersave").removeClass('tabactive');
		     $("#nav-deleteRider").removeClass('tabactive');
		     $('#li1').addClass('liactive');
			 $('#li2').removeClass('liactive');
			 $('#li3').removeClass('liactive');
			 $('#li4').removeClass('liactive');
			 $('#tab1').show();
			 riderTreasuryAnalystApprovers();		
		}
		if(actionId=='3'){
			 $("#nav-riderReturnToBusiness").addClass('tabactive');
			 $('#nav-riderApprove').removeClass('tabactive');
		     $("#nav-ridersave").removeClass('tabactive');
		     $("#nav-deleteRider").removeClass('tabactive');
		     $('#li2').addClass('liactive');
			 $('#li1').removeClass('liactive');
			 $('#li3').removeClass('liactive');
			 $('#li4').removeClass('liactive');
			 $('#tab2').show();		
		}
	}
	
	var analystErrorShow = $('#analystErrorShowId').val();
	if(analystErrorShow!=undefined && analystErrorShow == 'true'){
		$('#analystPageErrorDivId').show();
		$('#readySystemCheckSection').hide();
		$("#submitDiv").removeClass('hide');		
		var actionId= $('#actionTypeId').val();
		if(actionId=='4'){
			 $("#tr-nav-sendBack").parent('li').hide();
			 $("#tr-nav-approve").parent('li').show();
			$('#tr-nav-approve').addClass('tabactive');
		     $("#tr-nav-sendBack").removeClass('tabactive');
		     $('#li7').addClass('liactive');
			 $('#li8').removeClass('liactive');
			 $('#tab2').show();
			 getDelegationApprovers();			
		}
		if(actionId=='3'){	
			 $("#tr-nav-approve").parent('li').hide();
			 $("#tr-nav-sendBack").parent('li').show();
		     $("#tr-nav-sendBack").addClass('tabactive');
		     $('#tr-nav-approve').removeClass('tabactive');
		     $('#li8').addClass('liactive');
			 $('#li7').removeClass('liactive');
			 $('#tab3').show();	
		}
	}
	
	var validationReSubmitId= $('#validationReSubmitId').val();
	if(validationReSubmitId!=undefined && validationReSubmitId == 'false'){	
		$('#pageLevelErrorDivId').show();	
		 $("#nav-reSubmit").addClass('tabactive');
		 $('#li2').addClass('liactive');
			getDelegationApprovers();
			$('#tab2').show();			
	}
	
	var autoAmendmentvalidationId= $('#autoAmendmentvalidationId').val();
	if(autoAmendmentvalidationId!=undefined && autoAmendmentvalidationId == 'false'){
		$('#pageLevelErrorDivId').show();
	}
	
	var amdErrorMsgShowId = $('#amdErrorMsgShowId').val();
	if(amdErrorMsgShowId!=undefined && amdErrorMsgShowId == 'true'){
		$('#pageLevelErrorDivId').show();
		var actionId= $('#actionTypeId').val();
		if(actionId=='4'){
			$('#nav-approve').addClass('tabactive');
			 $('#li1').addClass('liactive');
			 $('#li2').removeClass('liactive');
		     $("#nav-reject").removeClass('tabactive');
			 $('#tab1').show();
			 getApprovers();			
		}
		if(actionId=='5'){
			$('#nav-reject').addClass('tabactive');
			 $('#li2').addClass('liactive');
			 $('#li1').removeClass('liactive');
		     $("#nav-approve").removeClass('tabactive');
			 $('#tab2').show();		
		}
	}
	
	var validationRiderId= $('#validationRiderId').val();
	if(validationRiderId!=undefined && validationRiderId == 'false'){	
		$('#pageLevelErrorDivId').show();	
		 $("#nav-submitRider").addClass('tabactive');
		 $('#li22').addClass('liactive');
			getDelegationApprovers();
			$('#tab24').show();
			 if($('#arBusinessApprovalFlag_Y').is(':checked')) {
					$('#tab2DelegationID').show();
				}
	}
	
	var suretyRiderId= $('#suretyRiderId').val();
	if(suretyRiderId!=undefined && suretyRiderId == 'false'){
		var approverAmount;
		var isContractBond = $('#contractBondID').val();
		$("#nav-submitRider").addClass('tabactive');
		$('#li22').addClass('liactive');
		$('#li23').removeClass('liactive');
		if(isContractBond == "true"){
			approverAmount = $('#revisedUSDEquiContractAmtId').val();
		}else{
			approverAmount = $('#revisedBondAmt').val();
		}
		if(approverAmount !="" && approverAmount != undefined){
			$('#submitProcess').show();
			getDelegationApproversOnSubmit(approverAmount);
		}
	}
	
	$('body').off('click', '#arBusinessApprovalFlag_Y').on('click', '#arBusinessApprovalFlag_Y', function(e){
		$('#tab2DelegationID').show();
	});

	$('body').off('click', '#arBusinessApprovalFlag_N').on('click', '#arBusinessApprovalFlag_N', function(e){
		$('#tab2DelegationID').hide();
	});

	$('body').off("change",'#accDistNoId ,#bussUnitCodeId').on("change",'#accDistNoId ,#bussUnitCodeId',function(e){
		e.stopPropagation();
		var url = contextURL+"/int/BUCADNLookup.action";
		var bucValue = $('#bussUnitCodeId').val();
		bucValue = $.trim(bucValue);
		$('#bussUnitCodeId').val(bucValue);
		var adnValue = $('#accDistNoId').val();
	     adnValue = $.trim(adnValue);
		$('#accDistNoId').val(adnValue);
		var formData = {
			bucValue : bucValue,
			adnValue : adnValue
		};
		if(bucValue != undefined && bucValue != '' && adnValue != undefined && adnValue != ''){
			$('#bucadnLoading').show();
			callBUCADNValidation(url,formData);
		}
	});
	
	
	var instrumentTypeId =$('#instrumentTypeId').val();
	$('body').off("click",'#deliveryType_false').on("click",'#deliveryType_false',function(e){
		e.stopPropagation();
		   $('#pDelivery').slideDown('fast');
		   $('#pDelivery1').slideDown('fast');
		   if((instrumentTypeId!=undefined) && (instrumentTypeId =="1" || instrumentTypeId =="2" || instrumentTypeId == "5")){
			   if((instrumentTypeId!=undefined) && (instrumentTypeId =="1" || instrumentTypeId =="2")){
			   makeMandatory('#address1,#city,#zipPostalcode,#deliveryAddresscountry');
			   }
			   if($('#deliveryDesignationFlag_Applicant').is(':checked')) {
				   setApplicantDetails($('#instrumentTypeId').val());
			   }else if($('#deliveryDesignationFlag_Beneficiary').is(':checked')){
				   setBeneficiaryDetails($('#instrumentTypeId').val());
			   } 
		   }
		   else if((instrumentTypeId!=undefined) && (instrumentTypeId =="3")){
			   makeMandatory('#sbAddress1,#sbCity,#zipPostalcode,#deliveryAddresscountry');
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
	
	$('body').off("change",'#riderGEDivisionID').on("change",'#riderGEDivisionID',function(e){
		e.stopPropagation();
		var geDivisionName=$('#riderGEDivisionID :selected').text();
		$('#riderGEDivisionName').val(geDivisionName);
		
	});
	
	 $("textarea#projectDescId").on("keyup change", function(){checkMaxLength(); } );
		
	 $('body').off("change",'#selectBuApprovers').on("change",'#selectBuApprovers',function(e){
		 e.stopPropagation();
			var approver=$('#selectBuApprovers :selected').text();
			var approverName = approver.toString();
			var approverLastName = approverName.substring(0,approverName.indexOf(',', 0));
			var approverFirstName = approverName.substring(approverName.indexOf(',',0)+2 , approverName.length);
			$('#approverFirstName').val(approverFirstName);
			$('#approverLastName').val(approverLastName);
			
		});
	   
		//onload Call for format types
	 	onloadFormatSelection();
		
		$('body').on('change', '#pole2', function(e){
			e.stopPropagation();
			formatSelectionClick();				
		});
		
		$('body').off("click",'#trans').on("click",'#trans',function(e){
			e.stopPropagation();
			$("#transnote").toggle(this.checked);
			$("#transId").val("");
		});
		
		$('body').off("click",'#attBond').on("click",'#attBond',function(e){
			e.stopPropagation();
			$("#attBondNote").toggle(this.checked);
			$("#attBondId").val("");
		});
		
		$('body').off("click",'#tpadd').on("click",'#tpadd',function(e){
			e.stopPropagation();
			$("#tpaddnote").toggle(this.checked);
			$("#tpaddId").val("");
		});
		
		$('body').off("click",'#tpcus').on("click",'#tpcus',function(e){
			e.stopPropagation();
			$("#tpcusnote").toggle(this.checked);
			$("#tpcusId").val("");
		});
		
		$('body').off("click",'#proj').on("click",'#proj',function(e){
			e.stopPropagation();
			$("#projnote").toggle(this.checked);
			$("#projId").val("");
		});
		
		$('body').off("click",'#insdet').on("click",'#insdet',function(e){
			e.stopPropagation();
			$("#insdetnote").toggle(this.checked);
			$("#insdetId").val("");
		});
		
		$('body').off("click",'#insrisk').on("click",'#insrisk',function(e){
			e.stopPropagation();
			$("#insrisknote").toggle(this.checked);
			$("#insriskId").val("");
		});
		
		$('body').off("click",'#standbylet').on("click",'#standbylet',function(e){
			e.stopPropagation();
			$("#standbyletnote").toggle(this.checked);
			$("#standbyletId").val("");
		});
		
		$('body').off("click",'#insrep').on("click",'#insrep',function(e){
			e.stopPropagation();
			$("#insrepnote").toggle(this.checked);
			$("#insrepId").val("");
		});
		
		$('body').off("click",'#insrepatr').on("click",'#insrepatr',function(e){
			e.stopPropagation();
			$("#insrepatrnote").toggle(this.checked);
		});
		
		$('body').off("click",'#delinst').on("click",'#delinst',function(e){
			e.stopPropagation();
			$("#delinstnote").toggle(this.checked);
			$("#delinstId").val("");
		});
		
		$('body').off("click",'#attachm').on("click",'#attachm',function(e){
			e.stopPropagation();		
			$("#attachmnote").toggle(this.checked);
			$("#attachmId").val("");
		});
		
		$('body').off("click",'#formatTa').on("click",'#formatTa',function(e){
			e.stopPropagation();			
			$("#formatTaNote").toggle(this.checked);
			$("#formatTaId").val("");
		});
		
		$('body').off("click",'#applic').on("click",'#applic',function(e){
			e.stopPropagation();
			$("#applicnote").toggle(this.checked);
			$("#applicId").val("");
		});
		
	    $('body').off("click",'#bundleToDashboardBack').on("click",'#bundleToDashboardBack',function(e){
	    	e.stopPropagation();
			window.location.href='forgot.action';
		});
		
		
		var showtrDelegation= $('#showtrDelegation').val();
		if(showtrDelegation!=undefined && showtrDelegation=='true'){
			 $('#readySystemCheckSection').hide();
			 $("#submitDiv").removeClass('hide');			
		}
		
		$("#priceDetailsFlag_Accept").click(function(e){
			e.stopPropagation();
	           $("#rejection").hide("fast");
	        });
		$("#priceDetailsFlag_Reject").click(function(e){
			e.stopPropagation();
	           $("#rejection").show("fast");
	        });
		
		var reasonforRejection = $('[name="requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.acceptPricingDetailsFlag"]:radio:checked').val();
	    if(reasonforRejection != undefined && reasonforRejection == "Reject"){
	    	 $("#rejection").show("fast");
	    }
		
	    $('body').off("click",'#deliveryDesignationFlag_Applicant').on("click",'#deliveryDesignationFlag_Applicant',function(e){
			e.stopPropagation();
			setApplicantDetails($('#instrumentTypeId').val());
		});
	    
	    $('body').off("click",'#deliveryDesignationFlag_Beneficiary').on("click",'#deliveryDesignationFlag_Beneficiary',function(e){
	    	setBeneficiaryDetails($('#instrumentTypeId').val());
		});
	    $('body').off("click",'#deliveryDesignationFlag_OtherParty').on("click",'#deliveryDesignationFlag_OtherParty',function(e){
			e.stopPropagation();
			if($('#deliveryType_false').is(':checked')){
			clearDeliveryDetails();	
			}
			 if((instrumentTypeId!=undefined) && (instrumentTypeId =="1" || instrumentTypeId =="2")){
	        	 refreshSectionCount("deliveryInstructionsPanel");
	        }
		});
	    
		$('body').off('change','#addressSelection').on('change','#addressSelection',function(e){
			e.stopPropagation();
			var addressSelectionVal =  $("#addressSelection").val();
	        if(addressSelectionVal=='PrincipalDetails') {
				$('#sbAddress1').val($('#principalAddress1').val());
				$('#sbAddress2').val($('#principalAddress2').val());
				$('#sbCity').val($('#principalAddressCity').val()); 
				if($('#principalAddressState').val() != null && $('#principalAddressState').val() !=""){
					$('#stateProvince2').val($('#principalAddressStatecode').val());
					$('#deliveryAddressState').val($("#principalAddressState").val());
					$('select.comboDeliveryState option[value="-1"]').attr("selected",true);
				}else{
					$('#stateProvince2').val("");
					$('#deliveryAddressState').val("");
					$('select.comboDeliveryState option[value="-1"]').attr("selected",true);
				}
				if($('#principalCountryCd').val() != null && $('#principalCountryCd').val() !=""){
					$('#sbCountryCode').val($('#principalCountryCd').val());
					$('#deliveryAddresscountry').val($("#principalAddressCountry").val());
					$('#deliveryAddresscountry').closest('div.form-row').find("input.ui-widget").val($("#principalAddressCountry").val());
				}else{
					$('#sbCountryCode').val("");
					$('#deliveryAddresscountry').val("");
					$('#deliveryAddresscountry').closest('div.form-row').find("input.ui-widget").val("");
				}				
				$('#zipPostalcode').val($('#principalAddressZip').val());
	        }
	        else if(addressSelectionVal=='ObligeeDetails') {
				$('#sbAddress1').val($('#obligeeAddress1').val());
				$('#sbAddress2').val($('#obligeeAddress2').val());
				$('#sbCity').val($('#obligeeAddressCity').val());
				if($('#obligeeAddressState').val() != null && $('#obligeeAddressState').val() !=""){
					$('#stateProvince2').val($('#obligeeAddressStateCd').val());
					$('#deliveryAddressState').val($("#obligeeAddressState").val());
					$('select.comboDeliveryState option[value="-1"]').attr("selected",true);
				}else{
					$('#stateProvince2').val("");
					$('#deliveryAddressState').val("");
					$('select.comboDeliveryState option[value="-1"]').attr("selected",true);
				}
				if($('#obligeeAddressCountryCd').val() != null && $('#obligeeAddressCountryCd').val() !=""){
					$('#sbCountryCode').val($('#obligeeAddressCountryCd').val());
					$('#deliveryAddresscountry').val($("#obligeeAddressCountry").val());
					$('#deliveryAddresscountry').closest('div.form-row').find("input.ui-widget").val($("#obligeeAddressCountry").val());
				}else{
					$('#sbCountryCode').val("");
					$('#deliveryAddresscountry').val("");
					$('#deliveryAddresscountry').closest('div.form-row').find("input.ui-widget").val("");
				}				
				$('#zipPostalcode').val($('#obligeeAddressZip').val());				
	        }
	        else{
	        	clearDeliveryDetails();	
	        }
	        if((instrumentTypeId!=undefined) && (instrumentTypeId =="1" || instrumentTypeId =="2" || instrumentTypeId =="3")){
	        	 refreshSectionCount("deliveryInstructionsPanel");
	        }
	       
		});
		if($('#openSection').val()!=undefined && $('#openSection').val()!=""){
		openRequestorSection();
		}
			
			$('#reject').click(function(e){
				e.stopPropagation();
				$('#rejectComment').show();
				 
			});
				
			$('#awardbank_5').click(function(e){
				e.stopPropagation();
				$('#Returnbank').show();
			});
			
			$('#awardbank_4').click(function(e){
				e.stopPropagation();
				$('#Returnbank').hide();
			});
			
			$('#rejectApprove_5').click(function(e){
				e.stopPropagation();
				$('#rejectComment').show();
			});
			
			$('#rejectApprove_4').click(function(e){
				e.stopPropagation();
				$('#rejectComment').hide();
			});
			
			$('#awardsubmit_14').click(function(e){
				e.stopPropagation();
				$('#Returnaward').show();
			});
			$('#awardsubmit_13').click(function(e){
				e.stopPropagation();
				$('#Returnaward').hide();
			});
			onclickApprove();
			
			onclickAwardbank();
			
			onclickBidAward();
			
			$('#completeTransactionId_20').click(function(e){
				e.stopPropagation();
				$('#decline').hide();
				 
			});
			$('#completeTransactionId_21').click(function(e){
				e.stopPropagation();
				$('#decline').show();
				 
			});
			
			$('#bankagreeId_22').click(function(e){
				e.stopPropagation();
				$('#decline').hide();
				 
			});
			$('#bankagreeId_23').click(function(e){
				e.stopPropagation();
				$('#decline').show();
				 
			});
			
			$('#completeAmendmentId_24').click(function(e){
				e.stopPropagation();
				$('#decline').hide();
				 
			});
			$('#completeAmendmentId_25').click(function(e){
				e.stopPropagation();
				$('#decline').show();
				 
			});
			
			$('#completeRiderId_26').click(function(e){
				e.stopPropagation();
				$('#decline').hide();
				 
			});
			$('#completeRiderId_27').click(function(e){
				e.stopPropagation();
				$('#decline').show();
				 
			});
			
			onclickTransaction();
			onclickBankagree();
			onclickCompleteAmendment();
			onclickCompleteRider();

			
			$("#BusinessClear").click(function(e){
				e.stopPropagation();
				$("#businessShow").hide();	
				$("#businessShow").find('input[type=hidden]').val('');
				$("#businessShow").find('.form-row').find('p').text('');
			});
			$("#BusinessClear1").click(function(e){
				e.stopPropagation();
				 $("#businessShow1").hide();	
				 $("#businessShow1").find('input[type=hidden]').val('');
				 $("#businessShow1").find('.form-row').find('p').text('');
			});
			$("#BusinessClear2").click(function(e){
				e.stopPropagation();
				$("#businessShow2").hide();
			    $("#businessShow2").find('input[type=hidden]').val('');
				$("#businessShow2").find('.form-row').find('p').text('');
			});
			/*issuer transactionsubmit*/
			 $("#bankagree").click(function(e){
				 e.stopPropagation();
				 $("#decline").hide("fast");
			 });
			 $("#bankdecline").click(function(e){
				 e.stopPropagation();
				    $("#decline").show("fast");
			 });
					 
			 // add multiple select / deselect functionality
		     $("#selectall").click(function (e) {
		    	 e.stopPropagation();
				   $('.case').attr('checked', this.checked);
			 });
				 
			 // if all checkbox are selected, check the selectall checkbox
		     // and viceversa
			 $(".case").click(function(e){
				 e.stopPropagation();
				  if($(".case").length == $(".case:checked").length) {
				        $("#selectall").attr("checked", "checked");
				   } else {
				        $("#selectall").removeAttr("checked");
				   }
				 
			 });
			 
			 $("#savemodel").click(function(e){
				 e.stopPropagation();
					 var thisCheck = $(this);
					 if (thisCheck.is (':checked'))
					 {
						 $('#ModelShow').show('fast'); 
					 }
					 else{
						 $('#ModelShow').hide('fast'); 
					 }
			     });
			 $("#saveAsModel").click(function(e){
				 e.stopPropagation();
				 var thisCheck = $(this);
				 if (thisCheck.is (':checked'))
				 {
					 $('#SaveAsModelShow').show('fast'); 
					 $('#saveasmodelId').val('SAVE');
					 $('#modelName').val("");
				 }
				 else{
					 $('#SaveAsModelShow').hide('fast'); 
					 $('#saveasmodelId').val("");
					 $('#modelName').val("");
				 }
		     });
			// ////////////////////

				if(!$('#nav-save').attr('handlerSaveDraft')) {
					$("#nav-save").click(function(e){
						e.stopPropagation();
						hideSubmitSectionDropdown();
						$('#actionTypeId').val("1");
						$('#saveasmodelId').val("");
						$('#modelName').val("");						
						$('form#reviewAndSubmitFormID').submit();
					});
					$('#nav-save').attr('handlerSaveDraft', true);
					}
				
			$('form#reviewAndSubmitFormID').submit(function() {
				return true;
			});
				
				$("#nav-exit").click(function(e){
					e.stopPropagation();
					   $('#li2').removeClass('liactive');
					   $('#li3').removeClass('liactive');
					   $('#li4').removeClass('liactive');
				    $("#nav-save").removeClass('tabactive');
					   $("#nav-submit").removeClass('tabactive');
					   $("#nav-prepare").removeClass('tabactive');
					   $("#nav-model").removeClass('tabactive');
					   
				});
				
				$(".nav-hide-review").click(function(e){
					e.stopPropagation();
					$(this).closest('.dropdownNew').hide();
					$('.bottombtn').each(function(){
						if($(this).hasClass('dropdown-open')){
							$(this).removeClass("secondary").removeClass('dropdown-open');
						}
					});
				});
				
				$(".nav-hide").click(function(e){
					e.stopPropagation();
					$('li.navLi').removeClass('liactive');
					 $("a.navLink").removeClass('tabactive');
					 $(this).closest('.tab').hide();
				});
				if(!$('#tr-nav-save').attr('handlerTreasurySave')) {
				$("#tr-nav-save").click(function(e){
					e.stopPropagation();
					$(this).addClass('tabactive');
					$('#li7').removeClass('liactive');
					$('#li8').removeClass('liactive');
					$("#tr-nav-approve").removeClass('tabactive');
					$("#tr-nav-sendBack").removeClass('tabactive');
					$('#actionTypeId').val("1");
					$('form#tranalystSubmitForm').submit();
				});
				$('#tr-nav-save').attr('handlerTreasurySave', true);
				}
				
				$('form#tranalystSubmitForm').submit(function() {
					return true;
				});
				
				if(!$('#tr-nav-approve').attr('handlerTreasuryApprove')) {
				$("#tr-nav-approve").click(function(e){
					e.stopPropagation();
					$(".approversErrorDiv").hide();
				    $(this).addClass('tabactive');
					   $('#li7').addClass('liactive');
					   $('#li8').removeClass('liactive');
					   $("#tr-nav-save").removeClass('tabactive');
					   $("#tr-nav-sendBack").removeClass('tabactive');
					   
				});	
				$('#tr-nav-approve').attr('handlerTreasuryApprove', true);
				}
				
				if(!$('#tr-nav-sendBack').attr('handlerSendBack')) {
				$("#tr-nav-sendBack").click(function(e){
					e.stopPropagation();
				    $(this).addClass('tabactive');
					   $('#li8').addClass('liactive');
					   $('#li7').removeClass('liactive');
					   $("#tr-nav-save").removeClass('tabactive');
					   $("#tr-nav-approve").removeClass('tabactive');
				});
				$('#tr-nav-sendBack').attr('handlerSendBack', true);
				}
				
								
				var errorShow = $('#errorShowId').val();
				if(errorShow!=undefined && errorShow == 'true'){
					$('#bidReplyPageLevelErrorDivId').show();
				}
				var pagelevelerror = $('#errorShowId').val();
				if(pagelevelerror!=undefined && pagelevelerror == 'true'){
					$('#issuerPageLevelErrorDivId').show();
				}
				
				var errorShow = $('#errorShowId').val();
				if(errorShow!=undefined && errorShow == 'true'){
					$('#bidReplyPageLevelErrorDivId').show();
				}
							
				$("a.alertPopUp").click(function(e){
					e.stopPropagation();
					$('#alertPopUp').modal({show: 'true'}).css("margin-top","-22px;"); 		
				});
				
				 $('body').off("change",'.estBidAmount').on("change",'.estBidAmount',function(e){
				    	e.stopPropagation();
						var targetId = $(e.target).closest('.row').next().find('p').attr('id');
						var currCodeid = $(e.target).closest('.row').prev().find('input[type=hidden]').attr('id');
						var currCode=$("#"+currCodeid).val();
						var originalCCYAmount= $(e.target).val();
						var targetControl = $(e.target).closest('.row').next().find('input[type=hidden]').attr('id');
						$(".usdEquivalentErrorDiv").hide();
						if(currCode!="" && originalCCYAmount!=""){
							if(currCode!=undefined && originalCCYAmount!=undefined){
								if(currCode!="USD"){
									$('#estUsdEquivalentDiv').show();
									var data = {currCode: currCode,originalCCYAmount: originalCCYAmount};
									$('#estBidUSDProcess').show();
									var url = contextURL +"/int/USDEquivalentRefData.action";
									$(".estUsdEquivalentErrorDiv").hide();
									$.ajax({
										type: "POST",
										url: url,
										dataType: 'json',
										data: data,
										success: function(data){
										$("#"+targetId).find('span').text(data.data);
										$('#'+targetControl).val(data.data);
										$('#estBidUSDProcess').hide();
										},
										error: function (xhr, textStatus, errorThrown ) {
											var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
											$(".estUsdEquivalentErrorDiv").show();
											$(".estUsdEquivalentErrorDiv").find('div.errorContent').html(errorReason);
											$("#"+targetId).find('span').text("");
											$('#'+targetControl).val("");
											$('#estUsdEquivalentDiv').hide();
											$('#estBidUSDProcess').hide();
										}
									});
								}else{
									$('#estUsdEquivalentDiv').hide();
									$("#"+targetId).find('span').text(originalCCYAmount);
									$('#'+targetControl).val(originalCCYAmount);
								}
									
							}
						}
					
					});
});

function showDiv() {
	if ($(window).scrollTop() > 100) {
		$('#floatDiv').fadeIn('fast').css({'position': 'fixed', 'top': '0px'}); ;
	} else {
		$('#floatDiv').fadeOut('fast');
	}
}

function hideSubmitSectionDropdown(){
	$('.bottombtn').each(function(){
		$(this).removeClass("secondary").removeClass('dropdown-open');
		var dropDownDiv = $(this).attr('data-dropdown');
		$(dropDownDiv).hide();
	});
}

//All Function Body
function callBUCADNValidation(url,formData){
	$.ajax({
		type: "POST",
        url: url,
        dataType: 'json',
        data: formData,
        processdata: true,
        success: function(data) {
        	if(data.result[0].IBSMessageId != '' && data.result[1] == undefined){
        		$('#matched').show();
        		$('#unMatched').hide();
        		$('.ibsClass').find('p').text($('#bussUnitCodeId').val() + " " + $('#accDistNoId').val());
        		$('.ibsClass').show();
        		$('.ibsClassWarning, .bucBlocked').hide();
        		$('#ibsSystemMsgId').val(data.result[0].IBSMessageId);
        		$('.ibsClassNotification').show();
        	}else{
        		$('#unMatched').show();
        		$('#matched').hide();
        		$('.ibsClass').hide();
        		$('.ibsClassNotification').hide();
        		$('.ibsClassWarning, .bucBlocked').hide();
        		if(data.result[0].IBSMessageId == ''){
        			$('.ibsClassWarning').show();
            		var contact = $('.ibsClassWarning').find('#ibsContact').text();
    				contact = contact.replace(contact.split(':')[1],data.result[0].Contact);
    				$('.ibsClassWarning').find('#ibsContact').text(contact);
    				$('.ibsClassWarning').find('#ibsMessage').text(data.result[0].IBSMessage);
            		$('#ibsSystemMsgId').val("0");
        		}
        		if(data.result[1] != undefined){
            		$('.bucBlocked').show();
            		var contact1 = $('.bucBlocked').find('#blockedBUCContact').text();
    				contact1 = contact1.replace(contact1.split(':')[1],data.result[1].BlockedBUCName);
    				$('.bucBlocked').find('#blockedBUCContact').text(contact1);
            	}
        	}
			 
    		var name = data.result[0].Contact.split(",");
    		$('#ibsSystemMsg').val(data.result[0].IBSMessage);
    		
    		$('#ibsFNameId').val(name[1]);
    		$('#ibsLNameId').val(name[0]);
    		$('#ibsPhoneId').val(data.result[0].Phone);
    		$('#bucadnLoading').hide();
    		setBucAdnTimeout();
        }
    });
}

function usdConversion(data,targetId,targetControl,imageId){
	$("#"+imageId).show();
	var url = contextURL +"/int/USDEquivalentRefData.action";
	$("#errorMessage").hide();
	$(".usdEquivalentErrorDiv").hide();
	$.ajax({
		type: "POST",
		url: url,
		dataType: 'json',
		data: data,
		success: function(data){
		$("#"+targetId).find('span').text(data.data);
		$('#'+targetControl).val(data.data);
		$("#"+imageId).hide();
		var taxonomyViewType = $('#taxonomyViewType').val();
		if($('#instrumentUSDAmt').val()!=undefined && $('#instrumentUSDAmt').val()!="" && (taxonomyViewType == undefined || taxonomyViewType != 'UPDATEDATA')){
		bidValuepercent($('#instrumentUSDAmt').val());
		}
		if($('#updateUSDVal').val()!=undefined && $('#updateUSDVal').val()!="" && taxonomyViewType!=undefined && taxonomyViewType == 'UPDATEDATA'){
			updatedBidValuepercent($('#updateUSDVal').val());
		}
		},
		error: function (xhr, textStatus, errorThrown ) {
			var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
			$(".usdEquivalentErrorDiv").show();
			$(".usdEquivalentErrorDiv").find('div.errorContent').html(errorReason);
			$("#"+targetId).find('span').text("");
			$('#'+targetControl).val("");
			$("#errorMessage").show();
			$('#usdEquivalentDiv').hide();
			$("#"+imageId).hide();
		}
	});
}

function approximateUSDShow(){
	var ccyCode = $('#currencies').val();
	if(ccyCode!="" && ccyCode!=undefined){
		if(ccyCode=="USD"){
			$('#approximateUSDDiv').hide();
		}else{
			$('#approximateUSDDiv').show();
		}
	}
}

function showHideIbsMessage(){
	var bucValue = $('#bussUnitCodeId').val();
	var adnValue = $('#accDistNoId').val();
	if(bucValue != undefined && bucValue != '' && adnValue != undefined && adnValue != ''){
		var url = contextURL+"/int/BUCADNLookup.action";
		var formData = {
			bucValue : bucValue,
			adnValue : adnValue
		};
		callBUCADNValidation(url,formData);
	}else{
		$('.ibsClass').hide();
	}
}


function checkMaxLength(){
 	maxLength = 300;
    currentLengthInTextarea = $("#projectDescId").val().length;
    if (currentLengthInTextarea > (maxLength)) { 
        // Trim the field current length over the maxlength.
        $("textarea#projectDescId").val($("textarea#projectDescId").val().slice(0, maxLength));
    }
} 
		
function onclickApprove(){
	if($('#rejectApprove_5').is(':checked')) {
		$('#rejectComment').show();
	}
	if($('#rejectApprove_4').is(':checked')) {
		$('#rejectComment').hide(); 
	}
}
			
function onclickAwardbank(){
	if($('#awardbank_5').is(':checked')) {
		$('#Returnbank').show();
	}
	if($('#awardbank_4').is(':checked')) {
		$('#Returnbank').hide(); 
	}
}

function onclickBidAward(){
	if($('#awardsubmit_14').is(':checked')) {
		$('#Returnaward').show();
	}
	if($('#awardsubmit_13').is(':checked')) {
		$('#Returnaward').hide(); 
	}
}

function onclickTransaction(){
	if($('#completeTransactionId_20').is(':checked')) {
		$('#decline').hide();
	}
	if($('#completeTransactionId_21').is(':checked')) {
		$('#decline').show(); 
	}
}

function onclickBankagree(){
	if($('#bankagreeId_22').is(':checked')) {
		$('#decline').hide();
	}
	if($('#bankagreeId_23').is(':checked')) {
		$('#decline').show(); 
	}
}

function onclickCompleteAmendment(){
	if($('#completeAmendmentId_24').is(':checked')) {
		$('#decline').hide();
	}
	if($('#completeAmendmentId_25').is(':checked')) {
		$('#decline').show(); 
	}
}

function onclickCompleteRider(){
	if($('#completeRiderId_26').is(':checked')) {
		$('#decline').hide();
	}
	if($('#completeRiderId_27').is(':checked')) {
		$('#decline').show(); 
	}
}

function getDelegationApprovers(){
	var selectedApproverSso = $("#selectedApproverSso").val();
	var approveLevelid="";
	var url = contextURL +"/int/DelegationApproversRefData.action";
	$.ajax({
		type: "POST",
		url: url,
		dataType: 'json',
		data: {},
		processdata: true,
		success: function(data){
			$("#selectBuApprovers").empty().append("<option value=''>Select...</option>");
        	for (var i = 0; i < data.result.length; i++) {
        		if(selectedApproverSso!=undefined && selectedApproverSso!="" &&  selectedApproverSso== data.result[i].ssoId)
    			{
        			$("#selectBuApprovers").append("<option value='" + data.result[i].ssoId + "'selected>" + data.result[i].lastName +", "+ data.result[i].firstName +"</option>");
    			}
    		else{
    			$("#selectBuApprovers").append("<option value='" + data.result[i].ssoId + "'>" + data.result[i].lastName +", "+ data.result[i].firstName +"</option>");
    			}
        		approveLevelid= data.result[i].approveLevelId;
             }
        	$('.approveLevelID').text(approveLevelid);
		}
	});
}

function getDelegationApproversOnSubmit(approverAmount){
	$(".approversErrorDiv").hide();
	var InstrumentTypeId =$('#instrumentTypeId').val();
	var requestId =$('#requestId').val();
	var WFStage =$('#WFStage').val();
	var selectedApproverSso = $("#selectedApproverSso").val();
	var AmendmentOrRiderId = $("#AmendmentOrRiderId").val();
	var isResubmitPage = $("#isResubmitPage").val();
	var isIRReadonlyPage = $("#isIRReadonlyPage").val();
	var levelsRequired="";
	var approveLevelid="";
	var groupName="";
	
	var notiClauseFlag="";
	var curePeriodFlag="";
	var drDownApprFlag="";
	if($('#curePeriodFlag_true').is(':checked')) {
		 curePeriodFlag = "true";
		}
	else if($('#curePeriodFlag_false').is(':checked')) {
		 curePeriodFlag = "false";
	}
	if($('#notiClauseFlag_true').is(':checked')) {
		notiClauseFlag = "true";
		}
	else if($('#notiClauseFlag_false').is(':checked')) {
		notiClauseFlag = "false";
	}
	if($('#drDownApprFlag_true').is(':checked')) {
		drDownApprFlag = "true";
		}
	else if($('#drDownApprFlag_false').is(':checked')) {
		drDownApprFlag = "false";
	}
	var formData = {'requestId':requestId,'InstrumentTypeId':InstrumentTypeId,'approverAmount':approverAmount,'WFStage':WFStage,'AmendmentOrRiderId':AmendmentOrRiderId,'notiClauseFlag':notiClauseFlag,'curePeriodFlag':curePeriodFlag,'drDownApprFlag':drDownApprFlag,'isResubmitPage':isResubmitPage,'isIRReadonlyPage':isIRReadonlyPage};
	var url = contextURL +"/int/ApproversRefData.action";
	$.ajax({
		type: "POST",
		url: url,
		dataType: 'json',
		data: formData, 
		processdata: true,
		success: function(data){
				$("#selectBuApprovers").empty().append("<option value=''>Select...</option>");
				for (var i = 0; i < data.result.length; i++) {
	        		if(selectedApproverSso!=undefined && selectedApproverSso!="" &&  selectedApproverSso== data.result[i].ssoId)
	    			{
	        			$("#selectBuApprovers").append("<option value='" + data.result[i].ssoId + "'selected>" + data.result[i].lastName +", "+ data.result[i].firstName +"</option>");
	    			}
	    		else{
	    			$("#selectBuApprovers").append("<option value='" + data.result[i].ssoId + "'>" + data.result[i].lastName +", "+ data.result[i].firstName +"</option>");
	    			} 
	        		levelsRequired = data.result[i].levelsrequired;
	    	        approveLevelid= data.result[i].approveLevelId;
	    	        groupName = data.result[i].groupName;
	             }
				if(data.result.length <= 0){
					if($('#instrumentTypeId').val()=='5' && WFStage=='TREAPROV'){
						$('#insTransionPlatformDiv').show();
					}
					$('#budelegationShowDivId').hide();
					if((WFStage != undefined && WFStage != '') && 
						(WFStage === 'Requestor' || WFStage === 'REQEST' || WFStage === 'REQUEST' || WFStage === 'ANLAPROV')){
						$('#noMatchingDelegation').show();
					}else if((WFStage != undefined && WFStage != '') && (WFStage === 'BUSAPROV' || WFStage === 'TREAPROV')){
						$('#lastApproverSubmit').show();
					}
				}else{
					$('#showLevelsId').empty().html(levelsRequired);
		        	$('.approveLevelID').text(approveLevelid);
		        	$('#approverLevel').val(approveLevelid);
		        	$('#groupName').val(groupName);
		        	$('#noMatchingDelegation').hide();
		        	$('#lastApproverSubmit').hide();
		        	$('#budelegationShowDivId').show();
				}
	        	$('#submitProcess').hide();
			
		},
		 error: function (xhr, textStatus, errorThrown ) {
			 $('#submitProcess').hide();
				var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
				$(".approversErrorDiv").show();
				var multipleTabError = "Please use 'New Session' (in IE, File->New Session) to launch one more instance of ALOC. ALOC in multiple tabs is currently not supported.";
				if(errorReason == multipleTabError){
					window.location.href = contextURL+'/int/multiTabsIssue.action';
				}else{
				$(".approversErrorDiv").find('div.errorContent').html(errorReason);
				}				
		    }
	});
}

function submitAction(actionType){
	$('#actionTypeId').val(actionType);
}
function setWorkingSection() {
	var activeSection="";
	$('.section_flip').each(function() {
		if($(this).hasClass('section_active')){
			activeSection = $(this).attr('id');
		}
	});
	$('#sncWorkingSectionId').val(activeSection);
}
function setBundleFlag(actionType){
	$('#prepareForBundleId').val('Y');
	$('#actionTypeId').val(actionType);
}




function clearDeliveryDetails(){
	$('#addressSelection').val("");
	$('#address1').val("");
	$('#address2').val("");
	$('#city').val("");
	$('#sbAddress1').val("");
	$('#sbAddress2').val("");
	$('#sbCity').val("");
	$('#stateProvinceCode').val("");
	$('#pDelivery').find('select').val(-1);
	$('#deliveryAddressState').val("");
	$('select.comboDeliveryState option[value="-1"]').attr("selected",true);
	//$('#deliveryAddressState').closest('div.form-row').find("input.ui-widget").val("");
	$('#zipPostalcode').val("");
	$('#countryCode').val("");
	$('#deliveryAddresscountry').val("");
	$('#deliveryAddresscountry').closest('div.form-row').find("input.ui-widget").val("");
	
}

function readyForSystemChecks(){
var url = contextURL+"/int/BUCADNLookup.action";
var bucValue = $.trim($('#pBUC').text());
var adnValue = $.trim($('#pADN').text());
var formData = {
	bucValue : bucValue,
	adnValue : adnValue
};
if(bucValue != undefined && bucValue != '' && adnValue != undefined && adnValue != ''){
	$.ajax({
		type: "POST",
        url: url,
        dataType: 'json',
        data: formData,
        processdata: true,
        success: function(data) {
        	if(data.result[0].IBSMessageId == ''){
        		$(".ibsClassWarningTA").show();
        		$("#ibsMessageinTA").text(data.result[0].IBSMessage);
        		
        	}
        	var requiresEditsValue= $('.requiresEdits').text();
        	if((data.result[0].IBSMessageId == '') || (requiresEditsValue != undefined && requiresEditsValue!='')){
				$("#tr-nav-approve").parent('li').hide();
				$("#tr-nav-sendBack").parent('li').show();
				$("#tra-nav-award").parent('li').hide();//for postAward
				$("#tra-nav-sendBack").parent('li').show();//for postAward
			}else{
				$("#tr-nav-sendBack").parent('li').hide();
				$("#tr-nav-approve").parent('li').show();
				$("#tra-nav-sendBack").parent('li').hide();//for postAward
				$("#tra-nav-award").parent('li').show();//for postAward
			}
		}
	});
}

 $('#readySystemCheckSection').hide();
 $("#submitDiv").removeClass('hide');
}


function getApprovers() {
	if($('#instrumentTypeId').val()=='1' || $('#instrumentTypeId').val()=='2'){
		var instrumentUSDAmt = $('#instrumentUSDAmt').val();
		 if(instrumentUSDAmt !="" && instrumentUSDAmt != undefined){
			 instrumentUSDAmt= instrumentUSDAmt.replace(/,/g,"");
			  $('#submitProcess').show();
			 getDelegationApproversOnSubmit(instrumentUSDAmt);
		 }
		
	}else if($('#instrumentTypeId').val()=='3'){
		var bondUsdEquivalentAmount = $('#bondUsdEquivalentAmount').val();
		 if(bondUsdEquivalentAmount !="" && bondUsdEquivalentAmount != undefined){
			 bondUsdEquivalentAmount= bondUsdEquivalentAmount.replace(/,/g,"");
			  $('#submitProcess').show();
			 getDelegationApproversOnSubmit(bondUsdEquivalentAmount);
		 }		
	}else if($('#instrumentTypeId').val()=='6'){
		$(".approversErrorDiv").hide();
		 var approverAmount;
			var isContractBond = $('#contractBondID').val();
			if(isContractBond == "true"){
				approverAmount = $('#revisedUSDEquiContractAmtId').val();
			}else{
				approverAmount = $('#revisedBondAmt').val();
			}
			if(approverAmount !="" && approverAmount != undefined){
				$('#submitProcess').show();
				 approverAmount= approverAmount.replace(/,/g,"");
				getDelegationApproversOnSubmit(approverAmount);
			}else{
				if(isContractBond == "true"){
					  var revisedAmt = $('#originalContractAmtId').val();
						var newCurrId = $('#contractCurId').val();
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
											approverAmount=data.data;	
											 getDelegationApproversOnSubmit(approverAmount);
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
									 getDelegationApproversOnSubmit(approverAmount);
								}
							}
						}
				   }
				else{
					approverAmount = $('#currentBondAmtId').val();
					if(approverAmount!=undefined && approverAmount!=""){
					$('#submitProcess').show();
					 approverAmount= approverAmount.replace(/,/g,"");
				    getDelegationApproversOnSubmit(approverAmount);
					}
				}
			}
		
	}else if($('#instrumentTypeId').val()=='5'){
		$(".approversErrorDiv").hide();
		var approverAmount = $('#revisedUSDEquiAmt').val();
		   if(approverAmount !="" && approverAmount != undefined){
			   approverAmount= approverAmount.replace(/,/g,"");
			   $('#submitProcess').show();
			   getDelegationApproversOnSubmit(approverAmount);
		   }else{
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
									approverAmount=data.data;	
									 getDelegationApproversOnSubmit(approverAmount);
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
							 getDelegationApproversOnSubmit(approverAmount);
						}
					}
				}
		   }
	}
}

function formatSelectionClick(){	
	var formatType= $('#pole2').val();
	if (formatType == "1" ) {     				 
		$("#formatStandard").show();   				
		$("#formatModified").hide();
		$("#formatAttachment").hide();
		$("#generateDoc").show();
		$("#formatSelectionH2").text(" - GE Standard Format");
	}
	else if (formatType == "2" ) { 				
		$("#formatModified").show();	
		$("#formatStandard").hide();
		$("#formatAttachment").hide();
		$("#generateDoc").show();
		$("#formatSelectionH2").text(" - Modified GE Standard Format");
	}	
	else if (formatType == "3" ) {   				
		$("#formatAttachment").show();
		$("#formatStandard").hide();
		$("#formatModified").hide();
		$("#generateDoc").hide();
		$("#formatSelectionH2").text("");
	}else {
		$("#formatAttachment").hide();
		$("#formatStandard").hide();
		$("#formatModified").hide();
		$("#generateDoc").hide();
		$("#formatSelectionH2").text("");
	}		
}

function deliveryTypeOnloadShow(){
	var instrumentTypeId =$('#instrumentTypeId').val();
	if($('#deliveryType_false').is(':checked')) {
		$('#pDelivery').slideDown('fast');
		$('#pDelivery1').slideDown('fast');
		if((instrumentTypeId!=undefined) && (instrumentTypeId =="1" || instrumentTypeId =="2")){
			   makeMandatory('#address1,#city,#zipPostalcode,#deliveryAddresscountry');
		   }
		   else if((instrumentTypeId!=undefined) && (instrumentTypeId =="3")){
			   makeMandatory('#sbAddress1,#sbCity,#zipPostalcode,#deliveryAddresscountry');
		   }
		}
	if ($('#deliveryType_true').is(':checked')){
		 $('#pDelivery').slideUp('fast');
		  $('#pDelivery1').slideUp('fast');
		   clearDeliveryDetails();
		   if((instrumentTypeId!=undefined) && (instrumentTypeId =="1" || instrumentTypeId =="2")){
			   removeMandatory('#address1,#city,#zipPostalcode,#deliveryAddresscountry');
		   }
		   else if((instrumentTypeId!=undefined) && (instrumentTypeId =="3")){
			   removeMandatory('#sbAddress1,#sbCity,#zipPostalcode,#deliveryAddresscountry');
		   }
	}
	
	var sendElectronic = $('input[id=sendElectronic]:checked').val(); 
	if(sendElectronic!=undefined && sendElectronic=='true'){
		$('#Recipient').removeClass('hide');
		$('#recipientShow').removeClass('hide');
	}else if(sendElectronic==false){
		$('#Recipient').addClass('hide');
		$('#recipientSelectionId').val('');
		$('#geRecipient').val('');
	}
}

function sendbackOnloadShow(){
	var transFlag=$('input[id=trans]:checked').val(); 
	if(transFlag == 'true'){
		$("#transnote").show();			
	}		
	var attBondFlag=$('input[id=attBond]:checked').val(); 
	if(attBondFlag == 'true'){
		$("#attBondNote").show();			
	}		
	var tpaddFlag=$('input[id=tpadd]:checked').val(); 
	if(tpaddFlag == 'true'){
		$("#tpaddnote").show();
	}
	var tpcusFlag=$('input[id=tpcus]:checked').val(); 
	if(tpcusFlag == 'true'){
		$("#tpcusnote").show();
	}
	var projFlag=$('input[id=proj]:checked').val(); 
	if(projFlag == 'true'){
		$("#projnote").show();
	}
	var insdetFlag=$('input[id=insdet]:checked').val(); 
	if(insdetFlag == 'true'){
		$("#insdetnote").show();
	}
	
	var insriskFlag=$('input[id=insrisk]:checked').val(); 
	if(insriskFlag == 'true'){
		$("#insrisknote").show();
		
	}
	var standbyletFlag=$('input[id=standbylet]:checked').val(); 
	if(standbyletFlag == 'true'){
		$("#standbyletnote").show();
	}
	var insrepFlag=$('input[id=insrep]:checked').val(); 
	if(insrepFlag == 'true'){
		$("#insrepnote").show();
	}
	var insrepatrFlag=$('input[id=insrepatr]:checked').val(); 
	if(insrepatrFlag == 'true'){
		$("#insrepatrnote").show();
	}
	
	var delinstFlag=$('input[id=delinst]:checked').val(); 
	if(delinstFlag == 'true'){
		$("#delinstnote").show();
	}
	var attachmFlag=$('input[id=attachm]:checked').val(); 
	if(attachmFlag == 'true'){
		$("#attachmnote").show();
	}
	var applicFlag=$('input[id=applic]:checked').val(); 
	if(applicFlag == 'true'){
		$("#applicnote").show();
	}
	var farmotFlag = $('input[id=formatTa]:checked').val(); 
	if(farmotFlag == 'true'){
		$("#formatTaNote").show();
	}
}

function multipleTabsProblemHandle(){
	 $.subscribe('multipleTabsProblem', function(event,data) {
	    	var errorReason = $(event.originalEvent.request.responseText).find('table tbody tr td.errorReason').text();
			var multipleTabError = "Please use 'New Session' (in IE, File->New Session) to launch one more instance of ALOC. ALOC in multiple tabs is currently not supported.";
			if(errorReason == multipleTabError){
				window.location.href = contextURL+'/int/multiTabsIssue.action';
			}		
	    });
}
function getInstrumentUSDConversion(){
	$.subscribe('getInstrumentUSDConversion', function(event,data) {
		var codeTextField = $("#"+data.id).parents('div.form-row').children("input:first").attr("id");
		var targetId = $("#"+data.id).parents('div.row').next().next().next().find('p').attr('id');
		var currCode=$("#"+codeTextField).val();
		var originalCCYAmountid=$("#"+data.id).parents('div.row').next().find('input.instrumentAmt').attr('id');
		var originalCCYAmount= $("#"+originalCCYAmountid).val();
		var targetControl = $("#"+data.id).parents('div.row').next().next().next().find('input[type=hidden]').attr('id');
		$(".instUsdEquivalentErrorDiv").hide();
		if(currCode!="" && originalCCYAmount!=""){
			if(currCode!=undefined && originalCCYAmount!=undefined){
				if(currCode!="USD"){
					$('#approximateUSDDiv').show();
					$('#instUsdProcess').show();
					var instrumentdata = {currCode: currCode,originalCCYAmount: originalCCYAmount};
					var url = contextURL +"/int/USDEquivalentRefData.action";
					$.ajax({
						type: "POST",
						url: url,
						dataType: 'json',
						data: instrumentdata,
						success: function(data){
						$("#"+targetId).find('span').text(data.data);
						$('#'+targetControl).val(data.data);
						bidValuepercent(data.data);
						$('#instUsdProcess').hide();
						},
						error: function (xhr, textStatus, errorThrown ) {
							var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
							$(".instUsdEquivalentErrorDiv").show();
							$(".instUsdEquivalentErrorDiv").find('div.errorContent').html(errorReason);
							$('#approximateUSDDiv').hide();
							$('#instUsdProcess').hide();
							$("#"+targetId).find('span').text("");
							$('#'+targetControl).val("");
							bidValuepercent("");
						}
						});
					
				}else{
					$('#approximateUSDDiv').hide();
					$("#"+targetId).find('span').text(originalCCYAmount);
					$('#'+targetControl).val(originalCCYAmount);
					bidValuepercent(originalCCYAmount);
				}
				amountTowords();
			}
			
		}
		
	});
}

function getUSDConversion(){
$.subscribe('getUSDConversion', function(event,data) {
	var codeTextField = $("#"+data.id).parents('div.form-row').children("input:first").attr("id");
	var targetId = $("#"+data.id).parents('div.row').next().next().find('p').attr('id');
	var imageId = $("#"+data.id).parents('div.row').next().next().find('img').attr('id');
	var currCode=$("#"+codeTextField).val();
	var originalCCYAmountid=$("#"+data.id).parents('div.row').next().find('input.currencyAmt').attr('id');
	var originalCCYAmount= $("#"+originalCCYAmountid).val();
	var targetControl = $("#"+data.id).parents('div.row').next().next().find('input[type=hidden]').attr('id');
	$(".usdEquivalentErrorDiv").hide();
	if(currCode!="" && originalCCYAmount!=""){
		if(currCode!=undefined && originalCCYAmount!=undefined){
			if(currCode!="USD"){
				$('#usdEquivalentDiv').show();
				var data = {currCode: currCode,originalCCYAmount: originalCCYAmount};
				usdConversion(data,targetId,targetControl,imageId);
			}else{
				$('#usdEquivalentDiv').hide();
				$("#"+targetId).find('span').text(originalCCYAmount);
				$('#'+targetControl).val(originalCCYAmount);
				if($('#instrumentUSDAmt').val()!=undefined && $('#instrumentUSDAmt').val()!=""){
				bidValuepercent($('#instrumentUSDAmt').val());
				}
			}
				
		}
		
	}
	
});
}

function getAutocompleterName(){
$.subscribe('getAutocompleterName', function(event,data) {
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
	
	if($('#' + data.id).hasClass('mandatory')) {
		fieldsModified('#' + data.id);
	}
	if($('#' + data.id).parents('div.form-row').find(".autoCompleterName").hasClass('mandatory')) {
		fieldsModified('#' + data.id);
	}
	event.stopPropagation();
});

$.subscribe('getBankAutocompleterName', function(event,data) {
	var ui = event.originalEvent.ui;
	var codeTextField = $("#"+data.id).parents('div.form-row').children("input:first").attr("id");
	if(ui.item != undefined && ui.item != null){
		text = ui.item.value;
	}else{
		text = '';
		$('#'+codeTextField).val($.trim(text));
	}
	if(text != undefined && text == ''){
		$("#treasurySelectedBankId").val("");
	}
	event.stopPropagation();
});
}
function getCurrencyAutocompleterName(){
	$.subscribe('getCurrencyAutocompleterName', function(event,data) {
		var ui = event.originalEvent.ui;
		var codeTextField = $("#"+data.id).parents('div.form-row').children("input:first").attr("id");
		var textField = $("#"+data.id).parents('div.form-row').find(".autoCompleterName").attr("id");
		var text;
		if(ui.item != undefined && ui.item != null){
			var name = ui.item.value;
			text = name.substring(0,name.indexOf("_"));
		}else{
			text = '';
			$('#'+codeTextField).val($.trim(text));
		}
		
		$('#'+textField).val($.trim(text));
		
		if($('#' + data.id).hasClass('mandatory')) {
			fieldsModified('#' + data.id);
		}
		if($('#' + data.id).parents('div.form-row').find(".autoCompleterName").hasClass('mandatory')) {
			fieldsModified('#' + data.id);
		}
		event.stopPropagation();
	});

}


function loadBeforeTracking(){
	$.subscribe('beforeTracking', function(event,data) {	
		if(event.originalEvent.formData != null && event.originalEvent.formData !=undefined){				
			for (var i = 0; i < event.originalEvent.formData.length; i++) {
				if(event.originalEvent.formData[i].name!='' && event.originalEvent.formData[i].name!=undefined){
					if(event.originalEvent.formData[i].name == 'sectionId'){
						if(event.originalEvent.formData[i].value!='' && event.originalEvent.formData[i].value!=undefined){
							sectionId = event.originalEvent.formData[i].value;	
							$('#currentSectionId').val(sectionId);
						}
					}
				}
	        }			
		}
		$("#readySystemCheckSection").show();
		 $("#submitDiv").removeClass('hide').addClass('hide');
		 $('.reimbursementDiv').addClass("hide");
		$('nav ul li.navLi').removeClass('liactive');
		$("a.navLink").removeClass('tabactive');
	});
	
}

function loadRequireEditTracking(){
	$.subscribe('requireEditTracking', function(event,data) {
		/*if(event.originalEvent.status != 'error'){*/
			var url = contextURL +"/int/approver/requireEditTracking.action";
			var sectionId = $('#currentSectionId').val();
			$.ajax({
				type: "POST",
				url: url,
				cache: false,
				dataType: 'html',
				data: {trackSectionId : sectionId},
				success: function(response){
					$('#tracksectionDiv').empty().append(response);
				}
			});
		/*}*/
		$('nav ul li.navLi').removeClass('liactive');
		$("a.navLink").removeClass('tabactive');
	});
	
}

function onloadFormatSelection(){
	var type = $('#pole2').val();
	if( type !="" && type != undefined){			
		formatSelectionClick();	 
	}else if(type == undefined){
		onloadReadOnlySection();
	}else{$("#formatSelectionH2").text("");}
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

function setApplicantDetails(instrumentTypeId){
	 if((instrumentTypeId!=undefined) && (instrumentTypeId =="1" || instrumentTypeId =="2" || instrumentTypeId == "5")){
	if($('#deliveryType_false').is(':checked')){
		if(($('#applicantAddressCity').val()!=undefined && $('#applicantAddressCity').val()!="") || ($('#applicantAddress1').val()!=undefined && $('#applicantAddress1').val()!="")){
			$('#address1').val($('#applicantAddress1').val());
			$('#address2').val($('#applicantAddress2').val());
			$('#city').val($('#applicantAddressCity').val());
			$('#zipPostalcode').val($('#applicantAddressZip').val());
			$('#stateProvinceCode').val($('#applicantAddressStateCd').val());
			$('#deliveryAddressState').val($("#applicantAddressState").val());
			$('select.comboDeliveryState option[value="-1"]').attr("selected",true);
			$('#countryCode').val($('#applicantAddressCountryCd').val());
			$('#deliveryAddresscountry').val($("#applicantAddressCountry").val());
			$('#deliveryAddresscountry').closest('div.form-row').find("input.ui-widget").val($("#applicantAddressCountry").val());
       	}else{
			$('#address1').val($('#triPartyAddress1').val());
			$('#address2').val($('#triPartyAddress2').val());
			$('#city').val($('#triPartyAddressCity').val());
			$('#zipPostalcode').val($('#triPartyAddressZip').val());
			$('#stateProvinceCode').val($('#triPartyAddressStateCd').val());
			$('#deliveryAddressState').val($("#triPartyAddressState").val());
			$('select.comboDeliveryState option[value="-1"]').attr("selected",true);
			$('#countryCode').val($('#triPartyAddressCountryCd').val());
			$('#deliveryAddresscountry').val($("#triPartyAddressCountry").val());
			$('#deliveryAddresscountry').closest('div.form-row').find("input.ui-widget").val($("#triPartyAddressCountry").val());
			}
		}	
	if((instrumentTypeId!=undefined) && (instrumentTypeId =="1" || instrumentTypeId =="2")){
       	 refreshSectionCount("deliveryInstructionsPanel");
		}
       }
}

function setBeneficiaryDetails(instrumentTypeId){
	if((instrumentTypeId!=undefined) && (instrumentTypeId =="1" || instrumentTypeId =="2" || instrumentTypeId == "5")){
   	if($('#deliveryType_false').is(':checked')){
   	$('#address1').val($('#customerAddress1').val());
		$('#address2').val($('#customerAddress2').val());
		$('#city').val($('#customerAddressCity').val());
		$('#stateProvinceCode').val($('#customerAddressStateCd').val());
		$('#deliveryAddressState').val($("#customerAddressState").val());
		$('select.comboDeliveryState option[value="-1"]').attr("selected",true);
		$('#zipPostalcode').val($('#customerAddressZip').val());
		$('#countryCode').val($('#customerAddressCountryCd').val());
		$('#deliveryAddresscountry').val($("#customerAddressCountry").val());
		$('#deliveryAddresscountry').closest('div.form-row').find("input.ui-widget").val($("#customerAddressCountry").val());
   	}
   	if((instrumentTypeId!=undefined) && (instrumentTypeId =="1" || instrumentTypeId =="2")){
       	 refreshSectionCount("deliveryInstructionsPanel");
   	}
       }
}

function setBucAdnTimeout() {
	setTimeout(	function(){
		   $('.bucAdnTimeOut').hide();
		}, 10000);
}


function getBondInfoUSDConversion(){
	$.subscribe('getBondInfoUSDConversion', function(event,data) {
		var codeTextField = $("#"+data.id).parents('div.form-row').children("input:first").attr("id");
		var targetId = $("#"+data.id).parents('div.row').next().next().find('p').attr('id');
		var currCode=$("#"+codeTextField).val();
		var originalCCYAmountid=$("#"+data.id).parents('div.row').next().find('input.estBidAmount').attr('id');
		var originalCCYAmount= $("#"+originalCCYAmountid).val();
		var targetControl = $("#"+data.id).parents('div.row').next().next().find('input[type=hidden]').attr('id');
		$(".estUsdEquivalentErrorDiv").hide();
		if(currCode!="" && originalCCYAmount!=""){
			if(currCode!=undefined && originalCCYAmount!=undefined){
				if(currCode!="USD"){
					$('#estUsdEquivalentDiv').show();
					var data = {currCode: currCode,originalCCYAmount: originalCCYAmount};
					$('#estBidUSDProcess').show();
					var url = contextURL +"/int/USDEquivalentRefData.action";
					$(".estUsdEquivalentErrorDiv").hide();
					$.ajax({
						type: "POST",
						url: url,
						dataType: 'json',
						data: data,
						success: function(data){
						$("#"+targetId).find('span').text(data.data);
						$('#'+targetControl).val(data.data);
						$('#estBidUSDProcess').hide();
						},
						error: function (xhr, textStatus, errorThrown ) {
							var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
							$(".estUsdEquivalentErrorDiv").show();
							$(".estUsdEquivalentErrorDiv").find('div.errorContent').html(errorReason);
							$("#"+targetId).find('span').text("");
							$('#'+targetControl).val("");
							$('#estUsdEquivalentDiv').hide();
							$('#estBidUSDProcess').hide();
						}
					});
				}else{
					$('#estUsdEquivalentDiv').hide();
					$("#"+targetId).find('span').text(originalCCYAmount);
					$('#'+targetControl).val(originalCCYAmount);
				}
				amountInWords();	
			}
		}		
	});
}
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

function openRequestorSection() {
	setTimeout(	function(){
	    $('.filledMandatoryCount').each(function(){
	    	var filledMandatoryCount = parseInt($.trim($(this).text()));
	    	var totalMandatoryCount = parseInt($.trim($(this).next().text()));
	    	var sectionId = $(this).closest('div').find('h2').attr('id');
	    	if(filledMandatoryCount < totalMandatoryCount){
	    		if(isSectionClosed('#'+sectionId)){
	    			toggleSectionExclusively('#'+sectionId);
	    	}
	    		return false;
	    	}
		});
		}, 100);
}
