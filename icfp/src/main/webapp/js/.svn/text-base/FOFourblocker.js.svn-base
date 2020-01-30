		
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
	
	
	 $("#productType").change( function(e){
	        e.preventDefault();
	       
	        var productType = $("#productType").val();
	       
	            url = contextURL +"/frontoffice/fourBlocker.do?command=getEventDetails";
	            $.post( url, {productType:productType},
	                    function(data){
	                    var content = $(data).find('#eventTypesDiv');
	                   
	                    $("#eventTypesDiv").empty().append( content.html() );
	            });
	    });       
	   
	
		var rational = document.forms[0].elements("fourBlocker.projectSummary.dealRationale").value;
		var rlength = rational.length;
		rlength = 2500-rlength;
		$(".dealRationaleChar").text(rlength);
		
		
		var impairmentComment = document.forms[0].elements("fourBlocker.tSummaryOwner.impairmentComments").value;
		var length = impairmentComment.length;
		length = 500-length;
		$("#impairmentCommentDivID").replaceWith( ""+length );	
		var commentsLength = "";
		var cmlength = commentsLength.length;
		cmlength = 500-cmlength;
		//$("#commentsID").replaceWith( ""+cmlength );	
		
	  
	  var impairmentHistory = document.forms[0].elements("fourBlocker.tSummaryOwner.impairmentHistory");
	  if(impairmentHistory[0].checked)
	  {
	      $("#impairmentCommentID").show();
	   }else{
		  $("#impairmentCommentID").hide(); 
	  }
	  var history = document.forms[0].elements("fourBlocker.tSummaryOwner.financialStatementFlag");
	  if(history[0].checked)
	  {
	      $("#lastDateofFinancialStmtDivID").show();
	   }else{
		  $("#lastDateofFinancialStmtDivID").hide(); 
	  }
	  populatePriorityData();

	  $("#impairmentHistoryNoId").click(function(){
          document.forms[0].elements("impairmentCommentID").value="";
          var  impairmentComment =  document.forms[0].elements("impairmentCommentID");
          changeInnerSize(impairmentComment);
	   });
	  
	  $("#isFinancialStatementDateID").click(function(){
		  document.forms[0].elements("fourBlocker.tSummaryOwner.latestDateOfFinancialStatement").value="";
	   });
	  
	  var textpriorityComment = document.forms[0].elements("textpriorityComment");
	  $("#isPriority").click(function(){
		  textpriorityComment[1].value="";
		  textpriorityComment[2].value="";
		
		  changeInnerSize(textpriorityComment[1]);
		  changeInnerSize(textpriorityComment[2]);
	   });
	  
	  $("#isPriority").click(function(){
		  textpriorityComment[0].value="";
		  textpriorityComment[2].value="";
		  changeInnerSize(textpriorityComment[0]);
		  changeInnerSize(textpriorityComment[2]);
	   });
	  
	  $("#isPriority").click(function(){
		  textpriorityComment[0].value="";
		  textpriorityComment[1].value="";
		  
		  changeInnerSize(textpriorityComment[0]);
		  changeInnerSize(textpriorityComment[1]);
		  
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
	   
	   
	   $('#spotRates').click(function() {
	  		
			var url = contextURL+"/frontoffice/fourBlocker.do?command=refreshSpotRates";
			$.post(url,function(data) {
				var content = $( data ).find( '#transactionLegsTable' );
				var content1 = $( data ).find( '.last-updated' );
				$('#transactionLegsTable').empty().append( content.html());
				$('.last-updated').empty().append( content1.html() );
			});
		});
	   
	   //disable and unable the affirm radio button
	   var foAffirmFlagId = $('#foAffirmFlagId').val();
	   if(foAffirmFlagId == 'No'){
		   $('#affirmRadioId').attr("disabled", "disabled");
	   }else{
		   $('#affirmRadioId').removeAttr("disabled");
	   }
	   
	   
	   
	   
	   
   
  });
 
 

 
 /**
	 * added for updateActions like affirm,save,reject 
	 */
	$(document).ready(function() {
		

		 				
		$('#sbCommentsError1').hide();
		$('#dCommentsError1').hide();
		$('#rejectCommentsErrorBar').hide();
		$('#submit').click(function(e){
			var action =$('input[name=submitDealFB]:radio:checked').val();
			var flag = validateRCAFrontOffice();
			$("#forwardPageId").val("submitSuccess");
			$('#sendbackComments').val("");
			$('#sbCommentsError1').hide();
			$('#rejectRequestComments').val("");
			$('#rejectCommentsErrorBar').hide();
			$('#teamMemberId').show();
			if(action == undefined){
				$('#topErrorDiv').show();
				$('#actionsId').find('.radio-container').addClass('conditional-radio-tri req-error');
				$('#actionButton').attr('style','margin-top: 100px;');
			}else if(action == 'affirm' &&  flag =="true"){
				 $("#inputsCompletedModalID").modal('show');
			}else if(action == 'reject' &&  flag =="true"){
				$("#rejectRequestF").modal('show');
	
			}else if (action === 'sendBack'){
				$("#sendback").modal('show');
			}else{
				$(window).scrollTop(100);
				$('#validationsRequired').show();
			}
		});
		$('#sendBack').click(function(e){
			var comments = $('#sendbackComments').val();
			$("#forwardPageId").val("submitSuccess");
				if(comments != ''){
					$('#approveRejectId').val("2");
					$('#actionID').val("sendBack");
					$('#sendBack').attr('data-dismiss','modal');
					$('#sbCommentsError1').hide();
					$('#actionCommentsID').val(comments);
					priorityComment();
					financialStmt();
					document.forms[0].action = contextURL + '/frontoffice/fourBlocker.do?command=submitDeal';
					document.forms[0].submit();
				}else{
					$('#sbCommentsError1').show();
					$('#sendBack').removeAttr('data-dismiss');
				}
		});
		
		$('#reject').click(function(e){
			var comments = $('#rejectRequestComments').val();
			if(comments != ''){
				$('#approveRejectId').val("1");
				$('#actionID').val("reject");
				$('#reject').attr('data-dismiss','modal');
				$('#rejectCommentsErrorBar').hide();
				$('#topErrorDiv').hide(); 
				$('#actionsId').find('.radio-container').removeClass('conditional-radio-tri req-error');
				$('#actionButton').removeAttr('style');
				$('#actionCommentsID').val(comments);
				priorityComment();
				financialStmt();
				document.forms[0].action = contextURL + '/frontoffice/fourBlocker.do?command=submitDeal';
				document.forms[0].submit();
				
			}else{
				$('#rejectCommentsErrorBar').show();
				$('#reject').removeAttr('data-dismiss');
			}
		});
		
		
		
		
		
		
		$('#assignToTeamMember').click(function(e){
			var teamMemberId = $('#teamMemberId').val();
			var comments = $('#dealCommentsId').val();
			if(teamMemberId != ''){
				$('#approveRejectId').val("7");
				$('#actionID').val("assignReview");
				$('#commentsID').val(comments);
				$('#assignToTeamMember').attr('data-dismiss','modal');
				$('#teamMemberId').hide();
				$('#teamMemberIdErrorSpan').hide();
				var teamMemberId = $('#teamMemberId').val();
				$("#teamMember").empty().append("<b>"+teamMemberId+"</b>");
				var lastfirstnames = $("#teamMemberId option:selected").text();
				$("#lastfirstnames").empty().append("<b>"+lastfirstnames+"</b>");
				$('#assignReviewerpopup').modal('show');
			}else{
				$('#teamMemberIdErrorSpan').show();
				$('#teamMemberId').show();
				$('#assignToTeamMember').removeAttr('data-dismiss'); 
			}
		});
		$('#saveAction').click(function(e){
			 $("#saveDataModelID").modal('show');
		});
		
		
	});
	
	function inputsCompleted()
	{
		var action =$('input[name=submitDealFB]:radio:checked').val();
		$('#approveRejectId').val("0");
		$('#actionID').val(action);
		$('#topErrorDiv').hide();
		$('#actionsId').find('.radio-container').removeClass('conditional-radio-tri req-error');
		$('#actionButton').removeAttr('style');
		priorityComment();
		financialStmt();
		document.forms[0].action = contextURL + '/frontoffice/fourBlocker.do?command=submitDeal';
		document.forms[0].submit();
	}
	
	function saveData()
	{
		$('#approveRejectId').val("0");
		$('#actionID').val("save");
		$("#forwardPageId").val("success");
		$('#topErrorDiv').hide();
		$('#actionsId').find('.radio-container').removeClass('conditional-radio-tri req-error');
		$('#actionButton').removeAttr('style');
		priorityComment();
		financialStmt();
		
		document.forms[0].action = contextURL + '/frontoffice/fourBlocker.do?command=submitDeal&action=save';
		document.forms[0].submit();
	}
		
	/**
	 * Remove the Leg
	 * @param id
	 */
	function removeLeg(id,legSeqId){
		$('#dealLeg'+id+'').remove();
	    document.getElementById('legNumber').value = id;
		var fundingRequestForm = document.getElementById('fundingRequestForm');
		fundingRequestForm.action =  contextURL+"/frontoffice/fourBlocker.do?command=deleteLeg&legNumber="+id+"&legSeqId="+legSeqId;
		fundingRequestForm.submit();
	}
	
	function modifyLeg(id,productType){
		
		//var legId = $(id).parent().next().next().html();
		
		document.getElementById('legNumber').value = id;
		var fundingRequestForm = document.getElementById('fundingRequestForm');
		fundingRequestForm.action =  contextURL+"/frontoffice/fourBlocker.do?command=openLeg&source=frontoffice/fourBlocker&modify=true&id="+id+"&pType="+productType+"";
		
		fundingRequestForm.submit();
	}
	function removeCPALeg(id){
		var legId = 1;
	    document.getElementById('legNumber').value = legId;
		var fundingRequestForm = document.getElementById('fundingRequestForm');
		fundingRequestForm.action =  contextURL+"/fundingRequest/newFundingRequest.do?command=deleteLeg&productType=CPA";
		fundingRequestForm.submit();
	}
	function modifyCPALeg(id){
		var legId = 1;
		document.getElementById('legNumber').value = legId;
		var fundingRequestForm = document.getElementById('fundingRequestForm');
		fundingRequestForm.action =  contextURL+"/frontoffice/CPALegRequest.do?command=openLeg&source=frontoffice/CPALegRequest&modify=true&id="+legId+"&productType=CPA&isFrontOffice=Yes&pType=CPA";
		fundingRequestForm.submit();
	}	
	
	//only numbers
	function onlyNumbers(inputVal){
	    var numericReg = /^\d*[0-9](|.\d*[0-9]|,\d*[0-9])?$/;
	    if(!numericReg.test(inputVal)) {
			messageSpan.hide();
			errorBarSpan.hide();
			return true;
	    } 
		messageSpan.show();
		errorBarSpan.show();
		return false;
	}
	function checkDecimalRange(inputVal,messageSpan,errorBarSpan,max){
		var characterReg = /^-?(?:\d*|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/;
		var input = inputVal.val();
		if(input == '' || input==null || input==undefined){
			messageSpan.show();
			errorBarSpan.show();
			return false;
		}else {
			if(!characterReg.test(input)) {
				messageSpan.show();
				errorBarSpan.show();
				return false;
		    } 
			if(input >= max){
				messageSpan.show();
				errorBarSpan.show();
				return false;		
			}
		}	
		messageSpan.hide();
		errorBarSpan.hide();
		return true;

	}
	//should be numeric and not null
	function validateAmount(id,messageSpan,errorBarSpan){
		var amount = id.val();
		if(amount == '' || amount==null || amount==undefined){
			messageSpan.show();
			errorBarSpan.show();
			return false;
		}else {
			messageSpan.hide();
			errorBarSpan.hide();
			return true;
		}
	}
	//validation for Radio buttons
	function radioMandatory(id,messageSpan,errorDiv){
		var radioValue =  id.val();
		if(!(radioValue == "0" || radioValue == "1" || radioValue == "2" || radioValue == "3" || radioValue == "Yes" || radioValue == "No" )){
			messageSpan.show();
			errorDiv.addClass("radio-container req-error");
			return false;
		}else {
			messageSpan.hide();
			errorDiv.removeClass("radio-container req-error");
			return true;
		}
	}
	//valueRequired
	function valueRequired(id,messageSpan,errorBarSpan){
		var required = id.val();
		if(required == '' || required==null || required==undefined){
			messageSpan.show();
			errorBarSpan.show();
			return false;
		}else {
			messageSpan.hide();
			errorBarSpan.hide();
			return true;
		}
	}
	//select a combovalue
	function selectCombo(id,errorBarSpan,messageSpan){
		var option = id.val();
		if(option=='0' || option == '' || option==null || option==undefined ){
			//messageSpan.show();
			errorBarSpan.show();
			return false;
		}else {
			//messageSpan.hide();
			errorBarSpan.hide();
			return true;
		}
	}
	
	function validateRCAFrontOffice(){
		
		var iscpa = document.forms[0].elements("isCPA").value;
		var flag = "true";
		if(!selectCombo($("#dealName"),$("#dealNameErrorSpan"))){
			flag = "false";
		}
		if(!selectCombo($("#dealCategoryId"),$("#dealCategoryIdErrorSpan"))){
			flag = "false";
		}
		if(!selectCombo($("#dealRationaleId"),$("#dealRationaleIdErrorSpan"))){
			flag = "false";
		}
		if(!iscpa){
			
		if(!radioMandatory($('input[id=securityTypeId]:checked'),$('#securityTypeIdErrorSpan'),$('#securityTypeIdErrorDiv'))){
			flag = "false";
		}	
		/* we wont have this id and its sourcestopper if(!radioMandatory($('input[id=crossBorderId]:checked'),$('#crossBorderIdErrorSpan'),$('#crossBorderIdErrorDiv'))){
			flag = "false";
		}	*/		
		if(!radioMandatory($('input[id=impairmentHistoryId]:checked'),$('#impairmentHistoryIdErrorSpan'),$('#impairmentHistoryIdErrorDiv'))){
			flag = "false";
		}
		}
		if(!radioMandatory($('input[id=isFinancialStatementDateID]:checked'),$('#financialStatementIdErrorSpan'),$('#financialStatementIdErrorDiv'))){
			flag = "false";
		}
		/*if(!radioMandatory($('input[id=isPriority]:checked'),$('#priorityIdErrorSpan'),$('#priorityIdErrorDiv'))){
			flag = "false";
		}*/
		
		if(($('input[id=isPriority]:checked').val()!="1") && ($('input[id=isPriority]:checked').val()!="2") && ($('input[id=isPriority]:checked').val()!="3")){
			$('#priorityIdErrorSpan').show();
			$('#priorityIdErrorDiv').addClass("radio-container req-error");
		    flag = "false";
		}
		if(($('input[id=isPriority]:checked').val()=="1") && $("#firstCommentID").val() == "")
		{
			$('#firstspamCommentID').show();
			flag = "false";
		}else{
			$('#firstspamCommentID').hide();
		}
		
		if(($('input[id=isPriority]:checked').val()=="2") && $("#secondCommentID").val() == "")
		{
			$('#secondspamCommentID').show();
			flag = "false";
		}else{
			$('#secondspamCommentID').hide();
		}
		
	/*	if(($('input[id=isPriority]:checked').val()=="3") && $("#thirdCommentID").val() == "")
		{
			
			$('#thirdspamCommentID').show();
			flag = "false";
		}else{
			$('#thirdspamCommentID').hide();
		} */
		
		
		
		if(!selectCombo($("#regionResponsibilityId"),$("#regionResponsibilityIdErrorSpan"))){
			flag = "false";
		}
		
		if(!selectCombo($("#regionResponsibilityId"),$("#regionResponsibilityIdErrorSpan"))){
			flag = "false";
		}
		if(!selectCombo($("#valueDtId"),$("#valueDtIdErrorSpan"))){
			flag = "false";
		}		
		return flag;
	}
	
	function getApprovers(){
		var dealSeqId = $("#dealSeqId").val();
		var url= contextURL+"/frontoffice/fourBlocker.do?command=getReaffirmApprovers";
		$("a.initiate").button('loading');
		$.post(url, {dealSeqId:dealSeqId},function(data){
			
			if( $(data).find("table > tbody > tr").length > 0){
				$("#reaffirmApproversId").modal("show");
				$("#reaffirmApproversId > .modal-body").empty().append( data );
			}
			
			$("a.initiate").button('reset');
		});

	}
	/**
	 * For InitiateSSO affirm
	 */
	function submitReaffirm(){
		var flagValidation = false;
		if( $("#reaffirmApproversId input:checkbox:checked").length < 1){
			$("#reaffirmApproversId > .modal-body > .alert").show()
			flagValidation = true;
		}
		if(!valueRequired($('#reaffirmCommentsID'),$('#reaffromErrorMess'),$('#reaffirmCommentsRedStrip'))){
			flagValidation = true;
		}
		if(flagValidation == true){
			return;
		}
		$("#forwardPageId").val("submitSuccess");
		$('#approveRejectId').val("3");
		$('#actionID').val("reAffrim");
		$('#reaffirmationId').attr('data-dismiss','modal');
		$('#sbCommentsError1').hide();
		document.forms[0].action = contextURL + '/frontoffice/fourBlocker.do?command=submitDeal';
		document.forms[0].submit();
	}

	/**
	 *This function will show the total length of give Text area within the text area. 
	 * @param Object
	 */
    function changeInnerSize(Object)
	{
		var maxchar1 = 500;
		var cnt1 = $(Object).val().length;
		var remainingchar1 = maxchar1 - cnt1;
		var counter1 = $(Object).prev()
		counter1.html(remainingchar1);
		  
	}
     /* When select all is clicked, ensure checked state of all items equals the select all state */
    function selectAllClicked() {
         $("#select-checkbox input[type='checkbox']").attr("checked", $("#select-all-checkbox").is(":checked"));
    }
    /* When an item checkbox is clicked, ensure the select all checkbox is ticked only if all items are ticked */
    function individualClicked() {
     	var all=true;
        $("#select-checkbox input[type='checkbox']").each(function() {
            all = $(this).is(":checked");
             if (!all){
            	 $("#select-all-checkbox").attr("checked", false);
            	 return false;
             }            	 
        });
        if(all){
        	$("#select-all-checkbox").attr("checked", true);
        }
    }
   
    /**
     * Forward to Add Leg Screen
     */
    function addLeg(){
    	var productType = $('#productType').val();
    	
    	if(productType == ""){
    			$("#productTypefailedBar").show();
        	}else {
        		$('input[id="addLegButtonID"]').attr('disabled','disabled');
        		$("#productTypefailedBar").hide();
        		var fundingRequestForm = document.getElementById('fundingRequestForm');
    			fundingRequestForm.action =  contextURL+"/frontoffice/fourBlocker.do?command=addLeg&isFrontOffice=Yes&productType="+productType;
    			fundingRequestForm.submit();
        	}
    }
    
    function financialStmt()
    {
    	var isFinancialStatementDateFlag = document.forms[0].elements("fourBlocker.tSummaryOwner.financialStatementFlag");
		if(isFinancialStatementDateFlag[1].checked)
		{
			
			$('#lastDateofFinancialStmtID').val("");
		}
    }
    function priorityComment()
    {
    	 var isPriority = document.forms[0].elements("fourBlocker.tPriorityTimings.priority");
    	 var textpriorityComment = document.forms[0].elements("textpriorityComment");
		  if(isPriority[0].checked)
		  {
			  document.forms[0].elements("fourBlocker.tPriorityTimings.priorityComments").value=textpriorityComment[0].value;
		  } 
		  else if(isPriority[1].checked)
		  {
			  document.forms[0].elements("fourBlocker.tPriorityTimings.priorityComments").value=textpriorityComment[1].value;
		  }
		  else if(isPriority[2].checked)
		  {
			  document.forms[0].elements("fourBlocker.tPriorityTimings.priorityComments").value=textpriorityComment[2].value;
		  }
		  
		  textpriorityComment[0].value="";
		  textpriorityComment[1].value="";
		  textpriorityComment[2].value="";
    }
    
    function populatePriorityData()
    {
    	
    	  var isPriority = document.forms[0].elements("fourBlocker.tPriorityTimings.priority");
    	  var originalComment = $("#priorityCommentID").val();
    	  var priorityCommentLen = originalComment.length;
    	  priorityCommentLen = 500-priorityCommentLen;
    	  var textpriorityComment = document.forms[0].elements("textpriorityComment");    	  
    	  if(isPriority[0].checked)
    	  {
    		   $("#firstCommentID").val(originalComment);
    		   $("#priorityCommentHighID").show();
    		   $("#priorityCommentMediumID").hide();
    		   $("#priorityCommentLowID").hide();
    		   changeInnerSize(textpriorityComment[0]);
    	  } 
    	  else if(isPriority[1].checked)
    	  {
    		  $("#secondCommentID").val(originalComment);
    		  $("#priorityCommentHighID").hide();
   		      $("#priorityCommentMediumID").show();
   		      $("#priorityCommentLowID").hide();
   		      changeInnerSize(textpriorityComment[1]);
    	  }
    	  else if(isPriority[2].checked)
    	  {
    		  $("#thirdCommentID").val(originalComment);
    		  $("#priorityCommentHighID").hide();
   		      $("#priorityCommentMediumID").hide();
   		      $("#priorityCommentLowID").show();
   		      changeInnerSize(textpriorityComment[2]);
    	  }
    }

    function assignMember(){
    	var teamMemberId = $('#teamMemberId').val();
    	document.forms[0].action = contextURL + '/frontoffice/fourBlocker.do?command=submitDeal&action=assignReview&teamMemberId='+teamMemberId;
		document.forms[0].submit();
    }