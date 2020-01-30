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
		customization.showPageNavigation = false;
		customization.showStatusBar = false;
		
		app = new spotfire.webPlayer.Application($("#spotfireWebplayerURLId").val(), customization);
		// Open an analysis.
		app.open($("#feeProjectionPathId").val(),"webPlayer",'');
		
		$('body').off('click', '#generateReport').on('click', '#generateReport', function(e) { 
     		if(validateFeeProjection()){
	     		$('#feeProjectionIndicator').show();
	     		$('#generateReportId').text("Refresh Report");
	        	var selectedCurrency = $("#instrumentCurrency").val();
	        	$("#morCurErr").hide();
	        	$("#divBorderId2").css("border","none");
	        	if($("#availableSites").val() != undefined && !jQuery.trim($("#availableSites").val()).length == 0){
	        		var availableSiteInfo = $('#availableSites').val().toString();
	        		$("#selectedSiteIds").val(availableSiteInfo);
	        	} else{
	    			$("#selectedSiteIds").val('');
	    		}
	  		   	$.ajax({
	  				type: "POST",
	  				url: contextURL+'/int/reports/getOtherMORRates.action',
	  			    dataType: 'json',
	  			    data: {selectedCurrency : selectedCurrency},
	  			    processdata: true,
	  			    success: function(response) {
	  			    	$('#morRateId').val(response.data);
	  			    	$('#feeProjectionIndicator').hide();
	  			    	generateReport();
	  			    },
	  			    error: function (xhr, textStatus, errorThrown ) {
						$('#feeProjectionIndicator').hide();
						var errorReason = $(xhr.responseText).find('table tbody tr td.errorReason').text();
						$("#morCurErr").html(errorReason.replace(":",""));
						$("#morCurErr").show();
						$("#divBorderId2").css("border","1px solid red");
						$("#reportGridId").css({visibility:"hidden"});
						$('#blankMessage').css({'display' : 'none'});
				    }
	  			});
     		}
      
        });
        
		$('body').off('click', '#exportResult').on('click', '#exportResult', function(e) {
        	if(validateFeeProjection()){
        		$('#generateReport').click();
	        	e.preventDefault();
	        	$("#morBloombergRate").val($("#morRateId").val().replace("'","").replace("'","").toString());
	        	var url = contextURL +"/int/reports/exportFeeProjectionReportDtl.action?fileName="+$('#headerText').text();
	        	if($("#availableSites").val() != undefined && !jQuery.trim($("#availableSites").val()).length == 0){
	        		var availableSiteInfo = $('#availableSites').val().toString();
	        		$("#selectedSiteIds").val(availableSiteInfo);
	        	} else{
	    			$("#selectedSiteIds").val('');
	    		}
				$('#feeProjectionForm').attr('action', url);
		        $('#feeProjectionForm').submit();
        	}
		});
	  
	   $('body').off('click', '#selectProjTypeId').on('click', '#selectProjTypeId', function(e) {
		    $('#bankNameId').siblings('.ui-autocomplete-input').val('');
		    $('#issuanceCountry').siblings('.ui-autocomplete-input').val('');
		    $('#applicantName').siblings('.ui-autocomplete-input').val('');
		    $('#benficiaryName').siblings('.ui-autocomplete-input').val('');
		    $('#bundleId').siblings('.ui-autocomplete-input').val('');
		    $('#bankName').val('');
		    $('#countryName').val('');
		    $('#bankNameId').val('');
		    $('#issuanceCountry').val('');
		    $('#applicantName').val('');
		    $('#benficiaryName').val('');
		    $('#bundleId').val('');
		    
		    $("#selectedFilterBorderId").css("border","none");
			if($("#selectProjTypeId").val() == 'Applicant'){
				$("#bankId").hide();
				$("#countryId").hide();
				$("#benificiaryId").hide();
				$("#applicantId").show();
				$("#bundleBorderId").hide();
			}
			else if($("#selectProjTypeId").val() == 'Bank'){
				$("#applicantId").hide();
				$("#benificiaryId").hide();
				$("#countryId").hide();
				$("#bankId").show();
				$("#bundleBorderId").hide();
			}
			else if($("#selectProjTypeId").val() == 'Beneficiary'){
				$("#applicantId").hide();
				$("#bankId").hide();
				$("#countryId").hide();
				$("#benificiaryId").show();
				$("#bundleBorderId").hide();
			}
			else if($("#selectProjTypeId").val() == 'Country'){
				$("#applicantId").hide();
				$("#bankId").hide();
				$("#benificiaryId").hide();
				$("#countryId").show();
				$("#bundleBorderId").hide();
			} 
			else if($("#selectProjTypeId").val() == 'BundleID'){
				$("#applicantId").hide();
				$("#bankId").hide();
				$("#benificiaryId").hide();
				$("#countryId").hide();
				$("#bundleBorderId").show();
			} 
			else{
				$("#applicantId").hide();
				$("#bankId").hide();
				$("#countryId").hide();
				$("#benificiaryId").hide();
				$("#bundleBorderId").hide();
			}
	   });
    
	   $('body').off('click', '#resetClick').on('click', '#resetClick', function(e) {
		   $("#reportGridId").css({visibility:"hidden"});
		   $('#blankMessage').css({'display' : 'none'});
		   $("input[type=text]").val('');
		   $("#selectProjTypeId").val("");
		   $("#selectMonthId").val("");
		   
		   $("#applicantId").hide();
		   $("#bankId").hide();
		   $("#countryId").hide();
		   $("#benificiaryId").hide();
		   
		   $.ajax({
			 	type: "POST",
	            url: contextURL+'/int/reports/resetSiteNames.action',
	            dataType: 'html',
	            processdata: true,
	            success: function(data) {
	            	$("#siteSelection").empty().append(data);
	            }
		   });
		   
		   $('#instrumentCurrency').val("USD");
		   $("#filterDivId").removeClass("show").addClass("hide");
	       $("#benificiaryDivId").removeClass("show").addClass("hide");
	   	   $("#countryDivId").removeClass("show").addClass("hide");
	   	   $("#bankDivId").removeClass("show").addClass("hide");
	   	   $("#applicantrDivId").removeClass("show").addClass("hide");
	       $("#bundleDivId").removeClass("show").addClass("hide");
		   $("#filterBorderId").css("border","none");
		   $("#divBorderId1").css("border","none");
		   $("#selectedFilterBorderId").css("border","none");
		   $('.optOutval-error1').text("");
       	   $('.optOutval-error2').text("");
       	   $('.optOutval-error3').text("");
       	   $("#divBorderId2").css("border","none");
       	   $("#morCurErr").hide();
	  });
	   
	   $.subscribe('getReportAutocompleterName', function(event,data) {
			var ui = event.originalEvent.ui;
			var codeTextField = $("#"+data.id).parents('div.span5').children("input:first").attr("id");
			var textField = $("#"+data.id).parents('div.span5').find(".autoCompleterName").attr("id");
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
	  $("#reportGridId").css({visibility:"hidden"});
	  $('.acc_triggerA').addClass('acc_active').next().next().show();
});
	
