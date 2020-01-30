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
		customization.showPageNavigation = true;
		customization.showStatusBar = false;
		
		spotfireApp = new spotfire.webPlayer.Application($("#spotfireWebplayerURLId").val(), customization);
		spotfireApp.open($("#feeQuotationPathId").val(),"webPlayer",'');
		
		$('body').off('click', '#generateReport').on('click', '#generateReport', function(e) {
			 $("#quotationDateDivId").removeClass("show").addClass("hide");
			 $("#feeForecastDateDivId").removeClass("show").addClass("hide");
			 $("#divBorderId").css("border","0px solid red");
			 $("#divBorderId1").css("border","0px solid red");
			 
			if(validateFeeQuotation()){
				if(!(jQuery.trim($('#availableBanks').val()).length == 0)){
		        	var selectedBanks = $('#availableBanks').val().toString();
		        	$('#bankSelectionId').val(selectedBanks);
		        }
				$('#blankMessage').css({'display' : 'none'});
        		var url = contextURL +"/int/reports/recordCountForFeeQuotation.action";
     			$.ajax({
     				type: "POST",
     				url: url,
     				dataType: 'json',
     				data: $("#feeQuotationForm").serialize(),// serializes the form's elements.
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
				setTimeout( "$('#reportDescId').hide();",8000);
				$('#headerText').text("Fee Quotation Report for Analysis Period of " +$("#quotationDatefromId").val().toString()+ " to " +$("#quotationDatetoId").val().toString());
	            $('#headerText').css({'display' : 'block'});
	            $('#headerText').css({'font-size':'90%'});
	            $('#headerText1').css({'display' : 'block'});
	            $('#headerText2').css({'display' : 'block'});
					
				spotfireApp.analysisDocument.setDocumentProperty("INFEEQUOTEMINDT",$("#quotationDatefromId").val().toString());
				spotfireApp.analysisDocument.setDocumentProperty("INFEEQUOTEMAXDT",$("#quotationDatetoId").val().toString());
			
				spotfireApp.analysisDocument.setDocumentProperty("INFEEFORECASTMINDT",$("#feeForecastDatefromId").val().toString());
				spotfireApp.analysisDocument.setDocumentProperty("INFEEFORECASTMAXDT",$("#feeForecastDatetoId").val().toString());
				
				//Issuer
				if(!(jQuery.trim($('#availableBanks').val()).length == 0)){
					spotfireApp.analysisDocument.setDocumentProperty("INISSUER", $('#availableBanks').val().toString());
				}
				else{
					spotfireApp.analysisDocument.setDocumentProperty("INISSUER", '');
				}
				// Country
				if(!(jQuery.trim($("#issuanceCountry").val()).length == 0)){
					spotfireApp.analysisDocument.setDocumentProperty("INCUNTRYISSU", $("#issuanceCountry").val().toString());
				}
				else{
					spotfireApp.analysisDocument.setDocumentProperty("INCUNTRYISSU", '');
				}
						
				// Site Id
				if(!(jQuery.trim($("#siteId").val()).length == 0)){
					spotfireApp.analysisDocument.setDocumentProperty("INSITEID", $("#siteId").val().toString());
				}
				else{
					spotfireApp.analysisDocument.setDocumentProperty("INSITEID",'');
				}
			}
		});
		
		var currentDate = $.datepicker.formatDate('mm/dd/yy', new Date());
        $("#quotationDatetoId").val(currentDate.toString());
        
		$.subscribe('getReportAutocompleterName',function(event,data){
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
		
		$('body').off('click', '#exportResult').on('click', '#exportResult', function(e) {
	        e.preventDefault();
	        $('#generateReport').click();
	        var url = contextURL +"/int/reports/exportFeeQuotationReportResults.action?fileName="+$('#headerText').text();
	        if(!(jQuery.trim($('#availableBanks').val()).length == 0)){
	        	var selectedBanks = $('#availableBanks').val().toString();
	        	$('#bankSelectionId').val(selectedBanks);
	        }
	        $('#feeQuotationForm').attr('action', url);
	        $('#feeQuotationForm').submit();
		});
		
		$('body').off('click', '#resetClick').on('click', '#resetClick', function(e) {
			// clearing the filter criteria
	    	$('input:checkbox').removeAttr('checked');
	     	$('input:radio').removeAttr('checked');
	     	$("input[type=text]").val('');
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
	    	$('#headerText').css({'display' : 'none'});
	        $('#headerText1').css({'display' : 'none'});
	        $('#headerText2').css({'display' : 'none'});
	    	var currentDate = $.datepicker.formatDate('mm/dd/yy', new Date());
	        $("#quotationDatetoId").val(currentDate.toString());
		});
		
		$('.acc_triggerA').addClass('acc_active').next().next().show();
		$("#reportGridId").css({visibility:"hidden"});
	});
    
    function validateFeeQuotation(){
		 var quotationDate = true;
		 var forecastDate = true;
		 
		 var quotationFromDate = $("#quotationDatefromId").val();
		 var quotationToDate = $("#quotationDatetoId").val();
		 var feeForecastFromDate = $("#feeForecastDatefromId").val();
		 var feeForecastToDate = $("#feeForecastDatetoId").val();
		 var currentDate = $.datepicker.formatDate('mm/dd/yy', new Date());
		 
		 if((jQuery.trim(quotationFromDate).length == 0 && jQuery.trim(quotationToDate).length == 0)){
			 $("#quotationDateDivId").removeClass("hide").addClass("show");
			 $('.optOutval-error').text("Please enter Fee Quotation Start & End Date").removeClass("hide").addClass("show");
			 $("#reportGridId").css({visibility:"hidden"});
			 $('#blankMessage').css({'display' : 'none'});
			 $("#divBorderId").css("border","1px solid red");
			 quotationDate = false;
		 }
		 
		 else if(jQuery.trim(quotationFromDate).length == 0){
			 $("#quotationDateDivId").removeClass("hide").addClass("show");
			 $('.optOutval-error').text("Please enter Fee Quotation Start Date").removeClass("hide").addClass("show");
			 $("#reportGridId").css({visibility:"hidden"});
			 $('#blankMessage').css({'display' : 'none'});
			 $("#divBorderId").css("border","1px solid red");
			 quotationDate = false;
		 }
		 
		 else if(jQuery.trim(quotationToDate).length == 0){
			 $("#quotationDateDivId").removeClass("hide").addClass("show");
			 $('.optOutval-error').text("Please enter Fee Quotation End Date").removeClass("hide").addClass("show");
			 $("#reportGridId").css({visibility:"hidden"});
			 $('#blankMessage').css({'display' : 'none'});
			 $("#divBorderId").css("border","1px solid red");
			 quotationDate = false;
		 }
		 
		 else if(new Date(quotationToDate) > new Date(currentDate)){
			 $("#quotationDateDivId").removeClass("hide").addClass("show");
			 $('.optOutval-error').text("Fee Quotation End Date should not be future date").removeClass("hide").addClass("show");
			 $("#reportGridId").css({visibility:"hidden"});
			 $('#blankMessage').css({'display' : 'none'});
			 $("#divBorderId").css("border","1px solid red");
			 quotationDate = false;
		 }
		 
		 else if(new Date(quotationFromDate) > new Date(quotationToDate)){
			 $("#quotationDateDivId").removeClass("hide").addClass("show");
			 $('.optOutval-error').text("Fee Quotation Start Date should be less than End Date").removeClass("hide").addClass("show");
			 $("#reportGridId").css({visibility:"hidden"});
			 $('#blankMessage').css({'display' : 'none'});
			 $("#divBorderId").css("border","1px solid red");
			 quotationDate = false;
		 }
		 
		 if((jQuery.trim(feeForecastFromDate).length == 0 && jQuery.trim(feeForecastToDate).length == 0)){
			 $("#feeForecastDateDivId").removeClass("hide").addClass("show");
			 $('.optOutval-error1').text("Please enter Fee Forecast Start & End Date").removeClass("hide").addClass("show");
			 $("#reportGridId").css({visibility:"hidden"});
			 $('#blankMessage').css({'display' : 'none'});
			 $("#divBorderId1").css("border","1px solid red");
			 forecastDate = false;
		 }
		 
		 else if((jQuery.trim(feeForecastFromDate).length == 0)){
			 $("#feeForecastDateDivId").removeClass("hide").addClass("show");
			 $('.optOutval-error1').text("Please enter Fee Forecast Start Date").removeClass("hide").addClass("show");
			 $("#reportGridId").css({visibility:"hidden"});
			 $('#blankMessage').css({'display' : 'none'});
			 $("#divBorderId1").css("border","1px solid red");
			 forecastDate = false;
		 }
		 
		 else if((jQuery.trim(feeForecastToDate).length == 0)){
			 $("#feeForecastDateDivId").removeClass("hide").addClass("show");
			 $('.optOutval-error1').text("Please enter Fee Forecast End Date").removeClass("hide").addClass("show");
			 $("#reportGridId").css({visibility:"hidden"});
			 $('#blankMessage').css({'display' : 'none'});
			 $("#divBorderId1").css("border","1px solid red");
			 forecastDate = false; 
		 }
		 else if(new Date(feeForecastFromDate) < new Date(currentDate)){
			 $("#feeForecastDateDivId").removeClass("hide").addClass("show");
			 $('.optOutval-error1').text("Forecast Start Date should not be previous date").removeClass("hide").addClass("show");
			 $("#reportGridId").css({visibility:"hidden"});
			 $('#blankMessage').css({'display' : 'none'});
			 $("#divBorderId1").css("border","1px solid red");
			 forecastDate = false;
		 }
		 else if(new Date(feeForecastToDate) < new Date(currentDate)){
			 $("#feeForecastDateDivId").removeClass("hide").addClass("show");
			 $('.optOutval-error1').text("Forecast End Date should not be previous date").removeClass("hide").addClass("show");
			 $("#reportGridId").css({visibility:"hidden"});
			 $('#blankMessage').css({'display' : 'none'});
			 $("#divBorderId1").css("border","1px solid red");
			 forecastDate = false;
		 }
		 
		 else if(new Date(feeForecastToDate) < new Date(feeForecastFromDate)){
			 $("#feeForecastDateDivId").removeClass("hide").addClass("show");
			 $('.optOutval-error1').text("Forecast Start Date should be less than End Date").removeClass("hide").addClass("show");
			 $("#reportGridId").css({visibility:"hidden"});
			 $('#blankMessage').css({'display' : 'none'});
			 $("#divBorderId1").css("border","1px solid red");
			 forecastDate = false;
		 }
		 
         if(quotationDate == false || forecastDate == false)
        	 return false;
         else
        	 return true;
	}
    
    function isDate(txtDate){
		  var currVal = txtDate;
	      if(currVal == ''){
	    	  $('.optOutval-error1').text("Please enter valid Quotation & Forecast Dates").removeClass("hide").addClass("show");
			     return false;
	      }
        
		  //Declare Regex 
		  var rxDatePattern = /^(\d{4})(\/|-)(\d{1,2})(\/|-)(\d{1,2})$/;
		  var dtArray = currVal.match(rxDatePattern); // is format OK?
		  if (dtArray == null){
	    	  $('.optOutval-error1').text("Please enter valid Quotation & Forecast Dates").removeClass("hide").addClass("show");
			     return false;
	      }
		  //Checks for yyyy/mm/dd format.
		  dtYear = dtArray[1];
		  dtMonth= dtArray[3];
		  dtDay = dtArray[5];
		  if (dtMonth < 1 || dtMonth > 12){
			  $('.optOutval-error1').text("Please enter valid Quotation & Forecast Dates").removeClass("hide").addClass("show");
		      return false;
		  }
		  else if (dtDay < 1 || dtDay> 31){
			  $('.optOutval-error1').text("Please enter valid Quotation & Forecast Dates").removeClass("hide").addClass("show");
		      return false;
		  }
		  else if ((dtMonth==4 || dtMonth==6 || dtMonth==9 || dtMonth==11) && dtDay ==31){
			  $('.optOutval-error1').text("Please enter valid Quotation & Forecast Dates").removeClass("hide").addClass("show");
		      return false;
		  }
		  else if (dtMonth == 2)
		  {
			  
		     var isleap = (dtYear % 4 == 0 && (dtYear % 100 != 0 || dtYear % 400 == 0));
		     if (dtDay> 29 || (dtDay ==29 && !isleap)){
				  $('.optOutval-error1').text("Please enter valid Quotation & Forecast Dates").removeClass("hide").addClass("show");
			      return false;
			  }
		  }
		  return true;
		}
    
    