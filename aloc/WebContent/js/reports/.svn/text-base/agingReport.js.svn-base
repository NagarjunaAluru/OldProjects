// Global declaration of spotfireApp object
	var app;
	
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
		customization.showPageNavigation = true;
		customization.showStatusBar = false;
		
		app = new spotfire.webPlayer.Application($("#spotfireWebplayerURLId").val(), customization);
    	// Open an analysis.  
        app.open($("#agingReportPathId").val(),"webPlayer",'Parameter.BusinessLocation = {Boston, Seattle};');
        
		$('#incrementalMonths option[value="0"]').attr("selected",true);
        $('#incrementalMonths').prop('disabled', true);
        $('body').off('click', '#generateReport').on('click', '#generateReport', function(e) {
	         var checkedVals = $('.groupByClass:checkbox:checked').map(function() {
	        	 return this.value;
	         }).get();
	         
	         if(checkedVals.length == 0){
	     		$("#errorDivId").removeClass("hide").addClass("show");
	 			$('.optOutval-error').text("Please check Group results by").removeClass("hide").addClass("show");
	 			$("#groupByDivId").css("border","1px solid red");
	 			$("#reportGridId").css({visibility:"hidden"});
	 			$('#blankMessage').css({'display' : 'none'});
	 			return false;
	     	 }
	 		 else{
	 			$('.optOutval-error').removeClass("show").addClass("hide");
	 			$("#groupByDivId").css("border","none");
	 		 }
	         
	        assignValues();
	        $('#blankMessage').css({'display' : 'none'});
			var url = contextURL +"/int/reports/recordCountForAging.action";
			$.ajax({
				type: "POST",
				url: url,
				dataType: 'json',
				data: $("#agingReportForm").serialize(),// serializes the form's elements.
				processdata: true,
				success: function(response){
					if((response.data == 0))
						$('#blankMessage').css({'display' : 'block'});
				},
				error: function (xhr, textStatus, errorThrown ) {
				}
			}); 
				
	         $("#reportGridId").css({visibility:"visible"});
	         $("#generateReportId").text("Refresh Report");
	         setTimeout( "$('#reportDescId').hide();", 6000);
	         
	         var insPurpose = new Array();
			 var i=0;
	   	 	 $('.instrPurpose').each(function() {
	   	 		 if($(this).attr('checked') == 'checked'){
	   	 			 insPurpose[i] =  $(this).val();
	   	 		 }
	   	 		 i++;
	   	 	 });
	   	 	 insPurpose =  insPurpose.toString().replace(",,,,,",",").replace(",,,,",",").replace(",,,",",").replace(",,",",");
	       	 if(insPurpose.charAt(0) == ','){
	       		insPurpose = insPurpose.replace(',','');
	       	 }
             // Instrument Type
       	 	 var bankGuaranteeCheck = $("#bankGuaranteeCheck:checked").val();
			 var standbyLetterCheck = $("#standbyLetterCheck:checked").val();
			 var suretyBondCheck    = $("#suretyBondCheck:checked").val();
			 var allCheckId         = $("#allCheckId:checked").val();
			
			 if (allCheckId == 'true') 
				 app.analysisDocument.setDocumentProperty("ININSTTYPE",'1,2,3');
		     else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == undefined && suretyBondCheck == undefined && allCheckId == undefined) 
		    	 app.analysisDocument.setDocumentProperty("ININSTTYPE", '1');
			 else if (bankGuaranteeCheck == undefined && standbyLetterCheck == 'true' && suretyBondCheck == undefined && allCheckId == undefined) 
				 app.analysisDocument.setDocumentProperty("ININSTTYPE", '2');
			 else if (bankGuaranteeCheck == undefined && standbyLetterCheck == undefined && suretyBondCheck == 'true' && allCheckId == undefined) 
				 app.analysisDocument.setDocumentProperty("ININSTTYPE", '3');
			 else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == undefined && suretyBondCheck == 'true' && allCheckId == undefined) 
				 app.analysisDocument.setDocumentProperty("ININSTTYPE", '1,3');
			 else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == 'true' && suretyBondCheck == undefined && allCheckId == undefined) 
				 app.analysisDocument.setDocumentProperty("ININSTTYPE", '1,2');
			 else if (bankGuaranteeCheck == undefined && standbyLetterCheck == 'true' && suretyBondCheck == 'true' && allCheckId == undefined) 
				 app.analysisDocument.setDocumentProperty("ININSTTYPE", '2,3');
			 else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == 'true' && suretyBondCheck == 'true' && allCheckId == undefined) 
				 app.analysisDocument.setDocumentProperty("ININSTTYPE", '1,2,3');
			 else
				 app.analysisDocument.setDocumentProperty("ININSTTYPE",'');
       
             // setting the groupBy values selectallId
			 if($('#applicantPrincipalId').attr('checked'))
				 app.analysisDocument.setDocumentProperty("INGBAPPPRINCNAME",'Y');
			 else
				 app.analysisDocument.setDocumentProperty("INGBAPPPRINCNAME",'');
		
			 if($('#beneficiaryId').attr('checked'))
				 app.analysisDocument.setDocumentProperty("INGBBENOBLIGNAME",'Y');
			 else
				 app.analysisDocument.setDocumentProperty("INGBBENOBLIGNAME",'');
			
			 if($('#beneficiaryRefId').attr('checked'))
				 app.analysisDocument.setDocumentProperty("INGBBENREF1",'Y');
			 else
				 app.analysisDocument.setDocumentProperty("INGBBENREF1",'');
			
			 if($('#countryofIssuanceId').attr('checked'))
				 app.analysisDocument.setDocumentProperty("INGBCOUNTRYOFISSUE",'Y');
			 else
				 app.analysisDocument.setDocumentProperty("INGBCOUNTRYOFISSUE",'');
			
			 if($('#obligeeCountryId').attr('checked'))
				 app.analysisDocument.setDocumentProperty("INGBBENOBLIGCOUNTRY",'Y');
			 else
				 app.analysisDocument.setDocumentProperty("INGBBENOBLIGCOUNTRY",'');
			
			 if($('#geApplicantRefId').attr('checked'))
				 app.analysisDocument.setDocumentProperty("INGBGEAPPREF1",'Y');
			 else
				 app.analysisDocument.setDocumentProperty("INGBGEAPPREF1",'');
			
			 if($('#leGoldId').attr('checked'))
				 app.analysisDocument.setDocumentProperty("INGBGOLDID",'Y');
			 else
				 app.analysisDocument.setDocumentProperty("INGBGOLDID",'');
			
			 if($('#instrPurposeId').attr('checked'))
				 app.analysisDocument.setDocumentProperty("INGBINSTPURP",'Y');
			 else
				 app.analysisDocument.setDocumentProperty("INGBINSTPURP",'');
			
			 if($('#instrTypeId').attr('checked'))
				 app.analysisDocument.setDocumentProperty("INGBINSTTYPE",'Y');
			 else
				 app.analysisDocument.setDocumentProperty("INGBINSTTYPE",'');
			
			 if($('#siteCodeId').attr('checked'))
				 app.analysisDocument.setDocumentProperty("INGBSITECODE",'Y');
			 else
				 app.analysisDocument.setDocumentProperty("INGBSITECODE",'');
			
			 if($('#gbBundleId').attr('checked'))
				 app.analysisDocument.setDocumentProperty("INGBBUNDLEID",'Y');
			 else
				 app.analysisDocument.setDocumentProperty("INGBBUNDLEID",'');
	         
	         //setting property for Applicant/Principal Name
			 if(!jQuery.trim($("#applicantName").val()).length == 0)
				 app.analysisDocument.setDocumentProperty("INAPPPRINCNAME",$("#applicantName").val().toString());
			 else
				 app.analysisDocument.setDocumentProperty("INAPPPRINCNAME",'');
	         
	         //setting property for Beneficiary/Obligee
			 if(!jQuery.trim($("#benficiaryName").val()).length == 0)
				 app.analysisDocument.setDocumentProperty("INBENOBLINAME",$("#benficiaryName").val().toString());
			 else
				 app.analysisDocument.setDocumentProperty("INBENOBLINAME",'');
	         
	         //setting property for Beneficiary/Obligee Country
			 if(!jQuery.trim($("#beneficiaryCountryId").val()).length == 0)
				 app.analysisDocument.setDocumentProperty("INBENOBLIGCOUNTRY",$("#beneficiaryCountryId").val().toString());
			 else
				 app.analysisDocument.setDocumentProperty("INBENOBLIGCOUNTRY",'');
	         
	         //setting property for Instrument Purpose
			 if(!jQuery.trim(insPurpose).length == 0)
				 app.analysisDocument.setDocumentProperty("ININSTPURP",insPurpose.toString());
			 else
				 app.analysisDocument.setDocumentProperty("ININSTPURP",'');
	         
	         //setting property for Gold ID
			 if(!jQuery.trim($("#legalGoldId").val()).length == 0)
				 app.analysisDocument.setDocumentProperty("INGOLDID",$("#legalGoldId").val().toString());
			 else
				 app.analysisDocument.setDocumentProperty("INGOLDID",'');
	         
	         //setting property for Site Code
			 if(!jQuery.trim($("#availableSites").val()).length == 0)
				 app.analysisDocument.setDocumentProperty("INSITECODE",$("#availableSites").val().toString());
			 else
				 app.analysisDocument.setDocumentProperty("INSITECODE",'');
			 
			//setting property for Bank ID
			 if(!jQuery.trim($('#availableBanks').val()).length == 0)
				 app.analysisDocument.setDocumentProperty("INBANKID",$('#availableBanks').val().toString());
			 else
				 app.analysisDocument.setDocumentProperty("INBANKID",'');
	         
	         //setting property for GE Applicant Reference
			 if(!jQuery.trim($("#geApplicantReferenceId").val()).length == 0)
				 app.analysisDocument.setDocumentProperty("INGEAPPREF1",$('#geApplicantReferenceId').val().toString());
			 else
				 app.analysisDocument.setDocumentProperty("INGEAPPREF1",'');
	         
	         //setting property for Beneficiary Reference
			 if(!jQuery.trim($("#beneficiaryReferenceId").val()).length == 0)
				 app.analysisDocument.setDocumentProperty("INBENREF1",$('#beneficiaryReferenceId').val().toString());
			 else
				 app.analysisDocument.setDocumentProperty("INBENREF1",'');
	         
	         //setting property for Country of Issuance
			 if(!jQuery.trim($("#issuanceCountry").val()).length == 0)
				 app.analysisDocument.setDocumentProperty("INCOUNTRYOFISSUE",$('#issuanceCountry').val().toString());
			 else
				 app.analysisDocument.setDocumentProperty("INCOUNTRYOFISSUE",'');
	         
	         //setting property for Bundle Id
			 if(!jQuery.trim($("#bundleId").val()).length == 0)
				 app.analysisDocument.setDocumentProperty("INBUNDLEID",$('#bundleId').val().toString());
			 else
				 app.analysisDocument.setDocumentProperty("INBUNDLEID",'');
	         
	         // setting property for aging Months
			 if(!jQuery.trim($("#agingMonthsId").val()).length == 0)
				 app.analysisDocument.setDocumentProperty("INAGINGMONTHS",$("#agingMonthsId").val().toString());
			 
			 // setting property for incremental no of months
			 if(!jQuery.trim($("#incrementalMonths").val()).length == 0)
				 app.analysisDocument.setDocumentProperty("INAGINGINCREMENT",$("#incrementalMonths").val().toString()); 
			 
			 //User SSO Id 
			 if($("#userSSOId").val() != undefined && !jQuery.trim($("#userSSOId").val()).length == 0)
				 app.analysisDocument.setDocumentProperty("INUSERSSO",$("#userSSOId").val().toString());
		});
        
        $('body').off('change', '#agingMonthsId').on('change', '#agingMonthsId', function(e) {
        	$('#incrementalMonths').prop('disabled', false);
        	var incrementalMonths = $("#defaultNoOfMonths").val() - $("#agingMonthsId").val();
        	$("#incrementalMonths").empty().html();
        	for(var i=1; i<=incrementalMonths; i++) {
        		$("#incrementalMonths").append("<option value='" + i +"'>" + i + "</option>");
        	}
        	$('#incrementalMonths option[value="1"]').attr("selected",true);
        	if($("#agingMonthsId").val() == $("#defaultNoOfMonths").val()){
        		$("#incrementalMonths").append("<option value='" + 0 +"' selected>" + 0 + "</option>");
        	}
        });
		
        $('body').off('click', '#exportResult').on('click', '#exportResult', function(e) {
			e.preventDefault();
			$('#generateReport').click();
			assignValues(); 
			var url = contextURL +"/int/reports/exportAgingReportResults.action";
			$('#agingReportForm').attr('action', url);
        	$('#agingReportForm').submit();			
			
		});
        
        $('body').off('click', '#resetClick').on('click', '#resetClick', function(e) {
        	var months = $("#defaultNoOfMonths").val();
        	// clearing the filter criteria
        	$('input:checkbox').removeAttr('checked');
         	$('input:radio').removeAttr('checked');
         	$("input[type=text]").val('');
         	$("#agingMonthsId").val(months);
         	$("#incrementalMonths").append("<option value='" + $("#defaultNoOfMonths").val() +"' selected>" + $("#defaultNoOfMonths").val() + "</option>");
        	
         	$('#incrementalMonths').prop('disabled', true);
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
         	$("#reportGridId").css({visibility:"hidden"});
         	$('#blankMessage').css({'display' : 'none'});
        });
		
        $('body').off('click', '.checkall').on('click', '.checkall', function(e) {
			if ($(e.target).is(":checked")) {
				$(e.target).closest("tr").find(':checkbox').attr('checked', true);
			} else {
				$(e.target).closest("tr").find(':checkbox').attr('checked', false);
			}
		});
        
        $('body').off('click', '.checkallinsType').on('click', '.checkallinsType', function(e) {
			if ($(e.target).is(":checked")) {
				$(e.target).closest("tr").find(':checkbox').attr('checked', true);
			} else {
				$(e.target).closest("tr").find(':checkbox').attr('checked', false);
			}
		});
		
        $('body').off('click', '#selectallId').on('click', '#selectallId', function(e) {
			if ($(e.target).is(":checked")) {
				$(e.target).closest("tbody").find(':checkbox').attr('checked', true);
			} else {
				$(e.target).closest("tbody").find(':checkbox').attr('checked', false);
			}
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
	    $('.acc_triggerA').addClass('acc_active').next().next().show();
	    $("#reportGridId").css({visibility:"hidden"});	
	});
	
	function assignValues(){
		 var insPurpose = new Array();
		 var i=0;
  	 	 $('.instrPurpose').each(function() {
  	 		 if($(this).attr('checked') == 'checked'){
  	 			 insPurpose[i] =  $(this).val();
  	 		 }
  	 		 i++;
  	 	 });
  	 	 insPurpose =  insPurpose.toString().replace(",,,,,",",").replace(",,,,",",").replace(",,,",",").replace(",,",",");
      	 if(insPurpose.charAt(0) == ','){
      		insPurpose = insPurpose.replace(',','');
      	 }
      	 
      	 // Instrument Type
      	 var bankGuaranteeCheck = $("#bankGuaranteeCheck:checked").val();
      	 var standbyLetterCheck = $("#standbyLetterCheck:checked").val();
      	 var suretyBondCheck    = $("#suretyBondCheck:checked").val();
      	 var allCheckId         = $("#allCheckId:checked").val();

      	 var selectedInsType = '';
		 //User SSO Id 
		 if($("#userSSOId").val() != undefined && !jQuery.trim($("#userSSOId").val()).length == 0)
		 var loginuserSSO ='';
		 loginuserSSO = $("#userSSOId").val();
		 $("#loginUserId").val(loginuserSSO);
		
		
		if(allCheckId == 'true') {
			selectedInsType = '1,2,3';
		}else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == undefined && suretyBondCheck == undefined && allCheckId == undefined) {
	    	selectedInsType = '1';
		}else if (bankGuaranteeCheck == undefined && standbyLetterCheck == 'true' && suretyBondCheck == undefined && allCheckId == undefined) {
			selectedInsType = '2';
		}else if (bankGuaranteeCheck == undefined && standbyLetterCheck == undefined && suretyBondCheck == 'true' && allCheckId == undefined) {
			selectedInsType = '3';
		}else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == undefined && suretyBondCheck == 'true' && allCheckId == undefined) {
			selectedInsType = '1,3';
		}else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == 'true' && suretyBondCheck == undefined && allCheckId == undefined){
			selectedInsType = '1,2';
		}else if (bankGuaranteeCheck == undefined && standbyLetterCheck == 'true' && suretyBondCheck == 'true' && allCheckId == undefined){ 
			selectedInsType = '2,3';
		}else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == 'true' && suretyBondCheck == 'true' && allCheckId == undefined) {
			selectedInsType = '1,2,3';
		}
		
		if(!jQuery.trim(selectedInsType).length == 0)
			$("#instPurposeId").val(selectedInsType);
		
		if($('#applicantPrincipalId').attr('checked'))
			$("#applicantPrincipalId").val('Y');
		else
			$("#applicantPrincipalId").val('');
		
		if($('#beneficiaryId').attr('checked'))
			$("#beneficiaryId").val('Y');
		else
			$("#beneficiaryId").val('');
		
		if($('#beneficiaryRefId').attr('checked'))
			$("#beneficiaryRefId").val('Y');
		else
			$("#beneficiaryRefId").val('');
		
		if($('#countryofIssuanceId').attr('checked'))
			$("#countryofIssuanceId").val('Y');
		else
			$("#countryofIssuanceId").val('');
		
		if($('#obligeeCountryId').attr('checked'))
			$("#obligeeCountryId").val('Y');
		else
			$("#obligeeCountryId").val('');
		
		if($('#geApplicantRefId').attr('checked'))
			$("#geApplicantRefId").val('Y');
		else
			$("#geApplicantRefId").val('');
		
		if($('#leGoldId').attr('checked'))
			$("#leGoldId").val('Y');
		else
			$("#leGoldId").val('');
		
		if($('#instrPurposeId').attr('checked'))
			$("#instrPurposeId").val('Y');
		else
			$("#instrPurposeId").val('');
		
		if($('#instrTypeId').attr('checked'))
			$("#instrTypeId").val('Y');
		else
			$("#instrTypeId").val('');
		
		if($('#siteCodeId').attr('checked'))
			$("#siteCodeId").val('Y');
		else
			$("#siteCodeId").val('');
		
		if($('#gbBundleId').attr('checked'))
			$("#gbBundleId").val('Y');
		else
			$("#gbBundleId").val('');
		
		if(!jQuery.trim($("#availableSites").val()).length == 0){
			var availableSiteInfo = $('#availableSites').val().toString();
			$("#availableSitesId").val(availableSiteInfo);
		}
		else{
			$("#availableSitesId").val('');
		}
		
		if(!jQuery.trim($("#availableBanks").val()).length == 0){
			var availableSiteInfo = $('#availableBanks').val().toString();
			$("#availableBankId").val(availableSiteInfo);
		}
		else{
			$("#availableBankId").val('');
		}
		
		if(!jQuery.trim(insPurpose).length == 0)
			$("#insPurpseValue").val(insPurpose);
	}