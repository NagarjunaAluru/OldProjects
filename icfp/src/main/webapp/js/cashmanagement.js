


$(document).ready(function() {
	$('#sbCommentsError1').hide();
	$('#dCommentsError1').hide();
	$('#submit').click(function(e){
		$("#forwardPageId").val("submitSuccess");
		$('#sendBackComments').val("");
		$('#sbCommentsError1').hide();
		$('#teamMemberId').show();
		var comments = $('#dealCommentsId').val();
		var action = $('input:radio[name=submitDealFB]:checked').val();
		if(action == undefined){
			$('#topErrorDiv').show();
			$('#cashManagementFBId').find('.radio-container').addClass('conditional-radio-tri req-error');
			$('#actionButton').attr('style','margin-top: 75px;');
		}else if(action == 'affirm'){
			 $("#inputsCompletedModalID").modal('show');
		}else if (action === 'sendBack'){
			$("#sendback").modal('show');
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
			document.forms[0].action = contextURL + '/cashManagement/cashManagement.do?command=submitDealRequest&action=sendBack';
			document.forms[0].submit();
		}else{
			$('#sbCommentsError1').show();
			$('#sendBack').removeAttr('data-dismiss');
		}
	});
	
	$('#assignToTeamMember').click(function(e){
			var comments = $('#dealCommentsId').val();
			var teamMemberId = $('#teamMemberId').val();
			if(teamMemberId != ''){
				$('#approveRejectId').val("7");
				$('#actionID').val("assignReview");
				$('#assignToTeamMember').attr('data-dismiss','modal');
				$('#teamMemberId').hide();
				$('#commentsID').val(comments);
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

  
  function inputsCompleted()
  {
	    var comments = $('#dealCommentsId').val();
		var action = $('input:radio[name=submitDealFB]:checked').val();
	    $('#approveRejectId').val("0");
		$('#actionID').val(action);
		$('#topErrorDiv').hide();
		$('#commentsID').val(comments);
		$('#cashManagementFBId').find('.radio-container').removeClass('conditional-radio-tri req-error');
		$('#actionButton').removeAttr('style');
		document.forms[0].action = contextURL + '/cashManagement/cashManagement.do?command=submitDealRequest&action='+action;
		document.forms[0].submit();
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
		document.forms[0].action = contextURL + '/cashManagement/cashManagement.do?command=submitDealRequest&action=save';
		document.forms[0].submit();
  }

function assignMember(){
	var teamMemberId = $('#teamMemberId').val();
	document.forms[0].action = contextURL + '/cashManagement/cashManagement.do?command=submitDealRequest&action=assignReview&teamMemberId='+teamMemberId;
	document.forms[0].submit();
}