function generateReport() {
	$("#morBloombergRate").val($("#morRateId").val().replace("'","").replace("'","").toString());
	$('#blankMessage').css({'display' : 'none'});
	var url = contextURL +"/int/reports/recordCountForFeeProjection.action";		
	$.ajax({
		type: "POST",
		url: url,
		dataType: 'json',
		data: $("#feeProjectionForm").serialize(),// serializes the form's elements.
		processdata: true,
		success: function(response){
			if((response.data == 0)){
				$('#blankMessage').css({'display' : 'block'});
			} else {
				$('#blankMessage').css({'display' : 'none'});
			}
		},
		error: function (xhr, textStatus, errorThrown ) {
		}
	}); 
	$("#reportGridId").css({visibility:"visible"});
	$('#generateButtonId').text("Refresh Report");
	$("#reportDescId").css({display:"block"});
	setTimeout( "$('#reportDescId').hide();", 8000);
	if($("#selectProjTypeId").val()=="Applicant" && !jQuery.trim($("#applicantName").val()).length == 0){
		app.analysisDocument.setDocumentProperty("INAPPLNAME",$("#applicantName").val().toString());
		app.analysisDocument.setDocumentProperty("INISSUERID",'');
		app.analysisDocument.setDocumentProperty("INBENENAME",'');
		app.analysisDocument.setDocumentProperty("INCUNTRYISSUANCE",'');
		app.analysisDocument.setDocumentProperty("INBUNDLEID",'');
		$('#headerText').text("Projected Fees For Period  " +$("#selectMonthId").val().toString()+ " Months By " +$("#applicantName").val().toString());
        $('#headerText').css({'display' : 'block'});
        $('#headerText').css({'font-size':'142%'});
	}
	if($("#selectProjTypeId").val()=="Bank" && !jQuery.trim($("#bankNameId").val()).length == 0){
		app.analysisDocument.setDocumentProperty("INISSUERID",$("#bankNameId").val().toString());
		app.analysisDocument.setDocumentProperty("INAPPLNAME",'');
		app.analysisDocument.setDocumentProperty("INBENENAME",'');
		app.analysisDocument.setDocumentProperty("INCUNTRYISSUANCE",'');
		app.analysisDocument.setDocumentProperty("INBUNDLEID",'');
		$('#headerText').text("Projected Fees For Period  " +$("#selectMonthId").val().toString()+ " Months By " +$("#bankName").val().toString());
        $('#headerText').css({'display' : 'block'});
        $('#headerText').css({'font-size':'142%'});
	}
	if($("#selectProjTypeId").val()=="Beneficiary" && !jQuery.trim($("#benficiaryName").val()).length == 0){
		app.analysisDocument.setDocumentProperty("INBENENAME",$("#benficiaryName").val().toString());
		app.analysisDocument.setDocumentProperty("INAPPLNAME",'');
		app.analysisDocument.setDocumentProperty("INISSUERID",'');
		app.analysisDocument.setDocumentProperty("INCUNTRYISSUANCE",'');
		app.analysisDocument.setDocumentProperty("INBUNDLEID",'');
		$('#headerText').text("Projected Fees For Period  " +$("#selectMonthId").val().toString()+ " Months By " +$("#benficiaryName").val().toString());
        $('#headerText').css({'display' : 'block'});
        $('#headerText').css({'font-size':'142%'});
	}
	if($("#selectProjTypeId").val()=="Country" && !jQuery.trim($("#issuanceCountry").val()).length == 0){
		app.analysisDocument.setDocumentProperty("INCUNTRYISSUANCE",$("#issuanceCountry").val().toString());
		app.analysisDocument.setDocumentProperty("INAPPLNAME",'');
		app.analysisDocument.setDocumentProperty("INISSUERID",'');
		app.analysisDocument.setDocumentProperty("INBENENAME",'');
		app.analysisDocument.setDocumentProperty("INBUNDLEID",'');
		$('#headerText').text("Projected Fees For Period  " +$("#selectMonthId").val().toString()+ " Months By " +$("#countryName").val().toString());
        $('#headerText').css({'display' : 'block'});
        $('#headerText').css({'font-size':'142%'});
	}
	if($("#selectProjTypeId").val()=="BundleID" && !jQuery.trim($("#bundleId").val()).length == 0){
		app.analysisDocument.setDocumentProperty("INCUNTRYISSUANCE",'');
		app.analysisDocument.setDocumentProperty("INAPPLNAME",'');
		app.analysisDocument.setDocumentProperty("INISSUERID",'');
		app.analysisDocument.setDocumentProperty("INBENENAME",'');
		app.analysisDocument.setDocumentProperty("INBUNDLEID",$("#bundleId").val().toString());
		$('#headerText').text("Projected Fees For Period  " +$("#selectMonthId").val().toString()+ " Months By " +$("#bundleId").val().toString());
        $('#headerText').css({'display' : 'block'});
        $('#headerText').css({'font-size':'142%'});
	}
	
	if($("#availableSites").val() != undefined && !jQuery.trim($("#availableSites").val()).length == 0)
			app.analysisDocument.setDocumentProperty("INSITEID",$("#availableSites").val().toString());
	else
		app.analysisDocument.setDocumentProperty("INSITEID",'');
	
	app.analysisDocument.setDocumentProperty("INNUMMONTHS",$("#selectMonthId").val().toString());
	app.analysisDocument.setDocumentProperty("INMORRATE",$("#morRateId").val().replace("'","").replace("'","").toString());
}  
  
