	$(document).ready(function() {
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
		$('#saveLeg1').click(function() {
			document.forms[0].action = contextURL + '/transactionCapture/transactionCaptureLeg.do?command=saveLeg&Save=True';
			document.forms[0].submit();
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
