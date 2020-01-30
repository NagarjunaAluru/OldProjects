// Global declaration of spotfireApp object
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
		         var app = new spotfire.webPlayer.Application($("#spotfireWebplayerURLId").val(), customization);
         
         // Open an analysis.
         app.open($("#ecsoPathId").val(),"webPlayer",'');
		 
         var currentDate = $.datepicker.formatDate('mm/dd/yy', new Date());
         $("#asofDateId").val(currentDate.toString());
         
         $('body').off('click', '#generateReport').on('click', '#generateReport', function(e) {
            var goldId = '';
    		var csoId = '';
			var asOfDate = $("#asofDateId").val();
			var currentDate = $.datepicker.formatDate('mm/dd/yy', new Date());  
			if((jQuery.trim(asOfDate).length == 0)){
				 $("#asOfDateDivID").removeClass("hide").addClass("show");
				 $('.optOutval-error').text("As of date is mandatory").removeClass("hide").addClass("show");
				 $("#divBorderId").css("border","1px solid red");
				 $("#reportGridId").css({visibility:"hidden"});
				 $('#blankMessage').css({'display' : 'none'});
				 return false;
			}
			else if(new Date(asOfDate) < new Date(currentDate)){
				 $("#asOfDateDivID").removeClass("hide").addClass("show");
				 $('.optOutval-error').text("As of date should not be past date").removeClass("hide").addClass("show");
				 $("#divBorderId").css("border","1px solid red");
				 $("#reportGridId").css({visibility:"hidden"});
				 $('#blankMessage').css({'display' : 'none'});
				 return false;
			}
			if(isDate(asOfDate)){
				 $("#asOfDateDivID").removeClass("show").addClass("hide");
				 $('.optOutval-error').text("As of Date is mandatory").removeClass("show").addClass("hide");
				 $("#divBorderId").css("border","0px solid red");
			}
			
			if(!(jQuery.trim($("#availableSites").val()).length == 0)){
        		var selectedSites = $('#availableSites').val().toString();
        		$('#selectedSiteIds').val(selectedSites);
        	}
			$('#blankMessage').css({'display' : 'none'});
    		var url = contextURL +"/int/reports/recordCountForECSO.action";
 			$.ajax({
 				type: "POST",
 				url: url,
 				dataType: 'json',
 				data: $("#escoReportForm").serialize(),// serializes the form's elements.
 				processdata: true,
 				success: function(response){
 					if((response.data == 0))
 						$('#blankMessage').css({'display' : 'block'});
 				},
 				error: function (xhr, textStatus, errorThrown ) {
 				}
 			}); 
 			 
			var i=1;
			$('.LEGoldID').each(function(){
				goldId=goldId+$(this).val();
				if(i != $('.LEGoldID').length){
					if($(this).val() !=''){
						goldId=goldId+",";
					}
				}
			});
			if($('.LEGoldID').length > 1){	
				goldId = goldId.toString().substring(0, (goldId.length)-1);
			}
			
			$("#leGoldTotalId").val('');
			
			if(goldId != ''){
				$("#leGoldTotalId").val(goldId);
			}
			
			var i=1;
			$('.csoIdClass').each(function(){
				csoId=csoId+$(this).val();
				if(i != $('.csoIdClass').length){
					
					if($(this).val() !=''){
						csoId=csoId+",";
					}
				}
			});
			
			if($('.csoIdClass').length > 1){	
				csoId = csoId.toString().substring(0, (csoId.length)-1);
			}
			$("#csoTotalId").val('');
			if(csoId !=''){
				$("#csoTotalId").val(csoId);
			}
        	
			$("#generateId").text("Refresh Report");
			$("#reportGridId").css({visibility:"visible"});
			setTimeout( "$('#reportDescId').hide();", 4000);
			$('#headerText').css({'display' : 'block'});
            $('#headerText').css({'font-size':'150%'});
				
            if(!(jQuery.trim($("#asofDateId").val()).length == 0))
			    app.analysisDocument.setDocumentProperty("INEXPIRDATE",$("#asofDateId").val().toString());
        
			if($("#availableSites").val() != undefined && !jQuery.trim($("#availableSites").val()).length == 0)
				app.analysisDocument.setDocumentProperty("INBUSSITEID",$("#availableSites").val().toString());
			else
				app.analysisDocument.setDocumentProperty("INBUSSITEID",'');
			
			if(!(jQuery.trim($("#leGoldTotalId").val()).length == 0))
				app.analysisDocument.setDocumentProperty("INGOLDID",$("#leGoldTotalId").val().toString());
			else
				app.analysisDocument.setDocumentProperty("INGOLDID",'');
			
			if(!(jQuery.trim($("#csoTotalId").val()).length == 0))
				app.analysisDocument.setDocumentProperty("INCSO",$("#csoTotalId").val().toString());
			else
				app.analysisDocument.setDocumentProperty("INCSO",'');
        });
        
        $('body').off('click', 'a#goldIdDyId').on('click', 'a#goldIdDyId', function(e) {
			var goldIdVal = parseInt($('#goldIdCount').val());
			$("table#goldIdTable tr:last").after('<tr class="newGoldIdRow"></tr>');
			var url = contextURL+'/int/reports/addGoldID.action?goldIdVal='+(goldIdVal+1);
			$('.newGoldIdRow').load(url).removeClass('newGoldIdRow');
			$('#goldIdCount').val(goldIdVal + 1);
			return false;
		});
		
        $('body').off('click', 'a#addCSOId').on('click', 'a#addCSOId', function(e) {
			var csoIdVal = parseInt($('#csoCountId').val());
			$("table#csoIdTable tr:last").after('<tr class="newCsoIdRow"></tr>');
			var url = contextURL+'/int/reports/addCSOID.action?csoIdVal='+(csoIdVal+1);
			$('.newCsoIdRow').load(url).removeClass('newCsoIdRow');
			$('#csoCountId').val(csoIdVal + 1);
			return false;
		});
		
        $('body').off('click', 'a.lookup').on('click', 'a.lookup', function(e){
	    	e.preventDefault();
	    	e.stopImmediatePropagation();
	    	var scrollTopValue = $(e.target).closest(".row").offset().top;
	  		var url = $(e.target).attr('href');
	  		$(e.target).siblings(".lookup-error").empty().addClass("hide").removeClass("show");
	  		var dataValue = $(e.target).siblings(".lookup-filterValue").val();
	  		if(dataValue == undefined && $(e.target).siblings(".lookup-filterValue").length == 0){
	  			dataValue = $(e.target).closest('.form-row').find('.lookup-filterValue').val();
	  		}
	  		if($.trim(dataValue) != ''){
	  			var indicator = $(e.target).siblings(".indicator");
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
	  						$(window).scrollTop(0);
	  					}else{
	  						$(indicator).hide();
	  					}
	  				}
	  			});
	  		}else{
	  			$(e.target).siblings(".lookup-error").text("Please enter values for Lookup Search").removeClass("hide").addClass("show");
	  			return false;
	  		}
	  		return false;
	     });
		
        $('body').off('click', '#exportResult').on('click', '#exportResult', function(e) {
        	e.preventDefault();
        	$('#generateReport').click();
        	var url = contextURL +"/int/reports/exportEcsoReportResults.action";
        	
        	if(!(jQuery.trim($("#availableSites").val()).length == 0)){
        		var selectedSites = $('#availableSites').val().toString();
        		$('#selectedSiteIds').val(selectedSites);
        	}
        	$('#escoReportForm').attr('action', url);
        	$('#escoReportForm').submit();
		});
        
        $('body').off('click', '#resetClick').on('click', '#resetClick', function(e) {
        	$("#asofDateId").val('');
        	$(".lookup-filterValue").val('');
    		$("#goldidShow0").find(":input").val("");
    		$("#goldidShow0").find("p").text("");
    		$("#goldidShow0").hide();
    		$('#headerText').css({'display' : 'none'});
    		$(".csoIdClass").val('');
    		var gidlen = $("table#goldIdTable tbody tr").length;
    		if(gidlen > 1){
    			for(var i=gidlen; i>1; i--){
    				$("table#goldIdTable tbody tr:nth-child("+i+")").remove();
    			}
    		}
    		var csolen = $("table#csoIdTable tbody tr").length;
    		if(csolen > 1){
    			for(var i=csolen; i>1; i--){
    				$("table#csoIdTable tbody tr:nth-child("+i+")").remove();
    			}
    		}
     		$.ajax({
     			type: "POST",
		            url: contextURL+'/int/reports/resetSiteNames.action',
		            dataType: 'html',
		            processdata: true,
		            success: function(data) {
		            	$("#siteSelection").empty().append(data);
		            }
		    });
     		$("#asOfDateDivID").removeClass("show").addClass("hide");
     		$('.optOutval-error').text("").removeClass("hide").addClass("show");
			 $("#divBorderId").css("border","none");
     		var currentDate = $.datepicker.formatDate('mm/dd/yy', new Date());
            $("#asofDateId").val(currentDate.toString());
            
     		$("#reportGridId").css({visibility:"hidden"});
     		$('#blankMessage').css({'display' : 'none'});
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
	