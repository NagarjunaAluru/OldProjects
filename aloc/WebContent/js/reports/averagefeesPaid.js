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
		spotfireApp.open($("#averageFeePaidId").val(),"webPlayer",'');
		
		$('body').off('click', '#generateReport').on('click', '#generateReport', function(e) {
			  if(validateAverageFeesPaid()){
				  assignValues();
				  var url = contextURL +"/int/reports/recordCountForAvgFeesPaid.action";
				  $.ajax({
					  type: "POST",
					  url: url,
					  dataType: 'json',
					  data: $("#averageFeesPaidForm").serialize(),// serializes the form's elements.
					  processdata: true,
					  success: function(response){
						if((response.data == 0))
							$('#blankMessage').css({'display' : 'block'});
						},
					  error: function (xhr, textStatus, errorThrown ) {}
					}); 
					
				  $("#reportGridId").css({visibility:"visible"});
				  $('#generateReportId').text("Refresh Report");
				  $("#reportDescId").css({display:"block"});
				  setTimeout( "$('#reportDescId').hide();",8000);
					
				  spotfireApp.analysisDocument.setDocumentProperty("INMINDATE",$("#dateFromId").val().toString());
				  spotfireApp.analysisDocument.setDocumentProperty("INMAXDATE",$("#dateToId").val().toString());
					
				  //Amount Range
				  if(!(jQuery.trim($("#amountRangeId").val()).length == 0))
					  spotfireApp.analysisDocument.setDocumentProperty("INAMTRANGEMIN",$("#amountRangeId").val().toString());
				  else
					  spotfireApp.analysisDocument.setDocumentProperty("INAMTRANGEMIN",'');
					
				  if(!(jQuery.trim($("#amountRangeToId").val()).length == 0))
					  spotfireApp.analysisDocument.setDocumentProperty("INAMTRANGEMAX",$("#amountRangeToId").val().toString());
				  else
					  spotfireApp.analysisDocument.setDocumentProperty("INAMTRANGEMAX",'');
			        
				  //Issuer
				  if($("#bankNameId").val() != undefined && !(jQuery.trim($("#bankNameId").val()).length == 0)){
					  spotfireApp.analysisDocument.setDocumentProperty("INFBNUMBER", '4');
					  spotfireApp.analysisDocument.setDocumentProperty("INFBVALUE", $("#bankNameId").val().toString());
					  $('#headerText').text("Average Fees For Period  " +$("#dateFromId").val().toString()+ " - " +$("#dateToId").val().toString()+ " By " +$('#bankName').val().toString());
		              $('#headerText').css({'display' : 'block'});
		              $('#headerText').css({'font-size':'142%'});
				  }
				  // Country
				  if($("#issuanceCountry").val() != undefined && !(jQuery.trim($("#issuanceCountry").val()).length == 0)){
					  spotfireApp.analysisDocument.setDocumentProperty("INFBNUMBER", '1');
					  spotfireApp.analysisDocument.setDocumentProperty("INFBVALUE", $("#issuanceCountry").val().toString());
					  $('#headerText').text("Average Fees For Period  " +$("#dateFromId").val().toString()+ " - " +$("#dateToId").val().toString()+ " By " +$('#countryName').val().toString());
		              $('#headerText').css({'display' : 'block'});
		              $('#headerText').css({'font-size':'142%'});
				  }
					
				  //applicant
				  if($("#applicantName").val() != undefined  && !(jQuery.trim($("#applicantName").val()).length == 0)){
					  spotfireApp.analysisDocument.setDocumentProperty("INFBNUMBER", '2');
					  spotfireApp.analysisDocument.setDocumentProperty("INFBVALUE", $("#applicantName").val().toString());
					  $('#headerText').text("Average Fees For Period  " +$("#dateFromId").val().toString()+ " - " +$("#dateToId").val().toString()+ " By " +$('#applicantName').val().toString());
		              $('#headerText').css({'display' : 'block'});
		              $('#headerText').css({'font-size':'142%'});
				  }
				  //benficiary
				  if($("#benficiaryName").val() != undefined  && !(jQuery.trim($("#benficiaryName").val()).length == 0)){
					  spotfireApp.analysisDocument.setDocumentProperty("INFBNUMBER", '3');
					  spotfireApp.analysisDocument.setDocumentProperty("INFBVALUE", $("#benficiaryName").val().toString());
					  $('#headerText').text("Average Fees For Period  " +$("#dateFromId").val().toString()+ " - " +$("#dateToId").val().toString()+ " By " +$('#benficiaryName').val().toString());
		              $('#headerText').css({'display' : 'block'});
		              $('#headerText').css({'font-size':'142%'});
				  }
					
				  // Site Id
				  if($("#siteId").val() != undefined  && !(jQuery.trim($("#siteId").val()).length == 0)){
					 spotfireApp.analysisDocument.setDocumentProperty("INFBNUMBER", '5');
					 spotfireApp.analysisDocument.setDocumentProperty("INFBVALUE", $("#siteId").val().toString());
					 $('#headerText').text("Average Fees For Period  " +$("#dateFromId").val().toString()+ " - " +$("#dateToId").val().toString()+ " By " +$('#siteName').val().toString());
		             $('#headerText').css({'display' : 'block'});
		             $('#headerText').css({'font-size':'142%'});
				  }
			  }
		});
		
		$('body').off('click', '#resetClick').on('click', '#resetClick', function(e) {
			   $("#reportGridId").css({visibility:"hidden"});
			   $("input[type=text]").val('');
			   $("#selectProjTypeId").val("");
		   	   $("#dateDivId").removeClass("show").addClass("hide");
			   $("#borderDateId").css("border","none");
			   
			   $("#applicantId").hide();
			   $("#bankId").hide();
			   $("#countryId").hide();
			   $("#benificiaryId").hide();
			   $("#siteNameId").hide();
			   
			   $("#filterDivId").removeClass("show").addClass("hide");
		   	   $("#siteDivId").removeClass("show").addClass("hide");
		       $("#benificiaryDivId").removeClass("show").addClass("hide");
		   	   $("#countryDivId").removeClass("show").addClass("hide");
		   	   $("#bankDivId").removeClass("show").addClass("hide");
		   	   $("#applicantrDivId").removeClass("show").addClass("hide");
			   $("#filterBorderId").css("border","none");
			   $("#selectedFilterBorderId").css("border","none");
			   $("#rangeDivId").removeClass("show").addClass("hide");
			   $("#borderAmountId").css("border","none");
		});
		
		$('body').off('click', '#exportResult').on('click', '#exportResult', function(e) {
	        e.preventDefault();
        	$('#generateReport').click();
        	assignValues();
	        var url = contextURL +"/int/reports/exportAvgFeesPaidDtl.action?fileName="+$('#headerText').text();
	        $('#averageFeesPaidForm').attr('action', url);
	        $('#averageFeesPaidForm').submit();
		});
		$('.acc_triggerA').addClass('acc_active').next().next().show();
		$("#reportGridId").css({visibility:"hidden"});
	});
	
	function assignValues(){
		if($("#bankNameId").val() != undefined && !(jQuery.trim($("#bankNameId").val()).length == 0))
        	$("#inFBValue").val($("#bankNameId").val());
        
        if($("#issuanceCountry").val() != undefined && !(jQuery.trim($("#issuanceCountry").val()).length == 0))
        	$("#inFBValue").val($("#issuanceCountry").val());
        
        if($("#applicantName").val() != undefined  && !(jQuery.trim($("#applicantName").val()).length == 0))
        	$("#inFBValue").val($("#applicantName").val());
        
        if($("#benficiaryName").val() != undefined  && !(jQuery.trim($("#benficiaryName").val()).length == 0))
        	$("#inFBValue").val($("#benficiaryName").val());
        
        if($("#siteId").val() != undefined  && !(jQuery.trim($("#siteId").val()).length == 0))
        	$("#inFBValue").val($("#siteId").val());
	}

