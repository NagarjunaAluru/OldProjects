

	$(document).ready(function() {
		 onLoadSolvencyCalc();
		$('input[name=saveAction]:radio').click(function() {
			var actionType = $('input[name=saveAction]:radio:checked').val();
			if(actionType == 'saveNextLeg'){
				$('#saveNextLeg').show();
				$('#saveLeg').hide();
			}else{
				$('#saveLeg').show();
				$('#saveNextLeg').hide();
			}
		});
		$('#saveLeg1').click(function() {
			document.forms[0].action = contextURL + '/transactionCapture/transactionCaptureLeg.do?command=saveLeg&Save=True';
			document.forms[0].submit();
		});
		$('#selectedTransactionCapturedIn').change(function(){
			if($('#selectedTransactionCapturedIn option:selected').text() == 'Loan Model'){
				$('#facilityId').parent().find('span[class=required]').hide();
				$('#transactionId').parent().find('span[class=required]').show();
			}else if($('#selectedTransactionCapturedIn option:selected').text() == 'Other'){
				$('#facilityId').parent().find('span[class=required]').hide();
				$('#transactionId').parent().find('span[class=required]').hide();
			}else{
				$('#facilityId').parent().find('span[class=required]').show();
				$('#transactionId').parent().find('span[class=required]').show();
			}
		});

			
		$('#valultReqIDLookupID').live('click', function() {
			$('#errorMessageID').hide();
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
				

		    if($('#selectedTransactionCapturedIn option:selected').text() == 'Loan Model'){
				$('#facilityId').parent().find('span[class=required]').hide();
				$('#transactionId').parent().find('span[class=required]').show();
			}else if($('#selectedTransactionCapturedIn option:selected').text() == 'Other'){
				$('#facilityId').parent().find('span[class=required]').hide();
				$('#transactionId').parent().find('span[class=required]').hide();
			}else{
				$('#facilityId').parent().find('span[class=required]').show();
				$('#transactionId').parent().find('span[class=required]').show();
			}

	});
	
	
	
