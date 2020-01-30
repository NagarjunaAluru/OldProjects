
$(document).ready(function() {
	$('#sbCommentsError1').hide();
	$('#dCommentsError1').hide();
	$('#teamMemberIdErrorSpan').removeClass("req-error");
	$('#searchTextErrorSpan').removeClass("req-error");
	/////////
	
	/////////
	$("#businessApproverSerachID").click(function(){ 
		var searchCriteria = $("#businessSearchCriteria option:selected").text();
		var businessSearchText = $("#businessSearchText").val();
		$('#teamMemberIdErrorSpan').removeClass("req-error");
		$('#searchTextErrorSpan').removeClass("req-error");
	
		var url= contextURL+"/businessApprovers.do?command=businessSearch";
		$("#businessApproverID").hide();
		$("#businessApproverID").empty();
    	 $.post(url, {searchCriteria:searchCriteria,searchText:businessSearchText},function(data){
			var content = $(data).find('#businessApproverID');
			
			$("#businessApproverID").empty().append( content.html() );
		}); $("#businessApproverID").show();
		 
	}); 
	 
	 $("#saveBusinessApprovers").click(function(){ 
	 	checked = $('#addBusinessApprover tbody :checked');
		    ssoId = checked.val();
		    businessUnit = checked.parent().next().text();
			name = checked.parent().next().next().text();
		 if(businessUnit != null && businessUnit != ''  ){
			 var url= contextURL+"/businessApprovers.do?command=saveSelection";

			 $.post(url, {ssoId:ssoId,name:name,businessUnit:businessUnit},function(data){
				var content = $(data).find('#fillBusinessApprovers');
				$("#fillBusinessApprovers").empty().append(content.html());
			}); 
		 } else {
			 $('#teamMemberIdErrorSpan').addClass("req-error");
			 return false;
		 }
		});
	 //$('#saveApprovers').live('click', saveApprovers);
	
});


function deleteApprover(ssoId , group){ 
	var sso_Id = ssoId;
	var businessUnit = group;
	var url= contextURL+"/businessApprovers.do?command=deleteApprover";
	 $.post(url, {ssoId:sso_Id,businessUnit:businessUnit},function(data){
 	 });
}
function clearBusinessSearchResults(){ 
	$("#businessSearchText").val("");
	$("#businessApproverID").hide();
	$('#teamMemberIdErrorSpan').removeClass("req-error");
	$('#searchTextErrorSpan').removeClass("req-error");

}
