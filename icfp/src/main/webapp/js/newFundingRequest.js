$(document).ready(function(){
	
	$("#productType").change( function(e){
		e.preventDefault();
		
		var productType = $("#productType").val();
		if(productType!=""){
		
			url = contextURL +"/fundingRequest/newFundingRequest.do?command=getEventDetails";
			$.post( url, {productType:productType},
					function(data){
					var content = $(data).find('#eventTypesDiv');
					
					$("#eventTypesDiv").empty().append( content.html() );
			});
		}
	});	
	
	/* Start - for CPA Day2 Operations - onLoad of the Page */
	
	var productType = $("#productType").val();
	if(productType!=""){
	
		url = contextURL +"/fundingRequest/newFundingRequest.do?command=getEventDetails";
		$.post( url, {productType:productType},
				function(data){
				var content = $(data).find('#eventTypesDiv');
				
				$("#eventTypesDiv").empty().append( content.html() );
		});
	}
	/* End - for CPA Day2 Operations */
});
		


function submitFunction()
		{
	
			var validate = true;
			var history = document.forms[0].elements("impairmentHistoryFlag");
			  if(history[1].checked)
			  {
				  document.forms[0].elements("impairmentComment").value="";
			  }
			  
			  var finStmtFlag = document.forms[0].elements("finSttmntDtAboveOneYrFlag");
			  if(finStmtFlag[1].checked)
			  {
				  document.forms[0].elements("latestDtOfFinSttmnt").value="";
			  }
			  
			  var isPriority = document.forms[0].elements("priorityId");
			  var textpriorityComment = document.forms[0].elements("textpriorityComment");
			  if(isPriority[0].checked)
			  {
				  document.forms[0].elements("priorityComment").value=textpriorityComment[0].value;
			  } 
			  else if(isPriority[1].checked)
			  {
				  document.forms[0].elements("priorityComment").value=textpriorityComment[1].value;
			  }
			  else if(isPriority[2].checked)
			  {
				  document.forms[0].elements("priorityComment").value=textpriorityComment[2].value;
			  }
			  textpriorityComment[0].value="";
			  textpriorityComment[1].value="";
			  textpriorityComment[2].value="";
			 // alert("its in submit function"+validate)
			 return validate;
		}
		
function submitDraftFunction()
{
	var history = document.forms[0].elements("impairmentHistoryFlag");
	  if(history[1].checked)
	  {
		  document.forms[0].elements("impairmentComment").value="";
	  }
	  
	  var finStmtFlag = document.forms[0].elements("finSttmntDtAboveOneYrFlag");
	  if(finStmtFlag[1].checked)
	  {
		  document.forms[0].elements("latestDtOfFinSttmnt").value="";
	  }
	  
	  var isPriority = document.forms[0].elements("priorityId");
	  var textpriorityComment = document.forms[0].elements("textpriorityComment");
	  if(isPriority[0].checked)
	  {
		  document.forms[0].elements("priorityComment").value=textpriorityComment[0].value;
	  } 
	  else if(isPriority[1].checked)
	  {
		  document.forms[0].elements("priorityComment").value=textpriorityComment[1].value;
	  }
	  else if(isPriority[2].checked)
	  {
		  document.forms[0].elements("priorityComment").value=textpriorityComment[2].value;
	  }
	  
	  textpriorityComment[0].value="";
	  textpriorityComment[1].value="";
	  textpriorityComment[2].value="";
	  
}

		/**
		 * Remove the Leg
		 * @param id
		 */
		function removeLeg(id,legSeqId){
			$('#dealLeg'+id+'').remove();
		
		    document.getElementById('legNumber').value = id;
			var fundingRequestForm = document.getElementById('fundingRequestForm');
			fundingRequestForm.action =  contextURL+"/fundingRequest/newFundingRequest.do?command=deleteLeg&legNumber="+id+"&legSeqId="+legSeqId;
			fundingRequestForm.submit();
		}
		
		 /**
         * Forward to Modify Leg Screen
         */
		function modifyLeg(id){
			//var legId = $(id).parent().next().next().html();
			
			document.getElementById('legNumber').value = id;
			updatePriorityComment();
			var fundingRequestForm = document.getElementById('fundingRequestForm');
			fundingRequestForm.action =  contextURL+"/fundingRequest/newFundingRequest.do?command=modifyLeg&modify=true&id="+id+"";
			fundingRequestForm.submit();
		}
		
		/**
		 * Remove the CPA Leg
		 * @param id
		 */
		function removeCPALeg(id){
			var legId = 1;
			
		    document.getElementById('legNumber').value = legId;
			var fundingRequestForm = document.getElementById('fundingRequestForm');
			fundingRequestForm.action =  contextURL+"/fundingRequest/newFundingRequest.do?command=deleteLeg&productType=CPA&id=1";
			fundingRequestForm.submit();
			
		}
		
		/**
		 * Modify CPA Leg
		 * @param id
		 */
		function modifyCPALeg(id){
			var legId = 1;
			document.getElementById('legNumber').value = legId;
			var fundingRequestForm = document.getElementById('fundingRequestForm');
			fundingRequestForm.action =  contextURL+"/CPALegRequest.do?command=openLeg&modify=true&productType=CPA&id=1";
			
			fundingRequestForm.submit();
			
		}

		 /**
		  *  This function will show the total length of give Text area within the text area.
		  */
        function changeInnerSize(Object)
		{
			var maxchar1 = 500;
			var cnt1 = $(Object).val().length;
			var remainingchar1 = maxchar1 - cnt1;
			var counter1 = $(Object).prev()
			counter1.html(remainingchar1);
			  
		}
        
        /**
         * Forward to Add Leg Screen
         */
        function addLeg(){
        	
        	var productType = $('#productType').val();
        	updatePriorityComment();
        		if(productType == ""){
        			$("#productTypefailedBar").show();
	        	}else {
	        		$('input[id="addLegButtonID"]').attr('disabled','disabled');
	        		$("#productTypefailedBar").hide();
	        		var fundingRequestForm = document.getElementById('fundingRequestForm');
	    			fundingRequestForm.action =  contextURL+"/fundingRequest/newFundingRequest.do?command=addLeg";
	    			fundingRequestForm.submit();
	        	}
        }
        
        function updatePriorityComment()
        {
        	var isPriority = document.forms[0].elements("priorityId");
			  var textpriorityComment = document.forms[0].elements("textpriorityComment");
			 
			  if(isPriority[0].checked)
			  {
				
				  document.forms[0].elements("priorityComment").value=textpriorityComment[0].value;
			  } 
			  else if(isPriority[1].checked)
			  {
				
				  document.forms[0].elements("priorityComment").value=textpriorityComment[1].value;
			  }
			  else if(isPriority[2].checked)
			  {
				 
				  document.forms[0].elements("priorityComment").value=textpriorityComment[2].value;
			  }
			  
			  textpriorityComment[0].value="";
			  textpriorityComment[1].value="";
			  textpriorityComment[2].value="";
        }
		
	