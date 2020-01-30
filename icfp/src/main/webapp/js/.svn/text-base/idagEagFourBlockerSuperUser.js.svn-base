$(document).ready(function() {
	var continueAction = "";
	$('#submit').click(function(e){
		$('#topErrorDiv').hide();
		$('#topErrorDiv1').hide();
		$('#topErrorDiv2').hide();
		$("#forwardPageId").val("submitSuccess");
		$('#sendBackComments').val("");
		$('#rejectComments').val("");
		$('#submitErrorBar').removeClass("req-error");
		$('#approveWithModCommentsErrorBar').removeClass("req-error");
		$('#sendForwardToCommentsErrorBar').removeClass("req-error");
		$('#approveOnBehalfCommentsErrorBar').removeClass("req-error");
		$('#rejectRequestCommentsErrorBar').removeClass("req-error");
		$('#rejectOnBehalfCommentsErrorBar').removeClass("req-error");
		$('#sendToTESGCommentsErrorBar').removeClass("req-error");
		$('#sendbackCommentsErrorBar').removeClass("req-error");
		$('#sendToTESGApproveOnBehalfCommentsErrorBar').removeClass("req-error");
		var comments = $('#dealCommentsId').val();
		$('#commentsID').val(comments);
		var errorExists = false;
		var action = $('input:radio[name=submitbutton]:checked').val();
		if(action == '' || action == undefined){
			$('#submitErrorBar').addClass("req-error");
			errorExists = true;
		}
		if(!errorExists && action == 'approve'){
			$('#approveRejectId').val("0");
			$('#actionID').val(action);
			continueAction = "approve";
			$('#wantToContinuePopup').modal('show');
		}
		if(errorExists){
			$('#genericErrorComment').show();
		}
	});
	$('#wantToContinue').click(function(e){
		if(continueAction == "approve"){
			document.forms[0].action = contextURL + '/idagEag/idagEag.do?command=submitDealRequest&action='+continueAction;
			document.forms[0].submit();
		}else if(continueAction == "approveWithMod"){
			document.forms[0].action = contextURL + '/idagEag/idagEag.do?command=submitDealRequest&action='+continueAction+'&approveReject=0';
			document.forms[0].submit();
		}else if(continueAction == "approveOnBehalfIdagEag"){
			document.forms[0].action = contextURL + '/idagEag/idagEag.do?command=submitDealRequest&onBehalf=true';
			document.forms[0].submit();
		}else if(continueAction == "sendToTESGApproveWithMod"){
			document.forms[0].action = contextURL + '/idagEag/idagEag.do?command=submitDealRequest&action='+continueAction+'&approveReject=0';
			document.forms[0].submit();
		}else if(continueAction == "sendToTESGApproveOnBehalfIdagEag"){
			document.forms[0].action = contextURL + '/idagEag/idagEag.do?command=submitDealRequest&onBehalf=true';
			document.forms[0].submit();
		}else if(continueAction == "sendToTESGApprove"){
			document.forms[0].action = contextURL + '/idagEag/idagEag.do?command=submitDealRequest&action='+continueAction+'&approveReject=0';
			document.forms[0].submit();
		}
	});
	$('#approveWithModification').click(function(e){
		var comments = $('#approveWithModComments').val();
		var dealcomments = $('#dealCommentsId').val();
		$('#commentsID').val(comments);
		if(comments != ''){
			$("#forwardPageId").val("submitSuccess");
			$('#commentsID').val(dealcomments);
			$('#actionCommentsID').val(comments);
			$('#approveRejectId').val("0");
			$('#actionID').val("approveWithMod");
			$('#approveWithModification').attr('data-dismiss','modal');
			$('#approveWithModComments').hide();
			continueAction = "approveWithMod";
			$('#wantToContinuePopup').modal('show');
		}else{
			$('#approveWithModCommentsErrorBar').addClass("req-error");
			$('#approveWithModification').removeAttr('data-dismiss');
		}
	});
	$('#approveOnBehalfIdagEag').click(function(e){
		var comments = $('#approveOnBehalfComments').val();
		if(comments != ''){
			var checkBoxes = $("input[name=approverOnBehalf]");
			var approverSelected = new Array();
			var approveOnBehalf="";
			var counter = 0;var i=0;
			$.each(checkBoxes, function() {
	        	if ($(this).attr('checked')){
	        		counter++;
	        		var eachApproverFlag = $(this).attr("value");
	        		var eachApproverGroup = $(this).parent().next().text();
	        		
	        		var eachApproverSSO = $(this).parent().next().next().find('#IDAGMemberName option:selected').val();
	        		var eachApproverName = $(this).parent().next().next().find('#IDAGMemberName option:selected').text();
	        		if(eachApproverSSO == '' && eachApproverName == 'Select...'){
	        			approverSelected[i] = eachApproverGroup;
	        			i++;
	        		}
	        		if(eachApproverGroup == 'ICFP-IDAG-TransferPricing'){
	        			eachApproverGroup = 'ICFP-IDAG-TferPrice';
	        		}
	        		var eachApprover = eachApproverFlag+";"+eachApproverGroup+";"+eachApproverSSO+";"+eachApproverName;
	        		approveOnBehalf += eachApprover + "|";
	        	}
	        });
			if( approverSelected.length > 0 ){
				var errorMsg = "Please Select Approver Name for the Following Group Name <ul>";
				for ( var int = 0; int < approverSelected.length; int++) {
					errorMsg += "<li>" + approverSelected[int] + "</li>"; 
				}
				errorMsg += "</ul>";
				$('#topErrorDiv').find('strong').html(errorMsg); 
				$('#topErrorDiv').show();
				$('#approveOnBehalfIdagEag').removeAttr('data-dismiss');
			}else if( counter == 0 ){
				var errorMsg = "Please Check atleast One Group to Affirm on behalf of IDAG";
				$('#topErrorDiv').find('strong').html(errorMsg); 
				$('#topErrorDiv').show();
				$('#approveOnBehalfIdagEag').removeAttr('data-dismiss');
			}else{
				$('#topErrorDiv').hide();
				approveOnBehalf=approveOnBehalf.replace(/\|$/,"");
				$('#approveOnBehalfIdagEag').attr('data-dismiss','modal');
				$('#approveOnBehalfErrorComments').hide();
				$('#approveRejectId').val("0");
				$('#actionID').val("approveOnBehalfIdagEag");
				$('#actionCommentsID').val(comments);
				$('#approverListId').val(approveOnBehalf);
				$('#approveOnBehalfCommentsErrorBar').removeClass("req-error");
				continueAction = "approveOnBehalfIdagEag";
				$('#wantToContinuePopup').modal('show');
			}
		}else{
			$('#approveOnBehalfCommentsErrorBar').addClass("req-error");
			$('#approveOnBehalfIdagEag').removeAttr('data-dismiss');
		}
		
	});
	$('#rejectDealRequest').click(function(e){
		var comments = $('#rejectRequestComments').val();
		if(comments != ''){
			$('#approveRejectId').val("1");
			$('#actionID').val("reject");
			$('#actionCommentsID').val(comments);
			$('#rejectDealRequest').attr('data-dismiss','modal');
			document.forms[0].action = contextURL + '/idagEag/idagEag.do?command=submitDealRequest&action=reject&approveReject=1';
			document.forms[0].submit();
		}else{
			$('#rejectRequestCommentsErrorBar').addClass("req-error");
			$('#rejectDealRequest').removeAttr('data-dismiss');
		}
	});
	$('#rejectOnBehalfIdagEag').click(function(e){
		var comments = $('#rejectOnBehalfComments').val();
		if(comments != ''){
			var checkBoxes = $("input[name=rejecterOnBehalf]");
			var approverSelected = new Array();
			var rejectOnBehalf="";
			var counter = 0;var i=0;
			$.each(checkBoxes, function() {
	        	if ($(this).attr('checked')){
	        		counter++;
	        		var eachApproverFlag = $(this).attr("value");
	        		var eachApproverGroup = $(this).parent().next().text();
	        		
	        		var eachApproverSSO = $(this).parent().next().next().find('#IDAGMemberName option:selected').val();
	        		var eachApproverName = $(this).parent().next().next().find('#IDAGMemberName option:selected').text();
	        		if(eachApproverSSO == '' && eachApproverName == 'Select...'){
	        			approverSelected[i] = eachApproverGroup;
	        			i++;
	        		}
	        		if(eachApproverGroup == 'ICFP-IDAG-TransferPricing'){
	        			eachApproverGroup = 'ICFP-IDAG-TferPrice';
	        		}
	        		var eachApprover = eachApproverFlag+";"+eachApproverGroup+";"+eachApproverSSO+";"+eachApproverName;
	        		rejectOnBehalf += eachApprover + "|";
	        	}
	        });
			if(approverSelected.length > 0){
				var errorMsg = "Please Select Approver Name for the Following Group Name <ul>";
				for ( var int = 0; int < approverSelected.length; int++) {
					errorMsg += "<li>" + approverSelected[int] + "</li>"; 
				}
				errorMsg += "</ul>";
				$('#topErrorDiv1').find('strong').html(errorMsg); 
				$('#topErrorDiv1').show();
				$('#rejectOnBehalfIdagEag').removeAttr('data-dismiss');
			}else if( counter == 0 ){
				var errorMsg = "Please Check atleast One Group to Affirm on behalf of IDAG";
				$('#topErrorDiv1').find('strong').html(errorMsg); 
				$('#topErrorDiv1').show();
				$('#rejectOnBehalfIdagEag').removeAttr('data-dismiss');
			}else{
				$('#topErrorDiv1').hide();
				rejectOnBehalf=rejectOnBehalf.replace(/\|$/,"");
				$('#approveRejectId').val("1");
				$('#actionID').val("rejectOnBehalfIdagEag");
				$('#approverListId').val(rejectOnBehalf);
				$('#actionCommentsID').val(comments);
				$('#rejectOnBehalfIdagEag').attr('data-dismiss','modal');
				document.forms[0].action = contextURL + '/idagEag/idagEag.do?command=submitDealRequest&onBehalf=true';
				document.forms[0].submit();
			}
		}else{
			$('#rejectOnBehalfCommentsErrorBar').addClass("req-error");
			$('#rejectOnBehalfIdagEag').removeAttr('data-dismiss');
		}
	});
	$('#sendbackToTESG').click(function(e){
		var val = $('input:radio[name=sendToTesgApprovalMethod]:checked').val();
		if(val == "approveWithMod"){
			if($('#sendToTESGApproveWithModComments').val() != ''){
				$('#approveRejectId').val("0");
				$('#actionID').val('sendToTESGApproveWithMod');
				$('#tesgEscalFlag').val("1");
				$('#sendbackToTESG').attr('data-dismiss','modal');
				continueAction = "sendToTESGApproveWithMod";
				$('#wantToContinuePopup').modal('show');
			}else{
				$('#sendToTESGApproveWithModCommentsErrorBar').addClass("req-error");
				$('#sendbackToTESG').removeAttr('data-dismiss');
			}
		}else if(val == "approveOnBehalf"){
			var comments = $('#sendToTESGApproveOnBehalfComments').val();
			
			if(comments != ''){
				
				var checkBoxes = $("input[name=approverOnBehalf]");
				var approverSelected = new Array();
				var approveOnBehalf="";
				var counter = 0;var i=0;
				$.each(checkBoxes, function() {
		        	if ($(this).attr('checked')){
		        		counter++;
		        		var eachApproverFlag = $(this).attr("value");
		        		var eachApproverGroup = $(this).parent().next().text();
		        		
		        		var eachApproverSSO = $(this).parent().next().next().find('#IDAGMemberName option:selected').val();
		        		var eachApproverName = $(this).parent().next().next().find('#IDAGMemberName option:selected').text();
		        		if(eachApproverSSO == '' && eachApproverName == 'Select...'){
		        			approverSelected[i] = eachApproverGroup;
		        			i++;
		        		}
		        		if(eachApproverGroup == 'ICFP-IDAG-TransferPricing'){
		        			eachApproverGroup = 'ICFP-IDAG-TferPrice';
		        		}
		        		var eachApprover = eachApproverFlag+";"+eachApproverGroup+";"+eachApproverSSO+";"+eachApproverName;
		        		approveOnBehalf += eachApprover + "|";
		        	}
		        });
				if(approverSelected.length > 0){
					var errorMsg = "Please Select Approver Name for the Following GroupName <ul>";
					for ( var int = 0; int < approverSelected.length; int++) {
						errorMsg += "<li>" + approverSelected[int] + "</li>"; 
					}
					errorMsg += "</ul>";
					$('#topErrorDiv2').find('strong').html(errorMsg); 
					$('#topErrorDiv2').show();
					$('#sendbackToTESG').removeAttr('data-dismiss');
				}else if( counter == 0 ){
					var errorMsg = "Please Check atleast One Group to Affirm on behalf of IDAG";
					$('#topErrorDiv2').find('strong').html(errorMsg); 
					$('#topErrorDiv2').show();
					$('#sendbackToTESG').removeAttr('data-dismiss');
				}else{
					$('#topErrorDiv2').hide();
					approveOnBehalf=approveOnBehalf.replace(/\|$/,"");
					$('#approverListId').val(approveOnBehalf);
					$('#sendbackToTESG').attr('data-dismiss','modal');
					$('#approveRejectId').val("0");
					$('#tesgEscalFlag').val("1");
					$('#actionCommentsID').val(comments);
					$('#actionID').val('approveOnBehalfIdagEag');
					continueAction = "sendToTESGApproveOnBehalfIdagEag";
					$('#wantToContinuePopup').modal('show');
				}
			}else{
				$('#sendToTESGApproveOnBehalfCommentsErrorBar').addClass("req-error");
				$('#sendbackToTESG').removeAttr('data-dismiss');
			}
		}else if(val == "approve"){
			$('#approveRejectId').val("0");
			$('#actionID').val("approve");
			$('#tesgEscalFlag').val("1");
			continueAction = "sendToTESGApprove";
			$('#wantToContinuePopup').modal('show');
		}

	});
	$('#sendbackToFO').click(function(e){
		var comments = $('#sendbackComments').val();
		if(comments != ''){
			$("#forwardPageId").val("submitSuccess");
			$('#approveRejectId').val("2");
			$('#actionID').val("sendBack");
			$('#sendbackToFO').attr('data-dismiss','modal');
			$('#actionCommentsID').val(comments);
			document.forms[0].action = contextURL + '/idagEag/idagEag.do?command=submitDealRequest&action=sendBack';
			document.forms[0].submit();
		}else{
			$('#sendbackCommentsErrorBar').addClass("req-error");
			$('#sendbackToFO').removeAttr('data-dismiss');
		}
	});
	
	$('#sendToTC').click(function(e){
		var comments = $('#sendForwardToComments').val();
		if(comments != ''){
			$("#forwardPageId").val("submitSuccess");
			$('#approveRejectId').val("0");
			$('#actionID').val("sendToTC");
			$('#sendToTC').attr('data-dismiss','modal');
			$('#sendToTC').hide();
			$('#actionCommentsID').val(comments);
			document.forms[0].action = contextURL + '/idagEag/idagEag.do?command=submitDealRequest&action=sendToTC&approveReject=0';
			document.forms[0].submit();
		}else{
			$('#sendForwardToCommentsErrorBar').addClass("req-error");
			$('#sendToTC').removeAttr('data-dismiss');
		}
	});
	
	$('#saveAction').click(function(e){
		$("#saveDataModelID").modal('show');
	});
	$('textarea').keyup(function() {
		var len = this.value.length;
		if (len >= 499) {
			this.value = this.value.substring(0, 500);
		}
	});

});

function saveData()
 { 
	var comments = $('#dealCommentsId').val();
	$('#commentsID').val(comments);
	$('#approveRejectId').val("0");
	$('#actionID').val("save");
	$("#forwardPageId").val("success");
	$('#topErrorDiv').hide();
	$('#cashManagementFBId').find('.radio-container').removeClass('conditional-radio-tri req-error');
	$('#actionButton').removeAttr('style');
	document.forms[0].action = contextURL + '/idagEag/idagEag.do?command=submitDealRequest&action=save';
	document.forms[0].submit();
 }
