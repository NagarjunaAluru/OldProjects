

$(document).ready(function() {
	$('#sbCommentsError1').hide();
	$('#dCommentsError1').hide();
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
			document.updateStatusForm.action = contextURL + '/countryTax/countryTax.do?command=submitDealRequest';
			document.updateStatusForm.submit();
			
		}else{
			$('#topErrorDiv').hide();
			$('#dCommentsError1').hide();
			$('#cashManagementFBId').find('.radio-container').removeClass('conditional-radio-tri req-error');
			$('#actionButton').removeAttr('style');
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
			document.forms[0].action = contextURL + '/countryTax/countryTax.do?command=submitDealRequest&action=sendBack';
			document.forms[0].submit();
		}else{
			$('#sbCommentsError1').show();
			$('#sendBack').removeAttr('data-dismiss');
		}
	});
	
	$('#assignToTeamMember').click(function(e){
			var teamMemberId = $('#teamMemberId').val();
			if(teamMemberId != ''){
				$('#approveRejectId').val("7");
				$('#actionID').val("assignReview");
				$('#assignToTeamMember').attr('data-dismiss','modal');
				$('#teamMemberId').hide();
				$('#teamMemberIdErrorSpan').hide();
				document.forms[0].action = contextURL + '/countryTax/countryTax.do?command=submitDealRequest&teamMemberId='+teamMemberId;
				document.forms[0].submit();
			}else{
				$('#teamMemberIdErrorSpan').show();
				$('#teamMemberId').show();
				$('#assignToTeamMember').removeAttr('data-dismiss'); 
			}
		});
	  
	
	$('#saveAction').click(function(e){
		var comments = $('#dealCommentsId').val();
		$('#commentsID').val(comments);
		$('#approveRejectId').val("0");
		$('#actionID').val("save");
		$("#forwardPageId").val("success");
		$('#topErrorDiv').hide();
		$('#cashManagementFBId').find('.radio-container').removeClass('conditional-radio-tri req-error');
		$('#actionButton').removeAttr('style');
		document.forms[0].action = contextURL + '/countryTax/countryTax.do?command=submitDealRequest';
		document.forms[0].submit();
	});
	
	$('textarea').keyup(function() {
		var len = this.value.length;
		if (len >= 500) {
		this.value = this.value.substring(0, 500);
		}
	});
});