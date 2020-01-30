$(document).ready(function() {
	$('#sbCommentsError1').hide();
	$("table").on("click", "a.reassign", function(){		 
		var roleId = $(this).parents("tr").find("#cafeId").val();
		var roleDisplay = $(this).parents("tr").find("td:nth-child(3)").html();
		url = contextURL +'/admin/admin.do?command=getTeamMembers&roleId='+roleId;
		$.post( url, {roleId:roleId},
			function(data){
				var content = $(data).find('#assignReviewerpopup');
				$("#assignReviewerpopup").empty().append( content.html() );
				$('#assignReviewerpopup .roleDisplay').each( function(){
					$(this).html(roleDisplay);
				});
				$('#assignReviewerpopup').data("roleid", roleId);
				$('#assignReviewerpopup').modal('show');
		});
	});
	$("table").on("click", "a.remove", function(){		 
		var roleId = $(this).parents("tr").find("#cafeId").val();
		var name = $(this).parents("tr").find("td:first").html();
		
		$('#removeReviewerpopup').data("roleid", roleId);
		
		$('#removeReviewerpopup .name').each( function(){
			$(this).html(name);
		});
		$('#removeReviewerpopup').modal('show');
	});
		
	$('#assignToTeamMember').live("click", function(e){
		var roleId= $('#assignReviewerpopup').data("roleid");
		var teamMemberId = $('#teamMemberId').val();
		if(teamMemberId != ''){
			$('#approveRejectId').val("7");
			$('#actionID').val("assignReview");
			$('#assignToTeamMember').attr('data-dismiss','modal');
			$('#teamMemberId').hide();
			$('#teamMemberIdErrorSpan').hide();
			document.forms[0].action = contextURL + '/admin/admin.do?command=reassignApprover&action=assignReview&teamMemberId='+teamMemberId+'&roleId='+roleId;
			document.forms[0].submit();
		}else{
			$('#teamMemberIdErrorSpan').show();
			$('#teamMemberId').show();
			$('#assignToTeamMember').removeAttr('data-dismiss'); 
		}
	});
	
	$('#removeTeamMember').live("click",function(e){
		var comments = $('#revokeComments').val();
		if(comments != ''){
			$('#actionID').val("revoke");
			$('#removeTeamMember').attr('data-dismiss','modal');
			$('#sbCommentsError1').hide();
			$('#actionCommentsID').val(comments);
			var roleId= $('#removeReviewerpopup').data("roleid");
			document.forms[0].action = contextURL + '/admin/admin.do?command=revokeTeamMembers&roleId='+roleId;
			document.forms[0].submit();
		}else{
			$('#sbCommentsError1').show();
			$('#removeTeamMember').removeAttr('data-dismiss');
		}
	});
	});