
   var checkCertify = 0;
	$(document).ready(function() {
		$('#changeTypeCommentsError').hide();
		$('div.closing-checklist input:radio:checked').each(function() {
			if(this.value == 1 || this.value == 3){
				checkCertify++;
			}else if(this.value == 2){
				checkCertify--;
			}
		});
		$('input:radio[value=certify]').attr("disabled", "disabled");
		$('input:radio[value=sendBack]').attr("disabled", "disabled");
		$('input:radio[value=override]').attr("disabled", "disabled");
		
		
	
		
			if($('input:radio[name=changeAfterApprovalFlag]:checked').val() == 1){
				$('.material-immaterial').show();
				$('.material-comments').show();
				if($('input:radio[name=changeTypeId]:checked').val() == 1){
					$('.closing-checklist').hide();
				}else if($('input:radio[name=changeTypeId]:checked').val() == 2){
					$('.closing-checklist').show();
				}
			}else if($('input:radio[name=changeAfterApprovalFlag]:checked').val() == 0){
				$('.material-immaterial').hide();
				$('.closing-checklist').show();
				$('.material-comments').hide();
			}
			
			if($('input:radio[name=changeAfterApprovalFlag]:checked').val() == 0){
				$('input:radio[value=sendBack]').removeAttr("disabled");
				$('input:radio[value=override]').removeAttr("disabled");
				if(checkCertify == 31){
					$('input:radio[value=certify]').removeAttr("disabled");
				}
			}else{
				if($('input:radio[name=changeTypeId]:checked').val() == 2){
					$('input:radio[value=sendBack]').attr("disabled", "disabled");
					$('input:radio[value=override]').removeAttr("disabled");
					if(checkCertify == 31){
						$('input:radio[value=certify]').removeAttr("disabled");
					}
					$('.closing-checklist, .material-condition').show();
				}else{
					$('input:radio[value=certify]').attr("disabled", "disabled");
					$('input:radio[value=override]').attr("disabled", "disabled");
				}
				if (!$.trim($('textarea[name=changeTypeComments]').val())) {
					$('input:radio[value=sendBack]').attr("disabled", "disabled");
				}else{
					$('input:radio[value=sendBack]').removeAttr("disabled");
				}
			}
		
	});
	function checkCheckList() {
		checkCertify++;
		if(checkCertify == 31){
			$('input:radio[value=certify]').removeAttr("disabled");
		}
	}
	function unCheckCheckList() {
		checkCertify--;
		if(checkCertify < 31){
			$('input:radio[value=certify]').attr("disabled", "disabled");
		}
	}
	function showComments(id) {
		var val = '#comment'+id;
		$(val).show();
	}
	function hideComments(id) {
		var val = '#comment'+id;
		$(val).hide();
	}
	
	function submitFormAtViewLeg(legNumber, productType) {
		var form = document.forms[0];
		var oldPath = form.action;
		var path = oldPath;
		path = path + "?command=viewInputScreens&source=transactionCapture/transactionCaptureFOCMFourBlocker&id=" + legNumber + "&pType=" + productType;
		form.action = path;
		form.submit();
	}
