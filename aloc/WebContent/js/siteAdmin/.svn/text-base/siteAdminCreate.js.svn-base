$(document).ready(function() {
	
	decCounter("siteName", 50);
	decCounter("description", 50);
	decCounter("specialInstructions", 400);
	
	$("#saveApprovers").hide();
	
	onloadTooltipsRoundedBut();
	
	/**
	 * To show Create Request Model window.  
	 */
	$('body').off('click', '#req, #req1').on('click', '#req, #req1', function(e){
		   $("#request").find(".reqdropdown").removeAttr('style');
        $("#request").show();
        if($(this).attr("id") == 'req1'){
     	   $("#request").find(".reqdropdown").css({"top":"100px","left":"70px"});
     	   $("#request").find("li#navTabLi2").addClass("active");
     	   $("#request").find("li#navTabLi1").removeClass("active");
     	   $("#request").find('#myTabContent').find('div#2').addClass('active in');
     	   $("#request").find('#myTabContent').find('div#1').removeClass('active in');
     	   $('#notSureAboutInstrumentID').val(true);
     	   
     	   $("#inside").find(".radio-container").show();
     	   $("#inside").find(".label-container").hide();
     	   $("#inside").hide();
     	   $("#outside").find(".radio-container").show();
     	   $("#outside").find(".label-container").hide();
     	   $("#outside").hide();
     	   $('#2').find('input[type=radio]').attr('checked',false);
     	   $("#ins").show();
        }else if($(this).attr("id") == 'req'){
     	   $("#request").find("li#navTabLi1").addClass("active");
     	   $("#request").find("li#navTabLi2").removeClass("active");
     	   $("#request").find('#myTabContent').find('div#1').addClass('active in');
     	   $("#request").find('#myTabContent').find('div#2').removeClass('active in');
     	   $('#notSureAboutInstrumentID').val(false);
        }
	});
	
	$('.inputBoxMS').attr('style', function(i, style) {
	    return style.replace(/width[^;]+;?/g, '');
	});
	
	/**
	 * To Close Create Request Model window.  
	 */
	$('body').off('click', '.reqclose').on('click', '.reqclose', function(e){
     $("#request").hide();
	});
	
	/**
	 * This is used to close Success message
	 */
	$('body').off('click', '.successclose').on('click', '.successclose', function(e){
		$(e.target).closest("#siteMsg").hide();
		$(".delegateSuccess").text("");
	});
	
	/**
	 * This is used to close failure message of Group creation
	 */
	$('body').off('click', '.failureClose').on('click', '.failureClose', function(e){
		$(e.target).closest(".groupName-invalid").hide();
		$(".groupInvalid").text("");
	});
	
	getCurrencyAutocompleterName();
	/**
	 * To get Look-up details  
	 */
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
  		var lookupField = $(e.target).siblings(".lookup-filterValue");
  		var bankCountryCd  = $(e.target).siblings(".bankCountryCode").val();
  		var bankCountryCodeField = $(e.target).siblings(".bankCountryCode");
  		var bankCountryNameField = $(e.target).siblings(".bankCountryName");
  		var bankCountryName = '';
  		var bankCity  = $(e.target).siblings(".bankCityName").val();
  		var bankCityField  = $(e.target).siblings(".bankCityName");
  		var userDataLookup = $(e.target).siblings('.businessContactClass').val();
  		if(dataValue == undefined && $(e.target).siblings(".lookup-filterValue").length == 0){
  			dataValue = $(e.target).closest('.form-row').find('.lookup-filterValue').val();
  			userDataLookup = $(e.target).closest('.form-row').find('.businessContactClass').val();
  			lookupField = $(e.target).closest('.form-row').find('.lookup-filterValue');
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
  				if(dataValue.indexOf(",") == -1){
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
  						}
  					}else {
  	  					$(lookupError).text("Please provide SSO(at least 7 digits) / LastName , FirstName (at least 2 characters each )").removeClass("hide").addClass("show");
  		  				return false;
  	  				}
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
  				data: {filterValue : $.trim(dataValue), bankCountryCd : bankCountryCd, bankCountry : bankCountryName, bankCity : $.trim(bankCity), scrollTopValue:scrollTopValue},
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
  					$(lookupField).val('');
  					$(bankCountryCodeField).val('');
  					$(bankCountryNameField).val('');
  					$(bankCountryNameField).siblings('.ui-autocomplete-input').val('');
  					$(bankCityField).val('');
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
	
	$('body').off('keyup', '.autosze50').on('keyup', '.autosze50', function(e) {
		if($(e.target).val()!=undefined){
			var cnt = $(e.target).val().length;
			var remainingchar50 = 50 - cnt;
			if (cnt > 50) {
				var string = $(e.target).val();
				string = string.substring(0,50);
			}
			$(e.target).parents('div.txtCnt').find('.counter').text(remainingchar50);
		}
	});
	
	onloadSiteTypeScripts();

	/**
	 * Cancel Pop-up
	 */
	$('body').off('click', 'a.clearEntries').on('click', 'a.clearEntries', function(e) {
		$('#clearEntries').modal({show: 'true'}).css("margin-top","100px;"); 
	});

	/**
	 * Bank Swift Configuration if it is Yes
	 */
	$('body').off('click', '.messageSupport_Yes').on('click', '.messageSupport_Yes', function(e) {
		if($(e.target).is(':checked'))  {
			var msgType = $(e.target).parents('tr').find('.msgType').val();
			var msgDir = $(e.target).parents('tr').find('.messageDirClass');

			if(msgType!=undefined){
				if(msgType == '1' || msgType == '6'){
					$(msgDir).show();
				}else if(msgType == '2' || msgType == '4' || msgType == '7' || msgType == '9'){
					$(msgDir).show();
					$(msgDir).val('Outbound');
				}else if(msgType == '3' || msgType == '5' || msgType == '8' || msgType == '10'){
					$(msgDir).show();
					$(msgDir).val('Inbound');
				}
			}
		}
	});

	onloadBankSite();

	$('body').off('click', '.messageSupport_No').on('click', '.messageSupport_No', function(e) {
		if($(e.target).is(':checked'))  {
			$(e.target).parents('tr').find('.messageDirClass').hide();
			$(e.target).parents('tr').find('.messageDirClass').val("");
		}
	});

	$('body').off('click', '#headerSiteOnly_true').on('click', '#headerSiteOnly_true', function(e) {
		headerSiteTrue();
	});
	
	$('body').off('click', '#headerSiteOnly_false').on('click', '#headerSiteOnly_false', function(e) {
		headerSiteFalse();
	});
	
	/**
	 * Swift Enabled Table show/hide
	 */
	$('body').off('click', '#swiftEnabled_true').on('click', '#swiftEnabled_true', function() {
		$("#verify").show();
		$("#bankSwiftDiv").show();
	});
	
	$('body').off('click', '#swiftEnabled_false').on('click', '#swiftEnabled_false', function() {
		$("#verify").hide();
		$("#fileActEnabled").attr("checked", false);
		$("#bankSwiftDiv").hide();
		
		$('.messageSupport_Yes').each(function(index){
			var a = $(this).is(":checked");
			if(a!=undefined && a == true){
				$(this).parents('tr').find('.messageDirClass').hide();
				$(this).parents('tr').find('.messageDirClass').val("");
			}
		});
		
		$('#bankSwiftDiv').find('input[type=radio]').attr('checked',false);
	});

	/**
	 * After Group Save
	 */
	$.subscribe('afterSaveGroup', function(event,data) {
		$('#saveGroup').val("");
		groupOperationsSuccess();
	});

	$.subscribe('saveGroupValCheck', function(event,data) {
		event.preventDefault();
		var groupVal = $('#saveGroup').val();
		if(groupVal == undefined || ($.trim($('#saveGroup').val())) == ''){
			$(".groupName-error").text("Group Name cannot be blank.").removeClass("hide").addClass("show");
			$('#processDelegation').hide();
			$('#saveGroup').val("");
			event.originalEvent.options.submit = false;
		}else{
			$(".groupName-error").empty().addClass("hide").removeClass("show");
			return true;
		}
	});
	
	/**
	 * After Group Deletion
	 */
	$.subscribe('deleteGroupValCheck', function(event,data) {
		event.preventDefault();
		var groupId = $('#selectedGroupName').val();
		if(groupId == undefined || ($.trim(groupId)) == ''){
			$(".groupRemove-error").text("Please select group to delete.").removeClass("hide").addClass("show");
			$('#groupProcess').hide();
			event.originalEvent.options.submit = false;
		}else{
			$(".groupRemove-error").empty().addClass("hide").removeClass("show");
			return true;
		}
	});
	
	$.subscribe('afterGroupDeletion', function(event,data) {
		$("#saveApprovers").hide();
		groupOperationsSuccess();
		$("#selectedGroupName").val("");
	});

	$.subscribe('ignoreParentSites', function(event,data) {
		event.preventDefault();
		$('.ignoreParentSites').val("true");

	});

	$.subscribe('createSiteService', function(event,data) {
		event.preventDefault();
		$('.ignoreParentSites').val("false");

	});

	$.subscribe('enableToggles', function(event,data) {
		var editModeCon = $('#editModeCon').val();
		if(editModeCon!=undefined && editModeCon == 'true'){
			$('#defaultDeliveryInstructions').attr('disabled', false);
			$('#customizedSiteReferences').attr('disabled', false);
			$('#delegationConfiguration').attr('disabled', false);
		}
		if($('#headerSiteOnly_true').is(':checked')){
			var validationSuccess = $('#createSiteValidateId').val();
			if(validationSuccess!=undefined && validationSuccess != 'false'){
				window.location.href = contextURL+'/int/siteadmin/cancel.action';
			}
		}
	});

	$('body').off('click', '#deliveryType_false').on('click', '#deliveryType_false', function(e) {
		$('#pDelivery').slideDown('fast');
	});

	$('body').off('click', '#deliveryType_true').on('click', '#deliveryType_true', function(e) {
		$('#pDelivery').slideUp('fast');
	});
	
	$.subscribe('redirectToPortalPage', function(event,data) {
		var validationSuccess = $('#validationSuccessId').val();
		if(validationSuccess!=undefined && validationSuccess != 'false'){
			window.location.href = contextURL+'/int/siteadmin/cancel.action';
		}
	});
	
	$.subscribe('redirectToPortalPageBankSite', function(event,data) {
		var validationSuccess = $('#createSiteValidateId').val();
		if(validationSuccess!=undefined && validationSuccess != 'false'){
			window.location.href = contextURL+'/int/siteadmin/cancel.action';
		}
	});
	
	$('body').off('change', '#sendElectronicCopy').on('change', '#sendElectronicCopy', function(e) {
		var val = $(e.target).is(':checked');
		if(val != undefined && val == true){
			$('#Recipient').show();
		}else{
			$('#Recipient').hide();
			$('#recipientShow').hide();
			$('#recipientClear').hide();
			$('#recipientLastName').val("");
			$('#recipientFirstName').val("");
			$('#recipientSsoId').val("");
			$('#recipientEmail').val("");
			$('#recipient').val("");
		}
	});
	
	onloadDeliveryTypeShow();
	
	/**
	 * When Click on Create Site show/hide related Divs
	 */
	if(!$('#CreateSiteRadioBut').attr('handlerRegistered')) {
		$('body').off('click', '#CreateSiteRadioBut').on('click', '#CreateSiteRadioBut', function() {
			$("#allSiteSections").hide();
			hideAll();

			$("#allSiteSections").find('input').val("");
			$("#allSiteSections").find('textarea').val("");
			$("#allSiteSections").find('radio').val("");
			$("#allSiteSections").find('select').val("");

			$('#modifySiteToggle').hide();
			$('#create').removeClass("hide");
			$('#copy').hide();

			$('#createNewSite').show();
			$('#createNewSitePanel').show();

			hideContainers2To6();

			$("#createSiteRadioProcess").show();
			url = contextURL+'/int/siteadmin/openCreateSite.action';
			$("#allSiteSections").load(url, function(){
				$("#createSiteRadioProcess").hide();
				$("#allSiteSections").show();
			});
			SiteTypeCreate();
		});
		$('#CreateSiteRadioBut').attr('handlerRegistered', true);
	}

	/**
	 * When Click on Modify Site show/hide related Divs
	 */
	if(!$('#ModifySiteRadioBut').attr('handlerRegistered')) {
		$('body').off('click', '#ModifySiteRadioBut').on('click', '#ModifySiteRadioBut', function() {
			$('#copy').hide();
			hideAll();
			$('#createNewSitePanel').hide();
			$('#create').addClass("hide");
			$('#modifysiteTypes').find('option:eq(0)').attr('selected', true);
			$('#modifySiteToggle').show();
			$('#modify').show();
			$('#siteIds').hide();

			$(".acc_trigger1").hide();
			$(".acc_trigger1").next('hr.h2-hr').hide();
			hideTriggers2To6();
			hideContainers2To6();
		});
		$('#ModifySiteRadioBut').attr('handlerRegistered', true);
	}

	SiteTypeCreate();

	onloadParentSiteService();
	
	$('body').off('change', '#parentsites').on('change', '#parentsites', function() {
		var parentSiteId = $('#parentsites').val();
		if(parentSiteId!=undefined){
			if(parentSiteId!="" && parentSiteId!="0"){
				getParentsiteDetails(parentSiteId);
			}else{
				$('#pDescContentCreate').hide();
				$("#parentDescription").val("");
				$("#parentPrefix").val("");
				$('#childSites').hide();
			}
		}
	});
	
	$('body').off('change', '#siteType').on('change', '#siteType', function() {
		
		url = contextURL+'/int/siteadmin/refreshSiteTypeDetails.action';
		$("#createSiteDiv").load(url, function(){
			
			showParentSites();
			
			$("#createSiteDiv").show();
			var siteType = $('#siteType').val();
			if(siteType != undefined && siteType == '3'){
				$("#LEMandatoryId").removeClass("hide");
				$("#LEOpionalId").addClass("hide");
			}else{
				$("#LEMandatoryId").addClass("hide");
				$("#LEOpionalId").removeClass("hide");
			}
			if(siteType!=undefined && (siteType=='2' || siteType == '5')){
				$('#createSiteSaveBut').hide();
				$('#createSiteCancel').hide();
				if(siteType!=undefined && (siteType=='2')){
					$('#bankFeePaymentSetup').show();
					$('#bankFeePaymentSetupPanel').show();
				}
				$('#bankSwiftConfig').show();
				$('#bankSwiftConfigPanel').show();

			}else{
				$('#createSiteSaveBut').show();
				$('#createSiteCancel').show();

				$('#bankFeePaymentSetup').hide();
				$('#bankFeePaymentSetupPanel').hide();
				$('#bankSwiftConfig').hide();
				$('#bankSwiftConfigPanel').hide();
			}
			SiteTypeCreate();
		});
	});

	/**
	 * Verify Site Name valid or Not
	 */
	$('body').off('change', '#siteName').on('change', '#siteName', function() {
		var siteName = $('#siteName').val();
		if(siteName != undefined && siteName != ''){
			$('#matched').hide();
			$('#unMatched').hide();
			$('.siteNameStr').text("");
			$('#siteNameProcess').show();
			$.ajax({
				type: "POST",
				url: contextURL+'/int/siteadmin/checkSiteNameValid.action',
				dataType: 'json',
				data: { siteName : siteName },
				processdata: true,
				success: function(data) {
					if(data.result.length > 0){
						if((data.result[0].siteNameVal).indexOf("Already Existed") != -1){
							$('#matched').hide();
							$('#unMatched').show();
							$('.siteNameStr').text("Invalid Site Name");
						}else{
							$('#matched').show();
							$('#unMatched').hide();
							$('.siteNameStr').text("Valid Site Name");
						}
					}
					$('#siteNameProcess').hide();
				}
			});
		}else{
			$('#matched').hide();
			$('#unMatched').hide();
			$('.siteNameStr').text("");
		}
	});


	/**
	 * Delegation Config Instruments Disabled related Script
	 */
	$('body').off('click', '.instr').on('click', '.instr', function(e) {
		var instChkCnt = 0;
		var instNtChkCnt = 0;
		$(e.target).closest('tr').find('.instr').each(function() {
			var instrTypeId = $(this).val();
			if(instrTypeId!=undefined){
				if((instrTypeId == '1' || instrTypeId == '2' || instrTypeId == '5') && $(this).is(":checked")){
					instNtChkCnt = instNtChkCnt + 1;
				}
				if((instrTypeId == '3' || instrTypeId == '6') && $(this).is(":checked")){
					instChkCnt = instChkCnt + 1;
				}
			}
		});
		if(instNtChkCnt == 0 && instChkCnt !=0){
			$(e.target).closest("tr").find(":input.radio").attr('checked', false);
			$(e.target).closest("tr").find('.notificationCaluseFlag')[0].checked = true;
			$(e.target).closest("tr").find('.curePeriodIndicatorFlag')[0].checked = true;
			$(e.target).closest("tr").find('.geAppDrawFlag')[0].checked = true;
			$(e.target).closest("tr").find(":input.radio").attr('disabled', true);
		}else{
			$(e.target).closest("tr").find(":input.radio").attr('disabled', false);
		}
		$(e.target).closest('tr').find('.insChktd').find('.instrCheckBox').prop('checked', false);
	});  


	onloadDelegateConfigRowEach();

	/**
	 * Delegation Config select All instruments when click on All Check Box
	 */
	$('body').off('click', '.instrCheckBox').on('click', '.instrCheckBox', function(e) {
		if($(e.target).is(":checked")){
			$(e.target).closest("tr").find(':checkbox').attr('checked',true);
		}else{
			$(e.target).closest("tr").find(':checkbox').attr('checked',false);
		}
		$(e.target).closest("tr").find(":input.radio").attr('disabled', false);
	});

	/**
	 * Check the Site Prefix is valid or Not
	 */
	$('body').off('change', '#sitePrefix').on('change', '#sitePrefix', function() {
		var sitePrefix = $('#sitePrefix').val();
		if(sitePrefix != undefined && sitePrefix != ''){
			$('#prefixMatched').hide();
			$('#prefixUnMatched').hide();
			$('#sitePrefixProcess').show();
			$('.sitePrefixStr').text("");
			
			var alphaNumeric = /^[a-zA-Z0-9]+$/;
			var result = alphaNumeric.test(sitePrefix);
			
			if(result == true){
				$.ajax({
					type: "POST",
					url: contextURL+'/int/siteadmin/checkSitePrefixValid.action',
					dataType: 'json',
					data: { sitePrefix : sitePrefix },
					processdata: true,
					success: function(data) {
						if(data.result.length > 0){
							if((data.result[0].sitePrefixVal).indexOf("Already Existed") != -1){
								$('#prefixMatched').hide();
								$('#prefixUnMatched').show();
								$('.sitePrefixStr').text("Invalid Site Prefix");
							}else{
								$('#prefixMatched').show();
								$('#prefixUnMatched').hide();
								$('.sitePrefixStr').text("Valid Site Prefix");
							}
						}
						$('#sitePrefixProcess').hide();
					}
				});
			}else{
				$('#prefixMatched').hide();
				$('#prefixUnMatched').show();
				$('.sitePrefixStr').text("Invalid Site Prefix");
				$('#sitePrefixProcess').hide();
			}
		}else{
			$('#prefixMatched').hide();
			$('#prefixUnMatched').hide();
			$('.sitePrefixStr').text("");
		}
	});

	/**
	 * Get the copy Site details
	 */
	if(!$('#selectSiteName').attr('handlerRegistered')) {
		$('body').off('change', '#selectSiteName').on('change', '#selectSiteName', function() {
			var selectSiteName = $('#selectSiteName').val();

			$("#allSiteSections").hide();
			$("#copySiteDetProcess").show();
			url = contextURL+'/int/siteadmin/getCopySiteDetails.action';
			$("#allSiteSections").load(url,{selectSiteName : selectSiteName}, function(){
				$("#copySiteDetProcess").hide();
			});
			$("#allSiteSections").show();
		});
		$('#selectSiteName').attr('handlerRegistered', true);
	}

	/**
	 * Click on Copy Site Show/ Hide all related divs
	 */
	if(!$('#CopySiteRadioBut').attr('handlerRegistered')) {
		$('body').off('click', '#CopySiteRadioBut').on('click', '#CopySiteRadioBut', function() {
			$('#copySiteProcess').show();
			hideAll();
			$('#createNewSitePanel').hide();

			$('#create').addClass("hide");
			$('#copy').show();
			$('#modifySiteToggle').hide();

			$(".acc_trigger1").hide();
			$(".acc_trigger1").next('hr.h2-hr').hide();
			hideTriggers2To6();
			hideContainers2To6();
			$('#copySiteInt').show();
			$('#siteNameCopy').hide();

			getSitenamesCopy();
		});
		$('#CopySiteRadioBut').attr('handlerRegistered', true);
	}

	/**
	 * Method to get the Modify Site details
	 */
	if(!$('#modifysiteTypes').attr('handlerRegistered')) {
		$('body').off('change', '#modifysiteTypes').on('change', '#modifysiteTypes', function() {
			var modifysiteTypes = $('#modifysiteTypes').val();
			if(modifysiteTypes != undefined && modifysiteTypes != ""){
				showSites();
				hideAllSections();
			}else if(modifysiteTypes != undefined && modifysiteTypes == ""){
				$("#siteIds").hide();
				$("#modifySites").hide();
				$('#allSiteSection').hide();
				hideAllSections();
			}

		});
		$('#modifysiteTypes').attr('handlerRegistered', true);
	}

	/**
	 * To display Modify Site sections
	 */
	if(!$('#modifySites').attr('handlerRegistered')) {
		$('body').off('change', '#modifySites').on('change', '#modifySites', function() {
			var siteId = $('#modifySites').val();
			if(siteId != undefined && siteId != ""){
				$("#modifySiteIdProcess").show();

				$("#allSiteSections").hide();
				url = contextURL+'/int/siteadmin/getModifySiteDetails.action';
				$("#allSiteSections").load(url,{siteId : siteId}, function(){
					$("#modifySiteIdProcess").hide();
				});
				$("#allSiteSections").show();
			}else{
				hideAllSections();
			}
		});
		$('#modifySites').attr('handlerRegistered', true);
	}

	$('#bankswiftTbl tbody tr:odd').addClass("odd");

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//	SITEADMIN DELEGATION SCRIPT
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	$('body').off('click', '.add-delegationGroup').on('click', '.add-delegationGroup', function(e) {
		var delegateConfigRow = $(e.target).parents('.delegateConfigRow');
		var delegationIndex = $(delegateConfigRow).find('.delegationIndex').val();
		var newGroupLevelField = $(delegateConfigRow).find('.newGroupLevel');
		var newGroupLevel = parseInt($(newGroupLevelField).val());
		var groupTable = $(e.target).siblings('table');
		var levelIndex = ($(groupTable).find('.groupAssignment').length - $(groupTable).find('.groupAssignment.deleted').length) + 1;
		$(groupTable).find('tr:last').after('<tr class="groupAssignment newDelegateConfigGroup"></tr>');
		var url = contextURL+'/int/siteadmin/addGroup.action';
		var data = {
					'newGroupLevel' : newGroupLevel,
					'delegationIndex' : delegationIndex,
					'levelIndex' : levelIndex,
					'uid' : new Date().getTime()
					};
		var newDelegateConfigGroup = $('.newDelegateConfigGroup');
		$(newDelegateConfigGroup).load(url,data).removeClass('newDelegateConfigGroup');
		$(newGroupLevelField).val(newGroupLevel + 1); // increment newGroupLevel
	});

	/**
	 * Removes delegation group
	 */
	$('body').off('click', '.remove-delegGroup').on('click', '.remove-delegGroup', function(e) {
		var assighmentGroupRow = $(e.target).parent().parent();
		$(assighmentGroupRow).find('.groupOpcode').val('DELETE');
		$(assighmentGroupRow).addClass('deleted');
		$(assighmentGroupRow).hide();

		// Reset levels
		var assignmentGroupTable = $(e.target).parents('table')[0];
		resetGroupLevels(assignmentGroupTable);
	});

	/**
	 * Adds Delegation Configuration
	 */
	$('body').off('click', '.add-delegationconfig').on('click', '.add-delegationconfig', function() {
		var newDelegationIndex = parseInt($('#newDelegationIndex').val());
		$("table#delegationConfigurations").children('tbody').children("tr:last").after('<tr class="delegateConfigRow newDelegationConfig"></tr>');
		var url = contextURL+'/int/siteadmin/delegationConfig.action';
		var data = {
					'newDelegationIndex' : newDelegationIndex,
					'uid' : new Date().getTime()
					};
		$('.newDelegationConfig').load(url,data).removeClass('newDelegationConfig');

		$('#newDelegationIndex').val(newDelegationIndex + 1);
	});

	/**
	 * Deletes Delegation Configuration
	 */
	$('body').off('click', '.delete-delegationconfig').on('click', '.delete-delegationconfig', function(e) {
		var parentRow = $(e.target).parents('tr');
		var deletedFormControl = $(parentRow).find('.deleteConfig');
		$(deletedFormControl).val('true');
		$(parentRow).hide();

		if ($.browser.msie) {
			tableBody = $(e.target).parents('tbody');
			tableBody.find('.even').removeClass('even');
			tableBody.find('tr:even').addClass('even');//dumb ie 
		}
	});
	
	/**
	 * Textarea 400 Char Counter 
	 */
	$('body').off('keyup', '.autosize').on('keyup', '.autosize', function(e) {
		if($(e.target).val()!=undefined){
			var cnt = $(e.target).val().length;
			var remainingchar30 = 400 - cnt;
			if (cnt >= 400) {
				var string = $(e.target).val();
				string = string.substring(0,400);
			}
			$(e.target).parents('div.txtCnt').find('.counter').text(remainingchar30);
		}
	});

	autoTextarea();
	autoTextarea50();
	
	/**
	 * Remove the Content from AutoCompleter when we clear the Field
	 */
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
		event.stopPropagation();
	});

});

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

