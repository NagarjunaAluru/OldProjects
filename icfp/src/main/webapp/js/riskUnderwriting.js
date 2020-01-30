$(document).ready(function() {
	//var length = 500-$('#sendBackComments').val().length;;
	//$("#sendBackCommentsSizeId").replaceWith( ""+length );	
	//var length = 500-$('#rejectRequestComments').val().length;;
	//$("#rejectRequestCommentsSizeId").replaceWith( ""+length );	

	$('#genericErrorComment').hide();
	//$('#riskReviewOverviewNeededErrorBar').removeClass("req-error");
	//$('#revisedTransactionClassificationLevelErrorBar').removeClass("req-error");
	//$('#revisedTransactionClassificationLevelCommentErrorBar').removeClass("req-error");
	$('#sendBackCommentsErrorBar').removeClass("req-error");
	$('#rejectCommentsErrorBar').removeClass("req-error");
	$('#submitErrorBar').removeClass("req-error");
	//$('#borrowerSolvencyErrorBar').removeClass("req-error");
	/*$("#riskReviewOverrideNeededY").click(function(){
		$('#riskReviewOverviewNeededErrorBar').removeClass("req-error");
	});
	$("#riskReviewOverrideNeededN").click(function(){
		$('#riskReviewOverviewNeededErrorBar').removeClass("req-error");
	});
*/
	$('#submit').click(function(e){
		$('#teamMemberId').show();
		$("#forwardPageId").val("submitSuccess");
		$('#sendBackComments').val("");
		$('#rejectComments').val("");
		$('#riskReviewOverviewNeededErrorBar').removeClass("req-error");
		$('#revisedTransactionClassificationLevelErrorBar').removeClass("req-error");
		$('#revisedTransactionClassificationLevelCommentErrorBar').removeClass("req-error");
		$('#sendBackCommentsErrorBar').removeClass("req-error");
		$('#rejectCommentsErrorBar').removeClass("req-error");
		$('#submitErrorBar').removeClass("req-error");
		//$('#borrowerSolvencyErrorBar').removeClass("req-error");
		var comments = $('#dealCommentsId').val();
		var action = $('input:radio[name=submitDealFB]:checked').val();
		if(action == 'affirm'){
			$("#inputsCompletedModalID").modal('show');
			
		}else if(action == '' || action == undefined){
			$('#cashManagementFBId').find('.btn-container').find('.radio-container').addClass('conditional-radio-tri req-error');
			$('#submitErrorBar').addClass("req-error");
			$('#actionButton').attr('style','margin-top: 100px;');
		}else if (action === 'sendBack'){
			$("#sendback").modal('show');
		}
		
	});
	
	$('#sendBack').click(function(e){
		var comments = $('#sendBackComments').val();
		if(comments != ''){
			$('#approveRejectId').val("2");
			$('#actionID').val("sendBack");
			$('#sendBack').attr('data-dismiss','modal');
			$('#sendBackCommentsErrorBar').hide();
			$('#actionCommentsID').val(comments);
			$('#cashManagementFBId').find('.radio-container').removeClass('conditional-radio-tri req-error');
			document.forms[0].action = contextURL + '/riskUnderwriting/riskUnderwriting.do?command=submitDealRequest&action=sendBack';
			document.forms[0].submit();
		}else{
			$('#sendBackCommentsErrorBar').show();
			$('#sendBack').removeAttr('data-dismiss');
		}
	});
	
	$('#reject').click(function(e){
		var comments = $('#rejectRequestComments').val();
		if(comments && comments != ''){
			$('#approveRejectId').val("1");
			$('#actionID').val("reject");
			$('#reject').attr('data-dismiss','modal');
			$('#cashManagementFBId').find('.radio-container').removeClass('conditional-radio-tri req-error');
			$('#actionCommentsID').val(comments);
			document.forms[0].action = contextURL + '/riskUnderwriting/riskUnderwriting.do?command=submitDealRequest&action=reject';
			document.forms[0].submit();
		}else{
			$('#rejectCommentsErrorBar').addClass("req-error");
			$('#reject').removeAttr('data-dismiss');
		}
	});
	$('#saveAction').click(function(e){
		 $("#saveDataModelID").modal('show');
		
	});
	$('#assignToTeamMember').click(function(e){
		var teamMemberId = $('#teamMemberId').val();
		var comments = $('#dealCommentsId').val();
		if(teamMemberId != ''){
			$('#approveRejectId').val("7");
			$('#actionID').val("assignReview");
			$('#commentsID').val(comments);
			$('#assignToTeamMember').attr('data-dismiss','modal');
			$('#teamMemberId').hide();
			$('#teamMemberIdErrorSpan').hide();
			var teamMemberId = $('#teamMemberId').val();
			$("#teamMember").empty().append("<b>"+teamMemberId+"</b>");
			var lastfirstnames = $("#teamMemberId option:selected").text();
			$("#lastfirstnames").empty().append("<b>"+lastfirstnames+"</b>");
			$('#assignReviewerpopup').modal('show');
		}else{
			$('#teamMemberIdErrorSpan').show();
			$('#teamMemberId').show();
			$('#assignToTeamMember').removeAttr('data-dismiss'); 
		}
	});
	$('textarea').keyup(function() {
		var len = this.value.length;
		if (len >= 499) {
			this.value = this.value.substring(0, 500);
		}
	});
});
function validateRiskReview() {
	var val = $('input:radio[id=riskReviewOverrideNeeded]:checked').val();
	var errorExists = false;
	if(val == undefined){
		$('#riskReviewOverviewNeededErrorBar').addClass("req-error");
		errorExists = true;
	}else{
		if(val == "1"){
			if($("#revisedTransactionClassificationLevel").val() == "" || $("#revisedTransactionClassificationLevel").val()==undefined){
				$('#revisedTransactionClassificationLevelErrorBar').addClass("req-error");
				errorExists = true;
			}
			if($("#revisedTransactionClassificationLevelComment").val() == ""){
				$('#revisedTransactionClassificationLevelCommentErrorBar').addClass("req-error");
				errorExists = true;
			}
		}
	}
	return errorExists;
}

function inputsCompleted()
{
	var comments = $('#dealCommentsId').val();
	var action = $('input:radio[name=submitDealFB]:checked').val();
	$('#approveRejectId').val("0");
	$('#actionID').val(action);
	$('#commentsID').val(comments);
	$('#topErrorDiv').hide();
	$('#cashManagementFBId').find('.radio-container').removeClass('conditional-radio-tri req-error');
	$('#actionButton').removeAttr('style');
	if(!validateRiskReview()){
		document.forms[0].action = contextURL + '/riskUnderwriting/riskUnderwriting.do?command=submitDealRequest&action='+action;
		document.forms[0].submit();
	}else{
		$("#inputsCompletedModalID").modal('hide');
		$(window).scrollTop(100);
		$('#genericErrorComment').show();
	}
}
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
	document.forms[0].action = contextURL + '/riskUnderwriting/riskUnderwriting.do?command=submitDealRequest&action=save';
	document.forms[0].submit();
}

function assignMember(){
	var teamMemberId = $('#teamMemberId').val();
	document.forms[0].action = contextURL + '/riskUnderwriting/riskUnderwriting.do?command=submitDealRequest&action=assignReview&teamMemberId='+teamMemberId;
	document.forms[0].submit();
}