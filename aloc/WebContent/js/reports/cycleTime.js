// Global declaration of spotfireApp object
	var app1;
	
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
		var groupByValues = "";
        
		app1 = new spotfire.webPlayer.Application($("#spotfireWebplayerURLId").val(), customization);	   
        app1.open($("#cycleTimePathId").val() ,"webPlayer",'');
    	
        $('body').off('click', '#generateReport').on('click', '#generateReport', function(e) {
        	var checkedVals = $('.groupByFilter:checkbox:checked').map(function() {
        	    return this.value;
        	}).get();
        	
        	if(validateCycleTime()){
        		 assignValues();
        		 $('#blankMessage').css({'display' : 'none'});
        		 var url = contextURL +"/int/reports/recordCountForCycleTime.action";
     			 $.ajax({
     				type: "POST",
     				url: url,
     				dataType: 'json',
     				data: $("#cycletimeForm").serialize(),// serializes the form's elements.
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
		        
		       	if(checkedVals.length > 0){
		       		groupByValues = "";
		       		if($('#siteId').attr('checked'))
			       		groupByValues = "Site ID";
		       		if($('#applicantId').attr('checked'))
				    	groupByValues = "Applicant Name"+groupByValues;
		       		if($('#issuerId').attr('checked'))
				    	groupByValues = "Issuer"+groupByValues;
		       		if($('#benficiaryObligeeId').attr('checked'))
				    	groupByValues = "Bene Name"+groupByValues;
		       		if($('#gbBenficiaryCountryId').attr('checked'))
				    	groupByValues = "Bene Country"+groupByValues;
		       	    if($('#countryIssuanceId').attr('checked'))
			        	groupByValues = "Country of Issuance"+groupByValues;
		       	    if($('#instrumentTypeId').attr('checked'))
			        	groupByValues = "Instrument Type"+groupByValues;
		       	    if($('#instrumentPurposeId').attr('checked'))
			        	groupByValues = "Instrument Purpose"+groupByValues;
			       
			        app1.analysisDocument.setDocumentProperty("SELECTEDGROUPBY", groupByValues.toString()); 
		       	}
		       	 
	            // Instrument Type
				var bankGuaranteeCheck = $("#bankGuaranteeCheck:checked").val();
				var standbyLetterCheck = $("#standbyLetterCheck:checked").val();
				var suretyBondCheck    = $("#suretyBondCheck:checked").val();
				var allCheckId         = $("#allCheckId:checked").val();
				
				if (allCheckId == 'true') 
					app1.analysisDocument.setDocumentProperty("ININSTTYPEID",'1,2,3');
				
				else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == undefined && suretyBondCheck == undefined && allCheckId == undefined) 
					app1.analysisDocument.setDocumentProperty("ININSTTYPEID", '1');
				else if (bankGuaranteeCheck == undefined && standbyLetterCheck == 'true' && suretyBondCheck == undefined && allCheckId == undefined) 
					app1.analysisDocument.setDocumentProperty("ININSTTYPEID", '2');
				else if (bankGuaranteeCheck == undefined && standbyLetterCheck == undefined && suretyBondCheck == 'true' && allCheckId == undefined) 
					app1.analysisDocument.setDocumentProperty("ININSTTYPEID", '3');
				else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == undefined && suretyBondCheck == 'true' && allCheckId == undefined) 
					app1.analysisDocument.setDocumentProperty("ININSTTYPEID", '1,3');
				else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == 'true' && suretyBondCheck == undefined && allCheckId == undefined) 
					app1.analysisDocument.setDocumentProperty("ININSTTYPEID", '1,2');
				else if (bankGuaranteeCheck == undefined && standbyLetterCheck == 'true' && suretyBondCheck == 'true' && allCheckId == undefined) 
					app1.analysisDocument.setDocumentProperty("ININSTTYPEID", '2,3');
				else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == 'true' && suretyBondCheck == 'true' && allCheckId == undefined) 
					app1.analysisDocument.setDocumentProperty("ININSTTYPEID", '1,2,3');
				else
					app1.analysisDocument.setDocumentProperty("ININSTTYPEID", '');
				
				
	            if(!jQuery.trim($("#availableSites").val()).length == 0)
	            	app1.analysisDocument.setDocumentProperty("INSITEID",$("#availableSites").val().toString());
	            else
	            	app1.analysisDocument.setDocumentProperty("INSITEID",'');
	            
	            if(!jQuery.trim(insPurpose).length == 0)
	            	app1.analysisDocument.setDocumentProperty("ININSTPURPOSEID",insPurpose.toString());
	            else
	            	app1.analysisDocument.setDocumentProperty("ININSTPURPOSEID",'');
	            
	            if(!jQuery.trim($("#requestDate").val()).length == 0)
	            	app1.analysisDocument.setDocumentProperty("INREQUESTDATE",$("#requestDate").val().toString()); 
	            else
	            	app1.analysisDocument.setDocumentProperty("INREQUESTDATE",'');
	            
	            if(!jQuery.trim($("#expirationDate").val()).length == 0)
	            	app1.analysisDocument.setDocumentProperty("INEXPIRDATE",$("#expirationDate").val().toString()); 
	            else
	            	app1.analysisDocument.setDocumentProperty("INEXPIRDATE",'');
	            
	            if(!jQuery.trim($("#alocRecordId").val()).length == 0)
	            	app1.analysisDocument.setDocumentProperty("INALOCRECORDNUMBER", $("#alocRecordId").val().toString());
	            else
	            	app1.analysisDocument.setDocumentProperty("INALOCRECORDNUMBER",'');
	            
	            if(!jQuery.trim($("#businessUnitCodeId").val()).length == 0)
	            	app1.analysisDocument.setDocumentProperty("INBUCLIKE", $("#businessUnitCodeId").val().toString());
	            else
	            	app1.analysisDocument.setDocumentProperty("INBUCLIKE",'');
	            
	            if(!jQuery.trim($("#accDestibutionNumberId").val()).length == 0)
	            	app1.analysisDocument.setDocumentProperty("INADNLIKE", $("#accDestibutionNumberId").val().toString());
	            else
	            	app1.analysisDocument.setDocumentProperty("INADNLIKE",'');
	            
	            if(!jQuery.trim($("#tripartyApplicantId").val()).length == 0)
	            	app1.analysisDocument.setDocumentProperty("INTPANAMELIKE", $("#tripartyApplicantId").val().toString());
	            else
	            	app1.analysisDocument.setDocumentProperty("INTPANAMELIKE",'');
	            
	            if(!jQuery.trim($("#instruCurrencyId").val()).length == 0)
	            	app1.analysisDocument.setDocumentProperty("INCURRENCYNAME", $("#instruCurrencyId").val().toString());
	            else
	            	app1.analysisDocument.setDocumentProperty("INCURRENCYNAME",'');
	            
	            //Instrument Amount less/greater than or equal to
	            if(!jQuery.trim($("#instrumentAmtFrom").val()).length == 0)
	            	app1.analysisDocument.setDocumentProperty("INOUTSTANDINGAMTMIN", $("#instrumentAmtFrom").val().toString());
	            else
	            	app1.analysisDocument.setDocumentProperty("INOUTSTANDINGAMTMIN",'');
	            
	            if(!jQuery.trim($("#instrumentAmtTo").val()).length == 0)
	            	app1.analysisDocument.setDocumentProperty("INOUTSTANDINGAMTMAX", $("#instrumentAmtTo").val().toString());
	            else
	            	app1.analysisDocument.setDocumentProperty("INOUTSTANDINGAMTMAX",'');
	            
	            if(!jQuery.trim($("#businessContactPersonId").val()).length == 0) 
	            	app1.analysisDocument.setDocumentProperty("INCURRENTCONTACTSSO", $("#tpApplicantBCPSSO").val().toString());
	            else
	            	app1.analysisDocument.setDocumentProperty("INCURRENTCONTACTSSO",'');
	            
	            if(!jQuery.trim($("#benficiaryName").val()).length == 0) 
		            app1.analysisDocument.setDocumentProperty("INBENNAME", $("#benficiaryName").val().toString());	
	            else
	            	app1.analysisDocument.setDocumentProperty("INBENNAME",'');
	            
	            if(!jQuery.trim($("#benficiaryCountryId").val()).length == 0) 
		            app1.analysisDocument.setDocumentProperty("INBENCUNTRY", $("#benficiaryCountryId").val().toString());	
	            else
	            	app1.analysisDocument.setDocumentProperty("INBENCUNTRY",'');
	            
	            if(!jQuery.trim($("#applicantPrincipal").val()).length == 0)
            		app1.analysisDocument.setDocumentProperty("INAPPNAME", $("#applicantPrincipal").val().toString());
	            else
	            	app1.analysisDocument.setDocumentProperty("INAPPNAME",'');
	            
	            if(!jQuery.trim($("#issuerNameId").val()).length == 0) 
	            	app1.analysisDocument.setDocumentProperty("INISSUER", $("#issuerNameId").val().toString());
	            else
	            	app1.analysisDocument.setDocumentProperty("INISSUER",'');
	            
	            if(!jQuery.trim($("#issuerReferemceNumberId").val()).length == 0)
	            	app1.analysisDocument.setDocumentProperty("INBANKREFNUM", $("#issuerReferemceNumberId").val().toString());
	            else
	            	app1.analysisDocument.setDocumentProperty("INBANKREFNUM",'');
	            	
            	if(!jQuery.trim($("#countryofIssuanceId").val()).length == 0)
            		app1.analysisDocument.setDocumentProperty("INCOUNTRYISSUE", $("#countryofIssuanceId").val().toString());
            	 else
 	            	app1.analysisDocument.setDocumentProperty("INCOUNTRYISSUE",'');
            	
            	if(!jQuery.trim($("#userSSOId").val()).length == 0)
            		app1.analysisDocument.setDocumentProperty("INUSERSSO", $("#userSSOId").val().toString());
            	
            	if($("input[type=radio][id=dayHourSelection_Hours]:checked").val() == 'Hours')
     			    app1.analysisDocument.setDocumentProperty("INDAYHOURFLAG", 'H');
     			else if($("input[type=radio][id=dayHourSelection_Days]:checked").val() == 'Days')
     			    app1.analysisDocument.setDocumentProperty("INDAYHOURFLAG", 'D'); 
     			else
     				app1.analysisDocument.setDocumentProperty("INDAYHOURFLAG", 'H');
     			
            	if($('#siteId').attr('checked'))
            		app1.analysisDocument.setDocumentProperty("INGBSITEID", 'Y');
            	else
            		app1.analysisDocument.setDocumentProperty("INGBSITEID", '');
            	
			    if($('#applicantId').attr('checked'))
			    	app1.analysisDocument.setDocumentProperty("INGBAPPNAME", 'Y');
			    else
			    	app1.analysisDocument.setDocumentProperty("INGBAPPNAME", '');
			    
			    if($('#issuerId').attr('checked'))
			    	app1.analysisDocument.setDocumentProperty("INGBBANKNAME", 'Y');
			    else
			    	app1.analysisDocument.setDocumentProperty("INGBBANKNAME", '');
			    
			    if($('#benficiaryObligeeId').attr('checked'))
			    	app1.analysisDocument.setDocumentProperty("INGBBENNAME", 'Y');	
			    else
			    	app1.analysisDocument.setDocumentProperty("INGBBENNAME", '');
			    
			    if($('#gbBenficiaryCountryId').attr('checked'))
			    	app1.analysisDocument.setDocumentProperty("INGBBENCUNTRY", 'Y');
			    else
			    	app1.analysisDocument.setDocumentProperty("INGBBENCUNTRY", '');
			    
		        if($('#countryIssuanceId').attr('checked'))
		        	app1.analysisDocument.setDocumentProperty("INGBCOUNTRYISSUE", 'Y');
		        else
			    	app1.analysisDocument.setDocumentProperty("INGBCOUNTRYISSUE", '');
		        
		        if($('#instrumentTypeId').attr('checked'))
		        	app1.analysisDocument.setDocumentProperty("INGBINSTTYPEID", 'Y');
		        else
			    	app1.analysisDocument.setDocumentProperty("INGBINSTTYPEID", '');
		        
		        if($('#instrumentPurposeId').attr('checked'))
		        	app1.analysisDocument.setDocumentProperty("INGBINSTPURPOSEID", 'Y');
		        else
			    	app1.analysisDocument.setDocumentProperty("INGBINSTPURPOSEID", '');
        	}
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
        
        // CheckAll and uncheckAll
        $('body').off('click', '.checkall').on('click', '.checkall', function(e) {
			if ($(e.target).is(":checked")) {
				$(e.target).closest("tr").find(':checkbox').attr(
						'checked', true);
			} else {
				$(e.target).closest("tr").find(':checkbox').attr(
						'checked', false);
			}
		});
        
		// CheckAll and uncheckAll
        $('body').off('click', '.checkallinsType').on('click', '.checkallinsType', function(e) {
			if ($(e.target).is(":checked")) {
				$(e.target).closest("tr").find(':checkbox').attr(
						'checked', true);
			} else {
				$(e.target).closest("tr").find(':checkbox').attr(
						'checked', false);
			}
		});
		
	    $('.instrPurpose').each(function() {
			if($(this).attr('checked') == 'checked'){
		  		 $('#instrumentPurpose').attr('checked','checked');	 
		  	}
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
     		$("#businessContactPersonId").val('');
			$("#BusinessShow").find(":input").val("");
			$("#BusinessShow").find("p").text("");
			$("#BusinessShow").hide();
			$(".lookup-error").text("");
     		$("#reportGridId").css({visibility:"hidden"});
     		$('#blankMessage').css({'display' : 'block'});
        });
	    
	    $('body').off('click', '#exportResult').on('click', '#exportResult', function(e) {
			e.preventDefault();
			$('#generateReport').click();
			var url = contextURL +"/int/reports/exportCycleTimeReportResults.action";
			assignValues();
 			$('#cycletimeForm').attr('action', url);
         	$('#cycletimeForm').submit();		
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
		var loginUserSSO = '';
		
		loginUserSSO = $("#userSSOId").val().toString();
		
		$("#loginSSOId").val(loginUserSSO);
		
		var selectedInstument = '';
		if (allCheckId == 'true') {
			selectedInstument ='1,2,3';
		}
		else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == undefined && suretyBondCheck == undefined && allCheckId == undefined) {
			selectedInstument ='1'; 
		} else if (bankGuaranteeCheck == undefined && standbyLetterCheck == 'true' && suretyBondCheck == undefined && allCheckId == undefined) {
			selectedInstument ='2';
		} else if (bankGuaranteeCheck == undefined && standbyLetterCheck == undefined && suretyBondCheck == 'true' && allCheckId == undefined) {
			selectedInstument ='3';
		} else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == undefined && suretyBondCheck == 'true' && allCheckId == undefined) {
			selectedInstument ='1,3';
		} else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == 'true' && suretyBondCheck == undefined && allCheckId == undefined) {
			selectedInstument ='1,2';
		} else if (bankGuaranteeCheck == undefined && standbyLetterCheck == 'true' && suretyBondCheck == 'true' && allCheckId == undefined) {
			selectedInstument ='2,3';
		} else if (bankGuaranteeCheck == 'true' && standbyLetterCheck == 'true' && suretyBondCheck == 'true' && allCheckId == undefined) {
			selectedInstument ='1,2,3';
		}
    	
		$("#selectedInstId").val(selectedInstument);
		
    	if(!jQuery.trim($("#availableSites").val()).length == 0){
    		var availableSiteInfo = $('#availableSites').val();
    		$("#selectedSites").val(availableSiteInfo);
    	}
    	
    	if(!jQuery.trim(insPurpose).length == 0)
    		$("#selectedInsPurpose").val(insPurpose);
    	
			
    	if($("input[type=radio][id=dayHourSelection_Hours]:checked").val() == 'Hours')
    		hoursValue = 'H';
			else if($("input[type=radio][id=dayHourSelection_Days]:checked").val() == 'Days')
				hoursValue = 'D';
			else
				hoursValue = 'H';
    	
			$("#showResultsId").val(hoursValue);
			
			if($('#siteId').attr('checked'))
				$("#siteId").val('Y');
			else 
				$("#siteId").val('');
					
			if($('#applicantId').attr('checked'))
				$("#applicantId").val('Y');
			else 
				$("#applicantId").val('');
			
			if($('#issuerId').attr('checked'))
				$("#issuerId").val('Y'); 
			else 
				$("#issuerId").val('');
			
			if($('#benficiaryObligeeId').attr('checked'))
				$("#benficiaryObligeeId").val('Y');
			else 
				$("#benficiaryObligeeId").val('');
			
			if($('#gbBenficiaryCountryId').attr('checked'))
				$("#gbBenficiaryCountryId").val('Y');
			else 
				$("#gbBenficiaryCountryId").val('');
			
			if($('#countryIssuanceId').attr('checked'))
				$("#countryIssuanceId").val('Y');
			else 
				$("#countryIssuanceId").val('');
			
			if($('#instrumentTypeId').attr('checked'))
				$("#instrumentTypeId").val('Y');
			else 
				$("#instrumentTypeId").val('');
			
			if($('#instrumentPurposeId').attr('checked'))
				$("#instrumentPurposeId").val('Y');
			else 
				$("#instrumentPurposeId").val('');
	}
	
	function validateCycleTime(){
		var groupByCheck = true;
		var amtCheck = true;
		var checkedVals = $('.groupByFilter:checkbox:checked').map(function() {
    	    return this.value;
    	}).get();
		
		if(checkedVals.length == 0){
    		$("#errorDivId").removeClass("hide").addClass("show");
			 	$('.optOutval-error').text("Please check Group results by").removeClass("hide").addClass("show");
			 	$("#groupByDivId").css("border","1px solid red");
			 	$("#reportGridId").css({visibility:"hidden"});
			 	$('#blankMessage').css({'display' : 'block'});
			 	groupByCheck = false;
    	}
		else{
			$('.optOutval-error').removeClass("show").addClass("hide");
			$("#groupByDivId").css("border","none");
		}
    	
    	if(!jQuery.trim($("#instrumentAmtFrom").val()).length == 0 && 
    			!jQuery.trim($("#instrumentAmtTo").val()).length == 0){
    		if(isNaN($("#instrumentAmtFrom").val()) || isNaN($("#instrumentAmtTo").val())){
    			$("#currencyDivId").removeClass("show").addClass("hide");
			 	$("#currencyBorderId").css("border","none");
    			$("#instrAmtDivId").removeClass("hide").addClass("show");
   			 	$('.optOutval-error1').text("Please enter valid Instrument Amounts").removeClass("hide").addClass("show");
	   			$("#instrAmtBorderId").css("border","1px solid red");
	     		$("#reportGridId").css({visibility:"hidden"});
	     		$('#blankMessage').css({'display' : 'block'});
	     		amtCheck = false;
        	}
    		else if(parseInt($("#instrumentAmtFrom").val())>parseInt($("#instrumentAmtTo").val())){
			 	$("#currencyDivId").removeClass("show").addClass("hide");
			 	$("#currencyBorderId").css("border","none");
    			$("#instrAmtDivId").removeClass("hide").addClass("show");
   			 	$('.optOutval-error1').text("Instrument From Amount should be less than To Amount").removeClass("hide").addClass("show");
        		$("#instrAmtBorderId").css("border","1px solid red");
        		$("#reportGridId").css({visibility:"hidden"});
        		$('#blankMessage').css({'display' : 'block'});
        		amtCheck = false;
    		}
    		else if(jQuery.trim($("#instruCurrencyId").val()).length == 0){
    			$("#instrAmtDivId").removeClass("show").addClass("hide");
   			 	$('.optOutval-error1').removeClass("show").addClass("hide");
        		$("#instrAmtBorderId").css("border","none");
        		$("#currencyDivId").removeClass("hide").addClass("show");
   			 	$('.optOutval-error2').text("Please select Instrument Currency").removeClass("hide").addClass("show");
        		$("#currencyBorderId").css("border","1px solid red");
        		$("#reportGridId").css({visibility:"hidden"});
        		$('#blankMessage').css({'display' : 'block'});
        		amtCheck = false;
    		}
    	}
    	if(groupByCheck == false || amtCheck == false)
    		return false;
    	else {
    		$("#currencyDivId").removeClass("show").addClass("hide");
		 	$("#currencyBorderId").css("border","none");
    		return true;
    	}
	}