/**
 * Get All the Site Name  When click on the Copy Site Radio Button
 */
function getSitenamesCopy(){
	$.ajax({
		type: "POST",
		url: contextURL+'/int/siteadmin/getSiteNames.action',
		dataType: 'json',
		data: {},
		processdata: true,
		success: function(data) {
			$("#selectSiteName").empty().append("<option value=''>Select...</option>");
			for (var i = 0; i < data.result.length; i++) {
				$("#selectSiteName").append("<option value='" + data.result[i].id + "'>" + data.result[i].name + "</option>");
			}
			$('#siteNameCopy').show();
			$('#copySiteProcess').hide();
		}
	});
}

/**
 * Hide All when suffle the Create/Copy/Modify Radio Buttons
 */
function hideAll(){
	$("#counterSiteName").text(50);
	$("#counterDesc").text(50);

	$('#matched').hide();
	$('#unMatched').hide();
	$('.siteNameStr').text("");
	$('#siteNameProcess').hide();

	$('#prefixMatched').hide();
	$('#prefixUnMatched').hide();
	$('.sitePrefixStr').text("");
	$('#sitePrefixProcess').hide();
}

/**
 * Hide All sections when Site Type changed in Modify Mode
 */
function hideAllSections(){
	$(".acc_trigger1").hide();
	$(".acc_trigger1").next('hr.h2-hr').hide();
	hideTriggers2To6();
	$(".acc_container1").hide();
	hideContainers2To6();	
}

