function deleteAdditionalApprover(ssoID){ 
	var ssoId = ssoID;
	var url= contextURL+"/additionalApprovers.do?command=deleteApprover";
	 $.post(url, {ssoId:ssoId},function(data){
 	 });
}
function clearSearchResults(){ 
	$("#searchText").val("");
	$("#additionalApproverID").hide();
	$('#teamMemberIdErrorSpan').removeClass("req-error");
	$('#searchTextErrorSpan').removeClass("req-error");
}

$(document).ready(function() {
	$('#sbCommentsError1').hide();
	$('#dCommentsError1').hide();
	$('#teamMemberIdErrorSpan').removeClass("req-error");
	$('#searchTextErrorSpan').removeClass("req-error");
	/////////
	
	/////////
	$("#additionalApproverSerachID").click(function(){ 
		var searchCriteria = $("#searchCriteria option:selected").text();
		var searchText = $("#searchText").val();
		$('#teamMemberIdErrorSpan').removeClass("req-error");
		$('#searchTextErrorSpan').removeClass("req-error");
		var url= contextURL+"/additionalApprovers.do?command=search";
		$("#additionalApproverID").hide();
		$("#additionalApproverID").empty();
		 $.post(url, {searchCriteria:searchCriteria,searchText:searchText},function(data){
			var content = $(data).find('#additionalApproverID');
			$("#additionalApproverID").empty().append( content.html() );
		}); $("#additionalApproverID").show();
		 
	}); 
	 $("#saveAddApprovers").click(function(){ 
		var ssoId = '';
		var name = '';
		var checkBoxes = $("input[name=optionsRadios]");
		$.each(checkBoxes, function() {
        	if ($(this).attr('checked')){
        		ssoId += ($(this).attr("value")) + ",";
        		name += $(this).parent().next().next().text() + ",";
        	}
        });
		ssoId=ssoId.replace(/,$/,"");
		name=name.replace(/,$/,"");
        if(ssoId != null && ssoId != ''  ){
			 var url= contextURL+"/additionalApprovers.do?command=saveSelection";

			 $.post(url, {ssoId:ssoId,name:name},function(data){
				var content = $(data).find('#fillAdditionalApprovers');
				$("#fillAdditionalApprovers").empty().append( content.html() );
			}); 
		 } else {
			 $('#teamMemberIdErrorSpan').addClass("req-error");
			 return false;
		 }
		});
	
});