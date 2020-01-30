$(document).ready(function() {
	$('textarea').keyup(function() {
		var len = this.value.length;
		if (len >= 500) {
		this.value = this.value.substring(0, 500);
		}
	});

	$('#assignToTeamMember').click(function(e){
		var teamMemberId = $('#teamMemberId').val();
		var comments = $('#dealCommentsId').val();
		if(teamMemberId != ''){
			$('#assignToTeamMember').attr('data-dismiss','modal');
			$('#commentsID').val(comments);
			$('#teamMemberId').hide();
			$('#teamMemberIdErrorSpan').hide();
			document.forms[0].action = contextURL + '/frontOfficeFourBlocker.do?command=submitDealRequest';
			document.forms[0].submit();
		}else{
			$('#teamMemberIdErrorSpan').show();
			$('#teamMemberId').show();
			$('#assignToTeamMember').removeAttr('data-dismiss'); 
			//hidePopUp = true; 
			
		}
		
	});
});