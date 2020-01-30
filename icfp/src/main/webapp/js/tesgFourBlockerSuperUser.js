$(document).ready(function() {
	var continueAction = "";
	$('#submit').click(function(e){
		$("#forwardPageId").val("submitSuccess");
		$('#sendBackComments').val("");
		$('#rejectComments').val("");
		$('#submitErrorBar').removeClass("req-error");
		$('#approveWithModCommentsErrorBar').removeClass("req-error");
		$('#approveOnBehalfCommentsErrorBar').removeClass("req-error");
		$('#rejectRequestCommentsErrorBar').removeClass("req-error");
		$('#rejectOnBehalfCommentsErrorBar').removeClass("req-error");
		$('#sendToeBoardroomCommentsErrorBar').removeClass("req-error");
		$('#sendbackCommentsErrorBar').removeClass("req-error");

		var errorExists = false;
		var action = $('input:radio[name=submitbutton]:checked').val();
		if(action == '' || action == undefined){
			$('#submitErrorBar').addClass("req-error");
			errorExists = true;
		}
		var comments = $('#dealCommentsId').val();
		$('#commentsID').val(comments);
		if(!errorExists && action == 'approve'){
			$('#approveRejectId').val("0");
			$('#actionID').val(action);
			continueAction = "approve";
			$('#wantToContinuePopup').modal('show');
		}else if( !errorExists && action === 'sendBackToFO'){
			$('#sendback').modal('show');
		}
		if(errorExists){
			$('#genericErrorComment').show();
		}
	});
	$('#wantToContinue').click(function(e){
		if(continueAction == "approve"){
			document.forms[0].action = contextURL + '/tesg/tesg.do?command=submitDealRequest&action='+continueAction;
			document.forms[0].submit();
		}else if(continueAction == "approveWithMod"){
			document.forms[0].action = contextURL + '/tesg/tesg.do?command=submitDealRequest&action='+continueAction+'&approveReject=0';
			document.forms[0].submit();
		}else if(continueAction == "approveOnBehalfTesg"){
			document.forms[0].action = contextURL + '/tesg/tesg.do?command=submitDealRequest&onBehalf1=true';
			document.forms[0].submit();
		}
	});
	$('#approveWithModification').click(function(e){
		var comments = $('#approveWithModComments').val();
		var dealcomments = $('#dealCommentsId').val();
		if(comments != ''){
			$('#approveRejectId').val("0");
			$('#actionID').val('approveWithMod');
			$('#actionCommentsID').val(comments);
			$('#commentsID').val(dealcomments);
			$("#forwardPageId").val("submitSuccess");
			$('#approveWithModification').attr('data-dismiss','modal');
			$('#approveWithModComments').hide();
			continueAction = "approveWithMod";
			$('#wantToContinuePopup').modal('show');
		}else{
			$('#approveWithModCommentsErrorBar').addClass("req-error");
			$('#approveWithModification').removeAttr('data-dismiss');
		}
	});
	$('#approveOnBehalfTesg').click(function(e){
		var comments = $('#approveOnBehalfComments').val();
		if(comments != ''){
			var checkBoxes = $("input[name=approverOnBehalf]");
			var approveOnBehalf="";
			var counter = 0;
			$.each(checkBoxes, function() {
	        	if ($(this).attr('checked')){
	        		counter++;
	        		approveOnBehalf += ($(this).attr("value")) + ",";
	        	}
	        });
			if( counter == 0 ){
				var errorMsg = "Please Check atleast One Group to Affirm on behalf of TESG";
				$('#topErrorDiv').find('strong').html(errorMsg); 
				$('#topErrorDiv').show();
				$('#approveOnBehalfCommentsErrorBar').removeClass("req-error");
				$('#approveOnBehalfTesg').removeAttr('data-dismiss');
			}else{
				approveOnBehalf=approveOnBehalf.replace(/,$/,"");
				$('#approveOnBehalfTesg').attr('data-dismiss','modal');
				$('#approveOnBehalfErrorComments').hide();
				$('#approveRejectId').val("0");
				$('#actionID').val('approveOnBehalfTesg');
				$('#approverListId').val(approveOnBehalf);
				$('#actionCommentsID').val(comments);
				continueAction = "approveOnBehalfTesg";
				$('#wantToContinuePopup').modal('show');
			}
		}else{
			$('#approveOnBehalfCommentsErrorBar').addClass("req-error");
			$('#approveOnBehalfTesg').removeAttr('data-dismiss');
		}
		
	});
	$('#rejectDealRequest').click(function(e){
		var comments = $('#rejectRequestComments').val();
		if(comments != ''){
			$('#approveRejectId').val("1");
			$('#actionID').val("reject");
			$('#rejectDealRequest').attr('data-dismiss','modal');
			$('#actionCommentsID').val(comments);
			document.forms[0].action = contextURL + '/tesg/tesg.do?command=submitDealRequest&action=reject&approveReject=1';
			document.forms[0].submit();
		}else{
			$('#rejectRequestCommentsErrorBar').addClass("req-error");
			$('#rejectDealRequest').removeAttr('data-dismiss');
		}
	});
	$('#rejectOnBehalfTesg').click(function(e){
		var comments = $('#rejectOnBehalfComments').val();
		if(comments != ''){
			var checkBoxes = $("input[name=rejecterOnBehalf]");
			var rejectOnBehalf="";
			var counter = 0;
			$.each(checkBoxes, function() {
	        	if ($(this).attr('checked')){
	        		counter++;
	        		rejectOnBehalf += ($(this).attr("value")) + ",";
	        	}
	        });
			if( counter == 0 ){
				var errorMsg = "Please Check atleast One Group to Reject on behalf of TESG";
				$('#topErrorDiv1').find('strong').html(errorMsg); 
				$('#topErrorDiv1').show();
				$('#rejectOnBehalfCommentsErrorBar').removeClass("req-error");
				$('#rejectOnBehalfTesg').removeAttr('data-dismiss');
			}else{
				rejectOnBehalf=rejectOnBehalf.replace(/,$/,"");
				$('#rejectOnBehalfTesg').attr('data-dismiss','modal');
				$('#approveRejectId').val("1");
				$('#actionID').val("rejectOnBehalfTesg");
				$('#approverListId').val(rejectOnBehalf);
				$('#actionCommentsID').val(comments);
				document.forms[0].action = contextURL + '/tesg/tesg.do?command=submitDealRequest&onBehalf1=true';
				document.forms[0].submit();
			}
		}else{
			$('#rejectOnBehalfCommentsErrorBar').addClass("req-error");
			$('#rejectOnBehalfTesg').removeAttr('data-dismiss');
		}
	});
	$('#sendbackToeBoardroom').click(function(e){
		
		var el = $("textarea[name='eboardComments']");
		
		if( $(el).val() == "" ) 
			return $(el).parent().append("<span class='req-error'>error</span>'");
		
		$("input[name='eboardComments']").val($(el).val());
		
		$('#actionID').val("sendToeBoardroomApprove");
		$('#ebordRoomFlag').val("1");
		$('#approveRejectId').val("0");
		document.forms[0].action = contextURL + '/tesg/tesg.do?command=submitDealRequest';
		document.forms[0].submit();
		
		$("#sendToeBoardroom").modal('hide');
		
	});
	$('#sendbackToFO').click(function(e){
		var comments = $('#sendbackComments').val();
		if(comments != ''){
			$("#forwardPageId").val("submitSuccess");
			$('#approveRejectId').val("2");
			$('#actionID').val("sendBack");
			$('#sendbackToFO').attr('data-dismiss','modal');
			$('#actionCommentsID').val(comments);
			document.forms[0].action = contextURL + '/tesg/tesg.do?command=submitDealRequest&action=sendBack';
			document.forms[0].submit();
		}else{
			$('#sendbackCommentsErrorBar').addClass("req-error");
			$('#sendbackToFO').removeAttr('data-dismiss');
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
	document.forms[0].action = contextURL + '/tesg/tesg.do?command=submitDealRequest&action=save';
	document.forms[0].submit();
}
