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
		app.open($("#userPathId").val(),"webPlayer",'Parameter.BusinessLocation = {Boston, Seattle};');
		
		$('body').off('click', '#generateReport').on('click', '#generateReport', function(e) {
			if($("#isTreasuryRole").val() == undefined && jQuery.trim($("#availableSites").val()).length == 0){
				$("#validationDivId").css("border","1px solid red");
				$('.optOutval-error').text("Please select atleast one Site").removeClass("hide").addClass("show");
				return false;
			}
		
        	var userReportSSOId = $("#userSSOId").val().toString();
        	$("#userReportSSOId").val(userReportSSOId);        	
        	if($("#availableSites").val() != undefined && !jQuery.trim($("#availableSites").val()).length == 0){
        		var selectedSites = $('#availableSites').val().toString();
        		$('#selectedSiteIds').val(selectedSites);
    		} else{
    			$("#selectedSiteIds").val('');
    		}
        	
        	if($("#availableBanks").val() != undefined && !jQuery.trim($("#availableBanks").val()).length == 0){
    			var availableBanksInfo = $('#availableBanks').val().toString();
    			$("#availableBankId").val(availableBanksInfo);
    		} else{
    			$("#availableBankId").val('');
    		}
        	$('#blankMessage').css({'display' : 'none'});
    		var url = contextURL +"/int/reports/recordCountForUser.action";
 			$.ajax({
 				type: "POST",
 				url: url,
 				dataType: 'json',
 				data: $("#userForm").serialize(),// serializes the form's elements.
 				processdata: true,
 				success: function(response){
 					if((response.data == 0))
 						$('#blankMessage').css({'display' : 'block'});
 				},
 				error: function (xhr, textStatus, errorThrown ) {
 				}
 			}); 
 			 
			$("#reportGridId").css({visibility:"visible"});
			$("#generateUserId").text("Refresh Report");
			setTimeout( "$('#reportDescId').hide();", 4000);
			$(".optOutval-error").removeClass("show").addClass("hide");
			$("#validationDivId").css("border","none");
			$("#reportDescId").css({'display' : 'block'});
			$('#headerText').text("User Report");
            $('#headerText').css({'display' : 'block'});
            $('#headerText').css({'font-size':'140%'});
            
			var status = $("input[name='reportsDetails.userReportDetails[0].status']:checked").val();
			
			if(status =='All')
				app.analysisDocument.setDocumentProperty("INSTATUS",'A');
			
			else if(status =='Enabled')
				app.analysisDocument.setDocumentProperty("INSTATUS",'N');

			else if(status =='Disabled')
				app.analysisDocument.setDocumentProperty("INSTATUS",'Y');
			
			//SSO ID
			if(!(jQuery.trim($("#tpApplicantBCPSSO").val()).length == 0))
				app.analysisDocument.setDocumentProperty("INSSO", $("#tpApplicantBCPSSO").val().toString());
			else
				app.analysisDocument.setDocumentProperty("INSSO", '');
			
			// Site ID
			if(!(jQuery.trim($("#availableSites").val()).length == 0))
				app.analysisDocument.setDocumentProperty("INSITEID", $("#availableSites").val().toString());
			else
				app.analysisDocument.setDocumentProperty("INSITEID",'');
			
			//setting property for Bank ID
			 if(!jQuery.trim($('#availableBanks').val()).length == 0)
				 app.analysisDocument.setDocumentProperty("INBANKID",$('#availableBanks').val().toString());
			 else
				 app.analysisDocument.setDocumentProperty("INBANKID",'');
			 
			//User SSO Id 
			 if($("#userSSOId").val() != undefined && !jQuery.trim($("#userSSOId").val()).length == 0)
				 app.analysisDocument.setDocumentProperty("INUSERSSO",$("#userSSOId").val().toString());
		});
		

		$('body').off('click', '#exportResult').on('click', '#exportResult', function(e) {
        	e.preventDefault();
        	$('#generateReport').click();
        	var url = contextURL +"/int/reports/exportUserReportResults.action";
        	var userReportSSOId = $("#userSSOId").val().toString();
        	$("#userReportSSOId").val(userReportSSOId);
        	
        	if($("#availableSites").val() != undefined && !jQuery.trim($("#availableSites").val()).length == 0){
        		var availableSiteInfo = $('#availableSites').val().toString();
        		$("#selectedSiteIds").val(availableSiteInfo);
        	}	else{
    			$("#selectedSiteIds").val('');
    		}
        	
        	if($("#availableBanks").val() != undefined && !jQuery.trim($("#availableBanks").val()).length == 0){
    			var availableBanksInfo = $('#availableBanks').val().toString();
    			$("#availableBankId").val(availableBanksInfo);
    		} else{
    			$("#availableBankId").val('');
    		}
        	$('#userForm').attr('action', url);
        	$('#userForm').submit();
		});
		
		$('body').off('click', 'a.lookup').on('click', 'a.lookup', function(e){
	    	e.preventDefault();
	    	var scrollTopValue = $(e.target).closest(".row").offset().top;
	  		var url = $(e.target).attr('href');
	  		$(e.target).parents('div.row').find(".lookup-error").empty().addClass("hide").removeClass("show");
	  		var dataValue = $(e.target).siblings(".lookup-filterValue").val();
	  		var userDataLookup = $(e.target).siblings('.userReportClass').val();
	  		if(dataValue == undefined && $(e.target).siblings(".lookup-filterValue").length == 0){
	  			dataValue = $(e.target).closest('.form-row').find('.lookup-filterValue').val();
	  			userDataLookup = $(e.target).closest('.form-row').find('.userReportClass').val();
	  		}
	  		if($.trim(dataValue) != ''){
	  			if(userDataLookup != undefined && userDataLookup != '' && userDataLookup == 'userReportType') {
	  			if (dataValue.indexOf(',') > -1) {
	  				$(e.target).parents('div.row').find(".lookup-error").text("Please enter valid SSO/User name").removeClass("hide").addClass("show");
	  				return false;		  			
	  			}
	  			var indicator = $(e.target).parents('div.row').find(".indicator");
	  			$(indicator).show();
	  			$.ajax({
	  				type: "POST",
	  				url: url,
	  				dataType: 'html',
	  				data: {filterValue : $.trim(dataValue), scrollTopValue:scrollTopValue},
	  				success: function(response){
	  					$('#lookupDiv').empty().append(response);
	  					$(indicator).hide();
	  				},
	  				complete : function(jqXHR, status){
	  					if(status == "success"){
	  						$('#mainPage').hide();
	  						$('#lookupDiv').show();
	  						$('#lookupDiv').find('h1').css("visibility","visible");
	  						$(window).scrollTop(0);
	  					}else{
	  						$(indicator).hide();
	  					}
	  				}
	  			});
	  		}else{
	  			$(e.target).parents('div.row').find(".lookup-error").text("Please enter values for Lookup Search").removeClass("hide").addClass("show");
	  			return false;
	  		}
	  		return false;
		}});
		 
		$('body').off('click', '#resetClick').on('click', '#resetClick', function(e) {
			 var radioCheck = $("input[name='reportsDetails.userReportDetails[0].status']:checked").val();
			 if(radioCheck != 'All'){
				$('input:radio').removeAttr('checked');
				$('#statusAll_All').attr('checked', true);
			 }
			 $("#businessContactPersonId").val('');
			 $("#BusinessShow").find(":input").val("");
			 $("#BusinessShow").find("p").text("");
			 $("#BusinessShow").hide();
			 $(".lookup-error").text("");
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
			 $(".optOutval-error").removeClass("show").addClass("hide");
			 $("#validationDivId").css("border","none");
			 $("#reportGridId").css({visibility:"hidden"});
			 $('#blankMessage').css({'display' : 'none'});
         });
		 $("#reportGridId").css({visibility:"hidden"});
	});
	
