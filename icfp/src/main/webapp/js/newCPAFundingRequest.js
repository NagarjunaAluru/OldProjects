
$(document).ready(function(){
	
	$('.autosize').keyup(function() {
		var len = this.value.length;
		if (len >= 500) {
		this.value = this.value.substring(0, 500);
		}
	});
	
	$('.autosize1').keyup(function() {
		var len = this.value.length;
		if (len >= 1000) {
		this.value = this.value.substring(0, 1000);
		}
	});
	
	$('.autosize2').keyup(function() {
		var len = this.value.length;
		if (len >= 2500) {
		this.value = this.value.substring(0, 2500);
		}
	});
	
	
	var cparational = document.forms[0].elements("dealRationale").value;
	
	var cparlength = cparational.length;

	cparlength = 2500-cparlength;
	$(".dealCPARationaleChar").text(cparlength);

	//$("#dealRationaleSizeID").replaceWith( ""+length );	
	
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
	  $("#priorityCommentHighID .char-count").text( priorityCommentLen );
  } 
  else if(isPriority[1].checked)
  {
	  textpriorityComment[1].value=document.forms[0].elements("priorityComment").value;
	  $("#priorityCommentHighID").hide();
	  $("#priorityCommentMediumID").show(); 
	  $("#priorityCommentLowID").hide();
	  $("#priorityCommentMediumID .char-count").text( priorityCommentLen );
  }
  else if(isPriority[2].checked)
  {
	  textpriorityComment[2].value=document.forms[0].elements("priorityComment").value;
	  $("#priorityCommentHighID").hide();
	  $("#priorityCommentMediumID").hide();
	  $("#priorityCommentLowID").show();
	  $("#priorityCommentLowID .char-count").text( priorityCommentLen );
  }
  
  $("#isImpairmentHistoryNoID").click(function(){
	  document.forms[0].elements("impairmentComment").value="";
	  var  impairmentComment =  document.forms[0].elements("impairmentComment");
	  changeInnerSize(impairmentComment);
   });
  
  $("#isFinancialStatementDateID").click(function(){
	  document.forms[0].elements("latestDtOfFinSttmnt").value="";
   });
  
  $("#isPriorityHigh").click(function(){
	  textpriorityComment[1].value="";
	  textpriorityComment[2].value="";
	  changeInnerSize(textpriorityComment[1]);
	  changeInnerSize(textpriorityComment[2]);
   });
  
  $("#isPriorityMedium").click(function(){
	  textpriorityComment[0].value="";
	  textpriorityComment[2].value="";
	  changeInnerSize(textpriorityComment[0]);
	  changeInnerSize(textpriorityComment[2]);
   });
  
  $("#isPriorityLow").click(function(){
	  textpriorityComment[0].value="";
	  textpriorityComment[1].value="";
	  changeInnerSize(textpriorityComment[0]);
	  changeInnerSize(textpriorityComment[1]);
   });
  
  $("#saveasdraftID").click(function(){
	  saveAsDraft();
   });
  
  $("#withdrawID").click(function(){
	  withDraw(); 
   });

	$("#reSubmitID").click(function(){
		reSubmit();
	});

  
  $("#createRequestID").click(function(){
	  createRequest();	
   });
  
  
   var sizevalue=document.forms[0].elements("legSize").value; 
   if(sizevalue>=1)
     $("#addLegDivID").hide();
   else
     $("#addLegDivID").show();
   
   
  });

	function saveAsDraft()
	{
		    $('input[type="submit"]').attr('disabled','disabled'); 
		    ("#saveasdraftID").val="saveAsDraft";
		    ("#saveasdraftID").disabled=true;
		    submitDraftFunction();
		    var fundingRequestForm = document.getElementById('fundingRequestForm');
			fundingRequestForm.action =  contextURL+"/fundingRequest/newCPAFundingRequest.do?command=saveAsDraft";
			fundingRequestForm.submit();
	}

	function withDraw()
	{
		    $('input[type="submit"]').attr('disabled','disabled'); 
		    ("#withdrawID").val= "withdrawRequest";
		    ("#withdrawID").disabled=true;
		    submitFunction();
		    var fundingRequestForm = document.getElementById('fundingRequestForm');
			fundingRequestForm.action =  contextURL+"/fundingRequest/newCPAFundingRequest.do?command=withdrawRequest";
			fundingRequestForm.submit();  
	}
	function reSubmit()
	{
		    $('input[type="submit"]').attr('disabled','disabled'); 
		    ("#reSubmitID").val= "reSubmitRequest";
		    ("#reSubmitID").disabled=true;
		    submitFunction();
		    document.forms[0].elements("page").value=3;
		    var fundingRequestForm = document.getElementById('fundingRequestForm');
			fundingRequestForm.action =  contextURL+"/fundingRequest/newCPAFundingRequest.do?command=reSubmitRequest";
			fundingRequestForm.submit();
	}

	function createRequest()
	{
		    validate = submitFunction();
		    if(validate==true) {
		    $('input[type="submit"]').attr('disabled','disabled'); 
		    document.forms[0].elements("page").value=3;
		    var fundingRequestForm = document.getElementById('fundingRequestForm');
			fundingRequestForm.action =  contextURL+"/fundingRequest/newCPAFundingRequest.do?command=createRequest";
			fundingRequestForm.submit();
		    } else {
		    	$(window).scrollTop(100);
				$('#validationsRequired').show();
		    	return false;
		    }  
	}
  

$(document).ready(function(){
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
		$("#priorityCommentHighID .char-count").text( priorityCommentLen );	
	} 
	else if(isPriority[1].checked)
	{
		textpriorityComment[1].value=document.forms[0].elements("priorityComment").value;
		$("#priorityCommentHighID").hide();
		$("#priorityCommentMediumID").show(); 
		$("#priorityCommentLowID").hide();
		$("#priorityCommentMediumID .char-count").text( priorityCommentLen );
	}
	else if(isPriority[2].checked)
	{
		textpriorityComment[2].value=document.forms[0].elements("priorityComment").value;
		$("#priorityCommentHighID").hide();
		$("#priorityCommentMediumID").hide();
		$("#priorityCommentLowID").show();
		$("#priorityCommentLowID .char-count").text( priorityCommentLen );
	}
});
  
