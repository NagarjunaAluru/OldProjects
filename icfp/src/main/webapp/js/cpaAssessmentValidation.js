function validateTPQualitativeAssesment()
{
	  
	    var high = $('input[id=qualitativeFactor1]:checked').val();
	 	var medium = $('input[id=qualitativeFactor2]:checked').val();
	 	var low = $('input[id=qualitativeFactor3]:checked').val();

	 	if(high==undefined && medium==undefined && low==undefined){
			$('#qFIdErrorDiv10').addClass("req-error");
			return true;
		}else{
			$('#qFIdErrorDiv10').removeClass("req-error");
			
			if(high=="1" || medium=="2"){
				var commentValue = $('#rationale').val();
				if(commentValue==""){
					$('#commentErrorID').show();
					return true;
				}
			}else {
				$('#commentErrorID').hide();
				return false;
			}
		}
		
		return false;
   }