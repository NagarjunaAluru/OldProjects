	// Global declaration of spotfireApp object
	var spotfireApp;
	
	$(document).ready(function() {
		var customization = new spotfire.webPlayer.Customization();
		customization.showTopHeader = false;
		customization.showToolBar = false;
		customization.showCustomizableHeader = false;
		customization.showTopHeader = false;
		customization.showClose = false;
		customization.showAnalysisInfo = false;
		customization.showToolBar = false;
		customization.showExportFile = false;
		customization.showExportVisualization = false;
		customization.showUndoRedo = false;
		customization.showDodPanel = false;
		customization.showFilterPanel = false;
		customization.showPageNavigation = false;
		customization.showStatusBar = false;
		
		spotfireApp = new spotfire.webPlayer.Application($("#spotfireWebplayerURLId").val(), customization);
		// Open an analysis.
		spotfireApp.open($("#issuanceExpirationPathId").val(),"webPlayer",'');
		
		var currentDate = $.datepicker.formatDate('mm/dd/yy', new Date());
        $("#issuanceDateTo").val(currentDate.toString());
        $("#expirationDateFrom").val(currentDate.toString());
        var now = new Date();
        now.setDate(now.getDate()+30);
        var newDate1 = $.datepicker.formatDate('mm/dd/yy', now);
        $("#expirationDateTo").val(newDate1.toString());
        
        $('body').off("change",'#accDistributionNumberId ,#businessUnitCodeId').on("change",'#accDistributionNumberId ,#businessUnitCodeId',function(e){
			e.stopPropagation();
			var url = contextURL+"/int/BUCADNLookup.action";
			var bucValue = $('#businessUnitCodeId').val();
			var adnValue = $('#accDistributionNumberId').val();
			var formData = {
				bucValue : bucValue,
				adnValue : adnValue
			};
			if(bucValue != undefined && bucValue != '' && adnValue != undefined && adnValue != ''){
				callBUCADNValidation(url,formData);
			}
		});
        
        // Generate Report Click
        $('body').off('click', '#generateReport').on('click', '#generateReport', function(e) {
		    var expInputDateFrom = $("#expirationDateFrom").val();
 			var expInputDateTo = $("#expirationDateTo").val();
 			var issInputDateFrom = $("#issuanceDateFrom").val();
 			var issInputDateTo = $("#issuanceDateTo").val();
 			
 			$("#checkExpDivId").addClass("hide");
 			$("#expDivId").addClass("hide");
 			$("#issDivId").addClass("hide");
 			$("#expDivId").removeClass("show").addClass("hide");
			$("#issDivId").removeClass("show").addClass("hide");
			$("#dateBorderDivId").css("border","none");
			$("#instrAmtBorderId").css("border","none");
			$("#instrAmtDivId").removeClass("show").addClass("hide");
			$("#fxRateDivId").removeClass("show").addClass("hide");
	   		$("#divFxRateBorderId").css("border","none");
	   		$("#bucAdnDivId").removeClass("show").addClass("hide");
			$('.optOutval-error5').removeClass("show").addClass("hide");
			$("#divBUCADNBorderId").css("border","none");
			
 			if(validateIssuance()){
 				assignValues();
 				$('#blankMessage').css({'display' : 'none'});
        		var url = contextURL +"/int/reports/recordCountForIssuance.action";
     			$.ajax({
     				type: "POST",
     				url: url,
     				dataType: 'json',
     				data: $("#issuanceExpirationform").serialize(),// serializes the form's elements.
     				processdata: true,
     				success: function(response){
     					if((response.data == 0))
     						$('#blankMessage').css({'display' : 'block'});
     				},
     				error: function (xhr, textStatus, errorThrown ) {
     				}
     			}); 
     			
 				$("#reportGridId").css({visibility:"visible"}); 
				$('#generateButtonId').text("Refresh Report");
				$("#reportDescId").css({'display' : 'block'});
				setTimeout( "$('#reportDescId').hide();", 7000);
				$("#divIssId").css("border","none");
				$("#divExpId").css("border","none");
				$("#divFxRateBorderId").css("border","none");
				 
				if($("#expirationDateCheck:checked").val() == 'true'){
					$('#headerText').text("Expiration Report from "+ expInputDateFrom +" to "+expInputDateTo);
		     		$('#headerText').css({'display' : 'block'});
		     		$('#headerText').css({'color' : '#00437e'});
				}
				
				if($("#issuanceDateCheck:checked").val() == 'true'){
					$('#headerText').text("Issuance Report from "+ issInputDateFrom +" to "+issInputDateTo);
		     		$('#headerText').css({'display' : 'block'});
		     		$('#headerText').css({'color' : '#00437e'});
				}
				
				if($("#expirationDateCheck:checked").val() == 'true' && $("#issuanceDateCheck:checked").val() == 'true'){
					$('#headerText').text("Issuance and Expiration Report " + expInputDateFrom +" "+expInputDateTo+" "+issInputDateFrom +" "+issInputDateTo);
		     		$('#headerText').css({'display' : 'block'});
		     		$('#headerText').css({'color' : '#00437e'});
				}
				
				if($("#expirationDateCheck:checked").val() == 'true'){
					// Expiration Start Date
					if(!jQuery.trim($("#expirationDateFrom").val()).length == 0)
						spotfireApp.analysisDocument.setDocumentProperty("INExpStartDt", $("#expirationDateFrom").val().toString());
					// Expiration To Date
					if(!jQuery.trim($("#expirationDateTo").val()).length == 0)
						spotfireApp.analysisDocument.setDocumentProperty("INExpEndDt", $("#expirationDateTo").val().toString());
				}
				else{
					spotfireApp.analysisDocument.setDocumentProperty("INExpStartDt", "");
					spotfireApp.analysisDocument.setDocumentProperty("INExpEndDt", "");
				}
				
				if($("#issuanceDateCheck:checked").val() == 'true'){
					// Issuance Start Date
					if(!jQuery.trim($("#issuanceDateFrom").val()).length == 0)
						spotfireApp.analysisDocument.setDocumentProperty("INIssuanceStartDt", $("#issuanceDateFrom").val().toString());
					// Issuance To Date
					if(!jQuery.trim($("#issuanceDateTo").val()).length == 0)
						spotfireApp.analysisDocument.setDocumentProperty("INIssuanceEndDt", $("#issuanceDateTo").val().toString());
				}
				else{
					spotfireApp.analysisDocument.setDocumentProperty("INIssuanceStartDt", "");
					spotfireApp.analysisDocument.setDocumentProperty("INIssuanceEndDt", "");
				}
				
				if($("input[type=radio][id=fxRateSelection_MOR]:checked").val() != undefined && 
				    		$("input[type=radio][id=fxRateSelection_MOR]:checked").val() == 'MOR'){
				    if($("#morRateId").val() != undefined && !jQuery.trim($("#morRateId").val()).length == 0){
				    	spotfireApp.analysisDocument.setDocumentProperty("INMORBLOOMBERGRATE",$("#morRateId").val().replace("'","").replace("'","").toString());
				    	spotfireApp.analysisDocument.setDocumentProperty("INMORBLOOMBERGFLAG","M");
				    }
				}
				
				else if($("input[type=radio][id=fxRateSelection_Bloomberg]:checked").val() != undefined && 
				    		$("input[type=radio][id=fxRateSelection_Bloomberg]:checked").val() == 'Bloomberg'){
				    if($("#bloombergId").val() != undefined && !jQuery.trim($("#bloombergId").val()).length == 0){
				    	spotfireApp.analysisDocument.setDocumentProperty("INMORBLOOMBERGRATE",$("#bloombergId").val().replace("'","").replace("'","").toString());
				    	spotfireApp.analysisDocument.setDocumentProperty("INMORBLOOMBERGFLAG","B");
				    }
				}
				else{
				    if($("#bloombergId").val() != undefined && !jQuery.trim($("#bloombergId").val()).length == 0){
				    	spotfireApp.analysisDocument.setDocumentProperty("INMORBLOOMBERGRATE",$("#bloombergId").val().replace("'","").replace("'","").toString());
				    	spotfireApp.analysisDocument.setDocumentProperty("INMORBLOOMBERGFLAG","B");
				    }
				}
				
				var fincheck =$("#financialCheck:checked").val();
	            var indCheck = $("#industrialCheck:checked").val();
				// Only for Treasury Users SiteType required to Send
			    
			    if (fincheck == undefined && indCheck == 'true') {
					spotfireApp.analysisDocument.setDocumentProperty("INSITETYPE",'4');
				} else if (fincheck == 'true' && indCheck == undefined) {
					spotfireApp.analysisDocument.setDocumentProperty("INSITETYPE",'1');
				} else if (fincheck == 'true' && indCheck == 'true') {
					spotfireApp.analysisDocument.setDocumentProperty("INSITETYPE",'1,4');
				} else {
					spotfireApp.analysisDocument.setDocumentProperty("INSITETYPE",'');
				}
	
				// Site ID
				if(!jQuery.trim($("#availableSites").val()).length == 0)
					spotfireApp.analysisDocument.setDocumentProperty("INSiteID",$("#availableSites").val().toString());
				else
					spotfireApp.analysisDocument.setDocumentProperty("INSiteID",'');
				// Instrument Type
				var bankGuaranteeCheck = $("#bankGuaranteeCheck:checked").val();
				var standbyLetterCheck = $("#standbyLetterCheck:checked").val();
				var suretyBondCheck    = $("#suretyBondCheck:checked").val();
				var allCheckId         = $("#allCheckId:checked").val();
				
				if (allCheckId == 'true') {
					spotfireApp.analysisDocument.setDocumentProperty("INInstrType",'1,2,3');
				} else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == undefined && suretyBondCheck == undefined && allCheckId == undefined) {
					spotfireApp.analysisDocument.setDocumentProperty("INInstrType", '1');
				} else if (bankGuaranteeCheck == undefined && standbyLetterCheck == 'true' && suretyBondCheck == undefined && allCheckId == undefined) {
					spotfireApp.analysisDocument.setDocumentProperty("INInstrType", '2');
				} else if (bankGuaranteeCheck == undefined && standbyLetterCheck == undefined && suretyBondCheck == 'true' && allCheckId == undefined) {
					spotfireApp.analysisDocument.setDocumentProperty("INInstrType", '3');
				} else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == undefined && suretyBondCheck == 'true' && allCheckId == undefined) {
					spotfireApp.analysisDocument.setDocumentProperty("INInstrType", '1,3');
				} else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == 'true' && suretyBondCheck == undefined && allCheckId == undefined) {
					spotfireApp.analysisDocument.setDocumentProperty("INInstrType", '1,2');
				} else if (bankGuaranteeCheck == undefined && standbyLetterCheck == 'true' && suretyBondCheck == 'true' && allCheckId == undefined) {
					spotfireApp.analysisDocument.setDocumentProperty("INInstrType", '2,3');
				} else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == 'true' && suretyBondCheck == 'true' && allCheckId == undefined) {
					spotfireApp.analysisDocument.setDocumentProperty("INInstrType", '1,2,3');
				} else {
					spotfireApp.analysisDocument.setDocumentProperty("INInstrType", '');
				}
	            
				// Instrument amount greater than
				if(!jQuery.trim($("#instrumentAmtFrom").val()).length == 0)
					spotfireApp.analysisDocument.setDocumentProperty("INInstrAmtFrm", $("#instrumentAmtFrom").val().toString());
				else 
					spotfireApp.analysisDocument.setDocumentProperty("INInstrAmtFrm", '');
				
				// Instrument amount less than
				if(!jQuery.trim($("#instrumentAmtTo").val()).length == 0)
					spotfireApp.analysisDocument.setDocumentProperty("INInstrAmtTo", $("#instrumentAmtTo").val().toString());
				else
					spotfireApp.analysisDocument.setDocumentProperty("INInstrAmtTo", '');
				
				// Instrument Currency
				if(!jQuery.trim($("#instrCurrencyId").val()).length == 0)
					spotfireApp.analysisDocument.setDocumentProperty("INInstrCurr",$("#instrCurrencyId").val().toString());
				else
					spotfireApp.analysisDocument.setDocumentProperty("INInstrCurr", '');
				
				// Requestor
				if(!jQuery.trim($("#requestorName").val()).length == 0)
					spotfireApp.analysisDocument.setDocumentProperty("INRequestor", $("#tpApplicantBCPSSO").val().toString());
				else
					spotfireApp.analysisDocument.setDocumentProperty("INRequestor", '');
				
				// Current Contact
				if(!jQuery.trim($("#contactPersonName").val()).length == 0)
					spotfireApp.analysisDocument.setDocumentProperty("INCurrentContact", $("#contactBCPSSO").val().toString());
				else
					spotfireApp.analysisDocument.setDocumentProperty("INCurrentContact", '');
				
				// Beneficiary/Obligee
				if(!jQuery.trim($("#benficiaryName").val()).length == 0)
					spotfireApp.analysisDocument.setDocumentProperty("INBenObligName", $("#benficiaryName").val().toString());
				else
					spotfireApp.analysisDocument.setDocumentProperty("INBenObligName", '');
				
				// Beneficiary/Obligee Country field is not there
				if(!jQuery.trim($("#obligeeCountry").val()).length == 0)
					spotfireApp.analysisDocument.setDocumentProperty("INBenObligCntry", $("#obligeeCountry").val().toString());
				else
					spotfireApp.analysisDocument.setDocumentProperty("INBenObligCntry", '');
				
				// Country of Issuance
				if(!jQuery.trim($("#issuanceCountry").val()).length == 0)
					spotfireApp.analysisDocument.setDocumentProperty("INCountryIssue", $("#issuanceCountry").val().toString());
				else
					spotfireApp.analysisDocument.setDocumentProperty("INCountryIssue", '');
				
				// Applicant/Principal
				if(!jQuery.trim($("#applicantName").val()).length == 0)
					spotfireApp.analysisDocument.setDocumentProperty("INApplPrnpl", $("#applicantName").val().toString());
				else
					spotfireApp.analysisDocument.setDocumentProperty("INApplPrnpl", '');
				
				// Third-Party Applicant
				if(!jQuery.trim($("#tripartyApplicantId").val()).length == 0)
					spotfireApp.analysisDocument.setDocumentProperty("INTriPartyAppliName", $("#tripartyApplicantId").val().toString());
				else
					spotfireApp.analysisDocument.setDocumentProperty("INTriPartyAppliName", '');
				
				// Issuer  
				if(!jQuery.trim($("#issuerId").val()).length == 0)
					spotfireApp.analysisDocument.setDocumentProperty("INIssuer", $("#issuerId").val().toString());
				else
					spotfireApp.analysisDocument.setDocumentProperty("INIssuer", '');
				
				// Issuing Bank Branch
				if(!jQuery.trim($("#issuingBankBranchId").val()).length == 0)
					spotfireApp.analysisDocument.setDocumentProperty("INIssuingBankBranch",$("#issuingBankBranchId").val().toString());
				else
					spotfireApp.analysisDocument.setDocumentProperty("INIssuingBankBranch", '');
				
				// Issuer Reference   
				if(!jQuery.trim($("#issuerReferenceId").val()).length == 0)
					spotfireApp.analysisDocument.setDocumentProperty("INIssuerRef",$("#issuerReferenceId").val().toString());
				else
					spotfireApp.analysisDocument.setDocumentProperty("INIssuerRef", '');
				
				// Customer Reference
				if(!jQuery.trim($("#customerReferenceId").val()).length == 0)
					spotfireApp.analysisDocument.setDocumentProperty("INCustRef", $("#customerReferenceId").val().toString());
				else
					spotfireApp.analysisDocument.setDocumentProperty("INCustRef", '');
				
				// BUC - ONLY for GE users   
				if(!jQuery.trim($("#businessUnitCodeId").val()).length == 0)
					spotfireApp.analysisDocument.setDocumentProperty("INBUC", $("#businessUnitCodeId").val().toString());
				else
					spotfireApp.analysisDocument.setDocumentProperty("INBUC", '');
				
				// A.D.N - ONLY for GE users  
				if(!jQuery.trim($("#accDistributionNumberId").val()).length == 0)
					spotfireApp.analysisDocument.setDocumentProperty("INADN", $("#accDistributionNumberId").val().toString());
				else
					spotfireApp.analysisDocument.setDocumentProperty("INADN", '');
				
				// User SSO ID
				if($("#userSSOId").val() != undefined && !jQuery.trim($("#userSSOId").val()).length == 0)
					spotfireApp.analysisDocument.setDocumentProperty("INUSERSSO",$("#userSSOId").val().toString());
 			}
		});
		
        $('body').off('click', '#exportResult').on('click', '#exportResult', function(e) {
			$('#generateReport').click();
			e.preventDefault();
			assignValues();
			var url = contextURL +"/int/reports/exportIssuanceExpirationReportResults.action?fileName="+$('#headerText').text();
            $('#issuanceExpirationform').attr('action', url);
        	$('#issuanceExpirationform').submit();
		});

		// CheckAll and uncheckAll
        $('body').off('click', '#allCheckId').on('click', '#allCheckId', function(e) {
			if ($(e.target).is(":checked")) {
				$(e.target).closest("tr").find(':checkbox').attr('checked', true);
			} else {
				$(e.target).closest("tr").find(':checkbox').attr('checked', false);
			}
		});

		$('body').off('click', '#expirationDateCheck').on('click', '#expirationDateCheck', function(e) {
			$("#divExpId").removeClass("hide").addClass("show");
			$("#divExpId").toggle("fast","linear");
			$("#divExpId").css("border","none");
			$("#divIssId").css("border","none");
			$("#expDivId").removeClass("show").addClass("hide");
			$("#issDivId").removeClass("show").addClass("hide");
			$("#checkExpDivId").removeClass("show").addClass("hide");
			$("#checkBorderDivId").css("border","none");
		});
		
		$('body').off('click', '#issuanceDateCheck').on('click', '#issuanceDateCheck', function(e) {
			$("#divIssId").removeClass("hide").addClass("show");
			$("#divIssId").toggle("fast","linear");
			$("#divExpId").css("border","none");
			$("#divIssId").css("border","none");
			$("#issDivId").removeClass("show").addClass("hide");
			$("#expDivId").removeClass("show").addClass("hide");
			$("#checkExpDivId").removeClass("show").addClass("hide");
			$("#checkBorderDivId").css("border","none");
		});
		
		$('body').off("change",'#financialCheck, #industrialCheck').on("change",'#financialCheck, #industrialCheck',function(e){
 			e.stopImmediatePropagation();
 			var financialCheck=$('#financialCheck').is(":checked");
 			var industrialCheck = $('#industrialCheck').is(":checked");
 			var isReports = true;
 			$.ajax({
 				type: "POST",
 				 url: contextURL+'/int/reports/getSites.action',
 			     dataType: 'html',
 			     data: {financialCheck : financialCheck, industrialCheck: industrialCheck,isReports : isReports},
 			     processdata: true,
 			     success: function(data) {
 			    	 $("#siteSelection").empty().append(data);
 			     }
 			});
	 	});  
		
		$('body').off('click', 'a.lookup').on('click', 'a.lookup', function(e){
		    	e.preventDefault();
		    	e.stopImmediatePropagation();
		    	var bucFirstName = '';
		  		var bucLastName = '';
		    	var scrollTopValue = $(e.target).closest(".row").offset().top;
		  		var url = $(e.target).attr('href');
		  		var lookupError = $(e.target).siblings(".lookup-error");
		  		if(lookupError == undefined || $(e.target).siblings(".lookup-error").length == 0){
		  			lookupError = $(e.target).closest('div.row').find(".lookup-error");
		  		}
		  		$(lookupError).empty().addClass("hide").removeClass("show");
		  	
		  		var dataValue = $(e.target).siblings(".lookup-filterValue").val();
		  		var userDataLookup = $(e.target).siblings('.businessContactClass').val();
		  		if(dataValue == undefined && $(e.target).siblings(".lookup-filterValue").length == 0){
		  			dataValue = $(e.target).closest('.form-row').find('.lookup-filterValue').val();
		  			lookupField = $(e.target).closest('.form-row').find('.lookup-filterValue');
		  			userDataLookup = $(e.target).closest('.form-row').find('.businessContactClass').val();
		  		}
		  		if($.trim(dataValue) != ''){
		  			if(userDataLookup != undefined && userDataLookup != '' && userDataLookup == 'BUC') {
		  				if(dataValue.indexOf(",") == -1){
		  					if(dataValue.length < 7 ){
		  						$(lookupError).text("Please provide SSO(at least 7 digits)/LastName , FirstName (at least 2 characters each )").removeClass("hide").addClass("show");
						  		return false;
		  					}
		  				}
		  				else{
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
		  							$(lookupError).text("Please provide SSO(at least 7 digits)/LastName , FirstName (at least 2 characters each )").removeClass("hide").addClass("show");
		  							return false;
		  						}else {
		  							bucLastName = dataValueArray[0];
		  							bucFirstName = dataValueArray[1];
		  						}
		  					}else {
		  						$(lookupError).text("Please provide SSO(at least 7 digits)/LastName , FirstName (at least 2 characters each )").removeClass("hide").addClass("show");
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
		  				data: {filterValue : $.trim(dataValue), scrollTopValue:scrollTopValue, bucFirstName : bucFirstName, bucLastName : bucLastName},
		  				success: function(response){
		  					$('#lookupDiv').empty().append(response);
		  					$(indicator).hide();
		  				},complete : function(jqXHR, status){
		  					if(status == "success"){
		  						$('#mainPage').hide();
		  						$('#lookupDiv').show();
		  						$('#lookupDiv').find('h1').css("visibility","visible");
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
		  		}
		  		else{
		  			$(lookupError).text("Please enter values for Lookup Search").removeClass("hide").addClass("show");
		  			return false;
		  		}
		  		return false;
		 });
		 
		$('body').off('click', '#resetClick').on('click', '#resetClick', function(e) {
			 	$('input:checkbox').removeAttr('checked');
		     	$('input:radio').removeAttr('checked');
		     	$("input[type=text]").val('');
	     		$.ajax({
	     			type: "POST",
			       url: contextURL+'/int/reports/resetSiteNames.action',
			       dataType: 'html',
			       processdata: true,
			       success: function(data) {
			           $("#siteSelection").empty().append(data);
			       }
			    });	
	            $("#divExpId").css({'display' : 'none'});
	            $("#divIssId").css({'display' : 'none'});
	            var currentDate = $.datepicker.formatDate('mm/dd/yy', new Date());
	            $("#issuanceDateTo").val(currentDate.toString());
	            $("#expirationDateFrom").val(currentDate.toString());
	            var now = new Date();
	            now.setDate(now.getDate()+30);
	            var newDate1 = $.datepicker.formatDate('mm/dd/yy', now);
	            $("#expirationDateTo").val(newDate1.toString());
	            $("#bucAdnDivId").removeClass("show").addClass("hide");
				$('.optOutval-error5').removeClass("show").addClass("hide");
				$("#divBUCADNBorderId").css("border","none");
				$("#fxRateDivId").removeClass("show").addClass("hide");
		   		$("#divFxRateBorderId").css("border","none");
		   		
		   		$("#businessContactPersonId").val('');
				$("#BusinessShow").find(":input").val("");
				$("#BusinessShow").find("p").text("");
				$("#BusinessShow").hide();
				$("#BusinessContactShow1").find(":input").val("");
				$("#BusinessContactShow1").find("p").text("");
				$("#BusinessContactShow1").hide();
				$(".lookup-error").text("");
	    });

		$.subscribe('getReportAutocompleterName', function(event,data) {
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
		$("#reportGridId").css({visibility:"hidden"});
		$('.acc_triggerA').addClass('acc_active').next().next().show();	
	});
	
	function assignValues(){
		if($("#availableSites").val() != undefined && !jQuery.trim($("#availableSites").val()).length == 0){
    		var selectedSites = $('#availableSites').val().toString();
    		$('#selectedSitesId').val(selectedSites);
    	}
		else{
			$('#selectedSitesId').val('');
		}
			
		var fincheck =$("#financialCheck:checked").val();
        var indCheck = $("#industrialCheck:checked").val();
		// Only for Treasury Users SiteType required to Send
	    if (fincheck == undefined && indCheck == 'true') {
	    	$('#siteType').val('4');
		} else if (fincheck == 'true' && indCheck == undefined) {
			$('#siteType').val('1');
		} else if (fincheck == 'true' && indCheck == 'true') {
			$('#siteType').val("1,4");
		}
	    
	    // Instrument Type
		var bankGuaranteeCheck = $("#bankGuaranteeCheck:checked").val();
		var standbyLetterCheck = $("#standbyLetterCheck:checked").val();
		var suretyBondCheck    = $("#suretyBondCheck:checked").val();
		var allCheckId         = $("#allCheckId:checked").val();
		
		if (allCheckId == 'true') {
			$('#instrumentType').val("1,2,3");
		} else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == undefined && suretyBondCheck == undefined && allCheckId == undefined) {
			$('#instrumentType').val('1');
		} else if (bankGuaranteeCheck == undefined && standbyLetterCheck == 'true' && suretyBondCheck == undefined && allCheckId == undefined) {
			$('#instrumentType').val('2');
		} else if (bankGuaranteeCheck == undefined && standbyLetterCheck == undefined && suretyBondCheck == 'true' && allCheckId == undefined) {
			$('#instrumentType').val('3');
		} else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == undefined && suretyBondCheck == 'true' && allCheckId == undefined) {
			$('#instrumentType').val("1,3");
		} else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == 'true' && suretyBondCheck == undefined && allCheckId == undefined) {
			$('#instrumentType').val("1,2");
		} else if (bankGuaranteeCheck == undefined && standbyLetterCheck == 'true' && suretyBondCheck == 'true' && allCheckId == undefined) {
			$('#instrumentType').val("2,3");
		} else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == 'true' && suretyBondCheck == 'true' && allCheckId == undefined) {
			$('#instrumentType').val("1,2,3");
		}
		
        $('#userssoId').val($("#userSSOId").val().toString()) ;
        
        if($("input[type=radio][id=fxRateSelection_MOR]:checked").val() != undefined && 
	    		$("input[type=radio][id=fxRateSelection_MOR]:checked").val() == 'MOR') {
        	if($("#morRateId").val() != undefined && !jQuery.trim($("#morRateId").val()).length == 0) {
        		$("#morBloombergRate").val($("#morRateId").val().replace("'","").replace("'","").toString());
        		$("#morBloombergRateFlag").val("M");
        	}
        }
        else if($("input[type=radio][id=fxRateSelection_Bloomberg]:checked").val() != undefined && 
	    		$("input[type=radio][id=fxRateSelection_Bloomberg]:checked").val() == 'Bloomberg') {
        	if($("#bloombergId").val() != undefined && !jQuery.trim($("#bloombergId").val()).length == 0) {
        		$("#morBloombergRate").val($("#bloombergId").val().replace("'","").replace("'","").toString());
        		$("#morBloombergRateFlag").val("B");
        	}
        }
        else {
        	if($("#bloombergId").val() != undefined && !jQuery.trim($("#bloombergId").val()).length == 0) {
        		$("#morBloombergRate").val($("#bloombergId").val().replace("'","").replace("'","").toString());
        		$("#morBloombergRateFlag").val("B");
        	}
        }
	}
	
	function callBUCADNValidation(url,formData){
		$.ajax({
			type: "POST",
	        url: url,
	        dataType: 'json',
	        data: formData,
	        processdata: true,
	        success: function(data) {
	        	if(data.result[0].IBSMessageId != '' && data.result[1] == undefined){
	        		$("#bucAdnDivId").removeClass("show").addClass("hide");
					$('.optOutval-error5').removeClass("show").addClass("hide");
					$("#divBUCADNBorderId").css("border","none");
	        	}else{
	        		$("#bucAdnDivId").removeClass("hide").addClass("show");
					$('.optOutval-error5').text("Business unit code  & Accounting distribution number combination should be valid").removeClass("hide").addClass("show");
					$("#divBUCADNBorderId").css("border","1px solid red");
					$("#reportGridId").css({visibility:"hidden"});
					$('#blankMessage').css({'display' : 'none'});
					return false;
	        	}
	        }
	    });
	}
	
	function incr_date(date_str,no_of_days_to_add){
		var futureDate=new Date(date_str);
        futureDate.setDate(new Date().getDate()+no_of_days_to_add);
     	var next_date_str= futureDate;
        return next_date_str;
	}
	
	function validateIssuance(){
		var expInputDateFrom = $("#expirationDateFrom").val();
		var expInputDateTo = $("#expirationDateTo").val();
		var issInputDateFrom = $("#issuanceDateFrom").val();
		var issInputDateTo = $("#issuanceDateTo").val();
		var expiartionIssuanceCheck = true;
		var expirationCheck = true;
		var issuanceCheck = true;
		var fxRateCheck = true;
		if ($("#expirationDateCheck").is(':not(:checked)') && $("#issuanceDateCheck").is(':not(:checked)')){
			$("#checkExpDivId").removeClass("hide").addClass("show");
			$('.optOutval-error').text("Please check either Expiration or Issuance Date").removeClass("hide").addClass("show");
			$("#checkBorderDivId").css("border","1px solid red");
			$("#reportGridId").css({visibility:"hidden"});
			$('#blankMessage').css({'display' : 'none'});
			expiartionIssuanceCheck = false;
		}		
		if (!$("#expirationDateCheck").is(':not(:checked)')){
			if((jQuery.trim(expInputDateFrom).length == 0 || jQuery.trim(expInputDateTo).length == 0)){
				$("#expDivId").removeClass("hide").addClass("show");
				$('.optOutval-error1').text("Expiration Date is mandatory").removeClass("hide").addClass("show");
				$("#divExpId").css("border","1px solid red");
				$("#reportGridId").css({visibility:"hidden"});
				$('#blankMessage').css({'display' : 'none'});
				expirationCheck = false;
		    }
			else if(new Date(expInputDateFrom) > new Date(expInputDateTo) && expirationCheck != false){
				$("#expDivId").removeClass("hide").addClass("show");
				$('.optOutval-error1').text("Expiration From Date should be less than To Date").removeClass("hide").addClass("show");
				$("#divExpId").css("border","1px solid red");
				$("#reportGridId").css({visibility:"hidden"});
				$('#blankMessage').css({'display' : 'none'});
				expirationCheck = false;
			}
			else{
				$("#expDivId").removeClass("show").addClass("hide");
				$("#divExpId").css("border","none");
			}
		}
		
		if(!$("#issuanceDateCheck").is(':not(:checked)')){
			if((jQuery.trim(issInputDateFrom).length == 0) || (jQuery.trim(issInputDateTo).length == 0)){
			    $("#issDivId").removeClass("hide").addClass("show");
				$('.optOutval-error2').text("Issuance Date is mandatory").removeClass("hide").addClass("show");
				$("#divIssId").css("border","1px solid red");
				$("#reportGridId").css({visibility:"hidden"});
				$('#blankMessage').css({'display' : 'none'});
				issuanceCheck = false;
			}
			else if(new Date(issInputDateFrom) > new Date(issInputDateTo) && issuanceCheck != false){
				$("#issDivId").removeClass("hide").addClass("show");
				$('.optOutval-error2').text("Issuance From Date should be less than To Date").removeClass("hide").addClass("show");
				$("#divIssId").css("border","1px solid red");
				$("#reportGridId").css({visibility:"hidden"});
				$('#blankMessage').css({'display' : 'none'});
				issuanceCheck = false;
			}
			else{
				$("#issDivId").removeClass("show").addClass("hide");
				$("#divIssId").css("border","none");
			}
		}
		
		if(!jQuery.trim($("#instrumentAmtFrom").val()).length == 0 && 
    			!jQuery.trim($("#instrumentAmtTo").val()).length == 0){
			if(isNaN($("#instrumentAmtFrom").val()) || isNaN($("#instrumentAmtTo").val())){
				$("#instrAmtDivId").removeClass("hide").addClass("show");
   			 	$('.optOutval-error3').text("Please enter valid Instrument Amounts").removeClass("hide").addClass("show");
        		$("#instrAmtBorderId").css("border","1px solid red");
        		$("#reportGridId").css({visibility:"hidden"});
        		$('#blankMessage').css({'display' : 'none'});
        		amtCheck = false;
        	}
			else if(parseInt($("#instrumentAmtFrom").val())>parseInt($("#instrumentAmtTo").val())){
    			$("#instrAmtDivId").removeClass("hide").addClass("show");
   			 	$('.optOutval-error3').text("Instrument From Amount should be less than To Amount").removeClass("hide").addClass("show");
        		$("#instrAmtBorderId").css("border","1px solid red");
        		$("#reportGridId").css({visibility:"hidden"});
        		$('#blankMessage').css({'display' : 'none'});
        		amtCheck = false;
    		}
		}
		if($("input[type=radio][id=fxRateSelection_MOR]:checked").length > 0){
	   		 $("#fxRateDivId").removeClass("show").addClass("hide");
	   		 $("#divFxRateBorderId").css("border","none");
	   	}
	   	else if($("input[type=radio][id=fxRateSelection_Bloomberg]:checked").length>0){
	   		 $("#fxRateDivId").removeClass("show").addClass("hide");
	   		 $("#divFxRateBorderId").css("border","none");
	   	}
	   	else {
	       	 $("#fxRateDivId").removeClass("hide").addClass("show");
	       	 $('.optOutval-error4').text("Please select Fx Rate Selection").removeClass("hide").addClass("show");
	       	 $("#divFxRateBorderId").css("border","1px solid red");
	       	 $("#reportGridId").css({visibility:"hidden"});
	       	 $('#blankMessage').css({'display' : 'none'});
	       	 fxRateCheck = false;
	   	} 	
		
		if(expiartionIssuanceCheck == false || expirationCheck == false || issuanceCheck == false || fxRateCheck == false)
			return false;
		else
			return true;
	}