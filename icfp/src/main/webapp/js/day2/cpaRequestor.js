	$(document).ready(function() {
		var settlementOtherDetailsId = $("#settlementOtherDetailsId").val(); 
		if(settlementOtherDetailsId!=null && settlementOtherDetailsId!="" && settlementOtherDetailsId!='undefined')
		{
			var length = settlementOtherDetailsId.length;
			length = 1000-length;
			$("#otherDetailsSizeID").replaceWith( ""+length );	
		}else{
			$("#otherDetailsSizeID").replaceWith( "1000" );
		}
		
		
		
		$('.autosize1').keyup(function() {
			var len = this.value.length;
			if (len >= 1000) {
				this.value = this.value.substring(0, 1000);
			}

		});
	});

	function closing(){
		   $("#confirm").modal('hide');
		   $(".modal-backdrop").hide();
		}