/**
 * To get all SiteNames and SiteIds
 */
function showSites() {
	var modifysiteTypes = $('#modifysiteTypes').val();
	$("#modifySiteProcess").show();

	$.ajax({
		type: "POST",
		url: contextURL+'/int/siteadmin/getAvailSites.action',
		dataType: 'json',
		data: { modifysiteTypes : modifysiteTypes},
		processdata: true,
		success: function(data) {
			$("#modifySites").empty().append("<option value=''>Select...</option>");
			for (var i = 0; i < data.result.length; i++) {
				$("#modifySites").append("<option value='" + data.result[i].id + "'>" + data.result[i].prefix + " - " + data.result[i].name + "</option>");
			}
			$("#siteIds").show();
			$("#modifySites").show();
			$("#modifySiteProcess").hide();
		}
	});
}

/**
 * Show/Hide Toggles when we change the Site Type
 */
function SiteTypeCreate(){
	var val = $('#siteType').val();
	if(val!=undefined && val!=""){
		if (val == "1" || val == "4") {
			if(!$('#headerSiteOnly_true').is(':checked')){
				$("#reqChkBox").show();
			}
			$("#save").hide();
			$("#bic").hide();

			$("#BankNameCreate").hide();
			$("#LegalGoldCreate").show();
			$("#parentSiteCreate").show();

			$("#HeaderCreate").show();
			$("#headerSiteCreate").hide();
			$(".acc_trigger4").hide();
			$(".acc_trigger4").next('hr.h2-hr').hide();
			
			if($('#headerSiteOnly_true').is(':checked') == false && $('#headerSiteOnly_false').is(':checked') == false){
				$(".acc_trigger5").hide();
				$(".acc_trigger5").next('hr.h2-hr').hide();
				$(".acc_trigger2").hide();
				$(".acc_trigger2").next('hr.h2-hr').hide();
				$(".acc_trigger3").hide();
				$(".acc_trigger3").next('hr.h2-hr').hide();
			}
				
			$(".acc_trigger6").hide();
			$(".acc_trigger6").next('hr.h2-hr').hide();
			$("#triPartyCreate").hide();   
			$("#privateCreate").hide();
			
			$("#buc").show();
			$("#adn").show();
		}
		if (val == "3" ) {
			$("#reqChkBox").hide();
			$("#requestCheck").prop('checked', false);
			$("#save").hide();
			$("#bic").hide();

			$("#BankNameCreate").hide();
			$("#LegalGoldCreate").show();
			$("#HeaderCreate").hide();
			$("#headerSiteCreate").hide();
			$(".acc_trigger2").hide();
			$(".acc_trigger3").hide();
			$(".acc_trigger4").hide();
			$(".acc_trigger6").hide();
			$(".acc_trigger2,.acc_trigger3,.acc_trigger4,.acc_trigger6").next('hr.h2-hr').hide();
			$(".acc_trigger5").show();
			$(".acc_trigger5").next('hr.h2-hr').show();
			$("#parentSiteCreate").hide();   
			$("#triPartyCreate").hide();
			$("#privateCreate").hide();
			
			$("#buc").show();
			$("#adn").hide();
		}
		if (val == "2" || val == "5") {    
			$("#save").hide();

			$("#BankNameCreate").show();
			$("#LegalGoldCreate").hide();
			$("#HeaderCreate").hide();
			$("#headerSiteCreate").show();

			$(".acc_trigger2").hide();
			$(".acc_trigger3").hide();
			$(".acc_trigger2,.acc_trigger3,.acc_trigger5").next('hr.h2-hr').hide();
			$("#reqChkBox").hide();
			$("#requestCheck").prop('checked', false);
			if(val == "5"){
				$("#bankFeePaymentSetupPanel").hide();
				$("#bankFeePaymentSetupSection").hide();
				$("#bankFeePaymentSetup").hide();
				$("#bankFeePaymentSetup").next('hr.h2-hr').hide();
				$("#triPartyCreate").hide();
				$("#privateCreate").hide();
			}else{
				$("#bankFeePaymentSetupPanel").show();
				$("#bankFeePaymentSetupSection").show();
				$("#bankFeePaymentSetup").show();
				$("#bankFeePaymentSetup").next('hr.h2-hr').show();
				$("#triPartyCreate").show();
				$("#privateCreate").show();
			}
			$("#bankSwiftConfigPanel").show();
			$("#bankSwiftConfigSection").show();
			var bankSelection  = $('#bankSelectionId').val();
			var modifySite = $("#modifySite").val();
			var copySite = $("#copySite").val();
			if(modifySite!=undefined && modifySite == "true" && ((bankSelection!=undefined || bankSelection == "")&& bankSelection != "New")){
				$('#bankSelectionId').val("Selected");
			}else if(copySite!=undefined && copySite == "true" && ((bankSelection!=undefined || bankSelection == "")&& bankSelection != "New")){
				$('#bankSelectionId').val("Selected");
			}
			$(".acc_trigger5").hide();
			$(".acc_trigger6").show();
			$(".acc_trigger6").next('hr.h2-hr').show();
			$("#parentSiteCreate").show();
			$("#bic").hide();
			
			$("#buc").hide();
			$("#adn").hide();
		}
	}
}