function validateFeeProjection(){
	   var filterValue = $("#selectProjTypeId").val();
	   var applicantValue = $("#applicantName").val();
	   var bankValue = $("#bankNameId").val();
	   var benfValue = $("#benficiaryName").val();
	   var issCountryValue = $("#issuanceCountry").val();
	   var bundleValue = $("#bundleId").val();
	   var filterCheck = true;
	  
	   if(jQuery.trim(filterValue).length == 0){
           $("#filterDivId").removeClass("hide").addClass("show");
 		   $("#filterBorderId").css("border","1px solid red");
 		   $("#reportGridId").css({visibility:"hidden"});
 		   $('#blankMessage').css({'display' : 'none'});
 		   $('.optOutval-error1').text("Please select Filter by").removeClass("hide").addClass("show");
 		   filterCheck = false;
        }
        else if(filterValue == "Applicant" && jQuery.trim(applicantValue).length == 0){
           $("#filterDivId").removeClass("show").addClass("hide");
		   $("#filterBorderId").css("border","none");
           $("#applicantDivId").removeClass("hide").addClass("show");
   		   $("#selectedFilterBorderId").css("border","1px solid red");
   		   $("#reportGridId").css({visibility:"hidden"});
   		   $('#blankMessage').css({'display' : 'none'});
   		   $('.optOutval-error2').text("Please enter Applicant").removeClass("hide").addClass("show");
   		   filterCheck = false;
        }
        else if(filterValue == "Bank" && jQuery.trim(bankValue).length == 0){
            $("#filterDivId").removeClass("show").addClass("hide");
 		    $("#filterBorderId").css("border","none");
            $("#bankDivId").removeClass("hide").addClass("show");
    		$("#selectedFilterBorderId").css("border","1px solid red");
    		$("#reportGridId").css({visibility:"hidden"});
    		$('#blankMessage').css({'display' : 'none'});
    		$('.optOutval-error2').text("Please enter Bank").removeClass("hide").addClass("show");
    		filterCheck = false;
        }
        else if(filterValue == "Country" && jQuery.trim(issCountryValue).length == 0){
            $("#filterDivId").removeClass("show").addClass("hide");
 		    $("#filterBorderId").css("border","none");
            $("#countryDivId").removeClass("hide").addClass("show");
    		$("#selectedFilterBorderId").css("border","1px solid red");
    		$("#reportGridId").css({visibility:"hidden"});
    		$('#blankMessage').css({'display' : 'none'});
    		$('.optOutval-error2').text("Please enter Country").removeClass("hide").addClass("show");
    		filterCheck = false;
        }
        else if(filterValue == "Beneficiary" && jQuery.trim(benfValue).length == 0){
            $("#filterDivId").removeClass("show").addClass("hide");
 		    $("#filterBorderId").css("border","none");
            $("#benificiaryDivId").removeClass("hide").addClass("show");
    		$("#selectedFilterBorderId").css("border","1px solid red");
    		$("#reportGridId").css({visibility:"hidden"});
    		$('#blankMessage').css({'display' : 'none'});
    		$('.optOutval-error2').text("Please enter Beneficiary").removeClass("hide").addClass("show");
    		filterCheck = false;
        }
        else if(filterValue == "BundleID" && jQuery.trim(bundleValue).length == 0){
            $("#filterDivId").removeClass("show").addClass("hide");
 		    $("#filterBorderId").css("border","none");
            $("#bundleDivId").removeClass("hide").addClass("show");
    		$("#selectedFilterBorderId").css("border","1px solid red");
    		$("#reportGridId").css({visibility:"hidden"});
    		$('#blankMessage').css({'display' : 'none'});
    		$('.optOutval-error2').text("Please enter Bundle ID").removeClass("hide").addClass("show");
    		filterCheck = false;
        }
        
        else{
        	$('.optOutval-error1').text("");
        	$('.optOutval-error2').text("");
        	$("#filterDivId").removeClass("show").addClass("hide");
        	$("#benificiaryDivId").removeClass("show").addClass("hide");
        	$("#countryDivId").removeClass("show").addClass("hide");
        	$("#bankDivId").removeClass("show").addClass("hide");
        	$("#applicantrDivId").removeClass("show").addClass("hide");
        	$("#bundleDivId").removeClass("show").addClass("hide");
			$("#filterBorderId").css("border","none");
			$("#selectedFilterBorderId").css("border","none");
			$("#filterBorderId").css("border","none");
        }
        	
        if( $("#selectMonthId").val()  == "" || jQuery.trim( $("#selectMonthId").val() ).length == 0){
        	
        	$("#monthsDivId").removeClass("hide").addClass("show");
        	$("#reportGridId").css({visibility:"hidden"});
        	$('#blankMessage').css({'display' : 'none'});
        	$("#divBorderId1").css("border","1px solid red");
    		$('.optOutval-error3').text("Please Enter number of months").removeClass("hide").addClass("show");
    		filterCheck = false;
        }
        
        else{
        	$('.optOutval-error3').text("");
        	$("#monthsDivId").removeClass("show").addClass("hide");
			$("#divBorderId1").css("border","none");
        }
		if(filterCheck == false)
			return false;
		else
			return true;
   }