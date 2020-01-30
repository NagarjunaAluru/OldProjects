	$(document).ready(function() {
		$('input[name=saveEquityLeg]:radio').click(function() {
			var actionType = $('input[name=saveEquityLeg]:radio:checked').val();
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
				$('#transactionId').parent().find('span[class=required]').show();
			}else if($('#selectedTransactionCapturedIn option:selected').text() == 'Other'){
				$('#transactionId').parent().find('span[class=required]').hide();
			}else{
				$('#transactionId').parent().find('span[class=required]').show();
			}
		});
		$('#saveLeg1').click(function() {
			document.forms[0].action = contextURL + '/transactionCapture/transactionCaptureLeg.do?command=saveLeg&Save=True';
			document.forms[0].submit();
		});
	});

	$(document).ready(function() {
		if($('#selectedTransactionCapturedIn option:selected').text() == 'Loan Model'){
			$('#transactionId').parent().find('span[class=required]').show();
		}else if($('#selectedTransactionCapturedIn option:selected').text() == 'Other'){
			$('#transactionId').parent().find('span[class=required]').hide();
		}else{
			$('#transactionId').parent().find('span[class=required]').show();
		}
	});