/**
 * Show All the parent Sites
 */
function showParentSites() {
	var val = $('#siteType').val();
	var siteId = $('#siteId').val();
	$('#pDescContentCreate').hide();
	$("#parentDescription").val("");
	$("#parentPrefix").val("");
	$('#childSites').hide();
	if(val!=undefined && val !=""){
		if(val != '3'){
			$('#parentSiteProcess').show();
			$.ajax({
				type: 'POST',
				url: contextURL+'/int/siteadmin/loadParentSites.action',
				dataType: 'json',
				data: { modifysiteTypes : val , siteId : siteId},
				processdata: true,
				success: function(data) {
					$("#parentsites").empty().append("<option value=''>Select...</option>");
					var pSiteId = $('#parentSiteIdDet').val();
					for (var i = 0; i < data.result.length; i++) {
						if(pSiteId!=undefined && pSiteId == data.result[i].id){
							$("#parentsites").append("<option value='" + data.result[i].id + "' selected>" + data.result[i].name + "</option>");
						}else {
							$("#parentsites").append("<option value='" + data.result[i].id + "'>" + data.result[i].name + "</option>");
						}
					}
					$('#parentSiteProcess').hide();
				}
			});
		}
	}
}

/**
 * Get the Parent Site Details
 */
function getParentsiteDetails(val) {
	var siteType = $('#siteType').val();
	if(siteType!=undefined && val!=undefined){
		$('#parentSiteDescProcess').show();
		$.ajax({
			type: "POST",
			url: contextURL+'/int/siteadmin/getDescPrefixParentSites.action',
			dataType: 'json',
			data: { parentSiteId : val},
			processdata: true,
			success: function(data) {
				if(data.result!=undefined){
					$('#pDescContentCreate').show();
					$("#childTableId").find('tbody').empty();
					var addCls = "";
					for (var i = 0; i < data.result.length; i++) {
						if(data.result[0].id == null || data.result[0].id == ""){
							$("#parentDesc").text("");
							$("#parentDescription").val("");
						}else{
							$("#parentDesc").text(data.result[0].id);
							$("#parentDescription").val(data.result[0].id);
						}

						if(data.result[0].name == null || data.result[0].name == ""){
							$("#parentPrefixDiv").text("");
							$("#parentPrefix").val("");
						}else{
							$("#parentPrefixDiv").text(data.result[0].name);
							$("#parentPrefix").val(data.result[0].name);
						}
						if(data.result[i].childSites!=undefined){
							var siteCode = data.result[i].siteCode;
							var designation = data.result[i].designation;
							if(siteCode == null){	siteCode = "-";}
							if(designation == null){	designation = "-";}

							if(i%2 == 0){ addCls = "odd"; }else{ addCls = ""; }

							$('#childSites').show();
							$("#childTableId").find('tbody').append('<tr class='+addCls+'><td>'+siteCode+'</td><td>'+data.result[i].childSites+'</td><td>'+designation+'</td></tr>');
						}else{
							$('#childSites').hide();
						}
					}
				}
				$('#parentSiteDescProcess').hide();
			}
		});
	}
}

