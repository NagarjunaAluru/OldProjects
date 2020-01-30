	function closeConfirmModal() {
		$("#confirm").modal('hide');
	}
	function saveAndReturnToDeal(obj, action) {

	 	var validateFlag = false;

	 	var transactionCapturedIn = $("#selectedTransactionCapturedIn").val();
	 	var inhouseloanmodelId = $("#inhouseloanmodelId").val();
	 	var vaultTextID = $("#vaultTextID").val();
	 	
	
	 	if(transactionCapturedIn == ""){
			$("#transactionCapturedInBar").show();
			validateFlag = true;
		}else {
			$("#transactionCapturedInBar").hide();
		}
	 	
	 	if( transactionCapturedIn == 1 || transactionCapturedIn == 2 ){
	 		if(inhouseloanmodelId == ""){
				$("#inhouseloanmodelIdBar").show();
				validateFlag = true;
			}else {
				$("#inhouseloanmodelIdBar").hide();
			}	
	 	}
	 	if(vaultTextID==undefined || vaultTextID==""){
	 		$("#transactionCapturedVaultdIdBar").show();
			validateFlag = true;
	 	}else{
	 		$("#transactionCapturedVaultdIdBar").hide();
	 	}
	 	 if (validateFlag == false) {
			obj.form.action = contextURL + action + '?command=saveLeg';
			obj.form.submit();
		} else {
			$(window).scrollTop(100);
			$('#validateFlag').show();
		} 
 	}

	function saveAsDraft(obj, action ) {
		obj.form.action = contextURL + action + '?command=saveLeg&Save=True';
		obj.form.submit();
	}
	function closeMessage() {
		$('#validateFlag').hide();
	}
	$(document).ready(function() {

			$('#valultReqIDLookupID').click(function() {
				
					$('#showWarning').hide();
					  var vaultID = $("#vaultTextID").val();
					  var legNumberID =  $("#legNumberID").val();
						var url= contextURL+"/transactionCapture/transactionCaptureLeg.do?command=getVaultDetailValidationFlag";
						$.post( url, {vaultIDDetails:vaultID,legNumber:legNumberID},
								function(data){
								var content = $(data).find('#vaultDivID');
								$("#vaultDivID").empty().append( content.html() );
								$("#vaultDivID").show();
						});
				   });
						
			});