/**
 * filter by selection
 */
   function filterSelection(){  
	    $('#bankNameId').siblings('.ui-autocomplete-input').val('');
	    $('#issuanceCountry').siblings('.ui-autocomplete-input').val('');
	    $('#applicantName').siblings('.ui-autocomplete-input').val('');
	    $('#benficiaryName').siblings('.ui-autocomplete-input').val('');
	    $('#siteId').siblings('.ui-autocomplete-input').val('');
	    
	    $('#bankNameId').val('');
	    $('#issuanceCountry').val('');
	    $('#applicantName').val('');
	    $('#benficiaryName').val('');
	    $('#siteId').val('');
	    
	    $("#selectedFilterBorderId").css("border","none");
		if($("#selectProjTypeId").val() == '2'){
			$("#bankId").hide();
			$("#countryId").hide();
			$("#benificiaryId").hide();
			$("#applicantId").show();
			$("#siteNameId").hide();
		}
		else if($("#selectProjTypeId").val() == '4'){
			$("#applicantId").hide();
			$("#benificiaryId").hide();
			$("#countryId").hide();
			$("#bankId").show();
			$("#siteNameId").hide();
		}
		else if($("#selectProjTypeId").val() == '3'){
			$("#applicantId").hide();
			$("#bankId").hide();
			$("#countryId").hide();
			$("#benificiaryId").show();
			$("#siteNameId").hide();
		}
		else if($("#selectProjTypeId").val() == '1'){
			$("#applicantId").hide();
			$("#bankId").hide();
			$("#benificiaryId").hide();
			$("#countryId").show();
			$("#siteNameId").hide();
		} 
		else if($("#selectProjTypeId").val() == '5'){	
			$("#applicantId").hide();
			$("#bankId").hide();
			$("#countryId").hide();
			$("#benificiaryId").hide();
			$("#siteNameId").show();
		}
		else{
			$("#applicantId").hide();
			$("#bankId").hide();
			$("#countryId").hide();
			$("#benificiaryId").hide();
			$("#siteNameId").hide();
		}
	}
    
   function validateAverageFeesPaid(){
	   var inputDateFrom = $("#dateFromId").val();
	   var inputDateTo = $("#dateToId").val();
	   var filterValue = $("#selectProjTypeId").val();
	   var applicantValue = $("#applicantName").val();
	   var bankValue = $("#bankNameId").val();
	   var benfValue = $("#benficiaryName").val();
	   var issCountryValue = $("#issuanceCountry").val();
	   var siteValue = $("#siteId").val();
	   var amountFrom = $("#amountRangeId").val();
	   var amountTo = $("#amountRangeToId").val();
	   var validDateCheck = true;
	   var filterCheck = true;
		
       if((jQuery.trim(inputDateFrom).length == 0) || (jQuery.trim(inputDateTo).length == 0)){
    	   $("#dateDivId").removeClass("hide").addClass("show");
		   $("#borderDateId").css("border","1px solid red");
		   $("#reportGridId").css({visibility:"hidden"});
		   
		   if((jQuery.trim(inputDateFrom).length == 0 && jQuery.trim(inputDateTo).length == 0))
			   $('.optOutval-error').text("Please enter Date from & Date to").removeClass("hide").addClass("show");
		   else if(jQuery.trim(inputDateFrom).length == 0)
			   $('.optOutval-error').text("Please enter Date from").removeClass("hide").addClass("show");
		   else
			   $('.optOutval-error').text("Please enter Date to").removeClass("hide").addClass("show");
		   
		   validDateCheck = false;
		}
        else if(new Date(inputDateFrom) > new Date(inputDateTo)){
        	 $("#dateDivId").removeClass("hide").addClass("show");
  		     $("#borderDateId").css("border","1px solid red");
  		     $("#reportGridId").css({visibility:"hidden"});
  		     $('.optOutval-error').text("Date from should be less than Date to").removeClass("hide").addClass("show");
  		     validDateCheck = false;
		}
        else{
			 $("#dateDivId").removeClass("show").addClass("hide");
			 $("#borderDateId").css("border","none");
		}
       
        if(jQuery.trim(filterValue).length == 0){
           $("#filterDivId").removeClass("hide").addClass("show");
 		   $("#filterBorderId").css("border","1px solid red");
 		   $("#reportGridId").css({visibility:"hidden"});
 		   $('.optOutval-error1').text("Please select Filter by").removeClass("hide").addClass("show");
 		   filterCheck = false;
        }
        else if(filterValue == "2" && jQuery.trim(applicantValue).length == 0){
           $("#filterDivId").removeClass("show").addClass("hide");
		   $("#filterBorderId").css("border","none");
           $("#applicantDivId").removeClass("hide").addClass("show");
   		   $("#selectedFilterBorderId").css("border","1px solid red");
   		   $("#reportGridId").css({visibility:"hidden"});
   		   $('.optOutval-error2').text("Please enter Applicant").removeClass("hide").addClass("show");
   		   filterCheck = false;
        }
        else if(filterValue == "4" && jQuery.trim(bankValue).length == 0){
            $("#filterDivId").removeClass("show").addClass("hide");
 		    $("#filterBorderId").css("border","none");
            $("#bankDivId").removeClass("hide").addClass("show");
    		$("#selectedFilterBorderId").css("border","1px solid red");
    		$("#reportGridId").css({visibility:"hidden"});
    		$('.optOutval-error2').text("Please enter Bank").removeClass("hide").addClass("show");
    		filterCheck = false;
        }
        else if(filterValue == "1" && jQuery.trim(issCountryValue).length == 0){
            $("#filterDivId").removeClass("show").addClass("hide");
 		    $("#filterBorderId").css("border","none");
            $("#countryDivId").removeClass("hide").addClass("show");
    		$("#selectedFilterBorderId").css("border","1px solid red");
    		$("#reportGridId").css({visibility:"hidden"});
    		$('.optOutval-error2').text("Please enter Country").removeClass("hide").addClass("show");
    		filterCheck = false;
        }
        else if(filterValue == "3" && jQuery.trim(benfValue).length == 0){
            $("#filterDivId").removeClass("show").addClass("hide");
 		    $("#filterBorderId").css("border","none");
            $("#benificiaryDivId").removeClass("hide").addClass("show");
    		$("#selectedFilterBorderId").css("border","1px solid red");
    		$("#reportGridId").css({visibility:"hidden"});
    		$('.optOutval-error2').text("Please enter Beneficiary").removeClass("hide").addClass("show");
    		filterCheck = false;
        }
        else if(filterValue == "5" && jQuery.trim(siteValue).length == 0){
            $("#filterDivId").removeClass("show").addClass("hide");
 		    $("#filterBorderId").css("border","none");
            $("#siteDivId").removeClass("hide").addClass("show");
    		$("#selectedFilterBorderId").css("border","1px solid red");
    		$("#reportGridId").css({visibility:"hidden"});
    		$('.optOutval-error2').text("Please enter Site ID").removeClass("hide").addClass("show");
    		filterCheck = false;
        }
        else{
        	$('.optOutval-error2').text("");
        	$("#filterDivId").removeClass("show").addClass("hide");
        	$("#siteDivId").removeClass("show").addClass("hide");
        	$("#benificiaryDivId").removeClass("show").addClass("hide");
        	$("#countryDivId").removeClass("show").addClass("hide");
        	$("#bankDivId").removeClass("show").addClass("hide");
        	$("#applicantrDivId").removeClass("show").addClass("hide");
			$("#filterBorderId").css("border","none");
			$("#selectedFilterBorderId").css("border","none");
        }
        
        if(!jQuery.trim(amountFrom).length == 0 || !jQuery.trim(amountTo).length == 0){
        	if(isNaN(amountFrom) || isNaN(amountTo)){
        		$("#rangeDivId").removeClass("hide").addClass("show");
   			 	$("#borderAmountId").css("border","1px solid red");
   			 	$('.optOutval-error3').text("Please enter valid Amount Range").removeClass("hide").addClass("show");
   			 	filterCheck = false;
        	}
        	else if(parseInt(amountFrom) > parseInt(amountTo)){
        		$("#rangeDivId").removeClass("hide").addClass("show");
   			 	$("#borderAmountId").css("border","1px solid red");
   			 	$('.optOutval-error3').text("From Amount should not be greater than To Amount").removeClass("hide").addClass("show");
   			 	filterCheck = false;
        	}
        	else{
        		$("#rangeDivId").removeClass("show").addClass("hide");
    			$("#borderAmountId").css("border","none");
        	}
        }
        
        if(validDateCheck == false || filterCheck == false)
	    	return false;
	    else
	    	return true;
   }
   
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