/**
   Get the Current Approvers
 */
function getCurrentAvailApprovers(groupId) {
	$('#groupProcess').show();
	$.ajax({
		type: "POST",
		url: contextURL+'/int/siteadmin/getCurrentApprovers.action',
		dataType: 'html',
		data: { groupId : groupId},
		processdata: true,
		success: function(data) {
			$('#SelectedApp').empty().append(data);
			$('#SelectedApp').show();
			$('#saveApprovers').show();
			$('#groupProcess').hide();
		}
	});
}

/**
 * Show Toggles Header Site True
 */
function headerSiteTrue(){
	$("#headerSiteCreate").hide();
	hideTriggers2To6();
	$("#saveBtn").show();
	$("#reqChkBox").hide();
	$("#requestCheck").prop('checked', false);
}

/**
 * Hide Toggle Header Site False
 */
function headerSiteFalse(){
	$(".acc_trigger2").show();
	$(".acc_trigger3").show();
	$(".acc_trigger5").show();
	$(".acc_trigger4").hide();
	$(".acc_trigger6").hide();
	$(".acc_trigger4,.acc_trigger6").next('hr.h2-hr').hide();
	$(".acc_trigger2,.acc_trigger3,.acc_trigger5").next('hr.h2-hr').show();
	$("#saveBtn").show();
	$("#reqChkBox").show();
}

