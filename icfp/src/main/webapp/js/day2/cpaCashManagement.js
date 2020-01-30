	function closeConfirmModal() {
		$("#confirm").modal('hide');
	}
	
	function closeConfirmModal() {
		$("#cancelpopup").modal('hide');
	}


	function saveAndReturnToDeal(obj, action) {

	 	 var validateFlag = false;
		var qAssessment = $('input:radio[name=qAssessment]:checked').val();
		
		if (qAssessment == undefined) {
			validateFlag = true;
			$('#qualitativeDiv').addClass("req-error");
		} else {
			$('#qualitativeDiv').removeClass("req-error");
			if (qAssessment == 1 || qAssessment == 2) {
				var rationale = $('#rationale').val();
				if (rationale == "") {
					validateFlag = true;
					$('#rationale').parent().append(
							"<span class='req-error'>error</span>'");
				}
			} else {
				$("span.req-error").remove();
			}
		}

			
			

		if (validateFlag == false) {
			document.forms[0].action = contextURL + action + '?command=saveLeg';
			document.forms[0].submit();
		} else {
			$(window).scrollTop(100);
			$('#validateFlag').show();
		} 
 	}

	function saveAsDraft(obj, action ) {
		document.forms[0].action = contextURL + action + '?command=saveLeg&Save=True';
		document.forms[0].submit();
	}
	function closeMessage() {
		$('#validateFlag').hide();
	}
