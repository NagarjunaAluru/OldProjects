$(document).ready(function(){
	
	var rational = document.forms[0].elements("dealRationale").value;
	
	var length = rational.length;

	length = 500-length;

	$("#dealRationaleSizeID").replaceWith( ""+length );	
	
	var impairmentComment = document.forms[0].elements("impairmentComment").value;
	
	var length = impairmentComment.length;

	length = 500-length;

	$("#impairmentCommentDivID").replaceWith( ""+length );	
	
	
	
	var commentsLength = document.forms[0].elements("comments").value;
	
	var cmlength = commentsLength.length;

	cmlength = 500-cmlength;

	$("#commentsID").replaceWith( ""+cmlength );	
	
	
	
	
  var impairmentHistory = document.forms[0].elements("impairmentHistoryFlag");

  if(impairmentHistory[0].checked)
  {
      $("#impairmentCommentID").show();
   }else{
	  $("#impairmentCommentID").hide(); 
  }
  
  var history = document.forms[0].elements("finSttmntDtAboveOneYrFlag");
  if(history[0].checked)
  {
      $("#lastDateofFinancialStmtDivID").show();
   }else{
	  $("#lastDateofFinancialStmtDivID").hide(); 
  }
  
  var isPriority = document.forms[0].elements("priorityId");
  var textpriorityComment = document.forms[0].elements("textpriorityComment");
  
  var priorityCommentVal = document.forms[0].elements("priorityComment").value;
  
  var priorityCommentLen = priorityCommentVal.length;
  
  priorityCommentLen = 500-priorityCommentLen;
  
  if(isPriority[0].checked)
  {
	  textpriorityComment[0].value=document.forms[0].elements("priorityComment").value;
	  $("#priorityCommentHighID").show();
	  $("#priorityCommentMediumID").hide(); 
	  $("#priorityCommentLowID").hide();
	  $("#highPriorityLabelID").replaceWith( ""+priorityCommentLen );	
  } 
  else if(isPriority[1].checked)
  {
	  textpriorityComment[1].value=document.forms[0].elements("priorityComment").value;
	  $("#priorityCommentHighID").hide();
	  $("#priorityCommentMediumID").show(); 
	  $("#priorityCommentLowID").hide();
	  $("#mediumPriorityLabelID").replaceWith( ""+priorityCommentLen );
  }
  else if(isPriority[2].checked)
  {
	  textpriorityComment[2].value=document.forms[0].elements("priorityComment").value;
	  $("#priorityCommentHighID").hide();
	  $("#priorityCommentMediumID").hide();
	  $("#priorityCommentLowID").show();
	  $("#lowPriorityLabelID").replaceWith( ""+priorityCommentLen );
  }
  
  $("#isImpairmentHistoryNoID").click(function(){
	  document.forms[0].elements("impairmentComment").value="";
   });
  
  $("#isFinancialStatementDateID").click(function(){
	  document.forms[0].elements("latestDtOfFinSttmnt").value="";
   });
  
  $("#isPriorityHigh").click(function(){
	  textpriorityComment[1].value="";
	  textpriorityComment[2].value="";
   });
  
  $("#isPriorityMedium").click(function(){
	  textpriorityComment[0].value="";
	  textpriorityComment[2].value="";
   });
  
  $("#isPriorityLow").click(function(){
	  textpriorityComment[0].value="";
	  textpriorityComment[1].value="";
	  
   });
  
  $("#saveasdraftID").click(function(){
	    $('input[type="submit"]').attr('disabled','disabled'); 
	    ("#saveasdraftID").val="saveAsDraft";
	    ("#saveasdraftID").disabled=true;
	    submitFunction();
	    var fundingRequestForm = document.getElementById('fundingRequestForm');
		fundingRequestForm.action =  contextURL+"/fundingRequest/newFundingRequest.do?command=saveAsDraft";
		fundingRequestForm.submit();
   });
  
  $("#createRequestID").click(function(){
	    $('input[type="submit"]').attr('disabled','disabled'); 
	    ("#createRequestID").val="createRequest";
	    document.forms[0].elements("page").value=3;
	    submitFunction();
	    var fundingRequestForm = document.getElementById('fundingRequestForm');
		fundingRequestForm.action =  contextURL+"/fundingRequest/newFundingRequest.do?command=createRequest";
		
		fundingRequestForm.submit();
   });
  
   $('textarea').keyup(function() {
	  var len = this.value.length;
	  if (len >= 500) {
	  this.value = this.value.substring(0, 500);
	  }
	  }); 
  
  
  });