/**
 * get the approvers for the Delegation
 */
function getApprovers(){
	var groupId = $('#selectedGroupName').val();
	$(".groupRemove-error").empty().addClass("hide").removeClass("show");
	if(groupId != undefined && groupId != ""){
		getCurrentAvailApprovers(groupId);
	}else if(groupId == ""){
		$("#saveApprovers").hide();
		$('#SelectedApp').empty();
		$('#SelectedApp').hide();
		$('#businessDelegates').hide();
	}
}

/**
 * Decrease the Counter Value
 * @param id
 * @param fullLength
 */
function decCounter(id,fullLength){
	var txtAreaVal = $('#'+id).val(); 
	if(txtAreaVal!=undefined && txtAreaVal!=""){
		var txtAreaValLen = txtAreaVal.length;
		txtAreaValLen = fullLength-txtAreaValLen;
		$('#'+id).siblings('.counter').text(txtAreaValLen);
	}
}

// TEXTAREA MAX LENGTH
function imposeMaxLength(Object, MaxLen){
	return (Object.value.length <= MaxLen);
}

/**
 * Resets the levels of all groups in Delegation
 */
function resetGroupLevels(groupTable) {
	var levelCounter = 1;
	$(groupTable).find('.groupAssignment').each(function() {
		if(!$(this).hasClass('deleted')) {
			$(this).find('.groupLevelDisplayHolder').html(levelCounter);
			$(this).find('.groupLevel').val(levelCounter);
			levelCounter++;
		} 
	});
}

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
 * auto expanding text area
 */
