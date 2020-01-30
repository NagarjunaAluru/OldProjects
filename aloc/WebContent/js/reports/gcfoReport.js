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
         app.open($("#GCFOPathId").val(),"webPlayer",'Parameter.BusinessLocation = {Boston, Seattle}; ApplyBookmark(bookmarkName = "All");');
        
         $('body').off('click', '#generateReport').on('click', '#generateReport', function(e) {
	    	var asOfDate = $("#asOfDate").val();
			if((jQuery.trim(asOfDate).length == 0)){
				 $("#asOfDateDivID").removeClass("hide").addClass("show");
				 $('.optOutval-error').text("As of Date is mandatory").removeClass("hide").addClass("show");
				 $("#divBorderId").css("border","1px solid red");
				 $("#reportGridId").css({visibility:"hidden"});
				 $('#blankMessage').css({'display' : 'none'});
				 return false;
			}
			if(isDate(asOfDate)){
				$("#asOfDateID").val($("#asOfDate").val());
				$('#blankMessage').css({'display' : 'none'});
				var url = contextURL +"/int/reports/recordCountForGCFO.action";
	 			$.ajax({
	 				type: "POST",
	 				url: url,
	 				dataType: 'json',
	 				data: $("#gcfoForm").serialize(),// serializes the form's elements.
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
				setTimeout( "$('#reportDescId').hide();",7000);
				$('#headerText').text("GCFO Report as of "+asOfDate);
	            $('#headerText').css({'display' : 'block'});
	            $('#headerText').css({'font-size':'140%'});
				if(!(jQuery.trim(asOfDate).length == 0)){
					$("#asOfDateDivID").removeClass("show").addClass("hide");
					$("#divBorderId").css("border","0px solid red");
					app.analysisDocument.setDocumentProperty("INASOFDATE",$("#asOfDate").val());
				}
			}	
        });
        
         $('body').off('click', '#exportResult').on('click', '#exportResult', function(e) {
        	e.preventDefault();
        	$('#generateReport').click();
        	$("#asOfDateID").val($("#asOfDate").val());
			var url = contextURL +"/int/reports/gcfoReportResults.action?fileName="+$('#headerText').text();
			$('#gcfoForm').attr('action', url);
	        $('#gcfoForm').submit();	
		});
        
         $('body').off('click', '#resetClick').on('click', '#resetClick', function(e) {
        	$("#asOfDate").val('');
        	$("#asOfDateDivID").removeClass("show").addClass("hide");
        	$("#reportGridId").css({visibility:"hidden"});
        	$('#blankMessage').css({'display' : 'none'});
        	$('#headerText').css({'display' : 'none'});
        });
        $('.acc_triggerA').addClass('acc_active').next().next().show();
        $("#reportGridId").css({visibility:"hidden"});
	});
	
	// Date validations
	function isDate(txtDate){
		  var currVal = txtDate;
	      if(currVal == ''){
	    	  $("#asOfDateDivID").removeClass("hide").addClass("show");
	    	  $('.optOutval-error').text("Please enter valid Date").removeClass("hide").addClass("show");
			  $("#divBorderId").css("border","1px solid red");
			     return false;
	      }
		  //Declare Regex 
	      var rxDatePattern = /^(\d{1,2})(\/|-)(\d{1,2})(\/|-)(\d{4})$/; //Declare Regex
	      var dtArray = currVal.match(rxDatePattern); // is format OK?
	      if (dtArray == null){
	    	  $("#asOfDateDivID").removeClass("hide").addClass("show");
	    	  $('.optOutval-error').text("Please enter valid Date").removeClass("hide").addClass("show");
			  $("#divBorderId").css("border","1px solid red");
	    	  return false;
	      } 

	      //Checks for dd/mm/yyyy format.
	      dtMonth = dtArray[1];
	      dtDay   = dtArray[3];
	      dtYear  = dtArray[5];        
	      
		  if (dtMonth < 1 || dtMonth > 12){
			  $("#asOfDateDivID").removeClass("hide").addClass("show");
	    	  $('.optOutval-error').text("Please enter valid Date").removeClass("hide").addClass("show");
			  $("#divBorderId").css("border","1px solid red");
		      return false;
		  }
		  else if (dtDay < 1 || dtDay> 31){
			  $("#asOfDateDivID").removeClass("hide").addClass("show");
	    	  $('.optOutval-error').text("Please enter valid Date").removeClass("hide").addClass("show");
			  $("#divBorderId").css("border","1px solid red");
		      return false;
		  }
		  else if ((dtMonth==4 || dtMonth==6 || dtMonth==9 || dtMonth==11) && dtDay ==31){
			  $("#asOfDateDivID").removeClass("hide").addClass("show");
	    	  $('.optOutval-error').text("Please enter valid Date").removeClass("hide").addClass("show");
			  $("#divBorderId").css("border","1px solid red");
		      return false;
		  }
		  else if (dtMonth == 2)
		  {
		     var isleap = (dtYear % 4 == 0 && (dtYear % 100 != 0 || dtYear % 400 == 0));
		     if (dtDay> 29 || (dtDay ==29 && !isleap)){
		    	 $("#asOfDateDivID").removeClass("hide").addClass("show");
		    	  $('.optOutval-error').text("Please enter valid Date").removeClass("hide").addClass("show");
				  $("#divBorderId").css("border","1px solid red");
			      return false;
			  }
		  }
		  return true;
	}