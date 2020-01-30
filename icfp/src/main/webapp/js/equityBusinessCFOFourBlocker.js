
$(document).ready(function() {
	$('#sendBackCommentsIdErrorSpan').hide();
	$('#dCommentsError1').hide();
	var continueAction = "";
	$('#submit').click(function(e){
		$("#forwardPageId").val("submitSuccess");
		$('#sendBackComments').val("");
		$('#sbCommentsError1').hide();
		var comments = $('#dealCommentsId').val();
		var action = $('input:radio[name=submitDealFB]:checked').val();
		if(action == undefined){
			$('#topErrorDiv').show();
			$('#cashManagementFBId').find('.radio-container').addClass('conditional-radio-tri req-error');
			$('#actionButton').attr('style','margin-top: 75px;');
		}else if(action == 'affirm'){
			$('#approveRejectId').val("0");
			$('#actionID').val(action);
			$('#topErrorDiv').hide();
			$('#commentsID').val(comments);
			$('#cashManagementFBId').find('.radio-container').removeClass('conditional-radio-tri req-error');
			$('#actionButton').removeAttr('style');
			continueAction = "affirm";
			$('#wantToContinuePopup').modal('show');
		}else if (action === 'sendBack'){
			$("#sendback").modal('show');
		}else{
			$('#topErrorDiv').hide();
			$('#dCommentsError1').hide();
			$('#cashManagementFBId').find('.radio-container').removeClass('conditional-radio-tri req-error');
			$('#actionButton').removeAttr('style');
		}
	});
	$('#wantToContinue').click(function(e){
		if(continueAction == "affirm"){
			document.forms[0].action = contextURL + '/equityBusinessCFO.do?command=submitDealRequest&action='+continueAction;
			document.forms[0].submit();
		}
	});
	$('#sendBack').click(function(e){
		var comments = $('#sendBackComments').val();
		if(comments != ''){
			$('#approveRejectId').val("2");
			$('#actionID').val("sendBack");
			$('#sendBack').attr('data-dismiss','modal');
			$('#sbCommentsError1').hide();
			$('#actionCommentsID').val(comments);
			//alert("SB Comments : "+$('#sendBackComments').val());
			document.forms[0].action = contextURL + '/equityBusinessCFO.do?command=submitDealRequest&action=sendBack';
			document.forms[0].submit();
		}else{
			$('#sbCommentsError1').show();
			$('#sendBack').removeAttr('data-dismiss');
		}
	});
	
	$('#saveAction').click(function(e){
		$("#saveDataModelID").modal('show');
	});
	
	$('textarea').keyup(function() {
		var len = this.value.length;
		if (len >= 500) {
		this.value = this.value.substring(0, 500);
		}
	});
});

function saveData()
{
	$('#approveRejectId').val("0");
	$('#actionID').val("save");
	$("#forwardPageId").val("success");
	$('#topErrorDiv').hide();
	$('#cashManagementFBId').find('.radio-container').removeClass('conditional-radio-tri req-error');
	$('#actionButton').removeAttr('style');
	document.forms[0].action = contextURL + '/equityBusinessCFO.do?command=submitDealRequest&action=save';
	document.forms[0].submit();
	}