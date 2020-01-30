$(document).ready(function(){
	$("#addApprover").click(function(){
		var firstName = $("#firstLastName").val();
		var ssoid = $("#ssoid").val();
		var url= contextURL+"/riskUnderwriting/riskUnderwriting.do?command=getApprover";
		$.post(url, {firstName:firstName,
			lastName:lastName,
			ssoid:ssoid},function(data){
				$("conditional-row");
			});
	});
});




		