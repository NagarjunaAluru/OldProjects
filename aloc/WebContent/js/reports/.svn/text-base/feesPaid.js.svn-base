// Global declaration of app object
	var app;
	
	$(document).ready(function() {
		//document.domain=$("#domainNameURLId").val();
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
		customization.showPageNavigation = true;
		customization.showStatusBar = false;
		var checkedVals = 0;
		
		app = new spotfire.webPlayer.Application($("#spotfireWebplayerURLId").val(), customization);
		app.open($("#feesPaidPathId").val(), "webPlayer", '');
		
		$('body').off('click', '#generateReport').on('click', '#generateReport', function(e) {
			 $("#paymentDivId").addClass("hide");
			 $("#issuanceDivId").addClass("hide");
			 if(validateFeesPaid()){
				 assignValues();
				 $('#blankMessage').css({'display' : 'none'});
        		 var url = contextURL +"/int/reports/recordCountForFeesPaid.action";
     			 $.ajax({
     				type: "POST",
     				url: url,
     				dataType: 'json',
     				data: $("#feesPaidReportForm").serialize(),// serializes the form's elements.
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
				 setTimeout( "$('#reportDescId').hide();", 8000);
				 
				 $('#headerText').text("Fees Paid : "+ $("#paymentDateFromId").val() +" - "+$("#paymentDateToId").val());
		     	 $('#headerText').css({'display' : 'block'});
		     	 $('#headerText').css({'color' : '#00437e'});
		     		
				 if($("#availableBanks").val() != null){
					  banksCount = $("#availableBanks").val().toString().split(",").length;
				 }
				 if($("#availableSites").val() != null){
					  sitesCount = $("#availableSites").val().toString().split(",").length;
				 }
				 checkedVals = $('.groupByFilter:checkbox:checked').map(function() { return "["+this.name+"]"; }).get().join('NEST');
				 
				 var finalString = "<" +checkedVals+">";
				 		
				 app.analysisDocument.setDocumentProperty("SELECTEDGROUPBY1", finalString.toString());
					
				 if($("#availableBanks").val() != undefined && !jQuery.trim($("#availableBanks").val()).length == 0)
					 app.analysisDocument.setDocumentProperty("INISSUER",$('#availableBanks').val().toString());
				 else
					 app.analysisDocument.setDocumentProperty("INISSUER",'');
				 
				 if($("#paymentDateFromId").val() != undefined && !jQuery.trim($("#paymentDateFromId").val()).length == 0)
					 app.analysisDocument.setDocumentProperty("INPAYMENTSTARTDT",$("#paymentDateFromId").val().toString());
				 
				 if($("#paymentDateToId").val() != undefined && !jQuery.trim($("#paymentDateToId").val()).length == 0)
					 app.analysisDocument.setDocumentProperty("INPAYMENTENDDT",$("#paymentDateToId").val().toString());
				 
				 if($("#issuanceDateFromId").val() != undefined && !jQuery.trim($("#issuanceDateFromId").val()).length == 0)
					 app.analysisDocument.setDocumentProperty("INISSUANCESTARTDT",$("#issuanceDateFromId").val().toString());
				 else
					 app.analysisDocument.setDocumentProperty("INISSUANCESTARTDT",'');
				 
				 if($("#issuanceDateToId").val() != undefined && !jQuery.trim($("#issuanceDateToId").val()).length == 0)
					 app.analysisDocument.setDocumentProperty("INISSUANCEENDDT",$("#issuanceDateToId").val().toString());
				 else
					 app.analysisDocument.setDocumentProperty("INISSUANCEENDDT",'');
				 
				 if($("#applicantName").val() != undefined && !jQuery.trim($("#applicantName").val()).length == 0)
					 app.analysisDocument.setDocumentProperty("INAPPPRINCPLNAME",$("#applicantName").val().toString());
				 else
					 app.analysisDocument.setDocumentProperty("INAPPPRINCPLNAME",'');
				 
				 if($("#geRefId").val() != undefined && !jQuery.trim($("#geRefId").val()).length == 0)
					 app.analysisDocument.setDocumentProperty("INGEREF1",$("#geRefId").val().toString());
				 else
					 app.analysisDocument.setDocumentProperty("INGEREF1",'');
		         
		         // MOR Rate property
			     if(!jQuery.trim($("#bloombergId").val()).length == 0)
			    	 app.analysisDocument.setDocumentProperty("INMORRATE",$("#bloombergId").val().replace("'","").replace("'","").toString());
				
		         //Business Site Id
				 if($("#availableSites").val() != undefined && !jQuery.trim($("#availableSites").val()).length == 0)
					 app.analysisDocument.setDocumentProperty("INBUSINESSSITE",$("#availableSites").val().toString());
				 else
					 app.analysisDocument.setDocumentProperty("INBUSINESSSITE",'');
				 
		         //Country Of Issuance
				 if($("#issuanceCountry").val() != undefined && !jQuery.trim($("#issuanceCountry").val()).length == 0)
					 app.analysisDocument.setDocumentProperty("INCNTRYISSUE",$("#issuanceCountry").val().toString());
				 else
					 app.analysisDocument.setDocumentProperty("INCNTRYISSUE",'');
				 
				 //User SSO Id 
				 if($("#userSSOId").val() != undefined && !jQuery.trim($("#userSSOId").val()).length == 0)
					 app.analysisDocument.setDocumentProperty("INUSERSSO",$("#userSSOId").val().toString());
				 
			     if($('#issuerId').attr('checked'))
			    	 app.analysisDocument.setDocumentProperty("INGBISSUER", 'Y');
			     else
			    	 app.analysisDocument.setDocumentProperty("INGBISSUER", '');
			     
			     if($('#businessSiteId').attr('checked'))
			    	 app.analysisDocument.setDocumentProperty("INGBBUSINESSSITE", 'Y');
			     else
			    	 app.analysisDocument.setDocumentProperty("INGBBUSINESSSITE", '');
			     
			     if($('#countryofIssuanceId').attr('checked'))
			    	 app.analysisDocument.setDocumentProperty("INGBCNTRYISSUE", 'Y');	
			     else
			    	 app.analysisDocument.setDocumentProperty("INGBCNTRYISSUE", '');
			     
			     if($('#geRefGroupById').attr('checked'))
		        	 app.analysisDocument.setDocumentProperty("INGBGEREF1", 'Y');	
			     else
			    	 app.analysisDocument.setDocumentProperty("INGBGEREF1", '');
			     
			     if($('#applicantPrincipalId').attr('checked'))
		        	 app.analysisDocument.setDocumentProperty("INGBAPPLICANT", 'Y');
			     else
			    	 app.analysisDocument.setDocumentProperty("INGBAPPLICANT", '');
			     
			     if($('#bankReferenceId').attr('checked'))
		        	 app.analysisDocument.setDocumentProperty("INGBBANKREF", 'Y');
		         else
			    	 app.analysisDocument.setDocumentProperty("INGBBANKREF", '');	         
			}
		});
        
		$('body').off('click', '#resetClick').on('click', '#resetClick', function(e) {
        	// clearing the filter criteria
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
 		 
	 		$.ajax({
	 			type: "POST",
	            url: contextURL+'/int/reports/resetBankNames.action',
	            dataType: 'html',
	            processdata: true,
	            success: function(data) {
	            	$("#bankSelection").empty().append(data);
	            }
	        });
	 		var currentDate = $.datepicker.formatDate('mm/dd/yy', new Date());
	        $("#paymentDateToId").val(currentDate.toString());
	        
	        $("#paymentDivId").removeClass("show").addClass("hide");
			$("#paymentBorderDivId").css("border","none");
			$("#issuanceDivId").removeClass("show").addClass("hide");
			$("#issuanceBorderDivId").css("border","none");
			$("#groupByDivId").removeClass("show").addClass("hide");
			$("#groupByGridId").css("border","none");
			$('#blankMessage').css({'display' : 'none'});
        });
        
		$('body').off('click', '#exportResult').on('click', '#exportResult', function(e) {
			e.preventDefault();
			$('#generateReport').click();
        	var url = contextURL +"/int/reports/exportFeesPaidReportResults.action?fileName="+$('#headerText').text();
        	assignValues();
        	$('#feesPaidReportForm').attr('action', url);
        	$('#feesPaidReportForm').submit();
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
        
        if($('#siteSelection').is(':empty')){
        	$.ajax({
        		type: "POST",
	            url: contextURL+'/int/reports/addSiteSelection.action',
	            dataType: 'html',
	            processdata: true,
	            success: function(data) {
	            	$("#siteSelection").empty().append(data);
	            }
		   });
        }
        if($('#bankSelection').is(':empty')){
        	$.ajax({
        		type: "POST",
	            url: contextURL+'/int/reports/addBankSelection.action',
	            dataType: 'html',
	            processdata: true,
	            success: function(data) {
	            	$("#bankSelection").empty().append(data);
	            }
		   });
        }
        
        $('.acc_triggerA').addClass('acc_active').next().next().show();
        $("#reportGridId").css({visibility:"hidden"});
	});
	
	function assignValues(){
    	if($("#availableSites").val() != undefined && !jQuery.trim($("#availableSites").val()).length == 0){
    		var selectedSites = $('#availableSites').val().toString();
    		$('#selectedSitesId').val(selectedSites);
    	}
    	
    	if($("#availableBanks").val() != undefined && !jQuery.trim($("#availableBanks").val()).length == 0){
    		var selectedBanks = $('#availableBanks').val().toString();
    		$('#selectedBanksId').val(selectedBanks);
    	}
    	
    	var UserSSOID = $('#userSSOId').val().toString();
    	$('#UserSSO').val(UserSSOID);
    	
    	if($("#bloombergId").val() != undefined && !jQuery.trim($("#bloombergId").val()).length == 0)
    		$("#morBloombergRate").val($("#bloombergId").val().replace("'","").replace("'","").toString());
    	
    	if($('#issuerId').attr('checked'))
    		$("#gbIssuer").val('Y');
    	else
    		$("#gbIssuer").val('');
    	
    	if($('#businessSiteId').attr('checked'))
	    	$("#gbBusinessSite").val('Y');
	    else
	    	$("#gbBusinessSite").val('');
	    
    	if($('#countryofIssuanceId').attr('checked'))
	    	$("#gbCountryIssuance").val('Y');
	    else
	    	$("#gbCountryIssuance").val('');
	    
    	if($('#geRefGroupById').attr('checked'))
	    	$("#gbGeref1").val('Y');
	    else
	    	$("#gbGeref1").val('');
	    
    	if($('#applicantPrincipalId').attr('checked'))
	    	$("#gbApplicant").val('Y');
	    else
	    	$("#gbApplicant").val('');
	    
    	if($('#bankReferenceId').attr('checked'))
	    	$("#gbBankRef").val('Y');
	    else
	    	$("#gbBankRef").val('');
    }
    
    function validateFeesPaid(){
    	 var paymentFromDate  = $("#paymentDateFromId").val();
		 var paymentToDate    = $("#paymentDateToId").val();
		 var currentDate      = $.datepicker.formatDate('mm/dd/yy', new Date());  
		 var issuanceFromDate = $("#issuanceDateFromId").val();
		 var issuanceToDate   = $("#issuanceDateToId").val();
		 var paymentCheck = true;
		 var issuanceCheck = true;
		 var groupCheck = true;
		 
		 if((jQuery.trim(paymentFromDate).length == 0 || jQuery.trim(paymentToDate).length == 0)){
			 $("#paymentDivId").removeClass("hide").addClass("show");
			 $("#paymentBorderDivId").css("border","1px solid red");
			 $("#reportGridId").css({visibility:"hidden"});
			 $('#blankMessage').css({'display' : 'none'});
			 if((jQuery.trim(paymentFromDate).length == 0 && jQuery.trim(paymentToDate).length == 0))
				 $('.optOutval-error').text("Please enter Payment Start & End Date").removeClass("hide").addClass("show");
			 else if(jQuery.trim(paymentFromDate).length == 0)
				 $('.optOutval-error').text("Please enter Payment Start Date").removeClass("hide").addClass("show");
			 else
				 $('.optOutval-error').text("Please enter Payment End Date").removeClass("hide").addClass("show");
			 paymentCheck = false;
		 }
		 else if(new Date(paymentFromDate) > new Date(paymentToDate)){
			 $("#paymentDivId").removeClass("hide").addClass("show");
			 $('.optOutval-error').text("Payment Start Date should be less than End Date").removeClass("hide").addClass("show");
			 $("#paymentBorderDivId").css("border","1px solid red");
			 $("#reportGridId").css({visibility:"hidden"});
			 $('#blankMessage').css({'display' : 'none'});
			 paymentCheck = false;
		 }
		 else if(new Date(paymentToDate) > new Date(currentDate)){
			 $("#paymentDivId").removeClass("hide").addClass("show");
			 $('.optOutval-error').text("Payment To Date should not be future date").removeClass("hide").addClass("show");
			 $("#paymentBorderDivId").css("border","1px solid red");
			 $("#reportGridId").css({visibility:"hidden"});
			 $('#blankMessage').css({'display' : 'none'});
			 paymentCheck = false;
		 }
		 else{
			 $("#paymentDivId").removeClass("show").addClass("hide");
			 $("#paymentBorderDivId").css("border","none");
		 }
		 if(new Date(issuanceFromDate) > new Date(issuanceToDate)){
			 $("#issuanceDivId").removeClass("hide").addClass("show");
			 $('.optOutval-error1').text("Issuance Start Date should be less than End Date").removeClass("hide").addClass("show");
			 $("#issuanceBorderDivId").css("border","1px solid red");
			 $("#reportGridId").css({visibility:"hidden"});
			 $('#blankMessage').css({'display' : 'none'});
			 issuanceCheck = false;
		 }
		 else{
			 $("#issuanceDivId").removeClass("show").addClass("hide");
			 $("#issuanceBorderDivId").css("border","none");
		 }
		 
		 var issuerCheck = $("#issuerId:checked").val();
		 var businessCheck = $("#businessSiteId:checked").val();
		 var countryIssuanceCheck = $("#countryofIssuanceId:checked").val();
		 var geRefCheck = $("#geRefGroupById:checked").val();
		 var applicantCheck = $("#applicantId:checked").val();
		 var bankReferenceCheck = $("#bankReferenceId:checked").val();
		 
		 if(issuerCheck == 'true' || businessCheck == 'true' || countryIssuanceCheck == 'true' || 
				 geRefCheck == 'true' || applicantCheck == 'true' || bankReferenceCheck == 'true'){
			 $("#groupByDivId").removeClass("show").addClass("hide");
			 $("#groupByGridId").css("border","none");
		 }
		 else{
			 $("#groupByDivId").removeClass("hide").addClass("show");
			 $('.optOutval-error2').text("Please check atleast one Group results by").removeClass("hide").addClass("show");
			 $("#reportGridId").css({visibility:"hidden"});
			 $('#blankMessage').css({'display' : 'none'});
			 $("#groupByGridId").css("border","1px solid red");
			 groupCheck = false;
		 }
			 
		 if(paymentCheck == false || issuanceCheck == false || groupCheck == false)
	    	return false;
	    else
	    	return true;
	    
    }