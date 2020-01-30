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
		app.open($("#bidSuccessGraphPathId").val(),"webPlayer",'Parameter.BusinessLocation = {Boston, Seattle};');
		
		var currentDate = $.datepicker.formatDate('mm/dd/yy', new Date());
        $("#analysisDatetoId").val(currentDate.toString());
        $("#bankId").attr('checked', true);
        
        $('body').off('click', '#generateReport').on('click', '#generateReport', function(e) {
			$("#validationDivId").css("border","none");
			$(".optOutval-error").text("");
 			$("#analysisDateDivId").addClass("hide");
 			$("#checkBankDivId").addClass("hide");
 			$("#divBorderId").css("border","0px solid red");
 			$("#divBorderId1").css("border","0px solid red");
 			if(validateBidSuccess()){
 				assignValues();
 				$('#blankMessage').css({'display' : 'none'});
 				var url = contextURL +"/int/reports/recordCountForBidSuccess.action";
				$.ajax({
					type: "POST",
					url: url,
					dataType: 'json',
					data: $("#bidSuccessForm").serialize(),// serializes the form's elements.
					processdata: true,
					success: function(response){
						if((response.data == 0))
 							$('#blankMessage').css({'display' : 'block'});
					},
					error: function (xhr, textStatus, errorThrown ) {
					}
				});
		        	
 	        	$("#reportGridId").css({visibility:"visible"});
 	        	$("#exportResultIcon").css({visibility:"visible"});
 	        	$("#reportDescId").css({'display' : 'block'});
				$('#generateButtonId').text("Refresh Report");
				setTimeout( "$('#reportDescId').hide();", 8000);
				
				if($("#availableBanks").val() != undefined && !jQuery.trim($("#availableBanks").val()).length == 0)
					app.analysisDocument.setDocumentProperty("INBANKNAME",$('#availableBanks').val().toString());
				else
					app.analysisDocument.setDocumentProperty("INBANKNAME",'');
				
				if($("#analysisDatefromId").val() != undefined && !jQuery.trim($("#analysisDatefromId").val()).length == 0)
					app.analysisDocument.setDocumentProperty("INANALYSPERIODSTDT",$("#analysisDatefromId").val().toString());
				else
					app.analysisDocument.setDocumentProperty("INANALYSPERIODSTDT",'');
				
				if($("#analysisDatetoId").val() != undefined && !jQuery.trim($("#analysisDatetoId").val()).length == 0)
					app.analysisDocument.setDocumentProperty("INANALYSPERIODENDDT",$("#analysisDatetoId").val().toString()); 
				else
					app.analysisDocument.setDocumentProperty("INANALYSPERIODENDDT",'');
				
				if($('#bankId').attr('checked'))
					app.analysisDocument.setDocumentProperty("INGBBANK",'Y');
				else
					app.analysisDocument.setDocumentProperty("INGBBANK",'');
			
				if($('#countryofIssuance').attr('checked'))	
					app.analysisDocument.setDocumentProperty("INGBCOUNTRYISSUE",'Y');
				else
					app.analysisDocument.setDocumentProperty("INGBCOUNTRYISSUE",'');
	        
				if($('#currencyofIssuance').attr('checked'))
					app.analysisDocument.setDocumentProperty("INGBCURRENCYISSUE",'Y');
				else
					app.analysisDocument.setDocumentProperty("INGBCURRENCYISSUE",'');
	            
				if($('#siteCheckId').attr('checked'))
	           	    app.analysisDocument.setDocumentProperty("INGBSITEID",'Y');
				else
					app.analysisDocument.setDocumentProperty("INGBSITEID",'');
	            
	            if($("#availableSites").val() != undefined && !jQuery.trim($("#availableSites").val()).length == 0)
	            	app.analysisDocument.setDocumentProperty("INSITEID",$("#availableSites").val().toString());
	            else
	            	app.analysisDocument.setDocumentProperty("INSITEID",'');
	            
	            if($("#issuanceCountry").val() != undefined && !jQuery.trim($("#issuanceCountry").val()).length == 0)
	            	app.analysisDocument.setDocumentProperty("INCOUNTRYISSUE",$("#issuanceCountry").val().toString());
	            else
	            	app.analysisDocument.setDocumentProperty("INCOUNTRYISSUE",'');
	            
	            if($("#instrCurrencyId").val() != undefined && !jQuery.trim($("#instrCurrencyId").val()).length == 0)
	            	app.analysisDocument.setDocumentProperty("INCURRENCYISSUE",$("#instrCurrencyId").val().toString());
	            else
	            	app.analysisDocument.setDocumentProperty("INCURRENCYISSUE",'');
	            
	            if($("#userSSOId").val() != undefined && !jQuery.trim($("#userSSOId").val()).length == 0)
	            	app.analysisDocument.setDocumentProperty("INUSERSSO",$("#userSSOId").val().toString());
				
 			}
        });
        
        $('body').off('click', '#exportResult,#exportResultIcon').on('click', '#exportResult,#exportResultIcon', function(e) {
        	$('#generateReport').click();
        	e.preventDefault();
        	var url = contextURL +"/int/reports/exportBidSuccessResults.action";
        	assignValues();
			$('#bidSuccessForm').attr('action', url);
	        $('#bidSuccessForm').submit();			
		});
        
        $('body').off('click', '#resetClick').on('click', '#resetClick', function(e) {
        	$('input:checkbox').removeAttr('checked');
         	$('input:radio').removeAttr('checked');
         	$("input[type=text]").val('');
         	$('#issuanceCountry').val('');
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
            $("#analysisDatetoId").val(currentDate.toString());
            $("#bankId").attr('checked', true);
            $("#groupByDivId").removeClass("show").addClass("hide");
			$("#groupByGridId").css("border","none");
			$("#analysisDateDivId").removeClass("show").addClass("hide");
			$("#validationDivId").css("border","none");
			$(".optOutval-error").text("");
			$("#divBorderId").css("border","none");
		    $("#reportGridId").css({visibility:"hidden"});
		    $('#blankMessage').css({'display' : 'none'});
		    $("#exportResultIcon").css({visibility:"hidden"});
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
        $("#exportResultIcon").css({visibility:"hidden"});
        $('.acc_triggerA').addClass('acc_active').next().next().show();
	});
	
	function assignValues(){
    	if($('#bankId').attr('checked'))
    		$("#bankId").val('Y');
		else 	
			$("#bankId").val('');
	
    	if($('#countryofIssuance').attr('checked'))
			$("#countryofIssuance").val('Y');
		else 
			$("#countryofIssuance").val('');

    	if($('#currencyofIssuance').attr('checked'))
			$("#currencyofIssuance").val('Y');
		else
			$("#currencyofIssuance").val('');
       
    	if($('#siteCheckId').attr('checked'))
			$("#siteCheckId").val('Y');
		else 
			$("#siteCheckId").val('');
		
		if($("#availableSites").val() != undefined && !jQuery.trim($("#availableSites").val()).length == 0){
			var availableSiteInfo = $('#availableSites').val().toString();
			$("#selectedsites").val(availableSiteInfo);
		}
		
		if($("#availableBanks").val() != undefined && !jQuery.trim($("#availableBanks").val()).length == 0){
			var selectedBanksArray = $('#availableBanks').val().toString();
			$("#selectedBanks").val(selectedBanksArray);
    	}
		var userid = '';
		if($("#userSSOId").val().toString() != undefined && !jQuery.trim($("#userSSOId").val().toString()).length == 0)
        	userid = $("#userSSOId").val().toString();
		
		$("#loginUser").val(userid);
    }
	
	function validateBidSuccess(){
		 var bankSelection = true;
		 var analasysDate = true;
		 var groupCheck = true;
		 
		 var banksList = $("#availableBanks").val();
	        if($("#bankSelection").val()!=undefined){
				if(banksList==null){
					 $('.optOutval-error').text("Please select atleast one Bank").removeClass("hide").addClass("show");
					 $("#validationDivId").css("border","1px solid red");
					 $("#reportGridId").css({visibility:"hidden"});
					 $('#blankMessage').css({'display' : 'none'});
					 bankSelection = false;
				}
	        }
	        
	        var analysisFromDate = $("#analysisDatefromId").val();
			var analysisToDate = $("#analysisDatetoId").val();
			if((jQuery.trim(analysisFromDate).length == 0) || (jQuery.trim(analysisToDate).length == 0)){
				 $("#analysisDateDivId").removeClass("hide").addClass("show");
				 $('.optOutval-error1').text("Please enter Analysis Date").removeClass("hide").addClass("show");
				 $("#divBorderId").css("border","1px solid red");
				 $("#reportGridId").css({visibility:"hidden"});
				 $('#blankMessage').css({'display' : 'none'});
				 analasysDate = false;
			}
			if(!(jQuery.trim(analysisFromDate).length == 0) && !(jQuery.trim(analysisToDate).length == 0)){
				var startDate = $('#analysisDatefromId').val();
				var endDate = $('#analysisDatetoId').val();
				if(new Date(startDate) > new Date(endDate))
				{
					$("#analysisDateDivId").removeClass("hide").addClass("show");
					$('.optOutval-error1').text("Analysis From Date should be less than To Date").removeClass("hide").addClass("show");
					$("#divBorderId").css("border","1px solid red");
					$("#reportGridId").css({visibility:"hidden"});
					$('#blankMessage').css({'display' : 'none'});
					analasysDate = false;
				}
				 
			}
			
			 var issuerCheck = $("#bankId:checked").val();
			 var countryCheck = $("#countryofIssuance:checked").val();
			 var currencyCheck = $("#currencyofIssuance:checked").val();
			 var siteCheck = $("#siteCheckId:checked").val();
			 
			 if(issuerCheck == 'true' || countryCheck == 'true' || currencyCheck == 'true' || siteCheck == 'true' ||
				 issuerCheck == 'Y' || countryCheck == 'Y' || currencyCheck == 'Y' || siteCheck == 'Y'){
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
         if(bankSelection == false || analasysDate == false || groupCheck == false)
        	 return false;
         else
        	 return true;
	}

    function isDate(txtDate){
    	var currVal = txtDate;
        if(currVal == ''){
        	$('.optOutval-error1').text("Please enter valid Analysis Dates").removeClass("hide").addClass("show");
		    return false;
        }
		//Declare Regex 
		var rxDatePattern = /^(\d{4})(\/|-)(\d{1,2})(\/|-)(\d{1,2})$/;
		var dtArray = currVal.match(rxDatePattern); // is format OK?
		if (dtArray == null){
	    	 $('.optOutval-error1').text("Please enter valid Analysis Dates").removeClass("hide").addClass("show");
			 return false;
	    }
		//Checks for yyyy/mm/dd format.
		dtYear = dtArray[1];
		dtMonth= dtArray[3];
		dtDay = dtArray[5];
		if (dtMonth < 1 || dtMonth > 12){
			$('.optOutval-error1').text("Please enter valid Analysis Dates").removeClass("hide").addClass("show");
		    return false;
		}
	    else if (dtDay < 1 || dtDay> 31){
			$('.optOutval-error1').text("Please enter valid Analysis Dates").removeClass("hide").addClass("show");
		    return false;
		}
		else if ((dtMonth==4 || dtMonth==6 || dtMonth==9 || dtMonth==11) && dtDay ==31){
			$('.optOutval-error1').text("Please enter valid Analysis Dates").removeClass("hide").addClass("show");
		    return false;
		}
		else if (dtMonth == 2){
		   var isleap = (dtYear % 4 == 0 && (dtYear % 100 != 0 || dtYear % 400 == 0));
		   if (dtDay> 29 || (dtDay ==29 && !isleap)){
			  $('.optOutval-error1').text("Please enter valid Analysis Dates").removeClass("hide").addClass("show");
			  return false;
		   }
		}
		return true;
	}