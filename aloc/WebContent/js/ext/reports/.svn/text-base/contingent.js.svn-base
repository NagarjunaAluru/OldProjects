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
 		
		app.open($("#contigentBUCId").val(),"webPlayer",'Parameter.BusinessLocation = {Boston, Seattle};');
		  
    	var currentDate = $.datepicker.formatDate('mm/dd/yy', new Date());
        $("#asOfDate").val(currentDate.toString());
        
    	var fincheckonload = $('#financialCheck').attr('checked');
		var indCheckonload = $("#industrialCheck").attr('checked');

		if (fincheckonload != undefined && fincheckonload == 'checked')
			$('#financialCheck').attr('checked','checked');
		if (indCheckonload != undefined && indCheckonload == 'checked')
			$('#industrialCheck').attr('checked','checked');
		if ($('#preliminaryRadio_Preliminary').attr('checked'))
			$('#headerText').show();
		if ($('#preliminaryRadio_Final').attr('checked'))
			$('#headerText').show();
 
		$('body').off('click', '#generateReport').on('click', '#generateReport', function(e) {
        	 $("#asOfDateDivId").addClass("hide");
             $("#fxRateDivId").addClass("hide");
        	 if(validateContingent()){
        		 assignValues();
       		  	 $('#blankMessage').css({'display' : 'none'});
 				 var url = contextURL +"/ext/reports/recordCountForContingent.action";
				 $.ajax({
					 type: "POST",
	 				 url: url,
	 				 dataType: 'json',
	 				 data: $("#contingentForm").serialize(),// serializes the form's elements.
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
		          
		         var fincheck =$("#financialCheck:checked").val();
		         var indCheck = $("#industrialCheck:checked").val();
		         var siteName = "";
		          
		 		 // Only for Treasury Users SiteType required to Send
		 		 if (fincheck == undefined && indCheck == 'true') {
		 			 app.analysisDocument.setDocumentProperty("INSITETYPE",'4');
		 			 siteName = "Industrial";
		 		 } else if (indCheck == undefined && fincheck == 'true') {
		 			 app.analysisDocument.setDocumentProperty("INSITETYPE",'1');
		 			 siteName = "Financial";
		 		 } else if (fincheck == 'true' && indCheck == 'true') {
		 			 app.analysisDocument.setDocumentProperty("INSITETYPE",'1,4');
		 			 siteName = "Financial & Industrial";
		 		 } else if(fincheck == undefined && indCheck == undefined){
		 			 $('#headerText').text("Contingent Liability Report as of "+ $("#asOfDate").val());
		             $('#headerText').css({'display' : 'block'});
		             $('#headerText').css({'color' : '#00437e'});
		 		 }
		 			
			     if($("#contigentPathId").val() != undefined){
			    	  var preliminaryCheck = $("#preliminaryRadio_Preliminary");
			          if(preliminaryCheck.attr("checked") != undefined && preliminaryCheck.attr("checked") == "checked"){
			             $('#headerText').text("Contingent Liability Report - Preliminiary as of "+ $("#asOfDate").val() +"  for Site Type(s) "+siteName);
			             $('#headerText').css({'display' : 'block'});
			             $('#headerText').css({'color' : '#00437e'});
			          }
			          var finalCheck = $("#preliminaryRadio_Final");
			          if(finalCheck.attr("checked") != undefined && finalCheck.attr("checked") == "checked"){
			         	 $('#headerText').text("Contingent Liability Report - Final as of "+ $("#asOfDate").val()+ "  for Site Type(s) "+siteName);
			         	 $('#headerText').css({'display' : 'block'});
			         	 $('#headerText').css({'color' : '#00437e'});
			          }
				 }
		 		 if($("#asOfDate").val() != undefined && !jQuery.trim($("#asOfDate").val()).length == 0)
		 			app.analysisDocument.setDocumentProperty("INUSEXPIRATIONDATE", $("#asOfDate").val().toString());
		 			
		 		 if($("#availableSites").val() != undefined && !jQuery.trim($("#availableSites").val()).length == 0)
		 			app.analysisDocument.setDocumentProperty("INSITEID",$("#availableSites").val().toString());
		 		 else
		 			app.analysisDocument.setDocumentProperty("INSITEID",'');
		 			
		 		 //setting property for Bank ID
				 if(!jQuery.trim($('#availableBanks').val()).length == 0)
					app.analysisDocument.setDocumentProperty("INBANKID",$('#availableBanks').val().toString());
				 else
					app.analysisDocument.setDocumentProperty("INBANKID",'');
		 			
				 if($("#bloombergId").val() != undefined && !jQuery.trim($("#bloombergId").val()).length == 0){
				    app.analysisDocument.setDocumentProperty("INMORBLOOMBERGRATE",$("#bloombergId").val().replace("'","").replace("'","").toString());
				    app.analysisDocument.setDocumentProperty("INMORBLOOMBERGFLAG","B");
				 }
				    	
				 if($("#userSSOId").val() != undefined && !jQuery.trim($("#userSSOId").val()).length == 0)
				    app.analysisDocument.setDocumentProperty("INUSERSSO",$("#userSSOId").val().toString());
        	 }
	     });
         
		 $('body').off("change",'#financialCheck, #industrialCheck').on("change",'#financialCheck, #industrialCheck',function(e){
 			 e.stopImmediatePropagation();
 			 var financialCheck=$('#financialCheck').is(":checked");
 			 var industrialCheck = $('#industrialCheck').is(":checked");
 			 var isReports = true;
 			 $.ajax({
 				type: "POST",
 				url: contextURL+'/ext/reports/getSites.action',
 			    dataType: 'html',
 			    data: {financialCheck : financialCheck, industrialCheck: industrialCheck,isReports : isReports},
 			    processdata: true,
 			    success: function(data) {
 			    	$("#siteSelection").empty().append(data);
 			    }
 			 });
 		 });   
		 
		 $('body').off('click', '#resetClick').on('click', '#resetClick', function(e) {
        	$('input:checkbox').removeAttr('checked');
          	$('input:radio').removeAttr('checked');
          	$("input[type=text]").val('');
     		$.ajax({
 			 	type: "POST",
	            url: contextURL+'/ext/reports/resetSiteNames.action',
	            dataType: 'html',
	            processdata: true,
	            success: function(data) {
	            	$("#siteSelection").empty().append(data);
	            }
		    });
     		 
     		$.ajax({
     			type: "POST",
	            url: contextURL+'/ext/reports/resetBankNames.action',
	            dataType: 'html',
	            processdata: true,
	            success: function(data) {
	            	$("#bankSelection").empty().append(data);
	            }
	        });
     		
     		var currentDate = $.datepicker.formatDate('mm/dd/yy', new Date());
            $("#asOfDate").val(currentDate.toString());
            $("#reportGridId").css({visibility:"hidden"});
            $('#blankMessage').css({'display' : 'none'});
         });
         
		 $('body').off('click', '#exportResult').on('click', '#exportResult', function(e) {
			 $('#generateReport').click();
			 e.preventDefault();
        	 var url = contextURL+'/ext/reports/exportContingentLiabilityResults.action?fileName='+$('#headerText').text();
        	 assignValues();
        	 $("#userSSO").val($("#userSSOId").val());
	 		 $('#contingentForm').attr('action', url);
         	 $('#contingentForm').submit();				
 		});
        $('.acc_triggerA').addClass('acc_active').next().next().show();
        $("#reportGridId").css({visibility:"hidden"});
    });
	
	function assignValues(){
			if($("#availableSites").val() != undefined && !jQuery.trim($("#availableSites").val()).length == 0){
        		var availableSiteInfo = $('#availableSites').val().toString();
        		$("#selectedSiteIds").val(availableSiteInfo);
        	} else{
    			$("#selectedSiteIds").val('');
    		}
        	
        	if(!jQuery.trim($("#availableBanks").val()).length == 0){
    			var availableBanksInfo = $('#availableBanks').val().toString();
    			$("#availableBankId").val(availableBanksInfo);
    		} else{
    			$("#availableBankId").val('');
    		}
			
			if($("#bloombergId").val() != undefined && !jQuery.trim($("#bloombergId").val()).length == 0) {
			    $("#morBloomberg").val($("#bloombergId").val().replace("'","").replace("'","").toString());
			    $("#morBloombergRateFlag").val("B");
			}
        	
        	$("#userSSO").val($("#userSSOId").val());	
    }
	
	function validateContingent(){
		 var asOfDate = $("#asOfDate").val();
		 var asOfDateCheck = true;
		 var fxRateCheck = true;
    	 if(jQuery.trim(asOfDate).length == 0){
			 $("#asOfDateDivId").removeClass("hide").addClass("show");
			 $('.optOutval-error').text("As of date is mandatory").removeClass("hide").addClass("show");
			 $("#reportGridId").css({visibility:"hidden"});
			 $("#divBorderId").css("border","1px solid red");
			 $('#blankMessage').css({'display' : 'none'});
			 asOfDateCheck = false;
		 }  
    	 else{
    		 $("#asOfDateDivId").removeClass("show").addClass("hide");
    		 $("#divBorderId").css("border","none");
    	 }

          if(asOfDateCheck == false || fxRateCheck == false)
        	  return false;
          else
        	  return true;
	}