function autoTextarea50(){
	$('textarea.autosze50').autoResize({
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
 * Hide the containers from 2 to 6
 */
function hideContainers2To6(){
	$(".acc_container2").hide();
	$(".acc_container3").hide();
	$(".acc_container4").hide();
	$(".acc_container5").hide();
	$(".acc_container6").hide();
}

/**
 * Hide the triggers from 2 to 6
 */
function hideTriggers2To6(){
	$(".acc_trigger2").hide();
	$(".acc_trigger3").hide();
	$(".acc_trigger4").hide();
	$(".acc_trigger5").hide();
	$(".acc_trigger6").hide();
	$(".acc_trigger2,.acc_trigger3,.acc_trigger4,.acc_trigger5,.acc_trigger6").next('hr.h2-hr').hide();
	
}

/**
 * Delivery Instructions onload Script
 */
function onloadDeliveryTypeShow(){
	
	$("#saveApprovers").hide();
	
	var deliveryType = $('input[id=deliveryType]:checked').val(); 
	if(deliveryType!=undefined && deliveryType==true){
		$("#Recipient").addClass("hide");
	}else if(deliveryType!=undefined && deliveryType==false) {
		$("#Recipient").removeClass("hide");
	}
	
	var deliveryTypeRadio = $('[name="siteAdmin.deliveryInstructions.deliveryType"]:radio:checked').val();
	if(deliveryTypeRadio != undefined && deliveryTypeRadio == "false"){
		$('#pDelivery').slideDown('fast');
	}

	var ecopyOtherGEPerson = $('[name="siteAdmin.deliveryInstructions.ecopyOtherGEPerson"]:checkbox:checked').val();
	if(ecopyOtherGEPerson != undefined && ecopyOtherGEPerson == "true"){
		$("#Recipient").removeClass("hide");
	}
}

/**
 * Onload ParentSite Service Call & HeaderSite sections Hide/Show
 */
function onloadParentSiteService(){
	
	var siteType = $('#siteType').val();
	if(siteType != undefined && siteType == '3'){
		$("#LEMandatoryId").removeClass("hide");
		$("#LEOpionalId").addClass("hide");
	}else{
		$("#LEMandatoryId").addClass("hide");
		$("#LEOpionalId").removeClass("hide");
	}
	if(siteType!=undefined && siteType!=""){
		var parentSiteService = $('.ignoreParentSites').val();
		if(parentSiteService != undefined && parentSiteService == "true"){
		}else{
			showParentSites();
			$('#parentsites').val($('#parentSiteIdDet').val());
			var parentSiteId = $('#parentSiteIdDet').val();
			if(parentSiteId!=undefined && parentSiteId!="" && parentSiteId!="0"){
				getParentsiteDetails(parentSiteId);
			}	
		}
		if(siteType=='2' || siteType == '5'){
			$('#createSiteSaveBut').hide();
			$('#createSiteCancel').hide();
		}
	}
	if($('#headerSiteOnly_true').is(':checked')){
		headerSiteTrue();
	}else if($('#headerSiteOnly_false').is(':checked')){
		var val = $('#siteType').val();
		if(val != undefined && (val== '1' || val == '4')){
			headerSiteFalse();
		}
		if(val != undefined && val == '3'){
			$(".acc_trigger5").show();
			$(".acc_trigger5").next('hr.h2-hr').show();
		}
	}
}

/**
 * Onload SiteType Radio's check & Sections Disabling
 */
function onloadSiteTypeScripts(){
	var modifySite = $("#modifySite").val();
	var editModeCon = $('#editModeCon').val();
	var copySite = $("#copySite").val();
	if(editModeCon!=undefined && editModeCon != 'true' && modifySite!=undefined  && modifySite != "true"){
		$('#defaultDeliveryInstructions').attr('disabled', true);
		$('#customizedSiteReferences').attr('disabled', true);
		$('#delegationConfiguration').attr('disabled', true);
	}
	if(modifySite!=undefined && modifySite == "true"){
		$('#ModifySite').attr('checked','checked');
		$('#modifySiteToggle').show();
		$('#modify').show();
		$('#siteIds').show();
	}
	if(copySite!=undefined && copySite == "true"){
		$('#CopySite').attr('checked','checked');
		$('#copy').show();
	}
}

/**
 * Onload BankSwift Table & MessageDirections Hide/Show 
 */
function onloadBankSite(){
	var swiftEnabledVal =$('input[id=swiftEnabled_true]:checked').val(); 
	if(swiftEnabledVal!=undefined && swiftEnabledVal == 'true'){
		$("#verify").show();
		$("#bankSwiftDiv").show();
	}
	
	var swiftEnabledVal =$('input[id=swiftEnabled_false]:checked').val(); 
	if(swiftEnabledVal!=undefined && swiftEnabledVal == 'false'){
		$("#bankSwiftDiv").hide();
	}
	
	$('.messageSupport_Yes').each(function(){
		var a = $(this).is(":checked");
		if(a!=undefined && a == true){
			$(this).parents('tr').find('.messageDirClass').show();
		}
	});
}

/**
 * Onload DelegationConfigs Radios Check/Uncheck 
 */
function onloadDelegateConfigRowEach(){
	$('tr.delegateConfigRow').each(function(e){
		var instChkCnt = 0;
		var instNtChkCnt = 0;
		$(this).find('.instr').each(function(e){
			var instrTypeId = $(this).val();
			if(instrTypeId!=undefined){
				if((instrTypeId == '1' || instrTypeId == '2' || instrTypeId == '5') && $(this).is(":checked")){
					instNtChkCnt = instNtChkCnt + 1;
				}
				if((instrTypeId == '3' || instrTypeId == '6') && $(this).is(":checked")){
					instChkCnt = instChkCnt + 1;
				}
			}
		});
		if(instNtChkCnt == 0 && instChkCnt !=0){
			$(this).find(":input.radio").attr('checked', false);
			$(this).find('.notificationCaluseFlag')[0].checked = true;
			$(this).find('.curePeriodIndicatorFlag')[0].checked = true;
			$(this).find('.geAppDrawFlag')[0].checked = true;
			$(this).find(":input.radio").attr('disabled', true);
		}else{
			$(this).find(":input.radio").attr('disabled', false);
		}
	});	
}

/**
 * Onload Buttons Rounded Corners & h2 line Hide/Show
 */
function onloadTooltipsRoundedBut(){
	if (window.PIE) {
        $('.main,.btn,.modalSite').each(function() {
            PIE.attach(this);
        });
    }
	$('.ttip').tooltip({delay: { show: 300, hide: 1 }});
	$('.ttip.chart').tooltip();
	
	$(".acc_trigger2,.acc_trigger3,.acc_trigger4,.acc_trigger5,.acc_trigger6").next('hr.h2-hr').hide();
	var siteType = $('#siteType').val();
	if(siteType != undefined && (siteType == '2' || siteType == '5')){
		$(".acc_trigger4,.acc_trigger6").next('hr.h2-hr').show();
		$(".acc_trigger2,.acc_trigger3,.acc_trigger5").next('hr.h2-hr').hide();
	}else if((siteType != undefined && (siteType == '1' || siteType == '4')) && $('#headerSiteOnly_false').is(':checked')){
		$(".acc_trigger4,.acc_trigger6").next('hr.h2-hr').hide();
		$(".acc_trigger2,.acc_trigger3,.acc_trigger5").next('hr.h2-hr').show();
	}else if(siteType != undefined && siteType == '3'){
		$(".acc_trigger2,.acc_trigger3,.acc_trigger4,acc_trigger6").next('hr.h2-hr').hide();
		$(".acc_trigger5").next('hr.h2-hr').show();
	}
	
	var delegationErrors = $("#delegationErrors").val();
	if(delegationErrors != undefined && delegationErrors == 'available'){
		$('html,body').animate({ scrollTop: $('#saveApprovers').offset().top }, 'fast');
	}
}

/**
 * Group Save/Update/Delete Success/Error Messages display
 */
function groupOperationsSuccess(){
	var createGrpMsg = $("#createGrpSuccess").val();
	//TODO : Need to change the condition when ERROR/SUCCESS changed in BW code. 
	if(createGrpMsg!= undefined && createGrpMsg != "" && createGrpMsg.indexOf("Group Name:") == -1
			&& createGrpMsg.indexOf("More than 20 groups") == -1){
		$(".groupUpdate-success").removeClass("hide").addClass("show");
		$(".delegateSuccess").text(createGrpMsg);
		$(".groupUpdate-success").show();
		$(".groupName-invalid").removeClass("show").addClass("hide");
		$(".groupInvalid").text("");
		$(".groupName-invalid").hide();
	}else if(createGrpMsg.indexOf("Group Name:") != -1
			|| createGrpMsg.indexOf("More than 20 groups") != -1){
		$(".groupName-invalid").removeClass("hide").addClass("show");
		$(".groupInvalid").text(createGrpMsg);
		$(".groupName-invalid").show();
		$(".groupUpdate-success").removeClass("show").addClass("hide");
		$(".delegateSuccess").text("");
		$(".groupUpdate-success").hide();
	}else{
		$(".groupUpdate-success").removeClass("show").addClass("hide");
		$(".delegateSuccess").text("");
		$(".groupUpdate-success").hide();
		$(".groupName-invalid").removeClass("show").addClass("hide");
		$(".groupInvalid").text("");
		$(".groupName-invalid").hide();
	}
}

function decimalAmountZero(){
	 $('.bigDecimal').each(function(){
		var val = $(this).val();
		if(val != undefined && val !="" && val == ".00"){
			$(this).val("0");
		}
	 });
}