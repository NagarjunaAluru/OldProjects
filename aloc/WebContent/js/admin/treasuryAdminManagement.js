
//Standard Format Management section Code
function insertLabelTag(tagName) {
		tinyMCE.execInstanceCommand("geStandardFormatId", "mceInsertContent",false, " &lt;" + tagName + "&gt; ");

}

$(document).ready(function() {	
	$.tablesorter.addParser({
		  id: 'dayMonthYearStamp',
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
		      var date = s.match(/^(\w{3})(\d{1,2}), (\d{4}) (\d{2}):(\d{2}) (\w{2}) (\w{3})[ ]?$/);
		      if(date != null || date != undefined){
			      var m = monthNames[date[1]];
			      var d = String(date[2]);
			      if (d.length == 1) {d = "0" + d;}
			      var y = date[3];
			      return '' + y + m + d;
		      }else return '';
		  },
		  type: 'numeric'
		});
	$.tablesorter.addParser({
	  id: 'dayMonthYearTime',
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
	      var date = s.match(/^(\d{1,2}) (\w{3}) (\d{4}) (\d{2}):(\d{2}) (\w{2}) (\w{3})[ ]?$/);
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
		
	decCounter("reimbursementAgrName", 100); 
	decCounter("agreementTextEdit", 10000); 
	decCounter("agreementTextAdd", 10000);
	decCounter("userAnnouncementMgmtId", 200); 
	decCounter("rejectReasonId", 100);
	decCounter("reimbursementAgrNameAdd", 100);
	
	$("a.clearEntries").click(function(){
		$('#clearEntries').modal({show: 'true'}).css("margin-top","-82px;"); 
	});
	
	$('#standardFormatInstrumentType').bind("change", function(){
		var standardFormatInstrumentType = $('#standardFormatInstrumentType').val();
        var allow = standardFormatInstrumentType == "-1" ? false : true;
        if(!allow) {          
        	$('#intstrumentTypeErrorId').show();
			$('#standardFormatBondTypeDiv').hide();
			$('#standardFormatInstrumentPurposeDiv').hide();
			$('#standardFormatSubBondTypeDiv').hide();	
            $("#standardFormatMgmtBodyDiv").hide();
            return;
        }	
        $('#intstrumentTypeErrorId').hide();
        if(standardFormatInstrumentType==1 || standardFormatInstrumentType==2){
	        if($('#instrumentPurposeId').val()!= null)
	        $('#instrumentPurposeId').val(null);
        	$('#standardFormatInstrumentPurposeDiv').hide(); 
        	$("#standardFormatMgmtBodyDiv").hide();
        }	
		standardFormatInstrumentTypeChange();		
	});
	$("#retentionSendLogTable").tablesorter({
		headers:{
			5:{sorter:"dayMonthYearStamp"},
			3:{sorter:"dayMonthYear"}
		}
	});
	$("#retentionFullAuditLogTable").tablesorter({
		headers:{
			1:{sorter:"dayMonthYearStamp"},
			5:{sorter:"dayMonthYear"}
		}
	});
	$("#retentionAuditLogTable").tablesorter({
		headers:{
			1:{sorter:"dayMonthYearStamp"}
		}
	});
	
	$("#auditLogId").tablesorter({
		headers:{
			1:{sorter:"dayMonthYearStamp"}
		}
	});
	
	$("#stdFormatauditLog").tablesorter();
	
	$("#amendmentWorkflowAuditLogTable").tablesorter({
		headers:{
			1:{sorter:"dayMonthYearTime"}
		}
	});
	$("#amdWorkFlowFullAuditLogTable").tablesorter({
		headers:{
			1:{sorter:"dayMonthYearTime"}
		}
	});
	$('#delSave_Approve').click(function(){
		  $("#deleg").hide();
		  $("#rejectReasonId").val('');
		  $('.counter').text('100');
	});

	$('#bdelegate_Reject').click(function(){
		$("#rejectReasonId").val('');
		$('.counter').text('100');
		$("#deleg").show();
	});
	
	var rejectVal =$('input[id=bdelegate_Reject]:checked').val(); 
	if(rejectVal!=undefined && rejectVal == 'Reject'){
		$("#deleg").show();
	}
	
	var oneTimeDateSel =$('input[id=scheduleFrequencyFlagId_false]:checked').val(); 
	if(oneTimeDateSel!=undefined && oneTimeDateSel == 'false'){
		$("#oneTimeID").show();
		var SchFrqVal = $('#scheduleFrequencyID').val();	
		if(SchFrqVal !=undefined && SchFrqVal != "" ){
			$('#scheduleFrequencyID').val("");	
		}
	}
	
	var scheduleFrequencyIDVal =$('input[id=scheduleFrequencyFlagId_true]:checked').val(); 
	if(scheduleFrequencyIDVal!=undefined && scheduleFrequencyIDVal == 'true'){
		$("#scheduleSelectionId").show();
		var SchFlagVal = $('#scheduleFrequencyFlagId').val();	
		if(SchFlagVal !=undefined && SchFlagVal != "" ){
			$('#scheduleFrequencyFlagId').val("");	
		}
	}
	
	var netrunIdVal = $('#nextRunDateID').val();	
	var appxrecIDVal = $('#appxrecID').val();
	var dateRangeVal = $('#dateRangeOfRecordsPurgedID').val();
	if(netrunIdVal !=undefined && netrunIdVal != "" || appxrecIDVal !=undefined && appxrecIDVal != "" ||dateRangeVal !=undefined && dateRangeVal != ""){
		$("#viewRentensionDet").show();
		$("#submitDiv").show();		
	}else {$("#viewRentensionDet").hide(); $("#submitDiv").hide();}
	
	
	
	$('#standardFormatBondType').bind("change", function(){		
		var standardFormatBondType = $('#standardFormatBondType').val();		
		var allow = standardFormatBondType == "" ? false : true;
	        if (!allow) {
	        	$("#bondTypeErrorId").show();
	        	$('#standardFormatSubBondTypeDiv').hide();	
	            $("#standardFormatMgmtBodyDiv").hide();
	            return;
	        } 
	     $("#bondTypeErrorId").hide();   
		if( $('#instrumentPurposeId').val() != null){			
			$('#instrumentPurposeId').val(null);				
		}	
		if(standardFormatBondType=="1"){	
			$("#standardFormatProcess2").show();
			getFormatMasterDetails();
		}
		else{
			$("#standardFormatMgmtBodyDiv").hide();	
		    standardFormatBondTypeChange();		  
		}
		
	});

	$('#links').click(function() {
	     var NWin = window.open($(this).prop('href'), '', 'height=200,width=400');
	     if (window.focus) 
	     {
	       NWin.focus();
	     }
	     return false;
	    });
	
//onload call	
	var standardFormatInstrumentType = $('#standardFormatInstrumentType').val();
	if(standardFormatInstrumentType !=undefined && standardFormatInstrumentType!="-1"){	
		if(standardFormatInstrumentType=="1" 
			|| standardFormatInstrumentType=="2"){			
			$('#standardFormatInstrumentPurposeDiv').show();
			$('#standardFormatBondTypeDiv').hide();
			$('#standardFormatSubBondTypeDiv').hide();	
		}
		else if(standardFormatInstrumentType=="3")
		{
			$('#standardFormatBondTypeDiv').show();
			$('#standardFormatInstrumentPurposeDiv').hide();
			$('#standardFormatSubBondTypeDiv').hide();	
		}else if(standardFormatInstrumentType =="4"){
				$('#standardFormatBondTypeDiv').hide();
				$('#standardFormatInstrumentPurposeDiv').hide();
				$('#standardFormatSubBondTypeDiv').hide();											
		}else{
			$('#standardFormatInstrumentPurposeDiv').hide();
			$('#standardFormatBondTypeDiv').hide();				
			$('#standardFormatSubBondTypeDiv').hide();	
		}	
		$("#standardFormatMgmtBodyDiv").show();
	}
	
	//onload Call for bond types
	var standardFormatBondType = $('#standardFormatBondType').val();
	if(standardFormatBondType!="" && standardFormatBondType!=undefined){
		showBondSubType(standardFormatBondType);
	}	

	
	
	//treasuryAdmin InstrumentType Change Script	
	function standardFormatInstrumentTypeChange(){		
		var standardFormatInstrumentType = $('#standardFormatInstrumentType').val();		
		if(standardFormatInstrumentType!=undefined){			
			if(standardFormatInstrumentType=="1" 
				|| standardFormatInstrumentType=="2"){
				$('#standardFormatInstrumentPurposeDiv').show();
				$('#standardFormatBondTypeDiv').hide();
				$('#standardFormatSubBondTypeDiv').hide();				
			}else if(standardFormatInstrumentType=="3"){
				$('#standardFormatBondTypeDiv').show();
				$('#standardFormatInstrumentPurposeDiv').hide();
				$('#standardFormatSubBondTypeDiv').hide();	
			}else if(standardFormatInstrumentType =="4"){
				$('#instrumentPurposeId').val(null);	
				$('#standardFormatBondType').val(null);
				$('#standardFormatSubBondType').val(null);						
				$('#standardFormatInstrumentPurposeDiv').hide();
				$('#standardFormatBondTypeDiv').hide();
				$('#standardFormatSubBondTypeDiv').hide();	
				$("#standardFormatProcess0").show(); 
				getFormatMasterDetails();
			}
			else{
				$('#standardFormatInstrumentPurposeDiv').hide();
				$('#standardFormatBondTypeDiv').hide();				
				$('#standardFormatSubBondTypeDiv').hide();	
			}
		}  		
	}

	//treasuryAdmin BondType Change Script 
	function standardFormatBondTypeChange(){
		var standardFormatBondType = $('#standardFormatBondType').val();
		$('#instrumentPurposeId').val(null);
		if(standardFormatBondType!=undefined){			
			$('#standardFormatInstrumentPurposeDiv').hide();		  
		    showBondSubType(standardFormatBondType);						  
		} 
	}
	
	function showBondSubType(val) {		
		var subBondType = $("#subBondTypeHiddenVal").val();
		if ((val == "2") || (val == "3") || (val == "4"))  
			{				
			    $.ajax({
			    	type: "POST",
		            url: contextURL +"/int/admin/getBondSubTypes.action",		          
		            dataType: 'json',
		            data: { bondType : val},
		            processdata: true,
		            success: function(data) {		            	
		            	$("#standardFormatSubBondType").empty().append("<option value='-1'>Select...</option>");
		            	for (var i = 0; i < data.result.length; i++) {
		            		if(subBondType==data.result[i].id){		            			
		            			$("#standardFormatSubBondType").append("<option value='" + data.result[i].id + "' selected>" + data.result[i].name + "</option>");
		            		}else{
		            			$("#standardFormatSubBondType").append("<option value='" + data.result[i].id + "'>" + data.result[i].name + "</option>");
		            		}
		                }
		            }
		        }); 
			    $('#standardFormatSubBondTypeDiv').show();	
			}else {
				$("#standardFormatSubBondTypeDiv").hide();
		}
	}
	
	//Section expand and collapse  
	$('.collapse').click(function(){
		$(this).parent().find('.section_flip').removeClass('section_active');
		$(this).parent().find('.section_panel').slideUp();
	});	
		
	$('#instrumentPurposeId').bind("change", function(){			
        var allow = $('#instrumentPurposeId').val() == "" ? false : true;
        if (!allow) {         
        	$("#intstrumentPurposeErrorId").show();
            $("#standardFormatMgmtBodyDiv").hide();
            return;
        }  
    	$("#intstrumentPurposeErrorId").hide();
		if( $('#standardFormatBondType').val() != null){			
			$('#standardFormatBondType').val(null);
			$('#standardFormatSubBondType').val(null);
		}
		if($('#instrumentPurposeId').val()!= undefined){		
			$("#standardFormatProcess1").show();					
			getFormatMasterDetails();		
		}	
	});

	$('#standardFormatSubBondType').bind("change", function(){		
        var allow = $('#standardFormatSubBondType').val() == "-1" ? false : true;
        if (!allow) {
        	$("#subBondTypeErrorId").show();
            $("#standardFormatMgmtBodyDiv").hide();
            return;
        } 
        $("#subBondTypeErrorId").hide();
		if( $('#instrumentPurposeId').val() != null){			
			$('#instrumentPurposeId').val(null);				
		}	
		if($('#standardFormatSubBondType').val()!= undefined){
			$("#standardFormatProcess3").show(); 
			getFormatMasterDetails();
		}
	});
	

  //Reimbersument agreement Screen Scripts Starts Here 
	 addCondIdOptionClick();
	 $('#addcondId_add').click(function () {	
		 addCondIdOptionClick();
	 });	 
	 $('#addcondId_edit').click(function () {		 
		 addCondIdOptionClick();
	 });
	 function addCondIdOptionClick(){		
		 var selectedOption = $('input:radio[name=addOrEditSelection]:checked').val();
		 var includeNoPage = $('#includePageId').val();		 
		 var previousConditionId = $('#previousConditionId').val();		 		 		
		 if(selectedOption=="add" || selectedOption=="edit"){ 
			 if(selectedOption=="add") {
				 if(!includeNoPage || previousConditionId=="edit"){				 
					 url = contextURL+'/int/admin/openReimbursementPage.action';
					 $("#includepageDivId").empty().load(url, function(){
						 $('#addAgreementName').show();	
						 $('#editAgreementName').hide();
						 $('#addANewReimbusementMgmt').show();
						 $('#editANewReimbusementMgmt').hide();				 
						 $('.reimbusementMgmtPanel').attr('id','addANewReimbusementMgmtPanel');		
						 $('#editSectionDiv').attr('style','margin-left:5px');
						 $('#editSectionDiv').show();
						 $('#submitBtnDiv').show();
						 $('#auditlogDiv').hide();
					 });
				 }else{
					 $('#addAgreementName').show();	
					 $('#editAgreementName').hide();
					 $('#addANewReimbusementMgmt').show();
					 $('#editANewReimbusementMgmt').hide();				 
					 $('.reimbusementMgmtPanel').attr('id','addANewReimbusementMgmtPanel');		
					 $('#editSectionDiv').attr('style','margin-left:5px');
					 $('#editSectionDiv').show();
					 $('#submitBtnDiv').show();
					 $('#auditlogDiv').hide();
				 }
			 }else if(selectedOption=="edit")
			 {				
				 $('#addAgreementName').hide();	
				 $('#addANewReimbusementMgmt').hide();
				 $('#editANewReimbusementMgmt').show();
				 $('#editAgreementName').show();
				 $('.reimbusementMgmtPanel').attr('id','editANewReimbusementMgmtPanel'); 				 
				 var agreementId = $('#reimbursementAgreementLNamesId').val();				 
				 if(agreementId == "-1"){
					 $('#editSectionDiv').hide();
					 $('#auditlogDiv').hide();
					 $('#submitBtnDiv').hide();
				 }else
				 {
					 $('#editSectionDiv').attr('style','margin-left:5px');
					 $('#editSectionDiv').show();
					 $('#auditlogDiv').show();
					 $('#submitBtnDiv').show();
				 }

			 }
			 $('#showReimbursement').show();	
		 }else
		 {
			 $('#showReimbursement').hide();
			 $('#addAgreementName').hide();	
			 $('#editAgreementName').hide();
			 $('#addANewReimbusementMgmt').hide();
			 $('#editANewReimbusementMgmt').hide();
			 $('#submitBtnDiv').hide();
		 }
	 }	   
	 $('#enableId_Enabled').click(function () {
		   $('#siteMsg').hide();
	 });
	  $('#enableId_Disabled').click(function () {
		  var val = $("#yes_true").is(':checked');			 
		  if (val){
		   $('#siteMsg').show(); 
		  }
	 });
	  
	 $('input:radio[name=add]').click(function() {		
	         if ($('#yes').attr('checked')) {
	             $('#one').show();
	           } else if ($('#no').attr('checked')) {
	             $('#one').hide();
	          }
	  });

    $('input:radio[name=edit]').click(function() {    	
	         if ($('#yes1').attr('checked')) {
	             $('#two').show();
	           } else if ($('#no1').attr('checked')) {
	             $('#two').hide();
	          }
    }); 
    
	defaultAgreementClick();	  	 
	 $('#yes_true').click(function() {
		 	$('#one').show();   
		});
    $('#no_false').click(function() {
			$('#one').hide();	   
		});
    if($('#yes_true').is(':checked')) {
    	$('#one').show();   
    }
    if($('#no_false').is(':checked')) {
    	$('#one').hide();	   
    }
    $('#yes1_true').click(function() {
			$('#two').show();		   
		});
	$('#no1_false').click(function() {
			$('#two').hide();	   
    	});
		  
    
    function defaultAgreementClick(){         	
		var selectedOption = $('input:radio[name=addOrEditSelection]:checked').val();		
		if(selectedOption == "add"){		
			if ($('#yes_true').attr('checked')) {
	             $('#one').show();
	           } else if ($('no_false').attr('checked')) {
	             $('#one').hide();
	          }
		}
		if(selectedOption == "edit"){		
			if ($('#yes1_true').attr('checked')) {
	             $('#two').show();
	           } else if ($('#no1_false').attr('checked')) {
	             $('#two').hide();
	          }			
		}				
    }

    if(!$('#reimbursementAgreementLNamesId').attr('handlerRegistered')) {
    	$('#reimbursementAgreementLNamesId').live('change', function() {   
    		var reimbursementAgreementId = $('#reimbursementAgreementLNamesId').val();
    		var selectedOption = $('input:radio[name=addOrEditSelection]:checked').val();	 	   
    		var allow = reimbursementAgreementId == "-1" ? false : true;
    		if(!allow) {    			
    			$("#reimbursementAgreementErrorId").show();
    			$("#editSectionDiv").hide();
    			$("#auditlogDiv").hide();
    			$("#submitBtnDiv").hide();
    			return;
    		}	
    		$("#reimbursementAgreementErrorId").hide();
    		$("#reimbursementAgreementProcess0").show(); 
    		var url = contextURL +'/int/admin/reimbursementAgreementDetails.action';		
    		var formData = {'reimbursement.reimbursementAgreement.reimbursementAgreementId':reimbursementAgreementId,'addOrEditSelection':selectedOption};
    		$.ajax({
    			type:'POST',
    			url: url,
    			dataType: 'html',
    			data: formData, 
    			success: function(data) {
    				$("#reimbursementAgreemenMgmtDivId").replaceWith(data);
    				$("#reimbursementAgreemenMgmtDivId").show();      				
    				$('#editSectionDiv').show();
    				$("#ReimAgrfooterDiv").empty();	 	  
    			}
    		});			
    	});
    	$('#includePageId').val(true);		 	
    	$('#reimbursementAgreementLNamesId').attr('handlerRegistered', true);
    } 
    $('table.table tr:odd').addClass('odd');
    if (window.PIE) {
        $('.rounded').each(function() {
            PIE.attach(this);
        });
    }  
});




jQuery(function($){			 
	  var reimbursementValidationSuccess = $('#reimbursementValidationId').val();	 	 
	  if(reimbursementValidationSuccess!=undefined && reimbursementValidationSuccess != ''){		 
	 	    $('#reimbursementValidationId').val(null);	
	 	    $("#editSectionDiv").attr('style','margin-left:-5px');	 	    
			$('#reimbursementAgreementModel').modal({		 
			        show: 'true'
			        
		  }); 
	  }			
	  var validationSuccess = $('#validationSuccessId').val();		  
	  if(validationSuccess!=undefined && validationSuccess == 'Y'){	
 	    $('#validationSuccessId').val(null); 	    
 	    $("#standardFormatMgmtBodyDiv").attr('style','margin-left:0px');
 	    $("auditLogDiv").attr('style','margin-left:0px');
 	    $("#standardFormatMgmtBodyDiv").show();
		$('#standardFormatModel').modal({				
		        show: 'true'
		        
	     }); 		
	  }
});	
//	
function getFormatMasterDetails()
{
	$("#standardFormatMgmtBodyDiv").hide();
	var instrumentType = $('#standardFormatInstrumentType').val();
	var instrumentPurposeId = $('#instrumentPurposeId').val();
	var bondType = $('#standardFormatBondType').val();
	var subBondType = $('#standardFormatSubBondType').val();			
	var url = contextURL +'/int/admin/getStdFormatManagement.action';		
	var formData = {'standardFormatMaster.standardFormatInstrumentTypeId':instrumentType, 'standardFormatMaster.standardFormatPurpusId':instrumentPurposeId,'standardFormatMaster.standardFormatBondTypeId':bondType, 'standardFormatMaster.standardFormatSubBondTypeId':subBondType};
	$.ajax({
	    type:'POST',
		url: url,
		dataType: 'html',
		data: formData, 
		success: function(data) {		
			 $("#standardFormatMgmtDiv").replaceWith(data);								  
		     $("#footerDiv").empty();	 	    	
		     $("#standardFormatMgmtBodyDiv").attr('style','margin-left:-5px');
		     $("#standardFormatMgmtBodyDiv").show();					    
		}
	});		
};


function cancelReimbursementAgreement(){	
	document.forms[0].method="Post";
	document.forms[0].action = contextURL + '/int/admin/treasuryAdminPortal.action';
	document.forms[0].submit();
};	

function popUpReimbursementWindow(agreementName) {		
	  n = window.open('#confirmReimbursementAgreement', '_self');	
	  $('#agreementName', n.document).val(agreementName);	
	  $('#modalAgreementName', n.document).val(agreementName);		 	 	
	  $('#confirmReimbursementAgreement').modal({		 
		        show: 'true'
		        
	  }); 
	  
	};	
	function registerCommonTinyMCE(maxChars,textAreaId) {
		tinymce.init({
			mode : "textareas",		   
			theme : "advanced",	   
			editor_selector : "mceEditor",
			theme_advanced_toolbar_align : "left", 
			plugins : "maxchars,style",
			theme_advanced_buttons1:"bold,italic,underline,|,justifyleft,justifycenter,justifyright,justifyfull,|,bullist,outdent,indent,link,unlink,forecolor,backcolor|,undo,redo", 	
			theme_advanced_buttons2:"",
			theme_advanced_buttons3:"",
			theme_advanced_buttons3_add : "styleprops",
			theme_advanced_blockformats : "p,div,h1,h2,h3,h4,h5,h6,blockquote,dt,dd,code,samp",
			theme_advanced_buttons4:"", 
			theme_advanced_statusbar_location : "bottom",
			theme_advanced_path : false,
			max_chars : maxChars,
			max_chars_indicator : textAreaId,
			setup: function(ed) {
				var text = "";
				var wordcount = false;
				ed.onSetContent.add(function(ed, e) {
					if (!wordcount) {
						wordcount = addWordCount();
					}
					var charsMaxLength =0;
					if(maxChars==10000)
						charsMaxLength = "(Limit is 10,000 characters).";
					else
						charsMaxLength = "(Limit is 200 characters).";
					text = ed.getContent().replace(/(<([^>]+)>)/ig,"").replace(/&nbsp;/gi,""); 					
					text = $.trim(text);					
					var textAreaVal = $('#'+textAreaId).val();
					if(textAreaVal !=null && textAreaVal != undefined){						
						if(text.length <= maxChars){
							$('#' + tinyMCE.activeEditor.id + '_wordcount').html("<span>" +(maxChars-text.length) + "</span> characters left "+charsMaxLength);
						}else
							$('#' + tinyMCE.activeEditor.id + '_wordcount').html("<span>" +0+ "</span> characters left "+charsMaxLength);
					}
				});
				ed.onKeyUp.add(function(ed, e) { 
					if (!wordcount) {
						wordcount = addWordCount();
					}
					var charsMaxLength =0;
					if(maxChars==10000)
						charsMaxLength = "(Limit is 10,000 characters).";
					else
						charsMaxLength = "(Limit is 200 characters).";
					text = ed.getContent().replace(/(<([^>]+)>)/ig,"").replace(/&nbsp;/gi,"");
					text = $.trim(text);
					var textAreaVal = $('#'+textAreaId).val();					
					if(textAreaVal !=null && textAreaVal != undefined){						
						if(text.length <= maxChars){
							$('#' + tinyMCE.activeEditor.id + '_wordcount').html("<span>" +(maxChars-text.length) + "</span> characters left "+charsMaxLength);
						}else
							$('#' + tinyMCE.activeEditor.id + '_wordcount').html("<span>" +0+ "</span> characters left "+charsMaxLength);
					}				
				});				
			}
		});

	}
function addWordCount() {
	$('span.mceEditor').after('<div id="' + tinyMCE.activeEditor.id + '_wordcount" class="wordcount" style="color: #777777">0  words, 0 characters</div>');
	return true;
}

function setViewRetention(Retention){
	if(Retention !=null && Retention !=""){
		$('#viewRetentionID').val(Retention);
	}
	else
		$('#viewRetentionID').val("");
	
}
function setValueFlag()
{
	
	var oneTimeDateSel =$('input[id=scheduleFrequencyFlagId_false]:checked').val(); 
	if(oneTimeDateSel!=undefined && oneTimeDateSel == 'false'){
		$("#oneTimeID").show();
		var SchFrqVal = $('#scheduleFrequencyID').val();	
		if(SchFrqVal !=undefined && SchFrqVal != "" ){
			$('#scheduleFrequencyID').val("");	
		}
	}
	
	var scheduleFrequencyIDVal =$('input[id=scheduleFrequencyFlagId_true]:checked').val(); 
	if(scheduleFrequencyIDVal!=undefined && scheduleFrequencyIDVal == 'true'){
		$("#scheduleSelectionId").show();
		var SchFlagVal = $('#runDateId').val();	
		if(SchFlagVal !=undefined && SchFlagVal != "" ){
			$('#runDateId').val("");	
		}
	}

}
/*
 * 
 */
function deleteUserannouncement(userAnnouncementId) {		
	n = window.open('#deleteRequestModal','_self');
	$('#activeUserAnnouncementId', n.document).val(userAnnouncementId);	
	$('#deleteUserAnnouncementId').text(userAnnouncementId); 	
	$('#deleteRequestModal').modal({ 		 
	        show: 'true'	        
	 }); 	
  }	
