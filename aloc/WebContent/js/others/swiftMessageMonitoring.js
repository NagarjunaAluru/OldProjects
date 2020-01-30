$(document).ready(function(){
	$.tablesorter.addParser({
		  id: 'dayMonthYear',
		  is: function(s) {
		      return false;
		  },
		  format: function(s) {
		  	  if( s.trim )
		  	  	s = s.trim();
		  	  else
		  	  	s = s.replace(" ","");
		  	  if("" === s || "--" === s || "-" === s)
	    	  	  return '';		
		      var date = s.match(/^(\d{1,2})(\w{3}) (\d{4})[ ]?$/);
		      if(date != null || date != undefined){
			      var m = monthNames[date[2]];
			      var d = String(date[1]);
			      if (d.length == 1) {d = "0" + d;}
			      var y = date[3];
			      return '' + y + m + d;
		      }else return '';
		  },
		  type: 'numeric'
		});
		var monthNames = {};
		monthNames["Jan"] = "01";
		monthNames["Feb"] = "02";
		monthNames["Mar"] = "03";
		monthNames["Apr"] = "04";
		monthNames["May"] = "05";
		monthNames["Jun"] = "06";
		monthNames["Jul"] = "07";
		monthNames["Aug"] = "08";
		monthNames["Sep"] = "09";
		monthNames["Oct"] = "10";
		monthNames["Nov"] = "11";
		monthNames["Dec"] = "12";
		
		
	$("a.advanceSearch").click(function() {
		// Code between here will only run when the a link is clicked and has a name of addRow
		$(this).parent().next("div.filterMsg").slideDown();
	});	
	
	$("a.clearEntries").click(function(){
		$('#clearEntries').modal({show: 'true'}).css("margin-top","-82px;"); 
	});
	$("#swiftconetent tr:odd").addClass('odd');
	$("#swiftconetent").tablesorter({
		headers:{
			5:{sorter:"dayMonthYear"},
		}
	});
	
	$("a.advanceSearchBtn").click(function(e) {
		e.preventDefault();
		var url = $(this).attr('href');
		$('#advSearchIndicator').show();
		var bgInstrument = $('#bgInstrument').is(':checked');
		var slocInstrument = $('#slocInstrument').is(':checked');
		$.ajax({
	           type: "POST",
	           url: url,
	           dataType: 'html',
	           data: $("#SwiftSearchFormID").serialize(), // serializes the form's elements.
	           success: function(data)
	           {
	        	   	$('#swiftMainContent').empty().html(data);
					$('#advSearchIndicator').hide();
					$('.ErrorDiv').addClass('hide').hide();
					if(bgInstrument == false){
						 $('#bgInstrument').attr('checked', false);
					}
					
					if(slocInstrument == false){
						 $('#slocInstrument').attr('checked', false);
					}
	           },
	           error: function (xhr, textStatus, errorThrown ) {
					$('#advSearchIndicator').hide();
			    }
	         });

	});	
	
	 /*$('.checkall').click(function () {
		
		 $('.instrTypes').each(function() {
	            $(this).attr('checked',!$(this).attr('checked'));
	        });
	 });*/
	
	$("a#basicSearch").click(function(e){
		e.preventDefault();
		var url = $(this).attr('href');
		var searchCriteriaText = $("#searchCriteriaText").val();
		if(searchCriteriaText == 'Search...'){
			searchCriteriaText = '';
		}
		$('#searchIndicator').show();
		var bgInstrument = $('#bgInstrument').is(':checked');
		var slocInstrument = $('#slocInstrument').is(':checked');
		$.ajax({
			type: "POST",
			url: url,
			dataType: 'html',
			data: {searchCriteriaText:searchCriteriaText},
			success: function(data){
				$('#swiftMainContent').empty().html(data);
				$('#advSearchIndicator').hide();
				$('.ErrorDiv').addClass('hide').hide();
				if(bgInstrument == false){
					 $('#bgInstrument').attr('checked', false);
				}
				
				if(slocInstrument == false){
					 $('#slocInstrument').attr('checked', false);
				}
			},
			error: function (xhr, textStatus, errorThrown ) {
				$('#searchIndicator').hide();
		    }
		});
	});
	
	$("a#resend").click(function(e){
		e.preventDefault();
		var url = contextURL +"/int/admin/resendSwiftMessageMonitoring.action";
		var requestId = $(this).closest('tr').find('.requestId').val();
		var amendmentId = $(this).closest('tr').find('.amendmentId').val();
		var processImg = $(this).closest('tr').find('.swiftResendProcess').show();
		$.ajax({
			type: "POST",
			url: url,
			dataType: 'html',
			data: {'swiftMonitoring.ALOCRecordNo':requestId, 'swiftMonitoring.amendmentId':amendmentId},
			success: function(data){
				$('#swiftMainContent').empty().html(data);
				processImg.hide();
				$('.ErrorDiv').addClass('hide').hide();
			},
			error: function (xhr, textStatus, errorThrown ) {
				var errorMsg = $.trim($(xhr.responseText).find('.errorReason').text());				
				if(errorMsg!=undefined && errorMsg!=""){
					$('.ErrorDiv').show();
				}
				$('.delError').text(errorMsg).show();
				processImg.hide();
		    }
		});
	});
});